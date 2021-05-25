package com.avito.android.payment.form;

import android.os.Parcelable;
import com.avito.android.Features;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.payment.caching_interactor.CachingInteractor;
import com.avito.android.payment.caching_interactor.SealedResultCachingInteractor;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.remote.PaymentSessionTypeMarker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.payment.form.PaymentGenericFormResult;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.validation.LocalPretendInteractor;
import io.reactivex.Observable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002BI\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0010\u0012\u0006\u0010\u001e\u001a\u00020\u0010\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b&\u0010'J\u001b\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ6\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/avito/android/payment/form/PaymentGenericFormInteractorImpl;", "Lcom/avito/android/payment/form/PaymentGenericFormInteractor;", "Lcom/avito/android/payment/caching_interactor/CachingInteractor;", "Lcom/avito/android/remote/model/payment/form/PaymentGenericFormResult;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "getPaymentForm", "()Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/remote/model/PretendResult;", "validateUserInput", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lio/reactivex/Observable;", "", "forceUpdate", "", "", "nativeMethods", "load", "(ZLjava/util/Set;)Lio/reactivex/Observable;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/validation/LocalPretendInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/validation/LocalPretendInteractor;", "localPretendInteractor", "Lcom/avito/android/payment/remote/PaymentApi;", "api", "paymentSessionId", "methodSignature", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;", "paymentSessionTypeMarker", "state", "<init>", "(Lcom/avito/android/payment/remote/PaymentApi;Lcom/avito/android/validation/LocalPretendInteractor;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;Lcom/avito/android/util/Kundle;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentGenericFormInteractorImpl implements PaymentGenericFormInteractor, CachingInteractor<PaymentGenericFormResult> {
    public final LocalPretendInteractor a;
    public final /* synthetic */ SealedResultCachingInteractor<PaymentGenericFormResult> b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PaymentSessionTypeMarker.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
        }
    }

    public static final class a extends Lambda implements Function0<Observable<TypedResult<PaymentGenericFormResult>>> {
        public final /* synthetic */ PaymentSessionTypeMarker a;
        public final /* synthetic */ PaymentApi b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Features e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PaymentSessionTypeMarker paymentSessionTypeMarker, PaymentApi paymentApi, String str, String str2, Features features) {
            super(0);
            this.a = paymentSessionTypeMarker;
            this.b = paymentApi;
            this.c = str;
            this.d = str2;
            this.e = features;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Observable<TypedResult<PaymentGenericFormResult>> invoke() {
            int ordinal = this.a.ordinal();
            if (ordinal == 0) {
                return InteropKt.toV2(this.b.getPaymentForm(this.c, this.d));
            }
            if (ordinal == 1) {
                return InteropKt.toV2(this.b.legacyGetPaymentForm(this.c, this.d));
            }
            if (ordinal != 2) {
                throw new NoWhenBranchMatchedException();
            } else if (this.e.getBillingPaymentGenericFormUp().invoke().booleanValue()) {
                return InteropKt.toV2(this.b.getPaymentForm(this.c, this.d));
            } else {
                return InteropKt.toV2(this.b.legacyGetPaymentForm(this.c, this.d));
            }
        }
    }

    public static final class b extends Lambda implements Function2<PaymentGenericFormResult, Kundle, Unit> {
        public static final b a = new b();

        public b() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(PaymentGenericFormResult paymentGenericFormResult, Kundle kundle) {
            PaymentGenericFormResult paymentGenericFormResult2 = paymentGenericFormResult;
            Kundle kundle2 = kundle;
            Intrinsics.checkNotNullParameter(paymentGenericFormResult2, "result");
            Intrinsics.checkNotNullParameter(kundle2, "kundle");
            if (paymentGenericFormResult2 instanceof PaymentGenericFormResult.Ok) {
                kundle2.putParcelable("PaymentGenericFormInteractor_cached_results", (Parcelable) paymentGenericFormResult2);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Kundle, PaymentGenericFormResult> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PaymentGenericFormResult invoke(Kundle kundle) {
            Kundle kundle2 = kundle;
            Intrinsics.checkNotNullParameter(kundle2, "kundle");
            if (kundle2.contains("PaymentGenericFormInteractor_cached_results")) {
                return (PaymentGenericFormResult.Ok) kundle2.getParcelable("PaymentGenericFormInteractor_cached_results");
            }
            return null;
        }
    }

    public PaymentGenericFormInteractorImpl(@NotNull PaymentApi paymentApi, @NotNull LocalPretendInteractor localPretendInteractor, @NotNull String str, @NotNull String str2, @NotNull SchedulersFactory schedulersFactory, @NotNull Features features, @NotNull PaymentSessionTypeMarker paymentSessionTypeMarker, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(paymentApi, "api");
        Intrinsics.checkNotNullParameter(localPretendInteractor, "localPretendInteractor");
        Intrinsics.checkNotNullParameter(str, "paymentSessionId");
        Intrinsics.checkNotNullParameter(str2, "methodSignature");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(paymentSessionTypeMarker, "paymentSessionTypeMarker");
        this.b = new SealedResultCachingInteractor<>(schedulersFactory, kundle, new a(paymentSessionTypeMarker, paymentApi, str, str2, features), b.a, c.a);
        this.a = localPretendInteractor;
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormInteractor
    @NotNull
    public Observable<LoadingState<PaymentGenericFormResult>> getPaymentForm() {
        return CachingInteractor.DefaultImpls.load$default(this, false, null, 3, null);
    }

    @Override // com.avito.android.payment.caching_interactor.CachingInteractor
    @NotNull
    public Observable<LoadingState<PaymentGenericFormResult>> load(boolean z, @NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "nativeMethods");
        return this.b.load(z, set);
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormInteractor, com.avito.android.payment.caching_interactor.CachingInteractor
    @NotNull
    public Kundle onSaveState() {
        return this.b.onSaveState();
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormInteractor
    @NotNull
    public Observable<PretendResult> validateUserInput(@NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(parametersTree, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        return InteropKt.toV2(this.a.pretend(parametersTree));
    }
}
