package com.mars.android20180105_1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //TextView tv;
    //EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("This is title");
        builder.setMessage("Hello");
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "按下了確定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "按下了取消", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("HELP", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"按下幫助紐",Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();


    }

    public void click2 (View v)
    {
        final EditText ed = new EditText(MainActivity.this);//final 關鍵字變成全區變數
        final TextView tv = (TextView)findViewById(R.id.textView);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        ed.setText(tv.getText().toString());//在顯示前先取出textview的內容,修改的時候看的到之前的文字
        builder.setView(ed);//放入editview
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv.setText(ed.getText().toString());

                Toast.makeText(MainActivity.this, "按下了確定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "按下了取消", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();//一定要加

    }


}
