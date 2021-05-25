package com.avito.android.conveyor_shared_item.notification;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.conveyor_shared_item.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/avito/android/conveyor_shared_item/notification/NotificationItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/conveyor_shared_item/notification/NotificationItemView;", "Lcom/avito/android/conveyor_shared_item/notification/NotificationItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/conveyor_shared_item/notification/NotificationItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/conveyor_shared_item/notification/NotificationItemPresenter;", "getPresenter", "()Lcom/avito/android/conveyor_shared_item/notification/NotificationItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/conveyor_shared_item/notification/NotificationItemViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "", "sidePaddingResource", "<init>", "(Lcom/avito/android/conveyor_shared_item/notification/NotificationItemPresenter;Ljava/lang/Integer;)V", "conveyor-shared-item_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationItemBlueprint implements ItemBlueprint<NotificationItemView, NotificationItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<NotificationItemViewHolder> a;
    @NotNull
    public final NotificationItemPresenter b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, NotificationItemViewHolder> {
        public final /* synthetic */ Integer a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Integer num) {
            super(2);
            this.a = num;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public NotificationItemViewHolder invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new NotificationItemViewHolder(view2, this.a);
        }
    }

    public NotificationItemBlueprint(@NotNull NotificationItemPresenter notificationItemPresenter, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(notificationItemPresenter, "presenter");
        this.b = notificationItemPresenter;
        this.a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.notification_item, new a(num));
    }

    /* Return type fixed from 'com.avito.android.conveyor_shared_item.notification.NotificationItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<NotificationItemView, NotificationItem> getPresenter() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<NotificationItemViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof NotificationItem;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NotificationItemBlueprint(NotificationItemPresenter notificationItemPresenter, Integer num, int i, j jVar) {
        this(notificationItemPresenter, (i & 2) != 0 ? null : num);
    }
}
