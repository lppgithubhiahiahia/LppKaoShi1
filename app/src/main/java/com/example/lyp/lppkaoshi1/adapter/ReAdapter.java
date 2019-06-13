package com.example.lyp.lppkaoshi1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lyp.lppkaoshi1.R;
import com.example.lyp.lppkaoshi1.beans.MyBeans;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class ReAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<MyBeans.ResultBean> list;

    private ArrayList<Integer> banners;

    public ReAdapter(Context context, ArrayList<MyBeans.ResultBean> list, ArrayList<Integer> banners) {
        this.context = context;
        this.list = list;
        this.banners = banners;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if (i==0){
            View view=View.inflate(context,R.layout.one_item,null);

            Holder1 holder1 = new Holder1(view);

            return holder1;
        }else if (i==1){

            View view=View.inflate(context,R.layout.two_item,null);

            Holder2 holder2 = new Holder2(view);

            return holder2;

        }else if (i==2){

            View view=View.inflate(context,R.layout.three_item,null);

            Holder3 holder3 = new Holder3(view);

            return holder3;
        }else {

            View view=View.inflate(context,R.layout.four_item,null);

            Holder4 holder4 = new Holder4(view);

            return holder4;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        int type = getItemViewType(i);

        MyBeans.ResultBean bean = list.get(i);

        if (type==0){

            final Holder1 holder1= (Holder1) viewHolder;

            holder1.banner.setImages(banners).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {

                    Glide.with(context).load(path).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher)).into(imageView);

                }
            }).start();


        }else if (type==1){

            Holder2 holder2= (Holder2) viewHolder;

            holder2.two_title.setText(bean.getName());

            Glide.with(context).load(bean.getHeader()).into(holder2.two_iv);

            holder2.two_content.setText(bean.getText());

        }else if (type==2){

            Holder3 holder3= (Holder3) viewHolder;

            holder3.three_title.setText(bean.getName());

            Glide.with(context).load(bean.getHeader()).into(holder3.three_iv1);
            Glide.with(context).load(bean.getHeader()).into(holder3.three_iv2);

            holder3.three_content.setText(bean.getText());

        }else if (type==3){

            Holder4 holder4= (Holder4) viewHolder;

            holder4.four_title.setText(bean.getName());

            Glide.with(context).load(bean.getHeader()).into(holder4.four_iv1);
            Glide.with(context).load(bean.getHeader()).into(holder4.four_iv2);
            Glide.with(context).load(bean.getHeader()).into(holder4.four_iv3);

            holder4.four_content.setText(bean.getText());

        }


    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    @Override
    public int getItemViewType(int position) {

        if (position==0){

            return 0;
        }else {

            if (position%4==1){
                return 1;
            }else if (position%4==2){
                return 2;
            }else if (position%4==3){

                return 3;
            }

        }

        return super.getItemViewType(position);
    }

    public class Holder1 extends RecyclerView.ViewHolder{

        private Banner banner;
        public Holder1(@NonNull View itemView) {
            super(itemView);

            banner=itemView.findViewById(R.id.banner);
        }
    }
    public class Holder2 extends RecyclerView.ViewHolder{

        private TextView two_title;
        private ImageView two_iv;
        private TextView two_content;
        public Holder2(@NonNull View itemView) {
            super(itemView);
            two_title=itemView.findViewById(R.id.two_title);
            two_iv=itemView.findViewById(R.id.two_iv);
            two_content=itemView.findViewById(R.id.two_content);
        }
    }
    public class Holder3 extends RecyclerView.ViewHolder{

        private TextView three_title;
        private ImageView three_iv1;
        private ImageView three_iv2;
        private TextView three_content;
        public Holder3(@NonNull View itemView) {
            super(itemView);
            three_title=itemView.findViewById(R.id.three_title);
            three_iv1=itemView.findViewById(R.id.three_iv1);
            three_iv2=itemView.findViewById(R.id.three_iv2);

            three_content=itemView.findViewById(R.id.three_content);
        }
    }
    public class Holder4 extends RecyclerView.ViewHolder{
        private TextView four_title;
        private ImageView four_iv1;
        private ImageView four_iv2;
        private ImageView four_iv3;
        private TextView four_content;
        public Holder4(@NonNull View itemView) {
            super(itemView);

            four_title=itemView.findViewById(R.id.four_title);
            four_iv1=itemView.findViewById(R.id.four_iv1);
            four_iv2=itemView.findViewById(R.id.four_iv2);
            four_iv3=itemView.findViewById(R.id.four_iv3);

            four_content=itemView.findViewById(R.id.four_content);
        }
    }
    

    public interface MyOn{

        void onClick(int i,MyBeans.ResultBean resultBean);
    }
}
