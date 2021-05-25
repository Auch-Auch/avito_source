package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.AppCall;
public abstract class ResultProcessor {
    public FacebookCallback a;

    public ResultProcessor(FacebookCallback facebookCallback) {
        this.a = facebookCallback;
    }

    public void onCancel(AppCall appCall) {
        FacebookCallback facebookCallback = this.a;
        if (facebookCallback != null) {
            facebookCallback.onCancel();
        }
    }

    public void onError(AppCall appCall, FacebookException facebookException) {
        FacebookCallback facebookCallback = this.a;
        if (facebookCallback != null) {
            facebookCallback.onError(facebookException);
        }
    }

    public abstract void onSuccess(AppCall appCall, Bundle bundle);
}
