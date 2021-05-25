package com.avito.android.advert_core.specifications;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.LayoutTypeProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert_core/specifications/SpecificationsConverterImpl;", "Lcom/avito/android/advert_core/specifications/SpecificationsConverter;", "Lcom/avito/android/remote/model/ModelSpecifications;", "specifications", "", "schemePos", "Lkotlin/Pair;", "", "Lcom/avito/android/advert_core/specifications/SpecificationData;", "convertSpecifications", "(Lcom/avito/android/remote/model/ModelSpecifications;I)Lkotlin/Pair;", "Lcom/avito/android/serp/adapter/LayoutTypeProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/LayoutTypeProvider;", "layoutTypeProvider", "<init>", "(Lcom/avito/android/serp/adapter/LayoutTypeProvider;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class SpecificationsConverterImpl implements SpecificationsConverter {
    public final LayoutTypeProvider a;

    @Inject
    public SpecificationsConverterImpl(@NotNull LayoutTypeProvider layoutTypeProvider) {
        Intrinsics.checkNotNullParameter(layoutTypeProvider, "layoutTypeProvider");
        this.a = layoutTypeProvider;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c0 A[ADDED_TO_REGION] */
    @Override // com.avito.android.advert_core.specifications.SpecificationsConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.Pair<java.lang.Integer, java.util.List<com.avito.android.advert_core.specifications.SpecificationData>> convertSpecifications(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.ModelSpecifications r10, int r11) {
        /*
            r9 = this;
            java.lang.String r0 = "specifications"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            com.avito.android.serp.adapter.LayoutTypeProvider r0 = r9.a
            com.avito.android.serp.adapter.LayoutType r0 = r0.getLayoutType()
            int r1 = r0.getColumnCount()
            com.avito.android.serp.adapter.SerpViewType r2 = com.avito.android.serp.adapter.SerpViewType.BIG
            int r0 = r0.getColumnCount(r2)
            int r1 = r1 / r0
            java.lang.String r0 = r10.getModelTitle()
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0027
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r0 = 0
            goto L_0x0028
        L_0x0027:
            r0 = 1
        L_0x0028:
            r4 = 0
            if (r0 == 0) goto L_0x002d
            r0 = r4
            goto L_0x0039
        L_0x002d:
            com.avito.android.advert_core.specifications.SpecificationData$TitleData r0 = new com.avito.android.advert_core.specifications.SpecificationData$TitleData
            java.lang.String r5 = r10.getModelTitle()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r0.<init>(r5, r1)
        L_0x0039:
            r5 = -1
            if (r11 == r5) goto L_0x0055
            int r5 = r1 + -1
            int r5 = java.lang.Math.max(r3, r5)
            com.avito.android.remote.model.ModelSpecifications$Scheme r6 = r10.getScheme()
            if (r6 == 0) goto L_0x0055
            com.avito.android.advert_core.specifications.SpecificationData$SchemeData r6 = new com.avito.android.advert_core.specifications.SpecificationData$SchemeData
            com.avito.android.remote.model.ModelSpecifications$Scheme r7 = r10.getScheme()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r6.<init>(r7, r5)
            goto L_0x0056
        L_0x0055:
            r6 = r4
        L_0x0056:
            java.util.List r5 = r10.getBlocks()
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r3
            if (r5 == 0) goto L_0x0070
            java.util.List r4 = r10.getBlocks()
            java.lang.Object r2 = r4.get(r2)
            com.avito.android.remote.model.ModelSpecifications$Block r2 = (com.avito.android.remote.model.ModelSpecifications.Block) r2
            com.avito.android.advert_core.specifications.SpecificationData$BlockData r4 = new com.avito.android.advert_core.specifications.SpecificationData$BlockData
            r4.<init>(r2, r3)
        L_0x0070:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            if (r0 == 0) goto L_0x007a
            r2.add(r0)
        L_0x007a:
            r0 = -2
            if (r11 != r0) goto L_0x0095
            if (r1 > r3) goto L_0x008a
            if (r6 == 0) goto L_0x0084
            r2.add(r6)
        L_0x0084:
            if (r4 == 0) goto L_0x00b4
            r2.add(r4)
            goto L_0x00b4
        L_0x008a:
            if (r4 == 0) goto L_0x008f
            r2.add(r4)
        L_0x008f:
            if (r6 == 0) goto L_0x00b4
            r2.add(r6)
            goto L_0x00b4
        L_0x0095:
            if (r11 == 0) goto L_0x00aa
            if (r11 == r3) goto L_0x009f
            if (r4 == 0) goto L_0x00b4
            r2.add(r4)
            goto L_0x00b4
        L_0x009f:
            if (r4 == 0) goto L_0x00a4
            r2.add(r4)
        L_0x00a4:
            if (r6 == 0) goto L_0x00b4
            r2.add(r6)
            goto L_0x00b4
        L_0x00aa:
            if (r6 == 0) goto L_0x00af
            r2.add(r6)
        L_0x00af:
            if (r4 == 0) goto L_0x00b4
            r2.add(r4)
        L_0x00b4:
            r0 = 2
            java.util.List r4 = r10.getBlocks()
            int r4 = r4.size()
            r5 = 1
        L_0x00be:
            if (r5 >= r4) goto L_0x00de
            if (r0 != r11) goto L_0x00c7
            if (r6 == 0) goto L_0x00c7
            r2.add(r6)
        L_0x00c7:
            java.util.List r7 = r10.getBlocks()
            java.lang.Object r7 = r7.get(r5)
            com.avito.android.remote.model.ModelSpecifications$Block r7 = (com.avito.android.remote.model.ModelSpecifications.Block) r7
            com.avito.android.advert_core.specifications.SpecificationData$BlockData r8 = new com.avito.android.advert_core.specifications.SpecificationData$BlockData
            r8.<init>(r7, r3)
            r2.add(r8)
            int r0 = r0 + 1
            int r5 = r5 + 1
            goto L_0x00be
        L_0x00de:
            kotlin.Pair r10 = new kotlin.Pair
            java.lang.Integer r11 = java.lang.Integer.valueOf(r1)
            r10.<init>(r11, r2)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert_core.specifications.SpecificationsConverterImpl.convertSpecifications(com.avito.android.remote.model.ModelSpecifications, int):kotlin.Pair");
    }
}
