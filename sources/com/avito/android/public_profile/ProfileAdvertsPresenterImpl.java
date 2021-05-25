package com.avito.android.public_profile;

import a2.g.r.g;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteButtonClickListener;
import com.avito.android.public_profile.ProfileAdvertsInteractor;
import com.avito.android.public_profile.ProfileAdvertsPresenter;
import com.avito.android.public_profile.adapter.error_snippet.ErrorSnippetItem;
import com.avito.android.public_profile.adapter.loading_item.PageLoadingItem;
import com.avito.android.public_profile.adapter.placeholder.PlaceholderItem;
import com.avito.android.public_profile.remote.model.ProfileAdvertsResult;
import com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B·\u0001\u0012\u0006\u0010b\u001a\u00020:\u0012\u0006\u0010=\u001a\u00020:\u0012\b\u0010n\u001a\u0004\u0018\u00010:\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010P\u001a\u00020M\u0012\u0006\u0010T\u001a\u00020Q\u0012\u0007\u0010\u0001\u001a\u00020~\u0012\f\u0010h\u001a\b\u0012\u0004\u0012\u00020e0d\u0012\u0006\u0010l\u001a\u00020i\u0012\u0006\u0010L\u001a\u00020I\u0012\u0006\u0010F\u001a\u00020C\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010t\u001a\u00020q\u0012\f\u0010B\u001a\b\u0012\u0004\u0012\u00020?0>\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020*0)\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000302¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u0019\u0010\u0011\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\tJ)\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u0018\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%H\u0001¢\u0006\u0004\b'\u0010(R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\u0003028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020?0>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010<R\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010GR\u0016\u0010^\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010]R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010b\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010<R\u0018\u0010c\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010<R\u001c\u0010h\u001a\b\u0012\u0004\u0012\u00020e0d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010n\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010<R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u001c\u0010}\u001a\b\u0012\u0004\u0012\u00020z0y8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010\u0001\u001a\u00020~8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/public_profile/ProfileAdvertsPresenterImpl;", "Lcom/avito/android/public_profile/ProfileAdvertsPresenter;", "Lcom/avito/android/favorite/FavoriteButtonClickListener;", "", AuthSource.BOOKING_ORDER, "()V", "c", "", AuthSource.SEND_ABUSE, "()Z", "Lcom/avito/android/public_profile/ProfileAdvertsView;", "view", "attachView", "(Lcom/avito/android/public_profile/ProfileAdvertsView;)V", "detachView", "Lcom/avito/android/public_profile/ProfileAdvertsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/public_profile/ProfileAdvertsPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onAppend", "canAppend", "Lcom/avito/android/serp/adapter/AdvertItem;", "advert", "", VKApiConst.POSITION, "Lcom/avito/android/remote/model/Image;", "image", "onAdvertClicked", "(Lcom/avito/android/serp/adapter/AdvertItem;ILcom/avito/android/remote/model/Image;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onAdditionalActionClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/serp/adapter/FavorableItem;", "favorableItem", "onFavoriteButtonClicked", "(Lcom/avito/android/serp/adapter/FavorableItem;)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/public_profile/remote/model/ProfileAdvertsResult;", "y", "Lio/reactivex/rxjava3/functions/Consumer;", "profileAdvertsResultReceivedEvent", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "o", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/jakewharton/rxrelay3/PublishRelay;", "z", "Lcom/jakewharton/rxrelay3/PublishRelay;", "profileAdvertsNeedReloadEvent", "Lcom/avito/android/public_profile/ProfileAdvertsInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/public_profile/ProfileAdvertsInteractor;", "interactor", "", "k", "Ljava/lang/String;", "shortcut", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/public_profile/adapter/error_snippet/ErrorSnippetItem;", "x", "Lio/reactivex/rxjava3/core/Observable;", "errorSnippetClicks", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", VKApiConst.VERSION, "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Z", "hasMorePages", "Lcom/avito/android/public_profile/ProfileAdvertsResourceProvider;", "u", "Lcom/avito/android/public_profile/ProfileAdvertsResourceProvider;", "resourceProvider", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "p", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "serpSpanProvider", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", VKApiConst.Q, "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "d", "disclaimer", "Lcom/avito/android/util/SchedulersFactory3;", "n", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "f", "isAppending", "I", "offset", g.a, "Lcom/avito/android/public_profile/ProfileAdvertsView;", "j", "userKey", "lastErrorMessage", "Lcom/avito/android/util/Formatter;", "", "s", "Lcom/avito/android/util/Formatter;", "errorFormatter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "t", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "l", "contextId", "h", "Lcom/avito/android/public_profile/ProfileAdvertsPresenter$Router;", "Lcom/avito/android/public_profile/tracker/PublicProfileAdvertsTracker;", "w", "Lcom/avito/android/public_profile/tracker/PublicProfileAdvertsTracker;", "tracker", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "i", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "", "Lcom/avito/android/remote/model/SerpElement;", "e", "Ljava/util/List;", MessengerShareContentUtility.ELEMENTS, "Lcom/avito/android/serp/SerpItemProcessor;", "r", "Lcom/avito/android/serp/SerpItemProcessor;", "itemProcessor", "state", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/public_profile/ProfileAdvertsInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/serp/adapter/SerpSpanProvider;Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Lcom/avito/android/serp/SerpItemProcessor;Lcom/avito/android/util/Formatter;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/public_profile/ProfileAdvertsResourceProvider;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Lcom/avito/android/util/Kundle;Lcom/avito/android/public_profile/tracker/PublicProfileAdvertsTracker;Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/functions/Consumer;Lcom/jakewharton/rxrelay3/PublishRelay;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileAdvertsPresenterImpl implements ProfileAdvertsPresenter, FavoriteButtonClickListener {
    public boolean a;
    public String b;
    public int c;
    public String d;
    public List<? extends SerpElement> e;
    public boolean f;
    public ProfileAdvertsView g;
    public ProfileAdvertsPresenter.Router h;
    public final CompositeDisposable i;
    public final String j;
    public final String k;
    public final String l;
    public final ProfileAdvertsInteractor m;
    public final SchedulersFactory3 n;
    public final AdapterPresenter o;
    public final SerpSpanProvider p;
    public final SpannedGridPositionProvider q;
    public final SerpItemProcessor r;
    public final Formatter<Throwable> s;
    public final FavoriteAdvertsPresenter t;
    public final ProfileAdvertsResourceProvider u;
    public final ViewedAdvertsPresenter v;
    public final PublicProfileAdvertsTracker w;
    public final Observable<ErrorSnippetItem> x;
    public final Consumer<ProfileAdvertsResult> y;
    public final PublishRelay<Unit> z;

    public static final class a<T> implements Consumer<ErrorSnippetItem> {
        public final /* synthetic */ ProfileAdvertsPresenterImpl a;

        public a(ProfileAdvertsPresenterImpl profileAdvertsPresenterImpl) {
            this.a = profileAdvertsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(ErrorSnippetItem errorSnippetItem) {
            this.a.b = null;
            ProfileAdvertsPresenterImpl.access$loadAdvertsOrUpdateDataSource(this.a);
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ ProfileAdvertsPresenterImpl a;

        public b(ProfileAdvertsPresenterImpl profileAdvertsPresenterImpl) {
            this.a = profileAdvertsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.e = CollectionsKt__CollectionsKt.emptyList();
            this.a.b();
        }
    }

    public static final class c<T> implements Consumer<ProfileAdvertsResult> {
        public final /* synthetic */ ProfileAdvertsPresenterImpl a;

        public c(ProfileAdvertsPresenterImpl profileAdvertsPresenterImpl) {
            this.a = profileAdvertsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(ProfileAdvertsResult profileAdvertsResult) {
            ProfileAdvertsResult profileAdvertsResult2 = profileAdvertsResult;
            this.a.w.trackProfileAdvertsLoaded();
            ProfileAdvertsPresenterImpl profileAdvertsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(profileAdvertsResult2, "it");
            ProfileAdvertsPresenterImpl.access$onProfileAdvertsLoaded(profileAdvertsPresenterImpl, profileAdvertsResult2);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ ProfileAdvertsPresenterImpl a;

        public d(ProfileAdvertsPresenterImpl profileAdvertsPresenterImpl) {
            this.a = profileAdvertsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.a.w.trackProfileAdvertsLoadError();
            this.a.w.startProfileAdvertsPreparing();
            ProfileAdvertsPresenterImpl profileAdvertsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            ProfileAdvertsPresenterImpl.access$handleLoadError(profileAdvertsPresenterImpl, th2);
        }
    }

    public static final class e<T> implements Consumer<List<? extends ViewTypeSerpItem>> {
        public final /* synthetic */ ProfileAdvertsPresenterImpl a;
        public final /* synthetic */ int b;

        public e(ProfileAdvertsPresenterImpl profileAdvertsPresenterImpl, int i) {
            this.a = profileAdvertsPresenterImpl;
            this.b = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends ViewTypeSerpItem> list) {
            List<? extends ViewTypeSerpItem> list2 = list;
            String str = this.a.d;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list2);
            if (!this.a.a && str != null) {
                mutableList.add(new PlaceholderItem(str, this.b, null, 4, null));
            }
            ProfileAdvertsPresenterImpl.access$updateErrorSnippet(this.a, mutableList, this.b);
            ProfileAdvertsPresenterImpl.access$updatePageLoading(this.a, mutableList, this.b);
            ProfileAdvertsPresenterImpl.access$updateView(this.a, new ListDataSource(mutableList));
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ ProfileAdvertsPresenterImpl a;

        public f(ProfileAdvertsPresenterImpl profileAdvertsPresenterImpl) {
            this.a = profileAdvertsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.avito.android.util.Formatter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            ProfileAdvertsView profileAdvertsView = this.a.g;
            if (profileAdvertsView != null) {
                profileAdvertsView.showError(this.a.s.format(th2));
            }
        }
    }

    public ProfileAdvertsPresenterImpl(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull ProfileAdvertsInteractor profileAdvertsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AdapterPresenter adapterPresenter, @NotNull SerpSpanProvider serpSpanProvider, @NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull SerpItemProcessor serpItemProcessor, @NotNull Formatter<Throwable> formatter, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull ProfileAdvertsResourceProvider profileAdvertsResourceProvider, @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @Nullable Kundle kundle, @NotNull PublicProfileAdvertsTracker publicProfileAdvertsTracker, @NotNull Observable<ErrorSnippetItem> observable, @NotNull Consumer<ProfileAdvertsResult> consumer, @NotNull PublishRelay<Unit> publishRelay) {
        List<? extends SerpElement> emptyList;
        Integer num;
        Boolean bool;
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(str2, "shortcut");
        Intrinsics.checkNotNullParameter(profileAdvertsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(serpSpanProvider, "serpSpanProvider");
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(serpItemProcessor, "itemProcessor");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(profileAdvertsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(publicProfileAdvertsTracker, "tracker");
        Intrinsics.checkNotNullParameter(observable, "errorSnippetClicks");
        Intrinsics.checkNotNullParameter(consumer, "profileAdvertsResultReceivedEvent");
        Intrinsics.checkNotNullParameter(publishRelay, "profileAdvertsNeedReloadEvent");
        this.j = str;
        this.k = str2;
        this.l = str3;
        this.m = profileAdvertsInteractor;
        this.n = schedulersFactory3;
        this.o = adapterPresenter;
        this.p = serpSpanProvider;
        this.q = spannedGridPositionProvider;
        this.r = serpItemProcessor;
        this.s = formatter;
        this.t = favoriteAdvertsPresenter;
        this.u = profileAdvertsResourceProvider;
        this.v = viewedAdvertsPresenter;
        this.w = publicProfileAdvertsTracker;
        this.x = observable;
        this.y = consumer;
        this.z = publishRelay;
        this.a = (kundle == null || (bool = kundle.getBoolean("key_more_pages")) == null) ? true : bool.booleanValue();
        String str4 = null;
        this.b = kundle != null ? kundle.getString("key_last_error_message") : null;
        this.c = (kundle == null || (num = kundle.getInt("key_offset")) == null) ? 0 : num.intValue();
        this.d = kundle != null ? kundle.getString("key_disclaimer") : str4;
        this.e = (kundle == null || (emptyList = kundle.getParcelableList("key_elements")) == null) ? CollectionsKt__CollectionsKt.emptyList() : emptyList;
        this.i = new CompositeDisposable();
        serpSpanProvider.setAppendingListener(this);
    }

    public static final void access$handleLoadError(ProfileAdvertsPresenterImpl profileAdvertsPresenterImpl, Throwable th) {
        profileAdvertsPresenterImpl.f = false;
        profileAdvertsPresenterImpl.b = profileAdvertsPresenterImpl.s.format(th);
        profileAdvertsPresenterImpl.c();
        profileAdvertsPresenterImpl.w.trackProfileAdvertsErrorPreparing();
        profileAdvertsPresenterImpl.w.startProfileAdvertsDraw();
        profileAdvertsPresenterImpl.w.trackProfileAdvertsErrorDraw();
    }

    public static final void access$loadAdvertsOrUpdateDataSource(ProfileAdvertsPresenterImpl profileAdvertsPresenterImpl) {
        if (profileAdvertsPresenterImpl.a()) {
            profileAdvertsPresenterImpl.b();
        } else {
            profileAdvertsPresenterImpl.c();
        }
    }

    public static final void access$onProfileAdvertsLoaded(ProfileAdvertsPresenterImpl profileAdvertsPresenterImpl, ProfileAdvertsResult profileAdvertsResult) {
        profileAdvertsPresenterImpl.w.startProfileAdvertsPreparing();
        profileAdvertsPresenterImpl.d = profileAdvertsResult.getDisclaimer();
        boolean z2 = false;
        profileAdvertsPresenterImpl.f = false;
        profileAdvertsPresenterImpl.y.accept(profileAdvertsResult);
        List<SerpElement> list = profileAdvertsResult.getList();
        if (list != null && !list.isEmpty()) {
            z2 = true;
        }
        profileAdvertsPresenterImpl.a = z2;
        List<SerpElement> list2 = profileAdvertsResult.getList();
        if (list2 != null) {
            if (!profileAdvertsPresenterImpl.a()) {
                list2 = CollectionsKt___CollectionsKt.plus((Collection) profileAdvertsPresenterImpl.e, (Iterable) list2);
            }
            profileAdvertsPresenterImpl.e = list2;
        }
        profileAdvertsPresenterImpl.c = profileAdvertsPresenterImpl.e.size();
        profileAdvertsPresenterImpl.c();
    }

    public static final void access$updateErrorSnippet(ProfileAdvertsPresenterImpl profileAdvertsPresenterImpl, List list, int i2) {
        Objects.requireNonNull(profileAdvertsPresenterImpl);
        h.removeAll(list, (Function1) a2.a.a.d2.a.a);
        String str = profileAdvertsPresenterImpl.b;
        if (str != null) {
            list.add(new ErrorSnippetItem(str, i2, null, 4, null));
        }
    }

    public static final void access$updatePageLoading(ProfileAdvertsPresenterImpl profileAdvertsPresenterImpl, List list, int i2) {
        Objects.requireNonNull(profileAdvertsPresenterImpl);
        h.removeAll(list, (Function1) a2.a.a.d2.b.a);
        if (profileAdvertsPresenterImpl.a) {
            String str = profileAdvertsPresenterImpl.b;
            if (str == null || str.length() == 0) {
                list.add(new PageLoadingItem(i2, null, 2, null));
            }
        }
    }

    public static final void access$updateView(ProfileAdvertsPresenterImpl profileAdvertsPresenterImpl, DataSource dataSource) {
        profileAdvertsPresenterImpl.w.trackProfileAdvertsPreparing();
        ProfileAdvertsView profileAdvertsView = profileAdvertsPresenterImpl.g;
        if (profileAdvertsView != null) {
            profileAdvertsPresenterImpl.w.startProfileAdvertsDraw();
            profileAdvertsView.showAdverts();
            profileAdvertsPresenterImpl.p.onDataSourceChanged(dataSource);
            profileAdvertsPresenterImpl.o.onDataSourceChanged(dataSource);
            profileAdvertsPresenterImpl.q.onDataSourceChanged(dataSource);
            profileAdvertsPresenterImpl.t.onDataSourceChanged(dataSource);
            profileAdvertsPresenterImpl.v.onDataSourceChanged(dataSource);
            profileAdvertsView.onDataChanged(profileAdvertsPresenterImpl);
            profileAdvertsPresenterImpl.w.trackProfileAdvertsDraw();
        }
    }

    public final boolean a() {
        return this.c == 0;
    }

    @Override // com.avito.android.public_profile.ProfileAdvertsPresenter
    public void attachRouter(@Nullable ProfileAdvertsPresenter.Router router) {
        this.h = router;
    }

    @Override // com.avito.android.public_profile.ProfileAdvertsPresenter
    public void attachView(@Nullable ProfileAdvertsView profileAdvertsView) {
        this.g = profileAdvertsView;
        int columnsCount = this.u.getColumnsCount();
        ProfileAdvertsView profileAdvertsView2 = this.g;
        if (profileAdvertsView2 != null) {
            profileAdvertsView2.setColumnsCount(columnsCount);
        }
        this.p.setColumnsCount(columnsCount);
        this.q.setColumnsCount(columnsCount);
        if (a()) {
            b();
        } else {
            c();
        }
        if (!a()) {
            PublicProfileAdvertsTracker publicProfileAdvertsTracker = this.w;
            publicProfileAdvertsTracker.restartSession();
            publicProfileAdvertsTracker.startProfileAdvertsLocalLoading();
            publicProfileAdvertsTracker.trackProfileAdvertsLoaded();
            publicProfileAdvertsTracker.startProfileAdvertsPreparing();
        }
        CompositeDisposable compositeDisposable = this.i;
        Disposable subscribe = this.x.subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "errorSnippetClicks.subsc…ateDataSource()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.i;
        Disposable subscribe2 = this.z.subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "profileAdvertsNeedReload…rofileAdverts()\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    public final void b() {
        ProfileAdvertsView profileAdvertsView;
        this.w.restartSession();
        this.w.startProfileAdvertsServerLoading();
        this.f = true;
        this.b = null;
        if (a() && (profileAdvertsView = this.g) != null) {
            profileAdvertsView.showProgress();
        }
        CompositeDisposable compositeDisposable = this.i;
        Disposable subscribe = ProfileAdvertsInteractor.DefaultImpls.loadProfileAdverts$default(this.m, this.j, this.k, this.c, null, this.l, 8, null).subscribeOn(this.n.io()).observeOn(this.n.mainThread()).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadProfileAd…or(it)\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void c() {
        int columnsCount = this.u.getColumnsCount();
        CompositeDisposable compositeDisposable = this.i;
        Disposable subscribe = this.r.convert(this.e, columnsCount, SerpDisplayType.Grid).observeOn(this.n.mainThread()).subscribe(new e(this, columnsCount), new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemProcessor.convert(el…ormat(it))\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public boolean canAppend() {
        if (this.a) {
            String str = this.b;
            if (str == null || str.length() == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.avito.android.public_profile.ProfileAdvertsPresenter
    public void detachRouter() {
        this.h = null;
    }

    @Override // com.avito.android.public_profile.ProfileAdvertsPresenter
    public void detachView() {
        this.w.stop();
        this.i.clear();
        this.g = null;
    }

    @Override // com.avito.android.serp.adapter.GroupingListener
    public void onAdditionalActionClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
    }

    @Override // com.avito.android.serp.adapter.AdvertItemListener
    public void onAdvertClicked(@NotNull AdvertItem advertItem, int i2, @Nullable Image image) {
        ProfileAdvertsPresenter.Router router;
        Intrinsics.checkNotNullParameter(advertItem, "advert");
        DeepLink deepLink = advertItem.getDeepLink();
        if (!(deepLink instanceof AdvertDetailsLink)) {
            deepLink = null;
        }
        AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink;
        if (advertDetailsLink != null && (router = this.h) != null) {
            router.openFastAdvertDetails(advertDetailsLink.getItemId(), advertDetailsLink.getContext(), advertItem.getTitle(), advertItem.getPrice(), advertItem.getPreviousPrice(), image, null, advertItem.isMarketplace());
        }
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public void onAppend() {
        if (!this.f) {
            String str = this.b;
            if (str == null || str.length() == 0) {
                b();
            }
        }
    }

    @Override // com.avito.android.favorite.FavoriteButtonClickListener
    public void onFavoriteButtonClicked(@NotNull FavorableItem favorableItem) {
        Intrinsics.checkNotNullParameter(favorableItem, "favorableItem");
        this.t.onFavoriteButtonClicked(favorableItem);
    }

    @Override // com.avito.android.advert.actions.MoreActionsClickListener
    public void onMoreActionsClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        ProfileAdvertsPresenter.DefaultImpls.onMoreActionsClicked(this, str);
    }

    @Override // com.avito.android.public_profile.ProfileAdvertsPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putBoolean("key_more_pages", Boolean.valueOf(this.a));
        kundle.putString("key_last_error_message", this.b);
        kundle.putInt("key_offset", Integer.valueOf(this.c));
        kundle.putString("key_disclaimer", this.d);
        kundle.putParcelableList("key_elements", this.e);
        return kundle;
    }
}
