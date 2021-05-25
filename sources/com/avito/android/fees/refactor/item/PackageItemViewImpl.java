package com.avito.android.fees.refactor.item;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.fees.R;
import com.avito.android.fees.refactor.item.PackageItemView;
import com.avito.android.util.Constants;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00102\u001a\u00020(¢\u0006\u0004\b3\u00104J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u001d\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J'\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u0011R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010#\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010\u001e¨\u00065"}, d2 = {"Lcom/avito/android/fees/refactor/item/PackageItemViewImpl;", "Lcom/avito/android/fees/refactor/item/PackageItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", ErrorBundle.DETAIL_ENTRY, "", "setCountDetails", "(Ljava/lang/String;)V", "days", "setDaysLeft", Constants.LOCATION_NAME, "setLocation", "title", "showCategory", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showDetails", "(Lkotlin/jvm/functions/Function0;)V", "hideDetails", "()V", "hideCategory", "", "max", "progress", "drawableId", "showProgress", "(III)V", "setOnClickListener", "Landroid/widget/TextView;", VKApiConst.VERSION, "Landroid/widget/TextView;", "category", "s", "countDetails", "u", "location", "Landroid/widget/Button;", "w", "Landroid/widget/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroid/view/View;", "y", "Landroid/view/View;", "container", "Landroid/widget/ProgressBar;", "x", "Landroid/widget/ProgressBar;", "progressBar", "t", "daysLeft", "view", "<init>", "(Landroid/view/View;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class PackageItemViewImpl extends BaseViewHolder implements PackageItemView {
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final Button w;
    public final ProgressBar x;
    public final View y;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PackageItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.placement_counter);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.placement_counter)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.days_counter);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.days_counter)");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.location);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.location)");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.category);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.category)");
        this.v = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.expanding_button);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.expanding_button)");
        this.w = (Button) findViewById5;
        View findViewById6 = view.findViewById(R.id.placement_progress);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.placement_progress)");
        this.x = (ProgressBar) findViewById6;
        View findViewById7 = view.findViewById(R.id.package_top_container);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.package_top_container)");
        this.y = findViewById7;
    }

    @Override // com.avito.android.fees.refactor.item.PackageItemView
    public void hideCategory() {
        Views.hide(this.v);
    }

    @Override // com.avito.android.fees.refactor.item.PackageItemView
    public void hideDetails() {
        Views.hide(this.w);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        PackageItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.fees.refactor.item.PackageItemView
    public void setCountDetails(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ErrorBundle.DETAIL_ENTRY);
        this.s.setText(str);
    }

    @Override // com.avito.android.fees.refactor.item.PackageItemView
    public void setDaysLeft(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "days");
        this.t.setText(str);
    }

    @Override // com.avito.android.fees.refactor.item.PackageItemView
    public void setLocation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.LOCATION_NAME);
        this.u.setText(str);
    }

    @Override // com.avito.android.fees.refactor.item.PackageItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.y.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.fees.refactor.item.PackageItemView
    public void showCategory(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.v.setText(str);
        Views.show(this.v);
    }

    @Override // com.avito.android.fees.refactor.item.PackageItemView
    public void showDetails(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Views.show(this.w);
        this.w.setOnClickListener(new b(function0));
    }

    @Override // com.avito.android.fees.refactor.item.PackageItemView
    public void showProgress(int i, int i2, int i3) {
        this.x.setProgressDrawable(this.x.getContext().getDrawable(i3));
        this.x.setMax(i);
        this.x.setProgress(i2);
    }
}
