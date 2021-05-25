package com.voximplant.sdk.internal.call;

import a2.t.a.c.n0.h2;
import a2.t.a.c.n0.r1;
import com.voximplant.sdk.call.CallStats;
import org.webrtc.IceCandidate;
import org.webrtc.PeerConnection;
public interface IPCStreamListener {
    void onAudioStreamAdded(String str, r1 r1Var);

    void onAudioStreamRemoved(String str, String str2);

    void onCallStatisticsReady(CallStats callStats);

    void onIceCandidate(IceCandidate iceCandidate);

    void onIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState);

    void onIceGatheringChange(PeerConnection.IceGatheringState iceGatheringState);

    void onLocalVideoStreamRemoved(h2 h2Var);

    void onRemoteVideoStreamRemoved(String str);

    void onRenegotiationNeeded();

    void onVideoStreamAdded(String str, h2 h2Var);
}
