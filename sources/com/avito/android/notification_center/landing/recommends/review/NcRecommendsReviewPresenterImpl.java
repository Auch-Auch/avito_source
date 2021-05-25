package com.avito.android.notification_center.landing.recommends.review;

import a2.g.r.g;
import com.avito.android.notification_center.landing.recommends.review.di.Hint;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\b\u0007\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010'\u001a\u00020$\u0012\b\u0010+\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b,\u0010-J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0018R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010)¨\u0006."}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewPresenterImpl;", "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewPresenter;", "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewView;", "view", "", "attachView", "(Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewView;)V", "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewRouter;", "router", "attachRouter", "(Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewRouter;)V", "Lcom/avito/android/util/Kundle;", "getState", "()Lcom/avito/android/util/Kundle;", "detachRouter", "()V", "detachView", AuthSource.SEND_ABUSE, "c", "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewView;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewRouter;", "", "f", "Ljava/lang/String;", "hint", "Lio/reactivex/disposables/Disposable;", "d", "Lio/reactivex/disposables/Disposable;", "disposable", "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewInteractor;", g.a, "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewInteractor;", "interactor", "e", "text", "Lcom/avito/android/util/SchedulersFactory;", "h", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "state", "<init>", "(Ljava/lang/String;Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/Kundle;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NcRecommendsReviewPresenterImpl implements NcRecommendsReviewPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public NcRecommendsReviewRouter b;
    public NcRecommendsReviewView c;
    public Disposable d;
    public String e;
    public final String f;
    public final NcRecommendsReviewInteractor g;
    public final SchedulersFactory h;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(1);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Unit unit) {
            int i = this.a;
            if (i == 0) {
                NcRecommendsReviewPresenterImpl.access$load((NcRecommendsReviewPresenterImpl) this.b);
                return Unit.INSTANCE;
            } else if (i == 1) {
                NcRecommendsReviewPresenterImpl.access$disposeRequest((NcRecommendsReviewPresenterImpl) this.b);
                return Unit.INSTANCE;
            } else if (i == 2) {
                NcRecommendsReviewRouter ncRecommendsReviewRouter = ((NcRecommendsReviewPresenterImpl) this.b).b;
                if (ncRecommendsReviewRouter != null) {
                    ncRecommendsReviewRouter.closeScreen();
                }
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ NcRecommendsReviewPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(NcRecommendsReviewPresenterImpl ncRecommendsReviewPresenterImpl) {
            super(1);
            this.a = ncRecommendsReviewPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            NcRecommendsReviewPresenterImpl ncRecommendsReviewPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            NcRecommendsReviewPresenterImpl.access$saveText(ncRecommendsReviewPresenterImpl, str2);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public NcRecommendsReviewPresenterImpl(@Hint @NotNull String str, @NotNull NcRecommendsReviewInteractor ncRecommendsReviewInteractor, @NotNull SchedulersFactory schedulersFactory, @Nullable Kundle kundle) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "hint");
        Intrinsics.checkNotNullParameter(ncRecommendsReviewInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.f = str;
        this.g = ncRecommendsReviewInteractor;
        this.h = schedulersFactory;
        this.e = (kundle == null || (str2 = kundle.getString("key_text")) == null) ? "" : str2;
    }

    public static final void access$disposeRequest(NcRecommendsReviewPresenterImpl ncRecommendsReviewPresenterImpl) {
        Disposable disposable = ncRecommendsReviewPresenterImpl.d;
        if (disposable != null) {
            disposable.dispose();
        }
        ncRecommendsReviewPresenterImpl.d = null;
    }

    public static final void access$load(NcRecommendsReviewPresenterImpl ncRecommendsReviewPresenterImpl) {
        Disposable disposable = ncRecommendsReviewPresenterImpl.d;
        if (disposable != null) {
            disposable.dispose();
        }
        ncRecommendsReviewPresenterImpl.d = Observables.subscribeOnNext(a2.b.a.a.a.T1(ncRecommendsReviewPresenterImpl.h, ncRecommendsReviewPresenterImpl.g.send(ncRecommendsReviewPresenterImpl.e), "interactor.send(text)\n  …lersFactory.mainThread())"), new a2.a.a.p1.a.b.a.a(ncRecommendsReviewPresenterImpl));
    }

    public static final void access$saveText(NcRecommendsReviewPresenterImpl ncRecommendsReviewPresenterImpl, String str) {
        Objects.requireNonNull(ncRecommendsReviewPresenterImpl);
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        ncRecommendsReviewPresenterImpl.e = StringsKt__StringsKt.trim(str).toString();
        ncRecommendsReviewPresenterImpl.a();
    }

    public final void a() {
        if (m.isBlank(this.e)) {
            NcRecommendsReviewView ncRecommendsReviewView = this.c;
            if (ncRecommendsReviewView != null) {
                ncRecommendsReviewView.disableButton();
                return;
            }
            return;
        }
        NcRecommendsReviewView ncRecommendsReviewView2 = this.c;
        if (ncRecommendsReviewView2 != null) {
            ncRecommendsReviewView2.enableButton();
        }
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewPresenter
    public void attachRouter(@NotNull NcRecommendsReviewRouter ncRecommendsReviewRouter) {
        Intrinsics.checkNotNullParameter(ncRecommendsReviewRouter, "router");
        this.b = ncRecommendsReviewRouter;
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewPresenter
    public void attachView(@NotNull NcRecommendsReviewView ncRecommendsReviewView) {
        Intrinsics.checkNotNullParameter(ncRecommendsReviewView, "view");
        this.c = ncRecommendsReviewView;
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.h, ncRecommendsReviewView.getTextChangeCallback(), "view.getTextChangeCallba…lersFactory.mainThread())"), new b(this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.h, ncRecommendsReviewView.getSaveButtonClicks(), "view.getSaveButtonClicks…lersFactory.mainThread())"), new a(0, this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.h, ncRecommendsReviewView.getCancelDialogCallback(), "view.getCancelDialogCall…lersFactory.mainThread())"), new a(1, this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.h, ncRecommendsReviewView.getBackButtonClicks(), "view.getBackButtonClicks…lersFactory.mainThread())"), new a(2, this)));
        ncRecommendsReviewView.showHint(this.f);
        ncRecommendsReviewView.showText(this.e);
        a();
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewPresenter
    public void detachView() {
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d = null;
        this.a.clear();
        this.c = null;
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewPresenter
    @NotNull
    public Kundle getState() {
        return new Kundle().putString("key_text", this.e);
    }
}
