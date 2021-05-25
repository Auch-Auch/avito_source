package com.avito.android.remote.model.user_profile;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface SubscriptionStatus {
    public static final String ACTIVE = "active";
    public static final String PAUSED = "paused";
}
