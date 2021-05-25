package com.avito.android.payment.processing;

import com.avito.android.Features;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.remote.PaymentSessionTypeMarker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\"\u0010#J1\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/payment/processing/PaymentGenericFactory;", "", "", "paymentSessionId", "methodSignature", "", "params", "Lcom/avito/android/payment/processing/PaymentGenericPresenter;", "createPresenter", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/avito/android/payment/processing/PaymentGenericPresenter;", "Lcom/avito/android/payment/remote/PaymentApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/payment/remote/PaymentApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/Kundle;", "f", "Lcom/avito/android/util/Kundle;", "paymentInteractorState", "Lcom/avito/android/Features;", "e", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "c", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;", "d", "Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;", "paymentSessionTypeMarker", "<init>", "(Lcom/avito/android/payment/remote/PaymentApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;Lcom/avito/android/Features;Lcom/avito/android/util/Kundle;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentGenericFactory {
    public final PaymentApi a;
    public final SchedulersFactory b;
    public final DeepLinkFactory c;
    public final PaymentSessionTypeMarker d;
    public final Features e;
    public final Kundle f;

    public PaymentGenericFactory(@NotNull PaymentApi paymentApi, @NotNull SchedulersFactory schedulersFactory, @NotNull DeepLinkFactory deepLinkFactory, @NotNull PaymentSessionTypeMarker paymentSessionTypeMarker, @NotNull Features features, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(paymentApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(paymentSessionTypeMarker, "paymentSessionTypeMarker");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = paymentApi;
        this.b = schedulersFactory;
        this.c = deepLinkFactory;
        this.d = paymentSessionTypeMarker;
        this.e = features;
        this.f = kundle;
    }

    @NotNull
    public final PaymentGenericPresenter createPresenter(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "paymentSessionId");
        Intrinsics.checkNotNullParameter(str2, "methodSignature");
        Intrinsics.checkNotNullParameter(map, "params");
        return new PaymentGenericPresenterImpl(new PaymentGenericInteractorImpl(this.a, str, str2, map, this.d, this.b, this.e, this.f), new PaymentStatusPollingInteractorImpl(this.a), this.c, this.b);
    }
}
