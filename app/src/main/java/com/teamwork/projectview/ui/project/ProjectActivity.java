package com.teamwork.projectview.ui.project;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.teamwork.projectview.ProjectViewApplication;
import com.teamwork.projectview.R;
import com.teamwork.projectview.data.dao.ProjectDAO;
import com.teamwork.projectview.di.components.ProjectComponent;
import com.teamwork.projectview.ui.base.BaseActivity;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ProjectActivity extends BaseActivity implements ProjectContract.View {

    @Inject
    ProjectPresenter mProjectPresenter;

    @Inject
    ProjectDAO mProjectDAO;

    private CompositeDisposable mCompositeDisposable;

    @Override
    protected void setupActivity(ProjectComponent projectComponent, Bundle savedInstanceState) {
        setContentView(R.layout.activity_project_view);
        ((ProjectViewApplication) getApplication()).getProjectComponent().inject(this);
        mProjectPresenter.attachView(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mCompositeDisposable = new CompositeDisposable();
        init();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        mProjectPresenter.getProjectList(mProjectDAO, mCompositeDisposable);
    }

    @Override
    public void loadView() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void openListActivity() {

    }
}
