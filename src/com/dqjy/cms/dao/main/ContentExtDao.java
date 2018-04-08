package com.dqjy.cms.dao.main;

import com.dqjy.cms.entity.main.ContentExt;
import com.dqjy.common.hibernate3.Updater;

public interface ContentExtDao {
	public ContentExt findById(Integer id);

	public ContentExt save(ContentExt bean);

	public ContentExt updateByUpdater(Updater<ContentExt> updater);
}