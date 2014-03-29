package com.example.adapters;

import com.example.utils.Variables;
import com.example.voztruyen.R;
import com.example.voztruyen.R.drawable;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StoryAdapter extends ArrayAdapter<String> {
	private Context context;
	private String[] stories;

	public StoryAdapter(Context context, int textViewResourceId,
			String[] stories) {
		super(context, textViewResourceId, stories);
		this.context = context;
		this.stories = stories;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.activity_main, parent, false);
		ImageView iv = (ImageView) rowView.findViewById(R.id.ivIcon);
		TextView tv1 = (TextView) rowView.findViewById(R.id.tvTitle);
		TextView tv2 = (TextView) rowView.findViewById(R.id.tvArtist);
		iv.setImageResource(Variables.ICONS[position]);
		tv1.setText(Variables.STORIES[position]);
		tv2.setText(Variables.ARTIST[position]);
		//rowView.setBackgroundColor(drawable.expand);
		return rowView;
	}

}
