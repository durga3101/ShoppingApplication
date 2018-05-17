package bootcamp.android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import bootcamp.android.R;
import bootcamp.android.activities.ShoppingItemsListingActivity;
import bootcamp.android.models.Product;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private final ShoppingItemsListingActivity shoppingItemsListingActivity;
    private List<Product> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleView;
        public TextView descriptionView;
        public View view;
        public ViewHolder(View view) {
            super(view);
            this.view = view;
            titleView = view.findViewById(R.id.title);
            descriptionView = view.findViewById(R.id.description);
        }
    }

    public MyAdapter(List<Product> myDataset, ShoppingItemsListingActivity shoppingItemsListingActivity) {
        mDataset = myDataset;
        this.shoppingItemsListingActivity = shoppingItemsListingActivity;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.titleView.setText(mDataset.get(position).getTitle());
        holder.descriptionView.setText(mDataset.get(position).getDescription());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                shoppingItemsListingActivity.move(mDataset.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}