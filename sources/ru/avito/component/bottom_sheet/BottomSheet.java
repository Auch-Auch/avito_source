package ru.avito.component.bottom_sheet;

import a2.b.a.a.a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u0000 :2\u00020\u0001:\u0004:;<=J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0005\u0010\nJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH&¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u000bH&¢\u0006\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001e\u001a\u00020\u00198&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010$\u001a\u00020\u001f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010'\u001a\u00020\u001f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001c\u0010(\u001a\u00020\u001f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u0018\u0010+\u001a\u0004\u0018\u00010\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0013R\u001c\u00102\u001a\u00020-8&@&X¦\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u0015038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u001c\u00109\u001a\u00020\u001f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b7\u0010!\"\u0004\b8\u0010#¨\u0006>"}, d2 = {"Lru/avito/component/bottom_sheet/BottomSheet;", "", "", "layoutId", "Landroid/view/View;", "setContentView", "(I)Landroid/view/View;", "view", "Landroid/view/ViewGroup$LayoutParams;", "params", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)Landroid/view/View;", "", "attachBottomView", "(Landroid/view/View;)V", Tracker.Events.CREATIVE_COLLAPSE, "()V", Tracker.Events.CREATIVE_EXPAND, "close", "getContentView", "()Landroid/view/View;", "contentView", "Lru/avito/component/bottom_sheet/BottomSheet$Visibility;", "getVisibility", "()Lru/avito/component/bottom_sheet/BottomSheet$Visibility;", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "Lru/avito/component/bottom_sheet/BottomSheet$NotchVisibility;", "getNotchVisibility", "()Lru/avito/component/bottom_sheet/BottomSheet$NotchVisibility;", "setNotchVisibility", "(Lru/avito/component/bottom_sheet/BottomSheet$NotchVisibility;)V", "notchVisibility", "", "getLockExpanded", "()Z", "setLockExpanded", "(Z)V", "lockExpanded", "getDimStatusBarOnExpand", "setDimStatusBarOnExpand", "dimStatusBarOnExpand", "isHideable", "setHideable", "getBottomView", "bottomView", "getView", "Lru/avito/component/bottom_sheet/BottomSheet$PeekHeight;", "getPeekHeight", "()Lru/avito/component/bottom_sheet/BottomSheet$PeekHeight;", "setPeekHeight", "(Lru/avito/component/bottom_sheet/BottomSheet$PeekHeight;)V", "peekHeight", "Lio/reactivex/rxjava3/core/Observable;", "getVisibilityObservable", "()Lio/reactivex/rxjava3/core/Observable;", "visibilityObservable", "getDimBackgroundOnExpand", "setDimBackgroundOnExpand", "dimBackgroundOnExpand", "Companion", "NotchVisibility", "PeekHeight", "Visibility", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface BottomSheet {
    @NotNull
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lru/avito/component/bottom_sheet/BottomSheet$Companion;", "", "Landroid/view/View;", "view", "Lru/avito/component/bottom_sheet/BottomSheet;", "create", "(Landroid/view/View;)Lru/avito/component/bottom_sheet/BottomSheet;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final BottomSheet create(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return new BottomSheetImpl((FrameLayout) view);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ View setContentView$default(BottomSheet bottomSheet, View view, ViewGroup.LayoutParams layoutParams, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    layoutParams = null;
                }
                return bottomSheet.setContentView(view, layoutParams);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setContentView");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/avito/component/bottom_sheet/BottomSheet$NotchVisibility;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO", "ALWAYS_SHOWN", "ALWAYS_HIDDEN", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public enum NotchVisibility {
        AUTO,
        ALWAYS_SHOWN,
        ALWAYS_HIDDEN
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lru/avito/component/bottom_sheet/BottomSheet$PeekHeight;", "", "<init>", "()V", "Absolute", "Auto", "Relative", "Lru/avito/component/bottom_sheet/BottomSheet$PeekHeight$Auto;", "Lru/avito/component/bottom_sheet/BottomSheet$PeekHeight$Relative;", "Lru/avito/component/bottom_sheet/BottomSheet$PeekHeight$Absolute;", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class PeekHeight {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lru/avito/component/bottom_sheet/BottomSheet$PeekHeight$Absolute;", "Lru/avito/component/bottom_sheet/BottomSheet$PeekHeight;", "", "component1", "()I", "value", "copy", "(I)Lru/avito/component/bottom_sheet/BottomSheet$PeekHeight$Absolute;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getValue", "<init>", "(I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Absolute extends PeekHeight {
            public final int a;

            public Absolute(int i) {
                super(null);
                this.a = i;
            }

            public static /* synthetic */ Absolute copy$default(Absolute absolute, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = absolute.a;
                }
                return absolute.copy(i);
            }

            public final int component1() {
                return this.a;
            }

            @NotNull
            public final Absolute copy(int i) {
                return new Absolute(i);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Absolute) && this.a == ((Absolute) obj).a;
                }
                return true;
            }

            public final int getValue() {
                return this.a;
            }

            public int hashCode() {
                return this.a;
            }

            @NotNull
            public String toString() {
                return a.j(a.L("Absolute(value="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/avito/component/bottom_sheet/BottomSheet$PeekHeight$Auto;", "Lru/avito/component/bottom_sheet/BottomSheet$PeekHeight;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Auto extends PeekHeight {
            @NotNull
            public static final Auto INSTANCE = new Auto();

            public Auto() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lru/avito/component/bottom_sheet/BottomSheet$PeekHeight$Relative;", "Lru/avito/component/bottom_sheet/BottomSheet$PeekHeight;", "", "component1", "()F", "", "component2", "()I", "value", "offset", "copy", "(FI)Lru/avito/component/bottom_sheet/BottomSheet$PeekHeight$Relative;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "F", "getValue", AuthSource.BOOKING_ORDER, "I", "getOffset", "<init>", "(FI)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Relative extends PeekHeight {
            public final float a;
            public final int b;

            public Relative(float f, int i) {
                super(null);
                this.a = f;
                this.b = i;
            }

            public static /* synthetic */ Relative copy$default(Relative relative, float f, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    f = relative.a;
                }
                if ((i2 & 2) != 0) {
                    i = relative.b;
                }
                return relative.copy(f, i);
            }

            public final float component1() {
                return this.a;
            }

            public final int component2() {
                return this.b;
            }

            @NotNull
            public final Relative copy(float f, int i) {
                return new Relative(f, i);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Relative)) {
                    return false;
                }
                Relative relative = (Relative) obj;
                return Float.compare(this.a, relative.a) == 0 && this.b == relative.b;
            }

            public final int getOffset() {
                return this.b;
            }

            public final float getValue() {
                return this.a;
            }

            public int hashCode() {
                return (Float.floatToIntBits(this.a) * 31) + this.b;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Relative(value=");
                L.append(this.a);
                L.append(", offset=");
                return a.j(L, this.b, ")");
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Relative(float f, int i, int i2, j jVar) {
                this(f, (i2 & 2) != 0 ? 0 : i);
            }
        }

        public PeekHeight() {
        }

        public PeekHeight(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lru/avito/component/bottom_sheet/BottomSheet$Visibility;", "", "<init>", "()V", "Closed", "Collapsed", "Expanded", "Lru/avito/component/bottom_sheet/BottomSheet$Visibility$Expanded;", "Lru/avito/component/bottom_sheet/BottomSheet$Visibility$Collapsed;", "Lru/avito/component/bottom_sheet/BottomSheet$Visibility$Closed;", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Visibility {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/avito/component/bottom_sheet/BottomSheet$Visibility$Closed;", "Lru/avito/component/bottom_sheet/BottomSheet$Visibility;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Closed extends Visibility {
            @NotNull
            public static final Closed INSTANCE = new Closed();

            public Closed() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/avito/component/bottom_sheet/BottomSheet$Visibility$Collapsed;", "Lru/avito/component/bottom_sheet/BottomSheet$Visibility;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Collapsed extends Visibility {
            @NotNull
            public static final Collapsed INSTANCE = new Collapsed();

            public Collapsed() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/avito/component/bottom_sheet/BottomSheet$Visibility$Expanded;", "Lru/avito/component/bottom_sheet/BottomSheet$Visibility;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Expanded extends Visibility {
            @NotNull
            public static final Expanded INSTANCE = new Expanded();

            public Expanded() {
                super(null);
            }
        }

        public Visibility() {
        }

        public Visibility(j jVar) {
        }
    }

    void attachBottomView(@Nullable View view);

    void close();

    void collapse();

    void expand();

    @Nullable
    View getBottomView();

    @Nullable
    View getContentView();

    boolean getDimBackgroundOnExpand();

    boolean getDimStatusBarOnExpand();

    boolean getLockExpanded();

    @NotNull
    NotchVisibility getNotchVisibility();

    @NotNull
    PeekHeight getPeekHeight();

    @NotNull
    View getView();

    @NotNull
    Visibility getVisibility();

    @NotNull
    Observable<Visibility> getVisibilityObservable();

    boolean isHideable();

    @NotNull
    View setContentView(@LayoutRes int i);

    @NotNull
    View setContentView(@NotNull View view, @Nullable ViewGroup.LayoutParams layoutParams);

    void setDimBackgroundOnExpand(boolean z);

    void setDimStatusBarOnExpand(boolean z);

    void setHideable(boolean z);

    void setLockExpanded(boolean z);

    void setNotchVisibility(@NotNull NotchVisibility notchVisibility);

    void setPeekHeight(@NotNull PeekHeight peekHeight);
}
