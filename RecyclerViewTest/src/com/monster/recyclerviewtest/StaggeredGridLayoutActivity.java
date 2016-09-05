package com.monster.recyclerviewtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.monster.recyclerviewtest.adapter.SimpleAdapter.OnItemClickListener;
import com.monster.recyclerviewtest.adapter.StaggeredAdapter;

public class StaggeredGridLayoutActivity extends Activity {
	private RecyclerView mRecyclerView;
	private List<String> mDatas;
	private StaggeredAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initDatas();
		initViews();
		mAdapter = new StaggeredAdapter(this, mDatas);
		mRecyclerView.setAdapter(mAdapter);
		// 设置RecyclerView的布局管理
		mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,
				StaggeredGridLayoutManager.VERTICAL));
		// 设置RecyclerView的Item间分割线
		// mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
		// DividerItemDecoration.VERTICAL_LIST));
		mAdapter.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemLongClick(View view, int position) {
				mAdapter.deleteData(position);
			}

			@Override
			public void onItemClick(View view, int position) {

			}
		});
	}

	private void initDatas() {
		mDatas = new ArrayList<String>();
		for (int i = 'A'; i <= 'z'; i++) {
			mDatas.add("" + (char) i);
		}

	}

	private void initViews() {
		mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
		}
		return super.onOptionsItemSelected(item);
	}
}