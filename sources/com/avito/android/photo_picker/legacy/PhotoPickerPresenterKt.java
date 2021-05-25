package com.avito.android.photo_picker.legacy;

import com.avito.android.photo_picker.legacy.thumbnail_list.UriPhotoItem;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"photo-picker_release"}, k = 2, mv = {1, 4, 2})
public final class PhotoPickerPresenterKt {
    /* renamed from: access$getByStringId  reason: collision with other method in class */
    public static final UriPhotoItem m91access$getByStringId(List list, String str) {
        Object obj;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((UriPhotoItem) obj).getStringId(), str)) {
                break;
            }
        }
        return (UriPhotoItem) obj;
    }

    public static final PickerPhoto access$getByStringId(List list, String str) {
        Object obj;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((PickerPhoto) obj).getId().toString(), str)) {
                break;
            }
        }
        return (PickerPhoto) obj;
    }
}
