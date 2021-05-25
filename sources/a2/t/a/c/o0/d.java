package a2.t.a.c.o0;

import a2.b.a.a.a;
import com.voximplant.sdk.client.IClientLoginListener;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.callbacks.Callback;
import com.voximplant.sdk.internal.callbacks.LoginCallbackController;
import com.voximplant.sdk.internal.callbacks.OnLoginFailed;
import com.voximplant.sdk.internal.callbacks.OnLoginSuccessful;
import com.voximplant.sdk.internal.callbacks.OnOneTimeKeyGenerated;
import com.voximplant.sdk.internal.callbacks.OnRefreshTokenFailed;
import com.voximplant.sdk.internal.callbacks.OnRefreshTokenSuccess;
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ LoginCallbackController a;

    public /* synthetic */ d(LoginCallbackController loginCallbackController) {
        this.a = loginCallbackController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LoginCallbackController loginCallbackController = this.a;
        while (!loginCallbackController.b.isEmpty()) {
            Callback poll = loginCallbackController.b.poll();
            IClientLoginListener iClientLoginListener = loginCallbackController.a;
            if (iClientLoginListener != null) {
                if (poll instanceof OnLoginSuccessful) {
                    Logger.i("Invoke onLoginSuccessful");
                    OnLoginSuccessful onLoginSuccessful = (OnLoginSuccessful) poll;
                    iClientLoginListener.onLoginSuccessful(onLoginSuccessful.getDisplayName(), onLoginSuccessful.getLoginTokens());
                }
                if (poll instanceof OnLoginFailed) {
                    OnLoginFailed onLoginFailed = (OnLoginFailed) poll;
                    StringBuilder L = a.L("Invoke onLoginFailed ");
                    L.append(onLoginFailed.getErrorCode());
                    Logger.i(L.toString());
                    iClientLoginListener.onLoginFailed(loginCallbackController.a(onLoginFailed.getErrorCode()));
                }
                if (poll instanceof OnRefreshTokenFailed) {
                    Logger.i("Invoke onRefreshTokenFailed");
                    iClientLoginListener.onRefreshTokenFailed(loginCallbackController.a(((OnRefreshTokenFailed) poll).getErrorCode()));
                }
                if (poll instanceof OnRefreshTokenSuccess) {
                    Logger.i("Invoke onRefreshTokenSuccess");
                    iClientLoginListener.onRefreshTokenSuccess(((OnRefreshTokenSuccess) poll).getLoginTokens());
                }
                if (poll instanceof OnOneTimeKeyGenerated) {
                    Logger.i("Invoke onOneTimeKeyGenerated");
                    iClientLoginListener.onOneTimeKeyGenerated(((OnOneTimeKeyGenerated) poll).getKey());
                }
            }
        }
    }
}
