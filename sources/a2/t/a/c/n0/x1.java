package a2.t.a.c.n0;

import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.voximplant.sdk.call.ICall;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.call.CallIn;
import com.voximplant.sdk.internal.call.ISdpCreateObserver;
import com.voximplant.sdk.internal.call.ISdpSetObserver;
import com.voximplant.sdk.internal.proto.M_acceptCall;
import com.voximplant.sdk.internal.proto.Utils;
import com.voximplant.sdk.internal.signaling.Signaling;
import com.voximplant.sdk.internal.utils.VoxImplantUtils;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.webrtc.SessionDescription;
public class x1 implements ISdpSetObserver {
    public final /* synthetic */ ICall a;
    public final /* synthetic */ CallIn b;

    public class a implements ISdpCreateObserver {

        /* renamed from: a2.t.a.c.n0.x1$a$a  reason: collision with other inner class name */
        public class C0107a implements ISdpSetObserver {
            public C0107a() {
            }

            @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
            public void onSetFailure(String str) {
                Logger.e(x1.this.b.b() + "CallIn: start: set local description failed");
                x1.this.b.c();
            }

            @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
            public void onSetSuccess() {
                Logger.i(x1.this.b.b() + "CallIn: start: local description is set");
                CallIn callIn = x1.this.b;
                Signaling signaling = callIn.f;
                String str = callIn.a;
                Map<String, String> cleanHeaders = Utils.cleanHeaders(callIn.c.extraHeaders);
                CallIn callIn2 = x1.this.b;
                signaling.sendMessage(new M_acceptCall(str, cleanHeaders, callIn2.n, callIn2.e()));
                x1 x1Var = x1.this;
                CallIn callIn3 = x1Var.b;
                callIn3.v = callIn3.e.schedule(new j0(this, x1Var.a), SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, TimeUnit.MILLISECONDS);
                x1.this.b.r = true;
            }
        }

        public a() {
        }

        @Override // com.voximplant.sdk.internal.call.ISdpCreateObserver
        public void onCreateFail(String str) {
            Logger.e(x1.this.b.b() + "CallIn: start: create local description failed");
            x1.this.b.c();
        }

        @Override // com.voximplant.sdk.internal.call.ISdpCreateObserver
        public void onCreateSuccess(SessionDescription sessionDescription) {
            x1.this.b.n = sessionDescription;
            Logger.i(x1.this.b.b() + "CallIn: start: local description is created =");
            VoxImplantUtils.logLargeString(x1.this.b.n.description);
            CallIn callIn = x1.this.b;
            callIn.b.setLocalDescription(callIn.n, new C0107a());
        }
    }

    public x1(CallIn callIn, ICall iCall) {
        this.b = callIn;
        this.a = iCall;
    }

    @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
    public void onSetFailure(String str) {
        Logger.e(this.b.b() + "CallIn: start: set remote description failed");
        this.b.c();
    }

    @Override // com.voximplant.sdk.internal.call.ISdpSetObserver
    public void onSetSuccess() {
        Logger.i(this.b.b() + "CallIn: start: remote description is set:");
        this.b.b.start();
        this.b.b.createAnswer(new a(), false);
    }
}
