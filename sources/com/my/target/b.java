package com.my.target;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.cn;
import java.util.ArrayList;
import java.util.List;
public abstract class b<T extends cn> {
    @Nullable
    public AbstractC0305b<T> a;
    @NonNull
    public final a adConfig;
    @NonNull
    public final a<T> b;
    @Nullable
    public String c;

    public interface a<T extends cn> {
        boolean a();

        @NonNull
        c<T> b();

        @Nullable
        d<T> c();

        @NonNull
        e d();
    }

    /* renamed from: com.my.target.b$b  reason: collision with other inner class name */
    public interface AbstractC0305b<T extends cn> {
        void onResult(@Nullable T t, @Nullable String str);
    }

    public class c implements Runnable {
        public final /* synthetic */ Context a;

        public c(Context context) {
            this.a = context;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.my.target.b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            cn b2 = b.this.b(this.a);
            b bVar = b.this;
            bVar.a((b) b2, bVar.c);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ cn a;
        public final /* synthetic */ String b;

        public d(cn cnVar, String str) {
            this.a = cnVar;
            this.b = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.my.target.b$b<T extends com.my.target.cn> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            AbstractC0305b<T> bVar = b.this.a;
            if (bVar != 0) {
                bVar.onResult(this.a, this.b);
                b.this.a = null;
            }
        }
    }

    public b(@NonNull a<T> aVar, @NonNull a aVar2) {
        this.b = aVar;
        this.adConfig = aVar2;
    }

    @NonNull
    @AnyThread
    public b<T> a(@NonNull Context context) {
        af.a(new c(context.getApplicationContext()));
        return this;
    }

    @NonNull
    @AnyThread
    public final b<T> a(@NonNull AbstractC0305b<T> bVar) {
        this.a = bVar;
        return this;
    }

    @Nullable
    public T a(@NonNull bp bpVar, @Nullable T t, @NonNull c<T> cVar, @NonNull db dbVar, @NonNull Context context) {
        dbVar.f(bpVar.getUrl(), context);
        if (!dbVar.cI()) {
            return t;
        }
        im.a(bpVar.q("serviceRequested"), context);
        int i = 0;
        int bannersCount = t != null ? t.getBannersCount() : 0;
        String str = (String) dbVar.cJ();
        T a3 = str != null ? a((List<bp>) bpVar.bc(), (ArrayList<bp>) cVar.a(str, bpVar, t, this.adConfig, context), (c<ArrayList<bp>>) cVar, dbVar, context) : t;
        if (a3 != null) {
            i = a3.getBannersCount();
        }
        if (bannersCount != i) {
            return a3;
        }
        im.a(bpVar.q("serviceAnswerEmpty"), context);
        bp bb = bpVar.bb();
        return bb != null ? a(bb, (bp) a3, (c<bp>) cVar, dbVar, context) : a3;
    }

    @Nullable
    public T a(@Nullable T t, @NonNull Context context) {
        d<T> c2;
        return (t == null || (c2 = this.b.c()) == null) ? t : c2.a(t, this.adConfig, context);
    }

    @Nullable
    public T a(@NonNull List<bp> list, @Nullable T t, @NonNull c<T> cVar, @NonNull db dbVar, @NonNull Context context) {
        if (list.size() <= 0) {
            return t;
        }
        T t2 = t;
        for (bp bpVar : list) {
            t2 = a(bpVar, (bp) t2, (c<bp>) cVar, dbVar, context);
        }
        return t2;
    }

    @Nullable
    public String a(@NonNull bp bpVar, @NonNull db dbVar, @NonNull Context context) {
        dbVar.f(bpVar.getUrl(), context);
        if (dbVar.cI()) {
            return (String) dbVar.cJ();
        }
        this.c = dbVar.cK();
        return null;
    }

    public void a(@Nullable T t, @Nullable String str) {
        if (this.a != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.a.onResult(t, str);
                this.a = null;
                return;
            }
            af.c(new d(t, str));
        }
    }

    @Nullable
    public T b(@NonNull Context context) {
        ic.ac(context);
        bp a3 = this.b.d().a(this.adConfig, context);
        db cE = db.cE();
        String a4 = a(a3, cE, context);
        if (a4 == null) {
            return null;
        }
        c<T> b2 = this.b.b();
        T a5 = b2.a(a4, a3, null, this.adConfig, context);
        if (this.b.a()) {
            a5 = a((List<bp>) a3.bc(), (ArrayList<bp>) a5, (c<ArrayList<bp>>) b2, cE, context);
        }
        return a((b<T>) a5, context);
    }
}
