package com.teamwork.projectview.model.business;

import com.teamwork.projectview.model.dao.ProjectDAO;
import com.teamwork.projectview.model.entities.Projects;

import io.reactivex.Observable;

/**
 * TeamWorkProjectView - Technical Test
 *
 * This interface is implemented by @{@link ProjectModelImpl }
 *
 * Created by Thulio Araujo on 3/1/2018.
 */
public interface ProjectModel {

    Observable<Projects> fetchAllProject(ProjectDAO projectDAO);

}
