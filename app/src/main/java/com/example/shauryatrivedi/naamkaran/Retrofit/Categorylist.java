package com.example.shauryatrivedi.naamkaran.Retrofit;

//http://mapi.trycatchtech.com/v1/naamkaran/category_list
public class Categorylist {
    String id;
    String cat_nam;

    public Categorylist(String id, String cat_nam) {
        this.id = id;
        this.cat_nam = cat_nam;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCat_nam() {
        return cat_nam;
    }

    public void setCat_nam(String cat_nam) {
        this.cat_nam = cat_nam;
    }
}