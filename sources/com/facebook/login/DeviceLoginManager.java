package com.facebook.login;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.login.LoginClient;
import java.util.Collection;
@AutoHandleExceptions
public class DeviceLoginManager extends LoginManager {
    public static volatile DeviceLoginManager i;
    public Uri g;
    @Nullable
    public String h;

    public static DeviceLoginManager getInstance() {
        if (i == null) {
            synchronized (DeviceLoginManager.class) {
                if (i == null) {
                    i = new DeviceLoginManager();
                }
            }
        }
        return i;
    }

    @Override // com.facebook.login.LoginManager
    public LoginClient.Request createLoginRequest(Collection<String> collection) {
        LoginClient.Request createLoginRequest = super.createLoginRequest(collection);
        Uri deviceRedirectUri = getDeviceRedirectUri();
        if (deviceRedirectUri != null) {
            createLoginRequest.g = deviceRedirectUri.toString();
        }
        String deviceAuthTargetUserId = getDeviceAuthTargetUserId();
        if (deviceAuthTargetUserId != null) {
            createLoginRequest.i = deviceAuthTargetUserId;
        }
        return createLoginRequest;
    }

    @Nullable
    public String getDeviceAuthTargetUserId() {
        return this.h;
    }

    public Uri getDeviceRedirectUri() {
        return this.g;
    }

    public void setDeviceAuthTargetUserId(@Nullable String str) {
        this.h = str;
    }

    public void setDeviceRedirectUri(Uri uri) {
        this.g = uri;
    }
}
