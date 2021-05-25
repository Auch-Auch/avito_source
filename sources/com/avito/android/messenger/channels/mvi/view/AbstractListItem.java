package com.avito.android.messenger.channels.mvi.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.view.PanelStateKt;
import com.vk.sdk.api.VKApiConst;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0017\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010@\u001a\u00020!¢\u0006\u0004\bH\u0010IJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\nJ\u001f\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u00020\u00042\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u00042\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u0006J\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\nJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010\u0006J\u0017\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\nJ\u000f\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\u0006J\u0017\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0004H\u0016¢\u0006\u0004\b)\u0010\nJ\u000f\u0010*\u001a\u00020\u000eH\u0016¢\u0006\u0004\b*\u0010\u001bJ\u000f\u0010+\u001a\u00020\u000eH&¢\u0006\u0004\b+\u0010\u001bJ#\u00100\u001a\u00028\u00002\u0006\u0010-\u001a\u00020,2\n\u0010/\u001a\u0006\u0012\u0002\b\u00030.H&¢\u0006\u0004\b0\u00101J9\u00105\u001a\u00020\b2\n\u0010/\u001a\u0006\u0012\u0002\b\u00030.2\u0006\u00102\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u000e2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001603H&¢\u0006\u0004\b5\u00106J+\u00107\u001a\u00020\b2\n\u0010/\u001a\u0006\u0012\u0002\b\u00030.2\u0006\u00102\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u000eH\u0016¢\u0006\u0004\b7\u00108J+\u00109\u001a\u00020\b2\n\u0010/\u001a\u0006\u0012\u0002\b\u00030.2\u0006\u00102\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u000eH\u0016¢\u0006\u0004\b9\u00108J+\u0010:\u001a\u00020\b2\n\u0010/\u001a\u0006\u0012\u0002\b\u00030.2\u0006\u00102\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u000eH\u0016¢\u0006\u0004\b:\u00108R\u0016\u0010=\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010<R\u0016\u0010@\u001a\u00020!8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010<R\u0016\u0010E\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010<R\u0016\u0010G\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010<¨\u0006J"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/AbstractListItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Leu/davidea/flexibleadapter/items/IFlexible;", "", "isEnabled", "()Z", "enabled", "", "setEnabled", "(Z)V", "isHidden", PanelStateKt.PANEL_HIDDEN, "setHidden", "", "spanCount", VKApiConst.POSITION, "getSpanSize", "(II)I", "newItem", "shouldNotifyChange", "(Leu/davidea/flexibleadapter/items/IFlexible;)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "contentEquals", "(Lcom/avito/android/messenger/channels/mvi/view/AbstractListItem;)Z", "isSelectable", "selectable", "setSelectable", "", "getBubbleText", "(I)Ljava/lang/String;", "isDraggable", "draggable", "setDraggable", "isSwipeable", "swipeable", "setSwipeable", "getItemViewType", "getLayoutRes", "Landroid/view/View;", "view", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "createViewHolder", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "payloads", "bindViewHolder", "(Leu/davidea/flexibleadapter/FlexibleAdapter;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/util/List;)V", "unbindViewHolder", "(Leu/davidea/flexibleadapter/FlexibleAdapter;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "onViewAttached", "onViewDetached", AuthSource.BOOKING_ORDER, "Z", "_hidden", "c", "_selectable", "id", "Ljava/lang/String;", "e", "_swipeable", AuthSource.SEND_ABUSE, "_enabled", "d", "_draggable", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class AbstractListItem<VH extends RecyclerView.ViewHolder> implements IFlexible<VH> {
    public boolean a = true;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    @JvmField
    @NotNull
    public final String id;

    public AbstractListItem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.id = str;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public abstract void bindViewHolder(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull VH vh, int i, @NotNull List<? extends Object> list);

    public boolean contentEquals(@NotNull AbstractListItem<?> abstractListItem) {
        Intrinsics.checkNotNullParameter(abstractListItem, "other");
        return equals(abstractListItem);
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    @NotNull
    public abstract VH createViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> flexibleAdapter);

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof ChannelListItem) || (!Intrinsics.areEqual(((ChannelListItem) obj).id, this.id))) {
            return false;
        }
        return true;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    @NotNull
    public String getBubbleText(int i) {
        return String.valueOf(i + 1);
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public int getItemViewType() {
        return getLayoutRes();
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public abstract int getLayoutRes();

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public int getSpanSize(int i, int i2) {
        return 1;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public boolean isDraggable() {
        return this.d;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public boolean isEnabled() {
        return this.a;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public boolean isHidden() {
        return this.b;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public boolean isSelectable() {
        return this.c;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public boolean isSwipeable() {
        return this.e;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public void onViewAttached(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull VH vh, int i) {
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        Intrinsics.checkNotNullParameter(vh, "holder");
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public void onViewDetached(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull VH vh, int i) {
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        Intrinsics.checkNotNullParameter(vh, "holder");
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public void setDraggable(boolean z) {
        this.d = z;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public void setEnabled(boolean z) {
        this.a = z;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public void setHidden(boolean z) {
        this.b = z;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public void setSelectable(boolean z) {
        this.c = z;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public void setSwipeable(boolean z) {
        this.e = z;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public boolean shouldNotifyChange(@NotNull IFlexible<?> iFlexible) {
        Intrinsics.checkNotNullParameter(iFlexible, "newItem");
        return true;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public void unbindViewHolder(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull VH vh, int i) {
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        Intrinsics.checkNotNullParameter(vh, "holder");
    }
}
