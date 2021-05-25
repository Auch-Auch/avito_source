package com.jaredrummler.android.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;
import java.util.Locale;
public final class Statm extends ProcFile {
    public static final Parcelable.Creator<Statm> CREATOR = new a();
    public final String[] fields;

    public static class a implements Parcelable.Creator<Statm> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public Statm createFromParcel(Parcel parcel) {
            return new Statm(parcel, null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public Statm[] newArray(int i) {
            return new Statm[i];
        }
    }

    public Statm(String str) throws IOException {
        super(str);
        this.fields = this.content.split("\\s+");
    }

    public static Statm get(int i) throws IOException {
        return new Statm(String.format(Locale.ENGLISH, "/proc/%d/statm", Integer.valueOf(i)));
    }

    public long getResidentSetSize() {
        return Long.parseLong(this.fields[1]) * 1024;
    }

    public long getSize() {
        return Long.parseLong(this.fields[0]) * 1024;
    }

    @Override // com.jaredrummler.android.processes.models.ProcFile, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeStringArray(this.fields);
    }

    public Statm(Parcel parcel, a aVar) {
        super(parcel);
        this.fields = parcel.createStringArray();
    }
}
