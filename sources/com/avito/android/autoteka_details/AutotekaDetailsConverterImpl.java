package com.avito.android.autoteka_details;

import a2.b.a.a.a;
import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AutotekaDetailsResponse;
import com.avito.android.util.text.AttributedTextFormatter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/autoteka_details/AutotekaDetailsConverterImpl;", "Lcom/avito/android/autoteka_details/AutotekaDetailsConverter;", "Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "item", "Lcom/avito/android/autoteka_details/AutotekaDetails;", "convert", "(Lcom/avito/android/remote/model/AutotekaDetailsResponse;)Lcom/avito/android/autoteka_details/AutotekaDetails;", "Lcom/avito/android/util/text/AttributedTextFormatter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaDetailsConverterImpl implements AutotekaDetailsConverter {
    public final Resources a;
    public final AttributedTextFormatter b;

    @Inject
    public AutotekaDetailsConverterImpl(@NotNull Resources resources, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.a = resources;
        this.b = attributedTextFormatter;
    }

    @Override // com.avito.android.autoteka_details.AutotekaDetailsConverter
    @NotNull
    public AutotekaDetails convert(@NotNull AutotekaDetailsResponse autotekaDetailsResponse) {
        Intrinsics.checkNotNullParameter(autotekaDetailsResponse, "item");
        String string = this.a.getString(R.string.autoteka_details_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…g.autoteka_details_title)");
        return new AutotekaDetails(a.H(new Object[]{autotekaDetailsResponse.getVin()}, 1, string, "java.lang.String.format(format, *args)"), autotekaDetailsResponse.getTitle(), autotekaDetailsResponse.getDescription(), autotekaDetailsResponse.getReportUrl(), autotekaDetailsResponse.getExampleUrl(), this.b.format(autotekaDetailsResponse.getDisclaimer()));
    }
}
