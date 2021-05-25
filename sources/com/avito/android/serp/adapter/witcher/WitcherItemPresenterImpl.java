package com.avito.android.serp.adapter.witcher;

import android.os.Parcelable;
import com.avito.android.ab_tests.groups.ViewedItemsTabTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.module.WitcherModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.WitcherElement;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.witcher.WitcherAnalyticsInteractor;
import com.avito.android.serp.adapter.witcher.WitcherItemView;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.konveyor.data_source.ListDataSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BE\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020&0%\u0012\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-¢\u0006\u0004\b2\u00103J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0019\u001a\u00020\u0018*\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010#R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenterImpl;", "Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", "Lcom/avito/android/serp/adapter/witcher/WitcherItemView;", "view", "Lcom/avito/android/serp/adapter/witcher/WitcherItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/serp/adapter/witcher/WitcherItemView;Lcom/avito/android/serp/adapter/witcher/WitcherItem;I)V", "Landroid/os/Parcelable;", "parcel", "getSavedState", "(Landroid/os/Parcelable;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "invalidateState", "()V", "", "hasCarousel", "()Z", "Lcom/avito/android/remote/model/WitcherElement$SelectionType;", "Lcom/avito/android/serp/adapter/witcher/WitcherItemView$SelectionType;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/WitcherElement$SelectionType;)Lcom/avito/android/serp/adapter/witcher/WitcherItemView$SelectionType;", "Lcom/avito/android/serp/adapter/witcher/WitcherResourceProvider;", "c", "Lcom/avito/android/serp/adapter/witcher/WitcherResourceProvider;", "witcherResourceProvider", "Lcom/avito/android/serp/adapter/witcher/WitcherAnalyticsInteractor;", "e", "Lcom/avito/android/serp/adapter/witcher/WitcherAnalyticsInteractor;", "witcherAnalyticsInteractor", "Lcom/avito/android/util/Kundle;", "state", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/witcher/WitcherItemListener;", "d", "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/witcher/WitcherItem;", "witcherItem", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/ViewedItemsTabTestGroup;", "f", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "viewedItemsTabTestGroup", "<init>", "(Lcom/avito/android/serp/adapter/witcher/WitcherResourceProvider;Ldagger/Lazy;Lcom/avito/android/util/Kundle;Lcom/avito/android/serp/adapter/witcher/WitcherAnalyticsInteractor;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class WitcherItemPresenterImpl implements WitcherItemPresenter {
    public final Kundle a;
    public WitcherItem b;
    public final WitcherResourceProvider c;
    public final Lazy<WitcherItemListener> d;
    public final WitcherAnalyticsInteractor e;
    public final SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            WitcherElement.SelectionType.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            WitcherElement.SelectionType selectionType = WitcherElement.SelectionType.REGULAR;
            iArr[0] = 1;
            WitcherElement.SelectionType selectionType2 = WitcherElement.SelectionType.SELECTED;
            iArr[1] = 2;
            WitcherElement.SelectionType selectionType3 = WitcherElement.SelectionType.SCROLLABLE;
            iArr[2] = 3;
            WitcherElement.SelectionType selectionType4 = WitcherElement.SelectionType.SCROLLABLE_CLICKABLE_HEADER;
            iArr[3] = 4;
            WitcherElement.SelectionType selectionType5 = WitcherElement.SelectionType.MARKETPLACE;
            iArr[4] = 5;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error(th);
            } else if (i == 1) {
                Logs.error(th);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;

        public b(int i, Object obj, Object obj2, Object obj3) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = obj3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((WitcherItemPresenterImpl) this.b).e.sendClickWitcher(WitcherAnalyticsInteractor.FromBlock.BUTTON);
                WitcherItemPresenterImpl.access$followDeeplink((WitcherItemPresenterImpl) this.b, ((WitcherItem) this.c).getDeepLink());
            } else if (i == 1) {
                ((WitcherItemPresenterImpl) this.b).e.sendClickWitcher(WitcherAnalyticsInteractor.FromBlock.HEADER);
                WitcherItemPresenterImpl.access$followDeeplink((WitcherItemPresenterImpl) this.b, ((WitcherItem) this.c).getDeepLink());
            } else {
                throw null;
            }
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WitcherItemView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(WitcherItemView witcherItemView) {
            super(0);
            this.a = witcherItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getFavoriteAdvertsPresenter().detachViews();
            this.a.getViewedAdvertsPresenter().detachView();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public WitcherItemPresenterImpl(@NotNull WitcherResourceProvider witcherResourceProvider, @NotNull Lazy<WitcherItemListener> lazy, @WitcherModule.WitcherItemsSavedState @Nullable Kundle kundle, @NotNull WitcherAnalyticsInteractor witcherAnalyticsInteractor, @Nullable SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> singleManuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(witcherResourceProvider, "witcherResourceProvider");
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(witcherAnalyticsInteractor, "witcherAnalyticsInteractor");
        this.c = witcherResourceProvider;
        this.d = lazy;
        this.e = witcherAnalyticsInteractor;
        this.f = singleManuallyExposedAbTestGroup;
        this.a = kundle == null ? new Kundle() : kundle;
    }

    public static final void access$followDeeplink(WitcherItemPresenterImpl witcherItemPresenterImpl, DeepLink deepLink) {
        Objects.requireNonNull(witcherItemPresenterImpl);
        if (deepLink != null) {
            witcherItemPresenterImpl.d.get().onWitcherSearchButtonClicked(deepLink);
        }
    }

    public final WitcherItemView.SelectionType a(WitcherElement.SelectionType selectionType) {
        int ordinal = selectionType.ordinal();
        if (ordinal == 0) {
            return WitcherItemView.SelectionType.REGULAR;
        }
        if (ordinal == 1) {
            return WitcherItemView.SelectionType.SELECTED;
        }
        if (ordinal == 2) {
            return WitcherItemView.SelectionType.SCROLLABLE;
        }
        if (ordinal == 3) {
            return WitcherItemView.SelectionType.SCROLLABLE_CLICKABLE_HEADER;
        }
        if (ordinal == 4) {
            return WitcherItemView.SelectionType.MARKETPLACE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemPresenter
    public void getSavedState(@Nullable Parcelable parcelable) {
        this.a.putParcelable(WitcherItemPresenterKt.SAVED_STATE_KEY, parcelable);
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemPresenter
    public boolean hasCarousel() {
        WitcherElement.SelectionType selectionType;
        WitcherItemView.SelectionType a3;
        WitcherItem witcherItem = this.b;
        if (witcherItem == null || (selectionType = witcherItem.getSelectionType()) == null || (a3 = a(selectionType)) == null) {
            return false;
        }
        return a3.getHasCarousel();
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemPresenter
    public void invalidateState() {
        this.a.clear();
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherItemPresenter
    @NotNull
    public Kundle onSaveState() {
        return this.a;
    }

    public void bindView(@NotNull WitcherItemView witcherItemView, @NotNull WitcherItem witcherItem, int i) {
        Intrinsics.checkNotNullParameter(witcherItemView, "view");
        Intrinsics.checkNotNullParameter(witcherItem, "item");
        this.b = witcherItem;
        SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> singleManuallyExposedAbTestGroup = this.f;
        if (singleManuallyExposedAbTestGroup != null) {
            singleManuallyExposedAbTestGroup.exposeIfNeeded();
        }
        if (hasCarousel()) {
            witcherItemView.subscribeToScrollChanges();
        }
        witcherItemView.setTitle(witcherItem.getTitleText());
        witcherItemView.setButtonText(witcherItem.getButtonText());
        witcherItemView.setSelectionType(a(witcherItem.getSelectionType()));
        witcherItemView.setUnbindListener(new c(witcherItemView));
        List<PersistableSerpItem> items = witcherItem.getItems();
        if (!hasCarousel()) {
            items = CollectionsKt___CollectionsKt.take(items, this.c.getElementsCountForWitcher());
        }
        ListDataSource listDataSource = new ListDataSource(items);
        witcherItemView.setItems(listDataSource);
        witcherItemView.getFavoriteAdvertsPresenter().onDataSourceChanged(listDataSource);
        witcherItemView.getFavoriteAdvertsPresenter().attachView(witcherItemView);
        witcherItemView.getViewedAdvertsPresenter().onDataSourceChanged(listDataSource);
        witcherItemView.getViewedAdvertsPresenter().attachView(witcherItemView);
        if (hasCarousel()) {
            witcherItemView.setInnerItemsSavedState(this.a.getParcelable(WitcherItemPresenterKt.SAVED_STATE_KEY));
        }
        witcherItemView.getButtonClicks().subscribe(new b(0, this, witcherItem, witcherItemView), a.b);
        witcherItemView.getTitleClicks().subscribe(new b(1, this, witcherItem, witcherItemView), a.c);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WitcherItemPresenterImpl(WitcherResourceProvider witcherResourceProvider, Lazy lazy, Kundle kundle, WitcherAnalyticsInteractor witcherAnalyticsInteractor, SingleManuallyExposedAbTestGroup singleManuallyExposedAbTestGroup, int i, j jVar) {
        this(witcherResourceProvider, lazy, (i & 4) != 0 ? null : kundle, witcherAnalyticsInteractor, (i & 16) != 0 ? null : singleManuallyExposedAbTestGroup);
    }
}
