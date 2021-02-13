package com.castelaofpe.helptech.inicio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.castelaofpe.helptech.R;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class FotoActivity extends AppCompatActivity {

    Button btnSubirImagen;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_foto);

        imagen = (ImageView) findViewById(R.id.act_foto_imageView_camara);
        btnSubirImagen = (Button) findViewById(R.id.act_foto_abrir_camara);

        if (validaPermisos()) {
            btnSubirImagen.setEnabled(true);
        }else{
            btnSubirImagen.setEnabled(false);
        }
    }

    private boolean validaPermisos() {

        //SI ES MENOR QUE MARSHALLOW (23) -> PERMISOS FORMA MANUAL
        if (Build.VERSION.SDK_INT<Build.VERSION_CODES.M) {
            return true;
        }

        //SI SE CONCEDERON PERMISOS
        if ( (checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED) &&
                (checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)) {
            return true;
        }

        //SI NO SE CONCEDIERON PERMISOS
        if ( (shouldShowRequestPermissionRationale(CAMERA)) ||
                (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)) ) {
            cargarDialogoRecomendacion();  //AVISA PARA ACTIVAR PERMISOS
        }else{
            requestPermissions(new String[] {WRITE_EXTERNAL_STORAGE, CAMERA},100);
        }

        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 100) {
            if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                btnSubirImagen.setEnabled(true);
            }else{
                solicitarPermisosManualmente();
            }
        }
    }

    private void solicitarPermisosManualmente() {
        final CharSequence[] opciones = {"Sí", "No"};
        final AlertDialog.Builder alertOpciones = new AlertDialog.Builder(FotoActivity.this);
        alertOpciones.setTitle("¿Desea configurar los permisos de forma manual?");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if (opciones[i].equals("Sí")) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Los permisos no fueron aceptados", Toast.LENGTH_SHORT).show();
                }
                    dialog.dismiss();
                }
        });
        alertOpciones.show();
    }

    private void cargarDialogoRecomendacion() {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(FotoActivity.this);
        dialogo.setTitle("Permisos Desactivados");
        dialogo.setMessage("Debe conceder permisos para que la aplicación funcione correctamente");

        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                requestPermissions(new String[] {WRITE_EXTERNAL_STORAGE, CAMERA},100);
            }
        });
        dialogo.show();
    }


    public void onClick(View view) {
        
        Intent vista = new Intent(FotoActivity.this, DescripcionActivity.class);
        startActivity(vista);
    }


    public void onClickOpCamara(View view) {

        cargarImagen();
    }



    private void cargarImagen() {

        final CharSequence[] opciones = {"Abrir Cámara", "Seleccionar desde la galería", "Cancelar"};
        final AlertDialog.Builder alertOpciones = new AlertDialog.Builder(FotoActivity.this);
        alertOpciones.setTitle("Seleccione una opción");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if (opciones[i].equals("Abrir Cámara")) {
                    Toast.makeText(getApplication(), "Sacar foto", Toast.LENGTH_SHORT).show();
                }else{
                    if (opciones[i].equals("Seleccionar desde la galería")) {
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/");
                        startActivityForResult(intent.createChooser(intent,"Seleccione la Aplicación"), 10);
                    }else{
                        dialog.dismiss();
                    }
                }
            }
        });
        alertOpciones.show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Uri path = data.getData();
            imagen.setImageURI(path);
        }
    }
}