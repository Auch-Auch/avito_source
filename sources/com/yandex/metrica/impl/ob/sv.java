package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class sv implements sm {
    @NonNull
    private Set<String> a;

    public sv(@Nullable List<sr> list) {
        if (list == null) {
            this.a = new HashSet();
            return;
        }
        this.a = new HashSet(list.size());
        for (sr srVar : list) {
            if (srVar.b) {
                this.a.add(srVar.a);
            }
        }
    }

    @Override // com.yandex.metrica.impl.ob.sm
    public boolean a(@NonNull String str) {
        return this.a.contains(str);
    }

    public String toString() {
        StringBuilder L = a.L("StartupBasedPermissionStrategy{mEnabledPermissions=");
        L.append(this.a);
        L.append('}');
        return L.toString();
    }
}
