package com.avito.android.select.new_metro.adapter.filter;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nRD\u0010\u0010\u001a0\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u0004 \f*\u0017\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u000b¢\u0006\u0002\b\r0\u000b¢\u0006\u0002\b\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItemPresenterImpl;", "Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItemPresenter;", "Lcom/avito/android/select/new_metro/adapter/checkbox_listitem/CheckBoxListItemView;", "view", "Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/select/new_metro/adapter/checkbox_listitem/CheckBoxListItemView;Lcom/avito/android/select/new_metro/adapter/filter/MetroFilterItem;I)V", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/subjects/PublishSubject;", "valueChangesConsumer", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Observable;", "getValueChangesStream", "()Lio/reactivex/rxjava3/core/Observable;", "valueChangesStream", "<init>", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroFilterItemPresenterImpl implements MetroFilterItemPresenter {
    public final PublishSubject<MetroFilterItem> a;
    @NotNull
    public final Observable<MetroFilterItem> b;

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ MetroFilterItemPresenterImpl a;
        public final /* synthetic */ MetroFilterItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MetroFilterItemPresenterImpl metroFilterItemPresenterImpl, MetroFilterItem metroFilterItem) {
            super(1);
            this.a = metroFilterItemPresenterImpl;
            this.b = metroFilterItem;
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
    public MetroFilterItemPresenterImpl() {
        PublishSubject<MetroFilterItem> create = PublishSubject.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "valueChangesConsumer");
        this.b = create;
    }

    @Override // com.avito.android.select.new_metro.adapter.filter.MetroFilterItemPresenter
    @NotNull
    public Observable<MetroFilterItem> getValueChangesStream() {
        return this.b;
    }

    public void bindView(@NotNull CheckBoxListItemView checkBoxListItemView, @NotNull MetroFilterItem metroFilterItem, int i) {
        Intrinsics.checkNotNullParameter(checkBoxListItemView, "view");
        Intrinsics.checkNotNullParameter(metroFilterItem, "item");
        checkBoxListItemView.setCheckListener(b.a);
        checkBoxListItemView.setText(metroFilterItem.getName());
        checkBoxListItemView.setChecked(metroFilterItem.isChecked());
        checkBoxListItemView.setCheckListener(new a(this, metroFilterItem));
    }
}
