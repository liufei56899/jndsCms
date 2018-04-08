package com.dqjy.cms.dao.main;

import com.dqjy.cms.entity.main.CmsUserResume;
import com.dqjy.common.hibernate3.Updater;

public interface CmsUserResumeDao {
	public CmsUserResume findById(Integer id);

	public CmsUserResume save(CmsUserResume bean);

	public CmsUserResume updateByUpdater(Updater<CmsUserResume> updater);
}