package com.avito.android.util.map;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/util/map/MarkerItem;", "", "<init>", "()V", "Cluster", "ClusterWithLabel", "MyLocation", "Pin", "PinWithLabel", "Lcom/avito/android/util/map/MarkerItem$MyLocation;", "Lcom/avito/android/util/map/MarkerItem$Cluster;", "Lcom/avito/android/util/map/MarkerItem$Pin;", "Lcom/avito/android/util/map/MarkerItem$PinWithLabel;", "Lcom/avito/android/util/map/MarkerItem$ClusterWithLabel;", "map_release"}, k = 1, mv = {1, 4, 2})
public abstract class MarkerItem {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/util/map/MarkerItem$Cluster;", "Lcom/avito/android/util/map/MarkerItem;", "", "component1", "()Ljava/lang/String;", "text", "copy", "(Ljava/lang/String;)Lcom/avito/android/util/map/MarkerItem$Cluster;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getText", "<init>", "(Ljava/lang/String;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class Cluster extends MarkerItem {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cluster(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "text");
            this.a = str;
        }

        public static /* synthetic */ Cluster copy$default(Cluster cluster, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cluster.a;
            }
            return cluster.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final Cluster copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new Cluster(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Cluster) && Intrinsics.areEqual(this.a, ((Cluster) obj).a);
            }
            return true;
        }

        @NotNull
        public final String getText() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.t(a.L("Cluster(text="), this.a, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/avito/android/util/map/MarkerItem$ClusterWithLabel;", "Lcom/avito/android/util/map/MarkerItem;", "", "component1", "()Ljava/lang/String;", "component2", "labelText", "text", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/util/map/MarkerItem$ClusterWithLabel;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", AuthSource.SEND_ABUSE, "getLabelText", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class ClusterWithLabel extends MarkerItem {
        @NotNull
        public final String a;
        @NotNull
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ClusterWithLabel(@NotNull String str, @NotNull String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "labelText");
            Intrinsics.checkNotNullParameter(str2, "text");
            this.a = str;
            this.b = str2;
        }

        public static /* synthetic */ ClusterWithLabel copy$default(ClusterWithLabel clusterWithLabel, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = clusterWithLabel.a;
            }
            if ((i & 2) != 0) {
                str2 = clusterWithLabel.b;
            }
            return clusterWithLabel.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final ClusterWithLabel copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "labelText");
            Intrinsics.checkNotNullParameter(str2, "text");
            return new ClusterWithLabel(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClusterWithLabel)) {
                return false;
            }
            ClusterWithLabel clusterWithLabel = (ClusterWithLabel) obj;
            return Intrinsics.areEqual(this.a, clusterWithLabel.a) && Intrinsics.areEqual(this.b, clusterWithLabel.b);
        }

        @NotNull
        public final String getLabelText() {
            return this.a;
        }

        @NotNull
        public final String getText() {
            return this.b;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("ClusterWithLabel(labelText=");
            L.append(this.a);
            L.append(", text=");
            return a.t(L, this.b, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/util/map/MarkerItem$MyLocation;", "Lcom/avito/android/util/map/MarkerItem;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class MyLocation extends MarkerItem {
        public MyLocation() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/avito/android/util/map/MarkerItem$Pin;", "Lcom/avito/android/util/map/MarkerItem;", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "", "component3", "()Ljava/lang/Integer;", "selected", "text", "count", "copy", "(ZLjava/lang/String;Ljava/lang/Integer;)Lcom/avito/android/util/map/MarkerItem$Pin;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/Integer;", "getCount", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", AuthSource.SEND_ABUSE, "Z", "getSelected", "setSelected", "(Z)V", "<init>", "(ZLjava/lang/String;Ljava/lang/Integer;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class Pin extends MarkerItem {
        public boolean a;
        @Nullable
        public final String b;
        @Nullable
        public final Integer c;

        public Pin() {
            this(false, null, null, 7, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Pin(boolean z, String str, Integer num, int i, j jVar) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num);
        }

        public static /* synthetic */ Pin copy$default(Pin pin, boolean z, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                z = pin.a;
            }
            if ((i & 2) != 0) {
                str = pin.b;
            }
            if ((i & 4) != 0) {
                num = pin.c;
            }
            return pin.copy(z, str, num);
        }

        public final boolean component1() {
            return this.a;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        @Nullable
        public final Integer component3() {
            return this.c;
        }

        @NotNull
        public final Pin copy(boolean z, @Nullable String str, @Nullable Integer num) {
            return new Pin(z, str, num);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            return this.a == pin.a && Intrinsics.areEqual(this.b, pin.b) && Intrinsics.areEqual(this.c, pin.c);
        }

        @Nullable
        public final Integer getCount() {
            return this.c;
        }

        public final boolean getSelected() {
            return this.a;
        }

        @Nullable
        public final String getText() {
            return this.b;
        }

        public int hashCode() {
            boolean z = this.a;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = i * 31;
            String str = this.b;
            int i5 = 0;
            int hashCode = (i4 + (str != null ? str.hashCode() : 0)) * 31;
            Integer num = this.c;
            if (num != null) {
                i5 = num.hashCode();
            }
            return hashCode + i5;
        }

        public final void setSelected(boolean z) {
            this.a = z;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Pin(selected=");
            L.append(this.a);
            L.append(", text=");
            L.append(this.b);
            L.append(", count=");
            return a.p(L, this.c, ")");
        }

        public Pin(boolean z, @Nullable String str, @Nullable Integer num) {
            super(null);
            this.a = z;
            this.b = str;
            this.c = num;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\b¨\u0006 "}, d2 = {"Lcom/avito/android/util/map/MarkerItem$PinWithLabel;", "Lcom/avito/android/util/map/MarkerItem;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Integer;", "labelText", "text", "count", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/avito/android/util/map/MarkerItem$PinWithLabel;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getLabelText", AuthSource.BOOKING_ORDER, "getText", "c", "Ljava/lang/Integer;", "getCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class PinWithLabel extends MarkerItem {
        @NotNull
        public final String a;
        @Nullable
        public final String b;
        @Nullable
        public final Integer c;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PinWithLabel(String str, String str2, Integer num, int i, j jVar) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num);
        }

        public static /* synthetic */ PinWithLabel copy$default(PinWithLabel pinWithLabel, String str, String str2, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pinWithLabel.a;
            }
            if ((i & 2) != 0) {
                str2 = pinWithLabel.b;
            }
            if ((i & 4) != 0) {
                num = pinWithLabel.c;
            }
            return pinWithLabel.copy(str, str2, num);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        @Nullable
        public final Integer component3() {
            return this.c;
        }

        @NotNull
        public final PinWithLabel copy(@NotNull String str, @Nullable String str2, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(str, "labelText");
            return new PinWithLabel(str, str2, num);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PinWithLabel)) {
                return false;
            }
            PinWithLabel pinWithLabel = (PinWithLabel) obj;
            return Intrinsics.areEqual(this.a, pinWithLabel.a) && Intrinsics.areEqual(this.b, pinWithLabel.b) && Intrinsics.areEqual(this.c, pinWithLabel.c);
        }

        @Nullable
        public final Integer getCount() {
            return this.c;
        }

        @NotNull
        public final String getLabelText() {
            return this.a;
        }

        @Nullable
        public final String getText() {
            return this.b;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Integer num = this.c;
            if (num != null) {
                i = num.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("PinWithLabel(labelText=");
            L.append(this.a);
            L.append(", text=");
            L.append(this.b);
            L.append(", count=");
            return a.p(L, this.c, ")");
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PinWithLabel(@NotNull String str, @Nullable String str2, @Nullable Integer num) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "labelText");
            this.a = str;
            this.b = str2;
            this.c = num;
        }
    }

    public MarkerItem() {
    }

    public MarkerItem(j jVar) {
    }
}
