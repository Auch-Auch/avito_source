package com.avito.android.design.widget;

import androidx.annotation.StringRes;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\r\u0010\tJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0011\u0010\tJ\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0012\u0010\u000fJ\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0014\u0010\tJ\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/design/widget/PostingView;", "", "", "stringRes", "", "setError", "(I)V", "", "error", "(Ljava/lang/CharSequence;)V", "clearError", "()V", "info", "setInfo", "getInfo", "()Ljava/lang/CharSequence;", "title", "setTitle", "getTitle", "value", "setValue", "getValue", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface PostingView {
    void clearError();

    @Nullable
    CharSequence getInfo();

    @Nullable
    CharSequence getTitle();

    @Nullable
    CharSequence getValue();

    void setError(@StringRes int i);

    void setError(@Nullable CharSequence charSequence);

    void setInfo(@Nullable CharSequence charSequence);

    void setTitle(@Nullable CharSequence charSequence);

    void setValue(@Nullable CharSequence charSequence);
}
