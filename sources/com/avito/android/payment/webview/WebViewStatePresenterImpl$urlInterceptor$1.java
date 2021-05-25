package com.avito.android.payment.webview;

import android.net.Uri;
import com.avito.android.deep_linking.links.CarBookingOrderPayLink;
import com.avito.android.deep_linking.links.CarBookingOrderPaymentFailureLink;
import com.avito.android.deep_linking.links.CarBookingOrderPaymentSuccessLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeliveryCourierOrderPaymentFailureLink;
import com.avito.android.deep_linking.links.DeliveryCourierOrderPaymentSuccessLink;
import com.avito.android.deep_linking.links.DeliveryOrderPaymentFailureLink;
import com.avito.android.deep_linking.links.DeliveryOrderPaymentSuccessLink;
import com.avito.android.deep_linking.links.PaymentStatusLink;
import com.avito.android.deep_linking.links.StrBookingPaymentFailureLink;
import com.avito.android.deep_linking.links.StrBookingPaymentSuccessLink;
import com.facebook.share.internal.ShareConstants;
import com.yatatsu.powerwebview.PowerWebViewInterceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/payment/webview/WebViewStatePresenterImpl$urlInterceptor$1", "Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "intercept", "(Landroid/net/Uri;)Z", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class WebViewStatePresenterImpl$urlInterceptor$1 implements PowerWebViewInterceptor {
    public final /* synthetic */ WebViewStatePresenterImpl a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public WebViewStatePresenterImpl$urlInterceptor$1(WebViewStatePresenterImpl webViewStatePresenterImpl) {
        this.a = webViewStatePresenterImpl;
    }

    @Override // com.yatatsu.powerwebview.PowerWebViewInterceptor
    public boolean intercept(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        this.a.e.accept(uri);
        DeepLink createFromUri = this.a.h.createFromUri(uri);
        return (createFromUri instanceof CarBookingOrderPaymentSuccessLink) | (createFromUri instanceof PaymentStatusLink) | (createFromUri instanceof DeliveryOrderPaymentSuccessLink) | (createFromUri instanceof DeliveryOrderPaymentFailureLink) | (createFromUri instanceof StrBookingPaymentSuccessLink) | (createFromUri instanceof StrBookingPaymentFailureLink) | (createFromUri instanceof DeliveryCourierOrderPaymentSuccessLink) | (createFromUri instanceof DeliveryCourierOrderPaymentFailureLink) | (createFromUri instanceof CarBookingOrderPayLink) | (createFromUri instanceof CarBookingOrderPaymentFailureLink);
    }
}
