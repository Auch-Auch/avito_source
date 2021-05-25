package com.facebook.share.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.internal.AppInviteDialogFeature;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.AppInviteContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
public class AppInviteDialog extends FacebookDialogBase<AppInviteContent, Result> {
    public static final int e = CallbackManagerImpl.RequestCodeOffset.AppInvite.toRequestCode();

    @Deprecated
    public static final class Result {
        public final Bundle a;

        public Result(Bundle bundle) {
            this.a = bundle;
        }

        public Bundle getData() {
            return this.a;
        }
    }

    public class a extends ResultProcessor {
        public final /* synthetic */ FacebookCallback b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AppInviteDialog appInviteDialog, FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
            super(facebookCallback);
            this.b = facebookCallback2;
        }

        @Override // com.facebook.share.internal.ResultProcessor
        public void onSuccess(AppCall appCall, Bundle bundle) {
            if ("cancel".equalsIgnoreCase(ShareInternalUtility.getNativeDialogCompletionGesture(bundle))) {
                this.b.onCancel();
            } else {
                this.b.onSuccess(new Result(bundle));
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
            return ShareInternalUtility.handleActivityResult(AppInviteDialog.this.getRequestCode(), i, intent, this.a);
        }
    }

    public class c extends FacebookDialogBase<AppInviteContent, Result>.ModeHandler {
        public c(a aVar) {
            super(AppInviteDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ boolean canShow(Object obj, boolean z) {
            AppInviteContent appInviteContent = (AppInviteContent) obj;
            return false;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(Object obj) {
            AppCall createBaseAppCall = AppInviteDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new a2.g.v.m.a(this, (AppInviteContent) obj), AppInviteDialogFeature.APP_INVITES_DIALOG);
            return createBaseAppCall;
        }
    }

    public class d extends FacebookDialogBase<AppInviteContent, Result>.ModeHandler {
        public d(a aVar) {
            super(AppInviteDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ boolean canShow(Object obj, boolean z) {
            AppInviteContent appInviteContent = (AppInviteContent) obj;
            return false;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(Object obj) {
            AppCall createBaseAppCall = AppInviteDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebFallbackDialog(createBaseAppCall, AppInviteDialog.a((AppInviteContent) obj), AppInviteDialogFeature.APP_INVITES_DIALOG);
            return createBaseAppCall;
        }
    }

    @Deprecated
    public AppInviteDialog(Activity activity) {
        super(activity, e);
    }

    public static Bundle a(AppInviteContent appInviteContent) {
        Bundle bundle = new Bundle();
        bundle.putString(ShareConstants.APPLINK_URL, appInviteContent.getApplinkUrl());
        bundle.putString(ShareConstants.PREVIEW_IMAGE_URL, appInviteContent.getPreviewImageUrl());
        bundle.putString("destination", appInviteContent.getDestination().toString());
        String promotionCode = appInviteContent.getPromotionCode();
        if (promotionCode == null) {
            promotionCode = "";
        }
        String promotionText = appInviteContent.getPromotionText();
        if (!TextUtils.isEmpty(promotionText)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ShareConstants.PROMO_CODE, promotionCode);
                jSONObject.put(ShareConstants.PROMO_TEXT, promotionText);
                bundle.putString(ShareConstants.DEEPLINK_CONTEXT, jSONObject.toString());
                bundle.putString(ShareConstants.PROMO_CODE, promotionCode);
                bundle.putString(ShareConstants.PROMO_TEXT, promotionText);
            } catch (JSONException unused) {
            }
        }
        return bundle;
    }

    @Deprecated
    public static boolean canShow() {
        return false;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public List<FacebookDialogBase<AppInviteContent, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c(null));
        arrayList.add(new d(null));
        return arrayList;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        callbackManagerImpl.registerCallback(getRequestCode(), new b(facebookCallback == null ? null : new a(this, facebookCallback, facebookCallback)));
    }

    @Deprecated
    public void show(AppInviteContent appInviteContent) {
    }

    @Deprecated
    public AppInviteDialog(Fragment fragment) {
        super(new FragmentWrapper(fragment), e);
    }

    @Deprecated
    public static void show(Activity activity, AppInviteContent appInviteContent) {
        new AppInviteDialog(activity).show(appInviteContent);
    }

    @Deprecated
    public static void show(Fragment fragment, AppInviteContent appInviteContent) {
        new AppInviteDialog(new FragmentWrapper(fragment)).show(appInviteContent);
    }

    @Deprecated
    public AppInviteDialog(android.app.Fragment fragment) {
        super(new FragmentWrapper(fragment), e);
    }

    @Deprecated
    public static void show(android.app.Fragment fragment, AppInviteContent appInviteContent) {
        new AppInviteDialog(new FragmentWrapper(fragment)).show(appInviteContent);
    }

    public AppInviteDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, e);
    }
}
