package com.wenld.baselibrary.testMvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wenld.baselibrary.R;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by wenld on 2017/6/1.
 */

public class StatisticsFragment extends Fragment implements StatisticsContract.View {

    private TextView mStatisticsTV;

    private StatisticsContract.Presenter mPresenter;

    public static StatisticsFragment newInstance() {
        return new StatisticsFragment();
    }

    @Override
    public void setPresenter(@NonNull StatisticsContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.statistics_frag, container, false);
        mStatisticsTV = (TextView) root.findViewById(R.id.statistics);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setProgressIndicator(boolean active) {
        if (active) {
            mStatisticsTV.setText("loading");
        } else {
            mStatisticsTV.setText("");
        }
    }

    @Override
    public void showStatistics(int numberOfIncompleteTasks, int numberOfCompletedTasks) {
        if (numberOfCompletedTasks == 0 && numberOfIncompleteTasks == 0) {
            mStatisticsTV.setText("mStatisticsTV ");
        } else {
            String displayString = "statistics_active_tasks "
                    + numberOfIncompleteTasks + "\n" +  " statistics_completed_tasks" + numberOfCompletedTasks;
            mStatisticsTV.setText(displayString);
        }
    }

    @Override
    public void showLoadingStatisticsError() {
        mStatisticsTV.setText("statistics_error");
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}