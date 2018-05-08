<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("basePath", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>老师界面</title>
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

body {
	background: url(./static/img/bgpic1.jpg);
	background-size: 70%;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<!-- 老师考勤模块框 -->
	<!-- Modal -->
	<div class="modal fade" id="teaClassModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form class="form-horizontal">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">选择上课的信息</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-2 control-label">班级</label>
								<div class="col-sm-4">
									<select id="class_select" class="form-control"
										name="stuClassname">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">周次</label>
								<div class="col-sm-4">
									<input type="text" id="week" class="form-control"
										name="stuWeek" placeholder="1">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">星期</label>
								<div class="col-sm-4">
									<select id="weekday_select" class="form-control"
										name="stuWeekday">
										<option value="一" id="weekday" weekid="1">一</option>
										<option value="二" id="weekday" weekid="2">二</option>
										<option value="三" id="weekday" weekid="3">三</option>
										<option value="四" id="weekday" weekid="4">四</option>
										<option value="五" id="weekday" weekid="5">五</option>
										<option value="六" id="weekday" weekid="6">六</option>
										<option value="日" id="weekday" weekid="7">日</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程名</label>
								<div class="col-sm-4">
									<select id="course_select" class="form-control"
										name="stuCoursename">
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" onclick="begin(1)"
							id="class_btn">确定</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!--提问模态框 -->
	<div class="modal fade" id="teaQuesModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form class="form-horizontal">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">抽签小程序</h4>
					</div>
					<div class="modal-body">
						<div class="jumbotron">
							<h3 id="result" style="color: blue; text-align: center">Welcome</h3>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="begin_btn">开始</button>
						<button type="button" class="btn btn-danger" id="end_btn">停止</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 老师查询学生信息模块框 -->
	<!-- Modal -->
	<div class="modal fade" id="teaSelectModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form class="form-horizontal">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">查询学生缺勤信息</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-2 control-label">班级</label>
								<div class="col-sm-4">
									<select id="class_select_select" class="form-control"
										name="stuClassname">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程名</label>
								<div class="col-sm-4">
									<select id="course_select_select" class="form-control"
										name="stuCoursename">
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" onclick="select(1)">确定</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!--获取平时分的模态框 -->
	<div class="modal fade" id="teaWeightModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form class="form-horizontal">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">设置考勤分所占权重</h4>
					</div>
					<div class="modal-body">
						<input type="text" name="weight" id="weight" class="form-control"
							placeholder="权重" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" id="yes_btn">确定</button>
						<button type="button" class="btn btn-primary"
							id="export_grade_btn">导出</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!--添加备注的模态框 -->
	<div class="modal fade" id="teaRemarkModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form class="form-horizontal">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">添加备注</h4>
					</div>
					<div class="modal-body">
						<input type="text" name="Remark" id="remark" class="form-control"
							placeholder="备注" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" id="remark_btn">确定</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row" style="color: white; background: #bfd061;">
			<div class="col-md-8">
				<h1>考勤管理系统</h1>
			</div>
			<div class="col-md-4" style="margin-top: 5px">
				<ul>
					<li>
						<h4 style="margin-top: -1px">
							欢迎<font color="red">${teacher.tecName}</font>老师登录
						</h4>
					</li>
					<li><a href="/Attendance/index.jsp"><h4
								style="margin-top: -1px">
								<font color="red">退出</font>
							</h4></a></li>
				</ul>
			</div>
		</div>
		<div class="row" style="margin-top: 10px">
			<div id="selected" class="col-md-8"></div>
			<div class="col-md-4">
				<button type="button" class="btn btn-primary "
					id="tea_Class_modal_btn">考勤</button>
				<button type="button" class="btn btn-primary"
					id="tea_random_modal_btn">提问</button>
				<button type="button" class="btn btn-primary"
					id="tea_select_modal_btn">查看</button>
				<button type="button" class="btn btn-primary"
					id="tea_weight_modal_btn">设置比重</button>
				<button type="button" class="btn btn-danger" id="tea_export_btn">导出</button>
			</div>
		</div>
		<!-- 显示学生表格数据 -->
		<div class="row" style="margin-top: 10px">
			<div class=col-md-12>
				<table class="table table-bordered table-hover" id="stus_table">
					<thead>
						<tr>
							<th>学号</th>
							<th>姓名</th>
							<th>班级</th>
							<th>课程名</th>
							<th>状态</th>
							<th>备注</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>

		<!-- 显示学生表格数据 -->
		<div class="row">
			<div class=col-md-12>
				<table class="table table-bordered table-hover"
					id="stus_select_table">
					<thead>
						<tr>
							<th>学号</th>
							<th>姓名</th>
							<th>班级</th>
							<th>课程名</th>
							<th>周次</th>
							<th>星期</th>
							<th>状态</th>
							<th>备注</th>
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
	<OBJECT classid="clsid:A318A9AC-E75F-424C-9364-6B40A848FC6B" width=20
		height=20 id=zkonline> </OBJECT>
	<COMMENT> <EMBED type="application/x-eskerplus"
		classid="clsid:A318A9AC-E75F-424C-9364-6B40A848FC6B"
		codebase="ZKOnline.ocx" width=20 height=20>
	</EMBED> </COMMENT>
</body>
<script type="text/javascript">
	var time, currentPage;
	var students = new Array();//记录所有学生的姓名
	var index;//记录已选过的人
	var allStus;//每次重新提问时重新赋值

	var classname;//記住跟新所需的条件
	var coursename;
	var week;
	var weekday;
	//页面加载完成后执行
	/* $(function() {
		sure();
	}) */

	$("#stus_select_table").hide();//隐藏查询表格
	//考勤开始
	$("#tea_Class_modal_btn").click(function() {
		getClassname("#class_select");
		getCourse("#course_select");
		$("#teaClassModal").modal('show');
		$("#stus_select_table").hide();//隐藏查询表格
		$("#stus_table").show();//显示学生表格

	})

	//获得所有班级名
	function getClassname(ele) {
		$("#class_select").empty();
		$("#course_select").empty();
		$("#class_select_select").empty();
		$("#course_select_select").empty();
		$.ajax({
			url : "${basePath}/getclass",
			type : "GET",
			success : function(result) {
				console.log(result);
				var optionEl = $("<option name='stuClassname'></option>")
						.append("");
				optionEl.appendTo(ele);
				$.each(result.extend.classes, function() {
					optionEl = $(
							"<option name='stuClassname' id='sid'></option>")
							.append(this.classname);
					optionEl.attr("classid", this.classid);
					optionEl.appendTo(ele);
				})
			}
		})
	}

	//获得所有课程名
	function getCourse(ele) {
		$("#class_select").empty();
		$("#course_select").empty();
		$("#class_select_select").empty();
		$("#course_select_select").empty();
		$
				.ajax({
					url : "${basePath}/getcourse",
					type : "GET",
					success : function(result) {
						console.log(result);
						var optionEl = $("<option name='coursename'></option>")
								.append("");
						optionEl.appendTo(ele);
						$
								.each(
										result.extend.couses,
										function() {
											optionEl = $(
													"<option name='coursename' id='cid'></option>")
													.append(this.coursename);
											optionEl.attr("courseid",
													this.courseId);
											optionEl.appendTo(ele);
										})
					}
				})
	}

	//点击签到之后跳出指纹页面
	$(document).on(
			"click",
			".attendancebtn",
			function() {
				var classid = $("#class_select").find("option:selected").attr(
						"classid");
				var courseid = $("#course_select").find("option:selected")
						.attr("courseid");
				var weekid = $("#weekday_select").find("option:selected").attr(
						"weekid");
				var stuId = $(this).parents("tr").find("td:eq(0)").text();
				var url = "${basePath}/verify.jsp?pid=" + stuId + "&week="
						+ week + "&weekday=" + weekid + "&courseid=" + courseid
						+ "&classid=" + classid;
				var newHtml=window.open(url);
				if(!newHtml.closed){
					 //parent.location.reload(); 
					 begin(1);
				}
				window.open(url);
			});

	function begin(pn) {
		var regPos = /^\d*$/; // 非负整数
		classname = $('#class_select').val();
		week = $('#week').val();
		if (regPos.test(week)) {
			coursename = $('#course_select').val();
			weekday = $("#weekday_select").val();
			$.ajax({
				url : "${basePath}/begin/" + pn,
				data : $("#teaClassModal form").serialize(),
				type : "GET",
				success : function(result) {
					console.log(result);
					if (result.code == 100) {
						allStus = result;//将json数据赋给allStus
						var stus = result.extend.pageinfo.list;
						$.each(stus, function(index, item) {
							students[index] = item.stuName;
						});
						$("#teaClassModal").modal('hide');
						build_table(result);//解析数据，显示数据
						build_info(result);//显示分页信息
					} else {
						alert(result.extend.msg);
					}
				}
			})
		} else {
			alert("输入的周次错误");
		}

	}

	//构建表格
	function build_table(result) {
		//清空数据
		$("#stus_table tbody").empty();
		var stus = result.extend.pageinfo.list;
		$
				.each(
						stus,
						function(index, item) {
							var stuIdTd = $("<td></td>").append(
									item.stuinfo.stuinfoId);
							var stuNameTd = $("<td></td>").append(item.stuName);
							var stuClassnameTd = $("<td></td>").append(
									item.stuClassname);
							var stuCoursenameTd = $("<td></td>").append(
									item.stuinfo.stuCoursename);
							var stuAttendanceBtn =$("<button class='btn btn-primary btn-sm attendancebtn'><span class='glyphicon glyphicon-edit'>签到</span></button>");
							stuAttendanceBtn.attr("attendance_id",
									item.stuinfo.stuinfoId);
							var editBtn = $("<td></td>").append($("<button class='btn btn-primary btn-sm remark'><span class='glyphicon glyphicon-pencil'>编辑</span></button>"));
							editBtn.attr("t_id", item.stuinfo.stuinfoId);
							if(item.stuinfo.stuAttendance=="缺勤"){
								var alertTb=$("<laber></laber>").addClass("alert alert-danger").append("缺勤");
							}else{
								var alertTb=$("<laber></laber>").addClass("alert alert-info").append("到勤");
							}
							var zhuantTB=$("<td></td>").append(stuAttendanceBtn).append(" ").append(alertTb);
							$("<tr></tr>").append(stuIdTd).append(stuNameTd)
									.append(stuClassnameTd).append(
											stuCoursenameTd).append(
													zhuantTB).append(editBtn)
									.appendTo("#stus_table tbody");//放入表格id为emps_table的tbody中

						});
	}

	//构建查询缺勤表格
	function build_select_table(result) {
		//清空数据
		$("#stus_select_table tbody").empty();
		var stus = result.extend.pageinfo.list;
		$.each(stus, function(index, item) {
			console.log(item.stuinfo.stuinfoId);
			var stuIdTd = $("<td></td>").append(item.stuinfo.stuinfoId);
			var stuNameTd = $("<td></td>").append(item.stuName);
			var stuClassnameTd = $("<td></td>").append(item.stuClassname);
			var stuWeekTd = $("<td></td>").append(item.stuinfo.stuWeek);
			var stuWeekdayTd = $("<td></td>").append(item.stuinfo.stuWeekday);
			var stuCoursenameTd = $("<td></td>").append(
					item.stuinfo.stuCoursename);
			var stuAttendanceTd = $("<td></td>").addClass("danger").append(
					item.stuinfo.stuAttendance);
			var stuRenarkTd = $("<td></td>").append(item.stuinfo.stuRemark);
			$("<tr></tr>").append(stuIdTd).append(stuNameTd).append(
					stuClassnameTd).append(stuCoursenameTd).append(stuWeekTd)
					.append(stuWeekdayTd).append(stuAttendanceTd).append(
							stuRenarkTd).appendTo("#stus_select_table tbody");//放入表格id为emps_table的tbody中

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

	//提问按钮
	$("#tea_random_modal_btn").click(function() {
		$("#teaQuesModal").modal('show');
		document.getElementById("result").innerHTML = "Welcome";
		var stus = allStus.extend.pageinfo.list;
		$.each(stus, function(index, item) {
			students[index] = item.stuName;

		});
	})

	//提问中的开始按钮
	$("#begin_btn").click(function() {
		document.getElementById("begin_btn").disabled = true;
		chouqian();
	})
	//抽签方法
	function chouqian() {
		index = Math.floor(Math.random() * 1000 % students.length);
		var name = students[index];
		if (name == null) {
			document.getElementById("begin_btn").disabled = false;
			alert("学生已抽完");
			$("#teaQuesModal").modal('hide');
		} else {
			document.getElementById("result").innerHTML = name;
			time = window.setTimeout(chouqian, 2);//2ms调用一次chouqian方法

		}
	}
	//抽签中的停止按钮
	$("#end_btn").click(function() {
		window.clearTimeout(time);//清除事件
		document.getElementById("begin_btn").disabled = false;
		students.splice(index, 1);//将数组从索引处删除一个
	})

	//老师查询
	$("#tea_select_modal_btn").click(function() {
		getClassname("#class_select_select");
		getCourse("#course_select_select");
		$("#teaSelectModal").modal('show');
	})

	//查询缺席学生
	function select(pn) {
		$.ajax({
			url : "${basePath}/absent/" + pn,
			data : $("#teaSelectModal form").serialize(),
			type : "POST",
			success : function(result) {
				console.log(result);
				if (result.code == 100) {
					$("#stus_select_table").show();
					build_select_table(result);
					build_info(result);
					bulid_select_nav(result);
					$("#teaSelectModal").modal('hide');
					$("#stus_table").hide();
				} else {
					alert(result.extend.error);
				}
			}
		})
	}

	//导出按钮
	$("#tea_export_btn").click(function() {
		var url = "${basePath}/exportabsent";
		window.open(url);
	})

	//设置平时分的权重
	$("#tea_weight_modal_btn").click(function() {
		$("#teaWeightModal").modal('show');
	})
	$("#yes_btn").click(function() {
		var weight = $("#weight").val();
		if ($("#weight").val() >= 1) {
			alert("权重应小于1");
		} else {
			$.ajax({
				url : "${basePath}/weight",
				data : "weight=" + weight,
				type : "POST",
				success : function(result) {
					if (result.code == 100) {
						console.log(result);
					} else {
						alert(result.extend.error);
					}
				}
			})
		}
	})

	//导出学生成绩表
	$("#export_grade_btn").click(function() {
		var url = "${basePath}/exportgrade";
		window.open(url);
		$("#teaWeightModal").modal('hide');
	})

	//备注按钮
	$(document).on("click", ".remark", function() {
		$("#remark_btn").attr("stu_id", $(this).attr("t_id"));
		$("#teaRemarkModal").modal('show');

	})

	//备注下的确定按钮
	$("#remark_btn").click(function() {
		var id = $(this).attr("stu_id");
		var Remark = $("#remark").val();
		$.ajax({
			url : "${basePath}/remarkupdate/" + id,
			type : "POST",
			data : "Remark=" + Remark + "&_method=PUT",
			success : function(result) {
				alert("跟新成功");
				$("#teaRemarkModal").modal('hide');
			}
		})
	})
</script>
</html>