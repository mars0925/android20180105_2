package com.mars.app_dialoglist;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int ch=-1;
    int tmp=-1 ;
    boolean[] chks = new boolean[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //list對話框
    public void click1(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        final TextView tv2 = (TextView)findViewById(R.id.textView2);//全局變數
        final String city [] = {"台中","台北","高雄","桃園"};
        builder.setItems(city, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv2.setText(city[i]);
            }
        });
        // 有加builder.setCancelable(false); 要加入取消鈕給使用者取消
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //取消內容不用寫
            }
        });
        builder.show();
        builder.setCancelable(false);//按旁邊不能取消
    }
    //單選對話框
    public void click2(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("單選列表");

        final String fruits[] = {"蘋果", "香蕉", "梨子"};
        final TextView tv3 = (TextView) findViewById(R.id.textView3);
        tmp = ch;
        //ch傳入選擇位置
        builder.setSingleChoiceItems(fruits, ch, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                    tmp = i;//選的時候就會把索引瑪給tmp
            }
        });

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ch = tmp;
                tv3.setText(fruits[ch]);

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();

    }

    //多選對話框
    public void click3 (View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("多選列表");
        final String fruits[] = {"蘋果", "香蕉", "梨子", "西瓜", "鳳梨"};
        final TextView tv4 = (TextView) findViewById(R.id.textView4);
        //chks是布林的陣列
        builder.setMultiChoiceItems(fruits, chks, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
            }
        });

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {
                StringBuilder sb = new StringBuilder();//字串累加時要用到的物件
                for (int i=0;i<=4;i++)
                {
                    if (chks[i])
                    {
                        sb.append(fruits[i] + ",");
                    }
                }
                tv4.setText(sb.toString());//StringBuilder的結果要倒出來用toString()
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

        public void click4(View v)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("this is a title");
            // LayoutInflater.from 來建立物件
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            //用inflater.inflate建立Viewiew,把先建好的layout1放到VIEW
            View v1 = inflater.inflate(R.layout.layout1,null);
            //放入v1
            builder.setView(v1);
            //重點是v1.findViewById 從v1這個view來找到id
            final TextView tv = (TextView)v1.findViewById(R.id.textView) ;
            Button  bt  = (Button) v1.findViewById(R.id.button4);
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tv.setText("HELLO world");
                }
            });

            builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // Toast.makeText(MainActivity.this, "按下了確定", Toast.LENGTH_SHORT).show();

                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.show();


        }

    }






