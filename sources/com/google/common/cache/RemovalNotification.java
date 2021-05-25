package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.AbstractMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    public final RemovalCause a;

    public RemovalNotification(@NullableDecl K k, @NullableDecl V v, RemovalCause removalCause) {
        super(k, v);
        this.a = (RemovalCause) Preconditions.checkNotNull(removalCause);
    }

    public static <K, V> RemovalNotification<K, V> create(@NullableDecl K k, @NullableDecl V v, RemovalCause removalCause) {
        return new RemovalNotification<>(k, v, removalCause);
    }

    public RemovalCause getCause() {
        return this.a;
    }

    public boolean wasEvicted() {
        return this.a.a();
    }
}
