
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html lang="en-US">

<%@ include file="includes/head.jsp" %>

<body class="home blog masthead-fixed list-view full-width grid">
<div id="page" class="hfeed site">
	
	<%@ include file="includes/header.jsp" %>

	<div id="main" class="site-main">
		<div id="main-content" class="main-content">
			<div id="primary" class="content-area">
				<div id="content" class="site-content" role="main">		
				<article id="post-1" class="post-1 post type-post status-publish format-standard hentry category-uncategorized">	
				<header class="entry-header">
					<h1 class="entry-title"><a href="#" rel="bookmark">Add Item</a></h1>
					<div class="entry-meta">
					<span class="entry-date"><a href="#" rel="bookmark"><time class="entry-date" datetime="2015-06-15T15:06:09+00:00">June 15, 2015</time></a></span>
					<span class="byline"><span class="author vcard"><a class="url fn n" href="#" rel="author">nipotian</a></span></span>			
					<span class="comments-link"><a href="#">1 Comment</a></span>
					</div><!-- .entry-meta -->
				</header><!-- .entry-header -->
				<div class="entry-content">
				<sf:form method="post" modelAttribute="item" onsubmit="return chkformis();" enctype="multipart/form-data" >
				<table>
					<tr>
					<th>Item Name (*): </th>
					<td><sf:input type="text" id="ipiname" size="30" path="name" onblur="valiname();"/></td>
					</tr>
					<tr>
					<td><sf:input type="hidden" path="sellAcc.username" value="${pageContext.request.userPrincipal.name}" /></td>
					<td id="cnamer"><sf:errors  path="name"/></td>
					</tr>
					<tr>
					<th>Description: </th>
					<td><sf:textarea id="ipdesc" wrap="hard" rows="6" cols="30" path="description" onblur="valdesc();"/></td>
					</tr>
					<tr>
					<td></td><td id="descer"><sf:errors  path="description"/></td>
					</tr>
					<tr>
					<th>Bid Increment: </th>
					<td><sf:input type="text" id="ipinc" size="30" path="bidInc" onblur="valinc();"/></td>
					</tr>
					<tr>
					<td></td><td id="incer"><sf:errors  path="bidInc"/></td>
					</tr>	
					<tr>
					<th>Minimum Bid: </th>
					<td><sf:input type="text" id="ipmbid" size="30" path="minBid" onblur="valmbid();"/></td>
					</tr>
					<tr>
					<td></td><td id="mbider"><sf:errors  path="minBid"/></td>
					</tr>	
					<tr>
					<th>Start Date: </th>
					<td><sf:input type="text" id="ipsdate" size="30" path="startDate" onblur="valsdate();"/></td>
					</tr>
					<tr>
					<td></td><td id="sdateer"><sf:errors  path="startDate"/></td>
					</tr>	
					<tr>
					<th>End Date: </th>
					<td><sf:input type="text" id="ipedate" size="30" path="endDate" onblur="valedate();"/></td>
					</tr>
					<tr>
					<td></td><td id="edateer"><sf:errors  path="endDate"/></td>
					</tr>	
					<tr>
					<th>Image: </th>
					<td><input type="file" accept="image/*" id="ipimg" size="30" name="file" onblur="valimage();"/></td>
					</tr>
					<tr>
					<td></td><td id="imger"></td>
					</tr>				
					<tr>
					<td colspan="2"><input name="comit" type="submit" value="Done" /></td>
					</tr>
				</table>
				</sf:form>	
					
				</div><!-- .entry-content -->	
				</article><!-- #post-## -->
				</div><!-- #content -->
			</div><!-- #primary -->
		</div><!-- #main-content -->
		<%@ include file="includes/seconds.jsp" %>
	</div><!-- #main -->

	<%@ include file="includes/footer.jsp" %>
</div><!-- #page -->
	
</body>
</html>
