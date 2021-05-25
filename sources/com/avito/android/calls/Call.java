package com.avito.android.calls;

import com.avito.android.calls.quality.CallQualityIssueListener;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.Completable;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0002#$J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\u001f\u001a\u00020\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/calls/Call;", "", "", "hangup", "()V", "", "enable", "sendAudio", "(Z)V", "Lio/reactivex/Completable;", "sendVideo", "(Z)Lio/reactivex/Completable;", "Lcom/avito/android/calls/Call$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addListener", "(Lcom/avito/android/calls/Call$Listener;)V", "removeListener", "Lcom/avito/android/calls/quality/CallQualityIssueListener;", "setQualityIssueListener", "(Lcom/avito/android/calls/quality/CallQualityIssueListener;)V", "", "getId", "()Ljava/lang/String;", "id", "getItemId", "itemId", "getUuid", "uuid", "", "getDuration", "()J", "duration", "getSupportVideo", "()Z", "supportVideo", "Failure", "Listener", "calls_release"}, k = 1, mv = {1, 4, 2})
public interface Call {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/calls/Call$Failure;", "", "<init>", "()V", "Busy", "Other", "Rejected", "Terminated", "Timeout", "Unavailable", "Lcom/avito/android/calls/Call$Failure$Busy;", "Lcom/avito/android/calls/Call$Failure$Terminated;", "Lcom/avito/android/calls/Call$Failure$Unavailable;", "Lcom/avito/android/calls/Call$Failure$Timeout;", "Lcom/avito/android/calls/Call$Failure$Rejected;", "Lcom/avito/android/calls/Call$Failure$Other;", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Failure {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/Call$Failure$Busy;", "Lcom/avito/android/calls/Call$Failure;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Busy extends Failure {
            @NotNull
            public static final Busy INSTANCE = new Busy();

            public Busy() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/calls/Call$Failure$Other;", "Lcom/avito/android/calls/Call$Failure;", "", AuthSource.SEND_ABUSE, "I", "getCode", "()I", "code", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(ILjava/lang/String;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Other extends Failure {
            public final int a;
            @Nullable
            public final String b;

            public Other(int i, @Nullable String str) {
                super(null);
                this.a = i;
                this.b = str;
            }

            public final int getCode() {
                return this.a;
            }

            @Nullable
            public final String getMessage() {
                return this.b;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/Call$Failure$Rejected;", "Lcom/avito/android/calls/Call$Failure;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Rejected extends Failure {
            @NotNull
            public static final Rejected INSTANCE = new Rejected();

            public Rejected() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/Call$Failure$Terminated;", "Lcom/avito/android/calls/Call$Failure;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Terminated extends Failure {
            @NotNull
            public static final Terminated INSTANCE = new Terminated();

            public Terminated() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/Call$Failure$Timeout;", "Lcom/avito/android/calls/Call$Failure;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Timeout extends Failure {
            @NotNull
            public static final Timeout INSTANCE = new Timeout();

            public Timeout() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/Call$Failure$Unavailable;", "Lcom/avito/android/calls/Call$Failure;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class Unavailable extends Failure {
            @NotNull
            public static final Unavailable INSTANCE = new Unavailable();

            public Unavailable() {
                super(null);
            }
        }

        public Failure() {
        }

        public Failure(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006JC\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001d\u0010\u001cJ'\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001f\u0010 J'\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Lcom/avito/android/calls/Call$Listener;", "", "Lcom/avito/android/calls/Call;", "call", "", "onCallRinging", "(Lcom/avito/android/calls/Call;)V", "onCallConnected", "onCallAudioStarted", "", "type", "content", "", "headers", "onSipInfoReceived", "(Lcom/avito/android/calls/Call;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "", "answeredElsewhere", "userInitiated", "onCallDisconnected", "(Lcom/avito/android/calls/Call;ZZ)V", "Lcom/avito/android/calls/Call$Failure;", "reason", "onCallFailed", "(Lcom/avito/android/calls/Call;Lcom/avito/android/calls/Call$Failure;)V", "Lcom/avito/android/calls/CallVideoStream;", "stream", "onLocalVideoStreamAdded", "(Lcom/avito/android/calls/Call;Lcom/avito/android/calls/CallVideoStream;)V", "onLocalVideoStreamRemoved", "endpointId", "onRemoteVideoStreamAdded", "(Lcom/avito/android/calls/Call;Ljava/lang/String;Lcom/avito/android/calls/CallVideoStream;)V", "onRemoteVideoStreamRemoved", "calls_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onCallAudioStarted(@NotNull Call call);

        void onCallConnected(@NotNull Call call);

        void onCallDisconnected(@NotNull Call call, boolean z, boolean z2);

        void onCallFailed(@NotNull Call call, @NotNull Failure failure);

        void onCallRinging(@NotNull Call call);

        void onLocalVideoStreamAdded(@NotNull Call call, @NotNull CallVideoStream callVideoStream);

        void onLocalVideoStreamRemoved(@NotNull Call call, @NotNull CallVideoStream callVideoStream);

        void onRemoteVideoStreamAdded(@NotNull Call call, @NotNull String str, @NotNull CallVideoStream callVideoStream);

        void onRemoteVideoStreamRemoved(@NotNull Call call, @NotNull String str, @NotNull CallVideoStream callVideoStream);

        void onSipInfoReceived(@NotNull Call call, @Nullable String str, @Nullable String str2, @Nullable Map<String, String> map);
    }

    void addListener(@NotNull Listener listener);

    long getDuration();

    @NotNull
    String getId();

    @Nullable
    String getItemId();

    boolean getSupportVideo();

    @NotNull
    String getUuid();

    void hangup();

    void removeListener(@NotNull Listener listener);

    void sendAudio(boolean z);

    @NotNull
    Completable sendVideo(boolean z);

    void setQualityIssueListener(@Nullable CallQualityIssueListener callQualityIssueListener);
}
