package com.voximplant.sdk.internal.callbacks;

import a2.b.a.a.a;
import com.voximplant.sdk.call.QualityIssueLevel;
public class OnPacketLoss extends Callback {
    public final QualityIssueLevel a;
    public final double b;

    public OnPacketLoss(QualityIssueLevel qualityIssueLevel, double d) {
        this.a = qualityIssueLevel;
        this.b = d;
    }

    public QualityIssueLevel getLevel() {
        return this.a;
    }

    public double getPacketLoss() {
        return this.b;
    }

    public String toString() {
        StringBuilder L = a.L("PacketLoss: level: ");
        L.append(this.a);
        L.append(", loss: ");
        L.append(this.b);
        return L.toString();
    }
}
