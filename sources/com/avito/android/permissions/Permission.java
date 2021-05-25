package com.avito.android.permissions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Retention(RetentionPolicy.SOURCE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/permissions/Permission;", "", "<init>", "()V", "Companion", "permissions_release"}, k = 1, mv = {1, 4, 2})
public @interface Permission {
    @NotNull
    public static final String CALL_PHONE = "android.permission.CALL_PHONE";
    @NotNull
    public static final String CAMERA = "android.permission.CAMERA";
    @NotNull
    public static final String COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";
    @NotNull
    public static final Companion Companion = Companion.a;
    @NotNull
    public static final String FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    @NotNull
    public static final String READ_CALL_LOG = "android.permission.READ_CALL_LOG";
    @NotNull
    public static final String RECORD_AUDIO = "android.permission.RECORD_AUDIO";
    @NotNull
    public static final String STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/avito/android/permissions/Permission$Companion;", "", "", "COARSE_LOCATION", "Ljava/lang/String;", "FINE_LOCATION", "CALL_PHONE", "STORAGE", "RECORD_AUDIO", "READ_CALL_LOG", "CAMERA", "<init>", "()V", "permissions_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        @NotNull
        public static final String CALL_PHONE = "android.permission.CALL_PHONE";
        @NotNull
        public static final String CAMERA = "android.permission.CAMERA";
        @NotNull
        public static final String COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";
        @NotNull
        public static final String FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
        @NotNull
        public static final String READ_CALL_LOG = "android.permission.READ_CALL_LOG";
        @NotNull
        public static final String RECORD_AUDIO = "android.permission.RECORD_AUDIO";
        @NotNull
        public static final String STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
        public static final /* synthetic */ Companion a = new Companion();
    }
}
