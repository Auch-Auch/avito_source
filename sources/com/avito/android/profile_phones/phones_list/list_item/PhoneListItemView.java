package com.avito.android.profile_phones.phones_list.list_item;

import android.view.View;
import androidx.annotation.AttrRes;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.list_item.ListItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\bJ\u001d\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u001b\u0010\u0013\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "onUnbind", "()V", "", "phone", "setPhone", "(Ljava/lang/String;)V", "usageText", "setUsageText", "text", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemView$StatusType;", "type", "setStatus", "(Ljava/lang/String;Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemView$StatusType;)V", "hideStatus", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "visible", "setActionsIconVisible", "(Z)V", "Lcom/avito/android/lib/design/list_item/ListItem;", "s", "Lcom/avito/android/lib/design/list_item/ListItem;", "listItem", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "StatusType", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneListItemView extends BaseViewHolder {
    public final ListItem s;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemView$StatusType;", "", "", AuthSource.SEND_ABUSE, "I", "getColorRes", "()I", "colorRes", "<init>", "(Ljava/lang/String;II)V", "RED", "ORANGE", "NONE", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    public enum StatusType {
        RED(R.attr.red),
        ORANGE(R.attr.orange),
        NONE(R.attr.gray28);
        
        public final int a;

        /* access modifiers changed from: public */
        StatusType(@AttrRes int i) {
            this.a = i;
        }

        public final int getColorRes() {
            return this.a;
        }
    }

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
    public PhoneListItemView(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.s = (ListItem) view;
    }

    public final void hideStatus() {
        this.s.setMessage((CharSequence) null);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.s.setOnClickListener(null);
    }

    public final void setActionsIconVisible(boolean z) {
        if (z) {
            ListItem.setImageResource$default(this.s, 0, com.avito.android.ui_components.R.drawable.ic_more_horizontal_24, 1, null);
        } else {
            ListItem.setImageResource$default(this.s, 0, 0, 1, null);
        }
    }

    public final void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClickListener(new a(function0));
    }

    public final void setPhone(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phone");
        this.s.setTitle(str);
    }

    public final void setStatus(@NotNull String str, @NotNull StatusType statusType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(statusType, "type");
        this.s.setMessage(str);
        ListItem listItem = this.s;
        listItem.setMessageColor(Contexts.getColorStateListByAttr(listItem.getContext(), statusType.getColorRes()));
    }

    public final void setUsageText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "usageText");
        this.s.setSubtitle(str);
    }
}
