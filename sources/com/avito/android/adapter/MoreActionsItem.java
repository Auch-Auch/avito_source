package com.avito.android.adapter;

import com.avito.android.adapter.HiddenAdvertItem;
import com.avito.android.remote.model.AdvertItemActions;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/adapter/MoreActionsItem;", "Lcom/avito/android/adapter/HiddenAdvertItem;", "Lcom/avito/android/remote/model/AdvertItemActions;", "moreActions", "copyWithMoreActions", "(Lcom/avito/android/remote/model/AdvertItemActions;)Lcom/avito/android/adapter/MoreActionsItem;", "getMoreActions", "()Lcom/avito/android/remote/model/AdvertItemActions;", "advert-item-actions_release"}, k = 1, mv = {1, 4, 2})
public interface MoreActionsItem extends HiddenAdvertItem {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getId(@NotNull MoreActionsItem moreActionsItem) {
            return HiddenAdvertItem.DefaultImpls.getId(moreActionsItem);
        }
    }

    @NotNull
    MoreActionsItem copyWithMoreActions(@NotNull AdvertItemActions advertItemActions);

    @Nullable
    AdvertItemActions getMoreActions();
}
