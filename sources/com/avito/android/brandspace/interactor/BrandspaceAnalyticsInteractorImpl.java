package com.avito.android.brandspace.interactor;

import a2.g.r.g;
import android.os.SystemClock;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.ScreenIdField;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.brandspace.di.BrandspaceId;
import com.avito.android.brandspace.di.BrandspaceInitialTreeParent;
import com.avito.android.brandspace.di.BrandspaceSourceAnnotation;
import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import com.avito.android.brandspace.interactor.events.BrandspaceAdvertClickEvent;
import com.avito.android.brandspace.interactor.events.BrandspaceBlockClickEvent;
import com.avito.android.brandspace.interactor.events.BrandspaceBlockViewEvent;
import com.avito.android.brandspace.interactor.events.BrandspacePageLoadEvent;
import com.avito.android.brandspace.interactor.events.BrandspaceVisitEvent;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.items.adverts.BrandspaceAdvertItem;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItem;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001BC\b\u0007\u0012\b\b\u0001\u00101\u001a\u00020\u001f\u0012\n\b\u0001\u0010G\u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010&\u001a\u00020#\u0012\n\b\u0001\u0010J\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010*\u001a\u00020'¢\u0006\u0004\bK\u0010LJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u00103R\u0016\u00107\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00106R&\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u001f0:j\b\u0012\u0004\u0012\u00020\u001f`;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b?\u00106\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR&\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u001f0:j\b\u0012\u0004\u0012\u00020\u001f`;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010=R\u0018\u0010G\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u00100R&\u0010I\u001a\u0012\u0012\u0004\u0012\u00020\u001f0:j\b\u0012\u0004\u0012\u00020\u001f`;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010=¨\u0006M"}, d2 = {"Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractorImpl;", "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getParent", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "", "durationToTrackVisit", "", "sendPageLoaded", "(Ljava/lang/Long;)V", "Lcom/avito/android/brandspace/items/BlockType;", "blockType", "sendBlockViewIfNeeded", "(Lcom/avito/android/brandspace/items/BlockType;)V", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "item", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "forceBlockClick", "trackBlockClick", "(Lcom/avito/android/brandspace/presenter/BrandspaceItem;Lcom/avito/android/deep_linking/links/DeepLink;Z)V", "scheduleVisitTrackIfNeeded", "()V", "stopVisitTrackIfNeeded", "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor$State;", "saveState", "()Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor$State;", "state", "restoreState", "(Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor$State;)V", "", BookingInfoActivity.EXTRA_ITEM_ID, AuthSource.SEND_ABUSE, "(Ljava/lang/String;Lcom/avito/android/brandspace/items/BlockType;)V", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "k", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "Lcom/avito/android/util/SchedulersFactory3;", "l", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/analytics/Analytics;", "j", "Lcom/avito/android/analytics/Analytics;", "analytics", "h", "Ljava/lang/String;", "id", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "trackVisitDisposable", "c", "J", "startTrackingVisitTime", AuthSource.BOOKING_ORDER, "stateId", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "f", "Ljava/util/HashSet;", "trackedBlockTypeClicks", "d", "getDurationToTrackVisit", "()J", "setDurationToTrackVisit", "(J)V", "e", "trackedBlockTypeViews", "i", "source", g.a, "trackedAdvertClicks", "parent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/provider/TreeStateIdGenerator;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/util/SchedulersFactory3;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceAnalyticsInteractorImpl implements BrandspaceAnalyticsInteractor {
    public Disposable a;
    public long b;
    public long c = -1;
    public long d = -1;
    public HashSet<String> e = new HashSet<>();
    public HashSet<String> f = new HashSet<>();
    public HashSet<String> g = new HashSet<>();
    public final String h;
    public final String i;
    public final Analytics j;
    public final TreeStateIdGenerator k;
    public final SchedulersFactory3 l;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ BrandspaceAnalyticsInteractorImpl a;

        public a(BrandspaceAnalyticsInteractorImpl brandspaceAnalyticsInteractorImpl) {
            this.a = brandspaceAnalyticsInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.c = -1;
            this.a.a = null;
            BrandspaceAnalyticsInteractorImpl.access$sendPageVisit(this.a);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
        }
    }

    @Inject
    public BrandspaceAnalyticsInteractorImpl(@BrandspaceId @NotNull String str, @BrandspaceSourceAnnotation @Nullable String str2, @NotNull Analytics analytics, @NotNull TreeStateIdGenerator treeStateIdGenerator, @BrandspaceInitialTreeParent @Nullable TreeClickStreamParent treeClickStreamParent, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(treeStateIdGenerator, "treeStateIdGenerator");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.h = str;
        this.i = str2;
        this.j = analytics;
        this.k = treeStateIdGenerator;
        this.l = schedulersFactory3;
        this.b = treeStateIdGenerator.nextStateId();
    }

    public static final void access$sendPageVisit(BrandspaceAnalyticsInteractorImpl brandspaceAnalyticsInteractorImpl) {
        brandspaceAnalyticsInteractorImpl.setDurationToTrackVisit(-1);
        brandspaceAnalyticsInteractorImpl.j.track(new BrandspaceVisitEvent(brandspaceAnalyticsInteractorImpl.i, brandspaceAnalyticsInteractorImpl.h));
    }

    public final void a(String str, BlockType blockType) {
        if (!this.g.contains(str)) {
            this.g.add(str);
            this.j.track(new BrandspaceAdvertClickEvent(str, blockType, this.h));
        }
    }

    @Override // com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor
    public long getDurationToTrackVisit() {
        return this.d;
    }

    @Override // com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor
    @NotNull
    public TreeClickStreamParent getParent() {
        return new TreeClickStreamParent(this.b, ScreenIdField.BRANDSPACE.name(), null, null);
    }

    @Override // com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor
    public void restoreState(@NotNull BrandspaceAnalyticsInteractor.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.b = state.getStateId();
        setDurationToTrackVisit(state.getDurationToTrackVisit());
        this.e = state.getTrackedBlockTypeViews();
        this.f = state.getTrackedBlockTypeClicks();
        this.g = state.getTrackedAdvertClicks();
    }

    @Override // com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor
    @NotNull
    public BrandspaceAnalyticsInteractor.State saveState() {
        return new BrandspaceAnalyticsInteractor.State(this.b, getDurationToTrackVisit(), this.e, this.f, this.g);
    }

    @Override // com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor
    public void scheduleVisitTrackIfNeeded() {
        long durationToTrackVisit = getDurationToTrackVisit();
        if (durationToTrackVisit != -1 && this.a == null) {
            this.c = SystemClock.elapsedRealtime();
            this.a = Single.just(Unit.INSTANCE).delay(durationToTrackVisit, TimeUnit.MILLISECONDS).subscribeOn(this.l.mainThread()).subscribe(new a(this), b.a);
        }
    }

    @Override // com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor
    public void sendBlockViewIfNeeded(@NotNull BlockType blockType) {
        Intrinsics.checkNotNullParameter(blockType, "blockType");
        if (!this.e.contains(blockType.getValue())) {
            this.e.add(blockType.getValue());
            this.j.track(new BrandspaceBlockViewEvent(blockType, this.h));
        }
    }

    @Override // com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor
    public void sendPageLoaded(@Nullable Long l2) {
        this.b = this.k.nextStateId();
        setDurationToTrackVisit(l2 != null ? l2.longValue() : -1);
        this.j.track(new BrandspacePageLoadEvent(this.i, this.h));
    }

    public void setDurationToTrackVisit(long j2) {
        this.d = j2;
    }

    @Override // com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor
    public void stopVisitTrackIfNeeded() {
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.a = null;
        if (this.c != -1) {
            setDurationToTrackVisit(getDurationToTrackVisit() - (SystemClock.elapsedRealtime() - this.c));
            this.c = -1;
            if (getDurationToTrackVisit() <= 0) {
                setDurationToTrackVisit(-1);
                this.j.track(new BrandspaceVisitEvent(this.i, this.h));
            }
        }
    }

    @Override // com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor
    public void trackBlockClick(@NotNull BrandspaceItem brandspaceItem, @Nullable DeepLink deepLink, boolean z) {
        String str;
        Intrinsics.checkNotNullParameter(brandspaceItem, "item");
        sendBlockViewIfNeeded(brandspaceItem.getType());
        if (brandspaceItem instanceof BrandspaceAdvertItem) {
            str = ((BrandspaceAdvertItem) brandspaceItem).getAdvertItem().getStringId();
        } else {
            str = brandspaceItem instanceof MarketplaceSnippetItem ? String.valueOf(brandspaceItem.getId()) : null;
        }
        if (deepLink instanceof AdvertDetailsLink) {
            a(((AdvertDetailsLink) deepLink).getItemId(), brandspaceItem.getType());
        } else if (str == null || z) {
            BlockType type = brandspaceItem.getType();
            if (!this.f.contains(type.getValue())) {
                this.f.add(type.getValue());
                this.j.track(new BrandspaceBlockClickEvent(type, this.h));
            }
        } else {
            a(str, brandspaceItem.getType());
        }
    }
}
