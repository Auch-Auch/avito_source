package com.avito.android.blueprints.radiogroup;

import android.content.Context;
import android.view.View;
import com.avito.android.item_temporary.R;
import com.avito.android.items.SelectableItem;
import com.avito.android.lib.design.radio.RadioButton;
import com.avito.android.lib.design.radio.RadioGroup;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007JA\u0010\u0013\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0015\u001a\u00020\u00052\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lcom/avito/android/blueprints/radiogroup/RadioGroupSelectItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/blueprints/radiogroup/RadioGroupSelectItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "tag", "setTag", "error", "setError", "", "Lcom/avito/android/items/SelectableItem;", ResidentialComplexModuleKt.VALUES, "selectedValue", "Lkotlin/Function2;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setValues", "(Ljava/util/List;Lcom/avito/android/items/SelectableItem;Lkotlin/jvm/functions/Function2;)V", "setCheckChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "", FirebaseAnalytics.Param.INDEX, "setSelectedIndex", "(I)V", "onUnbind", "()V", "Lcom/avito/android/lib/design/radio/RadioGroup;", "s", "Lcom/avito/android/lib/design/radio/RadioGroup;", "radioGroup", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class RadioGroupSelectItemViewImpl extends BaseViewHolder implements RadioGroupSelectItemView {
    public final RadioGroup s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadioGroupSelectItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.radio_group);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.radio_group)");
        this.s = (RadioGroup) findViewById;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.s.setOnCheckedChangeListener(null);
    }

    @Override // com.avito.android.blueprints.radiogroup.RadioGroupSelectItemView
    public void setCheckChangeListener(@NotNull Function2<? super String, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(function2) { // from class: com.avito.android.blueprints.radiogroup.RadioGroupSelectItemViewImpl$setCheckChangeListener$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.lib.design.radio.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(@NotNull RadioGroup radioGroup, @NotNull RadioButton radioButton, boolean z) {
                Intrinsics.checkNotNullParameter(radioGroup, "radioGroup");
                Intrinsics.checkNotNullParameter(radioButton, "radioButton");
                this.a.invoke(radioButton.getTag().toString(), Boolean.valueOf(z));
            }
        });
    }

    @Override // com.avito.android.blueprints.radiogroup.RadioGroupSelectItemView
    public void setError(@Nullable String str) {
        this.s.setHint(str);
    }

    @Override // com.avito.android.blueprints.radiogroup.RadioGroupSelectItemView
    public void setSelectedIndex(int i) {
        this.s.check(i);
    }

    @Override // com.avito.android.blueprints.radiogroup.RadioGroupSelectItemView
    public void setTag(@Nullable String str) {
        this.s.setTag(str);
    }

    @Override // com.avito.android.blueprints.radiogroup.RadioGroupSelectItemView
    public void setTitle(@Nullable String str) {
        this.s.setTitle(str);
    }

    @Override // com.avito.android.blueprints.radiogroup.RadioGroupSelectItemView
    public void setValues(@NotNull List<SelectableItem> list, @Nullable SelectableItem selectableItem, @NotNull Function2<? super String, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.removeAllRadioButtons();
        this.s.clearChecked();
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
                this.s.check(i);
            }
            i = i2;
        }
        setCheckChangeListener(function2);
    }
}
