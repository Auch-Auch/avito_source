package com.avito.android.search.filter.adapter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.avito.android.component.radio_button.RadioButton;
import com.avito.android.component.radio_button.RadioButtonImpl;
import com.avito.android.search.filter.SelectableItemIconFactory;
import com.avito.android.search.filter.adapter.SelectableItemView;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0012\u001a\u00020\u00052\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/avito/android/search/filter/adapter/SelectableItemRadioButtonView;", "Lcom/avito/android/search/filter/adapter/SelectableItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "selected", "setSelected", "(Z)V", "", "color", "setColor", "(Ljava/lang/Integer;)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnSelectedChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/search/filter/SelectableItemIconFactory;", "u", "Lcom/avito/android/search/filter/SelectableItemIconFactory;", "iconFactory", "Lcom/avito/android/component/radio_button/RadioButtonImpl;", "s", "Lcom/avito/android/component/radio_button/RadioButtonImpl;", "radioButton", "Landroid/content/res/Resources;", "t", "Landroid/content/res/Resources;", "resources", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/search/filter/SelectableItemIconFactory;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class SelectableItemRadioButtonView extends BaseViewHolder implements SelectableItemView {
    public final RadioButtonImpl s;
    public final Resources t;
    public final SelectableItemIconFactory u;

    public static final class a extends Lambda implements Function2<RadioButton, Boolean, Unit> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function1 function1) {
            super(2);
            this.a = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(RadioButton radioButton, Boolean bool) {
            boolean booleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(radioButton, "<anonymous parameter 0>");
            this.a.invoke(Boolean.valueOf(booleanValue));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectableItemRadioButtonView(@NotNull View view, @NotNull SelectableItemIconFactory selectableItemIconFactory) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(selectableItemIconFactory, "iconFactory");
        this.u = selectableItemIconFactory;
        this.s = new RadioButtonImpl(view);
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        this.t = resources;
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.standard_padding);
        Views.changePadding$default(view, dimensionPixelSize, 0, dimensionPixelSize, 0, 10, null);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        SelectableItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.search.filter.adapter.SelectableItemView
    public void setColor(@Nullable Integer num) {
        Drawable drawable;
        RadioButtonImpl radioButtonImpl = this.s;
        if (num != null) {
            drawable = this.u.createIcon(num.intValue());
        } else {
            drawable = null;
        }
        radioButtonImpl.setIcon(drawable);
    }

    @Override // com.avito.android.search.filter.adapter.SelectableItemView
    public void setOnSelectedChangeListener(@Nullable Function1<? super Boolean, Unit> function1) {
        if (function1 != null) {
            this.s.setOnCheckedChangeListener(new a(function1));
        } else {
            this.s.setOnCheckedChangeListener(null);
        }
    }

    @Override // com.avito.android.search.filter.adapter.SelectableItemView
    public void setSelected(boolean z) {
        this.s.setChecked(z);
    }

    @Override // com.avito.android.search.filter.adapter.SelectableItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }
}
