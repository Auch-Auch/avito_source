package com.avito.android.component;

import a2.a.a.a.a;
import android.view.View;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u0000 !2\u00020\u0001:\u0003\"!#J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0016R\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0016¨\u0006$"}, d2 = {"Lcom/avito/android/component/MessageInput;", "", "Lcom/avito/android/component/MessageInput$AttachButtonState;", "state", "", "setAttachmentButtonState", "(Lcom/avito/android/component/MessageInput$AttachButtonState;)V", "", "enabled", "setPhotoEnabled", "(Z)V", "", "text", "showKeyboard", "setText", "(Ljava/lang/CharSequence;Z)V", "clearText", "()V", "show", "hide", "Lio/reactivex/rxjava3/core/Observable;", "getPhotoButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "photoButtonClicks", "getTouches", "touches", "", "getSubmitButtonClicks", "submitButtonClicks", "getAttachmentButtonClicks", "attachmentButtonClicks", "getTextChanges", "textChanges", "Companion", "AttachButtonState", "SendPhotoButtonState", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface MessageInput {
    @NotNull
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/component/MessageInput$AttachButtonState;", "", "<init>", "(Ljava/lang/String;I)V", "VISIBLE", "DISABLED", "HIDDEN", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public enum AttachButtonState {
        VISIBLE,
        DISABLED,
        HIDDEN
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/component/MessageInput$Companion;", "", "Landroid/view/View;", "view", "Lcom/avito/android/component/MessageInput;", "create", "(Landroid/view/View;)Lcom/avito/android/component/MessageInput;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final MessageInput create(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return new a(view);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/component/MessageInput$SendPhotoButtonState;", "", "<init>", "(Ljava/lang/String;I)V", "SEND_PHOTO_ALLOW", "SEND_PHOTO_DISALLOW", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public enum SendPhotoButtonState {
        SEND_PHOTO_ALLOW,
        SEND_PHOTO_DISALLOW
    }

    void clearText();

    @NotNull
    Observable<Unit> getAttachmentButtonClicks();

    @NotNull
    Observable<Unit> getPhotoButtonClicks();

    @NotNull
    Observable<String> getSubmitButtonClicks();

    @NotNull
    Observable<CharSequence> getTextChanges();

    @NotNull
    Observable<Unit> getTouches();

    void hide();

    void setAttachmentButtonState(@NotNull AttachButtonState attachButtonState);

    void setPhotoEnabled(boolean z);

    void setText(@NotNull CharSequence charSequence, boolean z);

    void show();
}
