package com.avito.android.inline_filters.dialog;

import a2.a.a.g1.e.a;
import com.avito.android.Features;
import com.avito.android.ab_tests.AutoGenerationsFilterWithPhotos;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.category_parameters.SortDirection;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.remote.model.search.WidgetType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u000e\b\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/inline_filters/dialog/InlineFiltersDialogItemConverterImpl;", "Lcom/avito/android/inline_filters/dialog/InlineFiltersDialogItemConverter;", "Lcom/avito/android/remote/model/search/Filter;", "filters", "", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "convertItems", "(Lcom/avito/android/remote/model/search/Filter;)Ljava/util/List;", "Lcom/avito/android/Features;", AuthSource.SEND_ABUSE, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "filterWithPhotosGroup", "<init>", "(Lcom/avito/android/Features;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFiltersDialogItemConverterImpl implements InlineFiltersDialogItemConverter {
    public final Features a;
    public final SingleManuallyExposedAbTestGroup<SimpleTestGroup> b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            WidgetType.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            WidgetType widgetType = WidgetType.Select;
            iArr[1] = 1;
            WidgetType widgetType2 = WidgetType.Multiselect;
            iArr[2] = 2;
        }
    }

    @Inject
    public InlineFiltersDialogItemConverterImpl(@NotNull Features features, @AutoGenerationsFilterWithPhotos @NotNull SingleManuallyExposedAbTestGroup<SimpleTestGroup> singleManuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "filterWithPhotosGroup");
        this.a = features;
        this.b = singleManuallyExposedAbTestGroup;
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFiltersDialogItemConverter
    @NotNull
    public List<InlineFiltersDialogItem> convertItems(@NotNull Filter filter) {
        int ordinal;
        InlineFiltersDialogItem inlineFiltersDialogItem;
        Image image;
        boolean z;
        boolean z2;
        String str;
        Filter.Config config;
        Boolean withImages;
        Filter.Config config2;
        Intrinsics.checkNotNullParameter(filter, "filters");
        Filter.Widget widget = filter.getWidget();
        WidgetType type = widget != null ? widget.getType() : null;
        if (type == null || !((ordinal = type.ordinal()) == 1 || ordinal == 2)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        LinkedList linkedList = new LinkedList();
        List<Filter.InnerOptions> options = filter.getOptions();
        if (options != null) {
            for (T t : options) {
                if (t.getTitle() != null) {
                    linkedList.addLast(t.getTitle());
                }
                List<Filter.InnerOptions.Options> options2 = t.getOptions();
                if (options2 != null) {
                    Filter.Widget widget2 = filter.getWidget();
                    SortDirection sortDirection = (widget2 == null || (config2 = widget2.getConfig()) == null) ? null : config2.getSortDirection();
                    if (this.a.getLocalSortInSelectFilters().invoke().booleanValue() && sortDirection != null) {
                        options2 = CollectionsKt___CollectionsKt.sortedWith(options2, new a(sortDirection));
                    }
                    linkedList.addAll(options2);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : linkedList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (obj instanceof String) {
                inlineFiltersDialogItem = new InlineFiltersDialogItem(String.valueOf(i), (String) obj, null, "", true, false, false, false, false, false, null, 1988, null);
            } else if (obj instanceof Filter.InnerOptions.Options) {
                Filter.Widget widget3 = filter.getWidget();
                if (widget3 == null || (config = widget3.getConfig()) == null || (withImages = config.getWithImages()) == null) {
                    image = null;
                    z2 = false;
                    z = false;
                } else {
                    z2 = this.a.getImageSelectInFiltersMvp3().invoke().booleanValue() && (this.b.getTestGroup().isTest() ^ true) && withImages.booleanValue();
                    image = ((Filter.InnerOptions.Options) obj).getImage();
                    z = true;
                }
                String valueOf = String.valueOf(i);
                Filter.InnerOptions.Options options3 = (Filter.InnerOptions.Options) obj;
                String title = options3.getTitle();
                String str2 = title != null ? title : "";
                String subtitle = options3.getSubtitle();
                String id = options3.getId();
                if (id != null) {
                    str = id;
                } else {
                    str = "";
                }
                boolean access$isChecked = InlineFiltersDialogItemConverterKt.access$isChecked(options3, filter);
                boolean z3 = filter.getValue() instanceof InlineFilterValue.InlineFilterSelectIntValue;
                Filter.Widget widget4 = filter.getWidget();
                inlineFiltersDialogItem = new InlineFiltersDialogItem(valueOf, str2, subtitle, str, false, access$isChecked, z3, (widget4 != null ? widget4.getType() : null) == WidgetType.Multiselect, z2, z, image);
            } else {
                inlineFiltersDialogItem = null;
            }
            if (inlineFiltersDialogItem != null) {
                arrayList.add(inlineFiltersDialogItem);
            }
            i = i2;
        }
        return arrayList;
    }
}
