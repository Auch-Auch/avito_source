package com.avito.android.util;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/util/PreferencesCookieJar;", "Lokhttp3/CookieJar;", "Lokhttp3/HttpUrl;", "url", "", "Lokhttp3/Cookie;", "cookies", "", "saveFromResponse", "(Lokhttp3/HttpUrl;Ljava/util/List;)V", "loadForRequest", "(Lokhttp3/HttpUrl;)Ljava/util/List;", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "cookieStore", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class PreferencesCookieJar implements CookieJar {
    public final Preferences a;

    public PreferencesCookieJar(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "cookieStore");
        this.a = preferences;
    }

    @Override // okhttp3.CookieJar
    @NotNull
    public List<Cookie> loadForRequest(@NotNull HttpUrl httpUrl) {
        Intrinsics.checkNotNullParameter(httpUrl, "url");
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        Map<String, Object> all = this.a.getAll();
        for (String str : all.keySet()) {
            try {
                Object obj = all.get(str);
                if (obj != null) {
                    Cookie parse = Cookie.Companion.parse(httpUrl, (String) obj);
                    if (parse != null) {
                        boolean z = true;
                        if (parse.expiresAt() > System.currentTimeMillis()) {
                            String encodedPath = httpUrl.encodedPath();
                            String path = parse.path();
                            if (!Intrinsics.areEqual(path, "/")) {
                                if (!Intrinsics.areEqual(path, encodedPath)) {
                                    z = false;
                                }
                            }
                            if (z) {
                                arrayList.add(parse);
                            }
                        } else {
                            arrayList2.add(str);
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } catch (Throwable th) {
                Logs.error("PreferencesCookieJar", "failed when execute loadForRequest", new CookieJarException(a.c3("PreferencesCookieJar could not handle cookie ", str), th));
            }
        }
        for (String str2 : arrayList2) {
            this.a.remove(str2);
        }
        return arrayList;
    }

    @Override // okhttp3.CookieJar
    public void saveFromResponse(@NotNull HttpUrl httpUrl, @NotNull List<Cookie> list) {
        Intrinsics.checkNotNullParameter(httpUrl, "url");
        Intrinsics.checkNotNullParameter(list, "cookies");
        for (T t : list) {
            this.a.putString(t.name(), t.toString());
        }
    }
}
