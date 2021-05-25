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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/avito/android/search/filter/adapter/MultiselectItemPresenterImpl;", "Lcom/avito/android/search/filter/adapter/MultiselectItemPresenter;", "Lcom/avito/android/search/filter/adapter/SelectItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Multiselect;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/search/filter/adapter/SelectItemView;Lcom/avito/android/category_parameters/ParameterElement$Multiselect;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/functions/Consumer;", "clearConsumer", AuthSource.SEND_ABUSE, "clickConsumer", "Lcom/avito/android/search/filter/FiltersChangeProvider;", GeoContract.PROVIDER, "<init>", "(Lcom/avito/android/search/filter/FiltersChangeProvider;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class MultiselectItemPresenterImpl implements MultiselectItemPresenter {
    public final Consumer<ParameterElement.Multiselect> a;
    public final Consumer<ParameterElement.Multiselect> b;

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
                ((MultiselectItemPresenterImpl) this.b).a.accept((ParameterElement.Multiselect) this.c);
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((MultiselectItemPresenterImpl) this.b).b.accept((ParameterElement.Multiselect) this.c);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    @Inject
    public MultiselectItemPresenterImpl(@NotNull FiltersChangeProvider filtersChangeProvider) {
        Intrinsics.checkNotNullParameter(filtersChangeProvider, GeoContract.PROVIDER);
        this.a = filtersChangeProvider.getMultiselectClickConsumer();
        this.b = filtersChangeProvider.getMultiselectClearConsumer();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.search.filter.adapter.SelectItemView r3, @org.jetbrains.annotations.NotNull com.avito.android.category_parameters.ParameterElement.Multiselect r4, int r5) {
        /*
            r2 = this;
            java.lang.String r5 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
            java.lang.String r5 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            boolean r5 = r4.isRequired()
            r0 = 0
            r1 = 1
            if (r5 != 0) goto L_0x0026
            java.lang.String r5 = r4.getValue()
            if (r5 == 0) goto L_0x0021
            int r5 = r5.length()
            if (r5 != 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r5 = 0
            goto L_0x0022
        L_0x0021:
            r5 = 1
        L_0x0022:
            if (r5 != 0) goto L_0x0026
            r5 = 1
            goto L_0x0027
        L_0x0026:
            r5 = 0
        L_0x0027:
            r3.setClearButtonVisible(r5)
            java.lang.String r5 = r4.getTitle()
            r3.setTitle(r5)
            java.lang.String r5 = r4.getValue()
            r3.setValue(r5)
            boolean r5 = r4.isRemovableOnly()
            if (r5 == 0) goto L_0x0042
            r3.removeOnClickListener()
            goto L_0x004a
        L_0x0042:
            com.avito.android.search.filter.adapter.MultiselectItemPresenterImpl$a r5 = new com.avito.android.search.filter.adapter.MultiselectItemPresenterImpl$a
            r5.<init>(r0, r2, r4)
            r3.setOnClickListener(r5)
        L_0x004a:
            com.avito.android.search.filter.adapter.MultiselectItemPresenterImpl$a r5 = new com.avito.android.search.filter.adapter.MultiselectItemPresenterImpl$a
            r5.<init>(r1, r2, r4)
            r3.setOnClearListener(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.filter.adapter.MultiselectItemPresenterImpl.bindView(com.avito.android.search.filter.adapter.SelectItemView, com.avito.android.category_parameters.ParameterElement$Multiselect, int):void");
    }
}
