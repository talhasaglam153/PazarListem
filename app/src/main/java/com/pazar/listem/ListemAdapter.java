package com.pazar.listem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListemAdapter extends RecyclerView.Adapter<ListemAdapter.ListeTutucu> {

    private Context myContext;
    private List<String> liste;

    public ListemAdapter(Context myContext, List<String> liste) {
        this.myContext = myContext;
        this.liste = liste;
    }


    @NonNull
    @Override
    public ListemAdapter.ListeTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new ListeTutucu(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListemAdapter.ListeTutucu holder, int position) {
        String listemiz = liste.get(position);
        holder.textView.setText(listemiz);

    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    public class ListeTutucu extends RecyclerView.ViewHolder {
        private TextView textView;

        public ListeTutucu(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
        }
    }
}
