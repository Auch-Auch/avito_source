package com.avito.android.beduin.ui.adapter;

import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.beduin.core.component.BeduinComponent;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B;\u0012\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\f\u0012\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\f¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0007R(\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R(\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/avito/android/beduin/ui/adapter/BeduinDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "(II)Z", "getOldListSize", "()I", "getNewListSize", "areContentsTheSame", "", "Lcom/avito/android/beduin/core/component/BeduinComponent;", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "oldList", AuthSource.BOOKING_ORDER, "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinDiffUtil extends DiffUtil.Callback {
    public final List<BeduinComponent<BeduinModel, View>> a;
    public final List<BeduinComponent<BeduinModel, View>> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.beduin.core.component.BeduinComponent<com.avito.android.beduin.core.model.container.component.BeduinModel, android.view.View>> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.beduin.core.component.BeduinComponent<com.avito.android.beduin.core.model.container.component.BeduinModel, android.view.View>> */
    /* JADX WARN: Multi-variable type inference failed */
    public BeduinDiffUtil(@NotNull List<? extends BeduinComponent<BeduinModel, View>> list, @NotNull List<? extends BeduinComponent<BeduinModel, View>> list2) {
        Intrinsics.checkNotNullParameter(list, "oldList");
        Intrinsics.checkNotNullParameter(list2, "newList");
        this.a = list;
        this.b = list2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        return Intrinsics.areEqual(this.a.get(i).getModel(), this.b.get(i2).getModel());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        return Intrinsics.areEqual(this.a.get(i).getModel().getId(), this.b.get(i2).getModel().getId());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.a.size();
    }
}
