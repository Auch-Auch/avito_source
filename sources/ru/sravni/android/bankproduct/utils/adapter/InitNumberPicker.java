package ru.sravni.android.bankproduct.utils.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\bJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\b¨\u0006\u001c"}, d2 = {"Lru/sravni/android/bankproduct/utils/adapter/InitNumberPicker;", "", "", "", "component1", "()Ljava/util/List;", "", "component2", "()I", "list", "currentPosition", "copy", "(Ljava/util/List;I)Lru/sravni/android/bankproduct/utils/adapter/InitNumberPicker;", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getList", AuthSource.BOOKING_ORDER, "I", "getCurrentPosition", "<init>", "(Ljava/util/List;I)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class InitNumberPicker {
    @NotNull
    public final List<String> a;
    public final int b;

    public InitNumberPicker(@NotNull List<String> list, int i) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        this.a = list;
        this.b = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.utils.adapter.InitNumberPicker */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InitNumberPicker copy$default(InitNumberPicker initNumberPicker, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = initNumberPicker.a;
        }
        if ((i2 & 2) != 0) {
            i = initNumberPicker.b;
        }
        return initNumberPicker.copy(list, i);
    }

    @NotNull
    public final List<String> component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final InitNumberPicker copy(@NotNull List<String> list, int i) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        return new InitNumberPicker(list, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InitNumberPicker)) {
            return false;
        }
        InitNumberPicker initNumberPicker = (InitNumberPicker) obj;
        return Intrinsics.areEqual(this.a, initNumberPicker.a) && this.b == initNumberPicker.b;
    }

    public final int getCurrentPosition() {
        return this.b;
    }

    @NotNull
    public final List<String> getList() {
        return this.a;
    }

    public int hashCode() {
        List<String> list = this.a;
        return ((list != null ? list.hashCode() : 0) * 31) + this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("InitNumberPicker(list=");
        L.append(this.a);
        L.append(", currentPosition=");
        return a.j(L, this.b, ")");
    }
}
