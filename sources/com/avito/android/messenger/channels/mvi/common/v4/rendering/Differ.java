package com.avito.android.messenger.channels.mvi.common.v4.rendering;

import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\r\u0010\fJ+\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000f\u001a\u00028\u00002\b\b\u0002\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Differ;", "State", "Item", "", "state", "", "getItems", "(Ljava/lang/Object;)Ljava/util/List;", "oldItem", "newItem", "", "areContentsTheSame", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "areItemsTheSame", "oldState", "newState", "detectMoves", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "calculateDiff", "(Ljava/lang/Object;Ljava/lang/Object;Z)Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "<init>", "()V", AuthSource.SEND_ABUSE, "mvi_release"}, k = 1, mv = {1, 4, 2})
public abstract class Differ<State, Item> {

    public final class a extends DiffUtil.Callback {
        public final List<Item> a;
        public final List<Item> b;
        public final /* synthetic */ Differ c;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends Item> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends Item> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull Differ differ, @NotNull List<? extends Item> list, List<? extends Item> list2) {
            Intrinsics.checkNotNullParameter(list, "oldItems");
            Intrinsics.checkNotNullParameter(list2, "newItems");
            this.c = differ;
            this.a = list;
            this.b = list2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i, int i2) {
            return this.c.areContentsTheSame(this.a.get(i), this.b.get(i2));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int i, int i2) {
            return this.c.areItemsTheSame(this.a.get(i), this.b.get(i2));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.b.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.a.size();
        }
    }

    public static /* synthetic */ DiffUtil.DiffResult calculateDiff$default(Differ differ, Object obj, Object obj2, boolean z, int i, Object obj3) {
        if (obj3 == null) {
            if ((i & 4) != 0) {
                z = true;
            }
            return differ.calculateDiff(obj, obj2, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateDiff");
    }

    public boolean areContentsTheSame(Item item, Item item2) {
        return false;
    }

    public boolean areItemsTheSame(Item item, Item item2) {
        return item == item2;
    }

    @Nullable
    public final DiffUtil.DiffResult calculateDiff(@Nullable State state, State state2, boolean z) {
        List<Item> items = getItems(state);
        List<Item> items2 = getItems(state2);
        if (items == null || items2 == null) {
            return null;
        }
        return DiffUtil.calculateDiff(new a(this, items, items2), z);
    }

    @Nullable
    public abstract List<Item> getItems(@Nullable State state);
}
