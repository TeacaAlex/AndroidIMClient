package com.example.chatclient;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.Window;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class Login extends Activity {

	private String userId = "";
	private String password = "";
	private boolean ok;
	private int progress = 0;
	private AlertDialog alertDialog;
	private RelativeLayout loginScreen;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_login);
        
        loginScreen = (RelativeLayout)findViewById(R.id.loginScreed);
        loginScreen.setBackgroundColor(Color.GREEN);
        
        
        Bundle extras = getIntent().getExtras();
        String value = extras.getString("ID&PASS");
        String values[] = value.split("`");
        if(values.length != 0) {
        	userId = values[0];
        	password = values[1];
        }
        
        setProgressBarVisibility(true);
        progress=0;
        
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Checking...");
        alertDialog.setMessage("Verifying the username and password");
        alertDialog.show();
        new Thread(loginThread).start();
    }
    
    private void doSomeLongWork(final int incr) {
    	runOnUiThread(new Runnable() {
    		public void run() {
    			progress+=incr;
    			setProgress(progress);
    		}
    	});
    	
		SystemClock.sleep(250);
	}
	 
	private Runnable loginThread = new Runnable() {
    	public void run() {
    		for (int i=0;i<10000;i+=200) {
    			doSomeLongWork(200);
    		}
    		
    		if(!userId.equals("") && !password.equals("")) {
    			Intent i = new Intent(Login.this, ListChat.class);
    			startActivity(i);
    			Login.this.finish();
    		}
    		else {
    			Intent i = new Intent(Login.this, SignInActivity.class);
    			startActivity(i);
    			Login.this.finish();
    		}
    		
    		runOnUiThread(new Runnable() {
    			public void run() {
    				setProgressBarVisibility(false);
    			}
    		});
    	}
    };
}
