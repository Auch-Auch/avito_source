package com.jaredrummler.android.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.IOException;
import java.util.Locale;
public class AndroidProcess implements Parcelable {
    public static final Parcelable.Creator<AndroidProcess> CREATOR = new a();
    public final String name;
    public final int pid;

    public static class a implements Parcelable.Creator<AndroidProcess> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public AndroidProcess createFromParcel(Parcel parcel) {
            return new AndroidProcess(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public AndroidProcess[] newArray(int i) {
            return new AndroidProcess[i];
        }
    }

    public AndroidProcess(int i) throws IOException {
        String str;
        this.pid = i;
        try {
            str = ProcFile.a(String.format(Locale.ENGLISH, "/proc/%d/cmdline", Integer.valueOf(i))).trim();
        } catch (IOException unused) {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                str = Stat.get(i).getComm();
            } catch (Exception unused2) {
                throw new IOException(String.format(Locale.ENGLISH, "Error reading /proc/%d/stat", Integer.valueOf(i)));
            }
        }
        this.name = str;
    }

    public String attr_current() throws IOException {
        return read("attr/current");
    }

    public Cgroup cgroup() throws IOException {
        return Cgroup.get(this.pid);
    }

    public String cmdline() throws IOException {
        return read("cmdline");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int oom_adj() throws IOException {
        return Integer.parseInt(read("oom_adj"));
    }

    public int oom_score() throws IOException {
        return Integer.parseInt(read("oom_score"));
    }

    public int oom_score_adj() throws IOException {
        return Integer.parseInt(read("oom_score_adj"));
    }

    public String read(String str) throws IOException {
        return ProcFile.a(String.format(Locale.ENGLISH, "/proc/%d/%s", Integer.valueOf(this.pid), str));
    }

    public Stat stat() throws IOException {
        return Stat.get(this.pid);
    }

    public Statm statm() throws IOException {
        return Statm.get(this.pid);
    }

    public Status status() throws IOException {
        return Status.get(this.pid);
    }

    public String wchan() throws IOException {
        return read("wchan");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeInt(this.pid);
    }

    public AndroidProcess(Parcel parcel) {
        this.name = parcel.readString();
        this.pid = parcel.readInt();
    }
}
