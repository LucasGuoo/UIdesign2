package com.example.uidesign2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    boolean useLinearLayout;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    GridLayoutManager gridLayoutManager;



    /**
     * 调用 super.onCreate(savedInstanceState) 来初始化 Activity。

     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//调用 super.onCreate(savedInstanceState) 来初始化 Activity。
        setContentView(R.layout.activity_main);// 设置 Activity 的布局为 activity_main。

        ArrayList<Fruit> fruits = geneFruitData();//调用 geneFruitData() 方法生成一个 Fruit 对象的 ArrayList，并将其存储在 fruits 变量中。
        ArrayList<String> fruitsInfo = new ArrayList<>();//创建一个新的 ArrayList<String>，命名为 fruitsInfo，用于存储 Fruit 对象序列化后的 JSON 字符串。
        Gson gson = new Gson();//初始化 Gson 对象，用于将 Fruit 对象转换为 JSON 字符串。
        for(int i = 0; i < fruits.size(); i++){//使用一个 for循环遍历 fruits 列表，并将每个 Fruit 对象转换为 JSON 字符串，然后将这些字符串添加到 fruitsInfo 列表中。
        Fruit fruit = fruits.get(i);
        String data = gson.toJson(fruit);
        fruitsInfo.add(data);
        }



        recyclerView = findViewById(R.id.recyclerView);//从布局中查找 RecyclerView 实例，并为其设置布局管理器（LinearLayoutManager）。
        layoutManager = new LinearLayoutManager(MainActivity.this);
        gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        if( !useLinearLayout){
            recyclerView.setLayoutManager(layoutManager);
        }else{
            recyclerView.setLayoutManager(gridLayoutManager);
        }

        MYAdapter myAdapter = new MYAdapter(fruitsInfo);//创建一个新的 MYAdapter 实例，并将 fruitsInfo 列表作为参数传递给它。
        recyclerView.setAdapter(myAdapter);//将 MYAdapter 设置为 RecyclerView 的适配器。
    }

    /**
     * 这个函数封装了所有水果的数据，并返回了一个水果类型的链表
     * @return
     */
    ArrayList<Fruit> geneFruitData(){
        ArrayList<Fruit> fruits = new ArrayList<>();
        Fruit apple = new Fruit("苹果", "apple", 4, R.drawable.apple,"温带水果之王",
                "红苹果，青苹果\n味道酸甜真不错\n你一个，我一个\n脸蛋红润像苹果");
        fruits.add(apple);
        Fruit pear = new Fruit("梨", "pear", 1, R.drawable.pear, "百果之宗",
                "我是一只大鸭梨\n雪白的果肉甜如蜜\n小朋友呀快洗手\n手不干净我不理");
        fruits.add(pear);
        Fruit orange = new Fruit("橙子", "orange", 1, R.drawable.orange, "疗疾佳果",
                "橙子园，橙子大\n像灯笼，枝头挂\n摘一个，尝一尝\n青的酸，红的甜");
        fruits.add(orange);
        Fruit lemon = new Fruit("柠檬", "lemon", 3, R.drawable.lemon, "柠檬酸仓库",
                "小柠檬大营养\n中间鼓鼓两头尖\n咬一口，酸掉牙\n口气清新要靠它");
        fruits.add(lemon);
        Fruit strawberry = new Fruit("草莓", "strawberry", 1, R.drawable.strawberry, "水果皇后",
                "小草莓，红艳艳\n芝麻点，满身长\n绿小帽，头上戴\n咬一口，酸甜甜");
        fruits.add(strawberry);
        Fruit mango = new Fruit("芒果", "mango", 1, R.drawable.mango, "热带果王",
                "芒果香，芒果甜\n有营养，我爱吃\n红芒果，绿芒果\n小朋友，爱芒果");
        fruits.add(mango);
        Fruit peach = new Fruit("桃子", "peach", 3, R.drawable.peach, "天下第一果",
                "大桃子，真好看\n底下圆来上头尖\n粉粉绿绿颜色鲜\n吃来汁多味道甜\n小朋友们真喜欢");
        fruits.add(peach);
        Fruit avocado = new Fruit("牛油果", "avocado", 3, R.drawable.avovado, "森林奶油",
                "它的皮肤会变色\n有时绿，有时黑\n热带气候中生长\n寒冷气候不耐受\n小浆果，大营养\n不是蔬菜是水果");
        fruits.add(avocado);
        Fruit cherry = new Fruit("樱桃", "cherry", 2, R.drawable. cherry, "早春第一果",
                "樱桃樱桃甜又香\n红彤彤啊圆滚滚\n长大高高的枝头\n一颗一颗挨一起\n好像美丽的宝石");
        fruits.add(cherry);
        Fruit watermelon = new Fruit("西瓜", "watermelon", 2, R.drawable.watermelon, "盛夏之王",
                "西瓜西瓜圆又圆\n红瓤黑子在里边\n打来井水镇一镇\n吃到嘴里凉又甜");
        fruits.add(watermelon);
        Fruit banana = new Fruit("香蕉","banana",1, R.drawable.banana, "智慧之果",
                "小香蕉，真奇怪\n像月牙，不上天\n 像小船，不下海\n像鱼儿，真可爱\n一游游到我嘴里\n又香又甜真痛快");
        fruits.add(banana);
        Fruit pitaya = new Fruit("火龙果", "pitaya", 4, R.drawable.pitaya, "芝麻果",
                "火龙果，吉祥果\n红棉袄，绿卷发\n白肚皮，芝麻点\n美容养颜味道好");
        fruits.add(pitaya);
        Fruit grape = new Fruit("葡萄", "grape", 3, R.drawable.grape, "菩提子",
                "葡萄葡萄你真好\n扒开绿叶对人笑\n滴溜圆，水灵灵\n像珍珠，像玛瑙\n摘一粒，吃一口\n蜜汁满嘴角\n营养价值高\n香甜味道好");
        fruits.add(grape);
        Fruit kiwifruit = new Fruit("猕猴桃", "kiwifruit", 2, R.drawable.kiwifruit, "水果之王",
                "猕猴桃，鸡蛋大\n果肉籽儿像芝麻\n用刀一下切两半\n果肉软软可甜啦\n大人小孩都爱吃");
        fruits.add(kiwifruit);
        Fruit pineapple = new Fruit("菠萝", "pineapple", 2, R.drawable.pineapple, "水果中的维生素明星",
                "头顶绿色小辫\n身穿黄色罗衣\n外形虽然粗糙\n甘甜藏在心里");
        fruits.add(pineapple);
        return fruits;
    }

    /**
     * 重写方法，绑定菜单栏样式layout
     * @param menu The options menu in which you place your items.
     *
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 重写方法，管理菜单栏的具体控件
     * @param item The menu item that was selected.
     *
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId ==R.id.switchview){
            switchview();
        }
        if(itemId == R.id.add){

        }
        return super.onOptionsItemSelected(item);
    }

    public void switchview(){
        if(useLinearLayout){
            recyclerView.setLayoutManager(layoutManager);
        }else{
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        useLinearLayout = !useLinearLayout;
    }
}