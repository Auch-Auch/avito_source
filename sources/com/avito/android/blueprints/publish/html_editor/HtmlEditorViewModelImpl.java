package com.avito.android.blueprints.publish.html_editor;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.html_editor.EditorHistoryProvider;
import com.avito.android.html_editor.EditorNavigationEvent;
import com.avito.android.html_editor.HistorySnapshot;
import com.avito.android.html_editor.RenderedHistorySnapshot;
import com.avito.android.html_formatter.FormatChange;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001MB'\u0012\u0006\u0010J\u001a\u00020I\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010H\u001a\u00020E¢\u0006\u0004\bK\u0010LJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u0013\u0010%\u001a\u00020$*\u00020#H\u0002¢\u0006\u0004\b%\u0010&R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020$0'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010)R\"\u00105\u001a\b\u0012\u0004\u0012\u00020 008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\"\u00108\u001a\b\u0012\u0004\u0012\u00020\u0003008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00104R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020 0'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010)R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\"\u0010A\u001a\b\u0012\u0004\u0012\u00020$008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u00102\u001a\u0004\b@\u00104R\u0016\u0010D\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006N"}, d2 = {"Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$State;", "state", "", "setState", "(Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$State;)V", "", "itemId", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/html_formatter/FormatChange;", "itemFormatChangesObservable", "(Ljava/lang/String;)Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/html_editor/RenderedHistorySnapshot;", "itemSnapshotsFromStorageObservable", "itemCreateSnapshotEventsObservable", "format", "onFormatClicked", "(Lcom/avito/android/html_formatter/FormatChange;)V", "Lcom/avito/android/html_editor/HistorySnapshot;", "snapshot", "", "shouldAffectHistoryState", "onNewSnapshot", "(Lcom/avito/android/html_editor/HistorySnapshot;Z)V", "clearHistoryTopIfNeeded", "()Z", "Lcom/avito/android/html_editor/EditorNavigationEvent;", "type", "onHistoryNavigationClicked", "(Lcom/avito/android/html_editor/EditorNavigationEvent;)V", "", "setFormat", "(I)V", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$HistoryState;", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$NavigationButtonsState;", "c", "(Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$HistoryState;)Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel$NavigationButtonsState;", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "k", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "f", "navigationState", "Landroidx/lifecycle/LiveData;", "h", "Landroidx/lifecycle/LiveData;", "getFormatStateLiveData", "()Landroidx/lifecycle/LiveData;", "formatStateLiveData", g.a, "getStateLiveData", "stateLiveData", "e", "formatState", "Lcom/avito/android/html_editor/EditorHistoryProvider;", "j", "Lcom/avito/android/html_editor/EditorHistoryProvider;", "historyProvider", "i", "getNavigationStateLiveData", "navigationStateLiveData", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModelImpl$a;", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModelImpl$a;", "storage", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "l", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "htmlRenderOptions", "Landroidx/lifecycle/SavedStateHandle;", "stateHandle", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Lcom/avito/android/html_editor/EditorHistoryProvider;Lcom/avito/android/html_formatter/HtmlNodeFactory;Lcom/avito/android/html_formatter/HtmlRenderOptions;)V", AuthSource.SEND_ABUSE, "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class HtmlEditorViewModelImpl extends ViewModel implements HtmlEditorViewModel {
    public final a c;
    public final MutableLiveData<HtmlEditorViewModel.State> d;
    public final MutableLiveData<Integer> e;
    public final MutableLiveData<HtmlEditorViewModel.NavigationButtonsState> f;
    @NotNull
    public final LiveData<HtmlEditorViewModel.State> g;
    @NotNull
    public final LiveData<Integer> h;
    @NotNull
    public final LiveData<HtmlEditorViewModel.NavigationButtonsState> i;
    public final EditorHistoryProvider j;
    public final HtmlNodeFactory k;
    public final HtmlRenderOptions l;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            EditorNavigationEvent.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public static final class a {
        public final Map<String, PublishRelay<FormatChange>> a = new LinkedHashMap();
        public final Map<String, PublishRelay<RenderedHistorySnapshot>> b = new LinkedHashMap();
        public final Map<String, PublishRelay<Unit>> c = new LinkedHashMap();
        public final SavedStateHandle d;

        public a(@NotNull SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "historyState");
            this.d = savedStateHandle;
        }

        @NotNull
        public final PublishRelay<Unit> a(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            Map<String, PublishRelay<Unit>> map = this.c;
            PublishRelay<Unit> publishRelay = map.get(str);
            if (publishRelay == null) {
                publishRelay = PublishRelay.create();
                Intrinsics.checkNotNullExpressionValue(publishRelay, "PublishRelay.create()");
                map.put(str, publishRelay);
            }
            return publishRelay;
        }

        @NotNull
        public final PublishRelay<FormatChange> b(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            Map<String, PublishRelay<FormatChange>> map = this.a;
            PublishRelay<FormatChange> publishRelay = map.get(str);
            if (publishRelay == null) {
                publishRelay = PublishRelay.create();
                Intrinsics.checkNotNullExpressionValue(publishRelay, "PublishRelay.create()");
                map.put(str, publishRelay);
            }
            return publishRelay;
        }

        @NotNull
        public final HtmlEditorViewModel.HistoryState c(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            HtmlEditorViewModel.HistoryState historyState = (HtmlEditorViewModel.HistoryState) this.d.get(str);
            if (historyState == null) {
                historyState = new HtmlEditorViewModel.HistoryState(0, 0);
                this.d.set(str, historyState);
            }
            Intrinsics.checkNotNullExpressionValue(historyState, "historyState.get<HtmlEdi…itemId, this) }\n        }");
            return historyState;
        }

        @NotNull
        public final PublishRelay<RenderedHistorySnapshot> d(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            Map<String, PublishRelay<RenderedHistorySnapshot>> map = this.b;
            PublishRelay<RenderedHistorySnapshot> publishRelay = map.get(str);
            if (publishRelay == null) {
                publishRelay = PublishRelay.create();
                Intrinsics.checkNotNullExpressionValue(publishRelay, "PublishRelay.create()");
                map.put(str, publishRelay);
            }
            return publishRelay;
        }
    }

    public HtmlEditorViewModelImpl(@NotNull SavedStateHandle savedStateHandle, @NotNull EditorHistoryProvider editorHistoryProvider, @NotNull HtmlNodeFactory htmlNodeFactory, @NotNull HtmlRenderOptions htmlRenderOptions) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "stateHandle");
        Intrinsics.checkNotNullParameter(editorHistoryProvider, "historyProvider");
        Intrinsics.checkNotNullParameter(htmlNodeFactory, "htmlNodeFactory");
        Intrinsics.checkNotNullParameter(htmlRenderOptions, "htmlRenderOptions");
        this.j = editorHistoryProvider;
        this.k = htmlNodeFactory;
        this.l = htmlRenderOptions;
        this.c = new a(savedStateHandle);
        MutableLiveData<HtmlEditorViewModel.State> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this.e = mutableLiveData2;
        MutableLiveData<HtmlEditorViewModel.NavigationButtonsState> mutableLiveData3 = new MutableLiveData<>();
        this.f = mutableLiveData3;
        this.g = mutableLiveData;
        this.h = mutableLiveData2;
        this.i = mutableLiveData3;
        if (savedStateHandle.keys().isEmpty()) {
            editorHistoryProvider.clearAllHistories();
        }
    }

    public final HtmlEditorViewModel.NavigationButtonsState c(HtmlEditorViewModel.HistoryState historyState) {
        boolean z = false;
        boolean z2 = historyState.getCurrentSnapshot() > 0;
        if (historyState.getCurrentSnapshot() < historyState.getSnapshotsCount()) {
            z = true;
        }
        return new HtmlEditorViewModel.NavigationButtonsState(z2, z);
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel
    public boolean clearHistoryTopIfNeeded() {
        String itemId;
        HtmlEditorViewModel.State value = this.d.getValue();
        if (!(value instanceof HtmlEditorViewModel.State.Enabled)) {
            value = null;
        }
        HtmlEditorViewModel.State.Enabled enabled = (HtmlEditorViewModel.State.Enabled) value;
        if (enabled == null || (itemId = enabled.getItemId()) == null) {
            return false;
        }
        HtmlEditorViewModel.HistoryState c2 = this.c.c(itemId);
        if (c2.getCurrentSnapshot() >= c2.getSnapshotsCount()) {
            return false;
        }
        this.j.clearSnapshots(itemId, c2.getCurrentSnapshot() + 1, c2.getSnapshotsCount());
        c2.setCurrentSnapshot(c2.getCurrentSnapshot() + 1);
        c2.setSnapshotsCount(c2.getCurrentSnapshot());
        this.f.setValue(c(c2));
        return true;
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel
    @NotNull
    public LiveData<Integer> getFormatStateLiveData() {
        return this.h;
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel
    @NotNull
    public LiveData<HtmlEditorViewModel.NavigationButtonsState> getNavigationStateLiveData() {
        return this.i;
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel
    @NotNull
    public LiveData<HtmlEditorViewModel.State> getStateLiveData() {
        return this.g;
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel
    public void onFormatClicked(@NotNull FormatChange formatChange) {
        String itemId;
        Intrinsics.checkNotNullParameter(formatChange, "format");
        HtmlEditorViewModel.State value = this.d.getValue();
        if (!(value instanceof HtmlEditorViewModel.State.Enabled)) {
            value = null;
        }
        HtmlEditorViewModel.State.Enabled enabled = (HtmlEditorViewModel.State.Enabled) value;
        if (enabled != null && (itemId = enabled.getItemId()) != null) {
            this.c.b(itemId).accept(formatChange);
        }
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel
    public void onHistoryNavigationClicked(@NotNull EditorNavigationEvent editorNavigationEvent) {
        String itemId;
        Intrinsics.checkNotNullParameter(editorNavigationEvent, "type");
        HtmlEditorViewModel.State value = this.d.getValue();
        if (!(value instanceof HtmlEditorViewModel.State.Enabled)) {
            value = null;
        }
        HtmlEditorViewModel.State.Enabled enabled = (HtmlEditorViewModel.State.Enabled) value;
        if (enabled != null && (itemId = enabled.getItemId()) != null) {
            HtmlEditorViewModel.HistoryState c2 = this.c.c(itemId);
            int ordinal = editorNavigationEvent.ordinal();
            if (ordinal == 0) {
                if (this.j.getHistorySnapshot(itemId, c2.getCurrentSnapshot()) == null) {
                    this.c.a(itemId).accept(Unit.INSTANCE);
                }
                c2.setCurrentSnapshot(c2.getCurrentSnapshot() - 1);
            } else if (ordinal == 1) {
                c2.setCurrentSnapshot(c2.getCurrentSnapshot() + 1);
            }
            this.f.setValue(c(c2));
            HistorySnapshot historySnapshot = this.j.getHistorySnapshot(itemId, c2.getCurrentSnapshot());
            if (historySnapshot != null) {
                MutableHtmlNode createMutableNodeFrom = this.k.createMutableNodeFrom(historySnapshot.getValue());
                this.c.d(itemId).accept(new RenderedHistorySnapshot(createMutableNodeFrom.render(this.l), createMutableNodeFrom, historySnapshot.getValue(), historySnapshot.getSelectionStart(), historySnapshot.getSelectionEnd()));
            }
        }
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel
    public void onNewSnapshot(@NotNull HistorySnapshot historySnapshot, boolean z) {
        String itemId;
        Intrinsics.checkNotNullParameter(historySnapshot, "snapshot");
        HtmlEditorViewModel.State value = this.d.getValue();
        if (!(value instanceof HtmlEditorViewModel.State.Enabled)) {
            value = null;
        }
        HtmlEditorViewModel.State.Enabled enabled = (HtmlEditorViewModel.State.Enabled) value;
        if (enabled != null && (itemId = enabled.getItemId()) != null) {
            HtmlEditorViewModel.HistoryState c2 = this.c.c(itemId);
            this.j.saveHistorySnapshot(itemId, c2.getCurrentSnapshot(), historySnapshot);
            if (z) {
                c2.setCurrentSnapshot(c2.getCurrentSnapshot() + 1);
                c2.setSnapshotsCount(c2.getSnapshotsCount() + 1);
            }
            this.f.setValue(c(c2));
        }
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel
    public void setFormat(int i2) {
        this.e.setValue(Integer.valueOf(i2));
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel
    public void setState(@NotNull HtmlEditorViewModel.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.d.setValue(state);
        if (state instanceof HtmlEditorViewModel.State.Enabled) {
            this.f.setValue(c(this.c.c(((HtmlEditorViewModel.State.Enabled) state).getItemId())));
        } else {
            boolean z = state instanceof HtmlEditorViewModel.State.Disabled;
        }
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel
    @NotNull
    public PublishRelay<Unit> itemCreateSnapshotEventsObservable(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return this.c.a(str);
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel
    @NotNull
    public PublishRelay<FormatChange> itemFormatChangesObservable(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return this.c.b(str);
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel
    @NotNull
    public PublishRelay<RenderedHistorySnapshot> itemSnapshotsFromStorageObservable(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return this.c.d(str);
    }
}
