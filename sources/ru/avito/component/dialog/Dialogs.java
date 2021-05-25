package ru.avito.component.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeEmitter;
import io.reactivex.rxjava3.core.MaybeOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lru/avito/component/dialog/Dialogs;", "", "Landroid/content/Context;", "context", "Lio/reactivex/rxjava3/core/Maybe;", "", "showEnableNotifications", "(Landroid/content/Context;)Lio/reactivex/rxjava3/core/Maybe;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class Dialogs {
    @NotNull
    public static final Dialogs INSTANCE = new Dialogs();

    public static final class a<T> implements MaybeOnSubscribe<Unit> {
        public final /* synthetic */ Context a;

        /* compiled from: kotlin-style lambda group */
        /* renamed from: ru.avito.component.dialog.Dialogs$a$a  reason: collision with other inner class name */
        public static final class C0673a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ int a;
            public final /* synthetic */ Object b;
            public final /* synthetic */ Object c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0673a(int i, Object obj, Object obj2) {
                super(0);
                this.a = i;
                this.b = obj;
                this.c = obj2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: io.reactivex.rxjava3.core.MaybeEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                int i = this.a;
                if (i == 0) {
                    Unit unit = Unit.INSTANCE;
                    ((MaybeEmitter) this.b).onSuccess(unit);
                    ((AlertDialog) this.c).dismiss();
                    return unit;
                } else if (i == 1) {
                    ((MaybeEmitter) this.b).onComplete();
                    ((AlertDialog) this.c).dismiss();
                    return Unit.INSTANCE;
                } else {
                    throw null;
                }
            }
        }

        public static final class b implements Cancellable {
            public final /* synthetic */ AlertDialog a;

            public b(AlertDialog alertDialog) {
                this.a = alertDialog;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.dismiss();
            }
        }

        public a(Context context) {
            this.a = context;
        }

        @Override // io.reactivex.rxjava3.core.MaybeOnSubscribe
        public final void subscribe(MaybeEmitter<Unit> maybeEmitter) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.simple_dialog, (ViewGroup) null);
            AlertDialog create = new AlertDialog.Builder(this.a).setView(inflate).create();
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            SimpleDialogImpl simpleDialogImpl = new SimpleDialogImpl(inflate);
            simpleDialogImpl.setImage(Contexts.getDrawableByAttr(this.a, com.avito.android.lib.design.R.attr.img_dialogNotifications));
            simpleDialogImpl.showImage();
            simpleDialogImpl.setTitle(R.string.notifications_settings_dialog_title);
            simpleDialogImpl.setBody(R.string.notifications_settings_dialog_body);
            simpleDialogImpl.setPrimaryButtonText(R.string.notifications_settings_dialog_button_primary);
            simpleDialogImpl.setSecondaryButtonText(R.string.notifications_settings_dialog_button_secondary);
            simpleDialogImpl.setPrimaryClickListener(new C0673a(0, maybeEmitter, create));
            simpleDialogImpl.setSecondaryClickListener(new C0673a(1, maybeEmitter, create));
            maybeEmitter.setCancellable(new b(create));
            create.show();
        }
    }

    @NotNull
    public final Maybe<Unit> showEnableNotifications(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Maybe<Unit> create = Maybe.create(new a(context));
        Intrinsics.checkNotNullExpressionValue(create, "Maybe.create { emitter -… alertDialog.show()\n    }");
        return create;
    }
}
