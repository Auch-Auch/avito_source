package com.avito.android.publish.residential_complex_search.adapter.button;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/adapter/button/ResidentialComplexButtonPresenterImpl;", "Lcom/avito/android/publish/residential_complex_search/adapter/button/ResidentialComplexButtonPresenter;", "Lcom/avito/android/publish/residential_complex_search/adapter/button/ResidentialComplexButtonView;", "view", "Lcom/avito/android/publish/residential_complex_search/adapter/button/ResidentialComplexButtonItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/publish/residential_complex_search/adapter/button/ResidentialComplexButtonView;Lcom/avito/android/publish/residential_complex_search/adapter/button/ResidentialComplexButtonItem;I)V", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getClicks", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "setClicks", "(Lcom/avito/android/util/architecture_components/SingleLiveEvent;)V", "clicks", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ResidentialComplexButtonPresenterImpl implements ResidentialComplexButtonPresenter {
    @NotNull
    public SingleLiveEvent<ResidentialComplexButtonItem> a = new SingleLiveEvent<>();

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ResidentialComplexButtonPresenterImpl a;
        public final /* synthetic */ ResidentialComplexButtonItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ResidentialComplexButtonPresenterImpl residentialComplexButtonPresenterImpl, ResidentialComplexButtonItem residentialComplexButtonItem) {
            super(0);
            this.a = residentialComplexButtonPresenterImpl;
            this.b = residentialComplexButtonItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getClicks().postValue(this.b);
            return Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.publish.residential_complex_search.adapter.button.ResidentialComplexButtonPresenter
    @NotNull
    public SingleLiveEvent<ResidentialComplexButtonItem> getClicks() {
        return this.a;
    }

    public void setClicks(@NotNull SingleLiveEvent<ResidentialComplexButtonItem> singleLiveEvent) {
        Intrinsics.checkNotNullParameter(singleLiveEvent, "<set-?>");
        this.a = singleLiveEvent;
    }

    public void bindView(@NotNull ResidentialComplexButtonView residentialComplexButtonView, @NotNull ResidentialComplexButtonItem residentialComplexButtonItem, int i) {
        Intrinsics.checkNotNullParameter(residentialComplexButtonView, "view");
        Intrinsics.checkNotNullParameter(residentialComplexButtonItem, "item");
        residentialComplexButtonView.setClickAction(new a(this, residentialComplexButtonItem));
    }
}
