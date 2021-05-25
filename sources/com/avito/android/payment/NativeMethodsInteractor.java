package com.avito.android.payment;

import a2.g.r.g;
import com.avito.android.app.external.ApplicationInfoProvider;
import com.avito.android.payment.google_pay.GooglePayRequestBuilder;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.PaymentMethodTypeKt;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.PaymentsClient;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b \u0010!J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR:\u0010\u0013\u001a&\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00070\u0007 \u0010*\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u000f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\tR:\u0010\u001f\u001a&\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00070\u0007 \u0010*\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u000f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0012¨\u0006\""}, d2 = {"Lcom/avito/android/payment/NativeMethodsInteractor;", "", "Lio/reactivex/Observable;", "", "", "getNativeMethods", "()Lio/reactivex/Observable;", "", "f", "Z", "googlePayEnabled", "Lcom/google/android/gms/wallet/PaymentsClient;", "d", "Lcom/google/android/gms/wallet/PaymentsClient;", "paymentsClient", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "googlePayEnabledRelay", "Lcom/avito/android/payment/google_pay/GooglePayRequestBuilder;", "e", "Lcom/avito/android/payment/google_pay/GooglePayRequestBuilder;", "googlePayRequestBuilder", "Lcom/avito/android/app/external/ApplicationInfoProvider;", "c", "Lcom/avito/android/app/external/ApplicationInfoProvider;", "appInfoProvider", g.a, "overrideGooglePayEnabled", AuthSource.BOOKING_ORDER, "sberbankOnlineAppEnabledRelay", "<init>", "(Lcom/avito/android/app/external/ApplicationInfoProvider;Lcom/google/android/gms/wallet/PaymentsClient;Lcom/avito/android/payment/google_pay/GooglePayRequestBuilder;ZZ)V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public class NativeMethodsInteractor {
    public final BehaviorRelay<Boolean> a = BehaviorRelay.create();
    public final BehaviorRelay<Boolean> b;
    public final ApplicationInfoProvider c;
    public final PaymentsClient d;
    public final GooglePayRequestBuilder e;
    public final boolean f;
    public final boolean g;

    public static final class a<TResult> implements OnCompleteListener<Boolean> {
        public final /* synthetic */ NativeMethodsInteractor a;

        public a(NativeMethodsInteractor nativeMethodsInteractor) {
            this.a = nativeMethodsInteractor;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(@NotNull Task<Boolean> task) {
            Intrinsics.checkNotNullParameter(task, "it");
            boolean z = true;
            try {
                Boolean result = task.getResult(ApiException.class);
                this.a.a.accept(Boolean.valueOf(this.a.f && (this.a.g || (result != null ? result.booleanValue() : false))));
            } catch (ApiException unused) {
                BehaviorRelay behaviorRelay = this.a.a;
                if (!this.a.f || !this.a.g) {
                    z = false;
                }
                behaviorRelay.accept(Boolean.valueOf(z));
            }
        }
    }

    public NativeMethodsInteractor(@NotNull ApplicationInfoProvider applicationInfoProvider, @NotNull PaymentsClient paymentsClient, @NotNull GooglePayRequestBuilder googlePayRequestBuilder, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(applicationInfoProvider, "appInfoProvider");
        Intrinsics.checkNotNullParameter(paymentsClient, "paymentsClient");
        Intrinsics.checkNotNullParameter(googlePayRequestBuilder, "googlePayRequestBuilder");
        this.c = applicationInfoProvider;
        this.d = paymentsClient;
        this.e = googlePayRequestBuilder;
        this.f = z;
        this.g = z2;
        BehaviorRelay<Boolean> create = BehaviorRelay.create();
        this.b = create;
        paymentsClient.isReadyToPay(IsReadyToPayRequest.fromJson(googlePayRequestBuilder.getIsReadyToPayRequest().toString())).addOnCompleteListener(new a(this));
        create.accept(Boolean.valueOf(applicationInfoProvider.isAppInstalled("ru.sberbankmobile") && SberbankOnlineKt.isVersionSupported(applicationInfoProvider.getVersionCode("ru.sberbankmobile"))));
    }

    @NotNull
    public Observable<Set<String>> getNativeMethods() {
        BehaviorRelay<Boolean> behaviorRelay = this.a;
        Intrinsics.checkNotNullExpressionValue(behaviorRelay, "googlePayEnabledRelay");
        BehaviorRelay<Boolean> behaviorRelay2 = this.b;
        Intrinsics.checkNotNullExpressionValue(behaviorRelay2, "sberbankOnlineAppEnabledRelay");
        Observable<Set<String>> zip = Observable.zip(behaviorRelay, behaviorRelay2, new BiFunction<T1, T2, R>() { // from class: com.avito.android.payment.NativeMethodsInteractor$getNativeMethods$$inlined$zip$1
            /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0017: APUT  (r0v1 java.lang.String[]), (0 ??[int, short, byte, char]), (r4v3 java.lang.String) */
            @Override // io.reactivex.functions.BiFunction
            public final R apply(T1 t1, T2 t2) {
                boolean booleanValue = t2.booleanValue();
                String[] strArr = new String[2];
                String str = null;
                strArr[0] = t1.booleanValue() ? "google-pay" : null;
                if (booleanValue) {
                    str = PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_SBERBANK_APP;
                }
                strArr[1] = str;
                return (R) CollectionsKt___CollectionsKt.toSet(CollectionsKt__CollectionsKt.listOfNotNull((Object[]) strArr));
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "Observables.zip(\n       …      ).toSet()\n        }");
        return zip;
    }
}
