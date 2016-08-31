package pdv.online.auction.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface PageSrv {
	public Pageable setPageDefault(Pageable page, Sort defaultSort);
}
