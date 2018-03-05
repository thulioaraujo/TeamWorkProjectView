package com.teamwork.projectview.ui.project;

import com.teamwork.projectview.data.entities.Project;
import com.teamwork.projectview.ui.base.BasePresenter;
import com.teamwork.projectview.ui.base.BaseView;

import java.util.ArrayList;

/**
 * TeamWorkProjectView - Technical Test
 *
 * Created by Thulio Araujo on 3/4/2018.
 */

public interface ProjectContract {

    interface View extends BaseView<Presenter> {

        void init();

        void loadView();

        void showHideProgress(final boolean visibility);

        void setAdapter(ArrayList<Project> projectList);

        void showDialogErrorMessage(final String message);

        void openListActivity();
    }

    interface Presenter extends BasePresenter<View> {

        void attachView(ProjectContract.View baseView);

        void detachView();
    }
}
