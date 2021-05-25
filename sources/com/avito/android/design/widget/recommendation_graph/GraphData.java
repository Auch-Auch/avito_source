package com.avito.android.design.widget.recommendation_graph;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B9\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0004\b(\u0010)J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJJ\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0014\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0010\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0005R\u0019\u0010\u000f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\bR%\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\r¨\u0006*"}, d2 = {"Lcom/avito/android/design/widget/recommendation_graph/GraphData;", "", "", "", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "component3", "()F", "Lkotlin/Pair;", "component4", "()Lkotlin/Pair;", "columns", "mediumLabel", "mediumPosition", "borders", "copy", "(Ljava/util/List;Ljava/lang/String;FLkotlin/Pair;)Lcom/avito/android/design/widget/recommendation_graph/GraphData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "F", "getMediumPosition", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getColumns", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMediumLabel", "d", "Lkotlin/Pair;", "getBorders", "<init>", "(Ljava/util/List;Ljava/lang/String;FLkotlin/Pair;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class GraphData {
    @NotNull
    public final List<Float> a;
    @NotNull
    public final String b;
    public final float c;
    @NotNull
    public final Pair<String, String> d;

    public GraphData(@NotNull List<Float> list, @NotNull String str, float f, @NotNull Pair<String, String> pair) {
        Intrinsics.checkNotNullParameter(list, "columns");
        Intrinsics.checkNotNullParameter(str, "mediumLabel");
        Intrinsics.checkNotNullParameter(pair, "borders");
        this.a = list;
        this.b = str;
        this.c = f;
        this.d = pair;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.design.widget.recommendation_graph.GraphData */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GraphData copy$default(GraphData graphData, List list, String str, float f, Pair pair, int i, Object obj) {
        if ((i & 1) != 0) {
            list = graphData.a;
        }
        if ((i & 2) != 0) {
            str = graphData.b;
        }
        if ((i & 4) != 0) {
            f = graphData.c;
        }
        if ((i & 8) != 0) {
            pair = graphData.d;
        }
        return graphData.copy(list, str, f, pair);
    }

    @NotNull
    public final List<Float> component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    public final float component3() {
        return this.c;
    }

    @NotNull
    public final Pair<String, String> component4() {
        return this.d;
    }

    @NotNull
    public final GraphData copy(@NotNull List<Float> list, @NotNull String str, float f, @NotNull Pair<String, String> pair) {
        Intrinsics.checkNotNullParameter(list, "columns");
        Intrinsics.checkNotNullParameter(str, "mediumLabel");
        Intrinsics.checkNotNullParameter(pair, "borders");
        return new GraphData(list, str, f, pair);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GraphData)) {
            return false;
        }
        GraphData graphData = (GraphData) obj;
        return Intrinsics.areEqual(this.a, graphData.a) && Intrinsics.areEqual(this.b, graphData.b) && Float.compare(this.c, graphData.c) == 0 && Intrinsics.areEqual(this.d, graphData.d);
    }

    @NotNull
    public final Pair<String, String> getBorders() {
        return this.d;
    }

    @NotNull
    public final List<Float> getColumns() {
        return this.a;
    }

    @NotNull
    public final String getMediumLabel() {
        return this.b;
    }

    public final float getMediumPosition() {
        return this.c;
    }

    public int hashCode() {
        List<Float> list = this.a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.b;
        int i1 = a.i1(this.c, (hashCode + (str != null ? str.hashCode() : 0)) * 31, 31);
        Pair<String, String> pair = this.d;
        if (pair != null) {
            i = pair.hashCode();
        }
        return i1 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("GraphData(columns=");
        L.append(this.a);
        L.append(", mediumLabel=");
        L.append(this.b);
        L.append(", mediumPosition=");
        L.append(this.c);
        L.append(", borders=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }
}
