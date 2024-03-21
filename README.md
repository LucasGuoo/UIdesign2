# RecyclerView和OptionsMenu、PopupMenu的练习
## 列表视图RecyclerView
>### 介绍
>-  RecyclerView是ViewGroup的子类。
>- 可以通过RecyclerView创建滚动列表视图
>- 因为列表中的每个子项是可回收的（recyclable），所以
RecyclerView创建的列表视图适用于为大型数据集显示元素。
>### RecyclerView涉及到以下要素
>- 包含RecyclerView的布局文件。该布局文件用于设置整个滚动
列表的布局。
>- 显示子项视图的布局文件。该布局文件用于设置滚动列表中每个子项的布局。
>- **适配器（Adapter）**。Adapter是数据与RecyclerView之间的桥
梁，用来管理RecyclerView。
>- **视图持有者（ViewHolder）**。ViewHolder用来管理
RecyclerView中的每个子项的视图
>### 使用RecyclerView的步骤包括
>1. 创建包含RecyclerView的布局文件，如：activity_main.xml。
>2. 创建用于显示RecyclerView中每个子项视图的布局文件，如：item_view_linear.xml。
>3. 创建自定义ViewHolder，继承于RecyclerView.ViewHolder，获取子项视图中每个控件。
>4. 创建自定义Adapter，继承于RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolde
>5. 重写构造函数、onCreateViewHolder、onBindViewHolder、getItemCount。
>6. 在Activity中获取recyclerView控件，并为recyclerView设置LayoutManager和Adapter。

## 选项菜单OptionMenu
>### 创建选项菜单的步骤：
>1. 创建设置选项菜单视图的布局文件，如：options_menu.xml。
>2.  重写Activity的onCreateOptionsMenu(Menu menu)方法创建选项菜单。
>3. 重写Activity的onOptionsItemSelected(MenuItem mi)方法对选项菜单的控件实现事件监听。

## 弹出式菜单 PopupMenu
> 弹出式菜单（ PopupMenu ）会在指定组件的上方或下方弹出。
> 创建选项菜单的步骤：
> 1. 创建设置弹出式菜单视图的布局文件，如：popup_menu.xml。
> 2. 调用new PopupMenu(Context context, View anchor)创建下拉菜单，anchor代表要激发弹出菜单的组件。
> 3. 调用MenuInflater的inflate()方法设置PopupMenu的界面布局。
> 4. 对PopupMenu中的控件实现事件监听。
> 5. 调用PopupMenu的show()方法显示弹出式菜单。
