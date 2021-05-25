package com.avito.android.recycler.layout_manager;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/avito/android/recycler/layout_manager/UnpredictiveLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "supportsPredictiveItemAnimations", "()Z", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "recycler_release"}, k = 1, mv = {1, 4, 2})
public final class UnpredictiveLinearLayoutManager extends LinearLayoutManager {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnpredictiveLinearLayoutManager(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return false;
    }
}
