package bootcamp.android.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.net.URL;
import java.util.List;

import bootcamp.android.R;
import bootcamp.android.adapters.ShoppingItemsListAdapter;
import bootcamp.android.models.Product;
import bootcamp.android.repositories.ProductRepository;

public class ShoppingItemsListingActivity extends Activity {

    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading");
        progressDialog.show();

        DownloadFilesTask downloadFilesTask = new DownloadFilesTask(this);
        downloadFilesTask.execute();
    }

    public void onFetch(List<Product> products) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        ShoppingItemsListAdapter productArrayAdapter = new ShoppingItemsListAdapter(products);
        recyclerView.setAdapter(productArrayAdapter);
        progressDialog.dismiss();
    }


    class DownloadFilesTask extends AsyncTask<Void, Integer, List<Product>> {
        private final ShoppingItemsListingActivity activity;

        DownloadFilesTask(ShoppingItemsListingActivity activity) {
            this.activity = activity;
        }

        @Override
        public List<Product> doInBackground(Void... urls) {
            ProductRepository productRepository = new ProductRepository();
            return productRepository.getProducts();
        }


        @Override
        protected void onPostExecute(List<Product> products) {
            super.onPostExecute(products);
            activity.onFetch(products);
        }
    }
}
