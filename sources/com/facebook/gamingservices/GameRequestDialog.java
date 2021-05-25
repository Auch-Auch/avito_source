package com.facebook.gamingservices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Validate;
import com.facebook.share.internal.GameRequestValidation;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.GameRequestContent;
import java.util.ArrayList;
import java.util.List;
public class GameRequestDialog extends FacebookDialogBase<GameRequestContent, Result> {
    public static final int e = CallbackManagerImpl.RequestCodeOffset.GameRequest.toRequestCode();

    public static final class Result {
        public String a;
        public List<String> b = new ArrayList();

        public Result(Bundle bundle, a aVar) {
            this.a = bundle.getString("request");
            while (bundle.containsKey(String.format(ShareConstants.WEB_DIALOG_RESULT_PARAM_TO_ARRAY_MEMBER, Integer.valueOf(this.b.size())))) {
                List<String> list = this.b;
                list.add(bundle.getString(String.format(ShareConstants.WEB_DIALOG_RESULT_PARAM_TO_ARRAY_MEMBER, Integer.valueOf(list.size()))));
            }
        }

        public String getRequestId() {
            return this.a;
        }

        public List<String> getRequestRecipients() {
            return this.b;
        }
    }

    public class a extends ResultProcessor {
        public final /* synthetic */ FacebookCallback b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GameRequestDialog gameRequestDialog, FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
            super(facebookCallback);
            this.b = facebookCallback2;
        }

        @Override // com.facebook.share.internal.ResultProcessor
        public void onSuccess(AppCall appCall, Bundle bundle) {
            if (bundle != null) {
                this.b.onSuccess(new Result(bundle, null));
            } else {
                onCancel(appCall);
            }
        }
    }

    public class b implements CallbackManagerImpl.Callback {
        public final /* synthetic */ ResultProcessor a;

        public b(ResultProcessor resultProcessor) {
            this.a = resultProcessor;
        }

        @Override // com.facebook.internal.CallbackManagerImpl.Callback
        public boolean onActivityResult(int i, Intent intent) {
            return ShareInternalUtility.handleActivityResult(GameRequestDialog.this.getRequestCode(), i, intent, this.a);
        }
    }

    public class c extends FacebookDialogBase<GameRequestContent, Result>.ModeHandler {
        public c(a aVar) {
            super(GameRequestDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(Object obj, boolean z) {
            GameRequestContent gameRequestContent = (GameRequestContent) obj;
            if (CustomTabUtils.getChromePackage() != null) {
                GameRequestDialog gameRequestDialog = GameRequestDialog.this;
                int i = GameRequestDialog.e;
                if (Validate.hasCustomTabRedirectActivity(gameRequestDialog.getActivityContext(), CustomTabUtils.getDefaultRedirectURI())) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(Object obj) {
            GameRequestContent gameRequestContent = (GameRequestContent) obj;
            GameRequestValidation.validate(gameRequestContent);
            AppCall createBaseAppCall = GameRequestDialog.this.createBaseAppCall();
            Bundle create = WebDialogParameters.create(gameRequestContent);
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (currentAccessToken != null) {
                create.putString("app_id", currentAccessToken.getApplicationId());
            } else {
                create.putString("app_id", FacebookSdk.getApplicationId());
            }
            create.putString("redirect_uri", CustomTabUtils.getDefaultRedirectURI());
            DialogPresenter.setupAppCallForCustomTabDialog(createBaseAppCall, "apprequests", create);
            return createBaseAppCall;
        }
    }

    public class d extends FacebookDialogBase<GameRequestContent, Result>.ModeHandler {
        public d(a aVar) {
            super(GameRequestDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ boolean canShow(Object obj, boolean z) {
            GameRequestContent gameRequestContent = (GameRequestContent) obj;
            return true;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(Object obj) {
            GameRequestContent gameRequestContent = (GameRequestContent) obj;
            GameRequestValidation.validate(gameRequestContent);
            AppCall createBaseAppCall = GameRequestDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, "apprequests", WebDialogParameters.create(gameRequestContent));
            return createBaseAppCall;
        }
    }

    public GameRequestDialog(Activity activity) {
        super(activity, e);
    }

    public static boolean canShow() {
        return true;
    }

    public static void show(Activity activity, GameRequestContent gameRequestContent) {
        new GameRequestDialog(activity).show(gameRequestContent);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public List<FacebookDialogBase<GameRequestContent, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c(null));
        arrayList.add(new d(null));
        return arrayList;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        callbackManagerImpl.registerCallback(getRequestCode(), new b(facebookCallback == null ? null : new a(this, facebookCallback, facebookCallback)));
    }

    public GameRequestDialog(Fragment fragment) {
        super(new FragmentWrapper(fragment), e);
    }

    public static void show(Fragment fragment, GameRequestContent gameRequestContent) {
        new GameRequestDialog(new FragmentWrapper(fragment)).show(gameRequestContent);
    }

    public GameRequestDialog(android.app.Fragment fragment) {
        super(new FragmentWrapper(fragment), e);
    }

    public static void show(android.app.Fragment fragment, GameRequestContent gameRequestContent) {
        new GameRequestDialog(new FragmentWrapper(fragment)).show(gameRequestContent);
    }

    public GameRequestDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, e);
    }
}
