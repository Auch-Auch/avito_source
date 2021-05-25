package com.voximplant.sdk.internal.callbacks;

import a2.b.a.a.a;
import com.voximplant.sdk.call.QualityIssueLevel;
public class OnCodecMismatch extends Callback {
    public final QualityIssueLevel a;
    public final String b;

    public OnCodecMismatch(QualityIssueLevel qualityIssueLevel, String str) {
        this.a = qualityIssueLevel;
        this.b = str;
    }

    public QualityIssueLevel getLevel() {
        return this.a;
    }

    public String getSendCodec() {
        return this.b;
    }

    public String toString() {
        StringBuilder L = a.L("CodecMismatch: level: ");
        L.append(this.a);
        L.append(", send codec: ");
        L.append(this.b);
        return L.toString();
    }
}
