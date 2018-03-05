package com.teamwork.projectview.ui.project;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.teamwork.projectview.ProjectViewApplication;
import com.teamwork.projectview.R;
import com.teamwork.projectview.data.dao.ProjectDAO;
import com.teamwork.projectview.data.entities.Project;
import com.teamwork.projectview.di.components.ProjectComponent;
import com.teamwork.projectview.ui.base.BaseActivity;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ProjectActivity extends BaseActivity implements ProjectContract.View {

    @Inject
    ProjectPresenter mProjectPresenter;

    @Inject
    ProjectDAO mProjectDAO;

    private CompositeDisposable mCompositeDisposable;
    private ProjectListAdapter projectListAdapter;
    private RecyclerView projectListRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ProgressBar progressBarProject;

    @Override
    protected void setupActivity(ProjectComponent projectComponent, Bundle savedInstanceState) {
        setContentView(R.layout.activity_project_view);
        ((ProjectViewApplication) getApplication()).getProjectComponent().inject(this);
        mProjectPresenter.attachView(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initializes the recycler view
        this.projectListRecyclerView = findViewById(R.id.rv_project_list);
        this.projectListRecyclerView.setHasFixedSize(true);
        this.projectListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        this.mLayoutManager = new LinearLayoutManager(this);
        this.projectListRecyclerView.setLayoutManager(mLayoutManager);

        // Initializes the progress bar
        this.progressBarProject = findViewById(R.id.project_progress);

        mCompositeDisposable = new CompositeDisposable();
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_project_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void init() {
        showHideProgress(true);
        mProjectPresenter.setProjectList(mProjectDAO, mCompositeDisposable);
    }

    @Override
    public void loadView() {

    }

    @Override
    public void showHideProgress(final boolean visibility) {
        int shortAnimTime = getResources().getInteger(android.R.integer.config_mediumAnimTime);

        projectListRecyclerView.setVisibility(visibility ? View.GONE : View.VISIBLE);
        projectListRecyclerView.animate().setDuration(shortAnimTime).alpha(
                visibility ? 0 : 1).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                projectListRecyclerView.setVisibility(visibility ? View.GONE : View.VISIBLE);
            }
        });

        progressBarProject.setVisibility(visibility ? View.VISIBLE : View.GONE);
        progressBarProject.animate().setDuration(shortAnimTime).alpha(
                visibility ? 1 : 0).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                progressBarProject.setVisibility(visibility ? View.VISIBLE : View.GONE);
            }
        });
    }

    @Override
    public void setAdapter(ArrayList<Project> projectList) {
        if (projectList != null && projectList.size() > 0) {
            // Creates the adapter and set it to the Recycler View
            this.projectListAdapter = new ProjectListAdapter(projectList, this);
            this.projectListRecyclerView.setAdapter(this.projectListAdapter);
        }
    }

    @Override
    public void showDialogErrorMessage(String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        //cancel
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void openListActivity() {

    }
}
