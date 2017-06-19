document.onkeydown = function (e) {
    let isIe = (document.all) ? true : false;
    let key;
    if (isIe) {
        key = window.event.keyCode;
    } else {
        key = String.fromCharCode(e.which);
    }
    if (key === 'W') {
    }
};