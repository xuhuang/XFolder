<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>VideoStore - Administration Page</title>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css" />
    <script>
    $(function() {
        $( "#tabs" ).tabs();
        $( "#tabs" ).tabs({ active: ${result.tab} });
        $("li a.movie").bind("click", function() {
        	$("input[name='tab']").val(0);
        	$("form.orderForm").submit();
        });
        $("li a.return").bind("click", function() {
        	$("input[name='tab']").val(1);
        	$("form.orderForm").submit();
        });
        $("li a.transaction").bind("click", function() {
        	$("input[name='tab']").val(2);
        	$("form.orderForm").submit();
        });
        
        $("#mSearch").click(function(){
        	var mKey = $("#mKeyword").val();
        	$("input[name='keyword']").val(mKey);
        	var active = $( "#tabs" ).tabs( "option", "active" );
        	$("input[name='tab']").val(active);
        	$("input[name='opt']").val("search");
        	$("form.orderForm").submit();
        });
    });
    </script>
</head>
<body>
 
<div id="tabs">
    <ul>
        <li id="movie"><a class="movie" href="#tabs-1">Movies</a></li>
        <li id="return"><a class="member" href="#tabs-2">Member</a></li>
        <li id="reprot"><a class="transaction" href="#tabs-3">Transaction</a></li>
        <li id="reprot"><a class="report" href="#tabs-4">Report</a></li>
    </ul>
    <div id="tabs-1">
        <p>
        	Search: <input type="text" width="20px" id="mKeyword" /><input id="mSearch" type="button" value="Search">
        </p>
        <p>
        	<input id="mAdd" type="button" value="Add new movie">
        </p>
        <p>
        	<table>
        		<c:forEach items="${result.movies}" var="movie">
        			<tr>
        				<td>${movie.Title}</td>
        				<td><a href="">Remove</a></td>
        				<td><a href="">Edit</a></td>
        			</tr>
        		</c:forEach>
        	</table>
        </p>
    </div>
    <div id="tabs-2">
        <p>
        	Search: <input type="text" width="20px" id="uKeyword" /><input id="uSearch" type="button" value="Search">
        </p>
        <p>
        	<input id="uAdd" type="button" value="Add new member">
        </p>
    </div>
    <div id="tabs-3">
        <p>
        	Search: <input type="text" width="20px" id="tKeyword" /><input id="tSearch" type="button" value="Search">
        </p>
    </div>
    <div id="tabs-4">
        <p>
        	<a href="report.do?reportId=1">
        		Total number of outgoing movies per store and per month.
        	</a>
       	</p>
        <p>
        	<a href="report.do?reportId=2">
        		Average number of rental days per store.
        	</a>
       	</p>
        <p>
        	<a href="report.do?reportId=3">
        		10 most frequently reserved titles for the last year.
        	</a>
       	</p>
       	<p>
        	<a href="report.do?reportId=4">
        		100 best customers.
        	</a>
       	</p>
       	<p>
        	<a href="report.do?reportId=5">
        		Average number of outgoing movies per store.
        	</a>
       	</p>
       	
		<p>
			${result.table}
		</p>
    </div>
</div>
<form class="orderForm" action="administration.do" method="post">
	<input type="hidden" name="keyword" value="" />
	<input type="hidden" name="tab" value="" />
	<input type="hidden" name="opt" value="" />
</form>
 
</body>
</html>