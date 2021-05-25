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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/avito/android/search/filter/adapter/InlineMultiselectItemPresenterImpl;", "Lcom/avito/android/search/filter/adapter/InlineMultiselectItemPresenter;", "Lcom/avito/android/search/filter/adapter/InlineMultiselectItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Multiselect;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/search/filter/adapter/InlineMultiselectItemView;Lcom/avito/android/category_parameters/ParameterElement$Multiselect;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "changeConsumer", "Lcom/avito/android/search/filter/FiltersChangeProvider;", "changeProvider", "<init>", "(Lcom/avito/android/search/filter/FiltersChangeProvider;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class InlineMultiselectItemPresenterImpl implements InlineMultiselectItemPresenter {
    public final Consumer<ParameterElement.Multiselect> a;

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ SelectableItem a;
        public final /* synthetic */ InlineMultiselectItemView b;
        public final /* synthetic */ InlineMultiselectItemPresenterImpl c;
        public final /* synthetic */ ParameterElement.Multiselect d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SelectableItem selectableItem, InlineMultiselectItemView inlineMultiselectItemView, InlineMultiselectItemPresenterImpl inlineMultiselectItemPresenterImpl, ParameterElement.Multiselect multiselect) {
            super(1);
            this.a = selectableItem;
            this.b = inlineMultiselectItemView;
            this.c = inlineMultiselectItemPresenterImpl;
            this.d = multiselect;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            this.a.setSelected(bool.booleanValue());
            this.c.a.accept(this.d);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public InlineMultiselectItemPresenterImpl(@NotNull FiltersChangeProvider filtersChangeProvider) {
        Intrinsics.checkNotNullParameter(filtersChangeProvider, "changeProvider");
        this.a = filtersChangeProvider.getMultiselectChangeConsumer();
    }

    public void bindView(@NotNull InlineMultiselectItemView inlineMultiselectItemView, @NotNull ParameterElement.Multiselect multiselect, int i) {
        Intrinsics.checkNotNullParameter(inlineMultiselectItemView, "view");
        Intrinsics.checkNotNullParameter(multiselect, "item");
        inlineMultiselectItemView.setTitle(multiselect.getTitle());
        inlineMultiselectItemView.removeOptions();
        for (T t : multiselect.getValues()) {
            inlineMultiselectItemView.addOption(t.getTitle(), t.isSelected(), new a(t, inlineMultiselectItemView, this, multiselect));
        }
    }
}
