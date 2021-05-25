package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class pt {
    @NonNull
    public final rk a;
    @Nullable
    public final ps b;

    public pt(@NonNull rk rkVar, @Nullable ps psVar) {
        this.a = rkVar;
        this.b = psVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        pt ptVar = (pt) obj;
        if (!this.a.equals(ptVar.a)) {
            return false;
        }
        ps psVar = this.b;
        ps psVar2 = ptVar.b;
        if (psVar != null) {
            return psVar.equals(psVar2);
        }
        if (psVar2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        ps psVar = this.b;
        return hashCode + (psVar != null ? psVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder L = a.L("ForcedCollectingConfig{providerAccessFlags=");
        L.append(this.a);
        L.append(", arguments=");
        L.append(this.b);
        L.append('}');
        return L.toString();
    }
}
