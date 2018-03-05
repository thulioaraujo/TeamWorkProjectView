package com.teamwork.projectview.ui.base;

/**
 * TeamWorkProjectView - Technical Test
 *
 * This interface represents the Base Contract which defines the connection
 * between the view and the presenter.
 *
 * Created by Thulio Araujo on 3/1/2018.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

}
