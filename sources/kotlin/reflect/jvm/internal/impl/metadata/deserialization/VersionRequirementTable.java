package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public final class VersionRequirementTable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final VersionRequirementTable b = new VersionRequirementTable(CollectionsKt__CollectionsKt.emptyList());
    @NotNull
    public final List<ProtoBuf.VersionRequirement> a;

    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final VersionRequirementTable create(@NotNull ProtoBuf.VersionRequirementTable versionRequirementTable) {
            Intrinsics.checkNotNullParameter(versionRequirementTable, "table");
            if (versionRequirementTable.getRequirementCount() == 0) {
                return getEMPTY();
            }
            List<ProtoBuf.VersionRequirement> requirementList = versionRequirementTable.getRequirementList();
            Intrinsics.checkNotNullExpressionValue(requirementList, "table.requirementList");
            return new VersionRequirementTable(requirementList, null);
        }

        @NotNull
        public final VersionRequirementTable getEMPTY() {
            return VersionRequirementTable.b;
        }

        public Companion(j jVar) {
        }
    }

    public VersionRequirementTable(List<ProtoBuf.VersionRequirement> list) {
        this.a = list;
    }

    @Nullable
    public final ProtoBuf.VersionRequirement get(int i) {
        return (ProtoBuf.VersionRequirement) CollectionsKt___CollectionsKt.getOrNull(this.a, i);
    }

    public VersionRequirementTable(List list, j jVar) {
        this.a = list;
    }
}
