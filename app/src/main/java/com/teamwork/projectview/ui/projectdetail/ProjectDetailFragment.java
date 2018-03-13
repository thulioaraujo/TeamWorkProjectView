package com.teamwork.projectview.ui.projectdetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teamwork.projectview.R;
import com.teamwork.projectview.data.entities.Project;
import com.teamwork.projectview.util.SystemConstants;
import com.teamwork.projectview.util.component.FullScreenDialogContent;
import com.teamwork.projectview.util.component.FullScreenDialogController;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * TeamWorkProjectView - Technical Test
 *
 * Created by Thulio Araujo on 3/13/2018.
 */

public class ProjectDetailFragment extends Fragment implements FullScreenDialogContent {

    private FullScreenDialogController dialogController;

    @BindView(R.id.lbl_project_name)
    TextView lblPropjectName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.project_detail_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, getView());

        Project project = (Project) this.getArguments().getSerializable(SystemConstants.PROJECT_DETAIL);
        lblPropjectName.setText(project.getName());
    }

    @Override
    public void onDialogCreated(FullScreenDialogController dialogController) {
        this.dialogController = dialogController;
    }

    @Override
    public boolean onConfirmClick(FullScreenDialogController dialogController) {
        return false;
    }

    @Override
    public boolean onDiscardClick(FullScreenDialogController dialogController) {
        dialogController.discard();
        return true;
    }

    @Override
    public boolean onExtraActionClick(MenuItem actionItem, FullScreenDialogController dialogController) {
        return false;
    }
}
