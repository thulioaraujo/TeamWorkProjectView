package com.teamwork.projectview.ui.project;

import com.teamwork.projectview.data.entities.Project;

/**
 * TeamWorkProjectView - Technical Test
 *
 * Created by Thulio Araujo on 3/5/2018.
 */

public interface ProjectListAdapterListener {
    void onHandleSelection(int position, Project project);
}
