package com.voximplant.sdk.internal.call;

import a2.t.a.c.n0.a2;
import a2.t.a.c.n0.m0;
import a2.t.a.c.n0.n0;
import a2.t.a.c.n0.z1;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.voximplant.sdk.call.CallError;
import com.voximplant.sdk.call.CallException;
import com.voximplant.sdk.call.CallSettings;
import com.voximplant.sdk.call.ICall;
import com.voximplant.sdk.call.RejectMode;
import com.voximplant.sdk.internal.CallManager;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.call.Call;
import com.voximplant.sdk.internal.call.CallOut;
import com.voximplant.sdk.internal.callbacks.OnCallAudioStarted;
import com.voximplant.sdk.internal.callbacks.OnCallConnected;
import com.voximplant.sdk.internal.callbacks.OnEndpointAdded;
import com.voximplant.sdk.internal.proto.M_handleConnectionConnected;
import com.voximplant.sdk.internal.proto.M_startEarlyMedia;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
public class CallOut extends Call {
    public boolean F;
    public String G;
    public Map<String, String> H;

    public class a implements ISdpSetObserver {
        public final /* synthetic */ M_handleConnectionConnected a;
        public final /* synthetic */ Call b;

        public a(M_handleConnectionConnected m_handleConnectionConnected, Call call) {
            this.a = m_handleConnectionConnected;
            this.b = call;
        }

        @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
        public void onSetFailure(String str) {
            Logger.e(CallOut.this.b() + "CallOut: Connection connected: set remote description failed");
            CallOut.this.c();
        }

        @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
        public void onSetSuccess() {
            Logger.i(CallOut.this.b() + "CallOut: Connection connected: remote description is set.");
            CallOut.this.o = this.a.sdpAnswer();
            CallOut callOut = CallOut.this;
            callOut.v = callOut.e.schedule(new m0(this, this.b), SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, TimeUnit.MILLISECONDS);
            CallOut.this.d.addCallCallbackToQueue(new OnCallConnected(this.b, this.a.headers()));
            CallOut callOut2 = CallOut.this;
            if (!callOut2.mIsServerCall) {
                callOut2.j.addFirst(new Call.d());
                callOut2.f();
            }
        }
    }

    public class b implements ISdpSetObserver {
        public final /* synthetic */ M_startEarlyMedia a;
        public final /* synthetic */ Call b;

        public b(M_startEarlyMedia m_startEarlyMedia, Call call) {
            this.a = m_startEarlyMedia;
            this.b = call;
        }

        @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
        public void onSetFailure(String str) {
            Logger.e(CallOut.this.b() + "CallOut: Start early media: set remote description failed");
            CallOut.this.c();
        }

        @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
        public void onSetSuccess() {
            Logger.i(CallOut.this.b() + "CallOut: Start early media: remote description is set.");
            CallOut.this.o = this.a.sdpAnswer();
            CallOut callOut = CallOut.this;
            callOut.v = callOut.e.schedule(new n0(this, this.b), SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, TimeUnit.MILLISECONDS);
            CallOut.this.d.addCallCallbackToQueue(new OnCallAudioStarted(this.b));
            CallOut.this.h();
        }
    }

    public CallOut(CallManager callManager, String str, String str2, CallSettings callSettings, boolean z) {
        super(callManager, str2, callSettings, z);
        Logger.i(b() + "CallOut: ctor");
        this.G = str;
    }

    @Override // com.voximplant.sdk.internal.call.Call, com.voximplant.sdk.call.ICall
    public void answer(CallSettings callSettings) throws CallException {
        Logger.e(b() + "CallOut: answer: throw CallException");
        throw new CallException(CallError.INCORRECT_OPERATION, "Can be called for Incoming Call only");
    }

    public final void h() {
        if (this.A == z1.CONNECTED && this.o != null) {
            this.d.addCallCallbackToQueue(new OnCallConnected(this, this.H));
        }
    }

    @Override // com.voximplant.sdk.internal.call.Call
    public void onMessage(M_handleConnectionConnected m_handleConnectionConnected) {
        this.A = z1.CONNECTED;
        this.B = System.currentTimeMillis();
        this.mIsServerCall = m_handleConnectionConnected.isServerCall();
        a2 b2 = this.h.b(this.a, false);
        if (b2 != null) {
            b2.c(m_handleConnectionConnected.userDisplayName(), m_handleConnectionConnected.sipUri());
        }
        if (!this.F) {
            d(m_handleConnectionConnected.sdpAnswer().description);
            this.b.setRemoteDescription(m_handleConnectionConnected.sdpAnswer(), false, new a(m_handleConnectionConnected, this));
            return;
        }
        this.H = m_handleConnectionConnected.headers();
        h();
    }

    @Override // com.voximplant.sdk.internal.call.Call, com.voximplant.sdk.call.ICall
    public void reject(RejectMode rejectMode, Map<String, String> map) throws CallException {
        Logger.i(b() + "CallOut: reject");
        throw new CallException(CallError.INCORRECT_OPERATION, "Cannot reject outgoing call");
    }

    @Override // com.voximplant.sdk.internal.call.Call, com.voximplant.sdk.call.ICall
    public void start() throws CallException {
        super.start();
        CallSettings callSettings = this.c;
        if (callSettings.customData != null) {
            if (callSettings.extraHeaders == null) {
                callSettings.extraHeaders = new HashMap();
            }
            CallSettings callSettings2 = this.c;
            callSettings2.extraHeaders.put("VI-CallData", callSettings2.customData);
        }
        this.e.execute(new Runnable(this) { // from class: a2.t.a.c.n0.o0
            public final /* synthetic */ ICall b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CallOut callOut = CallOut.this;
                ICall iCall = this.b;
                c2 c2Var = callOut.h;
                a2 b2 = c2Var.b(c2Var.a, false);
                if (b2 != null && !b2.d) {
                    b2.d = true;
                    callOut.d.addCallCallbackToQueue(new OnEndpointAdded(iCall, b2));
                }
                callOut.b.c();
                callOut.b.start();
                callOut.b.e(new y1(callOut), null, false);
            }
        });
    }

    @Override // com.voximplant.sdk.internal.call.Call
    public void onMessage(M_startEarlyMedia m_startEarlyMedia) {
        if (this.F) {
            Logger.i(b() + "CallOut: Start early media: already handled");
            return;
        }
        this.F = true;
        d(m_startEarlyMedia.sdpAnswer().description);
        this.b.setRemoteDescription(m_startEarlyMedia.sdpAnswer(), false, new b(m_startEarlyMedia, this));
    }
}
