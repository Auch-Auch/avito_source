package com.avito.android.serp.diff_calculator;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nJ-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/serp/diff_calculator/DiffCalculator;", "", "", "oldSize", "newSize", "replaceStartPosition", "", "Lcom/avito/android/serp/diff_calculator/Diff;", "changes", "(III)Ljava/util/List;", "Impl", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface DiffCalculator {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/serp/diff_calculator/DiffCalculator$Impl;", "Lcom/avito/android/serp/diff_calculator/DiffCalculator;", "", "oldSize", "newSize", "replaceStartPosition", "", "Lcom/avito/android/serp/diff_calculator/Diff;", "changes", "(III)Ljava/util/List;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements DiffCalculator {
        @Override // com.avito.android.serp.diff_calculator.DiffCalculator
        @NotNull
        public List<Diff> changes(int i, int i2, int i3) {
            ArrayList arrayList = new ArrayList();
            int min = Math.min(i2, i) - i3;
            if (min > 0) {
                arrayList.add(new ChangeDiff(i3, min));
            }
            int i4 = i2 - i;
            if (i4 > 0) {
                arrayList.add(new AddDiff(i, i4));
            }
            int i5 = i - i2;
            if (i5 > 0) {
                arrayList.add(new RemoveDiff(i2, i5));
            }
            return arrayList;
        }
    }

    @NotNull
    List<Diff> changes(int i, int i2, int i3);
}
