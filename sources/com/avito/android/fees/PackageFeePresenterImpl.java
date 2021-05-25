package com.avito.android.fees;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/fees/PackageFeePresenterImpl;", "Lcom/avito/android/fees/PackageFeePresenter;", "", "packageId", "", "apply", "(J)V", "Lcom/avito/android/fees/PackageFeeView;", "subscriber", "subscribe", "(Lcom/avito/android/fees/PackageFeeView;)V", "unsubscribe", "()V", "Lcom/avito/android/fees/PackageFeeInteractor;", "c", "Lcom/avito/android/fees/PackageFeeInteractor;", "packageFeeInteractor", "Lcom/avito/android/util/ErrorFormatter;", "e", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lio/reactivex/disposables/Disposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/disposables/Disposable;", "subscription", AuthSource.SEND_ABUSE, "Lcom/avito/android/fees/PackageFeeView;", "packageFeeView", "<init>", "(Lcom/avito/android/fees/PackageFeeInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/ErrorFormatter;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class PackageFeePresenterImpl implements PackageFeePresenter {
    public PackageFeeView a;
    public Disposable b;
    public final PackageFeeInteractor c;
    public final SchedulersFactory d;
    public final ErrorFormatter e;

    public static final class a<T> implements Consumer<SuccessResult> {
        public final /* synthetic */ PackageFeePresenterImpl a;

        public a(PackageFeePresenterImpl packageFeePresenterImpl) {
            this.a = packageFeePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(SuccessResult successResult) {
            this.a.b = null;
            PackageFeeView packageFeeView = this.a.a;
            if (packageFeeView != null) {
                packageFeeView.onLoadingFinish();
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ PackageFeePresenterImpl a;

        public b(PackageFeePresenterImpl packageFeePresenterImpl) {
            this.a = packageFeePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.util.ErrorFormatter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.b = null;
            String format = this.a.e.format(th);
            PackageFeeView packageFeeView = this.a.a;
            if (packageFeeView != null) {
                packageFeeView.onLoadingError(format);
            }
        }
    }

    public PackageFeePresenterImpl(@NotNull PackageFeeInteractor packageFeeInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorFormatter errorFormatter) {
        Intrinsics.checkNotNullParameter(packageFeeInteractor, "packageFeeInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        this.c = packageFeeInteractor;
        this.d = schedulersFactory;
        this.e = errorFormatter;
    }

    @Override // com.avito.android.fees.PackageFeePresenter
    public void apply(long j) {
        if (this.b == null) {
            PackageFeeView packageFeeView = this.a;
            if (packageFeeView != null) {
                packageFeeView.onLoadingStart();
            }
            Scheduler mainThread = this.d.mainThread();
            this.b = this.c.applyPackage(j).observeOn(mainThread).subscribeOn(this.d.io()).subscribe(new a(this), new b(this));
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

    public void subscribe(@NotNull PackageFeeView packageFeeView) {
        Intrinsics.checkNotNullParameter(packageFeeView, "subscriber");
        this.a = packageFeeView;
    }
}
