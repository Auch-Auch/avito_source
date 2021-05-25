package com.yandex.metrica.impl.ob;

import android.support.annotation.Nullable;
public class m {
    @Nullable
    public final a a;
    @Nullable
    public final Boolean b;

    public enum a {
        ACTIVE,
        WORKING_SET,
        FREQUENT,
        RARE
    }

    public m(@Nullable a aVar, @Nullable Boolean bool) {
        this.a = aVar;
        this.b = bool;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        if (this.a != mVar.a) {
            return false;
        }
        Boolean bool = this.b;
        if (bool != null) {
            return bool.equals(mVar.b);
        }
        if (mVar.b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        a aVar = this.a;
        int i = 0;
        int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        Boolean bool = this.b;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode + i;
    }
}
