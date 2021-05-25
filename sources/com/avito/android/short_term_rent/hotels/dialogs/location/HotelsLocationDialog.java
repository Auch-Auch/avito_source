package com.avito.android.short_term_rent.hotels.dialogs.location;

import a2.a.a.v2.b.i.c.a;
import a2.a.a.v2.b.i.c.b;
import a2.a.a.v2.b.i.c.c;
import a2.a.a.v2.b.i.c.d;
import a2.a.a.v2.b.i.c.e;
import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.model.hotels.HotelsLocation;
import com.avito.android.short_term_rent.R;
import com.avito.android.short_term_rent.di.component.DaggerHotelsFilterLocationComponent;
import com.avito.android.short_term_rent.di.component.HotelsDependencies;
import com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialog;
import com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialogView;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002Bj\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012#\u0010%\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00030!\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030&\u0012\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030&¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006+"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialog;", "Lcom/avito/android/short_term_rent/hotels/dialogs/HotelsFiltersDialog;", "Landroidx/lifecycle/LifecycleOwner;", "", "show", "()V", "dismiss", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle", "()Landroidx/lifecycle/LifecycleRegistry;", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationViewModel;", "viewModel", "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationViewModel;", "getViewModel", "()Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationViewModel;", "setViewModel", "(Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationViewModel;)V", "c", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "", "Lcom/avito/android/remote/model/hotels/HotelsLocation;", "defaultLocations", "Landroid/os/Parcelable;", "state", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "selectedValue", "selectedItemListener", "Lkotlin/Function0;", "dialogCloseListener", "closeButtonListener", "<init>", "(Landroid/content/Context;Ljava/util/List;Landroid/os/Parcelable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class HotelsLocationDialog extends HotelsFiltersDialog implements LifecycleOwner {
    public final LifecycleRegistry c;
    @NotNull
    public Context d;
    @Inject
    public HotelsLocationViewModel viewModel;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HotelsLocationDialog(Context context, List list, Parcelable parcelable, Function1 function1, Function0 function0, Function0 function02, int i, j jVar) {
        this(context, list, parcelable, function1, function0, (i & 32) != 0 ? function0 : function02);
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialog
    public void dismiss() {
        super.dismiss();
        this.c.setCurrentState(Lifecycle.State.DESTROYED);
    }

    @NotNull
    public final Context getContext() {
        return this.d;
    }

    @NotNull
    public final HotelsLocationViewModel getViewModel() {
        HotelsLocationViewModel hotelsLocationViewModel = this.viewModel;
        if (hotelsLocationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return hotelsLocationViewModel;
    }

    public final void setContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.d = context;
    }

    public final void setViewModel(@NotNull HotelsLocationViewModel hotelsLocationViewModel) {
        Intrinsics.checkNotNullParameter(hotelsLocationViewModel, "<set-?>");
        this.viewModel = hotelsLocationViewModel;
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialog
    public void show() {
        super.show();
        this.c.setCurrentState(Lifecycle.State.RESUMED);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HotelsLocationDialog(@NotNull Context context, @NotNull List<HotelsLocation> list, @Nullable Parcelable parcelable, @NotNull Function1<? super HotelsLocation, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        super(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "defaultLocations");
        Intrinsics.checkNotNullParameter(function1, "selectedItemListener");
        Intrinsics.checkNotNullParameter(function0, "dialogCloseListener");
        Intrinsics.checkNotNullParameter(function02, "closeButtonListener");
        this.d = context;
        this.c = new LifecycleRegistry(this);
        Object systemService = this.d.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View inflate = ((LayoutInflater) systemService).inflate(R.layout.hotels_location_dialog, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "containerView");
        setView(new HotelsLocationFilterViewImpl(inflate));
        HotelsFiltersDialogView view = getView();
        Objects.requireNonNull(view, "null cannot be cast to non-null type com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationFilterViewImpl");
        HotelsLocationFilterViewImpl hotelsLocationFilterViewImpl = (HotelsLocationFilterViewImpl) view;
        DaggerHotelsFilterLocationComponent.builder().dependencies((HotelsDependencies) ComponentDependenciesKt.getDependencies(HotelsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this.d))).bindDefaultLocations(list).build().inject(this);
        HotelsFiltersDialogView view2 = getView();
        Objects.requireNonNull(view2, "null cannot be cast to non-null type com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationView");
        HotelsLocationView hotelsLocationView = (HotelsLocationView) view2;
        HotelsLocationViewModel hotelsLocationViewModel = this.viewModel;
        if (hotelsLocationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        HotelsFiltersDialogView view3 = getView();
        Objects.requireNonNull(view3, "null cannot be cast to non-null type com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationFilterViewImpl");
        hotelsLocationViewModel.init((HotelsLocationFilterViewImpl) view3);
        HotelsLocationViewModel hotelsLocationViewModel2 = this.viewModel;
        if (hotelsLocationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        hotelsLocationViewModel2.getSuggestListChanges().observe(this, new d(hotelsLocationView));
        e eVar = new e(function0, inflate);
        BottomSheetDialog dialog = getDialog();
        dialog.setContentView(inflate, false);
        dialog.setSkipCollapsed(true);
        dialog.setOnCloseListener(new a(inflate, eVar));
        dialog.setOnCancelListener(new b(inflate, eVar));
        BottomSheetDialog.setHeaderParams$default(dialog, null, null, false, true, 7, null);
        dialog.setForceExpandedState(true);
        hotelsLocationView.setCloseAction(new a6(0, this, function02, inflate, function1, eVar, parcelable));
        hotelsLocationView.setResetAction(new a6(1, this, function02, inflate, function1, eVar, parcelable));
        HotelsFiltersDialogView view4 = getView();
        Objects.requireNonNull(view4, "null cannot be cast to non-null type com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationFilterViewImpl");
        ((HotelsLocationFilterViewImpl) view4).selectAction().subscribe(new c(this, function02, inflate, function1, eVar, parcelable));
        hotelsLocationView.setState(parcelable);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public LifecycleRegistry getLifecycle() {
        return this.c;
    }
}
