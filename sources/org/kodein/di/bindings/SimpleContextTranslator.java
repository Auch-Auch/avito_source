package org.kodein.di.bindings;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.TypeToken;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003BJ\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n\u0012\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\n\u0012!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00028\u00010\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR$\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR1\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00028\u00010\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lorg/kodein/di/bindings/SimpleContextTranslator;", "C", ExifInterface.LATITUDE_SOUTH, "Lorg/kodein/di/bindings/ContextTranslator;", "ctx", "translate", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lorg/kodein/di/TypeToken;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/TypeToken;", "getContextType", "()Lorg/kodein/di/TypeToken;", "contextType", AuthSource.BOOKING_ORDER, "getScopeType", "scopeType", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "c", "Lkotlin/jvm/functions/Function1;", "t", "<init>", "(Lorg/kodein/di/TypeToken;Lorg/kodein/di/TypeToken;Lkotlin/jvm/functions/Function1;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class SimpleContextTranslator<C, S> implements ContextTranslator<C, S> {
    @NotNull
    public final TypeToken<? super C> a;
    @NotNull
    public final TypeToken<? super S> b;
    public final Function1<C, S> c;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super C, ? extends S> */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleContextTranslator(@NotNull TypeToken<? super C> typeToken, @NotNull TypeToken<? super S> typeToken2, @NotNull Function1<? super C, ? extends S> function1) {
        Intrinsics.checkParameterIsNotNull(typeToken, "contextType");
        Intrinsics.checkParameterIsNotNull(typeToken2, "scopeType");
        Intrinsics.checkParameterIsNotNull(function1, "t");
        this.a = typeToken;
        this.b = typeToken2;
        this.c = function1;
    }

    @Override // org.kodein.di.bindings.ContextTranslator
    @NotNull
    public TypeToken<? super C> getContextType() {
        return this.a;
    }

    @Override // org.kodein.di.bindings.ContextTranslator
    @NotNull
    public TypeToken<? super S> getScopeType() {
        return this.b;
    }

    @NotNull
    public String toString() {
        return "()";
    }

    @Override // org.kodein.di.bindings.ContextTranslator
    public S translate(C c2) {
        return this.c.invoke(c2);
    }
}
