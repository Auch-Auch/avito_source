package com.facebook.share.internal;

import a2.g.v.l.k;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import java.util.ArrayList;
import java.util.List;
@Deprecated
public class LikeDialog extends FacebookDialogBase<LikeContent, Result> {
    public static final int e = CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode();

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
        public a(LikeDialog likeDialog, FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
            super(facebookCallback);
            this.b = facebookCallback2;
        }

        @Override // com.facebook.share.internal.ResultProcessor
        public void onSuccess(AppCall appCall, Bundle bundle) {
            this.b.onSuccess(new Result(bundle));
        }
    }

    public class b implements CallbackManagerImpl.Callback {
        public final /* synthetic */ ResultProcessor a;

        public b(ResultProcessor resultProcessor) {
            this.a = resultProcessor;
        }

        @Override // com.facebook.internal.CallbackManagerImpl.Callback
        public boolean onActivityResult(int i, Intent intent) {
            return ShareInternalUtility.handleActivityResult(LikeDialog.this.getRequestCode(), i, intent, this.a);
        }
    }

    public class c extends FacebookDialogBase<LikeContent, Result>.ModeHandler {
        public c(a aVar) {
            super(LikeDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ boolean canShow(Object obj, boolean z) {
            LikeContent likeContent = (LikeContent) obj;
            return false;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(Object obj) {
            AppCall createBaseAppCall = LikeDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new k(this, (LikeContent) obj), LikeDialogFeature.LIKE_DIALOG);
            return createBaseAppCall;
        }
    }

    public class d extends FacebookDialogBase<LikeContent, Result>.ModeHandler {
        public d(a aVar) {
            super(LikeDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ boolean canShow(Object obj, boolean z) {
            LikeContent likeContent = (LikeContent) obj;
            return false;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(Object obj) {
            AppCall createBaseAppCall = LikeDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebFallbackDialog(createBaseAppCall, LikeDialog.a((LikeContent) obj), LikeDialogFeature.LIKE_DIALOG);
            return createBaseAppCall;
        }
    }

    @Deprecated
    public LikeDialog(Activity activity) {
        super(activity, e);
    }

    public static Bundle a(LikeContent likeContent) {
        Bundle bundle = new Bundle();
        bundle.putString("object_id", likeContent.getObjectId());
        bundle.putString("object_type", likeContent.getObjectType());
        return bundle;
    }

    @Deprecated
    public static boolean canShowNativeDialog() {
        return false;
    }

    @Deprecated
    public static boolean canShowWebFallback() {
        return false;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public List<FacebookDialogBase<LikeContent, Result>.ModeHandler> getOrderedModeHandlers() {
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
    public void show(LikeContent likeContent) {
    }

    @Deprecated
    public LikeDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    @Deprecated
    public LikeDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    @Deprecated
    public LikeDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, e);
    }
}
