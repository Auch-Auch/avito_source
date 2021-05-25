package com.voximplant.sdk.call;
public interface IEndpointListener {
    void onEndpointInfoUpdated(IEndpoint iEndpoint);

    void onEndpointRemoved(IEndpoint iEndpoint);

    void onRemoteVideoStreamAdded(IEndpoint iEndpoint, IVideoStream iVideoStream);

    void onRemoteVideoStreamRemoved(IEndpoint iEndpoint, IVideoStream iVideoStream);
}
