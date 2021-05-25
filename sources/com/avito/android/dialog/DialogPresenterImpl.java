package com.avito.android.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.UserDialog;
import com.avito.android.ui_components.R;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Maybies;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.functions.Cancellable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\"\u0010#J9\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJC\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\rJ/\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000eJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\n\u0010\u0012J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/dialog/DialogPresenterImpl;", "Lcom/avito/android/dialog/DialogPresenter;", "", "title", "message", "positiveButtonText", "", "cancelable", "Lio/reactivex/Maybe;", "", "showDialog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Maybe;", "negativeButtonText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Maybe;", "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Maybe;", "Lcom/avito/android/remote/model/UserDialog;", "userDialog", "Lcom/avito/android/deep_linking/links/DeepLink;", "(Lcom/avito/android/remote/model/UserDialog;)Lio/reactivex/Maybe;", "Lio/reactivex/rxjava3/core/Maybe;", "showDialog3", "(Lcom/avito/android/remote/model/UserDialog;)Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/remote/model/Action;", "action", "wrapActionToDialog", "(Lcom/avito/android/remote/model/Action;)Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/util/DialogRouter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Landroid/app/Activity;", AuthSource.SEND_ABUSE, "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;Lcom/avito/android/util/DialogRouter;)V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public final class DialogPresenterImpl implements DialogPresenter {
    public final Activity a;
    public final DialogRouter b;

    public static final class a<T> implements MaybeOnSubscribe<Unit> {
        public final /* synthetic */ DialogPresenterImpl a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        /* renamed from: com.avito.android.dialog.DialogPresenterImpl$a$a  reason: collision with other inner class name */
        public static final class C0136a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ MaybeEmitter a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0136a(MaybeEmitter maybeEmitter) {
                super(0);
                this.a = maybeEmitter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.MaybeEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                MaybeEmitter maybeEmitter = this.a;
                Unit unit = Unit.INSTANCE;
                maybeEmitter.onSuccess(unit);
                return unit;
            }
        }

        public static final class b extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Ref.ObjectRef a;
            public final /* synthetic */ MaybeEmitter b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Ref.ObjectRef objectRef, MaybeEmitter maybeEmitter) {
                super(0);
                this.a = objectRef;
                this.b = maybeEmitter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                T t = this.a.element;
                if (t != null) {
                    t.dismiss();
                }
                this.b.onComplete();
                return Unit.INSTANCE;
            }
        }

        public static final class c implements DialogInterface.OnDismissListener {
            public final /* synthetic */ MaybeEmitter a;

            public c(MaybeEmitter maybeEmitter) {
                this.a = maybeEmitter;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.a.onComplete();
            }
        }

        public static final class d implements Cancellable {
            public final /* synthetic */ Ref.ObjectRef a;

            public d(Ref.ObjectRef objectRef) {
                this.a = objectRef;
            }

            @Override // io.reactivex.functions.Cancellable
            public final void cancel() {
                this.a.element.dismiss();
            }
        }

        public a(DialogPresenterImpl dialogPresenterImpl, boolean z, String str, String str2, String str3, String str4) {
            this.a = dialogPresenterImpl;
            this.b = z;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
            if (r1 != null) goto L_0x003d;
         */
        @Override // io.reactivex.MaybeOnSubscribe
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void subscribe(@org.jetbrains.annotations.NotNull io.reactivex.MaybeEmitter<kotlin.Unit> r12) {
            /*
                r11 = this;
                java.lang.String r0 = "emitter"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
                r0.<init>()
                r1 = 0
                r0.element = r1
                com.avito.android.dialog.DialogPresenterImpl r2 = r11.a
                com.avito.android.util.DialogRouter r3 = com.avito.android.dialog.DialogPresenterImpl.access$getDialogRouter$p(r2)
                boolean r5 = r11.b
                java.lang.String r4 = r11.c
                java.lang.String r6 = r11.d
                java.lang.String r2 = r11.e
                if (r2 == 0) goto L_0x002c
                int r7 = r2.length()
                if (r7 <= 0) goto L_0x0025
                r7 = 1
                goto L_0x0026
            L_0x0025:
                r7 = 0
            L_0x0026:
                if (r7 == 0) goto L_0x0029
                r1 = r2
            L_0x0029:
                if (r1 == 0) goto L_0x002c
                goto L_0x003d
            L_0x002c:
                com.avito.android.dialog.DialogPresenterImpl r1 = r11.a
                android.app.Activity r1 = com.avito.android.dialog.DialogPresenterImpl.access$getActivity$p(r1)
                int r2 = com.avito.android.ui_components.R.string.ok
                java.lang.String r1 = r1.getString(r2)
                java.lang.String r2 = "activity.getString(ui_R.string.ok)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            L_0x003d:
                r7 = r1
                java.lang.String r9 = r11.f
                com.avito.android.dialog.DialogPresenterImpl$a$a r8 = new com.avito.android.dialog.DialogPresenterImpl$a$a
                r8.<init>(r12)
                com.avito.android.dialog.DialogPresenterImpl$a$b r10 = new com.avito.android.dialog.DialogPresenterImpl$a$b
                r10.<init>(r0, r12)
                android.app.Dialog r1 = r3.showNotifyingDialog(r4, r5, r6, r7, r8, r9, r10)
                r0.element = r1
                com.avito.android.dialog.DialogPresenterImpl$a$c r2 = new com.avito.android.dialog.DialogPresenterImpl$a$c
                r2.<init>(r12)
                r1.setOnDismissListener(r2)
                com.avito.android.dialog.DialogPresenterImpl$a$d r1 = new com.avito.android.dialog.DialogPresenterImpl$a$d
                r1.<init>(r0)
                r12.setCancellable(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.dialog.DialogPresenterImpl.a.subscribe(io.reactivex.MaybeEmitter):void");
        }
    }

    public static final class b<T> implements MaybeOnSubscribe<Unit> {
        public final /* synthetic */ DialogPresenterImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public static final class a implements DialogInterface.OnDismissListener {
            public final /* synthetic */ MaybeEmitter a;

            public a(MaybeEmitter maybeEmitter) {
                this.a = maybeEmitter;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.a.onComplete();
            }
        }

        /* renamed from: com.avito.android.dialog.DialogPresenterImpl$b$b  reason: collision with other inner class name */
        public static final class C0137b implements Cancellable {
            public final /* synthetic */ Dialog a;

            public C0137b(Dialog dialog) {
                this.a = dialog;
            }

            @Override // io.reactivex.functions.Cancellable
            public final void cancel() {
                this.a.dismiss();
            }
        }

        public static final class c extends Lambda implements Function0<Unit> {
            public final /* synthetic */ MaybeEmitter a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(MaybeEmitter maybeEmitter) {
                super(0);
                this.a = maybeEmitter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.MaybeEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                MaybeEmitter maybeEmitter = this.a;
                Unit unit = Unit.INSTANCE;
                maybeEmitter.onSuccess(unit);
                return unit;
            }
        }

        public b(DialogPresenterImpl dialogPresenterImpl, String str, String str2) {
            this.a = dialogPresenterImpl;
            this.b = str;
            this.c = str2;
        }

        @Override // io.reactivex.MaybeOnSubscribe
        public final void subscribe(@NotNull MaybeEmitter<Unit> maybeEmitter) {
            Dialog dialog;
            Intrinsics.checkNotNullParameter(maybeEmitter, "emitter");
            c cVar = new c(maybeEmitter);
            String str = this.b;
            String str2 = null;
            if (str != null) {
                if (!(str.length() > 0)) {
                    str = null;
                }
                str2 = str;
            }
            if (str2 != null) {
                DialogRouter dialogRouter = this.a.b;
                String str3 = this.b;
                String str4 = this.c;
                String string = this.a.a.getString(R.string.ok);
                Intrinsics.checkNotNullExpressionValue(string, "activity.getString(ui_R.string.ok)");
                dialog = dialogRouter.showSimpleNotifyingDialog(str3, str4, string, cVar);
            } else {
                DialogRouter dialogRouter2 = this.a.b;
                String str5 = this.c;
                String string2 = this.a.a.getString(R.string.ok);
                Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(ui_R.string.ok)");
                dialog = dialogRouter2.showSimpleNotifyingDialog(str5, string2, cVar);
            }
            dialog.setOnDismissListener(new a(maybeEmitter));
            maybeEmitter.setCancellable(new C0137b(dialog));
        }
    }

    public static final class c<T, R> implements Function<Unit, DeepLink> {
        public final /* synthetic */ Action a;

        public c(Action action) {
            this.a = action;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public DeepLink apply(Unit unit) {
            DeepLink deepLink;
            Intrinsics.checkNotNullParameter(unit, "it");
            Action action = this.a;
            return (action == null || (deepLink = action.getDeepLink()) == null) ? new NoMatchLink() : deepLink;
        }
    }

    public static final class d<T, R> implements io.reactivex.rxjava3.functions.Function<Unit, DeepLink> {
        public final /* synthetic */ Action a;

        public d(Action action) {
            this.a = action;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public DeepLink apply(Unit unit) {
            DeepLink deepLink;
            Action action = this.a;
            return (action == null || (deepLink = action.getDeepLink()) == null) ? new NoMatchLink() : deepLink;
        }
    }

    @Inject
    public DialogPresenterImpl(@NotNull Activity activity, @NotNull DialogRouter dialogRouter) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        this.a = activity;
        this.b = dialogRouter;
    }

    @Override // com.avito.android.dialog.DialogPresenter
    @NotNull
    public Maybe<Unit> showDialog(@Nullable String str, @NotNull String str2, @Nullable String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str2, "message");
        return showDialog(str, str2, str3, z ? this.a.getString(R.string.cancel) : null, z);
    }

    @Override // com.avito.android.dialog.DialogPresenter
    @NotNull
    public io.reactivex.rxjava3.core.Maybe<DeepLink> showDialog3(@NotNull UserDialog userDialog) {
        io.reactivex.rxjava3.core.Maybe maybe;
        Intrinsics.checkNotNullParameter(userDialog, "userDialog");
        List<Action> actions = userDialog.getActions();
        Action action = actions != null ? (Action) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) actions) : null;
        if (action == null || (action.getDeepLink() instanceof NoMatchLink)) {
            maybe = InteropKt.toV3(showDialog(userDialog.getTitle(), userDialog.getMessage(), userDialog.getCancelable()));
        } else {
            maybe = InteropKt.toV3(showDialog(userDialog.getTitle(), userDialog.getMessage(), action.getTitle(), userDialog.getCancelable()));
        }
        io.reactivex.rxjava3.core.Maybe<DeepLink> map = maybe.map(new d(action));
        Intrinsics.checkNotNullExpressionValue(map, "if (action != null && ac…epLink ?: NoMatchLink() }");
        return map;
    }

    @Override // com.avito.android.dialog.DialogPresenter
    @NotNull
    public io.reactivex.rxjava3.core.Maybe<DeepLink> wrapActionToDialog(@NotNull Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Action.Confirmation confirmation = action.getConfirmation();
        if (confirmation != null) {
            return InteropKt.toV3(showDialog(new UserDialog(confirmation.getTitle(), confirmation.getDescription(), t6.n.d.listOf(new Action(confirmation.getOk(), action.getDeepLink(), null, null, null, null, 60, null)), false, 8, null)));
        }
        return InteropKt.toV3(Maybies.toMaybe(action.getDeepLink()));
    }

    @Override // com.avito.android.dialog.DialogPresenter
    @NotNull
    public Maybe<Unit> showDialog(@Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str2, "message");
        Maybe<Unit> create = Maybe.create(new a(this, z, str, str2, str3, str4));
        Intrinsics.checkNotNullExpressionValue(create, "Maybe.create { emitter -… dialog.dismiss() }\n    }");
        return create;
    }

    @Override // com.avito.android.dialog.DialogPresenter
    @NotNull
    public Maybe<Unit> showDialog(@Nullable String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str2, "message");
        Maybe<Unit> create = Maybe.create(new b(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(create, "Maybe.create { emitter -… dialog.dismiss() }\n    }");
        return create;
    }

    @Override // com.avito.android.dialog.DialogPresenter
    @NotNull
    public Maybe<DeepLink> showDialog(@NotNull UserDialog userDialog) {
        Maybe<Unit> maybe;
        Intrinsics.checkNotNullParameter(userDialog, "userDialog");
        List<Action> actions = userDialog.getActions();
        Action action = actions != null ? (Action) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) actions) : null;
        if (action == null || (action.getDeepLink() instanceof NoMatchLink)) {
            maybe = showDialog(userDialog.getTitle(), userDialog.getMessage(), userDialog.getCancelable());
        } else {
            maybe = showDialog(userDialog.getTitle(), userDialog.getMessage(), action.getTitle(), userDialog.getCancelable());
        }
        Maybe<R> map = maybe.map(new c(action));
        Intrinsics.checkNotNullExpressionValue(map, "if (action != null && ac…epLink ?: NoMatchLink() }");
        return map;
    }
}
