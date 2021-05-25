package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.URLDecoder;
import java.net.URLEncoder;
public class ip {
    public static final String[] c = {"http://play.google.com", "https://play.google.com", "http://market.android.com", "https://market.android.com", "market://", "samsungapps://"};
    @NonNull
    public final String a;
    @Nullable
    public a b;

    public interface a {
        void ac(@Nullable String str);
    }

    public class b implements Runnable {
        public final /* synthetic */ Context a;

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = ip.this.b;
                if (aVar != null) {
                    aVar.ac(this.a);
                    ip.this.b = null;
                }
            }
        }

        public b(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = (String) df.cL().f(ip.this.a, this.a);
            if (ip.this.b != null) {
                af.c(new a(str));
            }
        }
    }

    public ip(@NonNull String str) {
        this.a = str;
    }

    public static boolean ao(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : c) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean ap(@NonNull String str) {
        return str.startsWith("samsungapps://");
    }

    public static boolean aq(@Nullable String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("https");
    }

    @NonNull
    public static ip ar(@NonNull String str) {
        return new ip(str);
    }

    @NonNull
    public static String decode(@NonNull String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Throwable th) {
            a2.b.a.a.a.q1(th, a2.b.a.a.a.L("Unable to decode url "));
            return str;
        }
    }

    @NonNull
    public static String encode(@NonNull String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable th) {
            a2.b.a.a.a.q1(th, a2.b.a.a.a.L("Unable to encode url "));
            return "";
        }
    }

    @NonNull
    public ip a(@Nullable a aVar) {
        this.b = aVar;
        return this;
    }

    public void ag(@NonNull Context context) {
        af.b(new b(context.getApplicationContext()));
    }
}
