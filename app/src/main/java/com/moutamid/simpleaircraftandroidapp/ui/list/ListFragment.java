package com.moutamid.simpleaircraftandroidapp.ui.list;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.simpleaircraftandroidapp.Adapters.ListItemViewAdapter;
import com.moutamid.simpleaircraftandroidapp.Model.AircraftModel;
import com.moutamid.simpleaircraftandroidapp.R;
import com.moutamid.simpleaircraftandroidapp.databinding.FragmentListBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class ListFragment extends Fragment {

    private FragmentListBinding binding;
    private EditText searchBar;
    ListItemViewAdapter adapter,adapter1;
    private ArrayList<AircraftModel> OGList;
    private ArrayList<AircraftModel> SARList;
    private RecyclerView sar_recyclerView,oil_recyclerView;
    private Switch sarSwitch,oilSwitch;
    private boolean sar = false;
    private boolean og = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        searchBar = root.findViewById(R.id.search);
        sar_recyclerView = root.findViewById(R.id.sar_recyclerView);
        oil_recyclerView = root.findViewById(R.id.oil_recyclerView);
        oilSwitch = root.findViewById(R.id.oilSwitch);
        sarSwitch = root.findViewById(R.id.sarSwitch);
        OGList = new ArrayList<>();
        SARList = new ArrayList<>();
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                if (og) {
                    if (charSequence.length() > 0) {
                        adapter.getFilter().filter(charSequence.toString());
                    }else {
                        getOilGasList();
                    }
                }else if(sar){
                    if (charSequence.length() > 0) {
                        adapter1.getFilter().filter(charSequence.toString());
                    }else {
                        getSarList();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

     /*   oilSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    sar_recyclerView.setVisibility(View.GONE);
                    oil_recyclerView.setVisibility(View.VISIBLE);
                    sarSwitch.setChecked(false);
                    getOilGasList();
                    og = true;
                    sar = false;
                }else {
                    sar_recyclerView.setVisibility(View.GONE);
                    oil_recyclerView.setVisibility(View.GONE);
                    og = false;
                    sar = false;
                }
            }
        });

        sarSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    sar_recyclerView.setVisibility(View.VISIBLE);
                    oil_recyclerView.setVisibility(View.GONE);
                    oilSwitch.setChecked(false);
                    getSarList();
                    og = false;
                    sar = true;
                }else {
                    sar_recyclerView.setVisibility(View.GONE);
                    oil_recyclerView.setVisibility(View.GONE);
                    og = false;
                    sar = false;
                }
            }
        });*/

        oilSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!og){
                    sar_recyclerView.setVisibility(View.GONE);
                    oil_recyclerView.setVisibility(View.VISIBLE);
                    sarSwitch.setChecked(false);
                    getOilGasList();
                    og = true;
                    sar = false;
                }else {
                    sar_recyclerView.setVisibility(View.GONE);
                    oil_recyclerView.setVisibility(View.GONE);
                    og = false;
                    sar = false;
                }
            }
        });

        sarSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!sar){
                    sar_recyclerView.setVisibility(View.VISIBLE);
                    oil_recyclerView.setVisibility(View.GONE);
                    oilSwitch.setChecked(false);
                    getSarList();
                    og = false;
                    sar = true;
                }else {
                    sar_recyclerView.setVisibility(View.GONE);
                    oil_recyclerView.setVisibility(View.GONE);
                    og = false;
                    sar = false;
                }
            }
        });

        return root;
    }


    private void getOilGasList() {
        try {
            JSONArray jsonObject = new JSONArray(JSONDataFromAssets());
            Log.d("List","" + jsonObject.length());
            for (int i = 0; i < jsonObject.length(); i++){
                JSONObject object = jsonObject.getJSONObject(i);
                int id = object.getInt("id");
                String reg = object.getString("reg");
                String op = object.getString("op");
                String owner = object.getString("owner");
                String country = object.getString("country");
                String base = object.getString("base");
                String imageName = object.getString("imageName");
                String notes = object.getString("notes");
                String category = object.getString("category");
                String yearbuilt = object.getString("yearbuilt");
                boolean isNotContracted = object.getBoolean("isNotContracted");
                boolean isOG = object.getBoolean("isOG");
                String status = object.getString("status");
                boolean isSAR = object.getBoolean("isSAR");
                JSONObject cordinates = object.getJSONObject("coordinates");
                double lat = cordinates.getDouble("lat");
                double lng = cordinates.getDouble("long");
                if (isOG){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    OGList.add(model);
                    adapter = new ListItemViewAdapter(getActivity(),OGList);
                    oil_recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void getSarList() {
        try {
            //JSONObject jsonObject = new JSONObject(JSONDataFromAssets());
            JSONArray jsonObject = new JSONArray(JSONDataFromAssets());
            Log.d("List","" + jsonObject.length());
            for (int i = 0; i < jsonObject.length(); i++){
                JSONObject object = jsonObject.getJSONObject(i);
                int id = object.getInt("id");
                String reg = object.getString("reg");
                String op = object.getString("op");
                String owner = object.getString("owner");
                String country = object.getString("country");
                String base = object.getString("base");
                String imageName = object.getString("imageName");
                String notes = object.getString("notes");
                String category = object.getString("category");
                String yearbuilt = object.getString("yearbuilt");
                boolean isNotContracted = object.getBoolean("isNotContracted");
                boolean isOG = object.getBoolean("isOG");
                String status = object.getString("status");
                boolean isSAR = object.getBoolean("isSAR");
                JSONObject cordinates = object.getJSONObject("coordinates");
                double lat = cordinates.getDouble("lat");
                double lng = cordinates.getDouble("long");
                if (isSAR){
                    Log.d("List1","" + jsonObject.length());
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    SARList.add(model);
                    adapter1 = new ListItemViewAdapter(getActivity(),SARList);
                    sar_recyclerView.setAdapter(adapter1);
                    adapter1.notifyDataSetChanged();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String JSONDataFromAssets() {
        String json = null;
        InputStream inputStream = null;
        try {
            inputStream = getActivity().getAssets().open("data.json");
            int size = inputStream.available();
            byte[] bufferData = new byte[size];
            inputStream.read(bufferData);
            inputStream.close();

            json = new String(bufferData,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}