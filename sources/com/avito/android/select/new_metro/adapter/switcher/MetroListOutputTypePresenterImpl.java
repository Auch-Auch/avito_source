package com.avito.android.select.new_metro.adapter.switcher;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypeItem;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fRD\u0010\u0016\u001a0\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00040\u0004 \u0012*\u0017\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0011¢\u0006\u0002\b\u00130\u0011¢\u0006\u0002\b\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypePresenterImpl;", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypePresenter;", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeView;", "view", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeView;Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem;I)V", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Observable;", "getValueChangedStream", "()Lio/reactivex/rxjava3/core/Observable;", "valueChangedStream", "Lio/reactivex/rxjava3/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/subjects/PublishSubject;", "outputTypeChangedObservable", "<init>", "()V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroListOutputTypePresenterImpl implements MetroListOutputTypePresenter {
    public final PublishSubject<MetroListOutputTypeItem> a;
    @NotNull
    public final Observable<MetroListOutputTypeItem> b;

    public static final class a extends Lambda implements Function1<MetroListOutputTypeItem.OutputType, Unit> {
        public final /* synthetic */ MetroListOutputTypePresenterImpl a;
        public final /* synthetic */ MetroListOutputTypeItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MetroListOutputTypePresenterImpl metroListOutputTypePresenterImpl, MetroListOutputTypeItem metroListOutputTypeItem) {
            super(1);
            this.a = metroListOutputTypePresenterImpl;
            this.b = metroListOutputTypeItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MetroListOutputTypeItem.OutputType outputType) {
            MetroListOutputTypeItem.OutputType outputType2 = outputType;
            Intrinsics.checkNotNullParameter(outputType2, "it");
            this.b.setSelectedType(outputType2);
            this.a.a.onNext(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<MetroListOutputTypeItem.OutputType, Unit> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MetroListOutputTypeItem.OutputType outputType) {
            Intrinsics.checkNotNullParameter(outputType, "it");
            return Unit.INSTANCE;
        }
    }

    @Inject
    public MetroListOutputTypePresenterImpl() {
        PublishSubject<MetroListOutputTypeItem> create = PublishSubject.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "outputTypeChangedObservable");
        this.b = create;
    }

    @Override // com.avito.android.select.new_metro.adapter.switcher.MetroListOutputTypePresenter
    @NotNull
    public Observable<MetroListOutputTypeItem> getValueChangedStream() {
        return this.b;
    }

    public void bindView(@NotNull MetroListOutputTypeView metroListOutputTypeView, @NotNull MetroListOutputTypeItem metroListOutputTypeItem, int i) {
        Intrinsics.checkNotNullParameter(metroListOutputTypeView, "view");
        Intrinsics.checkNotNullParameter(metroListOutputTypeItem, "item");
        metroListOutputTypeView.setStateChangedListener(b.a);
        metroListOutputTypeView.setState(metroListOutputTypeItem.getSelectedType());
        metroListOutputTypeView.setStateChangedListener(new a(this, metroListOutputTypeItem));
    }
}
