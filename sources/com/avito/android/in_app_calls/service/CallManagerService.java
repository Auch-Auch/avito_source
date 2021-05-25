package com.avito.android.in_app_calls.service;

import a2.a.a.f1.f.f;
import a2.a.a.f1.f.g;
import a2.b.a.a.a;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import com.avito.android.calls.audio.AudioDevice;
import com.avito.android.calls_shared.AppCallScenario;
import com.avito.android.calls_shared.CallerInfo;
import com.avito.android.calls_shared.ItemInfo;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.in_app_calls.CallManager;
import com.avito.android.in_app_calls.IncomingCallHandler;
import com.avito.android.in_app_calls.data.InAppCallPendingAction;
import com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies;
import com.avito.android.in_app_calls.di.DaggerCallManagerServiceComponent;
import com.avito.android.in_app_calls.service.callStartTasks.CallStartTask;
import com.avito.android.in_app_calls.util.WakeLocksKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\bL\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0010\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0004R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u00102\u001a\u00060/R\u0002008\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0013\u00101R\"\u00104\u001a\u0002038\u0006@\u0006X.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\"\u0010F\u001a\u00020E8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lcom/avito/android/in_app_calls/service/CallManagerService;", "Landroid/app/Service;", "", "onCreate", "()V", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "onUnbind", "(Landroid/content/Intent;)Z", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", AuthSource.SEND_ABUSE, "Lcom/avito/android/in_app_calls/IncomingCallHandler;", "incomingCallHandler", "Lcom/avito/android/in_app_calls/IncomingCallHandler;", "getIncomingCallHandler", "()Lcom/avito/android/in_app_calls/IncomingCallHandler;", "setIncomingCallHandler", "(Lcom/avito/android/in_app_calls/IncomingCallHandler;)V", "Lcom/avito/android/in_app_calls/service/CallManagerServiceDelegate;", "delegate", "Lcom/avito/android/in_app_calls/service/CallManagerServiceDelegate;", "getDelegate", "()Lcom/avito/android/in_app_calls/service/CallManagerServiceDelegate;", "setDelegate", "(Lcom/avito/android/in_app_calls/service/CallManagerServiceDelegate;)V", "binder", "Landroid/os/IBinder;", "getBinder", "()Landroid/os/IBinder;", "setBinder", "(Landroid/os/IBinder;)V", "Lcom/avito/android/in_app_calls/service/RingtoneDelegate;", "ringtoneDelegate", "Lcom/avito/android/in_app_calls/service/RingtoneDelegate;", "getRingtoneDelegate", "()Lcom/avito/android/in_app_calls/service/RingtoneDelegate;", "setRingtoneDelegate", "(Lcom/avito/android/in_app_calls/service/RingtoneDelegate;)V", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "Landroid/os/PowerManager$WakeLock;", "proximityWakeLock", "Lcom/avito/android/in_app_calls/CallManager;", "callManager", "Lcom/avito/android/in_app_calls/CallManager;", "getCallManager", "()Lcom/avito/android/in_app_calls/CallManager;", "setCallManager", "(Lcom/avito/android/in_app_calls/CallManager;)V", "Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask;", "callStartTasks", "Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask;", "getCallStartTasks", "()Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask;", "setCallStartTasks", "(Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask;)V", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/in_app_calls/service/CallNotificationsDelegate;", "notificationsDelegate", "Lcom/avito/android/in_app_calls/service/CallNotificationsDelegate;", "getNotificationsDelegate", "()Lcom/avito/android/in_app_calls/service/CallNotificationsDelegate;", "setNotificationsDelegate", "(Lcom/avito/android/in_app_calls/service/CallNotificationsDelegate;)V", "<init>", "StartRequest", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallManagerService extends Service {
    public PowerManager.WakeLock a;
    public final CompositeDisposable b = new CompositeDisposable();
    @Inject
    public IBinder binder;
    @Inject
    public CallManager callManager;
    @Inject
    public CallStartTask callStartTasks;
    @Inject
    public CallManagerServiceDelegate delegate;
    @Inject
    public IncomingCallHandler incomingCallHandler;
    @Inject
    public CallNotificationsDelegate notificationsDelegate;
    @Inject
    public RingtoneDelegate ringtoneDelegate;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest;", "Landroid/os/Parcelable;", "", "getCallUuid", "()Ljava/lang/String;", "callUuid", "<init>", "()V", "Dial", "PendingAction", "Receive", "Reconnect", "Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest$Dial;", "Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest$Receive;", "Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest$PendingAction;", "Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest$Reconnect;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class StartRequest implements Parcelable {

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JN\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\"\u0010\u001dJ \u0010'\u001a\u00020&2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b'\u0010(R\u0019\u0010\u0016\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u000eR\u0019\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b\u0017\u0010\u0011R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\nR\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0007R\u001c\u0010\u0012\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u0010/\u001a\u0004\b8\u0010\u0004¨\u0006;"}, d2 = {"Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest$Dial;", "Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/calls_shared/CallerInfo;", "component2", "()Lcom/avito/android/calls_shared/CallerInfo;", "Lcom/avito/android/calls_shared/ItemInfo;", "component3", "()Lcom/avito/android/calls_shared/ItemInfo;", "component4", "Lcom/avito/android/calls_shared/AppCallScenario;", "component5", "()Lcom/avito/android/calls_shared/AppCallScenario;", "", "component6", "()Z", "callUuid", "recipient", "item", "callAs", "scenario", "isNewCall", "copy", "(Ljava/lang/String;Lcom/avito/android/calls_shared/CallerInfo;Lcom/avito/android/calls_shared/ItemInfo;Ljava/lang/String;Lcom/avito/android/calls_shared/AppCallScenario;Z)Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest$Dial;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "e", "Lcom/avito/android/calls_shared/AppCallScenario;", "getScenario", "f", "Z", "d", "Ljava/lang/String;", "getCallAs", "c", "Lcom/avito/android/calls_shared/ItemInfo;", "getItem", AuthSource.BOOKING_ORDER, "Lcom/avito/android/calls_shared/CallerInfo;", "getRecipient", AuthSource.SEND_ABUSE, "getCallUuid", "<init>", "(Ljava/lang/String;Lcom/avito/android/calls_shared/CallerInfo;Lcom/avito/android/calls_shared/ItemInfo;Ljava/lang/String;Lcom/avito/android/calls_shared/AppCallScenario;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Dial extends StartRequest {
            public static final Parcelable.Creator<Dial> CREATOR = new Creator();
            @NotNull
            public final String a;
            @NotNull
            public final CallerInfo b;
            @NotNull
            public final ItemInfo c;
            @Nullable
            public final String d;
            @NotNull
            public final AppCallScenario e;
            public final boolean f;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Dial> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Dial createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Dial(parcel.readString(), (CallerInfo) parcel.readParcelable(Dial.class.getClassLoader()), (ItemInfo) parcel.readParcelable(Dial.class.getClassLoader()), parcel.readString(), (AppCallScenario) Enum.valueOf(AppCallScenario.class, parcel.readString()), parcel.readInt() != 0);
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Dial[] newArray(int i) {
                    return new Dial[i];
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Dial(String str, CallerInfo callerInfo, ItemInfo itemInfo, String str2, AppCallScenario appCallScenario, boolean z, int i, j jVar) {
                this(str, callerInfo, itemInfo, (i & 8) != 0 ? null : str2, appCallScenario, z);
            }

            public static /* synthetic */ Dial copy$default(Dial dial, String str, CallerInfo callerInfo, ItemInfo itemInfo, String str2, AppCallScenario appCallScenario, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = dial.getCallUuid();
                }
                if ((i & 2) != 0) {
                    callerInfo = dial.b;
                }
                if ((i & 4) != 0) {
                    itemInfo = dial.c;
                }
                if ((i & 8) != 0) {
                    str2 = dial.d;
                }
                if ((i & 16) != 0) {
                    appCallScenario = dial.e;
                }
                if ((i & 32) != 0) {
                    z = dial.f;
                }
                return dial.copy(str, callerInfo, itemInfo, str2, appCallScenario, z);
            }

            @NotNull
            public final String component1() {
                return getCallUuid();
            }

            @NotNull
            public final CallerInfo component2() {
                return this.b;
            }

            @NotNull
            public final ItemInfo component3() {
                return this.c;
            }

            @Nullable
            public final String component4() {
                return this.d;
            }

            @NotNull
            public final AppCallScenario component5() {
                return this.e;
            }

            public final boolean component6() {
                return this.f;
            }

            @NotNull
            public final Dial copy(@NotNull String str, @NotNull CallerInfo callerInfo, @NotNull ItemInfo itemInfo, @Nullable String str2, @NotNull AppCallScenario appCallScenario, boolean z) {
                Intrinsics.checkNotNullParameter(str, "callUuid");
                Intrinsics.checkNotNullParameter(callerInfo, "recipient");
                Intrinsics.checkNotNullParameter(itemInfo, "item");
                Intrinsics.checkNotNullParameter(appCallScenario, "scenario");
                return new Dial(str, callerInfo, itemInfo, str2, appCallScenario, z);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Dial)) {
                    return false;
                }
                Dial dial = (Dial) obj;
                return Intrinsics.areEqual(getCallUuid(), dial.getCallUuid()) && Intrinsics.areEqual(this.b, dial.b) && Intrinsics.areEqual(this.c, dial.c) && Intrinsics.areEqual(this.d, dial.d) && Intrinsics.areEqual(this.e, dial.e) && this.f == dial.f;
            }

            @Nullable
            public final String getCallAs() {
                return this.d;
            }

            @Override // com.avito.android.in_app_calls.service.CallManagerService.StartRequest
            @NotNull
            public String getCallUuid() {
                return this.a;
            }

            @NotNull
            public final ItemInfo getItem() {
                return this.c;
            }

            @NotNull
            public final CallerInfo getRecipient() {
                return this.b;
            }

            @NotNull
            public final AppCallScenario getScenario() {
                return this.e;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String callUuid = getCallUuid();
                int i = 0;
                int hashCode = (callUuid != null ? callUuid.hashCode() : 0) * 31;
                CallerInfo callerInfo = this.b;
                int hashCode2 = (hashCode + (callerInfo != null ? callerInfo.hashCode() : 0)) * 31;
                ItemInfo itemInfo = this.c;
                int hashCode3 = (hashCode2 + (itemInfo != null ? itemInfo.hashCode() : 0)) * 31;
                String str = this.d;
                int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
                AppCallScenario appCallScenario = this.e;
                if (appCallScenario != null) {
                    i = appCallScenario.hashCode();
                }
                int i2 = (hashCode4 + i) * 31;
                boolean z = this.f;
                if (z) {
                    z = true;
                }
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                int i5 = z ? 1 : 0;
                return i2 + i3;
            }

            public final boolean isNewCall() {
                return this.f;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("Dial(callUuid=");
                L.append(getCallUuid());
                L.append(", recipient=");
                L.append(this.b);
                L.append(", item=");
                L.append(this.c);
                L.append(", callAs=");
                L.append(this.d);
                L.append(", scenario=");
                L.append(this.e);
                L.append(", isNewCall=");
                return a.B(L, this.f, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.a);
                parcel.writeParcelable(this.b, i);
                parcel.writeParcelable(this.c, i);
                parcel.writeString(this.d);
                parcel.writeString(this.e.name());
                parcel.writeInt(this.f ? 1 : 0);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Dial(@NotNull String str, @NotNull CallerInfo callerInfo, @NotNull ItemInfo itemInfo, @Nullable String str2, @NotNull AppCallScenario appCallScenario, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "callUuid");
                Intrinsics.checkNotNullParameter(callerInfo, "recipient");
                Intrinsics.checkNotNullParameter(itemInfo, "item");
                Intrinsics.checkNotNullParameter(appCallScenario, "scenario");
                this.a = str;
                this.b = callerInfo;
                this.c = itemInfo;
                this.d = str2;
                this.e = appCallScenario;
                this.f = z;
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest$PendingAction;", "Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;", "component2", "()Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;", "callUuid", "pendingAction", "copy", "(Ljava/lang/String;Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;)Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest$PendingAction;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCallUuid", AuthSource.BOOKING_ORDER, "Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;", "getPendingAction", "<init>", "(Ljava/lang/String;Lcom/avito/android/in_app_calls/data/InAppCallPendingAction;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class PendingAction extends StartRequest {
            public static final Parcelable.Creator<PendingAction> CREATOR = new Creator();
            @NotNull
            public final String a;
            @NotNull
            public final InAppCallPendingAction b;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<PendingAction> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final PendingAction createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new PendingAction(parcel.readString(), (InAppCallPendingAction) Enum.valueOf(InAppCallPendingAction.class, parcel.readString()));
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final PendingAction[] newArray(int i) {
                    return new PendingAction[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public PendingAction(@NotNull String str, @NotNull InAppCallPendingAction inAppCallPendingAction) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "callUuid");
                Intrinsics.checkNotNullParameter(inAppCallPendingAction, "pendingAction");
                this.a = str;
                this.b = inAppCallPendingAction;
            }

            public static /* synthetic */ PendingAction copy$default(PendingAction pendingAction, String str, InAppCallPendingAction inAppCallPendingAction, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = pendingAction.getCallUuid();
                }
                if ((i & 2) != 0) {
                    inAppCallPendingAction = pendingAction.b;
                }
                return pendingAction.copy(str, inAppCallPendingAction);
            }

            @NotNull
            public final String component1() {
                return getCallUuid();
            }

            @NotNull
            public final InAppCallPendingAction component2() {
                return this.b;
            }

            @NotNull
            public final PendingAction copy(@NotNull String str, @NotNull InAppCallPendingAction inAppCallPendingAction) {
                Intrinsics.checkNotNullParameter(str, "callUuid");
                Intrinsics.checkNotNullParameter(inAppCallPendingAction, "pendingAction");
                return new PendingAction(str, inAppCallPendingAction);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof PendingAction)) {
                    return false;
                }
                PendingAction pendingAction = (PendingAction) obj;
                return Intrinsics.areEqual(getCallUuid(), pendingAction.getCallUuid()) && Intrinsics.areEqual(this.b, pendingAction.b);
            }

            @Override // com.avito.android.in_app_calls.service.CallManagerService.StartRequest
            @NotNull
            public String getCallUuid() {
                return this.a;
            }

            @NotNull
            public final InAppCallPendingAction getPendingAction() {
                return this.b;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String callUuid = getCallUuid();
                int i = 0;
                int hashCode = (callUuid != null ? callUuid.hashCode() : 0) * 31;
                InAppCallPendingAction inAppCallPendingAction = this.b;
                if (inAppCallPendingAction != null) {
                    i = inAppCallPendingAction.hashCode();
                }
                return hashCode + i;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("PendingAction(callUuid=");
                L.append(getCallUuid());
                L.append(", pendingAction=");
                L.append(this.b);
                L.append(")");
                return L.toString();
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.a);
                parcel.writeString(this.b.name());
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0007R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\n¨\u0006+"}, d2 = {"Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest$Receive;", "Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/calls_shared/CallerInfo;", "component2", "()Lcom/avito/android/calls_shared/CallerInfo;", "Lcom/avito/android/calls_shared/ItemInfo;", "component3", "()Lcom/avito/android/calls_shared/ItemInfo;", "callUuid", "caller", "item", "copy", "(Ljava/lang/String;Lcom/avito/android/calls_shared/CallerInfo;Lcom/avito/android/calls_shared/ItemInfo;)Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest$Receive;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCallUuid", AuthSource.BOOKING_ORDER, "Lcom/avito/android/calls_shared/CallerInfo;", "getCaller", "c", "Lcom/avito/android/calls_shared/ItemInfo;", "getItem", "<init>", "(Ljava/lang/String;Lcom/avito/android/calls_shared/CallerInfo;Lcom/avito/android/calls_shared/ItemInfo;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Receive extends StartRequest {
            public static final Parcelable.Creator<Receive> CREATOR = new Creator();
            @NotNull
            public final String a;
            @NotNull
            public final CallerInfo b;
            @Nullable
            public final ItemInfo c;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Receive> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Receive createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Receive(parcel.readString(), (CallerInfo) parcel.readParcelable(Receive.class.getClassLoader()), (ItemInfo) parcel.readParcelable(Receive.class.getClassLoader()));
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Receive[] newArray(int i) {
                    return new Receive[i];
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Receive(String str, CallerInfo callerInfo, ItemInfo itemInfo, int i, j jVar) {
                this(str, callerInfo, (i & 4) != 0 ? null : itemInfo);
            }

            public static /* synthetic */ Receive copy$default(Receive receive, String str, CallerInfo callerInfo, ItemInfo itemInfo, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = receive.getCallUuid();
                }
                if ((i & 2) != 0) {
                    callerInfo = receive.b;
                }
                if ((i & 4) != 0) {
                    itemInfo = receive.c;
                }
                return receive.copy(str, callerInfo, itemInfo);
            }

            @NotNull
            public final String component1() {
                return getCallUuid();
            }

            @NotNull
            public final CallerInfo component2() {
                return this.b;
            }

            @Nullable
            public final ItemInfo component3() {
                return this.c;
            }

            @NotNull
            public final Receive copy(@NotNull String str, @NotNull CallerInfo callerInfo, @Nullable ItemInfo itemInfo) {
                Intrinsics.checkNotNullParameter(str, "callUuid");
                Intrinsics.checkNotNullParameter(callerInfo, "caller");
                return new Receive(str, callerInfo, itemInfo);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Receive)) {
                    return false;
                }
                Receive receive = (Receive) obj;
                return Intrinsics.areEqual(getCallUuid(), receive.getCallUuid()) && Intrinsics.areEqual(this.b, receive.b) && Intrinsics.areEqual(this.c, receive.c);
            }

            @Override // com.avito.android.in_app_calls.service.CallManagerService.StartRequest
            @NotNull
            public String getCallUuid() {
                return this.a;
            }

            @NotNull
            public final CallerInfo getCaller() {
                return this.b;
            }

            @Nullable
            public final ItemInfo getItem() {
                return this.c;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String callUuid = getCallUuid();
                int i = 0;
                int hashCode = (callUuid != null ? callUuid.hashCode() : 0) * 31;
                CallerInfo callerInfo = this.b;
                int hashCode2 = (hashCode + (callerInfo != null ? callerInfo.hashCode() : 0)) * 31;
                ItemInfo itemInfo = this.c;
                if (itemInfo != null) {
                    i = itemInfo.hashCode();
                }
                return hashCode2 + i;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("Receive(callUuid=");
                L.append(getCallUuid());
                L.append(", caller=");
                L.append(this.b);
                L.append(", item=");
                L.append(this.c);
                L.append(")");
                return L.toString();
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.a);
                parcel.writeParcelable(this.b, i);
                parcel.writeParcelable(this.c, i);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Receive(@NotNull String str, @NotNull CallerInfo callerInfo, @Nullable ItemInfo itemInfo) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "callUuid");
                Intrinsics.checkNotNullParameter(callerInfo, "caller");
                this.a = str;
                this.b = callerInfo;
                this.c = itemInfo;
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest$Reconnect;", "Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest;", "", "component1", "()Ljava/lang/String;", "callUuid", "copy", "(Ljava/lang/String;)Lcom/avito/android/in_app_calls/service/CallManagerService$StartRequest$Reconnect;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCallUuid", "<init>", "(Ljava/lang/String;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Reconnect extends StartRequest {
            public static final Parcelable.Creator<Reconnect> CREATOR = new Creator();
            @NotNull
            public final String a;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Reconnect> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Reconnect createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Reconnect(parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Reconnect[] newArray(int i) {
                    return new Reconnect[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Reconnect(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "callUuid");
                this.a = str;
            }

            public static /* synthetic */ Reconnect copy$default(Reconnect reconnect, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = reconnect.getCallUuid();
                }
                return reconnect.copy(str);
            }

            @NotNull
            public final String component1() {
                return getCallUuid();
            }

            @NotNull
            public final Reconnect copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "callUuid");
                return new Reconnect(str);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Reconnect) && Intrinsics.areEqual(getCallUuid(), ((Reconnect) obj).getCallUuid());
                }
                return true;
            }

            @Override // com.avito.android.in_app_calls.service.CallManagerService.StartRequest
            @NotNull
            public String getCallUuid() {
                return this.a;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String callUuid = getCallUuid();
                if (callUuid != null) {
                    return callUuid.hashCode();
                }
                return 0;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("Reconnect(callUuid=");
                L.append(getCallUuid());
                L.append(")");
                return L.toString();
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.a);
            }
        }

        public StartRequest() {
        }

        @NotNull
        public abstract String getCallUuid();

        public StartRequest(j jVar) {
        }
    }

    public static final void access$updateProximityWakeLockState(CallManagerService callManagerService, AudioDevice audioDevice) {
        Objects.requireNonNull(callManagerService);
        if (Intrinsics.areEqual(audioDevice, AudioDevice.Earpiece.INSTANCE) || Intrinsics.areEqual(audioDevice, AudioDevice.None.INSTANCE)) {
            PowerManager.WakeLock wakeLock = callManagerService.a;
            if (wakeLock == null) {
                Intrinsics.throwUninitializedPropertyAccessException("proximityWakeLock");
            }
            wakeLock.acquire();
            return;
        }
        callManagerService.a();
    }

    public final void a() {
        PowerManager.WakeLock wakeLock = this.a;
        if (wakeLock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("proximityWakeLock");
        }
        if (wakeLock.isHeld()) {
            PowerManager.WakeLock wakeLock2 = this.a;
            if (wakeLock2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("proximityWakeLock");
            }
            WakeLocksKt.releaseQuietly$default(wakeLock2, 1, false, 2, null);
        }
    }

    @NotNull
    public final IBinder getBinder() {
        IBinder iBinder = this.binder;
        if (iBinder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binder");
        }
        return iBinder;
    }

    @NotNull
    public final CallManager getCallManager() {
        CallManager callManager2 = this.callManager;
        if (callManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callManager");
        }
        return callManager2;
    }

    @NotNull
    public final CallStartTask getCallStartTasks() {
        CallStartTask callStartTask = this.callStartTasks;
        if (callStartTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callStartTasks");
        }
        return callStartTask;
    }

    @NotNull
    public final CallManagerServiceDelegate getDelegate() {
        CallManagerServiceDelegate callManagerServiceDelegate = this.delegate;
        if (callManagerServiceDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return callManagerServiceDelegate;
    }

    @NotNull
    public final IncomingCallHandler getIncomingCallHandler() {
        IncomingCallHandler incomingCallHandler2 = this.incomingCallHandler;
        if (incomingCallHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("incomingCallHandler");
        }
        return incomingCallHandler2;
    }

    @NotNull
    public final CallNotificationsDelegate getNotificationsDelegate() {
        CallNotificationsDelegate callNotificationsDelegate = this.notificationsDelegate;
        if (callNotificationsDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationsDelegate");
        }
        return callNotificationsDelegate;
    }

    @NotNull
    public final RingtoneDelegate getRingtoneDelegate() {
        RingtoneDelegate ringtoneDelegate2 = this.ringtoneDelegate;
        if (ringtoneDelegate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ringtoneDelegate");
        }
        return ringtoneDelegate2;
    }

    @Override // android.app.Service
    @NotNull
    public IBinder onBind(@Nullable Intent intent) {
        CallManagerServiceDelegate callManagerServiceDelegate = this.delegate;
        if (callManagerServiceDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        callManagerServiceDelegate.onBind();
        Logs.debug$default(LogTagsKt.TAG_CALL_MANAGER_SERVICE, "Service bounded", null, 4, null);
        IBinder iBinder = this.binder;
        if (iBinder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binder");
        }
        return iBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DaggerCallManagerServiceComponent.factory().create(this, (CallManagerServiceComponentDependencies) ComponentDependenciesKt.getDependencies(CallManagerServiceComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Service) this))).inject(this);
        Object systemService = getSystemService("power");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(32, "avito:call");
        Intrinsics.checkNotNullExpressionValue(newWakeLock, "powerManager.newWakeLock…Y_WAKE_LOCK_TAG\n        )");
        this.a = newWakeLock;
        if (newWakeLock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("proximityWakeLock");
        }
        newWakeLock.setReferenceCounted(false);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        CompositeDisposable compositeDisposable = this.b;
        CallManagerServiceDelegate callManagerServiceDelegate = this.delegate;
        if (callManagerServiceDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        Disposable subscribe = callManagerServiceDelegate.getStateObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, objectRef));
        Intrinsics.checkNotNullExpressionValue(subscribe, "delegate.stateObservable…ate = state\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.b;
        CallManager callManager2 = this.callManager;
        if (callManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callManager");
        }
        Disposable subscribe2 = callManager2.getMissedCallsStream().debounce(2000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "callManager.missedCallsS…missedCall)\n            }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        Logs.debug$default(LogTagsKt.TAG_CALL_MANAGER_SERVICE, "Service created", null, 4, null);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        IncomingCallHandler incomingCallHandler2 = this.incomingCallHandler;
        if (incomingCallHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("incomingCallHandler");
        }
        incomingCallHandler2.setAcceptReconnectCalls(false);
        RingtoneDelegate ringtoneDelegate2 = this.ringtoneDelegate;
        if (ringtoneDelegate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ringtoneDelegate");
        }
        ringtoneDelegate2.destroy();
        CallManagerServiceDelegate callManagerServiceDelegate = this.delegate;
        if (callManagerServiceDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        callManagerServiceDelegate.destroy();
        this.b.clear();
        RingtoneDelegate ringtoneDelegate3 = this.ringtoneDelegate;
        if (ringtoneDelegate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ringtoneDelegate");
        }
        ringtoneDelegate3.stopRingtone();
        PowerManager.WakeLock wakeLock = this.a;
        if (wakeLock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("proximityWakeLock");
        }
        WakeLocksKt.releaseQuietly$default(wakeLock, 0, false, 3, null);
        CallNotificationsDelegate callNotificationsDelegate = this.notificationsDelegate;
        if (callNotificationsDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationsDelegate");
        }
        callNotificationsDelegate.stopForeground();
        CallStartTask callStartTask = this.callStartTasks;
        if (callStartTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callStartTasks");
        }
        callStartTask.stop();
        Logs.debug$default(LogTagsKt.TAG_CALL_MANAGER_SERVICE, "Service destroyed", null, 4, null);
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        StartRequest startRequest = intent != null ? (StartRequest) intent.getParcelableExtra("start_request") : null;
        Logs.debug$default(LogTagsKt.TAG_CALL_MANAGER_SERVICE, "Service started with request: " + startRequest, null, 4, null);
        if (startRequest == null) {
            return 2;
        }
        CallStartTask callStartTask = this.callStartTasks;
        if (callStartTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callStartTasks");
        }
        callStartTask.run(new CallStartTask.TaskParams(startRequest.getCallUuid()));
        CallManagerServiceDelegate callManagerServiceDelegate = this.delegate;
        if (callManagerServiceDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        callManagerServiceDelegate.start(startRequest);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(@Nullable Intent intent) {
        CallManagerServiceDelegate callManagerServiceDelegate = this.delegate;
        if (callManagerServiceDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        callManagerServiceDelegate.onUnbind();
        Logs.debug$default(LogTagsKt.TAG_CALL_MANAGER_SERVICE, "Service unbounded", null, 4, null);
        return super.onUnbind(intent);
    }

    public final void setBinder(@NotNull IBinder iBinder) {
        Intrinsics.checkNotNullParameter(iBinder, "<set-?>");
        this.binder = iBinder;
    }

    public final void setCallManager(@NotNull CallManager callManager2) {
        Intrinsics.checkNotNullParameter(callManager2, "<set-?>");
        this.callManager = callManager2;
    }

    public final void setCallStartTasks(@NotNull CallStartTask callStartTask) {
        Intrinsics.checkNotNullParameter(callStartTask, "<set-?>");
        this.callStartTasks = callStartTask;
    }

    public final void setDelegate(@NotNull CallManagerServiceDelegate callManagerServiceDelegate) {
        Intrinsics.checkNotNullParameter(callManagerServiceDelegate, "<set-?>");
        this.delegate = callManagerServiceDelegate;
    }

    public final void setIncomingCallHandler(@NotNull IncomingCallHandler incomingCallHandler2) {
        Intrinsics.checkNotNullParameter(incomingCallHandler2, "<set-?>");
        this.incomingCallHandler = incomingCallHandler2;
    }

    public final void setNotificationsDelegate(@NotNull CallNotificationsDelegate callNotificationsDelegate) {
        Intrinsics.checkNotNullParameter(callNotificationsDelegate, "<set-?>");
        this.notificationsDelegate = callNotificationsDelegate;
    }

    public final void setRingtoneDelegate(@NotNull RingtoneDelegate ringtoneDelegate2) {
        Intrinsics.checkNotNullParameter(ringtoneDelegate2, "<set-?>");
        this.ringtoneDelegate = ringtoneDelegate2;
    }
}
