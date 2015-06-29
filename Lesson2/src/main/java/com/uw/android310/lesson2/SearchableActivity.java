package com.uw.android310.lesson2;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.uw.android310.core.StringUtil;


public class SearchableActivity extends AppCompatActivity {
    private TextView mSearchQueryTextView;
    private Button mSearchButton;

    ShareDialog mShareDialog;

    private String mSearchQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);

        mSearchQueryTextView = (TextView) findViewById(R.id.searchQuery);
        mSearchButton = (Button) findViewById(R.id.share);

        mShareDialog = new ShareDialog(this);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ShareDialog.canShow(ShareLinkContent.class)) {
                    ShareLinkContent linkContent = new ShareLinkContent.Builder()
                            .setContentTitle("Lesson 2 - Sharing and Search")
                            .setContentDescription(
                                    "I searched for the term: " + mSearchQuery)
                            .setContentUrl(Uri.parse("https://canvas.uw.edu/courses/998075"))
                            .build();

                    mShareDialog.show(linkContent);
                }
            }
        });

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        handleIntent(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_searchable, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String searchQuery = intent.getStringExtra(SearchManager.QUERY);

            // Check if search query is valid and appropriate
            if (StringUtil.isNullOrEmpty(searchQuery) || !StringUtil.Search.isQueryStringValidAndAppropriate(searchQuery)) {
                Toast.makeText(this, "Please enter a valid search query.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Show the query on the device
            mSearchQueryTextView.setText(searchQuery);

            // Store for later use
            mSearchQuery = searchQuery;
        }
    }
}
