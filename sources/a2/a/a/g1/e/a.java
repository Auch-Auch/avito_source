package a2.a.a.g1.e;

import com.avito.android.remote.model.category_parameters.SortDirection;
import com.avito.android.remote.model.search.Filter;
import java.util.Comparator;
public final class a<T> implements Comparator<Filter.InnerOptions.Options> {
    public final /* synthetic */ SortDirection a;

    public a(SortDirection sortDirection) {
        this.a = sortDirection;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        if ((r5.length() > 0) != false) goto L_0x002f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // java.util.Comparator
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compare(com.avito.android.remote.model.search.Filter.InnerOptions.Options r4, com.avito.android.remote.model.search.Filter.InnerOptions.Options r5) {
        /*
            r3 = this;
            com.avito.android.remote.model.search.Filter$InnerOptions$Options r4 = (com.avito.android.remote.model.search.Filter.InnerOptions.Options) r4
            com.avito.android.remote.model.search.Filter$InnerOptions$Options r5 = (com.avito.android.remote.model.search.Filter.InnerOptions.Options) r5
            java.lang.String r4 = r4.getSortParam()
            java.lang.String r5 = r5.getSortParam()
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L_0x001d
            int r2 = r4.length()
            if (r2 <= 0) goto L_0x0018
            r2 = 1
            goto L_0x0019
        L_0x0018:
            r2 = 0
        L_0x0019:
            if (r2 == 0) goto L_0x001d
            r2 = 1
            goto L_0x001e
        L_0x001d:
            r2 = 0
        L_0x001e:
            if (r2 == 0) goto L_0x0043
            if (r5 == 0) goto L_0x002e
            int r2 = r5.length()
            if (r2 <= 0) goto L_0x002a
            r2 = 1
            goto L_0x002b
        L_0x002a:
            r2 = 0
        L_0x002b:
            if (r2 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            if (r0 == 0) goto L_0x0043
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r1 = r4.compareTo(r5)
            com.avito.android.remote.model.category_parameters.SortDirection r4 = r3.a
            com.avito.android.remote.model.category_parameters.SortDirection r5 = com.avito.android.remote.model.category_parameters.SortDirection.Descending
            if (r4 != r5) goto L_0x0043
            int r1 = r1 * -1
        L_0x0043:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.a.a.g1.e.a.compare(java.lang.Object, java.lang.Object):int");
    }
}
