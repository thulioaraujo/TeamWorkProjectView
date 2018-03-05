package com.teamwork.projectview.ui.project;

import android.app.Application;

import com.teamwork.projectview.R;
import com.teamwork.projectview.data.dao.ProjectDAO;
import com.teamwork.projectview.data.entities.Project;
import com.teamwork.projectview.data.entities.Projects;
import com.teamwork.projectview.data.source.ProjectModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * TeamWorkProjectView - Technical Test
 *
 * Created by Thulio Araujo on 3/4/2018.
 */

public final class ProjectPresenter implements ProjectContract.Presenter {

    private final Application mApplication;
    private ProjectModel mProjectModel;

    @Nullable
    private ProjectContract.View mProjectView;

    @Inject
    public ProjectPresenter(Application application, ProjectModel projectModel) {
        this.mApplication = application;
        this.mProjectModel = projectModel;
    }

    public void setProjectList(ProjectDAO projectDAO, CompositeDisposable mCompositeDisposable){

        mCompositeDisposable.add(mProjectModel.fetchAllProject(projectDAO)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Projects>() {
                    @Override
                    public void onNext(Projects projects) {
                        List<Project> arr = projects.getProjects();

                        ArrayList<Project> projectItemList = new ArrayList<>(arr);
                        mProjectView.setAdapter(projectItemList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mProjectView.showDialogErrorMessage(mApplication.getString(R.string.error_fetch_all_projects));
                        mProjectView.showHideProgress(false);
                    }

                    @Override
                    public void onComplete() {
                        mProjectView.showHideProgress(false);
                    }
                }));
    }

    @Override
    public void attachView(ProjectContract.View view) {
        this.mProjectView = view;
    }

    @Override
    public void detachView() {
        this.mProjectView = null;
    }
}
