package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public final class PredefinedFunctionEnhancementInfo {
    @Nullable
    public final TypeEnhancementInfo a;
    @NotNull
    public final List<TypeEnhancementInfo> b;

    public PredefinedFunctionEnhancementInfo() {
        this(null, null, 3, null);
    }

    public PredefinedFunctionEnhancementInfo(@Nullable TypeEnhancementInfo typeEnhancementInfo, @NotNull List<TypeEnhancementInfo> list) {
        Intrinsics.checkNotNullParameter(list, "parametersInfo");
        this.a = typeEnhancementInfo;
        this.b = list;
    }

    @NotNull
    public final List<TypeEnhancementInfo> getParametersInfo() {
        return this.b;
    }

    @Nullable
    public final TypeEnhancementInfo getReturnTypeInfo() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PredefinedFunctionEnhancementInfo(TypeEnhancementInfo typeEnhancementInfo, List list, int i, j jVar) {
        this((i & 1) != 0 ? null : typeEnhancementInfo, (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
