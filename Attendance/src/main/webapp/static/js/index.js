/**
 * 登录界面的js
 * @returns
 */
//重置文本框
function reset() {
	var username = document.getElementById('username');
	var password = document.getElementById('password');
	var code = document.getElementById('code');
	username.value = '';
	password.value = '';
	code.value = '';
}
// 根据radio选中要跳转 的界面
function check() {
	var username = document.getElementById('username');
	if (username.value == '') {
		alert("用户名不能为空");
	} else {
		if (document.loginform.act[0].checked == true)
			document.loginform.action = "/Attendance/stu";
		if (document.loginform.act[1].checked == true)
			document.loginform.action = "/Attendance/teacher";
		if (document.loginform.act[2].checked == true)
			document.loginform.action = "/Attendance/admin";
	}
}

// 登录名获得焦点
window.onload = function() {
	document.getElementById('username').focus();
}