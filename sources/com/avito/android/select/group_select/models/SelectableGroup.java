package com.avito.android.select.group_select.models;

import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/select/group_select/models/SelectableGroup;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "Lcom/avito/android/select/group_select/models/SelectableOption;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectableGroup {
    @Nullable
    public final String a;
    @NotNull
    public final List<SelectableOption> b;

    public SelectableGroup(@Nullable String str, @NotNull List<SelectableOption> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.a = str;
        this.b = list;
    }

    @NotNull
    public final List<SelectableOption> getItems() {
        return this.b;
    }

    @Nullable
    public final String getTitle() {
        return this.a;
    }
}
