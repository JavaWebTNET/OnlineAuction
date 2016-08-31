
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
					<h1 class="entry-title"><a href="#" rel="bookmark">Account List</a></h1>
					<div class="entry-meta">
					<span class="entry-date"><a href="#" rel="bookmark"><time class="entry-date" datetime="2015-06-15T15:06:09+00:00">June 15, 2015</time></a></span>
					<span class="byline"><span class="author vcard"><a class="url fn n" href="#" rel="author">nipotian</a></span></span>			
					<span class="comments-link"><a href="#">1 Comment</a></span>
					</div><!-- .entry-meta -->
				</header><!-- .entry-header -->
				<div class="entry-content">
					<table class="items_list">
					<tr>
					<th>Id</th>
					<th>Username</th>
					<th>Email</th>
					<th>Enable</th>
					<th>Lock</th>
					</tr>
					<c:forEach var="acc" items="${accPage.getContent()}" varStatus="s">
					<tr class="items_tr_${s.index%2}">
					<td>${s.index+accPage.getNumber()*accPage.getSize()+1}</td>
					<td>${acc.username}</td>
					<td>${acc.email}</td>
					<td class="td_${acc.enable}">${acc.enable?'enabled':'locked'}</td>
					<td>
					<form method="post" action="lockAcc" id="${acc.username}">
						<input type="hidden" name="username" value="${acc.username}" />
						<input type="hidden" name="page" value="${accPage.getNumber()+1}" />
						<input type="button" value="${acc.enable?'lock':'unlock'}" onclick="ycdialog('${acc.username}');" />
					</form>
					</td>
					</tr>
					</c:forEach>
					</table>

					<p>Page
					<c:forEach var="i" begin="1" end="${accPage.getTotalPages()}" >
					<a href=".?page=${i}"><c:out value="${i}" /> </a>
					</c:forEach>
					</p>
					
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
