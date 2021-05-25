package com.avito.android.delivery.map.point_info;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.delivery.Overlay;
import com.avito.conveyor_item.Item;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0016\u0010\u0012\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView;", "", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView$State;", "state", "", "render", "(Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView$State;)V", "Lio/reactivex/rxjava3/core/Observable;", "getSubmitButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "submitButtonClicks", "getRetryButtonClicks", "retryButtonClicks", "getBottomSheetHideObservable", "bottomSheetHideObservable", "", "getBottomSheetPeekHeight", "()I", "bottomSheetPeekHeight", "State", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryRdsPointInfoView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView$State;", "", "<init>", "()V", "Expanded", "Hidden", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView$State$Expanded;", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView$State$Hidden;", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView$State$Hidden;", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView$State;", "Lcom/avito/android/remote/model/delivery/Overlay;", "component1", "()Lcom/avito/android/remote/model/delivery/Overlay;", "overlay", "copy", "(Lcom/avito/android/remote/model/delivery/Overlay;)Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView$State$Hidden;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/delivery/Overlay;", "getOverlay", "<init>", "(Lcom/avito/android/remote/model/delivery/Overlay;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
        public static final class Hidden extends State {
            @Nullable
            public final Overlay a;

            public Hidden() {
                this(null, 1, null);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Hidden(Overlay overlay, int i, j jVar) {
                this((i & 1) != 0 ? null : overlay);
            }

            public static /* synthetic */ Hidden copy$default(Hidden hidden, Overlay overlay, int i, Object obj) {
                if ((i & 1) != 0) {
                    overlay = hidden.a;
                }
                return hidden.copy(overlay);
            }

            @Nullable
            public final Overlay component1() {
                return this.a;
            }

            @NotNull
            public final Hidden copy(@Nullable Overlay overlay) {
                return new Hidden(overlay);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Hidden) && Intrinsics.areEqual(this.a, ((Hidden) obj).a);
                }
                return true;
            }

            @Nullable
            public final Overlay getOverlay() {
                return this.a;
            }

            public int hashCode() {
                Overlay overlay = this.a;
                if (overlay != null) {
                    return overlay.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Hidden(overlay=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }

            public Hidden(@Nullable Overlay overlay) {
                super(null);
                this.a = overlay;
            }
        }

        public State() {
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001BE\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010-J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004JP\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004\"\u0004\b \u0010!R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u000bR\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\b¨\u0006."}, d2 = {"Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView$State$Expanded;", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView$State;", "", "component1", "()Ljava/lang/Boolean;", "", "Lcom/avito/conveyor_item/Item;", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/lang/String;", "component4", "component5", "progress", "items", "errorText", Tracker.Events.CREATIVE_COLLAPSE, "notify", "copy", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView$State$Expanded;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "e", "Ljava/lang/Boolean;", "getNotify", "setNotify", "(Ljava/lang/Boolean;)V", AuthSource.SEND_ABUSE, "getProgress", "d", "getCollapse", "c", "Ljava/lang/String;", "getErrorText", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getItems", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
        public static final class Expanded extends State {
            @Nullable
            public final Boolean a;
            @NotNull
            public final List<Item> b;
            @Nullable
            public final String c;
            @Nullable
            public final Boolean d;
            @Nullable
            public Boolean e;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Expanded(Boolean bool, List list, String str, Boolean bool2, Boolean bool3, int i, j jVar) {
                this(bool, (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : bool3);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoView$State$Expanded */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Expanded copy$default(Expanded expanded, Boolean bool, List list, String str, Boolean bool2, Boolean bool3, int i, Object obj) {
                if ((i & 1) != 0) {
                    bool = expanded.a;
                }
                if ((i & 2) != 0) {
                    list = expanded.b;
                }
                if ((i & 4) != 0) {
                    str = expanded.c;
                }
                if ((i & 8) != 0) {
                    bool2 = expanded.d;
                }
                if ((i & 16) != 0) {
                    bool3 = expanded.e;
                }
                return expanded.copy(bool, list, str, bool2, bool3);
            }

            @Nullable
            public final Boolean component1() {
                return this.a;
            }

            @NotNull
            public final List<Item> component2() {
                return this.b;
            }

            @Nullable
            public final String component3() {
                return this.c;
            }

            @Nullable
            public final Boolean component4() {
                return this.d;
            }

            @Nullable
            public final Boolean component5() {
                return this.e;
            }

            @NotNull
            public final Expanded copy(@Nullable Boolean bool, @NotNull List<? extends Item> list, @Nullable String str, @Nullable Boolean bool2, @Nullable Boolean bool3) {
                Intrinsics.checkNotNullParameter(list, "items");
                return new Expanded(bool, list, str, bool2, bool3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Expanded)) {
                    return false;
                }
                Expanded expanded = (Expanded) obj;
                return Intrinsics.areEqual(this.a, expanded.a) && Intrinsics.areEqual(this.b, expanded.b) && Intrinsics.areEqual(this.c, expanded.c) && Intrinsics.areEqual(this.d, expanded.d) && Intrinsics.areEqual(this.e, expanded.e);
            }

            @Nullable
            public final Boolean getCollapse() {
                return this.d;
            }

            @Nullable
            public final String getErrorText() {
                return this.c;
            }

            @NotNull
            public final List<Item> getItems() {
                return this.b;
            }

            @Nullable
            public final Boolean getNotify() {
                return this.e;
            }

            @Nullable
            public final Boolean getProgress() {
                return this.a;
            }

            public int hashCode() {
                Boolean bool = this.a;
                int i = 0;
                int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
                List<Item> list = this.b;
                int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
                String str = this.c;
                int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
                Boolean bool2 = this.d;
                int hashCode4 = (hashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
                Boolean bool3 = this.e;
                if (bool3 != null) {
                    i = bool3.hashCode();
                }
                return hashCode4 + i;
            }

            public final void setNotify(@Nullable Boolean bool) {
                this.e = bool;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Expanded(progress=");
                L.append(this.a);
                L.append(", items=");
                L.append(this.b);
                L.append(", errorText=");
                L.append(this.c);
                L.append(", collapse=");
                L.append(this.d);
                L.append(", notify=");
                return a.o(L, this.e, ")");
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.conveyor_item.Item> */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Expanded(@Nullable Boolean bool, @NotNull List<? extends Item> list, @Nullable String str, @Nullable Boolean bool2, @Nullable Boolean bool3) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "items");
                this.a = bool;
                this.b = list;
                this.c = str;
                this.d = bool2;
                this.e = bool3;
            }
        }

        public State(j jVar) {
        }
    }

    @NotNull
    Observable<Unit> getBottomSheetHideObservable();

    int getBottomSheetPeekHeight();

    @NotNull
    Observable<Unit> getRetryButtonClicks();

    @NotNull
    Observable<Unit> getSubmitButtonClicks();

    void render(@NotNull State state);
}
