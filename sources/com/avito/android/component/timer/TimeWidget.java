package com.avito.android.component.timer;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/avito/android/component/timer/TimeWidget;", "", "", "onFinish", "()V", "", "hours", "setHours", "(Ljava/lang/String;)V", "minutes", "setMinutes", "seconds", "setSeconds", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface TimeWidget {
    void onFinish();

    void setHours(@NotNull String str);

    void setMinutes(@NotNull String str);

    void setSeconds(@NotNull String str);
}
