package ru.avito.component.serp;

import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.widget.TextViewCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a'\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\"\u001d\u0010\r\u001a\u00020\b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Landroid/widget/TextView;", "", "text", "", "async", "", "bindTextAsync", "(Landroid/widget/TextView;Ljava/lang/CharSequence;Z)V", "Ljava/util/concurrent/Executor;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class PrecomputedTextViewKt {
    public static final Lazy a = c.lazy(a.a);

    public static final class a extends Lambda implements Function0<ExecutorService> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ExecutorService invoke() {
            return Executors.newSingleThreadExecutor(a7.a.a.g.a.a);
        }
    }

    public static final void bindTextAsync(@NotNull TextView textView, @Nullable CharSequence charSequence, boolean z) {
        Intrinsics.checkNotNullParameter(textView, "$this$bindTextAsync");
        boolean z2 = false;
        if (!(textView instanceof AppCompatTextView)) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
            return;
        }
        if (charSequence == null || charSequence.length() == 0) {
            z2 = true;
        }
        if (z2) {
            Views.hide(textView);
            ((AppCompatTextView) textView).setText((CharSequence) null);
            return;
        }
        Views.show(textView);
        if (z) {
            ((AppCompatTextView) textView).setTextFuture(PrecomputedTextCompat.getTextFuture(charSequence, TextViewCompat.getTextMetricsParams(textView), (Executor) a.getValue()));
        } else {
            ((AppCompatTextView) textView).setText(charSequence);
        }
    }

    public static /* synthetic */ void bindTextAsync$default(TextView textView, CharSequence charSequence, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        bindTextAsync(textView, charSequence, z);
    }
}
