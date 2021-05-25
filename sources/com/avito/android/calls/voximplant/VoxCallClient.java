package com.avito.android.calls.voximplant;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.calls.AvitoCallClient;
import com.avito.android.calls.CallClientAvailabilityNotifier;
import com.avito.android.calls.CallExtras;
import com.avito.android.calls.ConnectionListener;
import com.avito.android.calls.Credentials;
import com.avito.android.calls.CredentialsStorage;
import com.avito.android.calls.IncomingCall;
import com.avito.android.calls.IncomingCallListener;
import com.avito.android.calls.OneTimeLoginCredentialsProvider;
import com.avito.android.calls.OutgoingCall;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls.auth.PushTokenRegistration;
import com.avito.android.calls.auth.UsernameProvider;
import com.avito.android.calls.voximplant.VoxCallClient;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.calls_shared.models.CallAvailabilityNotifiedState;
import com.avito.android.calls_shared.storage.CallStorage;
import com.avito.android.push.provider.GcmPushTokenProvider;
import com.avito.android.push.provider.PushTokenProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.Collections;
import com.avito.android.util.Logs;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.preferences.Preference;
import com.avito.android.util.rx3.InteropKt;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import com.voximplant.sdk.Voximplant;
import com.voximplant.sdk.call.CallSettings;
import com.voximplant.sdk.call.ICall;
import com.voximplant.sdk.call.VideoFlags;
import com.voximplant.sdk.client.ClientConfig;
import com.voximplant.sdk.client.ClientState;
import com.voximplant.sdk.client.IClient;
import com.voximplant.sdk.client.IClientIncomingCallListener;
import com.voximplant.sdk.client.IPushTokenCompletionHandler;
import com.voximplant.sdk.client.LogLevel;
import com.voximplant.sdk.client.LoginError;
import com.voximplant.sdk.client.PushTokenError;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u00027y\u0018\u00002\u00020\u0001:\u0002}~J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J%\u0010\r\u001a\u00020\u00042\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u000f\u0010\u0014J#\u0010\u0016\u001a\u00020\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b&\u0010'J\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020)2\u0006\u0010(\u001a\u00020\u0012H\u0016¢\u0006\u0004\b*\u0010+J'\u0010,\u001a\u00020\u00122\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bH\u0002¢\u0006\u0004\b,\u0010\u0017J\u001b\u0010/\u001a\u00020\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0004H\u0002¢\u0006\u0004\b1\u0010\bJ\u0017\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0012H\u0002¢\u0006\u0004\b3\u0010\u0014R\u0018\u00106\u001a\u0004\u0018\u00010\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR$\u0010X\u001a\u00020S2\u0006\u0010T\u001a\u00020S8\u0002@BX\u000e¢\u0006\f\n\u0004\b/\u0010U\"\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020Y8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010ZR\u0016\u0010^\u001a\u00020\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010]R\u0018\u0010a\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010p\u001a\u00020n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010oR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{¨\u0006"}, d2 = {"Lcom/avito/android/calls/voximplant/VoxCallClient;", "Lcom/avito/android/calls/AvitoCallClient;", "", ChannelContext.Item.USER_ID, "", "register", "(Ljava/lang/String;)V", "unregister", "()V", "name", "connectForOutgoingCall", "", "pushData", "connectForIncomingCall", "(Ljava/util/Map;)V", "disconnect", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "updatePushToken", "", "logout", "(Z)V", "data", "shouldStartFromPush", "(Ljava/util/Map;)Z", "callUuid", "targetId", "isVideo", "earlyBeeps", "Lcom/avito/android/calls/CallExtras;", AppLinkData.ARGUMENTS_EXTRAS_KEY, "Lcom/avito/android/calls/OutgoingCall;", "makeCall", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/calls/CallExtras;)Lcom/avito/android/calls/OutgoingCall;", "Lcom/avito/android/calls/IncomingCallListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setIncomingCallListener", "(Lcom/avito/android/calls/IncomingCallListener;)V", "Lcom/avito/android/calls/ConnectionListener;", "setConnectionListener", "(Lcom/avito/android/calls/ConnectionListener;)V", "enableVideo", "", "getMissingPermissions", "(Z)Ljava/util/List;", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls/Credentials$AccessToken;", "tokenCredentials", "d", "(Lcom/avito/android/calls/Credentials$AccessToken;)V", "c", "isRegistered", AuthSource.BOOKING_ORDER, "getUsername", "()Ljava/lang/String;", Preference.USERNAME, "com/avito/android/calls/voximplant/VoxCallClient$sessionListener$1", "e", "Lcom/avito/android/calls/voximplant/VoxCallClient$sessionListener$1;", "sessionListener", "Lcom/voximplant/sdk/client/IClient;", "i", "Lcom/voximplant/sdk/client/IClient;", "instance", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "p", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "analyticsTracker", "Lcom/avito/android/Features;", VKApiConst.Q, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/calls/OneTimeLoginCredentialsProvider;", "l", "Lcom/avito/android/calls/OneTimeLoginCredentialsProvider;", "oneTimeLoginCredentialsProvider", "Lcom/avito/android/calls_shared/storage/CallStorage;", "k", "Lcom/avito/android/calls_shared/storage/CallStorage;", "callStorage", "Lcom/avito/android/calls/auth/UsernameProvider;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/calls/auth/UsernameProvider;", "usernameProvider", "Lcom/avito/android/calls/voximplant/VoxCallClient$Command;", "value", "Lcom/avito/android/calls/voximplant/VoxCallClient$Command;", "setCurrentCommand", "(Lcom/avito/android/calls/voximplant/VoxCallClient$Command;)V", "currentCommand", "", "J", "retryCount", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", a2.g.r.g.a, "Lcom/avito/android/calls/ConnectionListener;", "connectionListener", "Lcom/avito/android/calls/CredentialsStorage;", "j", "Lcom/avito/android/calls/CredentialsStorage;", "credentialsStorage", "Landroid/content/Context;", "h", "Landroid/content/Context;", "context", "Lcom/avito/android/push/provider/PushTokenProvider;", "n", "Lcom/avito/android/push/provider/PushTokenProvider;", "pushTokenProvider", "Lio/reactivex/Scheduler;", "Lio/reactivex/Scheduler;", "scheduler", "Lcom/avito/android/calls/CallClientAvailabilityNotifier;", "o", "Lcom/avito/android/calls/CallClientAvailabilityNotifier;", "callClientAvailabilityNotifier", "Ljava/util/concurrent/Executor;", "r", "Ljava/util/concurrent/Executor;", "executor", "com/avito/android/calls/voximplant/VoxCallClient$loginListener$1", "f", "Lcom/avito/android/calls/voximplant/VoxCallClient$loginListener$1;", "loginListener", "Builder", "Command", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class VoxCallClient implements AvitoCallClient {
    public final Scheduler a;
    public final CompositeDisposable b = new CompositeDisposable();
    public long c;
    public Command d = Command.DISCONNECT;
    public final VoxCallClient$sessionListener$1 e;
    public final VoxCallClient$loginListener$1 f;
    public ConnectionListener g;
    public final Context h;
    public final IClient i;
    public final CredentialsStorage j;
    public final CallStorage k;
    public final OneTimeLoginCredentialsProvider l;
    public final UsernameProvider m;
    public final PushTokenProvider n;
    public final CallClientAvailabilityNotifier o;
    public final CallAnalyticsTracker p;
    public final Features q;
    public final Executor r;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010-\u001a\u00020)\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010>\u001a\u00020;¢\u0006\u0004\bA\u0010BJ\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001e\u0010-\u001a\n **\u0004\u0018\u00010)0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u0013\u001a\u0002008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006C"}, d2 = {"Lcom/avito/android/calls/voximplant/VoxCallClient$Builder;", "", "Lcom/avito/android/calls/CredentialsStorage;", "value", "credentialsStorage", "(Lcom/avito/android/calls/CredentialsStorage;)Lcom/avito/android/calls/voximplant/VoxCallClient$Builder;", "Lcom/avito/android/calls/OneTimeLoginCredentialsProvider;", GeoContract.PROVIDER, "oneTimeLoginCredentialsProvider", "(Lcom/avito/android/calls/OneTimeLoginCredentialsProvider;)Lcom/avito/android/calls/voximplant/VoxCallClient$Builder;", "Lcom/avito/android/calls/auth/UsernameProvider;", "usernameProvider", "(Lcom/avito/android/calls/auth/UsernameProvider;)Lcom/avito/android/calls/voximplant/VoxCallClient$Builder;", "", "enable", "enableDebugLogging", "(Z)Lcom/avito/android/calls/voximplant/VoxCallClient$Builder;", "enableLogcatLogging", "Lcom/avito/android/push/provider/GcmPushTokenProvider;", "pushTokenProvider", "(Lcom/avito/android/push/provider/GcmPushTokenProvider;)Lcom/avito/android/calls/voximplant/VoxCallClient$Builder;", "Lcom/avito/android/calls/CallClientAvailabilityNotifier;", "notifier", "callClientAvailabilityNotifier", "(Lcom/avito/android/calls/CallClientAvailabilityNotifier;)Lcom/avito/android/calls/voximplant/VoxCallClient$Builder;", "Ljava/util/concurrent/Executor;", "executor", "(Ljava/util/concurrent/Executor;)Lcom/avito/android/calls/voximplant/VoxCallClient$Builder;", "Lcom/avito/android/calls/voximplant/VoxCallClient;", "build", "()Lcom/avito/android/calls/voximplant/VoxCallClient;", "e", "Lcom/avito/android/calls/CredentialsStorage;", "f", "Lcom/avito/android/calls/OneTimeLoginCredentialsProvider;", "h", "Lcom/avito/android/calls/CallClientAvailabilityNotifier;", "Lcom/avito/android/Features;", "j", "Lcom/avito/android/Features;", "features", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", AuthSource.BOOKING_ORDER, "Ljava/util/concurrent/Executor;", "Lcom/avito/android/push/provider/PushTokenProvider;", "c", "Lcom/avito/android/push/provider/PushTokenProvider;", "Lcom/avito/android/calls_shared/storage/CallStorage;", "i", "Lcom/avito/android/calls_shared/storage/CallStorage;", "callStorage", "Lcom/voximplant/sdk/client/ClientConfig;", "d", "Lcom/voximplant/sdk/client/ClientConfig;", "clientConfig", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "k", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "analyticsTracker", a2.g.r.g.a, "Lcom/avito/android/calls/auth/UsernameProvider;", "<init>", "(Landroid/content/Context;Lcom/avito/android/calls_shared/storage/CallStorage;Lcom/avito/android/Features;Lcom/avito/android/calls/analytics/CallAnalyticsTracker;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Builder {
        public final Context a;
        public Executor b;
        public PushTokenProvider c = new PushTokenProvider.Dummy();
        public ClientConfig d = new ClientConfig();
        public CredentialsStorage e;
        public OneTimeLoginCredentialsProvider f;
        public UsernameProvider g;
        public CallClientAvailabilityNotifier h;
        public final CallStorage i;
        public final Features j;
        public final CallAnalyticsTracker k;

        public static final class a implements ThreadFactory {
            public static final a a = new a();

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, LogTagsKt.TAG_VOX_CLIENT);
            }
        }

        public Builder(@NotNull Context context, @NotNull CallStorage callStorage, @NotNull Features features, @NotNull CallAnalyticsTracker callAnalyticsTracker) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callStorage, "callStorage");
            Intrinsics.checkNotNullParameter(features, "features");
            Intrinsics.checkNotNullParameter(callAnalyticsTracker, "analyticsTracker");
            this.i = callStorage;
            this.j = features;
            this.k = callAnalyticsTracker;
            this.a = context.getApplicationContext();
        }

        @NotNull
        public final VoxCallClient build() {
            CredentialsStorage credentialsStorage = this.e;
            if (credentialsStorage != null) {
                UsernameProvider usernameProvider = this.g;
                if (usernameProvider != null) {
                    CallClientAvailabilityNotifier callClientAvailabilityNotifier = this.h;
                    if (callClientAvailabilityNotifier != null) {
                        ClientConfig clientConfig = this.d;
                        Context context = this.a;
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        clientConfig.packageName = context.getPackageName();
                        Executor executor = this.b;
                        if (executor == null) {
                            executor = Executors.newSingleThreadExecutor(a.a);
                        }
                        IClient clientInstance = Voximplant.getClientInstance(executor, this.a, this.d);
                        Context context2 = this.a;
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        Intrinsics.checkNotNullExpressionValue(clientInstance, "clientInstance");
                        CallStorage callStorage = this.i;
                        OneTimeLoginCredentialsProvider oneTimeLoginCredentialsProvider = this.f;
                        Features features = this.j;
                        CallAnalyticsTracker callAnalyticsTracker = this.k;
                        PushTokenProvider pushTokenProvider = this.c;
                        Intrinsics.checkNotNullExpressionValue(executor, "executor");
                        return new VoxCallClient(context2, clientInstance, credentialsStorage, callStorage, oneTimeLoginCredentialsProvider, usernameProvider, pushTokenProvider, callClientAvailabilityNotifier, callAnalyticsTracker, features, executor, null);
                    }
                    throw new IllegalArgumentException("CallClientAvailability notifier is not set".toString());
                }
                throw new IllegalArgumentException("UsernameProvider is not set".toString());
            }
            throw new IllegalArgumentException("CredentialsStorage is not set".toString());
        }

        @NotNull
        public final Builder callClientAvailabilityNotifier(@NotNull CallClientAvailabilityNotifier callClientAvailabilityNotifier) {
            Intrinsics.checkNotNullParameter(callClientAvailabilityNotifier, "notifier");
            this.h = callClientAvailabilityNotifier;
            return this;
        }

        @NotNull
        public final Builder credentialsStorage(@NotNull CredentialsStorage credentialsStorage) {
            Intrinsics.checkNotNullParameter(credentialsStorage, "value");
            this.e = credentialsStorage;
            return this;
        }

        @NotNull
        public final Builder enableDebugLogging(boolean z) {
            this.d.enableDebugLogging = z;
            return this;
        }

        @NotNull
        public final Builder enableLogcatLogging(boolean z) {
            this.d.enableLogcatLogging = z;
            return this;
        }

        @NotNull
        public final Builder executor(@NotNull Executor executor) {
            Intrinsics.checkNotNullParameter(executor, "value");
            this.b = executor;
            return this;
        }

        @NotNull
        public final Builder oneTimeLoginCredentialsProvider(@NotNull OneTimeLoginCredentialsProvider oneTimeLoginCredentialsProvider) {
            Intrinsics.checkNotNullParameter(oneTimeLoginCredentialsProvider, GeoContract.PROVIDER);
            this.f = oneTimeLoginCredentialsProvider;
            return this;
        }

        @NotNull
        public final Builder pushTokenProvider(@NotNull GcmPushTokenProvider gcmPushTokenProvider) {
            Intrinsics.checkNotNullParameter(gcmPushTokenProvider, GeoContract.PROVIDER);
            this.c = gcmPushTokenProvider;
            return this;
        }

        @NotNull
        public final Builder usernameProvider(@NotNull UsernameProvider usernameProvider) {
            Intrinsics.checkNotNullParameter(usernameProvider, GeoContract.PROVIDER);
            this.g = usernameProvider;
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/calls/voximplant/VoxCallClient$Command;", "", "", AuthSource.BOOKING_ORDER, "Z", "getClearOnSuccess", "()Z", "clearOnSuccess", "", AuthSource.SEND_ABUSE, "J", "getRetryCount", "()J", "retryCount", "<init>", "(Ljava/lang/String;IJZ)V", "DISCONNECT", "REGISTER", "UNREGISTER", "CONNECT_FOR_INCOMING_CALL", "CONNECT_FOR_OUTGOING_CALL", "calls_release"}, k = 1, mv = {1, 4, 2})
    public enum Command {
        DISCONNECT(0, false, 3),
        REGISTER(2, true),
        UNREGISTER(2, true),
        CONNECT_FOR_INCOMING_CALL(Long.MAX_VALUE, false, 2),
        CONNECT_FOR_OUTGOING_CALL(Long.MAX_VALUE, false, 2);
        
        public final long a;
        public final boolean b;

        /* access modifiers changed from: public */
        Command(long j, boolean z) {
            this.a = j;
            this.b = z;
        }

        public final boolean getClearOnSuccess() {
            return this.b;
        }

        public final long getRetryCount() {
            return this.a;
        }

        /* access modifiers changed from: public */
        Command(long j, boolean z, int i) {
            j = (i & 1) != 0 ? 0 : j;
            z = (i & 2) != 0 ? false : z;
            this.a = j;
            this.b = z;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;

        static {
            LoginError.values();
            int[] iArr = new int[9];
            $EnumSwitchMapping$0 = iArr;
            iArr[7] = 1;
            iArr[6] = 2;
            iArr[8] = 3;
            iArr[3] = 4;
            Command.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            Command command = Command.DISCONNECT;
            iArr2[0] = 1;
            Command command2 = Command.REGISTER;
            iArr2[1] = 2;
            Command command3 = Command.UNREGISTER;
            iArr2[2] = 3;
            Command command4 = Command.CONNECT_FOR_INCOMING_CALL;
            iArr2[3] = 4;
            Command command5 = Command.CONNECT_FOR_OUTGOING_CALL;
            iArr2[4] = 5;
            LoginError.values();
            int[] iArr3 = new int[9];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[6] = 1;
            iArr3[8] = 2;
            iArr3[3] = 3;
            iArr3[7] = 4;
            LogLevel.values();
            int[] iArr4 = new int[5];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[2] = 1;
            iArr4[3] = 2;
            iArr4[4] = 3;
            iArr4[0] = 4;
            iArr4[1] = 5;
            Command.values();
            int[] iArr5 = new int[5];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[1] = 1;
            iArr5[2] = 2;
            iArr5[3] = 3;
            iArr5[4] = 4;
            iArr5[0] = 5;
            Command.values();
            int[] iArr6 = new int[5];
            $EnumSwitchMapping$5 = iArr6;
            iArr6[2] = 1;
            iArr6[1] = 2;
            LoginError.values();
            int[] iArr7 = new int[9];
            $EnumSwitchMapping$6 = iArr7;
            iArr7[0] = 1;
            iArr7[1] = 2;
            iArr7[2] = 3;
            iArr7[3] = 4;
            iArr7[4] = 5;
            iArr7[6] = 6;
            iArr7[7] = 7;
            iArr7[8] = 8;
            iArr7[5] = 9;
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ VoxCallClient a;
        public final /* synthetic */ Map b;

        public a(VoxCallClient voxCallClient, Map map) {
            this.a = voxCallClient;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VoxCallClient.access$setCurrentCommand$p(this.a, Command.CONNECT_FOR_INCOMING_CALL);
            try {
                if (this.a.a(this.b)) {
                    ClientState clientState = this.a.i.getClientState();
                    boolean access$checkIfRegistrationRequired = VoxCallClient.access$checkIfRegistrationRequired(this.a);
                    if (clientState == ClientState.DISCONNECTED) {
                        this.a.i.connect();
                    } else if (access$checkIfRegistrationRequired && clientState == ClientState.LOGGED_IN) {
                        this.a.c();
                    }
                }
                if (this.b != null) {
                    this.a.i.handlePushNotification(this.b);
                }
            } catch (Exception e) {
                Logs.debug(LogTagsKt.TAG_VOX_CLIENT, "Connect failed", e);
                this.a.disconnect(true);
            }
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ VoxCallClient a;
        public final /* synthetic */ String b;

        public b(VoxCallClient voxCallClient, String str) {
            this.a = voxCallClient;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.b != null) {
                String username = this.a.getUsername();
                if (username == null) {
                    this.a.j.setUsername(this.b);
                } else if (!Intrinsics.areEqual(username, this.b)) {
                    VoxCallClient.access$clearSessionData(this.a);
                }
            }
            VoxCallClient.access$setCurrentCommand$p(this.a, Command.CONNECT_FOR_OUTGOING_CALL);
            try {
                if (this.a.a(null)) {
                    ClientState clientState = this.a.i.getClientState();
                    boolean access$checkIfRegistrationRequired = VoxCallClient.access$checkIfRegistrationRequired(this.a);
                    if (clientState == ClientState.DISCONNECTED) {
                        this.a.i.connect();
                    } else if (access$checkIfRegistrationRequired && clientState == ClientState.LOGGED_IN) {
                        this.a.c();
                    }
                }
            } catch (Exception e) {
                Logs.debug(LogTagsKt.TAG_VOX_CLIENT, "Connect failed", e);
                this.a.disconnect(true);
            }
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ VoxCallClient a;
        public final /* synthetic */ boolean b;

        public c(VoxCallClient voxCallClient, boolean z) {
            this.a = voxCallClient;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VoxCallClient.access$setCurrentCommand$p(this.a, Command.DISCONNECT);
            try {
                if (this.b) {
                    VoxCallClient.access$clearSessionData(this.a);
                }
                this.a.i.disconnect();
            } catch (Exception e) {
                Logs.debug(LogTagsKt.TAG_VOX_CLIENT, "Failure occurred during disconnect", e);
            }
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ VoxCallClient a;
        public final /* synthetic */ boolean b;

        public d(VoxCallClient voxCallClient, boolean z) {
            this.a = voxCallClient;
            this.b = z;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, a2.b.a.a.a.B(a2.b.a.a.a.L("Successfully reported push token registration status["), this.b, "] to backend"), null, 4, null);
            this.a.j.saveBackendNotified(this.b);
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ VoxCallClient a;
        public final /* synthetic */ boolean b;

        public e(VoxCallClient voxCallClient, boolean z) {
            this.a = voxCallClient;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            StringBuilder L = a2.b.a.a.a.L("Failed to report push token registration status[");
            L.append(this.b);
            L.append(']');
            Logs.debug(LogTagsKt.TAG_VOX_CLIENT, L.toString(), th);
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ VoxCallClient a;
        public final /* synthetic */ String b;

        public f(VoxCallClient voxCallClient, String str) {
            this.a = voxCallClient;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, a2.b.a.a.a.s(a2.b.a.a.a.L("register("), this.b, ')'), null, 4, null);
            this.a.j.setUserId(this.b);
            if (VoxCallClient.access$checkIfRegistrationRequired(this.a)) {
                if (this.a.d == Command.DISCONNECT || this.a.d == Command.UNREGISTER) {
                    VoxCallClient.access$setCurrentCommand$p(this.a, Command.REGISTER);
                    this.a.b.clear();
                }
                VoxCallClient.access$connectForPushRegistration(this.a);
            }
        }
    }

    public static final class g implements IClientIncomingCallListener {
        public final /* synthetic */ VoxCallClient a;
        public final /* synthetic */ IncomingCallListener b;

        public g(VoxCallClient voxCallClient, IncomingCallListener incomingCallListener) {
            this.a = voxCallClient;
            this.b = incomingCallListener;
        }

        @Override // com.voximplant.sdk.client.IClientIncomingCallListener
        public final void onIncomingCall(ICall iCall, boolean z, Map<String, String> map) {
            String str;
            String str2;
            try {
                IncomingCallListener incomingCallListener = this.b;
                Intrinsics.checkNotNullExpressionValue(iCall, "call");
                if (map == null || (str = map.get("X-UUID")) == null) {
                    String uuid = UUID.randomUUID().toString();
                    Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
                    if (uuid != null) {
                        str = uuid.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase()");
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                String str3 = map != null ? map.get("X-ItemId") : null;
                boolean parseBoolean = (map == null || (str2 = map.get("X-Early-Beeps")) == null) ? false : Boolean.parseBoolean(str2);
                CallExtras callExtras = new CallExtras(str3, "incoming_call");
                CallSettings callSettings = new CallSettings();
                callSettings.videoFlags = new VideoFlags(false, false);
                callSettings.extraHeaders = Collections.filterValuesNotNull(r.mutableMapOf(TuplesKt.to("X-UUID", str), TuplesKt.to("X-ItemId", callExtras.getItemId()), TuplesKt.to("X-Early-Beeps", String.valueOf(parseBoolean))));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("callUUID", str);
                jSONObject.put("itemID", callExtras.getItemId());
                jSONObject.put("scenario", callExtras.getScenario());
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().run {\n     …     toString()\n        }");
                callSettings.customData = jSONObject2;
                incomingCallListener.onIncomingCall(new VoxIncomingCall(str, str3, iCall, callSettings, z));
                Logs.debug(LogTagsKt.TAG_VOX_CLIENT, "Incoming call: " + iCall.getCallId() + " forwarded to listener", null);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to forward incoming call ");
                Intrinsics.checkNotNullExpressionValue(iCall, "call");
                sb.append(iCall.getCallId());
                sb.append(" to listener");
                Logs.debug(LogTagsKt.TAG_VOX_CLIENT, sb.toString(), e);
            }
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ VoxCallClient a;

        public h(VoxCallClient voxCallClient) {
            this.a = voxCallClient;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r4 = this;
                com.avito.android.calls.voximplant.VoxCallClient r0 = r4.a
                com.avito.android.calls.CredentialsStorage r0 = com.avito.android.calls.voximplant.VoxCallClient.access$getCredentialsStorage$p(r0)
                com.avito.android.calls.auth.PushTokenRegistration r0 = r0.getPushTokenRegistration()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "unregister: current status: "
                r1.append(r2)
                r1.append(r0)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "VoxCallClient"
                r3 = 0
                com.avito.android.util.Logs.debug(r2, r1, r3)
                boolean r1 = r0 instanceof com.avito.android.calls.auth.PushTokenRegistration.Registered
                if (r1 == 0) goto L_0x0032
                com.avito.android.calls.auth.PushTokenRegistration$PendingUnregister r1 = new com.avito.android.calls.auth.PushTokenRegistration$PendingUnregister
                com.avito.android.calls.auth.PushTokenRegistration$Registered r0 = (com.avito.android.calls.auth.PushTokenRegistration.Registered) r0
                java.lang.String r0 = r0.getToken()
                r1.<init>(r0)
            L_0x0030:
                r0 = r1
                goto L_0x004b
            L_0x0032:
                boolean r1 = r0 instanceof com.avito.android.calls.auth.PushTokenRegistration.PendingRegister
                if (r1 == 0) goto L_0x0042
                com.avito.android.calls.auth.PushTokenRegistration$PendingUnregister r1 = new com.avito.android.calls.auth.PushTokenRegistration$PendingUnregister
                com.avito.android.calls.auth.PushTokenRegistration$PendingRegister r0 = (com.avito.android.calls.auth.PushTokenRegistration.PendingRegister) r0
                java.lang.String r0 = r0.getToken()
                r1.<init>(r0)
                goto L_0x0030
            L_0x0042:
                boolean r1 = r0 instanceof com.avito.android.calls.auth.PushTokenRegistration.PendingUnregister
                if (r1 == 0) goto L_0x0047
                goto L_0x004b
            L_0x0047:
                boolean r1 = r0 instanceof com.avito.android.calls.auth.PushTokenRegistration.None
                if (r1 == 0) goto L_0x006e
            L_0x004b:
                com.avito.android.calls.voximplant.VoxCallClient r1 = r4.a
                com.avito.android.calls.CredentialsStorage r1 = com.avito.android.calls.voximplant.VoxCallClient.access$getCredentialsStorage$p(r1)
                r1.savePushTokenRegistration(r0)
                boolean r0 = r0 instanceof com.avito.android.calls.auth.PushTokenRegistration.PendingUnregister
                if (r0 == 0) goto L_0x006d
                com.avito.android.calls.voximplant.VoxCallClient r0 = r4.a
                com.avito.android.calls.voximplant.VoxCallClient$Command r1 = com.avito.android.calls.voximplant.VoxCallClient.Command.UNREGISTER
                com.avito.android.calls.voximplant.VoxCallClient.access$setCurrentCommand$p(r0, r1)
                com.avito.android.calls.voximplant.VoxCallClient r0 = r4.a
                io.reactivex.disposables.CompositeDisposable r0 = com.avito.android.calls.voximplant.VoxCallClient.access$getSubscriptions$p(r0)
                r0.clear()
                com.avito.android.calls.voximplant.VoxCallClient r0 = r4.a
                com.avito.android.calls.voximplant.VoxCallClient.access$connectForPushRegistration(r0)
            L_0x006d:
                return
            L_0x006e:
                kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.calls.voximplant.VoxCallClient.h.run():void");
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ VoxCallClient a;
        public final /* synthetic */ String b;

        public i(VoxCallClient voxCallClient, String str) {
            this.a = voxCallClient;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PushTokenRegistration pushTokenRegistration = this.a.j.getPushTokenRegistration();
            if (((pushTokenRegistration instanceof PushTokenRegistration.PendingRegister) || (pushTokenRegistration instanceof PushTokenRegistration.Registered)) && (!Intrinsics.areEqual(this.b, pushTokenRegistration.getToken())) && this.a.d != Command.UNREGISTER) {
                this.a.j.savePushTokenRegistration(new PushTokenRegistration.PendingRegister(this.b));
                VoxCallClient.access$connectForPushRegistration(this.a);
            }
        }
    }

    public VoxCallClient(Context context, IClient iClient, CredentialsStorage credentialsStorage, CallStorage callStorage, OneTimeLoginCredentialsProvider oneTimeLoginCredentialsProvider, UsernameProvider usernameProvider, PushTokenProvider pushTokenProvider, CallClientAvailabilityNotifier callClientAvailabilityNotifier, CallAnalyticsTracker callAnalyticsTracker, Features features, Executor executor, j jVar) {
        this.h = context;
        this.i = iClient;
        this.j = credentialsStorage;
        this.k = callStorage;
        this.l = oneTimeLoginCredentialsProvider;
        this.m = usernameProvider;
        this.n = pushTokenProvider;
        this.o = callClientAvailabilityNotifier;
        this.p = callAnalyticsTracker;
        this.q = features;
        this.r = executor;
        Scheduler from = Schedulers.from(executor);
        Intrinsics.checkNotNullExpressionValue(from, "Schedulers.from(executor)");
        this.a = from;
        VoxCallClient$sessionListener$1 voxCallClient$sessionListener$1 = new VoxCallClient$sessionListener$1(this);
        this.e = voxCallClient$sessionListener$1;
        VoxCallClient$loginListener$1 voxCallClient$loginListener$1 = new VoxCallClient$loginListener$1(this);
        this.f = voxCallClient$loginListener$1;
        Voximplant.setLogListener(a2.a.a.z.a.b.a);
        iClient.setClientLoginListener(voxCallClient$loginListener$1);
        iClient.setClientSessionListener(voxCallClient$sessionListener$1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x011c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean access$checkIfRegistrationRequired(com.avito.android.calls.voximplant.VoxCallClient r8) {
        /*
        // Method dump skipped, instructions count: 333
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.calls.voximplant.VoxCallClient.access$checkIfRegistrationRequired(com.avito.android.calls.voximplant.VoxCallClient):boolean");
    }

    public static final void access$clearSessionData(VoxCallClient voxCallClient) {
        Objects.requireNonNull(voxCallClient);
        Logs.debug(LogTagsKt.TAG_VOX_CLIENT, "Clear user session data", null);
        voxCallClient.j.clearAll();
        voxCallClient.k.setCallAvailabilityNotifiedState(CallAvailabilityNotifiedState.UNKNOWN);
    }

    public static final void access$connectForPushRegistration(VoxCallClient voxCallClient) {
        Objects.requireNonNull(voxCallClient);
        Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, "connectForPushRegistration()", null, 4, null);
        try {
            if (voxCallClient.a(null)) {
                ClientState clientState = voxCallClient.i.getClientState();
                if (clientState == ClientState.DISCONNECTED) {
                    voxCallClient.i.connect();
                } else if (clientState == ClientState.LOGGED_IN) {
                    voxCallClient.c();
                }
            }
        } catch (Exception e2) {
            Logs.debug(LogTagsKt.TAG_VOX_CLIENT, "Connect failed", e2);
            voxCallClient.disconnect(true);
        }
    }

    public static final String access$createCustomData(VoxCallClient voxCallClient, String str, CallExtras callExtras) {
        Objects.requireNonNull(voxCallClient);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("callUUID", str);
        jSONObject.put("itemID", callExtras.getItemId());
        jSONObject.put("scenario", callExtras.getScenario());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().run {\n     …     toString()\n        }");
        return jSONObject2;
    }

    public static final CallSettings access$createDefaultCallSettings(VoxCallClient voxCallClient, boolean z, String str, boolean z2, CallExtras callExtras) {
        Objects.requireNonNull(voxCallClient);
        CallSettings callSettings = new CallSettings();
        callSettings.videoFlags = new VideoFlags(z, z);
        callSettings.extraHeaders = Collections.filterValuesNotNull(r.mutableMapOf(TuplesKt.to("X-UUID", str), TuplesKt.to("X-ItemId", callExtras.getItemId()), TuplesKt.to("X-Early-Beeps", String.valueOf(z2))));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("callUUID", str);
        jSONObject.put("itemID", callExtras.getItemId());
        jSONObject.put("scenario", callExtras.getScenario());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().run {\n     …     toString()\n        }");
        callSettings.customData = jSONObject2;
        return callSettings;
    }

    public static final void access$logDebug(VoxCallClient voxCallClient, String str, Throwable th) {
        Objects.requireNonNull(voxCallClient);
        Logs.debug(LogTagsKt.TAG_VOX_CLIENT, str, th);
    }

    public static final void access$logVerbose(VoxCallClient voxCallClient, String str) {
        Objects.requireNonNull(voxCallClient);
        Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, str, null, 4, null);
    }

    public static final String access$nameForAnalytics(VoxCallClient voxCallClient, LoginError loginError) {
        Objects.requireNonNull(voxCallClient);
        switch (loginError.ordinal()) {
            case 0:
                return Preference.PASSWORD;
            case 1:
                return Preference.USERNAME;
            case 2:
                return "frozen";
            case 3:
                return "internal";
            case 4:
                return "state";
            case 5:
                return "limit";
            case 6:
                return "network";
            case 7:
                return AppleSignInManagerKt.EXTRA_APPLE_TOKEN;
            case 8:
                return "timeout";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final void access$performLogin(VoxCallClient voxCallClient) {
        Credentials credentials;
        Objects.requireNonNull(voxCallClient);
        try {
            credentials = voxCallClient.j.getCredentials();
        } catch (Exception e2) {
            Logs.error(LogTagsKt.TAG_VOX_CLIENT, "Failed to get credentials", e2);
            credentials = Credentials.None.INSTANCE;
        }
        if (Intrinsics.areEqual(credentials, Credentials.None.INSTANCE)) {
            Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, "No credentials => disconnecting", null, 4, null);
            voxCallClient.disconnect(true);
        } else if (credentials instanceof Credentials.Password) {
            Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, "Logging in with password...", null, 4, null);
            try {
                voxCallClient.i.login(((Credentials.Password) credentials).getName(), ((Credentials.Password) credentials).getPassword());
            } catch (Exception e3) {
                Logs.debug(LogTagsKt.TAG_VOX_CLIENT, "login with password failed", e3);
                voxCallClient.disconnect(true);
            }
        } else if (credentials instanceof Credentials.AccessToken) {
            Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, "Logging in with access token...", null, 4, null);
            Credentials.AccessToken accessToken = (Credentials.AccessToken) credentials;
            if (accessToken.getToken() != null) {
                try {
                    voxCallClient.i.loginWithAccessToken(((Credentials.AccessToken) credentials).getName(), ((Credentials.AccessToken) credentials).getToken());
                } catch (Exception e4) {
                    Logs.debug(LogTagsKt.TAG_VOX_CLIENT, "login with access token failed", e4);
                    voxCallClient.disconnect(true);
                }
            } else {
                voxCallClient.d(accessToken);
            }
        } else if (!(credentials instanceof Credentials.OneTimeKey)) {
        } else {
            if (voxCallClient.l != null) {
                try {
                    voxCallClient.i.requestOneTimeKey(((Credentials.OneTimeKey) credentials).getName());
                    Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, "One-time key requested", null, 4, null);
                } catch (Exception e5) {
                    Logs.debug(LogTagsKt.TAG_VOX_CLIENT, "login with one-time key failed", e5);
                    voxCallClient.disconnect(true);
                }
            } else {
                throw new IllegalArgumentException("OneTimeLoginCredentialsProvider is not set".toString());
            }
        }
    }

    public static final void access$requestOneTimeLoginKey(VoxCallClient voxCallClient, String str) {
        String username = voxCallClient.getUsername();
        if (username != null) {
            OneTimeLoginCredentialsProvider oneTimeLoginCredentialsProvider = voxCallClient.l;
            if (oneTimeLoginCredentialsProvider != null) {
                voxCallClient.b.clear();
                CompositeDisposable compositeDisposable = voxCallClient.b;
                Disposable subscribe = oneTimeLoginCredentialsProvider.getOneTimeLoginKey(str).subscribeOn(voxCallClient.a).observeOn(voxCallClient.a).subscribe(new a2.a.a.z.a.c(voxCallClient, username));
                Intrinsics.checkNotNullExpressionValue(subscribe, "provider.getOneTimeLogin…          )\n            }");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
                return;
            }
            throw new IllegalArgumentException("OneTimeLoginCredentialsProvider is not set".toString());
        }
        throw new IllegalArgumentException("Username must not be null".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [a2.a.a.z.a.f] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$scheduleWithDelay(com.avito.android.calls.voximplant.VoxCallClient r2, long r3, kotlin.jvm.functions.Function0 r5) {
        /*
            io.reactivex.disposables.CompositeDisposable r0 = r2.b
            r0.clear()
            io.reactivex.disposables.CompositeDisposable r0 = r2.b
            io.reactivex.Scheduler r2 = r2.a
            if (r5 == 0) goto L_0x0011
            a2.a.a.z.a.f r1 = new a2.a.a.z.a.f
            r1.<init>(r5)
            r5 = r1
        L_0x0011:
            java.lang.Runnable r5 = (java.lang.Runnable) r5
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS
            io.reactivex.disposables.Disposable r2 = r2.scheduleDirect(r5, r3, r1)
            java.lang.String r3 = "scheduler.scheduleDirect…econds, TimeUnit.SECONDS)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.calls.voximplant.VoxCallClient.access$scheduleWithDelay(com.avito.android.calls.voximplant.VoxCallClient, long, kotlin.jvm.functions.Function0):void");
    }

    public static final void access$setCurrentCommand$p(VoxCallClient voxCallClient, Command command) {
        Objects.requireNonNull(voxCallClient);
        Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, "currentCommand: " + voxCallClient.d + " -> " + command, null, 4, null);
        voxCallClient.d = command;
        voxCallClient.c = command.getRetryCount();
    }

    public static final IncomingCall access$toIncomingCall(VoxCallClient voxCallClient, ICall iCall, boolean z, Map map) {
        String str;
        String str2;
        Objects.requireNonNull(voxCallClient);
        if (map == null || (str = (String) map.get("X-UUID")) == null) {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
            Objects.requireNonNull(uuid, "null cannot be cast to non-null type java.lang.String");
            str = uuid.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase()");
        }
        String str3 = map != null ? (String) map.get("X-ItemId") : null;
        boolean parseBoolean = (map == null || (str2 = (String) map.get("X-Early-Beeps")) == null) ? false : Boolean.parseBoolean(str2);
        CallExtras callExtras = new CallExtras(str3, "incoming_call");
        CallSettings callSettings = new CallSettings();
        callSettings.videoFlags = new VideoFlags(false, false);
        callSettings.extraHeaders = Collections.filterValuesNotNull(r.mutableMapOf(TuplesKt.to("X-UUID", str), TuplesKt.to("X-ItemId", callExtras.getItemId()), TuplesKt.to("X-Early-Beeps", String.valueOf(parseBoolean))));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("callUUID", str);
        jSONObject.put("itemID", callExtras.getItemId());
        jSONObject.put("scenario", callExtras.getScenario());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().run {\n     …     toString()\n        }");
        callSettings.customData = jSONObject2;
        return new VoxIncomingCall(str, str3, iCall, callSettings, z);
    }

    public final boolean a(Map<String, String> map) {
        if (getUsername() != null) {
            return true;
        }
        ClientState clientState = this.i.getClientState();
        if (clientState == ClientState.LOGGED_IN || clientState == ClientState.LOGGING_IN) {
            disconnect(false);
        } else {
            Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, a2.b.a.a.a.g("Thread.currentThread()", a2.b.a.a.a.I('['), ']', new StringBuilder(), " Requesting username"), null, 4, null);
            this.b.clear();
            CompositeDisposable compositeDisposable = this.b;
            Disposable subscribe = InteropKt.toV2(this.m.getUsername()).subscribeOn(this.a).observeOn(this.a).subscribe(new a2.a.a.z.a.d(this, map), new a2.a.a.z.a.e(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "usernameProvider.getUser…t = false)\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
        return false;
    }

    public final void b(boolean z) {
        Completable completable;
        if (z) {
            completable = this.o.notifyAvailable(false);
        } else {
            completable = this.o.notifyUnavailable(false);
        }
        completable.subscribe(new d(this, z), new e(this, z));
    }

    public final void c() {
        Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, "performPendingRegistration()", null, 4, null);
        PushTokenRegistration pushTokenRegistration = this.j.getPushTokenRegistration();
        if (pushTokenRegistration instanceof PushTokenRegistration.PendingRegister) {
            Logs.debug(LogTagsKt.TAG_VOX_CLIENT, "Sending register push token request", null);
            this.p.trackTokenRegister();
            this.i.registerForPushNotifications(((PushTokenRegistration.PendingRegister) pushTokenRegistration).getToken(), new IPushTokenCompletionHandler(this, pushTokenRegistration) { // from class: com.avito.android.calls.voximplant.VoxCallClient$performPendingRegistration$1
                public final /* synthetic */ VoxCallClient a;
                public final /* synthetic */ PushTokenRegistration b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // com.voximplant.sdk.client.IPushTokenCompletionHandler
                public void onFailure(@Nullable PushTokenError pushTokenError) {
                    Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, "Failed to register push token in voximplant: " + pushTokenError, null, 4, null);
                    this.a.p.trackTokenRegistered(false);
                    this.a.b(false);
                    if (this.a.d == VoxCallClient.Command.REGISTER) {
                        this.a.disconnect(false);
                    }
                }

                @Override // com.voximplant.sdk.client.IPushTokenCompletionHandler
                public void onSuccess() {
                    Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, "Push token registered", null, 4, null);
                    this.a.p.trackTokenRegistered(true);
                    this.a.j.savePushTokenRegistration(new PushTokenRegistration.Registered(((PushTokenRegistration.PendingRegister) this.b).getToken(), false));
                    this.a.b(true);
                    if (this.a.d == VoxCallClient.Command.REGISTER) {
                        this.a.disconnect(false);
                    }
                }
            });
        } else if (pushTokenRegistration instanceof PushTokenRegistration.PendingUnregister) {
            Logs.debug(LogTagsKt.TAG_VOX_CLIENT, "Sending unregister push token request", null);
            this.p.trackTokenUnregister();
            this.i.unregisterFromPushNotifications(((PushTokenRegistration.PendingUnregister) pushTokenRegistration).getToken(), new IPushTokenCompletionHandler(this, pushTokenRegistration) { // from class: com.avito.android.calls.voximplant.VoxCallClient$performPendingRegistration$2
                public final /* synthetic */ VoxCallClient a;
                public final /* synthetic */ PushTokenRegistration b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // com.voximplant.sdk.client.IPushTokenCompletionHandler
                public void onFailure(@Nullable PushTokenError pushTokenError) {
                    Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, "Failed to unregister push token in voximplant: " + pushTokenError, null, 4, null);
                    this.a.p.trackTokenUnregistered(false);
                    this.a.b(false);
                    if (this.a.d != VoxCallClient.Command.REGISTER) {
                        this.a.disconnect(true);
                    }
                }

                @Override // com.voximplant.sdk.client.IPushTokenCompletionHandler
                public void onSuccess() {
                    Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, "Push token unregistered", null, 4, null);
                    this.a.p.trackTokenUnregistered(true);
                    this.a.b(false);
                    if (this.a.d != VoxCallClient.Command.REGISTER) {
                        this.a.j.savePushTokenRegistration(new PushTokenRegistration.None(((PushTokenRegistration.PendingUnregister) this.b).getToken()));
                        this.a.disconnect(true);
                    }
                }
            });
        } else {
            if (this.q.getCallsAvailabilityNotifiedState().invoke().booleanValue()) {
                if ((pushTokenRegistration instanceof PushTokenRegistration.Registered) && this.k.getCallAvailabilityNotifiedState() != CallAvailabilityNotifiedState.AVAILABLE) {
                    b(true);
                }
            } else if ((pushTokenRegistration instanceof PushTokenRegistration.Registered) && !((PushTokenRegistration.Registered) pushTokenRegistration).getBackendNotified()) {
                b(true);
            }
            int ordinal = this.d.ordinal();
            if (ordinal == 1) {
                disconnect(false);
            } else if (ordinal == 2) {
                disconnect(true);
            }
        }
    }

    @Override // com.avito.android.calls.AvitoCallClient
    public void connectForIncomingCall(@Nullable Map<String, String> map) {
        this.r.execute(new a(this, map));
    }

    @Override // com.avito.android.calls.AvitoCallClient
    public void connectForOutgoingCall(@Nullable String str) {
        Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, "connectForOutgoingCall()", null, 4, null);
        this.r.execute(new b(this, str));
    }

    public final void d(Credentials.AccessToken accessToken) {
        if (accessToken == null) {
            try {
                Credentials credentials = this.j.getCredentials();
                if (!(credentials instanceof Credentials.AccessToken)) {
                    credentials = null;
                }
                accessToken = (Credentials.AccessToken) credentials;
            } catch (Exception e2) {
                Logs.error(LogTagsKt.TAG_VOX_CLIENT, "Failed to get credentials", e2);
                accessToken = null;
            }
        }
        if (accessToken != null) {
            try {
                this.i.refreshToken(accessToken.getName(), accessToken.getRefreshToken());
                Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, "Refresh token requested", null, 4, null);
            } catch (Exception e3) {
                Logs.debug(LogTagsKt.TAG_VOX_CLIENT, "Refresh token threw unexpected exception", e3);
                disconnect(true);
            }
        } else {
            disconnect(true);
        }
    }

    @Override // com.avito.android.calls.AvitoCallClient
    public void disconnect() {
        disconnect(false);
    }

    @Override // com.avito.android.calls.AvitoCallClient
    @NotNull
    public List<String> getMissingPermissions(boolean z) {
        List<String> missingPermissions = Voximplant.getMissingPermissions(this.h, z);
        Intrinsics.checkNotNullExpressionValue(missingPermissions, "Voximplant.getMissingPer…ons(context, enableVideo)");
        return missingPermissions;
    }

    @Override // com.avito.android.calls.AvitoCallClient
    @Nullable
    public String getUsername() {
        return this.j.getUsername();
    }

    @Override // com.avito.android.calls.AvitoCallClient
    @Nullable
    public OutgoingCall makeCall(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @NotNull CallExtras callExtras) {
        Intrinsics.checkNotNullParameter(str, "callUuid");
        Intrinsics.checkNotNullParameter(str2, "targetId");
        Intrinsics.checkNotNullParameter(callExtras, AppLinkData.ARGUMENTS_EXTRAS_KEY);
        try {
            Logs.debug(LogTagsKt.TAG_VOX_CLIENT, "Make call, callUuid: [" + str + "], targetId: [" + str2 + ']', null);
            CallSettings callSettings = new CallSettings();
            callSettings.videoFlags = new VideoFlags(z, z);
            callSettings.extraHeaders = Collections.filterValuesNotNull(r.mutableMapOf(TuplesKt.to("X-UUID", str), TuplesKt.to("X-ItemId", callExtras.getItemId()), TuplesKt.to("X-Early-Beeps", String.valueOf(z2))));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("callUUID", str);
            jSONObject.put("itemID", callExtras.getItemId());
            jSONObject.put("scenario", callExtras.getScenario());
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().run {\n     …     toString()\n        }");
            callSettings.customData = jSONObject2;
            ICall call = this.i.call(str2, callSettings);
            if (call != null) {
                return new VoxOutgoingCall(str, callExtras.getItemId(), call, true);
            }
            return null;
        } catch (Exception e2) {
            Logs.debug(LogTagsKt.TAG_VOX_CLIENT, "Failure occurred during makeCall()", e2);
            return null;
        }
    }

    @Override // com.avito.android.calls.AvitoCallClient
    public void register(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        this.r.execute(new f(this, str));
    }

    @Override // com.avito.android.calls.AvitoCallClient
    public void setConnectionListener(@Nullable ConnectionListener connectionListener) {
        this.g = connectionListener;
    }

    @Override // com.avito.android.calls.AvitoCallClient
    public void setIncomingCallListener(@Nullable IncomingCallListener incomingCallListener) {
        if (incomingCallListener != null) {
            this.i.setClientIncomingCallListener(new g(this, incomingCallListener));
        } else {
            this.i.setClientIncomingCallListener(null);
        }
    }

    @Override // com.avito.android.calls.AvitoCallClient
    public boolean shouldStartFromPush(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        return map.containsKey("voximplant");
    }

    @Override // com.avito.android.calls.AvitoCallClient
    public void unregister() {
        this.r.execute(new h(this));
    }

    @Override // com.avito.android.calls.AvitoCallClient
    public void updatePushToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
        this.r.execute(new i(this, str));
    }

    public final void disconnect(boolean z) {
        this.r.execute(new c(this, z));
    }
}
