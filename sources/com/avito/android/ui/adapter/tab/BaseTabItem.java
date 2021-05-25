package com.avito.android.ui.adapter.tab;

import android.os.Parcelable;
import com.avito.android.design.widget.tab.Tab;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/ui/adapter/tab/BaseTabItem;", "Lcom/avito/android/design/widget/tab/Tab;", "Landroid/os/Parcelable;", "", "c", "Ljava/lang/String;", "getShortcut", "()Ljava/lang/String;", "shortcut", AuthSource.SEND_ABUSE, "getTitle", "title", "getLabel", "label", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getCount", "()Ljava/lang/Integer;", "count", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseTabItem implements Tab, Parcelable {
    @NotNull
    public final String a;
    @Nullable
    public final Integer b;
    @NotNull
    public final String c;

    public BaseTabItem(@NotNull String str, @Nullable Integer num, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "shortcut");
        this.a = str;
        this.b = num;
        this.c = str2;
    }

    @Nullable
    public Integer getCount() {
        return this.b;
    }

    @Override // com.avito.android.design.widget.tab.Tab
    @Nullable
    public String getLabel() {
        Integer count = getCount();
        if (count != null) {
            return String.valueOf(count.intValue());
        }
        return null;
    }

    @NotNull
    public String getShortcut() {
        return this.c;
    }

    @Override // com.avito.android.design.widget.tab.Tab
    @NotNull
    public String getTitle() {
        return this.a;
    }
}
