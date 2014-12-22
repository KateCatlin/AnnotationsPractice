package com.example.katecatlin.annotationspractice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.katecatlin.annotationspractice.activities.ListActivity;
import com.example.katecatlin.annotationspractice.activities.ListActivity_;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.annotations.rest.RestService;

@EActivity(R.layout.activity_main)
public class MyActivity extends Activity {
    Context context = this;
    String MESSAGE = "MESSAGE";


    @ViewById(R.id.myInput)
    EditText myInput;

    @ViewById(R.id.title)
    TextView textView;

    @Click
    void myButton() {
        trySubredditSubmit();

        String name = myInput.getText().toString();
        textView.setText("Hello " + name);
    }

    private void trySubredditSubmit() {
        String subredditEntryText = myInput.getText().toString().trim();

        if (subredditEntryText.isEmpty()) {
            Toast.makeText(this, "No way man, it's empty!", Toast.LENGTH_SHORT).show();
        } else {
            openRedditNavigationActivity(subredditEntryText);
        }
    }

    private void openRedditNavigationActivity(String subredditEntryText) {

        ListActivity_.intent(this).subredditChosen(subredditEntryText).start();
    }
}
