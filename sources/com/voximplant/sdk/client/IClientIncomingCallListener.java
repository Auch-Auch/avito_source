package com.voximplant.sdk.client;

import com.voximplant.sdk.call.ICall;
import java.util.Map;
public interface IClientIncomingCallListener {
    void onIncomingCall(ICall iCall, boolean z, Map<String, String> map);
}
