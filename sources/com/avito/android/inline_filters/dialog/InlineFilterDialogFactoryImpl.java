package com.avito.android.inline_filters.dialog;

import android.app.Activity;
import android.os.Parcelable;
import com.avito.android.Features;
import com.avito.android.ab_tests.AutoGenerationsFilterWithPhotos;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarDialog;
import com.avito.android.inline_filters.dialog.range.RangeFilterDialog;
import com.avito.android.inline_filters.dialog.select.GroupSelectFilterDialog;
import com.avito.android.inline_filters.dialog.select.MultiselectFilterDialog;
import com.avito.android.inline_filters.dialog.select.SelectFilterDialog;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.remote.model.search.WidgetType;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010&\u001a\u00020#\u0012\u000e\b\u0001\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b'\u0010(Jp\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R(\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactoryImpl;", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;", "Lcom/avito/android/remote/model/search/Filter;", "inlineFilter", "", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "convertedItems", "Landroid/os/Parcelable;", "state", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "Lkotlin/ParameterName;", "name", "selectedValue", "", "selectedItemListener", "Lkotlin/Function0;", "dialogCloseListener", "closeButtonListener", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialog;", "provideInlineFilterDialog", "(Lcom/avito/android/remote/model/search/Filter;Ljava/util/List;Landroid/os/Parcelable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lcom/avito/android/inline_filters/dialog/InlineFilterDialog;", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "getFilterWithPhotosGroup", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "setFilterWithPhotosGroup", "(Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;)V", "filterWithPhotosGroup", "Landroid/app/Activity;", AuthSource.SEND_ABUSE, "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;Lcom/avito/android/Features;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFilterDialogFactoryImpl implements InlineFilterDialogFactory {
    public final Activity a;
    @NotNull
    public SingleManuallyExposedAbTestGroup<SimpleTestGroup> b;
    public final Features c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            WidgetType.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            WidgetType widgetType = WidgetType.Select;
            iArr[1] = 1;
            WidgetType widgetType2 = WidgetType.NumericRange;
            iArr[3] = 2;
            WidgetType widgetType3 = WidgetType.Multiselect;
            iArr[2] = 3;
            WidgetType widgetType4 = WidgetType.Calendar;
            iArr[4] = 4;
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ InlineFilterDialogFactoryImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InlineFilterDialogFactoryImpl inlineFilterDialogFactoryImpl) {
            super(0);
            this.a = inlineFilterDialogFactoryImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getFilterWithPhotosGroup().exposeIfNeeded();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public InlineFilterDialogFactoryImpl(@NotNull Activity activity, @AutoGenerationsFilterWithPhotos @NotNull SingleManuallyExposedAbTestGroup<SimpleTestGroup> singleManuallyExposedAbTestGroup, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "filterWithPhotosGroup");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = activity;
        this.b = singleManuallyExposedAbTestGroup;
        this.c = features;
    }

    @NotNull
    public final SingleManuallyExposedAbTestGroup<SimpleTestGroup> getFilterWithPhotosGroup() {
        return this.b;
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFilterDialogFactory
    @Nullable
    public InlineFilterDialog provideInlineFilterDialog(@NotNull Filter filter, @NotNull List<InlineFiltersDialogItem> list, @Nullable Parcelable parcelable, @NotNull Function1<? super InlineFilterValue, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(filter, "inlineFilter");
        Intrinsics.checkNotNullParameter(list, "convertedItems");
        Intrinsics.checkNotNullParameter(function1, "selectedItemListener");
        Intrinsics.checkNotNullParameter(function0, "dialogCloseListener");
        Intrinsics.checkNotNullParameter(function02, "closeButtonListener");
        a aVar = new a(this);
        Filter.Widget widget = filter.getWidget();
        WidgetType type = widget != null ? widget.getType() : null;
        if (type == null) {
            return null;
        }
        int ordinal = type.ordinal();
        if (ordinal == 1) {
            return new SelectFilterDialog(this.a, filter, list, parcelable, function1, function0, function02, aVar);
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return new RangeFilterDialog(this.a, filter, parcelable, function1, function0);
            }
            if (ordinal != 4) {
                return null;
            }
            return new InlineFiltersCalendarDialog(this.a, function1, function0, filter, parcelable);
        } else if (!this.c.getGroupSelectForInlineFilters().invoke().booleanValue() || !InlineFilterDialogFactoryKt.access$hasGroupsConfig(filter.getWidget())) {
            return new MultiselectFilterDialog(this.a, filter, list, parcelable, function1, function0, aVar);
        } else {
            return new GroupSelectFilterDialog(this.a, filter, list, parcelable, function1, function0);
        }
    }

    public final void setFilterWithPhotosGroup(@NotNull SingleManuallyExposedAbTestGroup<SimpleTestGroup> singleManuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "<set-?>");
        this.b = singleManuallyExposedAbTestGroup;
    }
}
