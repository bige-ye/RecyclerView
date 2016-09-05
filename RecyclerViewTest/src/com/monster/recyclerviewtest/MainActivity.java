package com.monster.recyclerviewtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.monster.recyclerviewtest.adapter.SimpleAdapter;
import com.monster.recyclerviewtest.adapter.SimpleAdapter.OnItemClickListener;

public class MainActivity extends Activity {
	private RecyclerView mRecyclerView;
	private List<String> mDatas;
	private SimpleAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initDatas();
		initViews();
		mAdapter = new SimpleAdapter(this, mDatas);
		mRecyclerView.setAdapter(mAdapter);
		// 设置RecyclerView的布局管理
		LinearLayoutManager layoutManager = new LinearLayoutManager(this,
				LinearLayoutManager.VERTICAL, false);
		mRecyclerView.setLayoutManager(layoutManager);
		// 设置RecyclerView的Item间分割线
//		 mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
//		 DividerItemDecoration.VERTICAL_LIST));
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		
		mAdapter.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemLongClick(View view, int position) {
				Toast.makeText(MainActivity.this, "LongClick"+position, 0).show();
			}
			
			@Override
			public void onItemClick(View view, int position) {
				Toast.makeText(MainActivity.this, "Click"+position, 0).show();
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
		case R.id.action_add:
			mAdapter.addData(1);
			break;
		case R.id.action_delete:
			mAdapter.deleteData(1);
			break;
		case R.id.action_listview:
			mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
			break;

		case R.id.action_gridview:
			mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
			break;
		case R.id.action_hor_gridview:
			mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,
					StaggeredGridLayoutManager.HORIZONTAL));
			break;
		case R.id.action_staggered:
			Intent intent = new Intent(this, StaggeredGridLayoutActivity.class);
			startActivity(intent);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}