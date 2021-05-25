package com.avito.android.search.filter.adapter;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.filter.FiltersChangeProvider;
import com.avito.android.util.preferences.GeoContract;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/avito/android/search/filter/adapter/SelectItemPresenterImpl;", "Lcom/avito/android/search/filter/adapter/SelectItemPresenter;", "Lcom/avito/android/search/filter/adapter/SelectItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/search/filter/adapter/SelectItemView;Lcom/avito/android/category_parameters/ParameterElement$Select;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clickConsumer", AuthSource.BOOKING_ORDER, "clearConsumer", "Lcom/avito/android/search/filter/FiltersChangeProvider;", GeoContract.PROVIDER, "<init>", "(Lcom/avito/android/search/filter/FiltersChangeProvider;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class SelectItemPresenterImpl implements SelectItemPresenter {
    public final Consumer<ParameterElement.Select> a;
    public final Consumer<ParameterElement.Select> b;

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
            if (i == 0) {
                ((SelectItemPresenterImpl) this.b).a.accept((ParameterElement.Select) this.c);
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((SelectItemPresenterImpl) this.b).b.accept((ParameterElement.Select) this.c);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    @Inject
    public SelectItemPresenterImpl(@NotNull FiltersChangeProvider filtersChangeProvider) {
        Intrinsics.checkNotNullParameter(filtersChangeProvider, GeoContract.PROVIDER);
        this.a = filtersChangeProvider.getSelectClickConsumer();
        this.b = filtersChangeProvider.getSelectClearConsumer();
    }

    public void bindView(@NotNull SelectItemView selectItemView, @NotNull ParameterElement.Select select, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(selectItemView, "view");
        Intrinsics.checkNotNullParameter(select, "item");
        if (select.getClearEnabled()) {
            if (!select.isRequired()) {
                String value = select.getValue();
                if (!(value == null || value.length() == 0)) {
                    z = true;
                    selectItemView.setClearButtonVisible(z);
                }
            }
            z = false;
            selectItemView.setClearButtonVisible(z);
        } else {
            selectItemView.setClearButtonVisible(false);
        }
        selectItemView.setTitle(select.getTitle());
        selectItemView.setValue(select.getValue());
        selectItemView.setOnClickListener(new a(0, this, select));
        selectItemView.setOnClearListener(new a(1, this, select));
    }
}
