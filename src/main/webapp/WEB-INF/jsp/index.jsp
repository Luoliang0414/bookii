<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="width: 900px; margin:0px auto">
<div  style="width:900px; align:center">
<h2 align="center">图书信息列表</h2>
</div>
<div style="width:880px; text-align:left; padding-left:20px; line-height:25px; height:25px">
<a href="#">添加图书</a>
</div>
<div style="width:900px; text-align:center">
    <form id="searchForm" action="${pageContext.request.contextPath}/index" method="post">
        图书类型:
        <select name="typeid" id="typeid">
            <option value="-1">-请选择图书类型-</option>
            <c:if test="${requestScope.bookTypeList!=null}">
                <c:forEach var="bookType" items="${requestScope.bookTypeList}">
                    <option value="${bookType.typeid}" <c:if test="${bookParam.typeid==bookType.typeid}">selected="selected"</c:if>
                    >${bookType.typename}</option>
                </c:forEach>
            </c:if>
        </select>&nbsp;
        作者:
        <input name="author" type="text" id="author" size="8" value="${requestScope.bookParam.author}"/>
        价格:
        <input name="min_price" type="text" id="min_price" size="8" value="${requestScope.bookParam.min_price}"/>
        到
        <input name="max_price" type="text" id="max_price" size="8" value="${requestScope.bookParam.max_price}"/>
        <input name="pageNo" type="hidden" id="pageNo" value="1">
        <input type="submit" name="btnSearch" id="btnSearch" value="查询图书" />
    </form>
</div>

<div>
    <table width="900" border="1" cellspacing="0" cellpadding="0">
        <tr>
            <td>图书编号</td>
            <td>图书名称</td>
            <td>价格</td>
            <td>出版时间</td>
            <td>作者</td>
            <td>图书类型</td>
            <td>详细</td>
            <td>删除</td>
            <td>修改</td>
        </tr>
        <c:if test="${requestScope.page.list!=null}">
            <c:forEach items="${requestScope.page.list}" var="book">
                <tr>
                    <td>${book.bookid}</td>
                    <td>${book.bookname}</td>
                    <td>${book.price}</td>
                    <td><fmt:formatDate value="${book.pubtime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                    <td>${book.author}</td>
                    <td>${book.typeid}</td>
                    <td>详细</td>
                    <td>删除</td>
                    <td>修改</td>
                </tr>
            </c:forEach>
        </c:if>

        <tr>
            <td colspan="9" align="center" valign="middle">
                <a href="javascript:do_page(1)">首页</a>
                <a href="javascript:do_page(${requestScope.page.pageNo-1})">上一页</a>&nbsp;
                <a href="javascript:do_page(${requestScope.page.pageNo+1})">下一页</a>&nbsp;
                <a href="javascript:do_page(${requestScope.page.totalPage})">末页</a>&nbsp;
                ${requestScope.page.pageNo}/${requestScope.page.totalPage}页
            </td>
        </tr>
    </table>

</div>
<script type="application/javascript">
    function do_page(pn) {
        document.getElementById("pageNo").value=pn;
        var searchForm=document.getElementById("searchForm");
        searchForm.submit();
    }
</script>
</body>

</html>

