package com.example.voztruyen;

import java.util.List;

import com.example.adapters.ContentAdapter;
import com.example.models.RssItem;
import com.example.utils.Variables;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ListView;
import android.app.ListActivity;
import android.content.Intent;

public class NewListActivity extends ListActivity {
	// LinearLayout ll;
	// private int content;
	private List<RssItem> items;
	private int key;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// setContentView(R.layout.layout_content);
		Bundle bundle = getIntent().getExtras();
		int category = bundle.getInt(Variables.CATEGORY);
		int story = bundle.getInt(Variables.STORY);
		// content = bundle.getInt(Variables.CONTENT);
		setTitle(Variables.CATEGORIES[story][category]);
		key = story * 1000 + category;
		items = Variables.newsMap.get(key);
		ContentAdapter adapter = new ContentAdapter(this,
				Variables.ICONS[story], items);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(this, NewsActivity.class);
		intent.putExtra(Variables.LINK, items.get(position).getLink());
		startActivity(intent);
	}

}
