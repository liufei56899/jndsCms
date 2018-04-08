package com.dqjy.cms.manager.assist;

import com.dqjy.cms.entity.assist.CmsComment;
import com.dqjy.cms.entity.assist.CmsCommentExt;

public interface CmsCommentExtMng {
	public CmsCommentExt save(String ip, String text, CmsComment comment);

	public CmsCommentExt update(CmsCommentExt bean);

	public int deleteByContentId(Integer contentId);
}