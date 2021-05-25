package a2.t.a.c.n0;

import a2.b.a.a.a;
import com.voximplant.sdk.call.CallError;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.call.Call;
import com.voximplant.sdk.internal.call.ISdpCreateObserver;
import com.voximplant.sdk.internal.proto.M_ReInvite;
import com.voximplant.sdk.internal.utils.VoxImplantUtils;
import org.webrtc.SessionDescription;
public class w1 implements ISdpCreateObserver {
    public final /* synthetic */ Call.f a;

    public w1(Call.f fVar) {
        this.a = fVar;
    }

    @Override // com.voximplant.sdk.internal.call.ISdpCreateObserver
    public void onCreateFail(String str) {
        a.P0(Call.this, new StringBuilder(), "CallActionSendVideo: renegotiation, create local description failed");
        this.a.c(CallError.INTERNAL_ERROR);
    }

    @Override // com.voximplant.sdk.internal.call.ISdpCreateObserver
    public void onCreateSuccess(SessionDescription sessionDescription) {
        Call.this.n = sessionDescription;
        Logger.d(Call.this.b() + "CallActionSendVideo: renegotiation, local description is created = ");
        VoxImplantUtils.logLargeString(sessionDescription.description);
        Call call = Call.this;
        call.f.sendMessage(new M_ReInvite(call.a, null, sessionDescription, call.e()));
    }
}
