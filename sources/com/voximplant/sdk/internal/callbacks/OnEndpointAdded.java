package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.call.ICall;
import com.voximplant.sdk.call.IEndpoint;
public class OnEndpointAdded extends Callback {
    public final ICall a;
    public final IEndpoint b;

    public OnEndpointAdded(ICall iCall, IEndpoint iEndpoint) {
        this.a = iCall;
        this.b = iEndpoint;
    }

    public ICall getCall() {
        return this.a;
    }

    public IEndpoint getEndpoint() {
        return this.b;
    }
}
