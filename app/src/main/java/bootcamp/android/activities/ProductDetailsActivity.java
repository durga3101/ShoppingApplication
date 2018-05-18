package bootcamp.android.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import bootcamp.android.R;
import bootcamp.android.constants.Constants;
import bootcamp.android.models.Product;
import bootcamp.android.presenter.ProductDetailsPresenter;
import bootcamp.android.view.ProductDetailsView;

public class ProductDetailsActivity extends Activity implements ProductDetailsView {

    private ProductDetailsPresenter productDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);

        Bundle productDetails = getIntent().getExtras();
        String title = productDetails.getString(Constants.TITLE_KEY);
        String description = productDetails.getString(Constants.DESCRIPTION_KEY);
        String imageUrl = productDetails.getString(Constants.IMAGE_URL_KEY);

        productDetailsPresenter = new ProductDetailsPresenter(this);
        productDetailsPresenter.renderProduct(title, description,imageUrl);
    }


    @Override
    public void renderProduct(Product product) {
        TextView imageTitle = (TextView) findViewById(R.id.product_title);
        imageTitle.setText(product.getTitle());

        TextView issueDescription = (TextView) findViewById(R.id.product_description);
        issueDescription.setText(product.getDescription());

        ImageView imageView = (ImageView) findViewById(R.id.product_image);
        Picasso.get().load(product.getImageUrl()).into(imageView);
    }
}
