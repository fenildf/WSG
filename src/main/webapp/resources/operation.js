function createGroup(data) {
    let innerHtml = `
    <div class='groupStyle groupId${data.groupId}'>
                        <p>groupName："test"
                                    <a href='/msg/joinGroup?id=${data.groupId}'  style='font-size: 12px;color: red'>加入分组</a>
                        </p>
                        <hr/>
                        groupNumber:
                        <ul class='groupNumber${data.groupId}'>
                            <li>${data.firstUserName}</li>
                        </ul>
                    </div>
    `;
    $(".groupCon").append(innerHtml);
}

function deleteGroup(data) {
    $(".groupId" + data).remove();
}

function joinGroup() {
    location.href = "/msg/startGame"
}