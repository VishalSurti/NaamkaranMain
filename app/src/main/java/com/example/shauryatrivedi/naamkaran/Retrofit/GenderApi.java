package com.example.shauryatrivedi.naamkaran.Retrofit;

public class GenderApi {
String id;
String category_id;
String name;
String meaning;
String gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public GenderApi(String id, String category_id, String name, String meaning, String gender) {

        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.meaning = meaning;
        this.gender = gender;
    }
}
