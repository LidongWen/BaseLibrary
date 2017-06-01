package com.wenld.baselibrary.testMvp;

import com.wenld.baselib.base2mvp.BasePresenter;
import com.wenld.baselib.base2mvp.BaseView;

/**
 * Created by wenld on 2017/6/1.
 */

public interface StatisticsContract {

    interface View extends BaseView<Presenter> {

        void setProgressIndicator(boolean active);

        void showStatistics(int numberOfIncompleteTasks, int numberOfCompletedTasks);

        void showLoadingStatisticsError();

        boolean isActive();
    }

    interface Presenter extends BasePresenter {

    }
}