package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import com.bluejamesbond.text.hyphen.IHyphenator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/util/SoftWrapHyphenator;", "Lcom/bluejamesbond/text/hyphen/IHyphenator;", "", "word", "", "hyphenate", "(Ljava/lang/String;)Ljava/util/List;", "Lkotlin/ranges/IntRange;", "", AuthSource.SEND_ABUSE, "(Ljava/util/List;)I", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SoftWrapHyphenator implements IHyphenator {
    public final int a(List<IntRange> list) {
        IntRange intRange = (IntRange) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list);
        if (intRange != null) {
            return intRange.getEndInclusive().intValue() + 1;
        }
        return 0;
    }

    @Override // com.bluejamesbond.text.hyphen.IHyphenator
    @NotNull
    public List<String> hyphenate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "word");
        ArrayList<IntRange> arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int i3 = i2 + 1;
            if (str.charAt(i) == 173) {
                arrayList.add(new IntRange(a(arrayList), i2 - 1));
            }
            i++;
            i2 = i3;
        }
        if (arrayList.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        arrayList.add(new IntRange(a(arrayList), str.length() - 1));
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        for (IntRange intRange : arrayList) {
            arrayList2.add(StringsKt__StringsKt.substring(str, intRange));
        }
        return arrayList2;
    }
}
