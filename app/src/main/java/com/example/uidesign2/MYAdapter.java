package com.example.uidesign2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Adapter 适配器，是数据与RecyclerView之间的桥梁，用来管理RecyclerView
 * 通常我们自定义适配器，需要继承自RecyclerView.Adapter，并且指定一个自定义的ViewHolder作为泛型参数，也就是这里的参数
 * 通过指定 MyViewHolder 作为泛型类型，确保 onCreateViewHolder 方法返回的 ViewHolder 必须是 MyViewHolder 类型或其子类型
 * 这防止了错误地将其他类型的 ViewHolder 与你的适配器一起使用
 */
public class MYAdapter extends RecyclerView.Adapter<MYAdapter.MyViewHolder> {

    /**
     * 用一个链表保存水果数据
     * string类型而不是fruit是为了方便Jason传输
     */
    ArrayList<String> fruitsInfo ;

    /**
     * 初始化适配器，同时初始fruitInfo,此时应该拿到所有水果的数据
     * @param fruitsInfo
     */
    public MYAdapter(ArrayList<String> fruitsInfo) {
        this.fruitsInfo = fruitsInfo;
    }

    @NonNull
    /**
     * 使用 LayoutInflater 从 parent.getContext() 获取一个布局填充器实例。
     * 使用该填充器将 item_view_linear 布局填充到一个新的 View 对象中。
     * 这里，false 作为第三个参数意味着新创建的视图不会立即附加到父视图上，这通常是 onCreateViewHolder 所期望的。
     * 使用这个新填充的视图来创建一个 MyViewHolder 实例。
     * 返回新创建的 MyViewHolder 实例。
     */
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_linear,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    /**
     * 控件的绑定，把具体信息绑定到各个子项，并给每个单独的子项设计一个事件监听，弹出popupmenu
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    String data = fruitsInfo.get(position);//从 fruitsInfo 列表中获取指定 position 的字符串数据。
    Gson gson = new Gson();//使用 Gson 将字符串反序列化为 Fruit 对象。
    Fruit fruit = gson.fromJson(data,Fruit.class);

    Context context = holder.itemView.getContext();//获取当前项视图的上下文，并使用它来加载与 Fruit 对象关联的 Drawable 资源。
    Drawable photo = AppCompatResources.getDrawable(context,fruit.getPhotoId());

    holder.imageViewPhoto.setImageDrawable(photo);//设置 imageViewPhoto 的图片为加载的 Drawable

    holder.textViewName.setText(fruit.getName());//更新其他视图（如 textViewName, textViewEnglish, textViewNo）以显示 Fruit 对象的信息。
    holder.textViewEnglish.setText(fruit.getEnglish());
    holder.textViewNo.setText(String.valueOf(position + 1));

    //点击查看更多信息
    holder.imageViewReadMore.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        //点击后会触发的事务
            Toast.makeText(context,"查看更多",Toast.LENGTH_SHORT).show();
        }
    });

    //holder的事件监听，弹出popupmenu
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            PopupMenu popupMenu = new PopupMenu(context, holder.itemView);
            popupMenu.inflate(R.menu.popup_menu);
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    //选项的具体操作
                    return false;
                }
            });
            popupMenu.setGravity(Gravity.END);
            popupMenu.show();
        }
    });

    }

    /**
     * 这个方法告诉 RecyclerView 有多少项数据需要显示。
     * @return
     */
    @Override
    public int getItemCount() {
        return fruitsInfo.size();
    }

    /**
     * 定义内部类，继承自ViewHolder,视图持有者，负责管理子项视图
     */
    class MyViewHolder extends RecyclerView.ViewHolder{
        /**
         * 属性根据视图的具体控件来定义，可以和具体控件的id同名
         */
        ImageView imageViewPhoto, imageViewReadMore;
        TextView textViewName,textViewEnglish, textViewNo;

        /**
         * 通过传入的itemView拿到前子项中的数据
         * @param itemView 当前的视图
         */
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);//调用父类构造器，创建当前view的holder
            imageViewPhoto = itemView.findViewById(R.id.imageViewPhoto);
            imageViewReadMore = itemView.findViewById(R.id.imageButtonReadMore);
            textViewEnglish = itemView.findViewById(R.id.textViewEnglish);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewNo = itemView.findViewById(R.id.textViewNo);
        }
    }
}
