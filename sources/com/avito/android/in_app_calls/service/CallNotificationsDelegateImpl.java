package com.avito.android.in_app_calls.service;

import a2.b.a.a.a;
import a2.g.r.g;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.calls_shared.AppCallScenario;
import com.avito.android.calls_shared.CallSide;
import com.avito.android.calls_shared.CallUuidProvider;
import com.avito.android.in_app_calls.CallManager;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import com.avito.android.in_app_calls.data.InAppCallPendingAction;
import com.avito.android.in_app_calls.service.CallManagerService;
import com.avito.android.lib.design.avito.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.Logs;
import com.avito.android.util.preferences.Names;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b8\u00109J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/avito/android/in_app_calls/service/CallNotificationsDelegateImpl;", "Lcom/avito/android/in_app_calls/service/CallNotificationsDelegate;", "Lcom/avito/android/calls_shared/AppCallInfo;", "info", "", "isUiBound", "wasConnected", "", "showCallNotification", "(Lcom/avito/android/calls_shared/AppCallInfo;ZZ)V", "showCallActivity", "(Lcom/avito/android/calls_shared/AppCallInfo;)V", "Lcom/avito/android/in_app_calls/CallManager$MissedCallData;", "missedCall", "showMissedCallNotification", "(Lcom/avito/android/in_app_calls/CallManager$MissedCallData;)V", "stopForeground", "()V", "Landroidx/core/app/NotificationCompat$Builder;", AuthSource.SEND_ABUSE, "(Landroidx/core/app/NotificationCompat$Builder;Lcom/avito/android/calls_shared/AppCallInfo;)Landroidx/core/app/NotificationCompat$Builder;", "incomingCallPriority", "needShowActions", "Landroid/app/Notification;", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/calls_shared/AppCallInfo;ZZ)Landroid/app/Notification;", "Lcom/avito/android/Features;", "h", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/in_app_calls/service/SystemCallStateProvider;", "e", "Lcom/avito/android/in_app_calls/service/SystemCallStateProvider;", "systemCallStateProvider", "Landroidx/core/app/NotificationManagerCompat;", "Landroidx/core/app/NotificationManagerCompat;", "notificationManager", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "f", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "callAnalyticsTracker", "Landroid/app/Service;", "c", "Landroid/app/Service;", NotificationCompat.CATEGORY_SERVICE, "Landroidx/appcompat/view/ContextThemeWrapper;", "Landroidx/appcompat/view/ContextThemeWrapper;", "themeContext", "Lcom/avito/android/calls_shared/CallUuidProvider;", g.a, "Lcom/avito/android/calls_shared/CallUuidProvider;", "callUuidProvider", "Lcom/avito/android/ActivityIntentFactory;", "d", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "<init>", "(Landroid/app/Service;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/in_app_calls/service/SystemCallStateProvider;Lcom/avito/android/calls/analytics/CallAnalyticsTracker;Lcom/avito/android/calls_shared/CallUuidProvider;Lcom/avito/android/Features;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallNotificationsDelegateImpl implements CallNotificationsDelegate {
    public final ContextThemeWrapper a;
    public final NotificationManagerCompat b;
    public final Service c;
    public final ActivityIntentFactory d;
    public final SystemCallStateProvider e;
    public final CallAnalyticsTracker f;
    public final CallUuidProvider g;
    public final Features h;

    @Inject
    public CallNotificationsDelegateImpl(@NotNull Service service, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull SystemCallStateProvider systemCallStateProvider, @NotNull CallAnalyticsTracker callAnalyticsTracker, @NotNull CallUuidProvider callUuidProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(service, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter(activityIntentFactory, "intentFactory");
        Intrinsics.checkNotNullParameter(systemCallStateProvider, "systemCallStateProvider");
        Intrinsics.checkNotNullParameter(callAnalyticsTracker, "callAnalyticsTracker");
        Intrinsics.checkNotNullParameter(callUuidProvider, "callUuidProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        this.c = service;
        this.d = activityIntentFactory;
        this.e = systemCallStateProvider;
        this.f = callAnalyticsTracker;
        this.g = callUuidProvider;
        this.h = features;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(service, R.style.Theme_DesignSystem_Avito);
        this.a = contextThemeWrapper;
        NotificationManagerCompat from = NotificationManagerCompat.from(contextThemeWrapper);
        Intrinsics.checkNotNullExpressionValue(from, "NotificationManagerCompat.from(themeContext)");
        this.b = from;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r0 != null) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.core.app.NotificationCompat.Builder a(androidx.core.app.NotificationCompat.Builder r7, com.avito.android.calls_shared.AppCallInfo r8) {
        /*
            r6 = this;
            com.avito.android.calls_shared.CallerInfo r0 = r8.getCaller()
            java.lang.String r0 = r0.getDisplayName()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0018
            boolean r3 = t6.y.m.isBlank(r0)
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            if (r0 == 0) goto L_0x0018
            goto L_0x0025
        L_0x0018:
            android.app.Service r0 = r6.c
            int r3 = com.avito.android.in_app_calls.R.string.calls_default_display_name
            java.lang.String r0 = r0.getString(r3)
            java.lang.String r3 = "service.getString(R.stri…lls_default_display_name)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
        L_0x0025:
            com.avito.android.calls_shared.ItemInfo r8 = r8.getItem()
            if (r8 == 0) goto L_0x002f
            java.lang.String r1 = r8.getTitle()
        L_0x002f:
            r8 = 0
            if (r1 == 0) goto L_0x0042
            android.app.Service r3 = r6.c
            int r4 = com.avito.android.in_app_calls.R.string.calls_notification_content_user_and_item
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r8] = r0
            r5[r2] = r1
            java.lang.String r8 = r3.getString(r4, r5)
            goto L_0x004e
        L_0x0042:
            android.app.Service r1 = r6.c
            int r3 = com.avito.android.in_app_calls.R.string.calls_notification_content_user
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r8] = r0
            java.lang.String r8 = r1.getString(r3, r2)
        L_0x004e:
            java.lang.String r0 = "if (itemTitle != null) {…er, callerName)\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            androidx.core.app.NotificationCompat$Builder r0 = r7.setContentText(r8)
            androidx.core.app.NotificationCompat$BigTextStyle r1 = new androidx.core.app.NotificationCompat$BigTextStyle
            r1.<init>(r7)
            androidx.core.app.NotificationCompat$BigTextStyle r7 = r1.bigText(r8)
            androidx.core.app.NotificationCompat$Builder r7 = r0.setStyle(r7)
            java.lang.String r8 = "setContentText(message)\n…xt(message)\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.in_app_calls.service.CallNotificationsDelegateImpl.a(androidx.core.app.NotificationCompat$Builder, com.avito.android.calls_shared.AppCallInfo):androidx.core.app.NotificationCompat$Builder");
    }

    public final Notification b(AppCallInfo appCallInfo, boolean z, boolean z2) {
        String str;
        String str2;
        int i;
        NotificationCompat.Builder builder;
        NotificationCompat.Builder builder2;
        PendingIntent activity = PendingIntent.getActivity(this.c, 1, this.d.inAppCallIntent(new CallActivityRequest.Open(appCallInfo.getCallId(), appCallInfo.getItem(), appCallInfo.getScenario(), CallSide.Companion.fromBoolean(appCallInfo.isIncoming()))), 134217728);
        if (appCallInfo.isIncoming()) {
            str = this.c.getString(com.avito.android.in_app_calls.R.string.calls_notification_incoming_call_title);
        } else {
            str = this.c.getString(com.avito.android.in_app_calls.R.string.calls_notification_outgoing_call_title);
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (info.isIncoming) {\n …ing_call_title)\n        }");
        if (z) {
            str2 = this.c.getString(com.avito.android.in_app_calls.R.string.calls_notification_channel_incoming_id);
        } else {
            str2 = this.c.getString(com.avito.android.in_app_calls.R.string.calls_notification_channel_active_id);
        }
        Intrinsics.checkNotNullExpressionValue(str2, "if (incomingCallPriority…nnel_active_id)\n        }");
        NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(this.a, str2).setContentTitle(str);
        Intrinsics.checkNotNullExpressionValue(contentTitle, "NotificationCompat.Build…  .setContentTitle(title)");
        NotificationCompat.Builder a3 = a(contentTitle, appCallInfo);
        if (appCallInfo.isIncoming()) {
            i = com.avito.android.in_app_calls.R.drawable.ic_notification_incoming_call;
        } else {
            i = com.avito.android.in_app_calls.R.drawable.ic_notification_outgoing_call;
        }
        NotificationCompat.Builder category = a3.setSmallIcon(i).setColor(Contexts.getColorByAttr(this.a, com.avito.android.lib.design.R.attr.blue)).setSound(null).setCategory("call");
        if (z) {
            builder = category.setFullScreenIntent(this.e.isIdle() ? activity : null, true).setPriority(2);
        } else {
            builder = category.setFullScreenIntent(null, false).setPriority(-1);
        }
        NotificationCompat.Builder contentIntent = builder.setOngoing(true).setVibrate(null).setOnlyAlertOnce(true).setContentIntent(activity);
        if (z2) {
            PendingIntent activity2 = PendingIntent.getActivity(this.c, 3, this.d.inAppCallIntent(new CallActivityRequest.Receive.PendingAction(appCallInfo.getCallId(), appCallInfo.getItem(), InAppCallPendingAction.ANSWER)), 134217728);
            Service service = this.c;
            contentIntent.addAction(com.avito.android.in_app_calls.R.drawable.ic_call_decline_28, this.c.getString(com.avito.android.in_app_calls.R.string.calls_decline), PendingIntent.getService(service, 4, CallManagerServiceKt.createCallManagerServiceIntent(service, new CallManagerService.StartRequest.PendingAction(appCallInfo.getCallId(), InAppCallPendingAction.DECLINE)), 134217728)).addAction(com.avito.android.in_app_calls.R.drawable.ic_call_answer_28, this.c.getString(com.avito.android.in_app_calls.R.string.calls_answer), activity2);
        }
        Long connectTimestamp = appCallInfo.getConnectTimestamp();
        if (connectTimestamp == null || appCallInfo.getEndTimestamp() != null) {
            builder2 = contentIntent.setWhen(appCallInfo.getStartTimestamp()).setShowWhen(false).setUsesChronometer(false);
        } else {
            builder2 = contentIntent.setWhen(connectTimestamp.longValue()).setUsesChronometer(true);
        }
        Notification build = builder2.build();
        Intrinsics.checkNotNullExpressionValue(build, "NotificationCompat.Build…   }\n            .build()");
        return build;
    }

    @Override // com.avito.android.in_app_calls.service.CallNotificationsDelegate
    public void showCallActivity(@NotNull AppCallInfo appCallInfo) {
        Intrinsics.checkNotNullParameter(appCallInfo, "info");
        if (this.e.isIdle()) {
            try {
                Intent addFlags = this.d.inAppCallIntent(new CallActivityRequest.Receive.ReceiveCall(appCallInfo.getCallId(), appCallInfo.getItem(), appCallInfo.getCaller(), null, 8, null)).addFlags(268435456).addFlags(32768);
                Intrinsics.checkNotNullExpressionValue(addFlags, "intentFactory.inAppCallI…FLAG_ACTIVITY_CLEAR_TASK)");
                this.c.startActivity(addFlags);
            } catch (Exception e2) {
                Logs.debug("CallNotificationsDelegate", "Failed to start incoming call UI", e2);
                CallAnalyticsTracker callAnalyticsTracker = this.f;
                boolean isIncoming = appCallInfo.isIncoming();
                StringBuilder L = a.L("cant_start_ui_");
                L.append(e2.getClass().getSimpleName());
                callAnalyticsTracker.trackError(isIncoming, L.toString());
            }
        } else {
            Logs.debug$default("CallNotificationsDelegate", "Incoming call UI wan't shown because there is an ongoing system call", null, 4, null);
            this.f.trackError(appCallInfo.isIncoming(), "phone_busy");
        }
    }

    @Override // com.avito.android.in_app_calls.service.CallNotificationsDelegate
    public void showCallNotification(@NotNull AppCallInfo appCallInfo, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(appCallInfo, "info");
        boolean z3 = false;
        if (appCallInfo.getConnectTimestamp() != null) {
            this.c.startForeground(56, b(appCallInfo, false, false));
            this.f.trackCallUiShown("notify_silent");
        } else if (appCallInfo.isIncoming()) {
            Service service = this.c;
            boolean z4 = !z;
            if (!z2 && this.h.getCallsNotificationActions().invoke().booleanValue()) {
                z3 = true;
            }
            service.startForeground(56, b(appCallInfo, z4, z3));
            this.f.trackCallUiShown("notify_priority");
        } else {
            this.c.startForeground(56, b(appCallInfo, false, false));
            this.f.trackCallUiShown("notify_silent");
        }
    }

    @Override // com.avito.android.in_app_calls.service.CallNotificationsDelegate
    public void showMissedCallNotification(@NotNull CallManager.MissedCallData missedCallData) {
        int i;
        Intrinsics.checkNotNullParameter(missedCallData, "missedCall");
        CallManager.MissedCallReason reason = missedCallData.getReason();
        if (Intrinsics.areEqual(reason, CallManager.MissedCallReason.AnsweredElsewhere.INSTANCE)) {
            i = com.avito.android.in_app_calls.R.string.calls_notification_answered_elsewhere_call_title;
        } else if (!Intrinsics.areEqual(reason, CallManager.MissedCallReason.Missed.INSTANCE) && !Intrinsics.areEqual(reason, CallManager.MissedCallReason.Busy.INSTANCE) && !Intrinsics.areEqual(reason, CallManager.MissedCallReason.Failed.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        } else {
            i = com.avito.android.in_app_calls.R.string.calls_notification_missed_call_title;
        }
        PendingIntent activity = PendingIntent.getActivity(this.c, 2, this.d.inAppCallIntent(new CallActivityRequest.Dial.ByPreviousCall(this.g.nextCallUuid(), missedCallData.getInfo().getItem(), missedCallData.getInfo().getCallId(), AppCallScenario.CALL_BACK_FROM_NOTIFICATION)), 134217728);
        String string = this.c.getString(com.avito.android.in_app_calls.R.string.calls_notification_channel_missed_id);
        Intrinsics.checkNotNullExpressionValue(string, "service.getString(R.stri…cation_channel_missed_id)");
        NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(this.a, string).setContentTitle(this.c.getString(i));
        Intrinsics.checkNotNullExpressionValue(contentTitle, "NotificationCompat.Build…service.getString(title))");
        this.b.notify(Names.IN_APP_CALLS, 58, a(contentTitle, missedCallData.getInfo()).setDefaults(-1).setAutoCancel(true).setWhen(missedCallData.getInfo().getStartTimestamp()).setShowWhen(true).setColor(Contexts.getColorByAttr(this.a, com.avito.android.lib.design.R.attr.red)).setSmallIcon(com.avito.android.in_app_calls.R.drawable.ic_notification_incoming_call).setContentIntent(activity).setPriority(1).setCategory(NotificationCompat.CATEGORY_MESSAGE).build());
    }

    @Override // com.avito.android.in_app_calls.service.CallNotificationsDelegate
    public void stopForeground() {
        this.c.stopForeground(true);
        this.c.stopSelf();
    }
}
