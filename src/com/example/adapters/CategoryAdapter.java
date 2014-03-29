package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.utils.Variables;
import com.example.voztruyen.R;

public class CategoryAdapter extends ArrayAdapter<String> {
	private Context context;
	private String[] categories;
	private int ivIcon;

	public CategoryAdapter(Context context, int ivIcon, String[] categories) {
		super(context, ivIcon, categories);
		this.context = context;
		this.categories = categories;
		this.ivIcon = ivIcon;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.list_chaper, parent, false);
		ImageView iv = (ImageView) rowView.findViewById(R.id.ivIconChap);
		TextView tv1 = (TextView) rowView.findViewById(R.id.tvChap);
		//TextView tv2 = (TextView) rowView.findViewById(R.id.tvArtist);
		iv.setImageResource(ivIcon);
		tv1.setText(categories[position]);
		//tv2.setText(Variables.ARTIST[position]);

		return rowView;
	}

}
