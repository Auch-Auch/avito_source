package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.NonNull;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
public class lv {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile lv a;
    private final Map<String, lu> b;
    private final Map<String, lx> c;
    private final Map<String, lp> d;
    @NonNull
    private final ls e;
    private final Context f;
    private lu g;
    private lp h;
    private lx i;
    private lx j;
    private lx k;
    private lz l;
    private ly m;
    private ma n;

    public lv(Context context) {
        this(context, mi.a());
    }

    public static lv a(Context context) {
        if (a == null) {
            synchronized (lv.class) {
                if (a == null) {
                    a = new lv(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    public synchronized lx b(fb fbVar) {
        lx lxVar;
        String fbVar2 = fbVar.toString();
        lxVar = this.c.get(fbVar2);
        if (lxVar == null) {
            lxVar = new lx(a(fbVar), "preferences");
            this.c.put(fbVar2, lxVar);
        }
        return lxVar;
    }

    @NonNull
    public synchronized lp c(@NonNull fb fbVar) {
        lp lpVar;
        String fbVar2 = fbVar.toString();
        lpVar = this.d.get(fbVar2);
        if (lpVar == null) {
            lpVar = new lp(new mh(a(fbVar)), "binary_data");
            this.d.put(fbVar2, lpVar);
        }
        return lpVar;
    }

    public synchronized ma d() {
        if (this.n == null) {
            this.n = new ma(a(), "permissions");
        }
        return this.n;
    }

    public synchronized lx e() {
        if (this.j == null) {
            this.j = new lx(a(), "startup");
        }
        return this.j;
    }

    public synchronized lx f() {
        if (this.k == null) {
            this.k = new lx("preferences", new mg(this.f, a("metrica_client_data.db")));
        }
        return this.k;
    }

    public synchronized lz g() {
        if (this.l == null) {
            this.l = new lz(this.f, a());
        }
        return this.l;
    }

    public synchronized ly h() {
        if (this.m == null) {
            this.m = new ly(this.f, a());
        }
        return this.m;
    }

    public lv(Context context, @NonNull ls lsVar) {
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.f = context;
        this.e = lsVar;
    }

    private static String d(fb fbVar) {
        return "db_metrica_" + fbVar;
    }

    public synchronized lu a(fb fbVar) {
        lu luVar;
        String d2 = d(fbVar);
        luVar = this.b.get(d2);
        if (luVar == null) {
            luVar = a(d2, this.e.a());
            this.b.put(d2, luVar);
        }
        return luVar;
    }

    public synchronized lp b() {
        if (this.h == null) {
            this.h = new lp(new mh(a()), "binary_data");
        }
        return this.h;
    }

    public synchronized lx c() {
        if (this.i == null) {
            this.i = new lx(a(), "preferences");
        }
        return this.i;
    }

    @TargetApi(21)
    private String b(String str) {
        try {
            File noBackupFilesDir = this.f.getNoBackupFilesDir();
            File file = new File(noBackupFilesDir, str);
            if (!file.exists()) {
                if (a(noBackupFilesDir, str)) {
                    a(noBackupFilesDir, str + "-journal");
                    a(noBackupFilesDir, str + "-shm");
                    a(noBackupFilesDir, str + "-wal");
                }
            }
            return file.getAbsolutePath();
        } catch (Throwable unused) {
            return str;
        }
    }

    public synchronized lu a() {
        if (this.g == null) {
            this.g = a("metrica_data.db", this.e.b());
        }
        return this.g;
    }

    @NonNull
    public lu a(String str, mb mbVar) {
        return new lu(this.f, a(str), mbVar);
    }

    private String a(String str) {
        return dl.a(21) ? b(str) : str;
    }

    private boolean a(@NonNull File file, @NonNull String str) {
        File databasePath = this.f.getDatabasePath(str);
        if (databasePath == null || !databasePath.exists()) {
            return false;
        }
        return databasePath.renameTo(new File(file, str));
    }
}
