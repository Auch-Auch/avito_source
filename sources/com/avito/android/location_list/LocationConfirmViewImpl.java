package com.avito.android.location_list;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.avito.android.lastclick.LastClick;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/avito/android/location_list/LocationConfirmViewImpl;", "Lcom/avito/android/location_list/LocationConfirmView;", "", "confirm", "Lkotlin/Function0;", "", "func", "setConfirm", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "decline", "setDecline", "(Ljava/lang/String;)V", "message", "setMessage", "Landroidx/appcompat/app/AlertDialog;", "createDialog", "()Landroidx/appcompat/app/AlertDialog;", "Landroidx/appcompat/app/AlertDialog$Builder;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/app/AlertDialog$Builder;", "builder", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "location-list_release"}, k = 1, mv = {1, 4, 2})
public final class LocationConfirmViewImpl implements LocationConfirmView {
    public final AlertDialog.Builder a;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            LastClick.Updater.update();
            Function0 function0 = this.a;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public static final b a = new b();

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            LastClick.Updater.update();
        }
    }

    public LocationConfirmViewImpl(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = new AlertDialog.Builder(activity);
    }

    @Override // com.avito.android.location_list.LocationConfirmView
    @NotNull
    public AlertDialog createDialog() {
        AlertDialog create = this.a.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        return create;
    }

    @Override // com.avito.android.location_list.LocationConfirmView
    public void setConfirm(@NotNull String str, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "confirm");
        this.a.setPositiveButton(str, new a(function0));
    }

    @Override // com.avito.android.location_list.LocationConfirmView
    public void setDecline(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "decline");
        this.a.setNegativeButton(str, b.a);
    }

    @Override // com.avito.android.location_list.LocationConfirmView
    public void setMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.a.setMessage(str);
    }
}
