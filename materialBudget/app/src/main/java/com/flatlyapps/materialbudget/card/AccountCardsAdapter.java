package com.flatlyapps.materialbudget.card;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.flatlyapps.materialbudget.R;

/**
 * Created by Paul on 05/07/2015.
 */

public class AccountCardsAdapter extends RecyclerView.Adapter<AccountCardsAdapter.ViewHolder> {

    private final Context context;

    public AccountCardsAdapter(Context context) {
        this.context = context;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public final FrameLayout rootView;

        public ViewHolder(FrameLayout rootView) {
            super(rootView);
            this.rootView = rootView;
        }
    }

    @Override
    public AccountCardsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        FrameLayout rootView = (FrameLayout) LayoutInflater.from(context)
                .inflate(R.layout.account_card_layout, parent, false);
        ViewCompat.setElevation(rootView, 50);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView cardTitle = (TextView) holder.rootView.findViewById(R.id.card_title_view);
        cardTitle.setText("account: " + position);

        CardView cardView = (CardView) holder.rootView.findViewById(R.id.card_view);
        cardView.setOnClickListener(new CardClickListener((long)position));

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    private class CardClickListener implements View.OnClickListener {

        private final Long accountId;

        CardClickListener(Long accountId) {
            this.accountId = accountId;
        }

        @Override
        public void onClick(View v) {
        }
    }

}
