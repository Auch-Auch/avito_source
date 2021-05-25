package kotlin.reflect.jvm.internal.impl.load.java;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.r;
public final class BuiltinSpecialProperties {
    @NotNull
    public static final BuiltinSpecialProperties INSTANCE = new BuiltinSpecialProperties();
    @NotNull
    public static final Map<FqName, Name> a;
    @NotNull
    public static final Map<Name, List<Name>> b;
    @NotNull
    public static final Set<FqName> c;
    @NotNull
    public static final Set<Name> d;

    static {
        FqNameUnsafe fqNameUnsafe = StandardNames.FqNames._enum;
        FqName fqName = StandardNames.FqNames.map;
        Map<FqName, Name> mapOf = r.mapOf(TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(fqNameUnsafe, "name"), Name.identifier("name")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(fqNameUnsafe, "ordinal"), Name.identifier("ordinal")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(StandardNames.FqNames.collection, "size"), Name.identifier("size")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(fqName, "size"), Name.identifier("size")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(StandardNames.FqNames.charSequence, "length"), Name.identifier("length")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(fqName, "keys"), Name.identifier("keySet")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(fqName, ResidentialComplexModuleKt.VALUES), Name.identifier(ResidentialComplexModuleKt.VALUES)), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(fqName, "entries"), Name.identifier("entrySet")));
        a = mapOf;
        Set<Map.Entry<FqName, Name>> entrySet = mapOf.entrySet();
        ArrayList<Pair> arrayList = new ArrayList(e.collectionSizeOrDefault(entrySet, 10));
        for (T t : entrySet) {
            arrayList.add(new Pair(((FqName) t.getKey()).shortName(), t.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            Name name = (Name) pair.getSecond();
            Object obj = linkedHashMap.get(name);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(name, obj);
            }
            ((List) obj).add((Name) pair.getFirst());
        }
        b = linkedHashMap;
        Set<FqName> keySet = a.keySet();
        c = keySet;
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(keySet, 10));
        Iterator<T> it = keySet.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().shortName());
        }
        d = CollectionsKt___CollectionsKt.toSet(arrayList2);
    }

    @NotNull
    public final Map<FqName, Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return a;
    }

    @NotNull
    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name1");
        List<Name> list = b.get(name);
        return list == null ? CollectionsKt__CollectionsKt.emptyList() : list;
    }

    @NotNull
    public final Set<FqName> getSPECIAL_FQ_NAMES() {
        return c;
    }

    @NotNull
    public final Set<Name> getSPECIAL_SHORT_NAMES() {
        return d;
    }
}
