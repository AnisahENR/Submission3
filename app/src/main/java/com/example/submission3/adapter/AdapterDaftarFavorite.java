package com.example.submission3.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.submission3.R;
import com.example.submission3.model.DaftarFavoriteModel;

import java.util.ArrayList;

public class AdapterDaftarFavorite extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<DaftarFavoriteModel> listFavorite = new ArrayList<>();
    private Activity activity;

    public AdapterDaftarFavorite(Activity activity) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }

    public ArrayList<DaftarFavoriteModel> getListFavorite() {
        return listFavorite;
    }

    public void setListFavorite(ArrayList<DaftarFavoriteModel> listFavorite) {
        if (listFavorite.size() > 0) {
            this.listFavorite.clear();
        }
        this.listFavorite.addAll(listFavorite);
        notifyDataSetChanged();
    }

    public void addItem(DaftarFavoriteModel note) {
        this.listFavorite.add(note);
        notifyItemInserted(listFavorite.size() - 1);
    }

    public void updateItem(int position, DaftarFavoriteModel note) {
        this.listFavorite.set(position, note);
        notifyItemChanged(position, note);
    }

    public void removeItem(int position) {
        this.listFavorite.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listFavorite.size());
    }

    public class FavoriteViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvNamaUser;

        public FavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaUser = itemView.findViewById(R.id.nama_user);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_user, parent, false);
        return new FavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FavoriteViewHolder) {
            DaftarFavoriteModel daftar = listFavorite.get(position);
            FavoriteViewHolder view = (FavoriteViewHolder) holder;
            view.tvNamaUser.setText(daftar.getLogin());

//        holder.tvTitle.setText(listNotes.get(position).getTitle());
//        holder.tvDate.setText(listNotes.get(position).getDate());
//        holder.tvDescription.setText(listNotes.get(position).getDescription());
//        holder.cvNote.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
//            @Override
//            public void onItemClicked(View view, int position) {
//                Intent intent = new Intent(activity, NoteAddUpdateActivity.class);
//                intent.putExtra(NoteAddUpdateActivity.EXTRA_POSITION, position);
//                intent.putExtra(NoteAddUpdateActivity.EXTRA_NOTE, listNotes.get(position));
//                activity.startActivityForResult(intent, NoteAddUpdateActivity.REQUEST_UPDATE);
//            }
//        }));
        }
    }

    @Override
    public int getItemCount() {
        return listFavorite.size();
    }


}
