package com.avito.android.update;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.update.UpdateApplicationPresenter;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0016\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/avito/android/update/UpdateApplicationPresenterImpl;", "Lcom/avito/android/update/UpdateApplicationPresenter;", "Lcom/avito/android/update/UpdateApplicationView;", "view", "", "attachView", "(Lcom/avito/android/update/UpdateApplicationView;)V", "detachView", "()V", "Lcom/avito/android/update/UpdateApplicationPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/update/UpdateApplicationPresenter$Router;)V", "detachRouter", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", AuthSource.BOOKING_ORDER, "Lcom/avito/android/update/UpdateApplicationPresenter$Router;", AuthSource.SEND_ABUSE, "Lcom/avito/android/update/UpdateApplicationView;", "<init>", "update_release"}, k = 1, mv = {1, 4, 2})
public final class UpdateApplicationPresenterImpl implements UpdateApplicationPresenter {
    public UpdateApplicationView a;
    public UpdateApplicationPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();

    public static final class a<T, R> implements Function<Unit, CompletableSource> {
        public final /* synthetic */ UpdateApplicationPresenterImpl a;

        public a(UpdateApplicationPresenterImpl updateApplicationPresenterImpl) {
            this.a = updateApplicationPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public CompletableSource apply(Unit unit) {
            Completable openPlayStore;
            Intrinsics.checkNotNullParameter(unit, "it");
            UpdateApplicationPresenter.Router router = this.a.b;
            return (router == null || (openPlayStore = router.openPlayStore()) == null) ? Completable.complete() : openPlayStore;
        }
    }

    public static final class b implements Action {
        public static final b a = new b();

        @Override // io.reactivex.functions.Action
        public final void run() {
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ UpdateApplicationPresenterImpl a;

        public c(UpdateApplicationPresenterImpl updateApplicationPresenterImpl) {
            this.a = updateApplicationPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            UpdateApplicationPresenterImpl.access$openPlayStoreError(this.a);
        }
    }

    public static final void access$openPlayStoreError(UpdateApplicationPresenterImpl updateApplicationPresenterImpl) {
        UpdateApplicationView updateApplicationView = updateApplicationPresenterImpl.a;
        if (updateApplicationView != null) {
            updateApplicationView.showNoApplicationInstalledError();
        }
    }

    @Override // com.avito.android.update.UpdateApplicationPresenter
    public void attachRouter(@NotNull UpdateApplicationPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.update.UpdateApplicationPresenter
    public void attachView(@NotNull UpdateApplicationView updateApplicationView) {
        Intrinsics.checkNotNullParameter(updateApplicationView, "view");
        this.a = updateApplicationView;
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = updateApplicationView.updateButtonClicks().flatMapCompletable(new a(this)).subscribe(b.a, new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.updateButtonClicks(…ayStoreError()\n        })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.update.UpdateApplicationPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.update.UpdateApplicationPresenter
    public void detachView() {
        this.c.clear();
        this.a = null;
    }
}
