package com.castelaofpe.helptech.perfil;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.*;
import androidx.appcompat.widget.SwitchCompat;

import com.castelaofpe.helptech.R;
import com.castelaofpe.helptech.inicio.InicialActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ConfigActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private FirebaseAuth auth;
    private Button btnNombre;
    private Button btnPass;
    private Button btnEmail;
    private Button btnPrivacidad;
    private Button btnFoto;
    private ImageButton btnBack;
    private Activity act;
    private Button btnCerrarSesion;
    private SwitchCompat switchNotificaciones;

    public ConfigActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_config);
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        act = this;

        initButtons();
        initListeners();
    }

    private void initButtons() {

        btnNombre = findViewById(R.id.act_config_nombre_btn);
        btnPass = findViewById(R.id.act_config_pass_btn);
        btnPrivacidad = findViewById(R.id.act_config_privacidad_btn);
        btnBack = findViewById(R.id.act_config_back_btn);
        btnFoto = findViewById(R.id.act_config_foto_btn);
        btnCerrarSesion = findViewById(R.id.act_config_logout_btn);
        btnEmail = findViewById(R.id.act_config_email_btn);
        switchNotificaciones = findViewById(R.id.act_config_notificaciones_switch);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void initListeners() {

        btnNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogUsuario();
            }

            private void showDialogUsuario() {

                AlertDialog.Builder builder = new AlertDialog.Builder(act);
                LayoutInflater inflater = act.getLayoutInflater();

                View v = inflater.inflate(R.layout.dialog_usuario, null);
                final EditText edtNombre = v.findViewById(R.id.dialog_usuario_nombre_edt);

                builder.setView(v)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                                String nombre = edtNombre.getText().toString();

                                Toast.makeText(getApplicationContext(),
                                        getString(R.string.nombre_actualizado), Toast.LENGTH_SHORT).show();

                                actualizaUsername(nombre);
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

        btnPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogPass();
            }

            private void showDialogPass() {

                AlertDialog.Builder builder = new AlertDialog.Builder(act);
                LayoutInflater inflater = act.getLayoutInflater();

                View v = inflater.inflate(R.layout.dialog_password, null);
                final EditText edtNuevaPass = v.findViewById(R.id.dialog_pass_nueva_edt);
                final EditText edtConfirmaPass = v.findViewById(R.id.dialog_pass_confirma_edt);

                builder.setView(v)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                                String nuevaPass = edtNuevaPass.getText().toString();
                                String confirmaPass = edtConfirmaPass.getText().toString();

                                if (nuevaPass.equals(confirmaPass)) {

                                    Objects.requireNonNull(Objects.requireNonNull(auth.getCurrentUser()).updatePassword(nuevaPass));

                                    Toast.makeText(getApplicationContext(),
                                            getString(R.string.password_actualizada), Toast.LENGTH_SHORT).show();
                                }
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

        btnPrivacidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogPrivacidad();
            }

            private void showDialogPrivacidad() {

                AlertDialog.Builder builder = new AlertDialog.Builder(act);
                LayoutInflater inflater = act.getLayoutInflater();
                View v = inflater.inflate(R.layout.dialog_privacidad, null);

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

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Toast.makeText(getApplicationContext(),
                        getString(R.string.sesion_cerrada), Toast.LENGTH_SHORT).show();
                finish();
                Intent intent = new Intent(act, InicialActivity.class);
                startActivity(intent);
            }
        });

        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //seleccionaFoto();
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogEmail();
            }

            private void showDialogEmail() {

                AlertDialog.Builder builder = new AlertDialog.Builder(act);
                LayoutInflater inflater = act.getLayoutInflater();

                View v = inflater.inflate(R.layout.dialog_email, null);
                final EditText edtNuevoEmail = v.findViewById(R.id.dialog_email_nuevo);

                builder.setView(v)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                                    String email = edtNuevoEmail.getText().toString();
                                    Objects.requireNonNull(auth.getCurrentUser()).updateEmail(email);

                                Toast.makeText(getApplicationContext(),
                                        getString(R.string.email_actualizado), Toast.LENGTH_SHORT).show();

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

        switchNotificaciones.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            String fichero = getString(R.string.sharedpreferences_file);
            SharedPreferences prefs = getSharedPreferences(fichero, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("notificaciones", isChecked);
                editor.commit();
            }
        });

    }

    private void seleccionaFoto() {

      /*  Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(intent, PICK_IMAGE);

        Uri foto = intent.getData();

        StorageReference storageRef = FirebaseStorage.getInstance().getReferenceFromUrl("gs://helptech-a1b55.appspot.com/");
        storageRef.putFile(foto);*/
    }

    private void actualizaUsername(String username) {

        Map<String, Object> datos = new HashMap<>();
        datos.put("username", username);

        String filename = getString(R.string.sharedpreferences_file);
        SharedPreferences sharedPref = getSharedPreferences(filename, Context.MODE_PRIVATE);

        String uid = sharedPref.getString("id", "{}");
        db.collection("users").document(uid).set(datos, SetOptions.merge());
    }
}

