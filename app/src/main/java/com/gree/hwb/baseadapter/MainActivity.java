package com.gree.hwb.baseadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.gree.hwb.baseadapter.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		List<ItemBean> itemList = new ArrayList<>();
		for (int i = 0; i < 30; i++)
		{
			itemList.add(new ItemBean(R.mipmap.ic_launcher,"内容"+i,"标题"+i));
		}
		ListView listView = (ListView) findViewById(R.id.lv_item);
		listView.setAdapter(new MyAdapter(MainActivity.this,itemList));
	}
}
