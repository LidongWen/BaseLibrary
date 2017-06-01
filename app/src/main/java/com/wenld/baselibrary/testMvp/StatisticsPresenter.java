package com.wenld.baselibrary.testMvp;

import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by wenld on 2017/6/1.
 */

public class StatisticsPresenter implements StatisticsContract.Presenter {

    private final StatisticsContract.View mStatisticsView;

    public StatisticsPresenter(
                               @NonNull StatisticsContract.View statisticsView) {
        mStatisticsView = checkNotNull(statisticsView, "StatisticsView cannot be null!");

        mStatisticsView.setPresenter(this);
    }

    @Override
    public void start() {
        loadStatistics();
    }

    private void loadStatistics() {
        mStatisticsView.setProgressIndicator(true);


                // The view may not be able to handle UI updates anymore
                if (!mStatisticsView.isActive()) {
                    return;
                }
                mStatisticsView.setProgressIndicator(false);

                mStatisticsView.showStatistics(2, 1);



                // The view may not be able to handle UI updates anymore
                if (!mStatisticsView.isActive()) {
                    return;
                }
                mStatisticsView.showLoadingStatisticsError();
    }
}