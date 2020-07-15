package in.newdevpoint.android.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.newdevpoint.android.R;
import in.newdevpoint.android.model.Result;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Result> items = new ArrayList<>();

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTextView.setText(items.get(position).getName());

    }

    public void addAll(List<Result> list) {
        this.items.clear();
        this.items = list;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        MyViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.countryId);
        }
    }
}