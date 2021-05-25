package com.otaliastudios.opengl.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0006\"\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/otaliastudios/opengl/core/GlBindable;", "Lkotlin/Function0;", "", "block", "use", "(Lcom/otaliastudios/opengl/core/GlBindable;Lkotlin/jvm/functions/Function0;)V", "", "bindables", "([Lcom/otaliastudios/opengl/core/GlBindable;Lkotlin/jvm/functions/Function0;)V", "egloo-metadata_release"}, k = 2, mv = {1, 4, 0})
public final class GlBindableKt {
    public static final void use(@NotNull GlBindable glBindable, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(glBindable, "$this$use");
        Intrinsics.checkNotNullParameter(function0, "block");
        glBindable.bind();
        function0.invoke();
        glBindable.unbind();
    }

    public static final void use(@NotNull GlBindable[] glBindableArr, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(glBindableArr, "bindables");
        Intrinsics.checkNotNullParameter(function0, "block");
        for (GlBindable glBindable : glBindableArr) {
            glBindable.bind();
        }
        function0.invoke();
        for (GlBindable glBindable2 : glBindableArr) {
            glBindable2.unbind();
        }
    }
}
