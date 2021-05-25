package com.avito.android.photo_picker.legacy.service;

import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.photo_picker.legacy.service.ImageUploadServiceDelegate;
import com.avito.android.remote.model.ErrorType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t6.n.e;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"photo-picker_release"}, k = 2, mv = {1, 4, 2})
public final class ImageUploadServiceDelegateKt {
    public static final ImageUploadServiceDelegate.UploadingEvent access$foldToSingleEvent(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ImageUploadServiceDelegate.UploadingEvent) obj) instanceof ImageUploadServiceDelegate.UploadingEvent.Error) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return new ImageUploadServiceDelegate.UploadingEvent.Success();
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ImageUploadServiceDelegate.UploadingEvent uploadingEvent = (ImageUploadServiceDelegate.UploadingEvent) it.next();
            Collection<Throwable> collection = null;
            if (!(uploadingEvent instanceof ImageUploadServiceDelegate.UploadingEvent.Error)) {
                uploadingEvent = null;
            }
            ImageUploadServiceDelegate.UploadingEvent.Error error = (ImageUploadServiceDelegate.UploadingEvent.Error) uploadingEvent;
            if (error != null) {
                collection = error.getCauses();
            }
            arrayList2.add(collection);
        }
        return new ImageUploadServiceDelegate.UploadingEvent.Error(e.flatten(CollectionsKt___CollectionsKt.filterNotNull(arrayList2)));
    }

    public static final boolean access$needUpload(PhotoUpload photoUpload, boolean z) {
        if (photoUpload.getContentUri() == null) {
            return false;
        }
        String uploadId = photoUpload.getUploadId();
        if (!(uploadId == null || m.isBlank(uploadId))) {
            return false;
        }
        if (z || (!Intrinsics.areEqual(photoUpload.getError(), ErrorType.NonRestorableError.INSTANCE))) {
            return true;
        }
        return false;
    }
}
