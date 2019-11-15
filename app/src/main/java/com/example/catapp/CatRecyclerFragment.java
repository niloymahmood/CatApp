package com.example.catapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatRecyclerFragment extends Fragment {

    private RecyclerView recyclerView;
    private EditText editText;

    public CatRecyclerFragment(){
        //empty constructor required
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_cat_menu, container, false  );
        recyclerView = view.findViewById(R.id.rv_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

//json parsing resource https://www.youtube.com/watch?v=f-kcvxYZrB4&t=66s and tutorial work

        final CatAdapter catAdapter = new CatAdapter();
        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        String url = "https://api.thecatapi.com/v1/breeds?bc9d9845-ffb7-4b60-b9d8-6aa3994b13d5";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Cat[] cat = gson.fromJson(response, Cat[].class);
                final List<Cat>  catList = Arrays.asList(cat);

                catAdapter.setData(catList);
                recyclerView.setAdapter(catAdapter);
                FakeDatabase.saveCatsToFakeDatabase(catList);
                requestQueue.stop();

//search view resource https://www.youtube.com/watch?v=OWwOSLfWboY

                EditText editText = view.findViewById(R.id.editText);
                editText.setHint("Search for a Cat");
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        ArrayList<Cat> filteredCatList = new ArrayList<>();
                        for(Cat cat1: catList){
                            if (cat1.getName().toLowerCase().contains(s.toString().toLowerCase())){
                                filteredCatList.add(cat1);
                            }
                        }
                        catAdapter.filterList(filteredCatList);


                    }
                });





            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        requestQueue.add(stringRequest);
        return  view;



    }




    @Override
    public void onResume() {
        super.onResume();
        MainActivity parent = (MainActivity) getActivity();
        parent.showCoolMessage("");
    }
}
