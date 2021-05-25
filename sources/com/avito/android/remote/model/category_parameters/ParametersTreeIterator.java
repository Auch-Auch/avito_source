package com.avito.android.remote.model.category_parameters;

import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/ParametersTreeIterator;", "", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "", "hasNext", "()Z", "next", "()Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "", FirebaseAnalytics.Param.INDEX, "I", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "tree", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "<init>", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class ParametersTreeIterator implements Iterator<ParameterSlot>, KMappedMarker {
    private int index;
    private final ParametersTree tree;

    public ParametersTreeIterator(@NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(parametersTree, "tree");
        this.tree = parametersTree;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.tree.getCount() > this.index;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    @NotNull
    public ParameterSlot next() {
        if (hasNext()) {
            ParametersTree parametersTree = this.tree;
            int i = this.index;
            this.index = i + 1;
            return (ParameterSlot) parametersTree.getItem(i);
        }
        throw new IllegalStateException("Iterator has exhausted");
    }
}
