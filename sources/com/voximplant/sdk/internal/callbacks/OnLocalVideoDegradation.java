package com.voximplant.sdk.internal.callbacks;

import a2.b.a.a.a;
import com.voximplant.sdk.call.QualityIssueLevel;
public class OnLocalVideoDegradation extends Callback {
    public final QualityIssueLevel a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public OnLocalVideoDegradation(QualityIssueLevel qualityIssueLevel, int i, int i2, int i3, int i4) {
        this.a = qualityIssueLevel;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public int getActualFrameHeight() {
        return this.e;
    }

    public int getActualFrameWidth() {
        return this.d;
    }

    public QualityIssueLevel getLevel() {
        return this.a;
    }

    public int getTargetFrameHeight() {
        return this.c;
    }

    public int getTargetFrameWidth() {
        return this.b;
    }

    public String toString() {
        StringBuilder L = a.L("Local video degradation: level: ");
        L.append(this.a);
        L.append(", actual: ");
        L.append(this.d);
        L.append("x");
        L.append(this.c);
        L.append(", target: ");
        L.append(this.b);
        L.append("x");
        L.append(this.c);
        return L.toString();
    }
}
