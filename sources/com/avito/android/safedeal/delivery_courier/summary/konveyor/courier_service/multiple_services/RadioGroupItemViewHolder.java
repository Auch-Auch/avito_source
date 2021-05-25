package com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.avito.android.lib.design.radio.RadioButton;
import com.avito.android.lib.design.radio.RadioGroup;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\t\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/multiple_services/RadioGroupItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/multiple_services/RadioGroupItemView;", "", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/multiple_services/CourierServiceRadioButtonItem;", "radioButtons", "Lkotlin/Function1;", "", "onCheckedChangeListener", "setRadioButtons", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "hint", "setHint", "Lcom/avito/android/lib/design/radio/RadioGroup;", "s", "Lcom/avito/android/lib/design/radio/RadioGroup;", "radioGroup", "<init>", "(Lcom/avito/android/lib/design/radio/RadioGroup;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class RadioGroupItemViewHolder extends BaseViewHolder implements RadioGroupItemView {
    public final RadioGroup s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadioGroupItemViewHolder(@NotNull RadioGroup radioGroup) {
        super(radioGroup);
        Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
        this.s = radioGroup;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services.RadioGroupItemView
    public void setHint(@Nullable String str) {
        this.s.setHint(str);
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services.RadioGroupItemView
    public void setRadioButtons(@NotNull List<CourierServiceRadioButtonItem> list, @NotNull Function1<? super CourierServiceRadioButtonItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "radioButtons");
        Intrinsics.checkNotNullParameter(function1, "onCheckedChangeListener");
        this.s.removeAllRadioButtons();
        for (T t : list) {
            Context context = this.s.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "radioGroup.context");
            RadioButton radioButton = new RadioButton(context);
            radioButton.setTag(t.getStringId());
            radioButton.setTitle(t.getTitle());
            radioButton.setSubtitle(t.getSubtitle());
            this.s.addView(radioButton);
            if (t.isChecked()) {
                this.s.check(radioButton.getId());
            }
        }
        RadioGroup radioGroup = this.s;
        int childCount = radioGroup.getChildCount() - 1;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                View childAt = radioGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                if (childAt instanceof RadioButton) {
                    ViewGroup viewGroup = (ViewGroup) childAt;
                    int childCount2 = viewGroup.getChildCount() - 1;
                    if (childCount2 >= 0) {
                        int i2 = 0;
                        while (true) {
                            View childAt2 = viewGroup.getChildAt(i2);
                            Intrinsics.checkNotNullExpressionValue(childAt2, "getChildAt(i)");
                            if ((childAt2 instanceof AppCompatRadioButton) || (childAt2 instanceof LinearLayout)) {
                                Views.changeMargin$default(childAt2, 0, Views.dpToPx(childAt2, 5), 0, Views.dpToPx(childAt2, 6), 5, null);
                            }
                            if (i2 == childCount2) {
                                break;
                            }
                            i2++;
                        }
                    }
                }
                if (i == childCount) {
                    break;
                }
                i++;
            }
        }
        this.s.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(list, function1) { // from class: com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services.RadioGroupItemViewHolder$setRadioButtons$3
            public final /* synthetic */ List a;
            public final /* synthetic */ Function1 b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.avito.android.lib.design.radio.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(@NotNull RadioGroup radioGroup2, @NotNull RadioButton radioButton2, boolean z) {
                Object obj;
                Object obj2;
                Intrinsics.checkNotNullParameter(radioGroup2, "radioGroup");
                Intrinsics.checkNotNullParameter(radioButton2, "radioButton");
                Iterator it = this.a.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    if (((CourierServiceRadioButtonItem) obj2).isChecked()) {
                        break;
                    }
                }
                CourierServiceRadioButtonItem courierServiceRadioButtonItem = (CourierServiceRadioButtonItem) obj2;
                if (courierServiceRadioButtonItem != null) {
                    courierServiceRadioButtonItem.setChecked(false);
                }
                Iterator it2 = this.a.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    if (Intrinsics.areEqual(((CourierServiceRadioButtonItem) next).getStringId(), radioButton2.getTag())) {
                        obj = next;
                        break;
                    }
                }
                CourierServiceRadioButtonItem courierServiceRadioButtonItem2 = (CourierServiceRadioButtonItem) obj;
                if (courierServiceRadioButtonItem2 != null) {
                    courierServiceRadioButtonItem2.setChecked(true);
                    this.b.invoke(courierServiceRadioButtonItem2);
                }
            }
        });
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services.RadioGroupItemView
    public void setSubtitle(@Nullable String str) {
        this.s.setSubtitle(str);
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services.RadioGroupItemView
    public void setTitle(@Nullable String str) {
        this.s.setTitle(str);
    }
}
