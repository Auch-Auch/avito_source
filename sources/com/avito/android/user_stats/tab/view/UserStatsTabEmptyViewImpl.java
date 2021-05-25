package com.avito.android.user_stats.tab.view;

import android.view.View;
import android.widget.TextView;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_stats.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/avito/android/user_stats/tab/view/UserStatsTabEmptyViewImpl;", "Lcom/avito/android/user_stats/tab/view/UserStatsTabEmptyView;", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "descriptionView", AuthSource.SEND_ABUSE, "titleView", "Lcom/avito/android/lib/design/button/Button;", "c", "Lcom/avito/android/lib/design/button/Button;", "buttonView", "Landroid/view/View;", "view", "", "title", "description", "buttonText", "Lkotlin/Function0;", "", "clicksListener", "<init>", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsTabEmptyViewImpl implements UserStatsTabEmptyView {
    public final TextView a;
    public final TextView b;
    public final Button c;

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

    public UserStatsTabEmptyViewImpl(@NotNull View view, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "buttonText");
        Intrinsics.checkNotNullParameter(function0, "clicksListener");
        View findViewById = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
        TextView textView = (TextView) findViewById;
        this.a = textView;
        View findViewById2 = view.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.description)");
        TextView textView2 = (TextView) findViewById2;
        this.b = textView2;
        View findViewById3 = view.findViewById(R.id.action);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.action)");
        Button button = (Button) findViewById3;
        this.c = button;
        textView.setText(str);
        textView2.setText(str2);
        button.setText(str3);
        button.setOnClickListener(new a(function0));
    }
}
