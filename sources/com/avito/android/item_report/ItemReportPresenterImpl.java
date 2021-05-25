package com.avito.android.item_report;

import a2.g.r.g;
import android.os.Bundle;
import com.avito.android.item_report.ItemReportPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertReport;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.NetworkException;
import com.avito.android.util.SchedulersFactory;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u0007\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0007\u0010\nJ\u0019\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/avito/android/item_report/ItemReportPresenterImpl;", "Lcom/avito/android/item_report/ItemReportPresenter;", "", "load", "()V", "Landroid/os/Bundle;", VKApiConst.OUT, "onSaveState", "(Landroid/os/Bundle;)V", "", "()Ljava/lang/Void;", "savedInstanceState", "onRestoreState", "Lcom/avito/android/item_report/ItemReportPresenter$Subscriber;", "subscriber", "subscribe", "(Lcom/avito/android/item_report/ItemReportPresenter$Subscriber;)V", "unsubscribe", "Lcom/avito/android/remote/model/AdvertReport;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/AdvertReport;", "report", "Lio/reactivex/disposables/Disposable;", "c", "Lio/reactivex/disposables/Disposable;", "disposable", "Lcom/avito/android/util/ErrorFormatter;", g.a, "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lcom/avito/android/item_report/ItemReportInteractor;", "e", "Lcom/avito/android/item_report/ItemReportInteractor;", "interactor", "", "d", "Ljava/lang/String;", "itemId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/item_report/ItemReportPresenter$Subscriber;", "Lcom/avito/android/util/SchedulersFactory;", "f", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Ljava/lang/String;Lcom/avito/android/item_report/ItemReportInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/ErrorFormatter;)V", "item-report_release"}, k = 1, mv = {1, 4, 2})
public final class ItemReportPresenterImpl implements ItemReportPresenter {
    public AdvertReport a;
    public ItemReportPresenter.Subscriber b;
    public Disposable c;
    public final String d;
    public final ItemReportInteractor e;
    public final SchedulersFactory f;
    public final ErrorFormatter g;

    public static final class a<T> implements Consumer<AdvertReport> {
        public final /* synthetic */ ItemReportPresenterImpl a;

        public a(ItemReportPresenterImpl itemReportPresenterImpl) {
            this.a = itemReportPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(AdvertReport advertReport) {
            AdvertReport advertReport2 = advertReport;
            ItemReportPresenterImpl itemReportPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(advertReport2, "it");
            ItemReportPresenterImpl.access$finish(itemReportPresenterImpl, advertReport2);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ ItemReportPresenterImpl a;

        public b(ItemReportPresenterImpl itemReportPresenterImpl) {
            this.a = itemReportPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            ItemReportPresenterImpl itemReportPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            ItemReportPresenterImpl.access$error(itemReportPresenterImpl, th2);
        }
    }

    public ItemReportPresenterImpl(@NotNull String str, @NotNull ItemReportInteractor itemReportInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorFormatter errorFormatter) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(itemReportInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        this.d = str;
        this.e = itemReportInteractor;
        this.f = schedulersFactory;
        this.g = errorFormatter;
    }

    public static final void access$error(ItemReportPresenterImpl itemReportPresenterImpl, Throwable th) {
        Disposable disposable = itemReportPresenterImpl.c;
        if (disposable != null) {
            disposable.dispose();
        }
        itemReportPresenterImpl.c = null;
        ItemReportPresenter.Subscriber subscriber = itemReportPresenterImpl.b;
        if (subscriber == null) {
            return;
        }
        if (th instanceof NetworkException) {
            subscriber.onNetworkError();
        } else {
            subscriber.onFatalError(itemReportPresenterImpl.g.format(th));
        }
    }

    public static final void access$finish(ItemReportPresenterImpl itemReportPresenterImpl, AdvertReport advertReport) {
        Disposable disposable = itemReportPresenterImpl.c;
        if (disposable != null) {
            disposable.dispose();
        }
        itemReportPresenterImpl.c = null;
        ItemReportPresenter.Subscriber subscriber = itemReportPresenterImpl.b;
        if (subscriber != null) {
            subscriber.onFinish(advertReport);
        }
    }

    @Override // com.avito.android.item_report.ItemReportPresenter
    public void load() {
        ItemReportPresenter.Subscriber subscriber = this.b;
        if (subscriber != null) {
            AdvertReport advertReport = this.a;
            if (advertReport != null) {
                Disposable disposable = this.c;
                if (disposable != null) {
                    disposable.dispose();
                }
                this.c = null;
                ItemReportPresenter.Subscriber subscriber2 = this.b;
                if (subscriber2 != null) {
                    subscriber2.onFinish(advertReport);
                }
            } else if (this.c == null) {
                subscriber.showProgress();
                this.c = this.e.getReport(this.d).observeOn(this.f.mainThread()).subscribeOn(this.f.io()).subscribe(new a(this), new b(this));
            }
        }
    }

    @Override // com.avito.android.util.BundlePersistable
    public void onRestoreState(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.a = (AdvertReport) bundle.getParcelable(ItemReportPresenterKt.KEY_ITEM_REPORT);
        }
    }

    @Override // com.avito.android.util.BundlePersistable
    @Nullable
    public Void onSaveState() {
        return null;
    }

    @Override // com.avito.android.legacy_mvp.Presenter
    public void unsubscribe() {
        this.b = null;
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = null;
    }

    @Override // com.avito.android.util.BundlePersistable
    public void onSaveState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, VKApiConst.OUT);
        AdvertReport advertReport = this.a;
        if (advertReport != null) {
            bundle.putParcelable(ItemReportPresenterKt.KEY_ITEM_REPORT, advertReport);
        }
    }

    public void subscribe(@NotNull ItemReportPresenter.Subscriber subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        this.b = subscriber;
    }
}
