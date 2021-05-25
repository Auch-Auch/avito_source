package a2.a.a.l;

import a2.b.a.a.a;
import com.avito.android.async_phone.AsyncPhoneItem;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.AsyncPhoneItemView;
public final class g {
    @Nullable
    public final AsyncPhoneItem a;
    @Nullable
    public final AsyncPhoneItemView b;

    public g(@Nullable AsyncPhoneItem asyncPhoneItem, @Nullable AsyncPhoneItemView asyncPhoneItemView) {
        this.a = asyncPhoneItem;
        this.b = asyncPhoneItemView;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.areEqual(this.a, gVar.a) && Intrinsics.areEqual(this.b, gVar.b);
    }

    public int hashCode() {
        AsyncPhoneItem asyncPhoneItem = this.a;
        int i = 0;
        int hashCode = (asyncPhoneItem != null ? asyncPhoneItem.hashCode() : 0) * 31;
        AsyncPhoneItemView asyncPhoneItemView = this.b;
        if (asyncPhoneItemView != null) {
            i = asyncPhoneItemView.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("PhoneLoadingPair(item=");
        L.append(this.a);
        L.append(", itemView=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
