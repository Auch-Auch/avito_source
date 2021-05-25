package com.avito.android.photo_picker.legacy;

import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.remote.model.ErrorType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"photo-picker_release"}, k = 2, mv = {1, 4, 2})
public final class UploadingProgressInteractorKt {
    public static final boolean access$allAreFinished(List list) {
        boolean z;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PhotoUpload photoUpload = (PhotoUpload) it.next();
            String uploadId = photoUpload.getUploadId();
            if (!(uploadId == null || uploadId.length() == 0) || !Intrinsics.areEqual(photoUpload.getError(), ErrorType.NoError.INSTANCE)) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0009 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int access$countFinished(java.util.List r6) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r6 = r6.iterator()
        L_0x0009:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0041
            java.lang.Object r1 = r6.next()
            r2 = r1
            com.avito.android.photo_picker.PhotoUpload r2 = (com.avito.android.photo_picker.PhotoUpload) r2
            java.lang.String r3 = r2.getUploadId()
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x002b
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0026
            r3 = 1
            goto L_0x0027
        L_0x0026:
            r3 = 0
        L_0x0027:
            if (r3 == 0) goto L_0x002b
            r3 = 1
            goto L_0x002c
        L_0x002b:
            r3 = 0
        L_0x002c:
            if (r3 == 0) goto L_0x003b
            com.avito.android.remote.model.ErrorType r2 = r2.getError()
            com.avito.android.remote.model.ErrorType$NoError r3 = com.avito.android.remote.model.ErrorType.NoError.INSTANCE
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 == 0) goto L_0x003b
            r4 = 1
        L_0x003b:
            if (r4 == 0) goto L_0x0009
            r0.add(r1)
            goto L_0x0009
        L_0x0041:
            int r6 = r0.size()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.photo_picker.legacy.UploadingProgressInteractorKt.access$countFinished(java.util.List):int");
    }

    public static final List access$extractUploadIds(List list) {
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((PhotoUpload) it.next()).getUploadId());
        }
        return CollectionsKt___CollectionsKt.toList(CollectionsKt___CollectionsKt.filterNotNull(arrayList));
    }

    public static final boolean access$hasErrors(List list) {
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!Intrinsics.areEqual(((PhotoUpload) it.next()).getError(), ErrorType.NoError.INSTANCE)) {
                    return true;
                }
            }
        }
        return false;
    }
}
