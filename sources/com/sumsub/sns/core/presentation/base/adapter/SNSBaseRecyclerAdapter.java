package com.sumsub.sns.core.presentation.base.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.sumsub.sns.core.presentation.base.adapter.SNSBaseRecyclerViewHolder;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00010\u0004B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fR&\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0010j\b\u0012\u0004\u0012\u00028\u0000`\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/sumsub/sns/core/presentation/base/adapter/SNSBaseRecyclerAdapter;", "T", "Lcom/sumsub/sns/core/presentation/base/adapter/SNSBaseRecyclerViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", "getItemCount", "()I", "", "items", "", "setResources", "(Ljava/util/List;)V", VKApiConst.POSITION, "getItem", "(I)Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "resources", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSBaseRecyclerAdapter<T, VH extends SNSBaseRecyclerViewHolder<T>> extends RecyclerView.Adapter<VH> {
    public final ArrayList<T> c = new ArrayList<>();

    @Nullable
    public final T getItem(int i) {
        return this.c.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    public final void setResources(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.c.clear();
        this.c.addAll(list);
        notifyDataSetChanged();
    }
}
