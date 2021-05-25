package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLoadingKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.q;
import t6.v.e;
public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {
    @NotNull
    public final JavaClass a;
    @NotNull
    public final Function1<JavaMember, Boolean> b;
    @NotNull
    public final Function1<JavaMethod, Boolean> c;
    @NotNull
    public final Map<Name, List<JavaMethod>> d;
    @NotNull
    public final Map<Name, JavaField> e;
    @NotNull
    public final Map<Name, JavaRecordComponent> f;

    public static final class a extends Lambda implements Function1<JavaMethod, Boolean> {
        public final /* synthetic */ ClassDeclaredMemberIndex a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ClassDeclaredMemberIndex classDeclaredMemberIndex) {
            super(1);
            this.a = classDeclaredMemberIndex;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(JavaMethod javaMethod) {
            JavaMethod javaMethod2 = javaMethod;
            Intrinsics.checkNotNullParameter(javaMethod2, AuthSource.OPEN_CHANNEL_LIST);
            return Boolean.valueOf(((Boolean) this.a.b.invoke(javaMethod2)).booleanValue() && !JavaLoadingKt.isObjectMethodInInterface(javaMethod2));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public ClassDeclaredMemberIndex(@NotNull JavaClass javaClass, @NotNull Function1<? super JavaMember, Boolean> function1) {
        Intrinsics.checkNotNullParameter(javaClass, "jClass");
        Intrinsics.checkNotNullParameter(function1, "memberFilter");
        this.a = javaClass;
        this.b = function1;
        a aVar = new a(this);
        this.c = aVar;
        Sequence filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(javaClass.getMethods()), aVar);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : filter) {
            Name name = ((JavaMethod) obj).getName();
            Object obj2 = linkedHashMap.get(name);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(name, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.d = linkedHashMap;
        Sequence filter2 = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(this.a.getFields()), this.b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj3 : filter2) {
            linkedHashMap2.put(((JavaField) obj3).getName(), obj3);
        }
        this.e = linkedHashMap2;
        Collection<JavaRecordComponent> recordComponents = this.a.getRecordComponents();
        Function1<JavaMember, Boolean> function12 = this.b;
        ArrayList arrayList = new ArrayList();
        for (T t : recordComponents) {
            if (function12.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj4 : arrayList) {
            linkedHashMap3.put(((JavaRecordComponent) obj4).getName(), obj4);
        }
        this.f = linkedHashMap3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @Nullable
    public JavaField findFieldByName(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.e.get(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @NotNull
    public Collection<JavaMethod> findMethodsByName(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<JavaMethod> list = this.d.get(name);
        return list == null ? CollectionsKt__CollectionsKt.emptyList() : list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @Nullable
    public JavaRecordComponent findRecordComponentByName(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f.get(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @NotNull
    public Set<Name> getFieldNames() {
        Sequence<JavaNamedElement> filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(this.a.getFields()), this.b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaNamedElement javaNamedElement : filter) {
            linkedHashSet.add(javaNamedElement.getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @NotNull
    public Set<Name> getMethodNames() {
        Sequence<JavaNamedElement> filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(this.a.getMethods()), this.c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaNamedElement javaNamedElement : filter) {
            linkedHashSet.add(javaNamedElement.getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    @NotNull
    public Set<Name> getRecordComponentNames() {
        return this.f.keySet();
    }
}
