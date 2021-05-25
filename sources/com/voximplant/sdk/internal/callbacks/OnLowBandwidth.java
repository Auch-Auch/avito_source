package com.voximplant.sdk.internal.callbacks;

import a2.b.a.a.a;
import com.voximplant.sdk.call.QualityIssueLevel;
public class OnLowBandwidth extends Callback {
    public final QualityIssueLevel a;
    public final double b;
    public final double c;

    public OnLowBandwidth(QualityIssueLevel qualityIssueLevel, double d, double d2) {
        this.a = qualityIssueLevel;
        this.b = d;
        this.c = d2;
    }

    public double getActualBitrate() {
        return this.c;
    }

    public QualityIssueLevel getLevel() {
        return this.a;
    }

    public double getTargetBitrate() {
        return this.b;
    }

    public String toString() {
        StringBuilder L = a.L("LowBandwidth: level: ");
        L.append(this.a);
        L.append(", actual: ");
        L.append(this.c);
        L.append(", target: ");
        L.append(this.b);
        return L.toString();
    }
}
