package com.jaredrummler.android.processes.models;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Parcel;
import android.os.Parcelable;
import com.jaredrummler.android.processes.AndroidProcesses;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
public class AndroidAppProcess extends AndroidProcess {
    public static final Parcelable.Creator<AndroidAppProcess> CREATOR = new a();
    public static final boolean a = new File("/dev/cpuctl/tasks").exists();
    public static final Pattern b = Pattern.compile("^([A-Za-z]{1}[A-Za-z0-9_]*[\\.|:])*[A-Za-z][A-Za-z0-9_]*$");
    public final boolean foreground;
    public final int uid;

    public static final class NotAndroidAppProcessException extends Exception {
        public NotAndroidAppProcessException(int i) {
            super(String.format("The process %d does not belong to any application", Integer.valueOf(i)));
        }
    }

    public static class a implements Parcelable.Creator<AndroidAppProcess> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public AndroidAppProcess createFromParcel(Parcel parcel) {
            return new AndroidAppProcess(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public AndroidAppProcess[] newArray(int i) {
            return new AndroidAppProcess[i];
        }
    }

    public AndroidAppProcess(int i) throws IOException, NotAndroidAppProcessException {
        super(i);
        int i2;
        boolean z;
        String str = this.name;
        if (str == null || !b.matcher(str).matches() || !new File("/data/data", getPackageName()).exists()) {
            throw new NotAndroidAppProcessException(i);
        }
        if (a) {
            Cgroup cgroup = cgroup();
            ControlGroup group = cgroup.getGroup("cpuacct");
            ControlGroup group2 = cgroup.getGroup("cpu");
            if (group2 == null || group == null || !group.group.contains("pid_")) {
                throw new NotAndroidAppProcessException(i);
            }
            z = !group2.group.contains("bg_non_interactive");
            try {
                i2 = Integer.parseInt(group.group.split("/")[1].replace("uid_", ""));
            } catch (Exception unused) {
                i2 = status().getUid();
            }
            AndroidProcesses.log("name=%s, pid=%d, uid=%d, foreground=%b, cpuacct=%s, cpu=%s", this.name, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), group.toString(), group2.toString());
        } else {
            Stat stat = stat();
            Status status = status();
            z = stat.policy() == 0;
            i2 = status.getUid();
            AndroidProcesses.log("name=%s, pid=%d, uid=%d foreground=%b", this.name, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
        }
        this.foreground = z;
        this.uid = i2;
    }

    public PackageInfo getPackageInfo(Context context, int i) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(getPackageName(), i);
    }

    public String getPackageName() {
        return this.name.split(":")[0];
    }

    @Override // com.jaredrummler.android.processes.models.AndroidProcess, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.foreground ? (byte) 1 : 0);
        parcel.writeInt(this.uid);
    }

    public AndroidAppProcess(Parcel parcel) {
        super(parcel);
        this.foreground = parcel.readByte() != 0;
        this.uid = parcel.readInt();
    }
}
