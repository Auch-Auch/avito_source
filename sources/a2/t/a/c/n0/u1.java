package a2.t.a.c.n0;

import com.voximplant.sdk.internal.call.Call;
import com.voximplant.sdk.internal.call.CallIn;
import com.voximplant.sdk.internal.call.ISdpSetObserver;
import com.voximplant.sdk.internal.proto.M_handleAcceptReinvite;
import com.voximplant.sdk.internal.proto.WSMessage;
import org.webrtc.SessionDescription;
public class u1 implements ISdpSetObserver {
    public final /* synthetic */ WSMessage a;
    public final /* synthetic */ Call.d b;

    public class a implements ISdpSetObserver {
        public a() {
        }

        @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
        public void onSetFailure(String str) {
            a2.b.a.a.a.P0(Call.this, new StringBuilder(), "CallActionIceRestart: accept: set remote description failed");
            u1.this.b.a();
        }

        @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
        public void onSetSuccess() {
            a2.b.a.a.a.Q0(Call.this, new StringBuilder(), "CallActionIceRestart: accept: remote description is set");
            u1.this.b.a();
        }
    }

    public u1(Call.d dVar, WSMessage wSMessage) {
        this.b = dVar;
        this.a = wSMessage;
    }

    @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
    public void onSetFailure(String str) {
        a2.b.a.a.a.P0(Call.this, new StringBuilder(), "CallActionIceRestart: failed to set local description");
        this.b.a();
    }

    @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
    public void onSetSuccess() {
        SessionDescription sdpAnswer = ((M_handleAcceptReinvite) this.a).sdpAnswer();
        Call.this.d(sdpAnswer.description);
        Call call = Call.this;
        call.b.setRemoteDescription(sdpAnswer, call instanceof CallIn, new a());
    }
}
