package com.dqjy.cms.manager.main.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dqjy.cms.dao.main.ChannelExtDao;
import com.dqjy.cms.entity.main.Channel;
import com.dqjy.cms.entity.main.ChannelExt;
import com.dqjy.cms.manager.main.ChannelExtMng;
import com.dqjy.common.hibernate3.Updater;

@Service
@Transactional
public class ChannelExtMngImpl implements ChannelExtMng {
	public ChannelExt save(ChannelExt ext, Channel channel) {
		channel.setChannelExt(ext);
		ext.setChannel(channel);
		ext.init();
		dao.save(ext);
		return ext;
	}

	public ChannelExt update(ChannelExt ext) {
		Updater<ChannelExt> updater = new Updater<ChannelExt>(ext);
		updater.include(ChannelExt.PROP_FINAL_STEP);
		updater.include(ChannelExt.PROP_AFTER_CHECK);
		ChannelExt entity = dao.updateByUpdater(updater);
		entity.blankToNull();
		return entity;
	}

	private ChannelExtDao dao;

	@Autowired
	public void setDao(ChannelExtDao dao) {
		this.dao = dao;
	}
}