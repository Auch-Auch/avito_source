package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import androidx.annotation.RecentlyNonNull;
public class ResolvableApiException extends ApiException {
    public ResolvableApiException(@RecentlyNonNull Status status) {
        super(status);
    }

    @RecentlyNonNull
    public PendingIntent getResolution() {
        return getStatus().getResolution();
    }

    public void startResolutionForResult(@RecentlyNonNull Activity activity, @RecentlyNonNull int i) throws IntentSender.SendIntentException {
        getStatus().startResolutionForResult(activity, i);
    }
}
