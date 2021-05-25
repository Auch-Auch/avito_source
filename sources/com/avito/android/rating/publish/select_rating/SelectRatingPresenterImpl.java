package com.avito.android.rating.publish.select_rating;

import a2.g.r.g;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.select_rating.SelectRatingPresenter;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.remote.auth.AuthSource;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\b\u00101\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b2\u00103J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0014R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u001cR\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00064"}, d2 = {"Lcom/avito/android/rating/publish/select_rating/SelectRatingPresenterImpl;", "Lcom/avito/android/rating/publish/select_rating/SelectRatingPresenter;", "Lcom/avito/android/rating/publish/select_rating/SelectRatingView;", "view", "", "attachView", "(Lcom/avito/android/rating/publish/select_rating/SelectRatingView;)V", "", "score", "applyScore", "(I)V", "", "isLoading", "handleLoading", "(Z)V", "Lcom/avito/android/rating/publish/select_rating/SelectRatingPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/publish/select_rating/SelectRatingPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "d", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "h", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "ratingViewData", "Lcom/avito/android/rating/publish/select_rating/SelectRatingView;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/rating/publish/select_rating/SelectRatingPresenter$Router;", "Lcom/avito/android/ratings/RatingPublishData;", g.a, "Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "c", "disposables", "e", "I", "Lcom/avito/android/rating/publish/StepListener;", "f", "Lcom/avito/android/rating/publish/StepListener;", "stepListener", "state", "<init>", "(Lcom/avito/android/rating/publish/StepListener;Lcom/avito/android/ratings/RatingPublishData;Lcom/avito/android/rating/publish/RatingPublishViewData;Lcom/avito/android/util/Kundle;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class SelectRatingPresenterImpl implements SelectRatingPresenter {
    public SelectRatingView a;
    public SelectRatingPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public int e;
    public final StepListener f;
    public final RatingPublishData g;
    public final RatingPublishViewData h;

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
                SelectRatingPresenterImpl.access$onRatingSelected((SelectRatingPresenterImpl) this.b);
            } else if (i == 1) {
                SelectRatingPresenter.Router router = ((SelectRatingPresenterImpl) this.b).b;
                if (router != null) {
                    router.onBackPressed();
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<Integer> {
        public final /* synthetic */ SelectRatingPresenterImpl a;

        public b(SelectRatingPresenterImpl selectRatingPresenterImpl) {
            this.a = selectRatingPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            SelectRatingPresenterImpl selectRatingPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            SelectRatingPresenterImpl.access$onScoreChanged(selectRatingPresenterImpl, num2.intValue());
        }
    }

    @Inject
    public SelectRatingPresenterImpl(@NotNull StepListener stepListener, @NotNull RatingPublishData ratingPublishData, @NotNull RatingPublishViewData ratingPublishViewData, @Nullable Kundle kundle) {
        Integer num;
        Intrinsics.checkNotNullParameter(stepListener, "stepListener");
        Intrinsics.checkNotNullParameter(ratingPublishData, "ratingData");
        Intrinsics.checkNotNullParameter(ratingPublishViewData, "ratingViewData");
        this.f = stepListener;
        this.g = ratingPublishData;
        this.h = ratingPublishViewData;
        this.e = (kundle == null || (num = kundle.getInt("score")) == null) ? 0 : num.intValue();
    }

    public static final void access$onRatingSelected(SelectRatingPresenterImpl selectRatingPresenterImpl) {
        if (selectRatingPresenterImpl.e > 0) {
            selectRatingPresenterImpl.f.onStepDataProvided(selectRatingPresenterImpl.g, selectRatingPresenterImpl.h, true);
        }
    }

    public static final void access$onScoreChanged(SelectRatingPresenterImpl selectRatingPresenterImpl, int i) {
        selectRatingPresenterImpl.e = i;
        selectRatingPresenterImpl.a();
        selectRatingPresenterImpl.g.setScore(Integer.valueOf(i));
        selectRatingPresenterImpl.h.setScore(Integer.valueOf(i));
    }

    public final void a() {
        if (this.g.isLastStep()) {
            SelectRatingView selectRatingView = this.a;
            if (selectRatingView != null) {
                selectRatingView.showSendButton();
            }
        } else {
            SelectRatingView selectRatingView2 = this.a;
            if (selectRatingView2 != null) {
                selectRatingView2.showContinueButton();
            }
        }
        SelectRatingView selectRatingView3 = this.a;
        if (selectRatingView3 != null) {
            selectRatingView3.setButtonEnabled(this.e > 0);
        }
    }

    @Override // com.avito.android.rating.publish.select_rating.SelectRatingPresenter
    public void applyScore(int i) {
        this.e = i;
        this.g.setScore(Integer.valueOf(i));
        SelectRatingView selectRatingView = this.a;
        if (selectRatingView != null) {
            selectRatingView.setScore(this.e);
        }
    }

    @Override // com.avito.android.rating.publish.select_rating.SelectRatingPresenter
    public void attachRouter(@NotNull SelectRatingPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.rating.publish.select_rating.SelectRatingPresenter
    public void attachView(@NotNull SelectRatingView selectRatingView) {
        Intrinsics.checkNotNullParameter(selectRatingView, "view");
        this.a = selectRatingView;
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = selectRatingView.continueClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.continueClicks().su…atingSelected()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = selectRatingView.scoreChanges().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.scoreChanges().subs…coreChanged(it)\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = selectRatingView.navigationClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.navigationClicks().…onBackPressed()\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        SelectRatingView selectRatingView2 = this.a;
        if (selectRatingView2 != null) {
            selectRatingView2.setScore(this.e);
        }
        a();
    }

    @Override // com.avito.android.rating.publish.select_rating.SelectRatingPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.rating.publish.select_rating.SelectRatingPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.rating.publish.select_rating.SelectRatingPresenter
    public void handleLoading(boolean z) {
        SelectRatingView selectRatingView = this.a;
        if (selectRatingView != null) {
            selectRatingView.showLoadingState(z);
        }
    }

    @Override // com.avito.android.rating.publish.select_rating.SelectRatingPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putInt("score", Integer.valueOf(this.e));
    }
}
