package com.avito.android.auto_catalog;

import a2.a.a.m.c;
import a2.a.a.m.d;
import a2.a.a.m.e;
import a2.g.r.g;
import android.os.Bundle;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.analytics.provider.clickstream.ScreenIdField;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.auto_catalog.AutoCatalogPresenter;
import com.avito.android.auto_catalog.analytics.AutoCatalogAnalyticsInteractor;
import com.avito.android.auto_catalog.analytics.events.AutoCatalogShowEvent;
import com.avito.android.auto_catalog.items.AutoCatalogResourceProvider;
import com.avito.android.auto_catalog.items.image.SchemeItem;
import com.avito.android.auto_catalog.items.skeleton.SkeletonItem;
import com.avito.android.auto_catalog.items.specs_selector.SpecsSelectorItem;
import com.avito.android.auto_catalog.remote.model.Additional;
import com.avito.android.auto_catalog.remote.model.AutoCatalogResponse;
import com.avito.android.auto_catalog.remote.model.AutoModifications;
import com.avito.android.auto_catalog.remote.model.ModificationItem;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.ItemsSearchLink;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ModelSpecifications;
import com.avito.android.remote.model.NameIdEntity;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.PersistableSpannedItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.util.Bundles;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.BackpressureStrategy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010p\u001a\u00020m\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010b\u001a\u00020_\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010T\u001a\u00020Q¢\u0006\u0004\bq\u0010rJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\bJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J)\u0010*\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0018H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0004H\u0002¢\u0006\u0004\b3\u0010\bJ-\u00109\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u001c2\f\u00108\u001a\b\u0012\u0004\u0012\u00020706H\u0002¢\u0006\u0004\b9\u0010:J#\u0010?\u001a\u0004\u0018\u00010>2\b\u0010<\u001a\u0004\u0018\u00010;2\u0006\u0010=\u001a\u00020&H\u0002¢\u0006\u0004\b?\u0010@J#\u0010A\u001a\u0004\u0018\u00010>2\b\u0010<\u001a\u0004\u0018\u00010;2\u0006\u0010=\u001a\u00020&H\u0002¢\u0006\u0004\bA\u0010@J\u0019\u0010B\u001a\u00020&2\b\u0010<\u001a\u0004\u0018\u00010;H\u0002¢\u0006\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010HR\u0016\u0010K\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010PR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010VR\u0016\u0010X\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010JR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u001c\u00108\u001a\b\u0012\u0004\u0012\u000207068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR*\u0010h\u001a\u0016\u0012\u0004\u0012\u00020d\u0012\n\u0012\b\u0012\u0004\u0012\u00020e06\u0018\u00010c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010o¨\u0006s"}, d2 = {"Lcom/avito/android/auto_catalog/AutoCatalogPresenterImpl;", "Lcom/avito/android/auto_catalog/AutoCatalogPresenter;", "Lcom/avito/android/auto_catalog/AutoCatalogRouter;", "router", "", "attachRouter", "(Lcom/avito/android/auto_catalog/AutoCatalogRouter;)V", "detachRouter", "()V", "Lcom/avito/android/auto_catalog/AutoCatalogView;", "view", "attachView", "(Lcom/avito/android/auto_catalog/AutoCatalogView;)V", "detachView", "onStart", "onStop", "onRetry", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "state", "restoreState", "(Landroid/os/Bundle;)V", "onAppend", "", "canAppend", "()Z", "onSelectSpecsClick", "", "id", "onSelectSpecsResult", "(Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onAdditionalActionClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/serp/adapter/AdvertItem;", "advert", "", VKApiConst.POSITION, "Lcom/avito/android/remote/model/Image;", "image", "onAdvertClicked", "(Lcom/avito/android/serp/adapter/AdvertItem;ILcom/avito/android/remote/model/Image;)V", "Lcom/avito/android/serp/adapter/FavorableItem;", "favorableItem", "onFavoriteButtonClicked", "(Lcom/avito/android/serp/adapter/FavorableItem;)V", "isZeroSerp", "onSerpButtonClick", "(Z)V", "startLoadingData", "shareTitle", "shareUrl", "", "Lcom/avito/android/serp/adapter/PersistableSpannedItem;", "items", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Lcom/avito/android/auto_catalog/remote/model/AutoModifications;", "modifications", "modificationId", "Lcom/avito/android/auto_catalog/remote/model/ModificationItem;", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/auto_catalog/remote/model/AutoModifications;I)Lcom/avito/android/auto_catalog/remote/model/ModificationItem;", "c", AuthSource.SEND_ABUSE, "(Lcom/avito/android/auto_catalog/remote/model/AutoModifications;)I", "Lcom/avito/android/auto_catalog/analytics/AutoCatalogAnalyticsInteractor;", "k", "Lcom/avito/android/auto_catalog/analytics/AutoCatalogAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/auto_catalog/AutoCatalogRouter;", "h", "I", "prevColumns", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/auto_catalog/AutoCatalogView;", "Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProvider;", "n", "Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProvider;", "resourceProvider", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "commonDisposables", "spanCount", "Lcom/avito/android/auto_catalog/remote/model/AutoCatalogResponse;", "f", "Lcom/avito/android/auto_catalog/remote/model/AutoCatalogResponse;", "autoCatalogResponse", "e", "Ljava/util/List;", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "l", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "Lkotlin/Pair;", "", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", g.a, "Lkotlin/Pair;", "serpItems", "Lcom/avito/android/auto_catalog/analytics/events/AutoCatalogShowEvent$FromPage;", "i", "Lcom/avito/android/auto_catalog/analytics/events/AutoCatalogShowEvent$FromPage;", "fromPageAfterReturn", "Lcom/avito/android/auto_catalog/AutoCatalogInteractor;", "j", "Lcom/avito/android/auto_catalog/AutoCatalogInteractor;", "interactor", "<init>", "(Lcom/avito/android/auto_catalog/AutoCatalogInteractor;Lcom/avito/android/auto_catalog/analytics/AutoCatalogAnalyticsInteractor;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/auto_catalog/items/AutoCatalogResourceProvider;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class AutoCatalogPresenterImpl implements AutoCatalogPresenter {
    public final int a;
    public AutoCatalogView b;
    public AutoCatalogRouter c;
    public final CompositeDisposable d = new CompositeDisposable();
    public List<? extends PersistableSpannedItem> e = CollectionsKt__CollectionsKt.emptyList();
    public AutoCatalogResponse f;
    public Pair<Long, ? extends List<? extends PersistableSerpItem>> g;
    public int h;
    public AutoCatalogShowEvent.FromPage i;
    public final AutoCatalogInteractor j;
    public final AutoCatalogAnalyticsInteractor k;
    public final FavoriteAdvertsPresenter l;
    public final SchedulersFactory m;
    public final AutoCatalogResourceProvider n;

    public static final class a<T> implements Consumer<LoadingState<? super AutoCatalogResponse>> {
        public final /* synthetic */ AutoCatalogPresenterImpl a;

        public a(AutoCatalogPresenterImpl autoCatalogPresenterImpl) {
            this.a = autoCatalogPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super AutoCatalogResponse> loadingState) {
            AutoCatalogView autoCatalogView;
            LoadingState<? super AutoCatalogResponse> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                this.a.f = (AutoCatalogResponse) loaded.getData();
                AutoCatalogAnalyticsInteractor.DefaultImpls.sendShowAutoCatalog$default(this.a.k, null, 1, null);
                AutoCatalogPresenterImpl.access$startSerpRequestIfNeeded(this.a);
                AutoCatalogPresenterImpl autoCatalogPresenterImpl = this.a;
                autoCatalogPresenterImpl.e = AutoCatalogPresenterImpl.access$prepareContentScreen(autoCatalogPresenterImpl, (AutoCatalogResponse) loaded.getData());
                AutoCatalogPresenterImpl autoCatalogPresenterImpl2 = this.a;
                String title = ((AutoCatalogResponse) loaded.getData()).getTitle();
                String str = "";
                if (title == null) {
                    title = str;
                }
                String share = ((AutoCatalogResponse) loaded.getData()).getShare();
                if (share != null) {
                    str = share;
                }
                autoCatalogPresenterImpl2.d(title, str, this.a.e);
            } else if ((loadingState2 instanceof LoadingState.Error) && (autoCatalogView = this.a.b) != null) {
                autoCatalogView.showError();
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    @Inject
    public AutoCatalogPresenterImpl(@NotNull AutoCatalogInteractor autoCatalogInteractor, @NotNull AutoCatalogAnalyticsInteractor autoCatalogAnalyticsInteractor, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull SchedulersFactory schedulersFactory, @NotNull AutoCatalogResourceProvider autoCatalogResourceProvider) {
        Intrinsics.checkNotNullParameter(autoCatalogInteractor, "interactor");
        Intrinsics.checkNotNullParameter(autoCatalogAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(autoCatalogResourceProvider, "resourceProvider");
        this.j = autoCatalogInteractor;
        this.k = autoCatalogAnalyticsInteractor;
        this.l = favoriteAdvertsPresenter;
        this.m = schedulersFactory;
        this.n = autoCatalogResourceProvider;
        this.a = autoCatalogResourceProvider.spanCount();
    }

    public static final void access$onShareClicked(AutoCatalogPresenterImpl autoCatalogPresenterImpl, String str, String str2) {
        autoCatalogPresenterImpl.k.sendShareEvent();
        AutoCatalogRouter autoCatalogRouter = autoCatalogPresenterImpl.c;
        if (autoCatalogRouter != null) {
            autoCatalogRouter.openNativeShareDialog(str2, str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List access$prepareContentScreen(com.avito.android.auto_catalog.AutoCatalogPresenterImpl r24, com.avito.android.auto_catalog.remote.model.AutoCatalogResponse r25) {
        /*
        // Method dump skipped, instructions count: 576
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.auto_catalog.AutoCatalogPresenterImpl.access$prepareContentScreen(com.avito.android.auto_catalog.AutoCatalogPresenterImpl, com.avito.android.auto_catalog.remote.model.AutoCatalogResponse):java.util.List");
    }

    public static final void access$startSerpRequestIfNeeded(AutoCatalogPresenterImpl autoCatalogPresenterImpl) {
        Additional additional;
        AutoCatalogResponse autoCatalogResponse = autoCatalogPresenterImpl.f;
        ItemsSearchLink itemsSearchLink = null;
        DeepLink searchLink = (autoCatalogResponse == null || (additional = autoCatalogResponse.getAdditional()) == null) ? null : additional.getSearchLink();
        if (searchLink instanceof ItemsSearchLink) {
            itemsSearchLink = searchLink;
        }
        ItemsSearchLink itemsSearchLink2 = itemsSearchLink;
        if (autoCatalogPresenterImpl.g == null && itemsSearchLink2 != null) {
            CompositeDisposable compositeDisposable = autoCatalogPresenterImpl.d;
            Disposable subscribe = autoCatalogPresenterImpl.j.getSerpItems(1, null, null, Boolean.FALSE, itemsSearchLink2.getSearchParams()).observeOn(autoCatalogPresenterImpl.m.mainThread()).subscribe(new a2.a.a.m.a(autoCatalogPresenterImpl), a2.a.a.m.b.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getSerpItems(…or(it)\n                })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final int a(AutoModifications autoModifications) {
        List<ModificationItem> items;
        if (autoModifications == null || (items = autoModifications.getItems()) == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : items) {
            if (t.getSpecification() != null) {
                arrayList.add(t);
            }
        }
        return arrayList.size();
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogPresenter
    public void attachRouter(@Nullable AutoCatalogRouter autoCatalogRouter) {
        this.c = autoCatalogRouter;
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogPresenter
    public void attachView(@NotNull AutoCatalogView autoCatalogView) {
        Intrinsics.checkNotNullParameter(autoCatalogView, "view");
        this.b = autoCatalogView;
        if (autoCatalogView != null) {
            CompositeDisposable compositeDisposable = this.d;
            Disposable subscribe = autoCatalogView.upButtonClicks().observeOn(this.m.mainThread()).subscribe(new d(this), e.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "view.upButtonClicks()\n  …   }, { Logs.error(it) })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final ModificationItem b(AutoModifications autoModifications, int i2) {
        List<ModificationItem> items;
        boolean z;
        T t = null;
        if (autoModifications == null || (items = autoModifications.getItems()) == null) {
            return null;
        }
        Iterator<T> it = items.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            T t2 = next;
            if (t2.getId() != i2 || t2.getSpecification() == null) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        return t;
    }

    public final ModificationItem c(AutoModifications autoModifications, int i2) {
        List<ModificationItem> items;
        boolean z;
        ModificationItem b2 = b(autoModifications, i2);
        T t = null;
        if (b2 != null) {
            return b2;
        }
        if (autoModifications == null || (items = autoModifications.getItems()) == null) {
            return null;
        }
        Iterator<T> it = items.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (next.getSpecification() != null) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        return t;
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public boolean canAppend() {
        return false;
    }

    public final void d(String str, String str2, List<? extends PersistableSpannedItem> list) {
        AutoCatalogView autoCatalogView = this.b;
        if (autoCatalogView != null) {
            boolean z = true;
            autoCatalogView.setupToolbar(str2.length() > 0);
            if (str2.length() <= 0) {
                z = false;
            }
            if (z) {
                CompositeDisposable compositeDisposable = this.d;
                Disposable subscribe = autoCatalogView.shareButtonClicks().toFlowable(BackpressureStrategy.DROP).subscribe(new c(this, str, str2));
                Intrinsics.checkNotNullExpressionValue(subscribe, "shareButtonClicks()\n    …title, url)\n            }");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            }
            autoCatalogView.bindItems(list);
        }
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogPresenter
    public void detachRouter() {
        this.c = null;
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogPresenter
    public void detachView() {
        this.b = null;
        this.d.clear();
    }

    @Override // com.avito.android.serp.adapter.GroupingListener
    public void onAdditionalActionClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
    }

    @Override // com.avito.android.serp.adapter.AdvertItemListener
    public void onAdvertClicked(@NotNull AdvertItem advertItem, int i2, @Nullable Image image) {
        Intrinsics.checkNotNullParameter(advertItem, "advert");
        DeepLink deepLink = advertItem.getDeepLink();
        if (deepLink instanceof AdvertDetailsLink) {
            AutoCatalogRouter autoCatalogRouter = this.c;
            if (autoCatalogRouter != null) {
                AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink;
                autoCatalogRouter.openFastAdvertDetails(advertDetailsLink.getItemId(), advertDetailsLink.getContext(), advertItem.getTitle(), advertItem.getPrice(), advertItem.getPreviousPrice(), image, new TreeClickStreamParent(0, ScreenIdField.AUTO_CATALOG.getId(), null, null), advertItem.isMarketplace());
                return;
            }
            return;
        }
        AutoCatalogRouter autoCatalogRouter2 = this.c;
        if (autoCatalogRouter2 != null) {
            autoCatalogRouter2.followDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public void onAppend() {
    }

    @Override // com.avito.android.favorite.FavoriteButtonClickListener
    public void onFavoriteButtonClicked(@NotNull FavorableItem favorableItem) {
        Intrinsics.checkNotNullParameter(favorableItem, "favorableItem");
        this.l.onFavoriteButtonClicked(favorableItem);
    }

    @Override // com.avito.android.advert.actions.MoreActionsClickListener
    public void onMoreActionsClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        AutoCatalogPresenter.DefaultImpls.onMoreActionsClicked(this, str);
    }

    @Override // com.avito.android.advert_core.RetryListener
    public void onRetry() {
        startLoadingData();
    }

    @Override // com.avito.android.auto_catalog.items.specs_selector.SpecsSelectorListener
    public void onSelectSpecsClick() {
        List<? extends ParcelableEntity<String>> list;
        T t;
        List<? extends ParcelableEntity<String>> list2;
        AutoCatalogRouter autoCatalogRouter;
        AutoModifications modifications;
        List<ModificationItem> items;
        AutoCatalogResponse autoCatalogResponse = this.f;
        String str = "";
        ModificationItem modificationItem = null;
        if (autoCatalogResponse == null || (modifications = autoCatalogResponse.getModifications()) == null || (items = modifications.getItems()) == null) {
            list = null;
        } else {
            ArrayList<ModificationItem> arrayList = new ArrayList();
            for (T t2 : items) {
                if (t2.getSpecification() != null) {
                    arrayList.add(t2);
                }
            }
            list = new ArrayList<>(t6.n.e.collectionSizeOrDefault(arrayList, 10));
            for (ModificationItem modificationItem2 : arrayList) {
                String valueOf = String.valueOf(modificationItem2.getId());
                String title = modificationItem2.getTitle();
                if (title == null) {
                    title = str;
                }
                list.add(new NameIdEntity(valueOf, title));
            }
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterator<T> it = this.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t instanceof SpecsSelectorItem) {
                break;
            }
        }
        T t3 = t;
        if (t3 != null) {
            modificationItem = t3.getModification();
        }
        if (modificationItem != null) {
            String valueOf2 = String.valueOf(modificationItem.getId());
            String title2 = modificationItem.getTitle();
            if (title2 != null) {
                str = title2;
            }
            list2 = t6.n.d.listOf(new NameIdEntity(valueOf2, str));
        } else {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        if ((true ^ list.isEmpty()) && (autoCatalogRouter = this.c) != null) {
            autoCatalogRouter.openSelectScreen(String.valueOf(2), this.n.selectModificationText(), list2, list);
        }
    }

    @Override // com.avito.android.auto_catalog.items.specs_selector.SpecsSelectorListener
    public void onSelectSpecsResult(@NotNull String str) {
        ModelSpecifications specification;
        Intrinsics.checkNotNullParameter(str, "id");
        try {
            int parseInt = Integer.parseInt(str);
            AutoCatalogResponse autoCatalogResponse = this.f;
            ModificationItem b2 = b(autoCatalogResponse != null ? autoCatalogResponse.getModifications() : null, parseInt);
            List<? extends PersistableSpannedItem> list = this.e;
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                if (t instanceof SpecsSelectorItem) {
                    T t2 = t;
                    String title = b2 != null ? b2.getTitle() : null;
                    if (title == null) {
                        title = "";
                    }
                    AutoCatalogResponse autoCatalogResponse2 = this.f;
                    t = t2.copyWithModification(title, parseInt, b2, AutoCatalogPresenterKt.access$isGreaterThanOne(a(autoCatalogResponse2 != null ? autoCatalogResponse2.getModifications() : null)));
                } else if (t instanceof SchemeItem) {
                    t = t.copyWithScheme((b2 == null || (specification = b2.getSpecification()) == null) ? null : specification.getScheme());
                }
                arrayList.add(t);
            }
            this.e = arrayList;
            AutoCatalogView autoCatalogView = this.b;
            if (autoCatalogView != null) {
                autoCatalogView.bindItems(arrayList);
            }
            this.i = AutoCatalogShowEvent.FromPage.AUTO_CARD;
        } catch (NumberFormatException e2) {
            Logs.error(e2);
        }
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogPresenter
    public void onSerpButtonClick(boolean z) {
        Additional additional;
        Additional additional2;
        AutoCatalogRouter autoCatalogRouter = this.c;
        if (autoCatalogRouter != null) {
            DeepLink deepLink = null;
            if (z) {
                AutoCatalogResponse autoCatalogResponse = this.f;
                if (!(autoCatalogResponse == null || (additional2 = autoCatalogResponse.getAdditional()) == null)) {
                    deepLink = additional2.getFallbackSearchLink();
                }
            } else {
                AutoCatalogResponse autoCatalogResponse2 = this.f;
                if (!(autoCatalogResponse2 == null || (additional = autoCatalogResponse2.getAdditional()) == null)) {
                    deepLink = additional.getSearchLink();
                }
            }
            if (deepLink == null) {
                deepLink = new ItemsSearchLink(new SearchParams(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null), null, false, null, null, null, null, ScreenIdField.AUTO_CATALOG.getId(), false, null, null, false, 3840, null);
            }
            autoCatalogRouter.followDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogPresenter
    public void onStart() {
        startLoadingData();
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogPresenter
    public void onStop() {
        this.d.clear();
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogPresenter
    public void restoreState(@Nullable Bundle bundle) {
        List parcelableList;
        List<? extends PersistableSpannedItem> parcelableList2;
        this.f = bundle != null ? (AutoCatalogResponse) bundle.getParcelable("developmentsCatalog") : null;
        if (!(bundle == null || (parcelableList2 = Bundles.getParcelableList(bundle, "developmentsCatalogItems")) == null)) {
            this.e = parcelableList2;
        }
        if (bundle != null) {
            this.h = bundle.getInt("prevColumns", 0);
        }
        if (!(bundle == null || (parcelableList = Bundles.getParcelableList(bundle, "serpItems")) == null)) {
            this.g = new Pair<>(0L, parcelableList);
        }
        if (bundle != null) {
            long j2 = bundle.getLong("serpCount", 0);
            Pair<Long, ? extends List<? extends PersistableSerpItem>> pair = this.g;
            if (pair != null) {
                this.g = Pair.copy$default(pair, Long.valueOf(j2), null, 2, null);
            }
        }
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogPresenter
    @NotNull
    public Bundle saveState() {
        Long first;
        Bundle bundle = new Bundle();
        bundle.putParcelable("developmentsCatalog", this.f);
        Bundles.putParcelableList(bundle, "developmentsCatalogItems", this.e);
        bundle.putInt("prevColumns", this.h);
        Pair<Long, ? extends List<? extends PersistableSerpItem>> pair = this.g;
        bundle.putLong("serpCount", (pair == null || (first = pair.getFirst()) == null) ? 0 : first.longValue());
        Pair<Long, ? extends List<? extends PersistableSerpItem>> pair2 = this.g;
        Bundles.putParcelableList(bundle, "serpItems", pair2 != null ? (List) pair2.getSecond() : null);
        return bundle;
    }

    public final void startLoadingData() {
        if (this.f != null) {
            if (this.h != this.a) {
                ArrayList arrayList = new ArrayList();
                for (T t : this.e) {
                    if (!(t instanceof BlockItem) || !(t instanceof ViewTypeSerpItem) || t.getViewType() != SerpViewType.SINGLE) {
                        arrayList.add(t);
                    } else {
                        arrayList.add(t.copyWithSpanCount(this.a));
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.e = arrayList;
                }
                this.h = this.a;
            }
            this.k.sendShowAutoCatalog(this.i);
            this.i = null;
            AutoCatalogResponse autoCatalogResponse = this.f;
            if (autoCatalogResponse != null) {
                String title = autoCatalogResponse.getTitle();
                String str = "";
                if (title == null) {
                    title = str;
                }
                String share = autoCatalogResponse.getShare();
                if (share != null) {
                    str = share;
                }
                d(title, str, this.e);
                return;
            }
            return;
        }
        this.h = this.a;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new SkeletonItem(null, this.a, null, null, 13, null));
        List<? extends PersistableSpannedItem> list = CollectionsKt___CollectionsKt.toList(arrayList2);
        this.e = list;
        AutoCatalogView autoCatalogView = this.b;
        if (autoCatalogView != null) {
            autoCatalogView.bindItems(list);
        }
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.j.loadAutoCatalog().observeOn(this.m.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadAutoCatal…or(it)\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }
}
