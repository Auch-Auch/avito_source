package com.avito.android.publish.details.adapter.date_interval;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.PayloadItemPresenter;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rR\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenter;", "Lcom/avito/konveyor/blueprint/PayloadItemPresenter;", "Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemView;", "Lcom/avito/android/category_parameters/ParameterElement$DateInterval;", "Lio/reactivex/Observable;", "Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenter$DateSelectInfo;", "getPresentTimeCheckChanges", "()Lio/reactivex/Observable;", "presentTimeCheckChanges", "getStartDateSelectClicks", "startDateSelectClicks", "getEndDateSelectClicks", "endDateSelectClicks", "DateSelectInfo", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface DateIntervalItemPresenter extends PayloadItemPresenter<DateIntervalItemView, ParameterElement.DateInterval> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenter$DateSelectInfo;", "", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Long;", "getDelimiter", "()Ljava/lang/Long;", "delimiter", "Lcom/avito/android/category_parameters/ParameterElement$DateInterval;", AuthSource.SEND_ABUSE, "Lcom/avito/android/category_parameters/ParameterElement$DateInterval;", "getSelectInfo", "()Lcom/avito/android/category_parameters/ParameterElement$DateInterval;", "selectInfo", "", "c", "Z", "isPresentTime", "()Z", "<init>", "(Lcom/avito/android/category_parameters/ParameterElement$DateInterval;Ljava/lang/Long;Z)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class DateSelectInfo {
        @NotNull
        public final ParameterElement.DateInterval a;
        @Nullable
        public final Long b;
        public final boolean c;

        public DateSelectInfo(@NotNull ParameterElement.DateInterval dateInterval, @Nullable Long l, boolean z) {
            Intrinsics.checkNotNullParameter(dateInterval, "selectInfo");
            this.a = dateInterval;
            this.b = l;
            this.c = z;
        }

        @Nullable
        public final Long getDelimiter() {
            return this.b;
        }

        @NotNull
        public final ParameterElement.DateInterval getSelectInfo() {
            return this.a;
        }

        public final boolean isPresentTime() {
            return this.c;
        }
    }

    @NotNull
    Observable<DateSelectInfo> getEndDateSelectClicks();

    @NotNull
    Observable<DateSelectInfo> getPresentTimeCheckChanges();

    @NotNull
    Observable<DateSelectInfo> getStartDateSelectClicks();
}
