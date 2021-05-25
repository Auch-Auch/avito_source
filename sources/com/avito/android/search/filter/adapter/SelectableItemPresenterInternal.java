package com.avito.android.search.filter.adapter;

import com.avito.android.items.SelectableItem;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/search/filter/adapter/SelectableItemPresenterInternal;", "Lcom/avito/android/search/filter/adapter/SelectableItemPresenter;", "Lcom/avito/android/search/filter/adapter/SelectableItemView;", "view", "Lcom/avito/android/items/SelectableItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/search/filter/adapter/SelectableItemView;Lcom/avito/android/items/SelectableItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "changeConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public abstract class SelectableItemPresenterInternal implements SelectableItemPresenter {
    public final Consumer<SelectableItem> a;

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ SelectableItemPresenterInternal a;
        public final /* synthetic */ SelectableItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SelectableItemPresenterInternal selectableItemPresenterInternal, SelectableItem selectableItem) {
            super(1);
            this.a = selectableItemPresenterInternal;
            this.b = selectableItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            this.b.setSelected(bool.booleanValue());
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    public SelectableItemPresenterInternal(@NotNull Consumer<SelectableItem> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "changeConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull SelectableItemView selectableItemView, @NotNull SelectableItem selectableItem, int i) {
        Intrinsics.checkNotNullParameter(selectableItemView, "view");
        Intrinsics.checkNotNullParameter(selectableItem, "item");
        selectableItemView.setOnSelectedChangeListener(null);
        selectableItemView.setTitle(selectableItem.getTitle());
        selectableItemView.setSelected(selectableItem.isSelected());
        selectableItemView.setColor(selectableItem.getColor());
        selectableItemView.setOnSelectedChangeListener(new a(this, selectableItem));
    }
}
