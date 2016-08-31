package pdv.online.auction.service.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pdv.online.auction.service.PageSrv;

@Service
public class PageSrvImpl implements PageSrv{

	@Override
	public Pageable setPageDefault(Pageable page, Sort defaultSort) {
		Sort sort=page.getSort();
		int pageNumber=page.getPageNumber();
		if(page.getSort()==null){
			sort= defaultSort;
		}
		if(page.getPageNumber()<=0){
			pageNumber=1;
		}
		page=new PageRequest(pageNumber-1,page.getPageSize(),sort);
		return page;
	}

}
