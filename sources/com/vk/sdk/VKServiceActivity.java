package com.vk.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.dialogs.VKCaptchaDialog;
import com.vk.sdk.dialogs.VKOpenAuthDialog;
import com.vk.sdk.util.VKStringJoiner;
import com.vk.sdk.util.VKUtil;
public class VKServiceActivity extends Activity implements DialogInterface.OnDismissListener {
    public static final /* synthetic */ int a = 0;

    public enum VKServiceType {
        Authorization(10485),
        Captcha(14079),
        Validation(11477);
        
        public int a;

        /* access modifiers changed from: public */
        VKServiceType(int i) {
            this.a = i;
        }

        public int getOuterCode() {
            return this.a;
        }
    }

    public class a implements VKCallback<VKAccessToken> {
        public a() {
        }

        @Override // com.vk.sdk.VKCallback
        public void onError(VKError vKError) {
            VKError vKError2;
            VKRequest vKRequest;
            VKServiceActivity vKServiceActivity = VKServiceActivity.this;
            int i = VKServiceActivity.a;
            VKObject registeredObject = VKObject.getRegisteredObject(vKServiceActivity.b());
            if ((registeredObject instanceof VKError) && (vKRequest = (vKError2 = (VKError) registeredObject).request) != null) {
                vKRequest.cancel();
                VKRequest.VKRequestListener vKRequestListener = vKError2.request.requestListener;
                if (vKRequestListener != null) {
                    vKRequestListener.onError(vKError);
                }
            }
            if (vKError != null) {
                VKServiceActivity vKServiceActivity2 = VKServiceActivity.this;
                vKServiceActivity2.setResult(0, vKServiceActivity2.getIntent().putExtra("vk_extra_error_id", vKError.registerObject()));
            } else {
                VKServiceActivity.this.setResult(0);
            }
            VKServiceActivity.this.finish();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.vk.sdk.VKCallback
        public void onResult(VKAccessToken vKAccessToken) {
            VKServiceActivity.this.setResult(-1);
            VKServiceActivity.this.finish();
        }
    }

    @NonNull
    public static Intent a(Context context, VKServiceType vKServiceType) {
        Intent intent = new Intent(context, VKServiceActivity.class);
        intent.putExtra("arg1", vKServiceType.name());
        intent.putExtra("arg4", VKSdk.isCustomInitialize());
        return intent;
    }

    public static void interruptWithError(Context context, VKError vKError, VKServiceType vKServiceType) {
        Intent a3 = a(context, vKServiceType);
        a3.setFlags(268435456);
        a3.putExtra("arg3", vKError.registerObject());
        if (context != null) {
            context.startActivity(a3);
        }
    }

    public final long b() {
        return getIntent().getLongExtra("arg3", 0);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x0067 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.util.Map] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.app.Activity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r7, int r8, android.content.Intent r9) {
        /*
        // Method dump skipped, instructions count: 291
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vk.sdk.VKServiceActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onActivityResultPublic(int i, int i2, Intent intent) {
        onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getBooleanExtra("arg4", false)) {
            VKSdk.customInitialize(this, 0, null);
        }
        VKSdk.wakeUpSession(getApplicationContext());
        int ordinal = VKServiceType.valueOf(getIntent().getStringExtra("arg1")).ordinal();
        if (ordinal == 0) {
            Context applicationContext = getApplicationContext();
            Bundle bundle2 = new Bundle();
            bundle2.putString("version", VKSdk.getApiVersion());
            bundle2.putInt("client_id", VKSdk.c);
            bundle2.putBoolean(VKOpenAuthDialog.VK_EXTRA_REVOKE, true);
            bundle2.putString("scope", VKStringJoiner.join(getIntent().getStringArrayListExtra("arg2"), ","));
            String[] certificateFingerprint = VKUtil.getCertificateFingerprint(applicationContext, "com.vkontakte.android");
            if (!VKUtil.isAppInstalled(applicationContext, "com.vkontakte.android") || !VKUtil.isIntentAvailable(applicationContext, "com.vkontakte.android.action.SDK_AUTH") || certificateFingerprint.length <= 0 || !certificateFingerprint[0].equals("48761EEF50EE53AFC4CC9C5F10E6BDE7F8F5B82F")) {
                new VKOpenAuthDialog().show(this, bundle2, VKServiceType.Authorization.getOuterCode(), null);
            } else if (bundle == null) {
                Intent intent = new Intent("com.vkontakte.android.action.SDK_AUTH", (Uri) null);
                intent.setPackage("com.vkontakte.android");
                intent.putExtras(bundle2);
                startActivityForResult(intent, VKServiceType.Authorization.getOuterCode());
            }
        } else if (ordinal == 1) {
            VKError vKError = (VKError) VKObject.getRegisteredObject(b());
            if (vKError != null) {
                new VKCaptchaDialog(vKError).show(this, this);
            } else {
                finish();
            }
        } else if (ordinal == 2) {
            VKError vKError2 = (VKError) VKObject.getRegisteredObject(b());
            if (vKError2 != null) {
                if (!TextUtils.isEmpty(vKError2.redirectUri) && !vKError2.redirectUri.contains("&ui=vk_sdk") && !vKError2.redirectUri.contains("?ui=vk_sdk")) {
                    if (vKError2.redirectUri.indexOf(63) > 0) {
                        vKError2.redirectUri = a2.b.a.a.a.t(new StringBuilder(), vKError2.redirectUri, "&ui=vk_sdk");
                    } else {
                        vKError2.redirectUri = a2.b.a.a.a.t(new StringBuilder(), vKError2.redirectUri, "?ui=vk_sdk");
                    }
                }
                new VKOpenAuthDialog().show(this, new Bundle(), VKServiceType.Validation.getOuterCode(), vKError2);
                return;
            }
            finish();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        finish();
    }
}
