package mdg.com.circularreveal;

import android.animation.Animator;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mansi on 24/5/18.
 */

public class CardAdapter extends android.support.v7.widget.RecyclerView.Adapter<CardAdapter.CardViewHolder>{

    private Context mContext;
    private ArrayList<ModelClass> textList = new ArrayList<>();
    private LinearLayout cardParent;


    public class CardViewHolder extends RecyclerView.ViewHolder {
        public TextView card_text;

        public CardViewHolder(View view) {
            super(view);
            card_text = (TextView) view.findViewById(R.id.card_text);
            cardParent = (LinearLayout) view.findViewById(R.id.cardParent);
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

    void CircularRevealEffect(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // get the center for the clipping circle
            int cx = cardParent.getWidth() / 2;
            int cy = cardParent.getHeight() / 2;

            float finalRadius = (float) Math.hypot(cx, cy);
            Animator anim = ViewAnimationUtils.createCircularReveal(cardParent, cx, cy, 0, finalRadius);

            // make the view visible and start the animation
            cardParent.setVisibility(View.VISIBLE);
            anim.start();
        } else {
            // set the view to visible without a circular reveal animation below Lollipop
            cardParent.setVisibility(View.VISIBLE);
        }
    }

}
