package com.avito.android.info.ui;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/info/ui/InfoView;", "", "", "baseUrl", "text", "", "setContent", "(Ljava/lang/String;Ljava/lang/String;)V", "title", "setTitle", "(Ljava/lang/String;)V", "showError", "()V", "showContent", "showProgress", "Callback", "info_release"}, k = 1, mv = {1, 4, 2})
public interface InfoView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/info/ui/InfoView$Callback;", "", "", "close", "()V", "refresh", "info_release"}, k = 1, mv = {1, 4, 2})
    public interface Callback {
        void close();

        void refresh();
    }

    void setContent(@Nullable String str, @NotNull String str2);

    void setTitle(@NotNull String str);

    void showContent();

    void showError();

    void showProgress();
}
