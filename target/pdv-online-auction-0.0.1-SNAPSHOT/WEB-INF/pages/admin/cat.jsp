
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
					<h1 class="entry-title"><a href="#" rel="bookmark">
					Category
					<c:if test="${cate==null}">: ?</c:if>
					<c:if test="${cate!=null}">
					<c:if test="${cate.id>0}">: ${cate.name}</c:if>
					<c:if test="${cate.id==0}">: Other</c:if>
					</c:if>
					</a></h1>
					<div class="entry-meta">
					<span class="entry-date"><a href="#" rel="bookmark"><time class="entry-date" datetime="2015-06-15T15:06:09+00:00">June 15, 2015</time></a></span>
					<span class="byline"><span class="author vcard"><a class="url fn n" href="#" rel="author">nipotian</a></span></span>			
					<span class="comments-link"><a href="#">1 Comment</a></span>
					</div><!-- .entry-meta -->
				</header><!-- .entry-header -->
				<div class="entry-content">
					<p>
					<c:if test="${cate==null}">Main Category not selected</c:if>
					<c:if test="${cate!=null && cate.id>0}"><a href="addCat?super=${cate.id}">New Category</a></c:if>
					</p>
					<table class="items_list">
					<tr>
					<th>Id</th>
					<th>Category Name</th>
					<th>Description</th>
					<th>Edit</th>
					</tr>
					<c:forEach var="scate" items="${cate.subCate}" varStatus="s">
					<tr class="items_tr_${s.index%2}">
					<td>${scate.id}</td>
					<td>${scate.name}</td>
					<td>${scate.description}</td>
					<td><a href="cat?id=${scate.id}">edit</a></td>
					</tr>
					</c:forEach>
					</table>
					<table class="items_list">
					<tr>
					<th>Id</th>
					<th>Item Name</th>
					<th>Description</th>
					<th>Change Category</th>
					</tr>
					<c:forEach var="item" items="${catItems.getContent()}" varStatus="s">
					<tr class="items_tr_${s.index%2}">
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.description}</td>
					<td><input type="button" onclick="ddialog('item_p${item.id}');" value="Change Category" /></td>
					<td class="hide">
					<div class="hide" id="item_p${item.id}" title="${item.name}">
					<div class="item_p">
					<div class="item_img">
					<img src="../image/${item.image}" />
					</div>
					<p>${item.description}</p>
					<form action="changeCat" method="post" 
					onsubmit="return true;">
					<input type="hidden" name="itemId" value="${item.id}" />
					<select name="catId">
						<c:forEach var="cate" items="${mainCate}" varStatus="s">
						<option value="${cate.id}">${cate.name}</option>
						<c:forEach var="scate" items="${cate.subCate}" varStatus="s">
						<option value="${scate.id}">${cate.name}/${scate.name}</option>
						</c:forEach>
						</c:forEach>
						<option value="0" selected="selected">Other</option>
					</select>
					<input type="submit" value="Save" />
					</form>
					</div>
					</div>
					</td>
					</tr>
					</c:forEach>
					</table>
					
					
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
