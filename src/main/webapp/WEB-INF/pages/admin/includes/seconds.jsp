<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="secondary">
		<h2 class="site-description">Just another WordPress site</h2>	
		<div id="primary-sidebar" class="primary-sidebar widget-area" role="complementary">
		<aside id="search-2" class="widget widget_search">
			<form role="search" method="get" class="search-form" action="..">
				<label>
					<span class="screen-reader-text">Search for:</span>
					<input type="search" class="search-field" placeholder="Search &hellip;" value="" name="s" title="Search for:" />
				</label>
				<input type="submit" class="search-submit" value="Search" />
			</form>
		</aside>
		<aside id="categories-3" class="widget widget_categories">
			<h1 class="widget-title">Account Manager</h1>
			<ul>
			<li class="cat-item"><a href="." >Account List</a></li>
			</ul>
		</aside>
		<aside id="categories-4" class="widget widget_categories">
			<h1 class="widget-title">Categories Resits</h1>
			<ul>
			<li class="cat-item"><a href="addCat" >New Category Pack</a></li>
			<c:forEach var="mCate" items="${mainCate}" varStatus="s">
			<li class="cat-item"><a href="cat?id=${mCate.id}" >${mCate.name}</a></li>
			</c:forEach>
			<li class="cat-item"><a href="cat?id=0" >Other</a></li>
			</ul>
		</aside>
		</div><!-- #primary-sidebar -->
		</div><!-- #secondary -->