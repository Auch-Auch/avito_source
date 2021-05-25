package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.call.IEndpoint;
public class OnEndpointInfoUpdated extends Callback {
    public final IEndpoint a;

    public OnEndpointInfoUpdated(IEndpoint iEndpoint) {
        this.a = iEndpoint;
    }

    public IEndpoint getEndpoint() {
        return this.a;
    }
}
