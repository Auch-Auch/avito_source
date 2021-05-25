package com.avito.android.blueprints.publish.html_editor;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.LiveData;
import com.avito.android.html_editor.EditorNavigationEvent;
import com.avito.android.html_editor.HistorySnapshot;
import com.avito.android.html_editor.RenderedHistorySnapshot;
import com.avito.android.html_formatter.FormatChange;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.webrtc.PeerConnectionFactory;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001:\u0003+,-J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\nH&¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0019H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u001fH&¢\u0006\u0004\b \u0010!R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020\"8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001f0\"8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010%¨\u0006."}, d2 = {"Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$State;", "state", "", "setState", "(Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$State;)V", "", "itemId", "Lio/reactivex/Observable;", "Lcom/avito/android/html_formatter/FormatChange;", "itemFormatChangesObservable", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/html_editor/RenderedHistorySnapshot;", "itemSnapshotsFromStorageObservable", "itemCreateSnapshotEventsObservable", "Lcom/avito/android/html_editor/EditorNavigationEvent;", "type", "onHistoryNavigationClicked", "(Lcom/avito/android/html_editor/EditorNavigationEvent;)V", "format", "onFormatClicked", "(Lcom/avito/android/html_formatter/FormatChange;)V", "Lcom/avito/android/html_editor/HistorySnapshot;", "snapshot", "", "shouldAffectHistoryState", "onNewSnapshot", "(Lcom/avito/android/html_editor/HistorySnapshot;Z)V", "clearHistoryTopIfNeeded", "()Z", "", "setFormat", "(I)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$NavigationButtonsState;", "getNavigationStateLiveData", "()Landroidx/lifecycle/LiveData;", "navigationStateLiveData", "getStateLiveData", "stateLiveData", "getFormatStateLiveData", "formatStateLiveData", "HistoryState", "NavigationButtonsState", "State", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface HtmlEditorViewModel {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void onNewSnapshot$default(HtmlEditorViewModel htmlEditorViewModel, HistorySnapshot historySnapshot, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                htmlEditorViewModel.onNewSnapshot(historySnapshot, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onNewSnapshot");
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004\"\u0004\b\u001d\u0010\u001eR\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\u001e¨\u0006$"}, d2 = {"Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$HistoryState;", "Landroid/os/Parcelable;", "", "component1", "()I", "component2", "snapshotsCount", "currentSnapshot", "copy", "(II)Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$HistoryState;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "I", "getCurrentSnapshot", "setCurrentSnapshot", "(I)V", AuthSource.SEND_ABUSE, "getSnapshotsCount", "setSnapshotsCount", "<init>", "(II)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class HistoryState implements Parcelable {
        public static final Parcelable.Creator<HistoryState> CREATOR = new Creator();
        public int a;
        public int b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<HistoryState> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final HistoryState createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new HistoryState(parcel.readInt(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final HistoryState[] newArray(int i) {
                return new HistoryState[i];
            }
        }

        public HistoryState(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public static /* synthetic */ HistoryState copy$default(HistoryState historyState, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = historyState.a;
            }
            if ((i3 & 2) != 0) {
                i2 = historyState.b;
            }
            return historyState.copy(i, i2);
        }

        public final int component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final HistoryState copy(int i, int i2) {
            return new HistoryState(i, i2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HistoryState)) {
                return false;
            }
            HistoryState historyState = (HistoryState) obj;
            return this.a == historyState.a && this.b == historyState.b;
        }

        public final int getCurrentSnapshot() {
            return this.b;
        }

        public final int getSnapshotsCount() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final void setCurrentSnapshot(int i) {
            this.b = i;
        }

        public final void setSnapshotsCount(int i) {
            this.a = i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("HistoryState(snapshotsCount=");
            L.append(this.a);
            L.append(", currentSnapshot=");
            return a.j(L, this.b, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$NavigationButtonsState;", "", "", "component1", "()Z", "component2", "undoEnabled", "redoEnabled", "copy", "(ZZ)Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$NavigationButtonsState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Z", "getRedoEnabled", AuthSource.SEND_ABUSE, "getUndoEnabled", "<init>", "(ZZ)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class NavigationButtonsState {
        public final boolean a;
        public final boolean b;

        public NavigationButtonsState(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        public static /* synthetic */ NavigationButtonsState copy$default(NavigationButtonsState navigationButtonsState, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = navigationButtonsState.a;
            }
            if ((i & 2) != 0) {
                z2 = navigationButtonsState.b;
            }
            return navigationButtonsState.copy(z, z2);
        }

        public final boolean component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        @NotNull
        public final NavigationButtonsState copy(boolean z, boolean z2) {
            return new NavigationButtonsState(z, z2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NavigationButtonsState)) {
                return false;
            }
            NavigationButtonsState navigationButtonsState = (NavigationButtonsState) obj;
            return this.a == navigationButtonsState.a && this.b == navigationButtonsState.b;
        }

        public final boolean getRedoEnabled() {
            return this.b;
        }

        public final boolean getUndoEnabled() {
            return this.a;
        }

        public int hashCode() {
            boolean z = this.a;
            int i = 1;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = i2 * 31;
            boolean z2 = this.b;
            if (!z2) {
                i = z2 ? 1 : 0;
            }
            return i5 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("NavigationButtonsState(undoEnabled=");
            L.append(this.a);
            L.append(", redoEnabled=");
            return a.B(L, this.b, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$State;", "", "<init>", "()V", "Disabled", PeerConnectionFactory.TRIAL_ENABLED, "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$State$Enabled;", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$State$Disabled;", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$State$Disabled;", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$State;", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class Disabled extends State {
            @NotNull
            public static final Disabled INSTANCE = new Disabled();

            public Disabled() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$State$Enabled;", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$State;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "itemId", "<init>", "(Ljava/lang/String;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class Enabled extends State {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Enabled(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "itemId");
                this.a = str;
            }

            @NotNull
            public final String getItemId() {
                return this.a;
            }
        }

        public State() {
        }

        public State(j jVar) {
        }
    }

    boolean clearHistoryTopIfNeeded();

    @NotNull
    LiveData<Integer> getFormatStateLiveData();

    @NotNull
    LiveData<NavigationButtonsState> getNavigationStateLiveData();

    @NotNull
    LiveData<State> getStateLiveData();

    @NotNull
    Observable<Unit> itemCreateSnapshotEventsObservable(@NotNull String str);

    @NotNull
    Observable<FormatChange> itemFormatChangesObservable(@NotNull String str);

    @NotNull
    Observable<RenderedHistorySnapshot> itemSnapshotsFromStorageObservable(@NotNull String str);

    void onFormatClicked(@NotNull FormatChange formatChange);

    void onHistoryNavigationClicked(@NotNull EditorNavigationEvent editorNavigationEvent);

    void onNewSnapshot(@NotNull HistorySnapshot historySnapshot, boolean z);

    void setFormat(int i);

    void setState(@NotNull State state);
}
