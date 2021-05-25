package com.facebook.share.widget;

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
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.AppGroupCreationContent;
import java.util.ArrayList;
import java.util.List;
@Deprecated
public class CreateAppGroupDialog extends FacebookDialogBase<AppGroupCreationContent, Result> {
    public static final int e = CallbackManagerImpl.RequestCodeOffset.AppGroupCreate.toRequestCode();

    @Deprecated
    public static final class Result {
        public final String a;

        public Result(String str, a aVar) {
            this.a = str;
        }

        public String getId() {
            return this.a;
        }
    }

    public class a extends ResultProcessor {
        public final /* synthetic */ FacebookCallback b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CreateAppGroupDialog createAppGroupDialog, FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
            super(facebookCallback);
            this.b = facebookCallback2;
        }

        @Override // com.facebook.share.internal.ResultProcessor
        public void onSuccess(AppCall appCall, Bundle bundle) {
            this.b.onSuccess(new Result(bundle.getString("id"), null));
        }
    }

    public class b implements CallbackManagerImpl.Callback {
        public final /* synthetic */ ResultProcessor a;

        public b(ResultProcessor resultProcessor) {
            this.a = resultProcessor;
        }

        @Override // com.facebook.internal.CallbackManagerImpl.Callback
        public boolean onActivityResult(int i, Intent intent) {
            return ShareInternalUtility.handleActivityResult(CreateAppGroupDialog.this.getRequestCode(), i, intent, this.a);
        }
    }

    public class c extends FacebookDialogBase<AppGroupCreationContent, Result>.ModeHandler {
        public c(a aVar) {
            super(CreateAppGroupDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ boolean canShow(Object obj, boolean z) {
            AppGroupCreationContent appGroupCreationContent = (AppGroupCreationContent) obj;
            return true;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(Object obj) {
            AppCall createBaseAppCall = CreateAppGroupDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, "game_group_create", WebDialogParameters.create((AppGroupCreationContent) obj));
            return createBaseAppCall;
        }
    }

    @Deprecated
    public CreateAppGroupDialog(Activity activity) {
        super(activity, e);
    }

    @Deprecated
    public static boolean canShow() {
        return true;
    }

    @Deprecated
    public static void show(Activity activity, AppGroupCreationContent appGroupCreationContent) {
        new CreateAppGroupDialog(activity).show(appGroupCreationContent);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public List<FacebookDialogBase<AppGroupCreationContent, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c(null));
        return arrayList;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        callbackManagerImpl.registerCallback(getRequestCode(), new b(facebookCallback == null ? null : new a(this, facebookCallback, facebookCallback)));
    }

    @Deprecated
    public CreateAppGroupDialog(Fragment fragment) {
        super(new FragmentWrapper(fragment), e);
    }

    @Deprecated
    public static void show(Fragment fragment, AppGroupCreationContent appGroupCreationContent) {
        new CreateAppGroupDialog(new FragmentWrapper(fragment)).show(appGroupCreationContent);
    }

    @Deprecated
    public CreateAppGroupDialog(android.app.Fragment fragment) {
        super(new FragmentWrapper(fragment), e);
    }

    @Deprecated
    public static void show(android.app.Fragment fragment, AppGroupCreationContent appGroupCreationContent) {
        new CreateAppGroupDialog(new FragmentWrapper(fragment)).show(appGroupCreationContent);
    }

    public CreateAppGroupDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, e);
    }
}
