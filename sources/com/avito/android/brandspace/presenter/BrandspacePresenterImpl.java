package com.avito.android.brandspace.presenter;

import a2.a.a.w.c.j;
import a2.a.a.w.c.k;
import a2.a.a.w.c.l;
import a2.a.a.w.c.m;
import a2.a.a.w.c.n;
import a2.a.a.w.c.o;
import a2.a.a.w.c.p;
import a2.a.a.w.c.s;
import a2.a.a.w.c.v;
import a2.a.a.w.c.w;
import a2.a.a.w.c.x;
import a2.g.r.g;
import android.os.Bundle;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import com.avito.android.brandspace.interactor.BrandspaceInteractor;
import com.avito.android.brandspace.items.adverts.BrandspaceAdvertItem;
import com.avito.android.brandspace.items.carousel.CarouselItem;
import com.avito.android.brandspace.items.categories.CategoriesItem;
import com.avito.android.brandspace.items.marketplace.tab.MarketplaceTabsItem;
import com.avito.android.brandspace.items.wideabout.WideAboutItem;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import com.avito.android.brandspace.presenter.tracker.BrandspaceTracker;
import com.avito.android.brandspace.presenter.virtualitems.VirtualItem;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems;
import com.avito.android.brandspace.remote.model.Brandspace;
import com.avito.android.brandspace.remote.model.BrandspaceAdjustParameters;
import com.avito.android.brandspace.remote.model.BrandspaceElement;
import com.avito.android.brandspace.remote.model.BrandspaceSERPModule;
import com.avito.android.brandspace.router.BrandspaceRouter;
import com.avito.android.brandspace.utils.VirtualItemsKt;
import com.avito.android.brandspace.view.BrandspaceView;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.Image;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.util.Collections;
import com.avito.android.util.LoadingState;
import com.avito.android.util.LoadingStateKt;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Disposables;
import com.avito.konveyor.data_source.ListDataSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002BQ\b\u0007\u0012\u0006\u0010\u001a\u00020|\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010n\u001a\u00020k\u0012\u0006\u0010t\u001a\u00020q\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010b\u001a\u00020_\u0012\u0006\u0010]\u001a\u00020Z¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\tJ\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\tJ\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\tJ\u001f\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J'\u0010'\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00192\u0006\u0010 \u001a\u00020$2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00192\u0006\u0010 \u001a\u00020$H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00052\u0006\u0010 \u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020%2\u0006\u0010 \u001a\u000200H\u0016¢\u0006\u0004\b3\u00104J)\u00109\u001a\u00020\u00052\u0006\u00106\u001a\u0002052\u0006\u0010#\u001a\u00020\u00192\b\u00108\u001a\u0004\u0018\u000107H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020\u00052\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b?\u0010/J#\u0010C\u001a\u00020\u00052\b\u0010A\u001a\u0004\u0018\u00010@2\b\u0010B\u001a\u0004\u0018\u00010@H\u0016¢\u0006\u0004\bC\u0010DJ\u001f\u0010E\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00192\u0006\u0010 \u001a\u00020$H\u0002¢\u0006\u0004\bE\u0010+J\u000f\u0010F\u001a\u00020\u0005H\u0002¢\u0006\u0004\bF\u0010\tJ\u000f\u0010G\u001a\u00020\u0005H\u0002¢\u0006\u0004\bG\u0010\tJ\u0017\u0010J\u001a\u00020\u00052\u0006\u0010I\u001a\u00020HH\u0002¢\u0006\u0004\bJ\u0010KJ\u001d\u0010N\u001a\u00020\u00052\f\u0010M\u001a\b\u0012\u0004\u0012\u0002000LH\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u0005H\u0002¢\u0006\u0004\bP\u0010\tJ\u0015\u0010R\u001a\b\u0012\u0004\u0012\u0002000QH\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010V\u001a\u00020\u00052\u0006\u0010U\u001a\u00020TH\u0002¢\u0006\u0004\bV\u0010WJ\u0019\u0010X\u001a\u0004\u0018\u0001002\u0006\u0010 \u001a\u00020;H\u0002¢\u0006\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010^R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u001e\u0010e\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010dR\u001e\u0010g\u001a\n\u0012\u0004\u0012\u00020f\u0018\u00010c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010dR\u0018\u0010j\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010iR\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u001c\u0010p\u001a\b\u0012\u0004\u0012\u0002000Q8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010oR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010x\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010{\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010zR\u0016\u0010\u001a\u00020|8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bR\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010iR\u0019\u0010\u0001\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010iR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/brandspace/presenter/BrandspacePresenterImpl;", "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/brandspace/view/BrandspaceView;", "view", "", "onViewCreated", "(Lcom/avito/android/brandspace/view/BrandspaceView;)V", "onViewDestroyed", "()V", "onViewResumed", "onViewPaused", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "savedInstanceState", "onRestoreState", "(Landroid/os/Bundle;)V", "Lcom/avito/android/brandspace/router/BrandspaceRouter;", "router", "onViewStarted", "(Lcom/avito/android/brandspace/router/BrandspaceRouter;)V", "onViewStopped", "onUpClicked", "onRetryClicked", "", FirebaseAnalytics.Param.INDEX, "Lcom/avito/android/brandspace/items/categories/CategoriesItem;", "categoryItem", "onCategoriesClicked", "(ILcom/avito/android/brandspace/items/categories/CategoriesItem;)V", "Lcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabsItem;", "item", "onTabCategoriesClicked", "(ILcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabsItem;)V", VKApiConst.POSITION, "Lcom/avito/android/brandspace/items/carousel/CarouselItem;", "", "isProgrammatic", "onCarouselCurrentPositionChanged", "(ILcom/avito/android/brandspace/items/carousel/CarouselItem;Z)V", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "onCarouselHeightChanged", "(ILcom/avito/android/brandspace/items/carousel/CarouselItem;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "openDeeplink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "onItemViewTracked", "(Lcom/avito/android/brandspace/presenter/BrandspaceItem;)V", "isLastItemInBlock", "(Lcom/avito/android/brandspace/presenter/BrandspaceItem;)Z", "Lcom/avito/android/serp/adapter/AdvertItem;", "advert", "Lcom/avito/android/remote/model/Image;", "image", "onAdvertClicked", "(Lcom/avito/android/serp/adapter/AdvertItem;ILcom/avito/android/remote/model/Image;)V", "Lcom/avito/android/serp/adapter/FavorableItem;", "favorableItem", "onFavoriteButtonClicked", "(Lcom/avito/android/serp/adapter/FavorableItem;)V", "onAdditionalActionClicked", "", "videoUrl", "blockType", "openVideoUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "h", "c", "d", "Lcom/avito/android/brandspace/remote/model/Brandspace;", ScreenPublicConstsKt.CONTENT_TYPE_BRANDSPACE, "e", "(Lcom/avito/android/brandspace/remote/model/Brandspace;)V", "", "newItems", "i", "(Ljava/util/List;)V", g.a, "", AuthSource.BOOKING_ORDER, "()Ljava/util/List;", "Lcom/avito/android/remote/error/TypedError;", "typedError", "f", "(Lcom/avito/android/remote/error/TypedError;)V", AuthSource.SEND_ABUSE, "(Lcom/avito/android/serp/adapter/FavorableItem;)Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "Lcom/avito/android/util/SchedulersFactory3;", "r", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/brandspace/router/BrandspaceRouter;", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", VKApiConst.Q, "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "resources", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/util/LoadingState;", "brandspaceState", "Lcom/avito/android/brandspace/presenter/BrandspaceAdverts;", "filteredAdvertsState", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "filteredAdvertsDisposable", "Lcom/avito/android/brandspace/presenter/tracker/BrandspaceTracker;", "n", "Lcom/avito/android/brandspace/presenter/tracker/BrandspaceTracker;", "tracker", "Ljava/util/List;", "items", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "o", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "j", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "itemVisibilityTracker", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "compositeDisposable", "Lcom/avito/android/brandspace/presenter/BrandspaceItemBuilder;", "k", "Lcom/avito/android/brandspace/presenter/BrandspaceItemBuilder;", "itemBuilder", "Lcom/avito/android/brandspace/view/BrandspaceView;", "Lcom/avito/android/brandspace/interactor/BrandspaceInteractor;", "l", "Lcom/avito/android/brandspace/interactor/BrandspaceInteractor;", "interactor", "brandspaceDisposable", "buildItemsDisposable", "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "p", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "<init>", "(Lcom/avito/android/brandspace/presenter/BrandspaceItemBuilder;Lcom/avito/android/brandspace/interactor/BrandspaceInteractor;Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;Lcom/avito/android/brandspace/presenter/tracker/BrandspaceTracker;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;Lcom/avito/android/util/SchedulersFactory3;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspacePresenterImpl implements BrandspacePresenter, AdvertItemListener {
    public BrandspaceRouter a;
    public BrandspaceView b;
    public Disposable c;
    public Disposable d;
    public Disposable e;
    public final CompositeDisposable f = new CompositeDisposable();
    public LoadingState<? super Brandspace> g;
    public LoadingState<? super BrandspaceAdverts> h;
    public List<BrandspaceItem> i = new ArrayList();
    public ItemVisibilityTracker j;
    public final BrandspaceItemBuilder k;
    public final BrandspaceInteractor l;
    public final BrandspaceAnalyticsInteractor m;
    public final BrandspaceTracker n;
    public final FavoriteAdvertsPresenter o;
    public final TypedErrorThrowableConverter p;
    public final BrandspaceResourcesProvider q;
    public final SchedulersFactory3 r;

    public static final class a implements Action {
        public final /* synthetic */ BrandspacePresenterImpl a;

        public a(BrandspacePresenterImpl brandspacePresenterImpl) {
            this.a = brandspacePresenterImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.d = null;
        }
    }

    public static final class b<T> implements Consumer<List<? extends BrandspaceItem>> {
        public final /* synthetic */ BrandspacePresenterImpl a;

        public b(BrandspacePresenterImpl brandspacePresenterImpl) {
            this.a = brandspacePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends BrandspaceItem> list) {
            List<? extends BrandspaceItem> list2 = list;
            BrandspacePresenterImpl brandspacePresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "resultItems");
            brandspacePresenterImpl.i(list2);
            BrandspacePresenterImpl.access$showBrandspaceItems(this.a);
            BrandspacePresenterImpl.access$onLoadVirtualItems(this.a);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("BrandspacePresenter", "Error showBrandspace", th);
        }
    }

    @Inject
    public BrandspacePresenterImpl(@NotNull BrandspaceItemBuilder brandspaceItemBuilder, @NotNull BrandspaceInteractor brandspaceInteractor, @NotNull BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor, @NotNull BrandspaceTracker brandspaceTracker, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull BrandspaceResourcesProvider brandspaceResourcesProvider, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(brandspaceItemBuilder, "itemBuilder");
        Intrinsics.checkNotNullParameter(brandspaceInteractor, "interactor");
        Intrinsics.checkNotNullParameter(brandspaceAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(brandspaceTracker, "tracker");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(brandspaceResourcesProvider, "resources");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.k = brandspaceItemBuilder;
        this.l = brandspaceInteractor;
        this.m = brandspaceAnalyticsInteractor;
        this.n = brandspaceTracker;
        this.o = favoriteAdvertsPresenter;
        this.p = typedErrorThrowableConverter;
        this.q = brandspaceResourcesProvider;
        this.r = schedulersFactory3;
    }

    public static final void access$onBrandspaceLoadError(BrandspacePresenterImpl brandspacePresenterImpl, Throwable th) {
        brandspacePresenterImpl.n.trackBrandspaceLoadError();
        TypedError convert = brandspacePresenterImpl.p.convert(th);
        brandspacePresenterImpl.g = new LoadingState.Error(convert);
        brandspacePresenterImpl.f(convert);
    }

    public static final void access$onBrandspaceLoaded(BrandspacePresenterImpl brandspacePresenterImpl, Brandspace brandspace) {
        brandspacePresenterImpl.n.trackBrandspaceLoaded();
        BrandspaceAdjustParameters adjustParameters = brandspace.getAdjustParameters();
        brandspacePresenterImpl.m.sendPageLoaded(adjustParameters != null ? Long.valueOf(TimeUnit.SECONDS.toMillis(adjustParameters.getVisitDuration())) : null);
        brandspacePresenterImpl.m.scheduleVisitTrackIfNeeded();
        List<BrandspaceElement> elements = brandspace.getElements();
        if (elements == null) {
            elements = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (T t : elements) {
            boolean z2 = true;
            if (t instanceof BrandspaceSERPModule) {
                if (!z) {
                    z = true;
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                arrayList.add(t);
            }
        }
        Brandspace copy$default = Brandspace.copy$default(brandspace, null, null, arrayList, null, 11, null);
        brandspacePresenterImpl.g = new LoadingState.Loaded(copy$default);
        brandspacePresenterImpl.e(copy$default);
    }

    public static final void access$onLoadVirtualItems(BrandspacePresenterImpl brandspacePresenterImpl) {
        List<BrandspaceItem> list = brandspacePresenterImpl.i;
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t instanceof ExtraLoadingListItems) {
                arrayList.add(t);
            }
        }
        CompositeDisposable compositeDisposable = brandspacePresenterImpl.f;
        Disposable subscribe = Observable.fromIterable(arrayList).filter(p.a).flatMapSingle(new s(brandspacePresenterImpl)).observeOn(brandspacePresenterImpl.r.mainThread()).doOnNext(v.a).debounce(2000, TimeUnit.MILLISECONDS).subscribe(new w(brandspacePresenterImpl), x.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "Observable.fromIterable(…ets\", it) }\n            )");
        Disposables.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$showBrandspaceItems(BrandspacePresenterImpl brandspacePresenterImpl) {
        brandspacePresenterImpl.o.onDataSourceChanged(new ListDataSource(brandspacePresenterImpl.i));
        brandspacePresenterImpl.g();
        brandspacePresenterImpl.n.trackBrandspaceDraw();
    }

    public final BrandspaceItem a(FavorableItem favorableItem) {
        T t;
        boolean z;
        Iterator<T> it = this.i.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            T t2 = t;
            if (!(t2 instanceof BrandspaceAdvertItem) || t2.getAdvertItem().getId() != favorableItem.getId()) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        return t;
    }

    public final List<BrandspaceItem> b() {
        List<BrandspaceItem> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.i);
        VirtualItemsKt.unpackVirtualItems(mutableList);
        ArrayList arrayList = new ArrayList();
        for (T t : mutableList) {
            if (t instanceof WideAboutItem) {
                arrayList.add(t);
            }
        }
        ArrayList<WideAboutItem> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            WideAboutItem wideAboutItem = (WideAboutItem) obj;
            if (!this.q.isAboutWide()) {
                arrayList2.add(obj);
            }
        }
        for (WideAboutItem wideAboutItem2 : arrayList2) {
            int indexOf = mutableList.indexOf(wideAboutItem2);
            mutableList.remove(indexOf);
            mutableList.addAll(indexOf, wideAboutItem2.getNarrowAboutItems());
        }
        return mutableList;
    }

    public final void c() {
        LoadingState<? super Brandspace> loadingState = this.g;
        if (loadingState == null || (loadingState instanceof LoadingState.Error)) {
            this.n.startLoadingBrandspace();
            this.g = LoadingState.Loading.INSTANCE;
            BrandspaceView brandspaceView = this.b;
            if (brandspaceView != null) {
                brandspaceView.showLoading();
            }
            this.c = this.l.loadBrandspace().observeOn(this.r.mainThread()).doFinally(new j(this)).subscribe(new k(this), new l(this));
        }
    }

    public final void d() {
        BrandspaceView brandspaceView;
        LoadingState<? super Brandspace> loadingState = this.g;
        if (loadingState instanceof LoadingState.Loaded) {
            e((Brandspace) ((LoadingState.Loaded) loadingState).getData());
        } else if (loadingState instanceof LoadingState.Error) {
            f(((LoadingState.Error) loadingState).getError());
        } else if ((loadingState instanceof LoadingState.Loading) && (brandspaceView = this.b) != null) {
            brandspaceView.showLoading();
        }
    }

    public final void e(Brandspace brandspace) {
        Single<List<BrandspaceItem>> single;
        this.n.trackBrandspacePrepare();
        BrandspaceView brandspaceView = this.b;
        if (brandspaceView != null) {
            brandspaceView.showTitle(brandspace.getTitle());
        }
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d = null;
        if (this.i.isEmpty()) {
            single = this.k.build(brandspace);
        } else {
            single = this.k.refresh(this.i);
        }
        this.d = single.subscribeOn(this.r.computation()).observeOn(this.r.mainThread()).doFinally(new a(this)).subscribe(new b(this), c.a);
    }

    public final void f(TypedError typedError) {
        String str;
        this.n.trackBrandspaceErrorPrepare();
        if (typedError instanceof ErrorWithMessage) {
            str = ((ErrorWithMessage) typedError).getMessage();
        } else {
            str = this.q.getDefaultConnectionError();
        }
        BrandspaceView brandspaceView = this.b;
        if (brandspaceView != null) {
            brandspaceView.showError(str);
        }
        this.n.trackBrandspaceErrorDraw();
    }

    public final void g() {
        BrandspaceView brandspaceView = this.b;
        if (brandspaceView != null) {
            brandspaceView.showItems(b());
        }
    }

    public final void h(int i2, CarouselItem carouselItem) {
        Object obj;
        boolean z;
        CarouselItem copy$default = CarouselItem.copy$default(carouselItem, 0, null, null, 0, false, i2, 31, null);
        int indexOf = this.i.indexOf(carouselItem);
        if (indexOf >= 0) {
            this.i.remove(indexOf);
            this.i.add(indexOf, copy$default);
            return;
        }
        List<BrandspaceItem> list = this.i;
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t instanceof VirtualItem) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (((VirtualItem) next).isUnpackable()) {
                arrayList2.add(next);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (((VirtualItem) obj).getUnpackItems().indexOf(carouselItem) >= 0) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        VirtualItem virtualItem = (VirtualItem) obj;
        if (virtualItem != null) {
            virtualItem.replaceItem(carouselItem, copy$default);
        }
    }

    public final void i(List<? extends BrandspaceItem> list) {
        List<BrandspaceItem> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        this.i = mutableList;
        LoadingState<? super Brandspace> loadingState = this.g;
        boolean z = true;
        if ((!mutableList.isEmpty()) && (loadingState instanceof LoadingState.Loaded)) {
            Brandspace brandspace = (Brandspace) ((LoadingState.Loaded) loadingState).getData();
            if (this.h != null) {
                z = false;
            }
            List<BrandspaceElement> elements = brandspace.getElements();
            if (elements == null) {
                elements = CollectionsKt__CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (T t : elements) {
                if (t instanceof BrandspaceSERPModule) {
                    arrayList.add(t);
                }
            }
            BrandspaceSERPModule brandspaceSERPModule = (BrandspaceSERPModule) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            if (z && brandspaceSERPModule != null) {
                this.h = LoadingState.Loading.INSTANCE;
                this.e = this.l.loadFilteredAdverts(brandspaceSERPModule.getParameters()).doFinally(new m(this)).observeOn(this.r.mainThread()).subscribe(new n(this, brandspace), new o(this));
            }
        }
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    public boolean isLastItemInBlock(@NotNull BrandspaceItem brandspaceItem) {
        Intrinsics.checkNotNullParameter(brandspaceItem, "item");
        return this.k.isLastItemInBlock(brandspaceItem);
    }

    @Override // com.avito.android.serp.adapter.GroupingListener
    public void onAdditionalActionClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
    }

    @Override // com.avito.android.serp.adapter.AdvertItemListener
    public void onAdvertClicked(@NotNull AdvertItem advertItem, int i2, @Nullable Image image) {
        Intrinsics.checkNotNullParameter(advertItem, "advert");
        BrandspaceItem a3 = a(advertItem);
        Unit unit = null;
        if (a3 != null) {
            this.m.trackBlockClick(a3, null, false);
        }
        DeepLink deepLink = advertItem.getDeepLink();
        if (!(deepLink instanceof AdvertDetailsLink)) {
            deepLink = null;
        }
        AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink;
        if (advertDetailsLink != null) {
            BrandspaceRouter brandspaceRouter = this.a;
            if (brandspaceRouter != null) {
                brandspaceRouter.openAdvertDetails(advertDetailsLink.getItemId(), advertDetailsLink.getContext(), advertItem.getTitle(), advertItem.getPrice(), advertItem.getPreviousPrice(), image, this.m.getParent(), advertItem.isMarketplace());
                unit = Unit.INSTANCE;
            }
            if (unit != null) {
                return;
            }
        }
        BrandspaceRouter brandspaceRouter2 = this.a;
        if (brandspaceRouter2 != null) {
            brandspaceRouter2.followDeepLink(advertItem.getDeepLink());
        }
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    public void onCarouselCurrentPositionChanged(int i2, @NotNull CarouselItem carouselItem, boolean z) {
        Intrinsics.checkNotNullParameter(carouselItem, "item");
        if (!z) {
            this.m.trackBlockClick(carouselItem, null, false);
        }
        carouselItem.setCurrentPosition(i2);
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    public void onCarouselHeightChanged(int i2, @NotNull CarouselItem carouselItem) {
        Intrinsics.checkNotNullParameter(carouselItem, "item");
        h(i2, carouselItem);
        g();
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    public void onCategoriesClicked(int i2, @NotNull CategoriesItem categoriesItem) {
        Intrinsics.checkNotNullParameter(categoriesItem, "categoryItem");
        categoriesItem.setSelectedCategoryIndex(i2);
        List<BrandspaceItem> list = this.i;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            if ((t instanceof CarouselItem) && t.getId() == categoriesItem.getCategoriesId()) {
                t = CarouselItem.copy$default(t, 0, null, (List) r.getValue(categoriesItem.getCategoryItems(), Integer.valueOf(i2)), 0, false, 0, 51, null);
            }
            arrayList.add(t);
        }
        i(arrayList);
        this.m.trackBlockClick(categoriesItem, null, false);
        g();
    }

    @Override // com.avito.android.favorite.FavoriteButtonClickListener
    public void onFavoriteButtonClicked(@NotNull FavorableItem favorableItem) {
        Intrinsics.checkNotNullParameter(favorableItem, "favorableItem");
        BrandspaceItem a3 = a(favorableItem);
        if (a3 != null) {
            this.m.trackBlockClick(a3, null, true);
        }
        this.o.onFavoriteButtonClicked(favorableItem);
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    public void onItemViewTracked(@NotNull BrandspaceItem brandspaceItem) {
        Intrinsics.checkNotNullParameter(brandspaceItem, "item");
        this.m.sendBlockViewIfNeeded(brandspaceItem.getType());
    }

    @Override // com.avito.android.advert.actions.MoreActionsClickListener
    public void onMoreActionsClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        BrandspacePresenter.DefaultImpls.onMoreActionsClicked(this, str);
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    public void onRestoreState(@Nullable Bundle bundle) {
        if (bundle != null) {
            Brandspace brandspace = (Brandspace) bundle.getParcelable(ScreenPublicConstsKt.CONTENT_TYPE_BRANDSPACE);
            if (brandspace != null) {
                this.g = new LoadingState.Loaded(brandspace);
            }
            BrandspaceAnalyticsInteractor.State state = (BrandspaceAnalyticsInteractor.State) bundle.getParcelable("analytics_state");
            if (state != null) {
                BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor = this.m;
                Intrinsics.checkNotNullExpressionValue(state, "stateId");
                brandspaceAnalyticsInteractor.restoreState(state);
            }
            BrandspaceAdverts brandspaceAdverts = (BrandspaceAdverts) bundle.getParcelable("filtered_adverts");
            if (brandspaceAdverts != null) {
                this.h = new LoadingState.Loaded(brandspaceAdverts);
            }
            Serializable serializable = bundle.getSerializable("brandspace_last_block_item_ids");
            if (serializable != null) {
                this.k.setLastBlockItemIds((HashSet) serializable);
            }
            this.m.scheduleVisitTrackIfNeeded();
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("brandspace_items");
            List<? extends BrandspaceItem> list = parcelableArrayList != null ? CollectionsKt___CollectionsKt.toList(parcelableArrayList) : null;
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            i(list);
        }
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    public void onRetryClicked() {
        c();
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    @NotNull
    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        LoadingState<? super Brandspace> loadingState = this.g;
        BrandspaceAdverts brandspaceAdverts = null;
        bundle.putParcelable(ScreenPublicConstsKt.CONTENT_TYPE_BRANDSPACE, loadingState != null ? (Brandspace) LoadingStateKt.dataOrNull(loadingState) : null);
        LoadingState<? super BrandspaceAdverts> loadingState2 = this.h;
        if (loadingState2 != null) {
            brandspaceAdverts = (BrandspaceAdverts) LoadingStateKt.dataOrNull(loadingState2);
        }
        bundle.putParcelable("filtered_adverts", brandspaceAdverts);
        bundle.putParcelableArrayList("brandspace_items", Collections.asArrayList(this.i));
        bundle.putSerializable("brandspace_last_block_item_ids", this.k.getLastBlockItemIds());
        bundle.putParcelable("analytics_state", this.m.saveState());
        return bundle;
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    public void onTabCategoriesClicked(int i2, @NotNull MarketplaceTabsItem marketplaceTabsItem) {
        Intrinsics.checkNotNullParameter(marketplaceTabsItem, "item");
        marketplaceTabsItem.setSelectedTab((String) CollectionsKt___CollectionsKt.toList(marketplaceTabsItem.getTabs().keySet()).get(i2));
        List<BrandspaceItem> unpackItems = marketplaceTabsItem.getUnpackItems();
        ArrayList<CarouselItem> arrayList = new ArrayList();
        for (T t : unpackItems) {
            if (t instanceof CarouselItem) {
                arrayList.add(t);
            }
        }
        for (CarouselItem carouselItem : arrayList) {
            carouselItem.setCurrentPosition(0);
        }
        this.m.trackBlockClick(marketplaceTabsItem, null, false);
        BrandspaceView brandspaceView = this.b;
        if (brandspaceView != null) {
            brandspaceView.showItemsWithPostRefresh(b());
        }
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    public void onUpClicked() {
        BrandspaceRouter brandspaceRouter = this.a;
        if (brandspaceRouter != null) {
            brandspaceRouter.closeScreen();
        }
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    public void onViewCreated(@NotNull BrandspaceView brandspaceView) {
        Intrinsics.checkNotNullParameter(brandspaceView, "view");
        this.b = brandspaceView;
        this.j = brandspaceView.getItemVisibilityTracker();
        this.o.attachView(brandspaceView);
        List<BrandspaceItem> list = this.i;
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t instanceof CarouselItem) {
                arrayList.add(t);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            h(0, (CarouselItem) it.next());
        }
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    public void onViewDestroyed() {
        this.o.detachViews();
        this.b = null;
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    public void onViewPaused() {
        this.m.stopVisitTrackIfNeeded();
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    public void onViewResumed() {
        this.m.scheduleVisitTrackIfNeeded();
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    public void onViewStarted(@NotNull BrandspaceRouter brandspaceRouter) {
        Intrinsics.checkNotNullParameter(brandspaceRouter, "router");
        this.a = brandspaceRouter;
        this.n.restart();
        d();
        c();
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    public void onViewStopped() {
        this.a = null;
        this.n.stop();
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = null;
        Disposable disposable2 = this.d;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.d = null;
        Disposable disposable3 = this.e;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        this.e = null;
        this.f.clear();
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    public void openDeeplink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        BrandspaceRouter brandspaceRouter = this.a;
        if (brandspaceRouter != null) {
            brandspaceRouter.followDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.brandspace.presenter.BrandspacePresenter
    public void openVideoUrl(@Nullable String str, @Nullable String str2) {
        Brandspace brandspace;
        BrandspaceRouter brandspaceRouter;
        LoadingState<? super Brandspace> loadingState = this.g;
        if (loadingState != null && (brandspace = (Brandspace) LoadingStateKt.dataOrNull(loadingState)) != null && str != null && (brandspaceRouter = this.a) != null) {
            brandspaceRouter.openMedia(str, brandspace.getId(), str2, this.m.getParent(), ScreenSource.BRANDSPACE.INSTANCE);
        }
    }
}
