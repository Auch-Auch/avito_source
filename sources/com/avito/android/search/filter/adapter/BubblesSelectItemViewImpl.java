package com.avito.android.search.filter.adapter;

import android.view.View;
import com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer;
import com.avito.android.component.selectable_bubble_container.SelectableBubbleContainerImpl;
import com.avito.android.search.filter.adapter.BubblesSelectItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000e\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0012\u001a\u00020\b2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0014\u0010\nJ,\u0010\u0016\u001a\u00020\b2\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b\u0018\u00010\u0015H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/avito/android/search/filter/adapter/BubblesSelectItemViewImpl;", "Lcom/avito/android/search/filter/adapter/BubblesSelectItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/component/selectable_bubble_container/SelectableBubbleContainer;", "", "getSelectedPosition", "()I", VKApiConst.POSITION, "", "scrollToPosition", "(I)V", "", "Lcom/avito/android/component/selectable_bubble_container/SelectableBubbleContainer$Item;", "items", "setItems", "(Ljava/util/List;)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnScrollPositionChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "setSelectedItem", "Lkotlin/Function2;", "setSelectedItemListener", "(Lkotlin/jvm/functions/Function2;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class BubblesSelectItemViewImpl extends BaseViewHolder implements BubblesSelectItemView, SelectableBubbleContainer {
    public final /* synthetic */ SelectableBubbleContainerImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BubblesSelectItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new SelectableBubbleContainerImpl(view);
    }

    @Override // com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer
    public int getSelectedPosition() {
        return this.s.getSelectedPosition();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        BubblesSelectItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer
    public void scrollToPosition(int i) {
        this.s.scrollToPosition(i);
    }

    @Override // com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer
    public void setItems(@NotNull List<? extends SelectableBubbleContainer.Item> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.s.setItems(list);
    }

    @Override // com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer
    public void setOnScrollPositionChangeListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.s.setOnScrollPositionChangeListener(function1);
    }

    @Override // com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer
    public void setSelectedItem(int i) {
        this.s.setSelectedItem(i);
    }

    @Override // com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer
    public void setSelectedItemListener(@Nullable Function2<? super Integer, ? super SelectableBubbleContainer.Item, Unit> function2) {
        this.s.setSelectedItemListener(function2);
    }

    @Override // com.avito.android.component.selectable_bubble_container.SelectableBubbleContainer
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }
}
