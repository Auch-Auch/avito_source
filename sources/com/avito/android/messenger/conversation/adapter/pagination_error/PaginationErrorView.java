package com.avito.android.messenger.conversation.adapter.pagination_error;

import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/pagination_error/PaginationErrorView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRetryClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Listener", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface PaginationErrorView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull PaginationErrorView paginationErrorView) {
            ItemView.DefaultImpls.onUnbind(paginationErrorView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/pagination_error/PaginationErrorView$Listener;", "", "Lcom/avito/android/messenger/conversation/ChannelItem$PaginationError;", "item", "", "onRetryPaginationClicked", "(Lcom/avito/android/messenger/conversation/ChannelItem$PaginationError;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onRetryPaginationClicked(@NotNull ChannelItem.PaginationError paginationError);
    }

    void setRetryClickListener(@NotNull Function0<Unit> function0);
}
