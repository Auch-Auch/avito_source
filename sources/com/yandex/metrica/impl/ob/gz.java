package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.ew;
import com.yandex.metrica.impl.ob.vy;
import com.yandex.metrica.impl.ob.wb;
import java.util.List;
public class gz extends wb {
    @Nullable
    private List<String> a;
    @NonNull
    private String b;
    private Boolean c;

    public static final class a extends vy.a<ew.a, a> {
        @NonNull
        public final String a;
        public final boolean b;

        public a(@Nullable String str, @Nullable String str2, @Nullable String str3, @NonNull String str4, @Nullable Boolean bool) {
            super(str, str2, str3);
            this.a = str4;
            this.b = ((Boolean) abw.b(bool, Boolean.TRUE)).booleanValue();
        }

        @NonNull
        /* renamed from: a */
        public a b(@NonNull ew.a aVar) {
            return new a((String) abw.a(aVar.a, this.c), (String) abw.a(aVar.b, this.d), (String) abw.a(aVar.c, this.e), (String) abw.b(aVar.d, this.a), (Boolean) abw.a(aVar.m, Boolean.valueOf(this.b)));
        }

        /* renamed from: b */
        public boolean a(@NonNull ew.a aVar) {
            String str = aVar.a;
            if (str != null && !str.equals(this.c)) {
                return false;
            }
            String str2 = aVar.b;
            if (str2 != null && !str2.equals(this.d)) {
                return false;
            }
            String str3 = aVar.c;
            if (str3 != null && !str3.equals(this.e)) {
                return false;
            }
            String str4 = aVar.d;
            if (str4 == null || str4.equals(this.a)) {
                return true;
            }
            return false;
        }

        public a(@NonNull ew.a aVar) {
            this(aVar.a, aVar.b, aVar.c, aVar.d, aVar.m);
        }
    }

    public static class b extends wb.a<gz, a> {
        public b(@NonNull Context context, @NonNull String str) {
            super(context, str);
        }

        @Override // com.yandex.metrica.impl.ob.wb.a, com.yandex.metrica.impl.ob.vy.b
        @NonNull
        public /* synthetic */ vy c(@NonNull vy.c cVar) {
            return b((vy.c<a>) cVar);
        }

        @NonNull
        /* renamed from: a */
        public gz b() {
            return new gz();
        }

        @NonNull
        /* renamed from: a */
        public gz b(@NonNull vy.c<a> cVar) {
            gz gzVar = (gz) super.c(cVar);
            gzVar.a(cVar.a.l);
            gzVar.a(cVar.b.a);
            gzVar.a(Boolean.valueOf(cVar.b.b));
            return gzVar;
        }
    }

    @Nullable
    public List<String> a() {
        return this.a;
    }

    @NonNull
    public String b() {
        return this.b;
    }

    @Nullable
    public Boolean c() {
        return this.c;
    }

    @Override // com.yandex.metrica.impl.ob.wb
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("DiagnosticRequestConfig{mDiagnosticHosts=");
        L.append(this.a);
        L.append(", mApiKey='");
        a2.b.a.a.a.k1(L, this.b, '\'', ", statisticsSending=");
        L.append(this.c);
        L.append('}');
        return L.toString();
    }

    public void a(@Nullable List<String> list) {
        this.a = list;
    }

    public void a(@NonNull String str) {
        this.b = str;
    }

    public void a(Boolean bool) {
        this.c = bool;
    }
}
