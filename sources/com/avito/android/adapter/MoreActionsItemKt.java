package com.avito.android.adapter;

import com.avito.android.remote.model.AdvertItemActions;
import com.avito.android.remote.model.HideAction;
import com.avito.android.remote.model.ItemAction;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/adapter/MoreActionsItem;", "", "canBeHidden", "(Lcom/avito/android/adapter/MoreActionsItem;)Z", "advert-item-actions_release"}, k = 2, mv = {1, 4, 2})
public final class MoreActionsItemKt {
    public static final boolean canBeHidden(@NotNull MoreActionsItem moreActionsItem) {
        List<ItemAction> actions;
        Intrinsics.checkNotNullParameter(moreActionsItem, "$this$canBeHidden");
        AdvertItemActions moreActions = moreActionsItem.getMoreActions();
        if (moreActions == null || (actions = moreActions.getActions()) == null || actions.isEmpty()) {
            return false;
        }
        Iterator<T> it = actions.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof HideAction) {
                return true;
            }
        }
        return false;
    }
}
