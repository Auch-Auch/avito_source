package com.avito.android.select;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParcelableEntity;
import java.util.Comparator;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0016\u0010\u0003\u001a\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"2\u0010\t\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00050\u0004j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0005`\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "CLEAR_VARIANT_ID", "Ljava/util/Comparator;", "Lcom/avito/android/remote/model/ParcelableEntity;", "Lkotlin/Comparator;", AuthSource.BOOKING_ORDER, "Ljava/util/Comparator;", "COMPARATOR", "select_release"}, k = 2, mv = {1, 4, 2})
public final class SelectDialogPresenterKt {
    public static final String a = a2.b.a.a.a.E2(SelectDialogPresenterImpl.class, new StringBuilder(), "_clear_variant_id");
    public static final Comparator<ParcelableEntity<String>> b = a.a;

    public static final class a<T> implements Comparator<ParcelableEntity<String>> {
        public static final a a = new a();

        @Override // java.util.Comparator
        public int compare(ParcelableEntity<String> parcelableEntity, ParcelableEntity<String> parcelableEntity2) {
            return parcelableEntity.getId().compareTo(parcelableEntity2.getId());
        }
    }
}
