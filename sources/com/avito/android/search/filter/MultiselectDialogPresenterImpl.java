package com.avito.android.search.filter;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.SelectableItem;
import com.avito.android.remote.auth.AuthSource;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.list_dialog.ListDialog;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b'\u0010(J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\b*\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bRD\u0010\"\u001a0\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\f0\f \u001e*\u0017\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\f0\f\u0018\u00010\u001d¢\u0006\u0002\b\u001f0\u001d¢\u0006\u0002\b\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010#¨\u0006)"}, d2 = {"Lcom/avito/android/search/filter/MultiselectDialogPresenterImpl;", "Lcom/avito/android/search/filter/MultiselectDialogPresenter;", "Lru/avito/component/list_dialog/ListDialog;", "listDialog", "Lcom/avito/android/search/filter/DialogDismissListener;", "dismissListener", "Lcom/avito/android/category_parameters/ParameterElement$Multiselect;", "item", "", "bindDialog", "(Lru/avito/component/list_dialog/ListDialog;Lcom/avito/android/search/filter/DialogDismissListener;Lcom/avito/android/category_parameters/ParameterElement$Multiselect;)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/items/SelectableItem;", "selectableItemChangeConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "unbindDialog", "()V", "Lcom/avito/konveyor/data_source/IterableDataSource;", "items", AuthSource.SEND_ABUSE, "(Lru/avito/component/list_dialog/ListDialog;Lcom/avito/konveyor/data_source/IterableDataSource;)V", "Lcom/avito/android/search/filter/DialogResourceProvider;", "d", "Lcom/avito/android/search/filter/DialogResourceProvider;", "resourceProvider", "Lio/reactivex/rxjava3/disposables/Disposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "c", "Lcom/jakewharton/rxrelay3/PublishRelay;", "relay", "Lio/reactivex/rxjava3/functions/Consumer;", "changeConsumer", "Lcom/avito/android/search/filter/FiltersChangeProvider;", "changeProvider", "<init>", "(Lcom/avito/android/search/filter/FiltersChangeProvider;Lcom/avito/android/search/filter/DialogResourceProvider;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class MultiselectDialogPresenterImpl implements MultiselectDialogPresenter {
    public final Consumer<ParameterElement.Multiselect> a;
    public Disposable b;
    public final PublishRelay<SelectableItem> c = PublishRelay.create();
    public final DialogResourceProvider d;

    public static final class a<T> implements Consumer<SelectableItem> {
        public final /* synthetic */ ListDialog a;
        public final /* synthetic */ IterableDataSource b;
        public final /* synthetic */ MultiselectDialogPresenterImpl c;
        public final /* synthetic */ DialogDismissListener d;

        public a(ListDialog listDialog, IterableDataSource iterableDataSource, MultiselectDialogPresenterImpl multiselectDialogPresenterImpl, ParameterElement.Multiselect multiselect, DialogDismissListener dialogDismissListener) {
            this.a = listDialog;
            this.b = iterableDataSource;
            this.c = multiselectDialogPresenterImpl;
            this.d = dialogDismissListener;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SelectableItem selectableItem) {
            this.c.a(this.a, this.b);
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ IterableDataSource a;
        public final /* synthetic */ MultiselectDialogPresenterImpl b;
        public final /* synthetic */ ParameterElement.Multiselect c;
        public final /* synthetic */ DialogDismissListener d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(IterableDataSource iterableDataSource, MultiselectDialogPresenterImpl multiselectDialogPresenterImpl, ParameterElement.Multiselect multiselect, DialogDismissListener dialogDismissListener) {
            super(0);
            this.a = iterableDataSource;
            this.b = multiselectDialogPresenterImpl;
            this.c = multiselect;
            this.d = dialogDismissListener;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            MultiselectDialogPresenterImpl.access$updateValues(this.b, this.c, this.a);
            this.b.a.accept(this.c);
            this.d.dismiss();
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DialogDismissListener a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(MultiselectDialogPresenterImpl multiselectDialogPresenterImpl, ParameterElement.Multiselect multiselect, DialogDismissListener dialogDismissListener) {
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
    public MultiselectDialogPresenterImpl(@NotNull FiltersChangeProvider filtersChangeProvider, @NotNull DialogResourceProvider dialogResourceProvider) {
        Intrinsics.checkNotNullParameter(filtersChangeProvider, "changeProvider");
        Intrinsics.checkNotNullParameter(dialogResourceProvider, "resourceProvider");
        this.d = dialogResourceProvider;
        this.a = filtersChangeProvider.getMultiselectChangeConsumer();
    }

    public static final void access$updateValues(MultiselectDialogPresenterImpl multiselectDialogPresenterImpl, ParameterElement.Multiselect multiselect, IterableDataSource iterableDataSource) {
        Objects.requireNonNull(multiselectDialogPresenterImpl);
        List<SelectableItem> values = multiselect.getValues();
        Iterator<T> it = values.iterator();
        Iterator it2 = iterableDataSource.iterator();
        ArrayList arrayList = new ArrayList(Math.min(e.collectionSizeOrDefault(values, 10), e.collectionSizeOrDefault(iterableDataSource, 10)));
        while (it.hasNext() && it2.hasNext()) {
            it.next().setSelected(((SelectableItem) it2.next()).isSelected());
            arrayList.add(Unit.INSTANCE);
        }
    }

    public final void a(ListDialog listDialog, IterableDataSource<SelectableItem> iterableDataSource) {
        SelectableItem selectableItem;
        Iterator<SelectableItem> it = iterableDataSource.iterator();
        while (true) {
            if (!it.hasNext()) {
                selectableItem = null;
                break;
            }
            selectableItem = it.next();
            if (selectableItem.isSelected()) {
                break;
            }
        }
        listDialog.setPrimaryButtonEnabled(selectableItem != null);
    }

    @Override // com.avito.android.search.filter.MultiselectDialogPresenter
    public void bindDialog(@NotNull ListDialog listDialog, @NotNull DialogDismissListener dialogDismissListener, @NotNull ParameterElement.Multiselect multiselect) {
        Intrinsics.checkNotNullParameter(listDialog, "listDialog");
        Intrinsics.checkNotNullParameter(dialogDismissListener, "dismissListener");
        Intrinsics.checkNotNullParameter(multiselect, "item");
        List<SelectableItem> values = multiselect.getValues();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(values, 10));
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            arrayList.add(SelectableItem.copy$default(it.next(), null, null, false, null, 15, null));
        }
        ListDataSource listDataSource = new ListDataSource(arrayList);
        this.b = this.c.subscribe(new a(listDialog, listDataSource, this, multiselect, dialogDismissListener));
        listDialog.setTitle(multiselect.getTitle());
        listDialog.setDataSource(listDataSource);
        listDialog.setPrimaryButtonText(this.d.getPositiveButtonText());
        listDialog.setSecondaryButtonText(this.d.getNegativeButtonText());
        a(listDialog, listDataSource);
        listDialog.setPrimaryClickListener(new b(listDataSource, this, multiselect, dialogDismissListener));
        listDialog.setSecondaryClickListener(new c(this, multiselect, dialogDismissListener));
    }

    @Override // com.avito.android.search.filter.MultiselectDialogPresenter
    @NotNull
    public Consumer<SelectableItem> selectableItemChangeConsumer() {
        PublishRelay<SelectableItem> publishRelay = this.c;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "relay");
        return publishRelay;
    }

    @Override // com.avito.android.search.filter.MultiselectDialogPresenter
    public void unbindDialog() {
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
