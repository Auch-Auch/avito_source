package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.call.IEndpoint;
public class OnEndpointRemoved extends Callback {
    public final IEndpoint a;

    public OnEndpointRemoved(IEndpoint iEndpoint) {
        this.a = iEndpoint;
    }

    public IEndpoint getEndpoint() {
        return this.a;
    }
}
