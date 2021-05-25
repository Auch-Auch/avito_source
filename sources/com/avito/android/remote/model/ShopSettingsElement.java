package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.util.preferences.GeoContract;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0013\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\t\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement;", "", "<init>", "()V", "Address", "Domain", "HasConfirmation", "HasErrors", "HasModifiable", "HasPlaceholder", "HasPrefix", "HasSuggestion", "HasText", "HasTitle", "Identifiable", "Input", "MultiLine", "Phone", "Select", "SingleLine", "Switcher", "TitleSubtitle", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lcom/avito/android/remote/model/ShopSettingsElement$SingleLine;", "Lcom/avito/android/remote/model/ShopSettingsElement$MultiLine;", "Lcom/avito/android/remote/model/ShopSettingsElement$Domain;", "Lcom/avito/android/remote/model/ShopSettingsElement$Phone;", "Lcom/avito/android/remote/model/ShopSettingsElement$Select;", "Lcom/avito/android/remote/model/ShopSettingsElement$Address;", "Lcom/avito/android/remote/model/ShopSettingsElement$Switcher;", "Lcom/avito/android/remote/model/ShopSettingsElement$TitleSubtitle;", "Lcom/avito/android/remote/model/ShopSettingsElement$Unknown;", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
public abstract class ShopSettingsElement {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002Bm\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\"\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b%\u0010&R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u001c\u0010\f\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007R\u001c\u0010\"\u001a\u00020\u00158\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b\"\u0010\u0018R\u001c\u0010#\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007¨\u0006'"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$Address;", "Lcom/avito/android/remote/model/ShopSettingsElement;", "Lcom/avito/android/remote/model/ShopSettingsElement$Input;", "", "suggestion", "Ljava/lang/String;", "getSuggestion", "()Ljava/lang/String;", "text", "getText", GeoContract.LATITUDE, "getLatitude", "title", "getTitle", InternalConstsKt.PLACEHOLDER, "getPlaceholder", "Lcom/avito/android/remote/model/ShopSettingsModerationError;", "moderationError", "Lcom/avito/android/remote/model/ShopSettingsModerationError;", "getModerationError", "()Lcom/avito/android/remote/model/ShopSettingsModerationError;", "", "isConfirmed", "Z", "()Z", "prefix", "getPrefix", "Lcom/avito/android/remote/model/ShopSettingsValidationError;", "validationError", "Lcom/avito/android/remote/model/ShopSettingsValidationError;", "getValidationError", "()Lcom/avito/android/remote/model/ShopSettingsValidationError;", GeoContract.LONGITUDE, "getLongitude", "isModifiable", "id", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/ShopSettingsModerationError;Lcom/avito/android/remote/model/ShopSettingsValidationError;)V", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Address extends ShopSettingsElement implements Input {
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("isConfirmed")
        private final boolean isConfirmed;
        @SerializedName("isModifiable")
        private final boolean isModifiable;
        @SerializedName(GeoContract.LATITUDE)
        @Nullable
        private final String latitude;
        @SerializedName(GeoContract.LONGITUDE)
        @Nullable
        private final String longitude;
        @SerializedName("moderationError")
        @Nullable
        private final ShopSettingsModerationError moderationError;
        @SerializedName(InternalConstsKt.PLACEHOLDER)
        @Nullable
        private final String placeholder;
        @Nullable
        private final String prefix;
        @SerializedName("suggestion")
        @Nullable
        private final String suggestion;
        @SerializedName("text")
        @Nullable
        private final String text;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("validationError")
        @Nullable
        private final ShopSettingsValidationError validationError;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Address(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, boolean z, boolean z2, @Nullable String str6, @Nullable String str7, @Nullable ShopSettingsModerationError shopSettingsModerationError, @Nullable ShopSettingsValidationError shopSettingsValidationError) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.id = str;
            this.title = str2;
            this.text = str3;
            this.placeholder = str4;
            this.suggestion = str5;
            this.isModifiable = z;
            this.isConfirmed = z2;
            this.latitude = str6;
            this.longitude = str7;
            this.moderationError = shopSettingsModerationError;
            this.validationError = shopSettingsValidationError;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.Identifiable
        @NotNull
        public String getId() {
            return this.id;
        }

        @Nullable
        public final String getLatitude() {
            return this.latitude;
        }

        @Nullable
        public final String getLongitude() {
            return this.longitude;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasErrors
        @Nullable
        public ShopSettingsModerationError getModerationError() {
            return this.moderationError;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasPlaceholder
        @Nullable
        public String getPlaceholder() {
            return this.placeholder;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasPrefix
        @Nullable
        public String getPrefix() {
            return this.prefix;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasSuggestion
        @Nullable
        public String getSuggestion() {
            return this.suggestion;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasText
        @Nullable
        public String getText() {
            return this.text;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasTitle
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasErrors
        @Nullable
        public ShopSettingsValidationError getValidationError() {
            return this.validationError;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasConfirmation
        public boolean isConfirmed() {
            return this.isConfirmed;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasModifiable
        public boolean isModifiable() {
            return this.isModifiable;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002Bc\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b!\u0010\"R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R\u001c\u0010\u000f\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u00020\u00168\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007R\u001c\u0010\u001c\u001a\u00020\u00168\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001c\u0010\u0019R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$Domain;", "Lcom/avito/android/remote/model/ShopSettingsElement;", "Lcom/avito/android/remote/model/ShopSettingsElement$Input;", "", "suggestion", "Ljava/lang/String;", "getSuggestion", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/ShopSettingsModerationError;", "moderationError", "Lcom/avito/android/remote/model/ShopSettingsModerationError;", "getModerationError", "()Lcom/avito/android/remote/model/ShopSettingsModerationError;", InternalConstsKt.PLACEHOLDER, "getPlaceholder", "id", "getId", "Lcom/avito/android/remote/model/ShopSettingsValidationError;", "validationError", "Lcom/avito/android/remote/model/ShopSettingsValidationError;", "getValidationError", "()Lcom/avito/android/remote/model/ShopSettingsValidationError;", "", "isConfirmed", "Z", "()Z", "title", "getTitle", "isModifiable", "prefix", "getPrefix", "text", "getText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/ShopSettingsModerationError;Lcom/avito/android/remote/model/ShopSettingsValidationError;)V", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Domain extends ShopSettingsElement implements Input {
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("isConfirmed")
        private final boolean isConfirmed;
        @SerializedName("isModifiable")
        private final boolean isModifiable;
        @SerializedName("moderationError")
        @Nullable
        private final ShopSettingsModerationError moderationError;
        @SerializedName(InternalConstsKt.PLACEHOLDER)
        @Nullable
        private final String placeholder;
        @SerializedName("prefix")
        @Nullable
        private final String prefix;
        @SerializedName("suggestion")
        @Nullable
        private final String suggestion;
        @SerializedName("text")
        @Nullable
        private final String text;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("validationError")
        @Nullable
        private final ShopSettingsValidationError validationError;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Domain(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, boolean z, boolean z2, @Nullable ShopSettingsModerationError shopSettingsModerationError, @Nullable ShopSettingsValidationError shopSettingsValidationError) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.id = str;
            this.title = str2;
            this.text = str3;
            this.placeholder = str4;
            this.suggestion = str5;
            this.prefix = str6;
            this.isModifiable = z;
            this.isConfirmed = z2;
            this.moderationError = shopSettingsModerationError;
            this.validationError = shopSettingsValidationError;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.Identifiable
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasErrors
        @Nullable
        public ShopSettingsModerationError getModerationError() {
            return this.moderationError;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasPlaceholder
        @Nullable
        public String getPlaceholder() {
            return this.placeholder;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasPrefix
        @Nullable
        public String getPrefix() {
            return this.prefix;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasSuggestion
        @Nullable
        public String getSuggestion() {
            return this.suggestion;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasText
        @Nullable
        public String getText() {
            return this.text;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasTitle
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasErrors
        @Nullable
        public ShopSettingsValidationError getValidationError() {
            return this.validationError;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasConfirmation
        public boolean isConfirmed() {
            return this.isConfirmed;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasModifiable
        public boolean isModifiable() {
            return this.isModifiable;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$HasConfirmation;", "", "", "isConfirmed", "()Z", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public interface HasConfirmation {
        boolean isConfirmed();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$HasErrors;", "", "Lcom/avito/android/remote/model/ShopSettingsValidationError;", "getValidationError", "()Lcom/avito/android/remote/model/ShopSettingsValidationError;", "validationError", "Lcom/avito/android/remote/model/ShopSettingsModerationError;", "getModerationError", "()Lcom/avito/android/remote/model/ShopSettingsModerationError;", "moderationError", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public interface HasErrors {
        @Nullable
        ShopSettingsModerationError getModerationError();

        @Nullable
        ShopSettingsValidationError getValidationError();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$HasModifiable;", "", "", "isModifiable", "()Z", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public interface HasModifiable {
        boolean isModifiable();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$HasPlaceholder;", "", "", "getPlaceholder", "()Ljava/lang/String;", InternalConstsKt.PLACEHOLDER, "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public interface HasPlaceholder {
        @Nullable
        String getPlaceholder();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$HasPrefix;", "", "", "getPrefix", "()Ljava/lang/String;", "prefix", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public interface HasPrefix {
        @Nullable
        String getPrefix();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$HasSuggestion;", "", "", "getSuggestion", "()Ljava/lang/String;", "suggestion", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public interface HasSuggestion {
        @Nullable
        String getSuggestion();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$HasText;", "", "", "getText", "()Ljava/lang/String;", "text", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public interface HasText {
        @Nullable
        String getText();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$HasTitle;", "", "", "getTitle", "()Ljava/lang/String;", "title", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public interface HasTitle {
        @NotNull
        String getTitle();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$Identifiable;", "", "", "getId", "()Ljava/lang/String;", "id", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public interface Identifiable {
        @NotNull
        String getId();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$Input;", "Lcom/avito/android/remote/model/ShopSettingsElement$Identifiable;", "Lcom/avito/android/remote/model/ShopSettingsElement$HasSuggestion;", "Lcom/avito/android/remote/model/ShopSettingsElement$HasText;", "Lcom/avito/android/remote/model/ShopSettingsElement$HasConfirmation;", "Lcom/avito/android/remote/model/ShopSettingsElement$HasPrefix;", "Lcom/avito/android/remote/model/ShopSettingsElement$HasTitle;", "Lcom/avito/android/remote/model/ShopSettingsElement$HasModifiable;", "Lcom/avito/android/remote/model/ShopSettingsElement$HasPlaceholder;", "Lcom/avito/android/remote/model/ShopSettingsElement$HasErrors;", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public interface Input extends Identifiable, HasSuggestion, HasText, HasConfirmation, HasPrefix, HasTitle, HasModifiable, HasPlaceholder, HasErrors {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002Bc\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\r\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\r8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\r8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\r8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$MultiLine;", "Lcom/avito/android/remote/model/ShopSettingsElement;", "Lcom/avito/android/remote/model/ShopSettingsElement$Input;", "", "isModifiable", "Z", "()Z", "Lcom/avito/android/remote/model/ShopSettingsValidationError;", "validationError", "Lcom/avito/android/remote/model/ShopSettingsValidationError;", "getValidationError", "()Lcom/avito/android/remote/model/ShopSettingsValidationError;", "isConfirmed", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "prefix", "getPrefix", "Lcom/avito/android/remote/model/ShopSettingsModerationError;", "moderationError", "Lcom/avito/android/remote/model/ShopSettingsModerationError;", "getModerationError", "()Lcom/avito/android/remote/model/ShopSettingsModerationError;", "title", "getTitle", "text", "getText", "suggestion", "getSuggestion", InternalConstsKt.PLACEHOLDER, "getPlaceholder", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/ShopSettingsModerationError;Lcom/avito/android/remote/model/ShopSettingsValidationError;)V", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class MultiLine extends ShopSettingsElement implements Input {
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("isConfirmed")
        private final boolean isConfirmed;
        @SerializedName("isModifiable")
        private final boolean isModifiable;
        @SerializedName("moderationError")
        @Nullable
        private final ShopSettingsModerationError moderationError;
        @SerializedName(InternalConstsKt.PLACEHOLDER)
        @Nullable
        private final String placeholder;
        @SerializedName("prefix")
        @Nullable
        private final String prefix;
        @SerializedName("suggestion")
        @Nullable
        private final String suggestion;
        @SerializedName("text")
        @Nullable
        private final String text;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("validationError")
        @Nullable
        private final ShopSettingsValidationError validationError;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MultiLine(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, boolean z, boolean z2, @Nullable ShopSettingsModerationError shopSettingsModerationError, @Nullable ShopSettingsValidationError shopSettingsValidationError) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.id = str;
            this.title = str2;
            this.text = str3;
            this.placeholder = str4;
            this.suggestion = str5;
            this.prefix = str6;
            this.isModifiable = z;
            this.isConfirmed = z2;
            this.moderationError = shopSettingsModerationError;
            this.validationError = shopSettingsValidationError;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.Identifiable
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasErrors
        @Nullable
        public ShopSettingsModerationError getModerationError() {
            return this.moderationError;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasPlaceholder
        @Nullable
        public String getPlaceholder() {
            return this.placeholder;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasPrefix
        @Nullable
        public String getPrefix() {
            return this.prefix;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasSuggestion
        @Nullable
        public String getSuggestion() {
            return this.suggestion;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasText
        @Nullable
        public String getText() {
            return this.text;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasTitle
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasErrors
        @Nullable
        public ShopSettingsValidationError getValidationError() {
            return this.validationError;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasConfirmation
        public boolean isConfirmed() {
            return this.isConfirmed;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasModifiable
        public boolean isModifiable() {
            return this.isModifiable;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002Bc\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u00020\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u0019\u0010\u0006R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u000b¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$Phone;", "Lcom/avito/android/remote/model/ShopSettingsElement;", "Lcom/avito/android/remote/model/ShopSettingsElement$Input;", "", "isModifiable", "Z", "()Z", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "suggestion", "getSuggestion", InternalConstsKt.PLACEHOLDER, "getPlaceholder", "prefix", "getPrefix", "id", "getId", "Lcom/avito/android/remote/model/ShopSettingsModerationError;", "moderationError", "Lcom/avito/android/remote/model/ShopSettingsModerationError;", "getModerationError", "()Lcom/avito/android/remote/model/ShopSettingsModerationError;", "isConfirmed", "Lcom/avito/android/remote/model/ShopSettingsValidationError;", "validationError", "Lcom/avito/android/remote/model/ShopSettingsValidationError;", "getValidationError", "()Lcom/avito/android/remote/model/ShopSettingsValidationError;", "text", "getText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/ShopSettingsModerationError;Lcom/avito/android/remote/model/ShopSettingsValidationError;)V", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Phone extends ShopSettingsElement implements Input {
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("isConfirmed")
        private final boolean isConfirmed;
        @SerializedName("isModifiable")
        private final boolean isModifiable;
        @SerializedName("moderationError")
        @Nullable
        private final ShopSettingsModerationError moderationError;
        @SerializedName(InternalConstsKt.PLACEHOLDER)
        @Nullable
        private final String placeholder;
        @SerializedName("prefix")
        @Nullable
        private final String prefix;
        @SerializedName("suggestion")
        @Nullable
        private final String suggestion;
        @SerializedName("text")
        @Nullable
        private final String text;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("validationError")
        @Nullable
        private final ShopSettingsValidationError validationError;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Phone(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, boolean z, boolean z2, @Nullable ShopSettingsModerationError shopSettingsModerationError, @Nullable ShopSettingsValidationError shopSettingsValidationError) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.id = str;
            this.title = str2;
            this.text = str3;
            this.placeholder = str4;
            this.suggestion = str5;
            this.prefix = str6;
            this.isModifiable = z;
            this.isConfirmed = z2;
            this.moderationError = shopSettingsModerationError;
            this.validationError = shopSettingsValidationError;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.Identifiable
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasErrors
        @Nullable
        public ShopSettingsModerationError getModerationError() {
            return this.moderationError;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasPlaceholder
        @Nullable
        public String getPlaceholder() {
            return this.placeholder;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasPrefix
        @Nullable
        public String getPrefix() {
            return this.prefix;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasSuggestion
        @Nullable
        public String getSuggestion() {
            return this.suggestion;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasText
        @Nullable
        public String getText() {
            return this.text;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasTitle
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasErrors
        @Nullable
        public ShopSettingsValidationError getValidationError() {
            return this.validationError;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasConfirmation
        public boolean isConfirmed() {
            return this.isConfirmed;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasModifiable
        public boolean isModifiable() {
            return this.isModifiable;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B{\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010#\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b*\u0010+R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\n8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R$\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u00020\n8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b#\u0010\f\u001a\u0004\b#\u0010\rR\u001c\u0010$\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010\u0007R\u001c\u0010&\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010\u0007R\u001c\u0010(\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010\u0007¨\u0006,"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$Select;", "Lcom/avito/android/remote/model/ShopSettingsElement;", "Lcom/avito/android/remote/model/ShopSettingsElement$Input;", "", InternalConstsKt.PLACEHOLDER, "Ljava/lang/String;", "getPlaceholder", "()Ljava/lang/String;", "prefix", "getPrefix", "", "isConfirmed", "Z", "()Z", "value", "getValue", "", "parentValues", "Ljava/util/List;", "getParentValues", "()Ljava/util/List;", "Lcom/avito/android/remote/model/ShopSettingsModerationError;", "moderationError", "Lcom/avito/android/remote/model/ShopSettingsModerationError;", "getModerationError", "()Lcom/avito/android/remote/model/ShopSettingsModerationError;", "suggestion", "getSuggestion", "text", "getText", "Lcom/avito/android/remote/model/ShopSettingsValidationError;", "validationError", "Lcom/avito/android/remote/model/ShopSettingsValidationError;", "getValidationError", "()Lcom/avito/android/remote/model/ShopSettingsValidationError;", "isModifiable", "id", "getId", "selectContext", "getSelectContext", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/ShopSettingsModerationError;Lcom/avito/android/remote/model/ShopSettingsValidationError;)V", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Select extends ShopSettingsElement implements Input {
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("isConfirmed")
        private final boolean isConfirmed;
        @SerializedName("isModifiable")
        private final boolean isModifiable;
        @SerializedName("moderationError")
        @Nullable
        private final ShopSettingsModerationError moderationError;
        @SerializedName("parentValues")
        @Nullable
        private final List<String> parentValues;
        @SerializedName(InternalConstsKt.PLACEHOLDER)
        @Nullable
        private final String placeholder;
        @Nullable
        private final String prefix;
        @SerializedName("selectContext")
        @NotNull
        private final String selectContext;
        @SerializedName("suggestion")
        @Nullable
        private final String suggestion;
        @SerializedName("text")
        @Nullable
        private final String text;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("validationError")
        @Nullable
        private final ShopSettingsValidationError validationError;
        @SerializedName("value")
        @Nullable
        private final String value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Select(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, boolean z, boolean z2, @NotNull String str6, @Nullable List<String> list, @Nullable String str7, @Nullable ShopSettingsModerationError shopSettingsModerationError, @Nullable ShopSettingsValidationError shopSettingsValidationError) {
            super(null);
            a.Z0(str, "id", str2, "title", str6, "selectContext");
            this.id = str;
            this.title = str2;
            this.text = str3;
            this.placeholder = str4;
            this.suggestion = str5;
            this.isModifiable = z;
            this.isConfirmed = z2;
            this.selectContext = str6;
            this.parentValues = list;
            this.value = str7;
            this.moderationError = shopSettingsModerationError;
            this.validationError = shopSettingsValidationError;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.Identifiable
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasErrors
        @Nullable
        public ShopSettingsModerationError getModerationError() {
            return this.moderationError;
        }

        @Nullable
        public final List<String> getParentValues() {
            return this.parentValues;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasPlaceholder
        @Nullable
        public String getPlaceholder() {
            return this.placeholder;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasPrefix
        @Nullable
        public String getPrefix() {
            return this.prefix;
        }

        @NotNull
        public final String getSelectContext() {
            return this.selectContext;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasSuggestion
        @Nullable
        public String getSuggestion() {
            return this.suggestion;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasText
        @Nullable
        public String getText() {
            return this.text;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasTitle
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasErrors
        @Nullable
        public ShopSettingsValidationError getValidationError() {
            return this.validationError;
        }

        @Nullable
        public final String getValue() {
            return this.value;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasConfirmation
        public boolean isConfirmed() {
            return this.isConfirmed;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasModifiable
        public boolean isModifiable() {
            return this.isModifiable;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002Bc\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u000f\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b!\u0010\"R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u00020\u000f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\u0019\u001a\u00020\u000f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010\u001a\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$SingleLine;", "Lcom/avito/android/remote/model/ShopSettingsElement;", "Lcom/avito/android/remote/model/ShopSettingsElement$Input;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "suggestion", "getSuggestion", "Lcom/avito/android/remote/model/ShopSettingsValidationError;", "validationError", "Lcom/avito/android/remote/model/ShopSettingsValidationError;", "getValidationError", "()Lcom/avito/android/remote/model/ShopSettingsValidationError;", "", "isModifiable", "Z", "()Z", "title", "getTitle", InternalConstsKt.PLACEHOLDER, "getPlaceholder", "prefix", "getPrefix", "isConfirmed", "id", "getId", "Lcom/avito/android/remote/model/ShopSettingsModerationError;", "moderationError", "Lcom/avito/android/remote/model/ShopSettingsModerationError;", "getModerationError", "()Lcom/avito/android/remote/model/ShopSettingsModerationError;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/ShopSettingsModerationError;Lcom/avito/android/remote/model/ShopSettingsValidationError;)V", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class SingleLine extends ShopSettingsElement implements Input {
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("isConfirmed")
        private final boolean isConfirmed;
        @SerializedName("isModifiable")
        private final boolean isModifiable;
        @SerializedName("moderationError")
        @Nullable
        private final ShopSettingsModerationError moderationError;
        @SerializedName(InternalConstsKt.PLACEHOLDER)
        @Nullable
        private final String placeholder;
        @SerializedName("prefix")
        @Nullable
        private final String prefix;
        @SerializedName("suggestion")
        @Nullable
        private final String suggestion;
        @SerializedName("text")
        @Nullable
        private final String text;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("validationError")
        @Nullable
        private final ShopSettingsValidationError validationError;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SingleLine(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, boolean z, boolean z2, @Nullable ShopSettingsModerationError shopSettingsModerationError, @Nullable ShopSettingsValidationError shopSettingsValidationError) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.id = str;
            this.title = str2;
            this.text = str3;
            this.placeholder = str4;
            this.suggestion = str5;
            this.prefix = str6;
            this.isModifiable = z;
            this.isConfirmed = z2;
            this.moderationError = shopSettingsModerationError;
            this.validationError = shopSettingsValidationError;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.Identifiable
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasErrors
        @Nullable
        public ShopSettingsModerationError getModerationError() {
            return this.moderationError;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasPlaceholder
        @Nullable
        public String getPlaceholder() {
            return this.placeholder;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasPrefix
        @Nullable
        public String getPrefix() {
            return this.prefix;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasSuggestion
        @Nullable
        public String getSuggestion() {
            return this.suggestion;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasText
        @Nullable
        public String getText() {
            return this.text;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasTitle
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasErrors
        @Nullable
        public ShopSettingsValidationError getValidationError() {
            return this.validationError;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasConfirmation
        public boolean isConfirmed() {
            return this.isConfirmed;
        }

        @Override // com.avito.android.remote.model.ShopSettingsElement.HasModifiable
        public boolean isModifiable() {
            return this.isModifiable;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$Switcher;", "Lcom/avito/android/remote/model/ShopSettingsElement;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "id", "getId", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "", "isModifiable", "Z", "()Z", "isEnabled", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Switcher extends ShopSettingsElement {
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("isEnabled")
        private final boolean isEnabled;
        @SerializedName("isModifiable")
        private final boolean isModifiable;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final String subtitle;
        @SerializedName("title")
        @NotNull
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Switcher(@NotNull String str, @NotNull String str2, @Nullable String str3, boolean z, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.id = str;
            this.title = str2;
            this.subtitle = str3;
            this.isEnabled = z;
            this.isModifiable = z2;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getSubtitle() {
            return this.subtitle;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        public final boolean isModifiable() {
            return this.isModifiable;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$TitleSubtitle;", "Lcom/avito/android/remote/model/ShopSettingsElement;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class TitleSubtitle extends ShopSettingsElement {
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final String subtitle;
        @SerializedName("title")
        @NotNull
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TitleSubtitle(@NotNull String str, @Nullable String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.subtitle = str2;
        }

        @Nullable
        public final String getSubtitle() {
            return this.subtitle;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsElement$Unknown;", "Lcom/avito/android/remote/model/ShopSettingsElement;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "<init>", "()V", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Unknown extends ShopSettingsElement {
        public Unknown() {
            super(null);
        }

        public boolean equals(@Nullable Object obj) {
            return obj instanceof Unknown;
        }
    }

    private ShopSettingsElement() {
    }

    public /* synthetic */ ShopSettingsElement(j jVar) {
        this();
    }
}
