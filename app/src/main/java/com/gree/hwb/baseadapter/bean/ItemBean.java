package com.gree.hwb.baseadapter.bean;

/**
 * Created by Administrator on 2016/7/13.
 */
public class ItemBean
{
	public int itemImageResId ;
	public String itemTitle;
	public String itemContent;

	public ItemBean(int itemImageResId, String itemContent, String itemTitle)
	{
		this.itemImageResId = itemImageResId;
		this.itemContent = itemContent;
		this.itemTitle = itemTitle;
	}
}
