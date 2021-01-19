package com.castelaofpe.helptech.perfil;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.castelaofpe.helptech.R;

public class ConfigFragment extends Fragment {

    private Button btnNombre;
    private Button btnPass;
    private Button btnEmail;
    private Button btnPrivacidad;
    private Button btnFoto;

    public ConfigFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frg_config, container, false);
        initViews(v);
        initListeners();
        return v;
    }

    private void initViews(View v) {
        btnNombre = v.findViewById(R.id.frg_config_nombre_btn);
        btnPass = v.findViewById(R.id.frg_config_pass_btn);
        btnPrivacidad = v.findViewById(R.id.frg_config_privacidad_btn);
    }

    private void initListeners() {

        btnNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogUsuario();
            }
            private void showDialogUsuario() {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = requireActivity().getLayoutInflater();

                View v = inflater.inflate(R.layout.dialog_usuario, null);
                final EditText edtNombre = v.findViewById(R.id.dialog_usuario_nombre_edt);

                builder.setView(v)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                                String nombre = edtNombre.getText().toString();
                                Log.i("Nuevo nombre",nombre);

                            }
                        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btnPass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showDialogPass();
            }

            private void showDialogPass() {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = requireActivity().getLayoutInflater();

                View v = inflater.inflate(R.layout.dialog_password, null);
                final EditText edtNuevaPass= v.findViewById(R.id.dialog_pass_nueva_edt);
                final EditText edtConfirmaPass= v.findViewById(R.id.dialog_pass_confirma_edt);

                builder.setView(v)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                                String nuevaPass = edtNuevaPass.getText().toString();
                                String confirmaPass = edtConfirmaPass.getText().toString();

                                if( nuevaPass.equals(confirmaPass) )//Guardar contraseña
                                    Log.i("Contraseña guardada", nuevaPass);
                            }
                        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btnPrivacidad.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showDialogPrivacidad();
            }

            private void showDialogPrivacidad() {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = requireActivity().getLayoutInflater();

                View v = inflater.inflate(R.layout.dialog_privacidad, null);
                final TextView txtPrivacidad = v.findViewById(R.id.dialog_privacidad_txt);

                builder.setView(v)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

    }
}