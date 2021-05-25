package a2.a.a.i3.d;

import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a {
    @NotNull
    public final List<Item> a;
    @NotNull
    public final List<Integer> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.conveyor_item.Item> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull List<? extends Item> list, @NotNull List<Integer> list2) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(list2, "spaceIndices");
        this.a = list;
        this.b = list2;
    }
}
