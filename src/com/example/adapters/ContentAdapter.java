package com.example.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.models.RssItem;
import com.example.utils.Variables;
import com.example.voztruyen.R;

public class ContentAdapter extends ArrayAdapter<RssItem> {
	private Context context;
	private List<RssItem> items;
	private int ivIcon;

	public ContentAdapter(Context context, int ivIcon, List<RssItem> items) {
		super(context, ivIcon, items);
		this.context = context;
		this.items = items;
		this.ivIcon = ivIcon;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.layout_content, parent, false);
		ImageView iv = (ImageView) rowView.findViewById(R.id.ivIconContent);
		TextView tv = (TextView) rowView.findViewById(R.id.llContent);
		iv.setImageResource(ivIcon);
		tv.setText(items.get(position).getTitle());

		return rowView;
	}
}