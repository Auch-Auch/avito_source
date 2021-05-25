package com.avito.android.publish.date_picker;

import android.content.Context;
import android.view.View;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.button.Button;
import com.avito.android.publish.R;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.util.Date;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001bBI\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/publish/date_picker/DatePickerSheetDialog;", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "", VKApiConst.VERSION, "Ljava/lang/Long;", "delimiterStart", "Lcom/avito/android/publish/date_picker/DatePickerSheetDialog$DialogResources;", "t", "Lcom/avito/android/publish/date_picker/DatePickerSheetDialog$DialogResources;", "dialogResources", "Lcom/avito/android/publish/date_picker/DatePicker;", "s", "Lcom/avito/android/publish/date_picker/DatePicker;", "datePicker", "u", "value", "Lkotlin/Function1;", "", "x", "Lkotlin/jvm/functions/Function1;", "onCloseCallback", "w", "delimiterEnd", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/publish/date_picker/DatePickerSheetDialog$DialogResources;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "DialogResources", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class DatePickerSheetDialog extends BottomSheetDialog {
    public DatePicker s;
    public final DialogResources t;
    public final Long u;
    public final Long v;
    public final Long w;
    public final Function1<Long, Unit> x;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/date_picker/DatePickerSheetDialog$DialogResources;", "", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getContinueButtonText", "()Ljava/lang/String;", "continueButtonText", AuthSource.SEND_ABUSE, "getTitle", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class DialogResources {
        @NotNull
        public final String a;
        @NotNull
        public final String b;

        public DialogResources(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "continueButtonText");
            this.a = str;
            this.b = str2;
        }

        @NotNull
        public final String getContinueButtonText() {
            return this.b;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DatePickerSheetDialog(@NotNull Context context, @NotNull DialogResources dialogResources, @Nullable Long l, @Nullable Long l2, @Nullable Long l3, @NotNull Function1<? super Long, Unit> function1) {
        super(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dialogResources, "dialogResources");
        Intrinsics.checkNotNullParameter(function1, "onCloseCallback");
        this.t = dialogResources;
        this.u = l;
        this.v = l2;
        this.w = l3;
        this.x = function1;
        BottomSheetDialog.setContentView$default(this, R.layout.date_picker_dialog, R.layout.bottom_sheet_button, new Function1<View, Unit>(this) { // from class: com.avito.android.publish.date_picker.DatePickerSheetDialog.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(View view) {
                View view2 = view;
                Intrinsics.checkNotNullParameter(view2, "p1");
                DatePickerSheetDialog.access$setupContentView((DatePickerSheetDialog) this.receiver, view2);
                return Unit.INSTANCE;
            }
        }, new Function1<View, Unit>(this) { // from class: com.avito.android.publish.date_picker.DatePickerSheetDialog.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(View view) {
                View view2 = view;
                Intrinsics.checkNotNullParameter(view2, "p1");
                DatePickerSheetDialog.access$setupFooterView((DatePickerSheetDialog) this.receiver, view2);
                return Unit.INSTANCE;
            }
        }, false, 16, null);
        setFitContentPeekHeight(true);
        BottomSheetDialog.setHeaderParams$default(this, dialogResources.getTitle(), null, true, false, 10, null);
        setCancelable(true);
        setSkipCollapsed(true);
        setCanceledOnTouchOutside(true);
        setShowOnStart(false);
    }

    public static final /* synthetic */ DatePicker access$getDatePicker$p(DatePickerSheetDialog datePickerSheetDialog) {
        DatePicker datePicker = datePickerSheetDialog.s;
        if (datePicker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("datePicker");
        }
        return datePicker;
    }

    public static final void access$setupContentView(DatePickerSheetDialog datePickerSheetDialog, View view) {
        Long l = datePickerSheetDialog.u;
        datePickerSheetDialog.s = new MonthAndYearPicker(view, l != null ? l.longValue() : new Date().getTime(), datePickerSheetDialog.v, datePickerSheetDialog.w);
    }

    public static final void access$setupFooterView(DatePickerSheetDialog datePickerSheetDialog, View view) {
        Objects.requireNonNull(datePickerSheetDialog);
        View findViewById = view.findViewById(R.id.main_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.main_button)");
        Button button = (Button) findViewById;
        button.setText(datePickerSheetDialog.t.getContinueButtonText());
        button.setOnClickListener(new a2.a.a.e2.q.a(datePickerSheetDialog));
    }
}
