package a2.a.a.n0.d.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.avito.android.developments_catalog.R;
import com.avito.android.developments_catalog.remote.model.MetroParam;
import com.avito.android.lib.util.ReuseChildrenHelper;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends ReuseChildrenHelper<MetroParam, LinearLayout> {
    public final ViewGroup a;
    public final LayoutInflater b;

    public a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.developments_catalog_metro_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.d…ments_catalog_metro_root)");
        this.a = (ViewGroup) findViewById;
        this.b = LayoutInflater.from(view.getContext());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object, int] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x004b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:7:0x004b */
    /* JADX DEBUG: Multi-variable search result rejected for r11v3, resolved type: com.avito.android.advert_core.georeference.GeoReferenceViewBinderImpl */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.List */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.List */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ArrayList] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0063, code lost:
        if ((r9.length() > 0) != false) goto L_0x0067;
     */
    @Override // com.avito.android.lib.util.ReuseChildrenHelper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindData(android.widget.LinearLayout r9, com.avito.android.developments_catalog.remote.model.MetroParam r10, int r11) {
        /*
            r8 = this;
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            com.avito.android.developments_catalog.remote.model.MetroParam r10 = (com.avito.android.developments_catalog.remote.model.MetroParam) r10
            java.lang.String r11 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r11)
            java.lang.String r11 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r11)
            r9.removeAllViews()
            com.avito.android.advert_core.georeference.GeoReferenceViewBinderImpl r11 = new com.avito.android.advert_core.georeference.GeoReferenceViewBinderImpl
            r11.<init>(r9)
            java.util.List r9 = r10.getLines()
            if (r9 == 0) goto L_0x004a
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = t6.n.e.collectionSizeOrDefault(r9, r1)
            r0.<init>(r1)
            java.util.Iterator r9 = r9.iterator()
        L_0x002b:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x004b
            java.lang.Object r1 = r9.next()
            com.avito.android.developments_catalog.remote.model.MetroLine r1 = (com.avito.android.developments_catalog.remote.model.MetroLine) r1
            java.lang.String r2 = r1.getColor()
            r5 = 0
            r6 = 4
            r7 = 0
            java.lang.String r3 = "0x"
            java.lang.String r4 = "#"
            java.lang.String r1 = t6.y.m.replace$default(r2, r3, r4, r5, r6, r7)
            r0.add(r1)
            goto L_0x002b
        L_0x004a:
            r0 = 0
        L_0x004b:
            if (r0 == 0) goto L_0x004e
            goto L_0x0052
        L_0x004e:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0052:
            java.lang.String r9 = r10.getDistance()
            r1 = 1
            r2 = 0
            if (r9 == 0) goto L_0x0066
            int r3 = r9.length()
            if (r3 <= 0) goto L_0x0062
            r3 = 1
            goto L_0x0063
        L_0x0062:
            r3 = 0
        L_0x0063:
            if (r3 == 0) goto L_0x0066
            goto L_0x0067
        L_0x0066:
            r1 = 0
        L_0x0067:
            java.lang.String r10 = r10.getName()
            if (r1 == 0) goto L_0x0073
            java.lang.String r1 = ", "
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r10, r1)
        L_0x0073:
            r11.bindData(r0, r10, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.a.a.n0.d.c.a.bindData(android.view.View, java.lang.Object, int):void");
    }

    /* Return type fixed from 'android.view.View' to match base method */
    @Override // com.avito.android.lib.util.ReuseChildrenHelper
    public LinearLayout createChild() {
        View inflate = this.b.inflate(R.layout.metro, this.a, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        return (LinearLayout) inflate;
    }
}
