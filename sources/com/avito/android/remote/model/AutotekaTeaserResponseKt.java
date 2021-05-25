package com.avito.android.remote.model;

import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel;
import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryReportLink;
import com.avito.android.remote.model.teaser.TeaserInsight;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/AutotekaTeaserResult;", "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "toAutotekaTeaserGalleryModel", "(Lcom/avito/android/remote/model/AutotekaTeaserResult;)Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "autoteka_release"}, k = 2, mv = {1, 4, 2})
public final class AutotekaTeaserResponseKt {
    @NotNull
    public static final AutotekaTeaserGalleryModel toAutotekaTeaserGalleryModel(@NotNull AutotekaTeaserResult autotekaTeaserResult) {
        Intrinsics.checkNotNullParameter(autotekaTeaserResult, "$this$toAutotekaTeaserGalleryModel");
        String title = autotekaTeaserResult.getTitle();
        String subTitle = autotekaTeaserResult.getSubTitle();
        AutotekaTeaserGalleryReportLink autotekaTeaserGalleryReportLink = new AutotekaTeaserGalleryReportLink(autotekaTeaserResult.getReportLink().getTitle(), autotekaTeaserResult.getReportLink().getUrl());
        List<TeaserInsight> insights = autotekaTeaserResult.getInsights();
        AutotekaTeaserGallery gallery = autotekaTeaserResult.getGallery();
        String subtitle = gallery != null ? gallery.getSubtitle() : null;
        AutotekaTeaserGallery gallery2 = autotekaTeaserResult.getGallery();
        return new AutotekaTeaserGalleryModel(title, subTitle, autotekaTeaserGalleryReportLink, insights, subtitle, gallery2 != null ? gallery2.getTitle() : null);
    }
}
