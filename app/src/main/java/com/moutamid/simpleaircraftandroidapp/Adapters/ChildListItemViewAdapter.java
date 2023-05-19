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

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ChildListItemViewAdapter extends RecyclerView.Adapter<ChildListItemViewAdapter.ListItemViewHolder>{

    private Context mContext;
    private List<AircraftModel> aircraftModels;

    public ChildListItemViewAdapter(Context mContext, List<AircraftModel> aircraftModels) {
        this.mContext = mContext;
        this.aircraftModels = aircraftModels;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.feature_custom_layout,parent,false);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {
        AircraftModel model = aircraftModels.get(position);
        holder.nameTxt.setText(model.getImageName());
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
