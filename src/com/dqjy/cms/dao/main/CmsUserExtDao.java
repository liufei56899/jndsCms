package com.dqjy.cms.dao.main;

import com.dqjy.cms.entity.main.CmsUserExt;
import com.dqjy.common.hibernate3.Updater;

public interface CmsUserExtDao {
	public CmsUserExt findById(Integer id);

	public CmsUserExt save(CmsUserExt bean);

	public CmsUserExt updateByUpdater(Updater<CmsUserExt> updater);
	
	public CmsUserExt deleteById(Integer id);
}