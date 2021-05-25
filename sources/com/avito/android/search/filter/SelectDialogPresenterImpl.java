package com.avito.android.search.filter;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.SelectableItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.IterableDataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.button_panel.ButtonPanelsKt;
import ru.avito.component.list_dialog.ListDialog;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b$\u0010%J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aRD\u0010!\u001a0\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u000e0\u000e \u001d*\u0017\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\u001c¢\u0006\u0002\b\u001e0\u001c¢\u0006\u0002\b\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Lcom/avito/android/search/filter/SelectDialogPresenterImpl;", "Lcom/avito/android/search/filter/SelectDialogPresenter;", "Lru/avito/component/list_dialog/ListDialog;", "listDialog", "Lcom/avito/android/search/filter/DialogDismissListener;", "dismissListener", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "item", "", "bindDialog", "(Lru/avito/component/list_dialog/ListDialog;Lcom/avito/android/search/filter/DialogDismissListener;Lcom/avito/android/category_parameters/ParameterElement$Select;)V", "unbindDialog", "()V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/items/SelectableItem;", "selectableItemChangeConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/search/filter/DialogResourceProvider;", "d", "Lcom/avito/android/search/filter/DialogResourceProvider;", "resourceProvider", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "changeConsumer", "Lio/reactivex/rxjava3/disposables/Disposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "c", "Lcom/jakewharton/rxrelay3/PublishRelay;", "relay", "Lcom/avito/android/search/filter/FiltersChangeProvider;", "changeProvider", "<init>", "(Lcom/avito/android/search/filter/FiltersChangeProvider;Lcom/avito/android/search/filter/DialogResourceProvider;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class SelectDialogPresenterImpl implements SelectDialogPresenter {
    public final Consumer<ParameterElement.Select> a;
    public Disposable b;
    public final PublishRelay<SelectableItem> c = PublishRelay.create();
    public final DialogResourceProvider d;

    public static final class a<T> implements Consumer<SelectableItem> {
        public final /* synthetic */ ListDialog a;
        public final /* synthetic */ IterableDataSource b;
        public final /* synthetic */ SelectDialogPresenterImpl c;
        public final /* synthetic */ DialogDismissListener d;

        public a(ListDialog listDialog, IterableDataSource iterableDataSource, SelectDialogPresenterImpl selectDialogPresenterImpl, ParameterElement.Select select, DialogDismissListener dialogDismissListener) {
            this.a = listDialog;
            this.b = iterableDataSource;
            this.c = selectDialogPresenterImpl;
            this.d = dialogDismissListener;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SelectableItem selectableItem) {
            SelectableItem selectableItem2 = selectableItem;
            SelectDialogPresenterImpl selectDialogPresenterImpl = this.c;
            ListDialog listDialog = this.a;
            Intrinsics.checkNotNullExpressionValue(selectableItem2, "selectableItem");
            SelectDialogPresenterImpl.access$onSelectableItemStatusChanged(selectDialogPresenterImpl, listDialog, selectableItem2, this.b);
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ IterableDataSource a;
        public final /* synthetic */ SelectDialogPresenterImpl b;
        public final /* synthetic */ ParameterElement.Select c;
        public final /* synthetic */ DialogDismissListener d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(IterableDataSource iterableDataSource, SelectDialogPresenterImpl selectDialogPresenterImpl, ParameterElement.Select select, DialogDismissListener dialogDismissListener) {
            super(0);
            this.a = iterableDataSource;
            this.b = selectDialogPresenterImpl;
            this.c = select;
            this.d = dialogDismissListener;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            SelectDialogPresenterImpl selectDialogPresenterImpl = this.b;
            SelectDialogPresenterImpl.access$updateSelectedValue(selectDialogPresenterImpl, this.c, SelectDialogPresenterImpl.access$getSelectedItemId(selectDialogPresenterImpl, this.a));
            this.b.a.accept(this.c);
            this.d.dismiss();
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DialogDismissListener a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SelectDialogPresenterImpl selectDialogPresenterImpl, ParameterElement.Select select, DialogDismissListener dialogDismissListener) {
            super(0);
            this.a = dialogDismissListener;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.dismiss();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public SelectDialogPresenterImpl(@NotNull FiltersChangeProvider filtersChangeProvider, @NotNull DialogResourceProvider dialogResourceProvider) {
        Intrinsics.checkNotNullParameter(filtersChangeProvider, "changeProvider");
        Intrinsics.checkNotNullParameter(dialogResourceProvider, "resourceProvider");
        this.d = dialogResourceProvider;
        this.a = filtersChangeProvider.getSelectChangeConsumer();
    }

    public static final String access$getSelectedItemId(SelectDialogPresenterImpl selectDialogPresenterImpl, IterableDataSource iterableDataSource) {
        Object obj;
        Objects.requireNonNull(selectDialogPresenterImpl);
        Sequence filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(iterableDataSource), SelectDialogPresenterImpl$getSelectedItem$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        Iterator it = filter.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SelectableItem) obj).isSelected()) {
                break;
            }
        }
        SelectableItem selectableItem = (SelectableItem) obj;
        if (selectableItem != null) {
            return selectableItem.getStringId();
        }
        return null;
    }

    public static final void access$onSelectableItemStatusChanged(SelectDialogPresenterImpl selectDialogPresenterImpl, ListDialog listDialog, SelectableItem selectableItem, IterableDataSource iterableDataSource) {
        Objects.requireNonNull(selectDialogPresenterImpl);
        if (selectableItem.isSelected()) {
            Sequence filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(iterableDataSource), SelectDialogPresenterImpl$onSelectableItemStatusChanged$$inlined$filterIsInstance$1.INSTANCE);
            Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
            Iterator it = filter.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                Object next = it.next();
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                SelectableItem selectableItem2 = (SelectableItem) next;
                if (selectableItem2.getId() != selectableItem.getId() && selectableItem2.isSelected()) {
                    break;
                }
                i++;
            }
            if (i != -1) {
                Item item = (Item) iterableDataSource.getItem(i);
                if (item instanceof SelectableItem) {
                    ((SelectableItem) item).setSelected(false);
                    listDialog.notifyItemChanged(i);
                }
            }
            ButtonPanelsKt.enablePrimaryButton(listDialog);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$updateSelectedValue(SelectDialogPresenterImpl selectDialogPresenterImpl, ParameterElement.Select select, String str) {
        Objects.requireNonNull(selectDialogPresenterImpl);
        SelectableItem selectableItem = null;
        if (str != null) {
            Sequence filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(select.getItemsToShow()), SelectDialogPresenterImpl$$special$$inlined$filterIsInstance$1.INSTANCE);
            Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
            Iterator it = filter.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((SelectableItem) next).getStringId(), str)) {
                    selectableItem = next;
                    break;
                }
            }
            selectableItem = selectableItem;
        }
        select.setSelectedValue(selectableItem);
    }

    @Override // com.avito.android.search.filter.SelectDialogPresenter
    public void bindDialog(@NotNull ListDialog listDialog, @NotNull DialogDismissListener dialogDismissListener, @NotNull ParameterElement.Select select) {
        Intrinsics.checkNotNullParameter(listDialog, "listDialog");
        Intrinsics.checkNotNullParameter(dialogDismissListener, "dismissListener");
        Intrinsics.checkNotNullParameter(select, "item");
        List<Item> itemsToShow = select.getItemsToShow();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(itemsToShow, 10));
        for (T t : itemsToShow) {
            if (t instanceof SelectableItem) {
                t = SelectableItem.copy$default(t, null, null, Intrinsics.areEqual(select.getSelectedValue(), t), null, 11, null);
            }
            arrayList.add(t);
        }
        ListDataSource listDataSource = new ListDataSource(arrayList);
        this.b = this.c.subscribe(new a(listDialog, listDataSource, this, select, dialogDismissListener));
        listDialog.setTitle(select.getTitle());
        listDialog.setDataSource(listDataSource);
        listDialog.setPrimaryButtonText(this.d.getPositiveButtonText());
        listDialog.setSecondaryButtonText(this.d.getNegativeButtonText());
        listDialog.setPrimaryButtonEnabled(select.getSelectedValue() != null);
        listDialog.setPrimaryClickListener(new b(listDataSource, this, select, dialogDismissListener));
        listDialog.setSecondaryClickListener(new c(this, select, dialogDismissListener));
    }

    @Override // com.avito.android.search.filter.SelectDialogPresenter
    @NotNull
    public Consumer<SelectableItem> selectableItemChangeConsumer() {
        PublishRelay<SelectableItem> publishRelay = this.c;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "relay");
        return publishRelay;
    }

    @Override // com.avito.android.search.filter.SelectDialogPresenter
    public void unbindDialog() {
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
