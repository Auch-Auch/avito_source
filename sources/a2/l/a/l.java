package a2.l.a;

import a2.b.a.a.a;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import com.avito.android.remote.abuse.AbuseSendingResult;
import com.facebook.common.util.UriUtil;
import com.my.target.ae;
import com.my.target.dk;
import java.lang.reflect.Field;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@TargetApi(9)
public class l implements CookieStore {
    @NonNull
    public final SharedPreferences a;
    @NonNull
    public final Map<URI, Set<HttpCookie>> b = new HashMap();

    public l(@NonNull Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mytarget_httpcookie_prefs", 0);
        this.a = sharedPreferences;
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            try {
                URI uri = new URI(entry.getKey().split("\\|", 2)[0]);
                HttpCookie a3 = new dk().a((String) entry.getValue());
                Set<HttpCookie> set = this.b.get(uri);
                if (set == null) {
                    set = new HashSet<>();
                    this.b.put(uri, set);
                }
                set.add(a3);
            } catch (Throwable th) {
                ae.a(th.getMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x004e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x000f A[SYNTHETIC] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.net.HttpCookie> a(@androidx.annotation.NonNull java.net.URI r11) {
        /*
            r10 = this;
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.Map<java.net.URI, java.util.Set<java.net.HttpCookie>> r1 = r10.b
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x000f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0091
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.net.URI r3 = (java.net.URI) r3
            java.lang.String r4 = r3.getHost()
            java.lang.String r5 = r11.getHost()
            boolean r6 = r5.equals(r4)
            r7 = 0
            r8 = 1
            if (r6 != 0) goto L_0x004b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r9 = "."
            r6.append(r9)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            boolean r4 = r5.endsWith(r4)
            if (r4 == 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r4 = 0
            goto L_0x004c
        L_0x004b:
            r4 = 1
        L_0x004c:
            if (r4 == 0) goto L_0x000f
            java.lang.String r3 = r3.getPath()
            java.lang.String r4 = r11.getPath()
            boolean r5 = r4.equals(r3)
            if (r5 != 0) goto L_0x0083
            boolean r5 = r4.startsWith(r3)
            r6 = 47
            if (r5 == 0) goto L_0x006f
            int r5 = r3.length()
            int r5 = r5 - r8
            char r5 = r3.charAt(r5)
            if (r5 == r6) goto L_0x0083
        L_0x006f:
            boolean r5 = r4.startsWith(r3)
            if (r5 == 0) goto L_0x0084
            int r3 = r3.length()
            java.lang.String r3 = r4.substring(r3)
            char r3 = r3.charAt(r7)
            if (r3 != r6) goto L_0x0084
        L_0x0083:
            r7 = 1
        L_0x0084:
            if (r7 == 0) goto L_0x000f
            java.lang.Object r2 = r2.getValue()
            java.util.Collection r2 = (java.util.Collection) r2
            r0.addAll(r2)
            goto L_0x000f
        L_0x0091:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r2 = r0.iterator()
        L_0x009a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00b3
            java.lang.Object r3 = r2.next()
            java.net.HttpCookie r3 = (java.net.HttpCookie) r3
            boolean r4 = r3.hasExpired()
            if (r4 == 0) goto L_0x009a
            r1.add(r3)
            r2.remove()
            goto L_0x009a
        L_0x00b3:
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x00f2
            android.content.SharedPreferences r2 = r10.a
            android.content.SharedPreferences$Editor r2 = r2.edit()
            java.util.Iterator r1 = r1.iterator()
        L_0x00c3:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00ef
            java.lang.Object r3 = r1.next()
            java.net.HttpCookie r3 = (java.net.HttpCookie) r3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r11.toString()
            r4.append(r5)
            java.lang.String r5 = "|"
            r4.append(r5)
            java.lang.String r3 = r3.getName()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r2.remove(r3)
            goto L_0x00c3
        L_0x00ef:
            r2.apply()
        L_0x00f2:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>(r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.l.a.l.a(java.net.URI):java.util.List");
    }

    @Override // java.net.CookieStore
    public synchronized void add(URI uri, HttpCookie httpCookie) {
        if (httpCookie.getDomain() != null) {
            String domain = httpCookie.getDomain();
            if (domain.charAt(0) == '.') {
                domain = domain.substring(1);
            }
            try {
                uri = new URI(uri.getScheme() == null ? UriUtil.HTTP_SCHEME : uri.getScheme(), domain, httpCookie.getPath() == null ? "/" : httpCookie.getPath(), null);
            } catch (Throwable th) {
                ae.a(th.getMessage());
            }
        }
        Set<HttpCookie> set = this.b.get(uri);
        if (set == null) {
            set = new HashSet<>();
            this.b.put(uri, set);
        }
        set.remove(httpCookie);
        set.add(httpCookie);
        b(uri, httpCookie);
    }

    public final void b(@NonNull URI uri, @NonNull HttpCookie httpCookie) {
        String str;
        SharedPreferences.Editor edit = this.a.edit();
        String str2 = uri.toString() + "|" + httpCookie.getName();
        new dk();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", httpCookie.getName());
            jSONObject.putOpt("value", httpCookie.getValue());
            jSONObject.putOpt(AbuseSendingResult.COMMENT, httpCookie.getComment());
            jSONObject.putOpt("commentUrl", httpCookie.getCommentURL());
            jSONObject.putOpt("domain", httpCookie.getDomain());
            jSONObject.putOpt("maxage", Long.valueOf(httpCookie.getMaxAge()));
            jSONObject.putOpt(MessageMetaInfo.COLUMN_PATH, httpCookie.getPath());
            jSONObject.putOpt("portlist", httpCookie.getPortlist());
            jSONObject.putOpt("version", Integer.valueOf(httpCookie.getVersion()));
            jSONObject.putOpt("secure", Boolean.valueOf(httpCookie.getSecure()));
            jSONObject.putOpt("discard", Boolean.valueOf(httpCookie.getDiscard()));
            if (Build.VERSION.SDK_INT >= 24) {
                jSONObject.putOpt("httpOnly", Boolean.valueOf(httpCookie.isHttpOnly()));
            } else {
                try {
                    Field declaredField = httpCookie.getClass().getDeclaredField("httpOnly");
                    declaredField.setAccessible(true);
                    jSONObject.putOpt("httpOnly", declaredField.get(httpCookie));
                } catch (Throwable unused) {
                }
            }
            str = jSONObject.toString();
        } catch (Throwable th) {
            a.q1(th, a.L("Exception encoding cookie"));
            str = null;
        }
        edit.putString(str2, str);
        edit.apply();
    }

    @Override // java.net.CookieStore
    @NonNull
    public synchronized List<HttpCookie> get(URI uri) {
        return a(uri);
    }

    @Override // java.net.CookieStore
    @NonNull
    public synchronized List<HttpCookie> getCookies() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (URI uri : this.b.keySet()) {
            arrayList.addAll(a(uri));
        }
        return arrayList;
    }

    @Override // java.net.CookieStore
    @NonNull
    public synchronized List<URI> getURIs() {
        return new ArrayList(this.b.keySet());
    }

    @Override // java.net.CookieStore
    public synchronized boolean remove(URI uri, HttpCookie httpCookie) {
        boolean z;
        Set<HttpCookie> set = this.b.get(uri);
        z = set != null && set.remove(httpCookie);
        if (z) {
            SharedPreferences.Editor edit = this.a.edit();
            edit.remove(uri.toString() + "|" + httpCookie.getName());
            edit.apply();
        }
        return z;
    }

    @Override // java.net.CookieStore
    public synchronized boolean removeAll() {
        this.b.clear();
        this.a.edit().clear().apply();
        return true;
    }
}
