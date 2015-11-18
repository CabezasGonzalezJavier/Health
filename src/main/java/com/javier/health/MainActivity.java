package com.javier.health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.javier.health.controller.UserController;
import com.javier.health.controller.UserControllerFactory;
import com.javier.health.models.User;
import com.javier.health.utils.Constants;
import com.javier.health.utils.Utils;
import com.javier.health.view.UserAdapter;
import com.javier.health.webservices.UserResponseListener;

import java.util.List;

public class MainActivity extends AppCompatActivity implements UserResponseListener, AdapterView.OnItemClickListener {

    private static final String sTag = "MainActivity";
    private UserController mUserController;
    ListView mListView;
    List<User> mUserlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserControllerFactory.setResponseListerner(this);
        mListView = (ListView) findViewById(R.id.activity_main_list_view);

        mUserController= UserControllerFactory.getUserController();
        mUserController.request();

        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onSuccess(List<User> list) {
        Log.d(sTag, "onSuccess");
        mUserlist = list;
        UserAdapter adapter = new UserAdapter(this, list);
        mListView.setAdapter(adapter);
    }

    @Override
    public void onError(String errorResponse) {
        Log.d(sTag, "errorResponse");
        if (Utils.isOnline(MainActivity.this)) {
            Toast.makeText(MainActivity.this, R.string.activity_main_invalid_field, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, R.string.activity_main_check_your_connection, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra(Constants.PARCELABLE, mUserlist.get(position));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
