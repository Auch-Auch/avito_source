package com.avito.android.serp.adapter;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/serp/adapter/SimpleNarrowLayoutTypeProviderImpl;", "Lcom/avito/android/serp/adapter/LayoutTypeProvider;", "Lcom/avito/android/serp/adapter/LayoutType;", "getLayoutType", "()Lcom/avito/android/serp/adapter/LayoutType;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleNarrowLayoutTypeProviderImpl implements LayoutTypeProvider {
    @Override // com.avito.android.serp.adapter.LayoutTypeProvider
    @NotNull
    public LayoutType getLayoutType() {
        return LayoutType.NARROW;
    }
}
