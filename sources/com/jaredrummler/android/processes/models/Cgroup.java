package com.jaredrummler.android.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
public final class Cgroup extends ProcFile {
    public static final Parcelable.Creator<Cgroup> CREATOR = new a();
    public final ArrayList<ControlGroup> groups;

    public static class a implements Parcelable.Creator<Cgroup> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public Cgroup createFromParcel(Parcel parcel) {
            return new Cgroup(parcel, null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public Cgroup[] newArray(int i) {
            return new Cgroup[i];
        }
    }

    public Cgroup(String str) throws IOException {
        super(str);
        String[] split = this.content.split("\n");
        this.groups = new ArrayList<>();
        for (String str2 : split) {
            try {
                this.groups.add(new ControlGroup(str2));
            } catch (Exception unused) {
            }
        }
    }

    public static Cgroup get(int i) throws IOException {
        return new Cgroup(String.format(Locale.ENGLISH, "/proc/%d/cgroup", Integer.valueOf(i)));
    }

    public ControlGroup getGroup(String str) {
        Iterator<ControlGroup> it = this.groups.iterator();
        while (it.hasNext()) {
            ControlGroup next = it.next();
            String[] split = next.subsystems.split(",");
            int length = split.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (split[i].equals(str)) {
                        return next;
                    }
                    i++;
                }
            }
        }
        return null;
    }

    @Override // com.jaredrummler.android.processes.models.ProcFile, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.groups);
    }

    public Cgroup(Parcel parcel, a aVar) {
        super(parcel);
        this.groups = parcel.createTypedArrayList(ControlGroup.CREATOR);
    }
}
