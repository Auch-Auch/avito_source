package com.avito.android.rating.publish.select_advert;

import android.net.Uri;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.loading.LoadingItem;
import com.avito.android.rating.details.adapter.loading.LoadingItemNextPageAction;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.select_advert.SelectAdvertPresenter;
import com.avito.android.rating.publish.select_advert.adapter.SelectAdvertAction;
import com.avito.android.rating.publish.select_advert.adapter.error_snippet.ErrorSnippetItem;
import com.avito.android.rating.publish.select_advert.tracker.SelectAdvertTracker;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.publish.SearchUserAdvertsResult;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Observables;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bo\b\u0007\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010P\u001a\u00020M\u0012\u0006\u0010\\\u001a\u00020Y\u0012\f\u0010=\u001a\b\u0012\u0004\u0012\u00020:0\u0002\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u00101\u001a\u00020.\u0012\f\u0010D\u001a\b\u0012\u0004\u0012\u00020B0\u0002\u0012\b\u0010]\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b^\u0010_J1\u0010\b\u001a\u0014 \u0007*\t\u0018\u00010\u0005¢\u0006\u0002\b\u00060\u0005¢\u0006\u0002\b\u0006*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJK\u0010\r\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0007*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003 \u0007*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0007*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\fJ\u000f\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u00109R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020:0\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020B0\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010<R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010IR\u0016\u0010L\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u00103R\u0016\u0010X\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010KR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006`"}, d2 = {"Lcom/avito/android/rating/publish/select_advert/SelectAdvertPresenterImpl;", "Lcom/avito/android/rating/publish/select_advert/SelectAdvertPresenter;", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/annotations/NonNull;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "(Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/disposables/Disposable;", "", "c", "()V", AuthSource.SEND_ABUSE, "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/rating/publish/select_advert/SelectAdvertView;", "view", "attachView", "(Lcom/avito/android/rating/publish/select_advert/SelectAdvertView;)V", "Lcom/avito/android/rating/publish/select_advert/SelectAdvertPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/publish/select_advert/SelectAdvertPresenter$Router;)V", "detachRouter", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "backPressHandled", "()Z", "Lcom/avito/android/rating/publish/StepListener;", "j", "Lcom/avito/android/rating/publish/StepListener;", "stepListener", "Lcom/avito/android/util/SchedulersFactory3;", "n", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "e", "Ljava/util/List;", "items", "", a2.g.r.g.a, "Ljava/lang/String;", "query", "Lcom/avito/android/rating/publish/select_advert/tracker/SelectAdvertTracker;", "r", "Lcom/avito/android/rating/publish/select_advert/tracker/SelectAdvertTracker;", "tracker", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/ratings/RatingPublishData;", "p", "Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "Lcom/avito/android/rating/publish/select_advert/SelectAdvertView;", "Lcom/avito/android/rating/publish/select_advert/adapter/SelectAdvertAction;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/rxjava3/core/Observable;", "actionStream", "Lcom/avito/android/rating/publish/RatingPublishViewData;", VKApiConst.Q, "Lcom/avito/android/rating/publish/RatingPublishViewData;", "ratingViewData", "Lcom/avito/android/rating/details/adapter/loading/LoadingItemNextPageAction;", "s", "loadingItemShown", "Lcom/avito/android/error_helper/ErrorHelper;", "o", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "Lcom/avito/android/rating/publish/select_advert/SelectAdvertPresenter$Router;", "i", "Z", "isLoading", "Lcom/avito/android/rating/publish/select_advert/SelectAdvertInteractor;", "k", "Lcom/avito/android/rating/publish/select_advert/SelectAdvertInteractor;", "interactor", "Landroid/net/Uri;", "f", "Landroid/net/Uri;", "nextPage", "d", "viewDisposables", "h", "searchInputShown", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "l", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "state", "<init>", "(Lcom/avito/android/rating/publish/StepListener;Lcom/avito/android/rating/publish/select_advert/SelectAdvertInteractor;Lcom/avito/konveyor/adapter/AdapterPresenter;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/ratings/RatingPublishData;Lcom/avito/android/rating/publish/RatingPublishViewData;Lcom/avito/android/rating/publish/select_advert/tracker/SelectAdvertTracker;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/util/Kundle;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class SelectAdvertPresenterImpl implements SelectAdvertPresenter {
    public SelectAdvertView a;
    public SelectAdvertPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public List<? extends RatingDetailsItem> e;
    public Uri f;
    public String g;
    public boolean h;
    public boolean i;
    public final StepListener j;
    public final SelectAdvertInteractor k;
    public final AdapterPresenter l;
    public final Observable<SelectAdvertAction> m;
    public final SchedulersFactory3 n;
    public final ErrorHelper o;
    public final RatingPublishData p;
    public final RatingPublishViewData q;
    public final SelectAdvertTracker r;
    public final Observable<LoadingItemNextPageAction> s;

    public static final class a<T> implements Consumer<SelectAdvertAction> {
        public final /* synthetic */ SelectAdvertPresenterImpl a;

        public a(SelectAdvertPresenterImpl selectAdvertPresenterImpl) {
            this.a = selectAdvertPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SelectAdvertAction selectAdvertAction) {
            SelectAdvertAction selectAdvertAction2 = selectAdvertAction;
            if (selectAdvertAction2 instanceof SelectAdvertAction.AdvertItemClick) {
                this.a.p.setItemId(((SelectAdvertAction.AdvertItemClick) selectAdvertAction2).getAdvertItem().getSummary().getItemId());
                this.a.q.setItemId(this.a.p.getItemId());
                this.a.j.onStepDataProvided(this.a.p, this.a.q, true);
            } else if (selectAdvertAction2 instanceof SelectAdvertAction.RefreshClick) {
                SelectAdvertPresenterImpl.access$retryLoad(this.a);
            }
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ SelectAdvertPresenterImpl a;

        public b(SelectAdvertPresenterImpl selectAdvertPresenterImpl) {
            this.a = selectAdvertPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            SelectAdvertPresenter.Router router;
            if (!this.a.backPressHandled() && (router = this.a.b) != null) {
                router.closeScreen();
            }
        }
    }

    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ SelectAdvertPresenterImpl a;
        public final /* synthetic */ SelectAdvertView b;

        public c(SelectAdvertPresenterImpl selectAdvertPresenterImpl, SelectAdvertView selectAdvertView) {
            this.a = selectAdvertPresenterImpl;
            this.b = selectAdvertView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.h = true;
            this.b.showSearchInputState(true);
        }
    }

    public static final class d<T> implements Consumer<String> {
        public final /* synthetic */ SelectAdvertPresenterImpl a;

        public d(SelectAdvertPresenterImpl selectAdvertPresenterImpl) {
            this.a = selectAdvertPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            SelectAdvertPresenterImpl selectAdvertPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            SelectAdvertPresenterImpl.access$searchItems(selectAdvertPresenterImpl, str2);
        }
    }

    public static final class e extends Lambda implements Function1<LoadingItemNextPageAction, Boolean> {
        public final /* synthetic */ SelectAdvertPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(SelectAdvertPresenterImpl selectAdvertPresenterImpl) {
            super(1);
            this.a = selectAdvertPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(LoadingItemNextPageAction loadingItemNextPageAction) {
            Intrinsics.checkNotNullParameter(loadingItemNextPageAction, "it");
            return Boolean.valueOf(this.a.i);
        }
    }

    public static final class f<T> implements Consumer<LoadingItemNextPageAction> {
        public final /* synthetic */ SelectAdvertPresenterImpl a;

        public f(SelectAdvertPresenterImpl selectAdvertPresenterImpl) {
            this.a = selectAdvertPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingItemNextPageAction loadingItemNextPageAction) {
            this.a.f = loadingItemNextPageAction.getNextPage();
            SelectAdvertPresenterImpl selectAdvertPresenterImpl = this.a;
            selectAdvertPresenterImpl.b(SelectAdvertPresenterImpl.access$loadItems(selectAdvertPresenterImpl, selectAdvertPresenterImpl.f));
        }
    }

    public static final class g<T> implements Consumer<List<? extends RatingDetailsItem>> {
        public final /* synthetic */ SelectAdvertPresenterImpl a;

        public g(SelectAdvertPresenterImpl selectAdvertPresenterImpl) {
            this.a = selectAdvertPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends RatingDetailsItem> list) {
            this.a.r.trackLoading();
            this.a.r.startDraw();
            this.a.e = list;
            this.a.c();
            SelectAdvertView selectAdvertView = this.a.a;
            if (selectAdvertView != null) {
                SelectAdvertPresenterImpl.access$scrollToErrorIfNeeded(this.a, selectAdvertView);
            }
            this.a.r.trackDraw();
        }
    }

    @Inject
    public SelectAdvertPresenterImpl(@NotNull StepListener stepListener, @NotNull SelectAdvertInteractor selectAdvertInteractor, @NotNull AdapterPresenter adapterPresenter, @NotNull Observable<SelectAdvertAction> observable, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ErrorHelper errorHelper, @NotNull RatingPublishData ratingPublishData, @NotNull RatingPublishViewData ratingPublishViewData, @NotNull SelectAdvertTracker selectAdvertTracker, @NotNull Observable<LoadingItemNextPageAction> observable2, @Nullable Kundle kundle) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(stepListener, "stepListener");
        Intrinsics.checkNotNullParameter(selectAdvertInteractor, "interactor");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(observable, "actionStream");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(ratingPublishData, "ratingData");
        Intrinsics.checkNotNullParameter(ratingPublishViewData, "ratingViewData");
        Intrinsics.checkNotNullParameter(selectAdvertTracker, "tracker");
        Intrinsics.checkNotNullParameter(observable2, "loadingItemShown");
        this.j = stepListener;
        this.k = selectAdvertInteractor;
        this.l = adapterPresenter;
        this.m = observable;
        this.n = schedulersFactory3;
        this.o = errorHelper;
        this.p = ratingPublishData;
        this.q = ratingPublishViewData;
        this.r = selectAdvertTracker;
        this.s = observable2;
        String str = null;
        this.e = kundle != null ? kundle.getParcelableList("items") : null;
        this.f = kundle != null ? (Uri) kundle.getParcelable("next_page") : null;
        this.g = kundle != null ? kundle.getString("select_advert_query") : str;
        this.h = (kundle == null || (bool = kundle.getBoolean("search_input_shown")) == null) ? false : bool.booleanValue();
    }

    public static final String access$getMessage(SelectAdvertPresenterImpl selectAdvertPresenterImpl, Throwable th) {
        return selectAdvertPresenterImpl.o.recycle(th);
    }

    public static final Observable access$loadItems(SelectAdvertPresenterImpl selectAdvertPresenterImpl, Uri uri) {
        selectAdvertPresenterImpl.i = true;
        if (uri == null) {
            List<? extends RatingDetailsItem> list = selectAdvertPresenterImpl.e;
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            Observable just = Observable.just(list);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        }
        Observable<SearchUserAdvertsResult> doFinally = selectAdvertPresenterImpl.k.loadItems(uri).observeOn(selectAdvertPresenterImpl.n.mainThread()).doFinally(new a2.a.a.g2.b.l.b(selectAdvertPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(doFinally, "interactor.loadItems(nex…lly { isLoading = false }");
        Observable<SearchUserAdvertsResult> doOnNext = doFinally.doOnNext(new a2.a.a.g2.b.l.d(selectAdvertPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "interactor.loadItems(nex…          .saveNextPage()");
        List<? extends RatingDetailsItem> list2 = selectAdvertPresenterImpl.e;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        Observable<R> map = doOnNext.map(new a2.a.a.g2.b.l.c(selectAdvertPresenterImpl, list2));
        Intrinsics.checkNotNullExpressionValue(map, "interactor.loadItems(nex…temsWith(items.orEmpty())");
        Observable<R> onErrorReturn = map.onErrorReturn(new a2.a.a.g2.b.l.a(selectAdvertPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "interactor.loadItems(nex…           .handleError()");
        return onErrorReturn;
    }

    public static final void access$retryLoad(SelectAdvertPresenterImpl selectAdvertPresenterImpl) {
        List<? extends RatingDetailsItem> list = selectAdvertPresenterImpl.e;
        List<? extends RatingDetailsItem> list2 = null;
        if (list != null) {
            List<? extends RatingDetailsItem> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
            h.removeAll((List) mutableList, (Function1) a2.a.a.g2.b.l.e.a);
            if (mutableList != null && (!mutableList.isEmpty())) {
                list2 = mutableList;
            }
        }
        selectAdvertPresenterImpl.e = list2;
        selectAdvertPresenterImpl.c();
    }

    public static final void access$scrollToErrorIfNeeded(SelectAdvertPresenterImpl selectAdvertPresenterImpl, SelectAdvertView selectAdvertView) {
        List<? extends RatingDetailsItem> list = selectAdvertPresenterImpl.e;
        if (list != null && (((RatingDetailsItem) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list)) instanceof ErrorSnippetItem)) {
            selectAdvertView.scrollToPosition(CollectionsKt__CollectionsKt.getLastIndex(list));
        }
    }

    public static final void access$searchItems(SelectAdvertPresenterImpl selectAdvertPresenterImpl, String str) {
        String str2 = selectAdvertPresenterImpl.g;
        if (str2 == null) {
            str2 = "";
        }
        if (!Intrinsics.areEqual(str, str2)) {
            selectAdvertPresenterImpl.c.clear();
            selectAdvertPresenterImpl.g = str;
            selectAdvertPresenterImpl.e = null;
            CompositeDisposable compositeDisposable = selectAdvertPresenterImpl.c;
            Observable<List<RatingDetailsItem>> a3 = selectAdvertPresenterImpl.a();
            Intrinsics.checkNotNullExpressionValue(a3, "loadItems()");
            Disposable b2 = selectAdvertPresenterImpl.b(a3);
            Intrinsics.checkNotNullExpressionValue(b2, "loadItems()\n            .showResult()");
            DisposableKt.plusAssign(compositeDisposable, b2);
        }
    }

    public static final List access$withErrorSnippet(SelectAdvertPresenterImpl selectAdvertPresenterImpl, List list, String str) {
        Objects.requireNonNull(selectAdvertPresenterImpl);
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        h.removeAll(mutableList, (Function1) a2.a.a.g2.b.l.e.a);
        return CollectionsKt___CollectionsKt.plus((Collection<? extends ErrorSnippetItem>) mutableList, new ErrorSnippetItem("ErrorSnippetItem", str));
    }

    public static final List access$withoutLoadingItem(SelectAdvertPresenterImpl selectAdvertPresenterImpl, List list) {
        Objects.requireNonNull(selectAdvertPresenterImpl);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!(((RatingDetailsItem) obj) instanceof LoadingItem)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final Observable<List<RatingDetailsItem>> a() {
        List<? extends RatingDetailsItem> list = this.e;
        if (list != null) {
            Observable<List<RatingDetailsItem>> just = Observable.just(list);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            if (just != null) {
                return just;
            }
        }
        Observable doOnNext = a2.b.a.a.a.b2(this.n, this.k.loadItems(this.g), "interactor.loadItems(que…(schedulers.mainThread())").doOnNext(new a2.a.a.g2.b.l.d(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "interactor.loadItems(que…          .saveNextPage()");
        Observable map = doOnNext.map(new a2.a.a.g2.b.l.c(this, CollectionsKt__CollectionsKt.emptyList()));
        Intrinsics.checkNotNullExpressionValue(map, "interactor.loadItems(que…rgeItemsWith(emptyList())");
        return map.onErrorReturn(new a2.a.a.g2.b.l.a(this));
    }

    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertPresenter
    public void attachRouter(@NotNull SelectAdvertPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertPresenter
    public void attachView(@NotNull SelectAdvertView selectAdvertView) {
        Intrinsics.checkNotNullParameter(selectAdvertView, "view");
        this.a = selectAdvertView;
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.m.subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "actionStream.subscribe {…}\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = selectAdvertView.navigationClicks().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.navigationClicks().…)\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = selectAdvertView.searchButtonClicks().subscribe(new c(this, selectAdvertView));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.searchButtonClicks(…nputState(true)\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        selectAdvertView.setQuery(this.g);
        if (this.h) {
            selectAdvertView.showSearchInputState(true);
        }
        CompositeDisposable compositeDisposable4 = this.d;
        Disposable subscribe4 = selectAdvertView.queryStream().subscribe(new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.queryStream().subsc…searchItems(it)\n        }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.d;
        Disposable subscribe5 = Observables.filterNot(this.s, new e(this)).subscribe(new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe5, "loadingItemShown.filterN…e).showResult()\n        }");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
        this.r.startLoading();
        CompositeDisposable compositeDisposable6 = this.c;
        Observable<List<RatingDetailsItem>> a3 = a();
        Intrinsics.checkNotNullExpressionValue(a3, "loadItems()");
        Disposable b2 = b(a3);
        Intrinsics.checkNotNullExpressionValue(b2, "loadItems().showResult()");
        DisposableKt.plusAssign(compositeDisposable6, b2);
    }

    public final Disposable b(Observable<List<RatingDetailsItem>> observable) {
        return observable.subscribe(new g(this));
    }

    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertPresenter
    public boolean backPressHandled() {
        if (!this.h) {
            return false;
        }
        this.h = false;
        SelectAdvertView selectAdvertView = this.a;
        if (selectAdvertView != null) {
            selectAdvertView.showSearchInputState(false);
        }
        SelectAdvertView selectAdvertView2 = this.a;
        if (selectAdvertView2 != null) {
            selectAdvertView2.setQuery(null);
        }
        return true;
    }

    public final void c() {
        SelectAdvertView selectAdvertView = this.a;
        if (selectAdvertView != null) {
            List<? extends RatingDetailsItem> list = this.e;
            boolean z = true;
            if (list == null || !list.isEmpty()) {
                z = false;
            }
            selectAdvertView.showEmptyState(z);
        }
        AdapterPresenter adapterPresenter = this.l;
        List<? extends RatingDetailsItem> list2 = this.e;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        a2.b.a.a.a.s1(list2, adapterPresenter);
        SelectAdvertView selectAdvertView2 = this.a;
        if (selectAdvertView2 != null) {
            selectAdvertView2.notifyItemsChanged();
        }
    }

    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelableList("items", this.e).putParcelable("next_page", this.f).putString("select_advert_query", this.g).putBoolean("search_input_shown", Boolean.valueOf(this.h));
    }
}
