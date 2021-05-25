package io.reactivex.rxjava3.internal.fuseable;

import io.reactivex.rxjava3.annotations.Nullable;
public interface SimplePlainQueue<T> extends SimpleQueue<T> {
    @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    @Nullable
    T poll();
}
