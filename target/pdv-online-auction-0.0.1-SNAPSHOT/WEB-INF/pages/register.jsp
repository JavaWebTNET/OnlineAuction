
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
					<h1 class="entry-title"><a href="#" rel="bookmark">Register</a></h1>
					<div class="entry-meta">
					<span class="entry-date"><a href="#" rel="bookmark"><time class="entry-date" datetime="2015-06-15T15:06:09+00:00">June 15, 2015</time></a></span>
					<span class="byline"><span class="author vcard"><a class="url fn n" href="#" rel="author">nipotian</a></span></span>			
					<span class="comments-link"><a href="#">1 Comment</a></span>
					</div><!-- .entry-meta -->
				</header><!-- .entry-header -->
				<div class="entry-content">
				<sf:form method="post" modelAttribute="account" onsubmit="return chkformrs();" enctype="multipart/form-data" >
				<table>
					<tr>
					<th>Username(*): </th>
					<td><sf:input type="text" id="ipid" size="15" path="username" onblur="valid();"/></td>
					</tr>
					<tr>
					<td></td><td id="ider"><sf:errors  path="username"/></td>
					</tr>
					<tr>
					<th>Password(*): </th>
					<td><sf:input type="password" id="ippass" size="15" path="password" onblur="valpass();"/></td>
					</tr>
					<tr>
					<td></td><td id="passer"><sf:errors  path="password"/></td>
					</tr>
					<tr>
					<th>Re-Password(*): </th>
					<td><input type="password" id="iprps" size="15" onblur="valrepass();"/></td>
					</tr>
					<tr>
					<td></td><td id="rpser"></td>
					</tr>
					<tr>
					<th>Email(*): </th>
					<td><sf:input type="text" id="ipemail" size="15" path="email" onblur="valemail();"/></td>
					</tr>
					<tr>
					<td></td><td id="emailer"><sf:errors  path="email"/></td>
					</tr>
					<tr>
					<td colspan="2"><input name="comit" type="submit" value="Register" /></td>
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


                   