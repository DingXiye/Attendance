<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("basePath", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生页面</title>
<!-- 引入jqury -->
<script type="text/javascript"
	src="/Attendance/static/js/jquery-3.2.1.min.js"></script>
<!-- 引入bootstrap -->
<link
	href="/Attendance/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/Attendance/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<style type="text/css">
ul li {
	float: left;
	list-style-type: none;
}
body{
	background:url(./static/img/bgpic1.jpg) no-repeat;
	background-size: 70%;
	background-repeat: no-repeat;
}
</style>
</head>
<body>

	<!-- 学生修改密码模块框 -->
	<!-- Modal -->
	<div class="modal fade" id="stuEditpModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form class="form-horizontal">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">修改密码</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-2 control-label">旧密码</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="old_input">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">新密码</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="new_input">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">确认新密码</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="confirm_input">
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" onclick="confirm()">确定</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row" style="color:white;background:#bfd061;">
			<div class="col-md-8">
				<h1>考勤管理系统</h1>
			</div>
			<div class="col-md-4" style="margin-top: 5px">
				<ul>
					<li>
						<h4 style="margin-top: -1px">
							欢迎<font color="red">${stu.stuClassname} ${stu.stuName}</font>同学登录
						</h4>
					</li>
					<li><a href="/Attendance/index.jsp"><h4
								style="margin-top: -1px">
								<font color="red">退出</font>
							</h4></a></li>
				</ul>
			</div>
		</div>
		<!-- 修改密码 -->
		<div class="col-md-4" style="margin-top: 5px">
			<button type="button" class="btn btn-primary" id="edit_password">修改密码</button>
		</div>

		<!-- 查询自己的信息 -->
		<div class="col-md-4" style="margin-top: 5px">
			<button type="button" class="btn btn-primary" onclick="select(1)">缺勤信息</button>
		</div>

		<!-- 显示学生表格数据 -->
		<div class="row" style="margin-top: 10px">
			<div class=col-md-12>
				<table class="table table-hover" id="stus_table">
					<thead>
						<tr>
							<th>学号</th>
							<th>周次</th>
							<th>星期</th>
							<th>课程名</th>
							<th>状态</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
		<!-- 显示分页信息栏 -->
		<div class="row" style="margin-top: 10px">
			<!-- 分页文字信息 -->
			<div id="page_info_area" class="col-md-6"></div>

			<!-- 分页条信息 -->
			<div id="page_nav_area" class="col-md-6"></div>
		</div>

	</div>
</body>

<script type="text/javascript">
	var currentPage, totalRecord;
	//修改密码
	$("#edit_password").click(function() {
		$('#stuEditpModal').modal('show');
	})
	//修改密码
	function confirm() {
		var old = $("#old_input").val();
		var newinput = $("#new_input").val();
		var confirm = $("#confirm_input").val();
		if (newinput != confirm) {
			alert("两次输入的不相同，请重新输入");
			$("#new_input").val("");
			$("#confirm_input").val("");
		} else {
			var data = new FormData();
			data.append("old", old);
			data.append("new", newinput);
			$.ajax({
				url : "${basePath}/update",
				type : 'POST',
				cache : false,
				data : data,
				processData : false,
				contentType : false,
				success : function(result) {
					console.log(result);
					if (result.code == 100) {
						$('#stuEditpModal').modal('hide');
						alert("修改成功");
						window.location = 'index.jsp';
					} else {
						alert(result.extend.error);
						$("#old_input").val("");
					}
				}
			})
		}
	}
	//构建表格
	function build_table(result) {
		//清空数据
		console.log(result);
		$("#stus_table tbody").empty();
		var stus = result.extend.pageinfo.list;
		$.each(stus, function(index, item) {
			var stuIdTd = $("<td></td>").append(item.stuinfoId);
			var stuWeekTd = $("<td></td>").append(item.stuWeek);
			var stuWeekdayTd = $("<td></td>").append(item.stuWeekday);
			var stuCoursenameTd = $("<td></td>").append(item.stuCoursename);
			var stuAttendanceTd = $("<td></td>").addClass("danger").append(
					item.stuAttendance);

			$("<tr></tr>").append(stuIdTd).append(stuWeekTd).append(
					stuWeekdayTd).append(stuCoursenameTd).append(
					stuAttendanceTd).appendTo("#stus_table tbody");//放入表格id为emps_table的tbody中

		});
	}

	//显示分页信息
	function build_info(result) {
		//清空数据
		$("#page_info_area").empty();
		$("#page_info_area").append(
				"当前 " + result.extend.pageinfo.pageNum + " 页，总 "
						+ result.extend.pageinfo.pages + " 页，总 "
						+ result.extend.pageinfo.total + " 条记录");
		totalRecord = result.extend.pageinfo.total;//总记录数
		currentPage = result.extend.pageinfo.pageNum;
	}

	//显示查询结果的导航条
	function bulid_select_nav(result) {
		//清空数据
		console.log(result);
		$("#page_nav_area").empty();
		var ul = $("<ul></ul>").addClass("pagination");
		var firstPageLi = $("<li></li>").append(
				$("<a></a>").append("首页").attr("href", "#"));//构建首页
		var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
		if (result.extend.pageinfo.hasPreviousPage == false) {
			firstPageLi.addClass("disabled");
			prePageLi.addClass("disabled");
		} else {
			//添加首页、前一页的点击
			firstPageLi.click(function() {
				select(1);
			});

			prePageLi.click(function() {
				select(result.extend.pageinfo.pageNum - 1);
			});
		}

		var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
		var lastPageLi = $("<li></li>").append(
				$("<a></a>").append("末页").attr("href", "#"));

		if (result.extend.pageinfo.hasNextPage == false) {
			nextPageLi.addClass("disabled");
			lastPageLi.addClass("disabled");
		} else {
			//添加末页、下一页的点击
			nextPageLi.click(function() {
				select(result.extend.pageinfo.pageNum + 1);
			});

			lastPageLi.click(function() {
				select(result.extend.pageinfo.pages);
			});
		}

		//添加首页和尾页的提示
		ul.append(firstPageLi).append(prePageLi);

		$.each(result.extend.pageinfo.navigatepageNums, function(index, item) {
			var numLi = $("<li></li>").append($("<a></a>").append(item));
			if (result.extend.pageinfo.pageNum == item) {
				numLi.addClass("active");
			}

			numLi.click(function() {
				select(item);
			});

			ul.append(numLi);
		});
		ul.append(nextPageLi).append(lastPageLi);

		var navEle = $("<nav></nav>").append(ul);
		navEle.appendTo("#page_nav_area");//先将所有li标签全都加入到ul中，然后将ul标签加入到navEle中，最后加入到page_nav_area中
	}

	//结果集
	function select(pn) {
		$.ajax({
			url : "${basePath}/lack/" + pn,
			type : "GET",
			success : function(result) {
				//console.log(result);
				build_table(result);//解析数据，显示数据
				build_info(result);//显示分页信息
				bulid_select_nav(result);//查询之后的导航条
				if(result.extend.pageinfo.total!=0){
					alert(result.extend.count);
				}
			}
		})
	}
</script>
</html>