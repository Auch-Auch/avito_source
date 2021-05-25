package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
public final class NameResolverImpl implements NameResolver {
    @NotNull
    public final ProtoBuf.StringTable a;
    @NotNull
    public final ProtoBuf.QualifiedNameTable b;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {1, 2, 3};

        static {
            ProtoBuf.QualifiedNameTable.QualifiedName.Kind.values();
        }
    }

    public NameResolverImpl(@NotNull ProtoBuf.StringTable stringTable, @NotNull ProtoBuf.QualifiedNameTable qualifiedNameTable) {
        Intrinsics.checkNotNullParameter(stringTable, "strings");
        Intrinsics.checkNotNullParameter(qualifiedNameTable, "qualifiedNames");
        this.a = stringTable;
        this.b = qualifiedNameTable;
    }

    public final Triple<List<String>, List<String>, Boolean> a(int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        while (i != -1) {
            ProtoBuf.QualifiedNameTable.QualifiedName qualifiedName = this.b.getQualifiedName(i);
            String string = this.a.getString(qualifiedName.getShortName());
            ProtoBuf.QualifiedNameTable.QualifiedName.Kind kind = qualifiedName.getKind();
            Intrinsics.checkNotNull(kind);
            int ordinal = kind.ordinal();
            if (ordinal == 0) {
                linkedList2.addFirst(string);
            } else if (ordinal == 1) {
                linkedList.addFirst(string);
            } else if (ordinal == 2) {
                linkedList2.addFirst(string);
                z = true;
            }
            i = qualifiedName.getParentQualifiedName();
        }
        return new Triple<>(linkedList, linkedList2, Boolean.valueOf(z));
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    @NotNull
    public String getQualifiedClassName(int i) {
        Triple<List<String>, List<String>, Boolean> a3 = a(i);
        List<String> component1 = a3.component1();
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(a3.component2(), ".", null, null, 0, null, null, 62, null);
        if (component1.isEmpty()) {
            return joinToString$default;
        }
        return CollectionsKt___CollectionsKt.joinToString$default(component1, "/", null, null, 0, null, null, 62, null) + '/' + joinToString$default;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    @NotNull
    public String getString(int i) {
        String string = this.a.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "strings.getString(index)");
        return string;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i) {
        return a(i).getThird().booleanValue();
    }
}
