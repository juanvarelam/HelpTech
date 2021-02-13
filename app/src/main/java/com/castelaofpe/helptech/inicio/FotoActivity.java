package com.castelaofpe.helptech.inicio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.castelaofpe.helptech.R;

public class FotoActivity extends AppCompatActivity {

    Button btnSubirImagen;
    ImageView imagen;

    private static final int REQUEST_PERMISSION_CODE = 100;
    private static final int REQUEST_IMAGE_GALLERY = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_foto);

        imagen = findViewById(R.id.act_foto_imageView_camara);
        btnSubirImagen = findViewById(R.id.act_foto_btn_subir_imagen);

        btnSubirImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ActivityCompat.checkSelfPermission(FotoActivity.this,
                            Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        abrirGaleria();
                    }else{
                        ActivityCompat.requestPermissions(FotoActivity.this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION_CODE);
                    }
                }else{
                    abrirGaleria();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_PERMISSION_CODE) {
            if (permissions.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                abrirGaleria();
            }else{
                Toast.makeText(this, "Necesitas conceder los permisos", Toast.LENGTH_SHORT).show();
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void onClickNext(View view) {

        Intent vista = new Intent(FotoActivity.this, DescripcionActivity.class);
        startActivity(vista);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == REQUEST_IMAGE_GALLERY){  //GALERÍA
            if (resultCode == Activity.RESULT_OK && data != null) {
                Uri foto = data.getData();
                imagen.setImageURI(foto);
            }else{
                Toast.makeText(this, "No seleccionaste ninguna foto.", Toast.LENGTH_SHORT).show();
            }
        }else if (requestCode == REQUEST_IMAGE_GALLERY){

        }

        super.onActivityResult(requestCode, resultCode, data);
    }


    private void abrirGaleria() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/");
        startActivityForResult(intent, REQUEST_IMAGE_GALLERY);
    }
}