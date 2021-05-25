package com.avito.android.serp.adapter.item_sorter;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/serp/adapter/item_sorter/SerpItemSorterImpl;", "Lcom/avito/android/serp/adapter/item_sorter/SerpItemSorter;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "T", "", "list", "", "columns", "sort", "(Ljava/util/List;I)Ljava/util/List;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpItemSorterImpl implements SerpItemSorter {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:55:0x0091 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0091 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.util.List, java.util.List<T extends com.avito.android.serp.adapter.ViewTypeSerpItem>, java.util.Collection, java.lang.Object, java.util.List<? extends T extends com.avito.android.serp.adapter.ViewTypeSerpItem>] */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.util.Collection, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.util.List] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // com.avito.android.serp.adapter.item_sorter.SerpItemSorter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends com.avito.android.serp.adapter.ViewTypeSerpItem> java.util.List<T> sort(@org.jetbrains.annotations.NotNull java.util.List<? extends T> r14, int r15) {
        /*
            r13 = this;
            java.lang.String r0 = "list"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1
            if (r15 != r0) goto L_0x0009
            return r14
        L_0x0009:
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r14.size()
            r1.<init>(r2)
            java.util.LinkedList r2 = new java.util.LinkedList
            r2.<init>(r14)
        L_0x0017:
            boolean r14 = r2.isEmpty()
            r14 = r14 ^ r0
            if (r14 == 0) goto L_0x00cd
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.ListIterator r3 = r2.listIterator()
            java.lang.String r4 = "source.listIterator()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r4 = 0
            r5 = 0
        L_0x002e:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x00c8
            if (r5 >= r15) goto L_0x00c8
            java.lang.Object r6 = r3.next()
            com.avito.android.serp.adapter.ViewTypeSerpItem r6 = (com.avito.android.serp.adapter.ViewTypeSerpItem) r6
            int r7 = r6.getSpanCount()
            int r7 = t6.v.e.coerceAtMost(r7, r15)
            int r7 = r7 + r5
            if (r7 <= r15) goto L_0x00bf
            boolean r8 = r6 instanceof com.avito.android.serp.adapter.PersistableSerpItem
            if (r8 != 0) goto L_0x004d
            r8 = 0
            goto L_0x004e
        L_0x004d:
            r8 = r6
        L_0x004e:
            com.avito.android.serp.adapter.PersistableSerpItem r8 = (com.avito.android.serp.adapter.PersistableSerpItem) r8
            if (r8 == 0) goto L_0x005a
            boolean r8 = r8.getHasStablePosition()
            if (r8 != r0) goto L_0x005a
            r8 = 1
            goto L_0x005b
        L_0x005a:
            r8 = 0
        L_0x005b:
            if (r8 == 0) goto L_0x005f
            goto L_0x00c8
        L_0x005f:
            int r7 = r7 - r15
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            int r9 = r14.size()
            int r9 = r9 - r0
            r10 = 0
        L_0x006b:
            if (r9 < 0) goto L_0x0091
            java.lang.Object r11 = r14.get(r9)
            com.avito.android.serp.adapter.ViewTypeSerpItem r11 = (com.avito.android.serp.adapter.ViewTypeSerpItem) r11
            int r12 = r11.getSpanCount()
            int r12 = t6.v.e.coerceAtMost(r12, r15)
            if (r12 != r7) goto L_0x0087
            com.avito.android.serp.adapter.ViewTypeSerpItem[] r8 = new com.avito.android.serp.adapter.ViewTypeSerpItem[r0]
            r8[r4] = r11
            java.util.List r8 = kotlin.collections.CollectionsKt__CollectionsKt.mutableListOf(r8)
            r10 = r12
            goto L_0x0091
        L_0x0087:
            int r12 = r12 + r10
            if (r12 >= r7) goto L_0x008e
            r8.add(r11)
            r10 = r12
        L_0x008e:
            int r9 = r9 + -1
            goto L_0x006b
        L_0x0091:
            if (r10 != r7) goto L_0x0094
            goto L_0x0098
        L_0x0094:
            java.util.List r8 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0098:
            boolean r7 = r8.isEmpty()
            r7 = r7 ^ r0
            if (r7 == 0) goto L_0x002e
            r14.removeAll(r8)
            r14.add(r6)
            r3.remove()
            java.util.Iterator r5 = r8.iterator()
        L_0x00ac:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00bc
            java.lang.Object r6 = r5.next()
            com.avito.android.serp.adapter.ViewTypeSerpItem r6 = (com.avito.android.serp.adapter.ViewTypeSerpItem) r6
            r3.add(r6)
            goto L_0x00ac
        L_0x00bc:
            r5 = r15
            goto L_0x002e
        L_0x00bf:
            r14.add(r6)
            r3.remove()
            r5 = r7
            goto L_0x002e
        L_0x00c8:
            r1.addAll(r14)
            goto L_0x0017
        L_0x00cd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.adapter.item_sorter.SerpItemSorterImpl.sort(java.util.List, int):java.util.List");
    }
}
