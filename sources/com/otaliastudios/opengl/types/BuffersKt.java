package com.otaliastudios.opengl.types;

import java.nio.Buffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ljava/nio/Buffer;", "Lcom/otaliastudios/opengl/types/Buffer;", "", "dispose", "(Ljava/nio/Buffer;)V", "egloo-metadata_release"}, k = 2, mv = {1, 4, 0})
public final class BuffersKt {
    public static final void dispose(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$dispose");
        if (buffer instanceof Disposable) {
            ((Disposable) buffer).dispose();
        }
    }
}
