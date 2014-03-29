package com.example.voztruyen;

import java.util.List;

import com.example.adapters.CategoryAdapter;
import com.example.models.RssItem;
import com.example.utils.RssParser;
import com.example.utils.Variables;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ListView;

public class CategoryActivity extends ListActivity {
	private int story;
	private ProgressDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		Bundle bundle = getIntent().getExtras();
		story = bundle.getInt(Variables.STORY);
		setTitle(Variables.STORIES[story]);
		CategoryAdapter adapter = new CategoryAdapter(this,
				Variables.ICONS[story], Variables.CATEGORIES[story]);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		int key = story * 1000 + position;
		if (Variables.newsMap.get(key) == null) {
			dialog = ProgressDialog.show(this, "", "Loading "
					+ Variables.CATEGORIES[story][position]);
			new CategoryTask().execute(position);
		} else {
			Intent intent = new Intent(CategoryActivity.this,
					NewListActivity.class);
			intent.putExtra(Variables.STORY, story);
			intent.putExtra(Variables.CATEGORY, position);
			startActivity(intent);
		}
	}

	class CategoryTask extends AsyncTask<Integer, Void, Void> {
		private int position;

		@Override
		protected Void doInBackground(Integer... params) {
			position = params[0];
			int key = story * 1000 + position;
			RssParser parser = new RssParser();
			List<RssItem> items = parser
					.getNewsList(Variables.LINKS[story][position]);
			// System.out.println("Rss size: " + items.size());
			Variables.newsMap.put(key, items);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			if (dialog != null) {
				dialog.dismiss();
			}
			Intent intent = new Intent(CategoryActivity.this,
					NewListActivity.class);
			intent.putExtra(Variables.STORY, story);
			intent.putExtra(Variables.CATEGORY, position);

			startActivity(intent);
			super.onPostExecute(result);
		}
	}

}
