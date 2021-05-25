package com.avito.android.rating.user_review_details;

import a2.g.r.g;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.rating.details.event.RatingDetailsGalleryOpenEvent;
import com.avito.android.rating.user_review_details.UserReviewDetailsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.AvatarStatus;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.TnsGalleryImage;
import com.avito.android.remote.model.UserDialog;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.tns_gallery.TnsGalleryView;
import com.avito.android.user_review.RecipientProfile;
import com.avito.android.user_review.UserProfileData;
import com.avito.android.user_review.UserReviewData;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010'\u001a\u00020$\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\b\u0010<\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b=\u0010>J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010*R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006?"}, d2 = {"Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenterImpl;", "Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenter;", "Lcom/avito/android/rating/user_review_details/UserReviewDetailsView;", "view", "", "attachView", "(Lcom/avito/android/rating/user_review_details/UserReviewDetailsView;)V", "Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", AuthSource.SEND_ABUSE, "Lcom/avito/android/rating/user_review_details/UserReviewDetailsView;", "Lcom/avito/android/user_review/UserReviewData;", "f", "Lcom/avito/android/user_review/UserReviewData;", AvatarStatus.REVIEW, "Lcom/avito/android/util/SchedulersFactory3;", "k", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/analytics/Analytics;", "l", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "h", "Lio/reactivex/rxjava3/core/Observable;", "galleryItemClicks", "Lcom/avito/android/rating/user_review_details/UserReviewDetailsInteractor;", g.a, "Lcom/avito/android/rating/user_review_details/UserReviewDetailsInteractor;", "interactor", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", AuthSource.BOOKING_ORDER, "Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenter$Router;", "Lcom/avito/android/error_helper/ErrorHelper;", "j", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "Lcom/avito/android/dialog/DialogPresenter;", "i", "Lcom/avito/android/dialog/DialogPresenter;", "dialogPresenter", "d", "viewDisposables", "Lcom/avito/android/remote/model/UserDialog;", "e", "Lcom/avito/android/remote/model/UserDialog;", "userDialog", "state", "<init>", "(Lcom/avito/android/user_review/UserReviewData;Lcom/avito/android/rating/user_review_details/UserReviewDetailsInteractor;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/dialog/DialogPresenter;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/Kundle;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserReviewDetailsPresenterImpl implements UserReviewDetailsPresenter {
    public UserReviewDetailsView a;
    public UserReviewDetailsPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public UserDialog e;
    public final UserReviewData f;
    public final UserReviewDetailsInteractor g;
    public final Observable<TnsGalleryItemClickAction> h;
    public final DialogPresenter i;
    public final ErrorHelper j;
    public final SchedulersFactory3 k;
    public final Analytics l;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                UserReviewDetailsPresenter.Router router = ((UserReviewDetailsPresenterImpl) this.b).b;
                if (router != null) {
                    UserReviewDetailsPresenter.Router.DefaultImpls.leaveScreen$default(router, false, 1, null);
                }
            } else if (i == 1) {
                UserReviewDetailsPresenterImpl.access$deleteReview((UserReviewDetailsPresenterImpl) this.b);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ DeepLink a;
        public final /* synthetic */ UserReviewDetailsPresenterImpl b;
        public final /* synthetic */ UserReviewDetailsView c;

        public b(DeepLink deepLink, UserReviewDetailsPresenterImpl userReviewDetailsPresenterImpl, UserReviewDetailsView userReviewDetailsView) {
            this.a = deepLink;
            this.b = userReviewDetailsPresenterImpl;
            this.c = userReviewDetailsView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            UserReviewDetailsPresenter.Router router = this.b.b;
            if (router != null) {
                router.followDeepLink(this.a);
            }
        }
    }

    public static final class c<T> implements Consumer<TnsGalleryItemClickAction> {
        public final /* synthetic */ UserReviewDetailsPresenterImpl a;

        public c(UserReviewDetailsPresenterImpl userReviewDetailsPresenterImpl) {
            this.a = userReviewDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TnsGalleryItemClickAction tnsGalleryItemClickAction) {
            TnsGalleryItemClickAction tnsGalleryItemClickAction2 = tnsGalleryItemClickAction;
            UserReviewDetailsPresenter.Router router = this.a.b;
            if (router != null) {
                router.openGallery(tnsGalleryItemClickAction2.getImages(), tnsGalleryItemClickAction2.getIndex());
                this.a.l.track(new RatingDetailsGalleryOpenEvent(tnsGalleryItemClickAction2.getIndex()));
            }
        }
    }

    @Inject
    public UserReviewDetailsPresenterImpl(@NotNull UserReviewData userReviewData, @NotNull UserReviewDetailsInteractor userReviewDetailsInteractor, @NotNull Observable<TnsGalleryItemClickAction> observable, @NotNull DialogPresenter dialogPresenter, @NotNull ErrorHelper errorHelper, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Analytics analytics, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(userReviewData, AvatarStatus.REVIEW);
        Intrinsics.checkNotNullParameter(userReviewDetailsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(observable, "galleryItemClicks");
        Intrinsics.checkNotNullParameter(dialogPresenter, "dialogPresenter");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.f = userReviewData;
        this.g = userReviewDetailsInteractor;
        this.h = observable;
        this.i = dialogPresenter;
        this.j = errorHelper;
        this.k = schedulersFactory3;
        this.l = analytics;
        this.e = kundle != null ? (UserDialog) kundle.getParcelable("dialog") : null;
    }

    public static final void access$deleteReview(UserReviewDetailsPresenterImpl userReviewDetailsPresenterImpl) {
        CompositeDisposable compositeDisposable = userReviewDetailsPresenterImpl.c;
        Disposable subscribe = userReviewDetailsPresenterImpl.g.deleteReview(userReviewDetailsPresenterImpl.f.getId()).observeOn(userReviewDetailsPresenterImpl.k.mainThread()).doOnSubscribe(new a2.a.a.g2.e.a(userReviewDetailsPresenterImpl)).doOnTerminate(new r(0, userReviewDetailsPresenterImpl)).subscribe(new r(1, userReviewDetailsPresenterImpl), new a2.a.a.g2.e.b(userReviewDetailsPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.deleteReview(…Error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$handleError(UserReviewDetailsPresenterImpl userReviewDetailsPresenterImpl, Throwable th) {
        TypedError handle = userReviewDetailsPresenterImpl.j.handle(th);
        if (handle instanceof ErrorResult.ErrorDialog) {
            UserDialog userDialog = ((ErrorResult.ErrorDialog) handle).getUserDialog();
            CompositeDisposable compositeDisposable = userReviewDetailsPresenterImpl.d;
            Disposable subscribe = userReviewDetailsPresenterImpl.i.showDialog3(userDialog).subscribe(new a2.a.a.g2.e.c(userReviewDetailsPresenterImpl));
            Intrinsics.checkNotNullExpressionValue(subscribe, "dialogPresenter.showDial…ter?.followDeepLink(it) }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return;
        }
        UserReviewDetailsView userReviewDetailsView = userReviewDetailsPresenterImpl.a;
        if (userReviewDetailsView != null) {
            userReviewDetailsView.showError();
        }
    }

    public static final void access$handleReviewDeleted(UserReviewDetailsPresenterImpl userReviewDetailsPresenterImpl) {
        UserReviewDetailsPresenter.Router router = userReviewDetailsPresenterImpl.b;
        if (router != null) {
            router.leaveScreen(true);
        }
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsPresenter
    public void attachRouter(@NotNull UserReviewDetailsPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsPresenter
    public void attachView(@NotNull UserReviewDetailsView userReviewDetailsView) {
        DeepLink link;
        Intrinsics.checkNotNullParameter(userReviewDetailsView, "view");
        this.a = userReviewDetailsView;
        CompositeDisposable compositeDisposable = this.d;
        boolean z = false;
        Disposable subscribe = userReviewDetailsView.navigationClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.navigationClicks().…?.leaveScreen()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        RecipientProfile profile = this.f.getProfile();
        if (!(profile == null || (link = profile.getLink()) == null)) {
            CompositeDisposable compositeDisposable2 = this.d;
            Disposable subscribe2 = userReviewDetailsView.profileClicks().subscribe(new b(link, this, userReviewDetailsView));
            Intrinsics.checkNotNullExpressionValue(subscribe2, "view.profileClicks().sub…k(deepLink)\n            }");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        }
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = userReviewDetailsView.deleteClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.deleteClicks().subs… deleteReview()\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.d;
        Disposable subscribe4 = this.h.subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "galleryItemClicks.subscr…)\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        RecipientProfile profile2 = this.f.getProfile();
        if (profile2 != null) {
            Image avatar = profile2.getAvatar();
            Picture pictureOf$default = avatar != null ? AvitoPictureKt.pictureOf$default(avatar, true, 0.0f, 0.0f, null, 28, null) : null;
            if (profile2.isShop()) {
                userReviewDetailsView.setRecipientShopAvatar(pictureOf$default);
            } else {
                userReviewDetailsView.setRecipientAvatar(pictureOf$default);
            }
            userReviewDetailsView.setRecipientName(profile2.getName());
            userReviewDetailsView.setRecipientReply(profile2.getReply());
            userReviewDetailsView.setRecipientReplyDate(profile2.getReplyDate());
        }
        userReviewDetailsView.setItem(this.f.getItem());
        userReviewDetailsView.setMessage(this.f.getText());
        userReviewDetailsView.setPublicationDate(this.f.getRated());
        userReviewDetailsView.setRating(this.f.getScore());
        userReviewDetailsView.setStage(this.f.getStage());
        userReviewDetailsView.setRejectMessage(this.f.getRejectMessage());
        String reviewStatus = this.f.getReviewStatus();
        if (reviewStatus != null) {
            userReviewDetailsView.setReviewStatus(reviewStatus);
        }
        UserProfileData userProfile = this.f.getUserProfile();
        if (userProfile != null) {
            userReviewDetailsView.setUserName(userProfile.getName());
            userReviewDetailsView.setUserAvatar(AvitoPictureKt.pictureOf$default(userProfile.getAvatar(), true, 0.0f, 0.0f, null, 28, null));
        }
        List<TnsGalleryImage> images = this.f.getImages();
        if (images == null || images.isEmpty()) {
            z = true;
        }
        if (z) {
            userReviewDetailsView.getGalleryView().hideGallery();
            return;
        }
        TnsGalleryView galleryView = userReviewDetailsView.getGalleryView();
        List<TnsGalleryImage> images2 = this.f.getImages();
        Objects.requireNonNull(images2, "null cannot be cast to non-null type kotlin.collections.List<com.avito.android.remote.model.TnsGalleryImage>");
        galleryView.showGallery(images2);
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("dialog", this.e);
    }
}
