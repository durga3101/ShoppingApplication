package bootcamp.android.presenters;

import android.graphics.drawable.Drawable;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import bootcamp.android.models.Product;
import bootcamp.android.repositories.ProductRepository;
import bootcamp.android.views.ShoppingItemsListView;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingItemsListPresenterTest {

    @Mock
    private ShoppingItemsListView view;
    @Mock
    private ProductRepository productRepository;

    private ShoppingItemsListPresenter presenter;

    @Before
    public void setUp() {
        presenter = new ShoppingItemsListPresenter(view, productRepository);
    }

    @Test
    public void shouldCallRepositoryForProducts() {
        presenter.init();
        verify(productRepository).getProducts(any(Callback.class));
    }

    @Test
    public void shouldGetProductDataOnSuccess() {
        final Product product = new Product("title", "des", "image");
        final List<Product> list = new ArrayList<Product>();
        list.add(product);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                final Callback<List<Product>> callback = (Callback<List<Product>>) invocation.getArgument(0);
                callback.onResponse(null, Response.success(list));
                return null;
            }
        }).when(productRepository).getProducts(any(Callback.class));

        presenter.init();

        verify(view).displayProductList(list);

    }
}
