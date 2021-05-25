package com.avito.android.search.filter.adapter;

import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.avito.android.component.toggle_list_element.ToggleListElement;
import com.avito.android.component.toggle_list_element.ToggleListElementImpl;
import com.avito.android.search.filter.R;
import com.avito.android.search.filter.adapter.ChangeDisplayTypeView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nH\u0001¢\u0006\u0004\b\r\u0010\u000eJ&\u0010\u0011\u001a\u00020\n2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\n2\b\b\u0001\u0010\u0013\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0014\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/avito/android/search/filter/adapter/ChangeDisplayTypeViewImpl;", "Lcom/avito/android/search/filter/adapter/ChangeDisplayTypeView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/component/toggle_list_element/ToggleListElement;", "", "id", "", "icon", "", "isSelected", "", "addOption", "(Ljava/lang/String;IZ)V", "removeOptions", "()V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnOptionSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "title", "setTitle", "(I)V", "(Ljava/lang/String;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class ChangeDisplayTypeViewImpl extends BaseViewHolder implements ChangeDisplayTypeView, ToggleListElement {
    public final /* synthetic */ ToggleListElementImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChangeDisplayTypeViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.toggle_list_element);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.toggle_list_element)");
        this.s = new ToggleListElementImpl(findViewById);
    }

    @Override // com.avito.android.component.toggle_list_element.ToggleListElement
    public void addOption(@NotNull String str, @DrawableRes int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.s.addOption(str, i, z);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ChangeDisplayTypeView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.component.toggle_list_element.ToggleListElement
    public void removeOptions() {
        this.s.removeOptions();
    }

    @Override // com.avito.android.component.toggle_list_element.ToggleListElement
    public void setOnOptionSelectedListener(@Nullable Function1<? super String, Unit> function1) {
        this.s.setOnOptionSelectedListener(function1);
    }

    @Override // com.avito.android.component.toggle_list_element.ToggleListElement
    public void setTitle(@StringRes int i) {
        this.s.setTitle(i);
    }

    @Override // com.avito.android.component.toggle_list_element.ToggleListElement
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }
}
