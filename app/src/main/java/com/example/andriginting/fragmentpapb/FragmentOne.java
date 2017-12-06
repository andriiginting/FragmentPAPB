package com.example.andriginting.fragmentpapb;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {

    EditText nama;
    EditText nomorHp;
    Button btnSubmit;
    KirimData kirimData;

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_one, container, false);

        nama = v.findViewById(R.id.edt_text_nama);
        nomorHp = v.findViewById(R.id.edt_text_nomorhp);
        btnSubmit = v.findViewById(R.id.btn_submit);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putString("nama",nama.getText().toString());
                b.putString("nomorHP",nomorHp.getText().toString());

                FragmentTwo fragmentTwo = new FragmentTwo();
                fragmentTwo.setArguments(b);

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_container,fragmentTwo);
                ft.commit();

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            kirimData = (KirimData) context;
        }catch (Exception e){

        }
    }
}
