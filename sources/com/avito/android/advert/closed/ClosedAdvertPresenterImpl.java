package com.avito.android.advert.closed;

import a2.a.a.f.v.e;
import a2.a.a.f.v.f;
import a2.a.a.f.v.h;
import a2.g.r.g;
import com.avito.android.advert.closed.di.ClosedAdvertModule;
import com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Formatter;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Flowables;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001BA\b\u0007\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020)0(\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b/\u00100J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u0004*\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\fR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/avito/android/advert/closed/ClosedAdvertPresenterImpl;", "Lcom/avito/android/advert/closed/ClosedAdvertPresenter;", "Lcom/avito/android/advert/closed/ClosedAdvertRouter;", "router", "", "attachRouter", "(Lcom/avito/android/advert/closed/ClosedAdvertRouter;)V", "detachRouter", "()V", "Lcom/avito/android/advert/closed/ClosedAdvertView;", "view", "attachView", "(Lcom/avito/android/advert/closed/ClosedAdvertView;)V", "detachView", AuthSource.SEND_ABUSE, "", "d", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/advert/closed/ClosedAdvertResourcesProvider;", "h", "Lcom/avito/android/advert/closed/ClosedAdvertResourcesProvider;", "resourcesProvider", "Lcom/avito/android/util/SchedulersFactory3;", "i", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "c", "Lcom/avito/android/advert/closed/ClosedAdvertRouter;", "Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;", "f", "Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;", "viewedAdvertsInteractor", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractor;", "e", "Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractor;", "favoriteInteractor", "Lcom/avito/android/util/Formatter;", "", g.a, "Lcom/avito/android/util/Formatter;", "errorFormatter", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/closed/ClosedAdvertView;", "<init>", "(Ljava/lang/String;Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractor;Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;Lcom/avito/android/util/Formatter;Lcom/avito/android/advert/closed/ClosedAdvertResourcesProvider;Lcom/avito/android/util/SchedulersFactory3;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class ClosedAdvertPresenterImpl implements ClosedAdvertPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public ClosedAdvertView b;
    public ClosedAdvertRouter c;
    public final String d;
    public final AdvertDetailsFavoriteInteractor e;
    public final ViewedAdvertsInteractor f;
    public final Formatter<Throwable> g;
    public final ClosedAdvertResourcesProvider h;
    public final SchedulersFactory3 i;

    public static final class a<T> implements Consumer<Unit> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class c<T> implements Consumer<Boolean> {
        public final /* synthetic */ ClosedAdvertView a;

        public c(ClosedAdvertView closedAdvertView) {
            this.a = closedAdvertView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            ClosedAdvertView closedAdvertView = this.a;
            Intrinsics.checkNotNullExpressionValue(bool2, "isFavorite");
            closedAdvertView.setFavoriteVisible(bool2.booleanValue());
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ ClosedAdvertPresenterImpl a;
        public final /* synthetic */ ClosedAdvertView b;

        public d(ClosedAdvertPresenterImpl closedAdvertPresenterImpl, ClosedAdvertView closedAdvertView) {
            this.a = closedAdvertPresenterImpl;
            this.b = closedAdvertView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            ClosedAdvertPresenterImpl closedAdvertPresenterImpl = this.a;
            ClosedAdvertView closedAdvertView = this.b;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            ClosedAdvertPresenterImpl.access$showError(closedAdvertPresenterImpl, closedAdvertView, th2);
        }
    }

    @Inject
    public ClosedAdvertPresenterImpl(@ClosedAdvertModule.AdvertId @NotNull String str, @NotNull AdvertDetailsFavoriteInteractor advertDetailsFavoriteInteractor, @NotNull ViewedAdvertsInteractor viewedAdvertsInteractor, @NotNull Formatter<Throwable> formatter, @NotNull ClosedAdvertResourcesProvider closedAdvertResourcesProvider, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(advertDetailsFavoriteInteractor, "favoriteInteractor");
        Intrinsics.checkNotNullParameter(viewedAdvertsInteractor, "viewedAdvertsInteractor");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(closedAdvertResourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.d = str;
        this.e = advertDetailsFavoriteInteractor;
        this.f = viewedAdvertsInteractor;
        this.g = formatter;
        this.h = closedAdvertResourcesProvider;
        this.i = schedulersFactory3;
    }

    public static final void access$showError(ClosedAdvertPresenterImpl closedAdvertPresenterImpl, ClosedAdvertView closedAdvertView, Throwable th) {
        closedAdvertView.showMessage(closedAdvertPresenterImpl.g.format(th));
    }

    public final void a(ClosedAdvertView closedAdvertView) {
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = this.e.isFavorite(this.d, false).observeOn(this.i.mainThread()).subscribe(new c(closedAdvertView), new d(this, closedAdvertView));
        Intrinsics.checkNotNullExpressionValue(subscribe, "favoriteInteractor.isFav…Error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.advert.closed.ClosedAdvertPresenter
    public void attachRouter(@NotNull ClosedAdvertRouter closedAdvertRouter) {
        Intrinsics.checkNotNullParameter(closedAdvertRouter, "router");
        this.c = closedAdvertRouter;
    }

    @Override // com.avito.android.advert.closed.ClosedAdvertPresenter
    public void attachView(@NotNull ClosedAdvertView closedAdvertView) {
        Intrinsics.checkNotNullParameter(closedAdvertView, "view");
        this.b = closedAdvertView;
        closedAdvertView.setupToolbar();
        CompositeDisposable compositeDisposable = this.a;
        Observable<Unit> upButtonClicks = closedAdvertView.upButtonClicks();
        BackpressureStrategy backpressureStrategy = BackpressureStrategy.DROP;
        DisposableKt.plusAssign(compositeDisposable, Flowables.subscribeOnNext(a2.b.a.a.a.Z1(this.i, upButtonClicks.toFlowable(backpressureStrategy), "upButtonClicks()\n       …(schedulers.mainThread())"), new h(this)));
        CompositeDisposable compositeDisposable2 = this.a;
        Disposable subscribe = closedAdvertView.favoriteButtonClicks().toFlowable(backpressureStrategy).flatMapSingle(new a2.a.a.f.v.a(this)).observeOn(this.i.mainThread()).subscribe(new a2.a.a.f.v.b(closedAdvertView), new a2.a.a.f.v.c(this, closedAdvertView));
        Intrinsics.checkNotNullExpressionValue(subscribe, "favoriteButtonClicks()\n …Error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable2, subscribe);
        CompositeDisposable compositeDisposable3 = this.a;
        Disposable subscribe2 = this.e.favoriteInvalidatedEvent().observeOn(this.i.mainThread()).subscribe(new f(this), a2.a.a.f.v.g.a);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "favoriteInteractor\n     …() }, { Logs.error(it) })");
        DisposableKt.plusAssign(compositeDisposable3, subscribe2);
        CompositeDisposable compositeDisposable4 = this.a;
        Disposable subscribe3 = this.e.favoriteChangeEvents(this.d).observeOn(this.i.mainThread()).subscribe(new a2.a.a.f.v.d(this), e.a);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "favoriteInteractor\n     …   }, { Logs.error(it) })");
        DisposableKt.plusAssign(compositeDisposable4, subscribe3);
        CompositeDisposable compositeDisposable5 = this.a;
        Disposable subscribe4 = this.f.markAsViewed(this.d).subscribe(a.a, b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe4, "viewedAdvertsInteractor.…e({}, { Logs.error(it) })");
        DisposableKt.plusAssign(compositeDisposable5, subscribe4);
        a(closedAdvertView);
    }

    @Override // com.avito.android.advert.closed.ClosedAdvertPresenter
    public void detachRouter() {
        this.c = null;
    }

    @Override // com.avito.android.advert.closed.ClosedAdvertPresenter
    public void detachView() {
        this.a.clear();
        this.b = null;
    }
}
