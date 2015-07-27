package com.uw.android310.lesson6.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.uw.android310.lesson6.R;
import com.uw.android310.lesson6.model.ImageUpload;
import com.uw.android310.lesson6.util.DocumentUtils;
import com.uw.android310.lesson6.util.IntentUtils;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.imageview)
    ImageView mUploadImage;

    @Bind(R.id.editText_upload_title)
    EditText mUploadTitle;

    @Bind(R.id.editText_upload_desc)
    EditText mUploadDesc;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    /**
     * Upload object containging image and meta data
     */
    private ImageUpload mUpload;

    /**
     * Chosen file from intent
     */
    private File mChosenFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
    }

    @OnClick(R.id.imageview)
    public void onChooseImage() {
        mUploadDesc.clearFocus();
        mUploadTitle.clearFocus();
        IntentUtils.chooseFileIntent(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode != IntentUtils.FILE_PICK) {
            return;
        }

        if (resultCode != RESULT_OK) {
            return;
        }

        Uri returnUri = data.getData();
        String filePath = DocumentUtils.getPath(this, returnUri);

        //Safety check to prevent null pointer exception
        if (filePath == null || filePath.isEmpty()) {
            return;
        }

        mChosenFile = new File(filePath);

        Picasso.with(getBaseContext())
                .load(mChosenFile)
                .placeholder(R.drawable.ic_photo_library_black)
                .fit()
                .into(mUploadImage);

    }
}
