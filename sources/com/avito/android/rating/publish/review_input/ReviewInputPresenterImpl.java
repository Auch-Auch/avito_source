package com.avito.android.rating.publish.review_input;

import a2.g.r.g;
import com.avito.android.rating.publish.RatingPublishStep;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.review_input.ReviewInputPresenter;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.remote.abuse.AbuseSendingResult;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.publish.NextStagePayload;
import com.avito.android.util.Kundle;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B5\b\u0007\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u00106\u001a\u000203\u0012\b\u0010*\u001a\u0004\u0018\u00010'\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b<\u0010=J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0017\u001a\u00020\u00042\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u0010J\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u0010R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010%R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u0010-R$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/avito/android/rating/publish/review_input/ReviewInputPresenterImpl;", "Lcom/avito/android/rating/publish/review_input/ReviewInputPresenter;", "Lcom/avito/android/rating/publish/review_input/ReviewInputView;", "view", "", "attachView", "(Lcom/avito/android/rating/publish/review_input/ReviewInputView;)V", "", AbuseSendingResult.COMMENT, "applyComment", "(Ljava/lang/String;)V", "Lcom/avito/android/rating/publish/review_input/ReviewInputPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/publish/review_input/ReviewInputPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "errors", "handleErrors", "(Ljava/util/Map;)V", "", "isLoading", "handleLoading", "(Z)V", AuthSource.BOOKING_ORDER, AuthSource.SEND_ABUSE, "Lcom/avito/android/rating/publish/StepListener;", g.a, "Lcom/avito/android/rating/publish/StepListener;", "stepListener", "e", "Ljava/lang/String;", "Lcom/avito/android/rating/publish/review_input/ReviewInputPresenter$Router;", "Lcom/avito/android/rating/publish/review_input/ReviewInputView;", "Lcom/avito/android/remote/model/publish/NextStagePayload;", "j", "Lcom/avito/android/remote/model/publish/NextStagePayload;", "payload", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/ratings/RatingPublishData;", "h", "Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "i", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "ratingViewData", "d", "viewDisposables", "f", "Ljava/util/Map;", "state", "<init>", "(Lcom/avito/android/rating/publish/StepListener;Lcom/avito/android/ratings/RatingPublishData;Lcom/avito/android/rating/publish/RatingPublishViewData;Lcom/avito/android/remote/model/publish/NextStagePayload;Lcom/avito/android/util/Kundle;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ReviewInputPresenterImpl implements ReviewInputPresenter {
    public ReviewInputView a;
    public ReviewInputPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public String e;
    public Map<String, String> f;
    public final StepListener g;
    public final RatingPublishData h;
    public final RatingPublishViewData i;
    public final NextStagePayload j;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ ReviewInputPresenterImpl a;

        public a(ReviewInputPresenterImpl reviewInputPresenterImpl) {
            this.a = reviewInputPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            ReviewInputPresenter.Router router = this.a.b;
            if (router != null) {
                router.onBackPressed();
            }
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ ReviewInputPresenterImpl a;
        public final /* synthetic */ ReviewInputView b;

        public b(ReviewInputPresenterImpl reviewInputPresenterImpl, ReviewInputView reviewInputView) {
            this.a = reviewInputPresenterImpl;
            this.b = reviewInputView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            ReviewInputPresenterImpl.access$hideErrors(this.a);
            this.b.hideKeyboard();
            this.a.g.onStepDataProvided(this.a.h, this.a.i, true);
        }
    }

    public static final class c<T> implements Consumer<String> {
        public final /* synthetic */ ReviewInputPresenterImpl a;

        public c(ReviewInputPresenterImpl reviewInputPresenterImpl) {
            this.a = reviewInputPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            ReviewInputPresenterImpl reviewInputPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, AbuseSendingResult.COMMENT);
            reviewInputPresenterImpl.e = str2;
            NextStagePayload unused = this.a.j;
            this.a.h.setComment(str2);
            this.a.i.setComment(str2);
            this.a.g.onStepDataProvided(this.a.h, this.a.i, false);
            this.a.a();
        }
    }

    @Inject
    public ReviewInputPresenterImpl(@NotNull StepListener stepListener, @NotNull RatingPublishData ratingPublishData, @NotNull RatingPublishViewData ratingPublishViewData, @Nullable NextStagePayload nextStagePayload, @Nullable Kundle kundle) {
        String str;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(stepListener, "stepListener");
        Intrinsics.checkNotNullParameter(ratingPublishData, "ratingData");
        Intrinsics.checkNotNullParameter(ratingPublishViewData, "ratingViewData");
        this.g = stepListener;
        this.h = ratingPublishData;
        this.i = ratingPublishViewData;
        this.j = nextStagePayload;
        this.e = (kundle == null || (str = kundle.getString(AbuseSendingResult.COMMENT)) == null) ? "" : str;
        this.f = (kundle == null || (emptyMap = kundle.getStringMap("errors")) == null) ? r.emptyMap() : emptyMap;
    }

    public static final void access$hideErrors(ReviewInputPresenterImpl reviewInputPresenterImpl) {
        Objects.requireNonNull(reviewInputPresenterImpl);
        reviewInputPresenterImpl.f = r.emptyMap();
        reviewInputPresenterImpl.b();
    }

    public final void a() {
        if (this.h.isLastStep()) {
            ReviewInputView reviewInputView = this.a;
            if (reviewInputView != null) {
                reviewInputView.showSendButton();
            }
        } else {
            ReviewInputView reviewInputView2 = this.a;
            if (reviewInputView2 != null) {
                reviewInputView2.showContinueButton();
            }
        }
        ReviewInputView reviewInputView3 = this.a;
        if (reviewInputView3 != null) {
            reviewInputView3.setButtonEnabled(this.e.length() > 0);
        }
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputPresenter
    public void applyComment(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AbuseSendingResult.COMMENT);
        this.e = str;
        this.h.setComment(str);
        ReviewInputView reviewInputView = this.a;
        if (reviewInputView != null) {
            reviewInputView.setComment(str);
        }
        a();
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputPresenter
    public void attachRouter(@NotNull ReviewInputPresenter.Router router) {
        ReviewInputView reviewInputView;
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
        NextStagePayload nextStagePayload = this.j;
        if (nextStagePayload != null && (reviewInputView = this.a) != null) {
            reviewInputView.setTitle(nextStagePayload.getTitle());
            String description = nextStagePayload.getDescription();
            if (description != null) {
                reviewInputView.setDescription(description);
                reviewInputView.showDescription();
            }
            String placeholder = nextStagePayload.getPlaceholder();
            if (placeholder != null) {
                reviewInputView.setPlaceholder(placeholder);
            }
        }
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputPresenter
    public void attachView(@NotNull ReviewInputView reviewInputView) {
        Intrinsics.checkNotNullParameter(reviewInputView, "view");
        this.a = reviewInputView;
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = reviewInputView.navigationClicks().subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.navigationClicks().…onBackPressed()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = reviewInputView.buttonClicks().subscribe(new b(this, reviewInputView));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.buttonClicks().subs…e\n            )\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = reviewInputView.commentChanges().subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.commentChanges().su…   bindButton()\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        a();
        b();
        reviewInputView.setComment(this.e);
    }

    public final void b() {
        ReviewInputView reviewInputView;
        ReviewInputView reviewInputView2 = this.a;
        if (reviewInputView2 != null) {
            reviewInputView2.hideCommentError();
        }
        for (Map.Entry<String, String> entry : this.f.entrySet()) {
            String value = entry.getValue();
            if (Intrinsics.areEqual(entry.getKey(), RatingPublishStep.COMMENT.getStepId()) && (reviewInputView = this.a) != null) {
                reviewInputView.setCommentError(value);
            }
        }
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputPresenter
    public void handleErrors(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "errors");
        this.f = map;
        b();
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputPresenter
    public void handleLoading(boolean z) {
        ReviewInputView reviewInputView = this.a;
        if (reviewInputView != null) {
            reviewInputView.showLoadingState(z);
        }
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putString(AbuseSendingResult.COMMENT, this.e).putStringMap("errors", this.f);
    }
}
