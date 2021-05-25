package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.call.IEndpoint;
import com.voximplant.sdk.call.IVideoStream;
public class OnRemoteVideoStreamAdded extends Callback {
    public final IEndpoint a;
    public final IVideoStream b;

    public OnRemoteVideoStreamAdded(IEndpoint iEndpoint, IVideoStream iVideoStream) {
        this.a = iEndpoint;
        this.b = iVideoStream;
    }

    public IEndpoint getEndpoint() {
        return this.a;
    }

    public IVideoStream getVideoStream() {
        return this.b;
    }
}
