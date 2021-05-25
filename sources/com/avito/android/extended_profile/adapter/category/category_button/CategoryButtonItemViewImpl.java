package com.avito.android.extended_profile.adapter.category.category_button;

import android.view.View;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.extended_profile.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.util.ViewSizeKt;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_button/CategoryButtonItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/extended_profile/adapter/category/category_button/CategoryButtonItemView;", "", "isLoading", "", "setLoading", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "Lcom/avito/android/lib/design/button/Button;", "s", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lio/reactivex/rxjava3/core/Observable;", "u", "Lio/reactivex/rxjava3/core/Observable;", "getClicks", "()Lio/reactivex/rxjava3/core/Observable;", "clicks", "t", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/View;", "rootView", "isTablet", "<init>", "(Landroid/view/View;Z)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryButtonItemViewImpl extends BaseViewHolder implements CategoryButtonItemView {
    public final Button s;
    public Function0<Unit> t;
    @NotNull
    public final Observable<Unit> u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CategoryButtonItemViewImpl(@NotNull View view, boolean z) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.category_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById;
        this.s = button;
        if (z) {
            Views.changeMargin$default(button, 0, ViewSizeKt.getDp(24), 0, 0, 13, null);
        }
        this.u = RxView.clicks(button);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_button.CategoryButtonItemView
    @NotNull
    public Observable<Unit> getClicks() {
        return this.u;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.t;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_button.CategoryButtonItemView
    public void setLoading(boolean z) {
        this.s.setLoading(z);
        this.s.setClickable(!z);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_button.CategoryButtonItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.t = function0;
    }
}
