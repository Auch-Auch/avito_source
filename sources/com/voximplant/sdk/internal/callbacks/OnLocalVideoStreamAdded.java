package com.voximplant.sdk.internal.callbacks;

import com.voximplant.sdk.call.ICall;
import com.voximplant.sdk.call.IVideoStream;
public class OnLocalVideoStreamAdded extends Callback {
    public final ICall a;
    public final IVideoStream b;

    public OnLocalVideoStreamAdded(ICall iCall, IVideoStream iVideoStream) {
        this.a = iCall;
        this.b = iVideoStream;
    }

    public ICall getCall() {
        return this.a;
    }

    public IVideoStream getVideoStream() {
        return this.b;
    }
}
