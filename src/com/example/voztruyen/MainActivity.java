package com.example.voztruyen;

import com.example.adapters.StoryAdapter;
import com.example.utils.Variables;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	// ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);
		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1, Variables.STORIES);
		// setListAdapter(adapter);

		StoryAdapter adapter = new StoryAdapter(this, R.id.tvTitle,
				Variables.STORIES);
		// list = (ListView) findViewById(R.id.list);
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent("com.example.voztruyen.CATEGORY");
		intent.putExtra(Variables.STORY, position);
		startActivity(intent);
	}
}
