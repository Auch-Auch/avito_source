package com.facebook.internal;

import a2.b.a.a.a;
import android.app.Activity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.util.Iterator;
import java.util.List;
public abstract class FacebookDialogBase<CONTENT, RESULT> implements FacebookDialog<CONTENT, RESULT> {
    public static final Object BASE_AUTOMATIC_MODE = new Object();
    public final Activity a;
    public final FragmentWrapper b;
    public List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> c;
    public int d;

    public abstract class ModeHandler {
        public ModeHandler(FacebookDialogBase facebookDialogBase) {
        }

        /* JADX WARN: Failed to parse method signature: (TCONTENTZ)Z */
        public abstract boolean canShow(Object obj, boolean z);

        /* JADX WARN: Failed to parse method signature: (TCONTENT)Lcom/facebook/internal/AppCall; */
        public abstract AppCall createAppCall(Object obj);

        public Object getMode() {
            return FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }
    }

    public FacebookDialogBase(Activity activity, int i) {
        Validate.notNull(activity, "activity");
        this.a = activity;
        this.b = null;
        this.d = i;
    }

    @Override // com.facebook.FacebookDialog
    public boolean canShow(CONTENT content) {
        return canShowImpl(content, BASE_AUTOMATIC_MODE);
    }

    public boolean canShowImpl(CONTENT content, Object obj) {
        boolean z = obj == BASE_AUTOMATIC_MODE;
        if (this.c == null) {
            this.c = getOrderedModeHandlers();
        }
        for (FacebookDialogBase<CONTENT, RESULT>.ModeHandler modeHandler : this.c) {
            if (z || Utility.areObjectsEqual(modeHandler.getMode(), obj)) {
                if (modeHandler.canShow(content, false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public abstract AppCall createBaseAppCall();

    public Activity getActivityContext() {
        Activity activity = this.a;
        if (activity != null) {
            return activity;
        }
        FragmentWrapper fragmentWrapper = this.b;
        if (fragmentWrapper != null) {
            return fragmentWrapper.getActivity();
        }
        return null;
    }

    public abstract List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> getOrderedModeHandlers();

    public int getRequestCode() {
        return this.d;
    }

    @Override // com.facebook.FacebookDialog
    public final void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            registerCallbackImpl((CallbackManagerImpl) callbackManager, facebookCallback);
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public abstract void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<RESULT> facebookCallback);

    public void setRequestCode(int i) {
        if (!FacebookSdk.isFacebookRequestCode(i)) {
            this.d = i;
            return;
        }
        throw new IllegalArgumentException(a.Q2("Request code ", i, " cannot be within the range reserved by the Facebook SDK."));
    }

    @Override // com.facebook.FacebookDialog
    public void show(CONTENT content) {
        showImpl(content, BASE_AUTOMATIC_MODE);
    }

    public void showImpl(CONTENT content, Object obj) {
        boolean z = obj == BASE_AUTOMATIC_MODE;
        AppCall appCall = null;
        if (this.c == null) {
            this.c = getOrderedModeHandlers();
        }
        Iterator<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            FacebookDialogBase<CONTENT, RESULT>.ModeHandler next = it.next();
            if (z || Utility.areObjectsEqual(next.getMode(), obj)) {
                if (next.canShow(content, true)) {
                    try {
                        appCall = next.createAppCall(content);
                        break;
                    } catch (FacebookException e) {
                        appCall = createBaseAppCall();
                        DialogPresenter.setupAppCallForValidationError(appCall, e);
                    }
                }
            }
        }
        if (appCall == null) {
            appCall = createBaseAppCall();
            DialogPresenter.setupAppCallForCannotShowError(appCall);
        }
        if (appCall != null) {
            FragmentWrapper fragmentWrapper = this.b;
            if (fragmentWrapper != null) {
                DialogPresenter.present(appCall, fragmentWrapper);
            } else {
                DialogPresenter.present(appCall, this.a);
            }
        } else if (FacebookSdk.isDebugEnabled()) {
            throw new IllegalStateException("No code path should ever result in a null appCall");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startActivityForResult(android.content.Intent r3, int r4) {
        /*
            r2 = this;
            android.app.Activity r0 = r2.a
            java.lang.String r1 = "Failed to find Activity or Fragment to startActivityForResult "
            if (r0 == 0) goto L_0x000a
            r0.startActivityForResult(r3, r4)
            goto L_0x002f
        L_0x000a:
            com.facebook.internal.FragmentWrapper r0 = r2.b
            if (r0 == 0) goto L_0x0030
            android.app.Fragment r0 = r0.getNativeFragment()
            if (r0 == 0) goto L_0x001e
            com.facebook.internal.FragmentWrapper r0 = r2.b
            android.app.Fragment r0 = r0.getNativeFragment()
            r0.startActivityForResult(r3, r4)
            goto L_0x002f
        L_0x001e:
            com.facebook.internal.FragmentWrapper r0 = r2.b
            androidx.fragment.app.Fragment r0 = r0.getSupportFragment()
            if (r0 == 0) goto L_0x0030
            com.facebook.internal.FragmentWrapper r0 = r2.b
            androidx.fragment.app.Fragment r0 = r0.getSupportFragment()
            r0.startActivityForResult(r3, r4)
        L_0x002f:
            r1 = 0
        L_0x0030:
            if (r1 == 0) goto L_0x0040
            com.facebook.LoggingBehavior r3 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            r4 = 6
            java.lang.Class r0 = r2.getClass()
            java.lang.String r0 = r0.getName()
            com.facebook.internal.Logger.log(r3, r4, r0, r1)
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FacebookDialogBase.startActivityForResult(android.content.Intent, int):void");
    }

    @Override // com.facebook.FacebookDialog
    public final void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> facebookCallback, int i) {
        setRequestCode(i);
        registerCallback(callbackManager, facebookCallback);
    }

    public FacebookDialogBase(FragmentWrapper fragmentWrapper, int i) {
        Validate.notNull(fragmentWrapper, "fragmentWrapper");
        this.b = fragmentWrapper;
        this.a = null;
        this.d = i;
        if (fragmentWrapper.getActivity() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity");
        }
    }
}
