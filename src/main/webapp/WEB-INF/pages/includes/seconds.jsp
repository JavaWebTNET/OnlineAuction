<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="secondary">
		<h2 class="site-description">Just another WordPress site</h2>	
		<div id="primary-sidebar" class="primary-sidebar widget-area" role="complementary">
		<aside id="search-2" class="widget widget_search">
			<form role="search" method="get" class="search-form" action=".">
				<label>
					<span class="screen-reader-text">Search for:</span>
					<input type="hidden" name="cat" value="${cat}" />
					<input type="search" class="search-field" placeholder="Search &hellip;" value="" name="s" title="Search for:" />
				</label>
				<input type="submit" class="search-submit" value="Search" />
			</form>
		</aside>
		<aside id="categories-2" class="widget widget_categories">
			<h1 class="widget-title">Categories</h1>
			<ul>
			<c:forEach var="mCate" items="${mainCate}" varStatus="s">
			<li class="cat-item"><a href=".?cat=${mCate.id}" >${mCate.name}</a>				
				<a class="cat_toggle" href="#" onclick="togglecat('cat_${mCate.id}');"> </a>
				<ul id="cat_${mCate.id}" class="cat_item_children">
				<c:forEach var="sCate" items="${mCate.subCate}" varStatus="ss">				
				<li class="cat-item"><a href=".?cat=${sCate.id}" >${sCate.name}</a></li>
				<li class="cat-item"><a href=".?cat=${-mCate.id}" >Other</a></li>				
				</c:forEach>
				</ul>
			</li>
			</c:forEach>
			<li class="cat-item"><a href=".?cat=0" >Uncategorized</a></li>
			</ul>
		</aside>
		</div><!-- #primary-sidebar -->
		</div><!-- #secondary -->