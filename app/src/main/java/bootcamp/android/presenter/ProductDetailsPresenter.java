package bootcamp.android.presenter;

import bootcamp.android.models.Product;
import bootcamp.android.view.ProductDetailsView;


public class ProductDetailsPresenter {

    private final ProductDetailsView view;
    Product product;

    public ProductDetailsPresenter(ProductDetailsView view) {
        this.view = view;
    }

    public void getProduct(String title, String description, String imageUrl) {
        product = new Product(title, description, imageUrl);
        view.renderProduct(product);
    }

    public void sendProductAndNavigateToBack() {
        view.addToCart(product);
    }
}
