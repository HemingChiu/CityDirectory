package com.jayqiu.citydirectory;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;


public class MainActivity extends Activity {

	private ExpandableListView mLvAddress;
	private ArrayList<AddressProvincesEntity> addressProvincesList;
	private GoodsAddressAdapter goodsAddressAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_goods_addre);
		initViews();
		initEvents();
		initData();
	}

	private void initData() {
		addressProvincesList = new ArrayList<AddressProvincesEntity>();
		for (int i = 0; i < 5; i++) {
			AddressProvincesEntity addressProvincesEntity = new AddressProvincesEntity();
			addressProvincesEntity.setProvinces("省份" + i);
			ArrayList<GoodsAddressEntity> addressArrayList = new ArrayList<GoodsAddressEntity>();
			for (int j = 0; j < 15; j++) {
				GoodsAddressEntity addressEntity = new GoodsAddressEntity();
				addressEntity.setAddress("省份" + i + "城市" + j);
				addressArrayList.add(addressEntity);
			}
			addressProvincesEntity.setAddressEntity(addressArrayList);
			addressProvincesList.add(addressProvincesEntity);
		}
		goodsAddressAdapter = new GoodsAddressAdapter(MainActivity.this,
				addressProvincesList);
		mLvAddress.setAdapter(goodsAddressAdapter);

	}

	private void initViews() {
		mLvAddress = (ExpandableListView) findViewById(R.id.elv_goods_address);
		mLvAddress.setGroupIndicator(null);
	}

	private void initEvents() {

	}

}
