package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.ej;
public class el<T extends ej> {
    @NonNull
    private final ek<T> a;
    @Nullable
    private final ei<T> b;

    public static final class a<T extends ej> {
        @NonNull
        public final ek<T> a;
        @Nullable
        public ei<T> b;

        public a(@NonNull ek<T> ekVar) {
            this.a = ekVar;
        }

        @NonNull
        public a<T> a(@NonNull ei<T> eiVar) {
            this.b = eiVar;
            return this;
        }

        @NonNull
        public el<T> a() {
            return new el<>(this);
        }
    }

    public void a(@NonNull ej ejVar) {
        this.a.a(ejVar);
    }

    public final boolean b(@NonNull ej ejVar) {
        ei<T> eiVar = this.b;
        if (eiVar == null) {
            return false;
        }
        return eiVar.a(ejVar);
    }

    private el(@NonNull a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
    }

    @NonNull
    public static <T extends ej> a<T> a(@NonNull ek<T> ekVar) {
        return new a<>(ekVar);
    }
}
