package com.avito.android.publish.premoderation;

import a2.a.a.e2.y.a;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.publish.premoderation.AdvertDuplicatePresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertDuplicateResult;
import com.avito.android.remote.model.AdvertImage;
import com.avito.android.remote.model.SerpAdvert;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/publish/premoderation/AdvertDuplicatePresenterImpl;", "Lcom/avito/android/publish/premoderation/AdvertDuplicatePresenter;", "Lcom/avito/android/publish/premoderation/AdvertDuplicateView;", "view", "", "attachView", "(Lcom/avito/android/publish/premoderation/AdvertDuplicateView;)V", "Lcom/avito/android/publish/premoderation/AdvertDuplicatePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/publish/premoderation/AdvertDuplicatePresenter$Router;)V", "detachView", "()V", "detachRouter", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/premoderation/AdvertDuplicateView;", "Lcom/avito/android/remote/model/AdvertDuplicateResult;", "e", "Lcom/avito/android/remote/model/AdvertDuplicateResult;", "advert", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/premoderation/AdvertDuplicatePresenter$Router;", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/model/AdvertDuplicateResult;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDuplicatePresenterImpl implements AdvertDuplicatePresenter {
    public AdvertDuplicateView a;
    public AdvertDuplicatePresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final SchedulersFactory d;
    public final AdvertDuplicateResult e;

    public AdvertDuplicatePresenterImpl(@NotNull SchedulersFactory schedulersFactory, @NotNull AdvertDuplicateResult advertDuplicateResult) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(advertDuplicateResult, "advert");
        this.d = schedulersFactory;
        this.e = advertDuplicateResult;
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicatePresenter
    public void attachRouter(@NotNull AdvertDuplicatePresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicatePresenter
    public void attachView(@NotNull AdvertDuplicateView advertDuplicateView) {
        Intrinsics.checkNotNullParameter(advertDuplicateView, "view");
        this.a = advertDuplicateView;
        AdvertDuplicateResult advertDuplicateResult = this.e;
        advertDuplicateView.showTitle(advertDuplicateResult.getTitle());
        advertDuplicateView.showDescription(advertDuplicateResult.getDescription());
        advertDuplicateView.showHint(advertDuplicateResult.getHint());
        SerpAdvert item = advertDuplicateResult.getItem();
        AdvertImage image = item.getImage();
        advertDuplicateView.showAdvertImage(AvitoPictureKt.pictureOf$default(image != null ? image.getImage() : null, false, 0.0f, 1.5f, null, 20, null));
        advertDuplicateView.showAdvertTitle(item.getTitle());
        advertDuplicateView.showAdvertPrice(item.getPrice());
        advertDuplicateView.setActionTitle(advertDuplicateResult.getAction().getTitle());
        advertDuplicateView.setSkipActionTitle(advertDuplicateResult.getSkipActionTitle());
        CompositeDisposable compositeDisposable = this.c;
        Observable<Unit> subscribeOn = advertDuplicateView.actionClicks().subscribeOn(this.d.mainThread());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "actionClicks()\n         …(schedulers.mainThread())");
        DisposableKt.plusAssign(compositeDisposable, Observables.subscribeOnNext(subscribeOn, new a(this, advertDuplicateResult)));
        CompositeDisposable compositeDisposable2 = this.c;
        Observable<Unit> subscribeOn2 = advertDuplicateView.skipActionClicks().subscribeOn(this.d.mainThread());
        Intrinsics.checkNotNullExpressionValue(subscribeOn2, "skipActionClicks()\n     …(schedulers.mainThread())");
        DisposableKt.plusAssign(compositeDisposable2, Observables.subscribeOnNext(subscribeOn2, new y5(0, this)));
        CompositeDisposable compositeDisposable3 = this.c;
        Observable<Unit> subscribeOn3 = advertDuplicateView.upClicks().subscribeOn(this.d.mainThread());
        Intrinsics.checkNotNullExpressionValue(subscribeOn3, "upClicks()\n            .…(schedulers.mainThread())");
        DisposableKt.plusAssign(compositeDisposable3, Observables.subscribeOnNext(subscribeOn3, new y5(1, this)));
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicatePresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.publish.premoderation.AdvertDuplicatePresenter
    public void detachView() {
        this.c.clear();
    }
}
