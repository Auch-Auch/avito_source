package com.avito.android.developments_catalog.analytics;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001JA\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000f\u0010\u000eJ9\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/developments_catalog/analytics/DevelopmentsCatalogAnalyticsInteractor;", "", "", "developmentId", "", "", "metroIds", "searchContext", "locationId", "fromPage", "", "sendShowDevelopments", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sendShareEvent", "(Ljava/lang/String;Ljava/lang/String;)V", "sendCallEvent", "sendShowPhone", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "sendAvitoOfferEvent", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "sendClickToConsultationItemButton", "(Ljava/lang/String;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface DevelopmentsCatalogAnalyticsInteractor {
    void sendAvitoOfferEvent(@NotNull String str, @NotNull List<Integer> list, @Nullable String str2);

    void sendCallEvent(@NotNull String str, @Nullable String str2);

    void sendClickToConsultationItemButton(@NotNull String str);

    void sendShareEvent(@NotNull String str, @Nullable String str2);

    void sendShowDevelopments(@NotNull String str, @NotNull List<Integer> list, @Nullable String str2, @Nullable String str3, @NotNull String str4);

    void sendShowPhone(@NotNull String str, @NotNull List<Integer> list, @Nullable String str2, @Nullable String str3);
}
