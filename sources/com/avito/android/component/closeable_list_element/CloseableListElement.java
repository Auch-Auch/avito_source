package com.avito.android.component.closeable_list_element;

import androidx.annotation.StringRes;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\bJ\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\bJ\u001f\u0010\r\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/component/closeable_list_element/CloseableListElement;", "", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "(I)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnCloseClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setOnClickListener", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface CloseableListElement {
    void setOnClickListener(@Nullable Function0<Unit> function0);

    void setOnCloseClickListener(@Nullable Function0<Unit> function0);

    void setSubtitle(@StringRes int i);

    void setSubtitle(@Nullable String str);

    void setTitle(@StringRes int i);

    void setTitle(@NotNull String str);
}
