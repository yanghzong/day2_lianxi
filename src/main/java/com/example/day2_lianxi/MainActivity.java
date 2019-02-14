package com.example.day2_lianxi;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_circle)
    Button btnCircle;
    @BindView(R.id.btn_yuanjiao)
    Button btnYuanjiao;
    @BindView(R.id.btn_bili)
    Button btnBili;
    @BindView(R.id.btn_gif)
    Button btnGif;
    @BindView(R.id.sdv_img)
    SimpleDraweeView sdvImg;
    @BindView(R.id.sdv_bili)
    SimpleDraweeView sdvBili;
    @BindView(R.id.btn_getvalue)
    Button btnGetvalue;
    @BindView(R.id.btn_fanshe)
    Button btnFanshe;
    private Uri uri;
    private Uri gifuri;
    private GenericDraweeHierarchyBuilder mBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        uri = Uri.parse("http://www.81.cn/jwgz/attachement/jpg/site351/20171026/90b11c6d6bd21b5c24af1a.jpg");
        gifuri = Uri.parse("http://img.99danji.com/uploadfile/2017/0709/20170709112056389.gif");
        mBuilder = new GenericDraweeHierarchyBuilder(getResources());
    }

    @OnClick({R.id.btn_circle, R.id.btn_yuanjiao, R.id.btn_bili, R.id.btn_gif, R.id.btn_getvalue, R.id.btn_fanshe})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_circle:
                sdvImg.setVisibility(View.VISIBLE);
                sdvBili.setVisibility(View.GONE);
                //设置形状对象,形状为圆形
                RoundingParams params = RoundingParams.asCircle();
                //把形状设置给参数对象
                GenericDraweeHierarchy rounding = mBuilder.setRoundingParams(params).build();
                //设置给图片控件
                sdvImg.setHierarchy(rounding);
                //加载图片控件
                sdvImg.setImageURI(uri);
                break;
            case R.id.btn_yuanjiao:
                sdvImg.setVisibility(View.VISIBLE);
                sdvBili.setVisibility(View.GONE);
                RoundingParams roundingParams = RoundingParams.fromCornersRadius(7f);

                GenericDraweeHierarchy build = mBuilder.setRoundingParams(roundingParams).build();
                sdvImg.setHierarchy(build);
                //加载图片控件
                sdvImg.setImageURI(uri);
                break;
            case R.id.btn_bili:
                sdvBili.setVisibility(View.VISIBLE);
                sdvBili.setAspectRatio(1.2f);
                sdvBili.setImageURI(uri);
                break;
            case R.id.btn_gif:
                sdvBili.setVisibility(View.GONE);
                AbstractDraweeController build1 = Fresco.newDraweeControllerBuilder()
                        .setUri(gifuri)
                        .setAutoPlayAnimations(true)
                        .build();
                sdvImg.setController(build1);

                break;
            case R.id.btn_getvalue:
                //获取注解的值
                boolean present = Zhujie.class.isAnnotationPresent(DraweeViewAnimortation.class);
                DraweeViewAnimortation animortation = Zhujie.class.getAnnotation(DraweeViewAnimortation.class);
                Toast.makeText(this,""+animortation.name(),Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_fanshe:
                break;
        }
    }
}
