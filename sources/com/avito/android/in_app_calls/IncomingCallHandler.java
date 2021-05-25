package com.avito.android.in_app_calls;

import android.app.Application;
import com.avito.android.calls.IncomingCall;
import com.avito.android.calls.IncomingCallListener;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls_shared.CallerInfo;
import com.avito.android.calls_shared.ItemInfo;
import com.avito.android.calls_shared.tracker.events.CallEvent;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.in_app_calls.service.CallManagerService;
import com.avito.android.in_app_calls.service.CallManagerServiceKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.service.SafeServiceStarter;
import com.avito.android.util.Logs;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Singleton
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/in_app_calls/IncomingCallHandler;", "Lcom/avito/android/calls/IncomingCallListener;", "Lcom/avito/android/calls/IncomingCall;", "call", "", "onIncomingCall", "(Lcom/avito/android/calls/IncomingCall;)V", "", AuthSource.SEND_ABUSE, "Z", "getAcceptReconnectCalls", "()Z", "setAcceptReconnectCalls", "(Z)V", "acceptReconnectCalls", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "d", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "analyticsTracker", "Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "f", "Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "callEventTracker", "Landroid/app/Application;", AuthSource.BOOKING_ORDER, "Landroid/app/Application;", "context", "Lcom/avito/android/in_app_calls/CallRegistry;", "c", "Lcom/avito/android/in_app_calls/CallRegistry;", "callRegistry", "Lcom/avito/android/service/SafeServiceStarter;", "e", "Lcom/avito/android/service/SafeServiceStarter;", "safeServiceStarter", "<init>", "(Landroid/app/Application;Lcom/avito/android/in_app_calls/CallRegistry;Lcom/avito/android/calls/analytics/CallAnalyticsTracker;Lcom/avito/android/service/SafeServiceStarter;Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class IncomingCallHandler implements IncomingCallListener {
    public volatile boolean a;
    public final Application b;
    public final CallRegistry c;
    public final CallAnalyticsTracker d;
    public final SafeServiceStarter e;
    public final CallEventTracker f;

    @Inject
    public IncomingCallHandler(@NotNull Application application, @NotNull CallRegistry callRegistry, @NotNull CallAnalyticsTracker callAnalyticsTracker, @NotNull SafeServiceStarter safeServiceStarter, @NotNull CallEventTracker callEventTracker) {
        Intrinsics.checkNotNullParameter(application, "context");
        Intrinsics.checkNotNullParameter(callRegistry, "callRegistry");
        Intrinsics.checkNotNullParameter(callAnalyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(safeServiceStarter, "safeServiceStarter");
        Intrinsics.checkNotNullParameter(callEventTracker, "callEventTracker");
        this.b = application;
        this.c = callRegistry;
        this.d = callAnalyticsTracker;
        this.e = safeServiceStarter;
        this.f = callEventTracker;
    }

    public final boolean getAcceptReconnectCalls() {
        return this.a;
    }

    @Override // com.avito.android.calls.IncomingCallListener
    public void onIncomingCall(@NotNull IncomingCall incomingCall) {
        Intrinsics.checkNotNullParameter(incomingCall, "call");
        ItemInfo itemInfo = null;
        Logs.debug$default("IncomingCallHandler", "Handling incoming call from " + incomingCall.getCallerId() + ": " + incomingCall, null, 4, null);
        String uuid = incomingCall.getUuid();
        if (!Intrinsics.areEqual(incomingCall.getCallerId(), "reconnect")) {
            this.c.addCall(uuid, incomingCall);
            this.f.track(new CallEvent.IncomingCallReceived(incomingCall.getUuid()));
            this.d.trackCallInitiated(true);
            CallerInfo callerInfo = new CallerInfo(incomingCall.getCallerId());
            String itemId = incomingCall.getItemId();
            if (itemId != null) {
                itemInfo = new ItemInfo(itemId, null, null, null, 14, null);
            }
            this.e.start(this.b, CallManagerServiceKt.createCallManagerServiceIntent(this.b, new CallManagerService.StartRequest.Receive(uuid, callerInfo, itemInfo)));
        } else if (this.a) {
            this.c.addCall(uuid, incomingCall);
            this.e.start(this.b, CallManagerServiceKt.createCallManagerServiceIntent(this.b, new CallManagerService.StartRequest.Reconnect(uuid)));
        }
    }

    public final void setAcceptReconnectCalls(boolean z) {
        this.a = z;
    }
}
