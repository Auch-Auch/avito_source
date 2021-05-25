package com.avito.konveyor.adapter;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/konveyor/adapter/EmptyViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Landroid/view/ViewGroup;", "parent", "<init>", "(Landroid/view/ViewGroup;)V", "konveyor_release"}, k = 1, mv = {1, 4, 2})
public final class EmptyViewHolder extends BaseViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmptyViewHolder(@NotNull ViewGroup viewGroup) {
        super(new View(viewGroup.getContext()));
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }
}
