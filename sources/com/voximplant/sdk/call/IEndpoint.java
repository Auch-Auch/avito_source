package com.voximplant.sdk.call;

import androidx.annotation.Nullable;
import java.util.List;
public interface IEndpoint {
    List<IAudioStream> getAudioStreams();

    String getEndpointId();

    int getPlace();

    String getSipUri();

    String getUserDisplayName();

    String getUserName();

    List<IVideoStream> getVideoStreams();

    void setEndpointListener(@Nullable IEndpointListener iEndpointListener);
}
