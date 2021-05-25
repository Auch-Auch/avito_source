package com.avito.android.lib.design.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0003\f\r\u000eB\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/avito/android/lib/design/dialog/Dialog;", "Landroid/app/Dialog;", "", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getEnterAnimationDuration", "()J", "enterAnimationDuration", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "Config", "View", "components_release"}, k = 1, mv = {1, 4, 2})
public final class Dialog extends android.app.Dialog {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final Lazy a = c.lazy(new a(this));

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014JW\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u00042,\u0010\u000f\u001a(\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0007¢\u0006\u0002\b\u000e¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/lib/design/dialog/Dialog$Companion;", "", "Landroid/content/Context;", "context", "", "styleAttr", "styleRes", "Lkotlin/Function2;", "Lcom/avito/android/lib/design/dialog/Dialog$Config;", "Landroid/content/DialogInterface;", "Lkotlin/ParameterName;", "name", "dialog", "", "Lkotlin/ExtensionFunctionType;", "fillData", "Lcom/avito/android/lib/design/dialog/Dialog;", "create", "(Landroid/content/Context;IILkotlin/jvm/functions/Function2;)Lcom/avito/android/lib/design/dialog/Dialog;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ Dialog create$default(Companion companion, Context context, int i, int i2, Function2 function2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            return companion.create(context, i, i2, function2);
        }

        @NotNull
        public final Dialog create(@NotNull Context context, @AttrRes int i, @StyleRes int i2, @NotNull Function2<? super Config, ? super DialogInterface, Unit> function2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(function2, "fillData");
            DialogView dialogView = new DialogView(context, null, i, i2);
            Dialog dialog = new Dialog(context);
            dialog.setCancelable(false);
            dialog.setContentView(dialogView, new ViewGroup.LayoutParams(-2, -2));
            function2.invoke(new Config(dialog, dialogView), dialog);
            return dialog;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020;\u0012\u0006\u0010(\u001a\u00020\u0001¢\u0006\u0004\b>\u0010?J2\u0010\t\u001a\u00020\u00072#\b\u0002\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J0\u0010\u0011\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002¢\u0006\u0004\b\u0011\u0010\nJ\u001b\u0010\u0013\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012¢\u0006\u0004\b\u0013\u0010\u0014J0\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0001\u0010\u0018\u001a\u00020\u00172\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00172\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ&\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0001¢\u0006\u0004\b\u001c\u0010\u001eJ&\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00172\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0001¢\u0006\u0004\b\u001f\u0010\u001dJ&\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0001¢\u0006\u0004\b\u001f\u0010\u001eJ&\u0010 \u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00172\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0001¢\u0006\u0004\b \u0010\u001dJ&\u0010 \u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0001¢\u0006\u0004\b \u0010\u001eJ\u0010\u0010!\u001a\u00020\u0007H\u0001¢\u0006\u0004\b!\u0010\fJ\u0018\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0017H\u0001¢\u0006\u0004\b#\u0010$J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\rH\u0001¢\u0006\u0004\b&\u0010\u0010J\u0018\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'H\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010-\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010+H\u0001¢\u0006\u0004\b-\u0010.J\u001a\u0010-\u001a\u00020\u00072\b\b\u0001\u0010/\u001a\u00020\u0017H\u0001¢\u0006\u0004\b-\u0010$J\u001e\u00101\u001a\u00020\u00072\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0001¢\u0006\u0004\b1\u0010\u0014J\u001a\u00103\u001a\u00020\u00072\b\b\u0001\u00102\u001a\u00020\u0017H\u0001¢\u0006\u0004\b3\u0010$J\u001a\u00103\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b3\u00105J\u001a\u00107\u001a\u00020\u00072\b\b\u0001\u00106\u001a\u00020\u0017H\u0001¢\u0006\u0004\b7\u0010$J\u001a\u00107\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0004\b7\u00105R\u0016\u0010(\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010\u0006\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006@"}, d2 = {"Lcom/avito/android/lib/design/dialog/Dialog$Config;", "Lcom/avito/android/lib/design/dialog/Dialog$View;", "Lkotlin/Function1;", "Landroid/content/DialogInterface;", "Lkotlin/ParameterName;", "name", "dialog", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "enableCancelable", "(Lkotlin/jvm/functions/Function1;)V", "disableCancelable", "()V", "", "cancelable", "setCancelable", "(Z)V", "setOnDismissListener", "Lkotlin/Function0;", "setOnCloseClickedListener", "(Lkotlin/jvm/functions/Function0;)V", "", "text", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "addButton", "(Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", "textRes", "addDefaultButton", "(ILkotlin/jvm/functions/Function0;)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "addPrimaryButton", "addSecondaryButton", "removeAllButtons", "orientation", "setButtonsOrientation", "(I)V", "isVisible", "setCloseButtonVisible", "Landroid/view/View;", "view", "setCustomView", "(Landroid/view/View;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImage", "(Landroid/graphics/drawable/Drawable;)V", "src", "action", "setOnCloseClicked", "subtitleRes", "setSubtitle", MessengerShareContentUtility.SUBTITLE, "(Ljava/lang/String;)V", "titleRes", "setTitle", "title", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/dialog/Dialog$View;", "Landroid/app/Dialog;", AuthSource.SEND_ABUSE, "Landroid/app/Dialog;", "<init>", "(Landroid/app/Dialog;Lcom/avito/android/lib/design/dialog/Dialog$View;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Config implements View {
        public final android.app.Dialog a;
        public final View b;

        public static final class a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Config a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Config config) {
                super(0);
                this.a = config;
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                this.a.a.dismiss();
                return Unit.INSTANCE;
            }
        }

        public static final class b extends Lambda implements Function1<DialogInterface, Unit> {
            public static final b a = new b();

            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(DialogInterface dialogInterface) {
                Intrinsics.checkNotNullParameter(dialogInterface, "it");
                return Unit.INSTANCE;
            }
        }

        public static final class c extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Config a;
            public final /* synthetic */ Function0 b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(Config config, Function0 function0) {
                super(0);
                this.a = config;
                this.b = function0;
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                this.b.invoke();
                this.a.a.dismiss();
                return Unit.INSTANCE;
            }
        }

        public Config(@NotNull android.app.Dialog dialog, @NotNull View view) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Intrinsics.checkNotNullParameter(view, "view");
            this.a = dialog;
            this.b = view;
            view.setOnCloseClicked(new a(this));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.lib.design.dialog.Dialog$Config */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void enableCancelable$default(Config config, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = b.a;
            }
            config.enableCancelable(function1);
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void addButton(@NotNull String str, @StyleRes int i, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.b.addButton(str, i, function0);
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void addDefaultButton(int i, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.b.addDefaultButton(i, function0);
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void addDefaultButton(@NotNull String str, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.b.addDefaultButton(str, function0);
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void addPrimaryButton(int i, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.b.addPrimaryButton(i, function0);
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void addPrimaryButton(@NotNull String str, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.b.addPrimaryButton(str, function0);
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void addSecondaryButton(int i, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.b.addSecondaryButton(i, function0);
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void addSecondaryButton(@NotNull String str, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.b.addSecondaryButton(str, function0);
        }

        public final void disableCancelable() {
            setCancelable(false);
        }

        public final void enableCancelable(@NotNull Function1<? super DialogInterface, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            setCancelable(true);
            this.a.setOnCancelListener(new a2.a.a.k1.a.c.a(function1));
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void removeAllButtons() {
            this.b.removeAllButtons();
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void setButtonsOrientation(int i) {
            this.b.setButtonsOrientation(i);
        }

        public final void setCancelable(boolean z) {
            this.a.setCancelable(z);
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void setCloseButtonVisible(boolean z) {
            this.b.setCloseButtonVisible(z);
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void setCustomView(@NotNull android.view.View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.b.setCustomView(view);
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void setImage(@DrawableRes int i) {
            this.b.setImage(i);
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void setImage(@Nullable Drawable drawable) {
            this.b.setImage(drawable);
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void setOnCloseClicked(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "action");
            this.b.setOnCloseClicked(function0);
        }

        public final void setOnCloseClickedListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.b.setOnCloseClicked(new c(this, function0));
        }

        public final void setOnDismissListener(@NotNull Function1<? super DialogInterface, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.a.setOnDismissListener(new a2.a.a.k1.a.c.b(function1));
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void setSubtitle(@StringRes int i) {
            this.b.setSubtitle(i);
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void setSubtitle(@Nullable String str) {
            this.b.setSubtitle(str);
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void setTitle(@StringRes int i) {
            this.b.setTitle(i);
        }

        @Override // com.avito.android.lib.design.dialog.Dialog.View
        public void setTitle(@Nullable String str) {
            this.b.setTitle(str);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0005\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H&¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H&¢\u0006\u0004\b\u0016\u0010\u0018J%\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H&¢\u0006\u0004\b\u0019\u0010\u0017J%\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H&¢\u0006\u0004\b\u0019\u0010\u0018J%\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H&¢\u0006\u0004\b\u001a\u0010\u0017J%\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H&¢\u0006\u0004\b\u001a\u0010\u0018J\u0019\u0010\u001c\u001a\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020\u0002H&¢\u0006\u0004\b\u001c\u0010\u0006J\u0019\u0010\u001c\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&¢\u0006\u0004\b\u001c\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0002H&¢\u0006\u0004\b!\u0010\u0006J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H&¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H&¢\u0006\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/avito/android/lib/design/dialog/Dialog$View;", "", "", "titleRes", "", "setTitle", "(I)V", "", "title", "(Ljava/lang/String;)V", "subtitleRes", "setSubtitle", MessengerShareContentUtility.SUBTITLE, "removeAllButtons", "()V", "text", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addButton", "(Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", "textRes", "addPrimaryButton", "(ILkotlin/jvm/functions/Function0;)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "addSecondaryButton", "addDefaultButton", "src", "setImage", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "orientation", "setButtonsOrientation", "", "isVisible", "setCloseButtonVisible", "(Z)V", "action", "setOnCloseClicked", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View;", "view", "setCustomView", "(Landroid/view/View;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public interface View {
        void addButton(@NotNull String str, @StyleRes int i, @NotNull Function0<Unit> function0);

        void addDefaultButton(int i, @NotNull Function0<Unit> function0);

        void addDefaultButton(@NotNull String str, @NotNull Function0<Unit> function0);

        void addPrimaryButton(int i, @NotNull Function0<Unit> function0);

        void addPrimaryButton(@NotNull String str, @NotNull Function0<Unit> function0);

        void addSecondaryButton(int i, @NotNull Function0<Unit> function0);

        void addSecondaryButton(@NotNull String str, @NotNull Function0<Unit> function0);

        void removeAllButtons();

        void setButtonsOrientation(int i);

        void setCloseButtonVisible(boolean z);

        void setCustomView(@NotNull android.view.View view);

        void setImage(@DrawableRes int i);

        void setImage(@Nullable Drawable drawable);

        void setOnCloseClicked(@NotNull Function0<Unit> function0);

        void setSubtitle(@StringRes int i);

        void setSubtitle(@Nullable String str);

        void setTitle(@StringRes int i);

        void setTitle(@Nullable String str);
    }

    public static final class a extends Lambda implements Function0<Long> {
        public final /* synthetic */ Dialog a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Dialog dialog) {
            super(0);
            this.a = dialog;
        }

        @Override // kotlin.jvm.functions.Function0
        public Long invoke() {
            return Long.valueOf(Dialog.access$calculateEnterAnimationDuration(this.a));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Dialog(@NotNull Context context) {
        super(context, R.style.Dialog_Default_Window);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final long access$calculateEnterAnimationDuration(Dialog dialog) {
        Context context = dialog.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TypedArray obtainStyledAttributes = dialog.getContext().obtainStyledAttributes(Contexts.getResourceIdByAttr(context, 16842926), new int[]{16842932});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId == 0) {
            return 0;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(dialog.getContext(), resourceId);
        obtainStyledAttributes.recycle();
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "windowEnterAnimation");
        return loadAnimation.getDuration();
    }

    public final long getEnterAnimationDuration() {
        return ((Number) this.a.getValue()).longValue();
    }
}
