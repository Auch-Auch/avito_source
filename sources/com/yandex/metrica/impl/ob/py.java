package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class py {
    @NonNull
    public final rk a;
    @Nullable
    public final pw b;

    public py(@NonNull rk rkVar, @Nullable pw pwVar) {
        this.a = rkVar;
        this.b = pwVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        py pyVar = (py) obj;
        if (!this.a.equals(pyVar.a)) {
            return false;
        }
        pw pwVar = this.b;
        pw pwVar2 = pyVar.b;
        if (pwVar != null) {
            return pwVar.equals(pwVar2);
        }
        if (pwVar2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        pw pwVar = this.b;
        return hashCode + (pwVar != null ? pwVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder L = a.L("GplCollectingConfig{providerAccessFlags=");
        L.append(this.a);
        L.append(", arguments=");
        L.append(this.b);
        L.append('}');
        return L.toString();
    }
}
