package com.teamwork.projectview.ui.base;

/**
 * TeamWorkProjectView - Technical Test
 *
 * This interface represents the Base View
 *
 * Created by Thulio Araujo on 3/1/2018.
 */

public interface BaseView<T> {

    void showHideProgress(final boolean visibility);

    void showDialogErrorMessage(final String message);

}
