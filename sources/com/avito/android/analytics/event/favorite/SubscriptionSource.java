package com.avito.android.analytics.event.favorite;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "FAVORITE_SELLERS", "FAVORITE_SELLERS_REC", "ADVERT_DETAILS", "ADVERT_DETAILS_REC", "PUBLIC_PROFILE", "SHOP_PAGE", "EXTENDED_PROFILE", "UNKNOWN", "analytics_release"}, k = 1, mv = {1, 4, 2})
public enum SubscriptionSource {
    FAVORITE_SELLERS("favorite_sellers"),
    FAVORITE_SELLERS_REC("favorite_sellers_rec"),
    ADVERT_DETAILS("item"),
    ADVERT_DETAILS_REC("item_rec"),
    PUBLIC_PROFILE("public_profile"),
    SHOP_PAGE("shop_page"),
    EXTENDED_PROFILE("extended_profile"),
    UNKNOWN("unknown");
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/analytics/event/favorite/SubscriptionSource$Companion;", "", "", "value", "Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "getByValue", "(Ljava/lang/String;)Lcom/avito/android/analytics/event/favorite/SubscriptionSource;", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final SubscriptionSource getByValue(@NotNull String str) {
            SubscriptionSource subscriptionSource;
            Intrinsics.checkNotNullParameter(str, "value");
            SubscriptionSource[] values = SubscriptionSource.values();
            int i = 0;
            while (true) {
                if (i >= 8) {
                    subscriptionSource = null;
                    break;
                }
                subscriptionSource = values[i];
                if (Intrinsics.areEqual(subscriptionSource.getValue(), str)) {
                    break;
                }
                i++;
            }
            return subscriptionSource != null ? subscriptionSource : SubscriptionSource.UNKNOWN;
        }

        public Companion(j jVar) {
        }
    }

    /* access modifiers changed from: public */
    SubscriptionSource(String str) {
        this.a = str;
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }
}
