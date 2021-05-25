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
import java.util.ArrayList;
import java.util.List;
@Deprecated
public class JoinAppGroupDialog extends FacebookDialogBase<String, Result> {
    public static final int e = CallbackManagerImpl.RequestCodeOffset.AppGroupJoin.toRequestCode();

    @Deprecated
    public static final class Result {
        public final Bundle a;

        public Result(Bundle bundle, a aVar) {
            this.a = bundle;
        }

        public Bundle getData() {
            return this.a;
        }
    }

    public class a extends ResultProcessor {
        public final /* synthetic */ FacebookCallback b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(JoinAppGroupDialog joinAppGroupDialog, FacebookCallback facebookCallback, FacebookCallback facebookCallback2) {
            super(facebookCallback);
            this.b = facebookCallback2;
        }

        @Override // com.facebook.share.internal.ResultProcessor
        public void onSuccess(AppCall appCall, Bundle bundle) {
            this.b.onSuccess(new Result(bundle, null));
        }
    }

    public class b implements CallbackManagerImpl.Callback {
        public final /* synthetic */ ResultProcessor a;

        public b(ResultProcessor resultProcessor) {
            this.a = resultProcessor;
        }

        @Override // com.facebook.internal.CallbackManagerImpl.Callback
        public boolean onActivityResult(int i, Intent intent) {
            return ShareInternalUtility.handleActivityResult(JoinAppGroupDialog.this.getRequestCode(), i, intent, this.a);
        }
    }

    public class c extends FacebookDialogBase<String, Result>.ModeHandler {
        public c(a aVar) {
            super(JoinAppGroupDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public /* bridge */ /* synthetic */ boolean canShow(Object obj, boolean z) {
            String str = (String) obj;
            return true;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(Object obj) {
            AppCall createBaseAppCall = JoinAppGroupDialog.this.createBaseAppCall();
            Bundle bundle = new Bundle();
            bundle.putString("id", (String) obj);
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, "game_group_join", bundle);
            return createBaseAppCall;
        }
    }

    @Deprecated
    public JoinAppGroupDialog(Activity activity) {
        super(activity, e);
    }

    @Deprecated
    public static boolean canShow() {
        return true;
    }

    @Deprecated
    public static void show(Activity activity, String str) {
        new JoinAppGroupDialog(activity).show(str);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public List<FacebookDialogBase<String, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c(null));
        return arrayList;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        callbackManagerImpl.registerCallback(getRequestCode(), new b(facebookCallback == null ? null : new a(this, facebookCallback, facebookCallback)));
    }

    @Deprecated
    public JoinAppGroupDialog(Fragment fragment) {
        super(new FragmentWrapper(fragment), e);
    }

    @Deprecated
    public static void show(Fragment fragment, String str) {
        new JoinAppGroupDialog(new FragmentWrapper(fragment)).show(str);
    }

    @Deprecated
    public JoinAppGroupDialog(android.app.Fragment fragment) {
        super(new FragmentWrapper(fragment), e);
    }

    @Deprecated
    public static void show(android.app.Fragment fragment, String str) {
        new JoinAppGroupDialog(new FragmentWrapper(fragment)).show(str);
    }

    public JoinAppGroupDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, e);
    }
}
