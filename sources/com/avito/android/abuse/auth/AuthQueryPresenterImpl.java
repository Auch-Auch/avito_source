package com.avito.android.abuse.auth;

import com.avito.android.abuse.auth.AuthQueryPresenter;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0017\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/avito/android/abuse/auth/AuthQueryPresenterImpl;", "Lcom/avito/android/abuse/auth/AuthQueryPresenter;", "Lcom/avito/android/abuse/auth/AuthQueryView;", "view", "", "attachView", "(Lcom/avito/android/abuse/auth/AuthQueryView;)V", "detachView", "()V", "Lcom/avito/android/abuse/auth/AuthQueryPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/abuse/auth/AuthQueryPresenter$Router;)V", "detachRouter", "onBackPressed", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", AuthSource.BOOKING_ORDER, "Lcom/avito/android/abuse/auth/AuthQueryPresenter$Router;", AuthSource.SEND_ABUSE, "Lcom/avito/android/abuse/auth/AuthQueryView;", "<init>", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class AuthQueryPresenterImpl implements AuthQueryPresenter {
    public AuthQueryView a;
    public AuthQueryPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();

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
                ((AuthQueryPresenterImpl) this.b).onBackPressed();
            } else if (i == 1) {
                AuthQueryPresenter.Router router = ((AuthQueryPresenterImpl) this.b).b;
                if (router != null) {
                    router.showLoginScreen();
                }
            } else if (i == 2) {
                AuthQueryPresenter.Router router2 = ((AuthQueryPresenterImpl) this.b).b;
                if (router2 != null) {
                    router2.closeWithResult();
                }
            } else {
                throw null;
            }
        }
    }

    @Override // com.avito.android.abuse.auth.AuthQueryPresenter
    public void attachRouter(@NotNull AuthQueryPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.abuse.auth.AuthQueryPresenter
    public void attachView(@NotNull AuthQueryView authQueryView) {
        Intrinsics.checkNotNullParameter(authQueryView, "view");
        this.a = authQueryView;
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = authQueryView.backClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.backClicks().subscr…onBackPressed()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = authQueryView.authClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.authClicks().subscr…owLoginScreen()\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.c;
        Disposable subscribe3 = authQueryView.sendClicks().subscribe(new a(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.sendClicks().subscr…oseWithResult()\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
    }

    @Override // com.avito.android.abuse.auth.AuthQueryPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.abuse.auth.AuthQueryPresenter
    public void detachView() {
        this.c.clear();
    }

    @Override // com.avito.android.abuse.auth.AuthQueryPresenter
    public void onBackPressed() {
        AuthQueryPresenter.Router router = this.b;
        if (router != null) {
            router.leaveScreen();
        }
    }
}
