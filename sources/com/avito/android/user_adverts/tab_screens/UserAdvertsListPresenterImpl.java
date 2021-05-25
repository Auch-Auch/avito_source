package com.avito.android.user_adverts.tab_screens;

import android.content.Intent;
import android.net.Uri;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.BannerEvent;
import com.avito.android.component.user_advert.UserAdvertItem;
import com.avito.android.deep_linking.DeeplinkClickStreamProvider;
import com.avito.android.floating_views.FloatingViewsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.LinkedInfoBanner;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.serp.adapter.SerpItem;
import com.avito.android.serp.adapter.ShortcutBannerItem;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenter;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertItemAction;
import com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerItem;
import com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerPresenter;
import com.avito.android.user_adverts.tab_screens.advert_list.loading.LoadingElement;
import com.avito.android.user_adverts.tab_screens.advert_list.shortcut_title.ShortcutTitleItem;
import com.avito.android.user_adverts.tab_screens.converters.UserItemConverter;
import com.avito.android.user_adverts.tracker.UserAdvertsListTracker;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0001\b\u0007\u0012\u0006\u0010P\u001a\u00020\u001a\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010r\u001a\u00020o\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010h\u001a\u00020e\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010C\u001a\u00020@\u0012\b\u0010{\u001a\u0004\u0018\u00010\u0013\u0012\u0011\u0010I\u001a\r\u0012\t\u0012\u00070E¢\u0006\u0002\bF0D\u0012\u0006\u0010z\u001a\u00020w\u0012\u0010\u0010n\u001a\f\u0012\u0004\u0012\u00020j0ij\u0002`k\u0012\u0006\u0010M\u001a\u00020J¢\u0006\u0004\b|\u0010}J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b&\u0010%J!\u0010+\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010\u0006J\u0017\u0010/\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b/\u0010\u0006R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR!\u0010I\u001a\r\u0012\t\u0012\u00070E¢\u0006\u0002\bF0D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u001e\u0010b\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010_8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010aR\u0016\u0010d\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010QR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010gR \u0010n\u001a\f\u0012\u0004\u0012\u00020j0ij\u0002`k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010v\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010y¨\u0006~"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenterImpl;", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenter;", "", "updateCounter", "", AuthSource.SEND_ABUSE, "(Z)V", AuthSource.BOOKING_ORDER, "()V", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListView;", "view", "attachView", "(Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListView;)V", "detachView", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "invalidate", "refreshTabs", "onRefresh", "(ZZ)V", "", "bannerId", "closeUserAdvertsBanner", "(Ljava/lang/String;)V", "Lcom/avito/android/component/user_advert/UserAdvertItem;", "advert", "onAdvertClicked", "(Lcom/avito/android/component/user_advert/UserAdvertItem;)V", "Lcom/avito/android/serp/adapter/ShortcutBannerItem;", "item", "onShortcutBannerItemShowed", "(Lcom/avito/android/serp/adapter/ShortcutBannerItem;)V", "onShortcutBannerItemClicked", "", "resultCode", "Landroid/content/Intent;", "data", "onAdvertDetailsResult", "(ILandroid/content/Intent;)V", "animate", "showFloatingViews", "hideFloatingViews", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "k", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsCountUpdater;", "o", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsCountUpdater;", "userAdvertsCountUpdater", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListInteractor;", "i", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListInteractor;", "interactor", "Lcom/avito/android/user_adverts/tab_screens/converters/UserItemConverter;", "l", "Lcom/avito/android/user_adverts/tab_screens/converters/UserItemConverter;", "itemConverter", "Lcom/avito/android/user_adverts/tracker/UserAdvertsListTracker;", "p", "Lcom/avito/android/user_adverts/tracker/UserAdvertsListTracker;", "tracker", "", "Lcom/avito/android/deep_linking/DeeplinkClickStreamProvider;", "Lkotlin/jvm/JvmSuppressWildcards;", VKApiConst.Q, "Ljava/util/Set;", "deeplinkClicksStreamProviders", "Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerPresenter;", "t", "Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerPresenter;", "linkedInfoBannerPresenter", "h", "Ljava/lang/String;", "shortcut", "Z", "hasMorePages", "Lio/reactivex/disposables/CompositeDisposable;", "f", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter;", "n", "Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter;", "userAdvertsHostPresenter", "d", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListView;", "e", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListPresenter$Router;", "", "Lcom/avito/android/remote/model/SerpElement;", "Ljava/util/List;", MessengerShareContentUtility.ELEMENTS, "c", "isAppending", "Lcom/avito/android/floating_views/FloatingViewsPresenter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/floating_views/FloatingViewsPresenter;", "floatingViewsPresenter", "Lio/reactivex/Observable;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemAction;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemActionObservable;", "s", "Lio/reactivex/Observable;", "itemActions", "Lcom/avito/android/util/SchedulersFactory;", "j", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Landroid/net/Uri;", a2.g.r.g.a, "Landroid/net/Uri;", "nextPage", "Lcom/avito/android/analytics/Analytics;", "r", "Lcom/avito/android/analytics/Analytics;", "analytics", "state", "<init>", "(Ljava/lang/String;Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/user_adverts/tab_screens/converters/UserItemConverter;Lcom/avito/android/floating_views/FloatingViewsPresenter;Lcom/avito/android/user_adverts/root_screen/adverts_host/UserAdvertsHostPresenter;Lcom/avito/android/user_adverts/tab_screens/UserAdvertsCountUpdater;Lcom/avito/android/user_adverts/tracker/UserAdvertsListTracker;Lcom/avito/android/util/Kundle;Ljava/util/Set;Lcom/avito/android/analytics/Analytics;Lio/reactivex/Observable;Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerPresenter;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertsListPresenterImpl implements UserAdvertsListPresenter {
    public boolean a;
    public List<? extends SerpElement> b;
    public boolean c;
    public UserAdvertsListView d;
    public UserAdvertsListPresenter.Router e;
    public final CompositeDisposable f;
    public Uri g;
    public final String h;
    public final UserAdvertsListInteractor i;
    public final SchedulersFactory j;
    public final AdapterPresenter k;
    public final UserItemConverter l;
    public final FloatingViewsPresenter m;
    public final UserAdvertsHostPresenter n;
    public final UserAdvertsCountUpdater o;
    public final UserAdvertsListTracker p;
    public final Set<DeeplinkClickStreamProvider> q;
    public final Analytics r;
    public final Observable<UserAdvertItemAction> s;
    public final LinkedInfoBannerPresenter t;

    public static final class a<T> implements Consumer<LinkedInfoBannerItem> {
        public final /* synthetic */ UserAdvertsListPresenterImpl a;

        public a(UserAdvertsListPresenterImpl userAdvertsListPresenterImpl) {
            this.a = userAdvertsListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LinkedInfoBannerItem linkedInfoBannerItem) {
            UserAdvertsListPresenterImpl.access$deleteBannerWithId(this.a, linkedInfoBannerItem.getStringId());
            this.a.b();
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Error in subscription to LinkedInfoBannerPresenter", th);
        }
    }

    public static final class c<T, R> implements Function<Pair<? extends List<? extends SerpElement>, ? extends Uri>, List<? extends SerpElement>> {
        public final /* synthetic */ UserAdvertsListPresenterImpl a;

        public c(UserAdvertsListPresenterImpl userAdvertsListPresenterImpl) {
            this.a = userAdvertsListPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends SerpElement> apply(Pair<? extends List<? extends SerpElement>, ? extends Uri> pair) {
            Pair<? extends List<? extends SerpElement>, ? extends Uri> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "<name for destructuring parameter 0>");
            List<? extends SerpElement> list = (List) pair2.component1();
            Uri uri = (Uri) pair2.component2();
            this.a.g = uri;
            return uri == null ? list : CollectionsKt___CollectionsKt.plus((Collection<? extends LoadingElement>) list, new LoadingElement());
        }
    }

    public static final class d<T> implements Consumer<List<? extends SerpElement>> {
        public final /* synthetic */ UserAdvertsListPresenterImpl a;
        public final /* synthetic */ boolean b;

        public d(UserAdvertsListPresenterImpl userAdvertsListPresenterImpl, boolean z) {
            this.a = userAdvertsListPresenterImpl;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends SerpElement> list) {
            List<? extends SerpElement> list2 = list;
            this.a.p.trackAdvertsLoadingSuccess();
            this.a.p.startDraw();
            UserAdvertsListPresenterImpl userAdvertsListPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            UserAdvertsListPresenterImpl.access$onProfileAdvertsLoaded(userAdvertsListPresenterImpl, list2, this.b);
            this.a.p.trackAdvertsDrawSuccess();
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ UserAdvertsListPresenterImpl a;

        public e(UserAdvertsListPresenterImpl userAdvertsListPresenterImpl) {
            this.a = userAdvertsListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.p.trackAdvertsLoadingError();
            this.a.p.startDraw();
            UserAdvertsListPresenterImpl.access$onFatalErrorReceived(this.a);
            this.a.p.trackAdvertsDrawError();
        }
    }

    public static final class f<T, R> implements Function<List<? extends SerpItem>, a2.a.a.i3.d.a> {
        public final /* synthetic */ UserAdvertsListPresenterImpl a;

        public f(UserAdvertsListPresenterImpl userAdvertsListPresenterImpl) {
            this.a = userAdvertsListPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public a2.a.a.i3.d.a apply(List<? extends SerpItem> list) {
            List<? extends SerpItem> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "it");
            return UserAdvertsListPresenterImpl.access$separateSpaceIndices(this.a, list2);
        }
    }

    public static final class g<T> implements Consumer<a2.a.a.i3.d.a> {
        public final /* synthetic */ UserAdvertsListPresenterImpl a;

        public g(UserAdvertsListPresenterImpl userAdvertsListPresenterImpl) {
            this.a = userAdvertsListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(a2.a.a.i3.d.a aVar) {
            a2.a.a.i3.d.a aVar2 = aVar;
            UserAdvertsListPresenterImpl.access$updateView(this.a, new ListDataSource(aVar2.a), aVar2.b);
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public final /* synthetic */ UserAdvertsListPresenterImpl a;

        public h(UserAdvertsListPresenterImpl userAdvertsListPresenterImpl) {
            this.a = userAdvertsListPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            UserAdvertsListPresenterImpl.access$onFatalErrorReceived(this.a);
        }
    }

    @Inject
    public UserAdvertsListPresenterImpl(@NotNull String str, @NotNull UserAdvertsListInteractor userAdvertsListInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull AdapterPresenter adapterPresenter, @NotNull UserItemConverter userItemConverter, @NotNull FloatingViewsPresenter floatingViewsPresenter, @NotNull UserAdvertsHostPresenter userAdvertsHostPresenter, @NotNull UserAdvertsCountUpdater userAdvertsCountUpdater, @NotNull UserAdvertsListTracker userAdvertsListTracker, @Nullable Kundle kundle, @NotNull Set<DeeplinkClickStreamProvider> set, @NotNull Analytics analytics, @NotNull Observable<UserAdvertItemAction> observable, @NotNull LinkedInfoBannerPresenter linkedInfoBannerPresenter) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(str, "shortcut");
        Intrinsics.checkNotNullParameter(userAdvertsListInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(userItemConverter, "itemConverter");
        Intrinsics.checkNotNullParameter(floatingViewsPresenter, "floatingViewsPresenter");
        Intrinsics.checkNotNullParameter(userAdvertsHostPresenter, "userAdvertsHostPresenter");
        Intrinsics.checkNotNullParameter(userAdvertsCountUpdater, "userAdvertsCountUpdater");
        Intrinsics.checkNotNullParameter(userAdvertsListTracker, "tracker");
        Intrinsics.checkNotNullParameter(set, "deeplinkClicksStreamProviders");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(observable, "itemActions");
        Intrinsics.checkNotNullParameter(linkedInfoBannerPresenter, "linkedInfoBannerPresenter");
        this.h = str;
        this.i = userAdvertsListInteractor;
        this.j = schedulersFactory;
        this.k = adapterPresenter;
        this.l = userItemConverter;
        this.m = floatingViewsPresenter;
        this.n = userAdvertsHostPresenter;
        this.o = userAdvertsCountUpdater;
        this.p = userAdvertsListTracker;
        this.q = set;
        this.r = analytics;
        this.s = observable;
        this.t = linkedInfoBannerPresenter;
        this.a = (kundle == null || (bool = kundle.getBoolean("key_more_pages")) == null) ? true : bool.booleanValue();
        Uri uri = null;
        this.b = kundle != null ? kundle.getParcelableList("key_elements") : null;
        this.f = new CompositeDisposable();
        this.g = kundle != null ? (Uri) kundle.getParcelable("next_page") : uri;
    }

    public static final void access$deleteBannerWithId(UserAdvertsListPresenterImpl userAdvertsListPresenterImpl, String str) {
        ArrayList arrayList;
        List<? extends SerpElement> list = userAdvertsListPresenterImpl.b;
        if (list != null) {
            arrayList = new ArrayList();
            for (T t2 : list) {
                T t3 = t2;
                boolean z = true;
                if ((t3 instanceof LinkedInfoBanner) && !(!Intrinsics.areEqual(t3.getId(), str))) {
                    z = false;
                }
                if (z) {
                    arrayList.add(t2);
                }
            }
        } else {
            arrayList = null;
        }
        userAdvertsListPresenterImpl.b = arrayList;
    }

    public static final void access$onFatalErrorReceived(UserAdvertsListPresenterImpl userAdvertsListPresenterImpl) {
        userAdvertsListPresenterImpl.c = false;
        userAdvertsListPresenterImpl.m.setEnabled(false);
        userAdvertsListPresenterImpl.b = null;
        UserAdvertsListView userAdvertsListView = userAdvertsListPresenterImpl.d;
        if (userAdvertsListView != null) {
            userAdvertsListView.showError();
        }
    }

    public static final void access$onProfileAdvertsLoaded(UserAdvertsListPresenterImpl userAdvertsListPresenterImpl, List list, boolean z) {
        if (z) {
            userAdvertsListPresenterImpl.o.updateExpiredCount();
        }
        userAdvertsListPresenterImpl.c = false;
        userAdvertsListPresenterImpl.m.setEnabled(true);
        userAdvertsListPresenterImpl.a = !list.isEmpty();
        List<? extends SerpElement> list2 = userAdvertsListPresenterImpl.b;
        if (list2 != null) {
            ArrayList arrayList = new ArrayList();
            for (T t2 : list2) {
                if (!(t2 instanceof LoadingElement)) {
                    arrayList.add(t2);
                }
            }
            list = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) list);
        }
        userAdvertsListPresenterImpl.b = list;
        userAdvertsListPresenterImpl.b();
    }

    public static final a2.a.a.i3.d.a access$separateSpaceIndices(UserAdvertsListPresenterImpl userAdvertsListPresenterImpl, List list) {
        Objects.requireNonNull(userAdvertsListPresenterImpl);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Item item = (Item) obj;
            if (item instanceof ShortcutTitleItem) {
                if (((ShortcutTitleItem) item).getTitle().length() == 0) {
                    arrayList.add(Integer.valueOf(i2));
                    i2 = i3;
                }
            }
            arrayList2.add(item);
            i2 = i3;
        }
        return new a2.a.a.i3.d.a(arrayList2, arrayList);
    }

    public static final void access$updateView(UserAdvertsListPresenterImpl userAdvertsListPresenterImpl, DataSource dataSource, List list) {
        UserAdvertsListView userAdvertsListView = userAdvertsListPresenterImpl.d;
        if (userAdvertsListView != null) {
            userAdvertsListView.updateSpaceDecoration(list);
            userAdvertsListView.showAdverts();
            userAdvertsListPresenterImpl.k.onDataSourceChanged(dataSource);
            userAdvertsListView.onDataChanged();
        }
    }

    public final void a(boolean z) {
        Single<Pair<List<SerpElement>, Uri>> single;
        UserAdvertsListView userAdvertsListView;
        this.p.startAdvertsLoading();
        this.c = true;
        if (this.b == null && (userAdvertsListView = this.d) != null) {
            userAdvertsListView.showProgress();
        }
        Uri uri = this.g;
        CompositeDisposable compositeDisposable = this.f;
        if (uri == null) {
            single = this.i.loadUserAdverts(this.h);
        } else {
            single = this.i.loadUserAdverts(uri);
        }
        Disposable subscribe = single.map(new c(this)).observeOn(this.j.mainThread()).subscribe(new d(this, z), new e(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "if (nextPage == null) {\n…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenter
    public void attachRouter(@NotNull UserAdvertsListPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.e = router;
        this.m.attachSubscriber(this);
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenter
    public void attachView(@Nullable UserAdvertsListView userAdvertsListView) {
        this.d = userAdvertsListView;
        if (this.b == null) {
            a(Intrinsics.areEqual(this.h, "inactive"));
        } else {
            b();
        }
        CompositeDisposable compositeDisposable = this.f;
        Disposable subscribe = this.s.subscribe(new a2.a.a.i3.d.b(this), a2.a.a.i3.d.c.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemActions.subscribe({\n… actions\", it)\n        })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        Iterator<T> it = this.q.iterator();
        while (it.hasNext()) {
            CompositeDisposable compositeDisposable2 = this.f;
            Disposable subscribe2 = it.next().getDeeplinkClicks().debounce(300, TimeUnit.MILLISECONDS).subscribeOn(this.j.mainThread()).subscribe(new a2.a.a.i3.d.d(this), a2.a.a.i3.d.e.a);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "deeplinkClickStream\n    …ber.e(it) }\n            )");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        }
        CompositeDisposable compositeDisposable3 = this.f;
        Disposable subscribe3 = this.t.getCloseBannerClicks().observeOn(this.j.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "linkedInfoBannerPresente…nter\", it)\n            })");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
    }

    public final void b() {
        CompositeDisposable compositeDisposable = this.f;
        UserItemConverter userItemConverter = this.l;
        List<? extends SerpElement> list = this.b;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Disposable subscribe = userItemConverter.convert(list).map(new f(this)).observeOn(this.j.mainThread()).subscribe(new g(this), new h(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemConverter.convert(el…Received()\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenter
    public void closeUserAdvertsBanner(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "bannerId");
        CompositeDisposable compositeDisposable = this.f;
        Observable<SuccessResult> observeOn = this.i.closeUserAdvertsBanner(str).observeOn(this.j.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "interactor.closeUserAdve…(schedulers.mainThread())");
        DisposableKt.plusAssign(compositeDisposable, Observables.subscribeIgnoreResult(observeOn));
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenter
    public void detachRouter() {
        this.e = null;
        this.m.detachAll();
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenter
    public void detachView() {
        this.f.clear();
        this.d = null;
    }

    @Override // com.avito.android.floating_views.FloatingViewsPresenter.Subscriber
    public void hideFloatingViews(boolean z) {
        this.n.onHideFloatingViews(this.h, z, false);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemClickListener
    public void onAdvertClicked(@NotNull UserAdvertItem userAdvertItem) {
        Intrinsics.checkNotNullParameter(userAdvertItem, "advert");
        UserAdvertsListPresenter.Router router = this.e;
        if (router != null) {
            router.followDeepLink(userAdvertItem.getDeepLink());
        }
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenter
    public void onAdvertDetailsResult(int i2, @Nullable Intent intent) {
        this.n.onAdvertDetailsResult(i2, intent);
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenter
    public void onRefresh(boolean z, boolean z2) {
        if (z) {
            this.b = null;
            this.g = null;
            this.c = false;
            this.a = true;
            UserAdvertsListView userAdvertsListView = this.d;
            if (userAdvertsListView != null) {
                userAdvertsListView.scrollToTop();
            }
        }
        if (z2) {
            this.n.onRefreshTabs();
            this.n.onRefreshSoaStatistics();
        } else {
            this.n.onInvalidateActiveTab();
        }
        a(Intrinsics.areEqual(this.h, "inactive"));
    }

    @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putBoolean("key_more_pages", Boolean.valueOf(this.a)).putParcelableList("key_elements", this.b).putParcelable("next_page", this.g);
    }

    @Override // com.avito.android.serp.adapter.ShortcutBannerItemListener
    public void onShortcutBannerItemClicked(@NotNull ShortcutBannerItem shortcutBannerItem) {
        Intrinsics.checkNotNullParameter(shortcutBannerItem, "item");
        this.r.track(new BannerEvent.Action(shortcutBannerItem.getStringId(), "profile", "top", "click"));
        UserAdvertsListPresenter.Router router = this.e;
        if (router != null) {
            router.showInfoBannerScreen(shortcutBannerItem.getDeepLink());
        }
    }

    @Override // com.avito.android.serp.adapter.ShortcutBannerItemListener
    public void onShortcutBannerItemShowed(@NotNull ShortcutBannerItem shortcutBannerItem) {
        Intrinsics.checkNotNullParameter(shortcutBannerItem, "item");
        this.r.track(new BannerEvent.Shown(shortcutBannerItem.getStringId(), "profile", "top"));
    }

    @Override // com.avito.android.floating_views.FloatingViewsPresenter.Subscriber
    public void showFloatingViews(boolean z) {
        this.n.onShowFloatingViews(this.h, z, false);
    }
}
