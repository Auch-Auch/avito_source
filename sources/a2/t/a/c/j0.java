package a2.t.a.c;

import a2.b.a.a.a;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.voximplant.sdk.Voximplant;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.call.PCAudioParameters;
import com.voximplant.sdk.internal.call.PCFactoryWrapper;
import com.voximplant.sdk.internal.call.PCStream;
import com.voximplant.sdk.internal.signaling.ISignalingListener;
import com.voximplant.sdk.internal.signaling.Signaling;
import com.voximplant.sdk.internal.utils.VoxExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import okhttp3.Request;
import org.webrtc.PeerConnection;
public class j0 implements ISignalingListener {
    public Signaling a = Signaling.getInstance();
    public k0 b = k0.DISCONNECTED;
    public m0 c;
    public VoxExecutor d = VoxExecutor.getInstance();
    public ScheduledFuture e = null;
    public ScheduledFuture f = null;
    public ScheduledFuture g = null;
    public boolean h;
    public PCStream i = null;
    public PCFactoryWrapper j;
    public boolean k;
    public List<String> l;
    public boolean m = false;

    public j0(PCFactoryWrapper pCFactoryWrapper) {
        this.j = pCFactoryWrapper;
        this.a.addSignalingListener(this);
    }

    public final String a() {
        StringBuilder L = a.L("Authenticator [");
        L.append(this.b);
        L.append("] ");
        return L.toString();
    }

    public final void b(String str) {
        Logger.w(a() + "reportFailure: " + str);
        PCStream pCStream = this.i;
        if (pCStream != null) {
            pCStream.close();
            this.i = null;
        }
        this.b = k0.DISCONNECTED;
        ScheduledFuture scheduledFuture = this.e;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.e = null;
        }
        m0 m0Var = this.c;
        if (m0Var != null) {
            m0Var.onConnectionFail(str);
        }
    }

    public final void c() {
        this.b = k0.WEB_SOCKET_CONNECTING;
        List<String> list = this.l;
        if (list == null || list.isEmpty()) {
            b("Not able to connect to any servers");
            this.b = k0.DISCONNECTED;
            this.l = null;
            return;
        }
        String str = this.h ? "zclient" : "voxmobile";
        String str2 = "android-2.20.2";
        String str3 = Voximplant.subVersion;
        if (str3 != null && str3.matches("^[a-z]+-(\\d{1,3}\\.){2}\\d{1,3}$")) {
            str2 = str2.concat("_").concat(Voximplant.subVersion);
        }
        Logger.i(a() + "version: " + str2);
        HashMap hashMap = new HashMap();
        for (String str4 : this.l) {
            Request.Builder builder = new Request.Builder();
            StringBuilder W = a.W("wss://", str4, "/platform?version=3&referrer=platform&client=", str, "&video=true&client_platform=android&im_version=2&client_version=");
            W.append(str2);
            hashMap.put(str4, builder.url(W.toString()).build());
        }
        this.a.makeRequest(hashMap);
    }

    @Override // com.voximplant.sdk.internal.signaling.ISignalingListener
    public void onWSClose(String str) {
        k0 k0Var = k0.DISCONNECTED;
        Logger.i(a() + "onWSClose: reason: " + str);
        ScheduledFuture scheduledFuture = this.g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.g = null;
        }
        if (!this.m) {
            k0 k0Var2 = this.b;
            if (k0Var2 == k0.TRY_LOGIN) {
                ScheduledFuture scheduledFuture2 = this.f;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(true);
                    this.f = null;
                }
                this.b = k0Var;
                this.c.onDisconnected();
                this.c.onLoginFailed(null, 503);
            } else if (k0Var2 == k0.CONNECTED || k0Var2 == k0.LOGGED_IN) {
                this.l = null;
                this.k = false;
                this.b = k0Var;
                this.c.onDisconnected();
            } else if (k0Var2 != k0Var) {
                ScheduledFuture scheduledFuture3 = this.e;
                if (scheduledFuture3 != null) {
                    scheduledFuture3.cancel(true);
                    this.e = null;
                }
                PCStream pCStream = this.i;
                if (pCStream != null) {
                    pCStream.close();
                    this.i = null;
                }
                this.l = null;
                this.k = false;
                this.b = k0Var;
                this.c.onConnectionFail(str);
            }
        } else {
            ScheduledFuture scheduledFuture4 = this.e;
            if (scheduledFuture4 != null) {
                scheduledFuture4.cancel(true);
                this.e = null;
            }
            PCStream pCStream2 = this.i;
            if (pCStream2 != null) {
                pCStream2.close();
                this.i = null;
            }
            this.l = null;
            this.k = false;
            this.b = k0Var;
            this.m = false;
            this.c.onDisconnected();
        }
    }

    @Override // com.voximplant.sdk.internal.signaling.ISignalingListener
    public void onWSOpen() {
        if (this.b != k0.WEB_SOCKET_CONNECTING) {
            return;
        }
        if (this.h) {
            if (this.m) {
                Logger.w(a() + "connectivityCheck: disconnect was called");
                return;
            }
            this.b = k0.CONNECTIVITY_CHECK;
            Logger.i(a() + "connectivityCheck: connectivity check is started");
            this.e = this.d.smRunDelayed(new Runnable() { // from class: a2.t.a.c.c
                @Override // java.lang.Runnable
                public final void run() {
                    j0 j0Var = j0.this;
                    j0Var.b("Server not ready");
                    j0Var.b = k0.DISCONNECTED;
                }
            }, HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
            PeerConnection.RTCConfiguration rTCConfiguration = new PeerConnection.RTCConfiguration(new ArrayList());
            rTCConfiguration.tcpCandidatePolicy = PeerConnection.TcpCandidatePolicy.DISABLED;
            rTCConfiguration.bundlePolicy = PeerConnection.BundlePolicy.BALANCED;
            rTCConfiguration.rtcpMuxPolicy = PeerConnection.RtcpMuxPolicy.NEGOTIATE;
            rTCConfiguration.continualGatheringPolicy = PeerConnection.ContinualGatheringPolicy.GATHER_CONTINUALLY;
            rTCConfiguration.keyType = PeerConnection.KeyType.ECDSA;
            PCStream pCStream = new PCStream(this.j, rTCConfiguration, null, "__default");
            this.i = pCStream;
            pCStream.initPeerConnection(new PCAudioParameters(), null);
            this.i.start();
        } else if (this.m) {
            Logger.w(a() + "waitServerReady: disconnect was called");
        } else {
            this.b = k0.WAIT_SERVER_READY;
            this.e = this.d.smRunDelayed(new Runnable() { // from class: a2.t.a.c.g
                @Override // java.lang.Runnable
                public final void run() {
                    j0 j0Var = j0.this;
                    j0Var.b("Server not ready");
                    j0Var.a.closeConnection(true);
                    j0Var.b = k0.DISCONNECTED;
                }
            }, HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
        }
    }
}
