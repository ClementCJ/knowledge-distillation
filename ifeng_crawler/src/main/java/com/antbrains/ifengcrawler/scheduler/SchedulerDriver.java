package com.antbrains.ifengcrawler.scheduler;

import com.antbrains.mysqltool.PoolManager;
import com.antbrains.sc.scheduler.FileUnfinishedScheduler;

public class SchedulerDriver {

	public static void main(String[] args) throws Exception {
		PoolManager.StartPool("conf", "baidumusic");
		FileUnfinishedScheduler.main(args);
	}

}
