package ru.sravni.android.bankproduct.utils.permission;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\u001c\u0010\u001dB\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001fJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ \u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\b¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/utils/permission/PermissionSravniInfo;", "", "", "", "getPermissionsArray", "()[Ljava/lang/String;", "", "component1", "()Ljava/util/List;", "permissions", "copy", "(Ljava/util/List;)Lru/sravni/android/bankproduct/utils/permission/PermissionSravniInfo;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Z", "isEmpty", "()Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getPermissions", "<init>", "(Ljava/util/List;)V", "onePermission", "(Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class PermissionSravniInfo {
    public final boolean a;
    @NotNull
    public final List<String> b;

    public PermissionSravniInfo() {
        this(null, 1, null);
    }

    public PermissionSravniInfo(@NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "permissions");
        this.b = list;
        this.a = list.isEmpty();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.utils.permission.PermissionSravniInfo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PermissionSravniInfo copy$default(PermissionSravniInfo permissionSravniInfo, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = permissionSravniInfo.b;
        }
        return permissionSravniInfo.copy(list);
    }

    @NotNull
    public final List<String> component1() {
        return this.b;
    }

    @NotNull
    public final PermissionSravniInfo copy(@NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "permissions");
        return new PermissionSravniInfo(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof PermissionSravniInfo) && Intrinsics.areEqual(this.b, ((PermissionSravniInfo) obj).b);
        }
        return true;
    }

    @NotNull
    public final List<String> getPermissions() {
        return this.b;
    }

    @NotNull
    public final String[] getPermissionsArray() {
        Object[] array = this.b.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public int hashCode() {
        List<String> list = this.b;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final boolean isEmpty() {
        return this.a;
    }

    @NotNull
    public String toString() {
        return a.w(a.L("PermissionSravniInfo(permissions="), this.b, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PermissionSravniInfo(List list, int i, j jVar) {
        this((i & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PermissionSravniInfo(@NotNull String str) {
        this(d.listOf(str));
        Intrinsics.checkParameterIsNotNull(str, "onePermission");
    }
}
