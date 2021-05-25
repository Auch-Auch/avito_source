package com.avito.android.rating.user_reviews;

import a2.a.a.g2.f.e;
import a2.a.a.g2.f.f;
import a2.g.r.g;
import android.net.Uri;
import com.avito.android.analytics.Analytics;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.error_snippet.ErrorSnippetItem;
import com.avito.android.rating.details.adapter.loading.LoadingItem;
import com.avito.android.rating.details.adapter.loading.LoadingItemNextPageAction;
import com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItem;
import com.avito.android.rating.details.event.RatingDetailsGalleryOpenEvent;
import com.avito.android.rating.user_reviews.UserReviewsPresenter;
import com.avito.android.rating.user_reviews.adapter.placeholder.PlaceholderItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AvatarStatus;
import com.avito.android.remote.model.user_reviews.UserReviewsResult;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.user_review.UserReviewData;
import com.avito.android.util.Collections;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Uris;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.h;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bu\b\u0007\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010:\u001a\u000207\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b\u0012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020L0,\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010S\u001a\u00020P\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00020-0,\u0012\b\u0010X\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\bY\u0010ZJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\fJ\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017*\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010%R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010=R\u001e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020L0,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010/R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010OR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006["}, d2 = {"Lcom/avito/android/rating/user_reviews/UserReviewsPresenterImpl;", "Lcom/avito/android/rating/user_reviews/UserReviewsPresenter;", "Lcom/avito/android/rating/user_reviews/UserReviewsView;", "view", "", "attachView", "(Lcom/avito/android/rating/user_reviews/UserReviewsView;)V", "Lcom/avito/android/rating/user_reviews/UserReviewsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/user_reviews/UserReviewsPresenter$Router;)V", "detachRouter", "()V", "detachView", "onBackPressed", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/user_review/UserReviewData;", AvatarStatus.REVIEW, "onReviewDeleted", "(Lcom/avito/android/user_review/UserReviewData;)V", AuthSource.SEND_ABUSE, "", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", AuthSource.BOOKING_ORDER, "(Ljava/util/List;)Ljava/util/List;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "k", "Lcom/jakewharton/rxrelay3/PublishRelay;", "itemClickStream", "Lcom/avito/android/util/SchedulersFactory3;", "n", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "d", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/rating/user_reviews/UserReviewsPresenter$Router;", "Lcom/avito/android/error_helper/ErrorHelper;", "o", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/rating/details/adapter/loading/LoadingItemNextPageAction;", "r", "Lio/reactivex/rxjava3/core/Observable;", "loadingItemShown", "c", "disposables", "Landroid/net/Uri;", "f", "Landroid/net/Uri;", "nextPage", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "j", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "", g.a, "Z", "changed", "h", "isLoading", "e", "Ljava/util/List;", "items", "Lcom/avito/android/rating/user_reviews/UserReviewsInteractor;", "i", "Lcom/avito/android/rating/user_reviews/UserReviewsInteractor;", "interactor", "Lcom/avito/android/rating/user_reviews/ReviewItemConverter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/rating/user_reviews/ReviewItemConverter;", "converter", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "l", "galleryItemClicks", "Lcom/avito/android/rating/user_reviews/UserReviewsView;", "Lcom/avito/android/analytics/Analytics;", VKApiConst.Q, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/rating/user_reviews/ItemToReviewDataConverter;", "p", "Lcom/avito/android/rating/user_reviews/ItemToReviewDataConverter;", "reviewDataConverter", "state", "<init>", "(Lcom/avito/android/rating/user_reviews/UserReviewsInteractor;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/jakewharton/rxrelay3/PublishRelay;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/rating/user_reviews/ReviewItemConverter;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/rating/user_reviews/ItemToReviewDataConverter;Lcom/avito/android/analytics/Analytics;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/util/Kundle;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserReviewsPresenterImpl implements UserReviewsPresenter {
    public UserReviewsView a;
    public UserReviewsPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public List<? extends RatingDetailsItem> e;
    public Uri f;
    public boolean g;
    public boolean h;
    public final UserReviewsInteractor i;
    public final AdapterPresenter j;
    public final PublishRelay<RatingDetailsItem> k;
    public final Observable<TnsGalleryItemClickAction> l;
    public final ReviewItemConverter m;
    public final SchedulersFactory3 n;
    public final ErrorHelper o;
    public final ItemToReviewDataConverter p;
    public final Analytics q;
    public final Observable<LoadingItemNextPageAction> r;

    public static final class a<T> implements Consumer<RatingDetailsItem> {
        public final /* synthetic */ UserReviewsPresenterImpl a;

        public a(UserReviewsPresenterImpl userReviewsPresenterImpl) {
            this.a = userReviewsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(RatingDetailsItem ratingDetailsItem) {
            List access$withoutErrorSnippet;
            RatingDetailsItem ratingDetailsItem2 = ratingDetailsItem;
            if (ratingDetailsItem2 instanceof UserProfileCommentItem) {
                UserReviewData convert = this.a.p.convert((UserProfileCommentItem) ratingDetailsItem2);
                UserReviewsPresenter.Router router = this.a.b;
                if (router != null) {
                    router.openReviewDetails(convert);
                }
            } else if (ratingDetailsItem2 instanceof ErrorSnippetItem) {
                UserReviewsPresenterImpl userReviewsPresenterImpl = this.a;
                List list = userReviewsPresenterImpl.e;
                List list2 = null;
                if (!(list == null || (access$withoutErrorSnippet = UserReviewsPresenterImpl.access$withoutErrorSnippet(this.a, list)) == null || !(!access$withoutErrorSnippet.isEmpty()))) {
                    list2 = access$withoutErrorSnippet;
                }
                userReviewsPresenterImpl.e = list2;
                this.a.a();
            }
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ UserReviewsPresenterImpl a;

        public b(UserReviewsPresenterImpl userReviewsPresenterImpl) {
            this.a = userReviewsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            UserReviewsPresenter.Router router = this.a.b;
            if (router != null) {
                router.leaveScreen(this.a.g);
            }
        }
    }

    public static final class c<T> implements Consumer<TnsGalleryItemClickAction> {
        public final /* synthetic */ UserReviewsPresenterImpl a;

        public c(UserReviewsPresenterImpl userReviewsPresenterImpl) {
            this.a = userReviewsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TnsGalleryItemClickAction tnsGalleryItemClickAction) {
            TnsGalleryItemClickAction tnsGalleryItemClickAction2 = tnsGalleryItemClickAction;
            UserReviewsPresenter.Router router = this.a.b;
            if (router != null) {
                router.openGallery(tnsGalleryItemClickAction2.getImages(), tnsGalleryItemClickAction2.getIndex());
                this.a.q.track(new RatingDetailsGalleryOpenEvent(tnsGalleryItemClickAction2.getIndex()));
            }
        }
    }

    public static final class d<T> implements Consumer<LoadingItemNextPageAction> {
        public final /* synthetic */ UserReviewsPresenterImpl a;

        public d(UserReviewsPresenterImpl userReviewsPresenterImpl) {
            this.a = userReviewsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingItemNextPageAction loadingItemNextPageAction) {
            LoadingItemNextPageAction loadingItemNextPageAction2 = loadingItemNextPageAction;
            StringBuilder L = a2.b.a.a.a.L("loaded items using LoadingItem + ");
            L.append(this.a.h);
            Timber.d(L.toString(), new Object[0]);
            if (!this.a.h) {
                UserReviewsPresenterImpl userReviewsPresenterImpl = this.a;
                UserReviewsPresenterImpl.access$showResult(userReviewsPresenterImpl, UserReviewsPresenterImpl.access$loadItems(userReviewsPresenterImpl, loadingItemNextPageAction2.getNextPage()));
            }
        }
    }

    @Inject
    public UserReviewsPresenterImpl(@NotNull UserReviewsInteractor userReviewsInteractor, @NotNull AdapterPresenter adapterPresenter, @NotNull PublishRelay<RatingDetailsItem> publishRelay, @NotNull Observable<TnsGalleryItemClickAction> observable, @NotNull ReviewItemConverter reviewItemConverter, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ErrorHelper errorHelper, @NotNull ItemToReviewDataConverter itemToReviewDataConverter, @NotNull Analytics analytics, @NotNull Observable<LoadingItemNextPageAction> observable2, @Nullable Kundle kundle) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(userReviewsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(publishRelay, "itemClickStream");
        Intrinsics.checkNotNullParameter(observable, "galleryItemClicks");
        Intrinsics.checkNotNullParameter(reviewItemConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(itemToReviewDataConverter, "reviewDataConverter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(observable2, "loadingItemShown");
        this.i = userReviewsInteractor;
        this.j = adapterPresenter;
        this.k = publishRelay;
        this.l = observable;
        this.m = reviewItemConverter;
        this.n = schedulersFactory3;
        this.o = errorHelper;
        this.p = itemToReviewDataConverter;
        this.q = analytics;
        this.r = observable2;
        Uri uri = null;
        this.e = kundle != null ? kundle.getParcelableList("items") : null;
        this.f = kundle != null ? (Uri) kundle.getParcelable("next_page") : uri;
        this.g = (kundle == null || (bool = kundle.getBoolean("changed")) == null) ? false : bool.booleanValue();
    }

    public static final List access$emptyReviewsList(UserReviewsPresenterImpl userReviewsPresenterImpl) {
        Objects.requireNonNull(userReviewsPresenterImpl);
        return t6.n.d.listOf(new PlaceholderItem("1"));
    }

    public static final String access$getMessage(UserReviewsPresenterImpl userReviewsPresenterImpl, Throwable th) {
        return userReviewsPresenterImpl.o.recycle(th);
    }

    public static final boolean access$hasErrorSnippet(UserReviewsPresenterImpl userReviewsPresenterImpl, List list) {
        Objects.requireNonNull(userReviewsPresenterImpl);
        return (list != null ? (RatingDetailsItem) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list) : null) instanceof ErrorSnippetItem;
    }

    public static final Observable access$loadItems(UserReviewsPresenterImpl userReviewsPresenterImpl, Uri uri) {
        userReviewsPresenterImpl.h = true;
        if (uri == null) {
            List<? extends RatingDetailsItem> list = userReviewsPresenterImpl.e;
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            Observable just = Observable.just(list);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        }
        Observable<UserReviewsResult> doFinally = userReviewsPresenterImpl.i.getItems(uri).observeOn(userReviewsPresenterImpl.n.mainThread()).doFinally(new a2.a.a.g2.f.b(userReviewsPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(doFinally, "interactor.getItems(next…= false\n                }");
        Observable<UserReviewsResult> doOnNext = doFinally.doOnNext(new a2.a.a.g2.f.d(userReviewsPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "interactor.getItems(next…          .saveNextPage()");
        List<? extends RatingDetailsItem> list2 = userReviewsPresenterImpl.e;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        Observable<R> map = doOnNext.map(new a2.a.a.g2.f.c(userReviewsPresenterImpl, list2));
        Intrinsics.checkNotNullExpressionValue(map, "interactor.getItems(next…temsWith(items.orEmpty())");
        Observable<R> onErrorReturn = map.onErrorReturn(new a2.a.a.g2.f.a(userReviewsPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "interactor.getItems(next…           .handleError()");
        return onErrorReturn;
    }

    public static final void access$scrollToErrorIfNeeded(UserReviewsPresenterImpl userReviewsPresenterImpl, UserReviewsView userReviewsView) {
        List<? extends RatingDetailsItem> list = userReviewsPresenterImpl.e;
        if (list != null && (((RatingDetailsItem) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list)) instanceof ErrorSnippetItem)) {
            userReviewsView.scrollToPosition(CollectionsKt__CollectionsKt.getLastIndex(list));
        }
    }

    public static final Disposable access$showResult(UserReviewsPresenterImpl userReviewsPresenterImpl, Observable observable) {
        Objects.requireNonNull(userReviewsPresenterImpl);
        return observable.subscribe(new e(userReviewsPresenterImpl));
    }

    public static final List access$withErrorSnippet(UserReviewsPresenterImpl userReviewsPresenterImpl, List list, String str) {
        Objects.requireNonNull(userReviewsPresenterImpl);
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        h.removeAll(mutableList, (Function1) f.a);
        return CollectionsKt___CollectionsKt.plus((Collection<? extends ErrorSnippetItem>) mutableList, new ErrorSnippetItem("Error snippet Item id", str));
    }

    public static final List access$withoutErrorSnippet(UserReviewsPresenterImpl userReviewsPresenterImpl, List list) {
        Objects.requireNonNull(userReviewsPresenterImpl);
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        h.removeAll(mutableList, (Function1) f.a);
        return mutableList;
    }

    public final void a() {
        AdapterPresenter adapterPresenter = this.j;
        List<? extends RatingDetailsItem> list = this.e;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        a2.b.a.a.a.s1(list, adapterPresenter);
        UserReviewsView userReviewsView = this.a;
        if (userReviewsView != null) {
            userReviewsView.updateItems();
        }
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsPresenter
    public void attachRouter(@NotNull UserReviewsPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
        a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x006a, code lost:
        if (r4 != null) goto L_0x00a4;
     */
    @Override // com.avito.android.rating.user_reviews.UserReviewsPresenter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void attachView(@org.jetbrains.annotations.NotNull com.avito.android.rating.user_reviews.UserReviewsView r4) {
        /*
            r3 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r3.a = r4
            io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r3.d
            com.jakewharton.rxrelay3.PublishRelay<com.avito.android.rating.details.adapter.RatingDetailsItem> r1 = r3.k
            com.avito.android.rating.user_reviews.UserReviewsPresenterImpl$a r2 = new com.avito.android.rating.user_reviews.UserReviewsPresenterImpl$a
            r2.<init>(r3)
            io.reactivex.rxjava3.disposables.Disposable r1 = r1.subscribe(r2)
            java.lang.String r2 = "itemClickStream.subscrib…}\n            }\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            io.reactivex.rxjava3.kotlin.DisposableKt.plusAssign(r0, r1)
            io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r3.d
            io.reactivex.rxjava3.core.Observable r4 = r4.navigationClicks()
            com.avito.android.rating.user_reviews.UserReviewsPresenterImpl$b r1 = new com.avito.android.rating.user_reviews.UserReviewsPresenterImpl$b
            r1.<init>(r3)
            io.reactivex.rxjava3.disposables.Disposable r4 = r4.subscribe(r1)
            java.lang.String r1 = "view.navigationClicks().…Screen(changed)\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            io.reactivex.rxjava3.kotlin.DisposableKt.plusAssign(r0, r4)
            io.reactivex.rxjava3.disposables.CompositeDisposable r4 = r3.d
            io.reactivex.rxjava3.core.Observable<com.avito.android.tns_gallery.TnsGalleryItemClickAction> r0 = r3.l
            com.avito.android.rating.user_reviews.UserReviewsPresenterImpl$c r1 = new com.avito.android.rating.user_reviews.UserReviewsPresenterImpl$c
            r1.<init>(r3)
            io.reactivex.rxjava3.disposables.Disposable r0 = r0.subscribe(r1)
            java.lang.String r1 = "galleryItemClicks.subscr…)\n            }\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            io.reactivex.rxjava3.kotlin.DisposableKt.plusAssign(r4, r0)
            io.reactivex.rxjava3.disposables.CompositeDisposable r4 = r3.d
            io.reactivex.rxjava3.core.Observable<com.avito.android.rating.details.adapter.loading.LoadingItemNextPageAction> r0 = r3.r
            com.avito.android.rating.user_reviews.UserReviewsPresenterImpl$d r1 = new com.avito.android.rating.user_reviews.UserReviewsPresenterImpl$d
            r1.<init>(r3)
            io.reactivex.rxjava3.disposables.Disposable r0 = r0.subscribe(r1)
            java.lang.String r1 = "loadingItemShown.subscri…)\n            }\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            io.reactivex.rxjava3.kotlin.DisposableKt.plusAssign(r4, r0)
            java.util.List<? extends com.avito.android.rating.details.adapter.RatingDetailsItem> r4 = r3.e
            if (r4 == 0) goto L_0x006d
            io.reactivex.rxjava3.core.Observable r4 = io.reactivex.rxjava3.core.Observable.just(r4)
            java.lang.String r0 = "Observable.just(this)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            if (r4 == 0) goto L_0x006d
            goto L_0x00a4
        L_0x006d:
            com.avito.android.rating.user_reviews.UserReviewsInteractor r4 = r3.i
            io.reactivex.rxjava3.core.Observable r4 = r4.getItems()
            com.avito.android.util.SchedulersFactory3 r0 = r3.n
            java.lang.String r1 = "interactor.getItems()\n  …(schedulers.mainThread())"
            io.reactivex.rxjava3.core.Observable r4 = a2.b.a.a.a.b2(r0, r4, r1)
            a2.a.a.g2.f.d r0 = new a2.a.a.g2.f.d
            r0.<init>(r3)
            io.reactivex.rxjava3.core.Observable r4 = r4.doOnNext(r0)
            java.lang.String r0 = "interactor.getItems()\n  …          .saveNextPage()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            a2.a.a.g2.f.c r1 = new a2.a.a.g2.f.c
            r1.<init>(r3, r0)
            io.reactivex.rxjava3.core.Observable r4 = r4.map(r1)
            java.lang.String r0 = "interactor.getItems()\n  …rgeItemsWith(emptyList())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            a2.a.a.g2.f.a r0 = new a2.a.a.g2.f.a
            r0.<init>(r3)
            io.reactivex.rxjava3.core.Observable r4 = r4.onErrorReturn(r0)
        L_0x00a4:
            java.lang.String r0 = "loadItems()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            a2.a.a.g2.f.e r0 = new a2.a.a.g2.f.e
            r0.<init>(r3)
            r4.subscribe(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.rating.user_reviews.UserReviewsPresenterImpl.attachView(com.avito.android.rating.user_reviews.UserReviewsView):void");
    }

    public final List<RatingDetailsItem> b(List<? extends RatingDetailsItem> list) {
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (!(t instanceof LoadingItem)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsPresenter
    public void onBackPressed() {
        UserReviewsPresenter.Router router = this.b;
        if (router != null) {
            router.leaveScreen(this.g);
        }
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsPresenter
    public void onReviewDeleted(@NotNull UserReviewData userReviewData) {
        Intrinsics.checkNotNullParameter(userReviewData, AvatarStatus.REVIEW);
        List<? extends RatingDetailsItem> list = this.e;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (T t : list) {
            T t2 = t;
            boolean areEqual = t2 instanceof UserProfileCommentItem ? true ^ Intrinsics.areEqual(t2.getReviewId(), userReviewData.getId()) : true;
            if (!areEqual) {
                Uri uri = this.f;
                List<RatingDetailsItem> list2 = null;
                this.f = uri != null ? Uris.moveNextPageOffset(uri, -1) : null;
                List<? extends RatingDetailsItem> list3 = this.e;
                if (list3 != null) {
                    list2 = b(list3);
                    if (this.f != null) {
                        Uri uri2 = this.f;
                        Intrinsics.checkNotNull(uri2);
                        CollectionsKt___CollectionsKt.plus((Collection<? extends LoadingItem>) list2, new LoadingItem(uri2));
                    }
                }
                this.e = list2;
                z = true;
            }
            if (areEqual) {
                arrayList.add(t);
            }
        }
        this.e = arrayList;
        if (z) {
            if (Collections.isNullOrEmpty(arrayList)) {
                this.e = t6.n.d.listOf(new PlaceholderItem("1"));
                a();
            } else {
                AdapterPresenter adapterPresenter = this.j;
                List<? extends RatingDetailsItem> list4 = this.e;
                if (list4 == null) {
                    list4 = CollectionsKt__CollectionsKt.emptyList();
                }
                a2.b.a.a.a.s1(list4, adapterPresenter);
                UserReviewsView userReviewsView = this.a;
                if (userReviewsView != null) {
                    userReviewsView.notifyItemsChanged();
                }
            }
            UserReviewsView userReviewsView2 = this.a;
            if (userReviewsView2 != null) {
                userReviewsView2.showToolbar();
                userReviewsView2.showReviewDeletedMessage();
            }
            this.g = true;
        }
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("next_page", this.f).putParcelableList("items", this.e).putBoolean("changed", Boolean.valueOf(this.g));
    }
}
