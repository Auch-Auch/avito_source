package com.avito.android.calls_shared.analytics.mapping;

import a2.b.a.a.a;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.avito.android.analytics.Event;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.calls_shared.AppCallScenario;
import com.avito.android.calls_shared.CallSide;
import com.avito.android.calls_shared.ItemInfo;
import com.avito.android.calls_shared.MicAccessScenario;
import com.avito.android.calls_shared.analytics.events.AppCallEventType;
import com.avito.android.calls_shared.analytics.events.CallClientConnectedToVoxEvent;
import com.avito.android.calls_shared.analytics.events.CallPermissionsCheckedEvent;
import com.avito.android.calls_shared.analytics.events.CallPushReceivedEvent;
import com.avito.android.calls_shared.analytics.events.CallReceivedFromVoxEvent;
import com.avito.android.calls_shared.analytics.events.CallRegisteredEvent;
import com.avito.android.calls_shared.analytics.events.CallScreenOpenedEvent;
import com.avito.android.calls_shared.analytics.events.InAppCallEvent;
import com.avito.android.calls_shared.analytics.events.InAppCallGreenButtonClickedEvent;
import com.avito.android.calls_shared.analytics.events.InAppCallRedButtonClickedEvent;
import com.avito.android.calls_shared.analytics.events.InteractionSourceType;
import com.avito.android.calls_shared.analytics.events.MicPermissionPopupResultEvent;
import com.avito.android.calls_shared.tracker.errors.CallEventFactoryException;
import com.avito.android.calls_shared.tracker.events.CallEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/avito/android/calls_shared/analytics/mapping/CallEventFactory;", "", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "event", "Lcom/avito/android/analytics/Event;", "createEvent", "(Lcom/avito/android/calls_shared/tracker/events/CallEvent;)Lcom/avito/android/analytics/Event;", "Lcom/avito/android/calls_shared/analytics/events/AppCallEventType;", "Lcom/avito/android/calls_shared/AppCallInfo;", "info", "Lcom/avito/android/calls_shared/CallSide;", "callSide", "", "areNotificationsAllowed", AuthSource.SEND_ABUSE, "(Lcom/avito/android/calls_shared/analytics/events/AppCallEventType;Lcom/avito/android/calls_shared/AppCallInfo;Lcom/avito/android/calls_shared/CallSide;Ljava/lang/Boolean;)Lcom/avito/android/analytics/Event;", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/avito/android/analytics/NetworkTypeProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "<init>", "(Landroid/content/Context;Lcom/avito/android/analytics/NetworkTypeProvider;)V", "Companion", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class CallEventFactory {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final Context a;
    public final NetworkTypeProvider b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/analytics/mapping/CallEventFactory$Companion;", "", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static final InteractionSourceType access$mapInteractionFromUiToEventType(Companion companion, boolean z) {
            Objects.requireNonNull(companion);
            return z ? InteractionSourceType.AVITO : InteractionSourceType.SYSTEM;
        }

        public Companion(j jVar) {
        }
    }

    @Inject
    public CallEventFactory(@NotNull Context context, @NotNull NetworkTypeProvider networkTypeProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(networkTypeProvider, "networkTypeProvider");
        this.a = context;
        this.b = networkTypeProvider;
    }

    public final Event a(AppCallEventType appCallEventType, AppCallInfo appCallInfo, CallSide callSide, Boolean bool) {
        boolean z = ContextCompat.checkSelfPermission(this.a, "android.permission.RECORD_AUDIO") == 0;
        AppCallScenario scenario = appCallInfo.getScenario();
        String callId = appCallInfo.getCallId();
        ItemInfo item = appCallInfo.getItem();
        return new InAppCallEvent(scenario, callId, callSide, item != null ? item.getItemId() : null, this.b.networkType(), appCallEventType, bool, z);
    }

    @NotNull
    public final Event createEvent(@NotNull CallEvent callEvent) {
        Event event;
        ItemInfo item;
        Intrinsics.checkNotNullParameter(callEvent, "event");
        if (callEvent instanceof CallEvent.ScreenOpened) {
            event = new CallScreenOpenedEvent(callEvent.getId(), callEvent.getSide(), ((CallEvent.ScreenOpened) callEvent).getScenario());
        } else {
            InAppCallRedButtonClickedEvent inAppCallRedButtonClickedEvent = null;
            r1 = null;
            String str = null;
            if (callEvent instanceof CallEvent.MicPermissionResult) {
                boolean wasGranted = ((CallEvent.MicPermissionResult) callEvent).getWasGranted();
                MicAccessScenario fromCallSide = MicAccessScenario.Companion.fromCallSide(callEvent.getSide());
                AppCallInfo info = ((CallEvent.MicPermissionResult) callEvent).getInfo();
                if (!(info == null || (item = info.getItem()) == null)) {
                    str = item.getItemId();
                }
                event = new MicPermissionPopupResultEvent(wasGranted, fromCallSide, str, callEvent.getId());
            } else if (callEvent instanceof CallEvent.PermissionChecked) {
                event = new CallPermissionsCheckedEvent(callEvent.getId(), callEvent.getSide());
            } else if (callEvent instanceof CallEvent.Registered) {
                event = new CallRegisteredEvent(callEvent.getId(), callEvent.getSide());
            } else if (callEvent instanceof CallEvent.CallProcessStarted) {
                event = a(AppCallEventType.Start.INSTANCE, ((CallEvent.CallProcessStarted) callEvent).getInfo(), callEvent.getSide(), null);
            } else if (callEvent instanceof CallEvent.ConnectedToVoximplant) {
                event = new CallClientConnectedToVoxEvent(callEvent.getId(), callEvent.getSide());
            } else if (callEvent instanceof CallEvent.Dialing) {
                event = a(AppCallEventType.Waiting.INSTANCE, ((CallEvent.Dialing) callEvent).getInfo(), callEvent.getSide(), null);
            } else if (callEvent instanceof CallEvent.Connected) {
                event = a(AppCallEventType.Connected.INSTANCE, ((CallEvent.Connected) callEvent).getInfo(), callEvent.getSide(), null);
            } else if (callEvent instanceof CallEvent.PushReceived) {
                CallEvent.PushReceived pushReceived = (CallEvent.PushReceived) callEvent;
                event = new CallPushReceivedEvent(pushReceived.getPushId(), pushReceived.getTtl(), pushReceived.getSentPriority(), pushReceived.getReceivedPriority(), pushReceived.getSentTimestamp(), pushReceived.getNotificationsEnabled(), pushReceived.getVoxCallId(), pushReceived.getVoxUserId());
            } else if (callEvent instanceof CallEvent.IncomingCallReceived) {
                event = new CallReceivedFromVoxEvent(callEvent.getId(), callEvent.getSide());
            } else if (callEvent instanceof CallEvent.Ringing) {
                event = a(AppCallEventType.Waiting.INSTANCE, ((CallEvent.Ringing) callEvent).getInfo(), callEvent.getSide(), Boolean.valueOf(((CallEvent.Ringing) callEvent).getAreNotificationsAllowed()));
            } else if (callEvent instanceof CallEvent.Reconnecting) {
                event = a(AppCallEventType.Reconnecting.INSTANCE, ((CallEvent.Reconnecting) callEvent).getInfo(), callEvent.getSide(), null);
            } else if (callEvent instanceof CallEvent.Disconnected) {
                CallEvent.Disconnected disconnected = (CallEvent.Disconnected) callEvent;
                event = a(AppCallResultMappersKt.mapForEvent(disconnected.getResult()), disconnected.getInfo(), callEvent.getSide(), null);
            } else if (callEvent instanceof CallEvent.GreenButtonClicked) {
                event = new InAppCallGreenButtonClickedEvent(callEvent.getId(), Companion.access$mapInteractionFromUiToEventType(Companion, ((CallEvent.GreenButtonClicked) callEvent).getFromAppUi()));
            } else if (callEvent instanceof CallEvent.RedButtonClicked) {
                CallEvent.RedButtonClicked redButtonClicked = (CallEvent.RedButtonClicked) callEvent;
                AppCallInfo info2 = redButtonClicked.getInfo();
                if (info2 != null) {
                    inAppCallRedButtonClickedEvent = new InAppCallRedButtonClickedEvent(info2.getCallId(), info2.getScenario(), Companion.access$mapInteractionFromUiToEventType(Companion, redButtonClicked.getFromAppUi()));
                }
                event = inAppCallRedButtonClickedEvent;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        if (event != null) {
            return event;
        }
        StringBuilder L = a.L("Can't create event for CallEvent=[");
        L.append(callEvent.getClass().getSimpleName());
        L.append(']');
        return new NonFatalError(L.toString(), new CallEventFactoryException(), null, 4, null);
    }
}
