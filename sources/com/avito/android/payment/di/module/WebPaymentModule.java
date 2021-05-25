package com.avito.android.payment.di.module;

import android.os.Bundle;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerActivity;
import com.avito.android.payment.webview.PaymentWebViewStateWatcher;
import com.avito.android.payment.webview.PaymentWebViewStateWatcherImpl;
import com.avito.android.payment.webview.ScreenState;
import com.avito.android.payment.webview.WebPaymentPresenter;
import com.avito.android.payment.webview.WebPaymentPresenterImpl;
import com.avito.android.payment.webview.WebPaymentResult;
import com.avito.android.payment.webview.WebPaymentStateMachine;
import com.avito.android.payment.webview.WebPaymentStateMachineImpl;
import com.avito.android.payment.webview.WebViewStatePresenter;
import com.avito.android.payment.webview.WebViewStatePresenterImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b#\u0010$J7\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/payment/di/module/WebPaymentModule;", "", "Lcom/avito/android/payment/webview/WebViewStatePresenter;", "webViewStatePresenter", "Lcom/avito/android/payment/webview/WebPaymentStateMachine;", "webPaymentStateMachine", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/payment/webview/PaymentWebViewStateWatcher;", "paymentWebViewStateWatcher", "Lcom/avito/android/payment/webview/WebPaymentPresenter;", "provideWebPaymentPresenter$payment_release", "(Lcom/avito/android/payment/webview/WebViewStatePresenter;Lcom/avito/android/payment/webview/WebPaymentStateMachine;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/payment/webview/PaymentWebViewStateWatcher;)Lcom/avito/android/payment/webview/WebPaymentPresenter;", "provideWebPaymentPresenter", "provideWebViewStatePresenter$payment_release", "(Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/payment/webview/WebViewStatePresenter;", "provideWebViewStatePresenter", "provideWebPaymentStateMachine$payment_release", "()Lcom/avito/android/payment/webview/WebPaymentStateMachine;", "provideWebPaymentStateMachine", "Lcom/avito/android/analytics/Analytics;", "analytics", "providePaymentWebViewStateWatcher$payment_release", "(Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/payment/webview/PaymentWebViewStateWatcher;", "providePaymentWebViewStateWatcher", "Landroid/os/Bundle;", AuthSource.BOOKING_ORDER, "Landroid/os/Bundle;", "savedState", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "startUrl", "<init>", "(Ljava/lang/String;Landroid/os/Bundle;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DialogRouterModule.class})
public final class WebPaymentModule {
    public final String a;
    public final Bundle b;

    public WebPaymentModule(@NotNull String str, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "startUrl");
        this.a = str;
        this.b = bundle;
    }

    @Provides
    @PerActivity
    @NotNull
    public final PaymentWebViewStateWatcher providePaymentWebViewStateWatcher$payment_release(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new PaymentWebViewStateWatcherImpl(analytics);
    }

    @Provides
    @PerActivity
    @NotNull
    public final WebPaymentPresenter provideWebPaymentPresenter$payment_release(@NotNull WebViewStatePresenter webViewStatePresenter, @NotNull WebPaymentStateMachine webPaymentStateMachine, @NotNull DeepLinkFactory deepLinkFactory, @NotNull SchedulersFactory schedulersFactory, @NotNull PaymentWebViewStateWatcher paymentWebViewStateWatcher) {
        Intrinsics.checkNotNullParameter(webViewStatePresenter, "webViewStatePresenter");
        Intrinsics.checkNotNullParameter(webPaymentStateMachine, "webPaymentStateMachine");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(paymentWebViewStateWatcher, "paymentWebViewStateWatcher");
        return new WebPaymentPresenterImpl(webViewStatePresenter, webPaymentStateMachine, this.a, schedulersFactory, paymentWebViewStateWatcher, this.b == null ? new ScreenState.FullScreenLoading() : new ScreenState.Terminated(new WebPaymentResult.Error()));
    }

    @Provides
    @PerActivity
    @NotNull
    public final WebPaymentStateMachine provideWebPaymentStateMachine$payment_release() {
        return new WebPaymentStateMachineImpl();
    }

    @Provides
    @PerActivity
    @NotNull
    public final WebViewStatePresenter provideWebViewStatePresenter$payment_release(@NotNull DeepLinkFactory deepLinkFactory, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new WebViewStatePresenterImpl(deepLinkFactory, schedulersFactory);
    }
}
