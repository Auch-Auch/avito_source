package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import com.yandex.metrica.impl.ob.op;
import com.yandex.metrica.impl.ob.sg;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public class wp {
    @NonNull
    private act a;
    @NonNull
    private final mx<wr> b;
    @NonNull
    private a c;
    @NonNull
    private ng d;
    @NonNull
    private final b e;
    @NonNull
    private final abs f;
    @NonNull
    private final sd g;
    @Nullable
    private String h;

    public static class a {
        @NonNull
        private final wv a;

        public a() {
            this(new wv());
        }

        @NonNull
        public List<wu> a(@Nullable byte[] bArr) {
            ArrayList arrayList = new ArrayList();
            if (dl.a(bArr)) {
                return arrayList;
            }
            try {
                return this.a.a(new String(bArr, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
                return arrayList;
            }
        }

        @VisibleForTesting
        public a(@NonNull wv wvVar) {
            this.a = wvVar;
        }
    }

    public static class b {
        @Nullable
        public HttpURLConnection a(@NonNull String str, @NonNull String str2) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                if (!TextUtils.isEmpty(str)) {
                    httpURLConnection.setRequestProperty(HttpHeaders.IF_NONE_MATCH, str);
                }
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
                int i = sg.a.a;
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
                httpURLConnection.connect();
                return httpURLConnection;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public wp(@NonNull Context context, @Nullable String str, @NonNull act act) {
        this(str, op.a.a(wr.class).a(context), new a(), new b(), act, new ng(), new abs(), new sd(context));
    }

    public boolean b(@NonNull yb ybVar) {
        String str = this.h;
        if (str != null) {
            return !str.equals(ybVar.h);
        }
        if (ybVar.h != null) {
            return true;
        }
        return false;
    }

    public void a(@NonNull final wo woVar) {
        this.a.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.wp.1
            @Override // java.lang.Runnable
            public void run() {
                wp wpVar = wp.this;
                wpVar.a(woVar, wpVar.h);
            }
        });
    }

    @VisibleForTesting
    public wp(@Nullable String str, @NonNull mx mxVar, @NonNull a aVar, @NonNull b bVar, @NonNull act act, @NonNull ng ngVar, @NonNull abs abs, @NonNull sd sdVar) {
        this.h = str;
        this.b = mxVar;
        this.c = aVar;
        this.e = bVar;
        this.a = act;
        this.d = ngVar;
        this.f = abs;
        this.g = sdVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(@NonNull wo woVar, String str) {
        wr a3 = this.b.a();
        wr wrVar = null;
        if (this.g.a() && str != null) {
            try {
                HttpURLConnection a4 = this.e.a(a3.b, str);
                if (a4 != null) {
                    wrVar = a(a4, a3);
                }
            } catch (Throwable unused) {
            }
        }
        if (wrVar != null) {
            woVar.a(wrVar);
        } else {
            woVar.a();
        }
    }

    @Nullable
    public wr a(@NonNull HttpURLConnection httpURLConnection, @NonNull wr wrVar) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            try {
                return new wr(this.c.a(this.d.a(ax.b(httpURLConnection.getInputStream()), "af9202nao18gswqp")), dh.a(httpURLConnection.getHeaderField(HttpHeaders.ETAG)), this.f.a(), true, false);
            } catch (IOException unused) {
            }
        } else if (responseCode == 304) {
            return new wr(wrVar.a, wrVar.b, this.f.a(), true, false);
        }
        return null;
    }

    public void a(@Nullable yb ybVar) {
        if (ybVar != null) {
            this.h = ybVar.h;
        }
    }
}
