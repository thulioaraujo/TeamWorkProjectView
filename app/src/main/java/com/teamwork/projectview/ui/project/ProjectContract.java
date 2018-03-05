package com.teamwork.projectview.ui.project;

import com.teamwork.projectview.ui.base.BasePresenter;
import com.teamwork.projectview.ui.base.BaseView;

/**
 * TeamWorkProjectView - Technical Test
 *
 * Created by Thulio Araujo on 3/4/2018.
 */

public interface ProjectContract {

    interface View extends BaseView<Presenter> {

        void init();

        void loadView();

        void showProgress();

        void hideProgress();

        void openListActivity();
    }

    interface Presenter extends BasePresenter<View> {

        void attachView(ProjectContract.View baseView);

        void detachView();
    }
}
