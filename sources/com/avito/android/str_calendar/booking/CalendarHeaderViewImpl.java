package com.avito.android.str_calendar.booking;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.R;
import com.avito.android.util.Contexts;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\nR\u001e\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0019\u001a\n \u0012*\u0004\u0018\u00010\u00160\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001d\u001a\n \u0012*\u0004\u0018\u00010\u001a0\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/avito/android/str_calendar/booking/CalendarHeaderViewImpl;", "Lcom/avito/android/str_calendar/booking/CalendarHeaderView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setNavigationClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "enable", "setClearBtnEnable", "(Z)V", "function", "setClearBtnClickListener", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "clearButton", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class CalendarHeaderViewImpl implements CalendarHeaderView {
    public final Context a;
    public final Toolbar b;
    public final TextView c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public CalendarHeaderViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = view.getContext();
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        this.b = toolbar;
        this.c = (TextView) toolbar.findViewById(R.id.clear_button);
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24_blue);
    }

    @Override // com.avito.android.str_calendar.booking.CalendarHeaderView
    public void setClearBtnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "function");
        this.c.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.str_calendar.booking.CalendarHeaderView
    public void setClearBtnEnable(boolean z) {
        int i;
        TextView textView = this.c;
        if (z) {
            Context context = this.a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            i = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.blue);
        } else {
            Context context2 = this.a;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            i = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.blueAlpha40);
        }
        textView.setTextColor(i);
    }

    @Override // com.avito.android.str_calendar.booking.CalendarHeaderView
    public void setNavigationClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b.setNavigationOnClickListener(new b(function0));
    }

    @Override // com.avito.android.str_calendar.booking.CalendarHeaderView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        Toolbar toolbar = this.b;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        toolbar.setTitle(str);
    }
}
