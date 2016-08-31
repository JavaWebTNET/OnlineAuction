	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<header id="masthead" class="site-header" role="banner">
		<img class="header-img" src="<c:url value='/resources/img/boat.jpg' />" />
		<div class="header-main">
			<h1 class="site-title"><a href=".." rel="home">Online Auction</a></h1>
			
			<div class="search-toggle" onclick="searchtoggle();">				
			</div>
			<nav id="primary-navigation" class="site-navigation primary-navigation" role="navigation">
				<button class="menu-toggle" onclick="menutoggle();">Primary Menu</button>				
				<div id="nav-menu" class="nav-menu">
					<ul>
					<li class="page_item"><a href="#">About-US</a></li>
					<li class="page_item"><a href="../admin/">Admin</a></li>				
					</ul>
				</div><!-- #nav-menu -->
			</nav><!-- #primary-navigation -->
		</div><!-- .header-main -->
		<div class="username">
			<c:if test="${pageContext.request.userPrincipal != null}" >
				<a class="user" href=".">${pageContext.request.userPrincipal.name}</a>
				<a href="../logout"> - Log out</a>
			</c:if>
			<c:if test="${pageContext.request.userPrincipal == null}" >
				<a href="../login">Log in</a>
				<a href="../register"> - Register</a>
			</c:if>
		</div>	
		<div id="search-container" class="search-box-wrapper hide">
			<div class="search-box">
				<form role="search" method="get" class="search-form" action="..">
				<label>
					<span class="screen-reader-text">Search for:</span>
					<input type="search" id="sf-s" class="search-field" placeholder="Search &hellip;" value="" name="s" title="Search for:" />
				</label>
				<input type="submit" class="search-submit" value="Search" />
				</form>
			</div><!-- .search-box -->
		</div><!-- #search-container -->
	</header><!-- #masthead -->
