package com.avito.android.remote.model;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002R\u0016\u0010\u0005\u001a\u00028\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/Entity;", "T", "", "getId", "()Ljava/lang/Object;", "id", "", "getName", "()Ljava/lang/String;", "name", "models_release"}, k = 1, mv = {1, 4, 2})
public interface Entity<T> {
    T getId();

    @Nullable
    String getName();
}
