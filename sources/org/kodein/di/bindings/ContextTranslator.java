package org.kodein.di.bindings;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.TypeToken;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0017\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lorg/kodein/di/bindings/ContextTranslator;", "C", ExifInterface.LATITUDE_SOUTH, "", "ctx", "translate", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lorg/kodein/di/TypeToken;", "getScopeType", "()Lorg/kodein/di/TypeToken;", "scopeType", "getContextType", "contextType", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface ContextTranslator<C, S> {
    @NotNull
    TypeToken<? super C> getContextType();

    @NotNull
    TypeToken<? super S> getScopeType();

    S translate(C c);
}
