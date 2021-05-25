package a2.t.a.c;

import com.voximplant.sdk.internal.proto.WSMessage;
public interface m0 {
    void onConnected();

    void onConnectionFail(String str);

    void onDisconnected();

    void onLoginFailed(WSMessage wSMessage, int i);

    void onLoginSuccess(WSMessage wSMessage);
}
