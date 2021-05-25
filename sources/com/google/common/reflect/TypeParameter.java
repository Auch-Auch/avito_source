package com.google.common.reflect;

import a2.j.d.k.d;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
public abstract class TypeParameter<T> extends d<T> {
    public final TypeVariable<?> a;

    public TypeParameter() {
        Type a3 = a();
        Preconditions.checkArgument(a3 instanceof TypeVariable, "%s should be a type variable.", a3);
        this.a = (TypeVariable) a3;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof TypeParameter) {
            return this.a.equals(((TypeParameter) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
