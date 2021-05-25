package com.voximplant.sdk.call;

import java.util.Map;
public interface ICallListener {
    void onCallAudioStarted(ICall iCall);

    void onCallConnected(ICall iCall, Map<String, String> map);

    void onCallDisconnected(ICall iCall, Map<String, String> map, boolean z);

    void onCallFailed(ICall iCall, int i, String str, Map<String, String> map);

    void onCallRinging(ICall iCall, Map<String, String> map);

    void onCallStatsReceived(ICall iCall, CallStats callStats);

    void onEndpointAdded(ICall iCall, IEndpoint iEndpoint);

    void onICECompleted(ICall iCall);

    void onICETimeout(ICall iCall);

    void onLocalVideoStreamAdded(ICall iCall, IVideoStream iVideoStream);

    void onLocalVideoStreamRemoved(ICall iCall, IVideoStream iVideoStream);

    void onMessageReceived(ICall iCall, String str);

    void onSIPInfoReceived(ICall iCall, String str, String str2, Map<String, String> map);
}
