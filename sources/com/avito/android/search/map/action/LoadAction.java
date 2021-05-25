package com.avito.android.search.map.action;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.remote.model.search.map.MarkersResponse;
import com.avito.android.search.map.PinAdverts;
import com.avito.android.search.map.interactor.SerpInteractor;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.util.LoadingState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\n\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/search/map/action/LoadAction;", "Lcom/avito/android/search/map/action/MapAction;", "<init>", "()V", "AppendPinAdverts", "AppendSerp", "InitSerp", "LoadAd", "LoadInlineFilters", "LoadMarkers", "LoadPinAdverts", "LoadSavedSearchControlDeeplink", "LoadSearchDeepLink", "LoadSerp", "ReloadSerp", "RestorePinAdverts", "Lcom/avito/android/search/map/action/LoadAction$LoadMarkers;", "Lcom/avito/android/search/map/action/LoadAction$LoadInlineFilters;", "Lcom/avito/android/search/map/action/LoadAction$LoadSerp;", "Lcom/avito/android/search/map/action/LoadAction$AppendSerp;", "Lcom/avito/android/search/map/action/LoadAction$LoadAd;", "Lcom/avito/android/search/map/action/LoadAction$LoadPinAdverts;", "Lcom/avito/android/search/map/action/LoadAction$AppendPinAdverts;", "Lcom/avito/android/search/map/action/LoadAction$RestorePinAdverts;", "Lcom/avito/android/search/map/action/LoadAction$LoadSearchDeepLink;", "Lcom/avito/android/search/map/action/LoadAction$LoadSavedSearchControlDeeplink;", "map_release"}, k = 1, mv = {1, 4, 2})
public abstract class LoadAction implements MapAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/search/map/action/LoadAction$AppendPinAdverts;", "Lcom/avito/android/search/map/action/LoadAction;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/search/map/PinAdverts;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/LoadingState;", "getState", "()Lcom/avito/android/util/LoadingState;", "state", "<init>", "(Lcom/avito/android/util/LoadingState;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class AppendPinAdverts extends LoadAction {
        @NotNull
        public final LoadingState<PinAdverts> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.util.LoadingState<? super com.avito.android.search.map.PinAdverts> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AppendPinAdverts(@NotNull LoadingState<? super PinAdverts> loadingState) {
            super(null);
            Intrinsics.checkNotNullParameter(loadingState, "state");
            this.a = loadingState;
        }

        @NotNull
        public final LoadingState<PinAdverts> getState() {
            return this.a;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("AppendPinAdverts(state=");
            L.append(this.a);
            L.append(')');
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/search/map/action/LoadAction$AppendSerp;", "Lcom/avito/android/search/map/action/LoadAction;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/search/map/interactor/SerpInteractor$Result;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/LoadingState;", "getState", "()Lcom/avito/android/util/LoadingState;", "state", "<init>", "(Lcom/avito/android/util/LoadingState;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class AppendSerp extends LoadAction {
        @NotNull
        public final LoadingState<SerpInteractor.Result> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.util.LoadingState<? super com.avito.android.search.map.interactor.SerpInteractor$Result> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AppendSerp(@NotNull LoadingState<? super SerpInteractor.Result> loadingState) {
            super(null);
            Intrinsics.checkNotNullParameter(loadingState, "state");
            this.a = loadingState;
        }

        @NotNull
        public final LoadingState<SerpInteractor.Result> getState() {
            return this.a;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("AppendSerp(state=");
            L.append(this.a);
            L.append(')');
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/LoadAction$InitSerp;", "Lcom/avito/android/search/map/action/LoadAction$LoadSerp;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/search/map/interactor/SerpInteractor$Result;", "state", "<init>", "(Lcom/avito/android/util/LoadingState;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class InitSerp extends LoadSerp {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InitSerp(@NotNull LoadingState<? super SerpInteractor.Result> loadingState) {
            super(loadingState);
            Intrinsics.checkNotNullParameter(loadingState, "state");
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("InitSerp(state=");
            L.append(getState());
            L.append(')');
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/LoadAction$LoadAd;", "Lcom/avito/android/search/map/action/LoadAction;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "getAd", "()Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "ad", "<init>", "(Lcom/avito/android/serp/adapter/ViewTypeSerpItem;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class LoadAd extends LoadAction {
        @NotNull
        public final ViewTypeSerpItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadAd(@NotNull ViewTypeSerpItem viewTypeSerpItem) {
            super(null);
            Intrinsics.checkNotNullParameter(viewTypeSerpItem, "ad");
            this.a = viewTypeSerpItem;
        }

        @NotNull
        public final ViewTypeSerpItem getAd() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/search/map/action/LoadAction$LoadInlineFilters;", "Lcom/avito/android/search/map/action/LoadAction;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/search/InlineFilters;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/LoadingState;", "getState", "()Lcom/avito/android/util/LoadingState;", "state", "<init>", "(Lcom/avito/android/util/LoadingState;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class LoadInlineFilters extends LoadAction {
        @NotNull
        public final LoadingState<InlineFilters> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.util.LoadingState<? super com.avito.android.remote.model.search.InlineFilters> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadInlineFilters(@NotNull LoadingState<? super InlineFilters> loadingState) {
            super(null);
            Intrinsics.checkNotNullParameter(loadingState, "state");
            this.a = loadingState;
        }

        @NotNull
        public final LoadingState<InlineFilters> getState() {
            return this.a;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("LoadInlineFilters(state=");
            L.append(this.a);
            L.append(')');
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/search/map/action/LoadAction$LoadMarkers;", "Lcom/avito/android/search/map/action/LoadAction;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/search/map/MarkersResponse;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/LoadingState;", "getState", "()Lcom/avito/android/util/LoadingState;", "state", "<init>", "(Lcom/avito/android/util/LoadingState;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class LoadMarkers extends LoadAction {
        @NotNull
        public final LoadingState<MarkersResponse> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.util.LoadingState<? super com.avito.android.remote.model.search.map.MarkersResponse> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadMarkers(@NotNull LoadingState<? super MarkersResponse> loadingState) {
            super(null);
            Intrinsics.checkNotNullParameter(loadingState, "state");
            this.a = loadingState;
        }

        @NotNull
        public final LoadingState<MarkersResponse> getState() {
            return this.a;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("LoadMarkers(state=");
            L.append(this.a);
            L.append(')');
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/search/map/action/LoadAction$LoadPinAdverts;", "Lcom/avito/android/search/map/action/LoadAction;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/search/map/PinAdverts;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/LoadingState;", "getState", "()Lcom/avito/android/util/LoadingState;", "state", "<init>", "(Lcom/avito/android/util/LoadingState;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class LoadPinAdverts extends LoadAction {
        @NotNull
        public final LoadingState<PinAdverts> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.util.LoadingState<? super com.avito.android.search.map.PinAdverts> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadPinAdverts(@NotNull LoadingState<? super PinAdverts> loadingState) {
            super(null);
            Intrinsics.checkNotNullParameter(loadingState, "state");
            this.a = loadingState;
        }

        @NotNull
        public final LoadingState<PinAdverts> getState() {
            return this.a;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("LoadPinAdverts(state=");
            L.append(this.a);
            L.append(')');
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/search/map/action/LoadAction$LoadSavedSearchControlDeeplink;", "Lcom/avito/android/search/map/action/LoadAction;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/LoadingState;", "getState", "()Lcom/avito/android/util/LoadingState;", "state", "<init>", "(Lcom/avito/android/util/LoadingState;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class LoadSavedSearchControlDeeplink extends LoadAction {
        @NotNull
        public final LoadingState<DeepLink> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.util.LoadingState<? super com.avito.android.deep_linking.links.DeepLink> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadSavedSearchControlDeeplink(@NotNull LoadingState<? super DeepLink> loadingState) {
            super(null);
            Intrinsics.checkNotNullParameter(loadingState, "state");
            this.a = loadingState;
        }

        @NotNull
        public final LoadingState<DeepLink> getState() {
            return this.a;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("LoadSavedSearchControlDeeplink(state=");
            L.append(this.a);
            L.append(')');
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/search/map/action/LoadAction$LoadSearchDeepLink;", "Lcom/avito/android/search/map/action/LoadAction;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/LoadingState;", "getState", "()Lcom/avito/android/util/LoadingState;", "state", "<init>", "(Lcom/avito/android/util/LoadingState;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class LoadSearchDeepLink extends LoadAction {
        @NotNull
        public final LoadingState<DeepLink> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.util.LoadingState<? super com.avito.android.deep_linking.links.DeepLink> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadSearchDeepLink(@NotNull LoadingState<? super DeepLink> loadingState) {
            super(null);
            Intrinsics.checkNotNullParameter(loadingState, "state");
            this.a = loadingState;
        }

        @NotNull
        public final LoadingState<DeepLink> getState() {
            return this.a;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("LoadSearchDeepLink(state=");
            L.append(this.a);
            L.append(')');
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/search/map/action/LoadAction$LoadSerp;", "Lcom/avito/android/search/map/action/LoadAction;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/search/map/interactor/SerpInteractor$Result;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/LoadingState;", "getState", "()Lcom/avito/android/util/LoadingState;", "state", "<init>", "(Lcom/avito/android/util/LoadingState;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static class LoadSerp extends LoadAction {
        @NotNull
        public final LoadingState<SerpInteractor.Result> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.util.LoadingState<? super com.avito.android.search.map.interactor.SerpInteractor$Result> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadSerp(@NotNull LoadingState<? super SerpInteractor.Result> loadingState) {
            super(null);
            Intrinsics.checkNotNullParameter(loadingState, "state");
            this.a = loadingState;
        }

        @NotNull
        public final LoadingState<SerpInteractor.Result> getState() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/action/LoadAction$ReloadSerp;", "Lcom/avito/android/search/map/action/LoadAction$LoadSerp;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/search/map/interactor/SerpInteractor$Result;", "state", "<init>", "(Lcom/avito/android/util/LoadingState;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class ReloadSerp extends LoadSerp {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ReloadSerp(@NotNull LoadingState<? super SerpInteractor.Result> loadingState) {
            super(loadingState);
            Intrinsics.checkNotNullParameter(loadingState, "state");
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("ReloadSerp(state=");
            L.append(getState());
            L.append(')');
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/search/map/action/LoadAction$RestorePinAdverts;", "Lcom/avito/android/search/map/action/LoadAction;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class RestorePinAdverts extends LoadAction {
        @NotNull
        public static final RestorePinAdverts INSTANCE = new RestorePinAdverts();

        public RestorePinAdverts() {
            super(null);
        }

        @NotNull
        public String toString() {
            return "RestorePinAdverts";
        }
    }

    public LoadAction() {
    }

    public LoadAction(j jVar) {
    }
}
