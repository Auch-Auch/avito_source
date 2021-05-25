package com.jaredrummler.android.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;
import java.util.Locale;
public final class Status extends ProcFile {
    public static final Parcelable.Creator<Status> CREATOR = new a();

    public static class a implements Parcelable.Creator<Status> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public Status createFromParcel(Parcel parcel) {
            return new Status(parcel, null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public Status[] newArray(int i) {
            return new Status[i];
        }
    }

    public Status(String str) throws IOException {
        super(str);
    }

    public static Status get(int i) throws IOException {
        return new Status(String.format(Locale.ENGLISH, "/proc/%d/status", Integer.valueOf(i)));
    }

    public int getGid() {
        try {
            return Integer.parseInt(getValue("Gid").split("\\s+")[0]);
        } catch (Exception unused) {
            return -1;
        }
    }

    public int getUid() {
        try {
            return Integer.parseInt(getValue("Uid").split("\\s+")[0]);
        } catch (Exception unused) {
            return -1;
        }
    }

    public String getValue(String str) {
        String[] split = this.content.split("\n");
        for (String str2 : split) {
            if (str2.startsWith(str + ":")) {
                return str2.split(str + ":")[1].trim();
            }
        }
        return null;
    }

    public Status(Parcel parcel, a aVar) {
        super(parcel);
    }
}
