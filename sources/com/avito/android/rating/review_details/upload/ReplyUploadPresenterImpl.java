package com.avito.android.rating.review_details.upload;

import com.avito.android.rating.review_details.upload.ReviewReplyState;
import com.avito.android.ratings.ReviewData;
import com.avito.android.ratings.ReviewReply;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.review_reply.AddReviewReplyResult;
import com.avito.android.remote.model.review_reply.DeleteReviewReplyResult;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b+\u0010,J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/avito/android/rating/review_details/upload/ReplyUploadPresenterImpl;", "Lcom/avito/android/rating/review_details/upload/ReplyUploadPresenter;", "Lcom/avito/android/ratings/ReviewData;", "reviewData", "", "reply", "", "addReviewReply", "(Lcom/avito/android/ratings/ReviewData;Ljava/lang/String;)V", "deleteReviewReply", "(Lcom/avito/android/ratings/ReviewData;)V", "Lcom/avito/android/rating/review_details/upload/ReviewReplyObserver;", "observer", "", "resetState", "subscribe", "(Lcom/avito/android/rating/review_details/upload/ReviewReplyObserver;Z)V", "unsubscribe", "(Lcom/avito/android/rating/review_details/upload/ReviewReplyObserver;)V", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/rating/review_details/upload/ReviewReplyState;", "c", "Lcom/avito/android/rating/review_details/upload/ReviewReplyState;", "state", "Lcom/avito/android/rating/review_details/upload/ReviewReplyConverter;", "f", "Lcom/avito/android/rating/review_details/upload/ReviewReplyConverter;", "converter", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "observers", "Lcom/avito/android/rating/review_details/upload/ReviewReplyInteractor;", "d", "Lcom/avito/android/rating/review_details/upload/ReviewReplyInteractor;", "interactor", "<init>", "(Lcom/avito/android/rating/review_details/upload/ReviewReplyInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/rating/review_details/upload/ReviewReplyConverter;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ReplyUploadPresenterImpl implements ReplyUploadPresenter {
    public final List<ReviewReplyObserver> a = new ArrayList();
    public final CompositeDisposable b = new CompositeDisposable();
    public ReviewReplyState c;
    public final ReviewReplyInteractor d;
    public final SchedulersFactory3 e;
    public final ReviewReplyConverter f;

    public static final class a<T> implements Consumer<AddReviewReplyResult> {
        public final /* synthetic */ ReplyUploadPresenterImpl a;
        public final /* synthetic */ ReviewData b;

        public a(ReplyUploadPresenterImpl replyUploadPresenterImpl, ReviewData reviewData) {
            this.a = replyUploadPresenterImpl;
            this.b = reviewData;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AddReviewReplyResult addReviewReplyResult) {
            AddReviewReplyResult addReviewReplyResult2 = addReviewReplyResult;
            ReplyUploadPresenterImpl.access$sendState(this.a, new ReviewReplyState.Result(ReviewData.copy$default(this.b, null, null, null, null, null, null, null, null, null, this.a.f.convert(addReviewReplyResult2.getReply()), null, 1535, null), addReviewReplyResult2.getMessage()));
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ ReplyUploadPresenterImpl a;
        public final /* synthetic */ ReviewData b;

        public b(ReplyUploadPresenterImpl replyUploadPresenterImpl, ReviewData reviewData) {
            this.a = replyUploadPresenterImpl;
            this.b = reviewData;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            ReplyUploadPresenterImpl replyUploadPresenterImpl = this.a;
            ReviewData reviewData = this.b;
            Intrinsics.checkNotNullExpressionValue(th2, "error");
            ReplyUploadPresenterImpl.access$sendState(replyUploadPresenterImpl, new ReviewReplyState.Error(reviewData, th2));
        }
    }

    public static final class c<T> implements Consumer<DeleteReviewReplyResult> {
        public final /* synthetic */ ReplyUploadPresenterImpl a;
        public final /* synthetic */ ReviewData b;

        public c(ReplyUploadPresenterImpl replyUploadPresenterImpl, ReviewData reviewData) {
            this.a = replyUploadPresenterImpl;
            this.b = reviewData;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DeleteReviewReplyResult deleteReviewReplyResult) {
            ReplyUploadPresenterImpl.access$sendState(this.a, new ReviewReplyState.Result(ReviewData.copy$default(this.b, null, null, null, null, null, null, null, null, null, null, null, 1535, null), deleteReviewReplyResult.getMessage()));
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ ReplyUploadPresenterImpl a;
        public final /* synthetic */ ReviewData b;

        public d(ReplyUploadPresenterImpl replyUploadPresenterImpl, ReviewData reviewData) {
            this.a = replyUploadPresenterImpl;
            this.b = reviewData;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            ReplyUploadPresenterImpl replyUploadPresenterImpl = this.a;
            ReviewData reviewData = this.b;
            Intrinsics.checkNotNullExpressionValue(th2, "error");
            ReplyUploadPresenterImpl.access$sendState(replyUploadPresenterImpl, new ReviewReplyState.Error(reviewData, th2));
        }
    }

    public ReplyUploadPresenterImpl(@NotNull ReviewReplyInteractor reviewReplyInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ReviewReplyConverter reviewReplyConverter) {
        Intrinsics.checkNotNullParameter(reviewReplyInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(reviewReplyConverter, "converter");
        this.d = reviewReplyInteractor;
        this.e = schedulersFactory3;
        this.f = reviewReplyConverter;
    }

    public static final void access$sendState(ReplyUploadPresenterImpl replyUploadPresenterImpl, ReviewReplyState reviewReplyState) {
        replyUploadPresenterImpl.c = reviewReplyState;
        Iterator<T> it = replyUploadPresenterImpl.a.iterator();
        while (it.hasNext()) {
            it.next().applyReviewReplyState(reviewReplyState);
        }
    }

    @Override // com.avito.android.rating.review_details.upload.ReplyUploadPresenter
    public void addReviewReply(@NotNull ReviewData reviewData, @NotNull String str) {
        Intrinsics.checkNotNullParameter(reviewData, "reviewData");
        Intrinsics.checkNotNullParameter(str, "reply");
        Long reviewId = reviewData.getReviewId();
        if (reviewId != null) {
            long longValue = reviewId.longValue();
            CompositeDisposable compositeDisposable = this.b;
            Disposable subscribe = a2.b.a.a.a.b2(this.e, this.d.addReviewReply(longValue, str), "interactor.addReviewRepl…(schedulers.mainThread())").doOnSubscribe(new a2.a.a.g2.c.c.a(this, reviewData)).subscribe(new a(this, reviewData), new b(this, reviewData));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.addReviewRepl…          }\n            )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.rating.review_details.upload.ReplyUploadPresenter
    public void deleteReviewReply(@NotNull ReviewData reviewData) {
        Intrinsics.checkNotNullParameter(reviewData, "reviewData");
        ReviewReply reply = reviewData.getReply();
        if (reply != null) {
            long id = reply.getId();
            CompositeDisposable compositeDisposable = this.b;
            Disposable subscribe = a2.b.a.a.a.b2(this.e, this.d.deleteReviewReply(id), "interactor.deleteReviewR…(schedulers.mainThread())").doOnSubscribe(new a2.a.a.g2.c.c.a(this, reviewData)).subscribe(new c(this, reviewData), new d(this, reviewData));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.deleteReviewR…          }\n            )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.rating.review_details.upload.ReviewReplyProvider
    public void subscribe(@NotNull ReviewReplyObserver reviewReplyObserver, boolean z) {
        Intrinsics.checkNotNullParameter(reviewReplyObserver, "observer");
        this.a.add(reviewReplyObserver);
        ReviewReplyState reviewReplyState = null;
        if (z) {
            this.c = null;
            return;
        }
        ReviewReplyState reviewReplyState2 = this.c;
        if (reviewReplyState2 != null) {
            if (!(reviewReplyState2 instanceof ReviewReplyState.Error)) {
                reviewReplyState = reviewReplyState2;
            }
            if (reviewReplyState != null) {
                reviewReplyObserver.applyReviewReplyState(reviewReplyState);
            }
        }
    }

    @Override // com.avito.android.rating.review_details.upload.ReviewReplyProvider
    public void unsubscribe(@NotNull ReviewReplyObserver reviewReplyObserver) {
        Intrinsics.checkNotNullParameter(reviewReplyObserver, "observer");
        this.a.remove(reviewReplyObserver);
    }
}
