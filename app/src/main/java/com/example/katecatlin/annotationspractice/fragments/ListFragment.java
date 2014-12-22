package com.example.katecatlin.annotationspractice.fragments;

import android.app.Fragment;
import android.os.Bundle;

import org.androidannotations.annotations.EFragment;

/**
 * Created by katecatlin on 12/17/14.
 */
@EFragment
public class ListFragment extends Fragment{

    public static ListFragment newInstance() {
        final String ARG_SUBREDDIT = "arg_subreddit";

        Bundle args = new Bundle();

        ListFragment subredditListFragment = new ListFragment();
        subredditListFragment.setArguments(args);

        return subredditListFragment;
    }





}
