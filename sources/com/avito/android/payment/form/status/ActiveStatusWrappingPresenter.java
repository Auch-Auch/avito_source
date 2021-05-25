package com.avito.android.payment.form.status;

import android.os.Parcelable;
import com.avito.android.payment.ModalErrorView;
import com.avito.android.payment.ModalState;
import com.avito.android.payment.ModalView;
import com.avito.android.payment.form.PaymentStatusProcessingPresenter;
import com.avito.android.payment.form.PaymentStatusProcessingRouter;
import com.avito.android.payment.processing.ProcessingResult;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SimpleUserDialog;
import com.avito.android.util.Kundle;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\b\u0010*\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0018\u0010\tR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR:\u0010%\u001a&\u0012\f\u0012\n \"*\u0004\u0018\u00010!0! \"*\u0012\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!\u0018\u00010 0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R:\u0010)\u001a&\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00050\u0005 \"*\u0012\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00050\u0005\u0018\u00010&0&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lcom/avito/android/payment/form/status/ActiveStatusWrappingPresenter;", "Lcom/avito/android/payment/form/status/StatusFormProcessingPresenter;", "Lcom/avito/android/payment/form/PaymentStatusProcessingPresenter;", "Lcom/avito/android/payment/processing/ProcessingResult;", "result", "", "processPayment", "(Lcom/avito/android/payment/processing/ProcessingResult;)V", "detachView", "()V", "Lcom/avito/android/payment/ModalView;", "view", "attachModalView", "(Lcom/avito/android/payment/ModalView;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/payment/form/PaymentStatusProcessingRouter;", "router", "attachRouter", "(Lcom/avito/android/payment/form/PaymentStatusProcessingRouter;)V", "Lcom/avito/android/payment/ModalErrorView;", "attachView", "(Lcom/avito/android/payment/ModalErrorView;)V", "detachRouter", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposable", "d", "Lcom/avito/android/payment/form/PaymentStatusProcessingPresenter;", "delegate", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "Lcom/avito/android/payment/ModalState;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "modalState", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "dialogClicksRelay", "savedState", "<init>", "(Lcom/avito/android/payment/form/PaymentStatusProcessingPresenter;Lcom/avito/android/util/Kundle;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class ActiveStatusWrappingPresenter implements StatusFormProcessingPresenter, PaymentStatusProcessingPresenter {
    public final BehaviorRelay<ModalState> a;
    public final PublishRelay<Unit> b;
    public final CompositeDisposable c;
    public final PaymentStatusProcessingPresenter d;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ ActiveStatusWrappingPresenter a;

        public a(ActiveStatusWrappingPresenter activeStatusWrappingPresenter) {
            this.a = activeStatusWrappingPresenter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.jakewharton.rxrelay2.BehaviorRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.a.accept(new ModalState.Empty());
        }
    }

    public ActiveStatusWrappingPresenter(@NotNull PaymentStatusProcessingPresenter paymentStatusProcessingPresenter, @Nullable Kundle kundle) {
        Object obj;
        Intrinsics.checkNotNullParameter(paymentStatusProcessingPresenter, "delegate");
        this.d = paymentStatusProcessingPresenter;
        if (kundle == null || !kundle.contains("ActiveStatusWrappingPresenter_ModalState")) {
            obj = new ModalState.Empty();
        } else {
            obj = (ModalState.NotifyingDialog) kundle.getParcelable("ActiveStatusWrappingPresenter_ModalState");
            if (obj == null) {
                obj = new ModalState.Empty();
            }
        }
        this.a = BehaviorRelay.createDefault(obj);
        PublishRelay<Unit> create = PublishRelay.create();
        this.b = create;
        this.c = new CompositeDisposable();
        create.subscribe(new a(this));
    }

    @Override // com.avito.android.payment.form.status.StatusFormProcessingPresenter
    public void attachModalView(@NotNull ModalView modalView) {
        Intrinsics.checkNotNullParameter(modalView, "view");
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.a.subscribe(modalView.getModalViewBinding());
        Intrinsics.checkNotNullExpressionValue(subscribe, "modalState.subscribe(view.modalViewBinding)");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = modalView.getDialogOkClicks().subscribe(this.b);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.dialogOkClicks.subscribe(dialogClicksRelay)");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    @Override // com.avito.android.payment.form.PaymentStatusProcessingPresenter
    public void attachRouter(@NotNull PaymentStatusProcessingRouter paymentStatusProcessingRouter) {
        Intrinsics.checkNotNullParameter(paymentStatusProcessingRouter, "router");
        this.d.attachRouter(paymentStatusProcessingRouter);
    }

    @Override // com.avito.android.payment.form.PaymentStatusProcessingPresenter
    public void attachView(@NotNull ModalErrorView modalErrorView) {
        Intrinsics.checkNotNullParameter(modalErrorView, "view");
        this.d.attachView(modalErrorView);
    }

    @Override // com.avito.android.payment.form.PaymentStatusProcessingPresenter
    public void detachRouter() {
        this.d.detachRouter();
    }

    @Override // com.avito.android.payment.form.PaymentStatusProcessingPresenter
    public void detachView() {
        this.c.clear();
        this.d.detachView();
    }

    @Override // com.avito.android.payment.form.status.StatusFormProcessingPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        BehaviorRelay<ModalState> behaviorRelay = this.a;
        Intrinsics.checkNotNullExpressionValue(behaviorRelay, "modalState");
        ModalState value = behaviorRelay.getValue();
        if (value instanceof ModalState.NotifyingDialog) {
            kundle.putParcelable("ActiveStatusWrappingPresenter_ModalState", (Parcelable) value);
        }
        return kundle;
    }

    @Override // com.avito.android.payment.form.PaymentStatusProcessingPresenter
    public void processPayment(@NotNull ProcessingResult processingResult) {
        Intrinsics.checkNotNullParameter(processingResult, "result");
        if (processingResult instanceof ProcessingResult.Finished) {
            ProcessingResult.Finished finished = (ProcessingResult.Finished) processingResult;
            if (Intrinsics.areEqual(finished.getPaymentStatus().getState(), "active")) {
                SimpleUserDialog userDialog = finished.getPaymentStatus().getUserDialog();
                if (userDialog != null) {
                    this.a.accept(new ModalState.NotifyingDialog(userDialog, false, 2, null));
                    return;
                }
                this.a.accept(new ModalState.Empty());
                return;
            }
        }
        this.d.processPayment(processingResult);
    }
}
