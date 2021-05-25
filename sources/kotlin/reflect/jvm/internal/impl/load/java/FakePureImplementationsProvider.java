package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class FakePureImplementationsProvider {
    @NotNull
    public static final FakePureImplementationsProvider INSTANCE;
    @NotNull
    public static final HashMap<FqName, FqName> a = new HashMap<>();

    static {
        FakePureImplementationsProvider fakePureImplementationsProvider = new FakePureImplementationsProvider();
        INSTANCE = fakePureImplementationsProvider;
        fakePureImplementationsProvider.b(StandardNames.FqNames.mutableList, fakePureImplementationsProvider.a("java.util.ArrayList", "java.util.LinkedList"));
        fakePureImplementationsProvider.b(StandardNames.FqNames.mutableSet, fakePureImplementationsProvider.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        fakePureImplementationsProvider.b(StandardNames.FqNames.mutableMap, fakePureImplementationsProvider.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        fakePureImplementationsProvider.b(new FqName("java.util.function.Function"), fakePureImplementationsProvider.a("java.util.function.UnaryOperator"));
        fakePureImplementationsProvider.b(new FqName("java.util.function.BiFunction"), fakePureImplementationsProvider.a("java.util.function.BinaryOperator"));
    }

    public final List<FqName> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new FqName(str));
        }
        return arrayList;
    }

    public final void b(FqName fqName, List<FqName> list) {
        HashMap<FqName, FqName> hashMap = a;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            hashMap.put(it.next(), fqName);
        }
    }

    @Nullable
    public final FqName getPurelyImplementedInterface(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "classFqName");
        return a.get(fqName);
    }
}
