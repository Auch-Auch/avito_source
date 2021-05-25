package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class cq extends cn {
    @Nullable
    public ca b;

    @NonNull
    public static cq bW() {
        return new cq();
    }

    public void a(@Nullable ca caVar) {
        this.b = caVar;
    }

    @Nullable
    public ca bX() {
        return this.b;
    }

    @Override // com.my.target.cn
    public int getBannersCount() {
        return this.b == null ? 0 : 1;
    }
}
