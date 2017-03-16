package com.admin.retrofitjsonplaceholder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.admin.retrofitjsonplaceholder.presenter.PhotoPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RecyclerView recyclerView;
    Button btnGetdata;
    private PhotoPresenter photoPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        photoPresenter = new PhotoPresenter(this, recyclerView);
        btnGetdata = (Button) findViewById(R.id.btnGetData);
        btnGetdata.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        photoPresenter.fetchData();
    }
}
