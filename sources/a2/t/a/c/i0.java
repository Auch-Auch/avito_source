package a2.t.a.c;

import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.call.ISdpCreateObserver;
import com.voximplant.sdk.internal.call.ISdpSetObserver;
import com.voximplant.sdk.internal.proto.M___confirmPC;
import com.voximplant.sdk.internal.proto.M___muteLocal;
import com.voximplant.sdk.internal.utils.VoxImplantUtils;
import org.webrtc.SessionDescription;
public class i0 implements ISdpSetObserver {
    public final /* synthetic */ String a;
    public final /* synthetic */ j0 b;

    public class a implements ISdpCreateObserver {

        /* renamed from: a2.t.a.c.i0$a$a  reason: collision with other inner class name */
        public class C0105a implements ISdpSetObserver {
            public final /* synthetic */ SessionDescription a;

            public C0105a(SessionDescription sessionDescription) {
                this.a = sessionDescription;
            }

            @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
            public void onSetFailure(String str) {
                Logger.e(i0.this.b.a() + "local sdp set is failed, " + str);
                i0.this.b.b("Connectivity check failed");
            }

            @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
            public void onSetSuccess() {
                Logger.d(i0.this.b.a() + "local sdp is set");
                i0 i0Var = i0.this;
                i0Var.b.a.sendMessage(new M___confirmPC(i0Var.a, this.a.description));
            }
        }

        public a() {
        }

        @Override // com.voximplant.sdk.internal.call.ISdpCreateObserver
        public void onCreateFail(String str) {
            Logger.e(i0.this.b.a() + "local sdp is not created, " + str);
            i0.this.b.b("Connectivity check failed");
        }

        @Override // com.voximplant.sdk.internal.call.ISdpCreateObserver
        public void onCreateSuccess(SessionDescription sessionDescription) {
            Logger.d(i0.this.b.a() + "local sdp is created:");
            VoxImplantUtils.logLargeString(sessionDescription.description);
            i0.this.b.i.setLocalDescription(sessionDescription, new C0105a(sessionDescription));
        }
    }

    public i0(j0 j0Var, String str) {
        this.b = j0Var;
        this.a = str;
    }

    @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
    public void onSetFailure(String str) {
        Logger.e(this.b.a() + "remote sdp set is failed, " + str);
        this.b.b("Connectivity check failed");
    }

    @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
    public void onSetSuccess() {
        Logger.d(this.b.a() + "remote sdp is set");
        this.b.a.sendMessage(new M___muteLocal(this.a, false));
        this.b.i.createAnswer(new a(), false);
    }
}
