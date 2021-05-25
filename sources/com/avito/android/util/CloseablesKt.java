package com.avito.android.util;

import com.vk.sdk.api.VKApiConst;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ljava/io/Closeable;", "", "closeQuiet", "(Ljava/io/Closeable;)V", VKApiConst.LANG}, k = 2, mv = {1, 4, 2})
public final class CloseablesKt {
    public static final void closeQuiet(@NotNull Closeable closeable) {
        Intrinsics.checkNotNullParameter(closeable, "$this$closeQuiet");
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }
}
