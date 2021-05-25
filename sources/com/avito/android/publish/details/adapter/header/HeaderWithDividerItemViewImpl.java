package com.avito.android.publish.details.adapter.header;

import android.view.View;
import android.widget.TextView;
import com.avito.android.publish.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/publish/details/adapter/header/HeaderWithDividerItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/publish/details/adapter/header/HeaderWithDividerItemView;", "", "text", "", "setText", "(Ljava/lang/String;)V", "", "visible", "setDividerVisible", "(Z)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "headerView", "Landroid/view/View;", "t", "Landroid/view/View;", "headerDivider", "view", "<init>", "(Landroid/view/View;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderWithDividerItemViewImpl extends BaseViewHolder implements HeaderWithDividerItemView {
    public final TextView s;
    public final View t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeaderWithDividerItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.header_text);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.header_divider);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.t = findViewById2;
    }

    @Override // com.avito.android.publish.details.adapter.header.HeaderWithDividerItemView
    public void setDividerVisible(boolean z) {
        Views.setVisible(this.t, z);
    }

    @Override // com.avito.android.publish.details.adapter.header.HeaderWithDividerItemView
    public void setText(@Nullable String str) {
        TextViews.bindText$default(this.s, str, false, 2, null);
    }
}
