package kotlin.collections;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.v.e;
@SinceKotlin(version = "1.4")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u001a\b\u0007\u0018\u0000 J*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001JB\u0011\b\u0016\u0012\u0006\u0010G\u001a\u00020\u0016¢\u0006\u0004\bH\u00108B\t\b\u0016¢\u0006\u0004\bH\u0010+B\u0017\b\u0016\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0004\bH\u0010IJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\n\u0010\u0007J\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0011\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0011\u0010\u0007J\r\u0010\u0012\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0007J\u000f\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0013\u0010\u0007J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0018J\u001d\u0010\u001b\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001dJ\u0018\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ \u0010 \u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\"\u0010\u0015J\u0017\u0010#\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b%\u0010$J\u0017\u0010&\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b&\u0010\u0015J\u0017\u0010'\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b'\u0010\u001fJ\u001d\u0010(\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016¢\u0006\u0004\b(\u0010\u001cJ\u001d\u0010)\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016¢\u0006\u0004\b)\u0010\u001cJ\u000f\u0010*\u001a\u00020\fH\u0016¢\u0006\u0004\b*\u0010+JO\u00105\u001a\u00020\f2>\u00102\u001a:\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010100¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\f0,H\u0000¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\f2\u0006\u00106\u001a\u00020\u0016H\u0002¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b;\u0010:J%\u0010=\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0002¢\u0006\u0004\b=\u0010>R\u0016\u0010/\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010?R\u001e\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u000101008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR$\u0010F\u001a\u00020\u00162\u0006\u0010C\u001a\u00020\u00168\u0016@RX\u000e¢\u0006\f\n\u0004\b;\u0010?\u001a\u0004\bD\u0010E¨\u0006K"}, d2 = {"Lkotlin/collections/ArrayDeque;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableList;", "", "isEmpty", "()Z", InternalConstsKt.FIRST_IMAGE, "()Ljava/lang/Object;", "firstOrNull", "last", "lastOrNull", "element", "", "addFirst", "(Ljava/lang/Object;)V", "addLast", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", ProductAction.ACTION_ADD, "(Ljava/lang/Object;)Z", "", FirebaseAnalytics.Param.INDEX, "(ILjava/lang/Object;)V", "", MessengerShareContentUtility.ELEMENTS, "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "get", "(I)Ljava/lang/Object;", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "contains", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", ProductAction.ACTION_REMOVE, "removeAt", "removeAll", "retainAll", "clear", "()V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "", "", "structure", "internalStructure$kotlin_stdlib", "(Lkotlin/jvm/functions/Function2;)V", "internalStructure", "minCapacity", "d", "(I)V", "e", "(I)I", "c", "internalIndex", AuthSource.SEND_ABUSE, "(ILjava/util/Collection;)V", "I", AuthSource.BOOKING_ORDER, "[Ljava/lang/Object;", "elementData", "<set-?>", "getSize", "()I", "size", "initialCapacity", "<init>", "(Ljava/util/Collection;)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final Object[] d = new Object[0];
    public int a;
    public Object[] b;
    public int c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\t¨\u0006\u0010"}, d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "(II)I", "newCapacity", "defaultMinCapacity", "I", "", "emptyElementData", "[Ljava/lang/Object;", "maxArraySize", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        public Companion() {
        }

        public final int newCapacity$kotlin_stdlib(int i, int i2) {
            int i3 = i + (i >> 1);
            if (i3 - i2 < 0) {
                i3 = i2;
            }
            return i3 - 2147483639 > 0 ? i2 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i3;
        }

        public Companion(j jVar) {
        }
    }

    public ArrayDeque(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = d;
        } else if (i > 0) {
            objArr = new Object[i];
        } else {
            throw new IllegalArgumentException(a.M2("Illegal Capacity: ", i));
        }
        this.b = objArr;
    }

    public static final int access$negativeMod(ArrayDeque arrayDeque, int i) {
        Objects.requireNonNull(arrayDeque);
        return i < 0 ? i + arrayDeque.b.length : i;
    }

    public static final int access$positiveMod(ArrayDeque arrayDeque, int i) {
        Object[] objArr = arrayDeque.b;
        return i >= objArr.length ? i - objArr.length : i;
    }

    public final void a(int i, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.b.length;
        while (i < length && it.hasNext()) {
            this.b[i] = it.next();
            i++;
        }
        int i2 = this.a;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.b[i3] = it.next();
        }
        this.c = collection.size() + size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        if (collection.isEmpty()) {
            return false;
        }
        d(collection.size() + size());
        a(access$positiveMod(this, this.a + size()), collection);
        return true;
    }

    public final void addFirst(E e) {
        d(size() + 1);
        int c2 = c(this.a);
        this.a = c2;
        this.b[c2] = e;
        this.c = size() + 1;
    }

    public final void addLast(E e) {
        d(size() + 1);
        this.b[access$positiveMod(this, this.a + size())] = e;
        this.c = size() + 1;
    }

    public final int c(int i) {
        return i == 0 ? ArraysKt___ArraysKt.getLastIndex(this.b) : i - 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public void clear() {
        int access$positiveMod = access$positiveMod(this, this.a + size());
        int i = this.a;
        if (i < access$positiveMod) {
            ArraysKt___ArraysJvmKt.fill(this.b, (Object) null, i, access$positiveMod);
        } else if (!isEmpty()) {
            Object[] objArr = this.b;
            ArraysKt___ArraysJvmKt.fill(objArr, (Object) null, this.a, objArr.length);
            ArraysKt___ArraysJvmKt.fill(this.b, (Object) null, 0, access$positiveMod);
        }
        this.a = 0;
        this.c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i) {
        if (i >= 0) {
            Object[] objArr = this.b;
            if (i > objArr.length) {
                if (objArr == d) {
                    this.b = new Object[e.coerceAtLeast(i, 10)];
                    return;
                }
                Object[] objArr2 = new Object[Companion.newCapacity$kotlin_stdlib(objArr.length, i)];
                Object[] objArr3 = this.b;
                ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr2, 0, this.a, objArr3.length);
                Object[] objArr4 = this.b;
                int length = objArr4.length;
                int i2 = this.a;
                ArraysKt___ArraysJvmKt.copyInto(objArr4, objArr2, length - i2, 0, i2);
                this.a = 0;
                this.b = objArr2;
                return;
            }
            return;
        }
        throw new IllegalStateException("Deque is too big.");
    }

    public final int e(int i) {
        if (i == ArraysKt___ArraysKt.getLastIndex(this.b)) {
            return 0;
        }
        return i + 1;
    }

    public final E first() {
        if (!isEmpty()) {
            return (E) this.b[this.a];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Nullable
    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.b[this.a];
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        return (E) this.b[access$positiveMod(this, this.a + i)];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i;
        int access$positiveMod = access$positiveMod(this, this.a + size());
        int i2 = this.a;
        if (i2 < access$positiveMod) {
            while (i2 < access$positiveMod) {
                if (Intrinsics.areEqual(obj, this.b[i2])) {
                    i = this.a;
                } else {
                    i2++;
                }
            }
            return -1;
        } else if (i2 < access$positiveMod) {
            return -1;
        } else {
            int length = this.b.length;
            while (true) {
                if (i2 >= length) {
                    for (int i3 = 0; i3 < access$positiveMod; i3++) {
                        if (Intrinsics.areEqual(obj, this.b[i3])) {
                            i2 = i3 + this.b.length;
                            i = this.a;
                        }
                    }
                    return -1;
                } else if (Intrinsics.areEqual(obj, this.b[i2])) {
                    i = this.a;
                    break;
                } else {
                    i2++;
                }
            }
        }
        return i2 - i;
    }

    /* JADX DEBUG: Type inference failed for r1v8. Raw type applied. Possible types: ? super java.lang.Object[] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void internalStructure$kotlin_stdlib(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Object[], kotlin.Unit> r15) {
        /*
            r14 = this;
            java.lang.String r0 = "structure"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            int r0 = r14.size()
            int r1 = access$getHead$p(r14)
            int r1 = r1 + r0
            int r6 = access$positiveMod(r14, r1)
            boolean r0 = r14.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0025
            int r0 = r14.a
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r15.invoke(r0, r1)
            return
        L_0x0025:
            int r0 = r14.size()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            int r10 = r14.a
            if (r10 >= r6) goto L_0x0043
            java.lang.Object[] r2 = r14.b
            r4 = 0
            r7 = 2
            r8 = 0
            r3 = r0
            r5 = r10
            kotlin.collections.ArraysKt___ArraysJvmKt.copyInto$default(r2, r3, r4, r5, r6, r7, r8)
            int r1 = r14.a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r15.invoke(r1, r0)
            goto L_0x0064
        L_0x0043:
            java.lang.Object[] r7 = r14.b
            r9 = 0
            r11 = 0
            r12 = 10
            r13 = 0
            r8 = r0
            kotlin.collections.ArraysKt___ArraysJvmKt.copyInto$default(r7, r8, r9, r10, r11, r12, r13)
            java.lang.Object[] r2 = r14.b
            int r3 = r2.length
            int r4 = r14.a
            int r3 = r3 - r4
            kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(r2, r0, r3, r1, r6)
            int r1 = r14.a
            java.lang.Object[] r2 = r14.b
            int r2 = r2.length
            int r1 = r1 - r2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r15.invoke(r1, r0)
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.internalStructure$kotlin_stdlib(kotlin.jvm.functions.Function2):void");
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    public final E last() {
        if (!isEmpty()) {
            return (E) this.b[access$positiveMod(this, this.a + CollectionsKt__CollectionsKt.getLastIndex(this))];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int lastIndex;
        int i;
        int access$positiveMod = access$positiveMod(this, this.a + size());
        int i2 = this.a;
        if (i2 < access$positiveMod) {
            lastIndex = access$positiveMod - 1;
            if (lastIndex < i2) {
                return -1;
            }
            while (!Intrinsics.areEqual(obj, this.b[lastIndex])) {
                if (lastIndex == i2) {
                    return -1;
                }
                lastIndex--;
            }
            i = this.a;
        } else if (i2 <= access$positiveMod) {
            return -1;
        } else {
            int i3 = access$positiveMod - 1;
            while (true) {
                if (i3 < 0) {
                    lastIndex = ArraysKt___ArraysKt.getLastIndex(this.b);
                    int i4 = this.a;
                    if (lastIndex < i4) {
                        return -1;
                    }
                    while (!Intrinsics.areEqual(obj, this.b[lastIndex])) {
                        if (lastIndex == i4) {
                            return -1;
                        }
                        lastIndex--;
                    }
                    i = this.a;
                } else if (Intrinsics.areEqual(obj, this.b[i3])) {
                    lastIndex = i3 + this.b.length;
                    i = this.a;
                    break;
                } else {
                    i3--;
                }
            }
        }
        return lastIndex - i;
    }

    @Nullable
    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.b[access$positiveMod(this, this.a + CollectionsKt__CollectionsKt.getLastIndex(this))];
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.b.length == 0)) {
                int access$positiveMod = access$positiveMod(this, this.a + size());
                int i = this.a;
                if (this.a < access$positiveMod) {
                    for (int i2 = this.a; i2 < access$positiveMod; i2++) {
                        Object obj = this.b[i2];
                        if (!collection.contains(obj)) {
                            this.b[i] = obj;
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    ArraysKt___ArraysJvmKt.fill(this.b, (Object) null, i, access$positiveMod);
                } else {
                    int length = this.b.length;
                    boolean z2 = false;
                    for (int i3 = this.a; i3 < length; i3++) {
                        Object obj2 = this.b[i3];
                        this.b[i3] = null;
                        if (!collection.contains(obj2)) {
                            this.b[i] = obj2;
                            i++;
                        } else {
                            z2 = true;
                        }
                    }
                    i = access$positiveMod(this, i);
                    for (int i4 = 0; i4 < access$positiveMod; i4++) {
                        Object obj3 = this.b[i4];
                        this.b[i4] = null;
                        if (!collection.contains(obj3)) {
                            this.b[i] = obj3;
                            i = e(i);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.c = access$negativeMod(this, i - this.a);
                }
            }
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        if (i == CollectionsKt__CollectionsKt.getLastIndex(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        int access$positiveMod = access$positiveMod(this, this.a + i);
        E e = (E) this.b[access$positiveMod];
        if (i < (size() >> 1)) {
            int i2 = this.a;
            if (access$positiveMod >= i2) {
                Object[] objArr = this.b;
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i2 + 1, i2, access$positiveMod);
            } else {
                Object[] objArr2 = this.b;
                ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, 1, 0, access$positiveMod);
                Object[] objArr3 = this.b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i3 = this.a;
                ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, i3 + 1, i3, objArr3.length - 1);
            }
            Object[] objArr4 = this.b;
            int i4 = this.a;
            objArr4[i4] = null;
            this.a = e(i4);
        } else {
            int access$positiveMod2 = access$positiveMod(this, this.a + CollectionsKt__CollectionsKt.getLastIndex(this));
            if (access$positiveMod <= access$positiveMod2) {
                Object[] objArr5 = this.b;
                ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, access$positiveMod, access$positiveMod + 1, access$positiveMod2 + 1);
            } else {
                Object[] objArr6 = this.b;
                ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, access$positiveMod, access$positiveMod + 1, objArr6.length);
                Object[] objArr7 = this.b;
                objArr7[objArr7.length - 1] = objArr7[0];
                ArraysKt___ArraysJvmKt.copyInto(objArr7, objArr7, 0, 1, access$positiveMod2 + 1);
            }
            this.b[access$positiveMod2] = null;
        }
        this.c = size() - 1;
        return e;
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            E e = (E) this.b[this.a];
            Object[] objArr = this.b;
            int i = this.a;
            objArr[i] = null;
            this.a = e(i);
            this.c = size() - 1;
            return e;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Nullable
    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E removeLast() {
        if (!isEmpty()) {
            int access$positiveMod = access$positiveMod(this, this.a + CollectionsKt__CollectionsKt.getLastIndex(this));
            E e = (E) this.b[access$positiveMod];
            this.b[access$positiveMod] = null;
            this.c = size() - 1;
            return e;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Nullable
    public final E removeLastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.b.length == 0)) {
                int access$positiveMod = access$positiveMod(this, this.a + size());
                int i = this.a;
                if (this.a < access$positiveMod) {
                    for (int i2 = this.a; i2 < access$positiveMod; i2++) {
                        Object obj = this.b[i2];
                        if (collection.contains(obj)) {
                            this.b[i] = obj;
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    ArraysKt___ArraysJvmKt.fill(this.b, (Object) null, i, access$positiveMod);
                } else {
                    int length = this.b.length;
                    boolean z2 = false;
                    for (int i3 = this.a; i3 < length; i3++) {
                        Object obj2 = this.b[i3];
                        this.b[i3] = null;
                        if (collection.contains(obj2)) {
                            this.b[i] = obj2;
                            i++;
                        } else {
                            z2 = true;
                        }
                    }
                    i = access$positiveMod(this, i);
                    for (int i4 = 0; i4 < access$positiveMod; i4++) {
                        Object obj3 = this.b[i4];
                        this.b[i4] = null;
                        if (collection.contains(obj3)) {
                            this.b[i] = obj3;
                            i = e(i);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.c = access$negativeMod(this, i - this.a);
                }
            }
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        int access$positiveMod = access$positiveMod(this, this.a + i);
        E e2 = (E) this.b[access$positiveMod];
        this.b[access$positiveMod] = e;
        return e2;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, size());
        if (i == size()) {
            addLast(e);
        } else if (i == 0) {
            addFirst(e);
        } else {
            d(size() + 1);
            int access$positiveMod = access$positiveMod(this, this.a + i);
            if (i < ((size() + 1) >> 1)) {
                int c2 = c(access$positiveMod);
                int c3 = c(this.a);
                int i2 = this.a;
                if (c2 >= i2) {
                    Object[] objArr = this.b;
                    objArr[c3] = objArr[i2];
                    ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i2, i2 + 1, c2 + 1);
                } else {
                    Object[] objArr2 = this.b;
                    ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, i2 - 1, i2, objArr2.length);
                    Object[] objArr3 = this.b;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, 0, 1, c2 + 1);
                }
                this.b[c2] = e;
                this.a = c3;
            } else {
                int access$positiveMod2 = access$positiveMod(this, this.a + size());
                if (access$positiveMod < access$positiveMod2) {
                    Object[] objArr4 = this.b;
                    ArraysKt___ArraysJvmKt.copyInto(objArr4, objArr4, access$positiveMod + 1, access$positiveMod, access$positiveMod2);
                } else {
                    Object[] objArr5 = this.b;
                    ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, 1, 0, access$positiveMod2);
                    Object[] objArr6 = this.b;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, access$positiveMod + 1, access$positiveMod, objArr6.length - 1);
                }
                this.b[access$positiveMod] = e;
            }
            this.c = size() + 1;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, @NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i == size()) {
            return addAll(collection);
        }
        d(collection.size() + size());
        int access$positiveMod = access$positiveMod(this, this.a + size());
        int access$positiveMod2 = access$positiveMod(this, this.a + i);
        int size = collection.size();
        if (i < ((size() + 1) >> 1)) {
            int i2 = this.a;
            int i3 = i2 - size;
            if (access$positiveMod2 < i2) {
                Object[] objArr = this.b;
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i3, i2, objArr.length);
                if (size >= access$positiveMod2) {
                    Object[] objArr2 = this.b;
                    ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, objArr2.length - size, 0, access$positiveMod2);
                } else {
                    Object[] objArr3 = this.b;
                    ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.b;
                    ArraysKt___ArraysJvmKt.copyInto(objArr4, objArr4, 0, size, access$positiveMod2);
                }
            } else if (i3 >= 0) {
                Object[] objArr5 = this.b;
                ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, i3, i2, access$positiveMod2);
            } else {
                Object[] objArr6 = this.b;
                i3 += objArr6.length;
                int i4 = access$positiveMod2 - i2;
                int length = objArr6.length - i3;
                if (length >= i4) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, i3, i2, access$positiveMod2);
                } else {
                    ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, i3, i2, i2 + length);
                    Object[] objArr7 = this.b;
                    ArraysKt___ArraysJvmKt.copyInto(objArr7, objArr7, 0, this.a + length, access$positiveMod2);
                }
            }
            this.a = i3;
            int i5 = access$positiveMod2 - size;
            if (i5 < 0) {
                i5 += this.b.length;
            }
            a(i5, collection);
        } else {
            int i6 = access$positiveMod2 + size;
            if (access$positiveMod2 < access$positiveMod) {
                int i7 = size + access$positiveMod;
                Object[] objArr8 = this.b;
                if (i7 <= objArr8.length) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, i6, access$positiveMod2, access$positiveMod);
                } else if (i6 >= objArr8.length) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, i6 - objArr8.length, access$positiveMod2, access$positiveMod);
                } else {
                    int length2 = access$positiveMod - (i7 - objArr8.length);
                    ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, 0, length2, access$positiveMod);
                    Object[] objArr9 = this.b;
                    ArraysKt___ArraysJvmKt.copyInto(objArr9, objArr9, i6, access$positiveMod2, length2);
                }
            } else {
                Object[] objArr10 = this.b;
                ArraysKt___ArraysJvmKt.copyInto(objArr10, objArr10, size, 0, access$positiveMod);
                Object[] objArr11 = this.b;
                if (i6 >= objArr11.length) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr11, objArr11, i6 - objArr11.length, access$positiveMod2, objArr11.length);
                } else {
                    ArraysKt___ArraysJvmKt.copyInto(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.b;
                    ArraysKt___ArraysJvmKt.copyInto(objArr12, objArr12, i6, access$positiveMod2, objArr12.length - size);
                }
            }
            a(access$positiveMod2, collection);
        }
        return true;
    }

    public ArrayDeque() {
        this.b = d;
    }

    public ArrayDeque(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        boolean z = false;
        Object[] array = collection.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.b = array;
        this.c = array.length;
        if (array.length == 0 ? true : z) {
            this.b = d;
        }
    }
}
