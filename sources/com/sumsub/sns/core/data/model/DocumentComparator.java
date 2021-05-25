package com.sumsub.sns.core.data.model;

import com.avito.android.remote.auth.AuthSource;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/core/data/model/DocumentComparator;", "Ljava/util/Comparator;", "Lcom/sumsub/sns/core/data/model/Document;", "Lkotlin/Comparator;", "document1", "document2", "", "compare", "(Lcom/sumsub/sns/core/data/model/Document;Lcom/sumsub/sns/core/data/model/Document;)I", "Lcom/sumsub/sns/core/data/model/Applicant;", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/model/Applicant;", "applicant", "<init>", "(Lcom/sumsub/sns/core/data/model/Applicant;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class DocumentComparator implements Comparator<Document> {
    public final Applicant a;

    public DocumentComparator(@NotNull Applicant applicant) {
        Intrinsics.checkNotNullParameter(applicant, "applicant");
        this.a = applicant;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compare(@org.jetbrains.annotations.Nullable com.sumsub.sns.core.data.model.Document r7, @org.jetbrains.annotations.Nullable com.sumsub.sns.core.data.model.Document r8) {
        /*
            r6 = this;
            r0 = 0
            r1 = -1
            if (r7 == 0) goto L_0x0031
            com.sumsub.sns.core.data.model.Applicant r2 = r6.a
            com.sumsub.sns.core.data.model.Applicant$RequiredIdDocs r2 = r2.getRequiredIdDocs()
            java.util.List r2 = r2.getDocSets()
            java.util.Iterator r2 = r2.iterator()
            r3 = 0
        L_0x0013:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0031
            java.lang.Object r4 = r2.next()
            com.sumsub.sns.core.data.model.Applicant$RequiredIdDocs$DocSetsItem r4 = (com.sumsub.sns.core.data.model.Applicant.RequiredIdDocs.DocSetsItem) r4
            com.sumsub.sns.core.data.model.DocumentType r4 = r4.getIdDocSetType()
            com.sumsub.sns.core.data.model.DocumentType r5 = r7.getType()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 == 0) goto L_0x002e
            goto L_0x0032
        L_0x002e:
            int r3 = r3 + 1
            goto L_0x0013
        L_0x0031:
            r3 = -1
        L_0x0032:
            if (r8 == 0) goto L_0x0061
            com.sumsub.sns.core.data.model.Applicant r7 = r6.a
            com.sumsub.sns.core.data.model.Applicant$RequiredIdDocs r7 = r7.getRequiredIdDocs()
            java.util.List r7 = r7.getDocSets()
            java.util.Iterator r7 = r7.iterator()
        L_0x0042:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L_0x0061
            java.lang.Object r2 = r7.next()
            com.sumsub.sns.core.data.model.Applicant$RequiredIdDocs$DocSetsItem r2 = (com.sumsub.sns.core.data.model.Applicant.RequiredIdDocs.DocSetsItem) r2
            com.sumsub.sns.core.data.model.DocumentType r2 = r2.getIdDocSetType()
            com.sumsub.sns.core.data.model.DocumentType r4 = r8.getType()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
            if (r2 == 0) goto L_0x005e
            r1 = r0
            goto L_0x0061
        L_0x005e:
            int r0 = r0 + 1
            goto L_0x0042
        L_0x0061:
            int r3 = r3 - r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.model.DocumentComparator.compare(com.sumsub.sns.core.data.model.Document, com.sumsub.sns.core.data.model.Document):int");
    }
}
