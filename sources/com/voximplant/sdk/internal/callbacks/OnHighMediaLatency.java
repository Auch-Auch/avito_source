package com.voximplant.sdk.internal.callbacks;

import a2.b.a.a.a;
import com.voximplant.sdk.call.QualityIssueLevel;
public class OnHighMediaLatency extends Callback {
    public QualityIssueLevel a;
    public double b;

    public OnHighMediaLatency(QualityIssueLevel qualityIssueLevel, double d) {
        this.a = qualityIssueLevel;
        this.b = d;
    }

    public double getLatency() {
        return this.b;
    }

    public QualityIssueLevel getLevel() {
        return this.a;
    }

    public String toString() {
        StringBuilder L = a.L("HighMediaLatency: level: ");
        L.append(this.a);
        L.append(", latency: ");
        L.append(this.b);
        return L.toString();
    }
}
