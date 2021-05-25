package com.avito.android.remote.model.service_subscription_legacy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface SubscriptionStatus {
    public static final String ACTIVE = "active";
    public static final String SUSPENDED = "suspended";
}
