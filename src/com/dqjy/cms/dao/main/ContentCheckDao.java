package com.dqjy.cms.dao.main;

import com.dqjy.cms.entity.main.ContentCheck;
import com.dqjy.common.hibernate3.Updater;

public interface ContentCheckDao {
	public ContentCheck findById(Long id);

	public ContentCheck save(ContentCheck bean);

	public ContentCheck updateByUpdater(Updater<ContentCheck> updater);
}