package com.avito.android.component.search.list;

import android.view.View;
import android.widget.TextView;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/component/search/list/TitleItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/component/search/list/TitleItemView;", "", "text", "", "setText", "(Ljava/lang/String;)V", "", "paddingTop", "paddingBottom", "setPadding", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "t", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class TitleItemViewHolder extends BaseViewHolder implements TitleItemView {
    public final TextView s;
    public final View t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TitleItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = view;
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) view;
    }

    @Override // com.avito.android.component.search.list.TitleItemView
    public void setPadding(@Nullable Integer num, @Nullable Integer num2) {
        int i;
        int i2;
        if (num != null) {
            i = Views.dpToPx(this.t, num.intValue());
        } else {
            i = 0;
        }
        if (num2 != null) {
            i2 = Views.dpToPx(this.t, num2.intValue());
        } else {
            i2 = 0;
        }
        Views.changePadding$default(this.t, 0, i, 0, i2, 5, null);
    }

    @Override // com.avito.android.component.search.list.TitleItemView
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.s.setText(str);
    }
}
