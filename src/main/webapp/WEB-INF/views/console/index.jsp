<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>console - index</title>
    <link href="<c:url value="/resources/form.css" />" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.all.css" />" rel="stylesheet"
          type="text/css"/>

    <script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/jqueryform/2.8/jquery.form.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.core.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.widget.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.tabs.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/json2.js" />"></script>
</head>
<body>

<c:out value="${message}"/>

</body>
</html>