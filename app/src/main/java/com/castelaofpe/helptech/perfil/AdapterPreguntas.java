package com.castelaofpe.helptech.perfil;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.castelaofpe.helptech.R;


public class AdapterPreguntas extends Fragment {

    View v;

    public AdapterPreguntas() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frg_preguntas, container, false);
        return v;
    }
}