package com.avito.android.calls.voximplant;

import a2.t.a.a.b;
import a2.t.a.a.c;
import com.avito.android.calls.AvitoCallException;
import com.avito.android.calls.Call;
import com.avito.android.calls.quality.CallQualityIssue;
import com.avito.android.calls.quality.CallQualityIssueKt;
import com.avito.android.calls.quality.CallQualityIssueListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.voximplant.sdk.call.CallError;
import com.voximplant.sdk.call.CallException;
import com.voximplant.sdk.call.CallStats;
import com.voximplant.sdk.call.ICall;
import com.voximplant.sdk.call.ICallListener;
import com.voximplant.sdk.call.IEndpoint;
import com.voximplant.sdk.call.IEndpointListener;
import com.voximplant.sdk.call.IQualityIssueListener;
import com.voximplant.sdk.call.IVideoStream;
import com.voximplant.sdk.call.QualityIssueLevel;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001:\u0002+/B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\r\u0012\u0006\u00104\u001a\u000201¢\u0006\u0004\b5\u00106J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0004¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\"\u001a\u00020\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010(\u001a\u00020#8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\"\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020.0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010,R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/avito/android/calls/voximplant/VoxCall;", "Lcom/avito/android/calls/Call;", "Lcom/avito/android/calls/Call$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "addListener", "(Lcom/avito/android/calls/Call$Listener;)V", "removeListener", "Lcom/avito/android/calls/quality/CallQualityIssueListener;", "setQualityIssueListener", "(Lcom/avito/android/calls/quality/CallQualityIssueListener;)V", "hangup", "()V", "", "enable", "sendAudio", "(Z)V", "Lio/reactivex/Completable;", "sendVideo", "(Z)Lio/reactivex/Completable;", "Lcom/voximplant/sdk/call/CallException;", OkListener.KEY_EXCEPTION, "handleOrThrow", "(Lcom/voximplant/sdk/call/CallException;)V", "e", "Z", "getSupportVideo", "()Z", "supportVideo", "", "c", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "", "d", "J", "getDuration", "()J", "duration", "", "Lcom/voximplant/sdk/call/ICallListener;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "listeners", "Lcom/voximplant/sdk/call/IEndpoint;", AuthSource.BOOKING_ORDER, "endpoints", "Lcom/voximplant/sdk/call/ICall;", "f", "Lcom/voximplant/sdk/call/ICall;", "call", "<init>", "(ZLcom/voximplant/sdk/call/ICall;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
public abstract class VoxCall implements Call {
    public final Map<Call.Listener, ICallListener> a = new LinkedHashMap();
    public final Map<String, IEndpoint> b = new LinkedHashMap();
    @NotNull
    public final String c;
    public final long d;
    public final boolean e;
    public final ICall f;

    public final class a implements ICallListener {
        public final Call.Listener a;
        public final /* synthetic */ VoxCall b;

        public a(@NotNull VoxCall voxCall, Call.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "delegate");
            this.b = voxCall;
            this.a = listener;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // com.voximplant.sdk.call.ICallListener
        public void onCallAudioStarted(@Nullable ICall iCall) {
            Logs.debug$default("VoxCall", "onCallAudioStarted()", null, 4, null);
            this.a.onCallAudioStarted(this.b);
        }

        @Override // com.voximplant.sdk.call.ICallListener
        public void onCallConnected(@Nullable ICall iCall, @Nullable Map<String, String> map) {
            Logs.debug$default("VoxCall", "onCallConnected()", null, 4, null);
            this.a.onCallConnected(this.b);
        }

        @Override // com.voximplant.sdk.call.ICallListener
        public void onCallDisconnected(@Nullable ICall iCall, @Nullable Map<String, String> map, boolean z) {
            Logs.debug$default("VoxCall", "onCallDisconnected()", null, 4, null);
            this.a.onCallDisconnected(this.b, z, map != null ? map.containsKey("X-UserInitiated") : false);
        }

        @Override // com.voximplant.sdk.call.ICallListener
        public void onCallFailed(@Nullable ICall iCall, int i, @Nullable String str, @Nullable Map<String, String> map) {
            Logs.debug$default("VoxCall", "onCallFailed() " + i + " - " + str, null, 4, null);
            this.a.onCallFailed(this.b, CallErrorsKt.convertCallFailure(i, str));
        }

        @Override // com.voximplant.sdk.call.ICallListener
        public void onCallRinging(@Nullable ICall iCall, @Nullable Map<String, String> map) {
            Logs.debug$default("VoxCall", "onCallRinging()", null, 4, null);
            this.a.onCallRinging(this.b);
        }

        @Override // com.voximplant.sdk.call.ICallListener
        public void onCallStatsReceived(@Nullable ICall iCall, @Nullable CallStats callStats) {
            Logs.debug$default("VoxCall", "onCallAudioStarted(): " + callStats, null, 4, null);
        }

        @Override // com.voximplant.sdk.call.ICallListener
        public void onEndpointAdded(@Nullable ICall iCall, @Nullable IEndpoint iEndpoint) {
            if (iEndpoint != null) {
                VoxCall.access$addEndpoint(this.b, iEndpoint, this.a);
            }
        }

        @Override // com.voximplant.sdk.call.ICallListener
        public /* synthetic */ void onICECompleted(ICall iCall) {
            a2.t.a.a.a.$default$onICECompleted(this, iCall);
        }

        @Override // com.voximplant.sdk.call.ICallListener
        public /* synthetic */ void onICETimeout(ICall iCall) {
            a2.t.a.a.a.$default$onICETimeout(this, iCall);
        }

        @Override // com.voximplant.sdk.call.ICallListener
        public void onLocalVideoStreamAdded(@Nullable ICall iCall, @Nullable IVideoStream iVideoStream) {
            StringBuilder L = a2.b.a.a.a.L("onLocalVideoStreamAdded(): ");
            L.append(iVideoStream != null ? iVideoStream.getVideoStreamId() : null);
            Logs.debug$default("VoxCall", L.toString(), null, 4, null);
            if (iVideoStream != null) {
                this.a.onLocalVideoStreamAdded(this.b, new VoxCallVideoStream(iVideoStream));
            }
        }

        @Override // com.voximplant.sdk.call.ICallListener
        public void onLocalVideoStreamRemoved(@Nullable ICall iCall, @Nullable IVideoStream iVideoStream) {
            StringBuilder L = a2.b.a.a.a.L("onLocalVideoStreamRemoved(): ");
            L.append(iVideoStream != null ? iVideoStream.getVideoStreamId() : null);
            Logs.debug$default("VoxCall", L.toString(), null, 4, null);
            if (iVideoStream != null) {
                this.a.onLocalVideoStreamRemoved(this.b, new VoxCallVideoStream(iVideoStream));
            }
        }

        @Override // com.voximplant.sdk.call.ICallListener
        public /* synthetic */ void onMessageReceived(ICall iCall, String str) {
            a2.t.a.a.a.$default$onMessageReceived(this, iCall, str);
        }

        @Override // com.voximplant.sdk.call.ICallListener
        public void onSIPInfoReceived(@Nullable ICall iCall, @Nullable String str, @Nullable String str2, @Nullable Map<String, String> map) {
            StringBuilder W = a2.b.a.a.a.W("onSipInfoReceived(): type=", str, ", content=", str2, ", headers=");
            W.append(map);
            Logs.debug$default("VoxCall", W.toString(), null, 4, null);
            this.a.onSipInfoReceived(this.b, str, str2, map);
        }
    }

    public final class b implements IQualityIssueListener {
        public final CallQualityIssueListener a;
        public final /* synthetic */ VoxCall b;

        public b(@NotNull VoxCall voxCall, CallQualityIssueListener callQualityIssueListener) {
            Intrinsics.checkNotNullParameter(callQualityIssueListener, "delegate");
            this.b = voxCall;
            this.a = callQualityIssueListener;
        }

        @Override // com.voximplant.sdk.call.IQualityIssueListener
        public void onCodecMismatch(@Nullable ICall iCall, @Nullable QualityIssueLevel qualityIssueLevel, @Nullable String str) {
            this.a.onQualityIssue(this.b.getUuid(), CallQualityIssue.CodecMismatch.INSTANCE, CallQualityIssueKt.convertToInt(qualityIssueLevel));
        }

        @Override // com.voximplant.sdk.call.IQualityIssueListener
        public void onHighMediaLatency(@Nullable ICall iCall, @Nullable QualityIssueLevel qualityIssueLevel, double d) {
            this.a.onQualityIssue(this.b.getUuid(), CallQualityIssue.HighMediaLatency.INSTANCE, CallQualityIssueKt.convertToInt(qualityIssueLevel));
        }

        @Override // com.voximplant.sdk.call.IQualityIssueListener
        public void onIceDisconnected(@Nullable ICall iCall, @Nullable QualityIssueLevel qualityIssueLevel) {
            this.a.onQualityIssue(this.b.getUuid(), CallQualityIssue.IceDisconnected.INSTANCE, CallQualityIssueKt.convertToInt(qualityIssueLevel));
        }

        @Override // com.voximplant.sdk.call.IQualityIssueListener
        public /* synthetic */ void onLocalVideoDegradation(ICall iCall, QualityIssueLevel qualityIssueLevel, int i, int i2, int i3, int i4) {
            c.$default$onLocalVideoDegradation(this, iCall, qualityIssueLevel, i, i2, i3, i4);
        }

        @Override // com.voximplant.sdk.call.IQualityIssueListener
        public void onLowBandwidth(@Nullable ICall iCall, @NotNull QualityIssueLevel qualityIssueLevel, double d, double d2) {
            Intrinsics.checkNotNullParameter(qualityIssueLevel, FirebaseAnalytics.Param.LEVEL);
            this.a.onQualityIssue(this.b.getUuid(), CallQualityIssue.LowBandwidth.INSTANCE, qualityIssueLevel.ordinal());
        }

        @Override // com.voximplant.sdk.call.IQualityIssueListener
        public void onNoAudioSignal(@Nullable ICall iCall, @Nullable QualityIssueLevel qualityIssueLevel) {
            this.a.onQualityIssue(this.b.getUuid(), CallQualityIssue.NoAudioSignal.INSTANCE, CallQualityIssueKt.convertToInt(qualityIssueLevel));
        }

        @Override // com.voximplant.sdk.call.IQualityIssueListener
        public void onPacketLoss(@Nullable ICall iCall, @Nullable QualityIssueLevel qualityIssueLevel, double d) {
            this.a.onQualityIssue(this.b.getUuid(), CallQualityIssue.PacketLoss.INSTANCE, CallQualityIssueKt.convertToInt(qualityIssueLevel));
        }
    }

    public VoxCall(boolean z, @NotNull ICall iCall) {
        Intrinsics.checkNotNullParameter(iCall, "call");
        this.e = z;
        this.f = iCall;
        String callId = iCall.getCallId();
        Intrinsics.checkNotNullExpressionValue(callId, "call.callId");
        this.c = callId;
        this.d = iCall.getCallDuration();
    }

    public static final void access$addEndpoint(VoxCall voxCall, IEndpoint iEndpoint, Call.Listener listener) {
        Map<String, IEndpoint> map = voxCall.b;
        String endpointId = iEndpoint.getEndpointId();
        Intrinsics.checkNotNullExpressionValue(endpointId, "endpoint.endpointId");
        map.put(endpointId, iEndpoint);
        iEndpoint.setEndpointListener(new IEndpointListener(iEndpoint, listener) { // from class: com.avito.android.calls.voximplant.VoxCall$addEndpoint$1
            public final /* synthetic */ IEndpoint b;
            public final /* synthetic */ Call.Listener c;

            {
                this.b = r2;
                this.c = r3;
            }

            @Override // com.voximplant.sdk.call.IEndpointListener
            public /* synthetic */ void onEndpointInfoUpdated(IEndpoint iEndpoint2) {
                b.$default$onEndpointInfoUpdated(this, iEndpoint2);
            }

            @Override // com.voximplant.sdk.call.IEndpointListener
            public void onEndpointRemoved(@Nullable IEndpoint iEndpoint2) {
                this.b.setEndpointListener(null);
                VoxCall.access$getEndpoints$p(VoxCall.this).remove(this.b.getEndpointId());
                List<IVideoStream> videoStreams = this.b.getVideoStreams();
                Intrinsics.checkNotNullExpressionValue(videoStreams, "endpoint.videoStreams");
                for (T t : videoStreams) {
                    Call.Listener listener2 = this.c;
                    VoxCall voxCall2 = VoxCall.this;
                    String endpointId2 = this.b.getEndpointId();
                    Intrinsics.checkNotNullExpressionValue(endpointId2, "endpoint.endpointId");
                    Intrinsics.checkNotNullExpressionValue(t, "stream");
                    listener2.onRemoteVideoStreamRemoved(voxCall2, endpointId2, new VoxCallVideoStream(t));
                }
            }

            @Override // com.voximplant.sdk.call.IEndpointListener
            public void onRemoteVideoStreamAdded(@Nullable IEndpoint iEndpoint2, @Nullable IVideoStream iVideoStream) {
                if (iVideoStream != null) {
                    Call.Listener listener2 = this.c;
                    VoxCall voxCall2 = VoxCall.this;
                    String endpointId2 = this.b.getEndpointId();
                    Intrinsics.checkNotNullExpressionValue(endpointId2, "endpoint.endpointId");
                    listener2.onRemoteVideoStreamAdded(voxCall2, endpointId2, new VoxCallVideoStream(iVideoStream));
                }
            }

            @Override // com.voximplant.sdk.call.IEndpointListener
            public void onRemoteVideoStreamRemoved(@Nullable IEndpoint iEndpoint2, @Nullable IVideoStream iVideoStream) {
                if (iVideoStream != null) {
                    Call.Listener listener2 = this.c;
                    VoxCall voxCall2 = VoxCall.this;
                    String endpointId2 = this.b.getEndpointId();
                    Intrinsics.checkNotNullExpressionValue(endpointId2, "endpoint.endpointId");
                    listener2.onRemoteVideoStreamRemoved(voxCall2, endpointId2, new VoxCallVideoStream(iVideoStream));
                }
            }
        });
    }

    @Override // com.avito.android.calls.Call
    public void addListener(@NotNull Call.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        synchronized (this.a) {
            if (!this.a.containsKey(listener)) {
                a aVar = new a(this, listener);
                this.a.put(listener, aVar);
                this.f.addCallListener(aVar);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.calls.Call
    public long getDuration() {
        return this.d;
    }

    @Override // com.avito.android.calls.Call
    @NotNull
    public String getId() {
        return this.c;
    }

    @Override // com.avito.android.calls.Call
    public boolean getSupportVideo() {
        return this.e;
    }

    public final void handleOrThrow(@NotNull CallException callException) {
        Intrinsics.checkNotNullParameter(callException, OkListener.KEY_EXCEPTION);
        if (callException.getErrorCode() != CallError.ALREADY_IN_THIS_STATE) {
            CallError errorCode = callException.getErrorCode();
            Intrinsics.checkNotNullExpressionValue(errorCode, "exception.errorCode");
            throw new AvitoCallException(CallErrorsKt.convert(errorCode), callException.getMessage(), callException);
        }
    }

    @Override // com.avito.android.calls.Call
    public void hangup() {
        this.f.hangup(q.mapOf(TuplesKt.to("X-UserInitiated", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)));
    }

    @Override // com.avito.android.calls.Call
    public void removeListener(@NotNull Call.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ICallListener remove = this.a.remove(listener);
        if (remove != null) {
            this.f.removeCallListener(remove);
        }
    }

    @Override // com.avito.android.calls.Call
    public void sendAudio(boolean z) {
        this.f.sendAudio(z);
    }

    @Override // com.avito.android.calls.Call
    @NotNull
    public Completable sendVideo(boolean z) {
        Completable completable;
        if (getSupportVideo()) {
            Completable create = Completable.create(new CompletableOnSubscribe(this, z) { // from class: com.avito.android.calls.voximplant.VoxCall$sendVideo$1
                public final /* synthetic */ VoxCall a;
                public final /* synthetic */ boolean b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // io.reactivex.CompletableOnSubscribe
                public final void subscribe(@NotNull CompletableEmitter completableEmitter) {
                    Intrinsics.checkNotNullParameter(completableEmitter, "emitter");
                    try {
                        VoxCall.access$getCall$p(this.a).sendVideo(this.b, 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                              (wrap: com.voximplant.sdk.call.ICall : 0x000c: INVOKE  (r1v2 com.voximplant.sdk.call.ICall) = 
                              (wrap: com.avito.android.calls.voximplant.VoxCall : 0x000a: IGET  (r1v1 com.avito.android.calls.voximplant.VoxCall) = (r3v0 'this' com.avito.android.calls.voximplant.VoxCall$sendVideo$1 A[IMMUTABLE_TYPE, THIS]) com.avito.android.calls.voximplant.VoxCall$sendVideo$1.a com.avito.android.calls.voximplant.VoxCall)
                             type: STATIC call: com.avito.android.calls.voximplant.VoxCall.access$getCall$p(com.avito.android.calls.voximplant.VoxCall):com.voximplant.sdk.call.ICall)
                              (wrap: boolean : 0x0010: IGET  (r2v0 boolean) = (r3v0 'this' com.avito.android.calls.voximplant.VoxCall$sendVideo$1 A[IMMUTABLE_TYPE, THIS]) com.avito.android.calls.voximplant.VoxCall$sendVideo$1.b boolean)
                              (wrap: com.avito.android.calls.voximplant.VoxCall$sendVideo$1$callback$1 : 0x0007: CONSTRUCTOR  (r0v1 com.avito.android.calls.voximplant.VoxCall$sendVideo$1$callback$1) = (r4v0 'completableEmitter' io.reactivex.CompletableEmitter) call: com.avito.android.calls.voximplant.VoxCall$sendVideo$1$callback$1.<init>(io.reactivex.CompletableEmitter):void type: CONSTRUCTOR)
                             type: INTERFACE call: com.voximplant.sdk.call.ICall.sendVideo(boolean, com.voximplant.sdk.call.ICallCompletionHandler):void in method: com.avito.android.calls.voximplant.VoxCall$sendVideo$1.subscribe(io.reactivex.CompletableEmitter):void, file: classes2.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:316)
                            	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0007: CONSTRUCTOR  (r0v1 com.avito.android.calls.voximplant.VoxCall$sendVideo$1$callback$1) = (r4v0 'completableEmitter' io.reactivex.CompletableEmitter) call: com.avito.android.calls.voximplant.VoxCall$sendVideo$1$callback$1.<init>(io.reactivex.CompletableEmitter):void type: CONSTRUCTOR in method: com.avito.android.calls.voximplant.VoxCall$sendVideo$1.subscribe(io.reactivex.CompletableEmitter):void, file: classes2.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                            	... 21 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.avito.android.calls.voximplant.VoxCall$sendVideo$1$callback$1, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                            	... 27 more
                            */
                        /*
                            this = this;
                            java.lang.String r0 = "emitter"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                            com.avito.android.calls.voximplant.VoxCall$sendVideo$1$callback$1 r0 = new com.avito.android.calls.voximplant.VoxCall$sendVideo$1$callback$1
                            r0.<init>(r4)
                            com.avito.android.calls.voximplant.VoxCall r1 = r3.a     // Catch:{ Exception -> 0x0016 }
                            com.voximplant.sdk.call.ICall r1 = com.avito.android.calls.voximplant.VoxCall.access$getCall$p(r1)     // Catch:{ Exception -> 0x0016 }
                            boolean r2 = r3.b     // Catch:{ Exception -> 0x0016 }
                            r1.sendVideo(r2, r0)     // Catch:{ Exception -> 0x0016 }
                            goto L_0x0020
                        L_0x0016:
                            r0 = move-exception
                            boolean r1 = r4.isDisposed()
                            if (r1 != 0) goto L_0x0020
                            r4.onError(r0)
                        L_0x0020:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.calls.voximplant.VoxCall$sendVideo$1.subscribe(io.reactivex.CompletableEmitter):void");
                    }
                });
                Intrinsics.checkNotNullExpressionValue(create, "Completable.create { emi…          }\n            }");
                return create;
            }
            if (z) {
                completable = Completable.error(new IllegalStateException("Video is not supported in audio calls"));
            } else {
                completable = Completable.complete();
            }
            Intrinsics.checkNotNullExpressionValue(completable, "if (enable) {\n          ….complete()\n            }");
            return completable;
        }

        @Override // com.avito.android.calls.Call
        public void setQualityIssueListener(@Nullable CallQualityIssueListener callQualityIssueListener) {
            if (callQualityIssueListener != null) {
                this.f.setQualityIssueListener(new b(this, callQualityIssueListener));
            } else {
                this.f.setQualityIssueListener(null);
            }
        }
    }
