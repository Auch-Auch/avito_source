package com.avito.android.vas_performance.ui.recycler;

import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/vas_performance/ui/recycler/ListUpdate;", "", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "getDiffResult", "()Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "diffResult", "", "Lcom/avito/conveyor_item/Item;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getList", "()Ljava/util/List;", "list", "<init>", "(Ljava/util/List;Landroidx/recyclerview/widget/DiffUtil$DiffResult;)V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class ListUpdate {
    @NotNull
    public final List<Item> a;
    @NotNull
    public final DiffUtil.DiffResult b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.conveyor_item.Item> */
    /* JADX WARN: Multi-variable type inference failed */
    public ListUpdate(@NotNull List<? extends Item> list, @NotNull DiffUtil.DiffResult diffResult) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(diffResult, "diffResult");
        this.a = list;
        this.b = diffResult;
    }

    @NotNull
    public final DiffUtil.DiffResult getDiffResult() {
        return this.b;
    }

    @NotNull
    public final List<Item> getList() {
        return this.a;
    }
}
