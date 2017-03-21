package com.example.liz.calcu;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.icu.text.NumberFormat.getCurrencyInstance;

public class MainActivity extends AppCompatActivity {
    int quantity =2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display(quantity);
    }
    //order按钮更新数量和价格
    public void submitOrder(View view){
        String priceMessage = "$"+quantity*5;
        displayMessage(priceMessage);
    }
    //加号按钮
    public void increment(View view){
        quantity++;
        display(quantity);
    }
    //减号按钮
    public void decrement(View view){
        quantity--;
        display(quantity);
    }
    public void reset(View view){
        quantity = 0;
        display(quantity);
        displayMessage("$0");
    }
    //更新价格框方法
    @SuppressLint("NewApi")
    public void displayPrice(int number){
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(getCurrencyInstance().format(number));
    }
    //更新数量方法
    public void display(int quantity){
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+quantity);
    }
    public void displayMessage(String message){
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}
