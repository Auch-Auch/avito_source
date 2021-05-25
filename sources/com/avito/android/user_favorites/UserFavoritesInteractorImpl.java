package com.avito.android.user_favorites;

import a2.a.a.k3.c;
import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.ViewedItemsTabTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.common.CounterInteractor;
import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.di.FavoriteSellers;
import com.avito.android.favorites.di.Favorites;
import com.avito.android.preferences.UserFavoritesStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.subscriptions.SearchSubscriptionObservable;
import com.avito.android.user_favorites.adapter.FavoritesTab;
import com.avito.android.user_favorites.adapter.items.ItemsTab;
import com.avito.android.user_favorites.adapter.search.SearchTab;
import com.avito.android.user_favorites.adapter.sellers.SellersTab;
import com.avito.android.user_favorites.adapter.viewed_items.ViewedItemsTab;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Observables;
import com.avito.android.viewed_items.ViewedItemsCountInteractor;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bk\b\u0007\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u00105\u001a\u000202\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010-\u001a\u00020*¢\u0006\u0004\b:\u0010;J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0016¢\u0006\u0004\b\n\u0010\bR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/avito/android/user_favorites/UserFavoritesInteractorImpl;", "Lcom/avito/android/user_favorites/UserFavoritesInteractor;", "", "Lcom/avito/android/user_favorites/adapter/FavoritesTab;", "getTabs", "()Ljava/util/List;", "Lio/reactivex/rxjava3/core/Observable;", "tabsChanges", "()Lio/reactivex/rxjava3/core/Observable;", "", "authorizedChanges", "Lcom/avito/android/common/CounterInteractor;", "f", "Lcom/avito/android/common/CounterInteractor;", "favoriteSellersCounterInteractor", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/ViewedItemsTabTestGroup;", "i", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "viewedItemsTabTestGroup", g.a, "favoritesCounterInteractor", "", AuthSource.SEND_ABUSE, "Ljava/lang/Integer;", "listBottomPaddingPx", "Lcom/avito/android/search/subscriptions/SearchSubscriptionObservable;", "h", "Lcom/avito/android/search/subscriptions/SearchSubscriptionObservable;", "searchSubscriptionObservable", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/user_favorites/UserFavoritesResourceProvider;", "c", "Lcom/avito/android/user_favorites/UserFavoritesResourceProvider;", "resourceProvider", "Lcom/avito/android/preferences/UserFavoritesStorage;", "k", "Lcom/avito/android/preferences/UserFavoritesStorage;", "userFavoritesStorage", "Lcom/avito/android/Features;", "l", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/viewed_items/ViewedItemsCountInteractor;", "j", "Lcom/avito/android/viewed_items/ViewedItemsCountInteractor;", "viewedItemsCountInteractor", "Lcom/avito/android/db/SearchSubscriptionDao;", "e", "Lcom/avito/android/db/SearchSubscriptionDao;", "subscriptionDao", "Lcom/avito/android/account/AccountStorageInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "<init>", "(Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/user_favorites/UserFavoritesResourceProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/db/SearchSubscriptionDao;Lcom/avito/android/common/CounterInteractor;Lcom/avito/android/common/CounterInteractor;Lcom/avito/android/search/subscriptions/SearchSubscriptionObservable;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;Lcom/avito/android/viewed_items/ViewedItemsCountInteractor;Lcom/avito/android/preferences/UserFavoritesStorage;Lcom/avito/android/Features;)V", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
public final class UserFavoritesInteractorImpl implements UserFavoritesInteractor {
    public final Integer a;
    public final AccountStorageInteractor b;
    public final UserFavoritesResourceProvider c;
    public final SchedulersFactory3 d;
    public final SearchSubscriptionDao e;
    public final CounterInteractor f;
    public final CounterInteractor g;
    public final SearchSubscriptionObservable h;
    public final SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> i;
    public final ViewedItemsCountInteractor j;
    public final UserFavoritesStorage k;
    public final Features l;

    public static final class a<T, R> implements Function<Integer, String> {
        public final /* synthetic */ UserFavoritesInteractorImpl a;

        public a(UserFavoritesInteractorImpl userFavoritesInteractorImpl) {
            this.a = userFavoritesInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(Integer num) {
            Integer num2 = num;
            UserFavoritesInteractorImpl userFavoritesInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(num2, "countValueAsInt");
            return UserFavoritesInteractorImpl.access$toCounterString(userFavoritesInteractorImpl, num2.intValue());
        }
    }

    public static final class b extends Lambda implements Function1<List<? extends String>, List<? extends FavoritesTab>> {
        public final /* synthetic */ UserFavoritesInteractorImpl a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ Ref.ObjectRef c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(UserFavoritesInteractorImpl userFavoritesInteractorImpl, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            super(1);
            this.a = userFavoritesInteractorImpl;
            this.b = objectRef;
            this.c = objectRef2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public List<? extends FavoritesTab> invoke(List<? extends String> list) {
            String str;
            String str2;
            List<? extends String> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "countList");
            String str3 = (String) list2.get(0);
            String str4 = (String) list2.get(1);
            T t = this.b.element;
            if (t != null) {
                str = (String) list2.get(t.intValue());
            } else {
                str = "";
            }
            T t2 = this.c.element;
            if (t2 != null) {
                str2 = (String) list2.get(t2.intValue());
            } else {
                str2 = "";
            }
            return UserFavoritesInteractorImpl.a(this.a, str, str3, str4, str2, null, 16);
        }
    }

    @Inject
    public UserFavoritesInteractorImpl(@NotNull AccountStorageInteractor accountStorageInteractor, @NotNull UserFavoritesResourceProvider userFavoritesResourceProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SearchSubscriptionDao searchSubscriptionDao, @FavoriteSellers @NotNull CounterInteractor counterInteractor, @Favorites @NotNull CounterInteractor counterInteractor2, @NotNull SearchSubscriptionObservable searchSubscriptionObservable, @NotNull SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> singleManuallyExposedAbTestGroup, @NotNull ViewedItemsCountInteractor viewedItemsCountInteractor, @NotNull UserFavoritesStorage userFavoritesStorage, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(userFavoritesResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(searchSubscriptionDao, "subscriptionDao");
        Intrinsics.checkNotNullParameter(counterInteractor, "favoriteSellersCounterInteractor");
        Intrinsics.checkNotNullParameter(counterInteractor2, "favoritesCounterInteractor");
        Intrinsics.checkNotNullParameter(searchSubscriptionObservable, "searchSubscriptionObservable");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "viewedItemsTabTestGroup");
        Intrinsics.checkNotNullParameter(viewedItemsCountInteractor, "viewedItemsCountInteractor");
        Intrinsics.checkNotNullParameter(userFavoritesStorage, "userFavoritesStorage");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = accountStorageInteractor;
        this.c = userFavoritesResourceProvider;
        this.d = schedulersFactory3;
        this.e = searchSubscriptionDao;
        this.f = counterInteractor;
        this.g = counterInteractor2;
        this.h = searchSubscriptionObservable;
        this.i = singleManuallyExposedAbTestGroup;
        this.j = viewedItemsCountInteractor;
        this.k = userFavoritesStorage;
        this.l = features;
        this.a = features.getCartFloatingActionButton().invoke().booleanValue() ? Integer.valueOf(userFavoritesResourceProvider.cartFabListBottomPadding()) : null;
    }

    public static List a(UserFavoritesInteractorImpl userFavoritesInteractorImpl, String str, String str2, String str3, String str4, Integer num, int i2) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            str2 = "";
        }
        if ((i2 & 4) != 0) {
            str3 = "";
        }
        if ((i2 & 8) != 0) {
            str4 = "";
        }
        Integer num2 = (i2 & 16) != 0 ? userFavoritesInteractorImpl.a : null;
        Objects.requireNonNull(userFavoritesInteractorImpl);
        ArrayList arrayList = new ArrayList();
        if (userFavoritesInteractorImpl.l.getFavouriteAdvertsCounter().invoke().booleanValue()) {
            arrayList.add(new ItemsTab(userFavoritesInteractorImpl.c.favoriteItems(), str, num2));
        } else {
            arrayList.add(new ItemsTab(userFavoritesInteractorImpl.c.favoriteItems(), null, num2, 2, null));
        }
        arrayList.add(new SearchTab(userFavoritesInteractorImpl.c.searchSubscriptions(), str2, num2));
        if (userFavoritesInteractorImpl.i.getTestGroup().isTest()) {
            arrayList.add(new ViewedItemsTab(userFavoritesInteractorImpl.c.viewedItems(), str4, num2));
        }
        arrayList.add(new SellersTab(userFavoritesInteractorImpl.c.favoriteSellers(), str3, num2));
        return arrayList;
    }

    public static final String access$toCounterString(UserFavoritesInteractorImpl userFavoritesInteractorImpl, int i2) {
        Objects.requireNonNull(userFavoritesInteractorImpl);
        if (i2 <= 0) {
            return "";
        }
        if (i2 >= 100) {
            return "99+";
        }
        return String.valueOf(i2);
    }

    @Override // com.avito.android.user_favorites.UserFavoritesInteractor
    @NotNull
    public Observable<Boolean> authorizedChanges() {
        return this.b.authorized();
    }

    @Override // com.avito.android.user_favorites.UserFavoritesInteractor
    @NotNull
    public List<FavoritesTab> getTabs() {
        return a(this, null, null, null, null, null, 31);
    }

    @Override // com.avito.android.user_favorites.UserFavoritesInteractor
    @NotNull
    public Observable<List<FavoritesTab>> tabsChanges() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = null;
        ArrayList arrayList = new ArrayList();
        Observable<R> map = this.h.observeCounter().map(new a2.a.a.k3.b(this));
        int unreadChangesCount = this.e.getUnreadChangesCount();
        Observable<R> startWith = map.startWith(Observable.just(unreadChangesCount <= 0 ? "" : unreadChangesCount >= 100 ? "99+" : String.valueOf(unreadChangesCount)));
        Intrinsics.checkNotNullExpressionValue(startWith, "searchSubscriptionObserv…Count.toCounterString()))");
        arrayList.add(startWith);
        Observable<R> startWith2 = this.f.changes().map(new c(this)).startWith(Observable.just(""));
        Intrinsics.checkNotNullExpressionValue(startWith2, "favoriteSellersCounterIn…able.just(emptyString()))");
        arrayList.add(startWith2);
        if (this.l.getFavouriteAdvertsCounter().invoke().booleanValue()) {
            Observable<R> startWith3 = this.g.changes().map(new a2.a.a.k3.a(this)).startWith(Observable.just(""));
            Intrinsics.checkNotNullExpressionValue(startWith3, "favoritesCounterInteract…able.just(emptyString()))");
            arrayList.add(startWith3);
            objectRef.element = (T) Integer.valueOf(arrayList.size() - 1);
        }
        if (this.i.getTestGroup().isTest() && !this.k.viewedItemsTabWasOpened()) {
            arrayList.add(this.j.getViewedItemsCount().map(new a(this)));
            objectRef2.element = (T) Integer.valueOf(arrayList.size() - 1);
        }
        return Observables.combineLatest(arrayList, new b(this, objectRef, objectRef2));
    }
}
