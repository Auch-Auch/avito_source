package com.jaredrummler.android.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;
public class ControlGroup implements Parcelable {
    public static final Parcelable.Creator<ControlGroup> CREATOR = new a();
    public final String group;
    public final int id;
    public final String subsystems;

    public static class a implements Parcelable.Creator<ControlGroup> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ControlGroup createFromParcel(Parcel parcel) {
            return new ControlGroup(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ControlGroup[] newArray(int i) {
            return new ControlGroup[i];
        }
    }

    public ControlGroup(String str) throws NumberFormatException, IndexOutOfBoundsException {
        String[] split = str.split(":");
        this.id = Integer.parseInt(split[0]);
        this.subsystems = split[1];
        this.group = split[2];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format(Locale.ENGLISH, "%d:%s:%s", Integer.valueOf(this.id), this.subsystems, this.group);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.subsystems);
        parcel.writeString(this.group);
    }

    public ControlGroup(Parcel parcel) {
        this.id = parcel.readInt();
        this.subsystems = parcel.readString();
        this.group = parcel.readString();
    }
}
