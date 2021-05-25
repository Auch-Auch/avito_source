package com.avito.android.rating.review_details.reply;

import a2.g.r.g;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.rating.review_details.di.ReplyState;
import com.avito.android.rating.review_details.reply.ReviewReplyPresenter;
import com.avito.android.rating.review_details.upload.ReplyUploadPresenter;
import com.avito.android.rating.review_details.upload.ReviewReplyObserver;
import com.avito.android.rating.review_details.upload.ReviewReplyProvider;
import com.avito.android.rating.review_details.upload.ReviewReplyState;
import com.avito.android.ratings.ReviewData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.Kundle;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B=\b\u0007\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b6\u00107J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/avito/android/rating/review_details/reply/ReviewReplyPresenterImpl;", "Lcom/avito/android/rating/review_details/reply/ReviewReplyPresenter;", "Lcom/avito/android/rating/review_details/upload/ReviewReplyObserver;", "Lcom/avito/android/rating/review_details/reply/ReviewReplyView;", "view", "", "attachView", "(Lcom/avito/android/rating/review_details/reply/ReviewReplyView;)V", "Lcom/avito/android/rating/review_details/reply/ReviewReplyPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/review_details/reply/ReviewReplyPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/rating/review_details/upload/ReviewReplyState;", "state", "applyReviewReplyState", "(Lcom/avito/android/rating/review_details/upload/ReviewReplyState;)V", "Lcom/avito/android/error_helper/ErrorHelper;", "i", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", AuthSource.SEND_ABUSE, "Lcom/avito/android/rating/review_details/reply/ReviewReplyView;", "Lcom/avito/android/dialog/DialogPresenter;", "h", "Lcom/avito/android/dialog/DialogPresenter;", "dialogPresenter", AuthSource.BOOKING_ORDER, "Lcom/avito/android/rating/review_details/reply/ReviewReplyPresenter$Router;", "Lcom/avito/android/rating/review_details/upload/ReviewReplyProvider;", g.a, "Lcom/avito/android/rating/review_details/upload/ReviewReplyProvider;", "reviewReplyProvider", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/rating/review_details/upload/ReplyUploadPresenter;", "f", "Lcom/avito/android/rating/review_details/upload/ReplyUploadPresenter;", "uploadPresenter", "", "d", "Ljava/lang/String;", "replyText", "Lcom/avito/android/ratings/ReviewData;", "e", "Lcom/avito/android/ratings/ReviewData;", "reviewData", "<init>", "(Lcom/avito/android/ratings/ReviewData;Lcom/avito/android/rating/review_details/upload/ReplyUploadPresenter;Lcom/avito/android/rating/review_details/upload/ReviewReplyProvider;Lcom/avito/android/dialog/DialogPresenter;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/util/Kundle;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ReviewReplyPresenterImpl implements ReviewReplyPresenter, ReviewReplyObserver {
    public ReviewReplyView a;
    public ReviewReplyPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public String d;
    public final ReviewData e;
    public final ReplyUploadPresenter f;
    public final ReviewReplyProvider g;
    public final DialogPresenter h;
    public final ErrorHelper i;

    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ ReviewReplyPresenterImpl a;
        public final /* synthetic */ ReviewReplyView b;

        public a(ReviewReplyPresenterImpl reviewReplyPresenterImpl, ReviewReplyView reviewReplyView) {
            this.a = reviewReplyPresenterImpl;
            this.b = reviewReplyView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            this.a.d = str;
            this.b.hideErrorMessage();
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ ReviewReplyPresenterImpl a;
        public final /* synthetic */ ReviewReplyView b;

        public b(ReviewReplyPresenterImpl reviewReplyPresenterImpl, ReviewReplyView reviewReplyView) {
            this.a = reviewReplyPresenterImpl;
            this.b = reviewReplyView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.b.hideErrorMessage();
            ReplyUploadPresenter replyUploadPresenter = this.a.f;
            ReviewData reviewData = this.a.e;
            String str = this.a.d;
            if (str == null) {
                str = "";
            }
            replyUploadPresenter.addReviewReply(reviewData, str);
        }
    }

    @Inject
    public ReviewReplyPresenterImpl(@NotNull ReviewData reviewData, @NotNull ReplyUploadPresenter replyUploadPresenter, @NotNull ReviewReplyProvider reviewReplyProvider, @NotNull DialogPresenter dialogPresenter, @NotNull ErrorHelper errorHelper, @ReplyState @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(reviewData, "reviewData");
        Intrinsics.checkNotNullParameter(replyUploadPresenter, "uploadPresenter");
        Intrinsics.checkNotNullParameter(reviewReplyProvider, "reviewReplyProvider");
        Intrinsics.checkNotNullParameter(dialogPresenter, "dialogPresenter");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        this.e = reviewData;
        this.f = replyUploadPresenter;
        this.g = reviewReplyProvider;
        this.h = dialogPresenter;
        this.i = errorHelper;
        this.d = kundle != null ? kundle.getString("key_reply") : null;
    }

    @Override // com.avito.android.rating.review_details.upload.ReviewReplyObserver
    public void applyReviewReplyState(@NotNull ReviewReplyState reviewReplyState) {
        Intrinsics.checkNotNullParameter(reviewReplyState, "state");
        if (Intrinsics.areEqual(reviewReplyState.getReview().getReviewId(), this.e.getReviewId())) {
            if ((reviewReplyState instanceof ReviewReplyState.Result) && ((ReviewReplyState.Result) reviewReplyState).getReviewData().getReply() != null) {
                this.d = null;
                ReviewReplyPresenter.Router router = this.b;
                if (router != null) {
                    router.closeReplyDialog();
                }
            } else if (reviewReplyState instanceof ReviewReplyState.Error) {
                ReviewReplyState.Error error = (ReviewReplyState.Error) reviewReplyState;
                if (error.getReviewData().getReply() == null) {
                    TypedError handle = this.i.handle(error.getError());
                    if (handle instanceof ErrorResult.ErrorDialog) {
                        CompositeDisposable compositeDisposable = this.c;
                        Disposable subscribe = this.h.showDialog3(((ErrorResult.ErrorDialog) handle).getUserDialog()).subscribe(new a2.a.a.g2.c.b.a(this));
                        Intrinsics.checkNotNullExpressionValue(subscribe, "dialogPresenter.showDial…ter?.followDeepLink(it) }");
                        DisposableKt.plusAssign(compositeDisposable, subscribe);
                    } else if (handle instanceof ErrorResult.IncorrectData) {
                        ReviewReplyView reviewReplyView = this.a;
                        if (reviewReplyView != null) {
                            reviewReplyView.showErrorMessage(this.i.recycle(handle));
                        }
                    } else {
                        ReviewReplyView reviewReplyView2 = this.a;
                        if (reviewReplyView2 != null) {
                            reviewReplyView2.showSnackbar(this.i.recycle(handle));
                        }
                    }
                }
            }
            ReviewReplyView reviewReplyView3 = this.a;
            if (reviewReplyView3 != null) {
                reviewReplyView3.setLoading(reviewReplyState instanceof ReviewReplyState.Loading);
            }
        }
    }

    @Override // com.avito.android.rating.review_details.reply.ReviewReplyPresenter
    public void attachRouter(@NotNull ReviewReplyPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
        if (this.d != null) {
            router.showReplyDialog();
        }
    }

    @Override // com.avito.android.rating.review_details.reply.ReviewReplyPresenter
    public void attachView(@NotNull ReviewReplyView reviewReplyView) {
        Intrinsics.checkNotNullParameter(reviewReplyView, "view");
        this.a = reviewReplyView;
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = reviewReplyView.textChanges().subscribe(new a(this, reviewReplyView));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.textChanges().subsc…eErrorMessage()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = reviewReplyView.buttonClicks().subscribe(new b(this, reviewReplyView));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.buttonClicks().subs…eplyText ?: \"\")\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        ReviewReplyProvider.DefaultImpls.subscribe$default(this.g, this, false, 2, null);
        String str = this.d;
        if (str == null) {
            str = "";
        }
        reviewReplyView.setReplyText(str);
    }

    @Override // com.avito.android.rating.review_details.reply.ReviewReplyPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.rating.review_details.reply.ReviewReplyPresenter
    public void detachView() {
        this.g.unsubscribe(this);
        this.c.clear();
        this.a = null;
    }

    @Override // com.avito.android.rating.review_details.reply.ReviewReplyPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        String str = this.d;
        if (!(this.a != null)) {
            str = null;
        }
        return kundle.putString("key_reply", str);
    }
}
