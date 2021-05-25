package com.sumsub.sns.core.presentation.base.adapter;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0004¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/sumsub/sns/core/presentation/base/adapter/SNSBaseRecyclerViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "", "itemCount", "", "bind", "(Ljava/lang/Object;I)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSBaseRecyclerViewHolder<T> extends RecyclerView.ViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSBaseRecyclerViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        ButterKnife.bind(this, view);
    }

    public static /* synthetic */ void bind$default(SNSBaseRecyclerViewHolder sNSBaseRecyclerViewHolder, Object obj, int i, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 2) != 0) {
                i = Integer.MAX_VALUE;
            }
            sNSBaseRecyclerViewHolder.bind(obj, i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bind");
    }

    public abstract void bind(T t, int i);

    @NotNull
    public final Context getContext() {
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        return context;
    }
}
