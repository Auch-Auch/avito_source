package a2.a.a.i3.c.a.i.e;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class c {
    @NotNull
    public final List<a> a;
    @NotNull
    public final List<b> b;

    public c(@NotNull List<a> list, @NotNull List<b> list2) {
        Intrinsics.checkNotNullParameter(list, "circles");
        Intrinsics.checkNotNullParameter(list2, "tickCoords");
        this.a = list;
        this.b = list2;
    }

    public c(List list, List list2, int i) {
        List<b> emptyList = (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : null;
        Intrinsics.checkNotNullParameter(list, "circles");
        Intrinsics.checkNotNullParameter(emptyList, "tickCoords");
        this.a = list;
        this.b = emptyList;
    }
}
