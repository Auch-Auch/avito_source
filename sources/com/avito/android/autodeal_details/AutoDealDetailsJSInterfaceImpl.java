package com.avito.android.autodeal_details;

import android.webkit.JavascriptInterface;
import com.avito.android.autodeal_details.AutoDealDetailsJSEvents;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\bR@\u0010\u0010\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0018\u00010\t0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/autodeal_details/AutoDealDetailsJSInterfaceImpl;", "Lcom/avito/android/autodeal_details/AutoDealDetailsJSInterface;", "", "onClosePressed", "()V", "", "text", "showToast", "(Ljava/lang/String;)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/autodeal_details/AutoDealDetailsJSEvents;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "getEvents", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "events", "<init>", "autodeal-details_release"}, k = 1, mv = {1, 4, 2})
public final class AutoDealDetailsJSInterfaceImpl implements AutoDealDetailsJSInterface {
    public final PublishRelay<AutoDealDetailsJSEvents> a = PublishRelay.create();

    @JavascriptInterface
    public final void onClosePressed() {
        getEvents().accept(new AutoDealDetailsJSEvents.CloseScreen());
    }

    @JavascriptInterface
    public final void showToast(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        getEvents().accept(new AutoDealDetailsJSEvents.ShowToast(str));
    }

    @Override // com.avito.android.autodeal_details.AutoDealDetailsJSInterface
    public PublishRelay<AutoDealDetailsJSEvents> getEvents() {
        return this.a;
    }
}
