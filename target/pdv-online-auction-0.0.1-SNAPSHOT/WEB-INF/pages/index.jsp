
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en-US">

<%@ include file="includes/head.jsp" %>

<body onload="msgbox('${msg}');"
class="home blog masthead-fixed list-view full-width grid">
<div id="page" class="hfeed site">
	
	<%@ include file="includes/header.jsp" %>

	<div id="main" class="site-main">
		<div id="main-content" class="main-content">
			<div id="primary" class="content-area">
				<div id="content" class="site-content" role="main">		
				<article id="post-1" class="post-1 post type-post status-publish format-standard hentry category-uncategorized">	
				<header class="entry-header">
					<h1 class="entry-title"><a href="#" rel="bookmark">HomePage</a></h1>
					<div class="entry-meta">
					<span class="entry-date"><a href="#" rel="bookmark"><time class="entry-date" datetime="2015-06-15T15:06:09+00:00">June 15, 2015</time></a></span>
					<span class="byline"><span class="author vcard"><a class="url fn n" href="#" rel="author">nipotian</a></span></span>			
					<span class="comments-link"><a href="#">1 Comment</a></span>
					</div><!-- .entry-meta -->
				</header><!-- .entry-header -->
				<div class="entry-content">
					<p>Page
					<c:forEach var="i" begin="1" end="${itemPage.getTotalPages()}" >
					<a href=".?s=${s}&cat=${cat}&page=${i}">${i} </a>
					</c:forEach>
					</p>
					<c:forEach var="item" items="${itemPage.getContent()}" varStatus="s">
					<div class="item_p" onclick="ddialog('item_p${item.id}');">
					<div class="item_img">
					<img src="image/${item.image}" />
					</div>
					<h6>${item.name}</h6>
					<p>Category: ${item.category==null?'Other':item.category.name}</p>
					<p>$${item.curBid}</p>
					<p id="idex" >Ex.: ${item.endDate}</p>					
					</div>
					<div class="hide" id="item_p${item.id}" title="${item.name}">
					<div class="item_p">
					<div class="item_img">
					<img src="image/${item.image}" />
					</div>
					<h6>Current Bid: $${item.curBid}</h6>
					<c:if test="${item.bidStatus == 'A' 
						&& pageContext.request.userPrincipal.name != null 
						&& item.sellAcc.username != pageContext.request.userPrincipal.name}">
					<form action="bid" method="post" 
					onsubmit="return chkbid(item.curBid+item.bidInc);">
					<input type="hidden" name="bidAcc" value="${pageContext.request.userPrincipal.name}" />
					<input type="hidden" name="itemId" value="${item.id}" />
					Bid: $<input type="text" id="bidValue" name="bidValue" value="${item.curBid+item.bidInc}" />
					<input type="submit" value="Bid" />
					</form>
					</c:if>
					<p>${item.description}</p>
					<p>Seller: ${item.sellAcc.username}, ${item.sellAcc.email}</p>
					<p id="idex" >Ex.: ${item.endDate}</p>
					<p>Start: $${item.minBid}</p>
					<p>Inc: $${item.bidInc}</p>
					<h6>Bid Logs:</h6>
					<ul>
					<c:forEach var="alog" items="${item.auctLog}" varStatus="ls">
						<li>${alog.bidAcc.username}
						<ul>
						<li>${alog.bidAcc.email}</li>
						<li>$${alog.bidValue}</li>
						<li>${alog.bidDate}</li>
						</ul>
						</li>
					</c:forEach>
					</ul>
					</div>
					</div>
					</c:forEach>
					
					
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
