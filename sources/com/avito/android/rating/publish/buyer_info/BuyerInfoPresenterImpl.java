package com.avito.android.rating.publish.buyer_info;

import a2.g.r.g;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.buyer_info.BuyerInfoPresenter;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010&\u001a\u00020#\u0012\b\u00101\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b2\u00103J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/avito/android/rating/publish/buyer_info/BuyerInfoPresenterImpl;", "Lcom/avito/android/rating/publish/buyer_info/BuyerInfoPresenter;", "Lcom/avito/android/rating/publish/buyer_info/BuyerInfoView;", "view", "", "attachView", "(Lcom/avito/android/rating/publish/buyer_info/BuyerInfoView;)V", "", "text", "applyBuyerInfo", "(Ljava/lang/String;)V", "Lcom/avito/android/rating/publish/buyer_info/BuyerInfoPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/rating/publish/buyer_info/BuyerInfoPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "isLoading", "handleLoading", "(Z)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/rating/publish/buyer_info/BuyerInfoPresenter$Router;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "d", "viewDisposables", AuthSource.SEND_ABUSE, "Lcom/avito/android/rating/publish/buyer_info/BuyerInfoView;", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "h", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "ratingViewData", "Lcom/avito/android/rating/publish/StepListener;", "f", "Lcom/avito/android/rating/publish/StepListener;", "stepListener", "Lcom/avito/android/ratings/RatingPublishData;", g.a, "Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "e", "Ljava/lang/String;", "state", "<init>", "(Lcom/avito/android/rating/publish/StepListener;Lcom/avito/android/ratings/RatingPublishData;Lcom/avito/android/rating/publish/RatingPublishViewData;Lcom/avito/android/util/Kundle;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class BuyerInfoPresenterImpl implements BuyerInfoPresenter {
    public BuyerInfoView a;
    public BuyerInfoPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public String e;
    public final StepListener f;
    public final RatingPublishData g;
    public final RatingPublishViewData h;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ BuyerInfoPresenterImpl a;

        public a(BuyerInfoPresenterImpl buyerInfoPresenterImpl) {
            this.a = buyerInfoPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            BuyerInfoPresenter.Router router = this.a.b;
            if (router != null) {
                router.onBackPressed();
            }
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ BuyerInfoPresenterImpl a;
        public final /* synthetic */ BuyerInfoView b;

        public b(BuyerInfoPresenterImpl buyerInfoPresenterImpl, BuyerInfoView buyerInfoView) {
            this.a = buyerInfoPresenterImpl;
            this.b = buyerInfoView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.b.hideKeyboard();
            this.a.f.onStepDataProvided(this.a.g, this.a.h, true);
        }
    }

    public static final class c<T> implements Consumer<String> {
        public final /* synthetic */ BuyerInfoPresenterImpl a;

        public c(BuyerInfoPresenterImpl buyerInfoPresenterImpl) {
            this.a = buyerInfoPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            BuyerInfoPresenterImpl buyerInfoPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "text");
            buyerInfoPresenterImpl.e = str2;
            this.a.g.setBuyerInfo(str2);
            this.a.h.setBuyerInfo(str2);
            this.a.f.onStepDataProvided(this.a.g, this.a.h, false);
        }
    }

    @Inject
    public BuyerInfoPresenterImpl(@NotNull StepListener stepListener, @NotNull RatingPublishData ratingPublishData, @NotNull RatingPublishViewData ratingPublishViewData, @Nullable Kundle kundle) {
        String str;
        Intrinsics.checkNotNullParameter(stepListener, "stepListener");
        Intrinsics.checkNotNullParameter(ratingPublishData, "ratingData");
        Intrinsics.checkNotNullParameter(ratingPublishViewData, "ratingViewData");
        this.f = stepListener;
        this.g = ratingPublishData;
        this.h = ratingPublishViewData;
        this.e = (kundle == null || (str = kundle.getString("text")) == null) ? "" : str;
    }

    @Override // com.avito.android.rating.publish.buyer_info.BuyerInfoPresenter
    public void applyBuyerInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.e = str;
        this.g.setBuyerInfo(str);
        BuyerInfoView buyerInfoView = this.a;
        if (buyerInfoView != null) {
            buyerInfoView.setText(str);
        }
    }

    @Override // com.avito.android.rating.publish.buyer_info.BuyerInfoPresenter
    public void attachRouter(@NotNull BuyerInfoPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.rating.publish.buyer_info.BuyerInfoPresenter
    public void attachView(@NotNull BuyerInfoView buyerInfoView) {
        Intrinsics.checkNotNullParameter(buyerInfoView, "view");
        this.a = buyerInfoView;
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = buyerInfoView.navigationClicks().subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.navigationClicks().…onBackPressed()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = buyerInfoView.buttonClicks().subscribe(new b(this, buyerInfoView));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.buttonClicks().subs…e\n            )\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = buyerInfoView.textChanges().subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.textChanges().subsc…e\n            )\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        buyerInfoView.setText(this.e);
        if (this.g.isLastStep()) {
            BuyerInfoView buyerInfoView2 = this.a;
            if (buyerInfoView2 != null) {
                buyerInfoView2.showSendButton();
                return;
            }
            return;
        }
        BuyerInfoView buyerInfoView3 = this.a;
        if (buyerInfoView3 != null) {
            buyerInfoView3.showContinueButton();
        }
    }

    @Override // com.avito.android.rating.publish.buyer_info.BuyerInfoPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.rating.publish.buyer_info.BuyerInfoPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.rating.publish.buyer_info.BuyerInfoPresenter
    public void handleLoading(boolean z) {
        BuyerInfoView buyerInfoView = this.a;
        if (buyerInfoView != null) {
            buyerInfoView.showLoadingState(z);
        }
    }

    @Override // com.avito.android.rating.publish.buyer_info.BuyerInfoPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle();
    }
}
