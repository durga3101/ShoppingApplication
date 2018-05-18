package bootcamp.android.presenters;

import android.support.annotation.NonNull;

import java.util.List;

import bootcamp.android.models.Product;
import bootcamp.android.repositories.ProductRepository;
import bootcamp.android.views.ShoppingItemsListView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShoppingItemsListPresenter {
    private final ShoppingItemsListView view;
    private final ProductRepository productRepository;

    public ShoppingItemsListPresenter(ShoppingItemsListView view, ProductRepository productRepository) {
        this.view = view;
        this.productRepository = productRepository;
    }

    public void init() {
        productRepository.getProducts(productsCallback());
    }

    @NonNull
    private Callback<List<Product>> productsCallback() {
        return new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                view.displayProductList(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                view.displayErrorMessage();
            }
        };
    }
}
