package com.avito.android.select;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.remote.model.category_parameters.SectionTitle;
import com.avito.android.remote.model.category_parameters.SortDirection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ7\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ7\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/select/SelectParameterLocalSorterImpl;", "Lcom/avito/android/select/SelectParameterLocalSorter;", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "", "unsorted", "Lcom/avito/android/remote/model/category_parameters/SortDirection;", "direction", "sort", "(Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/SortDirection;)Ljava/util/List;", AuthSource.SEND_ABUSE, "<init>", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectParameterLocalSorterImpl implements SelectParameterLocalSorter {

    public static final class a<T> implements Comparator<ParcelableEntity<String>> {
        public final /* synthetic */ SortDirection a;

        public a(SortDirection sortDirection) {
            this.a = sortDirection;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0070, code lost:
            if ((r5.length() > 0) != false) goto L_0x0074;
         */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
        /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
        @Override // java.util.Comparator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(com.avito.android.remote.model.ParcelableEntity<java.lang.String> r5, com.avito.android.remote.model.ParcelableEntity<java.lang.String> r6) {
            /*
                r4 = this;
                com.avito.android.remote.model.ParcelableEntity r5 = (com.avito.android.remote.model.ParcelableEntity) r5
                com.avito.android.remote.model.ParcelableEntity r6 = (com.avito.android.remote.model.ParcelableEntity) r6
                boolean r0 = r5 instanceof com.avito.android.remote.model.category_parameters.SelectParameter.Value
                r1 = 0
                if (r0 == 0) goto L_0x0029
                boolean r0 = r6 instanceof com.avito.android.remote.model.category_parameters.SelectParameter.Value
                if (r0 == 0) goto L_0x0029
                com.avito.android.remote.model.category_parameters.SelectParameter$Value r5 = (com.avito.android.remote.model.category_parameters.SelectParameter.Value) r5
                com.avito.android.remote.model.category_parameters.SelectParameter$Value$Display r5 = r5.getDisplay()
                if (r5 == 0) goto L_0x001a
                java.lang.String r5 = r5.getSortParam()
                goto L_0x001b
            L_0x001a:
                r5 = r1
            L_0x001b:
                com.avito.android.remote.model.category_parameters.SelectParameter$Value r6 = (com.avito.android.remote.model.category_parameters.SelectParameter.Value) r6
                com.avito.android.remote.model.category_parameters.SelectParameter$Value$Display r6 = r6.getDisplay()
                if (r6 == 0) goto L_0x004c
                java.lang.String r6 = r6.getSortParam()
            L_0x0027:
                r1 = r6
                goto L_0x004c
            L_0x0029:
                boolean r0 = r5 instanceof com.avito.android.remote.model.category_parameters.MultiselectParameter.Value
                if (r0 == 0) goto L_0x0050
                boolean r0 = r6 instanceof com.avito.android.remote.model.category_parameters.MultiselectParameter.Value
                if (r0 == 0) goto L_0x0050
                com.avito.android.remote.model.category_parameters.MultiselectParameter$Value r5 = (com.avito.android.remote.model.category_parameters.MultiselectParameter.Value) r5
                com.avito.android.remote.model.category_parameters.MultiselectParameter$Value$Display r5 = r5.getDisplay()
                if (r5 == 0) goto L_0x003e
                java.lang.String r5 = r5.getSortParam()
                goto L_0x003f
            L_0x003e:
                r5 = r1
            L_0x003f:
                com.avito.android.remote.model.category_parameters.MultiselectParameter$Value r6 = (com.avito.android.remote.model.category_parameters.MultiselectParameter.Value) r6
                com.avito.android.remote.model.category_parameters.MultiselectParameter$Value$Display r6 = r6.getDisplay()
                if (r6 == 0) goto L_0x004c
                java.lang.String r6 = r6.getSortParam()
                goto L_0x0027
            L_0x004c:
                r3 = r1
                r1 = r5
                r5 = r3
                goto L_0x0051
            L_0x0050:
                r5 = r1
            L_0x0051:
                r6 = 1
                r0 = 0
                if (r1 == 0) goto L_0x0062
                int r2 = r1.length()
                if (r2 <= 0) goto L_0x005d
                r2 = 1
                goto L_0x005e
            L_0x005d:
                r2 = 0
            L_0x005e:
                if (r2 == 0) goto L_0x0062
                r2 = 1
                goto L_0x0063
            L_0x0062:
                r2 = 0
            L_0x0063:
                if (r2 == 0) goto L_0x0088
                if (r5 == 0) goto L_0x0073
                int r2 = r5.length()
                if (r2 <= 0) goto L_0x006f
                r2 = 1
                goto L_0x0070
            L_0x006f:
                r2 = 0
            L_0x0070:
                if (r2 == 0) goto L_0x0073
                goto L_0x0074
            L_0x0073:
                r6 = 0
            L_0x0074:
                if (r6 == 0) goto L_0x0088
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
                int r0 = r1.compareTo(r5)
                com.avito.android.remote.model.category_parameters.SortDirection r5 = r4.a
                com.avito.android.remote.model.category_parameters.SortDirection r6 = com.avito.android.remote.model.category_parameters.SortDirection.Descending
                if (r5 != r6) goto L_0x0088
                int r0 = r0 * -1
            L_0x0088:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.select.SelectParameterLocalSorterImpl.a.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    public final List<ParcelableEntity<String>> a(List<? extends ParcelableEntity<String>> list, SortDirection sortDirection) {
        if (list.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return CollectionsKt___CollectionsKt.sortedWith(list, new a(sortDirection));
    }

    @Override // com.avito.android.select.SelectParameterLocalSorter
    @NotNull
    public List<ParcelableEntity<String>> sort(@NotNull List<? extends ParcelableEntity<String>> list, @NotNull SortDirection sortDirection) {
        Intrinsics.checkNotNullParameter(list, "unsorted");
        Intrinsics.checkNotNullParameter(sortDirection, "direction");
        ArrayList arrayList = new ArrayList();
        int size = list.size() - 1;
        int i = -1;
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            if (i2 == size) {
                arrayList.addAll(a(list.subList(i + 1, i3), sortDirection));
            }
            if ((t2 instanceof SectionTitle) && i < i2) {
                arrayList.addAll(a(list.subList(i + 1, i2), sortDirection));
                arrayList.add(t2);
                i = i2;
            }
            i2 = i3;
        }
        return arrayList;
    }
}
