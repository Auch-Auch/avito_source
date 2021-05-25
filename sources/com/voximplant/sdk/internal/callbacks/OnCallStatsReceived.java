package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.call.CallStats;
import com.voximplant.sdk.call.ICall;
public class OnCallStatsReceived extends Callback {
    public final ICall a;
    public final CallStats b;

    public OnCallStatsReceived(ICall iCall, CallStats callStats) {
        this.a = iCall;
        this.b = callStats;
    }
}
