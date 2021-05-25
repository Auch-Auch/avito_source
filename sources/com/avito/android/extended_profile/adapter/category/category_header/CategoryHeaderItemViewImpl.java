package com.avito.android.extended_profile.adapter.category.category_header;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.extended_profile.R;
import com.avito.android.lib.design.spinner.Spinner;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00100\u001a\u00020\u0017¢\u0006\u0004\b1\u00102J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00052\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\tR\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_header/CategoryHeaderItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/extended_profile/adapter/category/category_header/CategoryHeaderItemView;", "", "title", "", "showTitle", "(Ljava/lang/CharSequence;)V", "showProgress", "()V", "", "isCollapsible", "setCollapsible", "(Z)V", "isCollapsed", "showAnimation", "setCollapsed", "(ZZ)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "Landroid/view/View;", "t", "Landroid/view/View;", "iconContainer", "Landroid/widget/ImageView;", "u", "Landroid/widget/ImageView;", "icon", "Lio/reactivex/rxjava3/core/Observable;", "x", "Lio/reactivex/rxjava3/core/Observable;", "getClicks", "()Lio/reactivex/rxjava3/core/Observable;", "clicks", "w", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "titleView", "Lcom/avito/android/lib/design/spinner/Spinner;", VKApiConst.VERSION, "Lcom/avito/android/lib/design/spinner/Spinner;", "progress", "rootView", "<init>", "(Landroid/view/View;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryHeaderItemViewImpl extends BaseViewHolder implements CategoryHeaderItemView {
    public final TextView s;
    public final View t;
    public final ImageView u;
    public final Spinner v;
    public Function0<Unit> w;
    @NotNull
    public final Observable<Unit> x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CategoryHeaderItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.category_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.icon_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.t = findViewById2;
        View findViewById3 = view.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        this.u = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.progress_bar);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.lib.design.spinner.Spinner");
        this.v = (Spinner) findViewById4;
        this.x = RxView.clicks(view);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_header.CategoryHeaderItemView
    @NotNull
    public Observable<Unit> getClicks() {
        return this.x;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.w;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_header.CategoryHeaderItemView
    public void setCollapsed(boolean z, boolean z2) {
        Views.hide(this.v);
        Views.show(this.u);
        this.u.clearAnimation();
        if (z2) {
            if (z) {
                ObjectAnimator.ofFloat(this.u, "rotation", 0.0f, -180.0f).start();
            } else {
                ObjectAnimator.ofFloat(this.u, "rotation", 180.0f, 360.0f).start();
            }
        } else if (z) {
            this.u.setRotation(180.0f);
        } else if (!z) {
            this.u.setRotation(0.0f);
        }
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_header.CategoryHeaderItemView
    public void setCollapsible(boolean z) {
        if (z) {
            Views.show(this.t);
        } else {
            Views.hide(this.t);
        }
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_header.CategoryHeaderItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.w = function0;
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_header.CategoryHeaderItemView
    public void showProgress() {
        Views.show(this.v);
        Views.hide(this.u);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_header.CategoryHeaderItemView
    public void showTitle(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.s, charSequence, false, 2, null);
    }
}
