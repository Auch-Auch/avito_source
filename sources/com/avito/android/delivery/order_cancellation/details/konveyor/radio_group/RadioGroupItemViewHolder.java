package com.avito.android.delivery.order_cancellation.details.konveyor.radio_group;

import android.content.Context;
import androidx.annotation.IdRes;
import com.avito.android.authorization.auth.tracker.check.CheckTrackerModule;
import com.avito.android.items.SelectableItem;
import com.avito.android.lib.design.radio.RadioButton;
import com.avito.android.lib.design.radio.RadioGroup;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016JA\u0010\u000b\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\t2\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/details/konveyor/radio_group/RadioGroupItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/delivery/order_cancellation/details/konveyor/radio_group/RadioGroupItemView;", "", "Lcom/avito/android/items/SelectableItem;", ResidentialComplexModuleKt.VALUES, "selectedValue", "Lkotlin/Function2;", "", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setValues", "(Ljava/util/List;Lcom/avito/android/items/SelectableItem;Lkotlin/jvm/functions/Function2;)V", "", "id", CheckTrackerModule.NAME, "(I)V", "Lcom/avito/android/lib/design/radio/RadioGroup;", "s", "Lcom/avito/android/lib/design/radio/RadioGroup;", "radioGroup", "<init>", "(Lcom/avito/android/lib/design/radio/RadioGroup;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class RadioGroupItemViewHolder extends BaseViewHolder implements RadioGroupItemView {
    public final RadioGroup s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadioGroupItemViewHolder(@NotNull RadioGroup radioGroup) {
        super(radioGroup);
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        this.s = radioGroup;
    }

    @Override // com.avito.android.delivery.order_cancellation.details.konveyor.radio_group.RadioGroupItemView
    public void check(@IdRes int i) {
        this.s.check(i);
    }

    @Override // com.avito.android.delivery.order_cancellation.details.konveyor.radio_group.RadioGroupItemView
    public void setValues(@NotNull List<SelectableItem> list, @Nullable SelectableItem selectableItem, @NotNull Function2<? super SelectableItem, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.removeAllRadioButtons();
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            Context context = this.s.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "radioGroup.context");
            RadioButton radioButton = new RadioButton(context);
            radioButton.setTag(t2.getStringId());
            radioButton.setId(i);
            radioButton.setTitle(t2.getTitle());
            this.s.addView(radioButton);
            if (Intrinsics.areEqual(t2.getStringId(), selectableItem != null ? selectableItem.getStringId() : null)) {
                this.s.check(radioButton.getId());
            }
            i = i2;
        }
        this.s.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(list, function2) { // from class: com.avito.android.delivery.order_cancellation.details.konveyor.radio_group.RadioGroupItemViewHolder$setValues$2
            public final /* synthetic */ List a;
            public final /* synthetic */ Function2 b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.avito.android.lib.design.radio.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(@NotNull RadioGroup radioGroup, @NotNull RadioButton radioButton2, boolean z) {
                Object obj;
                Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
                Intrinsics.checkNotNullParameter(radioButton2, "radioButton");
                Iterator it = this.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(((SelectableItem) obj).getStringId(), radioButton2.getTag())) {
                        break;
                    }
                }
                SelectableItem selectableItem2 = (SelectableItem) obj;
                if (selectableItem2 != null) {
                    this.b.invoke(selectableItem2, Boolean.valueOf(z));
                }
            }
        });
    }
}
