package ru.avito.component.statistics;

import a2.b.a.a.a;
import android.view.View;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.statistics.Statistics;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lru/avito/component/statistics/StatisticsImpl;", "Lru/avito/component/statistics/Statistics;", "", "viewsEver", "viewsToday", "likes", "", "setData", "(III)V", "Landroid/view/View$OnClickListener;", "clickListener", "setOnStatisticsClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "link", AuthSource.BOOKING_ORDER, "likesView", AuthSource.SEND_ABUSE, "watchesView", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class StatisticsImpl implements Statistics {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final TextView a;
    public final TextView b;
    public final TextView c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lru/avito/component/statistics/StatisticsImpl$Companion;", "", "Landroid/view/View;", "view", "Lru/avito/component/statistics/Statistics;", "createFromContainerView", "(Landroid/view/View;)Lru/avito/component/statistics/Statistics;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Statistics createFromContainerView(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.watches);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            View findViewById2 = view.findViewById(R.id.likes);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            View findViewById3 = view.findViewById(R.id.link);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            return new StatisticsImpl((TextView) findViewById, (TextView) findViewById2, (TextView) findViewById3, null);
        }

        public Companion(j jVar) {
        }
    }

    public StatisticsImpl(TextView textView, TextView textView2, TextView textView3, j jVar) {
        this.a = textView;
        this.b = textView2;
        this.c = textView3;
        Statistics.DefaultImpls.setData$default(this, 0, 0, 0, 7, null);
    }

    @Override // ru.avito.component.statistics.Statistics
    public void setData(int i, int i2, int i3) {
        String valueOf = String.valueOf(i);
        if (i2 > 0) {
            StringBuilder Q = a.Q(valueOf, " +");
            Q.append(String.valueOf(i2));
            valueOf = Q.toString();
        }
        this.a.setText(valueOf);
        this.b.setText(String.valueOf(i3));
    }

    @Override // ru.avito.component.statistics.Statistics
    public void setOnStatisticsClickListener(@Nullable View.OnClickListener onClickListener) {
        this.c.setOnClickListener(onClickListener);
    }
}
