package com.avito.android.info.ui;

import a2.g.r.g;
import android.os.Bundle;
import com.avito.android.info.business.InfoInteractor;
import com.avito.android.info.di.InfoActivityModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Info;
import com.avito.android.util.Flowables;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Publisher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\b\u0001\u0010)\u001a\u00020&\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010-\u001a\u00020*\u0012\n\b\u0001\u00103\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b4\u00105J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\fR\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R0\u00102\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0019 0*\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010/0/0.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u00101¨\u00066"}, d2 = {"Lcom/avito/android/info/ui/InfoPresenterImpl;", "Lcom/avito/android/info/ui/InfoPresenter;", "Lcom/avito/android/info/ui/InfoView;", "infoView", "", "attachView", "(Lcom/avito/android/info/ui/InfoView;)V", "Lcom/avito/android/info/ui/InfoRouter;", "router", "attachRouter", "(Lcom/avito/android/info/ui/InfoRouter;)V", "detachRouter", "()V", "detachView", "Landroid/os/Bundle;", "bundle", "saveState", "(Landroid/os/Bundle;)V", "close", "refresh", AuthSource.SEND_ABUSE, "Lcom/avito/android/info/business/InfoInteractor;", g.a, "Lcom/avito/android/info/business/InfoInteractor;", "infoInteractor", "Lcom/avito/android/remote/model/Info;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Info;", "info", "c", "Lcom/avito/android/info/ui/InfoRouter;", "infoRouter", "Lio/reactivex/disposables/Disposable;", "e", "Lio/reactivex/disposables/Disposable;", "subscription", "d", "Lcom/avito/android/info/ui/InfoView;", "", "f", "Ljava/lang/String;", "title", "Lcom/avito/android/util/SchedulersFactory;", "h", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lio/reactivex/subjects/PublishSubject;", "Lio/reactivex/Observable;", "kotlin.jvm.PlatformType", "Lio/reactivex/subjects/PublishSubject;", "publishSubject", "state", "<init>", "(Ljava/lang/String;Lcom/avito/android/info/business/InfoInteractor;Lcom/avito/android/util/SchedulersFactory;Landroid/os/Bundle;)V", "info_release"}, k = 1, mv = {1, 4, 2})
public final class InfoPresenterImpl implements InfoPresenter {
    public final PublishSubject<Observable<Info>> a;
    public Info b;
    public InfoRouter c;
    public InfoView d;
    public Disposable e;
    public final String f;
    public final InfoInteractor g;
    public final SchedulersFactory h;

    public static final class a<T, R> implements Function<Observable<Info>, Publisher<? extends Info>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Publisher<? extends Info> apply(Observable<Info> observable) {
            Observable<Info> observable2 = observable;
            Intrinsics.checkNotNullParameter(observable2, "it");
            return observable2.toFlowable(BackpressureStrategy.DROP);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ InfoPresenterImpl a;

        public b(InfoPresenterImpl infoPresenterImpl) {
            this.a = infoPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            InfoView infoView = this.a.d;
            if (infoView != null) {
                infoView.showError();
            }
            this.a.b = null;
        }
    }

    public static final class c<T> implements Consumer<Info> {
        public final /* synthetic */ InfoPresenterImpl a;

        public c(InfoPresenterImpl infoPresenterImpl) {
            this.a = infoPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Info info) {
            Info info2 = info;
            this.a.b = info2;
            InfoView infoView = this.a.d;
            if (infoView != null) {
                InfoPresenterImpl infoPresenterImpl = this.a;
                Intrinsics.checkNotNullExpressionValue(info2, "it");
                InfoPresenterImpl.access$show(infoPresenterImpl, infoView, info2);
            }
        }
    }

    @Inject
    public InfoPresenterImpl(@InfoActivityModule.InfoTitle @NotNull String str, @NotNull InfoInteractor infoInteractor, @NotNull SchedulersFactory schedulersFactory, @InfoActivityModule.InfoState @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(infoInteractor, "infoInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.f = str;
        this.g = infoInteractor;
        this.h = schedulersFactory;
        PublishSubject<Observable<Info>> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create<Observable<Info>>()");
        this.a = create;
        this.b = bundle != null ? (Info) bundle.getParcelable("key_info") : null;
    }

    public static final void access$show(InfoPresenterImpl infoPresenterImpl, InfoView infoView, Info info) {
        Objects.requireNonNull(infoPresenterImpl);
        infoView.setContent(info.getBaseUrl(), info.getText());
        infoView.showContent();
    }

    public final void a() {
        InfoView infoView = this.d;
        if (infoView != null) {
            infoView.showProgress();
        }
        this.a.onNext(this.g.load().observeOn(this.h.mainThread()).subscribeOn(this.h.io()).doOnError(new b(this)).doOnNext(new c(this)).onErrorResumeNext(Observable.empty()));
    }

    @Override // com.avito.android.info.ui.InfoPresenter
    public void attachRouter(@NotNull InfoRouter infoRouter) {
        Intrinsics.checkNotNullParameter(infoRouter, "router");
        this.c = infoRouter;
    }

    @Override // com.avito.android.info.ui.InfoPresenter
    public void attachView(@NotNull InfoView infoView) {
        Intrinsics.checkNotNullParameter(infoView, "infoView");
        Flowable<R> concatMap = this.a.toFlowable(BackpressureStrategy.DROP).concatMap(a.a);
        Intrinsics.checkNotNullExpressionValue(concatMap, "publishSubject\n         …kpressureStrategy.DROP) }");
        this.e = Flowables.subscribeIgnoreResult(concatMap);
        this.d = infoView;
        infoView.setTitle(this.f);
        Info info = this.b;
        if (info == null) {
            a();
            return;
        }
        infoView.setContent(info.getBaseUrl(), info.getText());
        infoView.showContent();
    }

    @Override // com.avito.android.info.ui.InfoView.Callback
    public void close() {
        InfoRouter infoRouter = this.c;
        if (infoRouter != null) {
            infoRouter.closeScreen();
        }
    }

    @Override // com.avito.android.info.ui.InfoPresenter
    public void detachRouter() {
        this.c = null;
    }

    @Override // com.avito.android.info.ui.InfoPresenter
    public void detachView() {
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d = null;
        this.e = null;
    }

    @Override // com.avito.android.info.ui.InfoView.Callback
    public void refresh() {
        a();
    }

    @Override // com.avito.android.info.ui.InfoPresenter
    public void saveState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        bundle.putParcelable("key_info", this.b);
    }
}
