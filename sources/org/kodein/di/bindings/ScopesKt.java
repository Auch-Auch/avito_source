package org.kodein.di.bindings;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.KodeinContext;
import org.kodein.di.TypeToken;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a7\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006*\f\b\u0002\u0010\b\"\u00020\u00072\u00020\u0007¨\u0006\t"}, d2 = {"C", ExifInterface.LATITUDE_SOUTH, "Lorg/kodein/di/bindings/ContextTranslator;", "ctx", "Lorg/kodein/di/KodeinContext;", "toKContext", "(Lorg/kodein/di/bindings/ContextTranslator;Ljava/lang/Object;)Lorg/kodein/di/KodeinContext;", "", "RegKey", "kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class ScopesKt {
    @NotNull
    public static final <C, S> KodeinContext<S> toKContext(@NotNull ContextTranslator<? super C, S> contextTranslator, C c) {
        Intrinsics.checkParameterIsNotNull(contextTranslator, "$this$toKContext");
        return KodeinContext.Companion.invoke(contextTranslator.getScopeType(), (TypeToken<? super S>) contextTranslator.translate(c));
    }
}
