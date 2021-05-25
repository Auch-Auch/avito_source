package com.avito.android.developments_catalog;

import com.avito.android.PhoneRequestDeepLinkAnalyticsData;
import com.avito.android.advert_core.map.MapPreviewRouter;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.remote.model.ConsultationFormData;
import com.avito.android.remote.model.Image;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ;\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&¢\u0006\u0004\b \u0010!J\u001f\u0010%\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H&¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;", "Lcom/avito/android/advert_core/map/MapPreviewRouter;", "", "closeScreen", "()V", "", "url", "title", "openNativeShareDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "", "currentPosition", "", "Lcom/avito/android/remote/model/Image;", "images", "", "stateId", "searchContext", "showFullscreenGallery", "(ILjava/util/List;Ljava/lang/Long;Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/PhoneLink;", "phoneLink", "makeCallSafely", "(Lcom/avito/android/deep_linking/links/PhoneLink;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/deep_linking/links/PhoneRequestLink;", "link", "Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData$ResidentialComplex;", "analyticsData", "requestPhone", "(Lcom/avito/android/deep_linking/links/PhoneRequestLink;Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData$ResidentialComplex;)V", "developmentId", "Lcom/avito/android/remote/model/ConsultationFormData;", "formData", "openConsultationForm", "(Ljava/lang/String;Lcom/avito/android/remote/model/ConsultationFormData;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface DevelopmentsCatalogRouter extends MapPreviewRouter {
    void closeScreen();

    void followDeepLink(@Nullable DeepLink deepLink);

    void makeCallSafely(@NotNull PhoneLink phoneLink);

    void openConsultationForm(@NotNull String str, @NotNull ConsultationFormData consultationFormData);

    void openNativeShareDialog(@NotNull String str, @NotNull String str2);

    void requestPhone(@NotNull PhoneRequestLink phoneRequestLink, @Nullable PhoneRequestDeepLinkAnalyticsData.ResidentialComplex residentialComplex);

    void showFullscreenGallery(int i, @Nullable List<Image> list, @Nullable Long l, @Nullable String str);
}
