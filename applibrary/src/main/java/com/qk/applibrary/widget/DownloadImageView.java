package com.qk.applibrary.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import net.tsz.afinal.FinalBitmap;
import net.tsz.afinal.bitmap.core.BitmapDisplayConfig;
import net.tsz.afinal.bitmap.display.Displayer;

/**
 * 下载图片控件
 */
public class DownloadImageView extends ImageView {
	private Context mContext;
	private FinalBitmap finalBitmap;

	public DownloadImageView(Context context) {
		super(context);
		mContext = context;
		init();
	}

	public DownloadImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs,defStyle);
		mContext = context;
		init();
	}

	public DownloadImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		init();
		// TODO Auto-generated constructor stub
	}
	
	private void init() {
		finalBitmap = FinalBitmap.create(mContext);
	}

	/**
	 * 加载网络图片
	 * @param picUrl  图片下载地址
	 */
	public void loadNetworkPic(String picUrl) {
		finalBitmap.display(this, picUrl);

	}

	/**
	 * 加载本地图片
	 * @param picFilePath  图片文件路径
	 */
	public void loadNativePic(String picFilePath) {
		Bitmap bm = BitmapFactory.decodeFile(picFilePath);
		if(bm != null) {
			setImageBitmap(bm);
		}
	}


}
