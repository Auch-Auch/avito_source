package com.avito.android.util;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import com.avito.android.deprecated_design.R;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button_panel.ButtonPanelsKt;
import ru.avito.component.dialog.SimpleDialog;
import ru.avito.component.dialog.SimpleDialogImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001LB\u0011\b\u0007\u0012\u0006\u0010I\u001a\u00020G¢\u0006\u0004\bJ\u0010KJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\n\u0010\u000eJ3\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0016J-\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u001aJ-\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0018J5\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u001aJW\u0010#\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\r\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010!\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b#\u0010$J[\u0010'\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\r\u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020\f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\f2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016¢\u0006\u0004\b'\u0010$J-\u0010+\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0(2\u0006\u0010\u001b\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J'\u00100\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020*H\u0016¢\u0006\u0004\b0\u00101J=\u00106\u001a\u00020\u00062\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001e0(2\u0006\u00104\u001a\u0002032\u0006\u0010\u001b\u001a\u0002052\u0006\u0010\u0011\u001a\u00020*2\u0006\u0010 \u001a\u00020*H\u0016¢\u0006\u0004\b6\u00107J1\u00108\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0(2\b\u0010\u001b\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b8\u0010,J)\u0010:\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b:\u0010;Jg\u0010?\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\u00100=2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\u00100=2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b?\u0010@J[\u0010?\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b?\u0010AJ\u0017\u0010E\u001a\u00020D2\u0006\u0010C\u001a\u00020BH\u0002¢\u0006\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010H¨\u0006M"}, d2 = {"Lcom/avito/android/util/DialogRouterImpl;", "Lcom/avito/android/util/DialogRouter;", "", "attr", "resolveAttr", "(I)I", "Landroid/app/Dialog;", "showSimpleWaitingDialog", "()Landroid/app/Dialog;", "id", "showSimpleWaitingDialogWithMessage", "(I)Landroid/app/Dialog;", "", "message", "(Ljava/lang/String;)Landroid/app/Dialog;", "Lkotlin/Function0;", "", "okListener", "dismissListener", "showSimpleNotifyingDialog", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Landroid/app/Dialog;", "title", "(Ljava/lang/String;Ljava/lang/String;)Landroid/app/Dialog;", "showSimpleNotifyingDismissDialog", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Landroid/app/Dialog;", "buttonText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Landroid/app/Dialog;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "cancelable", "", "negativeButtonText", "cancelListener", "positiveButtonText", "agreeListener", "showCancelableNotifyingDialog", "(Ljava/lang/String;ZLjava/lang/CharSequence;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Landroid/app/Dialog;", "positiveListener", "negativeListener", "showNotifyingDialog", "", "itemsNames", "Landroid/content/DialogInterface$OnClickListener;", "showChooseNotifyingDialog", "(Ljava/lang/String;[Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;", "Landroid/widget/ListAdapter;", "adapter", "checkedPosition", "showSingleChoiceDialog", "(Landroid/widget/ListAdapter;ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;", "items", "", "checkedItems", "Landroid/content/DialogInterface$OnMultiChoiceClickListener;", "showMultiChoiceDialog", "([Ljava/lang/CharSequence;[ZLandroid/content/DialogInterface$OnMultiChoiceClickListener;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;", "showChooseNotifyingDialogWithButtons", "embeddedLink", "showNotifyingDialogWithEmbeddedLink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/app/Dialog;", "imgRes", "Lkotlin/Function1;", "Landroidx/appcompat/app/AlertDialog;", "showNotifyingDialogWithImage", "(IIIIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Z)Landroid/app/Dialog;", "(IIIIILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Z)Landroid/app/Dialog;", "Landroid/content/Context;", "context", "Lcom/avito/android/util/DialogRouterImpl$f;", AuthSource.SEND_ABUSE, "(Landroid/content/Context;)Lcom/avito/android/util/DialogRouterImpl$f;", "Landroid/app/Activity;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "f", "deprecated-components_release"}, k = 1, mv = {1, 4, 2})
public final class DialogRouterImpl implements DialogRouter {
    public final Activity a;

    /* compiled from: java-style lambda group */
    public static final class a implements DialogInterface.OnClickListener {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            int i2 = this.a;
            if (i2 == 0) {
                Objects.requireNonNull(dialogInterface, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
                Button button = ((AlertDialog) dialogInterface).getButton(-1);
                Intrinsics.checkNotNullExpressionValue(button, "(dialog as AlertDialog).…n(Dialog.BUTTON_POSITIVE)");
                button.setEnabled(true);
            } else if (i2 == 1) {
                dialogInterface.dismiss();
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ Object g;
        public final /* synthetic */ Object h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i, int i2, int i3, int i4, int i5, int i6, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = obj;
            this.h = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((Function0) this.g).invoke();
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((Function0) this.h).invoke();
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(int i, Object obj, Object obj2, Object obj3, Object obj4) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = obj3;
            this.e = obj4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((Function0) this.c).invoke();
                return Unit.INSTANCE;
            } else if (i == 1) {
                Function0 function0 = (Function0) this.e;
                if (function0 != null) {
                    Unit unit = (Unit) function0.invoke();
                }
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ Object g;
        public final /* synthetic */ Object h;
        public final /* synthetic */ Object i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(int i2, int i3, int i4, int i5, int i6, int i7, Object obj, Object obj2, Object obj3) {
            super(0);
            this.a = i2;
            this.b = i3;
            this.c = i4;
            this.d = i5;
            this.e = i6;
            this.f = i7;
            this.g = obj;
            this.h = obj2;
            this.i = obj3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i2 = this.a;
            if (i2 == 0) {
                ((Function1) this.g).invoke((AlertDialog) this.h);
                return Unit.INSTANCE;
            } else if (i2 == 1) {
                ((Function1) this.i).invoke((AlertDialog) this.h);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class e extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(int i, Object obj, Object obj2, Object obj3, Object obj4) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = obj3;
            this.e = obj4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((Function0) this.d).invoke();
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((Function0) this.e).invoke();
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class f {
        @NotNull
        public final SimpleDialog a;
        @NotNull
        public final AlertDialog b;

        public f(@NotNull SimpleDialog simpleDialog, @NotNull AlertDialog alertDialog) {
            Intrinsics.checkNotNullParameter(simpleDialog, "component");
            Intrinsics.checkNotNullParameter(alertDialog, "dialog");
            this.a = simpleDialog;
            this.b = alertDialog;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return Intrinsics.areEqual(this.a, fVar.a) && Intrinsics.areEqual(this.b, fVar.b);
        }

        public int hashCode() {
            SimpleDialog simpleDialog = this.a;
            int i = 0;
            int hashCode = (simpleDialog != null ? simpleDialog.hashCode() : 0) * 31;
            AlertDialog alertDialog = this.b;
            if (alertDialog != null) {
                i = alertDialog.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ComponentInfo(component=");
            L.append(this.a);
            L.append(", dialog=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    public static final class g implements DialogInterface.OnClickListener {
        public final /* synthetic */ DialogInterface.OnClickListener a;

        public g(DialogInterface.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            DialogInterface.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                Objects.requireNonNull(dialogInterface, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
                ListView listView = ((AlertDialog) dialogInterface).getListView();
                Intrinsics.checkNotNullExpressionValue(listView, "(dialog as AlertDialog).listView");
                onClickListener.onClick(dialogInterface, listView.getCheckedItemPosition());
            }
        }
    }

    public static final class h extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AlertDialog a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(String str, String str2, CharSequence charSequence, AlertDialog alertDialog) {
            super(0);
            this.a = alertDialog;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.dismiss();
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ Function0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(String str, AlertDialog alertDialog, Function0 function0) {
            super(0);
            this.a = alertDialog;
            this.b = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.dismiss();
            this.b.invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AlertDialog a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(String str, String str2, AlertDialog alertDialog) {
            super(0);
            this.a = alertDialog;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.dismiss();
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(String str, String str2, Function0 function0) {
            super(0);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class l extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(String str, String str2, String str3, Function0 function0) {
            super(0);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class m implements DialogInterface.OnDismissListener {
        public final /* synthetic */ Function0 a;

        public m(Function0 function0) {
            this.a = function0;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            this.a.invoke();
        }
    }

    public static final class n extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AlertDialog a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(String str, String str2, AlertDialog alertDialog) {
            super(0);
            this.a = alertDialog;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.dismiss();
            return Unit.INSTANCE;
        }
    }

    public static final class o extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AlertDialog a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(String str, String str2, String str3, AlertDialog alertDialog) {
            super(0);
            this.a = alertDialog;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.dismiss();
            return Unit.INSTANCE;
        }
    }

    public static final class p implements DialogInterface.OnDismissListener {
        public final /* synthetic */ Function0 a;

        public p(Function0 function0) {
            this.a = function0;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            this.a.invoke();
        }
    }

    public static final class q implements DialogInterface.OnCancelListener {
        public final /* synthetic */ Function0 a;

        public q(Function0 function0) {
            this.a = function0;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.a.invoke();
        }
    }

    public static final class r implements DialogInterface.OnDismissListener {
        public final /* synthetic */ Function0 a;

        public r(Function0 function0) {
            this.a = function0;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            this.a.invoke();
        }
    }

    public static final class s implements DialogInterface.OnCancelListener {
        public final /* synthetic */ Function0 a;

        public s(Function0 function0) {
            this.a = function0;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.a.invoke();
        }
    }

    public static final class t implements DialogInterface.OnClickListener {
        public final /* synthetic */ DialogInterface.OnClickListener a;

        public t(DialogInterface.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            this.a.onClick(dialogInterface, i);
            dialogInterface.dismiss();
        }
    }

    @Inject
    public DialogRouterImpl(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = activity;
    }

    public final f a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.simple_dialog, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        SimpleDialogImpl simpleDialogImpl = new SimpleDialogImpl(inflate);
        AlertDialog create = new AlertDialog.Builder(context).setView(inflate).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(cont…ew)\n            .create()");
        return new f(simpleDialogImpl, create);
    }

    @Override // com.avito.android.util.DialogRouter
    public int resolveAttr(int i2) {
        return Contexts.getResourceIdByAttr(this.a, i2);
    }

    @Override // com.avito.android.util.DialogRouter
    @NotNull
    public Dialog showCancelableNotifyingDialog(@Nullable String str, boolean z, @Nullable CharSequence charSequence, @NotNull String str2, @NotNull Function0<Unit> function0, @NotNull String str3, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(str2, "negativeButtonText");
        Intrinsics.checkNotNullParameter(function0, "cancelListener");
        Intrinsics.checkNotNullParameter(str3, "positiveButtonText");
        Intrinsics.checkNotNullParameter(function02, "agreeListener");
        f a3 = a(this.a);
        SimpleDialog simpleDialog = a3.a;
        AlertDialog alertDialog = a3.b;
        simpleDialog.setPrimaryButtonText(str3);
        simpleDialog.setSecondaryButtonText(str2);
        simpleDialog.setPrimaryClickListener(new e(0, str3, str2, function02, function0));
        simpleDialog.setSecondaryClickListener(new e(1, str3, str2, function02, function0));
        if (charSequence == null) {
            simpleDialog.hideBody();
        } else {
            simpleDialog.setBody(charSequence);
        }
        if (str == null) {
            simpleDialog.hideTitle();
        } else {
            simpleDialog.setTitle(str);
        }
        alertDialog.setCancelable(z);
        alertDialog.show();
        return alertDialog;
    }

    @Override // com.avito.android.util.DialogRouter
    @NotNull
    public Dialog showChooseNotifyingDialog(@NotNull String str, @NotNull String[] strArr, @NotNull DialogInterface.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(strArr, "itemsNames");
        Intrinsics.checkNotNullParameter(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        AlertDialog show = new AlertDialog.Builder(this.a).setTitle(str).setSingleChoiceItems(strArr, -1, onClickListener).show();
        Intrinsics.checkNotNullExpressionValue(show, "AlertDialog.Builder(acti…ener)\n            .show()");
        return show;
    }

    @Override // com.avito.android.util.DialogRouter
    @Nullable
    public Dialog showChooseNotifyingDialogWithButtons(@NotNull String str, @NotNull String[] strArr, @Nullable DialogInterface.OnClickListener onClickListener) {
        AlertDialog alertDialog;
        Exception e2;
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(strArr, "itemsNames");
        try {
            alertDialog = new AlertDialog.Builder(this.a).setTitle(str).setCancelable(false).setSingleChoiceItems(strArr, -1, a.b).setNegativeButton(R.string.cancel, a.c).setPositiveButton(R.string.ok, new g(onClickListener)).show();
            try {
                Button button = alertDialog.getButton(-1);
                Intrinsics.checkNotNullExpressionValue(button, "dialog.getButton(Dialog.BUTTON_POSITIVE)");
                button.setEnabled(false);
            } catch (Exception e3) {
                e2 = e3;
            }
        } catch (Exception e4) {
            e2 = e4;
            alertDialog = null;
            e2.printStackTrace();
            return alertDialog;
        }
        return alertDialog;
    }

    @Override // com.avito.android.util.DialogRouter
    @NotNull
    public Dialog showMultiChoiceDialog(@NotNull CharSequence[] charSequenceArr, @NotNull boolean[] zArr, @NotNull DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener, @NotNull DialogInterface.OnClickListener onClickListener, @NotNull DialogInterface.OnClickListener onClickListener2) {
        Intrinsics.checkNotNullParameter(charSequenceArr, "items");
        Intrinsics.checkNotNullParameter(zArr, "checkedItems");
        Intrinsics.checkNotNullParameter(onMultiChoiceClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(onClickListener, "okListener");
        Intrinsics.checkNotNullParameter(onClickListener2, "cancelListener");
        AlertDialog show = new AlertDialog.Builder(this.a).setCancelable(true).setMultiChoiceItems(charSequenceArr, zArr, onMultiChoiceClickListener).setPositiveButton(R.string.button_ready, onClickListener).setNegativeButton(R.string.button_dismiss, onClickListener2).show();
        Intrinsics.checkNotNullExpressionValue(show, "AlertDialog.Builder(acti…s, cancelListener).show()");
        return show;
    }

    @Override // com.avito.android.util.DialogRouter
    @NotNull
    public Dialog showNotifyingDialog(@Nullable String str, boolean z, @Nullable CharSequence charSequence, @NotNull String str2, @NotNull Function0<Unit> function0, @Nullable String str3, @Nullable Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(str2, "positiveButtonText");
        Intrinsics.checkNotNullParameter(function0, "positiveListener");
        f a3 = a(this.a);
        SimpleDialog simpleDialog = a3.a;
        AlertDialog alertDialog = a3.b;
        simpleDialog.setPrimaryButtonText(str2);
        simpleDialog.setPrimaryClickListener(new c(0, str2, function0, str3, function02));
        if (str3 != null) {
            simpleDialog.setSecondaryButtonText(str3);
            simpleDialog.setSecondaryClickListener(new c(1, str2, function0, str3, function02));
        } else {
            ButtonPanelsKt.hideSecondaryButton(simpleDialog);
        }
        if (charSequence == null) {
            simpleDialog.hideBody();
        } else {
            simpleDialog.setBody(charSequence);
        }
        if (str == null) {
            simpleDialog.hideTitle();
        } else {
            simpleDialog.setTitle(str);
        }
        alertDialog.setCancelable(z);
        alertDialog.show();
        return alertDialog;
    }

    @Override // com.avito.android.util.DialogRouter
    @NotNull
    public Dialog showNotifyingDialogWithEmbeddedLink(@NotNull String str, @NotNull String str2, @Nullable CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        f a3 = a(this.a);
        SimpleDialog simpleDialog = a3.a;
        AlertDialog alertDialog = a3.b;
        simpleDialog.setTitle(str);
        simpleDialog.setBody(str2);
        simpleDialog.setEmbeddedLink(charSequence);
        simpleDialog.setPrimaryButtonText(R.string.close);
        ButtonPanelsKt.hideSecondaryButton(simpleDialog);
        simpleDialog.setPrimaryClickListener(new h(str, str2, charSequence, alertDialog));
        alertDialog.show();
        return alertDialog;
    }

    @Override // com.avito.android.util.DialogRouter
    @NotNull
    public Dialog showNotifyingDialogWithImage(int i2, int i3, int i4, int i5, int i6, @NotNull Function1<? super AlertDialog, Unit> function1, @NotNull Function1<? super AlertDialog, Unit> function12, boolean z) {
        Intrinsics.checkNotNullParameter(function1, "cancelListener");
        Intrinsics.checkNotNullParameter(function12, "agreeListener");
        f a3 = a(this.a);
        SimpleDialog simpleDialog = a3.a;
        AlertDialog alertDialog = a3.b;
        simpleDialog.setImage(i2);
        simpleDialog.showImage();
        simpleDialog.setTitle(i3);
        simpleDialog.setBody(i4);
        simpleDialog.setSecondaryButtonText(i5);
        simpleDialog.setSecondaryClickListener(new d(0, i2, i3, i4, i5, i6, function1, alertDialog, function12));
        simpleDialog.setPrimaryButtonText(i6);
        simpleDialog.setPrimaryClickListener(new d(1, i2, i3, i4, i5, i6, function1, alertDialog, function12));
        alertDialog.setCancelable(z);
        alertDialog.show();
        return alertDialog;
    }

    @Override // com.avito.android.util.DialogRouter
    @NotNull
    public Dialog showSimpleNotifyingDialog(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(function0, "okListener");
        Intrinsics.checkNotNullParameter(function02, "dismissListener");
        f a3 = a(this.a);
        SimpleDialog simpleDialog = a3.a;
        AlertDialog alertDialog = a3.b;
        simpleDialog.hideTitle();
        simpleDialog.setBody(str);
        simpleDialog.setPrimaryButtonText(R.string.ok);
        ButtonPanelsKt.hideSecondaryButton(simpleDialog);
        simpleDialog.setPrimaryClickListener(new i(str, alertDialog, function0));
        alertDialog.show();
        alertDialog.setOnDismissListener(new m(function02));
        return alertDialog;
    }

    @Override // com.avito.android.util.DialogRouter
    @NotNull
    public Dialog showSimpleNotifyingDismissDialog(@NotNull String str, @NotNull String str2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(function0, "dismissListener");
        f a3 = a(this.a);
        SimpleDialog simpleDialog = a3.a;
        AlertDialog alertDialog = a3.b;
        simpleDialog.setTitle(str);
        simpleDialog.setBody(str2);
        simpleDialog.setPrimaryButtonText(R.string.ok);
        ButtonPanelsKt.hideSecondaryButton(simpleDialog);
        simpleDialog.setPrimaryClickListener(new n(str, str2, alertDialog));
        alertDialog.setOnDismissListener(new p(function0));
        alertDialog.setOnCancelListener(new q(function0));
        alertDialog.show();
        return alertDialog;
    }

    @Override // com.avito.android.util.DialogRouter
    @NotNull
    public Dialog showSimpleWaitingDialog() {
        Activity activity = this.a;
        ProgressDialog show = ProgressDialog.show(activity, null, activity.getString(R.string.wait), true, true);
        Intrinsics.checkNotNullExpressionValue(show, "ProgressDialog.show(acti…string.wait), true, true)");
        return show;
    }

    @Override // com.avito.android.util.DialogRouter
    @NotNull
    public Dialog showSimpleWaitingDialogWithMessage(@StringRes int i2) {
        String string = this.a.getString(i2);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(id)");
        return showSimpleWaitingDialogWithMessage(string);
    }

    @Override // com.avito.android.util.DialogRouter
    @NotNull
    public Dialog showSingleChoiceDialog(@NotNull ListAdapter listAdapter, int i2, @NotNull DialogInterface.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(listAdapter, "adapter");
        Intrinsics.checkNotNullParameter(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        AlertDialog show = new AlertDialog.Builder(this.a).setCancelable(true).setSingleChoiceItems(listAdapter, i2, new t(onClickListener)).show();
        Intrinsics.checkNotNullExpressionValue(show, "AlertDialog.Builder(acti…    }\n            .show()");
        return show;
    }

    @Override // com.avito.android.util.DialogRouter
    @NotNull
    public Dialog showSimpleWaitingDialogWithMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        ProgressDialog show = ProgressDialog.show(this.a, null, str, true, true);
        Intrinsics.checkNotNullExpressionValue(show, "ProgressDialog.show(acti…ull, message, true, true)");
        return show;
    }

    @Override // com.avito.android.util.DialogRouter
    @NotNull
    public Dialog showSimpleNotifyingDialog(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        f a3 = a(this.a);
        SimpleDialog simpleDialog = a3.a;
        AlertDialog alertDialog = a3.b;
        simpleDialog.setTitle(str);
        simpleDialog.setBody(str2);
        simpleDialog.setPrimaryButtonText(R.string.ok);
        ButtonPanelsKt.hideSecondaryButton(simpleDialog);
        simpleDialog.setPrimaryClickListener(new j(str, str2, alertDialog));
        alertDialog.show();
        return alertDialog;
    }

    @Override // com.avito.android.util.DialogRouter
    @NotNull
    public Dialog showSimpleNotifyingDismissDialog(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, "buttonText");
        Intrinsics.checkNotNullParameter(function0, "dismissListener");
        f a3 = a(this.a);
        SimpleDialog simpleDialog = a3.a;
        AlertDialog alertDialog = a3.b;
        simpleDialog.setTitle(str);
        simpleDialog.setBody(str2);
        simpleDialog.setPrimaryButtonText(str3);
        ButtonPanelsKt.hideSecondaryButton(simpleDialog);
        simpleDialog.setPrimaryClickListener(new o(str, str2, str3, alertDialog));
        alertDialog.setOnDismissListener(new r(function0));
        alertDialog.setOnCancelListener(new s(function0));
        alertDialog.show();
        return alertDialog;
    }

    @Override // com.avito.android.util.DialogRouter
    @NotNull
    public Dialog showNotifyingDialogWithImage(int i2, int i3, int i4, int i5, int i6, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, boolean z) {
        Intrinsics.checkNotNullParameter(function0, "cancelListener");
        Intrinsics.checkNotNullParameter(function02, "agreeListener");
        f a3 = a(this.a);
        SimpleDialog simpleDialog = a3.a;
        AlertDialog alertDialog = a3.b;
        simpleDialog.setImage(i2);
        simpleDialog.showImage();
        simpleDialog.setTitle(i3);
        simpleDialog.setBody(i4);
        simpleDialog.setSecondaryButtonText(i5);
        simpleDialog.setSecondaryClickListener(new b(0, i2, i3, i4, i5, i6, function0, function02));
        simpleDialog.setPrimaryButtonText(i6);
        simpleDialog.setPrimaryClickListener(new b(1, i2, i3, i4, i5, i6, function0, function02));
        alertDialog.setCancelable(z);
        alertDialog.show();
        return alertDialog;
    }

    @Override // com.avito.android.util.DialogRouter
    @NotNull
    public Dialog showSimpleNotifyingDialog(@NotNull String str, @NotNull String str2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, "buttonText");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        f a3 = a(this.a);
        SimpleDialog simpleDialog = a3.a;
        AlertDialog alertDialog = a3.b;
        simpleDialog.hideTitle();
        simpleDialog.setBody(str);
        simpleDialog.setPrimaryButtonText(str2);
        ButtonPanelsKt.hideSecondaryButton(simpleDialog);
        simpleDialog.setPrimaryClickListener(new k(str, str2, function0));
        alertDialog.setCancelable(false);
        alertDialog.show();
        return alertDialog;
    }

    @Override // com.avito.android.util.DialogRouter
    @NotNull
    public Dialog showSimpleNotifyingDialog(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, "buttonText");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        f a3 = a(this.a);
        SimpleDialog simpleDialog = a3.a;
        AlertDialog alertDialog = a3.b;
        simpleDialog.setTitle(str);
        simpleDialog.setBody(str2);
        simpleDialog.setPrimaryButtonText(str3);
        ButtonPanelsKt.hideSecondaryButton(simpleDialog);
        simpleDialog.setPrimaryClickListener(new l(str, str2, str3, function0));
        alertDialog.setCancelable(false);
        alertDialog.show();
        return alertDialog;
    }
}
