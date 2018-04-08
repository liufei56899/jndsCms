package com.dqjy.cms.dao.assist;

import com.dqjy.cms.entity.assist.CmsCommentExt;
import com.dqjy.common.hibernate3.Updater;
import com.dqjy.common.page.Pagination;

public interface CmsCommentExtDao {
	public Pagination getPage(int pageNo, int pageSize);

	public CmsCommentExt findById(Integer id);

	public CmsCommentExt save(CmsCommentExt bean);

	public CmsCommentExt updateByUpdater(Updater<CmsCommentExt> updater);

	public int deleteByContentId(Integer contentId);

	public CmsCommentExt deleteById(Integer id);
}