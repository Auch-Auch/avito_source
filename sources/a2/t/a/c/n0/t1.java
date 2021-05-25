package a2.t.a.c.n0;

import a2.b.a.a.a;
import com.voximplant.sdk.internal.call.Call;
import com.voximplant.sdk.internal.call.ISdpCreateObserver;
import com.voximplant.sdk.internal.proto.M_ReInvite;
import com.voximplant.sdk.internal.utils.VoxImplantUtils;
import org.webrtc.SessionDescription;
public class t1 implements ISdpCreateObserver {
    public final /* synthetic */ Call.d a;

    public t1(Call.d dVar) {
        this.a = dVar;
    }

    @Override // com.voximplant.sdk.internal.call.ISdpCreateObserver
    public void onCreateFail(String str) {
        a.P0(Call.this, new StringBuilder(), "CallActionIceRestart: failed to create local description");
        this.a.a();
    }

    @Override // com.voximplant.sdk.internal.call.ISdpCreateObserver
    public void onCreateSuccess(SessionDescription sessionDescription) {
        Call.this.n = sessionDescription;
        a.Q0(Call.this, new StringBuilder(), "CallActionIceRestart: local description is created = ");
        VoxImplantUtils.logLargeString(sessionDescription.description);
        Call call = Call.this;
        call.f.sendMessage(new M_ReInvite(call.a, null, sessionDescription, call.e()));
    }
}
