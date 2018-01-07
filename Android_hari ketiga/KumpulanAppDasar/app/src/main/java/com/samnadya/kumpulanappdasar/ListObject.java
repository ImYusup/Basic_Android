package com.samnadya.kumpulanappdasar;

/**
 * Created by SamNadya on 15/11/2016.
 */

public class ListObject {

    String company, sub;
    int image_id;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public void setAll(int img_id, String title, String sub) {
        setImage_id(img_id);
        setCompany(title);
        setSub(sub);
    }
}
