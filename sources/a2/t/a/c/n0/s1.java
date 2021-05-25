package a2.t.a.c.n0;

import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.call.Call;
import com.voximplant.sdk.internal.call.ISdpCreateObserver;
import com.voximplant.sdk.internal.call.ISdpSetObserver;
import com.voximplant.sdk.internal.call.PCStream;
import com.voximplant.sdk.internal.proto.M_AcceptReInvite;
import com.voximplant.sdk.internal.utils.VoxImplantUtils;
import java.util.Objects;
import org.webrtc.SessionDescription;
public class s1 implements ISdpSetObserver {
    public final /* synthetic */ Call.b a;

    public class a implements ISdpCreateObserver {

        /* renamed from: a2.t.a.c.n0.s1$a$a  reason: collision with other inner class name */
        public class C0106a implements ISdpSetObserver {
            public final /* synthetic */ SessionDescription a;

            public C0106a(SessionDescription sessionDescription) {
                this.a = sessionDescription;
            }

            @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
            public void onSetFailure(String str) {
                a2.b.a.a.a.P0(Call.this, new StringBuilder(), "CallActionHandleReInvite: set local description failed");
                s1.this.a.a();
            }

            @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
            public void onSetSuccess() {
                a2.b.a.a.a.Q0(Call.this, new StringBuilder(), "CallActionHandleReInvite: local description is set = ");
                VoxImplantUtils.logLargeString(this.a.description);
                Call call = Call.this;
                call.f.sendMessage(new M_AcceptReInvite(call.a, null, this.a, call.e()));
                s1.this.a.a();
            }
        }

        public a() {
        }

        @Override // com.voximplant.sdk.internal.call.ISdpCreateObserver
        public void onCreateFail(String str) {
            a2.b.a.a.a.P0(Call.this, new StringBuilder(), "CallActionHandleReInvite: create local description failed");
            s1.this.a.a();
        }

        @Override // com.voximplant.sdk.internal.call.ISdpCreateObserver
        public void onCreateSuccess(SessionDescription sessionDescription) {
            a2.b.a.a.a.Q0(Call.this, new StringBuilder(), "CallActionHandleReInvite: local description is created");
            Call.this.b.setLocalDescription(sessionDescription, new C0106a(sessionDescription));
        }
    }

    public s1(Call.b bVar) {
        this.a = bVar;
    }

    @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
    public void onSetFailure(String str) {
        a2.b.a.a.a.P0(Call.this, new StringBuilder(), "CallActionHandleReInvite: set remote description failed");
        this.a.a();
    }

    @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
    public void onSetSuccess() {
        Logger.d(Call.this.b() + "CallActionHandleReInvite: remote description is set");
        PCStream pCStream = Call.this.b;
        a aVar = new a();
        g2 b = g2.b();
        SessionDescription sessionDescription = this.a.d;
        Objects.requireNonNull(b);
        pCStream.createAnswer(aVar, sessionDescription.description.contains("VIMS"));
    }
}
