package com.avito.android.messenger.map;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.v1.Renderer;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.bottom_sheet.BottomSheet;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/map/MapBottomSheet;", "Lcom/avito/android/messenger/channels/mvi/common/v1/Renderer;", "Lcom/avito/android/messenger/map/MapBottomSheet$State;", "Lio/reactivex/rxjava3/core/Observable;", "", "getEditDescriptionClicks", "()Lio/reactivex/rxjava3/core/Observable;", "editDescriptionClicks", "Lru/avito/component/bottom_sheet/BottomSheet$Visibility;", "getVisibilityStream", "visibilityStream", "getActionButtonClicks", "actionButtonClicks", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MapBottomSheet extends Renderer<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/map/MapBottomSheet$State;", "", "<init>", "()V", "Closed", "Expanded", "Lcom/avito/android/messenger/map/MapBottomSheet$State$Closed;", "Lcom/avito/android/messenger/map/MapBottomSheet$State$Expanded;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/map/MapBottomSheet$State$Closed;", "Lcom/avito/android/messenger/map/MapBottomSheet$State;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Closed extends State {
            @NotNull
            public static final Closed INSTANCE = new Closed();

            public Closed() {
                super(null);
            }

            @NotNull
            public String toString() {
                return "Closed";
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000e\u0010\fJ\u0010\u0010\u000f\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000f\u0010\fJR\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0015\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u0014\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010 \u001a\u0004\b\u0014\u0010\fR\u0019\u0010\u0012\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0013\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b$\u0010\fR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\tR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0004¨\u0006-"}, d2 = {"Lcom/avito/android/messenger/map/MapBottomSheet$State$Expanded;", "Lcom/avito/android/messenger/map/MapBottomSheet$State;", "", "toString", "()Ljava/lang/String;", "component1", "", "", "component2", "()Ljava/util/List;", "", "component3", "()Z", "component4", "component5", "component6", "title", "description", "isCloseable", "actionButtonIsEnabled", "isTextEditable", "isFullScreen", "copy", "(Ljava/lang/String;Ljava/util/List;ZZZZ)Lcom/avito/android/messenger/map/MapBottomSheet$State$Expanded;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "f", "Z", "e", "c", "d", "getActionButtonIsEnabled", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getDescription", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Ljava/util/List;ZZZZ)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Expanded extends State {
            @NotNull
            public final String a;
            @NotNull
            public final List<CharSequence> b;
            public final boolean c;
            public final boolean d;
            public final boolean e;
            public final boolean f;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Expanded(String str, List list, boolean z, boolean z2, boolean z3, boolean z4, int i, j jVar) {
                this(str, list, z, z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.avito.android.messenger.map.MapBottomSheet$State$Expanded */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Expanded copy$default(Expanded expanded, String str, List list, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = expanded.a;
                }
                if ((i & 2) != 0) {
                    list = expanded.b;
                }
                if ((i & 4) != 0) {
                    z = expanded.c;
                }
                if ((i & 8) != 0) {
                    z2 = expanded.d;
                }
                if ((i & 16) != 0) {
                    z3 = expanded.e;
                }
                if ((i & 32) != 0) {
                    z4 = expanded.f;
                }
                return expanded.copy(str, list, z, z2, z3, z4);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final List<CharSequence> component2() {
                return this.b;
            }

            public final boolean component3() {
                return this.c;
            }

            public final boolean component4() {
                return this.d;
            }

            public final boolean component5() {
                return this.e;
            }

            public final boolean component6() {
                return this.f;
            }

            @NotNull
            public final Expanded copy(@NotNull String str, @NotNull List<? extends CharSequence> list, boolean z, boolean z2, boolean z3, boolean z4) {
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(list, "description");
                return new Expanded(str, list, z, z2, z3, z4);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Expanded)) {
                    return false;
                }
                Expanded expanded = (Expanded) obj;
                return Intrinsics.areEqual(this.a, expanded.a) && Intrinsics.areEqual(this.b, expanded.b) && this.c == expanded.c && this.d == expanded.d && this.e == expanded.e && this.f == expanded.f;
            }

            public final boolean getActionButtonIsEnabled() {
                return this.d;
            }

            @NotNull
            public final List<CharSequence> getDescription() {
                return this.b;
            }

            @NotNull
            public final String getTitle() {
                return this.a;
            }

            public int hashCode() {
                String str = this.a;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                List<CharSequence> list = this.b;
                if (list != null) {
                    i = list.hashCode();
                }
                int i2 = (hashCode + i) * 31;
                boolean z = this.c;
                int i3 = 1;
                if (z) {
                    z = true;
                }
                int i4 = z ? 1 : 0;
                int i5 = z ? 1 : 0;
                int i6 = z ? 1 : 0;
                int i7 = (i2 + i4) * 31;
                boolean z2 = this.d;
                if (z2) {
                    z2 = true;
                }
                int i8 = z2 ? 1 : 0;
                int i9 = z2 ? 1 : 0;
                int i10 = z2 ? 1 : 0;
                int i11 = (i7 + i8) * 31;
                boolean z3 = this.e;
                if (z3) {
                    z3 = true;
                }
                int i12 = z3 ? 1 : 0;
                int i13 = z3 ? 1 : 0;
                int i14 = z3 ? 1 : 0;
                int i15 = (i11 + i12) * 31;
                boolean z4 = this.f;
                if (!z4) {
                    i3 = z4 ? 1 : 0;
                }
                return i15 + i3;
            }

            public final boolean isCloseable() {
                return this.c;
            }

            public final boolean isFullScreen() {
                return this.f;
            }

            public final boolean isTextEditable() {
                return this.e;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Expanded(title='");
                L.append(this.a);
                L.append("', description=");
                L.append(this.b);
                L.append(", isCloseable=");
                L.append(this.c);
                L.append(", ");
                L.append("actionButtonIsEnabled=");
                L.append(this.d);
                L.append(", isTextEditable=");
                L.append(this.e);
                L.append(", isFullScreen=");
                return a.A(L, this.f, ')');
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends java.lang.CharSequence> */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Expanded(@NotNull String str, @NotNull List<? extends CharSequence> list, boolean z, boolean z2, boolean z3, boolean z4) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(list, "description");
                this.a = str;
                this.b = list;
                this.c = z;
                this.d = z2;
                this.e = z3;
                this.f = z4;
            }
        }

        public State() {
        }

        public State(j jVar) {
        }
    }

    @NotNull
    Observable<Unit> getActionButtonClicks();

    @NotNull
    Observable<Unit> getEditDescriptionClicks();

    @NotNull
    Observable<BottomSheet.Visibility> getVisibilityStream();
}
