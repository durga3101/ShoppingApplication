package bootcamp.android.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import bootcamp.android.R;

public class ProductActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        TextView titleTextView = findViewById(R.id.title);
        TextView descriptionTextView = findViewById(R.id.description);

        titleTextView.setText(getIntent().getStringExtra("title"));
        descriptionTextView.setText(getIntent().getStringExtra("description"));
    }

}
