package com.tbruyelle.rxpermissions3;

import a2.b.a.a.a;
import a2.r.a.b;
import a2.r.a.c;
import a2.r.a.d;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
public class Permission {
    public final boolean granted;
    public final String name;
    public final boolean shouldShowRequestPermissionRationale;

    public Permission(String str, boolean z) {
        this(str, z, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Permission permission = (Permission) obj;
        if (this.granted == permission.granted && this.shouldShowRequestPermissionRationale == permission.shouldShowRequestPermissionRationale) {
            return this.name.equals(permission.name);
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + (this.granted ? 1 : 0)) * 31) + (this.shouldShowRequestPermissionRationale ? 1 : 0);
    }

    public String toString() {
        StringBuilder L = a.L("Permission{name='");
        a.k1(L, this.name, '\'', ", granted=");
        L.append(this.granted);
        L.append(", shouldShowRequestPermissionRationale=");
        return a.A(L, this.shouldShowRequestPermissionRationale, '}');
    }

    public Permission(String str, boolean z, boolean z2) {
        this.name = str;
        this.granted = z;
        this.shouldShowRequestPermissionRationale = z2;
    }

    public Permission(List<Permission> list) {
        this.name = ((StringBuilder) Observable.fromIterable(list).map(new b(this)).collectInto(new StringBuilder(), new a2.r.a.a(this)).blockingGet()).toString();
        this.granted = Observable.fromIterable(list).all(new c(this)).blockingGet().booleanValue();
        this.shouldShowRequestPermissionRationale = Observable.fromIterable(list).any(new d(this)).blockingGet().booleanValue();
    }
}
