package com.avito.android.search.filter.adapter;

import android.view.View;
import com.avito.android.items.SelectableItem;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.search.filter.R;
import com.avito.android.search.filter.adapter.InlineSelectItemView;
import com.avito.android.ui.widget.InlineSelectView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.text.Text;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007JA\u0010\u000f\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/avito/android/search/filter/adapter/InlineSelectItemViewImpl;", "Lcom/avito/android/search/filter/adapter/InlineSelectItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "Lcom/avito/android/items/SelectableItem;", ResidentialComplexModuleKt.VALUES, "selectedValue", "Lkotlin/Function2;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setValues", "(Ljava/util/List;Lcom/avito/android/items/SelectableItem;Lkotlin/jvm/functions/Function2;)V", "Lru/avito/component/text/Text;", "s", "Lru/avito/component/text/Text;", "Lcom/avito/android/ui/widget/InlineSelectView;", "t", "Lcom/avito/android/ui/widget/InlineSelectView;", "inlineSelectView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class InlineSelectItemViewImpl extends BaseViewHolder implements InlineSelectItemView {
    public final Text s;
    public final InlineSelectView t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InlineSelectItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.s = new TextImpl(findViewById);
        View findViewById2 = view.findViewById(R.id.select_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.ui.widget.InlineSelectView");
        this.t = (InlineSelectView) findViewById2;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        InlineSelectItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.search.filter.adapter.InlineSelectItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }

    @Override // com.avito.android.search.filter.adapter.InlineSelectItemView
    public void setValues(@NotNull List<SelectableItem> list, @Nullable SelectableItem selectableItem, @NotNull Function2<? super SelectableItem, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setValues(list, selectableItem, function2);
    }
}
