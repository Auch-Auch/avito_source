package com.avito.android.payment.processing;

import android.os.Parcelable;
import com.avito.android.Features;
import com.avito.android.payment.caching_interactor.CachingInteractor;
import com.avito.android.payment.caching_interactor.SealedResultCachingInteractor;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.remote.PaymentSessionTypeMarker;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.payment.generic.PaymentGenericResult;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import java.util.Map;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002BU\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J6\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006!"}, d2 = {"Lcom/avito/android/payment/processing/PaymentGenericInteractorImpl;", "Lcom/avito/android/payment/processing/PaymentGenericInteractor;", "Lcom/avito/android/payment/caching_interactor/CachingInteractor;", "Lcom/avito/android/remote/model/payment/generic/PaymentGenericResult;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "initPayment", "()Lio/reactivex/Observable;", "", "forceUpdate", "", "", "nativeMethods", "load", "(ZLjava/util/Set;)Lio/reactivex/Observable;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/payment/remote/PaymentApi;", "api", "paymentSessionId", "methodSignature", "", "params", "Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;", "paymentSessionTypeMarker", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/Features;", "features", "state", "<init>", "(Lcom/avito/android/payment/remote/PaymentApi;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;Lcom/avito/android/util/Kundle;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentGenericInteractorImpl implements PaymentGenericInteractor, CachingInteractor<PaymentGenericResult> {
    public final /* synthetic */ SealedResultCachingInteractor<PaymentGenericResult> a;

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

    public static final class a extends Lambda implements Function0<Observable<TypedResult<PaymentGenericResult>>> {
        public final /* synthetic */ PaymentSessionTypeMarker a;
        public final /* synthetic */ PaymentApi b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Map e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PaymentSessionTypeMarker paymentSessionTypeMarker, PaymentApi paymentApi, String str, String str2, Map map) {
            super(0);
            this.a = paymentSessionTypeMarker;
            this.b = paymentApi;
            this.c = str;
            this.d = str2;
            this.e = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Observable<TypedResult<PaymentGenericResult>> invoke() {
            int ordinal = this.a.ordinal();
            if (ordinal == 0) {
                return InteropKt.toV2(this.b.createPayment(this.c, this.d, this.e));
            }
            if (ordinal == 1) {
                return InteropKt.toV2(this.b.legacyCreatePayment(this.c, this.d, this.e));
            }
            if (ordinal == 2) {
                return InteropKt.toV2(this.b.createPayment(this.c, this.d, this.e));
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b extends Lambda implements Function2<PaymentGenericResult, Kundle, Unit> {
        public static final b a = new b();

        public b() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(PaymentGenericResult paymentGenericResult, Kundle kundle) {
            PaymentGenericResult paymentGenericResult2 = paymentGenericResult;
            Kundle kundle2 = kundle;
            Intrinsics.checkNotNullParameter(paymentGenericResult2, "result");
            Intrinsics.checkNotNullParameter(kundle2, "kundle");
            if (paymentGenericResult2 instanceof PaymentGenericResult.Ok) {
                kundle2.putParcelable("PaymentGenericInteractor_cached_results", (Parcelable) paymentGenericResult2);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Kundle, PaymentGenericResult> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PaymentGenericResult invoke(Kundle kundle) {
            Kundle kundle2 = kundle;
            Intrinsics.checkNotNullParameter(kundle2, "kundle");
            if (kundle2.contains("PaymentGenericInteractor_cached_results")) {
                return (PaymentGenericResult.Ok) kundle2.getParcelable("PaymentGenericInteractor_cached_results");
            }
            return null;
        }
    }

    public PaymentGenericInteractorImpl(@NotNull PaymentApi paymentApi, @NotNull String str, @NotNull String str2, @NotNull Map<String, String> map, @NotNull PaymentSessionTypeMarker paymentSessionTypeMarker, @NotNull SchedulersFactory schedulersFactory, @NotNull Features features, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(paymentApi, "api");
        Intrinsics.checkNotNullParameter(str, "paymentSessionId");
        Intrinsics.checkNotNullParameter(str2, "methodSignature");
        Intrinsics.checkNotNullParameter(map, "params");
        Intrinsics.checkNotNullParameter(paymentSessionTypeMarker, "paymentSessionTypeMarker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = new SealedResultCachingInteractor<>(schedulersFactory, kundle, new a(paymentSessionTypeMarker, paymentApi, str, str2, map), b.a, c.a);
    }

    @Override // com.avito.android.payment.processing.PaymentGenericInteractor
    @NotNull
    public Observable<LoadingState<PaymentGenericResult>> initPayment() {
        return CachingInteractor.DefaultImpls.load$default(this, false, null, 3, null);
    }

    @Override // com.avito.android.payment.caching_interactor.CachingInteractor
    @NotNull
    public Observable<LoadingState<PaymentGenericResult>> load(boolean z, @NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "nativeMethods");
        return this.a.load(z, set);
    }

    @Override // com.avito.android.payment.processing.PaymentGenericInteractor, com.avito.android.payment.caching_interactor.CachingInteractor
    @NotNull
    public Kundle onSaveState() {
        return this.a.onSaveState();
    }
}
