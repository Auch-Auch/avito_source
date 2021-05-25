package com.avito.android.location_list;

import android.view.View;
import com.avito.android.component.radio_button.RadioButton;
import com.avito.android.component.radio_button.RadioButtonImpl;
import com.avito.android.location_list.LocationItemTwoLinesView;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/avito/android/location_list/LocationRadioButtonView;", "Lcom/avito/android/location_list/LocationItemTwoLinesView;", "Lcom/avito/android/location_list/LocationItemSingleLineView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "", "checked", "setChecked", "(Z)V", "Lkotlin/Function0;", "func", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setSubtitle", "Lcom/avito/android/component/radio_button/RadioButtonImpl;", "s", "Lcom/avito/android/component/radio_button/RadioButtonImpl;", "radioButton", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "location-list_release"}, k = 1, mv = {1, 4, 2})
public final class LocationRadioButtonView extends BaseViewHolder implements LocationItemTwoLinesView, LocationItemSingleLineView {
    public final RadioButtonImpl s;

    public static final class a extends Lambda implements Function1<RadioButton, Unit> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function0 function0) {
            super(1);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RadioButton radioButton) {
            Intrinsics.checkNotNullParameter(radioButton, "it");
            this.a.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationRadioButtonView(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new RadioButtonImpl(view);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        LocationItemTwoLinesView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.location_list.LocationItemTwoLinesView, com.avito.android.location_list.LocationItemSingleLineView
    public void setChecked(boolean z) {
        this.s.setChecked(z);
    }

    @Override // com.avito.android.location_list.LocationItemTwoLinesView, com.avito.android.location_list.LocationItemSingleLineView
    public void setOnItemClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "func");
        this.s.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.location_list.LocationItemTwoLinesView
    public void setSubtitle(@Nullable String str) {
        this.s.setSubtitle(str);
    }

    @Override // com.avito.android.location_list.LocationItemTwoLinesView, com.avito.android.location_list.LocationItemSingleLineView
    public void setTitle(@Nullable String str) {
        RadioButtonImpl radioButtonImpl = this.s;
        if (str == null) {
            str = "";
        }
        radioButtonImpl.setTitle(str);
    }
}
