package com.example.a109590016_hw702;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private final LinkedList<String> name;
    private final LinkedList<String> description;
    private LayoutInflater mInflater;

    public WordListAdapter(Context context,
                           LinkedList<String> name, LinkedList<String> description) {
        mInflater = LayoutInflater.from(context);
        this.name = name;
        this.description = description;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item,
                parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String mCurrent = name.get(position);
        holder.wordItemView.setText(mCurrent);
        String mCurrent2 = description.get(position);
        holder.wordItemView2.setText(mCurrent2);
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        public final TextView wordItemView;
        public final TextView wordItemView2;
        final WordListAdapter mAdapter;
        public WordViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.name);
            wordItemView2 = itemView.findViewById(R.id.description);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
            Intent messageIntent = new Intent(view.getContext(), Recepie.class);
            messageIntent.putExtra("Position", mPosition);
            view.getContext().startActivity(messageIntent);
        }
    }
}
