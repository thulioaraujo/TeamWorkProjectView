package com.teamwork.projectview.ui.project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.teamwork.projectview.R;
import com.teamwork.projectview.data.entities.Project;
import com.teamwork.projectview.util.Util;

import java.util.ArrayList;

/**
 * TeamWorkProjectView - Technical Test
 *
 * Created by Thulio Araujo on 3/5/2018.
 */

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ViewHolder> {

    private ArrayList<Project> mProjects;
    private Context mContext;
    private ProjectListAdapterListener mProjectListAdapterListener;

    public ProjectListAdapter(ArrayList<Project> projects, Context context, ProjectListAdapterListener projectListAdapterListener) {
        this.mProjects = projects;
        this.mContext = context;

        // Coupling the lister to the context
        this.mProjectListAdapterListener = projectListAdapterListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_project, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Project project = mProjects.get(position);

        if (project != null) {
            if (project.getLogo() != null && !"".equals(project.getLogo())) {
                Picasso.with(mContext)
                        .load(project.getLogo())
                        .placeholder(R.drawable.progress_animation)
                        .error(R.mipmap.logo_error)
                        .into(holder.projectLogo);
            }

            holder.projectName.setText(project.getName());
            holder.companyName.setText(project.getCompany().getName());

            if (project.getStartDate() != null && !"".equals(project.getStartDate()) &&
                    project.getEndDate() != null && !"".equals(project.getEndDate())) {
                String startDate = Util.formatStringDate(project.getStartDate());
                String endDate = Util.formatStringDate(project.getEndDate());
                holder.projectDate.setText(startDate + " - " + endDate);
            } else {
                holder.projectDate.setText("/  /   -    /  /");
            }

            if (project.getStatus().equals(Project.ProjectStatus.ACTIVE.getValue())) {
                holder.projectStatus.setText(project.getStatus());
                holder.projectStatus.setBackgroundColor(ContextCompat.getColor(mContext, R.color.activeProjectColor));
            } else if (project.getStatus().equals(Project.ProjectStatus.ARCHIVED.getValue())) {
                holder.projectStatus.setText(project.getStatus());
                holder.projectStatus.setBackgroundColor(ContextCompat.getColor(mContext, R.color.archivedProjectColor));
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mProjectListAdapterListener.onHandleSelection(position, project);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mProjects.size();
    }

    /**
     * ViewHolder
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView projectName;
        private TextView companyName;
        private ImageView projectLogo;
        private TextView projectStatus;
        private TextView projectDate;

        public ViewHolder(View itemView) {
            super(itemView);

            this.projectName = itemView.findViewById(R.id.txt_project_name);
            this.companyName = itemView.findViewById(R.id.txt_company_name);
            this.projectLogo = itemView.findViewById(R.id.img_project_logo);
            this.projectStatus = itemView.findViewById(R.id.project_status);
            this.projectDate = itemView.findViewById(R.id.txt_project_date);
        }

        @Override
        public void onClick(View view) {

        }
    }
}