package com.avito.android.serp.ad;

import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdNetworkBanner;
import com.my.target.nativeads.NativeAd;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u001b\u001cJ\u001d\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\u0007R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u0001\u0002\u001d\u001e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/serp/ad/MyTargetBanner;", "Lcom/avito/android/remote/model/AdNetworkBanner;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "viewRef", "", "registerView", "(Ljava/lang/ref/WeakReference;)V", "view", "unregisterView", AuthSource.SEND_ABUSE, "Ljava/lang/ref/WeakReference;", "registeredView", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getBgColor", "()Ljava/lang/Integer;", "setBgColor", "(Ljava/lang/Integer;)V", "bgColor", "Lcom/my/target/nativeads/NativeAd;", "c", "Lcom/my/target/nativeads/NativeAd;", "getAd", "()Lcom/my/target/nativeads/NativeAd;", "ad", "MyTargetAppInstallBanner", "MyTargetContentBanner", "Lcom/avito/android/serp/ad/MyTargetBanner$MyTargetAppInstallBanner;", "Lcom/avito/android/serp/ad/MyTargetBanner$MyTargetContentBanner;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class MyTargetBanner implements AdNetworkBanner {
    public WeakReference<View> a;
    @Nullable
    public Integer b;
    @NotNull
    public final NativeAd c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/serp/ad/MyTargetBanner$MyTargetAppInstallBanner;", "Lcom/avito/android/serp/ad/MyTargetBanner;", "Lcom/avito/android/serp/ad/AdEventListenerHolder;", "d", "Lcom/avito/android/serp/ad/AdEventListenerHolder;", "getAdEventListenerHolder", "()Lcom/avito/android/serp/ad/AdEventListenerHolder;", "adEventListenerHolder", "Lcom/my/target/nativeads/NativeAd;", "ad", "<init>", "(Lcom/my/target/nativeads/NativeAd;Lcom/avito/android/serp/ad/AdEventListenerHolder;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class MyTargetAppInstallBanner extends MyTargetBanner {
        @NotNull
        public final AdEventListenerHolder d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MyTargetAppInstallBanner(@NotNull NativeAd nativeAd, @NotNull AdEventListenerHolder adEventListenerHolder) {
            super(nativeAd, null);
            Intrinsics.checkNotNullParameter(nativeAd, "ad");
            Intrinsics.checkNotNullParameter(adEventListenerHolder, "adEventListenerHolder");
            this.d = adEventListenerHolder;
        }

        @NotNull
        public final AdEventListenerHolder getAdEventListenerHolder() {
            return this.d;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/serp/ad/MyTargetBanner$MyTargetContentBanner;", "Lcom/avito/android/serp/ad/MyTargetBanner;", "Lcom/avito/android/serp/ad/AdEventListenerHolder;", "d", "Lcom/avito/android/serp/ad/AdEventListenerHolder;", "getAdEventListenerHolder", "()Lcom/avito/android/serp/ad/AdEventListenerHolder;", "adEventListenerHolder", "Lcom/my/target/nativeads/NativeAd;", "ad", "<init>", "(Lcom/my/target/nativeads/NativeAd;Lcom/avito/android/serp/ad/AdEventListenerHolder;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class MyTargetContentBanner extends MyTargetBanner {
        @NotNull
        public final AdEventListenerHolder d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MyTargetContentBanner(@NotNull NativeAd nativeAd, @NotNull AdEventListenerHolder adEventListenerHolder) {
            super(nativeAd, null);
            Intrinsics.checkNotNullParameter(nativeAd, "ad");
            Intrinsics.checkNotNullParameter(adEventListenerHolder, "adEventListenerHolder");
            this.d = adEventListenerHolder;
        }

        @NotNull
        public final AdEventListenerHolder getAdEventListenerHolder() {
            return this.d;
        }
    }

    public MyTargetBanner(NativeAd nativeAd, j jVar) {
        this.c = nativeAd;
    }

    @NotNull
    public final NativeAd getAd() {
        return this.c;
    }

    @Nullable
    public final Integer getBgColor() {
        return this.b;
    }

    public final void registerView(@Nullable WeakReference<View> weakReference) {
        View view;
        View view2 = null;
        View view3 = weakReference != null ? weakReference.get() : null;
        WeakReference<View> weakReference2 = this.a;
        if (weakReference2 != null) {
            view2 = weakReference2.get();
        }
        if (!Intrinsics.areEqual(view3, view2)) {
            this.c.unregisterView();
            this.a = weakReference;
            if (weakReference != null && (view = weakReference.get()) != null) {
                this.c.registerView(view);
            }
        }
    }

    public final void setBgColor(@Nullable Integer num) {
        this.b = num;
    }

    public final void unregisterView(@Nullable WeakReference<View> weakReference) {
        WeakReference<View> weakReference2 = this.a;
        if (Intrinsics.areEqual(weakReference2 != null ? weakReference2.get() : null, weakReference != null ? weakReference.get() : null)) {
            this.c.unregisterView();
            this.a = null;
        }
    }
}
