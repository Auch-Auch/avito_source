package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import a2.b.a.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public final class DescriptorKindFilter {
    @JvmField
    @NotNull
    public static final DescriptorKindFilter ALL;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter CALLABLES;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter CLASSIFIERS;
    @NotNull
    public static final Companion Companion;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter FUNCTIONS;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter NON_SINGLETON_CLASSIFIERS;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter PACKAGES;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter SINGLETON_CLASSIFIERS;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter TYPE_ALIASES;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter VALUES;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter VARIABLES;
    public static int c = 1;
    public static final int d;
    public static final int e;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    @NotNull
    public static final List<Companion.a> n;
    @NotNull
    public static final List<Companion.a> o;
    @NotNull
    public final List<DescriptorKindExclude> a;
    public final int b;

    public static final class Companion {

        public static final class a {
            public final int a;
            @NotNull
            public final String b;

            public a(int i, @NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "name");
                this.a = i;
                this.b = str;
            }
        }

        public Companion() {
        }

        public static final int access$nextMask(Companion companion) {
            Objects.requireNonNull(companion);
            int i = DescriptorKindFilter.c;
            DescriptorKindFilter.c <<= 1;
            return i;
        }

        public final int getALL_KINDS_MASK() {
            return DescriptorKindFilter.j;
        }

        public final int getCALLABLES_MASK() {
            return DescriptorKindFilter.m;
        }

        public final int getCLASSIFIERS_MASK() {
            return DescriptorKindFilter.k;
        }

        public final int getFUNCTIONS_MASK() {
            return DescriptorKindFilter.h;
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.d;
        }

        public final int getPACKAGES_MASK() {
            return DescriptorKindFilter.g;
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.e;
        }

        public final int getTYPE_ALIASES_MASK() {
            return DescriptorKindFilter.f;
        }

        public final int getVALUES_MASK() {
            return DescriptorKindFilter.l;
        }

        public final int getVARIABLES_MASK() {
            return DescriptorKindFilter.i;
        }

        public Companion(j jVar) {
        }
    }

    static {
        Companion.a aVar;
        Companion.a aVar2;
        Companion companion = new Companion(null);
        Companion = companion;
        d = Companion.access$nextMask(companion);
        e = Companion.access$nextMask(companion);
        f = Companion.access$nextMask(companion);
        g = Companion.access$nextMask(companion);
        h = Companion.access$nextMask(companion);
        i = Companion.access$nextMask(companion);
        j = Companion.access$nextMask(companion) - 1;
        k = companion.getNON_SINGLETON_CLASSIFIERS_MASK() | companion.getSINGLETON_CLASSIFIERS_MASK() | companion.getTYPE_ALIASES_MASK();
        l = companion.getSINGLETON_CLASSIFIERS_MASK() | companion.getFUNCTIONS_MASK() | companion.getVARIABLES_MASK();
        m = companion.getFUNCTIONS_MASK() | companion.getVARIABLES_MASK();
        ALL = new DescriptorKindFilter(companion.getALL_KINDS_MASK(), null, 2, null);
        CALLABLES = new DescriptorKindFilter(companion.getCALLABLES_MASK(), null, 2, null);
        NON_SINGLETON_CLASSIFIERS = new DescriptorKindFilter(companion.getNON_SINGLETON_CLASSIFIERS_MASK(), null, 2, null);
        SINGLETON_CLASSIFIERS = new DescriptorKindFilter(companion.getSINGLETON_CLASSIFIERS_MASK(), null, 2, null);
        TYPE_ALIASES = new DescriptorKindFilter(companion.getTYPE_ALIASES_MASK(), null, 2, null);
        CLASSIFIERS = new DescriptorKindFilter(companion.getCLASSIFIERS_MASK(), null, 2, null);
        PACKAGES = new DescriptorKindFilter(companion.getPACKAGES_MASK(), null, 2, null);
        FUNCTIONS = new DescriptorKindFilter(companion.getFUNCTIONS_MASK(), null, 2, null);
        VARIABLES = new DescriptorKindFilter(companion.getVARIABLES_MASK(), null, 2, null);
        VALUES = new DescriptorKindFilter(companion.getVALUES_MASK(), null, 2, null);
        Field[] fields = DescriptorKindFilter.class.getFields();
        Intrinsics.checkNotNullExpressionValue(fields, "T::class.java.fields");
        ArrayList arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Field field2 = (Field) it.next();
            Object obj = field2.get(null);
            DescriptorKindFilter descriptorKindFilter = obj instanceof DescriptorKindFilter ? (DescriptorKindFilter) obj : null;
            if (descriptorKindFilter != null) {
                int kindMask = descriptorKindFilter.getKindMask();
                String name = field2.getName();
                Intrinsics.checkNotNullExpressionValue(name, "field.name");
                aVar2 = new Companion.a(kindMask, name);
            } else {
                aVar2 = null;
            }
            if (aVar2 != null) {
                arrayList2.add(aVar2);
            }
        }
        n = arrayList2;
        Field[] fields2 = DescriptorKindFilter.class.getFields();
        Intrinsics.checkNotNullExpressionValue(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (Intrinsics.areEqual(((Field) next).getType(), Integer.TYPE)) {
                arrayList4.add(next);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            Field field4 = (Field) it3.next();
            Object obj2 = field4.get(null);
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj2).intValue();
            if (intValue == ((-intValue) & intValue)) {
                String name2 = field4.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "field.name");
                aVar = new Companion.a(intValue, name2);
            } else {
                aVar = null;
            }
            if (aVar != null) {
                arrayList5.add(aVar);
            }
        }
        o = arrayList5;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude> */
    /* JADX WARN: Multi-variable type inference failed */
    public DescriptorKindFilter(int i2, @NotNull List<? extends DescriptorKindExclude> list) {
        Intrinsics.checkNotNullParameter(list, "excludes");
        this.a = list;
        for (DescriptorKindExclude descriptorKindExclude : list) {
            i2 &= ~descriptorKindExclude.getFullyExcludedDescriptorKinds();
        }
        this.b = i2;
    }

    public final boolean acceptsKinds(int i2) {
        return (i2 & this.b) != 0;
    }

    @NotNull
    public final List<DescriptorKindExclude> getExcludes() {
        return this.a;
    }

    public final int getKindMask() {
        return this.b;
    }

    @Nullable
    public final DescriptorKindFilter restrictedToKindsOrNull(int i2) {
        int i3 = i2 & this.b;
        if (i3 == 0) {
            return null;
        }
        return new DescriptorKindFilter(i3, this.a);
    }

    @NotNull
    public String toString() {
        T t;
        boolean z;
        Iterator<T> it = n.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.a == getKindMask()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        T t2 = t;
        String str = t2 == null ? null : t2.b;
        if (str == null) {
            List<Companion.a> list = o;
            ArrayList arrayList = new ArrayList();
            for (T t3 : list) {
                String str2 = acceptsKinds(t3.a) ? t3.b : null;
                if (str2 != null) {
                    arrayList.add(str2);
                }
            }
            str = CollectionsKt___CollectionsKt.joinToString$default(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        StringBuilder R = a.R("DescriptorKindFilter(", str, ", ");
        R.append(this.a);
        R.append(')');
        return R.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DescriptorKindFilter(int i2, List list, int i3, j jVar) {
        this(i2, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
