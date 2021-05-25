package com.voximplant.sdk.call;

import org.webrtc.RendererCommon;
import org.webrtc.VideoSink;
public interface IVideoStream {
    void addVideoRenderer(VideoSink videoSink, RenderScaleType renderScaleType);

    void addVideoRenderer(VideoSink videoSink, RenderScaleType renderScaleType, RendererCommon.RendererEvents rendererEvents);

    String getVideoStreamId();

    VideoStreamType getVideoStreamType();

    void removeVideoRenderer(VideoSink videoSink);
}
