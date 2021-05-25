package com.jaredrummler.android.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import java.io.IOException;
public class ProcFile extends File implements Parcelable {
    public static final Parcelable.Creator<ProcFile> CREATOR = new a();
    public final String content;

    public static class a implements Parcelable.Creator<ProcFile> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ProcFile createFromParcel(Parcel parcel) {
            return new ProcFile(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ProcFile[] newArray(int i) {
            return new ProcFile[i];
        }
    }

    public ProcFile(String str) throws IOException {
        super(str);
        this.content = a(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033 A[SYNTHETIC, Splitter:B:16:0x0033] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r4) throws java.io.IOException {
        /*
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            r1.<init>()     // Catch:{ all -> 0x0030 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0030 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x0030 }
            r3.<init>(r4)     // Catch:{ all -> 0x0030 }
            r2.<init>(r3)     // Catch:{ all -> 0x0030 }
            java.lang.String r4 = r2.readLine()     // Catch:{ all -> 0x002d }
            java.lang.String r0 = ""
        L_0x0016:
            if (r4 == 0) goto L_0x0025
            r1.append(r0)     // Catch:{ all -> 0x002d }
            r1.append(r4)     // Catch:{ all -> 0x002d }
            java.lang.String r0 = "\n"
            java.lang.String r4 = r2.readLine()     // Catch:{ all -> 0x002d }
            goto L_0x0016
        L_0x0025:
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x002d }
            r2.close()     // Catch:{ IOException -> 0x002c }
        L_0x002c:
            return r4
        L_0x002d:
            r4 = move-exception
            r0 = r2
            goto L_0x0031
        L_0x0030:
            r4 = move-exception
        L_0x0031:
            if (r0 == 0) goto L_0x0036
            r0.close()     // Catch:{ IOException -> 0x0036 }
        L_0x0036:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jaredrummler.android.processes.models.ProcFile.a(java.lang.String):java.lang.String");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.io.File
    public long length() {
        return (long) this.content.length();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getAbsolutePath());
        parcel.writeString(this.content);
    }

    public ProcFile(Parcel parcel) {
        super(parcel.readString());
        this.content = parcel.readString();
    }
}
