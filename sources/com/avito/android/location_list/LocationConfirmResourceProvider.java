package com.avito.android.location_list;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/location_list/LocationConfirmResourceProvider;", "", "", "name", "getYouLocationMessage", "(Ljava/lang/String;)Ljava/lang/String;", "getNotFoundMessage", "()Ljava/lang/String;", "getDecline", "getConfirm", "location-list_release"}, k = 1, mv = {1, 4, 2})
public interface LocationConfirmResourceProvider {
    @NotNull
    String getConfirm();

    @NotNull
    String getDecline();

    @NotNull
    String getNotFoundMessage();

    @NotNull
    String getYouLocationMessage(@NotNull String str);
}
