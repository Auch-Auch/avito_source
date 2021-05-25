package com.voximplant.sdk.internal.signaling;

import com.voximplant.sdk.internal.proto.WSMessage;
public interface IMessageListener {
    void onMessage(WSMessage wSMessage);
}
