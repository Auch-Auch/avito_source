package com.voximplant.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.voximplant.sdk.call.CallSettings;
import com.voximplant.sdk.call.ICall;
import com.voximplant.sdk.call.VideoCodec;
import com.voximplant.sdk.client.RequestAudioFocusMode;
import com.voximplant.sdk.internal.CallManager;
import com.voximplant.sdk.internal.call.Call;
import com.voximplant.sdk.internal.call.CallOut;
import com.voximplant.sdk.internal.call.PCFactoryWrapper;
import com.voximplant.sdk.internal.callbacks.IncomingCallCallbackController;
import com.voximplant.sdk.internal.hardware.VoxAudioManager;
import com.voximplant.sdk.internal.utils.IdGenerator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.webrtc.PeerConnection;
public class CallManager {
    public ConcurrentHashMap<String, Call> a = new ConcurrentHashMap<>();
    public VoxAudioManager b;
    public Context c;
    public IdGenerator d = new IdGenerator();
    public IncomingCallCallbackController e = new IncomingCallCallbackController();
    public final PCFactoryWrapper f;
    public List<PeerConnection.IceServer> g;
    public List<PeerConnection.IceServer> h;
    public VideoCodec i;
    public boolean j;
    public boolean k;
    public RequestAudioFocusMode l;
    public int m;
    public ConcurrentHashMap<String, List<PeerConnection.IceServer>> n = new ConcurrentHashMap<>();
    public a o;

    public interface a {
        void onComplete();
    }

    public CallManager(Context context, PCFactoryWrapper pCFactoryWrapper) {
        this.c = context;
        this.f = pCFactoryWrapper;
        VoxAudioManager instance = VoxAudioManager.getInstance();
        this.b = instance;
        instance.initialize(this.c);
    }

    public ICall a(String str, CallSettings callSettings, boolean z) {
        Logger.i("CallManager: createCall: number: " + str + ", " + callSettings + ", is conference: " + z);
        CallOut callOut = new CallOut(this, str, this.d.get(36), callSettings, z);
        this.a.put(callOut.getCallId(), callOut);
        return callOut;
    }

    public void b(a aVar) {
        if (this.a.isEmpty()) {
            Logger.i("CallManager: endAllCalls: no calls");
            aVar.onComplete();
        } else {
            StringBuilder L = a2.b.a.a.a.L("CallManager: endAllCalls: have some calls: ");
            L.append(this.a);
            Logger.i(L.toString());
            this.o = aVar;
            for (Map.Entry<String, Call> entry : this.a.entrySet()) {
                entry.getValue().forceStop();
            }
        }
        startAudioManager(false);
    }

    public boolean cameraMirroringEnabled() {
        return this.k;
    }

    public Context getAndroidContext() {
        return this.c;
    }

    public List<PeerConnection.IceServer> getDefaultIceServers() {
        return this.h;
    }

    public List<PeerConnection.IceServer> getIceServersForCall(String str) {
        if (str == null) {
            return null;
        }
        return this.n.remove(str);
    }

    public PCFactoryWrapper getPCFactoryWrapper() {
        return this.f;
    }

    public VideoCodec getPreferredVideoCodecGlobal() {
        return this.i;
    }

    public int getStatsCollectionInterval() {
        return this.m;
    }

    public List<PeerConnection.IceServer> getStunServers() {
        return this.g;
    }

    public boolean isVideoSupportEnabled() {
        return this.j;
    }

    public void removeCall(String str) {
        a aVar;
        Logger.i("CallManager: remove call: " + str);
        this.a.remove(str);
        if (this.a.isEmpty() && (aVar = this.o) != null) {
            aVar.onComplete();
            this.o = null;
        }
    }

    public void startAudioManager(boolean z) {
        new Handler(Looper.getMainLooper()).post(new Runnable(z) { // from class: a2.t.a.c.j
            public final /* synthetic */ boolean b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CallManager callManager = CallManager.this;
                if (this.b) {
                    callManager.b.start(callManager.l == RequestAudioFocusMode.REQUEST_ON_CALL_START);
                } else if (callManager.a.isEmpty()) {
                    callManager.b.stop();
                }
            }
        });
    }
}
