package com.castelaofpe.helptech.inicio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.castelaofpe.helptech.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InicialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicialFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InicialFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InicialFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InicialFragment newInstance(String param1, String param2) {
        InicialFragment fragment = new InicialFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //si pulsa SIGN IN
        View v = inflater.inflate(R.layout.frg_login, container, false);
        Button btnLogin = v.findViewById(R.id.act_inicial_btn_inicio);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // FragmentManager manager = getSupportFragmentManager();
                //FragmentTransaction trans = manager.beginTransaction();

                //trans.replace(R.id.act_auth_container_frame, frgLog, "fragment_01");

                //trans.commit();
            }
        });

        //si pulsa SIGN UP
        View v2 = inflater.inflate(R.layout.frg_register, container, false);
        Button btnRegister = v.findViewById(R.id.act_inicial_btn_registro);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FragmentManager manager = getSupportFragmentManager();
                //FragmentTransaction trans = manager.beginTransaction();

                //trans.replace(R.id.act_auth_container_frame, frgReg, "fragment_01");

                //trans.commit();
            }
        });





        return inflater.inflate(R.layout.frg_inicial, container, false);
    }







}