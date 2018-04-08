package com.dqjy.cms.dao.assist;

import com.dqjy.cms.entity.assist.CmsJobApply;
import com.dqjy.common.hibernate3.Updater;
import com.dqjy.common.page.Pagination;

public interface CmsJobApplyDao {
	public Pagination getPage(Integer userId, Integer contentId,
			Integer siteId, boolean cacheable, int pageNo, int pageSize);

	public CmsJobApply findById(Integer id);

	public CmsJobApply save(CmsJobApply bean);

	public CmsJobApply updateByUpdater(Updater<CmsJobApply> updater);

	public CmsJobApply deleteById(Integer id);
}