package com.avito.android.shop_settings.blueprints.input.single_line_input;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem;
import com.jakewharton.rxrelay2.BehaviorRelay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\u0006\u0010\u001c\u001a\u00020\f\u0012\u0006\u0010\u001d\u001a\u00020\f\u0012\u0006\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\bT\u0010UB]\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010V\u001a\u00020\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\u0006\u0010\u001c\u001a\u00020\f\u0012\u0006\u0010\u001d\u001a\u00020\f\u0012\u0006\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\bT\u0010WJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0001\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0019\u001a\u00020\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\u0004J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b)\u0010$J \u0010.\u001a\u00020-2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b.\u0010/R\u001c\u0010\u0017\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0004R$\u00107\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00028V@VX\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0004\"\u0004\b5\u00106R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00101R\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b9\u00101\u001a\u0004\b:\u0010\u0004R\u001c\u0010\u0019\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\nR\u001c\u0010\u001b\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b\u001b\u0010\u000eR\u001c\u0010\u001c\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b@\u0010?\u001a\u0004\b\u001c\u0010\u000eR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bA\u00101\u001a\u0004\bB\u0010\u0004R(\u0010J\u001a\b\u0012\u0004\u0012\u00020\f0C8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\bD\u0010E\u0012\u0004\bH\u0010I\u001a\u0004\bF\u0010GR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bK\u00101\u001a\u0004\bL\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bM\u00101\u001a\u0004\bN\u0010\u0004R\u001c\u0010\u001d\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bO\u0010?\u001a\u0004\bP\u0010\u000eR\u001c\u0010\u001e\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010\u0013¨\u0006X"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/input/single_line_input/ShopSettingsSingleLineInputItem;", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem;", "", "component1", "()Ljava/lang/String;", "component2", "component4", "component5", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;", "component6", "()Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;", "component7", "", "component8", "()Z", "component9", "component10", "Lcom/avito/android/lib/design/input/FormatterType;", "component11", "()Lcom/avito/android/lib/design/input/FormatterType;", "stringId", "title", "parcelledText", "originalText", "suggestion", "state", InternalConstsKt.PLACEHOLDER, "isConfirmed", "isModifiable", "shouldScrollTo", "formatterType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;Ljava/lang/String;ZZZLcom/avito/android/lib/design/input/FormatterType;)Lcom/avito/android/shop_settings/blueprints/input/single_line_input/ShopSettingsSingleLineInputItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "e", "Ljava/lang/String;", "getOriginalText", "value", "getCurrentText", "setCurrentText", "(Ljava/lang/String;)V", "currentText", "d", AuthSource.BOOKING_ORDER, "getStringId", g.a, "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;", "getState", "i", "Z", "j", "f", "getSuggestion", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getDidChange", "()Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getDidChange$annotations", "()V", "didChange", "h", "getPlaceholder", "c", "getTitle", "k", "getShouldScrollTo", "l", "Lcom/avito/android/lib/design/input/FormatterType;", "getFormatterType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;Ljava/lang/String;ZZZLcom/avito/android/lib/design/input/FormatterType;)V", "text", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;Ljava/lang/String;ZZZLcom/avito/android/lib/design/input/FormatterType;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSingleLineInputItem implements ShopSettingsInputItem {
    public static final Parcelable.Creator<ShopSettingsSingleLineInputItem> CREATOR = new Creator();
    @NotNull
    public final BehaviorRelay<Boolean> a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    public String d;
    @NotNull
    public final String e;
    @Nullable
    public final String f;
    @NotNull
    public final ShopSettingsInputItem.State g;
    @Nullable
    public final String h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    @NotNull
    public final FormatterType l;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ShopSettingsSingleLineInputItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsSingleLineInputItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ShopSettingsSingleLineInputItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (ShopSettingsInputItem.State) Enum.valueOf(ShopSettingsInputItem.State.class, parcel.readString()), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, (FormatterType) parcel.readParcelable(ShopSettingsSingleLineInputItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsSingleLineInputItem[] newArray(int i) {
            return new ShopSettingsSingleLineInputItem[i];
        }
    }

    public ShopSettingsSingleLineInputItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @NotNull ShopSettingsInputItem.State state, @Nullable String str6, boolean z, boolean z2, boolean z3, @NotNull FormatterType formatterType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "parcelledText");
        Intrinsics.checkNotNullParameter(str4, "originalText");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(formatterType, "formatterType");
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = state;
        this.h = str6;
        this.i = z;
        this.j = z2;
        this.k = z3;
        this.l = formatterType;
        BehaviorRelay<Boolean> createDefault = BehaviorRelay.createDefault(Boolean.valueOf(!Intrinsics.areEqual(getOriginalText(), this.d)));
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefa…nalText != parcelledText)");
        this.a = createDefault;
    }

    public static /* synthetic */ ShopSettingsSingleLineInputItem copy$default(ShopSettingsSingleLineInputItem shopSettingsSingleLineInputItem, String str, String str2, String str3, String str4, String str5, ShopSettingsInputItem.State state, String str6, boolean z, boolean z2, boolean z3, FormatterType formatterType, int i2, Object obj) {
        return shopSettingsSingleLineInputItem.copy((i2 & 1) != 0 ? shopSettingsSingleLineInputItem.getStringId() : str, (i2 & 2) != 0 ? shopSettingsSingleLineInputItem.getTitle() : str2, (i2 & 4) != 0 ? shopSettingsSingleLineInputItem.d : str3, (i2 & 8) != 0 ? shopSettingsSingleLineInputItem.getOriginalText() : str4, (i2 & 16) != 0 ? shopSettingsSingleLineInputItem.getSuggestion() : str5, (i2 & 32) != 0 ? shopSettingsSingleLineInputItem.getState() : state, (i2 & 64) != 0 ? shopSettingsSingleLineInputItem.getPlaceholder() : str6, (i2 & 128) != 0 ? shopSettingsSingleLineInputItem.isConfirmed() : z, (i2 & 256) != 0 ? shopSettingsSingleLineInputItem.isModifiable() : z2, (i2 & 512) != 0 ? shopSettingsSingleLineInputItem.getShouldScrollTo() : z3, (i2 & 1024) != 0 ? shopSettingsSingleLineInputItem.getFormatterType() : formatterType);
    }

    public static /* synthetic */ void getDidChange$annotations() {
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    public final boolean component10() {
        return getShouldScrollTo();
    }

    @NotNull
    public final FormatterType component11() {
        return getFormatterType();
    }

    @NotNull
    public final String component2() {
        return getTitle();
    }

    @NotNull
    public final String component4() {
        return getOriginalText();
    }

    @Nullable
    public final String component5() {
        return getSuggestion();
    }

    @NotNull
    public final ShopSettingsInputItem.State component6() {
        return getState();
    }

    @Nullable
    public final String component7() {
        return getPlaceholder();
    }

    public final boolean component8() {
        return isConfirmed();
    }

    public final boolean component9() {
        return isModifiable();
    }

    @NotNull
    public final ShopSettingsSingleLineInputItem copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @NotNull ShopSettingsInputItem.State state, @Nullable String str6, boolean z, boolean z2, boolean z3, @NotNull FormatterType formatterType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "parcelledText");
        Intrinsics.checkNotNullParameter(str4, "originalText");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(formatterType, "formatterType");
        return new ShopSettingsSingleLineInputItem(str, str2, str3, str4, str5, state, str6, z, z2, z3, formatterType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopSettingsSingleLineInputItem)) {
            return false;
        }
        ShopSettingsSingleLineInputItem shopSettingsSingleLineInputItem = (ShopSettingsSingleLineInputItem) obj;
        return Intrinsics.areEqual(getStringId(), shopSettingsSingleLineInputItem.getStringId()) && Intrinsics.areEqual(getTitle(), shopSettingsSingleLineInputItem.getTitle()) && Intrinsics.areEqual(this.d, shopSettingsSingleLineInputItem.d) && Intrinsics.areEqual(getOriginalText(), shopSettingsSingleLineInputItem.getOriginalText()) && Intrinsics.areEqual(getSuggestion(), shopSettingsSingleLineInputItem.getSuggestion()) && Intrinsics.areEqual(getState(), shopSettingsSingleLineInputItem.getState()) && Intrinsics.areEqual(getPlaceholder(), shopSettingsSingleLineInputItem.getPlaceholder()) && isConfirmed() == shopSettingsSingleLineInputItem.isConfirmed() && isModifiable() == shopSettingsSingleLineInputItem.isModifiable() && getShouldScrollTo() == shopSettingsSingleLineInputItem.getShouldScrollTo() && Intrinsics.areEqual(getFormatterType(), shopSettingsSingleLineInputItem.getFormatterType());
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    @NotNull
    public String getCurrentText() {
        return this.d;
    }

    @Override // com.avito.android.shop_settings.blueprints.ShopSettingsItem
    @NotNull
    public BehaviorRelay<Boolean> getDidChange() {
        return this.a;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    @NotNull
    public FormatterType getFormatterType() {
        return this.l;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return ShopSettingsInputItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    @NotNull
    public String getOriginalText() {
        return this.e;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    @Nullable
    public String getPlaceholder() {
        return this.h;
    }

    @Override // com.avito.android.shop_settings.blueprints.ShopSettingsItem
    public boolean getShouldScrollTo() {
        return this.k;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    @NotNull
    public ShopSettingsInputItem.State getState() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    @Nullable
    public String getSuggestion() {
        return this.f;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    @NotNull
    public String getTitle() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String stringId = getStringId();
        int i2 = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        String title = getTitle();
        int hashCode2 = (hashCode + (title != null ? title.hashCode() : 0)) * 31;
        String str = this.d;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String originalText = getOriginalText();
        int hashCode4 = (hashCode3 + (originalText != null ? originalText.hashCode() : 0)) * 31;
        String suggestion = getSuggestion();
        int hashCode5 = (hashCode4 + (suggestion != null ? suggestion.hashCode() : 0)) * 31;
        ShopSettingsInputItem.State state = getState();
        int hashCode6 = (hashCode5 + (state != null ? state.hashCode() : 0)) * 31;
        String placeholder = getPlaceholder();
        int hashCode7 = (hashCode6 + (placeholder != null ? placeholder.hashCode() : 0)) * 31;
        boolean isConfirmed = isConfirmed();
        int i3 = 1;
        if (isConfirmed) {
            isConfirmed = true;
        }
        int i4 = isConfirmed ? 1 : 0;
        int i5 = isConfirmed ? 1 : 0;
        int i6 = isConfirmed ? 1 : 0;
        int i7 = (hashCode7 + i4) * 31;
        boolean isModifiable = isModifiable();
        if (isModifiable) {
            isModifiable = true;
        }
        int i8 = isModifiable ? 1 : 0;
        int i9 = isModifiable ? 1 : 0;
        int i10 = isModifiable ? 1 : 0;
        int i11 = (i7 + i8) * 31;
        boolean shouldScrollTo = getShouldScrollTo();
        if (!shouldScrollTo) {
            i3 = shouldScrollTo;
        }
        int i12 = (i11 + i3) * 31;
        FormatterType formatterType = getFormatterType();
        if (formatterType != null) {
            i2 = formatterType.hashCode();
        }
        return i12 + i2;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    public boolean isConfirmed() {
        return this.i;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    public boolean isModifiable() {
        return this.j;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    public void setCurrentText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.d = str;
        getDidChange().accept(Boolean.valueOf(!Intrinsics.areEqual(getOriginalText(), this.d)));
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ShopSettingsSingleLineInputItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", parcelledText=");
        L.append(this.d);
        L.append(", originalText=");
        L.append(getOriginalText());
        L.append(", suggestion=");
        L.append(getSuggestion());
        L.append(", state=");
        L.append(getState());
        L.append(", placeholder=");
        L.append(getPlaceholder());
        L.append(", isConfirmed=");
        L.append(isConfirmed());
        L.append(", isModifiable=");
        L.append(isModifiable());
        L.append(", shouldScrollTo=");
        L.append(getShouldScrollTo());
        L.append(", formatterType=");
        L.append(getFormatterType());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g.name());
        parcel.writeString(this.h);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeParcelable(this.l, i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShopSettingsSingleLineInputItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull ShopSettingsInputItem.State state, @Nullable String str5, boolean z, boolean z2, boolean z3, @NotNull FormatterType formatterType) {
        this(str, str2, str3, str3, str4, state, str5, z, z2, z3, formatterType);
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "text");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(formatterType, "formatterType");
    }
}
