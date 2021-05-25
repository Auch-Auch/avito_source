package okio;

import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.g;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\n\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0018J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000f8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", FirebaseAnalytics.Param.INDEX, "get", "(I)Lokio/ByteString;", "", AuthSource.BOOKING_ORDER, "[I", "getTrie$okio", "()[I", "trie", "", AuthSource.SEND_ABUSE, "[Lokio/ByteString;", "getByteStrings$okio", "()[Lokio/ByteString;", "byteStrings", "getSize", "()I", "size", "Companion", "okio"}, k = 1, mv = {1, 4, 0})
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final ByteString[] a;
    @NotNull
    public final int[] b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J[\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\b*\u00020\n8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lokio/Options$Companion;", "", "", "Lokio/ByteString;", "byteStrings", "Lokio/Options;", "of", "([Lokio/ByteString;)Lokio/Options;", "", "nodeOffset", "Lokio/Buffer;", "node", "", "byteStringOffset", "", "fromIndex", "toIndex", "indexes", "", AuthSource.SEND_ABUSE, "(JLokio/Buffer;ILjava/util/List;IILjava/util/List;)V", AuthSource.BOOKING_ORDER, "(Lokio/Buffer;)J", "intCount", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public final void a(long j, Buffer buffer, int i, List<? extends ByteString> list, int i2, int i3, List<Integer> list2) {
            int i4;
            int i5;
            int i6;
            int i7;
            Buffer buffer2;
            int i8 = i;
            if (i2 < i3) {
                for (int i9 = i2; i9 < i3; i9++) {
                    if (!(((ByteString) list.get(i9)).size() >= i8)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                ByteString byteString = (ByteString) list.get(i2);
                ByteString byteString2 = (ByteString) list.get(i3 - 1);
                if (i8 == byteString.size()) {
                    int i10 = i2 + 1;
                    i4 = i10;
                    i5 = list2.get(i2).intValue();
                    byteString = (ByteString) list.get(i10);
                } else {
                    i4 = i2;
                    i5 = -1;
                }
                if (byteString.getByte(i8) != byteString2.getByte(i8)) {
                    int i11 = 1;
                    for (int i12 = i4 + 1; i12 < i3; i12++) {
                        if (((ByteString) list.get(i12 - 1)).getByte(i8) != ((ByteString) list.get(i12)).getByte(i8)) {
                            i11++;
                        }
                    }
                    long b = b(buffer) + j + ((long) 2) + ((long) (i11 * 2));
                    buffer.writeInt(i11);
                    buffer.writeInt(i5);
                    for (int i13 = i4; i13 < i3; i13++) {
                        byte b2 = ((ByteString) list.get(i13)).getByte(i8);
                        if (i13 == i4 || b2 != ((ByteString) list.get(i13 - 1)).getByte(i8)) {
                            buffer.writeInt(b2 & 255);
                        }
                    }
                    Buffer buffer3 = new Buffer();
                    while (i4 < i3) {
                        byte b3 = ((ByteString) list.get(i4)).getByte(i8);
                        int i14 = i4 + 1;
                        int i15 = i14;
                        while (true) {
                            if (i15 >= i3) {
                                i6 = i3;
                                break;
                            } else if (b3 != ((ByteString) list.get(i15)).getByte(i8)) {
                                i6 = i15;
                                break;
                            } else {
                                i15++;
                            }
                        }
                        if (i14 == i6 && i8 + 1 == ((ByteString) list.get(i4)).size()) {
                            buffer.writeInt(list2.get(i4).intValue());
                            i7 = i6;
                            buffer2 = buffer3;
                        } else {
                            buffer.writeInt(((int) (b(buffer3) + b)) * -1);
                            i7 = i6;
                            buffer2 = buffer3;
                            a(b, buffer3, i8 + 1, list, i4, i6, list2);
                        }
                        buffer3 = buffer2;
                        i4 = i7;
                    }
                    buffer.writeAll(buffer3);
                    return;
                }
                int min = Math.min(byteString.size(), byteString2.size());
                int i16 = i8;
                int i17 = 0;
                while (i16 < min && byteString.getByte(i16) == byteString2.getByte(i16)) {
                    i17++;
                    i16++;
                }
                long b4 = b(buffer) + j + ((long) 2) + ((long) i17) + 1;
                buffer.writeInt(-i17);
                buffer.writeInt(i5);
                int i18 = i8 + i17;
                while (i8 < i18) {
                    buffer.writeInt(byteString.getByte(i8) & 255);
                    i8++;
                }
                if (i4 + 1 == i3) {
                    if (i18 == ((ByteString) list.get(i4)).size()) {
                        buffer.writeInt(list2.get(i4).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                Buffer buffer4 = new Buffer();
                buffer.writeInt(((int) (b(buffer4) + b4)) * -1);
                a(b4, buffer4, i18, list, i4, i3, list2);
                buffer.writeAll(buffer4);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public final long b(Buffer buffer) {
            return buffer.size() / ((long) 4);
        }

        @JvmStatic
        @NotNull
        public final Options of(@NotNull ByteString... byteStringArr) {
            Intrinsics.checkNotNullParameter(byteStringArr, "byteStrings");
            int i = 0;
            if (byteStringArr.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, null);
            }
            List<? extends ByteString> mutableList = ArraysKt___ArraysKt.toMutableList(byteStringArr);
            g.sort(mutableList);
            ArrayList arrayList = new ArrayList(byteStringArr.length);
            for (ByteString byteString : byteStringArr) {
                arrayList.add(-1);
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Integer[] numArr = (Integer[]) array;
            List<Integer> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf((Integer[]) Arrays.copyOf(numArr, numArr.length));
            int length = byteStringArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                mutableListOf.set(CollectionsKt__CollectionsKt.binarySearch$default(mutableList, byteStringArr[i2], 0, 0, 6, (Object) null), Integer.valueOf(i3));
                i2++;
                i3++;
            }
            if (((ByteString) mutableList.get(0)).size() > 0) {
                int i4 = 0;
                while (i4 < mutableList.size()) {
                    ByteString byteString2 = (ByteString) mutableList.get(i4);
                    int i5 = i4 + 1;
                    int i6 = i5;
                    while (i6 < mutableList.size()) {
                        ByteString byteString3 = (ByteString) mutableList.get(i6);
                        if (!byteString3.startsWith(byteString2)) {
                            continue;
                            break;
                        }
                        if (!(byteString3.size() != byteString2.size())) {
                            throw new IllegalArgumentException(("duplicate option: " + byteString3).toString());
                        } else if (mutableListOf.get(i6).intValue() > mutableListOf.get(i4).intValue()) {
                            mutableList.remove(i6);
                            mutableListOf.remove(i6);
                        } else {
                            i6++;
                        }
                    }
                    i4 = i5;
                }
                Buffer buffer = new Buffer();
                a(0, buffer, 0, mutableList, 0, mutableList.size(), mutableListOf);
                int[] iArr = new int[((int) b(buffer))];
                while (!buffer.exhausted()) {
                    iArr[i] = buffer.readInt();
                    i++;
                }
                Object[] copyOf = Arrays.copyOf(byteStringArr, byteStringArr.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
                return new Options((ByteString[]) copyOf, iArr, null);
            }
            throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
        }

        public Companion(j jVar) {
        }
    }

    public Options(ByteString[] byteStringArr, int[] iArr, j jVar) {
        this.a = byteStringArr;
        this.b = iArr;
    }

    @JvmStatic
    @NotNull
    public static final Options of(@NotNull ByteString... byteStringArr) {
        return Companion.of(byteStringArr);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    @NotNull
    public final ByteString[] getByteStrings$okio() {
        return this.a;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.a.length;
    }

    @NotNull
    public final int[] getTrie$okio() {
        return this.b;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Object) byteString);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    @NotNull
    public ByteString get(int i) {
        return this.a[i];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Object) byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Object) byteString);
    }
}
