function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) === ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) === 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function isLogin() {
    if(getCookie("user_id") === "") {
        alert("请登录");
        location.replace("loginpage.html")
    }
}

function isPlanner() {
    if(getCookie("user_planner_authority") === "false") {
        alert("你没有权限查询此页面");
        location.replace("index.html");
    }
}

function isPurchaser() {
    if(getCookie("user_purchaser_authority") === "false") {
        alert("你没有权限查询此页面");
        location.replace("index.html");
    }
}

function isInventory() {
    if(getCookie("user_inventory_authority") === "false") {
        alert("你没有权限查询此页面");
        location.replace("index.html");
    }
}