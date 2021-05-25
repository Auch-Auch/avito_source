package com.avito.android.util;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"application_release"}, k = 2, mv = {1, 4, 2})
public final class DiskSpaceAnalyticsTraverserKt {
    public static final String access$getName(File file, String str, Regex regex) {
        String canonicalPath = file.getCanonicalPath();
        Intrinsics.checkNotNullExpressionValue(canonicalPath, "this.canonicalPath");
        return regex.replace(StringsKt__StringsKt.removePrefix(canonicalPath, (CharSequence) (str + File.separator)), "_");
    }
}
