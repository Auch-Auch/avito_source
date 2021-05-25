package com.avito.android.messenger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface ChannelStatus {
    public static final int DELETED = 2;
    public static final int REFRESH = 4;
    public static final int UNKNOWN = 0;
    public static final int UPDATED = 1;
    public static final int USER_BLOCKED = 3;
}
