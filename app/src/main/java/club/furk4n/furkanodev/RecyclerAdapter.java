package club.furk4n.furkanodev;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Trabzonspor> liste;

    public RecyclerAdapter(List<Trabzonspor> list) {
        liste = list;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.baslik_text.setText(liste.get(position).getBaslik());
        viewHolder.aciklama_text.setText(liste.get(position).getAciklama());
        Picasso.with(viewHolder.trabzon_image.getContext()).load(liste.get(position).getResim()).into(viewHolder.trabzon_image);
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public CardView card_view;
        public TextView baslik_text;
        public TextView aciklama_text;
        public ImageView trabzon_image;

        public ViewHolder(View view) {
            super(view);

            this.card_view = view.findViewById(R.id.card_view);
            this.baslik_text = view.findViewById(R.id.trabzonTitle);
            this.aciklama_text = view.findViewById(R.id.trabzonSubTitle);
            this.trabzon_image = view.findViewById(R.id.trabzonImage);

        }
    }
}
