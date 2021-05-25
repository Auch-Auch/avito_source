package com.jaredrummler.android.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;
import java.util.Locale;
public final class Stat extends ProcFile {
    public static final Parcelable.Creator<Stat> CREATOR = new a();
    public final String[] a;

    public static class a implements Parcelable.Creator<Stat> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public Stat createFromParcel(Parcel parcel) {
            return new Stat(parcel, null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public Stat[] newArray(int i) {
            return new Stat[i];
        }
    }

    public Stat(String str) throws IOException {
        super(str);
        this.a = this.content.split("\\s+");
    }

    public static Stat get(int i) throws IOException {
        return new Stat(String.format(Locale.ENGLISH, "/proc/%d/stat", Integer.valueOf(i)));
    }

    public long arg_end() {
        return Long.parseLong(this.a[48]);
    }

    public long arg_start() {
        return Long.parseLong(this.a[47]);
    }

    public long blocked() {
        return Long.parseLong(this.a[31]);
    }

    public long cguest_time() {
        return Long.parseLong(this.a[43]);
    }

    public long cmajflt() {
        return Long.parseLong(this.a[12]);
    }

    public long cminflt() {
        return Long.parseLong(this.a[10]);
    }

    public long cnswap() {
        return Long.parseLong(this.a[36]);
    }

    public long cstime() {
        return Long.parseLong(this.a[16]);
    }

    public long cutime() {
        return Long.parseLong(this.a[15]);
    }

    public long delayacct_blkio_ticks() {
        return Long.parseLong(this.a[41]);
    }

    public long end_data() {
        return Long.parseLong(this.a[45]);
    }

    public long endcode() {
        return Long.parseLong(this.a[26]);
    }

    public long env_end() {
        return Long.parseLong(this.a[50]);
    }

    public long env_start() {
        return Long.parseLong(this.a[49]);
    }

    public int exit_code() {
        return Integer.parseInt(this.a[51]);
    }

    public int exit_signal() {
        return Integer.parseInt(this.a[37]);
    }

    public int flags() {
        return Integer.parseInt(this.a[8]);
    }

    public String getComm() {
        return this.a[1].replace("(", "").replace(")", "");
    }

    public int getPid() {
        return Integer.parseInt(this.a[0]);
    }

    public long guest_time() {
        return Long.parseLong(this.a[42]);
    }

    public long itrealvalue() {
        return Long.parseLong(this.a[20]);
    }

    public long kstkeip() {
        return Long.parseLong(this.a[29]);
    }

    public long kstkesp() {
        return Long.parseLong(this.a[28]);
    }

    public long majflt() {
        return Long.parseLong(this.a[11]);
    }

    public long minflt() {
        return Long.parseLong(this.a[9]);
    }

    public int nice() {
        return Integer.parseInt(this.a[18]);
    }

    public long nswap() {
        return Long.parseLong(this.a[35]);
    }

    public long num_threads() {
        return Long.parseLong(this.a[19]);
    }

    public int pgrp() {
        return Integer.parseInt(this.a[4]);
    }

    public int policy() {
        return Integer.parseInt(this.a[40]);
    }

    public int ppid() {
        return Integer.parseInt(this.a[3]);
    }

    public long priority() {
        return Long.parseLong(this.a[17]);
    }

    public int processor() {
        return Integer.parseInt(this.a[38]);
    }

    public long rss() {
        return Long.parseLong(this.a[23]);
    }

    public long rsslim() {
        return Long.parseLong(this.a[24]);
    }

    public int rt_priority() {
        return Integer.parseInt(this.a[39]);
    }

    public int session() {
        return Integer.parseInt(this.a[5]);
    }

    public long sigcatch() {
        return Long.parseLong(this.a[33]);
    }

    public long sigignore() {
        return Long.parseLong(this.a[32]);
    }

    public long signal() {
        return Long.parseLong(this.a[30]);
    }

    public long start_brk() {
        return Long.parseLong(this.a[46]);
    }

    public long start_data() {
        return Long.parseLong(this.a[44]);
    }

    public long startcode() {
        return Long.parseLong(this.a[25]);
    }

    public long startstack() {
        return Long.parseLong(this.a[27]);
    }

    public long starttime() {
        return Long.parseLong(this.a[21]);
    }

    public char state() {
        return this.a[2].charAt(0);
    }

    public long stime() {
        return Long.parseLong(this.a[14]);
    }

    public int tpgid() {
        return Integer.parseInt(this.a[7]);
    }

    public int tty_nr() {
        return Integer.parseInt(this.a[6]);
    }

    public long utime() {
        return Long.parseLong(this.a[13]);
    }

    public long vsize() {
        return Long.parseLong(this.a[22]);
    }

    public long wchan() {
        return Long.parseLong(this.a[34]);
    }

    @Override // com.jaredrummler.android.processes.models.ProcFile, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeStringArray(this.a);
    }

    public Stat(Parcel parcel, a aVar) {
        super(parcel);
        this.a = parcel.createStringArray();
    }
}
