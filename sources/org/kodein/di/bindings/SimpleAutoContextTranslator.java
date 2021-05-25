package org.kodein.di.bindings;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.TypeToken;
import org.kodein.di.TypeTokenKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00028\u00000\u0002B%\u0012\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0005\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0015\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\f¨\u0006\u0018"}, d2 = {"Lorg/kodein/di/bindings/SimpleAutoContextTranslator;", ExifInterface.LATITUDE_SOUTH, "Lorg/kodein/di/bindings/ContextTranslator;", "", "ctx", "translate", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lorg/kodein/di/TypeToken;", "getContextType", "()Lorg/kodein/di/TypeToken;", "contextType", "Lkotlin/Function0;", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "t", AuthSource.SEND_ABUSE, "Lorg/kodein/di/TypeToken;", "getScopeType", "scopeType", "<init>", "(Lorg/kodein/di/TypeToken;Lkotlin/jvm/functions/Function0;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class SimpleAutoContextTranslator<S> implements ContextTranslator<Object, S> {
    @NotNull
    public final TypeToken<? super S> a;
    public final Function0<S> b;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function0<? extends S> */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleAutoContextTranslator(@NotNull TypeToken<? super S> typeToken, @NotNull Function0<? extends S> function0) {
        Intrinsics.checkParameterIsNotNull(typeToken, "scopeType");
        Intrinsics.checkParameterIsNotNull(function0, "t");
        this.a = typeToken;
        this.b = function0;
    }

    /* Return type fixed from 'org.kodein.di.TypeToken<java.lang.Object>' to match base method */
    @Override // org.kodein.di.bindings.ContextTranslator
    @NotNull
    public TypeToken<? super Object> getContextType() {
        return TypeTokenKt.getAnyToken();
    }

    @Override // org.kodein.di.bindings.ContextTranslator
    @NotNull
    public TypeToken<? super S> getScopeType() {
        return this.a;
    }

    @NotNull
    public String toString() {
        StringBuilder I = a.I('(');
        I.append(getScopeType().simpleDispString());
        I.append(" -> ");
        I.append(getContextType().simpleDispString());
        I.append(')');
        return I.toString();
    }

    @Override // org.kodein.di.bindings.ContextTranslator
    public S translate(@Nullable Object obj) {
        return this.b.invoke();
    }
}
