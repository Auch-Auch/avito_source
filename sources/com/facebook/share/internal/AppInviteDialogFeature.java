package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.facebook.internal.NativeProtocol;
public enum AppInviteDialogFeature implements DialogFeature {
    APP_INVITES_DIALOG(NativeProtocol.PROTOCOL_VERSION_20140701);
    
    public int a;

    /* access modifiers changed from: public */
    AppInviteDialogFeature(int i) {
        this.a = i;
    }

    @Override // com.facebook.internal.DialogFeature
    public String getAction() {
        return NativeProtocol.ACTION_APPINVITE_DIALOG;
    }

    @Override // com.facebook.internal.DialogFeature
    public int getMinVersion() {
        return this.a;
    }
}
