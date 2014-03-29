package com.example.voztruyen;

import com.example.utils.Variables;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsActivity extends Activity {
	private WebView webview;
	private String link;
	private ProgressDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.article);
		Bundle bundle = getIntent().getExtras();
		setTitle(R.string.app_name);
		String link = bundle.getString(Variables.LINK);
		webview = (WebView) findViewById(R.id.wvNews);
		webview.getSettings().setSupportZoom(true);
		webview.setInitialScale(1);
		webview.getSettings().setLoadWithOverviewMode(true);
		webview.getSettings().setUseWideViewPort(true);
		webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		webview.setScrollbarFadingEnabled(false);
		webview.setWebViewClient(new VozWebViewClient());
		dialog = ProgressDialog.show(this, "", "Loading...");
		new NewsTask().execute();
	}

	class NewsTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			webview.loadUrl(link);
			return null;
		}

	}

	class VozWebViewClient extends WebViewClient {

		@Override
		public void onPageFinished(WebView view, String url) {
			if (dialog != null) {
				dialog.dismiss();
			}
			super.onPageFinished(view, url);
		}

	}

}
