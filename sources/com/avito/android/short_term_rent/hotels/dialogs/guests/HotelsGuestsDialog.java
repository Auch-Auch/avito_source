package com.avito.android.short_term_rent.hotels.dialogs.guests;

import a2.a.a.v2.b.i.b.a;
import a2.a.a.v2.b.i.b.b;
import a2.a.a.v2.b.i.b.c;
import a2.g.r.g;
import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.model.hotels.Adults;
import com.avito.android.remote.model.hotels.Children;
import com.avito.android.short_term_rent.R;
import com.avito.android.short_term_rent.hotels.data.BookingPeople;
import com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialog;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002Bt\u0012\u0006\u0010(\u001a\u00020#\u0012\u0006\u00100\u001a\u00020)\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\u0006\u0010\"\u001a\u00020\u001b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012#\u00105\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010)¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u000301\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000306\u0012\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u000306¢\u0006\u0004\b9\u0010:J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0019\u0010(\u001a\u00020#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u00100\u001a\u00020)8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006;"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/dialogs/guests/HotelsGuestsDialog;", "Lcom/avito/android/short_term_rent/hotels/dialogs/HotelsFiltersDialog;", "Landroidx/lifecycle/LifecycleOwner;", "", "show", "()V", "dismiss", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle", "()Landroidx/lifecycle/LifecycleRegistry;", "Landroid/os/Parcelable;", "h", "Landroid/os/Parcelable;", "getState", "()Landroid/os/Parcelable;", "state", "Lcom/avito/android/remote/model/hotels/Adults;", "f", "Lcom/avito/android/remote/model/hotels/Adults;", "getAdults", "()Lcom/avito/android/remote/model/hotels/Adults;", "setAdults", "(Lcom/avito/android/remote/model/hotels/Adults;)V", "adults", "c", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "Lcom/avito/android/remote/model/hotels/Children;", g.a, "Lcom/avito/android/remote/model/hotels/Children;", "getChildren", "()Lcom/avito/android/remote/model/hotels/Children;", "setChildren", "(Lcom/avito/android/remote/model/hotels/Children;)V", "children", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;", "e", "Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;", "getSelected", "()Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;", "setSelected", "(Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;)V", "selected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "selectedValue", "selectedItemListener", "Lkotlin/Function0;", "dialogCloseListener", "closeButtonListener", "<init>", "(Landroid/content/Context;Lcom/avito/android/short_term_rent/hotels/data/BookingPeople;Lcom/avito/android/remote/model/hotels/Adults;Lcom/avito/android/remote/model/hotels/Children;Landroid/os/Parcelable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class HotelsGuestsDialog extends HotelsFiltersDialog implements LifecycleOwner {
    public final LifecycleRegistry c;
    @NotNull
    public final Context d;
    @NotNull
    public BookingPeople e;
    @NotNull
    public Adults f;
    @NotNull
    public Children g;
    @Nullable
    public final Parcelable h;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HotelsGuestsDialog(Context context, BookingPeople bookingPeople, Adults adults, Children children, Parcelable parcelable, Function1 function1, Function0 function0, Function0 function02, int i, j jVar) {
        this(context, bookingPeople, adults, children, parcelable, function1, function0, (i & 128) != 0 ? function0 : function02);
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialog
    public void dismiss() {
        super.dismiss();
        this.c.setCurrentState(Lifecycle.State.DESTROYED);
    }

    @NotNull
    public final Adults getAdults() {
        return this.f;
    }

    @NotNull
    public final Children getChildren() {
        return this.g;
    }

    @NotNull
    public final Context getContext() {
        return this.d;
    }

    @NotNull
    public final BookingPeople getSelected() {
        return this.e;
    }

    @Nullable
    public final Parcelable getState() {
        return this.h;
    }

    public final void setAdults(@NotNull Adults adults) {
        Intrinsics.checkNotNullParameter(adults, "<set-?>");
        this.f = adults;
    }

    public final void setChildren(@NotNull Children children) {
        Intrinsics.checkNotNullParameter(children, "<set-?>");
        this.g = children;
    }

    public final void setSelected(@NotNull BookingPeople bookingPeople) {
        Intrinsics.checkNotNullParameter(bookingPeople, "<set-?>");
        this.e = bookingPeople;
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialog
    public void show() {
        super.show();
        this.c.setCurrentState(Lifecycle.State.RESUMED);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HotelsGuestsDialog(@NotNull Context context, @NotNull BookingPeople bookingPeople, @NotNull Adults adults, @NotNull Children children, @Nullable Parcelable parcelable, @NotNull Function1<? super BookingPeople, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        super(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bookingPeople, "selected");
        Intrinsics.checkNotNullParameter(adults, "adults");
        Intrinsics.checkNotNullParameter(children, "children");
        Intrinsics.checkNotNullParameter(function1, "selectedItemListener");
        Intrinsics.checkNotNullParameter(function0, "dialogCloseListener");
        Intrinsics.checkNotNullParameter(function02, "closeButtonListener");
        this.d = context;
        this.e = bookingPeople;
        this.f = adults;
        this.g = children;
        this.h = parcelable;
        this.c = new LifecycleRegistry(this);
        Object systemService = context.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View inflate = ((LayoutInflater) systemService).inflate(R.layout.hotels_guests_dialog, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "containerView");
        setView(new HotelsGuestsDialogViewImpl(inflate, this.e, this.f, this.g));
        BottomSheetDialog dialog = getDialog();
        dialog.setContentView(inflate, false);
        dialog.setSkipCollapsed(true);
        dialog.setOnCloseListener(new a(inflate, function0));
        dialog.setOnCancelListener(new b(inflate, function0));
        BottomSheetDialog.setHeaderParams$default(dialog, null, null, false, true, 7, null);
        dialog.setForceExpandedState(false);
        HotelsGuestsView hotelsGuestsView = (HotelsGuestsView) getView();
        if (hotelsGuestsView != null) {
            hotelsGuestsView.setCloseAction(new j6(0, this, function02, function1, function0));
            hotelsGuestsView.setResetAction(new j6(1, this, function02, function1, function0));
            hotelsGuestsView.setApplyAction(new c(this, function02, function1, function0));
            hotelsGuestsView.setState(hotelsGuestsView.getState());
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public LifecycleRegistry getLifecycle() {
        return this.c;
    }
}
