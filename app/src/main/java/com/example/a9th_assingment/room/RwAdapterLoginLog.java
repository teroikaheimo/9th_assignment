package com.example.a9th_assingment.room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.a9th_assingment.R;

import java.util.List;

public class RwAdapterLoginLog extends RecyclerView.Adapter<RwAdapterLoginLog.HolderLoginLog> {

    private final LayoutInflater inflater;
    private List<EntityLoginLog> nameDate;

    RwAdapterLoginLog(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public HolderLoginLog onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.login_list_item, parent, false);
        return new HolderLoginLog(itemView);
    }

    @Override
    public void onBindViewHolder(HolderLoginLog holder, int position) {
        if (nameDate != null) {
            EntityLoginLog current = nameDate.get(position);
            String timestamp = current.timestamp.toString();
            String success = current.success.toString();
            holder.usernameTextView.setText(current.username);
            holder.timestampTextView.setText(timestamp);
            holder.successTextView.setText(success);

        } else {
            // In case data is not ready yet.
            holder.usernameTextView.setText("No Data");
            holder.timestampTextView.setText("No Data");
            holder.successTextView.setText("No Data");
        }
    }

    void setNameDates(List<EntityLoginLog> nameDates) {
        nameDate = nameDates;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (nameDate != null)
            return nameDate.size();
        else return 0;
    }

    class HolderLoginLog extends RecyclerView.ViewHolder {
        private final TextView usernameTextView;
        private final TextView timestampTextView;
        private final TextView successTextView;


        private HolderLoginLog(View itemView) {
            super(itemView);
            usernameTextView = itemView.findViewById(R.id.username);
            timestampTextView = itemView.findViewById(R.id.timestamp);
            successTextView = itemView.findViewById(R.id.success);
        }
    }
}
