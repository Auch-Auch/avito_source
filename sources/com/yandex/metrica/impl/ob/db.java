package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.SparseArray;
import com.avito.android.BuildConfig;
import com.yandex.metrica.impl.ob.bu;
import com.yandex.metrica.impl.ob.i;
import com.yandex.metrica.impl.ob.op;
import com.yandex.metrica.impl.ob.yb;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;
public class db extends bu {
    private final mq a;
    @NonNull
    private final Context b;

    public static class b implements bu.a {
        @NonNull
        private mx a;
        @NonNull
        private mr b;

        public b(@NonNull mx mxVar, @NonNull mr mrVar) {
            this.a = mxVar;
            this.b = mrVar;
        }

        @Override // com.yandex.metrica.impl.ob.bu.a
        public void a(Context context) {
            this.a.a(this.b.a());
        }
    }

    public static class c implements bu.a {
        @NonNull
        private final mq a;
        @NonNull
        private final tc b;

        public c(@NonNull mq mqVar, @NonNull tc tcVar) {
            this.a = mqVar;
            this.b = tcVar;
        }

        @Override // com.yandex.metrica.impl.ob.bu.a
        public void a(Context context) {
            Boolean b2 = this.b.b();
            this.b.d().j();
            if (b2 != null) {
                this.a.a(b2.booleanValue()).q();
            }
        }
    }

    public static class d implements bu.a {
        @NonNull
        private final mx<Collection<sr>> a;
        @NonNull
        private final mx<sk> b;

        public d(@NonNull mx<Collection<sr>> mxVar, @NonNull mx<sk> mxVar2) {
            this.a = mxVar;
            this.b = mxVar2;
        }

        @Override // com.yandex.metrica.impl.ob.bu.a
        public void a(Context context) {
            this.b.a(new sk(new ArrayList(this.a.a()), null, new ArrayList()));
        }
    }

    public static class e implements bu.a {
        @NonNull
        private final mx<yb> a;

        public e(@NonNull mx<yb> mxVar) {
            this.a = mxVar;
        }

        @Override // com.yandex.metrica.impl.ob.bu.a
        public void a(Context context) {
            mx<yb> mxVar = this.a;
            mxVar.a(mxVar.a().a().c(true).a());
        }
    }

    public static class f implements bu.a {
        private tf a;
        private mr b;

        public f(@NonNull Context context) {
            this.a = new tf(context);
            this.b = new mr(lv.a(context).e(), context.getPackageName());
        }

        @Override // com.yandex.metrica.impl.ob.bu.a
        public void a(Context context) {
            String a3 = this.a.a((String) null);
            if (!TextUtils.isEmpty(a3)) {
                this.b.b(a3).q();
                tf.a(context);
            }
        }
    }

    public static class g implements bu.a {
        @Override // com.yandex.metrica.impl.ob.bu.a
        public void a(Context context) {
            tc tcVar = new tc(context, context.getPackageName());
            SharedPreferences a = ti.a(context, "_boundentrypreferences");
            th thVar = tc.d;
            String string = a.getString(thVar.a(), null);
            th thVar2 = tc.e;
            long j = a.getLong(thVar2.a(), -1);
            if (string != null && j != -1) {
                tcVar.a(new i.a(string, j)).j();
                a.edit().remove(thVar.a()).remove(thVar2.a()).apply();
            }
        }
    }

    public static class j implements bu.a {
        @Override // com.yandex.metrica.impl.ob.bu.a
        public void a(Context context) {
            mr mrVar = new mr(lv.a(context).e(), context.getPackageName());
            String i = mrVar.i(null);
            if (i != null) {
                mrVar.a(Collections.singletonList(i));
            }
            String j = mrVar.j(null);
            if (j != null) {
                mrVar.b(Collections.singletonList(j));
            }
        }
    }

    public static class l implements bu.a {
        @Override // com.yandex.metrica.impl.ob.bu.a
        public void a(Context context) {
            mx a = op.a.a(yb.class).a(context);
            yb ybVar = (yb) a.a();
            a.a(ybVar.a().a(ybVar.u > 0).c(true).a());
        }
    }

    public db(@NonNull Context context) {
        this.b = context;
        this.a = new mq(lv.a(context).c());
    }

    public static class k implements bu.a {

        public static class a implements FilenameFilter {
            public final Iterable<FilenameFilter> a;

            public a(Iterable<FilenameFilter> iterable) {
                this.a = iterable;
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                for (FilenameFilter filenameFilter : this.a) {
                    if (filenameFilter.accept(file, str)) {
                        return true;
                    }
                }
                return false;
            }
        }

        public static class b implements FilenameFilter {
            private final FilenameFilter a;

            public b(FilenameFilter filenameFilter) {
                this.a = filenameFilter;
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                if (!str.startsWith("db_metrica_")) {
                    return false;
                }
                try {
                    return this.a.accept(file, k.a(str));
                } catch (Throwable unused) {
                    return false;
                }
            }
        }

        public static class c implements FilenameFilter {
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.endsWith(BuildConfig.ADJUST_DEFAULT_TRACKER);
            }
        }

        public static class d implements FilenameFilter {
            private final String a;

            public d(@NonNull String str) {
                this.a = str;
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return !str.contains(this.a);
            }
        }

        private void d(Context context) {
            new mr(lv.a(context).e(), context.getPackageName()).r(new th("LAST_STARTUP_CLIDS_SAVE_TIME").b()).q();
        }

        @Override // com.yandex.metrica.impl.ob.bu.a
        public void a(Context context) {
            b(context);
            d(context);
        }

        public void b(@NonNull Context context) {
            File c2 = c(context);
            File[] listFiles = c2.listFiles(new a(Arrays.asList(new b(new d(context.getPackageName())), new b(new c()))));
            for (File file : listFiles) {
                try {
                    if (!file.delete()) {
                        xa.a().reportEvent("Can not delete file", new JSONObject().put("fileName", file.getName()).toString());
                    }
                } catch (Throwable th) {
                    xa.a().reportError("Can not delete file", th);
                }
            }
        }

        @VisibleForTesting
        public File c(@NonNull Context context) {
            if (dl.a(21)) {
                return context.getNoBackupFilesDir();
            }
            return new File(context.getFilesDir().getParentFile(), "databases");
        }

        @NonNull
        public static String a(@NonNull String str) {
            return str.endsWith("-journal") ? str.replace("-journal", "") : str;
        }
    }

    @Override // com.yandex.metrica.impl.ob.bu
    public SparseArray<bu.a> a() {
        return new SparseArray<bu.a>() { // from class: com.yandex.metrica.impl.ob.db.1
            {
                put(29, new f(db.this.b));
                put(39, new g());
                put(47, new h());
                put(60, new i());
                put(62, new j());
                put(66, new k());
                put(67, new b(op.a.a(yb.class).a(db.this.b), new mr(lv.a(db.this.b).e(), db.this.b.getPackageName())));
                put(68, new l());
                put(72, new a(op.a.b(sr.class).a(db.this.b), op.a.a(yb.class).a(db.this.b), new os()));
                put(73, new c(db.this.a, new tc(db.this.b, new fs(db.this.b.getPackageName(), null).toString())));
                put(82, new d(op.a.b(sr.class).a(db.this.b), op.a.a(sk.class).a(db.this.b)));
                put(87, new e(op.a.a(yb.class).a(db.this.b)));
            }
        };
    }

    public static class i implements bu.a {
        @Override // com.yandex.metrica.impl.ob.bu.a
        public void a(Context context) {
            a(context, new mq(lv.a(context).c()));
        }

        private void a(Context context, mq mqVar) {
            long j = new mr(lv.a(context).e(), context.getPackageName()).a().u;
            boolean z = true;
            boolean z2 = j > 0;
            if (mqVar.c(-1) <= 0) {
                z = false;
            }
            if (z2 || z) {
                mqVar.d(false).q();
            }
        }
    }

    @Override // com.yandex.metrica.impl.ob.bu
    public int a(td tdVar) {
        int a3 = tdVar.a();
        return a3 == -1 ? this.a.a(-1) : a3;
    }

    @Override // com.yandex.metrica.impl.ob.bu
    public void a(td tdVar, int i2) {
        this.a.b(i2).q();
        tdVar.b().j();
    }

    public static class a implements bu.a {
        @NonNull
        private final mx<Collection<sr>> a;
        @NonNull
        private final mx<yb> b;
        @NonNull
        private final os c;

        public a(@NonNull mx<Collection<sr>> mxVar, @NonNull mx<yb> mxVar2, @NonNull os osVar) {
            this.a = mxVar;
            this.b = mxVar2;
            this.c = osVar;
        }

        private void b(@NonNull Context context) {
            context.getSharedPreferences("com.yandex.metrica.configuration", 0).edit().clear().apply();
        }

        private void c(@NonNull Context context) {
            ma d = lv.a(context).d();
            List<sr> a3 = d.a();
            if (a3 != null) {
                this.a.a(a3);
                d.b();
            }
        }

        @Override // com.yandex.metrica.impl.ob.bu.a
        public void a(@NonNull Context context) {
            c(context);
            yb.a a3 = this.b.a().a();
            a(context, a3);
            a(a3);
            this.b.a(a3.a());
            b(context);
        }

        private void a(@NonNull yb.a aVar) {
            aVar.c(true);
        }

        private void a(@NonNull Context context, @NonNull yb.a aVar) {
            oq a3 = this.c.a(context);
            if (a3 != null) {
                aVar.b(a3.a).d(a3.b);
            }
        }
    }

    public static class h implements bu.a {
        private void b(Context context) {
            new os().a(context, new oq((String) abw.b(new mr(lv.a(context).e(), context.getPackageName()).a().b, ""), null), new so(new sj()));
        }

        private void c(Context context, mq mqVar) {
            tg tgVar = new tg(context);
            if (tgVar.a()) {
                mqVar.b(true);
                tgVar.b();
            }
        }

        @Override // com.yandex.metrica.impl.ob.bu.a
        public void a(Context context) {
            mq mqVar = new mq(lv.a(context).c());
            c(context, mqVar);
            b(context, mqVar);
            a(context, mqVar);
            mqVar.q();
            sx sxVar = new sx(context);
            sxVar.a();
            sxVar.b();
            b(context);
        }

        private void b(Context context, mq mqVar) {
            te teVar = new te(context, context.getPackageName());
            long a = teVar.a(0);
            if (a != 0) {
                mqVar.a(a);
            }
            teVar.a();
        }

        private void a(Context context, mq mqVar) {
            tc tcVar = new tc(context, new fs(context.getPackageName(), null).toString());
            Boolean b = tcVar.b();
            tcVar.d();
            if (b != null) {
                mqVar.a(b.booleanValue());
            }
            String b2 = tcVar.b((String) null);
            if (!TextUtils.isEmpty(b2)) {
                mqVar.a(b2);
            }
            tcVar.d().c().j();
        }
    }
}
