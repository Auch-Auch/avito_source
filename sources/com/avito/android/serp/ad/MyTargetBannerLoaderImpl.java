package com.avito.android.serp.ad;

import android.content.Context;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.MyTargetRequestEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.MyTargetBannerItem;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/serp/ad/MyTargetBannerLoaderImpl;", "Lcom/avito/android/serp/ad/MyTargetBannerLoader;", "Lcom/avito/android/remote/model/MyTargetBannerItem;", "banner", "", "isFallback", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/serp/ad/MyTargetBanner;", "loadBanner", "(Lcom/avito/android/remote/model/MyTargetBannerItem;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "c", "Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "imageBgProvider", "<init>", "(Landroid/content/Context;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/serp/ad/MyTargetImageBgProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class MyTargetBannerLoaderImpl implements MyTargetBannerLoader {
    public final Context a;
    public final Analytics b;
    public final MyTargetImageBgProvider c;

    @Inject
    public MyTargetBannerLoaderImpl(@NotNull Context context, @NotNull Analytics analytics, @NotNull MyTargetImageBgProvider myTargetImageBgProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(myTargetImageBgProvider, "imageBgProvider");
        this.a = context;
        this.b = analytics;
        this.c = myTargetImageBgProvider;
    }

    @Override // com.avito.android.serp.ad.MyTargetBannerLoader
    @NotNull
    public Observable<MyTargetBanner> loadBanner(@NotNull MyTargetBannerItem myTargetBannerItem, boolean z) {
        Intrinsics.checkNotNullParameter(myTargetBannerItem, "banner");
        this.b.track(new MyTargetRequestEvent(myTargetBannerItem.getId().intValue(), z));
        Context context = this.a;
        Analytics analytics = this.b;
        MyTargetImageBgProvider myTargetImageBgProvider = this.c;
        AdEventListenerHolder adEventListenerHolder = new AdEventListenerHolder();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        Observable<MyTargetBanner> create = Observable.create(new MyTargetBannerLoaderImpl$loadBanner$1(myTargetBannerItem, context, myTargetImageBgProvider, objectRef, adEventListenerHolder, analytics, z));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create<MyTarg…      ad.load()\n        }");
        return create;
    }
}
