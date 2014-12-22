package com.example.katecatlin.annotationspractice.activities;

/**
 * Created by katecatlin on 12/17/14.
 */

import android.app.Activity;
import android.app.Fragment;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.TextView;

import com.example.katecatlin.annotationspractice.R;
import com.example.katecatlin.annotationspractice.fragments.ListFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.list_activity)
public class ListActivity extends Activity {

    @Extra
    String subredditChosen;

    @ViewById(R.id.title2)
    TextView textView;

    ListFragment listFragment = new ListFragment();


}
