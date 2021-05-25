package com.avito.android.publish.slots;

import a2.a.a.e2.d0.c;
import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.SessionChangeTracker;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.ContactsDataSource;
import com.avito.android.publish.ProfileSourceInteractor;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.details.analytics.PublishDetailsTracker;
import com.avito.android.publish.slots.anonymous_number.AnonymousNumberSlotWrapper;
import com.avito.android.publish.slots.auto_sort_photos.AutoSortPhotosSlotWrapper;
import com.avito.android.publish.slots.contact_info.ContactInfoSlotWrapper;
import com.avito.android.publish.slots.cpa_tariff.CpaTariffSlotWrapper;
import com.avito.android.publish.slots.infomation.InformationSlotWrapper;
import com.avito.android.publish.slots.information_with_user_id.InformationWithUserIdSlotWrapper;
import com.avito.android.publish.slots.limits_info.LimitsInfoSlotWrapper;
import com.avito.android.publish.slots.link.LinkSlotWrapper;
import com.avito.android.publish.slots.market_price.MarketPriceSlotWrapper;
import com.avito.android.publish.slots.no_car.NoCarSlotWrapper;
import com.avito.android.publish.slots.parameters_suggest.ParametersSuggestByAddressSlotWrapper;
import com.avito.android.publish.slots.profile_info.ProfileInfoSlotWrapper;
import com.avito.android.publish.slots.profile_info.PublishContactsStringProvider;
import com.avito.android.publish.slots.text_suggests.TextSuggestionsSlotWrapper;
import com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.slot.BaseSlot;
import com.avito.android.remote.model.category_parameters.slot.Slot;
import com.avito.android.remote.model.category_parameters.slot.SlotType;
import com.avito.android.remote.model.category_parameters.slot.anonymous_number.AnonymousNumberSlot;
import com.avito.android.remote.model.category_parameters.slot.auto_publish.AutoPublishSlot;
import com.avito.android.remote.model.category_parameters.slot.auto_sort_photo.AutoSortPhotosSlot;
import com.avito.android.remote.model.category_parameters.slot.contact_info.ContactInfoSlot;
import com.avito.android.remote.model.category_parameters.slot.contact_method.ContactMethodSlot;
import com.avito.android.remote.model.category_parameters.slot.cpa_tariff.CpaTariffSlot;
import com.avito.android.remote.model.category_parameters.slot.edit_category.EditCategorySlot;
import com.avito.android.remote.model.category_parameters.slot.header.SectionSeparatorSlot;
import com.avito.android.remote.model.category_parameters.slot.information.InformationSlot;
import com.avito.android.remote.model.category_parameters.slot.information.InformationWithUserIdSlot;
import com.avito.android.remote.model.category_parameters.slot.limits_info.LimitsInfoSlot;
import com.avito.android.remote.model.category_parameters.slot.link.LinkSlot;
import com.avito.android.remote.model.category_parameters.slot.market_price.MarketPriceSlot;
import com.avito.android.remote.model.category_parameters.slot.no_car.NoCarSlot;
import com.avito.android.remote.model.category_parameters.slot.parameters_suggest.ParametersSuggestByAddressSlot;
import com.avito.android.remote.model.category_parameters.slot.profile_info.ProfileInfoSlot;
import com.avito.android.remote.model.category_parameters.slot.residential_complex.ResidentialComplexSlot;
import com.avito.android.remote.model.category_parameters.slot.text_suggests.TextSuggestionsSlot;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B¥\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u00101\u001a\u00020.\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010S\u001a\u00020P¢\u0006\u0004\be\u0010fJ)\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010(R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\"\u0010]\u001a\u00020\\8\u0016@\u0016X.¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0016\u0010d\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010(¨\u0006g"}, d2 = {"Lcom/avito/android/publish/slots/SlotsFactoryImpl;", "Lcom/avito/android/publish/slots/SlotsFactory;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "params", "", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/Slot;", "createSlotSet", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Ljava/util/Set;", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "t", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "publishEventTracker", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "l", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "converter", "Lcom/avito/android/publish/ProfileSourceInteractor;", "d", "Lcom/avito/android/publish/ProfileSourceInteractor;", "profileSource", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "o", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsData", "Lcom/avito/android/util/Formatter;", "", VKApiConst.Q, "Lcom/avito/android/util/Formatter;", "phoneFormatter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "k", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "", AuthSource.SEND_ABUSE, "Z", "isParametersSuggestByGeoSlotEnable", "Lcom/avito/android/remote/PublishApi;", g.a, "Lcom/avito/android/remote/PublishApi;", "publishApi", "Lcom/avito/android/analytics/Analytics;", "p", "Lcom/avito/android/analytics/Analytics;", "analyticsTracker", "Lcom/avito/android/account/SessionChangeTracker;", "r", "Lcom/avito/android/account/SessionChangeTracker;", "sessionChangeTracker", "Lcom/avito/android/publish/ContactsDataSource;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/publish/ContactsDataSource;", "contactsDataSource", AuthSource.BOOKING_ORDER, "isCpaTariffSlotEnable", "Lcom/avito/android/publish/slots/profile_info/PublishContactsStringProvider;", "n", "Lcom/avito/android/publish/slots/profile_info/PublishContactsStringProvider;", "contactsStringProvider", "Lcom/avito/android/account/AccountStorageInteractor;", "j", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "Lcom/avito/android/remote/ProfileApi;", "f", "Lcom/avito/android/remote/ProfileApi;", "profileApi", "Lcom/avito/android/remote/PublishLimitsApi;", "h", "Lcom/avito/android/remote/PublishLimitsApi;", "limitsApi", "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "s", "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "performanceTracker", "Lcom/avito/android/Features;", VKApiConst.VERSION, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "i", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "u", "Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "publishLimitsEventTracker", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "Lcom/avito/android/publish/PublishViewModel;", "getPublishViewModel", "()Lcom/avito/android/publish/PublishViewModel;", "setPublishViewModel", "(Lcom/avito/android/publish/PublishViewModel;)V", "c", "isLimitsInfoSlotEnabled", "<init>", "(Lcom/avito/android/publish/ProfileSourceInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/remote/PublishApi;Lcom/avito/android/remote/PublishLimitsApi;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/publish/ContactsDataSource;Lcom/avito/android/publish/slots/profile_info/PublishContactsStringProvider;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/Formatter;Lcom/avito/android/account/SessionChangeTracker;Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;Lcom/avito/android/publish/analytics/PublishEventTracker;Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;Lcom/avito/android/Features;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class SlotsFactoryImpl implements SlotsFactory {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final ProfileSourceInteractor d;
    public final SchedulersFactory3 e;
    public final ProfileApi f;
    public final PublishApi g;
    public final PublishLimitsApi h;
    public final TypedErrorThrowableConverter i;
    public final AccountStorageInteractor j;
    public final AttributedTextFormatter k;
    public final CategoryParametersConverter l;
    public final ContactsDataSource m;
    public final PublishContactsStringProvider n;
    public final PublishAnalyticsDataProvider o;
    public final Analytics p;
    public PublishViewModel publishViewModel;
    public final Formatter<String> q;
    public final SessionChangeTracker r;
    public final PublishDetailsTracker s;
    public final PublishEventTracker t;
    public final PublishLimitsEventTracker u;
    public final Features v;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SlotType.values();
            int[] iArr = new int[19];
            $EnumSwitchMapping$0 = iArr;
            SlotType slotType = SlotType.PROFILE_INFO;
            iArr[1] = 1;
            SlotType slotType2 = SlotType.CONTACT_INFO;
            iArr[2] = 2;
            SlotType slotType3 = SlotType.ANONYMOUS_NUMBER;
            iArr[6] = 3;
            SlotType slotType4 = SlotType.NO_CAR;
            iArr[4] = 4;
            SlotType slotType5 = SlotType.TEXT_SUGGESTIONS;
            iArr[3] = 5;
            SlotType slotType6 = SlotType.MARKET_PRICE;
            iArr[5] = 6;
            SlotType slotType7 = SlotType.CONTACT_METHOD;
            iArr[7] = 7;
            SlotType slotType8 = SlotType.EDIT_CATEGORY;
            iArr[8] = 8;
            SlotType slotType9 = SlotType.AUTO_SORT_PHOTOS;
            iArr[9] = 9;
            SlotType slotType10 = SlotType.AUTO_PUBLISH;
            iArr[10] = 10;
            SlotType slotType11 = SlotType.LIMITS_INFO;
            iArr[11] = 11;
            SlotType slotType12 = SlotType.RESIDENTIAL_COMPLEX;
            iArr[12] = 12;
            SlotType slotType13 = SlotType.INFORMATION;
            iArr[13] = 13;
            SlotType slotType14 = SlotType.LINK;
            iArr[15] = 14;
            SlotType slotType15 = SlotType.SECTION_SEPARATOR;
            iArr[14] = 15;
            SlotType slotType16 = SlotType.INFORMATION_WITH_USER_ID;
            iArr[16] = 16;
            SlotType slotType17 = SlotType.PARAMETERS_SUGGEST_BY_ADDRESS;
            iArr[17] = 17;
            SlotType slotType18 = SlotType.CPA_TARIFF_NOTIFICATION;
            iArr[18] = 18;
            SlotType slotType19 = SlotType.OTHER;
            iArr[0] = 19;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<Slot<?>, Boolean> {
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
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Slot<?> slot) {
            int i = this.a;
            boolean z = false;
            if (i == 0) {
                Slot<?> slot2 = slot;
                Intrinsics.checkNotNullParameter(slot2, "it");
                if (((SlotsFactoryImpl) this.b).a || !(slot2 instanceof ParametersSuggestByAddressSlot)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else if (i == 1) {
                Slot<?> slot3 = slot;
                Intrinsics.checkNotNullParameter(slot3, "it");
                if (((SlotsFactoryImpl) this.b).b || !(slot3 instanceof CpaTariffSlot)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else if (i == 2) {
                Slot<?> slot4 = slot;
                Intrinsics.checkNotNullParameter(slot4, "it");
                if (((SlotsFactoryImpl) this.b).c || !(slot4 instanceof LimitsInfoSlot)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else {
                throw null;
            }
        }
    }

    public SlotsFactoryImpl(@NotNull ProfileSourceInteractor profileSourceInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ProfileApi profileApi, @NotNull PublishApi publishApi, @NotNull PublishLimitsApi publishLimitsApi, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull AccountStorageInteractor accountStorageInteractor, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull ContactsDataSource contactsDataSource, @NotNull PublishContactsStringProvider publishContactsStringProvider, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull Analytics analytics, @NotNull Formatter<String> formatter, @NotNull SessionChangeTracker sessionChangeTracker, @NotNull PublishDetailsTracker publishDetailsTracker, @NotNull PublishEventTracker publishEventTracker, @NotNull PublishLimitsEventTracker publishLimitsEventTracker, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(profileSourceInteractor, "profileSource");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(profileApi, "profileApi");
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        Intrinsics.checkNotNullParameter(publishLimitsApi, "limitsApi");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "converter");
        Intrinsics.checkNotNullParameter(contactsDataSource, "contactsDataSource");
        Intrinsics.checkNotNullParameter(publishContactsStringProvider, "contactsStringProvider");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsData");
        Intrinsics.checkNotNullParameter(analytics, "analyticsTracker");
        Intrinsics.checkNotNullParameter(formatter, "phoneFormatter");
        Intrinsics.checkNotNullParameter(sessionChangeTracker, "sessionChangeTracker");
        Intrinsics.checkNotNullParameter(publishDetailsTracker, "performanceTracker");
        Intrinsics.checkNotNullParameter(publishEventTracker, "publishEventTracker");
        Intrinsics.checkNotNullParameter(publishLimitsEventTracker, "publishLimitsEventTracker");
        Intrinsics.checkNotNullParameter(features, "features");
        this.d = profileSourceInteractor;
        this.e = schedulersFactory3;
        this.f = profileApi;
        this.g = publishApi;
        this.h = publishLimitsApi;
        this.i = typedErrorThrowableConverter;
        this.j = accountStorageInteractor;
        this.k = attributedTextFormatter;
        this.l = categoryParametersConverter;
        this.m = contactsDataSource;
        this.n = publishContactsStringProvider;
        this.o = publishAnalyticsDataProvider;
        this.p = analytics;
        this.q = formatter;
        this.r = sessionChangeTracker;
        this.s = publishDetailsTracker;
        this.t = publishEventTracker;
        this.u = publishLimitsEventTracker;
        this.v = features;
        this.a = features.getSupportParametersSuggestByGeoSlot().invoke().booleanValue();
        this.b = features.getSupportCpaTariffSlot().invoke().booleanValue();
        this.c = features.getLimitsInfoOnPublish().invoke().booleanValue();
    }

    public static final SlotWrapper access$createSlot(SlotsFactoryImpl slotsFactoryImpl, BaseSlot baseSlot) {
        SlotWrapper slotWrapper;
        Objects.requireNonNull(slotsFactoryImpl);
        switch (baseSlot.getSlotType().ordinal()) {
            case 0:
                throw new UnsupportedOperationException("Unknown type of Slot");
            case 1:
                slotWrapper = new ProfileInfoSlotWrapper((ProfileInfoSlot) baseSlot, slotsFactoryImpl.n, slotsFactoryImpl.m);
                break;
            case 2:
                slotWrapper = new ContactInfoSlotWrapper((ContactInfoSlot) baseSlot, slotsFactoryImpl.d, slotsFactoryImpl.m, slotsFactoryImpl.f, slotsFactoryImpl.i, slotsFactoryImpl.j, slotsFactoryImpl.q, slotsFactoryImpl.getPublishViewModel().isEditing(), slotsFactoryImpl.r, slotsFactoryImpl.e, slotsFactoryImpl.t);
                break;
            case 3:
                return new TextSuggestionsSlotWrapper((TextSuggestionsSlot) baseSlot);
            case 4:
                return new NoCarSlotWrapper((NoCarSlot) baseSlot);
            case 5:
                slotWrapper = new MarketPriceSlotWrapper((MarketPriceSlot) baseSlot, slotsFactoryImpl.g, slotsFactoryImpl.getPublishViewModel(), slotsFactoryImpl.k, slotsFactoryImpl.l, slotsFactoryImpl.o, slotsFactoryImpl.p, slotsFactoryImpl.e, slotsFactoryImpl.s, slotsFactoryImpl.v);
                break;
            case 6:
                slotWrapper = new AnonymousNumberSlotWrapper((AnonymousNumberSlot) baseSlot, slotsFactoryImpl.getPublishViewModel(), slotsFactoryImpl.g, slotsFactoryImpl.l, slotsFactoryImpl.e, slotsFactoryImpl.o, slotsFactoryImpl.s, slotsFactoryImpl.m);
                break;
            case 7:
                return new ContactMethodSlotWrapper((ContactMethodSlot) baseSlot);
            case 8:
                return new EditCategorySlotWrapper((EditCategorySlot) baseSlot);
            case 9:
                slotWrapper = new AutoSortPhotosSlotWrapper((AutoSortPhotosSlot) baseSlot, slotsFactoryImpl.getPublishViewModel().getCategoryParameters());
                break;
            case 10:
                slotWrapper = new AutoPublishSlotWrapper((AutoPublishSlot) baseSlot, slotsFactoryImpl.g, slotsFactoryImpl.getPublishViewModel(), slotsFactoryImpl.l, slotsFactoryImpl.o, slotsFactoryImpl.e, slotsFactoryImpl.s);
                break;
            case 11:
                slotWrapper = new LimitsInfoSlotWrapper((LimitsInfoSlot) baseSlot, new c(slotsFactoryImpl), slotsFactoryImpl.h, slotsFactoryImpl.e, slotsFactoryImpl.u);
                break;
            case 12:
                return new ResidentialComplexSlotWrapper((ResidentialComplexSlot) baseSlot);
            case 13:
                return new InformationSlotWrapper((InformationSlot) baseSlot);
            case 14:
                return new SectionSeparatorSlotWrapper((SectionSeparatorSlot) baseSlot);
            case 15:
                return new LinkSlotWrapper((LinkSlot) baseSlot);
            case 16:
                slotWrapper = new InformationWithUserIdSlotWrapper((InformationWithUserIdSlot) baseSlot, slotsFactoryImpl.d, slotsFactoryImpl.e);
                break;
            case 17:
                slotWrapper = new ParametersSuggestByAddressSlotWrapper((ParametersSuggestByAddressSlot) baseSlot, slotsFactoryImpl.g, slotsFactoryImpl.getPublishViewModel(), slotsFactoryImpl.e, slotsFactoryImpl.l, slotsFactoryImpl.o);
                break;
            case 18:
                return new CpaTariffSlotWrapper((CpaTariffSlot) baseSlot);
            default:
                throw new NoWhenBranchMatchedException();
        }
        return slotWrapper;
    }

    @Override // com.avito.android.publish.slots.SlotsFactory
    @NotNull
    public Set<SlotWrapper<? extends Slot<?>>> createSlotSet(@NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(parametersTree, "params");
        Sequence filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(parametersTree), SlotsFactoryImpl$createSlotSet$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        return SequencesKt___SequencesKt.toSet(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.filter(filter, new a(0, this)), new a(1, this)), new a(2, this)), new Function1<BaseSlot, SlotWrapper<? extends Slot<?>>>(this) { // from class: com.avito.android.publish.slots.SlotsFactoryImpl.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public SlotWrapper<? extends Slot<?>> invoke(BaseSlot baseSlot) {
                BaseSlot baseSlot2 = baseSlot;
                Intrinsics.checkNotNullParameter(baseSlot2, "p1");
                return SlotsFactoryImpl.access$createSlot((SlotsFactoryImpl) this.receiver, baseSlot2);
            }
        }));
    }

    @Override // com.avito.android.publish.slots.SlotsFactory
    @NotNull
    public PublishViewModel getPublishViewModel() {
        PublishViewModel publishViewModel2 = this.publishViewModel;
        if (publishViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel2;
    }

    @Override // com.avito.android.publish.slots.SlotsFactory
    public void setPublishViewModel(@NotNull PublishViewModel publishViewModel2) {
        Intrinsics.checkNotNullParameter(publishViewModel2, "<set-?>");
        this.publishViewModel = publishViewModel2;
    }
}
