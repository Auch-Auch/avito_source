package com.avito.android.cookie_provider;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.interceptor.HeaderProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/cookie_provider/CookieProviderImpl;", "Lcom/avito/android/cookie_provider/CookieProvider;", "", "", "getCookies", "()Ljava/util/List;", "Lcom/avito/android/cookie_provider/CookieExpiredTime;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/cookie_provider/CookieExpiredTime;", "cookieExpiredTime", "Lcom/avito/android/remote/interceptor/HeaderProvider;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "providers", "<init>", "(Ljava/util/List;Lcom/avito/android/cookie_provider/CookieExpiredTime;)V", "cookie-provider_release"}, k = 1, mv = {1, 4, 2})
public final class CookieProviderImpl implements CookieProvider {
    public final List<HeaderProvider> a;
    public final CookieExpiredTime b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.interceptor.HeaderProvider> */
    /* JADX WARN: Multi-variable type inference failed */
    public CookieProviderImpl(@NotNull List<? extends HeaderProvider> list, @NotNull CookieExpiredTime cookieExpiredTime) {
        Intrinsics.checkNotNullParameter(list, "providers");
        Intrinsics.checkNotNullParameter(cookieExpiredTime, "cookieExpiredTime");
        this.a = list;
        this.b = cookieExpiredTime;
    }

    @Override // com.avito.android.cookie_provider.CookieProvider
    @NotNull
    public List<String> getCookies() {
        List<HeaderProvider> list = this.a;
        ArrayList<HeaderProvider> arrayList = new ArrayList();
        for (T t : list) {
            String value = t.getValue();
            if (!(value == null || value.length() == 0)) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        for (HeaderProvider headerProvider : arrayList) {
            String value2 = headerProvider.getValue();
            String replace$default = value2 != null ? m.replace$default(value2, ";", "%3B", false, 4, (Object) null) : null;
            arrayList2.add(headerProvider.getKey() + '=' + replace$default + "; Expires=" + this.b.getTime());
        }
        return CollectionsKt___CollectionsKt.toList(arrayList2);
    }
}
