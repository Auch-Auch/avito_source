package com.avito.android.tariff.count.item;

import android.view.View;
import com.avito.android.lib.design.list_item.RadioListItem;
import com.avito.android.tariff.R;
import com.avito.android.tariff.count.item.CountItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/avito/android/tariff/count/item/CountItemViewImpl;", "Lcom/avito/android/tariff/count/item/CountItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "description", "", "setDescription", "(Ljava/lang/String;)V", "title", "setTitle", "", "isSelected", "setSelected", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/lib/design/list_item/RadioListItem;", "s", "Lcom/avito/android/lib/design/list_item/RadioListItem;", "radioListItem", "t", "Lkotlin/jvm/functions/Function0;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class CountItemViewImpl extends BaseViewHolder implements CountItemView {
    public final RadioListItem s;
    public Function0<Unit> t;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ CountItemViewImpl a;

        public a(CountItemViewImpl countItemViewImpl) {
            this.a = countItemViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a.t;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.radio_list_item);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.list_item.RadioListItem");
        RadioListItem radioListItem = (RadioListItem) findViewById;
        this.s = radioListItem;
        radioListItem.setOnClickListener(new a(this));
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        CountItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.tariff.count.item.CountItemView
    public void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        this.s.setMessage(str);
    }

    @Override // com.avito.android.tariff.count.item.CountItemView
    public void setItemClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t = function0;
    }

    @Override // com.avito.android.tariff.count.item.CountItemView
    public void setSelected(boolean z) {
        this.s.setChecked(z);
    }

    @Override // com.avito.android.tariff.count.item.CountItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }
}
