<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	center = function(){
		debugger;
		center_this=this;
		//定义一个公用调用的函数,添加tabs
		center_this.addTabs=function(tabObject){
			debugger;

			var centerTabsOptions=$("#center_tabs");
			if (centerTabsOptions.tabs('exists', tabObject.title)) {
				centerTabsOptions.tabs('select', tabObject.title);
			} else {
				centerTabsOptions.tabs('add', tabObject);
			}
		}
		
	}
	var centerObject=new center();
</script>
<div class="easyui-tabs" fit="true" id="center_tabs" border=false>
 <div title="首页" data-options="iconCls : 'icon-home'" style="padding:20px;">
        welecome to here !
    </div>
</div>
