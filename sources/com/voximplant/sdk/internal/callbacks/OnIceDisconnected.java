package com.voximplant.sdk.internal.callbacks;

import a2.b.a.a.a;
import com.voximplant.sdk.call.QualityIssueLevel;
public class OnIceDisconnected extends Callback {
    public QualityIssueLevel a;

    public OnIceDisconnected(QualityIssueLevel qualityIssueLevel) {
        this.a = qualityIssueLevel;
    }

    public QualityIssueLevel getLevel() {
        return this.a;
    }

    public String toString() {
        StringBuilder L = a.L("IceDisconnected: level: ");
        L.append(this.a);
        return L.toString();
    }
}
