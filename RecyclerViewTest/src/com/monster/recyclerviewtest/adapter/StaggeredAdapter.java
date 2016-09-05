package com.monster.recyclerviewtest.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
/**
 * 瀑布流的adapter
 */
public class StaggeredAdapter extends SimpleAdapter {

	private List<Integer> mHeights;

	public StaggeredAdapter(Context context, List<String> datas) {
		super(context, datas);
		mHeights = new ArrayList<Integer>();
		//随机数设置高度
		for (int i = 0; i < mDatas.size(); i++) {
			mHeights.add((int) (100 + Math.random() * 300));
		}
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, int pos) {// 绑定ViewHolder
		LayoutParams layoutParams = holder.itemView.getLayoutParams();
		layoutParams.height = mHeights.get(pos);
		holder.itemView.setLayoutParams(layoutParams);
		holder.tv.setText(mDatas.get(pos));
		setUpItemEvent(holder);
	}

}