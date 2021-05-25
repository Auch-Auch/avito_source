package com.avito.android.inline_filters.di;

import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarDialog;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.str_calendar.di.component.StrBookingCalendarDependencies;
import com.avito.android.str_calendar.di.qualifier.EndDate;
import com.avito.android.str_calendar.di.qualifier.StartDate;
import dagger.BindsInstance;
import dagger.Component;
import java.util.Date;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/inline_filters/di/InlineFilterCalendarComponent;", "", "Lcom/avito/android/inline_filters/dialog/calendar/InlineFiltersCalendarDialog;", "dialog", "", "inject", "(Lcom/avito/android/inline_filters/dialog/calendar/InlineFiltersCalendarDialog;)V", "Builder", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {StrBookingCalendarDependencies.class}, modules = {InlineFiltersCalendarModule.class})
@PerFragment
public interface InlineFilterCalendarComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00002\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0011H'¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u00002\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0011H'¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/inline_filters/di/InlineFilterCalendarComponent$Builder;", "", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/inline_filters/di/InlineFilterCalendarComponent$Builder;", "Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterDateRangeValue;", "value", "bindValue", "(Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterDateRangeValue;)Lcom/avito/android/inline_filters/di/InlineFilterCalendarComponent$Builder;", "Lcom/avito/android/remote/model/search/Filter$Widget;", "widget", "bindWidget", "(Lcom/avito/android/remote/model/search/Filter$Widget;)Lcom/avito/android/inline_filters/di/InlineFilterCalendarComponent$Builder;", "", "title", "bindTitle", "(Ljava/lang/String;)Lcom/avito/android/inline_filters/di/InlineFilterCalendarComponent$Builder;", "Ljava/util/Date;", "checkInDate", "(Ljava/util/Date;)Lcom/avito/android/inline_filters/di/InlineFilterCalendarComponent$Builder;", "checkOutDate", "Lcom/avito/android/str_calendar/di/component/StrBookingCalendarDependencies;", "dependencies", "bookingCalendarDependencies", "(Lcom/avito/android/str_calendar/di/component/StrBookingCalendarDependencies;)Lcom/avito/android/inline_filters/di/InlineFilterCalendarComponent$Builder;", "Lcom/avito/android/inline_filters/di/InlineFilterCalendarComponent;", "build", "()Lcom/avito/android/inline_filters/di/InlineFilterCalendarComponent;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder bindTitle(@NotNull String str);

        @BindsInstance
        @NotNull
        Builder bindValue(@Nullable InlineFilterValue.InlineFilterDateRangeValue inlineFilterDateRangeValue);

        @BindsInstance
        @NotNull
        Builder bindWidget(@Nullable Filter.Widget widget);

        @NotNull
        Builder bookingCalendarDependencies(@NotNull StrBookingCalendarDependencies strBookingCalendarDependencies);

        @NotNull
        InlineFilterCalendarComponent build();

        @BindsInstance
        @NotNull
        Builder checkInDate(@StartDate @Nullable Date date);

        @BindsInstance
        @NotNull
        Builder checkOutDate(@EndDate @Nullable Date date);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);
    }

    void inject(@NotNull InlineFiltersCalendarDialog inlineFiltersCalendarDialog);
}
