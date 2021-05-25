package com.avito.android.publish.view.publish_button;

import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H&¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0003H&¢\u0006\u0004\b\u0015\u0010\u000fJ\u000f\u0010\u0016\u001a\u00020\u0003H&¢\u0006\u0004\b\u0016\u0010\u000fJ\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u0014R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/avito/android/publish/view/publish_button/PublishButton;", "", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "getHeight", "()I", "", "text", "setText", "(Ljava/lang/String;)V", "enable", "()V", "disable", "", "isVisible", "setProgressBarVisible", "(Z)V", "hide", "show", "isEnabled", "setEnabled", "setVisible", "Landroid/view/View;", "getButtonView", "()Landroid/view/View;", "buttonView", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface PublishButton {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void setEnabled(@NotNull PublishButton publishButton, boolean z) {
            if (z) {
                publishButton.enable();
            } else {
                publishButton.disable();
            }
        }

        public static void setVisible(@NotNull PublishButton publishButton, boolean z) {
            if (z) {
                publishButton.show();
            } else {
                publishButton.hide();
            }
        }
    }

    void disable();

    void enable();

    @Nullable
    View getButtonView();

    int getHeight();

    void hide();

    void setClickListener(@Nullable Function0<Unit> function0);

    void setEnabled(boolean z);

    void setProgressBarVisible(boolean z);

    void setText(@NotNull String str);

    void setVisible(boolean z);

    void show();
}
