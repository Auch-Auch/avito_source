package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.b;
import com.yandex.mobile.ads.impl.am;
import java.util.ArrayList;
import java.util.List;
public final class x<T> implements Parcelable {
    public static final Parcelable.Creator<x> CREATOR = new Parcelable.Creator<x>() { // from class: com.yandex.mobile.ads.impl.x.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ x createFromParcel(Parcel parcel) {
            return new x(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ x[] newArray(int i2) {
            return new x[i2];
        }
    };
    public static final Integer a = 100;
    private static final Integer b = 1000;
    private final int A;
    @Nullable
    private final b c;
    @Nullable
    private final String d;
    @Nullable
    private final String e;
    @Nullable
    private final String f;
    @NonNull
    private final am g;
    @Nullable
    private final List<String> h;
    @Nullable
    private final List<String> i;
    @Nullable
    private dk j;
    @Nullable
    private final List<Long> k;
    @Nullable
    private final List<Integer> l;
    @Nullable
    private final String m;
    @Nullable
    private final String n;
    @Nullable
    private final String o;
    @Nullable
    private final bm p;
    @Nullable
    private final bq q;
    @Nullable
    private final T r;
    private final boolean s;
    private final boolean t;
    private final boolean u;
    private final int v;
    private final int w;
    private final int x;
    private final int y;
    private final int z;

    public static class a<T> {
        @Nullable
        private b a;
        @Nullable
        private String b;
        @Nullable
        private String c;
        @Nullable
        private String d;
        @Nullable
        private am.a e;
        @Nullable
        private List<String> f;
        @Nullable
        private List<String> g;
        @Nullable
        private dk h;
        @Nullable
        private List<Long> i;
        @Nullable
        private List<Integer> j;
        @Nullable
        private String k;
        @Nullable
        private bm l;
        @Nullable
        private bq m;
        @Nullable
        private T n;
        @Nullable
        private String o;
        @Nullable
        private String p;
        private int q;
        private int r;
        private int s;
        private int t;
        private int u;
        private int v;
        private boolean w;
        private boolean x;
        private boolean y;

        @NonNull
        public final a<T> a(@NonNull b bVar) {
            this.a = bVar;
            return this;
        }

        @NonNull
        public final a<T> b(@NonNull String str) {
            this.c = str;
            return this;
        }

        @NonNull
        public final a<T> c(@Nullable String str) {
            this.d = str;
            return this;
        }

        @NonNull
        public final a<T> d(@NonNull List<Integer> list) {
            this.j = list;
            return this;
        }

        @NonNull
        public final a<T> e(int i2) {
            this.v = i2;
            return this;
        }

        @NonNull
        public final a<T> f(int i2) {
            this.s = i2;
            return this;
        }

        @NonNull
        public final a<T> a(@NonNull String str) {
            this.b = str;
            return this;
        }

        @NonNull
        public final a<T> b(int i2) {
            this.r = i2;
            return this;
        }

        @NonNull
        public final a<T> c(@NonNull List<Long> list) {
            this.i = list;
            return this;
        }

        @NonNull
        public final a<T> d(int i2) {
            this.u = i2;
            return this;
        }

        @NonNull
        public final a<T> e(@Nullable String str) {
            this.o = str;
            return this;
        }

        @NonNull
        public final a<T> f(@Nullable String str) {
            this.p = str;
            return this;
        }

        @NonNull
        public final a<T> a(int i2) {
            this.q = i2;
            return this;
        }

        @NonNull
        public final a<T> b(@NonNull List<String> list) {
            this.g = list;
            return this;
        }

        @NonNull
        public final a<T> c(int i2) {
            this.t = i2;
            return this;
        }

        @NonNull
        public final a<T> d(@Nullable String str) {
            this.k = str;
            return this;
        }

        @NonNull
        public final a<T> a(@Nullable am.a aVar) {
            this.e = aVar;
            return this;
        }

        @NonNull
        public final a<T> b(boolean z) {
            this.x = z;
            return this;
        }

        @NonNull
        public final a<T> c(boolean z) {
            this.y = z;
            return this;
        }

        @NonNull
        public final a<T> a(@NonNull List<String> list) {
            this.f = list;
            return this;
        }

        @NonNull
        public final a<T> a(@Nullable dk dkVar) {
            this.h = dkVar;
            return this;
        }

        @NonNull
        public final a<T> a(@Nullable bm bmVar) {
            this.l = bmVar;
            return this;
        }

        @NonNull
        public final a<T> a(@Nullable T t2) {
            this.n = t2;
            return this;
        }

        @NonNull
        public final a<T> a(@NonNull bq bqVar) {
            this.m = bqVar;
            return this;
        }

        @NonNull
        public final a<T> a(boolean z) {
            this.w = z;
            return this;
        }

        @NonNull
        public final x<T> a() {
            return new x<>(this, (byte) 0);
        }
    }

    public /* synthetic */ x(a aVar, byte b2) {
        this(aVar);
    }

    public final boolean A() {
        return this.u;
    }

    @Nullable
    public final b a() {
        return this.c;
    }

    @Nullable
    public final String b() {
        return this.d;
    }

    @Nullable
    public final String c() {
        return this.e;
    }

    @Nullable
    public final String d() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @NonNull
    public final am e() {
        return this.g;
    }

    @Nullable
    public final List<String> f() {
        return this.h;
    }

    @Nullable
    public final List<String> g() {
        return this.i;
    }

    @Nullable
    public final dk h() {
        return this.j;
    }

    @Nullable
    public final List<Long> i() {
        return this.k;
    }

    @Nullable
    public final List<Integer> j() {
        return this.l;
    }

    @Nullable
    public final String k() {
        return this.m;
    }

    @Nullable
    public final String l() {
        return this.n;
    }

    @Nullable
    public final String m() {
        return this.o;
    }

    @Nullable
    public final bm n() {
        return this.p;
    }

    @Nullable
    public final bq o() {
        return this.q;
    }

    @Nullable
    public final T p() {
        return this.r;
    }

    public final int q() {
        return this.z;
    }

    public final int r() {
        return this.A;
    }

    public final int s() {
        return this.w;
    }

    public final int t() {
        return this.v;
    }

    public final int u() {
        return b.intValue() * this.w;
    }

    public final int v() {
        return b.intValue() * this.x;
    }

    public final boolean w() {
        return this.A == 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i2) {
        b bVar = this.c;
        parcel.writeInt(bVar == null ? -1 : bVar.ordinal());
        parcel.writeString(this.f);
        parcel.writeString(this.d);
        parcel.writeString(this.n);
        parcel.writeParcelable(this.g, i2);
        parcel.writeInt(this.z);
        parcel.writeInt(this.A);
        parcel.writeStringList(this.h);
        parcel.writeStringList(this.i);
        parcel.writeList(this.k);
        parcel.writeList(this.l);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeInt(this.x);
        parcel.writeInt(this.y);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeParcelable(this.p, i2);
        parcel.writeParcelable(this.q, i2);
        parcel.writeSerializable(this.r.getClass());
        parcel.writeValue(this.r);
        parcel.writeByte(this.s ? (byte) 1 : 0);
        parcel.writeByte(this.t ? (byte) 1 : 0);
        parcel.writeByte(this.u ? (byte) 1 : 0);
    }

    public final boolean x() {
        return this.w > 0;
    }

    public final boolean y() {
        return this.s;
    }

    public final boolean z() {
        return this.t;
    }

    private x(@NonNull a<T> aVar) {
        this.c = ((a) aVar).a;
        this.f = ((a) aVar).d;
        this.d = ((a) aVar).b;
        this.e = ((a) aVar).c;
        int i2 = ((a) aVar).q;
        this.z = i2;
        int i3 = ((a) aVar).r;
        this.A = i3;
        this.g = new am(i2, i3, ((a) aVar).e != null ? ((a) aVar).e : am.a.FIXED);
        this.h = ((a) aVar).f;
        this.i = ((a) aVar).g;
        this.k = ((a) aVar).i;
        this.l = ((a) aVar).j;
        this.j = ((a) aVar).h;
        this.v = ((a) aVar).s;
        this.w = ((a) aVar).t;
        this.x = ((a) aVar).u;
        this.y = ((a) aVar).v;
        this.m = ((a) aVar).o;
        this.n = ((a) aVar).k;
        this.o = ((a) aVar).p;
        this.r = (T) ((a) aVar).n;
        this.p = ((a) aVar).l;
        this.q = ((a) aVar).m;
        this.s = ((a) aVar).w;
        this.t = ((a) aVar).x;
        this.u = ((a) aVar).y;
    }

    public x(@NonNull Parcel parcel) {
        b bVar;
        int readInt = parcel.readInt();
        T t2 = null;
        if (readInt == -1) {
            bVar = null;
        } else {
            bVar = b.values()[readInt];
        }
        this.c = bVar;
        this.f = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.g = (am) parcel.readParcelable(am.class.getClassLoader());
        this.z = parcel.readInt();
        this.A = parcel.readInt();
        this.h = parcel.createStringArrayList();
        this.i = parcel.createStringArrayList();
        ArrayList arrayList = new ArrayList();
        this.k = arrayList;
        parcel.readList(arrayList, Long.class.getClassLoader());
        ArrayList arrayList2 = new ArrayList();
        this.l = arrayList2;
        parcel.readList(arrayList2, Integer.class.getClassLoader());
        this.v = parcel.readInt();
        this.w = parcel.readInt();
        this.x = parcel.readInt();
        this.y = parcel.readInt();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = (bm) parcel.readParcelable(bm.class.getClassLoader());
        this.q = (bq) parcel.readParcelable(bq.class.getClassLoader());
        Class cls = (Class) parcel.readSerializable();
        this.r = cls != null ? (T) parcel.readValue(cls.getClassLoader()) : t2;
        boolean z2 = true;
        this.s = parcel.readByte() != 0;
        this.t = parcel.readByte() != 0;
        this.u = parcel.readByte() == 0 ? false : z2;
    }
}
