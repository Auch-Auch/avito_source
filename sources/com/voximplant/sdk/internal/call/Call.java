package com.voximplant.sdk.internal.call;

import a2.b.a.a.a;
import a2.t.a.c.n0.a2;
import a2.t.a.c.n0.c2;
import a2.t.a.c.n0.e2;
import a2.t.a.c.n0.f2;
import a2.t.a.c.n0.g;
import a2.t.a.c.n0.h;
import a2.t.a.c.n0.h2;
import a2.t.a.c.n0.i;
import a2.t.a.c.n0.j;
import a2.t.a.c.n0.k;
import a2.t.a.c.n0.l;
import a2.t.a.c.n0.m;
import a2.t.a.c.n0.n;
import a2.t.a.c.n0.o;
import a2.t.a.c.n0.p;
import a2.t.a.c.n0.r1;
import a2.t.a.c.n0.z1;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.SparseArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.voximplant.sdk.call.CallError;
import com.voximplant.sdk.call.CallException;
import com.voximplant.sdk.call.CallSettings;
import com.voximplant.sdk.call.CallStats;
import com.voximplant.sdk.call.IAudioStream;
import com.voximplant.sdk.call.ICall;
import com.voximplant.sdk.call.ICallCompletionHandler;
import com.voximplant.sdk.call.ICallListener;
import com.voximplant.sdk.call.IEndpoint;
import com.voximplant.sdk.call.IQualityIssueListener;
import com.voximplant.sdk.call.IVideoStream;
import com.voximplant.sdk.call.QualityIssue;
import com.voximplant.sdk.call.QualityIssueLevel;
import com.voximplant.sdk.call.RejectMode;
import com.voximplant.sdk.call.VideoCodec;
import com.voximplant.sdk.call.VideoFlags;
import com.voximplant.sdk.call.VideoStreamType;
import com.voximplant.sdk.hardware.ICustomVideoSource;
import com.voximplant.sdk.internal.CallManager;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.SharedData;
import com.voximplant.sdk.internal.call.Call;
import com.voximplant.sdk.internal.call.CallIn;
import com.voximplant.sdk.internal.call.PCStream;
import com.voximplant.sdk.internal.callbacks.CallCallbackController;
import com.voximplant.sdk.internal.callbacks.OnCallAudioStarted;
import com.voximplant.sdk.internal.callbacks.OnCallConnected;
import com.voximplant.sdk.internal.callbacks.OnCallDisconnected;
import com.voximplant.sdk.internal.callbacks.OnCallFailed;
import com.voximplant.sdk.internal.callbacks.OnCallStatsReceived;
import com.voximplant.sdk.internal.callbacks.OnEndpointAdded;
import com.voximplant.sdk.internal.callbacks.OnIceCompleted;
import com.voximplant.sdk.internal.callbacks.OnIceDisconnected;
import com.voximplant.sdk.internal.callbacks.OnLocalVideoStreamAdded;
import com.voximplant.sdk.internal.callbacks.OnLocalVideoStreamRemoved;
import com.voximplant.sdk.internal.callbacks.OnRemoteVideoStreamAdded;
import com.voximplant.sdk.internal.callbacks.OnRemoteVideoStreamRemoved;
import com.voximplant.sdk.internal.callbacks.QualityCallbackController;
import com.voximplant.sdk.internal.hardware.CustomVideoSource;
import com.voximplant.sdk.internal.proto.M_ReInvite;
import com.voximplant.sdk.internal.proto.M_disconnectCall;
import com.voximplant.sdk.internal.proto.M_handleAcceptReinvite;
import com.voximplant.sdk.internal.proto.M_handleConnectionConnected;
import com.voximplant.sdk.internal.proto.M_handleRejectReinvite;
import com.voximplant.sdk.internal.proto.M_rejectCall;
import com.voximplant.sdk.internal.proto.M_sendSIPInfo;
import com.voximplant.sdk.internal.proto.M_startEarlyMedia;
import com.voximplant.sdk.internal.proto.Utils;
import com.voximplant.sdk.internal.proto.WSMessage;
import com.voximplant.sdk.internal.signaling.Signaling;
import com.voximplant.sdk.internal.utils.VoxImplantUtils;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.webrtc.DtmfSender;
import org.webrtc.IceCandidate;
import org.webrtc.MediaStreamTrack;
import org.webrtc.PeerConnection;
import org.webrtc.RtpReceiver;
import org.webrtc.RtpSender;
import org.webrtc.RtpTransceiver;
import org.webrtc.SessionDescription;
public class Call implements ICall, IPCStreamListener {
    public z1 A = z1.NOT_STARTED;
    public long B = 0;
    public long C = 0;
    public int D;
    public int E;
    public String a;
    public PCStream b;
    public CallSettings c;
    public CallCallbackController d;
    public ScheduledExecutorService e = Executors.newSingleThreadScheduledExecutor();
    public Signaling f = Signaling.getInstance();
    public boolean g;
    public c2 h;
    public SparseArray<String> i = new SparseArray<>();
    public LinkedList<a> j = new LinkedList<>();
    public a k = null;
    public PCAudioParameters l = new PCAudioParameters();
    public e2 m = new e2();
    public CallManager mCallManager;
    public boolean mIsServerCall = false;
    public final f2 mQualityIssueAnalyzer;
    public SessionDescription n = null;
    public SessionDescription o = null;
    public ScheduledFuture p = null;
    public CopyOnWriteArrayList<IceCandidate> q = new CopyOnWriteArrayList<>();
    public boolean r = false;
    public ScheduledFuture s = null;
    public boolean t = false;
    public PeerConnection.IceConnectionState u;
    public ScheduledFuture v = null;
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public ScheduledFuture z = null;

    public abstract class a {
        public Timer a = new Timer();
        public ICallCompletionHandler b;

        /* renamed from: com.voximplant.sdk.internal.call.Call$a$a  reason: collision with other inner class name */
        public class C0326a extends TimerTask {
            public C0326a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Call.this.e.execute(new g(this));
            }
        }

        public a(ICallCompletionHandler iCallCompletionHandler) {
            this.b = iCallCompletionHandler;
        }

        public void a() {
            MediaStreamTrack track;
            Timer timer = this.a;
            if (timer != null) {
                timer.cancel();
                this.a = null;
            }
            PCStream pCStream = Call.this.b;
            for (RtpTransceiver rtpTransceiver : pCStream.c.getTransceivers()) {
                Logger.i(pCStream.i() + "checkRemoteTracks: " + rtpTransceiver.getMid() + " direction: " + rtpTransceiver.getDirection() + ", currentDirection: " + rtpTransceiver.getCurrentDirection());
                RtpReceiver receiver = rtpTransceiver.getReceiver();
                if (!(receiver == null || (track = receiver.track()) == null)) {
                    if (rtpTransceiver.getMediaType() == MediaStreamTrack.MediaType.MEDIA_TYPE_AUDIO && (!pCStream.o.contains(track.id()) || pCStream.j(rtpTransceiver))) {
                        pCStream.o.remove(track.id());
                        pCStream.a.onAudioStreamRemoved("stream_remote", track.id());
                    }
                    if (rtpTransceiver.getMediaType() == MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO) {
                        if ((pCStream.p.contains(track.id()) || pCStream.q.containsKey(track.id())) && pCStream.j(rtpTransceiver)) {
                            pCStream.q.remove(track.id());
                            pCStream.p.remove(track.id());
                            pCStream.a.onRemoteVideoStreamRemoved(track.id());
                        }
                        if (pCStream.q.containsKey(track.id()) && pCStream.f.c && !pCStream.j(rtpTransceiver)) {
                            pCStream.p.add(track.id());
                            pCStream.a.onVideoStreamAdded("stream_remote", pCStream.q.remove(track.id()));
                        }
                    }
                }
            }
            Logger.i("Call action completed successfully");
            SharedData.getCallbackExecutor().execute(new h(this));
            Call.a(Call.this, this);
        }

        public abstract String b();

        public void c(CallError callError) {
            Timer timer = this.a;
            if (timer != null) {
                timer.cancel();
                this.a = null;
            }
            if (callError != CallError.ALREADY_IN_THIS_STATE) {
                f();
            }
            Logger.w("Call action failed: error: " + callError);
            SharedData.getCallbackExecutor().execute(new i(this, callError));
            Call.a(Call.this, this);
        }

        public abstract void d(WSMessage wSMessage);

        public abstract void e();

        public abstract void f();

        public abstract void g();

        public void h() {
            this.a.schedule(new C0326a(), 15000);
        }
    }

    public class b extends a {
        public SessionDescription d;

        public b(SessionDescription sessionDescription) {
            super(null);
            this.d = sessionDescription;
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public String b() {
            return "";
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void d(WSMessage wSMessage) {
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void e() {
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void f() {
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void g() {
            Call.this.e.execute(new j(this));
        }
    }

    public class c extends a {
        public boolean d;

        public class a implements ISdpCreateObserver {
            public a() {
            }

            @Override // com.voximplant.sdk.internal.call.ISdpCreateObserver
            public void onCreateFail(String str) {
                a2.b.a.a.a.P0(Call.this, new StringBuilder(), "CallActionHold: create local description failed");
                c.this.c(CallError.INTERNAL_ERROR);
            }

            @Override // com.voximplant.sdk.internal.call.ISdpCreateObserver
            public void onCreateSuccess(SessionDescription sessionDescription) {
                Logger.d(Call.this.b() + "CallActionHold: local description is created =");
                VoxImplantUtils.logLargeString(sessionDescription.description);
                Call call = Call.this;
                call.n = sessionDescription;
                call.f.sendMessage(new M_ReInvite(call.a, null, sessionDescription, call.e()));
            }
        }

        public class b implements ISdpSetObserver {
            public final /* synthetic */ WSMessage a;

            public class a implements ISdpSetObserver {
                public a() {
                }

                @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
                public void onSetFailure(String str) {
                    a2.b.a.a.a.P0(Call.this, new StringBuilder(), "CallActionHold: set remote description failed");
                    c.this.c(CallError.INTERNAL_ERROR);
                }

                @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
                public void onSetSuccess() {
                    Logger.d(Call.this.b() + "CallActionHold: remote description is set.");
                    c.this.a();
                }
            }

            public b(WSMessage wSMessage) {
                this.a = wSMessage;
            }

            @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
            public void onSetFailure(String str) {
                a2.b.a.a.a.P0(Call.this, new StringBuilder(), "CallActionHold: set local description failed");
                c.this.c(CallError.INTERNAL_ERROR);
            }

            @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
            public void onSetSuccess() {
                SessionDescription sdpAnswer = ((M_handleAcceptReinvite) this.a).sdpAnswer();
                Call.this.d(sdpAnswer.description);
                Call call = Call.this;
                call.b.setRemoteDescription(sdpAnswer, call instanceof CallIn, new a());
            }
        }

        public c(boolean z, ICallCompletionHandler iCallCompletionHandler) {
            super(iCallCompletionHandler);
            this.d = z;
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public String b() {
            StringBuilder L = a2.b.a.a.a.L("hold: ");
            L.append(this.d);
            return L.toString();
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void d(WSMessage wSMessage) {
            if (wSMessage instanceof M_handleAcceptReinvite) {
                Call call = Call.this;
                call.b.setLocalDescription(call.n, new b(wSMessage));
            }
            if (wSMessage instanceof M_handleRejectReinvite) {
                c(CallError.REJECTED);
            }
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void e() {
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void f() {
            Call call = Call.this;
            PCAudioParameters pCAudioParameters = call.l;
            e2 e2Var = call.m;
            call.h.d();
            call.b.b(!this.d, e2Var);
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void g() {
            if (Call.this.b.w == this.d) {
                Logger.w(Call.this.b() + this + " enable = " + this.d + ": failed to the call is already in this state");
                c(CallError.ALREADY_IN_THIS_STATE);
                return;
            }
            h();
            Call.this.mQualityIssueAnalyzer.c = this.d;
            Call call = Call.this;
            PCStream pCStream = call.b;
            boolean z = this.d;
            PCAudioParameters pCAudioParameters = call.l;
            e2 e2Var = call.m;
            call.h.d();
            pCStream.b(z, e2Var);
            Call.this.b.e(new a(), null, false);
        }
    }

    public class d extends a {
        public d() {
            super(null);
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public String b() {
            return "";
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void d(WSMessage wSMessage) {
            if (wSMessage instanceof M_handleAcceptReinvite) {
                Call.this.e.execute(new l(this, wSMessage));
            }
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void e() {
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void f() {
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void g() {
            Call.this.e.execute(new k(this));
        }
    }

    public class e extends a {
        public boolean d;

        public class a implements ISdpSetObserver {
            public final /* synthetic */ WSMessage a;

            /* renamed from: com.voximplant.sdk.internal.call.Call$e$a$a  reason: collision with other inner class name */
            public class C0327a implements ISdpSetObserver {
                public C0327a() {
                }

                @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
                public void onSetFailure(String str) {
                    a2.b.a.a.a.P0(Call.this, new StringBuilder(), "CallActionReceiveVideo: accept: set remote description failed");
                    e.this.c(CallError.INTERNAL_ERROR);
                }

                @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
                public void onSetSuccess() {
                    Logger.d(Call.this.b() + "CallActionReceiveVideo: accept: remote description is set");
                    e.this.a();
                }
            }

            public a(WSMessage wSMessage) {
                this.a = wSMessage;
            }

            @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
            public void onSetFailure(String str) {
                a2.b.a.a.a.P0(Call.this, new StringBuilder(), "CallActionReceiveVideo: accept: set local description failed");
                e.this.c(CallError.INTERNAL_ERROR);
            }

            @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
            public void onSetSuccess() {
                SessionDescription sdpAnswer = ((M_handleAcceptReinvite) this.a).sdpAnswer();
                a2.b.a.a.a.Q0(Call.this, new StringBuilder(), "CallActionReceiveVideo: accept: local description:");
                VoxImplantUtils.logLargeString(Call.this.n.description);
                Call.this.d(sdpAnswer.description);
                Call call = Call.this;
                call.b.setRemoteDescription(sdpAnswer, call instanceof CallIn, new C0327a());
            }
        }

        public e(ICallCompletionHandler iCallCompletionHandler) {
            super(iCallCompletionHandler);
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public String b() {
            return "";
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void d(WSMessage wSMessage) {
            if (wSMessage instanceof M_handleAcceptReinvite) {
                Call call = Call.this;
                call.b.setLocalDescription(call.n, new a(wSMessage));
            }
            if (wSMessage instanceof M_handleRejectReinvite) {
                c(CallError.REJECTED);
            }
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void e() {
            if (this.d) {
                this.d = false;
                Call.this.e.execute(new m(this));
            }
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void f() {
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void g() {
            Call.this.e.execute(new n(this));
        }
    }

    public Call(CallManager callManager, String str, CallSettings callSettings, boolean z2) {
        VideoCodec videoCodec;
        this.mCallManager = callManager;
        this.d = new CallCallbackController();
        this.a = str;
        this.h = new c2(str);
        CallSettings callSettings2 = new CallSettings();
        this.c = callSettings2;
        if (callSettings != null) {
            callSettings2.customData = callSettings.customData;
            callSettings2.preferredVideoCodec = callSettings.preferredVideoCodec;
            callSettings2.extraHeaders = callSettings.extraHeaders;
            callSettings2.videoFlags = callSettings.videoFlags;
        }
        this.g = z2;
        this.D = this.mCallManager.getStatsCollectionInterval() / 500;
        if (!this.mCallManager.isVideoSupportEnabled()) {
            e2 e2Var = this.m;
            e2Var.b = false;
            e2Var.c = false;
        } else {
            e2 e2Var2 = this.m;
            VideoFlags videoFlags = this.c.videoFlags;
            boolean z3 = true;
            e2Var2.b = videoFlags != null && videoFlags.sendVideo;
            e2Var2.c = (videoFlags == null || !videoFlags.receiveVideo) ? false : z3;
            VideoCodec preferredVideoCodecGlobal = this.mCallManager.getPreferredVideoCodecGlobal();
            VideoCodec videoCodec2 = VideoCodec.AUTO;
            if (preferredVideoCodecGlobal == videoCodec2 || (videoCodec = this.c.preferredVideoCodec) == videoCodec2 || preferredVideoCodecGlobal == videoCodec) {
                this.m.a(preferredVideoCodecGlobal);
                this.m.a(preferredVideoCodecGlobal);
            } else {
                this.m.a(videoCodec);
            }
            this.m.d = this.mCallManager.cameraMirroringEnabled();
        }
        c2 c2Var = this.h;
        Objects.requireNonNull(c2Var);
        a2 a2Var = new a2(str, 0);
        c2Var.b.add(a2Var);
        Logger.i(c2Var.a() + "createEndpoint: " + a2Var);
        List<PeerConnection.IceServer> iceServersForCall = this.mCallManager.getIceServersForCall(this.a);
        if (iceServersForCall == null) {
            if (this instanceof CallOut) {
                iceServersForCall = this.mCallManager.getStunServers();
            } else {
                iceServersForCall = this.mCallManager.getDefaultIceServers();
            }
        }
        PCStream pCStream = new PCStream(this.mCallManager.getPCFactoryWrapper(), iceServersForCall, this, this.a, this.e);
        this.b = pCStream;
        Context androidContext = this.mCallManager.getAndroidContext();
        Logger.v(pCStream.i() + "setAndroidContext");
        pCStream.v = androidContext;
        this.b.initPeerConnection(this.l, this.m);
        this.mQualityIssueAnalyzer = new f2(this.a, new QualityCallbackController(this), this.m.a);
        StringBuilder sb = new StringBuilder();
        a2.b.a.a.a.O0(this, sb, "created: video receive: ");
        sb.append(this.m.c);
        sb.append(", video send: ");
        sb.append(this.m.b);
        sb.append(" ,video support enabled = ");
        sb.append(this.mCallManager.isVideoSupportEnabled());
        sb.append(")");
        Logger.d(sb.toString());
    }

    public static void a(Call call, a aVar) {
        Logger.i(call.b() + "onCallActionComplete action: " + aVar + " " + aVar.b());
        if (aVar == call.k) {
            call.k = null;
            call.f();
        }
    }

    @Override // com.voximplant.sdk.call.ICall
    public void addCallListener(ICallListener iCallListener) {
        Logger.i(b() + "addCallListener:" + iCallListener);
        this.e.execute(new Runnable(iCallListener) { // from class: a2.t.a.c.n0.a
            public final /* synthetic */ ICallListener b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Call call = Call.this;
                call.d.addCallListener(this.b);
            }
        });
    }

    @Override // com.voximplant.sdk.call.ICall
    public void answer(CallSettings callSettings) throws CallException {
        Logger.i(b() + "answer");
        throw new CallException(CallError.INCORRECT_OPERATION, "Must override");
    }

    public String b() {
        StringBuilder L = a2.b.a.a.a.L("Call [");
        L.append(this.a);
        L.append(", ");
        L.append(this.A);
        L.append("]");
        return L.toString();
    }

    public void c() {
        this.f.sendMessage(new M_disconnectCall(this.a, null));
        this.mCallManager.removeCall(this.a);
        this.b.close();
        this.b = null;
        this.mCallManager.startAudioManager(false);
        this.d.addCallCallbackToQueue(new OnCallFailed(this, 500, "Internal error", new HashMap()));
    }

    public void d(String str) {
        String[] split = str.split("\r\n");
        int i2 = 0;
        for (String str2 : split) {
            if (str2.startsWith("a=mid:")) {
                this.i.put(i2, str2.substring(6));
                i2++;
            }
        }
    }

    public Map<String, Map<String, String>> e() {
        h2 h2Var;
        HashMap hashMap = new HashMap();
        PCStream pCStream = this.b;
        Objects.requireNonNull(pCStream);
        HashMap hashMap2 = new HashMap();
        PeerConnection peerConnection = pCStream.c;
        if (peerConnection == null) {
            a2.b.a.a.a.R0(pCStream, new StringBuilder(), "getLocalTracksInfo: peer connection is not valid");
        } else {
            for (RtpSender rtpSender : peerConnection.getSenders()) {
                MediaStreamTrack track = rtpSender.track();
                if (!(track == null || track.kind() == null)) {
                    if (!track.kind().equals("audio") || track.id().equals(pCStream.i.a)) {
                        if (track.kind().equals("video") && (h2Var = pCStream.j) != null) {
                            if (h2Var.i == VideoStreamType.SCREEN_SHARING && track.id().equals(pCStream.j.e)) {
                                hashMap2.put(track.id(), "sharing");
                            } else if (!pCStream.f.b || !track.id().equals(pCStream.j.e)) {
                                Logger.w(pCStream.i() + "getLocalTracksInfo: skip video sender: " + track.id());
                            }
                        }
                        hashMap2.put(track.id(), track.kind());
                    } else {
                        Logger.w(pCStream.i() + "getLocalTracksInfo: skip audio sender: " + track.id());
                    }
                }
            }
        }
        hashMap.put("tracks", hashMap2);
        Logger.i(b() + "prepareLocalTrackInfo: " + hashMap);
        return hashMap;
    }

    public void f() {
        PeerConnection.IceConnectionState iceConnectionState = this.u;
        boolean z2 = false;
        boolean z3 = iceConnectionState == PeerConnection.IceConnectionState.CONNECTED || iceConnectionState == PeerConnection.IceConnectionState.COMPLETED;
        boolean z4 = this.j.size() > 0 && (this.j.getFirst() instanceof d);
        if (this.y && this.j.size() > 0 && (this.j.getFirst() instanceof b)) {
            z2 = true;
        }
        if (!z2 && !z4 && (this.y || !z3)) {
            a2.b.a.a.a.Q0(this, new StringBuilder(), "runActionQueue: not able to start renegotiation until ice is connected");
        } else if (this.k == null) {
            a2.b.a.a.a.Q0(this, new StringBuilder(), "runActionQueue currentAction == null");
            a pollFirst = this.j.pollFirst();
            this.k = pollFirst;
            if (pollFirst != null) {
                StringBuilder sb = new StringBuilder();
                a2.b.a.a.a.O0(this, sb, "runActionQueue currentAction == ");
                sb.append(this.k);
                sb.append(" ");
                sb.append(this.k.b());
                Logger.i(sb.toString());
                this.k.g();
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            a2.b.a.a.a.O0(this, sb2, "runActionQueue action queue = ");
            sb2.append(this.j);
            sb2.append(" currentAction == ");
            sb2.append(this.k);
            Logger.i(sb2.toString());
        }
    }

    public void forceStop() {
        this.e.execute(new Runnable() { // from class: a2.t.a.c.n0.g0
            @Override // java.lang.Runnable
            public final void run() {
                Call.this.g(null, false, true);
            }
        });
    }

    public final void g(Map<String, String> map, boolean z2, boolean z3) {
        z1 z1Var = z1.CONNECTED;
        a2.b.a.a.a.Q0(this, new StringBuilder(), "stop");
        z1 z1Var2 = this.A;
        if (z1Var2 == z1.STARTED || z1Var2 == z1Var) {
            ScheduledFuture scheduledFuture = this.s;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
                this.s = null;
            }
            PeerConnection.IceConnectionState iceConnectionState = this.u;
            if (iceConnectionState == PeerConnection.IceConnectionState.CONNECTED || iceConnectionState == PeerConnection.IceConnectionState.COMPLETED) {
                this.b.h(this.h.b);
            }
        }
        ScheduledFuture scheduledFuture2 = this.p;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
            this.p = null;
        }
        ScheduledFuture scheduledFuture3 = this.v;
        if (scheduledFuture3 != null) {
            scheduledFuture3.cancel(true);
            this.v = null;
        }
        this.r = false;
        this.q.clear();
        this.b.close();
        this.b = null;
        c2 c2Var = this.h;
        Logger.i(c2Var.a() + "cleanup");
        Iterator<a2> it = c2Var.b.iterator();
        while (it.hasNext()) {
            it.next().b(false);
        }
        c2Var.b.clear();
        c2Var.c.clear();
        c2Var.d.clear();
        f2 f2Var = this.mQualityIssueAnalyzer;
        synchronized (f2Var) {
            Logger.i(f2Var.c() + "close");
            f2Var.k.clear();
            f2Var.l.clear();
            f2Var.d.clear();
            f2Var.d = null;
            f2Var.f.shutdown();
        }
        StringBuilder sb = new StringBuilder();
        a2.b.a.a.a.O0(this, sb, "stop: call state: ");
        sb.append(this.A);
        Logger.i(sb.toString());
        if (!z3 || this.A == z1Var) {
            this.d.addCallCallbackToQueue(new OnCallDisconnected(this, map, z2));
        } else {
            this.d.addCallCallbackToQueue(new OnCallFailed(this, 409, "Connection closed", Collections.emptyMap()));
        }
        this.mCallManager.removeCall(this.a);
        this.mCallManager.startAudioManager(false);
        this.A = z1.ENDED;
    }

    @Override // com.voximplant.sdk.call.ICall
    public long getCallDuration() {
        long j2 = this.C;
        if (j2 > 0) {
            return j2;
        }
        if (this.B > 0) {
            return System.currentTimeMillis() - this.B;
        }
        return 0;
    }

    @Override // com.voximplant.sdk.call.ICall
    public String getCallId() {
        return this.a;
    }

    @Override // com.voximplant.sdk.call.ICall
    public Map<QualityIssue, QualityIssueLevel> getCurrentQualityIssues() {
        return Collections.unmodifiableMap(this.mQualityIssueAnalyzer.g);
    }

    @Override // com.voximplant.sdk.call.ICall
    public List<IEndpoint> getEndpoints() {
        c2 c2Var = this.h;
        Objects.requireNonNull(c2Var);
        return new ArrayList(c2Var.b);
    }

    @Override // com.voximplant.sdk.call.ICall
    public List<IAudioStream> getLocalAudioStreams() {
        PCStream pCStream = this.b;
        if (pCStream == null) {
            return null;
        }
        Objects.requireNonNull(pCStream);
        ArrayList arrayList = new ArrayList();
        Iterator<r1> it = pCStream.g.iterator();
        while (it.hasNext()) {
            r1 next = it.next();
            if (next.c) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @Override // com.voximplant.sdk.call.ICall
    public List<IVideoStream> getLocalVideoStreams() {
        PCStream pCStream = this.b;
        if (pCStream == null) {
            return null;
        }
        Objects.requireNonNull(pCStream);
        ArrayList arrayList = new ArrayList();
        Iterator<h2> it = pCStream.h.iterator();
        while (it.hasNext()) {
            h2 next = it.next();
            if (next.k) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @Override // com.voximplant.sdk.call.ICall
    public void hangup(Map<String, String> map) {
        Logger.d(b() + "hangup headers = " + map);
        this.e.execute(new Runnable(map) { // from class: a2.t.a.c.n0.a0
            public final /* synthetic */ Map b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Call call = Call.this;
                Map map2 = this.b;
                call.j.clear();
                z1 z1Var = call.A;
                if (z1Var == z1.STARTED || z1Var == z1.CONNECTED) {
                    call.f.sendMessage(new M_disconnectCall(call.a, Utils.cleanHeaders(map2)));
                } else if (z1Var != z1.NOT_STARTED) {
                } else {
                    if (call instanceof CallIn) {
                        call.f.sendMessage(new M_rejectCall(call.a, false, Utils.cleanHeaders(map2)));
                    } else {
                        call.mCallManager.removeCall(call.a);
                    }
                }
            }
        });
    }

    @Override // com.voximplant.sdk.call.ICall
    public void hold(boolean z2, ICallCompletionHandler iCallCompletionHandler) {
        Logger.i(b() + "hold: enable = " + z2);
        if (this.A != z1.CONNECTED) {
            Logger.e(b() + "hold: failed due to call is not started or already ended");
            SharedData.getCallbackExecutor().execute(new Runnable() { // from class: a2.t.a.c.n0.f0
                @Override // java.lang.Runnable
                public final void run() {
                    ICallCompletionHandler iCallCompletionHandler2 = ICallCompletionHandler.this;
                    if (iCallCompletionHandler2 != null) {
                        iCallCompletionHandler2.onFailure(new CallException(CallError.INCORRECT_OPERATION, "Call is not started or already ended"));
                    }
                }
            });
            return;
        }
        this.e.execute(new Runnable(z2, iCallCompletionHandler) { // from class: a2.t.a.c.n0.d0
            public final /* synthetic */ boolean b;
            public final /* synthetic */ ICallCompletionHandler c;

            {
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Call call = Call.this;
                call.j.add(new Call.c(this.b, this.c));
                call.f();
            }
        });
    }

    @Override // com.voximplant.sdk.call.ICall
    public boolean isVideoEnabled() {
        e2 e2Var = this.m;
        return e2Var.b || e2Var.c;
    }

    @Override // com.voximplant.sdk.internal.call.IPCStreamListener
    public void onAudioStreamAdded(String str, r1 r1Var) {
        if (str.equals("stream_remote")) {
            Logger.d(b() + "onRemoteAudioStreamAdded: " + r1Var);
            c2 c2Var = this.h;
            if (r1Var == null) {
                Logger.e(c2Var.a() + "addAudioStreamToEndpoint: invalid audio stream");
                return;
            }
            a2 b2 = c2Var.b(c2Var.a, false);
            if (b2 == null) {
                b2 = c2Var.c(r1Var.a, false);
            }
            if (b2 != null) {
                b2.g.put(r1Var.a, r1Var);
                Logger.i(c2Var.a() + "addAudioStreamToEndpoint: " + r1Var + " successfully added");
                return;
            }
            Logger.e(c2Var.a() + "addAudioStreamToEndpoint: " + r1Var + " failed to add, endpoint not found");
        }
    }

    @Override // com.voximplant.sdk.internal.call.IPCStreamListener
    public void onAudioStreamRemoved(String str, String str2) {
        if (str.equals("stream_remote")) {
            Logger.d(b() + "onRemoteAudioStreamRemoved: " + str2);
            c2 c2Var = this.h;
            if (str2 == null) {
                Logger.e(c2Var.a() + "removeAudioStreamFromEndpoint: invalid audio stream");
                return;
            }
            a2 b2 = c2Var.b(c2Var.a, false);
            if (b2 == null) {
                b2 = c2Var.c(str2, false);
            }
            if (b2 != null) {
                b2.g.remove(str2);
                Logger.i(c2Var.a() + "removeAudioStreamFromEndpoint: " + str2 + " successfully removed");
                return;
            }
            Logger.e(c2Var.a() + "removeAudioStreamFromEndpoint: " + str2 + " failed to remove, endpoint not found");
        }
    }

    @Override // com.voximplant.sdk.internal.call.IPCStreamListener
    public void onCallStatisticsReady(CallStats callStats) {
        int i2 = this.E + 1;
        this.E = i2;
        if (i2 % 2 == 0) {
            VoxImplantUtils.logLargeString(b() + "onCallStatisticsReady: " + callStats.toString());
        }
        int i3 = this.D;
        if (i3 != 0 && this.E % i3 == 0) {
            this.d.addCallCallbackToQueue(new OnCallStatsReceived(this, callStats));
        }
        f2 f2Var = this.mQualityIssueAnalyzer;
        if (f2Var != null) {
            f2Var.f.execute(new Runnable(callStats) { // from class: a2.t.a.c.n0.l1
                public final /* synthetic */ CallStats b;

                {
                    this.b = r2;
                }

                /* JADX WARNING: Removed duplicated region for block: B:85:0x01d4  */
                @Override // java.lang.Runnable
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    // Method dump skipped, instructions count: 1295
                    */
                    throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.n0.l1.run():void");
                }
            });
        }
    }

    @Override // com.voximplant.sdk.internal.call.IPCStreamListener
    public void onIceCandidate(IceCandidate iceCandidate) {
        a2.b.a.a.a.Q0(this, new StringBuilder(), "onIceCandidate");
        CopyOnWriteArrayList<IceCandidate> copyOnWriteArrayList = this.q;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(iceCandidate);
        }
    }

    @Override // com.voximplant.sdk.internal.call.IPCStreamListener
    public void onIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
        this.u = iceConnectionState;
        if (iceConnectionState == PeerConnection.IceConnectionState.CONNECTED) {
            a2.b.a.a.a.Q0(this, new StringBuilder(), "onIceConnectionChange: CONNECTED");
            ScheduledFuture scheduledFuture = this.v;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
                this.v = null;
            }
            if (!this.w && !this.x) {
                this.e.execute(new Runnable() { // from class: a2.t.a.c.n0.p1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Call.this.f();
                    }
                });
                this.x = true;
                this.d.addCallCallbackToQueue(new OnIceCompleted(this));
            }
            if (this.s == null) {
                this.s = this.e.scheduleAtFixedRate(new Runnable() { // from class: a2.t.a.c.n0.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Call call = Call.this;
                        call.b.h(call.h.b);
                    }
                }, 0, 500, TimeUnit.MILLISECONDS);
            }
        }
        if (iceConnectionState == PeerConnection.IceConnectionState.DISCONNECTED || iceConnectionState == PeerConnection.IceConnectionState.CLOSED) {
            Logger.i(b() + "onIceConnectionChange: " + iceConnectionState);
            ScheduledFuture scheduledFuture2 = this.s;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(true);
                this.s = null;
            }
        }
        if (this.A == z1.CONNECTED) {
            f2 f2Var = this.mQualityIssueAnalyzer;
            f2Var.f.execute(new Runnable(iceConnectionState) { // from class: a2.t.a.c.n0.k1
                public final /* synthetic */ PeerConnection.IceConnectionState b;

                {
                    this.b = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    QualityIssue qualityIssue;
                    QualityIssueLevel qualityIssueLevel;
                    f2 f2Var2 = f2.this;
                    PeerConnection.IceConnectionState iceConnectionState2 = this.b;
                    Objects.requireNonNull(f2Var2);
                    if (iceConnectionState2 == PeerConnection.IceConnectionState.DISCONNECTED && f2Var2.g.get((qualityIssue = QualityIssue.ICE_DISCONNECTED)) != (qualityIssueLevel = QualityIssueLevel.CRITICAL)) {
                        f2Var2.g.put(qualityIssue, qualityIssueLevel);
                        f2Var2.e.invokeQualityIssueEvent(new OnIceDisconnected(qualityIssueLevel));
                    } else if (iceConnectionState2 == PeerConnection.IceConnectionState.CONNECTED || iceConnectionState2 == PeerConnection.IceConnectionState.COMPLETED) {
                        ConcurrentHashMap<QualityIssue, QualityIssueLevel> concurrentHashMap = f2Var2.g;
                        QualityIssue qualityIssue2 = QualityIssue.ICE_DISCONNECTED;
                        if (concurrentHashMap.get(qualityIssue2) == QualityIssueLevel.CRITICAL) {
                            ConcurrentHashMap<QualityIssue, QualityIssueLevel> concurrentHashMap2 = f2Var2.g;
                            QualityIssueLevel qualityIssueLevel2 = QualityIssueLevel.NONE;
                            concurrentHashMap2.put(qualityIssue2, qualityIssueLevel2);
                            f2Var2.e.invokeQualityIssueEvent(new OnIceDisconnected(qualityIssueLevel2));
                        }
                    }
                }
            });
        }
    }

    @Override // com.voximplant.sdk.internal.call.IPCStreamListener
    public void onIceGatheringChange(PeerConnection.IceGatheringState iceGatheringState) {
        if (iceGatheringState == PeerConnection.IceGatheringState.GATHERING && this.p == null) {
            this.p = this.e.scheduleAtFixedRate(new Runnable() { // from class: a2.t.a.c.n0.c
                @Override // java.lang.Runnable
                public final void run() {
                    Call call = Call.this;
                    if (!call.q.isEmpty() && call.r) {
                        call.f.sendMessage(new M_sendSIPInfo(call.a, call.q));
                        call.q.clear();
                    }
                }
            }, 0, 100, TimeUnit.MILLISECONDS);
        }
        if (iceGatheringState == PeerConnection.IceGatheringState.COMPLETE) {
            this.e.schedule(new Runnable() { // from class: a2.t.a.c.n0.w
                @Override // java.lang.Runnable
                public final void run() {
                    Call call = Call.this;
                    a.Q0(call, new StringBuilder(), "Cancel ice collection future");
                    ScheduledFuture scheduledFuture = call.p;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(true);
                        call.p = null;
                    }
                }
            }, 200, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.voximplant.sdk.internal.call.IPCStreamListener
    public void onLocalVideoStreamRemoved(h2 h2Var) {
        Logger.d(b() + "onLocalVideoStreamRemoved: " + h2Var);
        this.d.addCallCallbackToQueue(new OnLocalVideoStreamRemoved(this, h2Var));
    }

    public void onMessage(WSMessage wSMessage) {
        this.e.execute(new Runnable(wSMessage) { // from class: a2.t.a.c.n0.y
            public final /* synthetic */ WSMessage b;

            {
                this.b = r2;
            }

            /* JADX WARNING: Removed duplicated region for block: B:140:0x0142 A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:146:0x0066 A[SYNTHETIC] */
            @Override // java.lang.Runnable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 1431
                */
                throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.n0.y.run():void");
            }
        });
    }

    @Override // com.voximplant.sdk.internal.call.IPCStreamListener
    public void onRemoteVideoStreamRemoved(String str) {
        h2 remove;
        Logger.d(b() + "onRemoteVideoStreamRemoved: " + str);
        c2 c2Var = this.h;
        if (str == null) {
            Logger.e(c2Var.a() + "removeVideoStreamFromEndpoint: invalid video stream");
            return;
        }
        Logger.i(c2Var.a() + "removeVideoStreamFromEndpoint: " + str);
        a2 b2 = c2Var.b(c2Var.a, false);
        if (b2 == null) {
            b2 = c2Var.c(str, true);
        }
        if (b2 != null) {
            Logger.i(b2.a() + "removeVideoStream: " + str);
            if (b2.f.containsKey(str) && (remove = b2.f.remove(str)) != null) {
                b2.e.addEndpointCallbackToQueue(new OnRemoteVideoStreamRemoved(b2, remove));
            }
            Logger.i(c2Var.a() + "removeVideoStreamFromEndpoint: " + str + " successfully removed");
            return;
        }
        Logger.w(c2Var.a() + "removeVideoStreamFromEndpoint: " + str + " failed to remove, stream and endpoint are already removed");
    }

    @Override // com.voximplant.sdk.internal.call.IPCStreamListener
    public void onRenegotiationNeeded() {
        if (this.k != null) {
            a2.b.a.a.a.Q0(this, new StringBuilder(), "onRenegotiationNeeded");
            this.k.e();
        }
    }

    @Override // com.voximplant.sdk.internal.call.IPCStreamListener
    public void onVideoStreamAdded(String str, h2 h2Var) {
        if (str.equals("stream_local")) {
            Logger.d(b() + "onLocalVideoStreamAdded: " + h2Var);
            this.d.addCallCallbackToQueue(new OnLocalVideoStreamAdded(this, h2Var));
        }
        if (str.equals("stream_remote")) {
            Logger.d(b() + "onRemoteVideoStreamAdded: " + h2Var);
            if (this.A != z1.CONNECTED && (this instanceof CallOut) && !this.h.b.isEmpty()) {
                a2.b.a.a.a.Q0(this, new StringBuilder(), "onRemoteVideoStreamAdded: call is not connected yet, notify about endpoint");
                a2 b2 = this.h.b(this.a, false);
                if (b2 != null && !b2.d) {
                    b2.d = true;
                    this.d.addCallCallbackToQueue(new OnEndpointAdded(this, b2));
                }
            }
            c2 c2Var = this.h;
            if (h2Var == null) {
                Logger.e(c2Var.a() + "addVideoStreamToEndpoint: invalid video stream");
                return;
            }
            a2 b3 = c2Var.b(c2Var.a, false);
            if (b3 == null) {
                b3 = c2Var.c(h2Var.e, true);
            }
            if (b3 != null) {
                EndpointTracks endpointTracks = c2Var.d.get(b3.a);
                if (endpointTracks != null) {
                    h2Var.i = endpointTracks.d.contains(h2Var.e) ? VideoStreamType.SCREEN_SHARING : VideoStreamType.VIDEO;
                }
                Logger.i(b3.a() + "addVideoStream: " + h2Var);
                b3.f.put(h2Var.e, h2Var);
                b3.e.addEndpointCallbackToQueue(new OnRemoteVideoStreamAdded(b3, h2Var));
                Logger.i(c2Var.a() + "addVideoStreamToEndpoint: " + h2Var + " successfully added");
                return;
            }
            Logger.e(c2Var.a() + "addVideoStreamToEndpoint: " + h2Var + " failed to add, endpoint not found");
        }
    }

    @Override // com.voximplant.sdk.call.ICall
    public void receiveVideo(ICallCompletionHandler iCallCompletionHandler) {
        a2.b.a.a.a.Q0(this, new StringBuilder(), "receiveVideo");
        if (this.A != z1.CONNECTED) {
            Logger.e(b() + "receiveVideo: failed due to call is not started or already ended");
            SharedData.getCallbackExecutor().execute(new Runnable() { // from class: a2.t.a.c.n0.e0
                @Override // java.lang.Runnable
                public final void run() {
                    ICallCompletionHandler iCallCompletionHandler2 = ICallCompletionHandler.this;
                    if (iCallCompletionHandler2 != null) {
                        iCallCompletionHandler2.onFailure(new CallException(CallError.INCORRECT_OPERATION, "Call is not started or already ended"));
                    }
                }
            });
            return;
        }
        this.e.execute(new Runnable(iCallCompletionHandler) { // from class: a2.t.a.c.n0.i0
            public final /* synthetic */ ICallCompletionHandler b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Call call = Call.this;
                call.j.add(new Call.e(this.b));
                call.f();
            }
        });
    }

    @Override // com.voximplant.sdk.call.ICall
    public void reject(RejectMode rejectMode, Map<String, String> map) throws CallException {
        throw new CallException(CallError.INCORRECT_OPERATION, "Must Override");
    }

    @Override // com.voximplant.sdk.call.ICall
    public void removeCallListener(ICallListener iCallListener) {
        Logger.i(b() + "removeCallListener:" + iCallListener);
        this.e.execute(new Runnable(iCallListener) { // from class: a2.t.a.c.n0.f
            public final /* synthetic */ ICallListener b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Call call = Call.this;
                call.d.removeCallListener(this.b);
            }
        });
    }

    @Override // com.voximplant.sdk.call.ICall
    public void sendAudio(boolean z2) {
        Logger.i(b() + "sendAudio: enable = " + z2);
        this.e.execute(new Runnable(z2) { // from class: a2.t.a.c.n0.t
            public final /* synthetic */ boolean b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Call call = Call.this;
                boolean z3 = this.b;
                if (call.A == z1.ENDED) {
                    Logger.e("sendAudio: Failed due to the call is not connected");
                    return;
                }
                call.l.c = z3;
                PCStream pCStream = call.b;
                if (pCStream != null) {
                    Logger.i(pCStream.i() + "sendAudio enable: " + z3);
                    pCStream.e.c = z3;
                    Iterator<r1> it = pCStream.g.iterator();
                    while (it.hasNext()) {
                        it.next().b(z3);
                    }
                }
            }
        });
    }

    @Override // com.voximplant.sdk.call.ICall
    public void sendDTMF(String str) {
        Logger.i(b() + "sendDTMF tones: " + str);
        this.e.execute(new Runnable(str) { // from class: a2.t.a.c.n0.x
            public final /* synthetic */ String b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Call call = Call.this;
                String str2 = this.b;
                if (call.A != z1.CONNECTED) {
                    Logger.e("sendDTMF: Failed to send DTMF due to the call is not connected");
                    return;
                }
                PCStream pCStream = call.b;
                if (pCStream != null) {
                    Logger.i(pCStream.i() + "send DTMF: " + str2);
                    PeerConnection peerConnection = pCStream.c;
                    if (peerConnection == null) {
                        a.R0(pCStream, new StringBuilder(), "sendDTMF: peer connection is invalid");
                        return;
                    }
                    DtmfSender dtmfSender = null;
                    Iterator<RtpSender> it = peerConnection.getSenders().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            RtpSender next = it.next();
                            MediaStreamTrack track = next.track();
                            if (track != null && track.kind().equals("audio")) {
                                dtmfSender = next.dtmf();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (dtmfSender == null) {
                        a.R0(pCStream, new StringBuilder(), "sendDTMF: not available to send DTMF due to DTMF sender is not created");
                    } else if (!dtmfSender.canInsertDtmf()) {
                        a.R0(pCStream, new StringBuilder(), "sendDTMF: canInsertDtmf failed");
                    } else if (dtmfSender.insertDtmf(str2, 500, 50)) {
                        Logger.d(pCStream.i() + "sendDTMF: DTMF is inserted");
                    } else {
                        a.R0(pCStream, new StringBuilder(), "sendDTMF: DTMF is failed to be inserted");
                    }
                } else {
                    Logger.e(call.b() + "sendDTMF: failed to send DTMF " + str2);
                }
            }
        });
    }

    @Override // com.voximplant.sdk.call.ICall
    public void sendInfo(String str, String str2, Map<String, String> map) {
        a2.b.a.a.a.Q0(this, new StringBuilder(), "sendInfo");
        this.e.execute(new Runnable(str, str2, map) { // from class: a2.t.a.c.n0.q
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ Map d;

            {
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Call call = Call.this;
                String str3 = this.b;
                String str4 = this.c;
                Map map2 = this.d;
                z1 z1Var = call.A;
                if (z1Var == z1.NOT_STARTED || z1Var == z1.ENDED) {
                    a.P0(call, new StringBuilder(), "sendInfo: Failed to send info due to the call is not started or is already ended");
                    return;
                }
                int indexOf = str3.indexOf("/");
                call.f.sendMessage(new M_sendSIPInfo(call.a, str3.substring(0, indexOf), str3.substring(indexOf + 1), str4, Utils.cleanHeaders(map2)));
            }
        });
    }

    @Override // com.voximplant.sdk.call.ICall
    public void sendMessage(String str) {
        a2.b.a.a.a.Q0(this, new StringBuilder(), "sendMessage");
        this.e.execute(new Runnable(str) { // from class: a2.t.a.c.n0.v
            public final /* synthetic */ String b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Call call = Call.this;
                String str2 = this.b;
                z1 z1Var = call.A;
                if (z1Var == z1.NOT_STARTED || z1Var == z1.ENDED) {
                    a.P0(call, new StringBuilder(), "sendMessage: Failed to send info due to the call is not started or is already ended");
                } else {
                    call.f.sendMessage(new M_sendSIPInfo(call.a, MimeTypes.BASE_TYPE_APPLICATION, "zingaya-im", str2, null));
                }
            }
        });
    }

    @Override // com.voximplant.sdk.call.ICall
    public void sendVideo(boolean z2, ICallCompletionHandler iCallCompletionHandler) {
        Logger.i(b() + "sendVideo: enable = " + z2);
        if (this.A != z1.CONNECTED) {
            Logger.e(b() + "sendVideo: failed due to call is not started or already ended");
            SharedData.getCallbackExecutor().execute(new Runnable() { // from class: a2.t.a.c.n0.d
                @Override // java.lang.Runnable
                public final void run() {
                    ICallCompletionHandler iCallCompletionHandler2 = ICallCompletionHandler.this;
                    if (iCallCompletionHandler2 != null) {
                        iCallCompletionHandler2.onFailure(new CallException(CallError.INCORRECT_OPERATION, "Call is not started or already ended"));
                    }
                }
            });
        } else if (!this.mCallManager.isVideoSupportEnabled()) {
            Logger.e(b() + "sendVideo: " + z2 + " fail due to video functionality is disabled");
            SharedData.getCallbackExecutor().execute(new Runnable() { // from class: a2.t.a.c.n0.r
                @Override // java.lang.Runnable
                public final void run() {
                    ICallCompletionHandler iCallCompletionHandler2 = ICallCompletionHandler.this;
                    if (iCallCompletionHandler2 != null) {
                        iCallCompletionHandler2.onFailure(new CallException(CallError.FUNCTIONALITY_IS_DISABLED, "Video functionality is disabled"));
                    }
                }
            });
        } else {
            this.e.execute(new Runnable(z2, iCallCompletionHandler) { // from class: a2.t.a.c.n0.s
                public final /* synthetic */ boolean b;
                public final /* synthetic */ ICallCompletionHandler c;

                {
                    this.b = r2;
                    this.c = r3;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Call call = Call.this;
                    boolean z3 = this.b;
                    call.j.add(new Call.f(z3, z3 ? VideoStreamType.VIDEO : null, this.c));
                    call.f();
                }
            });
        }
    }

    @Override // com.voximplant.sdk.call.ICall
    public void setQualityIssueListener(IQualityIssueListener iQualityIssueListener) {
        this.e.execute(new Runnable(iQualityIssueListener) { // from class: a2.t.a.c.n0.b
            public final /* synthetic */ IQualityIssueListener b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Call call = Call.this;
                IQualityIssueListener iQualityIssueListener2 = this.b;
                QualityCallbackController qualityCallbackController = call.mQualityIssueAnalyzer.e;
                if (qualityCallbackController != null) {
                    qualityCallbackController.setQualityListener(iQualityIssueListener2);
                }
            }
        });
    }

    @Override // com.voximplant.sdk.call.ICall
    public void start() throws CallException {
        a2.b.a.a.a.Q0(this, new StringBuilder(), Tracker.Events.CREATIVE_START);
        z1 z1Var = this.A;
        if (z1Var == z1.STARTED || z1Var == z1.CONNECTED) {
            Logger.e(b() + "start: Throwing CallException: INCORRECT OPERATION - Call is already started");
            throw new CallException(CallError.INCORRECT_OPERATION, "Call is already started");
        } else if (this.mCallManager.getAndroidContext().checkPermission("android.permission.RECORD_AUDIO", Process.myPid(), Process.myUid()) != 0) {
            Logger.e(b() + "start: Throwing CallException: MISSING PERMISSION - RECORD_AUDIO permission is missing");
            throw new CallException(CallError.MISSING_PERMISSION, "RECORD_AUDIO permission is missing");
        } else if (!this.m.b || this.t || this.mCallManager.getAndroidContext().checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) == 0) {
            this.e.execute(new Runnable() { // from class: a2.t.a.c.n0.h0
                @Override // java.lang.Runnable
                public final void run() {
                    Call call = Call.this;
                    call.b.initPeerConnection(call.l, call.m);
                    call.mCallManager.startAudioManager(true);
                    call.A = z1.STARTED;
                }
            });
        } else {
            Logger.e(b() + "start: Throwing CallException: MISSING PERMISSION - CAMERA permission is missing");
            throw new CallException(CallError.MISSING_PERMISSION, "CAMERA permission is missing");
        }
    }

    @Override // com.voximplant.sdk.call.ICall
    public void startScreenSharing(Intent intent, ICallCompletionHandler iCallCompletionHandler) {
        a2.b.a.a.a.Q0(this, new StringBuilder(), "startScreenSharing");
        if (this.A != z1.CONNECTED) {
            Logger.e(b() + "startScreenSharing: failed due to the call is not started or already ended");
            SharedData.getCallbackExecutor().execute(new Runnable() { // from class: a2.t.a.c.n0.u
                @Override // java.lang.Runnable
                public final void run() {
                    ICallCompletionHandler iCallCompletionHandler2 = ICallCompletionHandler.this;
                    if (iCallCompletionHandler2 != null) {
                        iCallCompletionHandler2.onFailure(new CallException(CallError.INCORRECT_OPERATION, "Call is not started or already ended"));
                    }
                }
            });
        } else if (intent == null) {
            Logger.e(b() + "startScreenSharing: failed due to permissionResultData is null");
            SharedData.getCallbackExecutor().execute(new Runnable() { // from class: a2.t.a.c.n0.e
                @Override // java.lang.Runnable
                public final void run() {
                    ICallCompletionHandler iCallCompletionHandler2 = ICallCompletionHandler.this;
                    if (iCallCompletionHandler2 != null) {
                        iCallCompletionHandler2.onFailure(new CallException(CallError.MISSING_PERMISSION, "User has not granted the permission for screen sharing"));
                    }
                }
            });
        } else {
            this.e.execute(new Runnable(intent, iCallCompletionHandler) { // from class: a2.t.a.c.n0.z
                public final /* synthetic */ Intent b;
                public final /* synthetic */ ICallCompletionHandler c;

                {
                    this.b = r2;
                    this.c = r3;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Call call = Call.this;
                    call.j.add(new Call.f(true, this.b, this.c));
                    call.f();
                }
            });
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        a2.b.a.a.a.O0(this, sb, " (mCallId = ");
        sb.append(this.a);
        sb.append(", isVideoEnabled = ");
        sb.append(isVideoEnabled());
        sb.append(")");
        return sb.toString();
    }

    @Override // com.voximplant.sdk.call.ICall
    public void useCustomVideoSource(ICustomVideoSource iCustomVideoSource) {
        Logger.i(b() + "useCustomVideoSource: videoSource: " + iCustomVideoSource);
        this.e.execute(new Runnable(iCustomVideoSource) { // from class: a2.t.a.c.n0.c0
            public final /* synthetic */ ICustomVideoSource b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Call call = Call.this;
                ICustomVideoSource iCustomVideoSource2 = this.b;
                PCStream pCStream = call.b;
                Logger.i(pCStream.i() + "setCustomVideoSource: videoSource: " + iCustomVideoSource2);
                pCStream.d = (CustomVideoSource) iCustomVideoSource2;
                call.t = true;
            }
        });
    }

    public void onMessage(M_handleConnectionConnected m_handleConnectionConnected) {
        Logger.i(b() + "onMessage: " + m_handleConnectionConnected);
        this.A = z1.CONNECTED;
        this.B = System.currentTimeMillis();
        this.d.addCallCallbackToQueue(new OnCallAudioStarted(this));
        this.d.addCallCallbackToQueue(new OnCallConnected(this, m_handleConnectionConnected.headers()));
    }

    public class f extends a {
        public boolean d;
        public boolean e;
        public VideoStreamType f;
        public Intent g;

        public class a implements ISdpSetObserver {
            public final /* synthetic */ WSMessage a;

            /* renamed from: com.voximplant.sdk.internal.call.Call$f$a$a  reason: collision with other inner class name */
            public class C0328a implements ISdpSetObserver {
                public C0328a() {
                }

                @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
                public void onSetFailure(String str) {
                    a2.b.a.a.a.P0(Call.this, new StringBuilder(), "CallActionSendVideo: accept: set remote description failed");
                    f.this.c(CallError.INTERNAL_ERROR);
                }

                @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
                public void onSetSuccess() {
                    Logger.d(Call.this.b() + "CallActionSendVideo: accept: remote description is set");
                    f.this.a();
                }
            }

            public a(WSMessage wSMessage) {
                this.a = wSMessage;
            }

            @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
            public void onSetFailure(String str) {
                Logger.e(Call.this.b() + "CallActionSendVideo: accept: set local description failed: " + str);
                VoxImplantUtils.logLargeString(Call.this.n.description);
                f.this.c(CallError.INTERNAL_ERROR);
            }

            @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
            public void onSetSuccess() {
                SessionDescription sdpAnswer = ((M_handleAcceptReinvite) this.a).sdpAnswer();
                Call.this.d(sdpAnswer.description);
                Call call = Call.this;
                call.b.setRemoteDescription(sdpAnswer, call instanceof CallIn, new C0328a());
            }
        }

        public f(boolean z, VideoStreamType videoStreamType, ICallCompletionHandler iCallCompletionHandler) {
            super(iCallCompletionHandler);
            this.f = null;
            this.d = z;
            this.f = videoStreamType;
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public String b() {
            StringBuilder L = a2.b.a.a.a.L("send video: ");
            L.append(this.d);
            return L.toString();
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void d(WSMessage wSMessage) {
            if (wSMessage instanceof M_handleAcceptReinvite) {
                Call call = Call.this;
                call.b.setLocalDescription(call.n, new a(wSMessage));
            }
            if (wSMessage instanceof M_handleRejectReinvite) {
                c(CallError.REJECTED);
            }
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void e() {
            if (this.e) {
                this.e = false;
                Call.this.e.execute(new o(this));
            }
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void f() {
        }

        @Override // com.voximplant.sdk.internal.call.Call.a
        public void g() {
            Call.this.e.execute(new p(this));
        }

        public f(boolean z, Intent intent, ICallCompletionHandler iCallCompletionHandler) {
            super(iCallCompletionHandler);
            this.f = null;
            this.f = VideoStreamType.SCREEN_SHARING;
            this.d = z;
            this.g = intent;
        }
    }

    public void onMessage(M_startEarlyMedia m_startEarlyMedia) {
        Logger.i(b() + "onMessage: " + m_startEarlyMedia);
    }
}
