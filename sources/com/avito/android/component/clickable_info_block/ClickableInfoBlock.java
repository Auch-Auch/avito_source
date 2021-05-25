package com.avito.android.component.clickable_info_block;

import a2.b.a.a.a;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/component/clickable_info_block/ClickableInfoBlock;", "Lcom/avito/android/component/info_block/InfoBlock;", "Lio/reactivex/rxjava3/core/Observable;", "", "clicks", "()Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/component/clickable_info_block/ClickableInfoBlock$Action;", "actions", "Lio/reactivex/rxjava3/core/Maybe;", "showActions", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Maybe;", "", "enabled", "setEnabled", "(Z)V", "Action", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface ClickableInfoBlock extends InfoBlock {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/avito/android/component/clickable_info_block/ClickableInfoBlock$Action;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "id", "text", "copy", "(ILjava/lang/String;)Lcom/avito/android/component/clickable_info_block/ClickableInfoBlock$Action;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getId", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", "<init>", "(ILjava/lang/String;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Action {
        public final int a;
        @NotNull
        public final String b;

        public Action(int i, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.a = i;
            this.b = str;
        }

        public static /* synthetic */ Action copy$default(Action action, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = action.a;
            }
            if ((i2 & 2) != 0) {
                str = action.b;
            }
            return action.copy(i, str);
        }

        public final int component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final Action copy(int i, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new Action(i, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Action)) {
                return false;
            }
            Action action = (Action) obj;
            return this.a == action.a && Intrinsics.areEqual(this.b, action.b);
        }

        public final int getId() {
            return this.a;
        }

        @NotNull
        public final String getText() {
            return this.b;
        }

        public int hashCode() {
            int i = this.a * 31;
            String str = this.b;
            return i + (str != null ? str.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Action(id=");
            L.append(this.a);
            L.append(", text=");
            return a.t(L, this.b, ")");
        }
    }

    @NotNull
    Observable<Unit> clicks();

    void setEnabled(boolean z);

    @NotNull
    Maybe<Action> showActions(@NotNull List<Action> list);
}
