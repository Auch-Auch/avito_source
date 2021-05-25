package com.avito.android.lib.design.promo_block.grouping;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/lib/design/promo_block/grouping/GroupingListProcessorImpl;", "Lcom/avito/android/lib/design/promo_block/grouping/GroupingListProcessor;", "T", "", "list", "fillOutput", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class GroupingListProcessorImpl implements GroupingListProcessor {
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ba, code lost:
        if (((com.avito.android.lib.design.promo_block.grouping.GroupableItem) r3).getCloseable() != false) goto L_0x00be;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0073  */
    @Override // com.avito.android.lib.design.promo_block.grouping.GroupingListProcessor
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.util.List<T> fillOutput(@org.jetbrains.annotations.NotNull java.util.List<? extends T> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "list"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = t6.n.e.collectionSizeOrDefault(r12, r1)
            r0.<init>(r1)
            java.util.Iterator r1 = r12.iterator()
            r2 = 0
            r3 = 0
        L_0x0016:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00ce
            java.lang.Object r4 = r1.next()
            int r5 = r3 + 1
            if (r3 >= 0) goto L_0x0027
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
        L_0x0027:
            boolean r6 = r4 instanceof com.avito.android.lib.design.promo_block.grouping.GroupableItem
            if (r6 == 0) goto L_0x00c8
            r6 = r4
            com.avito.android.lib.design.promo_block.grouping.GroupableItem r6 = (com.avito.android.lib.design.promo_block.grouping.GroupableItem) r6
            com.avito.android.lib.design.promo_block.grouping.GroupingOutput r7 = r6.getOutput()
            java.lang.Object r8 = r12.get(r3)
            boolean r9 = r8 instanceof com.avito.android.lib.design.promo_block.grouping.GroupableItem
            r10 = 1
            if (r9 == 0) goto L_0x0046
            com.avito.android.lib.design.promo_block.grouping.GroupableItem r8 = (com.avito.android.lib.design.promo_block.grouping.GroupableItem) r8
            boolean r8 = r8.getCloseable()
            if (r8 == 0) goto L_0x0046
            com.avito.android.lib.design.promo_block.grouping.EdgeMode r8 = com.avito.android.lib.design.promo_block.grouping.EdgeMode.ROUNDED
            goto L_0x0075
        L_0x0046:
            if (r3 == 0) goto L_0x0051
            int r8 = r3 + -1
            java.lang.Object r8 = r12.get(r8)
            boolean r8 = r8 instanceof com.avito.android.lib.design.promo_block.grouping.GroupableItem
            goto L_0x0052
        L_0x0051:
            r8 = 0
        L_0x0052:
            if (r8 != 0) goto L_0x0057
            com.avito.android.lib.design.promo_block.grouping.EdgeMode r8 = com.avito.android.lib.design.promo_block.grouping.EdgeMode.ROUNDED
            goto L_0x0075
        L_0x0057:
            if (r3 == 0) goto L_0x006d
            int r8 = r3 + -1
            java.lang.Object r8 = r12.get(r8)
            boolean r9 = r8 instanceof com.avito.android.lib.design.promo_block.grouping.GroupableItem
            if (r9 == 0) goto L_0x006d
            com.avito.android.lib.design.promo_block.grouping.GroupableItem r8 = (com.avito.android.lib.design.promo_block.grouping.GroupableItem) r8
            boolean r8 = r8.getCloseable()
            if (r8 == 0) goto L_0x006d
            r8 = 1
            goto L_0x006e
        L_0x006d:
            r8 = 0
        L_0x006e:
            if (r8 == 0) goto L_0x0073
            com.avito.android.lib.design.promo_block.grouping.EdgeMode r8 = com.avito.android.lib.design.promo_block.grouping.EdgeMode.ROUNDED
            goto L_0x0075
        L_0x0073:
            com.avito.android.lib.design.promo_block.grouping.EdgeMode r8 = com.avito.android.lib.design.promo_block.grouping.EdgeMode.FLAT
        L_0x0075:
            r7.setTopEdge$components_release(r8)
            com.avito.android.lib.design.promo_block.grouping.GroupingOutput r6 = r6.getOutput()
            java.lang.Object r7 = r12.get(r3)
            boolean r8 = r7 instanceof com.avito.android.lib.design.promo_block.grouping.GroupableItem
            if (r8 == 0) goto L_0x008f
            com.avito.android.lib.design.promo_block.grouping.GroupableItem r7 = (com.avito.android.lib.design.promo_block.grouping.GroupableItem) r7
            boolean r7 = r7.getCloseable()
            if (r7 == 0) goto L_0x008f
            com.avito.android.lib.design.promo_block.grouping.EdgeMode r3 = com.avito.android.lib.design.promo_block.grouping.EdgeMode.ROUNDED
            goto L_0x00c5
        L_0x008f:
            int r7 = r12.size()
            int r7 = r7 + -1
            if (r3 != r7) goto L_0x0099
            r7 = 0
            goto L_0x009f
        L_0x0099:
            java.lang.Object r7 = r12.get(r5)
            boolean r7 = r7 instanceof com.avito.android.lib.design.promo_block.grouping.GroupableItem
        L_0x009f:
            if (r7 != 0) goto L_0x00a4
            com.avito.android.lib.design.promo_block.grouping.EdgeMode r3 = com.avito.android.lib.design.promo_block.grouping.EdgeMode.ROUNDED
            goto L_0x00c5
        L_0x00a4:
            int r7 = r12.size()
            int r7 = r7 - r10
            if (r3 != r7) goto L_0x00ac
            goto L_0x00bd
        L_0x00ac:
            java.lang.Object r3 = r12.get(r5)
            boolean r7 = r3 instanceof com.avito.android.lib.design.promo_block.grouping.GroupableItem
            if (r7 == 0) goto L_0x00bd
            com.avito.android.lib.design.promo_block.grouping.GroupableItem r3 = (com.avito.android.lib.design.promo_block.grouping.GroupableItem) r3
            boolean r3 = r3.getCloseable()
            if (r3 == 0) goto L_0x00bd
            goto L_0x00be
        L_0x00bd:
            r10 = 0
        L_0x00be:
            if (r10 == 0) goto L_0x00c3
            com.avito.android.lib.design.promo_block.grouping.EdgeMode r3 = com.avito.android.lib.design.promo_block.grouping.EdgeMode.ROUNDED
            goto L_0x00c5
        L_0x00c3:
            com.avito.android.lib.design.promo_block.grouping.EdgeMode r3 = com.avito.android.lib.design.promo_block.grouping.EdgeMode.FLAT
        L_0x00c5:
            r6.setBottomEdge$components_release(r3)
        L_0x00c8:
            r0.add(r4)
            r3 = r5
            goto L_0x0016
        L_0x00ce:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.promo_block.grouping.GroupingListProcessorImpl.fillOutput(java.util.List):java.util.List");
    }
}
