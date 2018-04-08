package com.dqjy.cms.manager.main;

import com.dqjy.cms.entity.main.CmsSite;
import com.dqjy.cms.entity.main.CmsSiteCompany;

public interface CmsSiteCompanyMng {
	public CmsSiteCompany save(CmsSite site,CmsSiteCompany bean);

	public CmsSiteCompany update(CmsSiteCompany bean);
}