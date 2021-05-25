package com.avito.android.lib.design.snackbar.util;

import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b#\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJY\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u000f2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenterImpl;", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "Lcom/avito/android/lib/design/snackbar/util/SnackbarElementView;", "view", "", "setDefaultElement", "(Lcom/avito/android/lib/design/snackbar/util/SnackbarElementView;)V", "Lcom/avito/android/lib/design/snackbar/util/OptionalSnackbarElementView;", "addOptionalElement", "(Lcom/avito/android/lib/design/snackbar/util/OptionalSnackbarElementView;)V", "removeOptionalElement", "clear", "()V", "", "text", "", "textResId", "actionText", "actionTextResId", "Lkotlin/Function0;", "onActionClick", "duration", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "type", "showSnackbar", "(Ljava/lang/String;ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILcom/avito/android/lib/design/snackbar/SnackbarPosition;Lcom/avito/android/lib/design/snackbar/SnackbarType;)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/snackbar/util/SnackbarElementView;", "defaultElement", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "optionalElements", "<init>", "components_release"}, k = 1, mv = {1, 4, 2})
public final class CompositeSnackbarPresenterImpl implements CompositeSnackbarPresenter {
    public final List<OptionalSnackbarElementView> a = new ArrayList();
    public SnackbarElementView b;

    @Override // com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter
    public void addOptionalElement(@NotNull OptionalSnackbarElementView optionalSnackbarElementView) {
        Intrinsics.checkNotNullParameter(optionalSnackbarElementView, "view");
        this.a.add(optionalSnackbarElementView);
    }

    @Override // com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter
    public void clear() {
        this.b = null;
        this.a.clear();
    }

    @Override // com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter
    public void removeOptionalElement(@NotNull OptionalSnackbarElementView optionalSnackbarElementView) {
        Intrinsics.checkNotNullParameter(optionalSnackbarElementView, "view");
        this.a.remove(optionalSnackbarElementView);
    }

    @Override // com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter
    public void setDefaultElement(@NotNull SnackbarElementView snackbarElementView) {
        Intrinsics.checkNotNullParameter(snackbarElementView, "view");
        this.b = snackbarElementView;
    }

    @Override // com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter
    public void showSnackbar(@NotNull String str, int i, @Nullable String str2, int i2, @Nullable Function0<Unit> function0, int i3, @NotNull SnackbarPosition snackbarPosition, @NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(snackbarType, "type");
        for (T t : this.a) {
            if (t.canShowSnackbar()) {
                t.showSnackbar(str, i, str2, i2, function0, i3, snackbarPosition, snackbarType);
                return;
            }
        }
        SnackbarElementView snackbarElementView = this.b;
        if (snackbarElementView != null) {
            snackbarElementView.showSnackbar(str, i, str2, i2, function0, i3, snackbarPosition, snackbarType);
        }
    }
}
