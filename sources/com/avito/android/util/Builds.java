package com.avito.android.util;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0016\u0010\u0001\u001a\u00020\u00008\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "isAtLeastMarshmallow", "Z", "android_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Builds")
public final class Builds {
    @JvmField
    public static final boolean isAtLeastMarshmallow = (Build.VERSION.SDK_INT >= 23);
}
