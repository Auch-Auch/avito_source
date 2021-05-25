package com.avito.android.favorite_sellers;

import com.avito.android.FavoriteSeller;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0006R\u0016\u0010\f\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/favorite_sellers/SubscribableItem;", "Lcom/avito/android/FavoriteSeller;", "", "isLoading", "", "setSubscribeLoading", "(Z)V", "setNotificationsLoading", "isSubscribed", "()Z", "setSubscribed", "getRemoveAfterUnsubscribe", "removeAfterUnsubscribe", "isNotificationsActivated", "()Ljava/lang/Boolean;", "setNotificationsActivated", "(Ljava/lang/Boolean;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public interface SubscribableItem extends FavoriteSeller {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void setNotificationsLoading(@NotNull SubscribableItem subscribableItem, boolean z) {
        }

        public static void setSubscribeLoading(@NotNull SubscribableItem subscribableItem, boolean z) {
        }
    }

    boolean getRemoveAfterUnsubscribe();

    @Override // com.avito.android.FavoriteSeller
    @Nullable
    Boolean isNotificationsActivated();

    @Override // com.avito.android.FavoriteSeller
    boolean isSubscribed();

    void setNotificationsActivated(@Nullable Boolean bool);

    void setNotificationsLoading(boolean z);

    void setSubscribeLoading(boolean z);

    void setSubscribed(boolean z);
}
