package com.example.katecatlin.annotationspractice.activities.base_activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.example.katecatlin.annotationspractice.R;
import com.example.katecatlin.annotationspractice.interfaces.ProgressDialogHelper;
import com.example.katecatlin.annotationspractice.utils.ActivityStateUtil;
import com.example.katecatlin.annotationspractice.utils.NetworkUtil;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;

/**
 * Created by katecatlin on 12/22/14.
 */
@EActivity
public abstract class BaseActivity extends ActionBarActivity implements ProgressDialogHelper {

    public static Activity currentActivity;

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        checkNoInternet();
        currentActivity = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (currentActivity == this) {
            currentActivity = null;
        }
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @UiThread
    @Override
    public void showProgressDialog(String message) {
        if (!ActivityStateUtil.isActivityValid(this)) {
            return;
        }

        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
        }

        progressDialog.setMessage(message);
        progressDialog.show();
    }

    @UiThread
    @Override
    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing() && ActivityStateUtil.isActivityValid(this)) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @UiThread(delay = 1000)
    protected void delayFinish() {
        finish();
        overridePendingTransition(0, 0);
    }

    private void checkNoInternet() {
        if (!NetworkUtil.checkInternetConnection()) {
            Log.d("LOG_TAG", "IT'S WORKING");
//            NoInternetActivity_.intent(this).flags(Intent.FLAG_ACTIVITY_NEW_TASK).goToTabs(false).start();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
}
