package com.avito.android.photo_wizard.converter;

import com.avito.android.remote.model.VerificationStepTypeOrientation;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/photo_wizard/converter/DocumentTypesConverterImpl;", "Lcom/avito/android/photo_wizard/converter/DocumentTypesConverter;", "", "Lcom/avito/android/remote/model/VerificationStepType;", "types", "Lcom/avito/android/photo_wizard/DocumentType;", "convert", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public final class DocumentTypesConverterImpl implements DocumentTypesConverter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            VerificationStepTypeOrientation.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            VerificationStepTypeOrientation verificationStepTypeOrientation = VerificationStepTypeOrientation.HORIZONTAL;
            iArr[0] = 1;
            VerificationStepTypeOrientation verificationStepTypeOrientation2 = VerificationStepTypeOrientation.VERTICAL;
            iArr[1] = 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0052 A[SYNTHETIC] */
    @Override // com.avito.android.photo_wizard.converter.DocumentTypesConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.avito.android.photo_wizard.DocumentType> convert(@org.jetbrains.annotations.NotNull java.util.List<com.avito.android.remote.model.VerificationStepType> r10) {
        /*
            r9 = this;
            java.lang.String r0 = "types"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = t6.n.e.collectionSizeOrDefault(r10, r1)
            r0.<init>(r1)
            java.util.Iterator r10 = r10.iterator()
            r1 = 0
            r2 = 0
        L_0x0016:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto L_0x005a
            java.lang.Object r3 = r10.next()
            int r4 = r2 + 1
            if (r2 >= 0) goto L_0x0027
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
        L_0x0027:
            com.avito.android.remote.model.VerificationStepType r3 = (com.avito.android.remote.model.VerificationStepType) r3
            com.avito.android.photo_wizard.DocumentType r5 = new com.avito.android.photo_wizard.DocumentType
            java.lang.String r6 = r3.getValue()
            java.lang.String r7 = r3.getTitle()
            com.avito.android.remote.model.VerificationStepTypeOrientation r3 = r3.getOrientation()
            r8 = 1
            if (r3 != 0) goto L_0x003b
            goto L_0x0043
        L_0x003b:
            int r3 = r3.ordinal()
            if (r3 == 0) goto L_0x004c
            if (r3 != r8) goto L_0x0046
        L_0x0043:
            com.avito.android.photo_wizard.PictureType r3 = com.avito.android.photo_wizard.PictureType.VERTICAL
            goto L_0x004e
        L_0x0046:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L_0x004c:
            com.avito.android.photo_wizard.PictureType r3 = com.avito.android.photo_wizard.PictureType.HORIZONTAL
        L_0x004e:
            if (r2 != 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r8 = 0
        L_0x0052:
            r5.<init>(r6, r7, r3, r8)
            r0.add(r5)
            r2 = r4
            goto L_0x0016
        L_0x005a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.photo_wizard.converter.DocumentTypesConverterImpl.convert(java.util.List):java.util.List");
    }
}
