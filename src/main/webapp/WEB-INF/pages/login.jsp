
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<h1 class="entry-title"><a href="#" rel="bookmark">Log in</a></h1>
					<div class="entry-meta">
					<span class="entry-date"><a href="#" rel="bookmark"><time class="entry-date" datetime="2015-06-15T15:06:09+00:00">June 15, 2015</time></a></span>
					<span class="byline"><span class="author vcard"><a class="url fn n" href="#" rel="author">nipotian</a></span></span>			
					<span class="comments-link"><a href="#">1 Comment</a></span>
					</div><!-- .entry-meta -->
				</header><!-- .entry-header -->
				<div class="entry-content">
				<form id="loginForm" class="loginbox" name="loginForm" action="j_spring_security_check" method="post">
                       		<table>  
                       			<tr>
                       				<c:if test="${param.reg != null}">
                                	<td colspan=2>Register done. Please Login</td>                                                           
                            	</c:if>
                       			</tr>                           
                        		<tr>                      
                            		<th>Username</th>                             
                           			<td> <input type="text" id="username"  name="username" size="15" /></td>
                       			<tr>
                            		<th>Password</th>                             
                            		<td><input type="password" id="password" name="password" size="15" /></td>                       		
                        		<tr>
                            	<c:if test="${param.error != null}">
                                	<td colspan=2>Login Failed. Wrong username or password</td>                                                           
                            	</c:if>
                            	<c:if test="${param.loggedout != null }" >
                            		<td colspan=2>Logged out</td>                              
                            	</c:if>
                            	</tr>
                            	<tr>
                           			<td colspan="2"><button>Login</button></td>
                            	</tr>
  							</table>                                                      
                </form>				
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


                   