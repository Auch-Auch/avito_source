package com.avito.android.rating.review_details;

import a2.g.r.g;
import com.avito.android.analytics.Analytics;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.rating.R;
import com.avito.android.rating.details.event.RatingDetailsGalleryOpenEvent;
import com.avito.android.rating.review_details.ReviewDetailsPresenter;
import com.avito.android.rating.review_details.di.ReplyState;
import com.avito.android.rating.review_details.upload.ReplyUploadPresenter;
import com.avito.android.rating.review_details.upload.ReviewReplyObserver;
import com.avito.android.rating.review_details.upload.ReviewReplyProvider;
import com.avito.android.ratings.ReviewData;
import com.avito.android.ratings.ReviewReply;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.TnsGalleryImage;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.tns_gallery.TnsGalleryView;
import com.avito.android.util.Kundle;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002BS\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u00108\u001a\u000205\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010=\u001a\u00020:\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b>\u0010?J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010\"R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u00109R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lcom/avito/android/rating/review_details/ReviewDetailsPresenterImpl;", "Lcom/avito/android/rating/review_details/ReviewDetailsPresenter;", "Lcom/avito/android/rating/review_details/upload/ReviewReplyObserver;", "Lcom/avito/android/rating/review_details/ReviewDetailsView;", "view", "", "attachView", "(Lcom/avito/android/rating/review_details/ReviewDetailsView;)V", "Lcom/avito/android/rating/review_details/ReviewDetailsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/review_details/ReviewDetailsPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/rating/review_details/upload/ReviewReplyState;", "state", "applyReviewReplyState", "(Lcom/avito/android/rating/review_details/upload/ReviewReplyState;)V", "Lcom/avito/android/ratings/ReviewData;", "reviewData", AuthSource.SEND_ABUSE, "(Lcom/avito/android/ratings/ReviewData;)V", "e", "Lcom/avito/android/ratings/ReviewData;", "Lcom/avito/android/error_helper/ErrorHelper;", "j", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", AuthSource.BOOKING_ORDER, "Lcom/avito/android/rating/review_details/ReviewDetailsPresenter$Router;", "Lcom/avito/android/rating/review_details/upload/ReplyUploadPresenter;", "f", "Lcom/avito/android/rating/review_details/upload/ReplyUploadPresenter;", "uploadPresenter", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "h", "Lio/reactivex/rxjava3/core/Observable;", "galleryItemClicks", "d", "viewDisposables", "Lcom/avito/android/dialog/DialogPresenter;", "i", "Lcom/avito/android/dialog/DialogPresenter;", "dialogPresenter", "Lcom/avito/android/rating/review_details/upload/ReviewReplyProvider;", g.a, "Lcom/avito/android/rating/review_details/upload/ReviewReplyProvider;", "replyProvider", "Lcom/avito/android/rating/review_details/ReviewDetailsView;", "Lcom/avito/android/analytics/Analytics;", "k", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/ratings/ReviewData;Lcom/avito/android/rating/review_details/upload/ReplyUploadPresenter;Lcom/avito/android/rating/review_details/upload/ReviewReplyProvider;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/dialog/DialogPresenter;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/Kundle;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ReviewDetailsPresenterImpl implements ReviewDetailsPresenter, ReviewReplyObserver {
    public ReviewDetailsView a;
    public ReviewDetailsPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public final ReviewData e;
    public final ReplyUploadPresenter f;
    public final ReviewReplyProvider g;
    public final Observable<TnsGalleryItemClickAction> h;
    public final DialogPresenter i;
    public final ErrorHelper j;
    public final Analytics k;

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
                ReviewDetailsPresenter.Router router = ((ReviewDetailsPresenterImpl) this.b).b;
                if (router != null) {
                    router.leaveScreen();
                }
            } else if (i != 1) {
                throw null;
            } else if (((ReviewDetailsPresenterImpl) this.b).e.getReply() == null) {
                ReviewDetailsPresenter.Router router2 = ((ReviewDetailsPresenterImpl) this.b).b;
                if (router2 != null) {
                    router2.showReplyDialog();
                }
            } else {
                ReviewDetailsPresenterImpl.access$deleteReply((ReviewDetailsPresenterImpl) this.b);
            }
        }
    }

    public static final class b<T> implements Consumer<TnsGalleryItemClickAction> {
        public final /* synthetic */ ReviewDetailsPresenterImpl a;

        public b(ReviewDetailsPresenterImpl reviewDetailsPresenterImpl) {
            this.a = reviewDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TnsGalleryItemClickAction tnsGalleryItemClickAction) {
            TnsGalleryItemClickAction tnsGalleryItemClickAction2 = tnsGalleryItemClickAction;
            ReviewDetailsPresenter.Router router = this.a.b;
            if (router != null) {
                router.openGallery(tnsGalleryItemClickAction2.getImages(), tnsGalleryItemClickAction2.getIndex());
                this.a.k.track(new RatingDetailsGalleryOpenEvent(tnsGalleryItemClickAction2.getIndex()));
            }
        }
    }

    @Inject
    public ReviewDetailsPresenterImpl(@NotNull ReviewData reviewData, @NotNull ReplyUploadPresenter replyUploadPresenter, @NotNull ReviewReplyProvider reviewReplyProvider, @NotNull Observable<TnsGalleryItemClickAction> observable, @NotNull DialogPresenter dialogPresenter, @NotNull ErrorHelper errorHelper, @NotNull Analytics analytics, @ReplyState @Nullable Kundle kundle) {
        ReviewData reviewData2;
        Intrinsics.checkNotNullParameter(reviewData, "reviewData");
        Intrinsics.checkNotNullParameter(replyUploadPresenter, "uploadPresenter");
        Intrinsics.checkNotNullParameter(reviewReplyProvider, "replyProvider");
        Intrinsics.checkNotNullParameter(observable, "galleryItemClicks");
        Intrinsics.checkNotNullParameter(dialogPresenter, "dialogPresenter");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.f = replyUploadPresenter;
        this.g = reviewReplyProvider;
        this.h = observable;
        this.i = dialogPresenter;
        this.j = errorHelper;
        this.k = analytics;
        if (!(kundle == null || (reviewData2 = (ReviewData) kundle.getParcelable("key_review_data")) == null)) {
            reviewData = reviewData2;
        }
        this.e = reviewData;
    }

    public static final void access$deleteReply(ReviewDetailsPresenterImpl reviewDetailsPresenterImpl) {
        reviewDetailsPresenterImpl.f.deleteReviewReply(reviewDetailsPresenterImpl.e);
    }

    public final void a(ReviewData reviewData) {
        ReviewDetailsView reviewDetailsView = this.a;
        if (reviewDetailsView != null) {
            reviewDetailsView.showReply(reviewData.getReply() != null);
            ReviewReply reply = reviewData.getReply();
            if (reply != null) {
                Image avatar = reply.getAvatar();
                Picture pictureOf$default = avatar != null ? AvitoPictureKt.pictureOf$default(avatar, true, 0.0f, 0.0f, null, 28, null) : null;
                if (reply.isShop()) {
                    reviewDetailsView.setReplyShopAvatar(pictureOf$default);
                } else {
                    reviewDetailsView.setReplyUserAvatar(pictureOf$default);
                }
                reviewDetailsView.setReplyStatus(reply.getStatus(), reply.getStatusText(), reply.getRejectMessage());
                reviewDetailsView.setReplyTitle(reply.getTitle());
                reviewDetailsView.setReplyText(reply.getText());
                reviewDetailsView.setReplyDate(reply.getAnswerDate());
            }
            reviewDetailsView.setButtonText(reviewData.getReply() == null ? R.string.review_reply_add_button : R.string.review_reply_delete_button);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // com.avito.android.rating.review_details.upload.ReviewReplyObserver
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void applyReviewReplyState(@org.jetbrains.annotations.NotNull com.avito.android.rating.review_details.upload.ReviewReplyState r7) {
        /*
            r6 = this;
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.avito.android.ratings.ReviewData r0 = r7.getReview()
            java.lang.Long r0 = r0.getReviewId()
            com.avito.android.ratings.ReviewData r1 = r6.e
            java.lang.Long r1 = r1.getReviewId()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00c2
            boolean r0 = r7 instanceof com.avito.android.rating.review_details.upload.ReviewReplyState.Result
            r1 = 1
            if (r0 == 0) goto L_0x006d
            r0 = r7
            com.avito.android.rating.review_details.upload.ReviewReplyState$Result r0 = (com.avito.android.rating.review_details.upload.ReviewReplyState.Result) r0
            com.avito.android.ratings.ReviewData r2 = r0.getReviewData()
            com.avito.android.ratings.ReviewReply r2 = r2.getReply()
            r3 = 0
            if (r2 == 0) goto L_0x0035
            long r4 = r2.getId()
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            goto L_0x0036
        L_0x0035:
            r2 = r3
        L_0x0036:
            com.avito.android.ratings.ReviewData r4 = r6.e
            com.avito.android.ratings.ReviewReply r4 = r4.getReply()
            if (r4 == 0) goto L_0x0046
            long r3 = r4.getId()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
        L_0x0046:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            r2 = r2 ^ r1
            if (r2 == 0) goto L_0x006d
            com.avito.android.ratings.ReviewData r1 = r6.e
            com.avito.android.ratings.ReviewData r2 = r0.getReviewData()
            com.avito.android.ratings.ReviewReply r2 = r2.getReply()
            r1.setReply(r2)
            com.avito.android.ratings.ReviewData r1 = r0.getReviewData()
            r6.a(r1)
            com.avito.android.rating.review_details.ReviewDetailsView r1 = r6.a
            if (r1 == 0) goto L_0x00b9
            java.lang.String r0 = r0.getMessage()
            r1.showSnackbar(r0)
            goto L_0x00b9
        L_0x006d:
            boolean r0 = r7 instanceof com.avito.android.rating.review_details.upload.ReviewReplyState.Error
            if (r0 == 0) goto L_0x00b9
            com.avito.android.rating.review_details.ReviewDetailsPresenter$Router r0 = r6.b
            if (r0 == 0) goto L_0x007b
            boolean r0 = r0.dialogIsShowing()
            if (r0 == r1) goto L_0x00b9
        L_0x007b:
            r0 = r7
            com.avito.android.rating.review_details.upload.ReviewReplyState$Error r0 = (com.avito.android.rating.review_details.upload.ReviewReplyState.Error) r0
            java.lang.Throwable r0 = r0.getError()
            com.avito.android.error_helper.ErrorHelper r1 = r6.j
            com.avito.android.remote.error.TypedError r0 = r1.handle(r0)
            boolean r1 = r0 instanceof com.avito.android.remote.error.ErrorResult.ErrorDialog
            if (r1 == 0) goto L_0x00ac
            io.reactivex.rxjava3.disposables.CompositeDisposable r1 = r6.d
            com.avito.android.dialog.DialogPresenter r2 = r6.i
            com.avito.android.remote.error.ErrorResult$ErrorDialog r0 = (com.avito.android.remote.error.ErrorResult.ErrorDialog) r0
            com.avito.android.remote.model.UserDialog r0 = r0.getUserDialog()
            io.reactivex.rxjava3.core.Maybe r0 = r2.showDialog3(r0)
            a2.a.a.g2.c.a r2 = new a2.a.a.g2.c.a
            r2.<init>(r6)
            io.reactivex.rxjava3.disposables.Disposable r0 = r0.subscribe(r2)
            java.lang.String r2 = "dialogPresenter.showDial…ter?.followDeepLink(it) }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            io.reactivex.rxjava3.kotlin.DisposableKt.plusAssign(r1, r0)
            goto L_0x00b9
        L_0x00ac:
            com.avito.android.rating.review_details.ReviewDetailsView r1 = r6.a
            if (r1 == 0) goto L_0x00b9
            com.avito.android.error_helper.ErrorHelper r2 = r6.j
            java.lang.String r0 = r2.recycle(r0)
            r1.showSnackbar(r0)
        L_0x00b9:
            com.avito.android.rating.review_details.ReviewDetailsView r0 = r6.a
            if (r0 == 0) goto L_0x00c2
            boolean r7 = r7 instanceof com.avito.android.rating.review_details.upload.ReviewReplyState.Loading
            r0.setLoading(r7)
        L_0x00c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.rating.review_details.ReviewDetailsPresenterImpl.applyReviewReplyState(com.avito.android.rating.review_details.upload.ReviewReplyState):void");
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsPresenter
    public void attachRouter(@NotNull ReviewDetailsPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsPresenter
    public void attachView(@NotNull ReviewDetailsView reviewDetailsView) {
        Intrinsics.checkNotNullParameter(reviewDetailsView, "view");
        this.a = reviewDetailsView;
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = reviewDetailsView.navigationClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.navigationClicks().…?.leaveScreen()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        boolean z = true;
        Disposable subscribe2 = reviewDetailsView.actionClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.actionClicks().subs…)\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = this.h.subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "galleryItemClicks.subscr…)\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        Image avatar = this.e.getAvatar();
        reviewDetailsView.setAvatar(avatar != null ? AvitoPictureKt.pictureOf$default(avatar, true, 0.0f, 0.0f, null, 28, null) : null);
        reviewDetailsView.setItem(this.e.getItem());
        reviewDetailsView.setMessage(this.e.getMessage());
        reviewDetailsView.setName(this.e.getName());
        reviewDetailsView.setPublicationDate(this.e.getPublicationDate());
        reviewDetailsView.setRating(this.e.getScore());
        reviewDetailsView.setStage(this.e.getStage());
        reviewDetailsView.showButton(this.e.getReviewId() != null && Intrinsics.areEqual(this.e.getCanReply(), Boolean.TRUE));
        List<TnsGalleryImage> images = this.e.getImages();
        if (images != null && !images.isEmpty()) {
            z = false;
        }
        if (z) {
            reviewDetailsView.getGalleryView().hideGallery();
        } else {
            TnsGalleryView galleryView = reviewDetailsView.getGalleryView();
            List<TnsGalleryImage> images2 = this.e.getImages();
            Objects.requireNonNull(images2, "null cannot be cast to non-null type kotlin.collections.List<com.avito.android.remote.model.TnsGalleryImage>");
            galleryView.showGallery(images2);
        }
        a(this.e);
        ReviewReplyProvider.DefaultImpls.subscribe$default(this.g, this, false, 2, null);
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsPresenter
    public void detachView() {
        this.g.unsubscribe(this);
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.rating.review_details.ReviewDetailsPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("key_review_data", this.e);
    }
}
