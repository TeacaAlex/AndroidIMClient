package com.example.chatclient;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

public class SignInActivity extends Activity {
	
	private EditText userId;
	private EditText password;
	private TableLayout table;
	private int progress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_sign_in);
        
        userId = (EditText)findViewById(R.id.userId);
        userId.setBackgroundColor(Color.WHITE);
        
        
        
        password = (EditText)findViewById(R.id.pass);
        password.setBackgroundColor(Color.WHITE);
        table = (TableLayout)findViewById(R.id.table);
        table.setBackgroundColor(Color.GREEN);
        
        
        Button save = (Button)findViewById(R.id.login);
        save.setTextColor(Color.WHITE);
        save.setOnClickListener(onSave);
    }
    
    private View.OnClickListener onSave = new View.OnClickListener() {	
		public void onClick(View v) {
			
			String user = userId.getText().toString();
			String pass = password.getText().toString();
			
			Intent i = new Intent(SignInActivity.this, Login.class);
			i.putExtra("ID&PASS", user + "`" + pass);
			startActivity(i);
			SignInActivity.this.finish();
		}
	};
}
