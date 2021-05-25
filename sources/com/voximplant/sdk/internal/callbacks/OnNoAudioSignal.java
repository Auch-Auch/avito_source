package com.voximplant.sdk.internal.callbacks;

import a2.b.a.a.a;
import com.voximplant.sdk.call.QualityIssueLevel;
public class OnNoAudioSignal extends Callback {
    public QualityIssueLevel a;

    public OnNoAudioSignal(QualityIssueLevel qualityIssueLevel) {
        this.a = qualityIssueLevel;
    }

    public QualityIssueLevel getLevel() {
        return this.a;
    }

    public String toString() {
        StringBuilder L = a.L("NoAudioSignal: level: ");
        L.append(this.a);
        return L.toString();
    }
}
