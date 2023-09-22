package org.dmt.eurostat.dmtpostprocessing.common.page;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class PageMapper {

    public static final Integer DEFAULT_PAGE_NUMBER = 1;
    public static final Integer DEFAULT_PAGE_SIZE = 10;

    public static PageRequest toPageable(Integer pageNumber, Integer pageSize) {
        return pageNumber != null ? PageRequest.of(Math.max(1, pageNumber) - 1, pageSize) : PageRequest.ofSize(pageSize);
    }

    public static org.dmt.eurostat.dmtpostprocessing.models.Page toPageAPI(Page<?> page) {
        org.dmt.eurostat.dmtpostprocessing.models.Page pageAPI = new org.dmt.eurostat.dmtpostprocessing.models.Page();
        pageAPI.setPageNumber(page.getNumber() + 1);
        pageAPI.setPageSize(page.getSize());
        pageAPI.setItemCount(Long.valueOf(page.getTotalElements()).intValue());
        return pageAPI;
    }
}