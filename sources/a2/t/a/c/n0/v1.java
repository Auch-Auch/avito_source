package a2.t.a.c.n0;

import a2.b.a.a.a;
import com.voximplant.sdk.call.CallError;
import com.voximplant.sdk.internal.call.Call;
import com.voximplant.sdk.internal.call.ISdpCreateObserver;
import com.voximplant.sdk.internal.proto.M_ReInvite;
import org.webrtc.SessionDescription;
public class v1 implements ISdpCreateObserver {
    public final /* synthetic */ Call.e a;

    public v1(Call.e eVar) {
        this.a = eVar;
    }

    @Override // com.voximplant.sdk.internal.call.ISdpCreateObserver
    public void onCreateFail(String str) {
        a.P0(Call.this, new StringBuilder(), "CallActionReceiveVideo: renegotiation, create local description failed");
        this.a.c(CallError.INTERNAL_ERROR);
    }

    @Override // com.voximplant.sdk.internal.call.ISdpCreateObserver
    public void onCreateSuccess(SessionDescription sessionDescription) {
        Call.this.n = sessionDescription;
        a.Q0(Call.this, new StringBuilder(), "CallActionReceiveVideo: renegotiation, local description is created = ");
        Call call = Call.this;
        call.f.sendMessage(new M_ReInvite(call.a, null, sessionDescription, call.e()));
    }
}
