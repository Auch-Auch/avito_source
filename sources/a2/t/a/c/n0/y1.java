package a2.t.a.c.n0;

import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.call.CallOut;
import com.voximplant.sdk.internal.call.ISdpCreateObserver;
import com.voximplant.sdk.internal.call.ISdpSetObserver;
import com.voximplant.sdk.internal.proto.M_callConference;
import com.voximplant.sdk.internal.proto.M_createCall;
import com.voximplant.sdk.internal.proto.Utils;
import com.voximplant.sdk.internal.signaling.Signaling;
import com.voximplant.sdk.internal.utils.VoxImplantUtils;
import java.util.Map;
import org.webrtc.SessionDescription;
public class y1 implements ISdpCreateObserver {
    public final /* synthetic */ CallOut a;

    public class a implements ISdpSetObserver {
        public a() {
        }

        @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
        public void onSetFailure(String str) {
            Logger.e(y1.this.a.b() + "CallOut: start: set local description failed");
            y1.this.a.c();
        }

        @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
        public void onSetSuccess() {
            Logger.d(y1.this.a.b() + "CallOut: start: local description is set = ");
            VoxImplantUtils.logLargeString(y1.this.a.n.description);
            CallOut callOut = y1.this.a;
            callOut.d(callOut.n.description);
            CallOut callOut2 = y1.this.a;
            if (callOut2.g) {
                Signaling signaling = callOut2.f;
                String str = callOut2.a;
                String str2 = callOut2.G;
                boolean isVideoEnabled = callOut2.isVideoEnabled();
                Map<String, String> cleanHeaders = Utils.cleanHeaders(y1.this.a.c.extraHeaders);
                CallOut callOut3 = y1.this.a;
                signaling.sendMessage(new M_callConference(str, str2, isVideoEnabled, cleanHeaders, callOut3.n, callOut3.e()));
            } else {
                Signaling signaling2 = callOut2.f;
                String str3 = callOut2.a;
                String str4 = callOut2.G;
                boolean isVideoEnabled2 = callOut2.isVideoEnabled();
                Map<String, String> cleanHeaders2 = Utils.cleanHeaders(y1.this.a.c.extraHeaders);
                CallOut callOut4 = y1.this.a;
                signaling2.sendMessage(new M_createCall(str3, str4, isVideoEnabled2, cleanHeaders2, callOut4.n, callOut4.e()));
            }
            y1.this.a.r = true;
        }
    }

    public y1(CallOut callOut) {
        this.a = callOut;
    }

    @Override // com.voximplant.sdk.internal.call.ISdpCreateObserver
    public void onCreateFail(String str) {
        Logger.e(this.a.b() + "CallOut: start: create local description failed");
        this.a.c();
    }

    @Override // com.voximplant.sdk.internal.call.ISdpCreateObserver
    public void onCreateSuccess(SessionDescription sessionDescription) {
        CallOut callOut = this.a;
        callOut.n = sessionDescription;
        callOut.b.setLocalDescription(sessionDescription, new a());
    }
}
