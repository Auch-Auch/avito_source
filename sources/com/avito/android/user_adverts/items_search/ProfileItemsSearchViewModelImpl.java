package com.avito.android.user_adverts.items_search;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.Analytics;
import com.avito.android.component.user_advert.UserAdvertItem;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.UserAdvertsResult;
import com.avito.android.serp.adapter.ShortcutBannerItem;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModel;
import com.avito.android.user_adverts.items_search.advert_list.UserSearchItemConverter;
import com.avito.android.user_adverts.items_search.advert_list.suggests.SuggestsItemConverter;
import com.avito.android.user_adverts.items_search.analytics.PageType;
import com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchEvent;
import com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker;
import com.avito.android.user_adverts.items_search.analytics.ProfileItemsSuggestsEvent;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertItemAction;
import com.avito.android.user_adverts.tab_screens.advert_list.loading.LoadMoreAction;
import com.avito.android.user_adverts.tab_screens.advert_list.loading.LoadingElement;
import com.avito.android.user_adverts.tab_screens.advert_list.shortcut_title.ShortcutTitleItem;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
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
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001cB?\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u0010\\\u001a\u00020Y\u0012\u0006\u0010`\u001a\u00020]\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u00100\u001a\u00020\u0003¢\u0006\u0004\ba\u0010bJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tJ+\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00072\u0010\u0010\u0012\u001a\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0017H\u0016¢\u0006\u0004\b\u001e\u0010\u001aJ\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010 J\u0017\u0010!\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010\u0016J\u0017\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b(\u0010'J\u000f\u0010)\u001a\u00020\u0007H\u0014¢\u0006\u0004\b)\u0010\u0016J\u0017\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\b\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u0018088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u00109R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u00109R\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020U0T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_¨\u0006d"}, d2 = {"Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel;", "", "query", "", "userIntent", "", "search", "(Ljava/lang/String;Z)V", "d", "", "count", "c", "(Ljava/lang/Integer;ZLjava/lang/String;)V", "Lio/reactivex/Observable;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemAction;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemActionObservable;", "itemActions", "subscribeToItemActions", "(Lio/reactivex/Observable;)V", "unsubscribeFromItemActions", "()V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$ItemsState;", "itemsState", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$Suggests;", "suggestsState", "Lcom/avito/android/deep_linking/links/DeepLink;", "advertClicks", "loadSuggestions", "(Ljava/lang/String;)V", "refreshResults", "(Z)V", "retryOnError", "Lcom/avito/android/serp/adapter/ShortcutBannerItem;", "item", "onShortcutBannerItemShowed", "(Lcom/avito/android/serp/adapter/ShortcutBannerItem;)V", "onShortcutBannerItemClicked", "onCleared", "Lcom/avito/android/component/user_advert/UserAdvertItem;", "advert", "onAdvertClicked", "(Lcom/avito/android/component/user_advert/UserAdvertItem;)V", VKApiConst.Q, "Ljava/lang/String;", "shortcut", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModelImpl$a;", "i", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModelImpl$a;", "Lcom/avito/android/user_adverts/items_search/advert_list/UserSearchItemConverter;", "n", "Lcom/avito/android/user_adverts/items_search/advert_list/UserSearchItemConverter;", "itemConverter", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchInteractor;", "k", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchInteractor;", "interactor", "Lcom/avito/android/analytics/Analytics;", "p", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestsItemConverter;", "o", "Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestsItemConverter;", "suggestConverter", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "e", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lio/reactivex/disposables/Disposable;", "f", "Lio/reactivex/disposables/Disposable;", "itemActionsDisposable", "h", "Z", "isAppending", "Lio/reactivex/disposables/CompositeDisposable;", a2.g.r.g.a, "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "", "Lcom/avito/android/remote/model/SerpElement;", "j", "Ljava/util/List;", MessengerShareContentUtility.ELEMENTS, "Lcom/avito/android/user_adverts/items_search/analytics/ProfileItemsSearchTracker;", "l", "Lcom/avito/android/user_adverts/items_search/analytics/ProfileItemsSearchTracker;", "tracker", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchInteractor;Lcom/avito/android/user_adverts/items_search/analytics/ProfileItemsSearchTracker;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/user_adverts/items_search/advert_list/UserSearchItemConverter;Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestsItemConverter;Lcom/avito/android/analytics/Analytics;Ljava/lang/String;)V", AuthSource.SEND_ABUSE, "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileItemsSearchViewModelImpl extends ViewModel implements ProfileItemsSearchViewModel {
    public final MutableLiveData<ProfileItemsSearchViewModel.ItemsState> c = new MutableLiveData<>();
    public final MutableLiveData<ProfileItemsSearchViewModel.Suggests> d = new MutableLiveData<>();
    public final SingleLiveEvent<DeepLink> e = new SingleLiveEvent<>();
    public Disposable f;
    public final CompositeDisposable g = new CompositeDisposable();
    public boolean h;
    public a i = new a(null, null, null, 7);
    public List<? extends SerpElement> j = CollectionsKt__CollectionsKt.emptyList();
    public final ProfileItemsSearchInteractor k;
    public final ProfileItemsSearchTracker l;
    public final SchedulersFactory m;
    public final UserSearchItemConverter n;
    public final SuggestsItemConverter o;
    public final Analytics p;
    public final String q;

    public static final class b<T> implements Consumer<List<? extends String>> {
        public final /* synthetic */ ProfileItemsSearchViewModelImpl a;
        public final /* synthetic */ String b;

        public b(ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl, String str) {
            this.a = profileItemsSearchViewModelImpl;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.avito.android.user_adverts.items_search.advert_list.suggests.SuggestsItemConverter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends String> list) {
            List<? extends String> list2 = list;
            ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            ProfileItemsSearchViewModelImpl.access$trackSuggestsResult(profileItemsSearchViewModelImpl, list2, this.b);
            this.a.d.setValue(new ProfileItemsSearchViewModel.Suggests(this.a.o.convert(list2)));
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ ProfileItemsSearchViewModelImpl a;

        public c(ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl) {
            this.a = profileItemsSearchViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.d.setValue(new ProfileItemsSearchViewModel.Suggests(CollectionsKt__CollectionsKt.emptyList()));
        }
    }

    public static final class d<T, R> implements Function<UserAdvertsResult, Pair<? extends List<? extends SerpElement>, ? extends Uri>> {
        public final /* synthetic */ ProfileItemsSearchViewModelImpl a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public d(ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl, boolean z, String str) {
            this.a = profileItemsSearchViewModelImpl;
            this.b = z;
            this.c = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Pair<? extends List<? extends SerpElement>, ? extends Uri> apply(UserAdvertsResult userAdvertsResult) {
            UserAdvertsResult userAdvertsResult2 = userAdvertsResult;
            Intrinsics.checkNotNullParameter(userAdvertsResult2, "it");
            ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl = this.a;
            profileItemsSearchViewModelImpl.i = a.a(profileItemsSearchViewModelImpl.i, null, userAdvertsResult2.getTotalCount(), null, 5);
            this.a.c(userAdvertsResult2.getTotalCount(), this.b, this.c);
            return TuplesKt.to(userAdvertsResult2.getList(), userAdvertsResult2.getNextPage());
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ ProfileItemsSearchViewModelImpl a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public e(ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl, boolean z, String str) {
            this.a = profileItemsSearchViewModelImpl;
            this.b = z;
            this.c = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.c(null, this.b, this.c);
        }
    }

    public static final class f<T, R> implements Function<Pair<? extends List<? extends SerpElement>, ? extends Uri>, Pair<? extends List<? extends SerpElement>, ? extends Uri>> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Pair<? extends List<? extends SerpElement>, ? extends Uri> apply(Pair<? extends List<? extends SerpElement>, ? extends Uri> pair) {
            Pair<? extends List<? extends SerpElement>, ? extends Uri> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "<name for destructuring parameter 0>");
            List list = (List) pair2.component1();
            Uri uri = (Uri) pair2.component2();
            if (uri == null) {
                return TuplesKt.to(list, uri);
            }
            return TuplesKt.to(CollectionsKt___CollectionsKt.plus((Collection<? extends LoadingElement>) list, new LoadingElement()), uri);
        }
    }

    public static final class g<T> implements Consumer<Pair<? extends List<? extends SerpElement>, ? extends Uri>> {
        public final /* synthetic */ ProfileItemsSearchViewModelImpl a;
        public final /* synthetic */ String b;

        public g(ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl, String str) {
            this.a = profileItemsSearchViewModelImpl;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Pair<? extends List<? extends SerpElement>, ? extends Uri> pair) {
            Pair<? extends List<? extends SerpElement>, ? extends Uri> pair2 = pair;
            ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl = this.a;
            profileItemsSearchViewModelImpl.i = a.a(profileItemsSearchViewModelImpl.i, null, null, (Uri) pair2.component2(), 3);
            this.a.l.trackAdvertsLoadingSuccess();
            this.a.l.trackAdvertsPrepareSuccess();
            this.a.l.startDraw();
            ProfileItemsSearchViewModelImpl.access$onProfileAdvertsLoaded(this.a, this.b, (List) pair2.component1());
            this.a.l.trackAdvertsDrawSuccess();
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public final /* synthetic */ ProfileItemsSearchViewModelImpl a;

        public h(ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl) {
            this.a = profileItemsSearchViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.l.trackAdvertsLoadingError();
            this.a.l.trackAdvertsPrepareError();
            this.a.l.startDraw();
            ProfileItemsSearchViewModelImpl.access$onFatalErrorReceived(this.a);
            this.a.l.trackAdvertsDrawError();
        }
    }

    public static final class i<T> implements Consumer<UserAdvertItemAction> {
        public final /* synthetic */ ProfileItemsSearchViewModelImpl a;

        public i(ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl) {
            this.a = profileItemsSearchViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(UserAdvertItemAction userAdvertItemAction) {
            if ((userAdvertItemAction instanceof LoadMoreAction) && !this.a.h) {
                ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl = this.a;
                profileItemsSearchViewModelImpl.d(profileItemsSearchViewModelImpl.i.a, true);
            }
        }
    }

    public static final class j<T> implements Consumer<Throwable> {
        public static final j a = new j();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to observe item actions", th);
        }
    }

    public ProfileItemsSearchViewModelImpl(@NotNull ProfileItemsSearchInteractor profileItemsSearchInteractor, @NotNull ProfileItemsSearchTracker profileItemsSearchTracker, @NotNull SchedulersFactory schedulersFactory, @NotNull UserSearchItemConverter userSearchItemConverter, @NotNull SuggestsItemConverter suggestsItemConverter, @NotNull Analytics analytics, @NotNull String str) {
        Intrinsics.checkNotNullParameter(profileItemsSearchInteractor, "interactor");
        Intrinsics.checkNotNullParameter(profileItemsSearchTracker, "tracker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(userSearchItemConverter, "itemConverter");
        Intrinsics.checkNotNullParameter(suggestsItemConverter, "suggestConverter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(str, "shortcut");
        this.k = profileItemsSearchInteractor;
        this.l = profileItemsSearchTracker;
        this.m = schedulersFactory;
        this.n = userSearchItemConverter;
        this.o = suggestsItemConverter;
        this.p = analytics;
        this.q = str;
    }

    public static final void access$onFatalErrorReceived(ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl) {
        profileItemsSearchViewModelImpl.h = false;
        profileItemsSearchViewModelImpl.c.setValue(ProfileItemsSearchViewModel.ItemsState.Error.INSTANCE);
    }

    public static final void access$onProfileAdvertsLoaded(ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl, String str, List list) {
        profileItemsSearchViewModelImpl.h = false;
        if (list.isEmpty() && profileItemsSearchViewModelImpl.j.isEmpty()) {
            profileItemsSearchViewModelImpl.c.setValue(new ProfileItemsSearchViewModel.ItemsState.LoadedEmpty(str));
        }
        List<? extends SerpElement> list2 = profileItemsSearchViewModelImpl.j;
        ArrayList arrayList = new ArrayList();
        for (T t : list2) {
            if (!(t instanceof LoadingElement)) {
                arrayList.add(t);
            }
        }
        List<? extends SerpElement> plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) list);
        profileItemsSearchViewModelImpl.j = plus;
        Integer num = profileItemsSearchViewModelImpl.i.b;
        int intValue = num != null ? num.intValue() : plus.size();
        CompositeDisposable compositeDisposable = profileItemsSearchViewModelImpl.g;
        Disposable subscribe = profileItemsSearchViewModelImpl.n.convert(intValue, profileItemsSearchViewModelImpl.j).map(new a2.a.a.i3.b.d(profileItemsSearchViewModelImpl)).observeOn(profileItemsSearchViewModelImpl.m.mainThread()).subscribe(new a2.a.a.i3.b.e(profileItemsSearchViewModelImpl), new a2.a.a.i3.b.f(profileItemsSearchViewModelImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemConverter.convert(to…Received()\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final Pair access$separateSpaceIndices(ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl, List list) {
        Objects.requireNonNull(profileItemsSearchViewModelImpl);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            SpannedItem spannedItem = (SpannedItem) obj;
            if (spannedItem instanceof ShortcutTitleItem) {
                if (((ShortcutTitleItem) spannedItem).getTitle().length() == 0) {
                    arrayList.add(Integer.valueOf(i2));
                    i2 = i3;
                }
            }
            arrayList2.add(spannedItem);
            i2 = i3;
        }
        return TuplesKt.to(arrayList2, arrayList);
    }

    public static final void access$trackSuggestsResult(ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl, List list, String str) {
        Objects.requireNonNull(profileItemsSearchViewModelImpl);
        if (!list.isEmpty()) {
            profileItemsSearchViewModelImpl.p.track(new ProfileItemsSuggestsEvent(str));
        }
    }

    @Override // com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModel
    @NotNull
    public LiveData<DeepLink> advertClicks() {
        return this.e;
    }

    public final void c(Integer num, boolean z, String str) {
        if (z) {
            if (num == null) {
                this.p.track(new ProfileItemsSearchEvent(0, this.q, PageType.SEARCH_BAR, str, 1, null));
            } else {
                this.p.track(new ProfileItemsSearchEvent(num.intValue(), this.q, PageType.SEARCH_BAR, str));
            }
        }
    }

    public final void d(String str, boolean z) {
        Single<Pair<List<SerpElement>, Uri>> single;
        this.l.startLoadingAdverts();
        this.h = true;
        Uri uri = this.i.c;
        CompositeDisposable compositeDisposable = this.g;
        if (uri == null) {
            single = this.k.search(str).map(new d(this, z, str)).doOnError(new e(this, z, str));
            Intrinsics.checkNotNullExpressionValue(single, "interactor.search(query)…rIntent, query = query) }");
        } else {
            single = this.k.loadMoreItems(uri);
        }
        Disposable subscribe = single.map(f.a).observeOn(this.m.mainThread()).subscribe(new g(this, str), new h(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "if (nextPage == null) {\n…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModel
    @NotNull
    public LiveData<ProfileItemsSearchViewModel.ItemsState> itemsState() {
        return this.c;
    }

    @Override // com.avito.android.user_adverts.items_search.SearchBarInteractor
    public void loadSuggestions(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        if (Intrinsics.areEqual(str, "")) {
            this.d.postValue(new ProfileItemsSearchViewModel.Suggests(CollectionsKt__CollectionsKt.emptyList()));
            return;
        }
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = this.k.loadSuggests(str).observeOn(this.m.mainThread()).subscribe(new b(this, str), new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadSuggests(…ptyList())\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.component.user_advert.UserAdvertItemClickListener
    public void onAdvertClicked(@NotNull UserAdvertItem userAdvertItem) {
        Intrinsics.checkNotNullParameter(userAdvertItem, "advert");
        this.e.postValue(userAdvertItem.getDeepLink());
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.g.clear();
        super.onCleared();
    }

    @Override // com.avito.android.serp.adapter.ShortcutBannerItemListener
    public void onShortcutBannerItemClicked(@NotNull ShortcutBannerItem shortcutBannerItem) {
        Intrinsics.checkNotNullParameter(shortcutBannerItem, "item");
    }

    @Override // com.avito.android.serp.adapter.ShortcutBannerItemListener
    public void onShortcutBannerItemShowed(@NotNull ShortcutBannerItem shortcutBannerItem) {
        Intrinsics.checkNotNullParameter(shortcutBannerItem, "item");
    }

    @Override // com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModel
    public void refreshResults(boolean z) {
        search(this.i.a, z);
    }

    @Override // com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModel
    public void retryOnError() {
        search(this.i.a);
    }

    @Override // com.avito.android.user_adverts.items_search.SearchBarInteractor
    public void search(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        search(str, true);
    }

    @Override // com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModel
    public void subscribeToItemActions(@NotNull Observable<UserAdvertItemAction> observable) {
        Intrinsics.checkNotNullParameter(observable, "itemActions");
        this.f = observable.subscribe(new i(this), j.a);
    }

    @Override // com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModel
    @NotNull
    public LiveData<ProfileItemsSearchViewModel.Suggests> suggestsState() {
        return this.d;
    }

    @Override // com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModel
    public void unsubscribeFromItemActions() {
        Disposable disposable = this.f;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public static final class a {
        @NotNull
        public final String a;
        @Nullable
        public final Integer b;
        @Nullable
        public final Uri c;

        public a() {
            this(null, null, null, 7);
        }

        public a(String str, Integer num, Uri uri, int i) {
            str = (i & 1) != 0 ? "" : str;
            int i2 = i & 2;
            int i3 = i & 4;
            Intrinsics.checkNotNullParameter(str, "query");
            this.a = str;
            this.b = null;
            this.c = null;
        }

        public static a a(a aVar, String str, Integer num, Uri uri, int i) {
            String str2 = (i & 1) != 0 ? aVar.a : null;
            if ((i & 2) != 0) {
                num = aVar.b;
            }
            if ((i & 4) != 0) {
                uri = aVar.c;
            }
            Objects.requireNonNull(aVar);
            Intrinsics.checkNotNullParameter(str2, "query");
            return new a(str2, num, uri);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c);
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.b;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
            Uri uri = this.c;
            if (uri != null) {
                i = uri.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("SearchState(query=");
            L.append(this.a);
            L.append(", totalCount=");
            L.append(this.b);
            L.append(", nextPage=");
            L.append(this.c);
            L.append(")");
            return L.toString();
        }

        public a(@NotNull String str, @Nullable Integer num, @Nullable Uri uri) {
            Intrinsics.checkNotNullParameter(str, "query");
            this.a = str;
            this.b = num;
            this.c = uri;
        }
    }

    public final void search(String str, boolean z) {
        this.c.setValue(ProfileItemsSearchViewModel.ItemsState.Loading.INSTANCE);
        this.j = CollectionsKt__CollectionsKt.emptyList();
        this.i = new a(str, null, null, 6);
        d(str, z);
    }
}
