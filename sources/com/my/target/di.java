package com.my.target;

import a2.b.a.a.a;
import a2.l.a.l;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URI;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class di {
    @Nullable
    public static volatile di b;
    @NonNull
    public final CookieHandler a;

    public di(@NonNull CookieManager cookieManager) {
        this.a = cookieManager;
    }

    @NonNull
    public static di w(@NonNull Context context) {
        di diVar = b;
        if (diVar == null) {
            synchronized (di.class) {
                diVar = b;
                if (diVar == null) {
                    diVar = new di(new CookieManager(new l(context.getApplicationContext()), null));
                    b = diVar;
                }
            }
        }
        return diVar;
    }

    public void a(@NonNull URLConnection uRLConnection) {
        Map<String, List<String>> headerFields = uRLConnection.getHeaderFields();
        try {
            this.a.put(URI.create(uRLConnection.getURL().toString()), headerFields);
        } catch (Throwable th) {
            a.q1(th, a.L("unable to set cookies from urlconnection: "));
        }
    }

    public void b(@NonNull URLConnection uRLConnection) {
        HashMap hashMap = new HashMap();
        try {
            for (Map.Entry<String, List<String>> entry : this.a.get(URI.create(uRLConnection.getURL().toString()), hashMap).entrySet()) {
                String key = entry.getKey();
                for (String str : entry.getValue()) {
                    uRLConnection.addRequestProperty(key, str);
                }
            }
        } catch (Throwable th) {
            a.q1(th, a.L("unable to set cookies to urlconnection "));
        }
    }
}
