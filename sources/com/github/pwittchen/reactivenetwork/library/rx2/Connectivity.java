package com.github.pwittchen.reactivenetwork.library.rx2;

import a2.b.a.a.a;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
public class Connectivity {
    public NetworkInfo.State a;
    public NetworkInfo.DetailedState b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public String h;
    public String i;
    public String j;
    public String k;

    public static class Builder {
        public NetworkInfo.State a = NetworkInfo.State.DISCONNECTED;
        public NetworkInfo.DetailedState b = NetworkInfo.DetailedState.IDLE;
        public int c = -1;
        public int d = -1;
        public boolean e = false;
        public boolean f = false;
        public boolean g = false;
        public String h = "NONE";
        public String i = "NONE";
        public String j = "";
        public String k = "";

        public Builder available(boolean z) {
            this.e = z;
            return this;
        }

        public Connectivity build() {
            return new Connectivity(this);
        }

        public Builder detailedState(NetworkInfo.DetailedState detailedState) {
            this.b = detailedState;
            return this;
        }

        public Builder extraInfo(String str) {
            this.k = str;
            return this;
        }

        public Builder failover(boolean z) {
            this.f = z;
            return this;
        }

        public Builder reason(String str) {
            this.j = str;
            return this;
        }

        public Builder roaming(boolean z) {
            this.g = z;
            return this;
        }

        public Builder state(NetworkInfo.State state) {
            this.a = state;
            return this;
        }

        public Builder subType(int i2) {
            this.d = i2;
            return this;
        }

        public Builder subTypeName(String str) {
            this.i = str;
            return this;
        }

        public Builder type(int i2) {
            this.c = i2;
            return this;
        }

        public Builder typeName(String str) {
            this.h = str;
            return this;
        }
    }

    public Connectivity(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
    }

    public static Builder available(boolean z) {
        return new Builder().available(z);
    }

    public static Connectivity create(@NonNull Context context) {
        Preconditions.checkNotNull(context, "context == null");
        return create(context, (ConnectivityManager) context.getSystemService("connectivity"));
    }

    public static Builder extraInfo(String str) {
        return new Builder().extraInfo(str);
    }

    public static Builder failover(boolean z) {
        return new Builder().failover(z);
    }

    public static Builder reason(String str) {
        return new Builder().reason(str);
    }

    public static Builder roaming(boolean z) {
        return new Builder().roaming(z);
    }

    public static Builder state(NetworkInfo.DetailedState detailedState) {
        return new Builder().detailedState(detailedState);
    }

    public static Builder subType(int i2) {
        return new Builder().subType(i2);
    }

    public static Builder subTypeName(String str) {
        return new Builder().subTypeName(str);
    }

    public static Builder type(int i2) {
        return new Builder().type(i2);
    }

    public static Builder typeName(String str) {
        return new Builder().typeName(str);
    }

    public NetworkInfo.DetailedState detailedState() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Connectivity connectivity = (Connectivity) obj;
        if (this.c != connectivity.c || this.d != connectivity.d || this.e != connectivity.e || this.f != connectivity.f || this.g != connectivity.g || this.a != connectivity.a || this.b != connectivity.b || !this.h.equals(connectivity.h)) {
            return false;
        }
        String str = this.i;
        if (str == null ? connectivity.i != null : !str.equals(connectivity.i)) {
            return false;
        }
        String str2 = this.j;
        if (str2 == null ? connectivity.j != null : !str2.equals(connectivity.j)) {
            return false;
        }
        String str3 = this.k;
        String str4 = connectivity.k;
        if (str3 != null) {
            return str3.equals(str4);
        }
        if (str4 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        NetworkInfo.DetailedState detailedState = this.b;
        int i2 = 0;
        int B0 = a.B0(this.h, (((((((((((hashCode + (detailedState != null ? detailedState.hashCode() : 0)) * 31) + this.c) * 31) + this.d) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31, 31);
        String str = this.i;
        int hashCode2 = (B0 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.j;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.k;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        StringBuilder L = a.L("Connectivity{state=");
        L.append(this.a);
        L.append(", detailedState=");
        L.append(this.b);
        L.append(", type=");
        L.append(this.c);
        L.append(", subType=");
        L.append(this.d);
        L.append(", available=");
        L.append(this.e);
        L.append(", failover=");
        L.append(this.f);
        L.append(", roaming=");
        L.append(this.g);
        L.append(", typeName='");
        a.k1(L, this.h, '\'', ", subTypeName='");
        a.k1(L, this.i, '\'', ", reason='");
        a.k1(L, this.j, '\'', ", extraInfo='");
        L.append(this.k);
        L.append('\'');
        L.append('}');
        return L.toString();
    }

    public static Builder state(NetworkInfo.State state) {
        return new Builder().state(state);
    }

    public boolean available() {
        return this.e;
    }

    public String extraInfo() {
        return this.k;
    }

    public boolean failover() {
        return this.f;
    }

    public String reason() {
        return this.j;
    }

    public boolean roaming() {
        return this.g;
    }

    public int subType() {
        return this.d;
    }

    public String subTypeName() {
        return this.i;
    }

    public int type() {
        return this.c;
    }

    public String typeName() {
        return this.h;
    }

    public static Connectivity create(@NonNull Context context, ConnectivityManager connectivityManager) {
        Preconditions.checkNotNull(context, "context == null");
        if (connectivityManager == null) {
            return create();
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return create();
        }
        return new Builder().state(activeNetworkInfo.getState()).detailedState(activeNetworkInfo.getDetailedState()).type(activeNetworkInfo.getType()).subType(activeNetworkInfo.getSubtype()).available(activeNetworkInfo.isAvailable()).failover(activeNetworkInfo.isFailover()).roaming(activeNetworkInfo.isRoaming()).typeName(activeNetworkInfo.getTypeName()).subTypeName(activeNetworkInfo.getSubtypeName()).reason(activeNetworkInfo.getReason()).extraInfo(activeNetworkInfo.getExtraInfo()).build();
    }

    public NetworkInfo.State state() {
        return this.a;
    }

    public static Connectivity create() {
        return new Builder().build();
    }

    public Connectivity() {
        this(new Builder());
    }
}
