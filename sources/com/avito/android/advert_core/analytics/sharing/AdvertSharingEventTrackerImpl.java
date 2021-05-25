package com.avito.android.advert_core.analytics.sharing;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.analytics.sharing.ItemSharingEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/advert_core/analytics/sharing/AdvertSharingEventTrackerImpl;", "Lcom/avito/android/advert_core/analytics/sharing/AdvertSharingEventTracker;", "", "itemId", "networkType", "", "isAuthorized", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "", "trackSocialItemSharing", "(Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "trackItemSharing", "(Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/Features;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertSharingEventTrackerImpl implements AdvertSharingEventTracker {
    public final Analytics a;
    public final AccountStateProvider b;
    public final SchedulersFactory3 c;
    public final Features d;

    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ AdvertSharingEventTrackerImpl a;
        public final /* synthetic */ TreeClickStreamParent b;
        public final /* synthetic */ String c;

        public a(AdvertSharingEventTrackerImpl advertSharingEventTrackerImpl, TreeClickStreamParent treeClickStreamParent, String str) {
            this.a = advertSharingEventTrackerImpl;
            this.b = treeClickStreamParent;
            this.c = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            if (this.a.d.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
                Analytics analytics = this.a.a;
                TreeClickStreamParent treeClickStreamParent = this.b;
                String str3 = this.c;
                Intrinsics.checkNotNullExpressionValue(str2, ChannelContext.Item.USER_ID);
                analytics.track(new ItemSharingTreeEvent(treeClickStreamParent, str3, str2, 0, "share button", null, 32, null));
                return;
            }
            Analytics analytics2 = this.a.a;
            ItemSharingEvent.Companion companion = ItemSharingEvent.Companion;
            String str4 = this.c;
            Intrinsics.checkNotNullExpressionValue(str2, ChannelContext.Item.USER_ID);
            analytics2.track(ItemSharingEvent.Companion.createForAdvertDetails$default(companion, str4, str2, 0, "share button", null, 16, null));
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("UserId getting for ItemSharingEvent is failure", th);
        }
    }

    public static final class c<T> implements Consumer<String> {
        public final /* synthetic */ AdvertSharingEventTrackerImpl a;
        public final /* synthetic */ TreeClickStreamParent b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ boolean e;

        public c(AdvertSharingEventTrackerImpl advertSharingEventTrackerImpl, TreeClickStreamParent treeClickStreamParent, String str, String str2, boolean z) {
            this.a = advertSharingEventTrackerImpl;
            this.b = treeClickStreamParent;
            this.c = str;
            this.d = str2;
            this.e = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            if (this.a.d.getAdvertDetailsClientAnalytics().invoke().booleanValue()) {
                Analytics analytics = this.a.a;
                TreeClickStreamParent treeClickStreamParent = this.b;
                String str3 = this.c;
                Intrinsics.checkNotNullExpressionValue(str2, ChannelContext.Item.USER_ID);
                analytics.track(new ItemSharingTreeEvent(treeClickStreamParent, str3, str2, AdvertSharingEventTrackerKt.access$toSocialNetworkType(this.d), "social block", Boolean.valueOf(this.e)));
                return;
            }
            Analytics analytics2 = this.a.a;
            ItemSharingEvent.Companion companion = ItemSharingEvent.Companion;
            String str4 = this.c;
            Intrinsics.checkNotNullExpressionValue(str2, ChannelContext.Item.USER_ID);
            analytics2.track(companion.createForAdvertDetails(str4, str2, AdvertSharingEventTrackerKt.access$toSocialNetworkType(this.d), "social block", Boolean.valueOf(this.e)));
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("UserId getting for ItemSharingEvent is failure", th);
        }
    }

    @Inject
    public AdvertSharingEventTrackerImpl(@NotNull Analytics analytics, @NotNull AccountStateProvider accountStateProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = analytics;
        this.b = accountStateProvider;
        this.c = schedulersFactory3;
        this.d = features;
    }

    @Override // com.avito.android.advert_core.analytics.sharing.AdvertSharingEventTracker
    public void trackItemSharing(@NotNull String str, @Nullable TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.b.currentUserId().toSingle().observeOn(this.c.mainThread()).subscribe(new a(this, treeClickStreamParent, str), b.a);
    }

    @Override // com.avito.android.advert_core.analytics.sharing.AdvertSharingEventTracker
    public void trackSocialItemSharing(@NotNull String str, @Nullable String str2, boolean z, @Nullable TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.b.currentUserId().toSingle().observeOn(this.c.mainThread()).subscribe(new c(this, treeClickStreamParent, str, str2, z), d.a);
    }
}
