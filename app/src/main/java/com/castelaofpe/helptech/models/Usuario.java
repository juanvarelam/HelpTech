package com.castelaofpe.helptech.models;

import android.media.Image;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Usuario implements Serializable {

    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("username")
    private String username;
    @Expose
    @SerializedName("description")
    private String description;

  /*  public Usuario(String email, String username, String description) {
        this.email = email;
        this.username = username;
        this.description = description;
    }*/



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map toMap() {

        HashMap map = new HashMap();

        map.put("email", this.email);
        map.put("username", this.username);
        map.put("description", this.description);

        return map;

    }


}

