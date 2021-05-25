package com.google.common.graph;

import com.google.common.annotations.Beta;
@Beta
public interface SuccessorsFunction<N> {
    /* renamed from: successors */
    Iterable<? extends N> mo140successors(N n);
}
