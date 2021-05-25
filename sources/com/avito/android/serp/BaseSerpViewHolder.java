package com.avito.android.serp;

import android.view.View;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/avito/android/serp/BaseSerpViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "toString", "()Ljava/lang/String;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public class BaseSerpViewHolder extends BaseViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseSerpViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
    @NotNull
    public String toString() {
        return getClass().getSimpleName() + " type:" + getItemViewType() + " " + super.toString();
    }
}
