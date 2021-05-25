package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.b;
public final class s extends b<cs> {
    @Nullable
    public final cs d;
    @Nullable
    public final String e;

    public static class a implements b.a<cs> {
        @Override // com.my.target.b.a
        public boolean a() {
            return false;
        }

        @Override // com.my.target.b.a
        @NonNull
        public c<cs> b() {
            return t.f();
        }

        @Override // com.my.target.b.a
        @Nullable
        public d<cs> c() {
            return u.j();
        }

        @Override // com.my.target.b.a
        @NonNull
        public e d() {
            return v.k();
        }
    }

    public interface b extends b.AbstractC0305b {
    }

    public s(@NonNull a aVar, @Nullable cs csVar, @Nullable String str) {
        super(new a(), aVar);
        this.d = csVar;
        this.e = str;
    }

    @NonNull
    public static b<cs> a(@NonNull a aVar) {
        return new s(aVar, null, null);
    }

    @NonNull
    public static b<cs> a(@NonNull cs csVar, @NonNull a aVar) {
        return new s(aVar, csVar, null);
    }

    @NonNull
    public static b<cs> a(@NonNull String str, @NonNull a aVar) {
        return new s(aVar, null, str);
    }

    @Nullable
    /* renamed from: g */
    public cs b(@NonNull Context context) {
        cs csVar;
        cn b2;
        if (this.e != null) {
            csVar = this.b.b().a(this.e, bp.p(""), this.d, this.adConfig, context);
        } else {
            csVar = this.d;
            if (csVar == null) {
                b2 = super.b(context);
                return (cs) b2;
            }
        }
        b2 = a((s) csVar, context);
        return (cs) b2;
    }
}
