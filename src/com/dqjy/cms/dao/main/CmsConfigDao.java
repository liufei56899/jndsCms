package com.dqjy.cms.dao.main;

import com.dqjy.cms.entity.main.CmsConfig;
import com.dqjy.common.hibernate3.Updater;

public interface CmsConfigDao {
	public CmsConfig findById(Integer id);

	public CmsConfig updateByUpdater(Updater<CmsConfig> updater);
}