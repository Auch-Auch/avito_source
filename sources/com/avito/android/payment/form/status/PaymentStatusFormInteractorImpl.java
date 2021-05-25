package com.avito.android.payment.form.status;

import android.os.Parcelable;
import com.avito.android.payment.caching_interactor.CachingInteractor;
import com.avito.android.payment.caching_interactor.SealedResultCachingInteractor;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.payment.status.form.PaymentStatusFormResult;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B)\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J6\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/avito/android/payment/form/status/PaymentStatusFormInteractorImpl;", "Lcom/avito/android/payment/form/status/PaymentStatusFormInteractor;", "Lcom/avito/android/payment/caching_interactor/CachingInteractor;", "Lcom/avito/android/remote/model/payment/status/form/PaymentStatusFormResult;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "getPaymentStatusForm", "()Lio/reactivex/Observable;", "", "forceUpdate", "", "", "nativeMethods", "load", "(ZLjava/util/Set;)Lio/reactivex/Observable;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/payment/remote/PaymentApi;", "api", AnalyticFieldsName.orderId, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "state", "<init>", "(Lcom/avito/android/payment/remote/PaymentApi;Ljava/lang/String;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/Kundle;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentStatusFormInteractorImpl implements PaymentStatusFormInteractor, CachingInteractor<PaymentStatusFormResult> {
    public final /* synthetic */ SealedResultCachingInteractor<PaymentStatusFormResult> a;

    public static final class a extends Lambda implements Function0<Observable<TypedResult<PaymentStatusFormResult>>> {
        public final /* synthetic */ PaymentApi a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PaymentApi paymentApi, String str) {
            super(0);
            this.a = paymentApi;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Observable<TypedResult<PaymentStatusFormResult>> invoke() {
            return InteropKt.toV2(this.a.getPaymentStatusForm(this.b));
        }
    }

    public static final class b extends Lambda implements Function2<PaymentStatusFormResult, Kundle, Unit> {
        public static final b a = new b();

        public b() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(PaymentStatusFormResult paymentStatusFormResult, Kundle kundle) {
            PaymentStatusFormResult paymentStatusFormResult2 = paymentStatusFormResult;
            Kundle kundle2 = kundle;
            Intrinsics.checkNotNullParameter(paymentStatusFormResult2, "result");
            Intrinsics.checkNotNullParameter(kundle2, "kundle");
            if (paymentStatusFormResult2 instanceof PaymentStatusFormResult.StatusForm) {
                kundle2.putParcelable("PaymentStatusFormInteractor_cached_results", (Parcelable) paymentStatusFormResult2);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Kundle, PaymentStatusFormResult> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PaymentStatusFormResult invoke(Kundle kundle) {
            Kundle kundle2 = kundle;
            Intrinsics.checkNotNullParameter(kundle2, "kundle");
            if (kundle2.contains("PaymentStatusFormInteractor_cached_results")) {
                return (PaymentStatusFormResult.StatusForm) kundle2.getParcelable("PaymentStatusFormInteractor_cached_results");
            }
            return null;
        }
    }

    public PaymentStatusFormInteractorImpl(@NotNull PaymentApi paymentApi, @NotNull String str, @NotNull SchedulersFactory schedulersFactory, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(paymentApi, "api");
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.orderId);
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = new SealedResultCachingInteractor<>(schedulersFactory, kundle, new a(paymentApi, str), b.a, c.a);
    }

    @Override // com.avito.android.payment.form.status.PaymentStatusFormInteractor
    @NotNull
    public Observable<LoadingState<PaymentStatusFormResult>> getPaymentStatusForm() {
        return CachingInteractor.DefaultImpls.load$default(this, false, null, 3, null);
    }

    @Override // com.avito.android.payment.caching_interactor.CachingInteractor
    @NotNull
    public Observable<LoadingState<PaymentStatusFormResult>> load(boolean z, @NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "nativeMethods");
        return this.a.load(z, set);
    }

    @Override // com.avito.android.payment.form.status.PaymentStatusFormInteractor, com.avito.android.payment.caching_interactor.CachingInteractor
    @NotNull
    public Kundle onSaveState() {
        return this.a.onSaveState();
    }
}
