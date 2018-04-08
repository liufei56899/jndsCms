package com.dqjy.cms.dao.main;

import com.dqjy.cms.entity.main.ChannelTxt;
import com.dqjy.common.hibernate3.Updater;

public interface ChannelTxtDao {
	public ChannelTxt findById(Integer id);

	public ChannelTxt save(ChannelTxt bean);

	public ChannelTxt updateByUpdater(Updater<ChannelTxt> updater);
}