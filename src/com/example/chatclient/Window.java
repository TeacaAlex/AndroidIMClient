package com.example.chatclient;

import java.util.ArrayList;
import java.util.List;

import com.example.chatclient.ListChat.FriendListAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Window extends Activity {
	
	
	private EditText msg;
	private Button send;
	private String expeditor = "Eu";
	private String destinatar = "El";
	
	
	private List<Message> messages;
	WindowAdapter adapter1 = null;
	private ArrayAdapter<Message> adapter=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window);
        
        Bundle extras = getIntent().getExtras();
        String value = extras.getString("ACTORS");
        String values[] = value.split("`");
        if(values.length != 0) {
        	expeditor = values[0];
        	destinatar = values[1];
        }
        
        
        msg = (EditText)findViewById(R.id.message);
        
        send = (Button)findViewById(R.id.send);
        send.setOnClickListener(onSend);
        
        
        ListView list = (ListView)findViewById(R.id.msgs);
        messages = new ArrayList<Message>();
        adapter1 = new WindowAdapter();
        list.setAdapter(adapter1);
        
        //adapter=new ArrayAdapter<Message>(this, android.R.layout.simple_list_item_1, messages);
        //list.setAdapter(adapter);
    }
    
    class WindowAdapter extends ArrayAdapter<Message> {
		public WindowAdapter() {
			super(Window.this, android.R.layout.simple_list_item_1, messages);
		}
    }
    
    
    
    private View.OnClickListener onSend = new View.OnClickListener() {
		
		public void onClick(View v) {
			String msgToSend = msg.getText().toString();
			if(!msgToSend.equals("")) {
				sendMessage(new Message(msgToSend, expeditor));
			}
		}
	};
	
	public void sendMessage(Message newMsg) {
		adapter1.add(newMsg);
		msg.setText("");
		getMessage(new Message(newMsg.getMessage(), destinatar));
	}
	
	public void getMessage(Message newMsg) {
		adapter1.add(newMsg);
	}
	
}
