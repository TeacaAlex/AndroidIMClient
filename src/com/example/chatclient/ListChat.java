package com.example.chatclient;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListChat extends Activity {
	ArrayList<Friend> friends = new ArrayList<Friend>();
	FriendListAdapter adapter = null;
	
	
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_chat);
        
        populateList();
        
        ListView listView = (ListView)findViewById(R.id.list);
        adapter = new FriendListAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClick);
    }
    
    
    
    class FriendListAdapter extends ArrayAdapter<Friend> {
		public FriendListAdapter() {
			super(ListChat.this, R.layout.friendlist, friends);
		}
		
		public View getView(int position, View convertView, ViewGroup parent) {
			View row = convertView;
			FriendHolder holder = null;
			
			if(row == null) {
				LayoutInflater inflater = getLayoutInflater();
				row = inflater.inflate(R.layout.friendlist, null);
				holder = new FriendHolder(row);
				row.setTag(holder);
			}
			else
				holder = (FriendHolder) row.getTag();
			holder.populateFrom(friends.get(position));
			return row;
		}
	}
	
	class FriendHolder {
		private TextView username = null;
		private ImageView icon = null;
		
		public FriendHolder(View row) {
			username = (TextView) row.findViewById(R.id.username);
			icon = (ImageView) row.findViewById(R.id.icon);
		}
		
		void populateFrom(Friend friend) {
			username.setText(friend.getUserName());
			String status = friend.getStatus();
			if(status.equals("on")) {
				icon.setImageResource(R.drawable.green);
			}
			else {
				icon.setImageResource(R.drawable.red);
			}
		}
	}
	
	public void populateList() {
    	//TO DO fa rost de lista de prieteni
    	for(int i = 0 ; i < 30 ; i ++) {
    		if(i%2 == 0)
    			friends.add(new Friend("Friend " + i, "ip", "port", "on"));
    		else
    			friends.add(new Friend("Friend " + i, "ip", "port", "off"));
    	}
    }
	
	private AdapterView.OnItemClickListener onListClick=new AdapterView.OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Friend friend = friends.get(position);
			Intent i = new Intent(ListChat.this, Window.class);
			i.putExtra("ACTORS", "alex" + "`" + friend.getUserName());
			startActivity(i);
			//ListChat.this.finish();
		}
	};
}
	
	
