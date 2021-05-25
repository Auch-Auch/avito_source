package com.avito.android.messenger.conversation.adapter.file;

import android.content.Context;
import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.file.FileMessageView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.TextViews;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0018\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001b¨\u0006'"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/file/FileMessageViewDelegate;", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView;", "", "value", "", "setName", "(Ljava/lang/CharSequence;)V", "", "sizeInBytes", "setSize", "(J)V", "Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView$IconState;", "Lkotlin/Function0;", "onCancelClick", "setIconState", "(Lcom/avito/android/messenger/conversation/adapter/file/FileMessageView$IconState;Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/ProgressBar;", "e", "Landroid/widget/ProgressBar;", "progressBar", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "size", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "icon", AuthSource.BOOKING_ORDER, "name", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FileMessageViewDelegate implements FileMessageView {
    public final Context a;
    public final TextView b;
    public final TextView c;
    public final ImageView d;
    public final ProgressBar e;

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

    public FileMessageViewDelegate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = view.getContext();
        View findViewById = view.findViewById(R.id.message_file_name);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.message_file_size);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.message_file_icon);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        this.d = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.message_file_progress_bar);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.ProgressBar");
        this.e = (ProgressBar) findViewById4;
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        FileMessageView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.messenger.conversation.adapter.file.FileMessageView
    public void setIconState(@NotNull FileMessageView.IconState iconState, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(iconState, "value");
        Intrinsics.checkNotNullParameter(function0, "onCancelClick");
        if (Intrinsics.areEqual(iconState, FileMessageView.IconState.DownloadButton.INSTANCE)) {
            ProgressBar progressBar = this.e;
            progressBar.setOnClickListener(null);
            progressBar.post(new Runnable() { // from class: com.avito.android.messenger.conversation.adapter.file.FileMessageViewDelegate$sam$i$java_lang_Runnable$0
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
                }
            });
            this.d.setImageResource(R.drawable.ic_messenger_save_24_gray_28);
        } else if (Intrinsics.areEqual(iconState, FileMessageView.IconState.FileIcon.INSTANCE)) {
            ProgressBar progressBar2 = this.e;
            progressBar2.setOnClickListener(null);
            progressBar2.post(new Runnable() { // from class: com.avito.android.messenger.conversation.adapter.file.FileMessageViewDelegate$sam$i$java_lang_Runnable$0
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
                }
            });
            this.d.setImageResource(R.drawable.ic_messenger_file_24_gray_28);
        } else if (Intrinsics.areEqual(iconState, FileMessageView.IconState.TransferInProgress.INSTANCE)) {
            ProgressBar progressBar3 = this.e;
            progressBar3.setOnClickListener(new a(function0));
            progressBar3.post(new Runnable() { // from class: com.avito.android.messenger.conversation.adapter.file.FileMessageViewDelegate$sam$i$java_lang_Runnable$0
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
                }
            });
            this.d.setImageResource(R.drawable.ic_close_10_gray_28);
        }
    }

    @Override // com.avito.android.messenger.conversation.adapter.file.FileMessageView
    public void setName(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        TextViews.bindText$default(this.b, charSequence, false, 2, null);
    }

    @Override // com.avito.android.messenger.conversation.adapter.file.FileMessageView
    public void setSize(long j) {
        TextView textView = this.c;
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TextViews.bindText$default(textView, Formatter.formatShortFileSize(context.getApplicationContext(), j), false, 2, null);
    }
}
