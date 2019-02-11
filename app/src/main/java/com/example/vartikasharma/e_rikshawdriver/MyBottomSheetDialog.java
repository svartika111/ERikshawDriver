package com.example.vartikasharma.e_rikshawdriver;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by prongbang on 3/19/2017.
 */

public class MyBottomSheetDialog extends BottomSheetDialog implements View.OnClickListener {

    private ImageView ivAvatar;
    private TextView ivClose;
    private TextView tvTitle;
    private TextView tvSubTitle;
    private Context context;
    private RelativeLayout retry;
    @SuppressLint("StaticFieldLeak")
    private static MyBottomSheetDialog instance;

    public static MyBottomSheetDialog getInstance(@NonNull Context context) {
        return instance == null ? new MyBottomSheetDialog(context) : instance;
    }

    public MyBottomSheetDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        create();
    }

    public void create() {
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);
        setContentView(bottomSheetView);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());
        BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                // do something
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // do something
            }
        };

     //   ivAvatar = (ImageView) bottomSheetView.findViewById(R.id.ivAvatar);
        ivClose = (TextView) bottomSheetView.findViewById(R.id.ivClose);
        tvTitle = (TextView) bottomSheetView.findViewById(R.id.tvTitle);
        tvSubTitle = (TextView) bottomSheetView.findViewById(R.id.tvSubTitle);

      //  ivAvatar.setOnClickListener(this);
        ivClose.setOnClickListener(this);
        tvTitle.setOnClickListener(this);

    }

 //   public void setIvAvatar(String url) {
   //     ImageUtil.loadImageFromUrl(context, url, ivAvatar);
   // }

    public void setTvTitle(String tvTitle) {
        this.tvTitle.setText(tvTitle);
    }

    public void setTvSubTitle(String tvSubTitle) {
        this.tvSubTitle.setText(tvSubTitle);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvTitle:
//                hide();
                break;
            case R.id.ivClose:
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialogrequest);
                dialog.setTitle("Title...");

                // set the custom dialog components - text, image and button


                retry = (RelativeLayout) dialog.findViewById(R.id.retrybutton);
                // if button is clicked, close the custom dialog
                retry.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                hide();
                break;
           // case R.id.ivAvatar:
//                hide();
             //   break;
        }
    }
}
