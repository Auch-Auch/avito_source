package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.b;
public final class w extends b<ct> {

    public interface b extends b.AbstractC0305b {
    }

    public static class c implements b.a<ct> {
        public c(a aVar) {
        }

        @Override // com.my.target.b.a
        public boolean a() {
            return false;
        }

        @Override // com.my.target.b.a
        @NonNull
        public c<ct> b() {
            return x.f();
        }

        @Override // com.my.target.b.a
        @Nullable
        public d<ct> c() {
            return y.l();
        }

        @Override // com.my.target.b.a
        @NonNull
        public e d() {
            return e.e();
        }
    }

    public w(@NonNull a aVar) {
        super(new c(null), aVar);
    }

    @NonNull
    public static b<ct> a(@NonNull a aVar) {
        return new w(aVar);
    }

    @Override // com.my.target.b
    @Nullable
    public String a(@NonNull bp bpVar, @NonNull db dbVar, @NonNull Context context) {
        if (this.adConfig.getCachePeriod() > 0) {
            ae.a("NativeAppwallAdFactory: check cached data");
            String str = null;
            hy Z = hy.Z(context);
            if (Z != null) {
                str = Z.a(this.adConfig.getSlotId(), this.adConfig.getCachePeriod());
            }
            if (str != null) {
                ae.a("NativeAppwallAdFactory: cached data loaded successfully");
                bpVar.s(true);
                return str;
            }
            ae.a("NativeAppwallAdFactory: no cached data");
        }
        return super.a(bpVar, dbVar, context);
    }
}
