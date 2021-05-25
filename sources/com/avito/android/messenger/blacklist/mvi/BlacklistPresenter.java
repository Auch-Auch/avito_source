package com.avito.android.messenger.blacklist.mvi;

import a2.b.a.a.a;
import androidx.lifecycle.LiveData;
import com.avito.android.messenger.blacklist.mvi.adapter.BlacklistItem;
import com.avito.android.messenger.blacklist.mvi.adapter.blocked_user.UnblockClickListener;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0010J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\u0006R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;", "Lcom/avito/android/messenger/blacklist/mvi/adapter/blocked_user/UnblockClickListener;", "", "initialDataRequest", "()V", "refresh", "requestNextPage", "Landroidx/lifecycle/LiveData;", "", "getShowErrorStream", "()Landroidx/lifecycle/LiveData;", "showErrorStream", "getShowLoginScreenStream", "showLoginScreenStream", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface BlacklistPresenter extends MviEntity<State>, UnblockClickListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\b\b\u0018\u0000 )2\u00020\u0001:\u0002)*B-\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ>\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u0007R\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\f¨\u0006+"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;", "", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State$ProgressOverlayState;", "component1", "()Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State$ProgressOverlayState;", "", "component2", "()Z", "component3", "", "Lcom/avito/android/messenger/blacklist/mvi/adapter/BlacklistItem;", "component4", "()Ljava/util/List;", "progressOverlayState", "swipeToRefreshIsShown", "paginationIsEnabled", "listItems", "copy", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State$ProgressOverlayState;ZZLjava/util/List;)Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Z", "getPaginationIsEnabled", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State$ProgressOverlayState;", "getProgressOverlayState", AuthSource.BOOKING_ORDER, "getSwipeToRefreshIsShown", "d", "Ljava/util/List;", "getListItems", "<init>", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State$ProgressOverlayState;ZZLjava/util/List;)V", "Companion", "ProgressOverlayState", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final State e = new State(ProgressOverlayState.Loading.INSTANCE, false, false, CollectionsKt__CollectionsKt.emptyList());
        @NotNull
        public final ProgressOverlayState a;
        public final boolean b;
        public final boolean c;
        @NotNull
        public final List<BlacklistItem> d;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State$Companion;", "", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;", MessengerShareContentUtility.PREVIEW_DEFAULT, "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;", "getDEFAULT", "()Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final State getDEFAULT() {
                return State.e;
            }

            public Companion(j jVar) {
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State$ProgressOverlayState;", "", "<init>", "()V", "Error", "Hidden", "Loading", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State$ProgressOverlayState$Loading;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State$ProgressOverlayState$Error;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State$ProgressOverlayState$Hidden;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class ProgressOverlayState {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State$ProgressOverlayState$Error;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State$ProgressOverlayState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Error extends ProgressOverlayState {
                @NotNull
                public static final Error INSTANCE = new Error();

                public Error() {
                    super(null);
                }

                @NotNull
                public String toString() {
                    return "ProgressOverlayState.Error";
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State$ProgressOverlayState$Hidden;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State$ProgressOverlayState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Hidden extends ProgressOverlayState {
                @NotNull
                public static final Hidden INSTANCE = new Hidden();

                public Hidden() {
                    super(null);
                }

                @NotNull
                public String toString() {
                    return "ProgressOverlayState.Hidden";
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State$ProgressOverlayState$Loading;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter$State$ProgressOverlayState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Loading extends ProgressOverlayState {
                @NotNull
                public static final Loading INSTANCE = new Loading();

                public Loading() {
                    super(null);
                }

                @NotNull
                public String toString() {
                    return "ProgressOverlayState.Loading";
                }
            }

            public ProgressOverlayState() {
            }

            public ProgressOverlayState(j jVar) {
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends com.avito.android.messenger.blacklist.mvi.adapter.BlacklistItem> */
        /* JADX WARN: Multi-variable type inference failed */
        public State(@NotNull ProgressOverlayState progressOverlayState, boolean z, boolean z2, @NotNull List<? extends BlacklistItem> list) {
            Intrinsics.checkNotNullParameter(progressOverlayState, "progressOverlayState");
            Intrinsics.checkNotNullParameter(list, "listItems");
            this.a = progressOverlayState;
            this.b = z;
            this.c = z2;
            this.d = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.blacklist.mvi.BlacklistPresenter$State */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, ProgressOverlayState progressOverlayState, boolean z, boolean z2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                progressOverlayState = state.a;
            }
            if ((i & 2) != 0) {
                z = state.b;
            }
            if ((i & 4) != 0) {
                z2 = state.c;
            }
            if ((i & 8) != 0) {
                list = state.d;
            }
            return state.copy(progressOverlayState, z, z2, list);
        }

        @NotNull
        public final ProgressOverlayState component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        public final boolean component3() {
            return this.c;
        }

        @NotNull
        public final List<BlacklistItem> component4() {
            return this.d;
        }

        @NotNull
        public final State copy(@NotNull ProgressOverlayState progressOverlayState, boolean z, boolean z2, @NotNull List<? extends BlacklistItem> list) {
            Intrinsics.checkNotNullParameter(progressOverlayState, "progressOverlayState");
            Intrinsics.checkNotNullParameter(list, "listItems");
            return new State(progressOverlayState, z, z2, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.a, state.a) && this.b == state.b && this.c == state.c && Intrinsics.areEqual(this.d, state.d);
        }

        @NotNull
        public final List<BlacklistItem> getListItems() {
            return this.d;
        }

        public final boolean getPaginationIsEnabled() {
            return this.c;
        }

        @NotNull
        public final ProgressOverlayState getProgressOverlayState() {
            return this.a;
        }

        public final boolean getSwipeToRefreshIsShown() {
            return this.b;
        }

        public int hashCode() {
            ProgressOverlayState progressOverlayState = this.a;
            int i = 0;
            int hashCode = (progressOverlayState != null ? progressOverlayState.hashCode() : 0) * 31;
            boolean z = this.b;
            int i2 = 1;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = (hashCode + i3) * 31;
            boolean z2 = this.c;
            if (!z2) {
                i2 = z2 ? 1 : 0;
            }
            int i7 = (i6 + i2) * 31;
            List<BlacklistItem> list = this.d;
            if (list != null) {
                i = list.hashCode();
            }
            return i7 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("State(progressOverlayState=");
            L.append(this.a);
            L.append(", swipeToRefreshIsShown=");
            L.append(this.b);
            L.append(", paginationIsEnabled=");
            L.append(this.c);
            L.append(", listItems=");
            return a.w(L, this.d, ")");
        }
    }

    @NotNull
    LiveData<String> getShowErrorStream();

    @NotNull
    LiveData<Unit> getShowLoginScreenStream();

    void initialDataRequest();

    void refresh();

    void requestNextPage();
}
