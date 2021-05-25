package com.avito.android.profile.edit;

import com.avito.android.permissions.PermissionResultHandler;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH&¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/profile/edit/PermissionHandler;", "Lcom/avito/android/permissions/PermissionResultHandler;", "", "checkPermissions", "()V", "requestUnmetPermissions", "", "isGranted", "()Z", "canRequest", "Lkotlin/Function0;", "onCantRequest", "requestPermission", "(Lkotlin/jvm/functions/Function0;)V", "Lio/reactivex/Observable;", "getPermissionChanges", "()Lio/reactivex/Observable;", "permissionChanges", "getCanRequestPermissionChanges", "canRequestPermissionChanges", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface PermissionHandler extends PermissionResultHandler {
    boolean canRequest();

    void checkPermissions();

    @NotNull
    Observable<Boolean> getCanRequestPermissionChanges();

    @NotNull
    Observable<Boolean> getPermissionChanges();

    boolean isGranted();

    void requestPermission(@NotNull Function0<Unit> function0);

    void requestUnmetPermissions();
}
