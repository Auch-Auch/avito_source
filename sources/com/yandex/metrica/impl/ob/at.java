package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.r;
public abstract class at<T> {
    @NonNull
    public final r.a<T> a = new r.a<>();
    public long b;
    @Nullable
    private au c;

    public at(long j) {
        this.b = j;
    }

    public void a(@NonNull T t) {
        if (b(t)) {
            this.a.a(t);
            au auVar = this.c;
            if (auVar != null) {
                auVar.c();
            }
        }
    }

    public abstract boolean b(@NonNull T t);

    @Nullable
    public T a() {
        return this.a.a();
    }

    public void a(@NonNull au auVar) {
        this.c = auVar;
    }
}
