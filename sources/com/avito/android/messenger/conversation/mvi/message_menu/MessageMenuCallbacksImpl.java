package com.avito.android.messenger.conversation.mvi.message_menu;

import android.app.Application;
import android.content.ClipData;
import android.content.res.Resources;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.messenger.R;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.google.android.exoplayer2.util.MimeTypes;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u000fR\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016¨\u0006&"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuCallbacksImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageMenuCallbacks;", "Landroid/content/ClipData;", "data", "", "saveToClipboard", "(Landroid/content/ClipData;)V", "", "url", "openInBrowser", "(Ljava/lang/String;)V", "", "error", "onDeletePendingMessageFailure", "(Ljava/lang/Throwable;)V", "onRetrySendingMessageFailure", "onDeleteRemoteMessageFailure", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "getToastStream", "()Landroidx/lifecycle/MutableLiveData;", "toastStream", "c", "getUrlNavigationStream", "urlNavigationStream", "Landroid/content/res/Resources;", "f", "Landroid/content/res/Resources;", "resources", "e", "getCopyToClipboardStream", "copyToClipboardStream", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "<init>", "(Landroid/content/res/Resources;Landroid/app/Application;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageMenuCallbacksImpl extends ViewModel implements MessageMenuCallbacks {
    @NotNull
    public final MutableLiveData<String> c = new SingleLiveEvent();
    @NotNull
    public final MutableLiveData<String> d = new SingleLiveEvent();
    @NotNull
    public final MutableLiveData<ClipData> e = new SingleLiveEvent();
    public final Resources f;

    @Inject
    public MessageMenuCallbacksImpl(@NotNull Resources resources, @NotNull Application application) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        this.f = resources;
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_local.DeleteLocalMessageElementProvider.Callback
    public void onDeletePendingMessageFailure(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        getToastStream().postValue(this.f.getString(R.string.messenger_delete_message_error));
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.elements.delete_remote.DeleteRemoteMessageElementProvider.Callback
    public void onDeleteRemoteMessageFailure(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        getToastStream().postValue(this.f.getString(R.string.messenger_delete_message_error));
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.elements.RetrySendingMessageElementProvider.Callback
    public void onRetrySendingMessageFailure(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        getToastStream().postValue(this.f.getString(R.string.messenger_retry_sending_error));
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.elements.OpenInBrowserElementProvider.Callback
    public void openInBrowser(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        getUrlNavigationStream().postValue(str);
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.elements.CopyToClipboardElementProvider.Callback
    public void saveToClipboard(@NotNull ClipData clipData) {
        Intrinsics.checkNotNullParameter(clipData, "data");
        getCopyToClipboardStream().postValue(clipData);
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuCallbacks
    @NotNull
    public MutableLiveData<ClipData> getCopyToClipboardStream() {
        return this.e;
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuCallbacks
    @NotNull
    public MutableLiveData<String> getToastStream() {
        return this.d;
    }

    @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuCallbacks
    @NotNull
    public MutableLiveData<String> getUrlNavigationStream() {
        return this.c;
    }
}
