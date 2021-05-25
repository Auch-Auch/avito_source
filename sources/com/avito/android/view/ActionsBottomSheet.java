package com.avito.android.view;

import com.avito.android.advert.actions.AdvertItemActionsPresenter;
import com.avito.android.remote.model.ItemAction;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JS\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/avito/android/view/ActionsBottomSheet;", "", "", "title", "", "Lcom/avito/android/remote/model/ItemAction;", "actions", "id", "categoryId", "", "locationId", "feedId", VKApiConst.POSITION, "", "showBottomActionsMenu", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;I)V", "Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;", "getActionsMenuPresenter", "()Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;", "setActionsMenuPresenter", "(Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;)V", "actionsMenuPresenter", "advert-item-actions_release"}, k = 1, mv = {1, 4, 2})
public interface ActionsBottomSheet {
    @Nullable
    AdvertItemActionsPresenter getActionsMenuPresenter();

    void setActionsMenuPresenter(@Nullable AdvertItemActionsPresenter advertItemActionsPresenter);

    void showBottomActionsMenu(@Nullable String str, @NotNull List<? extends ItemAction> list, @NotNull String str2, @Nullable String str3, @Nullable Integer num, @NotNull String str4, int i);
}
