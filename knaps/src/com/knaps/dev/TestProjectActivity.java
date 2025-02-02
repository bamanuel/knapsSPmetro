package com.knaps.dev;

import java.io.IOException;
import java.util.ArrayList;

import com.knaps.dev.R;
import com.knaps.dev.DAL.DataAccess;
import com.knaps.dev.Models.AlertSubject;
import com.knaps.dev.Utilities.AppPrefs;
import com.knaps.dev.Utilities.Constants;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;

public class TestProjectActivity extends Activity {
	private final static String TAG = "TestProjectActivity";	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Save AS to preferences to be referenced by any newly created object!
        AlertSubject alertSubject  = new AlertSubject();
        AppPrefs appPrefs = new AppPrefs(getApplicationContext());
        appPrefs.saveObsSubject(alertSubject, Constants.ALERT_SUBJECT);
        
        setContentView(R.layout.main);
        openDataBase();
        
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        
        //Launch the list activity
        Button listButton = (Button)findViewById(R.id.list_button);
        //tv.setText(R.string.db_check);
        listButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {				
				Intent showLines = new Intent(TestProjectActivity.this, DisplayLines.class);
				startActivity(showLines);
			}
		});
    }

    private void openDataBase(){
    	DataAccess dbHelper = new DataAccess(TestProjectActivity.this);
		try{
			dbHelper.createDataBase();
		}
		catch (IOException e) {
			Log.e("OpenDB", "DB Failed to load:", e);
		}	
    }
    @Override
    protected void onStart(){
    	super.onStart();
    	TextView tv = (TextView)findViewById(R.id.DBsuccessTextView);
    	Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    	tv.setText(R.string.db_check);
    }
    @Override
    protected void onResume(){
    	super.onResume();
    	Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart(){
    	super.onRestart();
    	Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause(){
    	Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    	super.onPause();
    }
    @Override
    protected void onStop(){
    	Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    	super.onStop();
    }
    @Override 
    protected void onDestroy(){
    	Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    	super.onDestroy();
    }
}