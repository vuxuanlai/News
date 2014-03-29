package com.example.utils;

import java.util.HashMap;
import java.util.List;

import com.example.models.RssItem;
import com.example.voztruyen.R;

public class Variables {
	public static final String[] STORIES = { "Vnexpress", "Em của ngày hôm qua",
			"Vẽ em bằng màu của nỗi nhớ",
			"Làm sao để thoát khỏi vòng luẩn quẩn này" };
	public static final int[] ICONS = { R.drawable.a3, R.drawable.a4,
			R.drawable.a5, R.drawable.a6 };
	public static final String[] ARTIST = { "Nguyễn Mon", "Sơn Tùng",
			"Hoàng Nhật Gia", "Nguyễn 0000000" };

	// Ngay hom qua
	public static final String[] VNEXPRESS_CATEGORIES = { "Trang chủ", "Thời sự", };
	public static final String[] VNEXPRESS_LINKS = {
			"http://vnexpress.net/rss/tin-moi-nhat.rss",
			"http://vnexpress.net/rss/thoi-su.rss" };

	// Em cua ngay hom qua
	public static final String[] EM_CATEGORIES = { "Chương 1", "Chương 2" };
	public static final String[] EM_LINKS = { "", "" };

	// Ve em bang mau noi nho
	public static final String[] VE_CATEGORIES = { "Test Ve Chương 1",
			"Chương 2" };
	public static final String[] VE_LINKS = { "", "" };

	// Lam sao de thoat....
	public static final String[] LAM_CATEGORIES = { "Lam sao Chương 1",
			"Chương 2" };
	public static final String[] LAM_LINKS = { "", "" };

	// All
	public static final String[][] CATEGORIES = { VNEXPRESS_CATEGORIES,
			EM_CATEGORIES, VE_CATEGORIES, LAM_CATEGORIES };
	public static final String[][] LINKS = { VNEXPRESS_LINKS, EM_LINKS, VE_LINKS,
			LAM_LINKS };

	public static final String STORY = "story";
	public static final String CATEGORY = "category";
	public static final String CONTENT = "content";
	public static final String LINK = "link";
	public static HashMap<Integer, List<RssItem>> newsMap = new HashMap<Integer, List<RssItem>>();
}
