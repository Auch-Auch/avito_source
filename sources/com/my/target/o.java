package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.b;
public final class o extends b<cq> {
    @Nullable
    public final cq d;

    public interface b extends b.AbstractC0305b {
    }

    public static class c implements b.a<cq> {
        public c(a aVar) {
        }

        @Override // com.my.target.b.a
        public boolean a() {
            return true;
        }

        @Override // com.my.target.b.a
        @NonNull
        public c<cq> b() {
            return p.f();
        }

        @Override // com.my.target.b.a
        @Nullable
        public d<cq> c() {
            return q.i();
        }

        @Override // com.my.target.b.a
        @NonNull
        public e d() {
            return e.e();
        }
    }

    public o(@NonNull a aVar, @Nullable cq cqVar) {
        super(new c(null), aVar);
        this.d = cqVar;
    }

    @NonNull
    public static b<cq> a(@NonNull a aVar) {
        return new o(aVar, null);
    }

    @NonNull
    public static b<cq> a(@NonNull cq cqVar, @NonNull a aVar) {
        return new o(aVar, cqVar);
    }

    @Nullable
    /* renamed from: e */
    public cq b(@NonNull Context context) {
        cq cqVar = this.d;
        return (cq) (cqVar != null ? a((o) cqVar, context) : super.b(context));
    }
}
