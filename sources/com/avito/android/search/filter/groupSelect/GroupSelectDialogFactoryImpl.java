package com.avito.android.search.filter.groupSelect;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.avito.android.Features;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.filter.DialogDismissListenerImpl;
import com.avito.android.search.filter.R;
import com.avito.android.select.group_select.GroupSelectView;
import com.avito.android.select.group_select.GroupSelectViewImpl;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogFactoryImpl;", "Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogFactory;", "Landroid/content/Context;", "context", "Lcom/avito/android/category_parameters/ParameterElement$Multiselect;", "item", "", "showDialog", "(Landroid/content/Context;Lcom/avito/android/category_parameters/ParameterElement$Multiselect;)V", "Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogPresenter;", "presenter", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogPresenter;Lcom/avito/android/Features;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class GroupSelectDialogFactoryImpl implements GroupSelectDialogFactory {
    public final GroupSelectDialogPresenter a;
    public final Features b;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ GroupSelectDialogFactoryImpl a;
        public final /* synthetic */ View b;

        public a(GroupSelectDialogFactoryImpl groupSelectDialogFactoryImpl, View view, ParameterElement.Multiselect multiselect, Context context) {
            this.a = groupSelectDialogFactoryImpl;
            this.b = view;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            this.a.a.unbind();
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ GroupSelectViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(GroupSelectViewImpl groupSelectViewImpl) {
            super(0);
            this.a = groupSelectViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.clearSelection();
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ BottomSheetDialog a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(BottomSheetDialog bottomSheetDialog) {
            super(1);
            this.a = bottomSheetDialog;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            this.a.setActionButtonActive(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public GroupSelectDialogFactoryImpl(@NotNull GroupSelectDialogPresenter groupSelectDialogPresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(groupSelectDialogPresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = groupSelectDialogPresenter;
        this.b = features;
    }

    @Override // com.avito.android.search.filter.groupSelect.GroupSelectDialogFactory
    public void showDialog(@NotNull Context context, @NotNull ParameterElement.Multiselect multiselect) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(multiselect, "item");
        if (this.b.getGroupSelectForInlineFilters().invoke().booleanValue()) {
            i = GroupSelectView.Companion.getLayout();
        } else {
            i = GroupSelectView.Companion.getLayoutOld();
        }
        View inflate = View.inflate(context, i, null);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, 0, 2, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.setSkipCollapsed(true);
        bottomSheetDialog.setFitContentPeekHeight(true);
        bottomSheetDialog.setHeaderParams(multiselect.getTitle(), context.getString(R.string.clear_hint), true, true);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.setOnDismissListener(new a(this, inflate, multiselect, context));
        GroupSelectViewImpl groupSelectViewImpl = new GroupSelectViewImpl(inflate);
        DialogDismissListenerImpl dialogDismissListenerImpl = new DialogDismissListenerImpl(bottomSheetDialog);
        c cVar = new c(bottomSheetDialog);
        bottomSheetDialog.setOnActionClickListener(new b(groupSelectViewImpl));
        this.a.bindView(groupSelectViewImpl, dialogDismissListenerImpl, cVar, multiselect);
        bottomSheetDialog.show();
    }
}
