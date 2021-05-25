package com.facebook.gamingservices;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import com.facebook.FacebookCallback;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.List;
@AutoHandleExceptions
public class GamingGroupIntegration extends FacebookDialogBase<Void, Result> {
    public static final int e = CallbackManagerImpl.RequestCodeOffset.GamingGroupIntegration.toRequestCode();

    public static class Result {
    }

    public class a implements CallbackManagerImpl.Callback {
        public final /* synthetic */ FacebookCallback a;

        public a(GamingGroupIntegration gamingGroupIntegration, FacebookCallback facebookCallback) {
            this.a = facebookCallback;
        }

        @Override // com.facebook.internal.CallbackManagerImpl.Callback
        public boolean onActivityResult(int i, Intent intent) {
            if (intent == null || !intent.hasExtra("error")) {
                this.a.onSuccess(new Result());
                return true;
            }
            this.a.onError(((FacebookRequestError) intent.getParcelableExtra("error")).getException());
            return true;
        }
    }

    public GamingGroupIntegration(Activity activity) {
        super(activity, e);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public AppCall createBaseAppCall() {
        return null;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public List<FacebookDialogBase<Void, Result>.ModeHandler> getOrderedModeHandlers() {
        return null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.internal.CallbackManagerImpl, com.facebook.FacebookCallback] */
    @Override // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        callbackManagerImpl.registerCallback(getRequestCode(), new a(this, facebookCallback));
    }

    public void showImpl() {
        StringBuilder L = a2.b.a.a.a.L("https://fb.gg/me/community/");
        L.append(FacebookSdk.getApplicationId());
        startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(L.toString())), getRequestCode());
    }

    public GamingGroupIntegration(Fragment fragment) {
        super(new FragmentWrapper(fragment), e);
    }

    public void show() {
        showImpl();
    }

    public GamingGroupIntegration(androidx.fragment.app.Fragment fragment) {
        super(new FragmentWrapper(fragment), e);
    }

    public void show(Void r1) {
        showImpl();
    }
}
