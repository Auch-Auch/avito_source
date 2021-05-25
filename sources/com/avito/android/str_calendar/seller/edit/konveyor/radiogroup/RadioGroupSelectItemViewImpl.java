package com.avito.android.str_calendar.seller.edit.konveyor.radiogroup;

import android.content.Context;
import android.view.View;
import com.avito.android.items.SelectableItem;
import com.avito.android.lib.design.radio.RadioButton;
import com.avito.android.lib.design.radio.RadioGroup;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.str_calendar.R;
import com.avito.android.str_calendar.seller.edit.konveyor.radiogroup.RadioGroupSelectItemView;
import com.avito.android.util.Contexts;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u0019\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0007JA\u0010\u0015\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/konveyor/radiogroup/RadioGroupSelectItemViewImpl;", "Lcom/avito/android/str_calendar/seller/edit/konveyor/radiogroup/RadioGroupSelectItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "subTitle", "setSubTitle", "hint", "setHint", "error", "setError", "", "Lcom/avito/android/items/SelectableItem;", ResidentialComplexModuleKt.VALUES, "selectedValue", "Lkotlin/Function2;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setValues", "(Ljava/util/List;Lcom/avito/android/items/SelectableItem;Lkotlin/jvm/functions/Function2;)V", "Lcom/avito/android/lib/design/radio/RadioGroup;", "t", "Lcom/avito/android/lib/design/radio/RadioGroup;", "radioGroup", "Landroid/content/Context;", "s", "Landroid/content/Context;", "context", "", "Lcom/avito/android/lib/design/radio/RadioButton;", "u", "Ljava/util/List;", "radioButtons", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class RadioGroupSelectItemViewImpl extends BaseViewHolder implements RadioGroupSelectItemView {
    public final Context s;
    public final RadioGroup t;
    public final List<RadioButton> u = new ArrayList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadioGroupSelectItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.s = context;
        View findViewById = view.findViewById(R.id.radio_group);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.radio_group)");
        this.t = (RadioGroup) findViewById;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        RadioGroupSelectItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.radiogroup.RadioGroupSelectItemView
    public void setError(@Nullable String str) {
        this.t.setHintColor(Contexts.getColorByAttr(this.s, com.avito.android.lib.design.R.attr.red));
        this.t.setHint(str);
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.radiogroup.RadioGroupSelectItemView
    public void setHint(@Nullable String str) {
        this.t.setHintColor(Contexts.getColorByAttr(this.s, com.avito.android.lib.design.R.attr.gray48));
        this.t.setHint(str);
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.radiogroup.RadioGroupSelectItemView
    public void setSubTitle(@Nullable String str) {
        this.t.setSubtitle(str);
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.radiogroup.RadioGroupSelectItemView
    public void setTitle(@Nullable String str) {
        this.t.setTitle(str);
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.radiogroup.RadioGroupSelectItemView
    public void setValues(@NotNull List<SelectableItem> list, @Nullable SelectableItem selectableItem, @NotNull Function2<? super SelectableItem, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.removeAllRadioButtons();
        for (T t2 : list) {
            Context context = this.t.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "radioGroup.context");
            RadioButton radioButton = new RadioButton(context);
            radioButton.setTag(t2.getStringId());
            radioButton.setTitle(t2.getTitle());
            this.u.add(radioButton);
            this.t.addView(radioButton);
            if (Intrinsics.areEqual(t2.getStringId(), selectableItem != null ? selectableItem.getStringId() : null)) {
                this.t.check(radioButton.getId());
            }
        }
        this.t.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(function2, list) { // from class: com.avito.android.str_calendar.seller.edit.konveyor.radiogroup.RadioGroupSelectItemViewImpl$setValues$2
            public final /* synthetic */ Function2 a;
            public final /* synthetic */ List b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.avito.android.lib.design.radio.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(@NotNull RadioGroup radioGroup, @NotNull RadioButton radioButton2, boolean z) {
                Object obj;
                Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
                Intrinsics.checkNotNullParameter(radioButton2, "radioButton");
                Iterator it = this.b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(radioButton2.getTag(), ((SelectableItem) obj).getStringId())) {
                        break;
                    }
                }
                SelectableItem selectableItem2 = (SelectableItem) obj;
                if (selectableItem2 != null) {
                    this.a.invoke(selectableItem2, Boolean.valueOf(z));
                }
            }
        });
    }
}
