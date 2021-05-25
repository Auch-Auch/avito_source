package com.avito.android.job.interview.pickers;

import a2.a.a.j1.b.j.d;
import a2.a.a.j1.b.j.e;
import a2.a.a.j1.b.j.f;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.job.interview.Action;
import com.avito.android.job.interview.R;
import com.avito.android.job.interview.pickers.TimePickerResult;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.bottom_sheet.RightCrossHeaderKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.list_item.SwitcherListItem;
import com.avito.android.lib.design.picker.Picker;
import com.avito.android.lib.design.picker.WheelData;
import com.avito.android.lib.design.picker.WheelStyle;
import com.avito.android.remote.model.category_parameters.FormattedDateDisplayingType;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001/B/\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010\u001a\u001a\u00020\u0012\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR)\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00108B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001e\u0010#\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R)\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00108B@\u0002X\u0002¢\u0006\f\n\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0016R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u00060"}, d2 = {"Lcom/avito/android/job/interview/pickers/TimePickerDialog;", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "Landroid/view/ViewGroup;", "container", "", "c", "(Landroid/view/ViewGroup;)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/job/interview/Action;", "y", "Lio/reactivex/rxjava3/functions/Consumer;", "actionConsumer", "Lcom/avito/android/lib/design/button/Button;", "w", "Lcom/avito/android/lib/design/button/Button;", "applyButton", "", "Lcom/avito/android/lib/design/picker/WheelData;", "", "t", "Lkotlin/Lazy;", "getHours", "()Ljava/util/List;", "hours", "x", "I", "pos", "Lcom/avito/android/job/interview/pickers/TimePickerDialog$Mode;", "z", "Lcom/avito/android/job/interview/pickers/TimePickerDialog$Mode;", "mode", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", VKApiConst.VERSION, "Ljava/util/Calendar;", FormattedDateDisplayingType.TYPE_CALENDAR, "u", "getMinutes", "minutes", "", "s", "Ljava/lang/String;", "applyText", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;ILio/reactivex/rxjava3/functions/Consumer;Lcom/avito/android/job/interview/pickers/TimePickerDialog$Mode;)V", "Mode", "interview_release"}, k = 1, mv = {1, 4, 2})
public final class TimePickerDialog extends BottomSheetDialog {
    public final String s;
    public final Lazy t;
    public final Lazy u;
    public final Calendar v;
    public final Button w;
    public final int x;
    public final Consumer<Action> y;
    public Mode z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/job/interview/pickers/TimePickerDialog$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "INTERVAL", "SPECIFIC", "interview_release"}, k = 1, mv = {1, 4, 2})
    public enum Mode {
        INTERVAL,
        SPECIFIC
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            Mode.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            Mode.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[1] = 2;
            Mode.values();
            int[] iArr3 = new int[2];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[0] = 1;
            iArr3[1] = 2;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<List<? extends WheelData<Integer>>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final List<? extends WheelData<Integer>> invoke() {
            int i = this.a;
            if (i == 0) {
                return TimePickerDialog.access$buildTimeItems((TimePickerDialog) this.b, 24);
            }
            if (i == 1) {
                return TimePickerDialog.access$buildTimeItems((TimePickerDialog) this.b, 60);
            }
            throw null;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ TimePickerDialog a;
        public final /* synthetic */ ViewGroup b;

        public b(TimePickerDialog timePickerDialog, Context context, ViewGroup viewGroup) {
            this.a = timePickerDialog;
            this.b = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ViewGroup viewGroup = this.b;
            viewGroup.removeView(viewGroup.findViewWithTag("picker_view"));
            TimePickerDialog timePickerDialog = this.a;
            timePickerDialog.z = TimePickerDialog.access$alter(timePickerDialog, timePickerDialog.z);
            this.a.c(this.b);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ TimePickerDialog a;
        public final /* synthetic */ Picker b;

        public c(TimePickerDialog timePickerDialog, Picker picker) {
            this.a = timePickerDialog;
            this.b = picker;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.y.accept(new Action.TimeChanged(this.a.x, TimePickerDialog.access$buildPickerResult(this.a, this.b)));
            this.a.dismiss();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TimePickerDialog(Context context, int i, Consumer consumer, Mode mode, int i2, j jVar) {
        this(context, i, consumer, (i2 & 8) != 0 ? Mode.INTERVAL : mode);
    }

    public static final Mode access$alter(TimePickerDialog timePickerDialog, Mode mode) {
        Objects.requireNonNull(timePickerDialog);
        int ordinal = mode.ordinal();
        if (ordinal == 0) {
            return Mode.SPECIFIC;
        }
        if (ordinal == 1) {
            return Mode.INTERVAL;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final TimePickerResult access$buildPickerResult(TimePickerDialog timePickerDialog, Picker picker) {
        int ordinal = timePickerDialog.z.ordinal();
        if (ordinal == 0) {
            WheelData<?> firstWheelValue = picker.getFirstWheelValue();
            Objects.requireNonNull(firstWheelValue, "null cannot be cast to non-null type com.avito.android.lib.design.picker.WheelData<kotlin.String>");
            WheelData<?> secondWheelValue = picker.getSecondWheelValue();
            Objects.requireNonNull(secondWheelValue, "null cannot be cast to non-null type com.avito.android.lib.design.picker.WheelData<kotlin.String>");
            String name = firstWheelValue.getName();
            String name2 = secondWheelValue.getName();
            return new TimePickerResult.Interval(name, name2, firstWheelValue.getName() + '-' + secondWheelValue.getName());
        } else if (ordinal == 1) {
            WheelData<?> firstWheelValue2 = picker.getFirstWheelValue();
            Objects.requireNonNull(firstWheelValue2, "null cannot be cast to non-null type com.avito.android.lib.design.picker.WheelData<kotlin.Int>");
            WheelData<?> secondWheelValue2 = picker.getSecondWheelValue();
            Objects.requireNonNull(secondWheelValue2, "null cannot be cast to non-null type com.avito.android.lib.design.picker.WheelData<kotlin.Int>");
            return new TimePickerResult.Specific(firstWheelValue2.getName() + ':' + secondWheelValue2.getName());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('0' char), (r0v1 int)] */
    public static final List access$buildTimeItems(TimePickerDialog timePickerDialog, int i) {
        String str;
        Objects.requireNonNull(timePickerDialog);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < 10) {
                StringBuilder sb = new StringBuilder();
                sb.append('0');
                sb.append(i2);
                str = sb.toString();
            } else {
                str = String.valueOf(i2);
            }
            arrayList.add(new WheelData(Integer.valueOf(i2), str));
        }
        return arrayList;
    }

    public static final void access$verifyInterval(TimePickerDialog timePickerDialog, Picker picker, WheelData wheelData, WheelData wheelData2) {
        Objects.requireNonNull(timePickerDialog);
        if (wheelData != null && wheelData2 != null) {
            if (WheelData.Companion.checkIntervalIsValid(wheelData, wheelData2)) {
                Views.enable(timePickerDialog.w);
                timePickerDialog.w.setText(timePickerDialog.s);
                return;
            }
            Views.disable(timePickerDialog.w);
            Button button = timePickerDialog.w;
            String string = picker.getContext().getString(R.string.interview_invitation_picker_select_valid_interval);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…er_select_valid_interval)");
            button.setText(string);
        }
    }

    public final void c(ViewGroup viewGroup) {
        Picker picker;
        int ordinal = this.z.ordinal();
        if (ordinal == 0) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            picker = new Picker(context, null, 0, 0, 14, null);
            WheelData.Companion companion = WheelData.Companion;
            Picker.addWheel$default(picker, companion.getTimeInterval(), null, 2, null);
            picker.addDivider(com.avito.android.lib.design.R.drawable.design_interval_divider);
            picker.addWheel(companion.getTimeInterval(), new WheelStyle(null, false, 0, 7, null));
            int i = this.v.get(11) * 2;
            WheelData<?> wheelData = companion.getTimeInterval().get(i - 1);
            Intrinsics.checkNotNullExpressionValue(wheelData, "WheelData.timeInterval[currentHour * 2 - 1]");
            WheelData<?> wheelData2 = wheelData;
            WheelData<?> wheelData3 = companion.getTimeInterval().get(i);
            Intrinsics.checkNotNullExpressionValue(wheelData3, "WheelData.timeInterval[currentHour * 2]");
            WheelData<?> wheelData4 = wheelData3;
            picker.setFirstWheelValue(wheelData2);
            picker.setSecondWheelValue(wheelData4);
            picker.setOnSelection(new a2.a.a.j1.b.j.c(picker, wheelData2, wheelData4, this));
            d dVar = new d(this);
            picker.setOnScrollStartedCallback(dVar);
            picker.setOnSecondScrollStartedCallback(dVar);
        } else if (ordinal == 1) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            picker = new Picker(context2, null, 0, 0, 14, null);
            Picker.addWheel$default(picker, (List) this.t.getValue(), null, 2, null);
            picker.addDivider(":");
            Picker.addWheel$default(picker, (List) this.u.getValue(), null, 2, null);
            picker.setFirstWheelValue((WheelData) ((List) this.t.getValue()).get(this.v.get(11)));
            picker.setSecondWheelValue((WheelData) CollectionsKt___CollectionsKt.first((List<? extends Object>) ((List) this.u.getValue())));
            Views.enable(this.w);
            this.w.setText(this.s);
            e eVar = new e(this);
            picker.setOnScrollStartedCallback(eVar);
            picker.setOnSecondScrollStartedCallback(eVar);
            picker.setOnSelection(new f(this));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        picker.setTag("picker_view");
        View findViewById = findViewById(R.id.mode_switcher);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        viewGroup.addView(picker, viewGroup.indexOfChild(findViewById) + 1);
        View findViewById2 = findViewById(R.id.apply);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(id)");
        ((Button) findViewById2).setOnClickListener(new c(this, picker));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimePickerDialog(@NotNull Context context, int i, @NotNull Consumer<Action> consumer, @NotNull Mode mode) {
        super(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(consumer, "actionConsumer");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.x = i;
        this.y = consumer;
        this.z = mode;
        String string = context.getString(R.string.interview_invitation_picker_apply);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…_invitation_picker_apply)");
        this.s = string;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.t = t6.c.lazy(lazyThreadSafetyMode, (Function0) new a(0, this));
        this.u = t6.c.lazy(lazyThreadSafetyMode, (Function0) new a(1, this));
        this.v = Calendar.getInstance();
        setContentView(R.layout.interview_invitation_time_picker, true);
        String string2 = context.getString(R.string.interview_invitation_time_picker_title);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…tation_time_picker_title)");
        RightCrossHeaderKt.setRightCrossHeader(this, string2, true, true);
        setFitContentPeekHeight(true);
        View findViewById = findViewById(R.id.time_picker_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.mode_switcher);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(id)");
        SwitcherListItem switcherListItem = (SwitcherListItem) findViewById2;
        switcherListItem.setTitle(context.getString(R.string.interview_invitation_time_picker_switcher));
        switcherListItem.setOnClickListener(new b(this, context, viewGroup));
        c(viewGroup);
        View findViewById3 = findViewById(R.id.apply);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(id)");
        this.w = (Button) findViewById3;
    }
}
