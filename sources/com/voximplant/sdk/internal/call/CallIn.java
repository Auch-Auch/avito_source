package com.voximplant.sdk.internal.call;

import a2.t.a.c.n0.a2;
import a2.t.a.c.n0.e2;
import a2.t.a.c.n0.f2;
import a2.t.a.c.n0.z1;
import com.voximplant.sdk.call.CallError;
import com.voximplant.sdk.call.CallException;
import com.voximplant.sdk.call.CallSettings;
import com.voximplant.sdk.call.ICall;
import com.voximplant.sdk.call.RejectMode;
import com.voximplant.sdk.call.VideoCodec;
import com.voximplant.sdk.call.VideoFlags;
import com.voximplant.sdk.internal.CallManager;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.call.CallIn;
import com.voximplant.sdk.internal.callbacks.OnEndpointAdded;
import com.voximplant.sdk.internal.proto.M_handleConnectionConnected;
import com.voximplant.sdk.internal.proto.M_handleIncomingConnection;
import com.voximplant.sdk.internal.proto.M_rejectCall;
import com.voximplant.sdk.internal.proto.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.webrtc.SessionDescription;
public class CallIn extends Call {
    public CallIn(CallManager callManager, M_handleIncomingConnection m_handleIncomingConnection) {
        super(callManager, m_handleIncomingConnection.callId(), m_handleIncomingConnection.getVideoCallSettings(), false);
        boolean isServerCall = m_handleIncomingConnection.isServerCall();
        this.mIsServerCall = isServerCall;
        if (!isServerCall) {
            this.y = true;
        }
        SessionDescription sdpOffer = m_handleIncomingConnection.sdpOffer();
        this.o = sdpOffer;
        d(sdpOffer.description);
        a2 b = this.h.b(this.a, false);
        if (b != null) {
            b.c(m_handleIncomingConnection.userDisplayName(), m_handleIncomingConnection.sipUri());
            if (!b.d) {
                b.d = true;
                this.d.addCallCallbackToQueue(new OnEndpointAdded(this, b));
            }
        }
    }

    @Override // com.voximplant.sdk.internal.call.Call, com.voximplant.sdk.call.ICall
    public void answer(CallSettings callSettings) throws CallException {
        VideoCodec videoCodec;
        Logger.i(b() + "CallIn: answer");
        if (this.A == z1.NOT_STARTED) {
            if (callSettings != null) {
                CallSettings callSettings2 = this.c;
                callSettings2.videoFlags = callSettings.videoFlags;
                Map<String, String> map = callSettings.extraHeaders;
                callSettings2.extraHeaders = map;
                callSettings2.preferredVideoCodec = callSettings.preferredVideoCodec;
                String str = callSettings.customData;
                if (str != null) {
                    callSettings2.customData = str;
                    if (map == null) {
                        callSettings2.extraHeaders = new HashMap();
                    }
                    CallSettings callSettings3 = this.c;
                    callSettings3.extraHeaders.put("VI-CallData", callSettings3.customData);
                }
            }
            VideoCodec preferredVideoCodecGlobal = this.mCallManager.getPreferredVideoCodecGlobal();
            VideoCodec videoCodec2 = VideoCodec.AUTO;
            if (preferredVideoCodecGlobal == videoCodec2 || (videoCodec = this.c.preferredVideoCodec) == videoCodec2 || preferredVideoCodecGlobal == videoCodec) {
                this.m.a(preferredVideoCodecGlobal);
            } else {
                this.m.a(videoCodec);
            }
            f2 f2Var = this.mQualityIssueAnalyzer;
            VideoCodec videoCodec3 = this.m.a;
            Objects.requireNonNull(f2Var);
            if (videoCodec3 == VideoCodec.H264) {
                f2Var.b = "H264";
            } else if (videoCodec3 == VideoCodec.VP8) {
                f2Var.b = "VP8";
            } else {
                f2Var.b = null;
            }
            if (this.c.videoFlags != null) {
                Logger.i(b() + "CallIn: answer: video flags are provided: receive: " + this.c.videoFlags.receiveVideo + ", send: " + this.c.videoFlags.sendVideo);
                e2 e2Var = this.m;
                VideoFlags videoFlags = this.c.videoFlags;
                e2Var.c = videoFlags.receiveVideo;
                e2Var.b = videoFlags.sendVideo;
            } else {
                Logger.i(b() + "CallIn: answer: video flags are not provided, using the following configuration: receive: " + this.m.c + ", send: " + this.m.b);
            }
            super.start();
            this.e.execute(new Runnable(this) { // from class: a2.t.a.c.n0.k0
                public final /* synthetic */ ICall b;

                {
                    this.b = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    CallIn callIn = CallIn.this;
                    ICall iCall = this.b;
                    callIn.b.c();
                    callIn.b.setRemoteDescription(callIn.o, false, new x1(callIn, iCall));
                }
            });
            return;
        }
        Logger.e(b() + "CallIn: answer: throw CallException: INCORRECT_OPERATION - Call is already answered or ended");
        throw new CallException(CallError.INCORRECT_OPERATION, "Call is already answered or ended");
    }

    @Override // com.voximplant.sdk.internal.call.Call
    public void onMessage(M_handleConnectionConnected m_handleConnectionConnected) {
        super.onMessage(m_handleConnectionConnected);
        if (this.z == null && !this.mIsServerCall) {
            this.z = this.e.schedule(new Runnable() { // from class: a2.t.a.c.n0.l0
                @Override // java.lang.Runnable
                public final void run() {
                    CallIn callIn = CallIn.this;
                    Logger.w(callIn.b() + "ICE restart is not received, stop waiting for it");
                    callIn.y = false;
                    callIn.f();
                }
            }, 2000, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.voximplant.sdk.internal.call.Call, com.voximplant.sdk.call.ICall
    public void reject(RejectMode rejectMode, Map<String, String> map) throws CallException {
        Logger.i(b() + "reject headers = " + map);
        z1 z1Var = this.A;
        if (z1Var == z1.STARTED || z1Var == z1.CONNECTED) {
            throw new CallException(CallError.INCORRECT_OPERATION, "Cannot reject call in progress, use hangup");
        } else if (z1Var != z1.ENDED) {
            this.f.sendMessage(new M_rejectCall(this.a, rejectMode == RejectMode.BUSY, Utils.cleanHeaders(map)));
        } else {
            throw new CallException(CallError.INCORRECT_OPERATION, "Cannot reject call ended");
        }
    }

    @Override // com.voximplant.sdk.internal.call.Call, com.voximplant.sdk.call.ICall
    public void start() throws CallException {
        Logger.i(b() + "CallIn: start");
        throw new CallException(CallError.INCORRECT_OPERATION, "Cannot start incoming call, use ICall.answer API");
    }
}
