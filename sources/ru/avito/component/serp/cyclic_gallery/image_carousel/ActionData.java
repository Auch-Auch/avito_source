package ru.avito.component.serp.cyclic_gallery.image_carousel;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.PhoneLoadingState;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionData;", "", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionType;", "component1", "()Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionType;", "", "component2", "()Ljava/lang/String;", "actionType", "title", "copy", "(Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionType;Ljava/lang/String;)Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionType;", "getActionType", "Lru/avito/component/serp/PhoneLoadingState;", AuthSource.SEND_ABUSE, "Lru/avito/component/serp/PhoneLoadingState;", "getLoadingState", "()Lru/avito/component/serp/PhoneLoadingState;", "setLoadingState", "(Lru/avito/component/serp/PhoneLoadingState;)V", "loadingState", "c", "Ljava/lang/String;", "getTitle", "<init>", "(Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionType;Ljava/lang/String;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ActionData {
    @NotNull
    public PhoneLoadingState a = PhoneLoadingState.IDLE;
    @NotNull
    public final ActionType b;
    @NotNull
    public final String c;

    public ActionData(@NotNull ActionType actionType, @NotNull String str) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(str, "title");
        this.b = actionType;
        this.c = str;
    }

    public static /* synthetic */ ActionData copy$default(ActionData actionData, ActionType actionType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            actionType = actionData.b;
        }
        if ((i & 2) != 0) {
            str = actionData.c;
        }
        return actionData.copy(actionType, str);
    }

    @NotNull
    public final ActionType component1() {
        return this.b;
    }

    @NotNull
    public final String component2() {
        return this.c;
    }

    @NotNull
    public final ActionData copy(@NotNull ActionType actionType, @NotNull String str) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(str, "title");
        return new ActionData(actionType, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionData)) {
            return false;
        }
        ActionData actionData = (ActionData) obj;
        return Intrinsics.areEqual(this.b, actionData.b) && Intrinsics.areEqual(this.c, actionData.c);
    }

    @NotNull
    public final ActionType getActionType() {
        return this.b;
    }

    @NotNull
    public final PhoneLoadingState getLoadingState() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.c;
    }

    public int hashCode() {
        ActionType actionType = this.b;
        int i = 0;
        int hashCode = (actionType != null ? actionType.hashCode() : 0) * 31;
        String str = this.c;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public final void setLoadingState(@NotNull PhoneLoadingState phoneLoadingState) {
        Intrinsics.checkNotNullParameter(phoneLoadingState, "<set-?>");
        this.a = phoneLoadingState;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ActionData(actionType=");
        L.append(this.b);
        L.append(", title=");
        return a.t(L, this.c, ")");
    }
}
