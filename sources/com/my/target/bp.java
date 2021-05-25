package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
public class bp {
    @Nullable
    public Boolean A;
    @NonNull
    public final String a;
    @NonNull
    public final ArrayList<bp> b = new ArrayList<>();
    @NonNull
    public final ArrayList<cy> c = new ArrayList<>();
    @NonNull
    public final cz d = cz.cx();
    @Nullable
    public ArrayList<cy> e;
    @Nullable
    public ArrayList<bz> f;
    @Nullable
    public bp g;
    @Nullable
    public String h;
    @Nullable
    public String i;
    public int j;
    public int k = -1;
    public int l = -1;
    public int m = -1;
    public float n = -1.0f;
    public float o = -1.0f;
    public boolean p;
    public boolean q;
    public boolean r;
    public float s = -1.0f;
    @Nullable
    public Boolean t;
    @Nullable
    public Boolean u;
    @Nullable
    public Boolean v;
    @Nullable
    public Boolean w;
    @Nullable
    public Boolean x;
    @Nullable
    public Boolean y;
    @Nullable
    public Boolean z;

    public bp(@NonNull String str) {
        this.a = str;
    }

    @NonNull
    public static bp p(@NonNull String str) {
        return new bp(str);
    }

    public void a(@Nullable bp bpVar) {
        this.g = bpVar;
        if (bpVar != null) {
            bpVar.setPosition(this.l);
        }
    }

    public void a(cy cyVar) {
        this.c.add(cyVar);
    }

    public void a(@Nullable Boolean bool) {
        this.t = bool;
    }

    public boolean aY() {
        return this.q;
    }

    public int aZ() {
        return this.m;
    }

    public void b(@NonNull bp bpVar) {
        this.b.add(bpVar);
    }

    public void b(@Nullable Boolean bool) {
        this.u = bool;
    }

    public void b(@Nullable ArrayList<bz> arrayList) {
        this.f = arrayList;
    }

    public boolean ba() {
        return this.r;
    }

    @Nullable
    public bp bb() {
        return this.g;
    }

    @NonNull
    public ArrayList<bp> bc() {
        return this.b;
    }

    @Nullable
    public ArrayList<cy> bd() {
        if (this.e != null) {
            return new ArrayList<>(this.e);
        }
        return null;
    }

    public int be() {
        return this.j;
    }

    @Nullable
    public String bf() {
        return this.h;
    }

    @Nullable
    public Boolean bg() {
        return this.t;
    }

    @Nullable
    public Boolean bh() {
        return this.u;
    }

    @Nullable
    public Boolean bi() {
        return this.v;
    }

    @Nullable
    public Boolean bj() {
        return this.w;
    }

    @Nullable
    public Boolean bk() {
        return this.x;
    }

    @NonNull
    public cz bl() {
        return this.d;
    }

    @Nullable
    public Boolean bm() {
        return this.y;
    }

    @Nullable
    public Boolean bn() {
        return this.z;
    }

    @Nullable
    public Boolean bo() {
        return this.A;
    }

    public void c(@Nullable Boolean bool) {
        this.v = bool;
    }

    public void c(@Nullable ArrayList<cy> arrayList) {
        this.e = arrayList;
    }

    public void d(@Nullable Boolean bool) {
        this.w = bool;
    }

    public void d(@Nullable ArrayList<cy> arrayList) {
        ArrayList<cy> arrayList2 = this.e;
        if (arrayList2 == null) {
            this.e = arrayList;
        } else if (arrayList != null) {
            arrayList2.addAll(arrayList);
        }
    }

    public void e(@Nullable Boolean bool) {
        this.x = bool;
    }

    public void f(int i2) {
        this.j = i2;
    }

    public void f(@Nullable Boolean bool) {
        this.y = bool;
    }

    public void g(int i2) {
        this.m = i2;
    }

    public void g(@Nullable Boolean bool) {
        this.z = bool;
    }

    public float getAllowCloseDelay() {
        return this.s;
    }

    @Nullable
    public ArrayList<bz> getCompanionBanners() {
        return this.f;
    }

    @Nullable
    public String getCtaText() {
        return this.i;
    }

    public int getId() {
        return this.k;
    }

    public float getPoint() {
        return this.n;
    }

    public float getPointP() {
        return this.o;
    }

    public int getPosition() {
        return this.l;
    }

    @NonNull
    public String getUrl() {
        return this.a;
    }

    public void h(@Nullable Boolean bool) {
        this.A = bool;
    }

    public boolean isCached() {
        return this.p;
    }

    @NonNull
    public ArrayList<cy> q(@NonNull String str) {
        ArrayList<cy> arrayList = new ArrayList<>();
        Iterator<cy> it = this.c.iterator();
        while (it.hasNext()) {
            cy next = it.next();
            if (str.equals(next.getType())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void r(@Nullable String str) {
        this.h = str;
    }

    public void r(boolean z2) {
        this.q = z2;
    }

    public void s(boolean z2) {
        this.p = z2;
    }

    public void setAllowCloseDelay(float f2) {
        this.s = f2;
    }

    public void setCtaText(@Nullable String str) {
        this.i = str;
    }

    public void setId(int i2) {
        this.k = i2;
    }

    public void setPoint(float f2) {
        this.n = f2;
    }

    public void setPointP(float f2) {
        this.o = f2;
    }

    public void setPosition(int i2) {
        this.l = i2;
        bp bpVar = this.g;
        if (bpVar != null) {
            bpVar.setPosition(i2);
        }
    }

    public void t(boolean z2) {
        this.r = z2;
    }
}
