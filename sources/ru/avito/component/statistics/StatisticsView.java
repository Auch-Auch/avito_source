package ru.avito.component.statistics;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0002¢\u0006\u0004\b1\u00102J?\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010 \u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u0016\u0010$\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001dR\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u001d¨\u00063"}, d2 = {"Lru/avito/component/statistics/StatisticsView;", "Landroid/widget/FrameLayout;", "", "viewsEver", "viewsToday", "likes", "contactsEver", "contactsToday", "", "setData", "(IIIII)V", "setLikes", "(I)V", "setWatches", "(II)V", "viewEver", "setContacts", "hideContacts", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnStatisticsClickListener", "(Lkotlin/jvm/functions/Function0;)V", "total", "today", "", AuthSource.SEND_ABUSE, "(II)Ljava/lang/String;", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getWatchesView", "()Landroid/widget/TextView;", "watchesView", "c", "link", AuthSource.BOOKING_ORDER, "likesView", "Ljava/text/DecimalFormat;", "e", "Ljava/text/DecimalFormat;", "defaultFormatter", "d", "contacts", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class StatisticsView extends FrameLayout {
    @NotNull
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final DecimalFormat e;

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

    @JvmOverloads
    public StatisticsView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public StatisticsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public StatisticsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StatisticsView(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public static /* synthetic */ void setContacts$default(StatisticsView statisticsView, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        statisticsView.setContacts(i, i2);
    }

    public static /* synthetic */ void setData$default(StatisticsView statisticsView, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = 0;
        }
        if ((i6 & 2) != 0) {
            i2 = 0;
        }
        if ((i6 & 4) != 0) {
            i3 = 0;
        }
        if ((i6 & 8) != 0) {
            i4 = 0;
        }
        if ((i6 & 16) != 0) {
            i5 = 0;
        }
        statisticsView.setData(i, i2, i3, i4, i5);
    }

    public static /* synthetic */ void setLikes$default(StatisticsView statisticsView, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        statisticsView.setLikes(i);
    }

    public static /* synthetic */ void setWatches$default(StatisticsView statisticsView, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        statisticsView.setWatches(i, i2);
    }

    public final String a(int i, int i2) {
        String format = this.e.format(Integer.valueOf(i));
        if (i2 > 0) {
            StringBuilder Q = a2.b.a.a.a.Q(format, " +");
            Q.append(this.e.format(Integer.valueOf(i2)));
            return Q.toString();
        }
        Intrinsics.checkNotNullExpressionValue(format, "formattedTotal");
        return format;
    }

    @NotNull
    public final TextView getWatchesView() {
        return this.a;
    }

    public final void hideContacts() {
        Views.hide(this.d);
    }

    public final void setContacts(int i, int i2) {
        TextViews.bindText$default(this.d, a(i, i2), false, 2, null);
    }

    public final void setData(int i, int i2, int i3, int i4, int i5) {
        setWatches(i, i2);
        setLikes(i3);
        setContacts(i4, i5);
    }

    public final void setLikes(int i) {
        this.b.setText(this.e.format(Integer.valueOf(i)));
    }

    public final void setOnStatisticsClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.c.setOnClickListener(new a(function0));
        Views.show(this.c);
    }

    public final void setWatches(int i, int i2) {
        this.a.setText(a(i, i2));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StatisticsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        NumberFormat instance = DecimalFormat.getInstance(new Locale("ru", "RU"));
        Objects.requireNonNull(instance, "null cannot be cast to non-null type java.text.DecimalFormat");
        DecimalFormat decimalFormat = (DecimalFormat) instance;
        decimalFormat.setGroupingSize(3);
        DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
        Intrinsics.checkNotNullExpressionValue(decimalFormatSymbols, "decimalFormatSymbols");
        decimalFormatSymbols.setGroupingSeparator(Typography.nbsp);
        Unit unit = Unit.INSTANCE;
        this.e = decimalFormat;
        FrameLayout.inflate(context, R.layout.statistics_view, this);
        View findViewById = findViewById(R.id.watches);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.watches)");
        this.a = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.likes);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.likes)");
        this.b = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.link);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.link)");
        this.c = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.contacts);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.contacts)");
        this.d = (TextView) findViewById4;
    }
}
