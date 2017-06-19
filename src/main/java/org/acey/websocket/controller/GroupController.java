package org.acey.websocket.controller;

import org.acey.websocket.entity.Group;
import org.acey.websocket.entity.Message;
import org.acey.websocket.entity.User;
import org.acey.websocket.service.IGroupService;
import org.acey.websocket.util.Contant;
import org.acey.websocket.websocket.MyWebSocketHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("/msg")
public class GroupController {

    private Message message;
    @Resource
    private MyWebSocketHandler handler;
    @Resource
    private IGroupService groupService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView doLogin(String name, HttpServletRequest request) {
        User user = new User(UUID.randomUUID().toString().replace('-', '\0'), name, "", null);
        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("groups", MyWebSocketHandler.GROUP);

        return new ModelAndView("iframe");
    }

    @RequestMapping(value = "group", method = RequestMethod.GET)
    public ModelAndView group() {
        return new ModelAndView("group");
    }

    @RequestMapping(value = "startGame")
    public ModelAndView startGame(HttpSession session) {
        User user = (User) session.getAttribute("user");
        session.setAttribute("group", MyWebSocketHandler.GROUP.get(user.getGroupId()));

        return new ModelAndView("game");
    }

    @RequestMapping("createGroup")
    public String createGroup(HttpSession session) {
        try {
            User user = (User) session.getAttribute("user");

            Group group = groupService.create(user);
            MyWebSocketHandler.GROUP.put(group.getGroupId(), group);
            session.setAttribute("groups", MyWebSocketHandler.GROUP);

            Message<Group> message = new Message<Group>(Contant.OPER_CREATE, group);
            handler.sendGroupMember(message, user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "group";
    }

    @RequestMapping("deleteGroup")
    public String deleteGroup(HttpSession session) {
        try {
            User user = (User) session.getAttribute("user");

            String groupId = groupService.delete(user);

            Message<String> message = new Message<String>(Contant.OPER_DELETE, groupId);
            handler.sendGroupMember(message, user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "group";
    }

    @RequestMapping("joinGroup")
    public String addGroup(final HttpSession session, String id) {
        try {
            User user = (User) session.getAttribute("user");
            user.setGroupId(id);
            MyWebSocketHandler.GROUP.get(id).setLastUser(user);
            session.setAttribute("group", MyWebSocketHandler.GROUP.get(id));

            Message<String> message = new Message<String>(Contant.OPER_JOIN, "");
            handler.sendGroupMember(message, user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "game";
    }


}