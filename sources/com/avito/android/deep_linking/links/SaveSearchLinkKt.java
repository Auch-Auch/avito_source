package com.avito.android.deep_linking.links;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"models_release"}, k = 2, mv = {1, 4, 2})
public final class SaveSearchLinkKt {
    public static final String access$get(Uri uri, String str) {
        Intrinsics.checkNotNullParameter(uri, "$this$get");
        return uri.getQueryParameter(str);
    }
}
