package com.avito.android.select.new_metro.adapter.checkbox_listitem;

import com.avito.android.lib.design.list_item.CheckboxListItem;
import com.avito.android.lib.design.list_item.CompoundButtonListItem;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u00020\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/checkbox_listitem/CheckBoxListItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/select/new_metro/adapter/checkbox_listitem/CheckBoxListItemView;", "Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$OnCheckedChangeListener;", "", "value", "", "setText", "(Ljava/lang/CharSequence;)V", "", "isChecked", "setChecked", "(Z)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCheckListener", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/lib/design/list_item/CompoundButtonListItem;", "view", "onCheckedChanged", "(Lcom/avito/android/lib/design/list_item/CompoundButtonListItem;Z)V", "s", "Lkotlin/jvm/functions/Function1;", "Lcom/avito/android/lib/design/list_item/CheckboxListItem;", "t", "Lcom/avito/android/lib/design/list_item/CheckboxListItem;", "checkBox", "<init>", "(Lcom/avito/android/lib/design/list_item/CheckboxListItem;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class CheckBoxListItemViewImpl extends BaseViewHolder implements CheckBoxListItemView, CompoundButtonListItem.OnCheckedChangeListener {
    public Function1<? super Boolean, Unit> s = a.a;
    public final CheckboxListItem t;

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            bool.booleanValue();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckBoxListItemViewImpl(@NotNull CheckboxListItem checkboxListItem) {
        super(checkboxListItem);
        Intrinsics.checkNotNullParameter(checkboxListItem, "checkBox");
        this.t = checkboxListItem;
        checkboxListItem.addOnCheckedChangeListener(this);
    }

    @Override // com.avito.android.lib.design.list_item.CompoundButtonListItem.OnCheckedChangeListener
    public void onCheckedChanged(@NotNull CompoundButtonListItem compoundButtonListItem, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButtonListItem, "view");
        this.s.invoke(Boolean.valueOf(z));
    }

    @Override // com.avito.android.select.new_metro.adapter.checkbox_listitem.CheckBoxListItemView
    public void setCheckListener(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s = function1;
    }

    @Override // com.avito.android.select.new_metro.adapter.checkbox_listitem.CheckBoxListItemView
    public void setChecked(boolean z) {
        this.t.setChecked(z);
    }

    @Override // com.avito.android.select.new_metro.adapter.checkbox_listitem.CheckBoxListItemView
    public void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        this.t.setTitle(charSequence);
    }
}
