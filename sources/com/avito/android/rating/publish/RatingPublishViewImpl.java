package com.avito.android.rating.publish;

import a2.a.a.g2.b.j;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.rating.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001f\u0010 J)\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u000bJQ\u0010\u0013\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001b¨\u0006!"}, d2 = {"Lcom/avito/android/rating/publish/RatingPublishViewImpl;", "Lcom/avito/android/rating/publish/RatingPublishView;", "", "message", "Lkotlin/Function0;", "", "Lcom/avito/android/util/ActionHandler;", "dismissAction", "showSnackbar", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "showProgress", "()V", "hideProgress", "title", "", "cancelable", "actionListener", "actionTitle", "closeListener", "showErrorDialog", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/lib/design/dialog/Dialog;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/dialog/Dialog;", "dialog", "Landroid/view/View;", "c", "Landroid/view/View;", "view", AuthSource.SEND_ABUSE, "loader", "<init>", "(Landroid/view/View;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingPublishViewImpl implements RatingPublishView {
    public final View a;
    public Dialog b;
    public final View c;

    public static final class a extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Function0 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Function0 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, boolean z, Function0 function0, String str3, Function0 function02) {
            super(2);
            this.a = str;
            this.b = str2;
            this.c = z;
            this.d = function0;
            this.e = str3;
            this.f = function02;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
            Dialog.Config config2 = config;
            DialogInterface dialogInterface2 = dialogInterface;
            Intrinsics.checkNotNullParameter(config2, "$receiver");
            Intrinsics.checkNotNullParameter(dialogInterface2, "it");
            config2.setTitle(this.a);
            config2.setSubtitle(this.b);
            config2.setCloseButtonVisible(this.c);
            if (this.d != null) {
                String str = this.e;
                if (str != null) {
                    config2.addPrimaryButton(str, new j(this, config2, dialogInterface2));
                } else {
                    config2.addPrimaryButton(R.string.continue_button_title, new k4(1, this, dialogInterface2));
                }
            }
            if (this.f != null) {
                config2.setOnCloseClickedListener(new k4(0, this, config2));
            }
            return Unit.INSTANCE;
        }
    }

    public RatingPublishViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.c = view;
        View findViewById = view.findViewById(R.id.progress);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
    }

    @Override // com.avito.android.rating.publish.RatingPublishView
    public void hideProgress() {
        Views.hide(this.a);
    }

    @Override // com.avito.android.rating.publish.RatingPublishView
    public void showErrorDialog(@NotNull String str, @NotNull String str2, boolean z, @Nullable Function0<Unit> function0, @Nullable String str3, @Nullable Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Dialog dialog = this.b;
        if (dialog != null) {
            dialog.dismiss();
        }
        Dialog.Companion companion = Dialog.Companion;
        Context context = this.c.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Dialog create$default = Dialog.Companion.create$default(companion, context, 0, 0, new a(str, str2, z, function0, str3, function02), 6, null);
        this.b = create$default;
        if (create$default != null) {
            create$default.show();
        }
    }

    @Override // com.avito.android.rating.publish.RatingPublishView
    public void showProgress() {
        Views.show(this.a);
    }

    @Override // com.avito.android.rating.publish.RatingPublishView
    public void showSnackbar(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(function0, "dismissAction");
        Views.showSnackBar$default(this.c, str, 0, (String) null, 0, (Function0) null, function0, 0, 94, (Object) null);
    }
}
