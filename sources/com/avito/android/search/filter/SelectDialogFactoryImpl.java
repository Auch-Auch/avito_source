package com.avito.android.search.filter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.lastclick.LastClick;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.filter.adapter.SelectableItemRadioButtonBlueprint;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.list_dialog.ListDialogImpl;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/search/filter/SelectDialogFactoryImpl;", "Lcom/avito/android/search/filter/SelectDialogFactory;", "Landroid/content/Context;", "context", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "item", "", "showDialog", "(Landroid/content/Context;Lcom/avito/android/category_parameters/ParameterElement$Select;)V", "Lcom/avito/android/search/filter/adapter/SelectableItemRadioButtonBlueprint;", AuthSource.SEND_ABUSE, "Lcom/avito/android/search/filter/adapter/SelectableItemRadioButtonBlueprint;", "blueprint", "Lcom/avito/android/search/filter/SelectDialogPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/search/filter/SelectDialogPresenter;", "presenter", "<init>", "(Lcom/avito/android/search/filter/adapter/SelectableItemRadioButtonBlueprint;Lcom/avito/android/search/filter/SelectDialogPresenter;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class SelectDialogFactoryImpl implements SelectDialogFactory {
    public final SelectableItemRadioButtonBlueprint a;
    public final SelectDialogPresenter b;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ SelectDialogFactoryImpl a;

        public a(SelectDialogFactoryImpl selectDialogFactoryImpl) {
            this.a = selectDialogFactoryImpl;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            LastClick.Updater.update();
            this.a.b.unbindDialog();
        }
    }

    @Inject
    public SelectDialogFactoryImpl(@NotNull SelectableItemRadioButtonBlueprint selectableItemRadioButtonBlueprint, @NotNull SelectDialogPresenter selectDialogPresenter) {
        Intrinsics.checkNotNullParameter(selectableItemRadioButtonBlueprint, "blueprint");
        Intrinsics.checkNotNullParameter(selectDialogPresenter, "presenter");
        this.a = selectableItemRadioButtonBlueprint;
        this.b = selectDialogPresenter;
    }

    @Override // com.avito.android.search.filter.SelectDialogFactory
    public void showDialog(@NotNull Context context, @NotNull ParameterElement.Select select) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(select, "item");
        View inflate = LayoutInflater.from(context).inflate(R.layout.list_dialog, (ViewGroup) null);
        AlertDialog create = new AlertDialog.Builder(context).setView(inflate).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(cont…t).setView(view).create()");
        create.setOnDismissListener(new a(this));
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        this.b.bindDialog(new ListDialogImpl(inflate, d.listOf(this.a)), new DialogDismissListenerImpl(create), select);
        create.show();
    }
}
