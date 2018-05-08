<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.dy.bean.Admin"%>

<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%
	pageContext.setAttribute("basePath", request.getContextPath());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员页面</title>
<!-- 引入jqury -->
<script type="text/javascript"
	src="${basePath}/static/js/jquery-3.2.1.min.js"></script>
<!-- 引入bootstrap -->
<link
	href="${basePath }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="${basePath }/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<style type="text/css">
ul li {
	float: left;
	list-style-type: none;
}

body {
	background: url(./static/img/bgpic1.jpg) no-repeat;
	background-size: 70% 0%;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<OBJECT classid="clsid:A318A9AC-E75F-424C-9364-6B40A848FC6B" width=2
		height=2 id=zkonline> </OBJECT>

	<COMMENT> <EMBED type="application/x-eskerplus"
		classid="clsid:A318A9AC-E75F-424C-9364-6B40A848FC6B"
		codebase="ZKOnline.ocx" width=2 height=2>
	</EMBED> </COMMENT>

	<!-- 学生导入模块框 -->
	<!-- Modal -->
	<div class="modal fade" id="stuImportModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form enctype="multipart/form-data" id="uploadform">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">请选择Execl文件</h4>
					</div>
					<div class="modal-body">
						<input type="file" id="filename" name="filename"
							class="file-loading" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary"
							onclick="importxls()">导入</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 老师导入模块框 -->
	<!-- Modal -->
	<div class="modal fade" id="teaImportModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form enctype="multipart/form-data" id="uploadteaform">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">请选择Execl文件</h4>
					</div>
					<div class="modal-body">
						<input type="file" id="filename" name="filename"
							class="file-loading" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary"
							onclick="importteaxls()">导入</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 学生查询模块框 -->
	<!-- Modal -->
	<div class="modal fade" id="stuSelectModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">查询方式</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">学生学号</label>
							<div class="col-sm-4">
								<input type="text" name="stuId" class="form-control"
									id="stuId_select_input" placeholder="s1001">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">班级名称</label>
							<div class="col-sm-4">
								<select id="select_select" class="form-control"
									name="stuClassname">
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="select(1)">查询</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 老师查询模块框 -->
	<!-- Modal -->
	<div class="modal fade" id="teaSelectModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">查询方式</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">工号</label>
							<div class="col-sm-4">
								<input type="text" name="tecId" class="form-control"
									placeholder="1000">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">课程名称</label>
							<div class="col-sm-4">
								<select id="select_tea_select" class="form-control"
									name="coursename">
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						onclick="select_teacher(1)">查询</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 学生添加模块框 -->
	<!-- Modal -->
	<div class="modal fade" id="stuAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">学生基本信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">学号</label>
							<div class="col-sm-4">
								<input type="text" name="stuId" class="form-control"
									id="stuId_Add_input" placeholder="学生学号"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-4">
								<input type="text" name="stuName" class="form-control"
									id="stuName_Add_input" placeholder="学生姓名"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">班级名</label>
							<div class="col-sm-4">
								<select id="add_select" class="form-control" name="stuClassname">
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="stu_save_btn">保存</button>
				</div>
			</div>
		</div>
	</div>

	<!--老师添加模块框 -->
	<!-- Modal -->
	<div class="modal fade" id="teaAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">老师基本信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">工号</label>
							<div class="col-sm-4">
								<input type="text" name="tecId" class="form-control"
									placeholder="工号"> <span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-4">
								<input type="text" name="tecName" class="form-control"
									placeholder="老师姓名"> <span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">班级名</label>
							<div class="col-sm-4">
								<select id="add_class_select" class="form-control"
									name="classname">
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">课程名</label>
							<div class="col-sm-4">
								<select id="add_course_select" class="form-control"
									name="coursename">
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="tea_save_btn">保存</button>
				</div>
			</div>
		</div>
	</div>


	<!-- 学生编辑模块框 -->
	<!-- Modal -->
	<div class="modal fade" id="stuUpdateModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">学生信息编辑</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">学号</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="stuId_update_static"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-4">
								<input type="text" name="stuName" class="form-control"
									id="stuName_update_input" placeholder="学生姓名"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">班级名</label>
							<div class="col-sm-4">
								<select id="update_stu_select" class="form-control"
									name="stuClassname">
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="stu_edit_btn">保存</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 老师编辑模块框 -->
	<!-- Modal -->
	<div class="modal fade" id="teaUpdateModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">老师信息编辑</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">工号</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="teaId_update_static"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-4">
								<input type="text" name="tecName" class="form-control"
									id="tea_name_input" placeholder="老师姓名"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">班级名</label>
							<div class="col-sm-4">
								<select id="update_class_select" class="form-control"
									name="classname">
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">课程名</label>
							<div class="col-sm-4">
								<select id="update_teacourse_select" class="form-control"
									name="coursename">
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="tea_edit_btn">保存</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row" style="color: white; background: #bfd061;">
			<nav class=" navbar-inverse">
			<div class="col-md-8">
				<p class="navbar-text navbar-inverse">
				<h1>考勤管理系统</h1>
				</p>
			</div>
			<div class="col-md-4 " style="margin-top: 5px">
				<ul>
					<li><select id="test" style="color: black;">
							<option class="select" value="1" selected="selected">学生</option>
							<option class="select" value="2">老师</option>
					</select></li>
					<li>
						<h4 style="margin-top: -1px">
							欢迎<font color="red">${admin.adminName}</font>管理员登录
						</h4>
					</li>
					<li><a href="/Attendance/index.jsp"><h4
								style="margin-top: -1px">
								<font color="red">退出</font>
							</h4></a></li>
				</ul>
			</div>
			</nav>
		</div>
		<!-- 按钮 -->
		<div class="row" style="margin-top: 10px">
			<div id="selected" class="col-md-8">
				<h3 class="ss">学生管理</h3>
			</div>
			<div class="col-md-4">
				<button type="button" class="btn btn-primary btn-sm"
					id="admin_select_modal_btn">查询</button>
				<button type="button" class="btn btn-primary btn-sm"
					id="admin_import_modal_btn">导入</button>
				<button type="button" class="btn btn-primary btn-sm"
					id="admin_add_modal_btn">新增</button>
				<button type="button" class="btn btn-danger btn-sm"
					id="admin_delete_all_btn">删除</button>
				<button type="button" class="btn btn-danger btn-sm"
					id="admin_export_all_btn">导出</button>
			</div>
		</div>
		<!-- 显示学生表格数据 -->
		<div class="row">
			<div class=col-md-12>
				<table class="table table-bordered table-hover" id="stus_table">
					<thead>
						<tr>
							<th><input type="checkbox" id="check_all" /></th>
							<th>学号</th>
							<th>姓名</th>
							<th>班级</th>
							<th>注册时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>

		<!-- 显示老师表格数据 -->
		<div class="row">
			<div class=col-md-12>
				<table class="table table-bordered table-hover" id="tea_table">
					<thead>
						<tr>
							<th><input type="checkbox" id="check_tall" /></th>
							<th>工号</th>
							<th>姓名</th>
							<th>班级</th>
							<th>课程名</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>

		<!-- 显示分页信息栏 -->
		<div class="row">
			<!-- 分页文字信息 -->
			<div id="page_info_area" class="col-md-6"></div>

			<!-- 分页条信息 -->
			<div id="page_nav_area" class="col-md-6"></div>
		</div>
	</div>
	<script type="text/javascript">
		var totalRecord, currentPage;
		//select中值变化事件
		$("#test").on("change", function() {
			if ($("option:selected", this).val() == 1) {
				$(".row #selected .ss").html("学生管理");
				document.getElementById("stus_table").style.display = "";
				document.getElementById("tea_table").style.display = "none";
				to_pagestu(1);//显示学生页面
			} else {
				$(".row #selected .ss").html("老师管理");
				$("#page_info_area").empty();
				$("#page_info_area").empty();
				$("#page_nav_area").empty();
				document.getElementById("stus_table").style.display = "none";
				document.getElementById("tea_table").style.display = "";
				to_pagetea(1);//显示老师界面
			}
		});

		//页面加载完成后执行
		$(function() {
			document.getElementById("tea_table").style.display = "none";
			to_pagestu(1);//显示学生页面
		})

		//获取学生所有数据
		function to_pagestu(pn) {
			$.ajax({
				url : "${basePath}/stu",
				data : "pn=" + pn,
				type : "GET",
				success : function(result) {
					console.log(result);
					build_table(result);//解析数据，显示数据
					build_info(result);//显示分页信息
					bulid_nav(result);//添加分页条
				}
			})
		}

		//显示学生信息
		function build_table(result) {
			//清空数据
			$("#stus_table tbody").empty();
			var stus = result.extend.pageinfo.list;
			$
					.each(
							stus,
							function(index, item) {
								var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
								var stuIdTd = $("<td></td>").append(item.stuId);
								var stuNameTd = $("<td></td>").append(
										item.stuName);
								var classNameTd = $("<td></td>").append(
										item.stuClassname);
								var stuRegisterdateTd = $("<td></td>").append(
										item.stuRegisterdate);

								var editBtn = $("<button></button>").addClass(
										"btn btn-primary btn-sm edit_btn")
										.append($("<span></span>")).addClass(
												"glyphicon glyphicon-pencil")
										.append("编辑");
								editBtn.attr("edit-id", item.stuId);//为编辑按钮添加一个属性值
								var delBtn = $("<button></button>").addClass(
										"btn btn-danger btn-sm delete_btn")
										.append($("<span></span>")).addClass(
												"glyphicon glyphicon-trash")
										.append("删除");
								delBtn.attr("del-id", item.stuId);//为删除按钮添加一个属性
								//将两个按钮编程一个单元格中
								var regBtn = $("<button></button>").addClass(
										"btn btn-primary btn-sm reg_btn")
										.append($("<span></span>")).addClass(
												"glyphicon glyphicon-edit")
										.append("指纹注册");
								regBtn.attr("reg-id", item.stuId);//为删除按钮添加一个属性
								//alert(item.stuFingerprint);
								if(item.stuFingerprint!=""&&item.stuFingerprint!=null){
									var alertTb=$("<laber></laber>").addClass("alert alert-info").append("已采集");
								}else{
									var alertTb=$("<laber></laber>").addClass("alert alert-danger").append("未采集");
								}
								var btnTd = $("<td></td>").append(editBtn)
										.append(" ").append(delBtn).append(" ")
										.append(regBtn).append(" ").append(alertTb);
								//<div class="alert alert-danger" role="alert">...</div>
								$("<tr></tr>").append(checkBoxTd).append(
										stuIdTd).append(stuNameTd).append(
										classNameTd).append(stuRegisterdateTd)
										.append(btnTd).appendTo(
												"#stus_table tbody");//放入表格id为emps_table的tbody中

							});
		}

		//显示老师信息
		function build_teacher_table(result) {
			//清空数据
			$("#tea_table tbody").empty();
			console.log(result);
			var teas = result.extend.pageinfo.list;
			$
					.each(
							teas,
							function(index, item) {
								var checkBoxTd = $("<td><input type='checkbox' class='check_titem'/></td>");
								checkBoxTd.attr("checkbox_id", item.id);//为批量删除老师添加一个属性值
								var teaIdTd = $("<td></td>").append(item.tecId);
								var teaNameTd = $("<td></td>").append(
										item.tecName);
								var classNameTd = $("<td></td>").append(
										item.classname);
								var courseNameTd = $("<td></td>").append(
										item.coursename);
								var editBtn = $("<button></button>").addClass(
										"btn btn-primary btn-sm edit_tbtn")
										.append($("<span></span>")).addClass(
												"glyphicon glyphicon-pencil")
										.append("编辑");
								editBtn.attr("edit-tid", item.id);//为编辑按钮添加一个属性值
								var delBtn = $("<button></button>").addClass(
										"btn btn-danger btn-sm delete_tbtn")
										.append($("<span></span>")).addClass(
												"glyphicon glyphicon-trash")
										.append("删除");
								delBtn.attr("del-tid", item.id);//为删除按钮添加一个属性
								//将两个按钮编程一个单元格中
								var btnTd = $("<td></td>").append(editBtn)
										.append(" ").append(delBtn);

								$("<tr></tr>").append(checkBoxTd).append(
										teaIdTd).append(teaNameTd).append(
										classNameTd).append(courseNameTd)
										.append(btnTd).appendTo(
												"#tea_table tbody");//放入表格id为emps_table的tbody中

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

		//显示全部学生信息的导航条
		function bulid_nav(result) {
			//清空数据
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			var firstPageLi = $("<li></li>").append(
					$("<a></a>").append("首页").attr("href", "#"));//构建首页
			var prePageLi = $("<li></li>").append($("<a></a>").append("上一页"));
			if (result.extend.pageinfo.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				//添加首页、前一页的点击
				firstPageLi.click(function() {
					to_pagestu(1);
				});

				prePageLi.click(function() {
					to_pagestu(result.extend.pageinfo.pageNum - 1);
				});
			}

			var nextPageLi = $("<li></li>").append($("<a></a>").append("下一页"));
			var lastPageLi = $("<li></li>").append(
					$("<a></a>").append("末页").attr("href", "#"));

			if (result.extend.pageinfo.hasNextPage == false) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				//添加末页、下一页的点击
				nextPageLi.click(function() {
					to_pagestu(result.extend.pageinfo.pageNum + 1);
				});

				lastPageLi.click(function() {
					to_pagestu(result.extend.pageinfo.pages);
				});
			}

			//添加首页和尾页的提示
			ul.append(firstPageLi).append(prePageLi);

			$.each(result.extend.pageinfo.navigatepageNums, function(index,
					item) {
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.pageinfo.pageNum == item) {
					numLi.addClass("active");
				}

				numLi.click(function() {
					to_pagestu(item);
				});

				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);

			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");//先将所有li标签全都加入到ul中，然后将ul标签加入到navEle中，最后加入到page_nav_area中
		}

		//显示全部老师信息的导航条
		function bulid_teacher_nav(result) {
			//清空数据
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			var firstPageLi = $("<li></li>").append(
					$("<a></a>").append("首页").attr("href", "#"));//构建首页
			var prePageLi = $("<li></li>").append($("<a></a>").append("上一页"));
			if (result.extend.pageinfo.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				//添加首页、前一页的点击
				firstPageLi.click(function() {
					to_pagetea(1);
				});

				prePageLi.click(function() {
					to_pagetea(result.extend.pageinfo.pageNum - 1);
				});
			}

			var nextPageLi = $("<li></li>").append($("<a></a>").append("下一页"));
			var lastPageLi = $("<li></li>").append(
					$("<a></a>").append("末页").attr("href", "#"));

			if (result.extend.pageinfo.hasNextPage == false) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				//添加末页、下一页的点击
				nextPageLi.click(function() {
					to_pagetea(result.extend.pageinfo.pageNum + 1);
				});

				lastPageLi.click(function() {
					to_pagetea(result.extend.pageinfo.pages);
				});
			}

			//添加首页和尾页的提示
			ul.append(firstPageLi).append(prePageLi);

			$.each(result.extend.pageinfo.navigatepageNums, function(index,
					item) {
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.pageinfo.pageNum == item) {
					numLi.addClass("active");
				}

				numLi.click(function() {
					to_pagetea(item);
				});

				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);

			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");//先将所有li标签全都加入到ul中，然后将ul标签加入到navEle中，最后加入到page_nav_area中
		}

		//显示查询结果的导航条
		function bulid_select_nav(result) {
			//清空数据
			console.log(result);
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			var firstPageLi = $("<li></li>").append(
					$("<a></a>").append("首页").attr("href", "#"));//构建首页
			var prePageLi = $("<li></li>").append($("<a></a>").append("上一页"));
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

			var nextPageLi = $("<li></li>").append($("<a></a>").append("下一页"));
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

			$.each(result.extend.pageinfo.navigatepageNums, function(index,
					item) {
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

		//表单的完整重置
		function reset_form(ele) {
			$(ele)[0].reset();
			$(ele).find("*").removeClass("has-error");
			$(ele).find(".help-block").text("");
		}

		//导入按钮
		$("#admin_import_modal_btn").click(function() {
			if ($("option:selected", this).val() == 1) {
				$('#stuImportModal').modal('show');
			} else {
				$('#teaImportModal').modal('show');
			}
		})
		//导入学生xls文件
		function importxls() {
			var file = new FormData($("#uploadform")[0]);
			$.ajax({
				url : "${basePath}/import",
				type : "POST",
				data : file,
				async : false,
				cache : false,
				contentType : false, //不设置内容类型  
				processData : false, //不处理数据  
				success : function(result) {
					console.log(result);
					if (result.code == 100) {
						$('#stuImportModal').modal('hide');
						to_pagestu(1);
					} else {
						alert(result.extend.errorfilname);
					}
				}
			})
		}

		//导入老师xls文件
		function importteaxls() {
			var file = new FormData($("#uploadteaform")[0]);
			$.ajax({
				url : "${basePath}/importtea",
				type : "POST",
				data : file,
				async : false,
				cache : false,
				contentType : false, //不设置内容类型  
				processData : false, //不处理数据  
				success : function(result) {
					console.log(result);
					if (result.code == 100) {
						$('#teaImportModal').modal('hide');
						to_pagetea(1);
					} else {
						alert(result.extend.errorfilname);
					}
				}
			})
		}
		//查询按钮
		$("#admin_select_modal_btn").click(function() {
			/* alert($("#test option:selected").val()); */
			if ($("#test option:selected").val() == 1) {
				getClassname("#select_select");
				$('#stuSelectModal input').val("");
				$('#stuSelectModal').modal('show');
			} else {
				getCourse("#select_tea_select");
				$('#teaSelectModal input').val("");
				$('#teaSelectModal').modal('show');
			}

		})

		//获得所有班级名
		function getClassname(ele) {
			$("#stuSelectModal select").empty();
			$("#stuAddModal select").empty();
			$("#stuUpdateModal select").empty();
			$.ajax({
				url : "${basePath}/getclass",
				type : "GET",
				success : function(result) {
					console.log(result);
					var optionEl = $("<option name='stuClassname'></option>")
							.append("");
					optionEl.appendTo(ele);
					$.each(result.extend.classes, function() {
						optionEl = $("<option name='stuClassname'></option>")
								.append(this.classname);
						optionEl.appendTo(ele);
					})
				}
			})
		}

		//获得所有课程名
		function getCourse(ele) {
			$("#teaSelectModal select").empty();
			$("#teaAddModal select").empty();
			$("#teaUpdateModal select").empty();
			$.ajax({
				url : "${basePath}/getcourse",
				type : "GET",
				success : function(result) {
					console.log(result);
					var optionEl = $("<option name='coursename'></option>")
							.append("");
					optionEl.appendTo(ele);
					$.each(result.extend.couses, function() {
						optionEl = $("<option name='coursename'></option>")
								.append(this.coursename);
						optionEl.appendTo(ele);
					})
				}
			})
		}

		//学生查询,pn是查询第几页，因为使用了分页查询
		function select(pn) {
			$.ajax({
				url : "${basePath}/select/" + pn,
				data : $("#stuSelectModal form").serialize(),
				type : "GET",
				success : function(result) {
					if (result.code == 100) {
						if (result.extend.pageinfo.total == 0) {
							alert("查询结果为空，请检查条件");
						} else {
							$('#stuSelectModal').modal('hide');
							build_table(result);//解析数据，显示数据
							build_info(result);//显示分页信息
							bulid_select_nav(result);//查询之后的导航条
						}
					} else {
						alert(result.extend.error);
					}
				}
			})
		}

		//新增按钮
		$("#admin_add_modal_btn").click(function() {
			if ($("#test option:selected").val() == 1) {
				getClassname("#add_select");
				$('#stuAddModal').modal('show');
			} else {
				getClassname("#add_class_select");
				getCourse("#add_course_select");
				$('#teaAddModal').modal('show');
			}
		})

		//学生新增下的保存按钮。先进行前端校验，然后是ajax后端校验，最后是jsr303校验
		$("#stu_save_btn")
				.click(
						function() {
							if (!validate_add_form()) {//前端校验格式是否正确
								return false;
							}
							if ($(this).attr("ajax-va") == "error") {//后端验证是否重名
								return false;
							}
							$
									.ajax({
										url : "${basePath}/stuadd",
										type : "POST",
										data : $("#stuAddModal form")
												.serialize(),//将表单中的输入序列化为字符串
										success : function(result) {
											if (result.code == 100) {
												$("#stuAddModal").modal('hide');
												alert("添加成功");
												to_pagestu(totalRecord);
											} else {
												if (undefined != result.extend.errorFields.stuId) {
													console.log(result);
													show_validate_msg(
															"#stuId_Add_input",
															"error",
															result.extend.errorFields.stuId);
												}
											}
										}
									})
						})

		//老师新增下的保存按钮,无需验证
		$("#tea_save_btn").click(function() {
			$.ajax({
				url : "${basePath}/teaadd",
				type : "POST",
				data : $("#teaAddModal form").serialize(),//将表单中的输入序列化为字符串
				success : function(result) {
					$("#teaAddModal").modal('hide');
					to_pagetea(totalRecord);
					alert(result.msg);
				}
			})
		})

		//前端校验格式，可以不用写，因为可能会跳过前端验证，所以必须要写后端校验以及jsr验证
		function validate_add_form() {
			//拿到要校验的数据，使用正则表达式
			var stuId = $("#stuId_Add_input").val();//获取输入值
			var regId = /(s\d{4})/;//正则表达式
			if (!regId.test(stuId)) {
				show_validate_msg("#stuId_Add_input", "error", "学号必须是s加4个数字");
				return false;
			} else {
				show_validate_msg("#stuId_Add_input", "success", "");
			}
			return true;
		}

		//校验提示信息
		function show_validate_msg(ele, status, msg) {
			//先清除之前的状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if ("success" == status) {
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			} else if ("error" == status) {
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}

		//当id文本框发生改变时和数据库查重,后端验证
		$("#stuId_Add_input").change(
				function() {
					var stuId = this.value;
					$.ajax({
						url : "${basePath}/checkstu",
						data : "stuId=" + stuId,
						type : "POST",
						success : function(result) {
							if (result.code == 100) {
								show_validate_msg("#stuId_Add_input",
										"success", "用户名可用");
								$("#stu_save_btn").attr("ajax-va", "success");
							} else {
								show_validate_msg("#stuId_Add_input", "error",
										result.extend.rex_msg);
								$("#stu_save_btn").attr("ajax-va", "error");
							}
						}
					});
				});
		//因为js文件时加载时运行，问这个按钮是返回的jackson文件，运行时还没有这个按钮，所以绑定不了事件
		/* $("#delete_btn").click(function() {
		}) */

		//单个学生的删除
		$(document).on("click", ".delete_btn", function() {
			var stuId = $(this).parents("tr").find("td:eq(1)").text();//按照学号,返回他父元素后，找到第二个单元格
			var stuId = $(this).attr("del-id");//给删除按钮添加一个属性，值为stuId
			if (confirm("确认删除【" + stuId + "】吗?")) {
				//确认，发送 Ajax
				$.ajax({
					url : "${basePath}/stu/" + stuId,
					type : "DELETE",
					success : function(result) {
						alert(result.msg);
						//回到本页
						to_pagestu(currentPage);
					}
				});
			}
		});

		//单个老师的删除
		$(document)
				.on(
						"click",
						".delete_tbtn",
						function() {
							var teaId = $(this).parents("tr").find("td:eq(1)")
									.text();//按照工号,返回他父元素后，找到第二个单元格
							var teaName = $(this).parents("tr")
									.find("td:eq(2)").text();
							var teaClassname = $(this).parents("tr").find(
									"td:eq(3)").text();
							var teaCoursename = $(this).parents("tr").find(
									"td:eq(4)").text();
							var teainfo = teaId + " " + teaName + " "
									+ teaClassname + " " + teaCoursename;
							var Id = $(this).attr("del-tid");//获得按钮的del-id属性值
							if (confirm("确认删除【" + teainfo + "】这条记录吗?")) {
								//确认，发送 Ajax
								$.ajax({
									url : "${basePath}/tea/" + Id,
									type : "DELETE",
									success : function(result) {
										alert(result.msg);
										//回到本页
										to_pagetea(currentPage);
									}
								});
							}
						});

		//学生的单选和多选
		$("#check_all").click(function() {
			$(".check_item").prop("checked", $(this).prop("checked"));//为原生属性赋值用prop
		})

		//当所有复选框都选中时，全选也要跟着变化
		$(document)
				.on(
						"click",
						".check_item",
						function() {
							//选中的是否等于复选框的个数
							var flag = $(".check_item:checked").length == $(".check_item").length;
							$("#check_all").prop("checked", flag);
						});
		//老师表格的单选和多选
		$("#check_tall").click(function() {
			$(".check_titem").prop("checked", $(this).prop("checked"));//为原生属性赋值用prop
		})

		//当所有复选框都选中时，全选也要跟着变化
		$(document)
				.on(
						"click",
						".check_titem",
						function() {
							//选中的是否等于复选框的个数
							var flag = $(".check_titem:checked").length == $(".check_titem").length;
							$("#check_tall").prop("checked", flag);
						});

		//学生的批量删除
		function studelete() {
			var stuNames = "";//拼接出要删除的id和姓名
			var ids = "";
			$.each($(".check_item:checked"),
					function() {
						ids += $(this).parents("tr").find("td:eq(1)").text()
								+ "-";
						stuNames += $(this).parents("tr").find("td:eq(2)")
								.text()
								+ "-";
					})
			ids = ids.substring(0, ids.length - 1);
			stuNames = stuNames.substring(0, stuNames.length - 1);
			if (confirm("确认删除【" + stuNames + "】吗?")) {
				$.ajax({
					url : "${basePath}/stu/" + ids,
					type : "DELETE",
					success : function(result) {
						alert(result.msg);
						to_pagestu(currentPage);
						$("#check_all").prop("checked", false);
					}
				})
			}
		}

		//老师的批量删除
		function teadelete() {
			var ids = "";
			var teainfo = "";
			$.each($(".check_titem:checked"), function() {
				var teaId = $(this).parents("tr").find("td:eq(1)").text();//按照工号,返回他父元素后，找到第二个单元格
				var teaName = $(this).parents("tr").find("td:eq(2)").text();
				var teaClassname = $(this).parents("tr").find("td:eq(3)")
						.text();
				var teaCoursename = $(this).parents("tr").find("td:eq(4)")
						.text();
				teainfo += teaId + " " + teaName + " " + teaClassname + " "
						+ teaCoursename + "\n";
				ids += $(this).parents("tr").find("td:eq(0)").attr(
						"checkbox_id")
						+ "-";//获得按钮的del-id属性值
			})
			ids = ids.substring(0, ids.length - 1);
			if (confirm("确认删除【" + "\n" + teainfo + "】吗?")) {
				$.ajax({
					url : "${basePath}/tea/" + ids,
					type : "DELETE",
					success : function(result) {
						alert(result.msg);
						to_pagetea(currentPage);
						$("#check_tall").prop("checked", false);
					}
				})
			}
		}
		//全部删除
		$("#admin_delete_all_btn").click(function() {
			if ($("#test option:selected").val() == 1) {
				studelete();
			} else {
				teadelete();
			}
		})

		//学生表中编辑按钮
		$(document).on("click", ".edit_btn", function() {
			getClassname("#update_stu_select");
			getStu($(this).attr("edit-id"));//返回学生信息
			$("#stu_edit_btn").attr("edit-id", $(this).attr("edit-id"));
			$("#stuUpdateModal").modal('show');
		})

		//注册指纹
		$(document)
				.on(
						"click",
						".reg_btn",
						function() {
							var url="${basePath}/register.jsp?pid="+$(this).attr("reg-id");
							var newHtml=window.open(url);
							if(!newHtml.closed){
								 parent.location.reload();   
							}
						})

		//根据id返回学生的基本信息
		function getStu(id) {
			$.ajax({
				url : "${basePath}/stu/" + id,
				type : "GET",
				success : function(result) {
					var stuDate = result.extend.stu;
					$("#stuId_update_static").text(stuDate.stuId);//给文本框赋值
					$("#stuName_update_input").val(stuDate.stuName);
					$("#update_stu_select").val(stuDate.stuClassname);
				}
			})
		}

		//老师表中的编辑按钮
		$(document).on("click", ".edit_tbtn", function() {
			getClassname("#update_class_select");
			getCourse("#update_teacourse_select");
			getTeacher($(this).attr("edit-tid"));//返回老师的id主键信息
			$("#tea_edit_btn").attr("edit-tid", $(this).attr("edit-tid"));
			$("#teaUpdateModal").modal('show');
		})

		//根据id返回老师的值
		function getTeacher(id) {
			$.ajax({
				url : "${basePath}/tea/" + id,
				type : "GET",
				success : function(result) {
					var teaDate = result.extend.tea;
					$("#teaId_update_static").text(teaDate.tecId);//给文本框赋值
					$("#tea_name_input").val(teaDate.tecName);
					$("#update_class_select").val(teaDate.classname);
					//alert(teaDate.coursename);
					$("#update_teacourse_select").val(teaDate.coursename);
				}
			})
		}

		//学生编辑下的保存按钮
		$("#stu_edit_btn").click(function() {
			$.ajax({
				url : "${basePath}/stu/" + $(this).attr("edit-id"),
				//方法一.这是使用post加上put发送，会调用web.xml中的第4个配置，过滤post请求
				type : "POST",
				data : $("#stuUpdateModal form").serialize() + "&_method=PUT",
				//方法二.使用put发送
				//type : "PUT",
				//data : $("#stuUpdateModal form").serialize(),
				success : function(result) {
					//alert(result.msg);
					$("#stuUpdateModal").modal("hide");
					to_pagestu(currentPage);
				}
			});
		})

		//老师编辑下的保存按钮
		$("#tea_edit_btn").click(function() {
			$.ajax({
				url : "${basePath}/tea/" + $(this).attr("edit-tid"),
				//方法一.这是使用post加上put发送，会调用web.xml中的第4个配置，过滤post请求
				type : "POST",
				data : $("#teaUpdateModal form").serialize() + "&_method=PUT",
				//方法二.使用put发送
				//type : "PUT",
				//data : $("#stuUpdateModal form").serialize(),
				success : function(result) {
					//alert(result.msg);
					$("#teaUpdateModal").modal("hide");
					to_pagetea(currentPage);
				}
			});
		})

		//获取所有老师信息
		function to_pagetea(pn) {
			$.ajax({
				url : "${basePath}/tea",
				data : "pn=" + pn,
				type : "GET",
				success : function(result) {
					build_teacher_table(result);//解析数据，显示数据
					build_info(result);//显示分页信息
					bulid_teacher_nav(result);//添加分页条
				}
			})
		}

		//老师查询
		function select_teacher(pn) {
			$.ajax({
				url : "${basePath}/tselect/" + pn,
				data : $("#teaSelectModal form").serialize(),
				type : "GET",
				success : function(result) {
					if (result.code == 100) {
						if (result.extend.pageinfo.total == 0) {
							alert("查询结果为空，请检查条件");
						} else {
							$('#teaSelectModal').modal('hide');
							build_teacher_table(result);//解析数据，显示数据
							build_info(result);//显示分页信息
							bulid_teacher_nav(result);//添加分页条
						}
					} else {
						alert(result.extend.error);
					}
				}
			})
		}

		//导出按钮
		$("#admin_export_all_btn").click(function() {
			if ($("#test option:selected").val() == 1) {//导出学生信息
				var url = "${basePath}/export";
				window.open(url);
			} else {
				var url = "${basePath}/exporttea";
				window.open(url);
			}
		})
	</script>
</body>
</html>