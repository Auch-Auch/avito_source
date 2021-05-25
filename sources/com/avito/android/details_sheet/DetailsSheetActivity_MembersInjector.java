package com.avito.android.details_sheet;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class DetailsSheetActivity_MembersInjector implements MembersInjector<DetailsSheetActivity> {
    public final Provider<ImplicitIntentFactory> a;
    public final Provider<AttributedTextFormatter> b;
    public final Provider<Analytics> c;
    public final Provider<DeepLinkIntentFactory> d;

    public DetailsSheetActivity_MembersInjector(Provider<ImplicitIntentFactory> provider, Provider<AttributedTextFormatter> provider2, Provider<Analytics> provider3, Provider<DeepLinkIntentFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<DetailsSheetActivity> create(Provider<ImplicitIntentFactory> provider, Provider<AttributedTextFormatter> provider2, Provider<Analytics> provider3, Provider<DeepLinkIntentFactory> provider4) {
        return new DetailsSheetActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.details_sheet.DetailsSheetActivity.analytics")
    public static void injectAnalytics(DetailsSheetActivity detailsSheetActivity, Analytics analytics) {
        detailsSheetActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.details_sheet.DetailsSheetActivity.attributedTextFormatter")
    public static void injectAttributedTextFormatter(DetailsSheetActivity detailsSheetActivity, AttributedTextFormatter attributedTextFormatter) {
        detailsSheetActivity.attributedTextFormatter = attributedTextFormatter;
    }

    @InjectedFieldSignature("com.avito.android.details_sheet.DetailsSheetActivity.deeplinkIntentFactory")
    public static void injectDeeplinkIntentFactory(DetailsSheetActivity detailsSheetActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        detailsSheetActivity.deeplinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.details_sheet.DetailsSheetActivity.implicitIntentFactory")
    public static void injectImplicitIntentFactory(DetailsSheetActivity detailsSheetActivity, ImplicitIntentFactory implicitIntentFactory) {
        detailsSheetActivity.implicitIntentFactory = implicitIntentFactory;
    }

    public void injectMembers(DetailsSheetActivity detailsSheetActivity) {
        injectImplicitIntentFactory(detailsSheetActivity, this.a.get());
        injectAttributedTextFormatter(detailsSheetActivity, this.b.get());
        injectAnalytics(detailsSheetActivity, this.c.get());
        injectDeeplinkIntentFactory(detailsSheetActivity, this.d.get());
    }
}
