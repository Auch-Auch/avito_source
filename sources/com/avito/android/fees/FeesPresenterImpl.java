package com.avito.android.fees;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.AdvertFeesResponse;
import com.avito.android.remote.model.OwnedPackage;
import com.avito.android.remote.model.SingleFee;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/fees/FeesPresenterImpl;", "Lcom/avito/android/fees/FeesPresenter;", "", "retry", "()V", "Lcom/avito/android/fees/FeesView;", "subscriber", "subscribe", "(Lcom/avito/android/fees/FeesView;)V", "unsubscribe", "load", "Lcom/avito/android/remote/model/AdvertFeesResponse;", "fees", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/AdvertFeesResponse;)V", "Lio/reactivex/disposables/Disposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/disposables/Disposable;", "subscription", "Lcom/avito/android/util/ErrorFormatter;", "e", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lcom/avito/android/fees/FeesView;", "feesView", "Lcom/avito/android/fees/FeesInteractor;", "c", "Lcom/avito/android/fees/FeesInteractor;", "feesInteractor", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Lcom/avito/android/fees/FeesInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/ErrorFormatter;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class FeesPresenterImpl implements FeesPresenter {
    public FeesView a;
    public Disposable b;
    public final FeesInteractor c;
    public final SchedulersFactory d;
    public final ErrorFormatter e;

    public static final class a<T> implements Consumer<AdvertFeesResponse> {
        public final /* synthetic */ FeesPresenterImpl a;

        public a(FeesPresenterImpl feesPresenterImpl) {
            this.a = feesPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(AdvertFeesResponse advertFeesResponse) {
            AdvertFeesResponse advertFeesResponse2 = advertFeesResponse;
            this.a.b = null;
            FeesPresenterImpl feesPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(advertFeesResponse2, "it");
            feesPresenterImpl.a(advertFeesResponse2);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ FeesPresenterImpl a;

        public b(FeesPresenterImpl feesPresenterImpl) {
            this.a = feesPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.util.ErrorFormatter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.b = null;
            String format = this.a.e.format(th);
            FeesView feesView = this.a.a;
            if (feesView != null) {
                feesView.onLoadingError(format);
            }
        }
    }

    public FeesPresenterImpl(@NotNull FeesInteractor feesInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorFormatter errorFormatter) {
        Intrinsics.checkNotNullParameter(feesInteractor, "feesInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        this.c = feesInteractor;
        this.d = schedulersFactory;
        this.e = errorFormatter;
    }

    public final void a(AdvertFeesResponse advertFeesResponse) {
        FeesView feesView = this.a;
        if (feesView != null) {
            SingleFee singleFee = advertFeesResponse.getSingleFee();
            Action action = advertFeesResponse.getAction();
            List<OwnedPackage> packages = advertFeesResponse.getPackages();
            if (singleFee != null && action != null) {
                feesView.onSingleFeeAvailable(singleFee, advertFeesResponse.getMessage(), action);
            } else if (packages != null) {
                feesView.onPackageFeeAvailable(packages, advertFeesResponse.getMessage());
            } else {
                feesView.onLoadingError();
            }
        }
    }

    public final void load() {
        if (this.b == null) {
            AdvertFeesResponse itemFeesResponse = this.c.getItemFeesResponse();
            if (itemFeesResponse != null) {
                a(itemFeesResponse);
                return;
            }
            FeesView feesView = this.a;
            if (feesView != null) {
                feesView.onLoadingStart();
            }
            Scheduler mainThread = this.d.mainThread();
            this.b = this.c.getFees().observeOn(mainThread).subscribeOn(this.d.io()).subscribe(new a(this), new b(this));
        }
    }

    @Override // com.avito.android.fees.FeesPresenter
    public void retry() {
        if (this.a != null) {
            load();
        }
    }

    @Override // com.avito.android.legacy_mvp.Presenter
    public void unsubscribe() {
        this.a = null;
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        this.b = null;
    }

    public void subscribe(@NotNull FeesView feesView) {
        Intrinsics.checkNotNullParameter(feesView, "subscriber");
        this.a = feesView;
        load();
    }
}
