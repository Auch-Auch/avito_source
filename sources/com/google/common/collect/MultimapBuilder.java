package com.google.common.collect;

import a2.j.d.c.b0;
import a2.j.d.c.c0;
import a2.j.d.c.d0;
import a2.j.d.c.e0;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
@GwtCompatible
public abstract class MultimapBuilder<K0, V0> {

    public static abstract class MultimapBuilderWithKeys<K0> {

        public class c extends SetMultimapBuilder<K0, Object> {
            public final /* synthetic */ int a;

            public c(int i) {
                this.a = i;
            }

            @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            /* renamed from: build */
            public <K extends K0, V> SetMultimap<K, V> mo108build() {
                return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.a(), new g(this.a));
            }
        }

        public class d extends SetMultimapBuilder<K0, Object> {
            public final /* synthetic */ int a;

            public d(int i) {
                this.a = i;
            }

            @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            /* renamed from: build */
            public <K extends K0, V> SetMultimap<K, V> mo108build() {
                return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.a(), new h(this.a));
            }
        }

        public class f extends SetMultimapBuilder<K0, V0> {
            public final /* synthetic */ Class a;

            public f(Class cls) {
                this.a = cls;
            }

            @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            /* renamed from: build */
            public <K extends K0, V extends V0> SetMultimap<K, V> mo108build() {
                return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.a(), new f(this.a));
            }
        }

        public abstract <K extends K0, V> Map<K, Collection<V>> a();

        public ListMultimapBuilder<K0, Object> arrayListValues() {
            return arrayListValues(2);
        }

        public <V0 extends Enum<V0>> SetMultimapBuilder<K0, V0> enumSetValues(Class<V0> cls) {
            Preconditions.checkNotNull(cls, "valueClass");
            return new f(cls);
        }

        public SetMultimapBuilder<K0, Object> hashSetValues() {
            return hashSetValues(2);
        }

        public SetMultimapBuilder<K0, Object> linkedHashSetValues() {
            return linkedHashSetValues(2);
        }

        public ListMultimapBuilder<K0, Object> linkedListValues() {
            return new b();
        }

        public SortedSetMultimapBuilder<K0, Comparable> treeSetValues() {
            return treeSetValues(Ordering.natural());
        }

        public class e extends SortedSetMultimapBuilder<K0, V0> {
            public final /* synthetic */ Comparator a;

            public e(Comparator comparator) {
                this.a = comparator;
            }

            @Override // com.google.common.collect.MultimapBuilder.SortedSetMultimapBuilder, com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            /* renamed from: build */
            public <K extends K0, V extends V0> SortedSetMultimap<K, V> mo108build() {
                return Multimaps.newSortedSetMultimap(MultimapBuilderWithKeys.this.a(), new j(this.a));
            }
        }

        public ListMultimapBuilder<K0, Object> arrayListValues(int i) {
            AppCompatDelegateImpl.i.z(i, "expectedValuesPerKey");
            return new a(i);
        }

        public SetMultimapBuilder<K0, Object> hashSetValues(int i) {
            AppCompatDelegateImpl.i.z(i, "expectedValuesPerKey");
            return new c(i);
        }

        public SetMultimapBuilder<K0, Object> linkedHashSetValues(int i) {
            AppCompatDelegateImpl.i.z(i, "expectedValuesPerKey");
            return new d(i);
        }

        public <V0> SortedSetMultimapBuilder<K0, V0> treeSetValues(Comparator<V0> comparator) {
            Preconditions.checkNotNull(comparator, "comparator");
            return new e(comparator);
        }

        public class a extends ListMultimapBuilder<K0, Object> {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
            /* renamed from: build */
            public <K extends K0, V> ListMultimap<K, V> mo108build() {
                return Multimaps.newListMultimap(MultimapBuilderWithKeys.this.a(), new e(this.a));
            }

            @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
            /* renamed from: build  reason: collision with other method in class */
            public Multimap mo108build() {
                return Multimaps.newListMultimap(MultimapBuilderWithKeys.this.a(), new e(this.a));
            }
        }

        public class b extends ListMultimapBuilder<K0, Object> {
            public b() {
            }

            @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
            /* renamed from: build */
            public <K extends K0, V> ListMultimap<K, V> mo108build() {
                return Multimaps.newListMultimap(MultimapBuilderWithKeys.this.a(), i.INSTANCE);
            }

            @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
            /* renamed from: build  reason: collision with other method in class */
            public Multimap mo108build() {
                return Multimaps.newListMultimap(MultimapBuilderWithKeys.this.a(), i.INSTANCE);
            }
        }
    }

    public static class a extends MultimapBuilderWithKeys<Object> {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public <K, V> Map<K, Collection<V>> a() {
            return new b0(this.a);
        }
    }

    public static class b extends MultimapBuilderWithKeys<Object> {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public <K, V> Map<K, Collection<V>> a() {
            return new d0(this.a);
        }
    }

    public static class c extends MultimapBuilderWithKeys<K0> {
        public final /* synthetic */ Comparator a;

        public c(Comparator comparator) {
            this.a = comparator;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public <K extends K0, V> Map<K, Collection<V>> a() {
            return new TreeMap(this.a);
        }
    }

    public static class d extends MultimapBuilderWithKeys<K0> {
        public final /* synthetic */ Class a;

        public d(Class cls) {
            this.a = cls;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public <K extends K0, V> Map<K, Collection<V>> a() {
            return new EnumMap(this.a);
        }
    }

    public static final class e<V> implements Supplier<List<V>>, Serializable {
        public final int a;

        public e(int i) {
            AppCompatDelegateImpl.i.z(i, "expectedValuesPerKey");
            this.a = i;
        }

        @Override // com.google.common.base.Supplier
        public Object get() {
            return new ArrayList(this.a);
        }
    }

    public static final class f<V extends Enum<V>> implements Supplier<Set<V>>, Serializable {
        public final Class<V> a;

        public f(Class<V> cls) {
            this.a = (Class) Preconditions.checkNotNull(cls);
        }

        @Override // com.google.common.base.Supplier
        public Object get() {
            return EnumSet.noneOf(this.a);
        }
    }

    public static final class g<V> implements Supplier<Set<V>>, Serializable {
        public final int a;

        public g(int i) {
            AppCompatDelegateImpl.i.z(i, "expectedValuesPerKey");
            this.a = i;
        }

        @Override // com.google.common.base.Supplier
        public Object get() {
            return new c0(this.a);
        }
    }

    public static final class h<V> implements Supplier<Set<V>>, Serializable {
        public final int a;

        public h(int i) {
            AppCompatDelegateImpl.i.z(i, "expectedValuesPerKey");
            this.a = i;
        }

        @Override // com.google.common.base.Supplier
        public Object get() {
            return new e0(this.a);
        }
    }

    public enum i implements Supplier<List<Object>> {
        INSTANCE;

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.common.base.Supplier
        public List<Object> get() {
            return new LinkedList();
        }
    }

    public static final class j<V> implements Supplier<SortedSet<V>>, Serializable {
        public final Comparator<? super V> a;

        public j(Comparator<? super V> comparator) {
            this.a = (Comparator) Preconditions.checkNotNull(comparator);
        }

        @Override // com.google.common.base.Supplier
        public Object get() {
            return new TreeSet(this.a);
        }
    }

    public MultimapBuilder() {
    }

    public static <K0 extends Enum<K0>> MultimapBuilderWithKeys<K0> enumKeys(Class<K0> cls) {
        Preconditions.checkNotNull(cls);
        return new d(cls);
    }

    public static MultimapBuilderWithKeys<Object> hashKeys() {
        return hashKeys(8);
    }

    public static MultimapBuilderWithKeys<Object> linkedHashKeys() {
        return linkedHashKeys(8);
    }

    public static MultimapBuilderWithKeys<Comparable> treeKeys() {
        return treeKeys(Ordering.natural());
    }

    /* renamed from: build */
    public abstract <K extends K0, V extends V0> Multimap<K, V> mo108build();

    public <K extends K0, V extends V0> Multimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
        Multimap<K, V> build = mo108build();
        build.putAll(multimap);
        return build;
    }

    public static abstract class ListMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        public ListMultimapBuilder() {
            super(null);
        }

        @Override // com.google.common.collect.MultimapBuilder
        /* renamed from: build */
        public abstract <K extends K0, V extends V0> ListMultimap<K, V> mo108build();

        @Override // com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> ListMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (ListMultimap) MultimapBuilder.super.build((Multimap) multimap);
        }
    }

    public static abstract class SetMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        public SetMultimapBuilder() {
            super(null);
        }

        @Override // com.google.common.collect.MultimapBuilder
        /* renamed from: build */
        public abstract <K extends K0, V extends V0> SetMultimap<K, V> mo108build();

        @Override // com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> SetMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (SetMultimap) MultimapBuilder.super.build((Multimap) multimap);
        }
    }

    public MultimapBuilder(a aVar) {
    }

    public static MultimapBuilderWithKeys<Object> hashKeys(int i2) {
        AppCompatDelegateImpl.i.z(i2, "expectedKeys");
        return new a(i2);
    }

    public static MultimapBuilderWithKeys<Object> linkedHashKeys(int i2) {
        AppCompatDelegateImpl.i.z(i2, "expectedKeys");
        return new b(i2);
    }

    public static <K0> MultimapBuilderWithKeys<K0> treeKeys(Comparator<K0> comparator) {
        Preconditions.checkNotNull(comparator);
        return new c(comparator);
    }

    public static abstract class SortedSetMultimapBuilder<K0, V0> extends SetMultimapBuilder<K0, V0> {
        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        /* renamed from: build */
        public abstract <K extends K0, V extends V0> SortedSetMultimap<K, V> mo108build();

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> SortedSetMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (SortedSetMultimap) super.build((Multimap) multimap);
        }
    }
}
