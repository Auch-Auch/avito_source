package com.voximplant.sdk.client;

import androidx.annotation.Nullable;
import com.voximplant.sdk.call.CallSettings;
import com.voximplant.sdk.call.ICall;
import java.util.List;
import java.util.Map;
public interface IClient {
    ICall call(String str, CallSettings callSettings);

    ICall callConference(String str, CallSettings callSettings);

    void connect() throws IllegalStateException;

    void connect(boolean z, @Nullable List<String> list) throws IllegalStateException;

    void disconnect();

    ClientState getClientState();

    List<String> getSupportedVideoCodecs();

    void handlePushNotification(Map<String, String> map);

    void login(String str, String str2);

    void loginWithAccessToken(String str, String str2);

    void loginWithOneTimeKey(String str, String str2);

    void refreshToken(String str, String str2);

    void registerForPushNotifications(String str, IPushTokenCompletionHandler iPushTokenCompletionHandler);

    void requestOneTimeKey(String str);

    void setClientIncomingCallListener(IClientIncomingCallListener iClientIncomingCallListener);

    void setClientLoginListener(IClientLoginListener iClientLoginListener);

    void setClientSessionListener(IClientSessionListener iClientSessionListener);

    void unregisterFromPushNotifications(String str, IPushTokenCompletionHandler iPushTokenCompletionHandler);
}
