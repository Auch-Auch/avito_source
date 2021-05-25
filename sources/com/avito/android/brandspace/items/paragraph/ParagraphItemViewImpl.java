package com.avito.android.brandspace.items.paragraph;

import android.view.View;
import android.widget.TextView;
import com.avito.android.brandspace.R;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/brandspace/items/paragraph/ParagraphItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/brandspace/items/paragraph/ParagraphItemView;", "", "title", "text", "", "bind", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "s", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class ParagraphItemViewImpl extends BaseViewHolder implements ParagraphItemView {
    public final TextView s;
    public final TextView t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ParagraphItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.text)");
        this.t = (TextView) findViewById2;
    }

    @Override // com.avito.android.brandspace.items.paragraph.ParagraphItemView
    public void bind(@Nullable String str, @Nullable String str2) {
        TextViews.bindText$default(this.s, str, false, 2, null);
        TextViews.bindText$default(this.t, str2, false, 2, null);
    }
}
