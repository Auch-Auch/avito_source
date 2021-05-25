package com.avito.android.remote.model.category_parameters.slot;

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
import com.facebook.share.internal.ShareConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.q;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u001d\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/SlotType;", "", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "Lkotlin/reflect/KClass;", "slotClass", "Lkotlin/reflect/KClass;", "getSlotClass", "()Lkotlin/reflect/KClass;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/reflect/KClass;)V", "Companion", "OTHER", "PROFILE_INFO", "CONTACT_INFO", "TEXT_SUGGESTIONS", "NO_CAR", "MARKET_PRICE", "ANONYMOUS_NUMBER", "CONTACT_METHOD", "EDIT_CATEGORY", "AUTO_SORT_PHOTOS", "AUTO_PUBLISH", "LIMITS_INFO", "RESIDENTIAL_COMPLEX", "INFORMATION", "SECTION_SEPARATOR", ShareConstants.CONTENT_URL, "INFORMATION_WITH_USER_ID", "PARAMETERS_SUGGEST_BY_ADDRESS", "CPA_TARIFF_NOTIFICATION", "models_release"}, k = 1, mv = {1, 4, 2})
public enum SlotType {
    OTHER("", Reflection.getOrCreateKotlinClass(Object.class)),
    PROFILE_INFO("profileInfo", Reflection.getOrCreateKotlinClass(ProfileInfoSlot.class)),
    CONTACT_INFO("contactInfo", Reflection.getOrCreateKotlinClass(ContactInfoSlot.class)),
    TEXT_SUGGESTIONS("textSuggestions", Reflection.getOrCreateKotlinClass(TextSuggestionsSlot.class)),
    NO_CAR("noCar", Reflection.getOrCreateKotlinClass(NoCarSlot.class)),
    MARKET_PRICE("marketPrice", Reflection.getOrCreateKotlinClass(MarketPriceSlot.class)),
    ANONYMOUS_NUMBER("anonymousNumber", Reflection.getOrCreateKotlinClass(AnonymousNumberSlot.class)),
    CONTACT_METHOD("contactMethod", Reflection.getOrCreateKotlinClass(ContactMethodSlot.class)),
    EDIT_CATEGORY("editCategory", Reflection.getOrCreateKotlinClass(EditCategorySlot.class)),
    AUTO_SORT_PHOTOS("autoSortImages", Reflection.getOrCreateKotlinClass(AutoSortPhotosSlot.class)),
    AUTO_PUBLISH("autoPublish", Reflection.getOrCreateKotlinClass(AutoPublishSlot.class)),
    LIMITS_INFO("limitsInfo", Reflection.getOrCreateKotlinClass(LimitsInfoSlot.class)),
    RESIDENTIAL_COMPLEX("residentialComplex", Reflection.getOrCreateKotlinClass(ResidentialComplexSlot.class)),
    INFORMATION("information", Reflection.getOrCreateKotlinClass(InformationSlot.class)),
    SECTION_SEPARATOR("sectionSeparator", Reflection.getOrCreateKotlinClass(SectionSeparatorSlot.class)),
    LINK("link", Reflection.getOrCreateKotlinClass(LinkSlot.class)),
    INFORMATION_WITH_USER_ID("UserIdentifierSlot", Reflection.getOrCreateKotlinClass(InformationWithUserIdSlot.class)),
    PARAMETERS_SUGGEST_BY_ADDRESS("parametersSuggestByAddress", Reflection.getOrCreateKotlinClass(ParametersSuggestByAddressSlot.class)),
    CPA_TARIFF_NOTIFICATION("cpaNotification", Reflection.getOrCreateKotlinClass(CpaTariffSlot.class));
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final Map<String, SlotType> valuesMap;
    @NotNull
    private final KClass<?> slotClass;
    @NotNull
    private final String strValue;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/SlotType$Companion;", "", "", "strValue", "Lcom/avito/android/remote/model/category_parameters/slot/SlotType;", "valueOfStr", "(Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/slot/SlotType;", "", "valuesMap", "Ljava/util/Map;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final SlotType valueOfStr(@Nullable String str) {
            if (str == null) {
                return SlotType.OTHER;
            }
            SlotType slotType = (SlotType) SlotType.valuesMap.get(str);
            return slotType != null ? slotType : SlotType.OTHER;
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* access modifiers changed from: public */
    static {
        SlotType[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(e.coerceAtLeast(q.mapCapacity(19), 16));
        for (SlotType slotType : values) {
            linkedHashMap.put(slotType.strValue, slotType);
        }
        valuesMap = linkedHashMap;
    }

    private SlotType(String str, KClass kClass) {
        this.strValue = str;
        this.slotClass = kClass;
    }

    @NotNull
    public final KClass<?> getSlotClass() {
        return this.slotClass;
    }

    @NotNull
    public final String getStrValue() {
        return this.strValue;
    }
}
