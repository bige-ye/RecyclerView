package com.monster.recyclerviewtest.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
/**
 * �ٲ�����adapter
 */
public class StaggeredAdapter extends SimpleAdapter {

	private List<Integer> mHeights;

	public StaggeredAdapter(Context context, List<String> datas) {
		super(context, datas);
		mHeights = new ArrayList<Integer>();
		//��������ø߶�
		for (int i = 0; i < mDatas.size(); i++) {
			mHeights.add((int) (100 + Math.random() * 300));
		}
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, int pos) {// ��ViewHolder
		LayoutParams layoutParams = holder.itemView.getLayoutParams();
		layoutParams.height = mHeights.get(pos);
		holder.itemView.setLayoutParams(layoutParams);
		holder.tv.setText(mDatas.get(pos));
		setUpItemEvent(holder);
	}

}