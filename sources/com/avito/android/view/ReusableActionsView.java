package com.avito.android.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.lib.design.list_item.ListItem;
import com.avito.android.lib.util.ReuseChildrenHelper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.HideAction;
import com.avito.android.remote.model.ItemAction;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0010\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/view/ReusableActionsView;", "Lcom/avito/android/lib/util/ReuseChildrenHelper;", "Lcom/avito/android/remote/model/ItemAction;", "Lcom/avito/android/lib/design/list_item/ListItem;", "createChild", "()Lcom/avito/android/lib/design/list_item/ListItem;", "view", "data", "", VKApiConst.POSITION, "", "bindData", "(Lcom/avito/android/lib/design/list_item/ListItem;Lcom/avito/android/remote/model/ItemAction;I)V", "", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "bindDataForChildren", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "container", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function1;", "<init>", "(Landroid/view/ViewGroup;)V", "advert-item-actions_release"}, k = 1, mv = {1, 4, 2})
public final class ReusableActionsView extends ReuseChildrenHelper<ItemAction, ListItem> {
    public final Context a;
    public Function1<? super ItemAction, Unit> b;
    public final ViewGroup c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ReusableActionsView a;
        public final /* synthetic */ ItemAction b;

        public a(ReusableActionsView reusableActionsView, ItemAction itemAction) {
            this.a = reusableActionsView;
            this.b = itemAction;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1 = this.a.b;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke(this.b);
            }
        }
    }

    public ReusableActionsView(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        this.c = viewGroup;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "container.context");
        this.a = context;
    }

    public final void bindDataForChildren(@NotNull List<? extends ItemAction> list, @NotNull Function1<? super ItemAction, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "data");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b = function1;
        reuseChildrenView(this.c, list);
    }

    public void bindData(@NotNull ListItem listItem, @NotNull ItemAction itemAction, int i) {
        Intrinsics.checkNotNullParameter(listItem, "view");
        Intrinsics.checkNotNullParameter(itemAction, "data");
        if (itemAction instanceof HideAction) {
            HideAction hideAction = (HideAction) itemAction;
            Drawable drawable = hideAction.getUseIcon() ? Views.getDrawable(listItem, R.drawable.ic_clear_24) : null;
            listItem.setTitle(hideAction.getTitle());
            ListItem.setImageDrawable$default(listItem, drawable, null, 2, null);
            listItem.setOnClickListener(new a(this, itemAction));
            return;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.avito.android.lib.util.ReuseChildrenHelper
    @NotNull
    public ListItem createChild() {
        ListItem listItem = new ListItem(this.a);
        Views.changePadding$default(listItem, Views.dpToPx(listItem, 16), 0, 0, 0, 14, null);
        return listItem;
    }
}
