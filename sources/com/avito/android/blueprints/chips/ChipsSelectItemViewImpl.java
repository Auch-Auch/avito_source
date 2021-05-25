package com.avito.android.blueprints.chips;

import android.view.View;
import com.avito.android.item_temporary.R;
import com.avito.android.lib.design.chips.Chipable;
import com.avito.android.lib.design.chips.Chips;
import com.avito.android.lib.design.chips.SelectStrategy;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u0010/\u001a\u00020,¢\u0006\u0004\b2\u00103J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJG\u0010\u0017\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00050\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00064"}, d2 = {"Lcom/avito/android/blueprints/chips/ChipsSelectItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/blueprints/chips/ChipsSelectItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/text/AttributedText;", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "error", "setError", "setNormalState", "()V", "", "Lcom/avito/android/lib/design/chips/Chipable;", ResidentialComplexModuleKt.VALUES, "selectedValues", "Lkotlin/Function2;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setValues", "(Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "", "maxSelected", "setMaxSelected", "(Ljava/lang/Integer;)V", "Lcom/avito/android/lib/design/chips/SelectStrategy;", "strategy", "setSelectStrategy", "(Lcom/avito/android/lib/design/chips/SelectStrategy;)V", "keepSelected", "setKeepSelected", "(Z)V", "Lcom/avito/android/lib/design/chips/Chips$DisplayType;", "type", "setDisplayType", "(Lcom/avito/android/lib/design/chips/Chips$DisplayType;)V", "Lcom/avito/android/lib/design/chips/Chips;", "s", "Lcom/avito/android/lib/design/chips/Chips;", "chips", "Lcom/avito/android/util/text/AttributedTextFormatter;", "t", "Lcom/avito/android/util/text/AttributedTextFormatter;", "formatter", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class ChipsSelectItemViewImpl extends BaseViewHolder implements ChipsSelectItemView {
    public final Chips s;
    public final AttributedTextFormatter t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipsSelectItemViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "formatter");
        this.t = attributedTextFormatter;
        View findViewById = view.findViewById(R.id.chips);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.chips)");
        this.s = (Chips) findViewById;
    }

    @Override // com.avito.android.blueprints.chips.ChipsSelectItemView
    public void setDisplayType(@NotNull Chips.DisplayType displayType) {
        Intrinsics.checkNotNullParameter(displayType, "type");
        this.s.setDisplayType(displayType);
    }

    @Override // com.avito.android.blueprints.chips.ChipsSelectItemView
    public void setError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.s.setErrorOnTop(str);
    }

    @Override // com.avito.android.blueprints.chips.ChipsSelectItemView
    public void setKeepSelected(boolean z) {
        this.s.setKeepSelected(z);
    }

    @Override // com.avito.android.blueprints.chips.ChipsSelectItemView
    public void setMaxSelected(@Nullable Integer num) {
        this.s.setMaxSelected(num != null ? num.intValue() : -1);
    }

    @Override // com.avito.android.blueprints.chips.ChipsSelectItemView
    public void setNormalState() {
        this.s.setErrorOnTop(null);
    }

    @Override // com.avito.android.blueprints.chips.ChipsSelectItemView
    public void setSelectStrategy(@NotNull SelectStrategy selectStrategy) {
        Intrinsics.checkNotNullParameter(selectStrategy, "strategy");
        this.s.setSelectStrategy(selectStrategy);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
        if (r5 != null) goto L_0x0018;
     */
    @Override // com.avito.android.blueprints.chips.ChipsSelectItemView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSubtitle(@org.jetbrains.annotations.Nullable com.avito.android.remote.model.text.AttributedText r5) {
        /*
            r4 = this;
            com.avito.android.lib.design.chips.Chips r0 = r4.s
            if (r5 == 0) goto L_0x0016
            com.avito.android.util.text.AttributedTextFormatter r1 = r4.t
            android.content.Context r2 = r0.getContext()
            java.lang.String r3 = "chips.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.CharSequence r5 = r1.format(r2, r5)
            if (r5 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            java.lang.String r5 = ""
        L_0x0018:
            r0.setSubtitle(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.blueprints.chips.ChipsSelectItemViewImpl.setSubtitle(com.avito.android.remote.model.text.AttributedText):void");
    }

    @Override // com.avito.android.blueprints.chips.ChipsSelectItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }

    @Override // com.avito.android.blueprints.chips.ChipsSelectItemView
    public void setValues(@NotNull List<? extends Chipable> list, @Nullable List<? extends Chipable> list2, @NotNull Function2<? super Chipable, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setData(list);
        this.s.clearSelected();
        if (list2 != null) {
            this.s.select(list2);
        }
        this.s.setChipsSelectedListener(new Chips.ChipSelectedListener(function2) { // from class: com.avito.android.blueprints.chips.ChipsSelectItemViewImpl$setValues$2
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.lib.design.chips.Chips.ChipSelectedListener
            public void onChipSelected(@NotNull Chipable chipable) {
                Intrinsics.checkNotNullParameter(chipable, "item");
                this.a.invoke(chipable, Boolean.TRUE);
            }

            @Override // com.avito.android.lib.design.chips.Chips.ChipSelectedListener
            public void onChipUnSelected(@NotNull Chipable chipable) {
                Intrinsics.checkNotNullParameter(chipable, "item");
                this.a.invoke(chipable, Boolean.FALSE);
            }
        });
    }
}
