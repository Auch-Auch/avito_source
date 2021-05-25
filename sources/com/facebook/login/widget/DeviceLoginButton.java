package com.facebook.login.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.login.DeviceLoginManager;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;
public class DeviceLoginButton extends LoginButton {
    public Uri w;

    @AutoHandleExceptions
    public class b extends LoginButton.LoginClickListener {
        public b(a aVar) {
            super();
        }

        @Override // com.facebook.login.widget.LoginButton.LoginClickListener
        public LoginManager getLoginManager() {
            DeviceLoginManager instance = DeviceLoginManager.getInstance();
            instance.setDefaultAudience(DeviceLoginButton.this.getDefaultAudience());
            instance.setLoginBehavior(LoginBehavior.DEVICE_AUTH);
            instance.setDeviceRedirectUri(DeviceLoginButton.this.getDeviceRedirectUri());
            return instance;
        }
    }

    public DeviceLoginButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public Uri getDeviceRedirectUri() {
        return this.w;
    }

    @Override // com.facebook.login.widget.LoginButton
    public LoginButton.LoginClickListener getNewLoginClickListener() {
        return new b(null);
    }

    public void setDeviceRedirectUri(Uri uri) {
        this.w = uri;
    }

    public DeviceLoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DeviceLoginButton(Context context) {
        super(context);
    }
}
