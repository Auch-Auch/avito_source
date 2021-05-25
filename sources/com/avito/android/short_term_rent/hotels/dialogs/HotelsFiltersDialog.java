package com.avito.android.short_term_rent.hotels.dialogs;

import android.content.Context;
import android.os.Parcelable;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\t\u0010\u0004R\u001c\u0010\u000f\u001a\u00020\n8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/dialogs/HotelsFiltersDialog;", "", "", "show", "()V", "dismiss", "Landroid/os/Parcelable;", "onSaveState", "()Landroid/os/Parcelable;", "performDismiss", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "getDialog", "()Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "dialog", "Lcom/avito/android/short_term_rent/hotels/dialogs/HotelsFiltersDialogView;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/short_term_rent/hotels/dialogs/HotelsFiltersDialogView;", "getView", "()Lcom/avito/android/short_term_rent/hotels/dialogs/HotelsFiltersDialogView;", "setView", "(Lcom/avito/android/short_term_rent/hotels/dialogs/HotelsFiltersDialogView;)V", "view", "Landroid/content/Context;", "context", "", "theme", "<init>", "(Landroid/content/Context;I)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public abstract class HotelsFiltersDialog {
    @NotNull
    public final BottomSheetDialog a;
    @Nullable
    public HotelsFiltersDialogView b;

    public HotelsFiltersDialog(@Nullable Context context, int i) {
        Intrinsics.checkNotNull(context);
        this.a = new BottomSheetDialog(context, i);
    }

    public void dismiss() {
        performDismiss();
    }

    @NotNull
    public final BottomSheetDialog getDialog() {
        return this.a;
    }

    @Nullable
    public HotelsFiltersDialogView getView() {
        return this.b;
    }

    @Nullable
    public Parcelable onSaveState() {
        HotelsFiltersDialogView view = getView();
        if (view != null) {
            return view.getState();
        }
        return null;
    }

    public final void performDismiss() {
        this.a.dismiss();
        setView(null);
    }

    public void setView(@Nullable HotelsFiltersDialogView hotelsFiltersDialogView) {
        this.b = hotelsFiltersDialogView;
    }

    public void show() {
        this.a.show();
        this.a.expand();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HotelsFiltersDialog(Context context, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? 0 : i);
    }
}
