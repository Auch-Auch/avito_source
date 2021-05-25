package com.avito.android.tariff.fees_methods.items;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0007R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/tariff/fees_methods/items/FeeMethodClickStreamProvider;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/tariff/fees_methods/items/FeeMethodClickStreamProvider$Method;", "getDeeplinkClicks", "()Lio/reactivex/Observable;", "deeplinkClicks", "Method", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface FeeMethodClickStreamProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/tariff/fees_methods/items/FeeMethodClickStreamProvider$Method;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component2", "()Lcom/avito/android/deep_linking/links/DeepLink;", "type", "deepLink", "copy", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/tariff/fees_methods/items/FeeMethodClickStreamProvider$Method;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getType", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class Method {
        @NotNull
        public final String a;
        @NotNull
        public final DeepLink b;

        public Method(@NotNull String str, @NotNull DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(str, "type");
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = str;
            this.b = deepLink;
        }

        public static /* synthetic */ Method copy$default(Method method, String str, DeepLink deepLink, int i, Object obj) {
            if ((i & 1) != 0) {
                str = method.a;
            }
            if ((i & 2) != 0) {
                deepLink = method.b;
            }
            return method.copy(str, deepLink);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final DeepLink component2() {
            return this.b;
        }

        @NotNull
        public final Method copy(@NotNull String str, @NotNull DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(str, "type");
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            return new Method(str, deepLink);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Method)) {
                return false;
            }
            Method method = (Method) obj;
            return Intrinsics.areEqual(this.a, method.a) && Intrinsics.areEqual(this.b, method.b);
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.b;
        }

        @NotNull
        public final String getType() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            DeepLink deepLink = this.b;
            if (deepLink != null) {
                i = deepLink.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Method(type=");
            L.append(this.a);
            L.append(", deepLink=");
            return a.m(L, this.b, ")");
        }
    }

    @NotNull
    Observable<Method> getDeeplinkClicks();
}
