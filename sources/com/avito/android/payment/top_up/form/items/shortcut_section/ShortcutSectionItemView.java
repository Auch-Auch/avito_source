package com.avito.android.payment.top_up.form.items.shortcut_section;

import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.payment.top_up.form.items.bubble.BubbleItemDecoration;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "t", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView;", "s", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroid/view/View;", "view", "<init>", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Landroid/view/View;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class ShortcutSectionItemView extends BaseViewHolder {
    public final RecyclerView s;
    public final LinearLayoutManager t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShortcutSectionItemView(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        RecyclerView recyclerView = (RecyclerView) view;
        this.s = recyclerView;
        Resources resources = recyclerView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "recycler.resources");
        recyclerView.addItemDecoration(new BubbleItemDecoration(resources));
        recyclerView.setItemAnimator(null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        this.t = linearLayoutManager;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(simpleRecyclerAdapter);
    }
}
