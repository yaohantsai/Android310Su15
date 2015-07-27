package com.uw.android310.lesson6.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageView;

import com.uw.android310.lesson6.R;
import com.uw.android310.lesson6.model.ImageUpload;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.imageview)
    ImageView mUploadImage;

    @Bind(R.id.editText_upload_title)
    EditText mUploadTitle;

    @Bind(R.id.editText_upload_desc)
    EditText mUploadDesc;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
    }
}
