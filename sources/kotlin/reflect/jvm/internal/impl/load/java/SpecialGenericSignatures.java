package kotlin.reflect.jvm.internal.impl.load.java;

import a2.b.a.a.a;
import com.avito.android.util.preferences.SessionContract;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.q;
import t6.n.r;
import t6.n.y;
import t6.n.z;
import t6.r.a.j;
public class SpecialGenericSignatures {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final List<Companion.NameAndSignature> a;
    @NotNull
    public static final List<String> b;
    @NotNull
    public static final Map<Companion.NameAndSignature, TypeSafeBarrierDescription> c;
    @NotNull
    public static final Map<String, TypeSafeBarrierDescription> d;
    @NotNull
    public static final Set<Name> e;
    @NotNull
    public static final Set<String> f;
    @NotNull
    public static final Companion.NameAndSignature g;
    @NotNull
    public static final Map<Companion.NameAndSignature, Name> h;
    @NotNull
    public static final Map<String, Name> i;
    @NotNull
    public static final List<Name> j;
    @NotNull
    public static final Map<Name, List<Name>> k;

    public static final class Companion {

        public static final class NameAndSignature {
            @NotNull
            public final Name a;
            @NotNull
            public final String b;

            public NameAndSignature(@NotNull Name name, @NotNull String str) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(str, SessionContract.SIGNATURE);
                this.a = name;
                this.b = str;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof NameAndSignature)) {
                    return false;
                }
                NameAndSignature nameAndSignature = (NameAndSignature) obj;
                return Intrinsics.areEqual(this.a, nameAndSignature.a) && Intrinsics.areEqual(this.b, nameAndSignature.b);
            }

            @NotNull
            public final Name getName() {
                return this.a;
            }

            @NotNull
            public final String getSignature() {
                return this.b;
            }

            public int hashCode() {
                return this.b.hashCode() + (this.a.hashCode() * 31);
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("NameAndSignature(name=");
                L.append(this.a);
                L.append(", signature=");
                return a.s(L, this.b, ')');
            }
        }

        public Companion() {
        }

        public static final NameAndSignature access$method(Companion companion, String str, String str2, String str3, String str4) {
            Objects.requireNonNull(companion);
            Name identifier = Name.identifier(str2);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(name)");
            SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
            return new NameAndSignature(identifier, signatureBuildingComponents.signature(str, str2 + '(' + str3 + ')' + str4));
        }

        @NotNull
        public final List<String> getERASED_COLLECTION_PARAMETER_SIGNATURES() {
            return SpecialGenericSignatures.b;
        }

        @NotNull
        public final Set<Name> getERASED_VALUE_PARAMETERS_SHORT_NAMES() {
            return SpecialGenericSignatures.e;
        }

        @NotNull
        public final Set<String> getERASED_VALUE_PARAMETERS_SIGNATURES() {
            return SpecialGenericSignatures.f;
        }

        @NotNull
        public final Map<Name, List<Name>> getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP() {
            return SpecialGenericSignatures.k;
        }

        @NotNull
        public final List<Name> getORIGINAL_SHORT_NAMES() {
            return SpecialGenericSignatures.j;
        }

        @NotNull
        public final NameAndSignature getREMOVE_AT_NAME_AND_SIGNATURE() {
            return SpecialGenericSignatures.g;
        }

        @NotNull
        public final Map<String, TypeSafeBarrierDescription> getSIGNATURE_TO_DEFAULT_VALUES_MAP() {
            return SpecialGenericSignatures.d;
        }

        @NotNull
        public final Map<String, Name> getSIGNATURE_TO_JVM_REPRESENTATION_NAME() {
            return SpecialGenericSignatures.i;
        }

        @NotNull
        public final SpecialSignatureInfo getSpecialSignatureInfo(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "builtinSignature");
            if (getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(str)) {
                return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
            }
            if (((TypeSafeBarrierDescription) r.getValue(getSIGNATURE_TO_DEFAULT_VALUES_MAP(), str)) == TypeSafeBarrierDescription.NULL) {
                return SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
            }
            return SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }

        public Companion(j jVar) {
        }
    }

    public enum SpecialSignatureInfo {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);

        /* access modifiers changed from: public */
        SpecialSignatureInfo(String str, boolean z) {
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class TypeSafeBarrierDescription extends Enum<TypeSafeBarrierDescription> {
        public static final TypeSafeBarrierDescription FALSE;
        public static final TypeSafeBarrierDescription INDEX;
        public static final TypeSafeBarrierDescription MAP_GET_OR_DEFAULT;
        public static final TypeSafeBarrierDescription NULL;
        public static final /* synthetic */ TypeSafeBarrierDescription[] b;
        @Nullable
        public final Object a;

        public static final class a extends TypeSafeBarrierDescription {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            public a(String str, int i) {
                super(str, i, null, null);
            }
        }

        static {
            TypeSafeBarrierDescription typeSafeBarrierDescription = new TypeSafeBarrierDescription("NULL", 0, null);
            NULL = typeSafeBarrierDescription;
            TypeSafeBarrierDescription typeSafeBarrierDescription2 = new TypeSafeBarrierDescription("INDEX", 1, -1);
            INDEX = typeSafeBarrierDescription2;
            TypeSafeBarrierDescription typeSafeBarrierDescription3 = new TypeSafeBarrierDescription("FALSE", 2, Boolean.FALSE);
            FALSE = typeSafeBarrierDescription3;
            a aVar = new a("MAP_GET_OR_DEFAULT", 3);
            MAP_GET_OR_DEFAULT = aVar;
            b = new TypeSafeBarrierDescription[]{typeSafeBarrierDescription, typeSafeBarrierDescription2, typeSafeBarrierDescription3, aVar};
        }

        public TypeSafeBarrierDescription(String str, int i, Object obj) {
            this.a = obj;
        }

        public static TypeSafeBarrierDescription valueOf(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            return (TypeSafeBarrierDescription) Enum.valueOf(TypeSafeBarrierDescription.class, str);
        }

        public static TypeSafeBarrierDescription[] values() {
            TypeSafeBarrierDescription[] typeSafeBarrierDescriptionArr = b;
            TypeSafeBarrierDescription[] typeSafeBarrierDescriptionArr2 = new TypeSafeBarrierDescription[typeSafeBarrierDescriptionArr.length];
            System.arraycopy(typeSafeBarrierDescriptionArr, 0, typeSafeBarrierDescriptionArr2, 0, typeSafeBarrierDescriptionArr.length);
            return typeSafeBarrierDescriptionArr2;
        }

        public TypeSafeBarrierDescription(String str, int i, Object obj, j jVar) {
            this.a = obj;
        }
    }

    static {
        Set<String> of = y.setOf((Object[]) new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList<Companion.NameAndSignature> arrayList = new ArrayList(e.collectionSizeOrDefault(of, 10));
        for (String str : of) {
            Companion companion = Companion;
            String desc = JvmPrimitiveType.BOOLEAN.getDesc();
            Intrinsics.checkNotNullExpressionValue(desc, "BOOLEAN.desc");
            arrayList.add(Companion.access$method(companion, "java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        a = arrayList;
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        for (Companion.NameAndSignature nameAndSignature : arrayList) {
            arrayList2.add(nameAndSignature.getSignature());
        }
        b = arrayList2;
        List<Companion.NameAndSignature> list = a;
        ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList3.add(it.next().getName().asString());
        }
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        Companion companion2 = Companion;
        String javaUtil = signatureBuildingComponents.javaUtil("Collection");
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BOOLEAN;
        String desc2 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc2, "BOOLEAN.desc");
        Companion.NameAndSignature access$method = Companion.access$method(companion2, javaUtil, "contains", "Ljava/lang/Object;", desc2);
        TypeSafeBarrierDescription typeSafeBarrierDescription = TypeSafeBarrierDescription.FALSE;
        String javaUtil2 = signatureBuildingComponents.javaUtil("Collection");
        String desc3 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc3, "BOOLEAN.desc");
        String javaUtil3 = signatureBuildingComponents.javaUtil("Map");
        String desc4 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc4, "BOOLEAN.desc");
        String javaUtil4 = signatureBuildingComponents.javaUtil("Map");
        String desc5 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc5, "BOOLEAN.desc");
        String javaUtil5 = signatureBuildingComponents.javaUtil("Map");
        String desc6 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc6, "BOOLEAN.desc");
        Companion.NameAndSignature access$method2 = Companion.access$method(companion2, signatureBuildingComponents.javaUtil("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        TypeSafeBarrierDescription typeSafeBarrierDescription2 = TypeSafeBarrierDescription.NULL;
        String javaUtil6 = signatureBuildingComponents.javaUtil("List");
        JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.INT;
        String desc7 = jvmPrimitiveType2.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc7, "INT.desc");
        Companion.NameAndSignature access$method3 = Companion.access$method(companion2, javaUtil6, "indexOf", "Ljava/lang/Object;", desc7);
        TypeSafeBarrierDescription typeSafeBarrierDescription3 = TypeSafeBarrierDescription.INDEX;
        String javaUtil7 = signatureBuildingComponents.javaUtil("List");
        String desc8 = jvmPrimitiveType2.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc8, "INT.desc");
        Map<Companion.NameAndSignature, TypeSafeBarrierDescription> mapOf = r.mapOf(TuplesKt.to(access$method, typeSafeBarrierDescription), TuplesKt.to(Companion.access$method(companion2, javaUtil2, ProductAction.ACTION_REMOVE, "Ljava/lang/Object;", desc3), typeSafeBarrierDescription), TuplesKt.to(Companion.access$method(companion2, javaUtil3, "containsKey", "Ljava/lang/Object;", desc4), typeSafeBarrierDescription), TuplesKt.to(Companion.access$method(companion2, javaUtil4, "containsValue", "Ljava/lang/Object;", desc5), typeSafeBarrierDescription), TuplesKt.to(Companion.access$method(companion2, javaUtil5, ProductAction.ACTION_REMOVE, "Ljava/lang/Object;Ljava/lang/Object;", desc6), typeSafeBarrierDescription), TuplesKt.to(Companion.access$method(companion2, signatureBuildingComponents.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), TuplesKt.to(access$method2, typeSafeBarrierDescription2), TuplesKt.to(Companion.access$method(companion2, signatureBuildingComponents.javaUtil("Map"), ProductAction.ACTION_REMOVE, "Ljava/lang/Object;", "Ljava/lang/Object;"), typeSafeBarrierDescription2), TuplesKt.to(access$method3, typeSafeBarrierDescription3), TuplesKt.to(Companion.access$method(companion2, javaUtil7, "lastIndexOf", "Ljava/lang/Object;", desc8), typeSafeBarrierDescription3));
        c = mapOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap(q.mapCapacity(mapOf.size()));
        for (T t : mapOf.entrySet()) {
            linkedHashMap.put(((Companion.NameAndSignature) t.getKey()).getSignature(), t.getValue());
        }
        d = linkedHashMap;
        Set<Companion.NameAndSignature> plus = z.plus((Set) c.keySet(), (Iterable) a);
        ArrayList arrayList4 = new ArrayList(e.collectionSizeOrDefault(plus, 10));
        for (Companion.NameAndSignature nameAndSignature2 : plus) {
            arrayList4.add(nameAndSignature2.getName());
        }
        e = CollectionsKt___CollectionsKt.toSet(arrayList4);
        ArrayList arrayList5 = new ArrayList(e.collectionSizeOrDefault(plus, 10));
        for (Companion.NameAndSignature nameAndSignature3 : plus) {
            arrayList5.add(nameAndSignature3.getSignature());
        }
        f = CollectionsKt___CollectionsKt.toSet(arrayList5);
        Companion companion3 = Companion;
        JvmPrimitiveType jvmPrimitiveType3 = JvmPrimitiveType.INT;
        String desc9 = jvmPrimitiveType3.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc9, "INT.desc");
        g = Companion.access$method(companion3, "java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        SignatureBuildingComponents signatureBuildingComponents2 = SignatureBuildingComponents.INSTANCE;
        String javaLang = signatureBuildingComponents2.javaLang("Number");
        String desc10 = JvmPrimitiveType.BYTE.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc10, "BYTE.desc");
        String javaLang2 = signatureBuildingComponents2.javaLang("Number");
        String desc11 = JvmPrimitiveType.SHORT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc11, "SHORT.desc");
        String javaLang3 = signatureBuildingComponents2.javaLang("Number");
        String desc12 = jvmPrimitiveType3.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc12, "INT.desc");
        String javaLang4 = signatureBuildingComponents2.javaLang("Number");
        String desc13 = JvmPrimitiveType.LONG.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc13, "LONG.desc");
        String javaLang5 = signatureBuildingComponents2.javaLang("Number");
        String desc14 = JvmPrimitiveType.FLOAT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc14, "FLOAT.desc");
        String javaLang6 = signatureBuildingComponents2.javaLang("Number");
        String desc15 = JvmPrimitiveType.DOUBLE.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc15, "DOUBLE.desc");
        String javaLang7 = signatureBuildingComponents2.javaLang("CharSequence");
        String desc16 = jvmPrimitiveType3.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc16, "INT.desc");
        String desc17 = JvmPrimitiveType.CHAR.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc17, "CHAR.desc");
        Map<Companion.NameAndSignature, Name> mapOf2 = r.mapOf(TuplesKt.to(Companion.access$method(companion3, javaLang, "toByte", "", desc10), Name.identifier("byteValue")), TuplesKt.to(Companion.access$method(companion3, javaLang2, "toShort", "", desc11), Name.identifier("shortValue")), TuplesKt.to(Companion.access$method(companion3, javaLang3, "toInt", "", desc12), Name.identifier("intValue")), TuplesKt.to(Companion.access$method(companion3, javaLang4, "toLong", "", desc13), Name.identifier("longValue")), TuplesKt.to(Companion.access$method(companion3, javaLang5, "toFloat", "", desc14), Name.identifier("floatValue")), TuplesKt.to(Companion.access$method(companion3, javaLang6, "toDouble", "", desc15), Name.identifier("doubleValue")), TuplesKt.to(companion3.getREMOVE_AT_NAME_AND_SIGNATURE(), Name.identifier(ProductAction.ACTION_REMOVE)), TuplesKt.to(Companion.access$method(companion3, javaLang7, "get", desc16, desc17), Name.identifier("charAt")));
        h = mapOf2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(q.mapCapacity(mapOf2.size()));
        for (T t2 : mapOf2.entrySet()) {
            linkedHashMap2.put(((Companion.NameAndSignature) t2.getKey()).getSignature(), t2.getValue());
        }
        i = linkedHashMap2;
        Set<Companion.NameAndSignature> keySet = h.keySet();
        ArrayList arrayList6 = new ArrayList(e.collectionSizeOrDefault(keySet, 10));
        Iterator<T> it2 = keySet.iterator();
        while (it2.hasNext()) {
            arrayList6.add(it2.next().getName());
        }
        j = arrayList6;
        Set<Map.Entry<Companion.NameAndSignature, Name>> entrySet = h.entrySet();
        ArrayList<Pair> arrayList7 = new ArrayList(e.collectionSizeOrDefault(entrySet, 10));
        for (T t3 : entrySet) {
            arrayList7.add(new Pair(((Companion.NameAndSignature) t3.getKey()).getName(), t3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Pair pair : arrayList7) {
            Name name = (Name) pair.getSecond();
            Object obj = linkedHashMap3.get(name);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap3.put(name, obj);
            }
            ((List) obj).add((Name) pair.getFirst());
        }
        k = linkedHashMap3;
    }
}
