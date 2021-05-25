package com.avito.android.messenger.conversation.adapter.deleted;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.deleted.DeletedMessageView;
import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0015\u001a\n \u000e*\u0004\u0018\u00010\u00120\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/deleted/DeletedMessageViewDelegate;", "Lcom/avito/android/messenger/conversation/adapter/deleted/DeletedMessageView;", "", "text", "", "setText", "(Ljava/lang/CharSequence;)V", "showInfoPopup", "()V", "Landroid/view/View;", "c", "Landroid/view/View;", "view", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/view/LayoutInflater;", "inflater", "Landroid/widget/LinearLayout;", AuthSource.BOOKING_ORDER, "Landroid/widget/LinearLayout;", "messageBody", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DeletedMessageViewDelegate implements DeletedMessageView {
    public final LayoutInflater a;
    public final LinearLayout b;
    public final View c;

    public static final class a extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
            Dialog.Config config2 = config;
            DialogInterface dialogInterface2 = dialogInterface;
            Intrinsics.checkNotNullParameter(config2, "$receiver");
            Intrinsics.checkNotNullParameter(dialogInterface2, "dialog");
            config2.setCancelable(true);
            config2.setSubtitle(R.string.messenger_deleted_message_popup_text);
            config2.addDefaultButton(R.string.messenger_deleted_message_popup_ok, new a2.a.a.o1.d.y.a.a(dialogInterface2));
            return Unit.INSTANCE;
        }
    }

    public DeletedMessageViewDelegate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.c = view;
        this.a = LayoutInflater.from(view.getContext());
        this.b = (LinearLayout) view.findViewById(R.id.message);
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        DeletedMessageView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.messenger.conversation.adapter.deleted.DeletedMessageView
    public void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.b.removeAllViews();
        LinearLayout linearLayout = this.b;
        View inflate = this.a.inflate(R.layout.messenger_deleted_bubble_body_plain_text_view, (ViewGroup) linearLayout, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) inflate;
        textView.setText(charSequence);
        linearLayout.addView(textView);
    }

    @Override // com.avito.android.messenger.conversation.adapter.deleted.DeletedMessageView
    public void showInfoPopup() {
        Dialog.Companion companion = Dialog.Companion;
        Context context = this.c.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Dialog.Companion.create$default(companion, context, 0, 0, a.a, 6, null).show();
    }
}
