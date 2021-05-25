package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class bs extends cn {
    @Nullable
    public br b;

    @NonNull
    public static bs bq() {
        return new bs();
    }

    public void a(@Nullable br brVar) {
        this.b = brVar;
    }

    @Nullable
    public br br() {
        return this.b;
    }

    @Override // com.my.target.cn
    public int getBannersCount() {
        return this.b != null ? 1 : 0;
    }
}
