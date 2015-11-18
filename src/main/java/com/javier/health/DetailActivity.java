package com.javier.health;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.javier.health.models.User;
import com.javier.health.utils.Constants;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        User result = extras.getParcelable(Constants.PARCELABLE);
        initiateUI(result);
    }

    /**
     * this method was created for initing  UI element
     */
    private void initiateUI(User userResult) {
        TextView nameTextView = (TextView) findViewById(R.id.activity_detail_first_name_text_view);
        TextView surnameTextView = (TextView) findViewById(R.id.activity_detail_surname_text_view);
        TextView addressTextView = (TextView) findViewById(R.id.activity_detail_address_text_view);
        TextView phoneNumberTextView = (TextView) findViewById(R.id.activity_detail_phone_number_text_view);
        TextView emailTextView = (TextView) findViewById(R.id.activity_detail_email_text_view);
        TextView createdAtTextView = (TextView) findViewById(R.id.activity_detail_createdAt_text_view);
        TextView updatedAtTextView = (TextView) findViewById(R.id.activity_detail_updatedAt_text_view);

        nameTextView.setText(userResult.getFirstName());
        surnameTextView.setText(String.valueOf(userResult.getSurname()));
        addressTextView.setText(userResult.getAddress());
        phoneNumberTextView.setText(userResult.getPhoneNumber());
        emailTextView.setText(String.valueOf(userResult.getEmail()));
        createdAtTextView.setText(userResult.getCreatedAt());
        updatedAtTextView.setText(userResult.getUpdatedAt());
    }

    @Override
    public void onBackPressed()
    {
        cameback();
    }

    /**
     * this method was created for animation between activities
     */
    public void cameback()
    {
        finish();
        overridePendingTransition(R.anim.right, R.anim.left);
    }
}
