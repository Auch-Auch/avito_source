package com.avito.android.job.interview.pickers;

import android.content.Context;
import android.view.View;
import com.avito.android.job.interview.Action;
import com.avito.android.job.interview.R;
import com.avito.android.job.interview.domain.DateEntry;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.bottom_sheet.RightCrossHeaderKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.picker.Picker;
import com.avito.android.lib.design.picker.WheelData;
import com.avito.android.lib.design.picker.WheelGravity;
import com.avito.android.lib.design.picker.WheelStyle;
import com.avito.android.remote.model.category_parameters.FormattedDateDisplayingType;
import com.avito.android.util.Views;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Calendar;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/avito/android/job/interview/pickers/DatePickerDialog;", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "Lcom/avito/android/job/interview/domain/DateEntry;", "t", "Lcom/avito/android/job/interview/domain/DateEntry;", "dateEntry", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "s", "Ljava/util/Calendar;", FormattedDateDisplayingType.TYPE_CALENDAR, "Landroid/content/Context;", "context", "", "pos", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/job/interview/Action;", "actionConsumer", "<init>", "(Landroid/content/Context;ILio/reactivex/rxjava3/functions/Consumer;Lcom/avito/android/job/interview/domain/DateEntry;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
public final class DatePickerDialog extends BottomSheetDialog {
    public final Calendar s;
    public final DateEntry t;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Button a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DatePickerDialog datePickerDialog, Button button) {
            super(0);
            this.a = button;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Views.disable(this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function2<WheelData<?>, WheelData<?>, Unit> {
        public final /* synthetic */ Picker a;
        public final /* synthetic */ WheelData b;
        public final /* synthetic */ WheelData c;
        public final /* synthetic */ WheelData d;
        public final /* synthetic */ DatePickerDialog e;
        public final /* synthetic */ Button f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Picker picker, WheelData wheelData, WheelData wheelData2, WheelData wheelData3, DatePickerDialog datePickerDialog, Button button) {
            super(2);
            this.a = picker;
            this.b = wheelData;
            this.c = wheelData2;
            this.d = wheelData3;
            this.e = datePickerDialog;
            this.f = button;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(WheelData<?> wheelData, WheelData<?> wheelData2) {
            WheelData<?> wheelData3 = wheelData;
            WheelData<?> wheelData4 = wheelData2;
            if (!(!Intrinsics.areEqual(wheelData3, this.b)) && !(!Intrinsics.areEqual(wheelData4, this.c))) {
                DatePickerDialog.access$verifyDate(this.e, this.a, wheelData3, wheelData4, this.d, this.f);
                this.a.clearOnSelection();
                this.a.setOnSelection(new a2.a.a.j1.b.j.a(this));
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ DatePickerDialog a;
        public final /* synthetic */ Picker b;
        public final /* synthetic */ Consumer c;
        public final /* synthetic */ int d;

        public c(DatePickerDialog datePickerDialog, Picker picker, Consumer consumer, int i) {
            this.a = datePickerDialog;
            this.b = picker;
            this.c = consumer;
            this.d = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WheelData<?> firstWheelValue = this.b.getFirstWheelValue();
            Objects.requireNonNull(firstWheelValue, "null cannot be cast to non-null type com.avito.android.lib.design.picker.WheelData<kotlin.Int>");
            WheelData<?> secondWheelValue = this.b.getSecondWheelValue();
            Objects.requireNonNull(secondWheelValue, "null cannot be cast to non-null type com.avito.android.lib.design.picker.WheelData<kotlin.Int>");
            int i = this.a.s.get(1);
            Consumer consumer = this.c;
            int i2 = this.d;
            consumer.accept(new Action.DateChanged(i2, firstWheelValue.getName() + ' ' + secondWheelValue.getName() + ' ' + i, ((Number) firstWheelValue.getKey()).intValue(), ((Number) secondWheelValue.getKey()).intValue()));
            this.a.dismiss();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DatePickerDialog(@NotNull Context context, int i, @NotNull Consumer<Action> consumer, @NotNull DateEntry dateEntry) {
        super(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(consumer, "actionConsumer");
        Intrinsics.checkNotNullParameter(dateEntry, "dateEntry");
        this.t = dateEntry;
        Calendar instance = Calendar.getInstance();
        instance.set(2, dateEntry.getMonth());
        instance.set(5, dateEntry.getDay());
        Unit unit = Unit.INSTANCE;
        this.s = instance;
        setContentView(R.layout.interview_invitation_date_picker, true);
        String string = context.getString(R.string.interview_invitation_time_picker_title);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…tation_time_picker_title)");
        RightCrossHeaderKt.setRightCrossHeader(this, string, true, true);
        setFitContentPeekHeight(true);
        View findViewById = findViewById(R.id.apply);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        Button button = (Button) findViewById;
        View findViewById2 = findViewById(R.id.date_picker);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(id)");
        Picker picker = (Picker) findViewById2;
        WheelData.Companion companion = WheelData.Companion;
        picker.addWheel(companion.getDates(), new WheelStyle(WheelGravity.RIGHT, false, 0, 6, null));
        picker.addWheel(companion.getMonthsLowerCase(), new WheelStyle(WheelGravity.LEFT, false, 0, 6, null));
        WheelData<?> wheelData = companion.getDates().get(instance.get(5) - 1);
        Intrinsics.checkNotNullExpressionValue(wheelData, "WheelData.dates[calendar…lendar.DAY_OF_MONTH) - 1]");
        WheelData<?> wheelData2 = wheelData;
        WheelData<?> wheelData3 = companion.getMonthsLowerCase().get(instance.get(2));
        Intrinsics.checkNotNullExpressionValue(wheelData3, "WheelData.monthsLowerCas…ndar.get(Calendar.MONTH)]");
        WheelData<?> wheelData4 = wheelData3;
        picker.setFirstWheelValue(wheelData2);
        picker.setSecondWheelValue(wheelData4);
        a aVar = new a(this, button);
        picker.setOnScrollStartedCallback(aVar);
        picker.setOnSecondScrollStartedCallback(aVar);
        picker.setOnSelection(new b(picker, wheelData2, wheelData4, new WheelData(Integer.valueOf(instance.get(1)), ""), this, button));
        button.setOnClickListener(new c(this, picker, consumer, i));
    }

    public static final void access$verifyDate(DatePickerDialog datePickerDialog, Picker picker, WheelData wheelData, WheelData wheelData2, WheelData wheelData3, Button button) {
        Objects.requireNonNull(datePickerDialog);
        if (wheelData != null && wheelData2 != null) {
            if (WheelData.Companion.checkDateIsValid(wheelData, wheelData2, wheelData3)) {
                String string = picker.getContext().getString(R.string.interview_invitation_picker_apply);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…_invitation_picker_apply)");
                button.setText(string);
                Views.enable(button);
                return;
            }
            String string2 = picker.getContext().getString(R.string.interview_invitation_picker_select_valid_date);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…picker_select_valid_date)");
            button.setText(string2);
            Views.disable(button);
        }
    }
}
