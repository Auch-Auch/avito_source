package com.avito.android.similar_adverts;

import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractorKt;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/similar_adverts/Engine;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "type", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SIMILAR", "SIMILAR_MP", "SHOP_SIMILAR", "MARKETPLACE", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
public enum Engine {
    SIMILAR("vas_collab_similar"),
    SIMILAR_MP("marketplace_not_mkp_item"),
    SHOP_SIMILAR("shop_similar"),
    MARKETPLACE(AdvertDetailsAnalyticsInteractorKt.SAFEDEAL_SERVICE_MARKETPLACE);
    
    @NotNull
    public final String a;

    /* access modifiers changed from: public */
    Engine(String str) {
        this.a = str;
    }

    @NotNull
    public final String getType() {
        return this.a;
    }
}
