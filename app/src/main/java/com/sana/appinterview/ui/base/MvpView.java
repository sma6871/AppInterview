package com.sana.appinterview.ui.base;


/**
 * Base interface that any class that wants to act as a View in the MVP (Model View Presenter)
 * pattern must implement. Generally this interface will be extended by a more specific interface
 * that then usually will be implemented by an Activity or Fragment.
 */
public interface MvpView {
    void showError(String message);
    void showError(int messageId);
    void showMessageInfo(int messageId);
    void showMessageSuccess(int messageId);
    void showMessageInfo(String message);
    void showMessageSuccess(String message);
    void showLoading();

    void hideLoading();

}
