package com.dqjy.cms.manager.main.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqjy.cms.dao.main.CmsUserExtDao;
import com.dqjy.cms.entity.main.CmsUser;
import com.dqjy.cms.entity.main.CmsUserExt;
import com.dqjy.cms.manager.main.CmsUserExtMng;
import com.dqjy.common.hibernate3.Updater;

@Service
@Transactional
public class CmsUserExtMngImpl implements CmsUserExtMng {
	public CmsUserExt save(CmsUserExt ext, CmsUser user) {
		ext.blankToNull();
		ext.setUser(user);
		dao.save(ext);
		return ext;
	}

	public CmsUserExt update(CmsUserExt ext, CmsUser user) {
		CmsUserExt entity = dao.findById(user.getId());
		if (entity == null) {
			entity = save(ext, user);
			user.getUserExtSet().add(entity);
			return entity;
		} else {
			Updater<CmsUserExt> updater = new Updater<CmsUserExt>(ext);
			updater.include("gender");
			updater.include("birthday");
			ext = dao.updateByUpdater(updater);
			ext.blankToNull();
			return ext;
		}
	}

	private CmsUserExtDao dao;

	@Autowired
	public void setDao(CmsUserExtDao dao) {
		this.dao = dao;
	}

	public CmsUserExt deleteById(Integer id) {
		CmsUserExt bean = dao.deleteById(id);
		return bean;
	}
}