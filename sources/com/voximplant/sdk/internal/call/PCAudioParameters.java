package com.voximplant.sdk.internal.call;

import com.facebook.internal.ServerProtocol;
import org.webrtc.MediaConstraints;
public class PCAudioParameters {
    public boolean a;
    public MediaConstraints b;
    public boolean c;

    public PCAudioParameters() {
        this.a = false;
        this.c = true;
        this.b = new MediaConstraints();
        a(this.a);
    }

    public final void a(boolean z) {
        if (z) {
            this.b.mandatory.add(new MediaConstraints.KeyValuePair("googEchoCancellation", "false"));
            this.b.mandatory.add(new MediaConstraints.KeyValuePair("googAutoGainControl", "false"));
            this.b.mandatory.add(new MediaConstraints.KeyValuePair("googHighpassFilter", "false"));
            this.b.mandatory.add(new MediaConstraints.KeyValuePair("googNoiseSuppression", "false"));
            return;
        }
        this.b.mandatory.add(new MediaConstraints.KeyValuePair("googEchoCancellation", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        this.b.mandatory.add(new MediaConstraints.KeyValuePair("googAutoGainControl", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        this.b.mandatory.add(new MediaConstraints.KeyValuePair("googHighpassFilter", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        this.b.mandatory.add(new MediaConstraints.KeyValuePair("googNoiseSuppression", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
    }

    public PCAudioParameters(int i, String str, boolean z) {
        this.a = z;
        this.b = new MediaConstraints();
        a(z);
    }
}
