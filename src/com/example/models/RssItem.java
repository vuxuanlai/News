package com.example.models;

public class RssItem {
	private String title;
	private String description;
	private String link;
	private String date;

	public void setLink(String link) {
		this.link = link;
	}

	public String getLink() {
		return link;
	}

	public String getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
