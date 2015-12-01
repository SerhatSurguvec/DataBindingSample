package com.example.serhat.databindingex.View;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.serhat.databindingex.R;
import com.example.serhat.databindingex.databinding.ActivityMenuBinding;

/**
 * Created by Serhat on 01/12/15.
 */
public class MenuActivity extends AppCompatActivity implements MenuActivityInterface {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMenuBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_menu);
        binding.setHandler(this);
    }

    @Override
    public void onRecyclerViewClicked(View view) {
        Intent i = new Intent(MenuActivity.this, RecyclerViewActivity.class);
        ActivityCompat.startActivity(this, i, null);
    }
}
