package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class cu extends cn {
    @Nullable
    public ck b;
    public boolean c = true;

    @NonNull
    public static cu cp() {
        return new cu();
    }

    public void a(@Nullable ck ckVar) {
        this.b = ckVar;
    }

    public boolean cq() {
        return this.c;
    }

    @Nullable
    public ck cr() {
        return this.b;
    }

    @Override // com.my.target.cn
    public int getBannersCount() {
        return this.b == null ? 0 : 1;
    }

    public void u(boolean z) {
        this.c = z;
    }
}
