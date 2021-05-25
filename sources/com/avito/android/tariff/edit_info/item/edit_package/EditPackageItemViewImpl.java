package com.avito.android.tariff.edit_info.item.edit_package;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.paid_services.routing.ProgressState;
import com.avito.android.paid_services.routing.TariffCountStatus;
import com.avito.android.tariff.R;
import com.avito.android.tariff.view.TariffCountBar;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010<\u001a\u00020&\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010;\u001a\u000206¢\u0006\u0004\b?\u0010@J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u0019\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0010J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001e\u0010\u0010J\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0019\u0010;\u001a\u0002068\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006A"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/edit_package/EditPackageItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/tariff/edit_info/item/edit_package/EditPackageItemView;", "", "Lcom/avito/android/tariff/edit_info/item/edit_package/EditPackageMicroCategoryItem;", "microCategories", "", "setMicroCategories", "(Ljava/util/List;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "location", "setLocation", "(Ljava/lang/String;)V", "title", "setBarTitle", MessengerShareContentUtility.SUBTITLE, "bindSubtitle", "", "progress", "setBarProgress", "(F)V", "Lcom/avito/android/paid_services/routing/ProgressState;", "progressState", "setBarState", "(Lcom/avito/android/paid_services/routing/ProgressState;)V", "description", "bindBarDescription", "Lcom/avito/android/paid_services/routing/TariffCountStatus;", "tariffCountStatus", "setBarDescriptionStatus", "(Lcom/avito/android/paid_services/routing/TariffCountStatus;)V", "w", "Lkotlin/jvm/functions/Function0;", "clickListener", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "clickArea", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "locationsView", "Lcom/avito/android/tariff/view/TariffCountBar;", "t", "Lcom/avito/android/tariff/view/TariffCountBar;", "countBar", "Landroidx/recyclerview/widget/RecyclerView;", "u", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "x", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "view", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/ItemBinder;Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class EditPackageItemViewImpl extends BaseViewHolder implements EditPackageItemView {
    public final TextView s;
    public final TariffCountBar t;
    public RecyclerView u;
    public View v;
    public Function0<Unit> w;
    @NotNull
    public final AdapterPresenter x;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ EditPackageItemViewImpl a;

        public a(EditPackageItemViewImpl editPackageItemViewImpl) {
            this.a = editPackageItemViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a.w;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditPackageItemViewImpl(@NotNull View view, @NotNull ItemBinder itemBinder, @NotNull AdapterPresenter adapterPresenter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        this.x = adapterPresenter;
        View findViewById = view.findViewById(R.id.location);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.location)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.count_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.count_bar)");
        this.t = (TariffCountBar) findViewById2;
        View findViewById3 = view.findViewById(R.id.edit_package_recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.edit_package_recycler_view)");
        this.u = (RecyclerView) findViewById3;
        View findViewById4 = view.findViewById(R.id.clickArea);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.clickArea)");
        this.v = findViewById4;
        findViewById4.setOnClickListener(new a(this));
        this.u.setItemAnimator(null);
        this.u.setAdapter(new SimpleRecyclerAdapter(adapterPresenter, itemBinder));
    }

    @Override // com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemView
    public void bindBarDescription(@Nullable String str) {
        this.t.bindDescription(str);
    }

    @Override // com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemView
    public void bindSubtitle(@Nullable String str) {
        this.t.bindSubtitle(str);
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        return this.x;
    }

    @Override // com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemView
    public void setBarDescriptionStatus(@NotNull TariffCountStatus tariffCountStatus) {
        Intrinsics.checkNotNullParameter(tariffCountStatus, "tariffCountStatus");
        this.t.setDescriptionStatus(tariffCountStatus);
    }

    @Override // com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemView
    public void setBarProgress(float f) {
        this.t.setProgress(f);
    }

    @Override // com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemView
    public void setBarState(@NotNull ProgressState progressState) {
        Intrinsics.checkNotNullParameter(progressState, "progressState");
        this.t.setProgressState(progressState);
    }

    @Override // com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemView
    public void setBarTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setTitle(str);
    }

    @Override // com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemView
    public void setLocation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "location");
        this.s.setText(str);
    }

    @Override // com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemView
    public void setMicroCategories(@NotNull List<EditPackageMicroCategoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "microCategories");
        a2.b.a.a.a.s1(list, this.x);
        RecyclerView.Adapter adapter = this.u.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.w = function0;
    }
}
