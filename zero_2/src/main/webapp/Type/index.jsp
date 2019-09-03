<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="../layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="../layui/layui.all.js"></script>
<script src="../js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="../js/my.js"></script>
<title></title>
<style type="text/css">
.input {
	font-size: 16px; width : 200px;
	
	height: 30px;
	margin-top: -10px;
	margin-right: 10px;
	width: 200px;
}

.layui-form-select{width:200px;
}
</style>
</head>
<body>
<!-- 表格 -->
	<table id="demo" lay-filter="test"></table>
<!-- end表格 -->	
	<!--动态生成按钮 -->
	<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<!-- 最上面的按钮和搜索框 -->
	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <div class="layui-input-inline">
      <input type="text" name="txt" lay-verify="title"  autocomplete="off" placeholder="请输入名称" class="layui-input input">
    </div>

    <button class="layui-btn layui-btn-sm" lay-event="search">查询</button>
    <button class="layui-btn layui-btn-sm" lay-event="add">新增</button>
  </div>
</script>

	<script>
	
		layui.use('table', function() {
			var table = layui.table;

			//第一个实例
			table.render({
				//处理的元素
				elem : '#demo',
				height : 462,
				url : 'index.action' //数据接口,处理页直接给个json串,这个串就是查出来的内容,第一次没有传参,所以默认select
				,
				toolbar : '#toolbarDemo',
				
				page : true //开启分页
				,
				cols : [ [ //表头
				{
					//id要与查的数据对应上
					field : 'id',
					title : 'ID',
					width : 80,
					sort : true,
					fixed : 'right'
				}, {
					field : 'name',
					title : '用户名',
					width : 280
				}, {
					fixed : 'right',
					title : '操作',
					//名字对应上,操作列
					toolbar : '#barDemo',
					width : 150,
					align : 'center'
				}

				] ],
				//数据格式
				parseData : function(res) {
					return {
						"code" : res.code,
						"msg" : res.msg,
						"count" : res.count,
						data : res.list
					}
				}
			});
			
			

			//obj 行      obj.data 行数据    data.id 列
			//test  是table的lay-filter="test" 属性
			//tool是工具条事件名
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				if (obj.event === 'del') { ///lay-event 属性,在前面的按钮处有lay-event="del"
					//lay-event只是在表中删除,下面是在数据库删除的操作请求
					myconfirm("刪除？",function(){
			 $.post("delete.action", {id : data.id}, 
								function(json) {
							//重新更新,代替重定向
							reload('demo');
						//关闭弹窗
							layer.close(layer.index);
								}, "json"); 
							 	/* reload('demo',{cmd : "delete",id : data.id})
								layer.close(layer.index);  */
					});
				}else{
					//打开frame
					openFrame('edit.jsp?id='+data.id);
				}
			});

			table.on('toolbar(test)', function(obj) {
				if (obj.event === 'search') {
					//找到输入框的值
					var txt = $(event.target).prev().find("input").val();
					//{txt : txt}键值对,发的参数
					//reload是一种请求-->后端-->后端返回值-->前端表格刷新的过程,可以看成一种自动连续的过程
					//是一个从这里发出,在从这里接收的连续过程,简化了重定向,而且伴有局部刷新的效果
					reload('demo',{txt : txt});
					
				} else {
					openFrame("edit.jsp");
				}
			});

		});
	</script>
</body>
</html>