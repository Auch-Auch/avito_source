package com.avito.android.profile_phones.phones_list.actions.items;

import android.view.View;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.list_item.ListItem;
import com.avito.android.util.Contexts;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001d\u0010\r\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\tR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemViewHolder;", "Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "", "setTitle", "(Ljava/lang/CharSequence;)V", "applyNormalState", "()V", "applyRedState", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "Lcom/avito/android/lib/design/list_item/ListItem;", "s", "Lcom/avito/android/lib/design/list_item/ListItem;", "listItem", "<init>", "(Lcom/avito/android/lib/design/list_item/ListItem;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class ActionItemViewHolder extends BaseViewHolder implements ActionItemView {
    public final ListItem s;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActionItemViewHolder(@NotNull ListItem listItem) {
        super(listItem);
        Intrinsics.checkNotNullParameter(listItem, "listItem");
        this.s = listItem;
    }

    @Override // com.avito.android.profile_phones.phones_list.actions.items.ActionItemView
    public void applyNormalState() {
        ListItem listItem = this.s;
        listItem.setTitleColor(Contexts.getColorStateListByAttr(listItem.getContext(), R.attr.black));
    }

    @Override // com.avito.android.profile_phones.phones_list.actions.items.ActionItemView
    public void applyRedState() {
        ListItem listItem = this.s;
        listItem.setTitleColor(Contexts.getColorStateListByAttr(listItem.getContext(), R.attr.red));
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.s.setOnClickListener(null);
    }

    @Override // com.avito.android.profile_phones.phones_list.actions.items.ActionItemView
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.profile_phones.phones_list.actions.items.ActionItemView
    public void setTitle(@Nullable CharSequence charSequence) {
        this.s.setTitle(charSequence);
    }
}
