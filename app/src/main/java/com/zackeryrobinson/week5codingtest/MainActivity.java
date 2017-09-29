package com.zackeryrobinson.week5codingtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

// 1. Create an application to use the Flickr api.  You can use the following endpoint to
//    get the images http://api.flickr.com/services/feeds/photos_public.gne?tag=kitten&format=json&nojsoncallback=1
// 2. Screen 1: Should show a recycler view with all the images from the api.
//    Each ItemView should have a thumbnail of the image and two more fields.
// 3. On Clicking long press on each item a dialog box with two options will appear.
//    “Show full image” and “Show small image”. You can add options to the array in an xml
//    and pass to the dialog.
//    https://developer.android.com/guide/topics/ui/dialogs.html#AddingAList
// 4. “Show full image” will start a new activity and cover the whole screen with the
//     passed picture.
// 5. “Show small image” will show the image in a dialog in the same activity.
public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RecyclerViewAdapter adapter;
    RecyclerView.LayoutManager mLayoutManager;
    private static final int DATASET_COUNT = 60;
    private enum LayoutManagerType {
        LINEAR_LAYOUT_MANAGER
    }
    protected LayoutManagerType mCurrentLayoutManagerType;
    protected String[] mDataset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDataset();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        adapter = new RecyclerViewAdapter(mDataset, null, null);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(adapter);
        int scrollPosition = 0;
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);

    }


    private void initDataset() {
        mDataset = new String[DATASET_COUNT];
        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataset[i] = "This is element #" + i;
        }
    }


}
