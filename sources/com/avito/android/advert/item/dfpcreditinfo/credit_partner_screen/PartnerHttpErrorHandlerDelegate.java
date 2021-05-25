package com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen;

import a2.b.a.a.a;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.yatatsu.powerwebview.HttpErrorHandlerDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR%\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/PartnerHttpErrorHandlerDelegate;", "Lcom/yatatsu/powerwebview/HttpErrorHandlerDelegate;", "Landroid/webkit/WebView;", "view", "Landroid/webkit/WebResourceRequest;", "request", "Landroid/webkit/WebResourceResponse;", "errorResponse", "", "onReceivedHttpError", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceResponse;)V", "", "error", "onReceivedJsError", "(Ljava/lang/String;)V", "Lkotlin/Function1;", "", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function1;", "getOnError", "()Lkotlin/jvm/functions/Function1;", "onError", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class PartnerHttpErrorHandlerDelegate implements HttpErrorHandlerDelegate {
    @NotNull
    public final String a;
    @NotNull
    public final Function1<Boolean, Unit> b;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public PartnerHttpErrorHandlerDelegate(@NotNull String str, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(function1, "onError");
        this.a = str;
        this.b = function1;
    }

    @NotNull
    public final Function1<Boolean, Unit> getOnError() {
        return this.b;
    }

    @NotNull
    public final String getTag() {
        return this.a;
    }

    @Override // com.yatatsu.powerwebview.HttpErrorHandlerDelegate
    public void onReceivedHttpError(@NotNull WebView webView, @NotNull WebResourceRequest webResourceRequest, @NotNull WebResourceResponse webResourceResponse) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(webResourceRequest, "request");
        Intrinsics.checkNotNullParameter(webResourceResponse, "errorResponse");
        String str = this.a;
        StringBuilder L = a.L("HTTP error: code:");
        L.append(webResourceResponse.getStatusCode());
        L.append(" message:");
        L.append(webResourceResponse.getReasonPhrase());
        Logs.error$default(str, L.toString(), null, 4, null);
    }

    @Override // com.yatatsu.powerwebview.HttpErrorHandlerDelegate
    public void onReceivedJsError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Logs.error$default(this.a, a.c3("JS error: ", str), null, 4, null);
        this.b.invoke(Boolean.TRUE);
    }
}
