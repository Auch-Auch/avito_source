package com.avito.android.rating.details;

import android.net.Uri;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.rating.details.RatingDetailsPresenter;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.action.ActionItem;
import com.avito.android.rating.details.adapter.button.ButtonItem;
import com.avito.android.rating.details.adapter.error_snippet.ErrorSnippetItem;
import com.avito.android.rating.details.adapter.info.InfoItem;
import com.avito.android.rating.details.adapter.loading.LoadingItem;
import com.avito.android.rating.details.adapter.loading.LoadingItemNextPageAction;
import com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItem;
import com.avito.android.rating.details.event.RatingDetailsGalleryOpenEvent;
import com.avito.android.rating.review_details.upload.ReviewReplyObserver;
import com.avito.android.rating.review_details.upload.ReviewReplyProvider;
import com.avito.android.rating.review_details.upload.ReviewReplyState;
import com.avito.android.ratings.ReviewData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.rating_details.RatingDetailsResult;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Maybies;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0001\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010K\u001a\u00020H\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u0002090=\u0012\f\u0010d\u001a\b\u0012\u0004\u0012\u00020b0+\u0012\u0006\u0010a\u001a\u00020^\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u00107\u001a\u000204\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\be\u0010fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001e\u0010<\u001a\n\u0012\u0004\u0012\u000209\u0018\u0001088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u0002090=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010ER\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010U\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010RR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010]\u001a\u00020V8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010XR\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020b0+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010.¨\u0006g"}, d2 = {"Lcom/avito/android/rating/details/RatingDetailsPresenterImpl;", "Lcom/avito/android/rating/details/RatingDetailsPresenter;", "Lcom/avito/android/rating/review_details/upload/ReviewReplyObserver;", "", AuthSource.SEND_ABUSE, "()V", "Lcom/avito/android/rating/details/RatingDetailsView;", "view", "attachView", "(Lcom/avito/android/rating/details/RatingDetailsView;)V", "detachView", "Lcom/avito/android/rating/details/RatingDetailsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/details/RatingDetailsPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/rating/review_details/upload/ReviewReplyState;", "state", "applyReviewReplyState", "(Lcom/avito/android/rating/review_details/upload/ReviewReplyState;)V", "Lcom/avito/android/rating/details/RatingDetailsInteractor;", "k", "Lcom/avito/android/rating/details/RatingDetailsInteractor;", "interactor", "Lcom/avito/android/rating/review_details/upload/ReviewReplyProvider;", "s", "Lcom/avito/android/rating/review_details/upload/ReviewReplyProvider;", "reviewReplyProvider", "Lcom/avito/android/Features;", "t", "Lcom/avito/android/Features;", "features", "Landroid/net/Uri;", "f", "Landroid/net/Uri;", "nextPage", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "l", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/rating/details/adapter/loading/LoadingItemNextPageAction;", VKApiConst.VERSION, "Lio/reactivex/rxjava3/core/Observable;", "loadingItemShown", "Lcom/avito/android/dialog/DialogPresenter;", "r", "Lcom/avito/android/dialog/DialogPresenter;", "dialogPresenter", "Lcom/avito/android/analytics/Analytics;", "u", "Lcom/avito/android/analytics/Analytics;", "analytics", "", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "e", "Ljava/util/List;", "items", "Lcom/jakewharton/rxrelay3/PublishRelay;", "n", "Lcom/jakewharton/rxrelay3/PublishRelay;", "itemClicks", "d", "Lcom/avito/android/rating/details/RatingDetailsPresenter$Router;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "clicksDisposables", "disposables", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/rating/details/RatingDetailsConverter;", VKApiConst.Q, "Lcom/avito/android/rating/details/RatingDetailsConverter;", "converter", "Lcom/avito/android/remote/model/Action;", "h", "Lcom/avito/android/remote/model/Action;", "reviewAction", a2.g.r.g.a, "action", "", "i", "Z", "canCommentButtonBeShown", "c", "Lcom/avito/android/rating/details/RatingDetailsView;", "j", "isLoading", "Lcom/avito/android/util/ErrorFormatter;", "p", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "o", "galleryItemClicks", "<init>", "(Lcom/avito/android/rating/details/RatingDetailsInteractor;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/util/SchedulersFactory3;Lcom/jakewharton/rxrelay3/PublishRelay;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/util/ErrorFormatter;Lcom/avito/android/rating/details/RatingDetailsConverter;Lcom/avito/android/dialog/DialogPresenter;Lcom/avito/android/rating/review_details/upload/ReviewReplyProvider;Lcom/avito/android/Features;Lcom/avito/android/analytics/Analytics;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/util/Kundle;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingDetailsPresenterImpl implements RatingDetailsPresenter, ReviewReplyObserver {
    public final CompositeDisposable a;
    public final CompositeDisposable b;
    public RatingDetailsView c;
    public RatingDetailsPresenter.Router d;
    public List<? extends RatingDetailsItem> e;
    public Uri f;
    public Action g;
    public Action h;
    public boolean i;
    public boolean j;
    public final RatingDetailsInteractor k;
    public final AdapterPresenter l;
    public final SchedulersFactory3 m;
    public final PublishRelay<RatingDetailsItem> n;
    public final Observable<TnsGalleryItemClickAction> o;
    public final ErrorFormatter p;
    public final RatingDetailsConverter q;
    public final DialogPresenter r;
    public final ReviewReplyProvider s;
    public final Features t;
    public final Analytics u;
    public final Observable<LoadingItemNextPageAction> v;

    /* compiled from: java-style lambda group */
    public static final class a<T, R> implements Function<Unit, MaybeSource<? extends Action>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public final MaybeSource<? extends Action> apply(Unit unit) {
            int i = this.a;
            if (i == 0) {
                return Maybies.toMaybe(((RatingDetailsPresenterImpl) this.b).g);
            }
            if (i == 1) {
                return Maybies.toMaybe(((RatingDetailsPresenterImpl) this.b).h);
            }
            throw null;
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

    public static final class c<T> implements Consumer<TnsGalleryItemClickAction> {
        public final /* synthetic */ RatingDetailsPresenterImpl a;

        public c(RatingDetailsPresenterImpl ratingDetailsPresenterImpl) {
            this.a = ratingDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TnsGalleryItemClickAction tnsGalleryItemClickAction) {
            TnsGalleryItemClickAction tnsGalleryItemClickAction2 = tnsGalleryItemClickAction;
            RatingDetailsPresenter.Router router = this.a.d;
            if (router != null) {
                router.openGallery(tnsGalleryItemClickAction2.getImages(), tnsGalleryItemClickAction2.getIndex());
                this.a.u.track(new RatingDetailsGalleryOpenEvent(tnsGalleryItemClickAction2.getIndex()));
            }
        }
    }

    public static final class d<T> implements Consumer<LoadingItemNextPageAction> {
        public final /* synthetic */ RatingDetailsPresenterImpl a;

        public d(RatingDetailsPresenterImpl ratingDetailsPresenterImpl) {
            this.a = ratingDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingItemNextPageAction loadingItemNextPageAction) {
            LoadingItemNextPageAction loadingItemNextPageAction2 = loadingItemNextPageAction;
            if (!this.a.j) {
                RatingDetailsPresenterImpl ratingDetailsPresenterImpl = this.a;
                RatingDetailsPresenterImpl.access$showResult(ratingDetailsPresenterImpl, RatingDetailsPresenterImpl.access$loadItems(ratingDetailsPresenterImpl, loadingItemNextPageAction2.getNextPage()));
            }
        }
    }

    public static final class e<T> implements Consumer<Unit> {
        public final /* synthetic */ RatingDetailsPresenterImpl a;

        public e(RatingDetailsPresenterImpl ratingDetailsPresenterImpl) {
            this.a = ratingDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            RatingDetailsPresenter.Router router = this.a.d;
            if (router != null) {
                router.close();
            }
        }
    }

    public static final class f<T> implements Consumer<RatingDetailsItem> {
        public final /* synthetic */ RatingDetailsPresenterImpl a;

        public f(RatingDetailsPresenterImpl ratingDetailsPresenterImpl) {
            this.a = ratingDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(RatingDetailsItem ratingDetailsItem) {
            RatingDetailsPresenter.Router router;
            List access$withoutErrorSnippet;
            RatingDetailsItem ratingDetailsItem2 = ratingDetailsItem;
            if (ratingDetailsItem2 instanceof ActionItem) {
                RatingDetailsPresenter.Router router2 = this.a.d;
                if (router2 != null) {
                    router2.followDeepLink(((ActionItem) ratingDetailsItem2).getDeepLink());
                }
            } else if (ratingDetailsItem2 instanceof ButtonItem) {
                RatingDetailsPresenter.Router router3 = this.a.d;
                if (router3 != null) {
                    router3.followDeepLink(((ButtonItem) ratingDetailsItem2).getDeepLink());
                    router3.close();
                }
            } else if (ratingDetailsItem2 instanceof ErrorSnippetItem) {
                RatingDetailsPresenterImpl ratingDetailsPresenterImpl = this.a;
                List list = ratingDetailsPresenterImpl.e;
                List list2 = null;
                if (!(list == null || (access$withoutErrorSnippet = RatingDetailsPresenterImpl.access$withoutErrorSnippet(this.a, list)) == null || !(!access$withoutErrorSnippet.isEmpty()))) {
                    list2 = access$withoutErrorSnippet;
                }
                ratingDetailsPresenterImpl.e = list2;
                RatingDetailsPresenterImpl.access$updateItems(this.a);
            } else if (ratingDetailsItem2 instanceof InfoItem) {
                InfoItem.Hint hint = ((InfoItem) ratingDetailsItem2).getHint();
                if (hint != null && (router = this.a.d) != null) {
                    router.showInfoHintDialog(hint);
                }
            } else if (ratingDetailsItem2 instanceof UserProfileCommentItem) {
                UserProfileCommentItem userProfileCommentItem = (UserProfileCommentItem) ratingDetailsItem2;
                ReviewData reviewData = new ReviewData(userProfileCommentItem.getReviewId(), userProfileCommentItem.getScore(), userProfileCommentItem.getAvatar(), userProfileCommentItem.getName(), userProfileCommentItem.getMessage(), userProfileCommentItem.getStage(), userProfileCommentItem.getItem(), userProfileCommentItem.getPublicationDate(), userProfileCommentItem.getCanReply(), userProfileCommentItem.getReply(), userProfileCommentItem.getImages());
                RatingDetailsPresenter.Router router4 = this.a.d;
                if (router4 != null) {
                    router4.openReviewDetailsScreen(reviewData);
                }
            }
        }
    }

    public static final class g extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ RatingDetailsPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(RatingDetailsPresenterImpl ratingDetailsPresenterImpl) {
            super(0);
            this.a = ratingDetailsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            return Boolean.valueOf(this.a.f != null);
        }
    }

    public static final class h<T> implements Consumer<Boolean> {
        public final /* synthetic */ RatingDetailsPresenterImpl a;

        public h(RatingDetailsPresenterImpl ratingDetailsPresenterImpl) {
            this.a = ratingDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            RatingDetailsPresenterImpl ratingDetailsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(bool2, "canBeShown");
            ratingDetailsPresenterImpl.i = bool2.booleanValue();
            RatingDetailsPresenterImpl.access$updateCommentButton(this.a);
        }
    }

    public static final class i<T, R> implements Function<Action, MaybeSource<? extends DeepLink>> {
        public final /* synthetic */ RatingDetailsPresenterImpl a;

        public i(RatingDetailsPresenterImpl ratingDetailsPresenterImpl) {
            this.a = ratingDetailsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MaybeSource<? extends DeepLink> apply(Action action) {
            Action action2 = action;
            DialogPresenter dialogPresenter = this.a.r;
            Intrinsics.checkNotNullExpressionValue(action2, "it");
            return dialogPresenter.wrapActionToDialog(action2);
        }
    }

    public static final class j<T> implements Consumer<DeepLink> {
        public final /* synthetic */ RatingDetailsPresenterImpl a;

        public j(RatingDetailsPresenterImpl ratingDetailsPresenterImpl) {
            this.a = ratingDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            RatingDetailsPresenter.Router router = this.a.d;
            if (router != null) {
                Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
                router.followDeepLink(deepLink2);
            }
        }
    }

    public static final class k<T> implements Consumer<Action> {
        public final /* synthetic */ RatingDetailsPresenterImpl a;

        public k(RatingDetailsPresenterImpl ratingDetailsPresenterImpl) {
            this.a = ratingDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Action action) {
            Action action2 = action;
            this.a.u.track(new CopyReviewLinkEvent());
            RatingDetailsPresenter.Router router = this.a.d;
            if (router != null) {
                router.followDeepLink(action2.getDeepLink());
            }
        }
    }

    @Inject
    public RatingDetailsPresenterImpl(@NotNull RatingDetailsInteractor ratingDetailsInteractor, @NotNull AdapterPresenter adapterPresenter, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull PublishRelay<RatingDetailsItem> publishRelay, @NotNull Observable<TnsGalleryItemClickAction> observable, @NotNull ErrorFormatter errorFormatter, @NotNull RatingDetailsConverter ratingDetailsConverter, @NotNull DialogPresenter dialogPresenter, @NotNull ReviewReplyProvider reviewReplyProvider, @NotNull Features features, @NotNull Analytics analytics, @NotNull Observable<LoadingItemNextPageAction> observable2, @Nullable Kundle kundle) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(ratingDetailsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(publishRelay, "itemClicks");
        Intrinsics.checkNotNullParameter(observable, "galleryItemClicks");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(ratingDetailsConverter, "converter");
        Intrinsics.checkNotNullParameter(dialogPresenter, "dialogPresenter");
        Intrinsics.checkNotNullParameter(reviewReplyProvider, "reviewReplyProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(observable2, "loadingItemShown");
        this.k = ratingDetailsInteractor;
        this.l = adapterPresenter;
        this.m = schedulersFactory3;
        this.n = publishRelay;
        this.o = observable;
        this.p = errorFormatter;
        this.q = ratingDetailsConverter;
        this.r = dialogPresenter;
        this.s = reviewReplyProvider;
        this.t = features;
        this.u = analytics;
        this.v = observable2;
        this.a = new CompositeDisposable();
        this.b = new CompositeDisposable();
        Action action = null;
        this.e = kundle != null ? kundle.getParcelableList("items") : null;
        this.f = kundle != null ? (Uri) kundle.getParcelable("next_page") : null;
        this.g = kundle != null ? (Action) kundle.getParcelable("action") : null;
        this.h = kundle != null ? (Action) kundle.getParcelable("review_action") : action;
        this.i = (kundle == null || (bool = kundle.getBoolean("can_comment_button_be_shown")) == null) ? false : bool.booleanValue();
    }

    public static final String access$getMessage(RatingDetailsPresenterImpl ratingDetailsPresenterImpl, Throwable th) {
        return ratingDetailsPresenterImpl.p.format(th);
    }

    public static final Observable access$loadItems(RatingDetailsPresenterImpl ratingDetailsPresenterImpl, Uri uri) {
        ratingDetailsPresenterImpl.j = true;
        if (uri == null) {
            List<? extends RatingDetailsItem> list = ratingDetailsPresenterImpl.e;
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            Observable just = Observable.just(list);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        }
        Observable<RatingDetailsResult> doFinally = ratingDetailsPresenterImpl.k.getItems(uri).observeOn(ratingDetailsPresenterImpl.m.mainThread()).doFinally(new a2.a.a.g2.a.b(ratingDetailsPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(doFinally, "interactor.getItems(next…lly { isLoading = false }");
        Observable<RatingDetailsResult> doOnNext = doFinally.doOnNext(new a2.a.a.g2.a.e(ratingDetailsPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "interactor.getItems(next…          .saveNextPage()");
        List<? extends RatingDetailsItem> list2 = ratingDetailsPresenterImpl.e;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        Observable<R> map = doOnNext.map(new a2.a.a.g2.a.c(ratingDetailsPresenterImpl, list2));
        Intrinsics.checkNotNullExpressionValue(map, "interactor.getItems(next…temsWith(items.orEmpty())");
        Observable<R> onErrorReturn = map.onErrorReturn(new a2.a.a.g2.a.a(ratingDetailsPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "interactor.getItems(next…           .handleError()");
        return onErrorReturn;
    }

    public static final void access$scrollToErrorIfNeeded(RatingDetailsPresenterImpl ratingDetailsPresenterImpl, RatingDetailsView ratingDetailsView) {
        List<? extends RatingDetailsItem> list = ratingDetailsPresenterImpl.e;
        if (list != null && (((RatingDetailsItem) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list)) instanceof ErrorSnippetItem)) {
            ratingDetailsView.scrollToPosition(CollectionsKt__CollectionsKt.getLastIndex(list));
        }
    }

    public static final Disposable access$showResult(RatingDetailsPresenterImpl ratingDetailsPresenterImpl, Observable observable) {
        Objects.requireNonNull(ratingDetailsPresenterImpl);
        return observable.subscribe(new a2.a.a.g2.a.g(ratingDetailsPresenterImpl));
    }

    public static final void access$updateCommentButton(RatingDetailsPresenterImpl ratingDetailsPresenterImpl) {
        String title;
        RatingDetailsView ratingDetailsView = ratingDetailsPresenterImpl.c;
        if (ratingDetailsView != null) {
            Action action = ratingDetailsPresenterImpl.g;
            String str = null;
            if (!(action == null || (title = action.getTitle()) == null || !ratingDetailsPresenterImpl.i)) {
                str = title;
            }
            ratingDetailsView.showCommentButton(str);
        }
    }

    public static final void access$updateItems(RatingDetailsPresenterImpl ratingDetailsPresenterImpl) {
        AdapterPresenter adapterPresenter = ratingDetailsPresenterImpl.l;
        List<? extends RatingDetailsItem> list = ratingDetailsPresenterImpl.e;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        a2.b.a.a.a.s1(list, adapterPresenter);
        RatingDetailsView ratingDetailsView = ratingDetailsPresenterImpl.c;
        if (ratingDetailsView != null) {
            ratingDetailsView.updateItems();
        }
    }

    public static final List access$withErrorSnippet(RatingDetailsPresenterImpl ratingDetailsPresenterImpl, List list, String str) {
        Objects.requireNonNull(ratingDetailsPresenterImpl);
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        t6.n.h.removeAll(mutableList, (Function1) a2.a.a.g2.a.h.a);
        return CollectionsKt___CollectionsKt.plus((Collection<? extends ErrorSnippetItem>) mutableList, new ErrorSnippetItem("ErrorSnippetItem", str));
    }

    public static final List access$withoutErrorSnippet(RatingDetailsPresenterImpl ratingDetailsPresenterImpl, List list) {
        Objects.requireNonNull(ratingDetailsPresenterImpl);
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        t6.n.h.removeAll(mutableList, (Function1) a2.a.a.g2.a.h.a);
        return mutableList;
    }

    public static final List access$withoutLoadingItem(RatingDetailsPresenterImpl ratingDetailsPresenterImpl, List list) {
        Objects.requireNonNull(ratingDetailsPresenterImpl);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!(((RatingDetailsItem) obj) instanceof LoadingItem)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final void a() {
        RatingDetailsView ratingDetailsView;
        String title;
        Action action = this.h;
        String str = null;
        if (!(action == null || (title = action.getTitle()) == null || !this.t.getRequestReviewInProfile().invoke().booleanValue())) {
            str = title;
        }
        if (str != null && (ratingDetailsView = this.c) != null) {
            ratingDetailsView.showRequestReviewButton(str);
        }
    }

    @Override // com.avito.android.rating.review_details.upload.ReviewReplyObserver
    public void applyReviewReplyState(@NotNull ReviewReplyState reviewReplyState) {
        ReviewData reviewData;
        List<? extends RatingDetailsItem> list;
        Intrinsics.checkNotNullParameter(reviewReplyState, "state");
        if (!(reviewReplyState instanceof ReviewReplyState.Result)) {
            reviewReplyState = null;
        }
        ReviewReplyState.Result result = (ReviewReplyState.Result) reviewReplyState;
        if (!(result == null || (reviewData = result.getReviewData()) == null || (list = this.e) == null)) {
            int i2 = 0;
            for (T t2 : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t3 = t2;
                if (t3 instanceof UserProfileCommentItem) {
                    T t4 = t3;
                    if (Intrinsics.areEqual(t4.getReviewId(), reviewData.getReviewId())) {
                        t4.setReply(reviewData.getReply());
                        RatingDetailsView ratingDetailsView = this.c;
                        if (ratingDetailsView != null) {
                            ratingDetailsView.notifyItemAtPositionChanged(i2);
                            return;
                        }
                        return;
                    }
                }
                i2 = i3;
            }
        }
    }

    @Override // com.avito.android.rating.details.RatingDetailsPresenter
    public void attachRouter(@NotNull RatingDetailsPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.d = router;
        a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x00ee, code lost:
        if (r0 != null) goto L_0x0144;
     */
    @Override // com.avito.android.rating.details.RatingDetailsPresenter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void attachView(@org.jetbrains.annotations.NotNull com.avito.android.rating.details.RatingDetailsView r5) {
        /*
        // Method dump skipped, instructions count: 347
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.rating.details.RatingDetailsPresenterImpl.attachView(com.avito.android.rating.details.RatingDetailsView):void");
    }

    @Override // com.avito.android.rating.details.RatingDetailsPresenter
    public void detachRouter() {
        this.d = null;
    }

    @Override // com.avito.android.rating.details.RatingDetailsPresenter
    public void detachView() {
        this.s.unsubscribe(this);
        this.b.clear();
        this.a.clear();
        this.c = null;
    }

    @Override // com.avito.android.rating.details.RatingDetailsPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("next_page", this.f).putParcelableList("items", this.e).putParcelable("action", this.g).putBoolean("can_comment_button_be_shown", Boolean.valueOf(this.i)).putParcelable("review_action", this.h);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RatingDetailsPresenterImpl(RatingDetailsInteractor ratingDetailsInteractor, AdapterPresenter adapterPresenter, SchedulersFactory3 schedulersFactory3, PublishRelay publishRelay, Observable observable, ErrorFormatter errorFormatter, RatingDetailsConverter ratingDetailsConverter, DialogPresenter dialogPresenter, ReviewReplyProvider reviewReplyProvider, Features features, Analytics analytics, Observable observable2, Kundle kundle, int i2, t6.r.a.j jVar) {
        this(ratingDetailsInteractor, adapterPresenter, schedulersFactory3, publishRelay, observable, errorFormatter, ratingDetailsConverter, dialogPresenter, reviewReplyProvider, features, analytics, observable2, (i2 & 4096) != 0 ? null : kundle);
    }
}
