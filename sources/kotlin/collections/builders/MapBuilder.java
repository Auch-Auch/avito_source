package kotlin.collections.builders;

import a2.g.r.g;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 =*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\b\n}~\u0001\u0001B\t\b\u0016¢\u0006\u0004\b{\u0010(B\u0011\b\u0016\u0012\u0006\u0010|\u001a\u00020\u0004¢\u0006\u0004\b{\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\bJ\u0019\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00192\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u001a\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u001f\u0010 J!\u0010!\u001a\u0004\u0018\u00018\u00012\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0001H\u0016¢\u0006\u0004\b!\u0010\"J%\u0010$\u001a\u00020\u00062\u0014\u0010#\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b&\u0010 J\u000f\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020\u00192\b\u0010*\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0004\b+\u0010\u001dJ\u000f\u0010,\u001a\u00020\u0004H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u00020\u0006H\u0000¢\u0006\u0004\b1\u0010(J\u0017\u00104\u001a\u00020\u00042\u0006\u0010\f\u001a\u00028\u0000H\u0000¢\u0006\u0004\b3\u0010\u000eJ\u0017\u00106\u001a\u00020\u00042\u0006\u0010\f\u001a\u00028\u0000H\u0000¢\u0006\u0004\b5\u0010\u000eJ#\u0010;\u001a\u00020\u00192\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000107H\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010@\u001a\u00020\u00192\n\u0010=\u001a\u0006\u0012\u0002\b\u00030<H\u0000¢\u0006\u0004\b>\u0010?J#\u0010B\u001a\u00020\u00192\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000107H\u0000¢\u0006\u0004\bA\u0010:J\u0017\u0010E\u001a\u00020\u00192\u0006\u0010C\u001a\u00028\u0001H\u0000¢\u0006\u0004\bD\u0010\u001dJ\u001b\u0010I\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010FH\u0000¢\u0006\u0004\bG\u0010HJ\u001b\u0010M\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010JH\u0000¢\u0006\u0004\bK\u0010LJ\u001b\u0010Q\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010NH\u0000¢\u0006\u0004\bO\u0010PR\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00010R8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010VR\u0016\u0010Y\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010XR\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00028\u00000Z8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R(\u0010`\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010^0Z8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b_\u0010\\R$\u0010d\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u00048\u0016@RX\u000e¢\u0006\f\n\u0004\bb\u0010V\u001a\u0004\bc\u0010-R\u001e\u0010f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010eR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010l\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bk\u0010VR\u001e\u0010o\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010m8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010nR\u001e\u0010r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010p8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010qR\u001c\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010eR\u0016\u0010u\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bt\u0010VR$\u0010x\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010v8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010wR\u0016\u0010z\u001a\u00020g8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\by\u0010i¨\u0006\u0001"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", "n", "", "c", "(I)V", "", AuthSource.SEND_ABUSE, "()[Ljava/lang/Object;", "key", "f", "(Ljava/lang/Object;)I", "newHashSize", g.a, "d", "value", "e", FirebaseAnalytics.Param.INDEX, "h", "", "build", "()Ljava/util/Map;", "", "isEmpty", "()Z", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "from", "putAll", "(Ljava/util/Map;)V", ProductAction.ACTION_REMOVE, "clear", "()V", "", "other", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "checkIsMutable$kotlin_stdlib", "checkIsMutable", "addKey$kotlin_stdlib", "addKey", "removeKey$kotlin_stdlib", "removeKey", "", "entry", "containsEntry$kotlin_stdlib", "(Ljava/util/Map$Entry;)Z", "containsEntry", "", AuthSource.OPEN_CHANNEL_LIST, "containsAllEntries$kotlin_stdlib", "(Ljava/util/Collection;)Z", "containsAllEntries", "removeEntry$kotlin_stdlib", "removeEntry", "element", "removeValue$kotlin_stdlib", "removeValue", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator", "", "getValues", "()Ljava/util/Collection;", ResidentialComplexModuleKt.VALUES, "I", "hashShift", "Z", "isReadOnly", "", "getKeys", "()Ljava/util/Set;", "keys", "", "getEntries", "entries", "<set-?>", AuthSource.BOOKING_ORDER, "getSize", "size", "[Ljava/lang/Object;", "valuesArray", "", "j", "[I", "hashArray", "k", "maxProbeDistance", "Lkotlin/collections/builders/MapBuilderValues;", "Lkotlin/collections/builders/MapBuilderValues;", "valuesView", "Lkotlin/collections/builders/MapBuilderKeys;", "Lkotlin/collections/builders/MapBuilderKeys;", "keysView", "keysArray", "l", "length", "Lkotlin/collections/builders/MapBuilderEntries;", "Lkotlin/collections/builders/MapBuilderEntries;", "entriesView", "i", "presenceArray", "<init>", "initialCapacity", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class MapBuilder<K, V> implements Map<K, V>, KMutableMap {
    @NotNull
    public static final a m = new a(null);
    public int a;
    public int b;
    public MapBuilderKeys<K> c;
    public MapBuilderValues<V> d;
    public MapBuilderEntries<K, V> e;
    public boolean f;
    public K[] g;
    public V[] h;
    public int[] i;
    public int[] j;
    public int k;
    public int l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0004B\u001b\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0011\u001a\u00020\u00102\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "next", "()Lkotlin/collections/builders/MapBuilder$EntryRef;", "", "nextHashCode$kotlin_stdlib", "()I", "nextHashCode", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "", "nextAppendString", "(Ljava/lang/StringBuilder;)V", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EntriesItr(@NotNull MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.checkNotNullParameter(mapBuilder, "map");
        }

        public final void nextAppendString(@NotNull StringBuilder sb) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().l) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                Object obj = getMap$kotlin_stdlib().g[getLastIndex$kotlin_stdlib()];
                if (Intrinsics.areEqual(obj, getMap$kotlin_stdlib())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append('=');
                Object[] objArr = getMap$kotlin_stdlib().h;
                Intrinsics.checkNotNull(objArr);
                Object obj2 = objArr[getLastIndex$kotlin_stdlib()];
                if (Intrinsics.areEqual(obj2, getMap$kotlin_stdlib())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                initNext$kotlin_stdlib();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int nextHashCode$kotlin_stdlib() {
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().l) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                Object obj = getMap$kotlin_stdlib().g[getLastIndex$kotlin_stdlib()];
                int i = 0;
                int hashCode = obj != null ? obj.hashCode() : 0;
                Object[] objArr = getMap$kotlin_stdlib().h;
                Intrinsics.checkNotNull(objArr);
                Object obj2 = objArr[getLastIndex$kotlin_stdlib()];
                if (obj2 != null) {
                    i = obj2.hashCode();
                }
                int i2 = hashCode ^ i;
                initNext$kotlin_stdlib();
                return i2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        @NotNull
        public EntryRef<K, V> next() {
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().l) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                EntryRef<K, V> entryRef = new EntryRef<>(getMap$kotlin_stdlib(), getLastIndex$kotlin_stdlib());
                initNext$kotlin_stdlib();
                return entryRef;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B#\u0012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u001a\u0012\u0006\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u00028\u00032\u0006\u0010\u0004\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00028\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00028\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0013R\"\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getKey", "()Ljava/lang/Object;", "key", AuthSource.BOOKING_ORDER, "I", FirebaseAnalytics.Param.INDEX, "getValue", "value", "Lkotlin/collections/builders/MapBuilder;", AuthSource.SEND_ABUSE, "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        public final MapBuilder<K, V> a;
        public final int b;

        public EntryRef(@NotNull MapBuilder<K, V> mapBuilder, int i) {
            Intrinsics.checkNotNullParameter(mapBuilder, "map");
            this.a = mapBuilder;
            this.b = i;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (Intrinsics.areEqual(entry.getKey(), getKey()) && Intrinsics.areEqual(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) this.a.g[this.b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = this.a.h;
            Intrinsics.checkNotNull(objArr);
            return (V) objArr[this.b];
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            K key = getKey();
            int i = 0;
            int hashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            if (value != null) {
                i = value.hashCode();
            }
            return hashCode ^ i;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            this.a.checkIsMutable$kotlin_stdlib();
            Object[] a3 = this.a.a();
            int i = this.b;
            V v2 = (V) a3[i];
            a3[i] = v;
            return v2;
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: K : 0x0005: INVOKE  (r1v0 K) = (r2v0 'this' kotlin.collections.builders.MapBuilder$EntryRef<K, V> A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: kotlin.collections.builders.MapBuilder.EntryRef.getKey():java.lang.Object)), ('=' char), (wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: V : 0x0011: INVOKE  (r1v2 V) = (r2v0 'this' kotlin.collections.builders.MapBuilder$EntryRef<K, V> A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: kotlin.collections.builders.MapBuilder.EntryRef.getValue():java.lang.Object))] */
        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append((Object) getKey());
            sb.append('=');
            sb.append((Object) getValue());
            return sb.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0006R\"\u0010\u0013\u001a\u00020\f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00148\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012¨\u0006 "}, d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", "initNext$kotlin_stdlib", "()V", "initNext", "", "hasNext", "()Z", ProductAction.ACTION_REMOVE, "", AuthSource.BOOKING_ORDER, "I", "getLastIndex$kotlin_stdlib", "()I", "setLastIndex$kotlin_stdlib", "(I)V", "lastIndex", "Lkotlin/collections/builders/MapBuilder;", "c", "Lkotlin/collections/builders/MapBuilder;", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "map", AuthSource.SEND_ABUSE, "getIndex$kotlin_stdlib", "setIndex$kotlin_stdlib", FirebaseAnalytics.Param.INDEX, "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static class Itr<K, V> {
        public int a;
        public int b = -1;
        @NotNull
        public final MapBuilder<K, V> c;

        public Itr(@NotNull MapBuilder<K, V> mapBuilder) {
            Intrinsics.checkNotNullParameter(mapBuilder, "map");
            this.c = mapBuilder;
            initNext$kotlin_stdlib();
        }

        public final int getIndex$kotlin_stdlib() {
            return this.a;
        }

        public final int getLastIndex$kotlin_stdlib() {
            return this.b;
        }

        @NotNull
        public final MapBuilder<K, V> getMap$kotlin_stdlib() {
            return this.c;
        }

        public final boolean hasNext() {
            return this.a < this.c.l;
        }

        public final void initNext$kotlin_stdlib() {
            while (this.a < this.c.l) {
                int[] iArr = this.c.i;
                int i = this.a;
                if (iArr[i] < 0) {
                    this.a = i + 1;
                } else {
                    return;
                }
            }
        }

        public final void remove() {
            this.c.checkIsMutable$kotlin_stdlib();
            this.c.h(this.b);
            this.b = -1;
        }

        public final void setIndex$kotlin_stdlib(int i) {
            this.a = i;
        }

        public final void setLastIndex$kotlin_stdlib(int i) {
            this.b = i;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00028\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/MapBuilder$Itr;", "", "next", "()Ljava/lang/Object;", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMutableIterator {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public KeysItr(@NotNull MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.checkNotNullParameter(mapBuilder, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().l) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                K k = (K) getMap$kotlin_stdlib().g[getLastIndex$kotlin_stdlib()];
                initNext$kotlin_stdlib();
                return k;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00028\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/MapBuilder$Itr;", "", "next", "()Ljava/lang/Object;", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMutableIterator {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ValuesItr(@NotNull MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.checkNotNullParameter(mapBuilder, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().l) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                Object[] objArr = getMap$kotlin_stdlib().h;
                Intrinsics.checkNotNull(objArr);
                V v = (V) objArr[getLastIndex$kotlin_stdlib()];
                initNext$kotlin_stdlib();
                return v;
            }
            throw new NoSuchElementException();
        }
    }

    public static final class a {
        public a(j jVar) {
        }
    }

    public MapBuilder() {
        this(8);
    }

    public final V[] a() {
        V[] vArr = this.h;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) ListBuilderKt.arrayOfUninitializedElements(this.g.length);
        this.h = vArr2;
        return vArr2;
    }

    public final int addKey$kotlin_stdlib(K k2) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int f2 = f(k2);
            int coerceAtMost = e.coerceAtMost(this.k * 2, this.j.length / 2);
            int i2 = 0;
            while (true) {
                int[] iArr = this.j;
                int i3 = iArr[f2];
                if (i3 <= 0) {
                    int i4 = this.l;
                    K[] kArr = this.g;
                    if (i4 >= kArr.length) {
                        c(1);
                    } else {
                        int i5 = i4 + 1;
                        this.l = i5;
                        kArr[i4] = k2;
                        this.i[i4] = f2;
                        iArr[f2] = i5;
                        this.b = size() + 1;
                        if (i2 > this.k) {
                            this.k = i2;
                        }
                        return i4;
                    }
                } else if (Intrinsics.areEqual((Object) this.g[i3 - 1], (Object) k2)) {
                    return -i3;
                } else {
                    i2++;
                    if (i2 > coerceAtMost) {
                        g(this.j.length * 2);
                        break;
                    }
                    f2 = f2 == 0 ? this.j.length - 1 : f2 - 1;
                }
            }
        }
    }

    @NotNull
    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.f = true;
        return this;
    }

    public final void c(int i2) {
        int i3 = this.l;
        int i4 = i2 + i3;
        K[] kArr = this.g;
        if (i4 > kArr.length) {
            int length = (kArr.length * 3) / 2;
            if (i4 <= length) {
                i4 = length;
            }
            this.g = (K[]) ListBuilderKt.copyOfUninitializedElements(kArr, i4);
            V[] vArr = this.h;
            this.h = vArr != null ? (V[]) ListBuilderKt.copyOfUninitializedElements(vArr, i4) : null;
            int[] copyOf = Arrays.copyOf(this.i, i4);
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            this.i = copyOf;
            int highestOneBit = Integer.highestOneBit(e.coerceAtLeast(i4, 1) * 3);
            if (highestOneBit > this.j.length) {
                g(highestOneBit);
            }
        } else if ((i3 + i4) - size() > this.g.length) {
            g(this.j.length);
        }
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.f) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        int i2 = this.l - 1;
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                int[] iArr = this.i;
                int i4 = iArr[i3];
                if (i4 >= 0) {
                    this.j[i4] = 0;
                    iArr[i3] = -1;
                }
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
        }
        ListBuilderKt.resetRange(this.g, 0, this.l);
        V[] vArr = this.h;
        if (vArr != null) {
            ListBuilderKt.resetRange(vArr, 0, this.l);
        }
        this.b = 0;
        this.l = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(@NotNull Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, AuthSource.OPEN_CHANNEL_LIST);
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.collections.builders.MapBuilder<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        int d2 = d(entry.getKey());
        if (d2 < 0) {
            return false;
        }
        V[] vArr = this.h;
        Intrinsics.checkNotNull(vArr);
        return Intrinsics.areEqual(vArr[d2], entry.getValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) >= 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return e(obj) >= 0;
    }

    public final int d(K k2) {
        int f2 = f(k2);
        int i2 = this.k;
        while (true) {
            int i3 = this.j[f2];
            if (i3 == 0) {
                return -1;
            }
            if (i3 > 0) {
                int i4 = i3 - 1;
                if (Intrinsics.areEqual((Object) this.g[i4], (Object) k2)) {
                    return i4;
                }
            }
            i2--;
            if (i2 < 0) {
                return -1;
            }
            f2 = f2 == 0 ? this.j.length - 1 : f2 - 1;
        }
    }

    public final int e(V v) {
        int i2 = this.l;
        while (true) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
            if (this.i[i2] >= 0) {
                V[] vArr = this.h;
                Intrinsics.checkNotNull(vArr);
                if (Intrinsics.areEqual((Object) vArr[i2], (Object) v)) {
                    return i2;
                }
            }
        }
    }

    @NotNull
    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        return new EntriesItr<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map, java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (obj != this) {
            if (!(obj instanceof Map)) {
                return false;
            }
            Map map = (Map) obj;
            if (!(size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet()))) {
                return false;
            }
        }
        return true;
    }

    public final int f(K k2) {
        return ((k2 != null ? k2.hashCode() : 0) * -1640531527) >>> this.a;
    }

    public final void g(int i2) {
        boolean z;
        int i3;
        if (this.l > size()) {
            V[] vArr = this.h;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                i3 = this.l;
                if (i4 >= i3) {
                    break;
                }
                if (this.i[i4] >= 0) {
                    K[] kArr = this.g;
                    kArr[i5] = kArr[i4];
                    if (vArr != null) {
                        vArr[i5] = vArr[i4];
                    }
                    i5++;
                }
                i4++;
            }
            ListBuilderKt.resetRange(this.g, i5, i3);
            if (vArr != null) {
                ListBuilderKt.resetRange(vArr, i5, this.l);
            }
            this.l = i5;
        }
        int[] iArr = this.j;
        if (i2 != iArr.length) {
            this.j = new int[i2];
            this.a = Integer.numberOfLeadingZeros(i2) + 1;
        } else {
            ArraysKt___ArraysJvmKt.fill(iArr, 0, 0, iArr.length);
        }
        int i6 = 0;
        while (i6 < this.l) {
            int i7 = i6 + 1;
            int f2 = f(this.g[i6]);
            int i8 = this.k;
            while (true) {
                int[] iArr2 = this.j;
                if (iArr2[f2] == 0) {
                    iArr2[f2] = i7;
                    this.i[i6] = f2;
                    z = true;
                    break;
                }
                i8--;
                if (i8 < 0) {
                    z = false;
                    break;
                }
                f2 = f2 == 0 ? iArr2.length - 1 : f2 - 1;
            }
            if (z) {
                i6 = i7;
            } else {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        int d2 = d(obj);
        if (d2 < 0) {
            return null;
        }
        V[] vArr = this.h;
        Intrinsics.checkNotNull(vArr);
        return vArr[d2];
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        MapBuilderEntries<K, V> mapBuilderEntries = this.e;
        if (mapBuilderEntries != null) {
            return mapBuilderEntries;
        }
        MapBuilderEntries<K, V> mapBuilderEntries2 = new MapBuilderEntries<>(this);
        this.e = mapBuilderEntries2;
        return mapBuilderEntries2;
    }

    @NotNull
    public Set<K> getKeys() {
        MapBuilderKeys<K> mapBuilderKeys = this.c;
        if (mapBuilderKeys != null) {
            return mapBuilderKeys;
        }
        MapBuilderKeys<K> mapBuilderKeys2 = new MapBuilderKeys<>(this);
        this.c = mapBuilderKeys2;
        return mapBuilderKeys2;
    }

    public int getSize() {
        return this.b;
    }

    @NotNull
    public Collection<V> getValues() {
        MapBuilderValues<V> mapBuilderValues = this.d;
        if (mapBuilderValues != null) {
            return mapBuilderValues;
        }
        MapBuilderValues<V> mapBuilderValues2 = new MapBuilderValues<>(this);
        this.d = mapBuilderValues2;
        return mapBuilderValues2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(int r12) {
        /*
            r11 = this;
            K[] r0 = r11.g
            kotlin.collections.builders.ListBuilderKt.resetAt(r0, r12)
            int[] r0 = r11.i
            r0 = r0[r12]
            int r1 = r11.k
            int r1 = r1 * 2
            int[] r2 = r11.j
            int r2 = r2.length
            int r2 = r2 / 2
            int r1 = t6.v.e.coerceAtMost(r1, r2)
            r2 = 0
            r3 = r1
            r4 = 0
            r1 = r0
        L_0x001a:
            int r5 = r0 + -1
            r6 = -1
            if (r0 != 0) goto L_0x0024
            int[] r0 = r11.j
            int r0 = r0.length
            int r0 = r0 + r6
            goto L_0x0025
        L_0x0024:
            r0 = r5
        L_0x0025:
            int r4 = r4 + 1
            int r5 = r11.k
            if (r4 <= r5) goto L_0x0030
            int[] r0 = r11.j
            r0[r1] = r2
            goto L_0x005f
        L_0x0030:
            int[] r5 = r11.j
            r7 = r5[r0]
            if (r7 != 0) goto L_0x0039
            r5[r1] = r2
            goto L_0x005f
        L_0x0039:
            if (r7 >= 0) goto L_0x003e
            r5[r1] = r6
            goto L_0x0056
        L_0x003e:
            K[] r5 = r11.g
            int r8 = r7 + -1
            r5 = r5[r8]
            int r5 = r11.f(r5)
            int r5 = r5 - r0
            int[] r9 = r11.j
            int r10 = r9.length
            int r10 = r10 + r6
            r5 = r5 & r10
            if (r5 < r4) goto L_0x0058
            r9[r1] = r7
            int[] r4 = r11.i
            r4[r8] = r1
        L_0x0056:
            r1 = r0
            r4 = 0
        L_0x0058:
            int r3 = r3 + r6
            if (r3 >= 0) goto L_0x001a
            int[] r0 = r11.j
            r0[r1] = r6
        L_0x005f:
            int[] r0 = r11.i
            r0[r12] = r6
            int r12 = r11.size()
            int r12 = r12 + r6
            r11.b = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.MapBuilder.h(int):void");
    }

    @Override // java.util.Map, java.lang.Object
    public int hashCode() {
        EntriesItr<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i2 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            i2 += entriesIterator$kotlin_stdlib.nextHashCode$kotlin_stdlib();
        }
        return i2;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @NotNull
    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        return new KeysItr<>(this);
    }

    @Override // java.util.Map
    @Nullable
    public V put(K k2, V v) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(k2);
        V[] a3 = a();
        if (addKey$kotlin_stdlib < 0) {
            int i2 = (-addKey$kotlin_stdlib) - 1;
            V v2 = a3[i2];
            a3[i2] = v;
            return v2;
        }
        a3[addKey$kotlin_stdlib] = v;
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.collections.builders.MapBuilder<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "from");
        checkIsMutable$kotlin_stdlib();
        Set<Map.Entry<? extends K, ? extends V>> entrySet = map.entrySet();
        if (!entrySet.isEmpty()) {
            c(entrySet.size());
            for (Map.Entry<? extends K, ? extends V> entry : entrySet) {
                int addKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
                Object[] a3 = a();
                if (addKey$kotlin_stdlib >= 0) {
                    a3[addKey$kotlin_stdlib] = entry.getValue();
                } else {
                    int i2 = (-addKey$kotlin_stdlib) - 1;
                    if (!Intrinsics.areEqual(entry.getValue(), a3[i2])) {
                        a3[i2] = entry.getValue();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V remove(Object obj) {
        int removeKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (removeKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.h;
        Intrinsics.checkNotNull(vArr);
        V v = vArr[removeKey$kotlin_stdlib];
        ListBuilderKt.resetAt(vArr, removeKey$kotlin_stdlib);
        return v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.collections.builders.MapBuilder<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean removeEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int d2 = d(entry.getKey());
        if (d2 < 0) {
            return false;
        }
        V[] vArr = this.h;
        Intrinsics.checkNotNull(vArr);
        if (!Intrinsics.areEqual(vArr[d2], entry.getValue())) {
            return false;
        }
        h(d2);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K k2) {
        checkIsMutable$kotlin_stdlib();
        int d2 = d(k2);
        if (d2 < 0) {
            return -1;
        }
        h(d2);
        return d2;
    }

    public final boolean removeValue$kotlin_stdlib(V v) {
        checkIsMutable$kotlin_stdlib();
        int e2 = e(v);
        if (e2 < 0) {
            return false;
        }
        h(e2);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        EntriesItr<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i2 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            if (i2 > 0) {
                sb.append(", ");
            }
            entriesIterator$kotlin_stdlib.nextAppendString(sb);
            i2++;
        }
        sb.append("}");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    @NotNull
    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        return new ValuesItr<>(this);
    }

    public MapBuilder(int i2) {
        int[] iArr = new int[i2];
        int highestOneBit = Integer.highestOneBit(e.coerceAtLeast(i2, 1) * 3);
        this.g = (K[]) ListBuilderKt.arrayOfUninitializedElements(i2);
        this.h = null;
        this.i = iArr;
        this.j = new int[highestOneBit];
        this.k = 2;
        this.l = 0;
        this.a = Integer.numberOfLeadingZeros(highestOneBit) + 1;
    }
}
