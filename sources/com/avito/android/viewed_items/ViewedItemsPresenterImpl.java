package com.avito.android.viewed_items;

import a2.a.a.t3.d;
import a2.g.r.g;
import android.os.Bundle;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.ScreenIdField;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorite.FavoriteActionSource;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorite.FavoriteModel;
import com.avito.android.favorites.adapter.FavoriteListItem;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItem;
import com.avito.android.preferences.UserFavoritesStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.viewed_items.ViewedItemsPresenter;
import com.avito.android.viewed_items.ViewedItemsView;
import com.avito.android.viewed_items.adapter.LoadingItem;
import com.avito.android.viewed_items.di.ViewedItems;
import com.avito.android.viewed_items.model.ViewedItemsModel;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BK\b\u0007\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010V\u001a\u00020S\u0012\b\b\u0001\u0010f\u001a\u00020c\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010M\u001a\u00020J\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010D\u001a\u00020A¢\u0006\u0004\bg\u0010hJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\bJ\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\bJ'\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b \u0010!J!\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u001f\u0010/\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*2\u0006\u0010.\u001a\u00020\u000fH\u0016¢\u0006\u0004\b/\u00100R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020O0N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010`\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020W8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u0010YR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010e¨\u0006i"}, d2 = {"Lcom/avito/android/viewed_items/ViewedItemsPresenterImpl;", "Lcom/avito/android/viewed_items/ViewedItemsPresenter;", "Lcom/avito/android/viewed_items/ViewedItemsView;", "view", "", "attachView", "(Lcom/avito/android/viewed_items/ViewedItemsView;)V", "onResume", "()V", "detachView", "Lcom/avito/android/viewed_items/ViewedItemsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/viewed_items/ViewedItemsPresenter$Router;)V", "detachRouter", "", "showLoader", "loadNextPage", "loadContent", "(ZZ)V", "onErrorStateRefreshButtonClicked", "onSwipeToRefresh", "", "visibleItemCount", "totalItemCount", "firstVisibleItemPosition", "onScrolled", "(III)V", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "savedInstanceState", "onRestoreState", "(Landroid/os/Bundle;)V", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;", "item", "Lcom/avito/android/remote/model/Image;", "image", "onFavoriteItemClicked", "(Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;Lcom/avito/android/remote/model/Image;)V", "onRemoveItemClicked", "(Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;)V", "", "itemId", "onClickMoreItemActions", "(Ljava/lang/String;)V", "isShop", "onClickSimilar", "(Ljava/lang/String;Z)V", "Lcom/avito/android/viewed_items/ViewedItemsInteractor;", "h", "Lcom/avito/android/viewed_items/ViewedItemsInteractor;", "viewedItemsInteractor", "Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;", "n", "Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;", "eventInteractor", "Lcom/avito/android/preferences/UserFavoritesStorage;", "k", "Lcom/avito/android/preferences/UserFavoritesStorage;", "favoritesStorage", "Lcom/avito/android/util/SchedulersFactory3;", "l", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "o", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "f", "Ljava/lang/String;", "nextPage", "e", "Lcom/avito/android/viewed_items/ViewedItemsPresenter$Router;", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "interactor", "", "Lcom/avito/android/favorites/adapter/FavoriteListItem;", "d", "Ljava/util/List;", "viewedItems", "Lcom/avito/android/viewed_items/ViewedItemsCountInteractor;", "i", "Lcom/avito/android/viewed_items/ViewedItemsCountInteractor;", "viewedItemsCountInteractor", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "loadDisposable", g.a, "Z", "firstLoading", AuthSource.SEND_ABUSE, "Lcom/avito/android/viewed_items/ViewedItemsView;", "viewedItemsView", AuthSource.BOOKING_ORDER, "disposable", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "j", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "<init>", "(Lcom/avito/android/viewed_items/ViewedItemsInteractor;Lcom/avito/android/viewed_items/ViewedItemsCountInteractor;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/preferences/UserFavoritesStorage;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/favorite/FavoriteAdvertsInteractor;Lcom/avito/android/favorite/FavoriteAdvertsEventInteractor;Lcom/avito/android/analytics/provider/TreeStateIdGenerator;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class ViewedItemsPresenterImpl implements ViewedItemsPresenter {
    public ViewedItemsView a;
    public CompositeDisposable b = new CompositeDisposable();
    public CompositeDisposable c = new CompositeDisposable();
    public List<FavoriteListItem> d = new ArrayList();
    public ViewedItemsPresenter.Router e;
    public String f;
    public boolean g = true;
    public final ViewedItemsInteractor h;
    public final ViewedItemsCountInteractor i;
    public final AdapterPresenter j;
    public final UserFavoritesStorage k;
    public final SchedulersFactory3 l;
    public final FavoriteAdvertsInteractor m;
    public final FavoriteAdvertsEventInteractor n;
    public final TreeStateIdGenerator o;

    public static final class a<T, R> implements Function<LoadingState<? super ViewedItemsModel>, LoadingState<? super List<? extends FavoriteAdvertItem>>> {
        public final /* synthetic */ ViewedItemsPresenterImpl a;

        public a(ViewedItemsPresenterImpl viewedItemsPresenterImpl) {
            this.a = viewedItemsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super List<? extends FavoriteAdvertItem>> apply(LoadingState<? super ViewedItemsModel> loadingState) {
            LoadingState<? super ViewedItemsModel> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                this.a.f = ((ViewedItemsModel) loaded.getData()).getNextPage();
                ArrayList arrayList = new ArrayList();
                for (FavoriteModel favoriteModel : ((ViewedItemsModel) loaded.getData()).getItems()) {
                    arrayList.add(FavoriteAdvertItem.Companion.fromFavoriteModel(favoriteModel));
                }
                ViewedItemsPresenterImpl.access$setFavoriteStateToModels(this.a, arrayList);
                return new LoadingState.Loaded(arrayList);
            } else if (loadingState2 instanceof LoadingState.Error) {
                return new LoadingState.Error(((LoadingState.Error) loadingState2).getError());
            } else {
                if (loadingState2 instanceof LoadingState.Loading) {
                    return LoadingState.Loading.INSTANCE;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final class b<T> implements Consumer<LoadingState<? super List<? extends FavoriteAdvertItem>>> {
        public final /* synthetic */ ViewedItemsPresenterImpl a;
        public final /* synthetic */ boolean b;

        public b(ViewedItemsPresenterImpl viewedItemsPresenterImpl, boolean z) {
            this.a = viewedItemsPresenterImpl;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super List<? extends FavoriteAdvertItem>> loadingState) {
            ViewedItemsView viewedItemsView;
            LoadingState<? super List<? extends FavoriteAdvertItem>> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                if (((List) loaded.getData()).size() == 0) {
                    ViewedItemsView viewedItemsView2 = this.a.a;
                    if (viewedItemsView2 != null) {
                        viewedItemsView2.setScreenState(ViewedItemsView.ScreenState.EMPTY);
                        return;
                    }
                    return;
                }
                ViewedItemsPresenterImpl.access$mergeNewItemsToCurrentData(this.a, (List) loaded.getData());
                ViewedItemsPresenterImpl viewedItemsPresenterImpl = this.a;
                List list = viewedItemsPresenterImpl.d;
                ArrayList arrayList = new ArrayList();
                for (T t : list) {
                    if (!(t instanceof LoadingItem)) {
                        arrayList.add(t);
                    }
                }
                viewedItemsPresenterImpl.d = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
                if (this.a.f != null) {
                    this.a.d.add(new LoadingItem());
                }
                this.a.j.onDataSourceChanged(new ListDataSource(this.a.d));
                ViewedItemsView viewedItemsView3 = this.a.a;
                if (viewedItemsView3 != null) {
                    viewedItemsView3.notifyDatasetChanged();
                }
                ViewedItemsView viewedItemsView4 = this.a.a;
                if (viewedItemsView4 != null) {
                    viewedItemsView4.setScreenState(ViewedItemsView.ScreenState.CONTENT);
                }
            } else if (loadingState2 instanceof LoadingState.Error) {
                ViewedItemsView viewedItemsView5 = this.a.a;
                if (viewedItemsView5 != null) {
                    viewedItemsView5.setScreenState(ViewedItemsView.ScreenState.ERROR);
                }
            } else if ((loadingState2 instanceof LoadingState.Loading) && this.b && (viewedItemsView = this.a.a) != null) {
                viewedItemsView.setScreenState(ViewedItemsView.ScreenState.LOADING);
            }
        }
    }

    @Inject
    public ViewedItemsPresenterImpl(@NotNull ViewedItemsInteractor viewedItemsInteractor, @NotNull ViewedItemsCountInteractor viewedItemsCountInteractor, @ViewedItems @NotNull AdapterPresenter adapterPresenter, @NotNull UserFavoritesStorage userFavoritesStorage, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull FavoriteAdvertsInteractor favoriteAdvertsInteractor, @NotNull FavoriteAdvertsEventInteractor favoriteAdvertsEventInteractor, @NotNull TreeStateIdGenerator treeStateIdGenerator) {
        Intrinsics.checkNotNullParameter(viewedItemsInteractor, "viewedItemsInteractor");
        Intrinsics.checkNotNullParameter(viewedItemsCountInteractor, "viewedItemsCountInteractor");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(userFavoritesStorage, "favoritesStorage");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(favoriteAdvertsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(favoriteAdvertsEventInteractor, "eventInteractor");
        Intrinsics.checkNotNullParameter(treeStateIdGenerator, "treeStateIdGenerator");
        this.h = viewedItemsInteractor;
        this.i = viewedItemsCountInteractor;
        this.j = adapterPresenter;
        this.k = userFavoritesStorage;
        this.l = schedulersFactory3;
        this.m = favoriteAdvertsInteractor;
        this.n = favoriteAdvertsEventInteractor;
        this.o = treeStateIdGenerator;
    }

    public static final void access$changeAdvertsFavorite(ViewedItemsPresenterImpl viewedItemsPresenterImpl, List list, boolean z) {
        int i2 = 0;
        for (T t : viewedItemsPresenterImpl.d) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            if ((t2 instanceof FavorableItem) && list.contains(t2.getStringId())) {
                t2.setFavorite(z);
                ViewedItemsView viewedItemsView = viewedItemsPresenterImpl.a;
                if (viewedItemsView != null) {
                    viewedItemsView.notifyItemAtPositionChanged(i2);
                }
            }
            i2 = i3;
        }
    }

    public static final void access$mergeNewItemsToCurrentData(ViewedItemsPresenterImpl viewedItemsPresenterImpl, List list) {
        T t;
        Objects.requireNonNull(viewedItemsPresenterImpl);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            FavoriteAdvertItem favoriteAdvertItem = (FavoriteAdvertItem) it.next();
            Iterator<T> it2 = viewedItemsPresenterImpl.d.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t = null;
                    break;
                }
                t = it2.next();
                if (Intrinsics.areEqual(t.getStringId(), favoriteAdvertItem.getStringId())) {
                    break;
                }
            }
            if (t == null) {
                viewedItemsPresenterImpl.d.add(favoriteAdvertItem);
            }
        }
    }

    public static final List access$setFavoriteStateToModels(ViewedItemsPresenterImpl viewedItemsPresenterImpl, List list) {
        Objects.requireNonNull(viewedItemsPresenterImpl);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((FavoriteAdvertItem) it.next()).getStringId());
        }
        Map<String, Boolean> savedFavoriteStatusesSync = viewedItemsPresenterImpl.m.getSavedFavoriteStatusesSync(arrayList);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            FavoriteAdvertItem favoriteAdvertItem = (FavoriteAdvertItem) it2.next();
            if (savedFavoriteStatusesSync.containsKey(favoriteAdvertItem.getStringId())) {
                Boolean bool = savedFavoriteStatusesSync.get(favoriteAdvertItem.getStringId());
                favoriteAdvertItem.setFavorite(bool != null ? bool.booleanValue() : false);
            }
        }
        return list;
    }

    @Override // com.avito.android.viewed_items.ViewedItemsPresenter
    public void attachRouter(@NotNull ViewedItemsPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.e = router;
    }

    @Override // com.avito.android.viewed_items.ViewedItemsPresenter
    public void attachView(@NotNull ViewedItemsView viewedItemsView) {
        Intrinsics.checkNotNullParameter(viewedItemsView, "view");
        this.a = viewedItemsView;
        this.b.add(this.n.favoritesEvents().observeOn(this.l.mainThread()).subscribe(new d(this)));
    }

    @Override // com.avito.android.viewed_items.ViewedItemsPresenter
    public void detachRouter() {
        this.e = null;
    }

    @Override // com.avito.android.viewed_items.ViewedItemsPresenter
    public void detachView(@NotNull ViewedItemsView viewedItemsView) {
        Intrinsics.checkNotNullParameter(viewedItemsView, "view");
        this.b.clear();
        this.c.clear();
        this.a = null;
    }

    @Override // com.avito.android.viewed_items.ViewedItemsPresenter
    public void loadContent(boolean z, boolean z2) {
        this.c.clear();
        this.c.add(this.h.getViewedItems(z2 ? this.f : null).observeOn(this.l.mainThread()).map(new a(this)).subscribe(new b(this, z)));
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter.Listener
    public void onClickMoreItemActions(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter.Listener
    public void onClickSimilar(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "itemId");
    }

    @Override // com.avito.android.viewed_items.ViewedItemsPresenter
    public void onErrorStateRefreshButtonClicked() {
        this.f = null;
        this.d = new ArrayList();
        loadContent(true, false);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter.Listener
    public void onFavoriteItemClicked(@NotNull FavoriteAdvertItem favoriteAdvertItem, @Nullable Image image) {
        ViewedItemsPresenter.Router router;
        Intrinsics.checkNotNullParameter(favoriteAdvertItem, "item");
        DeepLink deepLink = favoriteAdvertItem.getDeepLink();
        String str = null;
        if (!(deepLink instanceof AdvertDetailsLink)) {
            deepLink = null;
        }
        if (((AdvertDetailsLink) deepLink) != null && (router = this.e) != null) {
            String stringId = favoriteAdvertItem.getStringId();
            DeepLink deepLink2 = favoriteAdvertItem.getDeepLink();
            if (!(deepLink2 instanceof AdvertDetailsLink)) {
                deepLink2 = null;
            }
            AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink2;
            if (advertDetailsLink != null) {
                str = advertDetailsLink.getContext();
            }
            router.openFastAdvertDetails(stringId, str, favoriteAdvertItem.getTitle(), favoriteAdvertItem.getPrice(), favoriteAdvertItem.getPreviousPrice(), image, new TreeClickStreamParent(this.o.nextStateId(), ScreenIdField.FAVORITE_ITEMS.name(), null, null));
        }
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter.Listener
    public void onRemoveItemClicked(@NotNull FavoriteAdvertItem favoriteAdvertItem) {
        Intrinsics.checkNotNullParameter(favoriteAdvertItem, "item");
        String str = null;
        AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) (!(favoriteAdvertItem instanceof AdvertDetailsLink) ? null : favoriteAdvertItem);
        if (advertDetailsLink != null) {
            str = advertDetailsLink.getContext();
        }
        this.m.toggleFavoriteStatus(favoriteAdvertItem.getStringId(), new FavoriteActionSource.Favorites(str), favoriteAdvertItem.isFavorite()).observeOn(this.l.mainThread()).subscribe();
    }

    @Override // com.avito.android.viewed_items.ViewedItemsPresenter
    public void onRestoreState(@Nullable Bundle bundle) {
        this.f = bundle != null ? bundle.getString("next_page_key") : null;
    }

    @Override // com.avito.android.viewed_items.ViewedItemsPresenter
    public void onResume() {
        this.k.setViewedItemsTabWasOpened(true);
        this.i.resetCount();
        if (this.g) {
            loadContent(true, false);
            this.g = false;
            return;
        }
        loadContent(false, false);
    }

    @Override // com.avito.android.viewed_items.ViewedItemsPresenter
    @NotNull
    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        bundle.putString("next_page_key", this.f);
        return bundle;
    }

    @Override // com.avito.android.viewed_items.ViewedItemsPresenter
    public void onScrolled(int i2, int i3, int i4) {
        if ((i2 + i4 >= i3) && this.f != null) {
            loadContent(false, true);
        }
    }

    @Override // com.avito.android.viewed_items.ViewedItemsPresenter
    public void onSwipeToRefresh() {
        this.f = null;
        this.d = new ArrayList();
        loadContent(false, false);
    }
}
