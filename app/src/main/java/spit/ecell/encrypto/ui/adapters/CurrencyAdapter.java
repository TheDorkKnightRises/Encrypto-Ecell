package spit.ecell.encrypto.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import spit.ecell.encrypto.R;
import spit.ecell.encrypto.models.Currency;

/**
 * Created by Samriddha on 17-03-2018.
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {
    private ArrayList<Currency> currencies;
    private Context context;

    public CurrencyAdapter(ArrayList<Currency> currencies, Context context) {
        this.currencies = currencies;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).
                inflate(R.layout.list_item_currency, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Currency currency = currencies.get(position);
        holder.symbolView.setText(currency.getSymbol());
        holder.nameView.setText(currency.getName());
        holder.valueView.setText(String.valueOf(currency.getCurrentValue()));
        holder.ownedAmountView.setText(String.valueOf(currency.getOwned()));
        if (currency.getVariation() >= 0) {
            holder.variationView.setText("+" + currency.getVariation() + "%");
        } else {
            holder.variationView.setText(currency.getVariation() + "%");
            holder.variationView.setBackgroundResource(R.drawable.border_rounded_red);
        }
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView symbolView, nameView, valueView, variationView, ownedAmountView;

        ViewHolder(View view) {
            super(view);
            symbolView = view.findViewById(R.id.currency_symbol);
            nameView = view.findViewById(R.id.currency_name);
            valueView = view.findViewById(R.id.value);
            variationView = view.findViewById(R.id.variation);
            ownedAmountView = view.findViewById(R.id.owned_amt);
        }
    }
}