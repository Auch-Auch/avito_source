package com.avito.android.notification_center.list.item;

import android.view.View;
import com.avito.android.component.notification_list_item.NotificationListItem;
import com.avito.android.component.notification_list_item.NotificationListItemImpl;
import com.avito.android.remote.model.Sort;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000b\u0010\u0006J \u0010\f\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\f\u0010\nJ\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0012\u0010\u0010J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0014\u0010\u0010J\u0010\u0010\u0015\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0015\u0010\u0006R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/notification_center/list/item/NotificationCenterListItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/notification_center/list/item/NotificationCenterListItemView;", "Lcom/avito/android/component/notification_list_item/NotificationListItem;", "", "onUnbind", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "hideIndicator", "setClickListener", "", Sort.DATE, "setDate", "(Ljava/lang/String;)V", "description", "setDescription", "title", "setTitle", "showIndicator", "Landroid/view/View;", "t", "Landroid/view/View;", "view", "s", "Lkotlin/jvm/functions/Function0;", "unbindListener", "<init>", "(Landroid/view/View;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterListItemViewImpl extends BaseViewHolder implements NotificationCenterListItemView, NotificationListItem {
    public Function0<Unit> s;
    public final View t;
    public final /* synthetic */ NotificationListItemImpl u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationCenterListItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.u = new NotificationListItemImpl(view);
        this.t = view;
    }

    @Override // com.avito.android.component.notification_list_item.NotificationListItem
    public void hideIndicator() {
        this.u.hideIndicator();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.s;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.component.notification_list_item.NotificationListItem
    public void setClickListener(@Nullable Function0<Unit> function0) {
        this.u.setClickListener(function0);
    }

    @Override // com.avito.android.component.notification_list_item.NotificationListItem
    public void setDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Sort.DATE);
        this.u.setDate(str);
    }

    @Override // com.avito.android.component.notification_list_item.NotificationListItem
    public void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        this.u.setDescription(str);
    }

    @Override // com.avito.android.component.notification_list_item.NotificationListItem
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.u.setTitle(str);
    }

    @Override // com.avito.android.notification_center.list.item.NotificationCenterListItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
    }

    @Override // com.avito.android.component.notification_list_item.NotificationListItem
    public void showIndicator() {
        this.u.showIndicator();
    }
}
