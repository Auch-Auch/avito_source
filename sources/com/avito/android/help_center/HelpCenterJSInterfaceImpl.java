package com.avito.android.help_center;

import android.webkit.JavascriptInterface;
import com.avito.android.help_center.HelpCenterJSEvent;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/help_center/HelpCenterJSInterfaceImpl;", "Lcom/avito/android/help_center/HelpCenterJSInterface;", "", "newUrl", "", "onUpdateURL", "(Ljava/lang/String;)V", "updateCookies", "()V", "onSendHelpRequest", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/help_center/HelpCenterJSEvent;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "getEvents", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "events", "<init>", "help-center_release"}, k = 1, mv = {1, 4, 2})
public final class HelpCenterJSInterfaceImpl implements HelpCenterJSInterface {
    @NotNull
    public final PublishRelay<HelpCenterJSEvent> a;

    @Inject
    public HelpCenterJSInterfaceImpl() {
        PublishRelay<HelpCenterJSEvent> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
    }

    @JavascriptInterface
    public final void onSendHelpRequest() {
        getEvents().accept(new HelpCenterJSEvent.SendHelpRequest());
    }

    @JavascriptInterface
    public final void onUpdateURL(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "newUrl");
        getEvents().accept(new HelpCenterJSEvent.UpdateUrl(str));
    }

    @JavascriptInterface
    public final void updateCookies() {
        getEvents().accept(new HelpCenterJSEvent.UpdateCookie());
    }

    @Override // com.avito.android.help_center.HelpCenterJSInterface
    @NotNull
    public PublishRelay<HelpCenterJSEvent> getEvents() {
        return this.a;
    }
}
