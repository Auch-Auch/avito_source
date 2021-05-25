package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.bt;
import com.my.target.common.models.AudioData;
import com.my.target.common.models.VideoData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class cr<T extends bt> extends cn {
    @NonNull
    public final String b;
    @NonNull
    public final ArrayList<cf<T>> c = new ArrayList<>();
    @NonNull
    public final ArrayList<bp> d = new ArrayList<>();
    @NonNull
    public final ArrayList<bp> e = new ArrayList<>();
    @NonNull
    public final ArrayList<bp> f = new ArrayList<>();
    public int g = 10;
    public int h = -1;

    public cr(@NonNull String str) {
        this.b = str;
    }

    @NonNull
    public static cr<VideoData> x(@NonNull String str) {
        return new cr<>(str);
    }

    @NonNull
    public static cr<AudioData> y(@NonNull String str) {
        return new cr<>(str);
    }

    public void a(@NonNull cf<T> cfVar, int i) {
        int size = this.c.size();
        if (i >= 0 && i <= size) {
            this.c.add(i, cfVar);
            Iterator<bp> it = this.f.iterator();
            while (it.hasNext()) {
                bp next = it.next();
                int position = next.getPosition();
                if (position >= i) {
                    next.setPosition(position + 1);
                }
            }
        }
    }

    public void b(@NonNull cr<T> crVar) {
        this.c.addAll(crVar.c);
        this.d.addAll(crVar.d);
        this.e.addAll(crVar.e);
    }

    public int bY() {
        return this.g;
    }

    public int bZ() {
        return this.h;
    }

    public void c(@NonNull bp bpVar) {
        (bpVar.ba() ? this.e : bpVar.aY() ? this.d : this.f).add(bpVar);
    }

    @NonNull
    public List<cf<T>> ca() {
        return new ArrayList(this.c);
    }

    @NonNull
    public ArrayList<bp> cb() {
        return new ArrayList<>(this.e);
    }

    @Nullable
    public bp cc() {
        if (this.d.size() > 0) {
            return this.d.remove(0);
        }
        return null;
    }

    public void cd() {
        this.f.clear();
    }

    public boolean ce() {
        return !this.e.isEmpty() || !this.d.isEmpty();
    }

    public void g(@NonNull cf<T> cfVar) {
        this.c.add(cfVar);
    }

    @Override // com.my.target.cn
    public int getBannersCount() {
        return this.c.size();
    }

    @NonNull
    public String getName() {
        return this.b;
    }

    @NonNull
    public ArrayList<bp> j(float f2) {
        ArrayList<bp> arrayList = new ArrayList<>();
        Iterator<bp> it = this.e.iterator();
        while (it.hasNext()) {
            bp next = it.next();
            if (next.getPoint() == f2) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            this.e.removeAll(arrayList);
        }
        return arrayList;
    }

    public void s(int i) {
        this.g = i;
    }

    public void t(int i) {
        this.h = i;
    }
}
