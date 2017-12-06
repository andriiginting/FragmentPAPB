package com.example.andriginting.fragmentpapb;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment {

    TextView namaKontak;
    TextView nomorKontak;
    Button btn_telfon;
    public FragmentTwo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        namaKontak = v.findViewById(R.id.txt_nama_kontak);
        nomorKontak = v.findViewById(R.id.txt_nomor_kontak);
        btn_telfon = v.findViewById(R.id.btn_telfon);

        Bundle b = getArguments();

        String nama= b.getString("nama");
        String nomor= b.getString("nomorHP");

        namaKontak.setText(nama);
        nomorKontak.setText(nomor);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btn_telfon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel: "+nomorKontak.getText().toString()));
                startActivity(intent);
            }
        });

    }
}
