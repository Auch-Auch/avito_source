package com.avito.android.conveyor_shared_item.paid_services;

import android.view.View;
import android.widget.TextView;
import com.avito.android.conveyor_shared_item.R;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderView;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderViewImpl;", "Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "description", "setDescription", "(Ljava/lang/CharSequence;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "t", "Landroid/widget/TextView;", "subtitleView", "s", "titleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "conveyor-shared-item_release"}, k = 1, mv = {1, 4, 2})
public final class PaidServiceHeaderViewImpl extends BaseViewHolder implements PaidServiceHeaderView {
    public final TextView s;
    public final TextView t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaidServiceHeaderViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view.findViewById(R.id.title);
        this.t = (TextView) view.findViewById(R.id.description);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        PaidServiceHeaderView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderView
    public void setDescription(@Nullable CharSequence charSequence) {
        TextView textView = this.t;
        Intrinsics.checkNotNullExpressionValue(textView, "subtitleView");
        TextViews.bindText$default(textView, charSequence, false, 2, null);
    }

    @Override // com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "titleView");
        textView.setText(str);
    }
}
