package bootcamp.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import bootcamp.android.R;
import bootcamp.android.adapter.MyAdapter;
import bootcamp.android.models.Product;
import bootcamp.android.repositories.ProductRepository;

import java.util.List;

public class ShoppingItemsListingActivity extends Activity {

    private ProductRepository productRepository;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        productRepository = new ProductRepository();

        List<Product> products  = productRepository.getProducts();
//        LinearLayout layout = (LinearLayout) findViewById(R.id.listofitems);
//        LayoutInflater layoutInflater = getLayoutInflater();

//        for (Product product : products) {
//            View view = layoutInflater.inflate(R.layout.product, null);
//            TextView titleView = (TextView)view.findViewById(R.id.title);
//            titleView.setText(product.getTitle());
//            TextView descriptionView = (TextView)view.findViewById(R.id.description);
//            descriptionView.setText(product.getDescription());
//            layout.addView(view);
//        }


        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        MyAdapter mAdapter = new MyAdapter(products, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void move(Product product) {
        Intent intent = new Intent(this, ProductActivity.class);
        intent.putExtra("title", product.getTitle());
        intent.putExtra("description", product.getDescription());

        startActivity(intent);

    }
}
