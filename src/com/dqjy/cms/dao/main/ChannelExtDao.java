package com.dqjy.cms.dao.main;

import com.dqjy.cms.entity.main.ChannelExt;
import com.dqjy.common.hibernate3.Updater;

public interface ChannelExtDao {
	public ChannelExt save(ChannelExt bean);

	public ChannelExt updateByUpdater(Updater<ChannelExt> updater);
}