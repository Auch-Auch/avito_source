package a2.t.a.c.n0;

import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.call.Call;
import java.util.List;
import org.webrtc.PeerConnection;
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ Call.d a;

    public /* synthetic */ k(Call.d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Call.d dVar = this.a;
        Call call = Call.this;
        List<PeerConnection.IceServer> iceServersForCall = call.mCallManager.getIceServersForCall(call.a);
        if (iceServersForCall == null) {
            iceServersForCall = Call.this.mCallManager.getDefaultIceServers();
        }
        if (iceServersForCall != null) {
            Call.this.b.e(new t1(dVar), iceServersForCall, true);
            return;
        }
        Logger.e(Call.this.b() + "CallActionIceRestart: failed to run the action, ice servers are null");
        dVar.a();
    }
}
