package com.avito.android.advert.cpo_program;

import a2.b.a.a.a;
import com.avito.android.advert.cpo_program.AutotekaCpoProgramPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CpoDescription;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Flowables;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramPresenterImpl;", "Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramPresenter;", "Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramView;", "view", "", "attachView", "(Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramView;)V", "detachView", "()V", "Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/model/CpoDescription;", "d", "Lcom/avito/android/remote/model/CpoDescription;", "cpoDescription", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramPresenter$Router;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/cpo_program/AutotekaCpoProgramView;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "<init>", "(Lcom/avito/android/remote/model/CpoDescription;Lcom/avito/android/util/SchedulersFactory3;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaCpoProgramPresenterImpl implements AutotekaCpoProgramPresenter {
    public AutotekaCpoProgramView a;
    public AutotekaCpoProgramPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CpoDescription d;
    public final SchedulersFactory3 e;

    @Inject
    public AutotekaCpoProgramPresenterImpl(@NotNull CpoDescription cpoDescription, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(cpoDescription, "cpoDescription");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.d = cpoDescription;
        this.e = schedulersFactory3;
    }

    @Override // com.avito.android.advert.cpo_program.AutotekaCpoProgramPresenter
    public void attachRouter(@NotNull AutotekaCpoProgramPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.advert.cpo_program.AutotekaCpoProgramPresenter
    public void attachView(@NotNull AutotekaCpoProgramView autotekaCpoProgramView) {
        Intrinsics.checkNotNullParameter(autotekaCpoProgramView, "view");
        this.a = autotekaCpoProgramView;
        DisposableKt.plusAssign(this.c, Flowables.subscribeOnNext(a.Z1(this.e, autotekaCpoProgramView.upButtonClicks().toFlowable(BackpressureStrategy.DROP), "upButtonClicks()\n       …(schedulers.mainThread())"), new a2.a.a.f.w.a(this)));
        autotekaCpoProgramView.showCpoProgram(this.d);
    }

    @Override // com.avito.android.advert.cpo_program.AutotekaCpoProgramPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.advert.cpo_program.AutotekaCpoProgramPresenter
    public void detachView() {
        this.c.clear();
    }
}
