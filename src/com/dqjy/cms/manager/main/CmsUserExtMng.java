package com.dqjy.cms.manager.main;

import com.dqjy.cms.entity.main.CmsUser;
import com.dqjy.cms.entity.main.CmsUserExt;

public interface CmsUserExtMng {
	public CmsUserExt save(CmsUserExt ext, CmsUser user);

	public CmsUserExt update(CmsUserExt ext, CmsUser user);
	
	public CmsUserExt deleteById(Integer id);
}