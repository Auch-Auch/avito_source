package com.avito.android.messenger.channels.mvi.presenter;

import android.content.Context;
import androidx.appcompat.view.ContextThemeWrapper;
import com.avito.android.lib.design.avito.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.text.AttributedTextFormatter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/LocalMessagePreviewProviderImpl;", "Lcom/avito/android/messenger/channels/mvi/presenter/LocalMessagePreviewProvider;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "message", "Lcom/avito/android/messenger/channels/mvi/presenter/MessagePreview;", "getPreviewText", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;)Lcom/avito/android/messenger/channels/mvi/presenter/MessagePreview;", "Landroidx/appcompat/view/ContextThemeWrapper;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/view/ContextThemeWrapper;", "context", "Lcom/avito/android/util/text/AttributedTextFormatter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class LocalMessagePreviewProviderImpl implements LocalMessagePreviewProvider {
    public final ContextThemeWrapper a;
    public final AttributedTextFormatter b;

    @Inject
    public LocalMessagePreviewProviderImpl(@NotNull Context context, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.b = attributedTextFormatter;
        this.a = new ContextThemeWrapper(context, R.style.Theme_DesignSystem_Avito);
    }

    /* JADX WARNING: Removed duplicated region for block: B:81:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01ae  */
    @Override // com.avito.android.messenger.channels.mvi.presenter.LocalMessagePreviewProvider
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.messenger.channels.mvi.presenter.MessagePreview getPreviewText(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.messenger.message.LocalMessage r8) {
        /*
        // Method dump skipped, instructions count: 511
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.channels.mvi.presenter.LocalMessagePreviewProviderImpl.getPreviewText(com.avito.android.remote.model.messenger.message.LocalMessage):com.avito.android.messenger.channels.mvi.presenter.MessagePreview");
    }
}
