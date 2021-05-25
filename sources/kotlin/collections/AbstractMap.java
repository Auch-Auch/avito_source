package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@SinceKotlin(version = "1.1")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\f\b'\u0018\u0000 /*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\u0001/B\t\b\u0004¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\u0007J!\u0010\u000e\u001a\u00020\u00052\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\nH\u0000¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00148V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000 8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010$8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010$8\b@\bX\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010+¨\u00060"}, d2 = {"Lkotlin/collections/AbstractMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "key", "", "containsKey", "(Ljava/lang/Object;)Z", "value", "containsValue", "", "entry", "containsEntry$kotlin_stdlib", "(Ljava/util/Map$Entry;)Z", "containsEntry", "", "other", "equals", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "hashCode", "()I", "isEmpty", "()Z", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "getSize", "size", "", "getKeys", "()Ljava/util/Set;", "keys", "", "getValues", "()Ljava/util/Collection;", ResidentialComplexModuleKt.VALUES, AuthSource.BOOKING_ORDER, "Ljava/util/Collection;", "_values", "Ljava/util/Set;", "_keys", "<init>", "()V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public abstract class AbstractMap<K, V> implements Map<K, V>, KMappedMarker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public volatile Set<? extends K> a;
    public volatile Collection<? extends V> b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010&\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\b2\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0010\u001a\u00020\r2\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lkotlin/collections/AbstractMap$Companion;", "", "", "e", "", "entryHashCode$kotlin_stdlib", "(Ljava/util/Map$Entry;)I", "entryHashCode", "", "entryToString$kotlin_stdlib", "(Ljava/util/Map$Entry;)Ljava/lang/String;", "entryToString", "other", "", "entryEquals$kotlin_stdlib", "(Ljava/util/Map$Entry;Ljava/lang/Object;)Z", "entryEquals", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        public Companion() {
        }

        public final boolean entryEquals$kotlin_stdlib(@NotNull Map.Entry<?, ?> entry, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(entry, "e");
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry2 = (Map.Entry) obj;
            if (!Intrinsics.areEqual(entry.getKey(), entry2.getKey()) || !Intrinsics.areEqual(entry.getValue(), entry2.getValue())) {
                return false;
            }
            return true;
        }

        public final int entryHashCode$kotlin_stdlib(@NotNull Map.Entry<?, ?> entry) {
            Intrinsics.checkNotNullParameter(entry, "e");
            Object key = entry.getKey();
            int i = 0;
            int hashCode = key != null ? key.hashCode() : 0;
            Object value = entry.getValue();
            if (value != null) {
                i = value.hashCode();
            }
            return hashCode ^ i;
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x000a: INVOKE  (r1v0 java.lang.Object) = (r3v0 java.util.Map$Entry<?, ?>) type: INTERFACE call: java.util.Map.Entry.getKey():java.lang.Object), ('=' char), (wrap: java.lang.Object : 0x0016: INVOKE  (r3v1 java.lang.Object) = (r3v0 java.util.Map$Entry<?, ?>) type: INTERFACE call: java.util.Map.Entry.getValue():java.lang.Object)] */
        @NotNull
        public final String entryToString$kotlin_stdlib(@NotNull Map.Entry<?, ?> entry) {
            Intrinsics.checkNotNullParameter(entry, "e");
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            return sb.toString();
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Map.Entry<? extends K, ? extends V>, CharSequence> {
        public final /* synthetic */ AbstractMap a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AbstractMap abstractMap) {
            super(1);
            this.a = abstractMap;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Intrinsics.checkNotNullParameter(entry, "it");
            return AbstractMap.access$toString(this.a, entry);
        }
    }

    public static final String access$toString(AbstractMap abstractMap, Map.Entry entry) {
        String str;
        Objects.requireNonNull(abstractMap);
        StringBuilder sb = new StringBuilder();
        Object key = entry.getKey();
        String str2 = "(this Map)";
        if (key == abstractMap) {
            str = str2;
        } else {
            str = String.valueOf(key);
        }
        sb.append(str);
        sb.append("=");
        Object value = entry.getValue();
        if (value != abstractMap) {
            str2 = String.valueOf(value);
        }
        sb.append(str2);
        return sb.toString();
    }

    public final Map.Entry<K, V> a(K k) {
        T t;
        Iterator<T> it = entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getKey(), k)) {
                break;
            }
        }
        return t;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean containsEntry$kotlin_stdlib(@Nullable Map.Entry<?, ?> entry) {
        if (!(entry instanceof Map.Entry)) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        V v = get(key);
        if (!Intrinsics.areEqual(value, v)) {
            return false;
        }
        if (v != null || containsKey(key)) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Set<Map.Entry<K, V>> entrySet = entrySet();
        if ((entrySet instanceof Collection) && entrySet.isEmpty()) {
            return false;
        }
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map, java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        Set<Map.Entry<K, V>> entrySet = map.entrySet();
        if ((entrySet instanceof Collection) && entrySet.isEmpty()) {
            return true;
        }
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            if (!containsEntry$kotlin_stdlib(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        Map.Entry<K, V> a3 = a(obj);
        if (a3 != null) {
            return a3.getValue();
        }
        return null;
    }

    public abstract Set getEntries();

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.Set<? extends K>, java.lang.Object, java.util.Set<K> */
    @NotNull
    public Set<K> getKeys() {
        if (this.a == null) {
            this.a = new AbstractSet<K>(this) { // from class: kotlin.collections.AbstractMap$keys$1
                public final /* synthetic */ AbstractMap a;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.a = r1;
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection
                public boolean contains(Object obj) {
                    return this.a.containsKey(obj);
                }

                @Override // kotlin.collections.AbstractCollection
                public int getSize() {
                    return this.a.size();
                }

                @Override // kotlin.collections.AbstractSet, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
                @NotNull
                public Iterator<K> iterator() {
                    return 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: RETURN  
                          (wrap: kotlin.collections.AbstractMap$keys$1$iterator$1 : 0x000c: CONSTRUCTOR  (r1v0 kotlin.collections.AbstractMap$keys$1$iterator$1) = 
                          (wrap: java.util.Iterator : 0x0006: INVOKE  (r0v2 java.util.Iterator) = 
                          (wrap: java.util.Set : 0x0002: INVOKE  (r0v1 java.util.Set) = 
                          (wrap: kotlin.collections.AbstractMap : 0x0000: IGET  (r0v0 kotlin.collections.AbstractMap) = (r2v0 'this' kotlin.collections.AbstractMap$keys$1 A[IMMUTABLE_TYPE, THIS]) kotlin.collections.AbstractMap$keys$1.a kotlin.collections.AbstractMap)
                         type: VIRTUAL call: kotlin.collections.AbstractMap.entrySet():java.util.Set)
                         type: INTERFACE call: java.util.Set.iterator():java.util.Iterator)
                         call: kotlin.collections.AbstractMap$keys$1$iterator$1.<init>(java.util.Iterator):void type: CONSTRUCTOR)
                         in method: kotlin.collections.AbstractMap$keys$1.iterator():java.util.Iterator<K>, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONSTRUCTOR  (r1v0 kotlin.collections.AbstractMap$keys$1$iterator$1) = 
                          (wrap: java.util.Iterator : 0x0006: INVOKE  (r0v2 java.util.Iterator) = 
                          (wrap: java.util.Set : 0x0002: INVOKE  (r0v1 java.util.Set) = 
                          (wrap: kotlin.collections.AbstractMap : 0x0000: IGET  (r0v0 kotlin.collections.AbstractMap) = (r2v0 'this' kotlin.collections.AbstractMap$keys$1 A[IMMUTABLE_TYPE, THIS]) kotlin.collections.AbstractMap$keys$1.a kotlin.collections.AbstractMap)
                         type: VIRTUAL call: kotlin.collections.AbstractMap.entrySet():java.util.Set)
                         type: INTERFACE call: java.util.Set.iterator():java.util.Iterator)
                         call: kotlin.collections.AbstractMap$keys$1$iterator$1.<init>(java.util.Iterator):void type: CONSTRUCTOR in method: kotlin.collections.AbstractMap$keys$1.iterator():java.util.Iterator<K>, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                        	... 15 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: kotlin.collections.AbstractMap$keys$1$iterator$1, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 19 more
                        */
                    /*
                        this = this;
                        kotlin.collections.AbstractMap r0 = r2.a
                        java.util.Set r0 = r0.entrySet()
                        java.util.Iterator r0 = r0.iterator()
                        kotlin.collections.AbstractMap$keys$1$iterator$1 r1 = new kotlin.collections.AbstractMap$keys$1$iterator$1
                        r1.<init>(r0)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.AbstractMap$keys$1.iterator():java.util.Iterator");
                }
            };
        }
        Set set = (Set<? extends K>) this.a;
        Intrinsics.checkNotNull(set);
        return set;
    }

    public int getSize() {
        return entrySet().size();
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.Collection<? extends V>, java.lang.Object, java.util.Collection<V> */
    @NotNull
    public Collection<V> getValues() {
        if (this.b == null) {
            this.b = new AbstractCollection<V>(this) { // from class: kotlin.collections.AbstractMap$values$1
                public final /* synthetic */ AbstractMap a;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.a = r1;
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection
                public boolean contains(Object obj) {
                    return this.a.containsValue(obj);
                }

                @Override // kotlin.collections.AbstractCollection
                public int getSize() {
                    return this.a.size();
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
                @NotNull
                public Iterator<V> iterator() {
                    return 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: RETURN  
                          (wrap: kotlin.collections.AbstractMap$values$1$iterator$1 : 0x000c: CONSTRUCTOR  (r1v0 kotlin.collections.AbstractMap$values$1$iterator$1) = 
                          (wrap: java.util.Iterator : 0x0006: INVOKE  (r0v2 java.util.Iterator) = 
                          (wrap: java.util.Set : 0x0002: INVOKE  (r0v1 java.util.Set) = 
                          (wrap: kotlin.collections.AbstractMap : 0x0000: IGET  (r0v0 kotlin.collections.AbstractMap) = (r2v0 'this' kotlin.collections.AbstractMap$values$1 A[IMMUTABLE_TYPE, THIS]) kotlin.collections.AbstractMap$values$1.a kotlin.collections.AbstractMap)
                         type: VIRTUAL call: kotlin.collections.AbstractMap.entrySet():java.util.Set)
                         type: INTERFACE call: java.util.Set.iterator():java.util.Iterator)
                         call: kotlin.collections.AbstractMap$values$1$iterator$1.<init>(java.util.Iterator):void type: CONSTRUCTOR)
                         in method: kotlin.collections.AbstractMap$values$1.iterator():java.util.Iterator<V>, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONSTRUCTOR  (r1v0 kotlin.collections.AbstractMap$values$1$iterator$1) = 
                          (wrap: java.util.Iterator : 0x0006: INVOKE  (r0v2 java.util.Iterator) = 
                          (wrap: java.util.Set : 0x0002: INVOKE  (r0v1 java.util.Set) = 
                          (wrap: kotlin.collections.AbstractMap : 0x0000: IGET  (r0v0 kotlin.collections.AbstractMap) = (r2v0 'this' kotlin.collections.AbstractMap$values$1 A[IMMUTABLE_TYPE, THIS]) kotlin.collections.AbstractMap$values$1.a kotlin.collections.AbstractMap)
                         type: VIRTUAL call: kotlin.collections.AbstractMap.entrySet():java.util.Set)
                         type: INTERFACE call: java.util.Set.iterator():java.util.Iterator)
                         call: kotlin.collections.AbstractMap$values$1$iterator$1.<init>(java.util.Iterator):void type: CONSTRUCTOR in method: kotlin.collections.AbstractMap$values$1.iterator():java.util.Iterator<V>, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                        	... 15 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: kotlin.collections.AbstractMap$values$1$iterator$1, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 19 more
                        */
                    /*
                        this = this;
                        kotlin.collections.AbstractMap r0 = r2.a
                        java.util.Set r0 = r0.entrySet()
                        java.util.Iterator r0 = r0.iterator()
                        kotlin.collections.AbstractMap$values$1$iterator$1 r1 = new kotlin.collections.AbstractMap$values$1$iterator$1
                        r1.<init>(r0)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.AbstractMap$values$1.iterator():java.util.Iterator");
                }
            };
        }
        Collection collection = (Collection<? extends V>) this.b;
        Intrinsics.checkNotNull(collection);
        return collection;
    }

    @Override // java.util.Map, java.lang.Object
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return CollectionsKt___CollectionsKt.joinToString$default(entrySet(), ", ", "{", "}", 0, null, new a(this), 24, null);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }
}
