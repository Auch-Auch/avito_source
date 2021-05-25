package com.avito.android.public_profile.adapter.placeholder;

import android.view.View;
import android.widget.TextView;
import com.avito.android.public_profile.R;
import com.avito.android.public_profile.adapter.placeholder.PlaceholderItemView;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/public_profile/adapter/placeholder/PlaceholderItemViewImpl;", "Lcom/avito/android/public_profile/adapter/placeholder/PlaceholderItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setText", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class PlaceholderItemViewImpl extends BaseViewHolder implements PlaceholderItemView {
    @NotNull
    public final TextView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlaceholderItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.placeholder);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
    }

    @NotNull
    public final TextView getTitleView() {
        return this.s;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        PlaceholderItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.public_profile.adapter.placeholder.PlaceholderItemView
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextViews.bindText$default(this.s, str, false, 2, null);
    }
}
