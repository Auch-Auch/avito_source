package com.facebook.gamingservices;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
@AutoHandleExceptions
public class FriendFinderDialog extends FacebookDialogBase<Void, Result> {
    public static final int f = CallbackManagerImpl.RequestCodeOffset.GamingFriendFinder.toRequestCode();
    public FacebookCallback e;

    public static class Result {
    }

    public class a implements DaemonRequest.Callback {
        public a() {
        }

        @Override // com.facebook.gamingservices.cloudgaming.DaemonRequest.Callback
        public void onCompleted(GraphResponse graphResponse) {
            if (FriendFinderDialog.this.e == null) {
                return;
            }
            if (graphResponse.getError() != null) {
                FriendFinderDialog.this.e.onError(new FacebookException(graphResponse.getError().getErrorMessage()));
            } else {
                FriendFinderDialog.this.e.onSuccess(new Result());
            }
        }
    }

    public class b implements CallbackManagerImpl.Callback {
        public final /* synthetic */ FacebookCallback a;

        public b(FriendFinderDialog friendFinderDialog, FacebookCallback facebookCallback) {
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

    public FriendFinderDialog(Activity activity) {
        super(activity, f);
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
        this.e = facebookCallback;
        callbackManagerImpl.registerCallback(getRequestCode(), new b(this, facebookCallback));
    }

    public void showImpl() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            throw new FacebookException("Attempted to open GamingServices FriendFinder with an invalid access token");
        }
        String applicationId = currentAccessToken.getApplicationId();
        if (CloudGameLoginHandler.isRunningInCloud()) {
            Activity activityContext = getActivityContext();
            a aVar = new a();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", applicationId);
                jSONObject.put("deepLink", "FRIEND_FINDER");
                DaemonRequest.executeAsync(activityContext, jSONObject, aVar, SDKMessageEnum.OPEN_GAMING_SERVICES_DEEP_LINK);
            } catch (JSONException unused) {
                FacebookCallback facebookCallback = this.e;
                if (facebookCallback != null) {
                    facebookCallback.onError(new FacebookException("Couldn't prepare Friend Finder Dialog"));
                }
            }
        } else {
            startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(a2.b.a.a.a.c3("https://fb.gg/me/friendfinder/", applicationId))), getRequestCode());
        }
    }

    public FriendFinderDialog(Fragment fragment) {
        super(new FragmentWrapper(fragment), f);
    }

    public void show() {
        showImpl();
    }

    public FriendFinderDialog(androidx.fragment.app.Fragment fragment) {
        super(new FragmentWrapper(fragment), f);
    }

    public void show(Void r1) {
        showImpl();
    }
}
