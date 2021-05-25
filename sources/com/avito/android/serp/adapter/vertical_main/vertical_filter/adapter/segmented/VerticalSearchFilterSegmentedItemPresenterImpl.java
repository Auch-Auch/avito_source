package com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.VerticalSearchFilterFormItem;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemPresenterImpl;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemPresenter;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemView;", "view", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterFormItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemView;Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterFormItem;I)V", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;", "presenter", "<init>", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalSearchFilterSegmentedItemPresenterImpl implements VerticalSearchFilterSegmentedItemPresenter {
    public final VerticalFilterPresenter a;

    public static final class a extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ VerticalSearchFilterSegmentedItemPresenterImpl a;
        public final /* synthetic */ List b;
        public final /* synthetic */ VerticalSearchFilterFormItem c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(VerticalSearchFilterSegmentedItemPresenterImpl verticalSearchFilterSegmentedItemPresenterImpl, List list, VerticalSearchFilterFormItem verticalSearchFilterFormItem) {
            super(1);
            this.a = verticalSearchFilterSegmentedItemPresenterImpl;
            this.b = list;
            this.c = verticalSearchFilterFormItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
            if ((r1 == null || r1.length() == 0) != false) goto L_0x002b;
         */
        @Override // kotlin.jvm.functions.Function1
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public kotlin.Unit invoke(java.lang.Integer r15) {
            /*
                r14 = this;
                java.lang.Number r15 = (java.lang.Number) r15
                int r15 = r15.intValue()
                r0 = 0
                if (r15 < 0) goto L_0x002b
                java.util.List r1 = r14.b
                int r1 = r1.size()
                if (r15 >= r1) goto L_0x002b
                java.util.List r1 = r14.b
                java.lang.Object r15 = r1.get(r15)
                com.avito.android.remote.model.search.Filter$InnerOptions$Options r15 = (com.avito.android.remote.model.search.Filter.InnerOptions.Options) r15
                java.lang.String r1 = r15.getId()
                if (r1 == 0) goto L_0x0028
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0026
                goto L_0x0028
            L_0x0026:
                r1 = 0
                goto L_0x0029
            L_0x0028:
                r1 = 1
            L_0x0029:
                if (r1 == 0) goto L_0x002c
            L_0x002b:
                r15 = r0
            L_0x002c:
                com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.VerticalSearchFilterFormItem r1 = r14.c
                com.avito.android.remote.model.search.Filter r1 = r1.getFilter()
                if (r1 == 0) goto L_0x003d
                com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemPresenterImpl r2 = r14.a
                com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter r2 = com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemPresenterImpl.access$getPresenter$p(r2)
                r2.onSegmentedSelect(r1, r15)
            L_0x003d:
                com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.VerticalSearchFilterFormItem r1 = r14.c
                com.avito.android.remote.model.search.Filter r2 = r1.getFilter()
                if (r2 == 0) goto L_0x005f
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                com.avito.android.remote.model.search.InlineFilterValue$InlineFilterSelectValue r9 = new com.avito.android.remote.model.search.InlineFilterValue$InlineFilterSelectValue
                if (r15 == 0) goto L_0x0053
                java.lang.String r0 = r15.getId()
            L_0x0053:
                r9.<init>(r0)
                r10 = 0
                r11 = 0
                r12 = 447(0x1bf, float:6.26E-43)
                r13 = 0
                com.avito.android.remote.model.search.Filter r0 = com.avito.android.remote.model.search.Filter.copy$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            L_0x005f:
                r1.setFilter(r0)
                kotlin.Unit r15 = kotlin.Unit.INSTANCE
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemPresenterImpl.a.invoke(java.lang.Object):java.lang.Object");
        }
    }

    @Inject
    public VerticalSearchFilterSegmentedItemPresenterImpl(@NotNull VerticalFilterPresenter verticalFilterPresenter) {
        Intrinsics.checkNotNullParameter(verticalFilterPresenter, "presenter");
        this.a = verticalFilterPresenter;
    }

    public void bindView(@NotNull VerticalSearchFilterSegmentedItemView verticalSearchFilterSegmentedItemView, @NotNull VerticalSearchFilterFormItem verticalSearchFilterFormItem, int i) {
        List<Filter.InnerOptions.Options> list;
        List<Filter.InnerOptions> options;
        Intrinsics.checkNotNullParameter(verticalSearchFilterSegmentedItemView, "view");
        Intrinsics.checkNotNullParameter(verticalSearchFilterFormItem, "item");
        int i2 = 0;
        verticalSearchFilterSegmentedItemView.setIsEnabled(verticalSearchFilterFormItem.isEnabled() && verticalSearchFilterFormItem.getFilter() != null);
        Filter filter = verticalSearchFilterFormItem.getFilter();
        if (filter == null || (options = filter.getOptions()) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list = new ArrayList();
            Iterator<T> it = options.iterator();
            while (it.hasNext()) {
                List<Filter.InnerOptions.Options> options2 = it.next().getOptions();
                if (options2 == null) {
                    options2 = CollectionsKt__CollectionsKt.emptyList();
                }
                h.addAll(list, options2);
            }
        }
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            for (Filter.InnerOptions.Options options3 : list) {
                String title = options3.getTitle();
                if (title == null) {
                    title = "";
                }
                arrayList.add(title);
            }
            Filter filter2 = verticalSearchFilterFormItem.getFilter();
            InlineFilterValue.InlineFilterSelectValue inlineFilterSelectValue = null;
            InlineFilterValue value = filter2 != null ? filter2.getValue() : null;
            if (value instanceof InlineFilterValue.InlineFilterSelectValue) {
                inlineFilterSelectValue = value;
            }
            InlineFilterValue.InlineFilterSelectValue inlineFilterSelectValue2 = inlineFilterSelectValue;
            if (inlineFilterSelectValue2 != null) {
                Iterator it2 = list.iterator();
                int i3 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i3 = -1;
                        break;
                    } else if (Intrinsics.areEqual(((Filter.InnerOptions.Options) it2.next()).getId(), inlineFilterSelectValue2.getSelectedOption())) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 != -1) {
                    i2 = i3;
                }
            }
            verticalSearchFilterSegmentedItemView.setTexts(arrayList, i2);
        }
        verticalSearchFilterSegmentedItemView.setOnClickListener(new a(this, list, verticalSearchFilterFormItem));
    }
}
