package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.b;
import java.util.ArrayList;
import java.util.List;
public final class i extends b<cp> {
    @Nullable
    public final List<bp> d;
    @NonNull
    public final ik e;
    @Nullable
    public Runnable f;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = i.this;
            iVar.e.e(iVar.f);
            i.this.a((i) null, "ad loading timeout");
        }
    }

    public interface b extends b.AbstractC0305b {
    }

    public static class c implements b.a<cp> {
        public c(a aVar) {
        }

        @Override // com.my.target.b.a
        public boolean a() {
            return true;
        }

        @Override // com.my.target.b.a
        @NonNull
        public c<cp> b() {
            return j.f();
        }

        @Override // com.my.target.b.a
        @Nullable
        public d<cp> c() {
            return k.h();
        }

        @Override // com.my.target.b.a
        @NonNull
        public e d() {
            return e.e();
        }
    }

    public i(@Nullable List<bp> list, @NonNull a aVar, int i) {
        super(new c(null), aVar);
        this.d = list;
        this.e = ik.J(i * 1000);
    }

    @NonNull
    public static b<cp> a(@NonNull a aVar, int i) {
        return new i(null, aVar, i);
    }

    @NonNull
    public static b<cp> a(@NonNull bp bpVar, @NonNull a aVar, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(bpVar);
        return new i(arrayList, aVar, i);
    }

    @NonNull
    public static b<cp> a(@NonNull List<bp> list, @NonNull a aVar, int i) {
        return new i(list, aVar, i);
    }

    @Override // com.my.target.b
    @NonNull
    public b<cp> a(@NonNull Context context) {
        if (this.f == null) {
            this.f = new a();
        }
        this.e.d(this.f);
        return super.a(context);
    }

    @Nullable
    /* renamed from: d */
    public cp b(@NonNull Context context) {
        cn b2;
        if (this.d != null) {
            b2 = a((i) ((cp) a(this.d, (List<bp>) null, (c<List<bp>>) this.b.b(), db.cE(), context)), context);
        } else {
            b2 = super.b(context);
        }
        return (cp) b2;
    }
}
