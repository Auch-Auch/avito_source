package com.avito.android.str_calendar.seller.edit.konveyor.chips;

import a2.a.a.b3.c.b.v.a.a;
import android.view.View;
import com.avito.android.items.SelectableItem;
import com.avito.android.lib.design.chips.Chipable;
import com.avito.android.lib.design.chips.Chips;
import com.avito.android.lib.design.chips.SelectStrategy;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.str_calendar.R;
import com.avito.android.str_calendar.seller.edit.konveyor.chips.ChipsSelectItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0007JA\u0010\u0015\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/konveyor/chips/ChipsSelectItemViewImpl;", "Lcom/avito/android/str_calendar/seller/edit/konveyor/chips/ChipsSelectItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "subTitle", "setSubTitle", "hint", "setHint", "error", "setError", "", "Lcom/avito/android/items/SelectableItem;", ResidentialComplexModuleKt.VALUES, "selectedValue", "Lkotlin/Function2;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setValues", "(Ljava/util/List;Lcom/avito/android/items/SelectableItem;Lkotlin/jvm/functions/Function2;)V", "Lcom/avito/android/lib/design/chips/SelectStrategy;", "strategy", "setSelectStrategy", "(Lcom/avito/android/lib/design/chips/SelectStrategy;)V", "keepSelected", "setKeepSelected", "(Z)V", "Lcom/avito/android/lib/design/chips/Chips;", "s", "Lcom/avito/android/lib/design/chips/Chips;", "chips", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class ChipsSelectItemViewImpl extends BaseViewHolder implements ChipsSelectItemView {
    public final Chips s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipsSelectItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.chips);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.chips)");
        this.s = (Chips) findViewById;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ChipsSelectItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.chips.ChipsSelectItemView
    public void setError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.s.setError(str);
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.chips.ChipsSelectItemView
    public void setHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        this.s.setHint(str);
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.chips.ChipsSelectItemView
    public void setKeepSelected(boolean z) {
        this.s.setKeepSelected(z);
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.chips.ChipsSelectItemView
    public void setSelectStrategy(@NotNull SelectStrategy selectStrategy) {
        Intrinsics.checkNotNullParameter(selectStrategy, "strategy");
        this.s.setSelectStrategy(selectStrategy);
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.chips.ChipsSelectItemView
    public void setSubTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "subTitle");
        this.s.setSubtitle(str);
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.chips.ChipsSelectItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.chips.ChipsSelectItemView
    public void setValues(@NotNull List<SelectableItem> list, @Nullable SelectableItem selectableItem, @NotNull Function2<? super SelectableItem, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setDisplayType(Chips.DisplayType.SINGLE_LINE_SCROLLABLE);
        Chips chips = this.s;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new a(it.next().getTitle()));
        }
        chips.setData(arrayList);
        if (selectableItem != null) {
            this.s.select(new a(selectableItem.getTitle()));
        }
        this.s.setChipsSelectedListener(new Chips.ChipSelectedListener(function2, list) { // from class: com.avito.android.str_calendar.seller.edit.konveyor.chips.ChipsSelectItemViewImpl$setValues$3
            public final /* synthetic */ Function2 a;
            public final /* synthetic */ List b;

            {
                this.a = r1;
                this.b = r2;
            }

            public final SelectableItem a(Chipable chipable) {
                Object obj;
                Iterator it2 = this.b.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    if (Intrinsics.areEqual(chipable.getChipTitle(), ((SelectableItem) obj).getTitle())) {
                        break;
                    }
                }
                return (SelectableItem) obj;
            }

            @Override // com.avito.android.lib.design.chips.Chips.ChipSelectedListener
            public void onChipSelected(@NotNull Chipable chipable) {
                Intrinsics.checkNotNullParameter(chipable, "item");
                SelectableItem a3 = a(chipable);
                if (a3 != null) {
                    this.a.invoke(a3, Boolean.TRUE);
                }
            }

            @Override // com.avito.android.lib.design.chips.Chips.ChipSelectedListener
            public void onChipUnSelected(@NotNull Chipable chipable) {
                Intrinsics.checkNotNullParameter(chipable, "item");
                SelectableItem a3 = a(chipable);
                if (a3 != null) {
                    this.a.invoke(a3, Boolean.FALSE);
                }
            }
        });
    }
}
