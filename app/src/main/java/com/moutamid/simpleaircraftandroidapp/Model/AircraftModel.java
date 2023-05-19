package com.moutamid.simpleaircraftandroidapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class AircraftModel implements Parcelable {

    private int id;
    private String reg;
    private String op;
    private String owner;
    private String country;
    private String base;
    private String status;
    private String notes;
    private boolean isSAR;
    private boolean isOG;
    private boolean isNotContracted;
    private String imageName;
    private String category;
    private String yearbuilt;
    private double lat;
    private double lng;

    public AircraftModel(){

    }

    public AircraftModel(int id, String reg, String op, String owner, String country, String base, String status, String notes, boolean isSAR, boolean isOG, boolean isNotContracted, String imageName, String category, String yearbuilt, double lat, double lng) {
        this.id = id;
        this.reg = reg;
        this.op = op;
        this.owner = owner;
        this.country = country;
        this.base = base;
        this.status = status;
        this.notes = notes;
        this.isSAR = isSAR;
        this.isOG = isOG;
        this.isNotContracted = isNotContracted;
        this.imageName = imageName;
        this.category = category;
        this.yearbuilt = yearbuilt;
        this.lat = lat;
        this.lng = lng;
    }

    protected AircraftModel(Parcel in) {
        id = in.readInt();
        reg = in.readString();
        op = in.readString();
        owner = in.readString();
        country = in.readString();
        base = in.readString();
        status = in.readString();
        notes = in.readString();
        isSAR = in.readByte() != 0;
        isOG = in.readByte() != 0;
        isNotContracted = in.readByte() != 0;
        imageName = in.readString();
        category = in.readString();
        yearbuilt = in.readString();
        lat = in.readDouble();
        lng = in.readDouble();
    }

    public static final Creator<AircraftModel> CREATOR = new Creator<AircraftModel>() {
        @Override
        public AircraftModel createFromParcel(Parcel in) {
            return new AircraftModel(in);
        }

        @Override
        public AircraftModel[] newArray(int size) {
            return new AircraftModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isSAR() {
        return isSAR;
    }

    public void setSAR(boolean SAR) {
        isSAR = SAR;
    }

    public boolean isOG() {
        return isOG;
    }

    public void setOG(boolean OG) {
        isOG = OG;
    }

    public boolean isNotContracted() {
        return isNotContracted;
    }

    public void setNotContracted(boolean notContracted) {
        isNotContracted = notContracted;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getYearbuilt() {
        return yearbuilt;
    }

    public void setYearbuilt(String yearbuilt) {
        this.yearbuilt = yearbuilt;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(reg);
        dest.writeString(op);
        dest.writeString(owner);
        dest.writeString(country);
        dest.writeString(base);
        dest.writeString(status);
        dest.writeString(notes);
        dest.writeByte((byte) (isSAR ? 1 : 0));
        dest.writeByte((byte) (isOG ? 1 : 0));
        dest.writeByte((byte) (isNotContracted ? 1 : 0));
        dest.writeString(imageName);
        dest.writeString(category);
        dest.writeString(yearbuilt);
        dest.writeDouble(lat);
        dest.writeDouble(lng);
    }
}
