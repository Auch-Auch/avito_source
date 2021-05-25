package com.avito.android.publish.details.adapter.date_interval;

import android.text.format.DateFormat;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.ItemWithState;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataConverterKt;
import com.avito.android.util.DateChange;
import com.avito.android.util.DateIntervalChangePayload;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b/\u00100J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\t\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u001a\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R:\u0010&\u001a&\u0012\f\u0012\n $*\u0004\u0018\u00010\u001d0\u001d $*\u0012\u0012\f\u0012\n $*\u0004\u0018\u00010\u001d0\u001d\u0018\u00010#0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010%R\"\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010!R:\u0010*\u001a&\u0012\f\u0012\n $*\u0004\u0018\u00010\u001d0\u001d $*\u0012\u0012\f\u0012\n $*\u0004\u0018\u00010\u001d0\u001d\u0018\u00010#0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010%R\"\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010!R:\u0010.\u001a&\u0012\f\u0012\n $*\u0004\u0018\u00010\u001d0\u001d $*\u0012\u0012\f\u0012\n $*\u0004\u0018\u00010\u001d0\u001d\u0018\u00010#0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010%¨\u00061"}, d2 = {"Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenterImpl;", "Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenter;", "Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$DateInterval;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemView;Lcom/avito/android/category_parameters/ParameterElement$DateInterval;I)V", "", "", "payloads", "(Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemView;Lcom/avito/android/category_parameters/ParameterElement$DateInterval;ILjava/util/List;)V", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemView;Lcom/avito/android/category_parameters/ParameterElement$DateInterval;)V", "", "useStartTitle", "c", "(Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemView;Lcom/avito/android/category_parameters/ParameterElement$DateInterval;Z)V", "", "itemTitle", "Lcom/avito/android/items/ItemWithState$State;", "startSelectState", "endSelectState", AuthSource.SEND_ABUSE, "(Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemView;Ljava/lang/String;Lcom/avito/android/items/ItemWithState$State;Lcom/avito/android/items/ItemWithState$State;)V", "Lio/reactivex/Observable;", "Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenter$DateSelectInfo;", "e", "Lio/reactivex/Observable;", "getStartDateSelectClicks", "()Lio/reactivex/Observable;", "startDateSelectClicks", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "Lcom/jakewharton/rxrelay2/PublishRelay;", "presentTimeCheckRelay", "f", "getEndDateSelectClicks", "endDateSelectClicks", "startDateSelectClicksRelay", "d", "getPresentTimeCheckChanges", "presentTimeCheckChanges", "endDateSelectClicksRelay", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class DateIntervalItemPresenterImpl implements DateIntervalItemPresenter {
    public final PublishRelay<DateIntervalItemPresenter.DateSelectInfo> a;
    public final PublishRelay<DateIntervalItemPresenter.DateSelectInfo> b;
    public final PublishRelay<DateIntervalItemPresenter.DateSelectInfo> c;
    @NotNull
    public final Observable<DateIntervalItemPresenter.DateSelectInfo> d;
    @NotNull
    public final Observable<DateIntervalItemPresenter.DateSelectInfo> e;
    @NotNull
    public final Observable<DateIntervalItemPresenter.DateSelectInfo> f;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            Long l = null;
            if (i == 0) {
                PublishRelay publishRelay = ((DateIntervalItemPresenterImpl) this.b).b;
                ParameterElement.DateInterval dateInterval = (ParameterElement.DateInterval) this.c;
                ParameterElement.DateTime end = dateInterval.getEnd();
                if (end != null) {
                    l = end.getValue();
                }
                publishRelay.accept(new DateIntervalItemPresenter.DateSelectInfo(dateInterval, l, false));
                return Unit.INSTANCE;
            } else if (i == 1) {
                PublishRelay publishRelay2 = ((DateIntervalItemPresenterImpl) this.b).c;
                ParameterElement.DateInterval dateInterval2 = (ParameterElement.DateInterval) this.c;
                ParameterElement.DateTime start = dateInterval2.getStart();
                if (start != null) {
                    l = start.getValue();
                }
                publishRelay2.accept(new DateIntervalItemPresenter.DateSelectInfo(dateInterval2, l, false));
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ DateIntervalItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.DateInterval b;
        public final /* synthetic */ DateIntervalItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(DateIntervalItemPresenterImpl dateIntervalItemPresenterImpl, ParameterElement.DateInterval dateInterval, DateIntervalItemView dateIntervalItemView) {
            super(1);
            this.a = dateIntervalItemPresenterImpl;
            this.b = dateInterval;
            this.c = dateIntervalItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            boolean booleanValue = bool.booleanValue();
            ParameterElement.DateTime end = this.b.getEnd();
            if (end != null) {
                end.setPresentTime(booleanValue);
            }
            this.a.c(this.c, this.b, booleanValue);
            if (booleanValue) {
                this.c.setEndSelectText(null);
            }
            this.c.setEndSelectVisible(!booleanValue);
            DateIntervalItemPresenterImpl dateIntervalItemPresenterImpl = this.a;
            DateIntervalItemView dateIntervalItemView = this.c;
            String title = this.b.getTitle();
            ParameterElement.DateTime start = this.b.getStart();
            ItemWithState.State state = start != null ? start.getState() : null;
            ParameterElement.DateTime end2 = this.b.getEnd();
            dateIntervalItemPresenterImpl.a(dateIntervalItemView, title, state, end2 != null ? end2.getState() : null);
            this.a.a.accept(new DateIntervalItemPresenter.DateSelectInfo(this.b, null, booleanValue));
            return Unit.INSTANCE;
        }
    }

    @Inject
    public DateIntervalItemPresenterImpl() {
        PublishRelay<DateIntervalItemPresenter.DateSelectInfo> create = PublishRelay.create();
        this.a = create;
        PublishRelay<DateIntervalItemPresenter.DateSelectInfo> create2 = PublishRelay.create();
        this.b = create2;
        PublishRelay<DateIntervalItemPresenter.DateSelectInfo> create3 = PublishRelay.create();
        this.c = create3;
        Observable<DateIntervalItemPresenter.DateSelectInfo> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "presentTimeCheckRelay.hide()");
        this.d = hide;
        Observable<DateIntervalItemPresenter.DateSelectInfo> hide2 = create2.hide();
        Intrinsics.checkNotNullExpressionValue(hide2, "startDateSelectClicksRelay.hide()");
        this.e = hide2;
        Observable<DateIntervalItemPresenter.DateSelectInfo> hide3 = create3.hide();
        Intrinsics.checkNotNullExpressionValue(hide3, "endDateSelectClicksRelay.hide()");
        this.f = hide3;
    }

    public final void a(DateIntervalItemView dateIntervalItemView, String str, ItemWithState.State state, ItemWithState.State state2) {
        boolean z = state instanceof ItemWithState.State.Error;
        if (z && (state2 instanceof ItemWithState.State.Error)) {
            dateIntervalItemView.setAllStatesToError(str);
        } else if (z) {
            dateIntervalItemView.setStartSelectStateToError(((ItemWithState.State.Error) state).getMessage());
        } else if (state2 instanceof ItemWithState.State.Error) {
            dateIntervalItemView.setEndSelectStateToError(((ItemWithState.State.Error) state2).getMessage());
        } else if (state instanceof ItemWithState.State.Normal) {
            dateIntervalItemView.setStartSelectStateToNormal();
        } else if (state2 instanceof ItemWithState.State.Normal) {
            dateIntervalItemView.setEndSelectStateToNormal();
        }
    }

    public final void b(DateIntervalItemView dateIntervalItemView, ParameterElement.DateInterval dateInterval) {
        if (dateInterval.getStart() == null) {
            dateIntervalItemView.setStartSelectClickListener(null);
        } else {
            dateIntervalItemView.setStartSelectClickListener(new a(0, this, dateInterval));
        }
        dateIntervalItemView.setEndSelectClickListener(new a(1, this, dateInterval));
        dateIntervalItemView.setPresentTimeCheckboxListener(new b(this, dateInterval, dateIntervalItemView));
    }

    public final void c(DateIntervalItemView dateIntervalItemView, ParameterElement.DateInterval dateInterval, boolean z) {
        ParameterElement.DateTime start = dateInterval.getStart();
        String title = start != null ? start.getTitle() : null;
        if (!z || title == null) {
            dateIntervalItemView.setTitle(dateInterval.getTitle());
        } else {
            dateIntervalItemView.setTitle(title);
        }
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemPresenter
    @NotNull
    public Observable<DateIntervalItemPresenter.DateSelectInfo> getEndDateSelectClicks() {
        return this.f;
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemPresenter
    @NotNull
    public Observable<DateIntervalItemPresenter.DateSelectInfo> getPresentTimeCheckChanges() {
        return this.d;
    }

    @Override // com.avito.android.publish.details.adapter.date_interval.DateIntervalItemPresenter
    @NotNull
    public Observable<DateIntervalItemPresenter.DateSelectInfo> getStartDateSelectClicks() {
        return this.e;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.konveyor.blueprint.ItemView, com.avito.konveyor.blueprint.Item, int, java.util.List] */
    @Override // com.avito.konveyor.blueprint.PayloadItemPresenter
    public /* bridge */ /* synthetic */ void bindView(DateIntervalItemView dateIntervalItemView, ParameterElement.DateInterval dateInterval, int i, List list) {
        bindView(dateIntervalItemView, dateInterval, i, (List<? extends Object>) list);
    }

    public void bindView(@NotNull DateIntervalItemView dateIntervalItemView, @NotNull ParameterElement.DateInterval dateInterval, int i) {
        String presentTime;
        Intrinsics.checkNotNullParameter(dateIntervalItemView, "view");
        Intrinsics.checkNotNullParameter(dateInterval, "item");
        ParameterElement.DateTime end = dateInterval.getEnd();
        c(dateIntervalItemView, dateInterval, end != null ? end.isPresentTime() : true);
        ParameterElement.DateTime start = dateInterval.getStart();
        ItemWithState.State state = null;
        if (start != null) {
            dateIntervalItemView.setStartSelectVisible(true);
            Long value = start.getValue();
            dateIntervalItemView.setStartSelectText(value != null ? DateFormat.format(CalendarDataConverterKt.MONTH_YEAR_PATTERN, value.longValue()).toString() : null);
        } else {
            dateIntervalItemView.setStartSelectVisible(false);
        }
        ParameterElement.DateTime end2 = dateInterval.getEnd();
        if (end2 != null) {
            dateIntervalItemView.setEndSelectVisible(!end2.isPresentTime());
            Long value2 = end2.getValue();
            dateIntervalItemView.setEndSelectText(value2 != null ? DateFormat.format(CalendarDataConverterKt.MONTH_YEAR_PATTERN, value2.longValue()).toString() : null);
        } else {
            dateIntervalItemView.setEndSelectVisible(false);
        }
        if (end2 == null || (presentTime = end2.getPresentTime()) == null) {
            dateIntervalItemView.setPresentTimeCheckboxVisibility(false);
        } else {
            dateIntervalItemView.setPresentTimeCheckboxText(presentTime);
            dateIntervalItemView.setPresentTimeCheckboxValue(end2.isPresentTime());
            dateIntervalItemView.setPresentTimeCheckboxVisibility(true);
        }
        String title = dateInterval.getTitle();
        ItemWithState.State state2 = start != null ? start.getState() : null;
        if (end2 != null) {
            state = end2.getState();
        }
        a(dateIntervalItemView, title, state2, state);
        b(dateIntervalItemView, dateInterval);
    }

    public void bindView(@NotNull DateIntervalItemView dateIntervalItemView, @NotNull ParameterElement.DateInterval dateInterval, int i, @NotNull List<? extends Object> list) {
        ItemWithState.State state;
        Long timeStamp;
        Long timeStamp2;
        ItemWithState.State state2;
        Intrinsics.checkNotNullParameter(dateIntervalItemView, "view");
        Intrinsics.checkNotNullParameter(dateInterval, "item");
        Intrinsics.checkNotNullParameter(list, "payloads");
        ItemWithState.State state3 = null;
        T t = null;
        for (T t2 : list) {
            if (t2 instanceof DateIntervalChangePayload) {
                t = t2;
            }
        }
        T t3 = t;
        if (t3 == null) {
            bindView(dateIntervalItemView, dateInterval, i);
            return;
        }
        String title = dateInterval.getTitle();
        DateChange startDateChange = t3.getStartDateChange();
        if (startDateChange == null || (state = startDateChange.getState()) == null) {
            ParameterElement.DateTime start = dateInterval.getStart();
            state = start != null ? start.getState() : null;
        }
        DateChange endDateChange = t3.getEndDateChange();
        if (endDateChange == null || (state2 = endDateChange.getState()) == null) {
            ParameterElement.DateTime end = dateInterval.getEnd();
            if (end != null) {
                state3 = end.getState();
            }
        } else {
            state3 = state2;
        }
        a(dateIntervalItemView, title, state, state3);
        DateChange startDateChange2 = t3.getStartDateChange();
        if (!(startDateChange2 == null || (timeStamp2 = startDateChange2.getTimeStamp()) == null)) {
            dateIntervalItemView.setStartSelectText(DateFormat.format(CalendarDataConverterKt.MONTH_YEAR_PATTERN, timeStamp2.longValue()).toString());
        }
        DateChange endDateChange2 = t3.getEndDateChange();
        if (!(endDateChange2 == null || (timeStamp = endDateChange2.getTimeStamp()) == null)) {
            dateIntervalItemView.setEndSelectText(DateFormat.format(CalendarDataConverterKt.MONTH_YEAR_PATTERN, timeStamp.longValue()).toString());
        }
        Boolean tillCurrentTime = t3.getTillCurrentTime();
        if (tillCurrentTime != null) {
            dateIntervalItemView.setPresentTimeCheckboxValue(tillCurrentTime.booleanValue());
        }
        b(dateIntervalItemView, dateInterval);
    }
}
