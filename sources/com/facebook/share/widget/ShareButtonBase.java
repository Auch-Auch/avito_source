package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;
public abstract class ShareButtonBase extends FacebookButtonBase {
    public static final /* synthetic */ int m = 0;
    public ShareContent j;
    public int k = 0;
    public boolean l = false;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShareButtonBase shareButtonBase = ShareButtonBase.this;
            int i = ShareButtonBase.m;
            shareButtonBase.callExternalOnClickListener(view);
            ShareButtonBase.this.getDialog().show(ShareButtonBase.this.getShareContent());
        }
    }

    public ShareButtonBase(Context context, AttributeSet attributeSet, int i, String str, String str2) {
        super(context, attributeSet, i, 0, str, str2);
        this.k = isInEditMode() ? 0 : getDefaultRequestCode();
        setEnabled(false);
        this.l = false;
    }

    public boolean canShare() {
        return getDialog().canShow(getShareContent());
    }

    @Override // com.facebook.FacebookButtonBase
    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super.configureButton(context, attributeSet, i, i2);
        setInternalOnClickListener(getShareOnClickListener());
    }

    public abstract FacebookDialogBase<ShareContent, Sharer.Result> getDialog();

    @Override // com.facebook.FacebookButtonBase
    public int getRequestCode() {
        return this.k;
    }

    public ShareContent getShareContent() {
        return this.j;
    }

    public View.OnClickListener getShareOnClickListener() {
        return new a();
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<Sharer.Result> facebookCallback) {
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManager, facebookCallback);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.l = true;
    }

    public void setRequestCode(int i) {
        if (!FacebookSdk.isFacebookRequestCode(i)) {
            this.k = i;
            return;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Request code ", i, " cannot be within the range reserved by the Facebook SDK."));
    }

    public void setShareContent(ShareContent shareContent) {
        this.j = shareContent;
        if (!this.l) {
            setEnabled(canShare());
            this.l = false;
        }
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<Sharer.Result> facebookCallback, int i) {
        setRequestCode(i);
        registerCallback(callbackManager, facebookCallback);
    }
}
