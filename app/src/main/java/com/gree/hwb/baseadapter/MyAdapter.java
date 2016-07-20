package com.gree.hwb.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gree.hwb.baseadapter.bean.ItemBean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
public class MyAdapter extends BaseAdapter
{
	public List<ItemBean> mItemList;
	LayoutInflater mInflater;//布局装载器
	public MyAdapter(Context context,List<ItemBean> mList)
	{
		this.mItemList = mList;
		mInflater = LayoutInflater.from(context);//contex要使用当前Adapter界面对象
	}

	//适配器中数据个数
	@Override
	public int getCount()
	{
		return mItemList.size();
	}

	//获取数据集中制定索引位置的数据项
	@Override
	public Object getItem(int i)
	{
		return mItemList.get(i);
	}

	//获取指定行对应的id
	@Override
	public long getItemId(int i)
	{
		return i;
	}

	//获取每一个item的显示内容
	@Override
	public View getView(int i, View convertview, ViewGroup viewGroup)
	{

		//逗逼式：此种方法完全未利用Listview的缓存机制************************************
		//无论缓存中是否有view均重新创建
		/*View view = mInflater.inflate(R.layout.item_layout,null);//使用item_layout填充view

		//关联控件
		ImageView imageView = (ImageView) view.findViewById(R.id.iv_item);
		TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
		TextView tvContext = (TextView) view.findViewById(R.id.tv_content);

		//设置控件的内容
		imageView.setImageResource(mItemList.get(i).itemImageResId);
		tvTitle.setText(mItemList.get(i).itemTitle);
		tvContext.setText(mItemList.get(i).itemContent);
		//逗逼式：此种方法完全未利用Listview的缓存机制*************************************/

		//标准式：此种方法完全利用Listview的缓存机制************************************
		/*if(convertview ==null)
		{
			convertview = mInflater.inflate(R.layout.item_layout,null);
		}
		ImageView imageView = (ImageView) convertview.findViewById(R.id.iv_item);
		TextView tvTitle = (TextView) convertview.findViewById(R.id.tv_title);
		TextView tvContext = (TextView) convertview.findViewById(R.id.tv_content);

		//设置控件的内容
		imageView.setImageResource(mItemList.get(i).itemImageResId);
		tvTitle.setText(mItemList.get(i).itemTitle);
		tvContext.setText(mItemList.get(i).itemContent);
		//标准式：此种方法完全利用Listview的缓存机制*************************************/

		//文艺式：避免重复使用findviewByid**********************************
		//使用iewHolderv类实现
		ViewHolder viewHolder;
		if (convertview == null)
		{
			viewHolder = new ViewHolder();
			convertview = mInflater.inflate(R.layout.item_layout,null);
			viewHolder.imageView = (ImageView) convertview.findViewById(R.id.iv_item);
			viewHolder.tvContext = (TextView) convertview.findViewById(R.id.tv_content);
			viewHolder.tvTitle = (TextView) convertview.findViewById(R.id.tv_title);
			convertview.setTag(viewHolder);//将contentView与viewHolder关联
		} else
		{
			viewHolder = (ViewHolder) convertview.getTag();//在viewHolder中直接去用不用每次都findviewById
		}

		//设置控件的内容
		viewHolder.imageView.setImageResource(mItemList.get(i).itemImageResId);
		viewHolder.tvTitle.setText(mItemList.get(i).itemTitle);
		viewHolder.tvContext.setText(mItemList.get(i).itemContent);


		return convertview;
	}

	class ViewHolder
	{
		ImageView imageView;
		TextView tvTitle;
		TextView tvContext;
	}
	//文艺式：避免重复使用findviewByid**********************************
}
