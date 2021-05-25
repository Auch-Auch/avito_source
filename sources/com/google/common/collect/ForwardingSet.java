package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class ForwardingSet<E> extends ForwardingCollection<E> implements Set<E> {
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public abstract Set<E> mo147delegate();

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || mo147delegate().equals(obj);
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        return mo147delegate().hashCode();
    }

    public boolean standardEquals(@NullableDecl Object obj) {
        return Sets.a(this, obj);
    }

    public int standardHashCode() {
        return Sets.b(this);
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardRemoveAll(Collection<?> collection) {
        return Sets.c(this, (Collection) Preconditions.checkNotNull(collection));
    }
}
