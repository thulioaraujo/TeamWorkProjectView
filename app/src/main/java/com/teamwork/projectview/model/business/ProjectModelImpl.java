package com.teamwork.projectview.model.business;

import android.app.Application;

import com.teamwork.projectview.model.dao.ProjectDAO;
import com.teamwork.projectview.model.entities.Projects;
import com.teamwork.projectview.util.Logger;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * TeamWorkProjectView - Technical Test
 *
 * This class implements methods which retrieves data related to the
 * {@link com.teamwork.projectview.model.entities.Project }
 *
 * Created by Thulio Araujo on 3/1/2018.
 */

public class ProjectModelImpl implements ProjectModel {

    private final Application application;
    private Logger logger = Logger.getLogger(getClass());

    public ProjectModelImpl(Application application) {
        this.application = application;
    }

    @Override
    public Observable<Projects> fetchAllProject(ProjectDAO projectDAO) {
        return projectDAO.getAllProject()
                .flatMap(new Function<Projects, ObservableSource<Projects>>() {

                    @Override
                    public ObservableSource<Projects> apply(Projects projects) throws Exception {
                        return Observable.just(projects);
                    }
                })
                .onErrorReturn(new Function<Throwable, Projects>() {
                    @Override
                    public Projects apply(Throwable throwable) throws Exception {
                        return null;
                    }
                });
    }
}
