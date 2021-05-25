package com.facebook.share;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.List;
@Deprecated
public class DeviceShareDialog extends FacebookDialogBase<ShareContent, Result> {
    public static final int e = CallbackManagerImpl.RequestCodeOffset.DeviceShare.toRequestCode();

    public static class Result {
    }

    public class a implements CallbackManagerImpl.Callback {
        public final /* synthetic */ FacebookCallback a;

        public a(DeviceShareDialog deviceShareDialog, FacebookCallback facebookCallback) {
            this.a = facebookCallback;
        }

        @Override // com.facebook.internal.CallbackManagerImpl.Callback
        public boolean onActivityResult(int i, Intent intent) {
            if (intent.hasExtra("error")) {
                this.a.onError(((FacebookRequestError) intent.getParcelableExtra("error")).getException());
                return true;
            }
            this.a.onSuccess(new Result());
            return true;
        }
    }

    public DeviceShareDialog(Activity activity) {
        super(activity, e);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public AppCall createBaseAppCall() {
        return null;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public List<FacebookDialogBase<ShareContent, Result>.ModeHandler> getOrderedModeHandlers() {
        return null;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        callbackManagerImpl.registerCallback(getRequestCode(), new a(this, facebookCallback));
    }

    public DeviceShareDialog(Fragment fragment) {
        super(new FragmentWrapper(fragment), e);
    }

    public boolean canShowImpl(ShareContent shareContent, Object obj) {
        return (shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareOpenGraphContent);
    }

    public void showImpl(ShareContent shareContent, Object obj) {
        if (shareContent == null) {
            throw new FacebookException("Must provide non-null content to share");
        } else if ((shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareOpenGraphContent)) {
            Intent intent = new Intent();
            intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
            intent.setAction(DeviceShareDialogFragment.TAG);
            intent.putExtra("content", shareContent);
            startActivityForResult(intent, getRequestCode());
        } else {
            throw new FacebookException(getClass().getSimpleName() + " only supports ShareLinkContent or ShareOpenGraphContent");
        }
    }

    public DeviceShareDialog(androidx.fragment.app.Fragment fragment) {
        super(new FragmentWrapper(fragment), e);
    }
}
