package com.avito.android.remote.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface ValidateVersionStatus {
    public static final int DEVICE_NOT_SUPPORTED = 4;
    public static final int NO_UPDATE = 0;
    public static final int UPDATE_DEVICE_WARNING = 3;
    public static final int UPDATE_PROPOSAL = 1;
    public static final int UPDATE_REQUIRED = 2;
}
