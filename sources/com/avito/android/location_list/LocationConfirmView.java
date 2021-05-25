package com.avito.android.location_list;

import androidx.appcompat.app.AlertDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J'\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/location_list/LocationConfirmView;", "", "", "message", "", "setMessage", "(Ljava/lang/String;)V", "decline", "setDecline", "confirm", "Lkotlin/Function0;", "func", "setConfirm", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Landroidx/appcompat/app/AlertDialog;", "createDialog", "()Landroidx/appcompat/app/AlertDialog;", "location-list_release"}, k = 1, mv = {1, 4, 2})
public interface LocationConfirmView {
    @NotNull
    AlertDialog createDialog();

    void setConfirm(@NotNull String str, @Nullable Function0<Unit> function0);

    void setDecline(@NotNull String str);

    void setMessage(@NotNull String str);
}
