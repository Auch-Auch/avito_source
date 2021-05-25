package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.DeviceShareDialog;
import com.facebook.share.R;
import com.facebook.share.model.ShareContent;
@Deprecated
public final class DeviceShareButton extends FacebookButtonBase {
    public static final /* synthetic */ int n = 0;
    public ShareContent j;
    public int k;
    public boolean l;
    public DeviceShareDialog m;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DeviceShareButton deviceShareButton = DeviceShareButton.this;
            int i = DeviceShareButton.n;
            deviceShareButton.callExternalOnClickListener(view);
            DeviceShareButton.this.getDialog().show(DeviceShareButton.this.getShareContent());
        }
    }

    public DeviceShareButton(Context context) {
        this(context, null, 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private DeviceShareDialog getDialog() {
        DeviceShareDialog deviceShareDialog = this.m;
        if (deviceShareDialog != null) {
            return deviceShareDialog;
        }
        if (getFragment() != null) {
            this.m = new DeviceShareDialog(getFragment());
        } else if (getNativeFragment() != null) {
            this.m = new DeviceShareDialog(getNativeFragment());
        } else {
            this.m = new DeviceShareDialog(getActivity());
        }
        return this.m;
    }

    private void setRequestCode(int i) {
        if (!FacebookSdk.isFacebookRequestCode(i)) {
            this.k = i;
            return;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Request code ", i, " cannot be within the range reserved by the Facebook SDK."));
    }

    @Override // com.facebook.FacebookButtonBase
    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super.configureButton(context, attributeSet, i, i2);
        setInternalOnClickListener(getShareOnClickListener());
    }

    @Override // com.facebook.FacebookButtonBase
    public int getDefaultRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
    }

    @Override // com.facebook.FacebookButtonBase
    public int getDefaultStyleResource() {
        return R.style.com_facebook_button_share;
    }

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

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<DeviceShareDialog.Result> facebookCallback) {
        getDialog().registerCallback(callbackManager, facebookCallback);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.l = true;
    }

    public void setShareContent(ShareContent shareContent) {
        this.j = shareContent;
        if (!this.l) {
            setEnabled(new DeviceShareDialog(getActivity()).canShow(getShareContent()));
            this.l = false;
        }
    }

    public DeviceShareButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<DeviceShareDialog.Result> facebookCallback, int i) {
        setRequestCode(i);
        getDialog().registerCallback(callbackManager, facebookCallback, i);
    }

    public DeviceShareButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0, AnalyticsEvents.EVENT_DEVICE_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_DEVICE_SHARE_BUTTON_DID_TAP);
        this.k = 0;
        this.l = false;
        this.m = null;
        this.k = isInEditMode() ? 0 : getDefaultRequestCode();
        setEnabled(false);
        this.l = false;
    }
}
