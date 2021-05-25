package org.kodein.di.bindings;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.TypeToken;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0004B/\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0006\u001a\u00028\u00022\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR%\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0013\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00108V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R%\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000eR\u001e\u0010\u0018\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00020\u00108V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012¨\u0006\u001b"}, d2 = {"Lorg/kodein/di/bindings/CompositeContextTranslator;", "C", "I", ExifInterface.LATITUDE_SOUTH, "Lorg/kodein/di/bindings/ContextTranslator;", "ctx", "translate", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/bindings/ContextTranslator;", "getSrc", "()Lorg/kodein/di/bindings/ContextTranslator;", "src", "Lorg/kodein/di/TypeToken;", "getContextType", "()Lorg/kodein/di/TypeToken;", "contextType", AuthSource.BOOKING_ORDER, "getDst", "dst", "getScopeType", "scopeType", "<init>", "(Lorg/kodein/di/bindings/ContextTranslator;Lorg/kodein/di/bindings/ContextTranslator;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class CompositeContextTranslator<C, I, S> implements ContextTranslator<C, S> {
    @NotNull
    public final ContextTranslator<C, I> a;
    @NotNull
    public final ContextTranslator<I, S> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: org.kodein.di.bindings.ContextTranslator<? super C, I> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: org.kodein.di.bindings.ContextTranslator<? super I, S> */
    /* JADX WARN: Multi-variable type inference failed */
    public CompositeContextTranslator(@NotNull ContextTranslator<? super C, I> contextTranslator, @NotNull ContextTranslator<? super I, S> contextTranslator2) {
        Intrinsics.checkParameterIsNotNull(contextTranslator, "src");
        Intrinsics.checkParameterIsNotNull(contextTranslator2, "dst");
        this.a = contextTranslator;
        this.b = contextTranslator2;
    }

    @Override // org.kodein.di.bindings.ContextTranslator
    @NotNull
    public TypeToken<? super C> getContextType() {
        return this.a.getContextType();
    }

    @NotNull
    public final ContextTranslator<I, S> getDst() {
        return this.b;
    }

    @Override // org.kodein.di.bindings.ContextTranslator
    @NotNull
    public TypeToken<? super S> getScopeType() {
        return this.b.getScopeType();
    }

    @NotNull
    public final ContextTranslator<C, I> getSrc() {
        return this.a;
    }

    @NotNull
    public String toString() {
        StringBuilder I = a.I('(');
        I.append(this.a);
        I.append(" -> ");
        I.append(this.b);
        I.append(')');
        return I.toString();
    }

    @Override // org.kodein.di.bindings.ContextTranslator
    public S translate(C c) {
        return this.b.translate(this.a.translate(c));
    }
}
