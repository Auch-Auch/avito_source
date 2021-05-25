package com.sumsub.sns.core.common;

import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ/\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u00020\u00108B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/sumsub/sns/core/common/Bitap;", "", "", "maxErrors", "", "", "text", "", "fuzzySearch", "(I[Ljava/lang/String;)Z", "", "fuzzySearchWithOccurrences", "(I[Ljava/lang/String;)Ljava/util/List;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "pattern", "Lcom/sumsub/sns/core/common/Alphabet;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "()Lcom/sumsub/sns/core/common/Alphabet;", "alphabet", "<init>", "(Ljava/lang/String;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class Bitap {
    public final Lazy a = t6.c.lazy(new a(this));
    public final String b;

    public static final class a extends Lambda implements Function0<Alphabet> {
        public final /* synthetic */ Bitap a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Bitap bitap) {
            super(0);
            this.a = bitap;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Alphabet invoke() {
            return BitapKt.initAlphabet$default(this.a.b, false, 2, null);
        }
    }

    public static final class b extends Lambda implements Function1<Integer, Integer> {
        public final /* synthetic */ Bitap a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Bitap bitap) {
            super(1);
            this.a = bitap;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Integer invoke(Integer num) {
            return Integer.valueOf(BitapKt.bitShiftPattern(num.intValue(), Math.min(this.a.b.length(), 31)));
        }
    }

    public static final class c extends Lambda implements Function1<Integer, Integer> {
        public final /* synthetic */ Bitap a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Bitap bitap) {
            super(1);
            this.a = bitap;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Integer invoke(Integer num) {
            return Integer.valueOf(BitapKt.bitShiftPattern(num.intValue(), Math.min(this.a.b.length(), 31)));
        }
    }

    public Bitap(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "pattern");
        this.b = str;
    }

    public final Alphabet a() {
        return (Alphabet) this.a.getValue();
    }

    public final boolean fuzzySearch(int i, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "text");
        b bVar = new b(this);
        int i2 = i + 1;
        Integer[] numArr = new Integer[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            numArr[i3] = 0;
        }
        ArrayList<String> arrayList = new ArrayList();
        int length = strArr.length;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i4 >= length) {
                break;
            }
            String str = strArr[i4];
            if (str.length() < this.b.length()) {
                z = false;
            }
            if (z) {
                arrayList.add(str);
            }
            i4++;
        }
        ArrayList<String> arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        for (String str2 : arrayList) {
            arrayList2.add(ExtensionsKt.lowerCased(str2));
        }
        for (String str3 : arrayList2) {
            if (StringsKt__StringsKt.contains((CharSequence) str3, (CharSequence) this.b, true)) {
                return true;
            }
            if (i > 0 && this.b.length() > i) {
                ArraysKt___ArraysJvmKt.fill$default((Object[]) numArr, (Object) 0, 0, 0, 6, (Object) null);
                for (int i5 = 0; i5 < str3.length(); i5++) {
                    char charAt = str3.charAt(i5);
                    numArr[0] = Integer.valueOf(((Number) bVar.invoke(numArr[0])).intValue() & ((Number) a().get(Character.valueOf(charAt))).intValue());
                    Iterator it = t6.v.e.downTo(i, 1).iterator();
                    while (it.hasNext()) {
                        int nextInt = ((IntIterator) it).nextInt();
                        numArr[nextInt] = Integer.valueOf((((Number) bVar.invoke(numArr[nextInt])).intValue() & ((Number) a().get(Character.valueOf(charAt))).intValue()) | ((Number) bVar.invoke(numArr[nextInt - 1])).intValue());
                    }
                    if ((numArr[i].intValue() & 1) > 0) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    @NotNull
    public final List<String> fuzzySearchWithOccurrences(int i, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "text");
        ArrayList arrayList = new ArrayList();
        c cVar = new c(this);
        int i2 = i + 1;
        Integer[] numArr = new Integer[i2];
        char c2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            numArr[i3] = 0;
        }
        ArrayList<String> arrayList2 = new ArrayList();
        int length = strArr.length;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i4 >= length) {
                break;
            }
            String str = strArr[i4];
            if (str.length() < this.b.length()) {
                z = false;
            }
            if (z) {
                arrayList2.add(str);
            }
            i4++;
        }
        ArrayList<String> arrayList3 = new ArrayList(e.collectionSizeOrDefault(arrayList2, 10));
        for (String str2 : arrayList2) {
            arrayList3.add(ExtensionsKt.lowerCased(str2));
        }
        for (String str3 : arrayList3) {
            if (StringsKt__StringsKt.contains((CharSequence) str3, (CharSequence) this.b, true)) {
                arrayList.add(str3);
            } else if (i > 0 && this.b.length() > i) {
                ArraysKt___ArraysJvmKt.fill$default((Object[]) numArr, (Object) 0, 0, 0, 6, (Object) null);
                int i5 = 0;
                while (i5 < str3.length()) {
                    char charAt = str3.charAt(i5);
                    numArr[c2] = Integer.valueOf(((Number) cVar.invoke(numArr[c2])).intValue() & ((Number) a().get(Character.valueOf(charAt))).intValue());
                    Iterator it = t6.v.e.downTo(i, 1).iterator();
                    while (it.hasNext()) {
                        int nextInt = ((IntIterator) it).nextInt();
                        numArr[nextInt] = Integer.valueOf((((Number) cVar.invoke(numArr[nextInt])).intValue() & ((Number) a().get(Character.valueOf(charAt))).intValue()) | ((Number) cVar.invoke(numArr[nextInt - 1])).intValue());
                    }
                    if ((numArr[i].intValue() & 1) > 0) {
                        arrayList.add(str3);
                    }
                    i5++;
                    c2 = 0;
                }
            }
            c2 = 0;
        }
        return arrayList;
    }
}
