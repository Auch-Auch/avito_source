package com.avito.android.advert.actions;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/actions/HiddenAdvertsStorageImpl;", "Lcom/avito/android/advert/actions/HiddenAdvertsStorage;", "", BookingInfoActivity.EXTRA_ITEM_ID, "", "put", "(Ljava/lang/String;)V", "", "isHidden", "(Ljava/lang/String;)Z", "", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "hiddenItems", "<init>", "()V", "advert-item-actions_release"}, k = 1, mv = {1, 4, 2})
public final class HiddenAdvertsStorageImpl implements HiddenAdvertsStorage {
    public final Set<String> a = new LinkedHashSet();

    @Override // com.avito.android.advert.actions.HiddenAdvertsStorage
    public boolean isHidden(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        return this.a.contains(str);
    }

    @Override // com.avito.android.advert.actions.HiddenAdvertsStorage
    public void put(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.a.add(str);
    }
}
