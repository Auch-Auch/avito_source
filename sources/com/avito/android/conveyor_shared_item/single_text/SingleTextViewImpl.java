package com.avito.android.conveyor_shared_item.single_text;

import android.view.View;
import android.widget.TextView;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/conveyor_shared_item/single_text/SingleTextViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/conveyor_shared_item/single_text/SingleTextView;", "", "text", "", "bindTitle", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title", "Landroid/view/View;", "root", "<init>", "(Landroid/view/View;Landroid/widget/TextView;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SingleTextViewImpl extends BaseViewHolder implements SingleTextView {
    @NotNull
    public final TextView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleTextViewImpl(@NotNull View view, @NotNull TextView textView) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "root");
        Intrinsics.checkNotNullParameter(textView, "title");
        this.s = textView;
    }

    @Override // com.avito.android.conveyor_shared_item.single_text.SingleTextView
    public void bindTitle(@Nullable String str) {
        TextViews.bindText$default(this.s, str, false, 2, null);
    }

    @NotNull
    public final TextView getTitle() {
        return this.s;
    }
}
