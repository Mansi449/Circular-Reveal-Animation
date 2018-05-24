package mdg.com.circularreveal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mansi on 24/5/18.
 */

public class CardAdapter extends android.support.v7.widget.RecyclerView.Adapter<CardAdapter.CardViewHolder>{

    private Context mContext;
    private ArrayList<ModelClass> textList = new ArrayList<>();

    public class CardViewHolder extends RecyclerView.ViewHolder {
        public TextView card_text;

        public CardViewHolder(View view) {
            super(view);
            card_text = (TextView) view.findViewById(R.id.card_text);
        }
    }

    public CardAdapter(Context mContext, ArrayList<ModelClass> textList) {
        this.mContext = mContext;
        this.textList = textList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);

        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, int position) {
        ModelClass model = textList.get(position);
        holder.card_text.setText(model.getCard_text());

    }

    @Override
    public int getItemCount() {
        return textList.size();
    }

}
