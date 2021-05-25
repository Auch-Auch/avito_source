package com.avito.android.select.new_metro.adapter.metro_station;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.new_metro.adapter.checkbox_listitem.CheckBoxListItemView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nRD\u0010\u0010\u001a0\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u0004 \f*\u0017\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u000b¢\u0006\u0002\b\r0\u000b¢\u0006\u0002\b\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItemPresenterImpl;", "Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItemPresenter;", "Lcom/avito/android/select/new_metro/adapter/checkbox_listitem/CheckBoxListItemView;", "view", "Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/select/new_metro/adapter/checkbox_listitem/CheckBoxListItemView;Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItem;I)V", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/subjects/PublishSubject;", "valueConsumerStream", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Observable;", "getValueChangedStream", "()Lio/reactivex/rxjava3/core/Observable;", "valueChangedStream", "<init>", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroStationItemPresenterImpl implements MetroStationItemPresenter {
    public final PublishSubject<MetroStationItem> a;
    @NotNull
    public final Observable<MetroStationItem> b;

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ MetroStationItemPresenterImpl a;
        public final /* synthetic */ MetroStationItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MetroStationItemPresenterImpl metroStationItemPresenterImpl, MetroStationItem metroStationItem) {
            super(1);
            this.a = metroStationItemPresenterImpl;
            this.b = metroStationItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            this.b.setChecked(bool.booleanValue());
            this.a.a.onNext(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            bool.booleanValue();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public MetroStationItemPresenterImpl() {
        PublishSubject<MetroStationItem> create = PublishSubject.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "valueConsumerStream");
        this.b = create;
    }

    @Override // com.avito.android.select.new_metro.adapter.metro_station.MetroStationItemPresenter
    @NotNull
    public Observable<MetroStationItem> getValueChangedStream() {
        return this.b;
    }

    public void bindView(@NotNull CheckBoxListItemView checkBoxListItemView, @NotNull MetroStationItem metroStationItem, int i) {
        Intrinsics.checkNotNullParameter(checkBoxListItemView, "view");
        Intrinsics.checkNotNullParameter(metroStationItem, "item");
        checkBoxListItemView.setCheckListener(b.a);
        checkBoxListItemView.setText(metroStationItem.getShowLineColor() ? metroStationItem.getStationNameWithLineColor() : metroStationItem.getStationName());
        checkBoxListItemView.setChecked(metroStationItem.isChecked());
        checkBoxListItemView.setCheckListener(new a(this, metroStationItem));
    }
}
