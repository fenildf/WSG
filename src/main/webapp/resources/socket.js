let websocket;
let path = "localhost:8080";

if ('WebSocket' in window) {
    websocket = new WebSocket("ws://" + path + "/ws");
} else if ('MozWebSocket' in window) {
    websocket = new MozWebSocket("ws://" + path + "/ws");
} else {
    websocket = new SockJS("http://" + path + "/ws/sockjs");
}


websocket.onopen = function (event) {
    console.log("WebSocket:已连接");
    console.log(event);
};

websocket.onmessage = function (event) {
    let data = JSON.parse(event.data);
    console.log("WebSocket:收到一条消息", data);

    if (data.operation === "create") groupFrame.window.createGroup(data.data);

    if (data.operation === "delete") groupFrame.window.deleteGroup(data.data);

    if (data.operation === "join") groupFrame.window.joinGroup();

    if (data.operation === "update");


};

websocket.onerror = function (event) {
    console.log("WebSocket:发生错误 ");
    console.log(event);
};

websocket.onclose = function (event) {
    console.log("WebSocket:已关闭");
    console.log(event);
}



function getSocket() {
    return websocket
}