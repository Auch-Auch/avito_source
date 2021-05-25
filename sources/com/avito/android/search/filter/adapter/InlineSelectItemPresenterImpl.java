package com.avito.android.search.filter.adapter;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.SelectableItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.filter.FiltersChangeProvider;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/search/filter/adapter/InlineSelectItemPresenterImpl;", "Lcom/avito/android/search/filter/adapter/InlineSelectItemPresenter;", "Lcom/avito/android/search/filter/adapter/InlineSelectItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/search/filter/adapter/InlineSelectItemView;Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/category_parameters/ParameterElement$Select;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "changeConsumer", "Lcom/avito/android/search/filter/FiltersChangeProvider;", "changeProvider", "<init>", "(Lcom/avito/android/search/filter/FiltersChangeProvider;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class InlineSelectItemPresenterImpl implements InlineSelectItemPresenter {
    public final Consumer<ParameterElement.Select> a;

    public static final class a extends Lambda implements Function2<SelectableItem, Boolean, Unit> {
        public final /* synthetic */ InlineSelectItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Select.Flat b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InlineSelectItemPresenterImpl inlineSelectItemPresenterImpl, ParameterElement.Select.Flat flat) {
            super(2);
            this.a = inlineSelectItemPresenterImpl;
            this.b = flat;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(SelectableItem selectableItem, Boolean bool) {
            SelectableItem selectableItem2 = selectableItem;
            boolean booleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(selectableItem2, "value");
            if (booleanValue) {
                this.b.setSelectedValue(selectableItem2);
                this.a.a.accept(this.b);
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public InlineSelectItemPresenterImpl(@NotNull FiltersChangeProvider filtersChangeProvider) {
        Intrinsics.checkNotNullParameter(filtersChangeProvider, "changeProvider");
        this.a = filtersChangeProvider.getSelectChangeConsumer();
    }

    public void bindView(@NotNull InlineSelectItemView inlineSelectItemView, @NotNull ParameterElement.Select.Flat flat, int i) {
        Intrinsics.checkNotNullParameter(inlineSelectItemView, "view");
        Intrinsics.checkNotNullParameter(flat, "item");
        inlineSelectItemView.setTitle(flat.getTitle());
        inlineSelectItemView.setValues(flat.getValues(), flat.getSelectedValue(), new a(this, flat));
    }
}
