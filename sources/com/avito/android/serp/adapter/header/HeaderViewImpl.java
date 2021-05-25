package com.avito.android.serp.adapter.header;

import android.view.View;
import com.avito.android.serp_core.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/serp/adapter/header/HeaderViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/serp/adapter/header/HeaderView;", "", "title", "", "descriptions", "", "setData", "(Ljava/lang/String;Ljava/util/List;)V", "Lcom/avito/android/serp/adapter/header/HeaderWidget;", "s", "Lcom/avito/android/serp/adapter/header/HeaderWidget;", "headerView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderViewImpl extends BaseViewHolder implements HeaderView {
    public final HeaderWidget s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeaderViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.header);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.header)");
        this.s = (HeaderWidget) findViewById;
    }

    @Override // com.avito.android.serp.adapter.header.HeaderView
    public void setData(@Nullable String str, @Nullable List<String> list) {
        this.s.setData(str, list);
    }
}
