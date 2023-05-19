package com.moutamid.simpleaircraftandroidapp.ui.featured;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.simpleaircraftandroidapp.Adapters.ChildListItemViewAdapter;
import com.moutamid.simpleaircraftandroidapp.Adapters.CustomizedExpandableListAdapter;
import com.moutamid.simpleaircraftandroidapp.Adapters.ListItemViewAdapter;
import com.moutamid.simpleaircraftandroidapp.Model.AircraftModel;
import com.moutamid.simpleaircraftandroidapp.R;
import com.moutamid.simpleaircraftandroidapp.databinding.FragmentFeatureBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FeatureFragment extends Fragment {

    private FragmentFeatureBinding binding;
    private ArrayList<String> titleList = new ArrayList<>();
    HashMap<String, List<AircraftModel>> expandableDetailList = new HashMap<String, List<AircraftModel>>();
    private List<AircraftModel> offshoreList = new ArrayList<>();
    private List<AircraftModel> cougarList = new ArrayList<>();
    private List<AircraftModel> bristowList = new ArrayList<>();
    private List<AircraftModel> CHCList = new ArrayList<>();
    private List<AircraftModel> retiredList = new ArrayList<>();
    private List<AircraftModel> PHIList = new ArrayList<>();
    private List<AircraftModel> IRCGList = new ArrayList<>();
    private List<AircraftModel> shellList = new ArrayList<>();
    private List<AircraftModel> othersList = new ArrayList<>();
    private List<AircraftModel> liderList = new ArrayList<>();
    private List<AircraftModel> saudiList = new ArrayList<>();
    private List<AircraftModel> milestoneList = new ArrayList<>();
    private List<AircraftModel> macquarieList = new ArrayList<>();
    private List<AircraftModel> OMNIList = new ArrayList<>();
    private List<AircraftModel> chinaList = new ArrayList<>();
    private List<AircraftModel> ASGList = new ArrayList<>();
    private List<AircraftModel> CITICList = new ArrayList<>();
    private List<AircraftModel> republicList = new ArrayList<>();
    private List<AircraftModel> chevronList = new ArrayList<>();
    private List<AircraftModel> UKSARList = new ArrayList<>();
 //   private TextView name1,name2,name3,name4,name5,name6,name7,name8,name9,name10,name11,name12,name13,name14,name15,name16,name17,name18,name19,name20;
    private RecyclerView list1,list2,list3,list4,list5,list6,list7,list8,list9,list10,list11,
            list12,list13,list14,list15,list16,list17,list18,list19,list20;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FeatureViewModel dashboardViewModel =
                new ViewModelProvider(this).get(FeatureViewModel.class);
        binding = FragmentFeatureBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        list1 = root.findViewById(R.id.recyclerview1);
        list2 = root.findViewById(R.id.recyclerview2);
        list3 = root.findViewById(R.id.recyclerview3);
        list4 = root.findViewById(R.id.recyclerview4);
        list5 = root.findViewById(R.id.recyclerview5);
        list6 = root.findViewById(R.id.recyclerview6);
        list7 = root.findViewById(R.id.recyclerview7);
        list8 = root.findViewById(R.id.recyclerview8);
        list9 = root.findViewById(R.id.recyclerview9);
        list10 = root.findViewById(R.id.recyclerview10);
        list11 = root.findViewById(R.id.recyclerview11);
        list12 = root.findViewById(R.id.recyclerview12);
        list13 = root.findViewById(R.id.recyclerview13);
        list14 = root.findViewById(R.id.recyclerview14);
        list15 = root.findViewById(R.id.recyclerview15);
        list16 = root.findViewById(R.id.recyclerview16);
        list17 = root.findViewById(R.id.recyclerview17);
        list18 = root.findViewById(R.id.recyclerview18);
        list19 = root.findViewById(R.id.recyclerview19);
        list20 = root.findViewById(R.id.recyclerview20);
        try {
            //JSONObject jsonObject = new JSONObject(JSONDataFromAssets());
            JSONArray jsonObject = new JSONArray(JSONDataFromAssets());
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
                if (category.equals("Offshore Helicopter Services")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    offshoreList.add(model);
                    ChildListItemViewAdapter adapter1 = new ChildListItemViewAdapter(getActivity(),offshoreList);
                    list1.setAdapter(adapter1);
                }
                if (category.equals("Cougar")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    cougarList.add(model);

                    ChildListItemViewAdapter adapter6 = new ChildListItemViewAdapter(getActivity(),cougarList);
                    list6.setAdapter(adapter6);
                }
                if (category.equals("Bristow")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    bristowList.add(model);

                    ChildListItemViewAdapter adapter2 = new ChildListItemViewAdapter(getActivity(),bristowList);
                    list2.setAdapter(adapter2);
                }
                if (category.equals("CHC")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    CHCList.add(model);

                    ChildListItemViewAdapter adapter3 = new ChildListItemViewAdapter(getActivity(),CHCList);
                    list3.setAdapter(adapter3);
                }
                if (category.equals("Retired")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    retiredList.add(model);

                    ChildListItemViewAdapter adapter12 = new ChildListItemViewAdapter(getActivity(),retiredList);
                    list12.setAdapter(adapter12);
                }
                if (category.equals("PHI")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    PHIList.add(model);

                    ChildListItemViewAdapter adapter4 = new ChildListItemViewAdapter(getActivity(),PHIList);
                    list4.setAdapter(adapter4);
                }
                if (category.equals("IRCG (CHC)")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    IRCGList.add(model);

                    ChildListItemViewAdapter adapter14 = new ChildListItemViewAdapter(getActivity(),IRCGList);
                    list14.setAdapter(adapter14);
                }
                if (category.equals("Shell")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    shellList.add(model);

                    ChildListItemViewAdapter adapter10 = new ChildListItemViewAdapter(getActivity(),shellList);
                    list10.setAdapter(adapter10);
                }
                if (category.equals("Lider")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    liderList.add(model);

                    ChildListItemViewAdapter adapter5 = new ChildListItemViewAdapter(getActivity(),liderList);
                    list5.setAdapter(adapter5);
                }
                if (category.equals("Saudi Ministry of Interior")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    saudiList.add(model);

                    ChildListItemViewAdapter adapter9 = new ChildListItemViewAdapter(getActivity(),saudiList);
                    list9.setAdapter(adapter9);
                }
                if (category.equals("Milestone")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    milestoneList.add(model);


                    ChildListItemViewAdapter adapter17 = new ChildListItemViewAdapter(getActivity(),milestoneList);
                    list17.setAdapter(adapter17);
                }
                if (category.equals("Macquarie")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    macquarieList.add(model);

                    ChildListItemViewAdapter adapter18 = new ChildListItemViewAdapter(getActivity(),macquarieList);
                    list18.setAdapter(adapter18);
                }
                if (category.equals("OMNI")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    OMNIList.add(model);


                    ChildListItemViewAdapter adapter15 = new ChildListItemViewAdapter(getActivity(),OMNIList);
                    list15.setAdapter(adapter15);
                }
                if (category.equals("China Southern General Aviation Co")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    chinaList.add(model);

                    ChildListItemViewAdapter adapter8 = new ChildListItemViewAdapter(getActivity(),chinaList);
                    list8.setAdapter(adapter8);
                }
                if (category.equals("ASG Helicopter Services")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    ASGList.add(model);


                    ChildListItemViewAdapter adapter16 = new ChildListItemViewAdapter(getActivity(),ASGList);
                    list16.setAdapter(adapter16);
                }
                if (category.equals("CITIC Offshore Helicopter Corp.")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    CITICList.add(model);


                    ChildListItemViewAdapter adapter13 = new ChildListItemViewAdapter(getActivity(),CITICList);
                    list13.setAdapter(adapter13);
                }
                if (category.equals("Republic of South Korea Coast Guard")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    republicList.add(model);

                    ChildListItemViewAdapter adapter11 = new ChildListItemViewAdapter(getActivity(),republicList);
                    list11.setAdapter(adapter11);
                }
                if (category.equals("Chevron")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    chevronList.add(model);


                    ChildListItemViewAdapter adapter7 = new ChildListItemViewAdapter(getActivity(),chevronList);
                    list7.setAdapter(adapter7);
                }
                if (category.equals("UKSAR (Bristow)")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    UKSARList.add(model);

                    ChildListItemViewAdapter adapter19 = new ChildListItemViewAdapter(getActivity(),UKSARList);
                    list19.setAdapter(adapter19);
                }
                if (category.equals("Others")){
                    AircraftModel model = new AircraftModel(id,reg,op,owner,country,base,status,notes,isSAR,
                            isOG,isNotContracted,imageName,category,yearbuilt,lat,lng);
                    othersList.add(model);

                    ChildListItemViewAdapter adapter20 = new ChildListItemViewAdapter(getActivity(),othersList);
                    list20.setAdapter(adapter20);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return root;
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