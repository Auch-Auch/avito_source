package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.b;
public final class ab extends b<cu> {
    @Nullable
    public final cu d;

    public interface a extends b.AbstractC0305b {
    }

    public static class c implements b.a<cu> {
        public c(b bVar) {
        }

        @Override // com.my.target.b.a
        public boolean a() {
            return false;
        }

        @Override // com.my.target.b.a
        @NonNull
        public c<cu> b() {
            return ac.f();
        }

        @Override // com.my.target.b.a
        @Nullable
        public d<cu> c() {
            return ad.m();
        }

        @Override // com.my.target.b.a
        @NonNull
        public e d() {
            return e.e();
        }
    }

    public ab(@NonNull a aVar, @Nullable cu cuVar) {
        super(new c(null), aVar);
        this.d = cuVar;
    }

    @NonNull
    public static b<cu> a(@NonNull a aVar) {
        return new ab(aVar, null);
    }

    @NonNull
    public static b<cu> a(@NonNull cu cuVar, @NonNull a aVar) {
        return new ab(aVar, cuVar);
    }

    @Nullable
    /* renamed from: h */
    public cu b(@NonNull Context context) {
        cu cuVar = this.d;
        return (cu) (cuVar != null ? a((ab) cuVar, context) : super.b(context));
    }
}
