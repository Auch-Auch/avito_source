package com.avito.android.deep_linking;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.collection.ArrayMap;
import com.avito.android.Features;
import com.avito.android.advert_core.marketplace.MarketplacePresenterKt;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.AdvertPublicationLink;
import com.avito.android.deep_linking.links.AuthenticateLink;
import com.avito.android.deep_linking.links.AutoCatalogLink;
import com.avito.android.deep_linking.links.BlockedIpScreenLink;
import com.avito.android.deep_linking.links.BundlesLink;
import com.avito.android.deep_linking.links.CartLink;
import com.avito.android.deep_linking.links.ChannelDetailsLink;
import com.avito.android.deep_linking.links.ChannelsLink;
import com.avito.android.deep_linking.links.ConsultationFormLink;
import com.avito.android.deep_linking.links.CreateChannelWithAvitoLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeepLinkKt;
import com.avito.android.deep_linking.links.DeliveryCourierLocationSelectLink;
import com.avito.android.deep_linking.links.DeliveryProfileSettingsLink;
import com.avito.android.deep_linking.links.DeliveryStartOrderingDeepLink;
import com.avito.android.deep_linking.links.DevelopmentsCatalogDeveloperLink;
import com.avito.android.deep_linking.links.DevelopmentsCatalogLink;
import com.avito.android.deep_linking.links.DiscountLink;
import com.avito.android.deep_linking.links.DraftRefreshLink;
import com.avito.android.deep_linking.links.EditProfileLink;
import com.avito.android.deep_linking.links.FavoritesLink;
import com.avito.android.deep_linking.links.HelpCenterShowLink;
import com.avito.android.deep_linking.links.HotelsLandingLink;
import com.avito.android.deep_linking.links.IncomeSettingsLink;
import com.avito.android.deep_linking.links.ItemsSearchLink;
import com.avito.android.deep_linking.links.JobSeekerSaveFormLink;
import com.avito.android.deep_linking.links.JobSeekerSurveyCompletedLink;
import com.avito.android.deep_linking.links.LfPackagesLink;
import com.avito.android.deep_linking.links.LoginLink;
import com.avito.android.deep_linking.links.MainScreenLink;
import com.avito.android.deep_linking.links.MobilePhoneVerificationLink;
import com.avito.android.deep_linking.links.MyAdvertDetailsLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.deep_linking.links.NotificationCenterLink;
import com.avito.android.deep_linking.links.OrderCallbackLink;
import com.avito.android.deep_linking.links.OrdersLink;
import com.avito.android.deep_linking.links.PasswordChangeLink;
import com.avito.android.deep_linking.links.PasswordSettingLink;
import com.avito.android.deep_linking.links.PerformanceVasLink;
import com.avito.android.deep_linking.links.PhoneAddLink;
import com.avito.android.deep_linking.links.ProfileNotificationsLink;
import com.avito.android.deep_linking.links.RealtyRequestFormLink;
import com.avito.android.deep_linking.links.RefreshLink;
import com.avito.android.deep_linking.links.RegisterLink;
import com.avito.android.deep_linking.links.RemoveProfileLink;
import com.avito.android.deep_linking.links.ResetPasswordLink;
import com.avito.android.deep_linking.links.SafeDealOrderTypesDeepLink;
import com.avito.android.deep_linking.links.SaveSearchLink;
import com.avito.android.deep_linking.links.SaveSearchLinkType;
import com.avito.android.deep_linking.links.SearchSubscriptionControlLink;
import com.avito.android.deep_linking.links.SearchSubscriptionLink;
import com.avito.android.deep_linking.links.SellerSubscribeLink;
import com.avito.android.deep_linking.links.SendEmailLink;
import com.avito.android.deep_linking.links.ServiceSubscriptionLink;
import com.avito.android.deep_linking.links.SessionDeleteLink;
import com.avito.android.deep_linking.links.SessionsListLink;
import com.avito.android.deep_linking.links.SettingsNotificationsLink;
import com.avito.android.deep_linking.links.ShopSettingsLink;
import com.avito.android.deep_linking.links.ShopsLink;
import com.avito.android.deep_linking.links.SocialsListLink;
import com.avito.android.deep_linking.links.StartPublishFromUserAdvertsLink;
import com.avito.android.deep_linking.links.ThemeSettingsLink;
import com.avito.android.deep_linking.links.TopUpFormLink;
import com.avito.android.deep_linking.links.UserAdvertsLink;
import com.avito.android.deep_linking.links.UserContactsLink;
import com.avito.android.deep_linking.links.UserRatingDetailsLink;
import com.avito.android.deep_linking.links.UserReviewsLink;
import com.avito.android.deep_linking.links.UserStatsLink;
import com.avito.android.deep_linking.links.UserSubscribersLink;
import com.avito.android.deep_linking.links.VasUnionLink;
import com.avito.android.deep_linking.links.VerificationsListLink;
import com.avito.android.deep_linking.links.VisualVasLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsFactory;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.parse.adapter.AttributedTextAdapter;
import com.avito.android.remote.parse.adapter.DeepLinkTypeAdapter;
import com.avito.android.remote.parse.adapter.FontParameterTypeAdapterFactory;
import com.avito.android.remote.parse.adapter.ImageTypeAdapter;
import com.avito.android.remote.shop.list.business.ShopsSearchParametersFactory;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.avito.android.util.UrlParams;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010'¢\u0006\u0004\b/\u00100J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\r\u001a\u0004\u0018\u00010\u0002*\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u0002*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R=\u0010\u001a\u001a)\u0012\u0004\u0012\u00020\u0002\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\u00160\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001fR\u001d\u0010&\u001a\u00020!8B@\u0002X\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/avito/android/deep_linking/DeepLinkFactory;", "", "", ShareConstants.MEDIA_URI, "Lcom/avito/android/deep_linking/links/DeepLink;", "createFromUri", "(Ljava/lang/String;)Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/net/Uri;", "(Landroid/net/Uri;)Lcom/avito/android/deep_linking/links/DeepLink;", "", "c", "(Landroid/net/Uri;)V", "parameter", AuthSource.BOOKING_ORDER, "(Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/String;", "replacement", AuthSource.SEND_ABUSE, "Lcom/avito/android/Features;", "e", "Lcom/avito/android/Features;", "features", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Ljava/util/Map;", "mapping", "Lcom/avito/android/deep_linking/links/NoMatchLink;", "Lcom/avito/android/deep_linking/links/NoMatchLink;", "noMatch", "Landroid/content/UriMatcher;", "Landroid/content/UriMatcher;", "uriMatcher", "Lcom/google/gson/Gson;", "d", "Lkotlin/Lazy;", "getGson", "()Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/util/BuildInfo;", a2.g.r.g.a, "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/analytics/Analytics;", "f", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/Features;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/BuildInfo;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public class DeepLinkFactory {
    public final UriMatcher a;
    public final NoMatchLink b;
    public final Map<String, Function1<Uri, DeepLink>> c;
    public final Lazy d;
    public final Features e;
    public final Analytics f;
    public final BuildInfo g;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<Uri, DeepLink> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(1);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Code restructure failed: missing block: B:1115:0x193f, code lost:
            if (r2 != false) goto L_0x1944;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:1126:0x1988, code lost:
            if (r4 != false) goto L_0x198d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:915:0x1444, code lost:
            if (r3 != false) goto L_0x1449;
         */
        /* JADX WARNING: Removed duplicated region for block: B:1459:0x222c  */
        /* JADX WARNING: Removed duplicated region for block: B:1460:0x2235  */
        @Override // kotlin.jvm.functions.Function1
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.avito.android.deep_linking.links.DeepLink invoke(android.net.Uri r39) {
            /*
            // Method dump skipped, instructions count: 9386
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.deep_linking.DeepLinkFactory.a.invoke(java.lang.Object):java.lang.Object");
        }
    }

    public static final class a0 extends Lambda implements Function1<Uri, DeliveryCourierLocationSelectLink> {
        public static final a0 a = new a0();

        public a0() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public DeliveryCourierLocationSelectLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new DeliveryCourierLocationSelectLink();
        }
    }

    public static final class a1 extends Lambda implements Function1<Uri, ServiceSubscriptionLink> {
        public static final a1 a = new a1();

        public a1() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ServiceSubscriptionLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new ServiceSubscriptionLink();
        }
    }

    public static final class b extends Lambda implements Function1<Uri, DiscountLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public DiscountLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new DiscountLink(this.a.b(uri2, "context"));
        }
    }

    public static final class b0 extends Lambda implements Function1<Uri, SaveSearchLink.New> {
        public static final b0 a = new b0();

        public b0() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SaveSearchLink.New invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new SaveSearchLink.New(SaveSearchLink.Companion.create(uri2, SaveSearchLinkType.NEW));
        }
    }

    public static final class b1 extends Lambda implements Function1<Uri, LfPackagesLink> {
        public static final b1 a = new b1();

        public b1() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public LfPackagesLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new LfPackagesLink();
        }
    }

    public static final class c extends Lambda implements Function1<Uri, MobilePhoneVerificationLink> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public MobilePhoneVerificationLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new MobilePhoneVerificationLink(null, 1, null);
        }
    }

    public static final class c0 extends Lambda implements Function1<Uri, SaveSearchLink.Edit> {
        public static final c0 a = new c0();

        public c0() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SaveSearchLink.Edit invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new SaveSearchLink.Edit(SaveSearchLink.Companion.create(uri2, SaveSearchLinkType.EDIT));
        }
    }

    public static final class c1 extends Lambda implements Function1<Uri, ShopSettingsLink> {
        public static final c1 a = new c1();

        public c1() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ShopSettingsLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new ShopSettingsLink();
        }
    }

    public static final class d extends Lambda implements Function1<Uri, RemoveProfileLink> {
        public static final d a = new d();

        public d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public RemoveProfileLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new RemoveProfileLink();
        }
    }

    public static final class d0 extends Lambda implements Function1<Uri, SaveSearchLink.Existing> {
        public static final d0 a = new d0();

        public d0() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SaveSearchLink.Existing invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new SaveSearchLink.Existing(SaveSearchLink.Companion.create(uri2, SaveSearchLinkType.EXISTING));
        }
    }

    public static final class d1 extends Lambda implements Function1<Uri, ThemeSettingsLink> {
        public static final d1 a = new d1();

        public d1() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ThemeSettingsLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new ThemeSettingsLink();
        }
    }

    public static final class e extends Lambda implements Function1<Uri, PhoneAddLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0030, code lost:
            if (r0 != null) goto L_0x0034;
         */
        @Override // kotlin.jvm.functions.Function1
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.avito.android.deep_linking.links.PhoneAddLink invoke(android.net.Uri r11) {
            /*
                r10 = this;
                android.net.Uri r11 = (android.net.Uri) r11
                java.lang.String r0 = "uri"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                com.avito.android.deep_linking.DeepLinkFactory r0 = r10.a
                java.lang.String r1 = "number"
                java.lang.String r3 = com.avito.android.deep_linking.DeepLinkFactory.access$get(r0, r11, r1)
                com.avito.android.deep_linking.DeepLinkFactory r0 = r10.a
                java.lang.String r1 = "source"
                java.lang.String r4 = com.avito.android.deep_linking.DeepLinkFactory.access$get(r0, r11, r1)
                com.avito.android.deep_linking.DeepLinkFactory r0 = r10.a
                java.lang.String r1 = "then"
                java.lang.String r0 = com.avito.android.deep_linking.DeepLinkFactory.access$get(r0, r11, r1)
                if (r0 == 0) goto L_0x0033
                android.net.Uri r0 = android.net.Uri.parse(r0)
                com.avito.android.deep_linking.DeepLinkFactory r1 = r10.a
                java.lang.String r2 = "thenUri"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
                com.avito.android.deep_linking.links.DeepLink r0 = r1.createFromUri(r0)
                if (r0 == 0) goto L_0x0033
                goto L_0x0034
            L_0x0033:
                r0 = 0
            L_0x0034:
                r7 = r0
                com.avito.android.deep_linking.DeepLinkFactory r0 = r10.a
                java.lang.String r1 = "title"
                java.lang.String r5 = com.avito.android.deep_linking.DeepLinkFactory.access$get(r0, r11, r1)
                com.avito.android.deep_linking.DeepLinkFactory r0 = r10.a
                java.lang.String r1 = "subtitle"
                java.lang.String r6 = com.avito.android.deep_linking.DeepLinkFactory.access$get(r0, r11, r1)
                if (r4 == 0) goto L_0x0050
                int r11 = r4.length()
                if (r11 != 0) goto L_0x004e
                goto L_0x0050
            L_0x004e:
                r11 = 0
                goto L_0x0051
            L_0x0050:
                r11 = 1
            L_0x0051:
                if (r11 == 0) goto L_0x005d
                com.avito.android.deep_linking.links.PhoneAddLink r11 = new com.avito.android.deep_linking.links.PhoneAddLink
                r4 = 0
                r8 = 2
                r9 = 0
                r2 = r11
                r2.<init>(r3, r4, r5, r6, r7, r8, r9)
                goto L_0x0063
            L_0x005d:
                com.avito.android.deep_linking.links.PhoneAddLink r11 = new com.avito.android.deep_linking.links.PhoneAddLink
                r2 = r11
                r2.<init>(r3, r4, r5, r6, r7)
            L_0x0063:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.deep_linking.DeepLinkFactory.e.invoke(java.lang.Object):java.lang.Object");
        }
    }

    public static final class e0 extends Lambda implements Function1<Uri, ConsultationFormLink> {
        public static final e0 a = new e0();

        public e0() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ConsultationFormLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new ConsultationFormLink(null, null, 3, null);
        }
    }

    public static final class e1 extends Lambda implements Function1<Uri, FavoritesLink> {
        public static final e1 a = new e1();

        public e1() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public FavoritesLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new FavoritesLink();
        }
    }

    public static final class f extends Lambda implements Function1<Uri, RegisterLink> {
        public static final f a = new f();

        public f() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public RegisterLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new RegisterLink();
        }
    }

    public static final class f0 extends Lambda implements Function1<Uri, OrdersLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f0(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
            if (r2 != false) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0025, code lost:
            if ((r0.length() > 0) != false) goto L_0x0029;
         */
        @Override // kotlin.jvm.functions.Function1
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.avito.android.deep_linking.links.OrdersLink invoke(android.net.Uri r6) {
            /*
                r5 = this;
                android.net.Uri r6 = (android.net.Uri) r6
                java.lang.String r0 = "uri"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                com.avito.android.deep_linking.DeepLinkFactory r0 = r5.a
                java.lang.String r1 = "tab"
                java.lang.String r0 = com.avito.android.deep_linking.DeepLinkFactory.access$get(r0, r6, r1)
                com.avito.android.deep_linking.DeepLinkFactory r1 = r5.a
                java.lang.String r2 = "ordersToPrefetch"
                java.lang.String r6 = com.avito.android.deep_linking.DeepLinkFactory.access$get(r1, r6, r2)
                r1 = 0
                r2 = 0
                r3 = 1
                if (r0 == 0) goto L_0x0028
                int r4 = r0.length()
                if (r4 <= 0) goto L_0x0024
                r4 = 1
                goto L_0x0025
            L_0x0024:
                r4 = 0
            L_0x0025:
                if (r4 == 0) goto L_0x0028
                goto L_0x0029
            L_0x0028:
                r0 = r1
            L_0x0029:
                if (r6 == 0) goto L_0x0035
                int r4 = r6.length()
                if (r4 <= 0) goto L_0x0032
                r2 = 1
            L_0x0032:
                if (r2 == 0) goto L_0x0035
                goto L_0x0036
            L_0x0035:
                r6 = r1
            L_0x0036:
                com.avito.android.deep_linking.links.OrdersLink r1 = new com.avito.android.deep_linking.links.OrdersLink
                r1.<init>(r0, r6)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.deep_linking.DeepLinkFactory.f0.invoke(java.lang.Object):java.lang.Object");
        }
    }

    public static final class f1 extends Lambda implements Function1<Uri, SearchSubscriptionLink> {
        public static final f1 a = new f1();

        public f1() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SearchSubscriptionLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new SearchSubscriptionLink(null, 1, null);
        }
    }

    public static final class g extends Lambda implements Function1<Uri, SendEmailLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SendEmailLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new SendEmailLink(this.a.b(uri2, "to"), this.a.b(uri2, "subject"), this.a.b(uri2, "info"));
        }
    }

    public static final class g0 extends Lambda implements Function1<Uri, CartLink> {
        public static final g0 a = new g0();

        public g0() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CartLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new CartLink();
        }
    }

    public static final class g1 extends Lambda implements Function1<Uri, NotificationCenterLink> {
        public static final g1 a = new g1();

        public g1() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public NotificationCenterLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new NotificationCenterLink();
        }
    }

    public static final class h extends Lambda implements Function1<Uri, ProfileNotificationsLink> {
        public static final h a = new h();

        public h() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ProfileNotificationsLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new ProfileNotificationsLink();
        }
    }

    public static final class h0 extends Lambda implements Function1<Uri, UserStatsLink> {
        public static final h0 a = new h0();

        public h0() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public UserStatsLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new UserStatsLink();
        }
    }

    public static final class h1 extends Lambda implements Function1<Uri, TopUpFormLink> {
        public static final h1 a = new h1();

        public h1() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public TopUpFormLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new TopUpFormLink();
        }
    }

    public static final class i extends Lambda implements Function1<Uri, BlockedIpScreenLink> {
        public static final i a = new i();

        public i() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public BlockedIpScreenLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new BlockedIpScreenLink();
        }
    }

    public static final class i0 extends Lambda implements Function1<Uri, RefreshLink> {
        public static final i0 a = new i0();

        public i0() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public RefreshLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new RefreshLink();
        }
    }

    public static final class i1 extends Lambda implements Function1<Uri, DraftRefreshLink> {
        public static final i1 a = new i1();

        public i1() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public DraftRefreshLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new DraftRefreshLink();
        }
    }

    public static final class j extends Lambda implements Function1<Uri, LoginLink> {
        public static final j a = new j();

        public j() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public LoginLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new LoginLink();
        }
    }

    public static final class j0 extends Lambda implements Function1<Uri, VerificationsListLink> {
        public static final j0 a = new j0();

        public j0() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public VerificationsListLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new VerificationsListLink();
        }
    }

    public static final class j1 extends Lambda implements Function1<Uri, EditProfileLink> {
        public static final j1 a = new j1();

        public j1() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public EditProfileLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new EditProfileLink();
        }
    }

    public static final class k extends Lambda implements Function1<Uri, HelpCenterShowLink> {
        public static final k a = new k();

        public k() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public HelpCenterShowLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
            return new HelpCenterShowLink();
        }
    }

    public static final class k0 extends Lambda implements Function1<Uri, HotelsLandingLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k0(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public HotelsLandingLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new HotelsLandingLink(this.a.b(uri2, "marker"));
        }
    }

    public static final class k1 extends Lambda implements Function0<Gson> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k1(DeepLinkFactory deepLinkFactory) {
            super(0);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Gson invoke() {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Image.class, new ImageTypeAdapter());
            gsonBuilder.registerTypeAdapter(AttributedText.class, new AttributedTextAdapter());
            GsonBuilder registerTypeAdapterFactory = gsonBuilder.registerTypeAdapterFactory(new FontParameterTypeAdapterFactory().create(this.a.e));
            Intrinsics.checkNotNullExpressionValue(registerTypeAdapterFactory, "GsonBuilder()\n          …ctory().create(features))");
            registerTypeAdapterFactory.registerTypeAdapter(DeepLink.class, new DeepLinkTypeAdapter(this.a));
            return registerTypeAdapterFactory.create();
        }
    }

    public static final class l extends Lambda implements Function1<Uri, DeliveryStartOrderingDeepLink> {
        public final /* synthetic */ DeepLinkFactory a;
        public final /* synthetic */ Lazy b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(DeepLinkFactory deepLinkFactory, Lazy lazy, KProperty kProperty) {
            super(1);
            this.a = deepLinkFactory;
            this.b = lazy;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public DeliveryStartOrderingDeepLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            boolean parseBoolean = Boolean.parseBoolean(this.a.b(uri2, "isMarketplace"));
            boolean parseBoolean2 = Boolean.parseBoolean(this.a.b(uri2, "isCart"));
            boolean parseBoolean3 = Boolean.parseBoolean(this.a.b(uri2, "autozoom"));
            String b2 = this.a.b(uri2, "itemId");
            String b3 = this.a.b(uri2, "source");
            String b4 = this.a.b(uri2, "context");
            String b5 = this.a.b(uri2, "locationId");
            String b6 = this.a.b(uri2, "firstCartItemId");
            String b8 = this.a.b(uri2, "cartItems");
            String b9 = this.a.b(uri2, MarketplacePresenterKt.KEY_CONTACT_EVENT);
            return new DeliveryStartOrderingDeepLink(b2, b3, b4, parseBoolean, parseBoolean2, parseBoolean3, b5, b6, b8, b9 != null ? (ParametrizedEvent) DeepLinkFactory.access$getGson$p(this.a).fromJson(b9, (Type) this.b.getValue()) : null);
        }
    }

    public static final class l0 extends Lambda implements Function1<Uri, ChannelsLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l0(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ChannelsLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new ChannelsLink(this.a.b(uri2, "itemId"));
        }
    }

    public static final class l1 extends Lambda implements Function0<Type> {
        public static final l1 a = new l1();

        public l1() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Type invoke() {
            return new DeepLinkFactory$parametrizedEventType$2$1().getType();
        }
    }

    public static final class m extends Lambda implements Function1<Uri, ResetPasswordLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ResetPasswordLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            String b = this.a.b(uri2, "login");
            String b2 = this.a.b(uri2, "src");
            String b3 = this.a.b(uri2, "skipLoginEntry");
            boolean z = false;
            if (b3 != null) {
                if (b3.length() > 0) {
                    z = true;
                }
            }
            if (b == null) {
                b = "";
            }
            return new ResetPasswordLink(b, z, b2);
        }
    }

    public static final class m0 extends Lambda implements Function1<Uri, MainScreenLink> {
        public static final m0 a = new m0();

        public m0() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public MainScreenLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new MainScreenLink();
        }
    }

    public static final class n extends Lambda implements Function1<Uri, SettingsNotificationsLink> {
        public static final n a = new n();

        public n() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SettingsNotificationsLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new SettingsNotificationsLink();
        }
    }

    public static final class n0 extends Lambda implements Function1<Uri, OrderCallbackLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n0(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public OrderCallbackLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new OrderCallbackLink(this.a.b(uri2, "type"));
        }
    }

    public static final class o extends Lambda implements Function1<Uri, DeliveryProfileSettingsLink> {
        public static final o a = new o();

        public o() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public DeliveryProfileSettingsLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new DeliveryProfileSettingsLink();
        }
    }

    public static final class o0 extends Lambda implements Function1<Uri, CreateChannelWithAvitoLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o0(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CreateChannelWithAvitoLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new CreateChannelWithAvitoLink(this.a.b(uri2, "context"), this.a.b(uri2, "source"));
        }
    }

    public static final class p extends Lambda implements Function1<Uri, SearchSubscriptionControlLink> {
        public static final p a = new p();

        public p() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SearchSubscriptionControlLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
            return new SearchSubscriptionControlLink();
        }
    }

    public static final class p0 extends Lambda implements Function1<Uri, AuthenticateLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p0(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AuthenticateLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, "it");
            return new AuthenticateLink(this.a.b(uri2, "s"), null, 2, null);
        }
    }

    public static final class q extends Lambda implements Function1<Uri, UserSubscribersLink> {
        public static final q a = new q();

        public q() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public UserSubscribersLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new UserSubscribersLink();
        }
    }

    public static final class q0 extends Lambda implements Function1<Uri, ItemsSearchLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q0(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ItemsSearchLink invoke(Uri uri) {
            Area area;
            Area area2;
            NumberFormatException e;
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            SearchParams access$createSearchParamsFromUri = DeepLinkFactory.access$createSearchParamsFromUri(this.a, uri2);
            String b = this.a.b(uri2, "context");
            boolean areEqual = Intrinsics.areEqual(this.a.b(uri2, "showMap"), "1");
            boolean areEqual2 = Intrinsics.areEqual(this.a.b(uri2, UrlParams.SIMPLE_MAP), "1");
            boolean areEqual3 = Intrinsics.areEqual(this.a.b(uri2, "showJobNearbyBanner"), "1");
            try {
                String b2 = this.a.b(uri2, "searchArea[latTop]");
                Double valueOf = b2 != null ? Double.valueOf(Double.parseDouble(b2)) : null;
                String b3 = this.a.b(uri2, "searchArea[lonLeft]");
                Double valueOf2 = b3 != null ? Double.valueOf(Double.parseDouble(b3)) : null;
                String b4 = this.a.b(uri2, "searchArea[latBottom]");
                Double valueOf3 = b4 != null ? Double.valueOf(Double.parseDouble(b4)) : null;
                String b5 = this.a.b(uri2, "searchArea[lonRight]");
                Double valueOf4 = b5 != null ? Double.valueOf(Double.parseDouble(b5)) : null;
                if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null) {
                    area = null;
                    return new ItemsSearchLink(access$createSearchParamsFromUri, b, areEqual, area, null, this.a.b(uri2, "mapSerpState"), null, null, areEqual3, this.a.b(uri2, PanelStateKt.PANEL_EXPANDED), this.a.b(uri2, "sellerId"), areEqual2);
                }
                try {
                    Area area3 = new Area(new Coordinates(valueOf.doubleValue(), valueOf2.doubleValue()), new Coordinates(valueOf3.doubleValue(), valueOf4.doubleValue()));
                    access$createSearchParamsFromUri = access$createSearchParamsFromUri;
                    try {
                        access$createSearchParamsFromUri.setArea(area3);
                        area = area3;
                    } catch (NumberFormatException e2) {
                        e = e2;
                        area2 = area3;
                        Logs.debug("DeepLinkFactory", "Failed to parse one of search parameters in deep link: " + uri2, e);
                        area = area2;
                        return new ItemsSearchLink(access$createSearchParamsFromUri, b, areEqual, area, null, this.a.b(uri2, "mapSerpState"), null, null, areEqual3, this.a.b(uri2, PanelStateKt.PANEL_EXPANDED), this.a.b(uri2, "sellerId"), areEqual2);
                    }
                } catch (NumberFormatException e3) {
                    e = e3;
                    access$createSearchParamsFromUri = access$createSearchParamsFromUri;
                    area2 = null;
                    Logs.debug("DeepLinkFactory", "Failed to parse one of search parameters in deep link: " + uri2, e);
                    area = area2;
                    return new ItemsSearchLink(access$createSearchParamsFromUri, b, areEqual, area, null, this.a.b(uri2, "mapSerpState"), null, null, areEqual3, this.a.b(uri2, PanelStateKt.PANEL_EXPANDED), this.a.b(uri2, "sellerId"), areEqual2);
                }
                return new ItemsSearchLink(access$createSearchParamsFromUri, b, areEqual, area, null, this.a.b(uri2, "mapSerpState"), null, null, areEqual3, this.a.b(uri2, PanelStateKt.PANEL_EXPANDED), this.a.b(uri2, "sellerId"), areEqual2);
            } catch (NumberFormatException e4) {
                e = e4;
                area2 = null;
                Logs.debug("DeepLinkFactory", "Failed to parse one of search parameters in deep link: " + uri2, e);
                area = area2;
                return new ItemsSearchLink(access$createSearchParamsFromUri, b, areEqual, area, null, this.a.b(uri2, "mapSerpState"), null, null, areEqual3, this.a.b(uri2, PanelStateKt.PANEL_EXPANDED), this.a.b(uri2, "sellerId"), areEqual2);
            }
        }
    }

    public static final class r extends Lambda implements Function1<Uri, PasswordChangeLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PasswordChangeLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new PasswordChangeLink(this.a.b(uri2, "login"), this.a.b(uri2, "loginType"), this.a.b(uri2, "sessionIdHash"), this.a.b(uri2, "deviceId"), this.a.b(uri2, "source"), this.a.b(uri2, ChannelContext.Item.USER_ID));
        }
    }

    public static final class r0 extends Lambda implements Function1<Uri, ShopsLink> {
        public static final r0 a = new r0();

        public r0() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ShopsLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new ShopsLink(new ShopsSearchParametersFactory().createFromUri(uri2));
        }
    }

    public static final class s extends Lambda implements Function1<Uri, PasswordSettingLink> {
        public static final s a = new s();

        public s() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PasswordSettingLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new PasswordSettingLink();
        }
    }

    public static final class s0 extends Lambda implements Function1<Uri, UserRatingDetailsLink> {
        public static final s0 a = new s0();

        public s0() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public UserRatingDetailsLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new UserRatingDetailsLink();
        }
    }

    public static final class t extends Lambda implements Function1<Uri, SocialsListLink> {
        public static final t a = new t();

        public t() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SocialsListLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new SocialsListLink();
        }
    }

    public static final class t0 extends Lambda implements Function1<Uri, UserReviewsLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t0(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public UserReviewsLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new UserReviewsLink(this.a.b(uri2, "context"));
        }
    }

    public static final class u extends Lambda implements Function1<Uri, SessionsListLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SessionsListLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new SessionsListLink(this.a.b(uri2, "source"));
        }
    }

    public static final class u0 extends Lambda implements Function1<Uri, ChannelsLink> {
        public static final u0 a = new u0();

        public u0() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ChannelsLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new ChannelsLink(null, 1, null);
        }
    }

    public static final class v extends Lambda implements Function1<Uri, SessionDeleteLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SessionDeleteLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new SessionDeleteLink(this.a.b(uri2, "sessionIdHash"), this.a.b(uri2, "deviceId"), this.a.b(uri2, "loginType"));
        }
    }

    public static final class v0 extends Lambda implements Function1<Uri, UserContactsLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v0(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public UserContactsLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new UserContactsLink(this.a.b(uri2, "context"));
        }
    }

    public static final class w extends Lambda implements Function1<Uri, JobSeekerSaveFormLink> {
        public static final w a = new w();

        public w() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public JobSeekerSaveFormLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new JobSeekerSaveFormLink();
        }
    }

    public static final class w0 extends Lambda implements Function1<Uri, SellerSubscribeLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w0(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SellerSubscribeLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new SellerSubscribeLink(this.a.b(uri2, "hash"), this.a.b(uri2, "src"));
        }
    }

    public static final class x extends Lambda implements Function1<Uri, JobSeekerSurveyCompletedLink> {
        public static final x a = new x();

        public x() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public JobSeekerSurveyCompletedLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new JobSeekerSurveyCompletedLink();
        }
    }

    public static final class x0 extends Lambda implements Function1<Uri, UserAdvertsLink> {
        public final /* synthetic */ DeepLinkFactory a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x0(DeepLinkFactory deepLinkFactory) {
            super(1);
            this.a = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public UserAdvertsLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            return new UserAdvertsLink(this.a.b(uri2, "shortcut"));
        }
    }

    public static final class y extends Lambda implements Function1<Uri, DeepLink> {
        public final /* synthetic */ DeepLinkFactory a;
        public final /* synthetic */ Lazy b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y(DeepLinkFactory deepLinkFactory, Lazy lazy, KProperty kProperty) {
            super(1);
            this.a = deepLinkFactory;
            this.b = lazy;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public DeepLink invoke(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
            String b2 = this.a.b(uri2, "itemId");
            if (b2 == null || t6.y.m.isBlank(b2)) {
                return this.a.b;
            }
            boolean parseBoolean = Boolean.parseBoolean(this.a.b(uri2, "isMarketplace"));
            String b3 = this.a.b(uri2, "context");
            String b4 = this.a.b(uri2, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
            String b5 = this.a.b(uri2, MarketplacePresenterKt.KEY_CONTACT_EVENT);
            return new SafeDealOrderTypesDeepLink(b2, parseBoolean, b3, b4, b5 != null ? (ParametrizedEvent) DeepLinkFactory.access$getGson$p(this.a).fromJson(b5, (Type) this.b.getValue()) : null);
        }
    }

    public static final class y0 extends Lambda implements Function1<Uri, StartPublishFromUserAdvertsLink> {
        public static final y0 a = new y0();

        public y0() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public StartPublishFromUserAdvertsLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
            return new StartPublishFromUserAdvertsLink();
        }
    }

    public static final class z extends Lambda implements Function1<Uri, IncomeSettingsLink> {
        public static final z a = new z();

        public z() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public IncomeSettingsLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new IncomeSettingsLink();
        }
    }

    public static final class z0 extends Lambda implements Function1<Uri, AdvertPublicationLink> {
        public static final z0 a = new z0();

        public z0() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AdvertPublicationLink invoke(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "it");
            return new AdvertPublicationLink(null, 1, null);
        }
    }

    public DeepLinkFactory(@NotNull Features features, @Nullable Analytics analytics, @Nullable BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.e = features;
        this.f = analytics;
        this.g = buildInfo;
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.a = uriMatcher;
        this.b = new NoMatchLink();
        ArrayMap arrayMap = new ArrayMap(32);
        this.c = arrayMap;
        this.d = t6.c.lazy(new k1(this));
        uriMatcher.addURI("1", "items/#", 0);
        uriMatcher.addURI("1", "profile/items/#", 1);
        uriMatcher.addURI("1", "channels/*", 2);
        Lazy lazy = t6.c.lazy(l1.a);
        arrayMap.put("1/call/feedback", new a(77, this));
        arrayMap.put("1/main", m0.a);
        arrayMap.put("1/authenticate", new p0(this));
        arrayMap.put("1/channels", u0.a);
        arrayMap.put("1/item/publish", z0.a);
        arrayMap.put("2/item/publish/draft", new a(118, this));
        arrayMap.put("1/profile/item/draft/delete", new a(126, this));
        arrayMap.put("1/item/publish/refresh", i1.a);
        arrayMap.put("1/profile/edit", j1.a);
        arrayMap.put("1/profile/remove", d.a);
        arrayMap.put("1/register", f.a);
        arrayMap.put("1/login", j.a);
        arrayMap.put("1/resetPassword", new m(this));
        arrayMap.put("1/restore", new a(40, this));
        arrayMap.put("1/item/show", new a(49, this));
        arrayMap.put(DevelopmentsCatalogLink.FACTORY_MAPPING_PATH, new a(55, this));
        arrayMap.put(DevelopmentsCatalogDeveloperLink.FACTORY_MAPPING_PATH, new a(61, this));
        arrayMap.put(ConsultationFormLink.FACTORY_MAPPING_PATH, e0.a);
        arrayMap.put(RealtyRequestFormLink.FACTORY_MAPPING_PATH, new a(76, this));
        arrayMap.put(HotelsLandingLink.FACTORY_MAPPING_PATH, new k0(this));
        arrayMap.put(AutoCatalogLink.FACTORY_MAPPING_PATH, new a(80, this));
        arrayMap.put("1/profile/item/show", new a(81, this));
        arrayMap.put("1/profile/item/draft/show", new a(82, this));
        arrayMap.put("1/channels/search", new l0(this));
        arrayMap.put("1/channel/show", new a(83, this));
        arrayMap.put("1/channel/map/show", new a(84, this));
        arrayMap.put("1/channel/call", new a(85, this));
        arrayMap.put("1/channel/blockWithReason", new a(86, this));
        arrayMap.put("1/channel/updateFolderTags", new a(87, this));
        arrayMap.put("1/phone/call", new a(88, this));
        arrayMap.put("1/phone/orderCallback", new n0(this));
        arrayMap.put("1/item/email", new a(89, this));
        arrayMap.put("1/item/contacts/packages/buy", new a(90, this));
        arrayMap.put("1/item/contacts/services/buy", new a(91, this));
        arrayMap.put("1/item/channel/create", new a(92, this));
        arrayMap.put("1/avito/channel/create", new o0(this));
        arrayMap.put("1/item/contacts/packages/apply", new a(93, this));
        arrayMap.put("1/info", new a(94, this));
        arrayMap.put("1/item/report", new a(95, this));
        arrayMap.put("1/items/search", new q0(this));
        Object obj = arrayMap.get("1/items/search");
        Intrinsics.checkNotNull(obj);
        arrayMap.put("1/items", obj);
        arrayMap.put("1/shops/search", r0.a);
        arrayMap.put("1/shop/showDescription", new a(96, this));
        arrayMap.put("1/shops/show", new a(97, this));
        arrayMap.put("1/profile/show", new a(98, this));
        arrayMap.put("1/profile/ratings", s0.a);
        arrayMap.put("1/user/ratings", new a(99, this));
        arrayMap.put("1/shop/ratings", new a(100, this));
        arrayMap.put("1/rating/publish", new a(101, this));
        arrayMap.put("1/user/reviews", new t0(this));
        arrayMap.put("1/profile/contacts", new v0(this));
        arrayMap.put("1/channel/review", new a(102, this));
        arrayMap.put("1/voipCall/callback", new a(103, this));
        arrayMap.put("1/favorite-sellers/subscriptions", new a(104, this));
        arrayMap.put("1/favorite-sellers/subscribers", new a(105, this));
        arrayMap.put("1/favorite-sellers/subscribe", new w0(this));
        arrayMap.put("1/share", new a(106, this));
        arrayMap.put("1/profile/items/search", new x0(this));
        arrayMap.put("1/user_adverts/publish", y0.a);
        arrayMap.put("1/profile/item/edit", new a(107, this));
        arrayMap.put("1/profile/item/delete", new a(108, this));
        arrayMap.put("1/profile/item/restore", new a(109, this));
        arrayMap.put("1/profile/item/activate", new a(110, this));
        arrayMap.put("1/profile/item/close", new a(111, this));
        arrayMap.put("1/profile/item/close/soa", new a(112, this));
        arrayMap.put("1/autopublish/set", new a(113, this));
        arrayMap.put("1/profile/item/publish", new a(114, this));
        arrayMap.put("1/channel/delete", new a(115, this));
        arrayMap.put("1/webview", new a(116, this));
        arrayMap.put("1/item/imv/show", new a(117, this));
        arrayMap.put("1/channel/block", new a(119, this));
        arrayMap.put("1/user/profile", new a(120, this));
        arrayMap.put("1/user/profileExtended", new a(121, this));
        arrayMap.put("1/user/profile/phone/get", new a(122, this));
        arrayMap.put("1/external/app", new a(123, this));
        arrayMap.put("1/infobanner/close", new a(124, this));
        arrayMap.put("1/profile/item/fees", new a(125, this));
        arrayMap.put("1/service/subscription", a1.a);
        arrayMap.put("1/lf/packages", b1.a);
        arrayMap.put("1/shop/settings", c1.a);
        arrayMap.put("1/settings/theme", d1.a);
        arrayMap.put("1/favorites/search", e1.a);
        arrayMap.put("1/subscriptions/search", f1.a);
        arrayMap.put("1/subscription/search/show", new a(127, this));
        arrayMap.put("1/notifications/search", g1.a);
        arrayMap.put("1/payment/session/service", new a(128, this));
        arrayMap.put("2/payment/session/service", new a(129, this));
        arrayMap.put("1/payment/order/status", new a(130, this));
        arrayMap.put("1/payment/wallet", h1.a);
        arrayMap.put("1/profile/item/paidServices", new a(131, this));
        arrayMap.put("1/profile/item/appliedServices", new a(132, this));
        arrayMap.put("1/profile/item/feesMethods", new a(133, this));
        arrayMap.put(PerformanceVasLink.FACTORY_MAPPING_PATH, new a(134, this));
        arrayMap.put(VisualVasLink.FACTORY_MAPPING_PATH, new a(135, this));
        arrayMap.put(VasUnionLink.FACTORY_MAPPING_PATH, new a(136, this));
        arrayMap.put(BundlesLink.FACTORY_MAPPING_PATH, new a(137, this));
        arrayMap.put("1/tariff/landing", new a(138, this));
        arrayMap.put("1/tariff/info", new a(139, this));
        arrayMap.put("1/tariff/package", new a(140, this));
        arrayMap.put("1/tariff/region", new a(141, this));
        arrayMap.put("1/tariff/count", new a(0, this));
        arrayMap.put("1/checkout", new a(1, this));
        arrayMap.put("1/tariff/editInfo", new a(2, this));
        arrayMap.put("1/discount/show", new b(this));
        arrayMap.put("1/payment/order/status/form", new a(3, this));
        arrayMap.put("1/item/publish/simpleCv", new a(4, this));
        arrayMap.put("1/phone/verify", new a(5, this));
        arrayMap.put("1/phone/management", new a(6, this));
        arrayMap.put("1/phone/verification/mobile", c.a);
        arrayMap.put("1/phone/verification/landline", new a(7, this));
        arrayMap.put("1/phone/verification/manual", new a(8, this));
        arrayMap.put("1/phone/verification/status", new a(9, this));
        arrayMap.put("1/phone/get", new a(10, this));
        arrayMap.put("1/phone/add", new e(this));
        arrayMap.put("1/profile/item/stats", new a(11, this));
        arrayMap.put("1/hints", new a(12, this));
        arrayMap.put("1/payment/generic", new a(13, this));
        arrayMap.put("1/payment/generic/form", new a(14, this));
        arrayMap.put("1/payment/sberbank/app", new a(15, this));
        arrayMap.put("1/payment/google_pay", new a(16, this));
        arrayMap.put("1/email/create", new g(this));
        arrayMap.put("1/notifications/unified/show", new a(17, this));
        arrayMap.put("1/notifications/main/show", new a(18, this));
        arrayMap.put("1/notifications/recommends/show", new a(19, this));
        arrayMap.put("1/notifications/feedback/show", new a(20, this));
        arrayMap.put("1/notifications/share/show", new a(21, this));
        arrayMap.put("1/profile/notifications", h.a);
        arrayMap.put("1/delivery/order/cancel", new a(22, this));
        arrayMap.put("1/info/ipblock/show", i.a);
        arrayMap.put("1/delivery/order/payout/init", new a(23, this));
        arrayMap.put("1/delivery/order/payout/proceed", new a(24, this));
        arrayMap.put("1/abuse/report", new a(25, this));
        arrayMap.put("1/map/showPin", new a(26, this));
        arrayMap.put("1/clickstream", new a(27, this));
        arrayMap.put("1/helpcenter/show", k.a);
        arrayMap.put("1/helpcenter/url/show", new a(28, this));
        arrayMap.put("1/helpcenter/request/create", new a(29, this));
        arrayMap.put("1/helpcenter/article/show", new a(30, this));
        arrayMap.put("1/support/request", new a(31, this));
        arrayMap.put("1/delivery/order/create", new l(this, lazy, null));
        arrayMap.put("1/delivery/order/summary", new a(32, this));
        arrayMap.put("1/delivery/order/pay", new a(33, this));
        arrayMap.put("1/delivery/order/payment/success", new a(34, this));
        arrayMap.put("1/delivery/order/payment/failure", new a(35, this));
        arrayMap.put("1/courierDelivery/order/payment/success", new a(36, this));
        arrayMap.put("1/courierDelivery/order/payment/failure", new a(37, this));
        arrayMap.put("1/autoteka/details", new a(38, this));
        arrayMap.put("1/autoteka/buyReport", new a(39, this));
        arrayMap.put("1/settings/notifications", n.a);
        arrayMap.put("1/profile/delivery/settings", o.a);
        arrayMap.put("1/autodeal/details", new a(41, this));
        arrayMap.put("1/shortTermRent/booking/request", new a(42, this));
        arrayMap.put("1/shortTermRent/booking/payment/success", new a(43, this));
        arrayMap.put("1/shortTermRent/booking/payment/failure", new a(44, this));
        arrayMap.put("1/searchSubscription/saveCurrentSerp", p.a);
        arrayMap.put("1/shortTermRent/seller/booking/calendar/manage", new a(45, this));
        arrayMap.put("1/shortTermRent/booking/payout/init", new a(46, this));
        arrayMap.put("1/detailssheet/show", new a(47, this));
        arrayMap.put("1/publish/limits/history", new a(48, this));
        arrayMap.put("1/profile/subscribers", q.a);
        arrayMap.put("1/badgeBar/show", new a(50, this));
        arrayMap.put("1/profile/password/change", new r(this));
        arrayMap.put("1/profile/password/set", s.a);
        arrayMap.put("1/profile/socials/list", t.a);
        arrayMap.put("1/profile/sessions/list", new u(this));
        arrayMap.put("1/profile/sessions/delete", new v(this));
        arrayMap.put("1/profile/sessions/info", new a(51, this));
        arrayMap.put("1/favorite-sellers/mute", new a(52, this));
        arrayMap.put("1/job/assistant/location", new a(53, this));
        arrayMap.put("1/job/survey/create", new a(54, this));
        arrayMap.put("1/job/survey/form/save", w.a);
        arrayMap.put("1/job/survey/completed", x.a);
        arrayMap.put("2/job/interview/invite", new a(56, this));
        arrayMap.put("1/safeDeal/item/orderTypes/select", new y(this, lazy, null));
        arrayMap.put("1/courierDelivery/order/create", new a(57, this));
        arrayMap.put("1/profile/income/settings", z.a);
        arrayMap.put("1/courierDelivery/order/params/update", new a(58, this));
        arrayMap.put("1/courierDelivery/location/select", a0.a);
        arrayMap.put("1/courierDelivery/timeInterval/select", new a(59, this));
        arrayMap.put("1/courierDelivery/order/payout/init", new a(60, this));
        arrayMap.put("1/safeDeal/order/payout/init", new a(62, this));
        arrayMap.put("1" + SaveSearchLink.New.Companion.getPATH(), b0.a);
        arrayMap.put("1" + SaveSearchLink.Edit.Companion.getPATH(), c0.a);
        arrayMap.put("1" + SaveSearchLink.Existing.Companion.getPATH(), d0.a);
        arrayMap.put("1/dialog/show", new a(63, this));
        arrayMap.put("1/item/car/booking/info/show", new a(64, this));
        arrayMap.put("1/car/booking/order/show", new a(65, this));
        arrayMap.put("1/toast/show", new a(66, this));
        arrayMap.put("1/deepLinks/multiple/open", new a(67, this));
        arrayMap.put("1/deepLinks/fallbackable/open", new a(68, this));
        arrayMap.put("1/order/open", new a(69, this));
        arrayMap.put("1/profile/orders/open", new f0(this));
        arrayMap.put("1/car/booking/order/pay", new a(70, this));
        arrayMap.put("1/car/booking/order/payment/success", new a(71, this));
        arrayMap.put("1/car/booking/order/payment/failure", new a(72, this));
        arrayMap.put("1/brandspace/show", new a(73, this));
        arrayMap.put("1/verifyIdentity/passport", new a(74, this));
        arrayMap.put("1/cart/open", g0.a);
        arrayMap.put("1/profile/smbStatistics", h0.a);
        arrayMap.put("2/items", new a(75, this));
        arrayMap.put("1/refreshCurrent", i0.a);
        arrayMap.put("1/profile/verifyIdentity/list", j0.a);
        arrayMap.put("1/profile/verifyIdentity/open", new a(78, this));
        arrayMap.put("1/profile/verifyIdentity/remove", new a(79, this));
    }

    public static final SearchParams access$createSearchParamsFromUri(DeepLinkFactory deepLinkFactory, Uri uri) {
        Objects.requireNonNull(deepLinkFactory);
        SearchParams fromUri = SearchParamsFactory.fromUri(uri);
        Intrinsics.checkNotNullExpressionValue(fromUri, "SearchParamsFactory.fromUri(uri)");
        return fromUri;
    }

    public static final Gson access$getGson$p(DeepLinkFactory deepLinkFactory) {
        return (Gson) deepLinkFactory.d.getValue();
    }

    public static final List access$getQueryParametersFromJson(DeepLinkFactory deepLinkFactory, Uri uri, String str) {
        Objects.requireNonNull(deepLinkFactory);
        return (List) new Gson().fromJson(deepLinkFactory.b(uri, str), new TypeToken<List<? extends String>>() { // from class: com.avito.android.deep_linking.DeepLinkFactory$getQueryParametersFromJson$listType$1
        }.getType());
    }

    public static final Uri access$getUri(DeepLinkFactory deepLinkFactory, Uri uri, String str) {
        String b2 = deepLinkFactory.b(uri, str);
        if (b2 == null || t6.y.m.isBlank(b2)) {
            return null;
        }
        return Uri.parse(b2);
    }

    public final String a(Uri uri, String str) {
        String path = uri.getPath();
        if (path != null) {
            return new Regex("[^\\w-/]").replace(path, str);
        }
        return null;
    }

    public final String b(Uri uri, String str) {
        Intrinsics.checkNotNullParameter(uri, "$this$get");
        return uri.getQueryParameter(str);
    }

    public final void c(Uri uri) {
        if (this.f != null && this.g != null) {
            String a3 = a(uri, "_");
            String replaceAfterLast$default = a3 != null ? StringsKt__StringsKt.replaceAfterLast$default(a3, "/", "ID", (String) null, 4, (Object) null) : null;
            Analytics analytics = this.f;
            analytics.track(new StatsdEvent.CountEvent(this.g.getVersionCode() + ".deprecated-deep-link." + replaceAfterLast$default, 0, 2, null));
        }
    }

    @NotNull
    public DeepLink createFromUri(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.MEDIA_URI);
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(uri)");
        return createFromUri(parse);
    }

    @NotNull
    public DeepLink createFromUri(@NotNull Uri uri) {
        DeepLink deepLink;
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        if (!Intrinsics.areEqual(uri.getScheme(), DeepLinkKt.DEEPLINK_URI_SCHEME)) {
            return this.b;
        }
        int match = this.a.match(uri);
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment != null) {
            DeepLink deepLink2 = null;
            if (match == 0) {
                c(uri);
                deepLink = new AdvertDetailsLink(lastPathSegment, null);
            } else if (match == 1) {
                c(uri);
                deepLink = new MyAdvertDetailsLink(lastPathSegment, null, 2, null);
            } else if (match == 2 && !t6.y.m.startsWith$default(lastPathSegment, "search", false, 2, null)) {
                c(uri);
                deepLink = new ChannelDetailsLink(lastPathSegment);
            } else {
                deepLink = null;
            }
            if (deepLink != null) {
                return deepLink;
            }
            Function1<Uri, DeepLink> function1 = this.c.get(uri.getHost() + uri.getPath());
            if (function1 != null) {
                deepLink2 = function1.invoke(uri);
            }
            if (deepLink2 != null && !(deepLink2 instanceof NoMatchLink)) {
                return deepLink2;
            }
            if (!(this.f == null || this.g == null)) {
                String a3 = a(uri, "_");
                this.f.track(new StatsdEvent.CountEvent(this.g.getVersionCode() + ".unknown-deep-link." + a3, 0, 2, null));
            }
            return this.b;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeepLinkFactory(Features features, Analytics analytics, BuildInfo buildInfo, int i2, t6.r.a.j jVar) {
        this(features, (i2 & 2) != 0 ? null : analytics, (i2 & 4) != 0 ? null : buildInfo);
    }
}
