package com.avito.android.util;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import com.google.android.material.R;
import com.google.android.material.snackbar.Snackbar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J}\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00042\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0004\u0018\u0001`\f2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\f2\b\b\u0003\u0010\u000f\u001a\u00020\u00042\b\b\u0003\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0001\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00042\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0004\u0018\u0001`\f2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\f2\b\b\u0003\u0010\u000f\u001a\u00020\u00042\b\b\u0003\u0010\u0010\u001a\u00020\u00042\b\b\u0003\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/avito/android/util/AvitoSnackbar;", "", "Landroid/view/View;", "view", "", "resId", "duration", "", "actionTitle", "maxLines", "Lkotlin/Function0;", "", "Lcom/avito/android/util/ActionHandler;", "action", "dismissAction", "backgroundColor", "textColor", "Lcom/google/android/material/snackbar/Snackbar;", "make", "(Landroid/view/View;IILjava/lang/String;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;II)Lcom/google/android/material/snackbar/Snackbar;", "", "text", "actionTextColor", "(Landroid/view/View;Ljava/lang/CharSequence;ILjava/lang/String;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;III)Lcom/google/android/material/snackbar/Snackbar;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoSnackbar {
    @NotNull
    public static final AvitoSnackbar INSTANCE = new AvitoSnackbar();

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ Function0 c;

        public a(Function0 function0, String str, int i, View view, Function0 function02, int i2, int i3, int i4) {
            this.a = function0;
            this.b = view;
            this.c = function02;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Snackbar make$default(AvitoSnackbar avitoSnackbar, View view, int i, int i2, String str, int i3, Function0 function0, Function0 function02, int i4, int i5, int i6, Object obj) {
        int i7;
        String str2 = (i6 & 8) != 0 ? null : str;
        int i8 = (i6 & 16) != 0 ? 2 : i3;
        Function0 function03 = (i6 & 32) != 0 ? null : function0;
        b bVar = (i6 & 64) != 0 ? b.a : function02;
        int i9 = (i6 & 128) != 0 ? 0 : i4;
        if ((i6 & 256) != 0) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            i7 = Contexts.getColorByAttr(context, R.attr.snackbarTextColor);
        } else {
            i7 = i5;
        }
        return avitoSnackbar.make(view, i, i2, str2, i8, function03, bVar, i9, i7);
    }

    @NotNull
    public final Snackbar make(@NotNull View view, @StringRes int i, int i2, @Nullable String str, int i3, @Nullable Function0<Unit> function0, @NotNull Function0<Unit> function02, @ColorInt int i4, @ColorInt int i5) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function02, "dismissAction");
        String string = view.getContext().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "view.context.getString(resId)");
        return make$default(this, view, string, i2, str, i3, function0, function02, i4, i5, 0, 512, null);
    }

    public static /* synthetic */ Snackbar make$default(AvitoSnackbar avitoSnackbar, View view, CharSequence charSequence, int i, String str, int i2, Function0 function0, Function0 function02, int i3, int i4, int i5, int i6, Object obj) {
        return avitoSnackbar.make(view, charSequence, i, (i6 & 8) != 0 ? null : str, (i6 & 16) != 0 ? 2 : i2, (i6 & 32) != 0 ? null : function0, (i6 & 64) != 0 ? c.a : function02, (i6 & 128) != 0 ? 0 : i3, (i6 & 256) != 0 ? 0 : i4, (i6 & 512) != 0 ? 0 : i5);
    }

    @NotNull
    public final Snackbar make(@NotNull View view, @NotNull CharSequence charSequence, int i, @Nullable String str, int i2, @Nullable Function0<Unit> function0, @NotNull Function0<Unit> function02, @ColorInt int i3, @ColorInt int i4, @ColorInt int i5) {
        int i6;
        int i7;
        int i8;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(function02, "dismissAction");
        Snackbar make = Snackbar.make(view, charSequence, i);
        Intrinsics.checkNotNullExpressionValue(make, "Snackbar.make(view, text, duration)");
        if (function0 != null) {
            make.setAction(str != null ? str : "", new a(function0, str, i5, view, function02, i2, i4, i3));
            Integer valueOf = Integer.valueOf(i5);
            if (!(valueOf.intValue() != 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                i8 = valueOf.intValue();
            } else {
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                i8 = Contexts.getColorByAttr(context, R.attr.snackbarActionTextColor);
            }
            make.setActionTextColor(i8);
        }
        make.addCallback(new Snackbar.Callback(function0, str, i5, view, function02, i2, i4, i3) { // from class: com.avito.android.util.AvitoSnackbar$make$$inlined$apply$lambda$2
            public final /* synthetic */ Function0 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ Function0 c;

            {
                this.a = r1;
                this.b = r4;
                this.c = r5;
            }

            @Override // com.google.android.material.snackbar.Snackbar.Callback
            public void onDismissed(@Nullable Snackbar snackbar, int i9) {
                this.c.invoke();
            }
        });
        TextView textView = (TextView) make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNullExpressionValue(textView, "snackbarView");
        textView.setMaxLines(i2);
        Integer valueOf2 = Integer.valueOf(i4);
        if (!(valueOf2.intValue() != 0)) {
            valueOf2 = null;
        }
        if (valueOf2 != null) {
            i6 = valueOf2.intValue();
        } else {
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            i6 = Contexts.getColorByAttr(context2, R.attr.snackbarTextColor);
        }
        textView.setTextColor(i6);
        View view2 = make.getView();
        Integer valueOf3 = Integer.valueOf(i3);
        Integer num = valueOf3.intValue() != 0 ? valueOf3 : null;
        if (num != null) {
            i7 = num.intValue();
        } else {
            Context context3 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "view.context");
            i7 = Contexts.getColorByAttr(context3, R.attr.snackbarBackgroundColor);
        }
        view2.setBackgroundColor(i7);
        return make;
    }
}
