package com.moutamid.simpleaircraftandroidapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.simpleaircraftandroidapp.MainActivity;
import com.moutamid.simpleaircraftandroidapp.Model.AircraftModel;
import com.moutamid.simpleaircraftandroidapp.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

public class ListItemViewAdapter extends RecyclerView.Adapter<ListItemViewAdapter.ListItemViewHolder> implements Filterable {

    private Context mContext;
    private ArrayList<AircraftModel> aircraftModels;

    public ListItemViewAdapter(Context mContext, ArrayList<AircraftModel> aircraftModels) {
        this.mContext = mContext;
        this.aircraftModels = aircraftModels;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_custom_layout,parent,false);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {
        AircraftModel model = aircraftModels.get(position);
        holder.nameTxt.setText(model.getImageName() + " " + model.getReg());
        holder.imageView.setImageBitmap(getBitmapFromAsset(model.getImageName() + ".png"));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MainActivity.class);
                intent.putExtra("aircraft",model);
                mContext.startActivity(intent);
            }
        });
    }

    private Bitmap getBitmapFromAsset(String strName)
    {
        AssetManager assetManager = mContext.getAssets();
        InputStream istr = null;
        try {
            istr = assetManager.open(strName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        return bitmap;
    }

    @Override
    public int getItemCount() {
        return aircraftModels.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<AircraftModel> filterList = new ArrayList<>();

            if (charSequence.toString().isEmpty()) {
                filterList.addAll(aircraftModels);
            } else {
                for (AircraftModel data : aircraftModels) {
                    if (data.getReg().toLowerCase().contains(charSequence.toString().toLowerCase()) ||
                            data.getOp().toLowerCase().contains(charSequence.toString().toLowerCase()) ||
                            data.getCountry().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filterList.add(data);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filterList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            aircraftModels.clear();
            aircraftModels.addAll((Collection<? extends AircraftModel>) filterResults.values);
            notifyDataSetChanged();

        }
    };


    public class ListItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView nameTxt;

        public ListItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            nameTxt = itemView.findViewById(R.id.name);
        }
    }
}
