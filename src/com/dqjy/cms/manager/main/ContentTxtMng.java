package com.dqjy.cms.manager.main;

import com.dqjy.cms.entity.main.Content;
import com.dqjy.cms.entity.main.ContentTxt;

public interface ContentTxtMng {
	public ContentTxt save(ContentTxt txt, Content content);

	public ContentTxt update(ContentTxt txt, Content content);
}