package com.avito.android.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.advert.actions.AdvertItemActionsPresenter;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.HideAction;
import com.avito.android.remote.model.ItemAction;
import com.avito.android.ui_components.R;
import com.avito.android.util.TextViews;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b$\u0010%JS\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/view/ActionsBottomSheetView;", "Lcom/avito/android/view/ActionsBottomSheet;", "", "title", "", "Lcom/avito/android/remote/model/ItemAction;", "actions", "id", "categoryId", "", "locationId", "feedId", VKApiConst.POSITION, "", "showBottomActionsMenu", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;I)V", "Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;", "getActionsMenuPresenter", "()Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;", "setActionsMenuPresenter", "(Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;)V", "actionsMenuPresenter", "", AuthSource.BOOKING_ORDER, "Z", "isTablet", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "c", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "dialog", "<init>", "(Landroid/content/Context;)V", "advert-item-actions_release"}, k = 1, mv = {1, 4, 2})
public final class ActionsBottomSheetView implements ActionsBottomSheet {
    @Nullable
    public AdvertItemActionsPresenter a;
    public final boolean b;
    public BottomSheetDialog c;
    public final Context d;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ ActionsBottomSheetView a;
        public final /* synthetic */ AdvertItemActionsPresenter b;
        public final /* synthetic */ BottomSheetDialog c;

        public a(ActionsBottomSheetView actionsBottomSheetView, AdvertItemActionsPresenter advertItemActionsPresenter, BottomSheetDialog bottomSheetDialog) {
            this.a = actionsBottomSheetView;
            this.b = advertItemActionsPresenter;
            this.c = bottomSheetDialog;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            this.b.onActionsMenuClosed();
            this.c.setOnDismissListener(null);
            this.a.c = null;
        }
    }

    public static final class b extends Lambda implements Function1<ItemAction, Unit> {
        public final /* synthetic */ BottomSheetDialog a;
        public final /* synthetic */ AdvertItemActionsPresenter b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(BottomSheetDialog bottomSheetDialog, AdvertItemActionsPresenter advertItemActionsPresenter) {
            super(1);
            this.a = bottomSheetDialog;
            this.b = advertItemActionsPresenter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ItemAction itemAction) {
            ItemAction itemAction2 = itemAction;
            Intrinsics.checkNotNullParameter(itemAction2, "action");
            BottomSheetDialog bottomSheetDialog = this.a;
            boolean z = true;
            if (bottomSheetDialog == null || !bottomSheetDialog.isShowing()) {
                z = false;
            }
            if (z && bottomSheetDialog != null) {
                bottomSheetDialog.dismiss();
            }
            if (itemAction2 instanceof HideAction) {
                this.b.hideItem(((HideAction) itemAction2).getLabel());
            }
            return Unit.INSTANCE;
        }
    }

    public ActionsBottomSheetView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.d = context;
        this.b = context.getResources().getBoolean(R.bool.is_tablet);
    }

    @Override // com.avito.android.view.ActionsBottomSheet
    @Nullable
    public AdvertItemActionsPresenter getActionsMenuPresenter() {
        return this.a;
    }

    @Override // com.avito.android.view.ActionsBottomSheet
    public void setActionsMenuPresenter(@Nullable AdvertItemActionsPresenter advertItemActionsPresenter) {
        this.a = advertItemActionsPresenter;
    }

    @Override // com.avito.android.view.ActionsBottomSheet
    public void showBottomActionsMenu(@Nullable String str, @NotNull List<? extends ItemAction> list, @NotNull String str2, @Nullable String str3, @Nullable Integer num, @NotNull String str4, int i) {
        Intrinsics.checkNotNullParameter(list, "actions");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str4, "feedId");
        BottomSheetDialog bottomSheetDialog = this.c;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.dismiss();
        }
        this.c = null;
        AdvertItemActionsPresenter actionsMenuPresenter = getActionsMenuPresenter();
        if (actionsMenuPresenter != null) {
            actionsMenuPresenter.onActionsMenuOpened(new ActionsMenuData(str, list, str2, str3, num, str4, i));
            View inflate = LayoutInflater.from(this.d).inflate(com.avito.android.advert_item_actions.R.layout.advert_actions_custom_header, (ViewGroup) null);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) inflate;
            BottomSheetDialog bottomSheetDialog2 = new BottomSheetDialog(this.d, 0, 2, null);
            bottomSheetDialog2.setContentView(com.avito.android.advert_item_actions.R.layout.advert_actions_menu, true);
            bottomSheetDialog2.setCustomHeader(textView);
            BottomSheetDialog.setHeaderParams$default(bottomSheetDialog2, null, null, false, !this.b, 7, null);
            bottomSheetDialog2.setFitContentPeekHeight(true);
            this.c = bottomSheetDialog2;
            View findViewById = bottomSheetDialog2.findViewById(com.avito.android.advert_item_actions.R.id.action_items_container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
            TextViews.bindText$default(textView, str, false, 2, null);
            bottomSheetDialog2.setOnDismissListener(new a(this, actionsMenuPresenter, bottomSheetDialog2));
            new ReusableActionsView((ViewGroup) findViewById).bindDataForChildren(list, new b(bottomSheetDialog2, actionsMenuPresenter));
            bottomSheetDialog2.show();
        }
    }
}
