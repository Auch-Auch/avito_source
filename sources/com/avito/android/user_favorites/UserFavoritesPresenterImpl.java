package com.avito.android.user_favorites;

import a2.g.r.g;
import com.avito.android.ab_tests.groups.ViewedItemsTabTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.SearchSubscriptionsOpenEvent;
import com.avito.android.analytics.event.favorite.DisplayFavoriteAdvertisementsEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.user_favorites.adapter.FavoritesTab;
import com.avito.android.user_favorites.di.StartTab;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010#\u001a\u00020 \u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010'\u001a\u00020$\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+\u0012\b\b\u0001\u00100\u001a\u00020\t\u0012\b\u00101\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b2\u00103J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\fR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00064"}, d2 = {"Lcom/avito/android/user_favorites/UserFavoritesPresenterImpl;", "Lcom/avito/android/user_favorites/UserFavoritesPresenter;", "Lcom/avito/android/user_favorites/UserFavoritesView;", "view", "", "attachView", "(Lcom/avito/android/user_favorites/UserFavoritesView;)V", "onResume", "()V", "", VKApiConst.POSITION, "changeTab", "(I)V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_favorites/UserFavoritesInteractor;", "d", "Lcom/avito/android/user_favorites/UserFavoritesInteractor;", "interactor", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/user_favorites/adapter/FavoritesTab;", "f", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabsDataProvider", "Lcom/avito/android/user_favorites/UserFavoritesView;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/analytics/Analytics;", g.a, "Lcom/avito/android/analytics/Analytics;", "analytics", "c", "I", "selectedTab", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/ViewedItemsTabTestGroup;", "h", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "viewedItemsTabTestGroup", "startTab", "state", "<init>", "(Lcom/avito/android/user_favorites/UserFavoritesInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;ILcom/avito/android/util/Kundle;)V", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
public final class UserFavoritesPresenterImpl implements UserFavoritesPresenter {
    public UserFavoritesView a;
    public final CompositeDisposable b = new CompositeDisposable();
    public int c;
    public final UserFavoritesInteractor d;
    public final SchedulersFactory3 e;
    public final TabsDataProvider<FavoritesTab> f;
    public final Analytics g;
    public final SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> h;

    public static final class a<T> implements Consumer<List<? extends FavoritesTab>> {
        public final /* synthetic */ UserFavoritesPresenterImpl a;
        public final /* synthetic */ UserFavoritesView b;

        public a(UserFavoritesPresenterImpl userFavoritesPresenterImpl, UserFavoritesView userFavoritesView) {
            this.a = userFavoritesPresenterImpl;
            this.b = userFavoritesView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.ui.adapter.tab.TabsDataProvider */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends FavoritesTab> list) {
            List<? extends FavoritesTab> list2 = list;
            TabsDataProvider tabsDataProvider = this.a.f;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            tabsDataProvider.updateItems(list2);
            this.b.notifyTabCountersChanged();
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class c<T> implements Consumer<Integer> {
        public final /* synthetic */ UserFavoritesPresenterImpl a;

        public c(UserFavoritesPresenterImpl userFavoritesPresenterImpl) {
            this.a = userFavoritesPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            int i = this.a.c;
            if (num2 == null || num2.intValue() != i) {
                UserFavoritesPresenterImpl userFavoritesPresenterImpl = this.a;
                Intrinsics.checkNotNullExpressionValue(num2, VKApiConst.POSITION);
                userFavoritesPresenterImpl.a(num2.intValue());
            }
            UserFavoritesPresenterImpl userFavoritesPresenterImpl2 = this.a;
            Intrinsics.checkNotNullExpressionValue(num2, VKApiConst.POSITION);
            userFavoritesPresenterImpl2.c = num2.intValue();
        }
    }

    @Inject
    public UserFavoritesPresenterImpl(@NotNull UserFavoritesInteractor userFavoritesInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TabsDataProvider<FavoritesTab> tabsDataProvider, @NotNull Analytics analytics, @NotNull SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> singleManuallyExposedAbTestGroup, @StartTab int i, @Nullable Kundle kundle) {
        Integer num;
        Intrinsics.checkNotNullParameter(userFavoritesInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabsDataProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "viewedItemsTabTestGroup");
        this.d = userFavoritesInteractor;
        this.e = schedulersFactory3;
        this.f = tabsDataProvider;
        this.g = analytics;
        this.h = singleManuallyExposedAbTestGroup;
        if (!(kundle == null || (num = kundle.getInt("selected_tab")) == null)) {
            i = num.intValue();
        }
        this.c = i;
    }

    public final void a(int i) {
        if (i == 0) {
            this.g.track(new DisplayFavoriteAdvertisementsEvent());
        } else if (i == 1) {
            this.g.track(new SearchSubscriptionsOpenEvent());
        }
    }

    @Override // com.avito.android.user_favorites.UserFavoritesPresenter
    public void attachView(@NotNull UserFavoritesView userFavoritesView) {
        Intrinsics.checkNotNullParameter(userFavoritesView, "view");
        this.a = userFavoritesView;
        this.f.updateItems(this.d.getTabs());
        userFavoritesView.notifyTabsChanged();
        CompositeDisposable compositeDisposable = this.b;
        Disposable subscribe = this.d.tabsChanges().observeOn(this.e.mainThread()).subscribe(new a(this, userFavoritesView), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.tabsChanges()….error(it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.b;
        Disposable subscribe2 = userFavoritesView.pageChanges().subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.pageChanges()\n     … = position\n            }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        userFavoritesView.setTabPosition(this.c);
    }

    @Override // com.avito.android.user_favorites.UserFavoritesPresenter
    public void changeTab(int i) {
        UserFavoritesView userFavoritesView;
        if (i >= 0 && (userFavoritesView = this.a) != null) {
            userFavoritesView.setTabPosition(i);
        }
    }

    @Override // com.avito.android.user_favorites.UserFavoritesPresenter
    public void detachView() {
        this.b.clear();
        this.a = null;
    }

    @Override // com.avito.android.user_favorites.UserFavoritesPresenter
    public void onResume() {
        a(this.c);
        this.h.exposeIfNeeded();
    }

    @Override // com.avito.android.user_favorites.UserFavoritesPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putInt("selected_tab", Integer.valueOf(this.c));
    }
}
