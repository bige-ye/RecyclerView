package com.monster.recyclerviewtest.adapter;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.monster.recyclerviewtest.R;

public class SimpleAdapter extends RecyclerView.Adapter<MyViewHolder> {
	private LayoutInflater mInflater;
	private Context mContext;
	protected List<String> mDatas;

	public SimpleAdapter(Context context, List<String> datas) {
		this.mContext = context;
		this.mDatas = datas;
		mInflater = LayoutInflater.from(context);
	}

	public void addData(int pos){
		mDatas.add(pos,"添加的Item");
		notifyItemInserted(pos);
	}
	
	public void deleteData(int pos){
		mDatas.remove(pos);
		notifyItemRemoved(pos);
	}
	
	public interface OnItemClickListener{
		void onItemClick(View view, int position);
		void onItemLongClick(View view, int position);
	}
	private OnItemClickListener mOnItemClickListener;
	
	public void setOnItemClickListener(OnItemClickListener listener){
		this.mOnItemClickListener = listener;
	}
	@Override
	public int getItemCount() {
		return mDatas.size();
	}

	@Override
	public void onBindViewHolder(final MyViewHolder holder, final int pos) {// 绑定ViewHolder
		holder.tv.setText(mDatas.get(pos));
		setUpItemEvent(holder);
	}

	protected void setUpItemEvent(final MyViewHolder holder) {
		if(mOnItemClickListener != null){
			holder.itemView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					if(mOnItemClickListener != null){
						int layoutPosition = holder.getLayoutPosition();
						mOnItemClickListener.onItemClick(holder.itemView, layoutPosition);
					}
				}
			});
			holder.itemView.setOnLongClickListener(new OnLongClickListener() {
				@Override
				public boolean onLongClick(View v) {
					int layoutPosition = holder.getLayoutPosition();
					mOnItemClickListener.onItemLongClick(holder.itemView, layoutPosition);
					return false;
				}
			});
		}
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {// 创建ViewHolder
		View view = mInflater.inflate(R.layout.item_single_textview, arg0,
				false);
		MyViewHolder viewHolder = new MyViewHolder(view);
		return viewHolder;
	}

}

class MyViewHolder extends ViewHolder {
	TextView tv;

	public MyViewHolder(View arg0) {
		super(arg0);
		tv = (TextView) arg0.findViewById(R.id.id_tv);
	}
}
