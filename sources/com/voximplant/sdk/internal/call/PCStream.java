package com.voximplant.sdk.internal.call;

import a2.b.a.a.a;
import a2.t.a.c.n0.a2;
import a2.t.a.c.n0.d2;
import a2.t.a.c.n0.e2;
import a2.t.a.c.n0.g2;
import a2.t.a.c.n0.h2;
import a2.t.a.c.n0.p0;
import a2.t.a.c.n0.r0;
import a2.t.a.c.n0.r1;
import a2.t.a.c.n0.s0;
import a2.t.a.c.n0.u0;
import a2.t.a.c.n0.v0;
import a2.t.a.c.n0.w0;
import a2.t.a.c.n0.y0;
import a2.t.a.c.n0.z0;
import android.content.Context;
import com.facebook.internal.ServerProtocol;
import com.voximplant.sdk.call.VideoCodec;
import com.voximplant.sdk.call.VideoStreamType;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.call.IPCStreamListener;
import com.voximplant.sdk.internal.call.PCStream;
import com.voximplant.sdk.internal.hardware.CustomVideoSource;
import com.voximplant.sdk.internal.proto.M___addCandidate;
import com.voximplant.sdk.internal.signaling.Signaling;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.CandidatePairChangeEvent;
import org.webrtc.DataChannel;
import org.webrtc.IceCandidate;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaStream;
import org.webrtc.MediaStreamTrack;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.RTCStatsCollectorCallback;
import org.webrtc.RTCStatsReport;
import org.webrtc.RtpReceiver;
import org.webrtc.RtpSender;
import org.webrtc.RtpTransceiver;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;
import org.webrtc.VideoSink;
import org.webrtc.VideoTrack;
import x6.f.o0;
public class PCStream implements PeerConnection.Observer {
    public Boolean A = null;
    public Map<String, RtpTransceiver.RtpTransceiverDirection> B = new HashMap();
    public final MediaConstraints.KeyValuePair C = new MediaConstraints.KeyValuePair("IceRestart", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
    public final IPCStreamListener a;
    public String b;
    public PeerConnection c;
    public CustomVideoSource d = null;
    public PCAudioParameters e = new PCAudioParameters();
    public e2 f = new e2();
    public ArrayList<r1> g = new ArrayList<>();
    public ArrayList<h2> h = new ArrayList<>();
    public r1 i;
    public h2 j;
    public h2 k;
    public h2 l;
    public String m;
    public String n;
    public List<String> o = new ArrayList();
    public List<String> p = new ArrayList();
    public Map<String, h2> q = new HashMap();
    public PeerConnection.SignalingState r = PeerConnection.SignalingState.STABLE;
    public CopyOnWriteArrayList<IceCandidate> s = new CopyOnWriteArrayList<>();
    public d2 t = new d2();
    public final PCFactoryWrapper u;
    public Context v;
    public boolean w;
    public Signaling x = Signaling.getInstance();
    public ScheduledExecutorService y;
    public String z = null;

    public class a implements SdpObserver {
        public final /* synthetic */ ISdpCreateObserver a;

        public a(ISdpCreateObserver iSdpCreateObserver) {
            this.a = iSdpCreateObserver;
        }

        @Override // org.webrtc.SdpObserver
        public void onCreateFailure(String str) {
            PCStream.this.y.execute(new r0(this.a, str));
        }

        @Override // org.webrtc.SdpObserver
        public void onCreateSuccess(SessionDescription sessionDescription) {
            PCStream.this.y.execute(new s0(this, this.a, sessionDescription));
        }

        @Override // org.webrtc.SdpObserver
        public void onSetFailure(String str) {
        }

        @Override // org.webrtc.SdpObserver
        public void onSetSuccess() {
        }
    }

    public class b implements SdpObserver {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ISdpCreateObserver b;

        public b(boolean z, ISdpCreateObserver iSdpCreateObserver) {
            this.a = z;
            this.b = iSdpCreateObserver;
        }

        @Override // org.webrtc.SdpObserver
        public void onCreateFailure(String str) {
            PCStream.this.y.execute(new u0(this.b, str));
        }

        @Override // org.webrtc.SdpObserver
        public void onCreateSuccess(SessionDescription sessionDescription) {
            PCStream.this.y.execute(new v0(this, sessionDescription, this.a, this.b));
        }

        @Override // org.webrtc.SdpObserver
        public void onSetFailure(String str) {
        }

        @Override // org.webrtc.SdpObserver
        public void onSetSuccess() {
        }
    }

    public class c implements SdpObserver {
        public final /* synthetic */ ISdpSetObserver a;
        public final /* synthetic */ SessionDescription b;

        public c(ISdpSetObserver iSdpSetObserver, SessionDescription sessionDescription) {
            this.a = iSdpSetObserver;
            this.b = sessionDescription;
        }

        @Override // org.webrtc.SdpObserver
        public void onCreateFailure(String str) {
        }

        @Override // org.webrtc.SdpObserver
        public void onCreateSuccess(SessionDescription sessionDescription) {
        }

        @Override // org.webrtc.SdpObserver
        public void onSetFailure(String str) {
            PCStream.this.y.execute(new w0(this, this.b, this.a, str));
        }

        @Override // org.webrtc.SdpObserver
        public void onSetSuccess() {
            ScheduledExecutorService scheduledExecutorService = PCStream.this.y;
            ISdpSetObserver iSdpSetObserver = this.a;
            iSdpSetObserver.getClass();
            scheduledExecutorService.execute(new p0(iSdpSetObserver));
        }
    }

    public class d implements SdpObserver {
        public final /* synthetic */ SessionDescription a;
        public final /* synthetic */ ISdpSetObserver b;

        public d(SessionDescription sessionDescription, ISdpSetObserver iSdpSetObserver) {
            this.a = sessionDescription;
            this.b = iSdpSetObserver;
        }

        @Override // org.webrtc.SdpObserver
        public void onCreateFailure(String str) {
        }

        @Override // org.webrtc.SdpObserver
        public void onCreateSuccess(SessionDescription sessionDescription) {
        }

        @Override // org.webrtc.SdpObserver
        public void onSetFailure(String str) {
            PCStream.this.y.execute(new z0(this, this.a, this.b, str));
        }

        @Override // org.webrtc.SdpObserver
        public void onSetSuccess() {
            PCStream.this.y.execute(new y0(this, this.a, this.b));
        }
    }

    public PCStream(PCFactoryWrapper pCFactoryWrapper, List<PeerConnection.IceServer> list, IPCStreamListener iPCStreamListener, String str, ScheduledExecutorService scheduledExecutorService) {
        Logger.i("PCStream iceServers = " + list);
        this.b = str;
        this.a = iPCStreamListener;
        this.u = pCFactoryWrapper;
        this.y = scheduledExecutorService;
        this.c = pCFactoryWrapper.a.createPeerConnection(f(list), this);
    }

    public static SessionDescription a(PCStream pCStream, SessionDescription sessionDescription) {
        Objects.requireNonNull(pCStream);
        g2.a aVar = new g2.a();
        aVar.b = false;
        aVar.a = true;
        aVar.c = false;
        HashMap<String, String> hashMap = new HashMap<>();
        aVar.d = hashMap;
        e2 e2Var = pCStream.f;
        if (e2Var != null) {
            VideoCodec videoCodec = e2Var.a;
            if (videoCodec == VideoCodec.H264) {
                hashMap.put("H264", "video");
            } else if (videoCodec == VideoCodec.VP8) {
                hashMap.put("VP8", "video");
            }
        }
        g2 b2 = g2.b();
        b2.a = sessionDescription;
        b2.b = aVar;
        return b2.c();
    }

    /* JADX WARN: Incorrect args count in method signature: (ZLcom/voximplant/sdk/internal/call/PCAudioParameters;La2/t/a/c/n0/e2;Ljava/util/List<Ljava/lang/String;>;)V */
    public void b(boolean z2, e2 e2Var) {
        IPCStreamListener iPCStreamListener;
        VideoStreamType videoStreamType;
        IPCStreamListener iPCStreamListener2;
        Logger.i(i() + "changeDirection: hold: " + z2 + ", sending transceivers: audio - " + this.m + ", video - " + this.n);
        boolean z3 = false;
        if (this.w != z2) {
            a2.b.a.a.a.S0(this, new StringBuilder(), "changeDirectionForHold");
            List<RtpTransceiver> transceivers = this.c.getTransceivers();
            this.i.b(!z2 && this.e.c);
            h2 h2Var = this.j;
            if (h2Var != null) {
                h2Var.a.setEnabled(!z2);
            }
            for (RtpTransceiver rtpTransceiver : transceivers) {
                if (z2) {
                    this.B.put(rtpTransceiver.getMid(), rtpTransceiver.getCurrentDirection());
                    rtpTransceiver.setDirection(g(rtpTransceiver.getCurrentDirection() != RtpTransceiver.RtpTransceiverDirection.INACTIVE, false));
                } else {
                    RtpTransceiver.RtpTransceiverDirection rtpTransceiverDirection = this.B.get(rtpTransceiver.getMid());
                    rtpTransceiver.setDirection(rtpTransceiverDirection);
                    Logger.i(i() + "changeDirectionForHold: changing direction for transceiver: " + rtpTransceiver.getMid() + "to: " + rtpTransceiverDirection);
                }
            }
            if (!z2) {
                this.B.clear();
            }
            this.w = z2;
            return;
        }
        e2 e2Var2 = this.f;
        boolean z4 = e2Var2.b;
        if (!z4 || !e2Var.b || e2Var2.e == (videoStreamType = e2Var.e)) {
            boolean z5 = e2Var.b;
            if (z4 != z5) {
                if (!z5) {
                    a2.b.a.a.a.S0(this, new StringBuilder(), "disableVideoSend");
                    if (this.j != null) {
                        Iterator<RtpTransceiver> it = this.c.getTransceivers().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            RtpTransceiver next = it.next();
                            if (next.getMediaType() == MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO) {
                                if ((next.getCurrentDirection() == RtpTransceiver.RtpTransceiverDirection.SEND_RECV || next.getCurrentDirection() == RtpTransceiver.RtpTransceiverDirection.SEND_ONLY) && next.getMid().equals(this.n)) {
                                    a2.b.a.a.a.S0(this, new StringBuilder(), "disableVideoSend: disable video send");
                                    this.j.b();
                                    this.h.remove(this.j);
                                    IPCStreamListener iPCStreamListener3 = this.a;
                                    if (iPCStreamListener3 != null) {
                                        iPCStreamListener3.onLocalVideoStreamRemoved(this.j.i == VideoStreamType.VIDEO ? this.k : this.l);
                                    }
                                    RtpTransceiver.RtpTransceiverDirection g2 = g(false, this.f.c);
                                    Logger.i(i() + "disableVideoSend: change video sending transceiver direction to " + g2);
                                    next.setDirection(g2);
                                    this.n = null;
                                    this.j = null;
                                }
                            }
                        }
                    } else {
                        a2.b.a.a.a.R0(this, new StringBuilder(), "disableVideoSend: there is no active video stream");
                    }
                } else {
                    Boolean bool = this.A;
                    if (bool == null || !bool.booleanValue()) {
                        VideoStreamType videoStreamType2 = e2Var.e;
                        Logger.i(i() + "enableVideoSendInMobileMode: " + videoStreamType2);
                        Iterator<RtpTransceiver> it2 = this.c.getTransceivers().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            RtpTransceiver next2 = it2.next();
                            if (next2.getMediaType() == MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO) {
                                RtpSender sender = next2.getSender();
                                if (sender == null) {
                                    Logger.w(i() + "enableVideoSendInMobileMode: video transceiver does not have a sender");
                                } else {
                                    d(sender.id(), videoStreamType2);
                                    h2 h2Var2 = this.j;
                                    if (h2Var2 != null) {
                                        sender.setTrack(h2Var2.a, false);
                                    }
                                    Logger.e(i() + "enableVideoSendInMobileMode 0: direction: " + next2.getDirection() + ", current direction: " + next2.getCurrentDirection());
                                    next2.setDirection(g(true, this.f.c));
                                    if (next2.getDirection() == RtpTransceiver.RtpTransceiverDirection.SEND_ONLY && next2.getCurrentDirection() == RtpTransceiver.RtpTransceiverDirection.INACTIVE && (iPCStreamListener = this.a) != null) {
                                        iPCStreamListener.onRenegotiationNeeded();
                                    }
                                    Logger.e(i() + "enableVideoSendInMobileMode 1: direction: " + next2.getDirection() + ", current direction: " + next2.getCurrentDirection());
                                    this.n = next2.getMid();
                                    z3 = true;
                                }
                            }
                        }
                        if (!z3) {
                            Logger.i(i() + "enableVideoSendInMobileMode: create new video transceiver");
                            d(null, videoStreamType2);
                            h2 h2Var3 = this.j;
                            if (h2Var3 != null) {
                                this.c.addTransceiver(h2Var3.a, new RtpTransceiver.RtpTransceiverInit(g(true, this.f.c)));
                            }
                        }
                    } else {
                        VideoStreamType videoStreamType3 = e2Var.e;
                        Logger.i(i() + "enableVideoSendInWebMode: " + videoStreamType3);
                        StringBuilder sb = new StringBuilder();
                        sb.append(i());
                        sb.append("enableVideoSendInWebMode: create a new video transceiver");
                        Logger.i(sb.toString());
                        d(null, videoStreamType3);
                        h2 h2Var4 = this.j;
                        if (h2Var4 != null) {
                            this.c.addTransceiver(h2Var4.a, new RtpTransceiver.RtpTransceiverInit(g(true, this.f.c)));
                            IPCStreamListener iPCStreamListener4 = this.a;
                            if (iPCStreamListener4 != null) {
                                iPCStreamListener4.onRenegotiationNeeded();
                            }
                        }
                    }
                }
                e2 e2Var3 = this.f;
                e2Var3.b = e2Var.b;
                e2Var3.e = e2Var.e;
            } else if (e2Var2.c != e2Var.c) {
                a2.b.a.a.a.S0(this, new StringBuilder(), "changeDirectionForVideoReceive");
                e2 e2Var4 = this.f;
                if (e2Var4.c || !e2Var.c) {
                    Logger.w(i() + "changeDirectionForVideoReceive: video receive is already enabled");
                    return;
                }
                e2Var4.c = true;
                boolean z7 = false;
                for (RtpTransceiver rtpTransceiver2 : this.c.getTransceivers()) {
                    if (rtpTransceiver2.getMediaType() == MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO) {
                        RtpTransceiver.RtpTransceiverDirection g3 = g(rtpTransceiver2.getMid().equals(this.n) && this.f.b, true);
                        Logger.i(i() + "changeDirectionForVideoReceive: change video transceiver direction to " + g3);
                        rtpTransceiver2.setDirection(g3);
                        IPCStreamListener iPCStreamListener5 = this.a;
                        if (iPCStreamListener5 != null) {
                            iPCStreamListener5.onRenegotiationNeeded();
                        }
                        z7 = true;
                    }
                }
                if (!z7) {
                    a2.b.a.a.a.S0(this, new StringBuilder(), "changeDirectionForVideoReceive - create video transceiver to receive");
                    this.c.addTransceiver(MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO, new RtpTransceiver.RtpTransceiverInit(g(false, true)));
                }
            }
        } else {
            h2 h2Var5 = this.j;
            if (h2Var5 == null) {
                a2.b.a.a.a.R0(this, new StringBuilder(), "replaceVideoStream: there is no active video stream");
            } else if (h2Var5.i != videoStreamType) {
                h2Var5.b();
                VideoStreamType videoStreamType4 = this.j.i;
                if (videoStreamType4 == VideoStreamType.VIDEO) {
                    IPCStreamListener iPCStreamListener6 = this.a;
                    if (iPCStreamListener6 != null) {
                        iPCStreamListener6.onLocalVideoStreamRemoved(this.k);
                    }
                } else if (videoStreamType4 == VideoStreamType.SCREEN_SHARING && (iPCStreamListener2 = this.a) != null) {
                    iPCStreamListener2.onLocalVideoStreamRemoved(this.l);
                }
                d(null, videoStreamType);
                Iterator<RtpTransceiver> it3 = this.c.getTransceivers().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    RtpTransceiver next3 = it3.next();
                    if (next3.getMediaType() == MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO && next3.getMid().equals(this.n)) {
                        if (this.j != null) {
                            next3.getSender().setTrack(this.j.a, false);
                        }
                        IPCStreamListener iPCStreamListener7 = this.a;
                        if (iPCStreamListener7 != null) {
                            iPCStreamListener7.onRenegotiationNeeded();
                        }
                    }
                }
            } else {
                Logger.w(i() + "replaceVideoStream: video stream " + videoStreamType + " is already used");
            }
            this.f.e = e2Var.e;
        }
    }

    public void c() {
        Logger.i(i() + "createLocalStreams");
        PeerConnectionFactory peerConnectionFactory = this.u.a;
        PCAudioParameters pCAudioParameters = this.e;
        r1 r1Var = new r1(peerConnectionFactory, pCAudioParameters.b, pCAudioParameters.c && !this.w);
        this.i = r1Var;
        this.g.add(r1Var);
        e2 e2Var = this.f;
        if (e2Var != null && e2Var.b) {
            d(null, VideoStreamType.VIDEO);
        }
    }

    public void close() {
        a2.b.a.a.a.S0(this, new StringBuilder(), "close");
        PeerConnection peerConnection = this.c;
        if (peerConnection != null) {
            peerConnection.dispose();
            this.c = null;
        }
        r1 r1Var = this.i;
        if (r1Var != null) {
            this.g.remove(r1Var);
            r1 r1Var2 = this.i;
            Logger.i(r1Var2.c() + "close");
            r1Var2.c = false;
            AudioSource audioSource = r1Var2.d;
            if (audioSource != null) {
                audioSource.dispose();
                r1Var2.d = null;
            }
            r1Var2.b = null;
            this.i = null;
        }
        h2 h2Var = this.j;
        if (h2Var != null) {
            this.h.remove(h2Var);
            this.j.b();
            this.j = null;
        }
        h2 h2Var2 = this.k;
        if (h2Var2 != null) {
            h2Var2.b();
            this.k = null;
        }
        h2 h2Var3 = this.l;
        if (h2Var3 != null) {
            h2Var3.b();
            this.l = null;
        }
        d2 d2Var = this.t;
        if (d2Var != null) {
            synchronized (d2Var) {
                Logger.d("PCStatisticsProcessing: close");
                d2Var.a.shutdownNow();
                d2Var.b.clear();
                d2Var.b = null;
                d2Var.c.clear();
                d2Var.c = null;
                d2Var.d.clear();
                d2Var.d = null;
            }
            this.t = null;
        }
        this.g.clear();
        this.h.clear();
        this.o.clear();
        this.p.clear();
    }

    public void createAnswer(ISdpCreateObserver iSdpCreateObserver, boolean z2) {
        a2.b.a.a.a.S0(this, new StringBuilder(), "createAnswer");
        this.c.createAnswer(new b(z2, iSdpCreateObserver), new MediaConstraints());
    }

    public final void d(String str, VideoStreamType videoStreamType) {
        e2 e2Var = this.f;
        if (e2Var == null) {
            Logger.w(i() + "createLocalVideoStream: local video stream is not created");
            return;
        }
        VideoStreamType videoStreamType2 = VideoStreamType.SCREEN_SHARING;
        if (videoStreamType == videoStreamType2) {
            PCFactoryWrapper pCFactoryWrapper = this.u;
            h2 h2Var = new h2(pCFactoryWrapper.a, str, pCFactoryWrapper.b);
            this.l = h2Var;
            this.j = h2Var;
        } else {
            boolean z2 = e2Var.d && this.d == null;
            e2Var.d = z2;
            PCFactoryWrapper pCFactoryWrapper2 = this.u;
            h2 h2Var2 = new h2(pCFactoryWrapper2.a, this.d, pCFactoryWrapper2.b, this.v, z2, str);
            this.k = h2Var2;
            this.j = h2Var2;
        }
        this.h.add(this.j);
        IPCStreamListener iPCStreamListener = this.a;
        if (iPCStreamListener != null) {
            iPCStreamListener.onVideoStreamAdded("stream_local", videoStreamType == videoStreamType2 ? this.l : this.k);
        }
    }

    public void e(ISdpCreateObserver iSdpCreateObserver, List<PeerConnection.IceServer> list, boolean z2) {
        MediaConstraints mediaConstraints = new MediaConstraints();
        if (list != null && !list.isEmpty() && z2) {
            Logger.i(i() + "createOffer: setConfiguration for ice restart: " + list);
            this.c.setConfiguration(f(list));
            mediaConstraints.mandatory.add(this.C);
        }
        Logger.i(i() + "createOffer: media constraints: " + mediaConstraints);
        this.c.createOffer(new a(iSdpCreateObserver), mediaConstraints);
    }

    public final PeerConnection.RTCConfiguration f(List<PeerConnection.IceServer> list) {
        PeerConnection.RTCConfiguration rTCConfiguration;
        Logger.d("PCStream createRTCConfiguration");
        if (list == null) {
            rTCConfiguration = new PeerConnection.RTCConfiguration(new ArrayList());
        } else {
            rTCConfiguration = new PeerConnection.RTCConfiguration(list);
        }
        rTCConfiguration.tcpCandidatePolicy = PeerConnection.TcpCandidatePolicy.ENABLED;
        rTCConfiguration.bundlePolicy = PeerConnection.BundlePolicy.BALANCED;
        rTCConfiguration.rtcpMuxPolicy = PeerConnection.RtcpMuxPolicy.REQUIRE;
        rTCConfiguration.continualGatheringPolicy = PeerConnection.ContinualGatheringPolicy.GATHER_CONTINUALLY;
        rTCConfiguration.keyType = PeerConnection.KeyType.ECDSA;
        rTCConfiguration.enableDtlsSrtp = Boolean.TRUE;
        rTCConfiguration.sdpSemantics = PeerConnection.SdpSemantics.UNIFIED_PLAN;
        return rTCConfiguration;
    }

    public final RtpTransceiver.RtpTransceiverDirection g(boolean z2, boolean z3) {
        if (z2 && z3) {
            return RtpTransceiver.RtpTransceiverDirection.SEND_RECV;
        }
        if (z2) {
            return RtpTransceiver.RtpTransceiverDirection.SEND_ONLY;
        }
        if (z3) {
            return RtpTransceiver.RtpTransceiverDirection.RECV_ONLY;
        }
        return RtpTransceiver.RtpTransceiverDirection.INACTIVE;
    }

    public void h(List<a2> list) {
        PeerConnection peerConnection = this.c;
        if (peerConnection == null) {
            a2.b.a.a.a.R0(this, new StringBuilder(), "getCallStatistics: peerConnection is invalid");
        } else {
            peerConnection.getStats(new RTCStatsCollectorCallback(list) { // from class: a2.t.a.c.n0.g1
                public final /* synthetic */ List b;

                {
                    this.b = r2;
                }

                @Override // org.webrtc.RTCStatsCollectorCallback
                public final void onStatsDelivered(RTCStatsReport rTCStatsReport) {
                    PCStream pCStream = PCStream.this;
                    pCStream.y.execute(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  
                          (wrap: java.util.concurrent.ScheduledExecutorService : 0x0004: IGET  (r2v0 java.util.concurrent.ScheduledExecutorService) = (r0v0 'pCStream' com.voximplant.sdk.internal.call.PCStream) com.voximplant.sdk.internal.call.PCStream.y java.util.concurrent.ScheduledExecutorService)
                          (wrap: a2.t.a.c.n0.x0 : 0x0008: CONSTRUCTOR  (r3v0 a2.t.a.c.n0.x0) = 
                          (r0v0 'pCStream' com.voximplant.sdk.internal.call.PCStream)
                          (r5v0 'rTCStatsReport' org.webrtc.RTCStatsReport)
                          (wrap: java.util.List : 0x0002: IGET  (r1v0 java.util.List) = (r4v0 'this' a2.t.a.c.n0.g1 A[IMMUTABLE_TYPE, THIS]) a2.t.a.c.n0.g1.b java.util.List)
                         call: a2.t.a.c.n0.x0.<init>(com.voximplant.sdk.internal.call.PCStream, org.webrtc.RTCStatsReport, java.util.List):void type: CONSTRUCTOR)
                         type: INTERFACE call: java.util.concurrent.ScheduledExecutorService.execute(java.lang.Runnable):void in method: a2.t.a.c.n0.g1.onStatsDelivered(org.webrtc.RTCStatsReport):void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0008: CONSTRUCTOR  (r3v0 a2.t.a.c.n0.x0) = 
                          (r0v0 'pCStream' com.voximplant.sdk.internal.call.PCStream)
                          (r5v0 'rTCStatsReport' org.webrtc.RTCStatsReport)
                          (wrap: java.util.List : 0x0002: IGET  (r1v0 java.util.List) = (r4v0 'this' a2.t.a.c.n0.g1 A[IMMUTABLE_TYPE, THIS]) a2.t.a.c.n0.g1.b java.util.List)
                         call: a2.t.a.c.n0.x0.<init>(com.voximplant.sdk.internal.call.PCStream, org.webrtc.RTCStatsReport, java.util.List):void type: CONSTRUCTOR in method: a2.t.a.c.n0.g1.onStatsDelivered(org.webrtc.RTCStatsReport):void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                        	... 15 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.n0.x0, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 21 more
                        */
                    /*
                        this = this;
                        com.voximplant.sdk.internal.call.PCStream r0 = com.voximplant.sdk.internal.call.PCStream.this
                        java.util.List r1 = r4.b
                        java.util.concurrent.ScheduledExecutorService r2 = r0.y
                        a2.t.a.c.n0.x0 r3 = new a2.t.a.c.n0.x0
                        r3.<init>(r0, r5, r1)
                        r2.execute(r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.n0.g1.onStatsDelivered(org.webrtc.RTCStatsReport):void");
                }
            });
        }
    }

    public final String i() {
        return a2.b.a.a.a.t(a2.b.a.a.a.L("PCStream ["), this.b, "] ");
    }

    public void initPeerConnection(PCAudioParameters pCAudioParameters, e2 e2Var) {
        a2.b.a.a.a.S0(this, new StringBuilder(), "initPeerConnection");
        if (pCAudioParameters != null) {
            this.e.c = pCAudioParameters.c;
        }
        if (e2Var != null) {
            e2 e2Var2 = this.f;
            e2Var2.b = e2Var.b;
            e2Var2.c = e2Var.c;
            e2Var2.d = e2Var.d;
            e2Var2.a(e2Var.a);
        }
    }

    public final boolean j(RtpTransceiver rtpTransceiver) {
        return rtpTransceiver.getCurrentDirection() == RtpTransceiver.RtpTransceiverDirection.SEND_ONLY || rtpTransceiver.getCurrentDirection() == RtpTransceiver.RtpTransceiverDirection.INACTIVE;
    }

    public final void k() {
        for (RtpTransceiver rtpTransceiver : this.c.getTransceivers()) {
            if (rtpTransceiver.getDirection() == RtpTransceiver.RtpTransceiverDirection.SEND_ONLY || rtpTransceiver.getDirection() == RtpTransceiver.RtpTransceiverDirection.SEND_RECV) {
                if (!this.w) {
                    String mid = rtpTransceiver.getMid();
                    if (rtpTransceiver.getMediaType() == MediaStreamTrack.MediaType.MEDIA_TYPE_AUDIO) {
                        Logger.i(i() + "updateSendingTransceiversMid: update audio sending via: " + mid);
                        this.m = mid;
                    }
                    if (rtpTransceiver.getMediaType() == MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO) {
                        Logger.i(i() + "updateSendingTransceiversMid: update video sending via: " + mid);
                        this.n = mid;
                    }
                }
            }
        }
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onAddStream(MediaStream mediaStream) {
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onAddTrack(RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr) {
    }

    @Override // org.webrtc.PeerConnection.Observer
    public /* synthetic */ void onConnectionChange(PeerConnection.PeerConnectionState peerConnectionState) {
        o0.$default$onConnectionChange(this, peerConnectionState);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onDataChannel(DataChannel dataChannel) {
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceCandidate(IceCandidate iceCandidate) {
        this.y.execute(new Runnable(iceCandidate) { // from class: a2.t.a.c.n0.t0
            public final /* synthetic */ IceCandidate b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PCStream pCStream = PCStream.this;
                IceCandidate iceCandidate2 = this.b;
                Logger.i(pCStream.i() + "onIceCandidate: " + iceCandidate2);
                IPCStreamListener iPCStreamListener = pCStream.a;
                if (iPCStreamListener != null) {
                    iPCStreamListener.onIceCandidate(iceCandidate2);
                } else if (pCStream.b.equals("__default")) {
                    pCStream.x.sendMessage(new M___addCandidate(pCStream.b, iceCandidate2));
                }
            }
        });
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
        this.y.execute(new Runnable(iceCandidateArr) { // from class: a2.t.a.c.n0.e1
            public final /* synthetic */ IceCandidate[] b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PCStream pCStream = PCStream.this;
                IceCandidate[] iceCandidateArr2 = this.b;
                Logger.i(pCStream.i() + "onIceCandidatesRemoved: " + Arrays.toString(iceCandidateArr2));
            }
        });
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
        this.y.execute(new Runnable(iceConnectionState) { // from class: a2.t.a.c.n0.d1
            public final /* synthetic */ PeerConnection.IceConnectionState b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PCStream pCStream = PCStream.this;
                PeerConnection.IceConnectionState iceConnectionState2 = this.b;
                Logger.i(pCStream.i() + "onIceConnectionChange: " + iceConnectionState2);
                IPCStreamListener iPCStreamListener = pCStream.a;
                if (iPCStreamListener != null) {
                    iPCStreamListener.onIceConnectionChange(iceConnectionState2);
                }
            }
        });
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceConnectionReceivingChange(boolean z2) {
        this.y.execute(new Runnable(z2) { // from class: a2.t.a.c.n0.b1
            public final /* synthetic */ boolean b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PCStream pCStream = PCStream.this;
                boolean z3 = this.b;
                Logger.d(pCStream.i() + "onIceConnectionReceivingChange: " + z3);
            }
        });
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onIceGatheringChange(PeerConnection.IceGatheringState iceGatheringState) {
        this.y.execute(new Runnable(iceGatheringState) { // from class: a2.t.a.c.n0.i1
            public final /* synthetic */ PeerConnection.IceGatheringState b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PCStream pCStream = PCStream.this;
                PeerConnection.IceGatheringState iceGatheringState2 = this.b;
                Logger.i(pCStream.i() + "onIceGatheringChange: " + iceGatheringState2);
                IPCStreamListener iPCStreamListener = pCStream.a;
                if (iPCStreamListener != null) {
                    iPCStreamListener.onIceGatheringChange(iceGatheringState2);
                }
            }
        });
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onRemoveStream(MediaStream mediaStream) {
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onRenegotiationNeeded() {
        this.y.execute(new Runnable() { // from class: a2.t.a.c.n0.h1
            @Override // java.lang.Runnable
            public final void run() {
                PCStream pCStream = PCStream.this;
                Logger.d(pCStream.i() + "onRenegotiationNeeded");
                IPCStreamListener iPCStreamListener = pCStream.a;
                if (iPCStreamListener != null) {
                    iPCStreamListener.onRenegotiationNeeded();
                }
            }
        });
    }

    @Override // org.webrtc.PeerConnection.Observer
    public /* synthetic */ void onSelectedCandidatePairChanged(CandidatePairChangeEvent candidatePairChangeEvent) {
        o0.$default$onSelectedCandidatePairChanged(this, candidatePairChangeEvent);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onSignalingChange(PeerConnection.SignalingState signalingState) {
        this.y.execute(new Runnable(signalingState) { // from class: a2.t.a.c.n0.c1
            public final /* synthetic */ PeerConnection.SignalingState b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PCStream pCStream = PCStream.this;
                PeerConnection.SignalingState signalingState2 = this.b;
                Logger.d(pCStream.i() + "onSignalingChange: " + signalingState2);
                pCStream.r = signalingState2;
                if (signalingState2 != PeerConnection.SignalingState.HAVE_LOCAL_OFFER) {
                    return;
                }
                if (pCStream.m == null || pCStream.n == null) {
                    pCStream.k();
                }
            }
        });
    }

    @Override // org.webrtc.PeerConnection.Observer
    public /* synthetic */ void onStandardizedIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
        o0.$default$onStandardizedIceConnectionChange(this, iceConnectionState);
    }

    @Override // org.webrtc.PeerConnection.Observer
    public void onTrack(RtpTransceiver rtpTransceiver) {
        this.y.execute(new Runnable(rtpTransceiver) { // from class: a2.t.a.c.n0.f1
            public final /* synthetic */ RtpTransceiver b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                PCStream pCStream = PCStream.this;
                RtpTransceiver rtpTransceiver2 = this.b;
                Objects.requireNonNull(pCStream);
                if (rtpTransceiver2.getMediaType() == MediaStreamTrack.MediaType.MEDIA_TYPE_AUDIO) {
                    RtpReceiver receiver = rtpTransceiver2.getReceiver();
                    if (receiver == null) {
                        a.R0(pCStream, new StringBuilder(), "onTrack: audio receiver is null");
                        return;
                    }
                    AudioTrack audioTrack = (AudioTrack) receiver.track();
                    if (audioTrack == null) {
                        a.R0(pCStream, new StringBuilder(), "onTrack: audio track is null");
                        return;
                    } else if (!pCStream.o.contains(audioTrack.id())) {
                        r1 r1Var = new r1(audioTrack.id());
                        r1Var.b = audioTrack;
                        Logger.i(pCStream.i() + "onTrack: audio track is added: " + audioTrack.id());
                        pCStream.o.add(audioTrack.id());
                        IPCStreamListener iPCStreamListener = pCStream.a;
                        if (iPCStreamListener != null) {
                            iPCStreamListener.onAudioStreamAdded("stream_remote", r1Var);
                        }
                    }
                }
                if (rtpTransceiver2.getMediaType() == MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO) {
                    RtpReceiver receiver2 = rtpTransceiver2.getReceiver();
                    if (receiver2 == null) {
                        a.R0(pCStream, new StringBuilder(), "onTrack: video receiver is null");
                        return;
                    }
                    VideoTrack videoTrack = (VideoTrack) receiver2.track();
                    if (videoTrack == null) {
                        a.R0(pCStream, new StringBuilder(), "onTrack: video track is null");
                    } else if (!pCStream.p.contains(videoTrack.id())) {
                        h2 h2Var = new h2(pCStream.u.b, pCStream.v, false, false);
                        h2Var.a = videoTrack;
                        h2Var.e = videoTrack.id();
                        Iterator<VideoSink> it = h2Var.b.iterator();
                        while (it.hasNext()) {
                            h2Var.a(it.next());
                        }
                        if (pCStream.f.c) {
                            pCStream.p.add(videoTrack.id());
                            Logger.i(pCStream.i() + "onTrack: video track is added: " + videoTrack.id());
                            pCStream.q.remove(videoTrack.id());
                            IPCStreamListener iPCStreamListener2 = pCStream.a;
                            if (iPCStreamListener2 != null) {
                                iPCStreamListener2.onVideoStreamAdded("stream_remote", h2Var);
                                return;
                            }
                            return;
                        }
                        a.S0(pCStream, new StringBuilder(), "onTrack: video receive is disabled, move new video stream to pending remote video streams");
                        pCStream.q.put(videoTrack.id(), h2Var);
                    }
                }
            }
        });
    }

    public void setLocalDescription(SessionDescription sessionDescription, ISdpSetObserver iSdpSetObserver) {
        a2.b.a.a.a.S0(this, new StringBuilder(), "setLocalDescription");
        this.c.setLocalDescription(new c(iSdpSetObserver, sessionDescription), sessionDescription);
    }

    public void setRemoteDescription(SessionDescription sessionDescription, boolean z2, ISdpSetObserver iSdpSetObserver) {
        Logger.i(i() + "setRemoteDescription");
        g2 b2 = g2.b();
        if (this.z == null) {
            if (b2.a(sessionDescription)) {
                this.z = "server_plan_b";
            } else {
                this.z = "server_unified";
            }
        }
        if (this.A == null) {
            Objects.requireNonNull(g2.b());
            boolean z3 = false;
            if (sessionDescription != null && (sessionDescription.description.contains("a=vox-params:platform chrome") || sessionDescription.description.contains("a=vox-params:platform firefox") || sessionDescription.description.contains("a=vox-params:platform safari") || sessionDescription.description.contains("a=vox-params:platform edge"))) {
                z3 = true;
            }
            this.A = Boolean.valueOf(z3);
            StringBuilder sb = new StringBuilder();
            sb.append(i());
            sb.append("setRemoteDescription: process in mode ");
            sb.append(this.A.booleanValue() ? "web" : "mobile");
            Logger.i(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i());
        sb2.append("setRemoteDescription: remote description is ");
        Objects.requireNonNull(b2);
        sb2.append(sessionDescription.description.contains("a=msid:") ? "unified plan" : "plan b");
        Logger.i(sb2.toString());
        g2.a aVar = new g2.a();
        aVar.b = true;
        aVar.a = true;
        aVar.c = z2;
        aVar.d = null;
        b2.a = sessionDescription;
        b2.b = aVar;
        SessionDescription c2 = b2.c();
        this.c.setRemoteDescription(new d(c2, iSdpSetObserver), c2);
    }

    public void start() {
        AudioTrack audioTrack;
        a2.b.a.a.a.S0(this, new StringBuilder(), Tracker.Events.CREATIVE_START);
        if (this.r == PeerConnection.SignalingState.HAVE_REMOTE_OFFER) {
            for (RtpTransceiver rtpTransceiver : this.c.getTransceivers()) {
                if (rtpTransceiver.getMediaType() == MediaStreamTrack.MediaType.MEDIA_TYPE_AUDIO && this.i != null) {
                    rtpTransceiver.setDirection(RtpTransceiver.RtpTransceiverDirection.SEND_RECV);
                    AudioTrack audioTrack2 = this.i.b;
                    if (audioTrack2 != null) {
                        rtpTransceiver.getSender().setTrack(audioTrack2, false);
                        this.m = rtpTransceiver.getMid();
                    }
                }
                if (rtpTransceiver.getMediaType() == MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO) {
                    e2 e2Var = this.f;
                    rtpTransceiver.setDirection(g(e2Var.b, e2Var.c));
                    h2 h2Var = this.j;
                    if (!(h2Var == null || h2Var.a == null)) {
                        rtpTransceiver.getSender().setTrack(this.j.a, false);
                        this.n = rtpTransceiver.getMid();
                    }
                }
            }
        }
        if (this.r == PeerConnection.SignalingState.STABLE) {
            r1 r1Var = this.i;
            if (!(r1Var == null || (audioTrack = r1Var.b) == null)) {
                this.c.addTransceiver(audioTrack, new RtpTransceiver.RtpTransceiverInit(g(true, true)));
            }
            h2 h2Var2 = this.j;
            if (h2Var2 != null) {
                VideoTrack videoTrack = h2Var2.a;
                if (videoTrack != null) {
                    PeerConnection peerConnection = this.c;
                    e2 e2Var2 = this.f;
                    peerConnection.addTransceiver(videoTrack, new RtpTransceiver.RtpTransceiverInit(g(e2Var2.b, e2Var2.c)));
                    return;
                }
                return;
            }
            e2 e2Var3 = this.f;
            if (e2Var3.c && !e2Var3.b) {
                a2.b.a.a.a.S0(this, new StringBuilder(), "start: create video transceiver for receive");
                this.c.addTransceiver(MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO, new RtpTransceiver.RtpTransceiverInit(g(false, true)));
            }
        }
    }

    public PCStream(PCFactoryWrapper pCFactoryWrapper, PeerConnection.RTCConfiguration rTCConfiguration, IPCStreamListener iPCStreamListener, String str) {
        Logger.i("PCStream");
        this.b = str;
        this.a = iPCStreamListener;
        this.u = pCFactoryWrapper;
        this.y = Executors.newSingleThreadScheduledExecutor();
        this.c = pCFactoryWrapper.a.createPeerConnection(rTCConfiguration, this);
    }
}
