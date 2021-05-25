package com.avito.android.messenger.channels.mvi.presenter;

import a2.b.a.a.a;
import androidx.annotation.StringRes;
import androidx.lifecycle.LiveData;
import com.avito.android.deep_linking.links.UpdateFolderTagsLink;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fJ\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;", "", "processScreenOpened", "()V", "", VKApiConst.POSITION, "tabSelected", "(I)V", "Landroidx/lifecycle/LiveData;", "getShowOnboardingStream", "()Landroidx/lifecycle/LiveData;", "showOnboardingStream", "FolderTab", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface FoldersPresenter extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$FolderTab;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "name", UpdateFolderTagsLink.FOLDER_ID, "value", "copy", "(ILjava/lang/String;Ljava/lang/String;)Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$FolderTab;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getValue", AuthSource.SEND_ABUSE, "I", "getName", AuthSource.BOOKING_ORDER, "getFolderId", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class FolderTab {
        public final int a;
        @NotNull
        public final String b;
        @NotNull
        public final String c;

        public FolderTab(@StringRes int i, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, UpdateFolderTagsLink.FOLDER_ID);
            Intrinsics.checkNotNullParameter(str2, "value");
            this.a = i;
            this.b = str;
            this.c = str2;
        }

        public static /* synthetic */ FolderTab copy$default(FolderTab folderTab, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = folderTab.a;
            }
            if ((i2 & 2) != 0) {
                str = folderTab.b;
            }
            if ((i2 & 4) != 0) {
                str2 = folderTab.c;
            }
            return folderTab.copy(i, str, str2);
        }

        public final int component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final String component3() {
            return this.c;
        }

        @NotNull
        public final FolderTab copy(@StringRes int i, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, UpdateFolderTagsLink.FOLDER_ID);
            Intrinsics.checkNotNullParameter(str2, "value");
            return new FolderTab(i, str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FolderTab)) {
                return false;
            }
            FolderTab folderTab = (FolderTab) obj;
            return this.a == folderTab.a && Intrinsics.areEqual(this.b, folderTab.b) && Intrinsics.areEqual(this.c, folderTab.c);
        }

        @NotNull
        public final String getFolderId() {
            return this.b;
        }

        public final int getName() {
            return this.a;
        }

        @NotNull
        public final String getValue() {
            return this.c;
        }

        public int hashCode() {
            int i = this.a * 31;
            String str = this.b;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.c;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("FolderTab(name=");
            L.append(this.a);
            L.append(", folderId=");
            L.append(this.b);
            L.append(", value=");
            return a.t(L, this.c, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\bJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;", "", "", "Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$FolderTab;", "component1", "()Ljava/util/List;", "", "component2", "()I", "tabs", "selected", "copy", "(Ljava/util/List;I)Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getTabs", AuthSource.BOOKING_ORDER, "I", "getSelected", "<init>", "(Ljava/util/List;I)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final State c = new State(CollectionsKt__CollectionsKt.emptyList(), 0);
        @NotNull
        public final List<FolderTab> a;
        public final int b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State$Companion;", "", "Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;", MessengerShareContentUtility.PREVIEW_DEFAULT, "Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;", "getDEFAULT", "()Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final State getDEFAULT() {
                return State.c;
            }

            public Companion(j jVar) {
            }
        }

        public State(@NotNull List<FolderTab> list, int i) {
            Intrinsics.checkNotNullParameter(list, "tabs");
            this.a = list;
            this.b = i;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.channels.mvi.presenter.FoldersPresenter$State */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, List list, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = state.a;
            }
            if ((i2 & 2) != 0) {
                i = state.b;
            }
            return state.copy(list, i);
        }

        @NotNull
        public final List<FolderTab> component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final State copy(@NotNull List<FolderTab> list, int i) {
            Intrinsics.checkNotNullParameter(list, "tabs");
            return new State(list, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.a, state.a) && this.b == state.b;
        }

        public final int getSelected() {
            return this.b;
        }

        @NotNull
        public final List<FolderTab> getTabs() {
            return this.a;
        }

        public int hashCode() {
            List<FolderTab> list = this.a;
            return ((list != null ? list.hashCode() : 0) * 31) + this.b;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("State(tabs=");
            L.append(this.a);
            L.append(", selected=");
            return a.j(L, this.b, ")");
        }
    }

    @NotNull
    LiveData<Unit> getShowOnboardingStream();

    void processScreenOpened();

    void tabSelected(int i);
}
