package com.avito.android.serp.adapter.empty_placeholder;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u001d\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemView$Action;", "actions", "setActions", "(Ljava/util/List;)V", "clearActionListeners", "()V", "Action", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface EmptyPlaceholderItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R!\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemView$Action;", "", "", "component1", "()Ljava/lang/String;", "Lkotlin/Function0;", "", "component2", "()Lkotlin/jvm/functions/Function0;", "text", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "copy", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemView$Action;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getText", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "getListener", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Action {
        @NotNull
        public final String a;
        @Nullable
        public final Function0<Unit> b;

        public Action(@NotNull String str, @Nullable Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.a = str;
            this.b = function0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemView$Action */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Action copy$default(Action action, String str, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                str = action.a;
            }
            if ((i & 2) != 0) {
                function0 = action.b;
            }
            return action.copy(str, function0);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final Function0<Unit> component2() {
            return this.b;
        }

        @NotNull
        public final Action copy(@NotNull String str, @Nullable Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new Action(str, function0);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Action)) {
                return false;
            }
            Action action = (Action) obj;
            return Intrinsics.areEqual(this.a, action.a) && Intrinsics.areEqual(this.b, action.b);
        }

        @Nullable
        public final Function0<Unit> getListener() {
            return this.b;
        }

        @NotNull
        public final String getText() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Function0<Unit> function0 = this.b;
            if (function0 != null) {
                i = function0.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Action(text=");
            L.append(this.a);
            L.append(", listener=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull EmptyPlaceholderItemView emptyPlaceholderItemView) {
            ItemView.DefaultImpls.onUnbind(emptyPlaceholderItemView);
        }
    }

    void clearActionListeners();

    void setActions(@NotNull List<Action> list);

    void setSubtitle(@NotNull String str);

    void setTitle(@NotNull String str);
}
