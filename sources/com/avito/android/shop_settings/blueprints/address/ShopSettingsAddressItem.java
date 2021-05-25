package com.avito.android.shop_settings.blueprints.address;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem;
import com.avito.android.util.preferences.GeoContract;
import com.jakewharton.rxrelay2.BehaviorRelay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000e\u0012\u0006\u0010 \u001a\u00020\u000e\u0012\u0006\u0010!\u001a\u00020\u000e\u0012\b\b\u0002\u0010\"\u001a\u00020\u0013¢\u0006\u0004\b^\u0010_Ba\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010`\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010 \u001a\u00020\u000e\u0012\u0006\u0010!\u001a\u00020\u000e¢\u0006\u0004\b^\u0010aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0001\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001d\u001a\u00020\n2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u0013HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010\u0004J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010)HÖ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020&HÖ\u0001¢\u0006\u0004\b-\u0010(J \u00102\u001a\u0002012\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020&HÖ\u0001¢\u0006\u0004\b2\u00103R$\u00108\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u00028V@VX\u000e¢\u0006\f\u001a\u0004\b5\u0010\u0004\"\u0004\b6\u00107R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u0004R\u001c\u0010!\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\u0010R\u001c\u0010\u001d\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010\fR\u001c\u0010\"\u001a\u00020\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010\u0015R\u001c\u0010\u0017\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bE\u0010:\u001a\u0004\bF\u0010\u0004R\u001c\u0010\u0019\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bG\u0010:\u001a\u0004\bH\u0010\u0004R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bI\u0010:\u001a\u0004\bJ\u0010\u0004R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bK\u0010:\u001a\u0004\bL\u0010\u0004\"\u0004\bM\u00107R\u001c\u0010\u001f\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bN\u0010=\u001a\u0004\b\u001f\u0010\u0010R\u001c\u0010 \u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bO\u0010=\u001a\u0004\b \u0010\u0010R\u001c\u0010\u0016\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bP\u0010:\u001a\u0004\bQ\u0010\u0004R(\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u000e0R8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\bS\u0010T\u0012\u0004\bW\u0010X\u001a\u0004\bU\u0010VR$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bZ\u0010:\u001a\u0004\b[\u0010\u0004\"\u0004\b\\\u00107R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010:¨\u0006b"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/address/ShopSettingsAddressItem;", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem;", "", "component1", "()Ljava/lang/String;", "component2", "component4", "component5", "component6", "component7", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;", "component8", "()Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;", "component9", "", "component10", "()Z", "component11", "component12", "Lcom/avito/android/lib/design/input/FormatterType;", "component13", "()Lcom/avito/android/lib/design/input/FormatterType;", "stringId", "title", "parcelledText", "originalText", GeoContract.LATITUDE, GeoContract.LONGITUDE, "suggestion", "state", InternalConstsKt.PLACEHOLDER, "isConfirmed", "isModifiable", "shouldScrollTo", "formatterType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;Ljava/lang/String;ZZZLcom/avito/android/lib/design/input/FormatterType;)Lcom/avito/android/shop_settings/blueprints/address/ShopSettingsAddressItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "value", "getCurrentText", "setCurrentText", "(Ljava/lang/String;)V", "currentText", "h", "Ljava/lang/String;", "getSuggestion", AuthSource.OPEN_CHANNEL_LIST, "Z", "getShouldScrollTo", "i", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;", "getState", "n", "Lcom/avito/android/lib/design/input/FormatterType;", "getFormatterType", "c", "getTitle", "e", "getOriginalText", "j", "getPlaceholder", g.a, "getLongitude", "setLongitude", "k", "l", AuthSource.BOOKING_ORDER, "getStringId", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getDidChange", "()Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getDidChange$annotations", "()V", "didChange", "f", "getLatitude", "setLatitude", "d", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;Ljava/lang/String;ZZZLcom/avito/android/lib/design/input/FormatterType;)V", "text", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;Ljava/lang/String;ZZ)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsAddressItem implements ShopSettingsInputItem {
    public static final Parcelable.Creator<ShopSettingsAddressItem> CREATOR = new Creator();
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
    public String f;
    @Nullable
    public String g;
    @Nullable
    public final String h;
    @NotNull
    public final ShopSettingsInputItem.State i;
    @Nullable
    public final String j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    @NotNull
    public final FormatterType n;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ShopSettingsAddressItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsAddressItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ShopSettingsAddressItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (ShopSettingsInputItem.State) Enum.valueOf(ShopSettingsInputItem.State.class, parcel.readString()), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, (FormatterType) parcel.readParcelable(ShopSettingsAddressItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsAddressItem[] newArray(int i) {
            return new ShopSettingsAddressItem[i];
        }
    }

    public ShopSettingsAddressItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @NotNull ShopSettingsInputItem.State state, @Nullable String str8, boolean z, boolean z2, boolean z3, @NotNull FormatterType formatterType) {
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
        this.g = str6;
        this.h = str7;
        this.i = state;
        this.j = str8;
        this.k = z;
        this.l = z2;
        this.m = z3;
        this.n = formatterType;
        BehaviorRelay<Boolean> createDefault = BehaviorRelay.createDefault(Boolean.valueOf(!Intrinsics.areEqual(getOriginalText(), this.d)));
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefa…nalText != parcelledText)");
        this.a = createDefault;
    }

    public static /* synthetic */ ShopSettingsAddressItem copy$default(ShopSettingsAddressItem shopSettingsAddressItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, ShopSettingsInputItem.State state, String str8, boolean z, boolean z2, boolean z3, FormatterType formatterType, int i2, Object obj) {
        return shopSettingsAddressItem.copy((i2 & 1) != 0 ? shopSettingsAddressItem.getStringId() : str, (i2 & 2) != 0 ? shopSettingsAddressItem.getTitle() : str2, (i2 & 4) != 0 ? shopSettingsAddressItem.d : str3, (i2 & 8) != 0 ? shopSettingsAddressItem.getOriginalText() : str4, (i2 & 16) != 0 ? shopSettingsAddressItem.f : str5, (i2 & 32) != 0 ? shopSettingsAddressItem.g : str6, (i2 & 64) != 0 ? shopSettingsAddressItem.getSuggestion() : str7, (i2 & 128) != 0 ? shopSettingsAddressItem.getState() : state, (i2 & 256) != 0 ? shopSettingsAddressItem.getPlaceholder() : str8, (i2 & 512) != 0 ? shopSettingsAddressItem.isConfirmed() : z, (i2 & 1024) != 0 ? shopSettingsAddressItem.isModifiable() : z2, (i2 & 2048) != 0 ? shopSettingsAddressItem.getShouldScrollTo() : z3, (i2 & 4096) != 0 ? shopSettingsAddressItem.getFormatterType() : formatterType);
    }

    public static /* synthetic */ void getDidChange$annotations() {
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    public final boolean component10() {
        return isConfirmed();
    }

    public final boolean component11() {
        return isModifiable();
    }

    public final boolean component12() {
        return getShouldScrollTo();
    }

    @NotNull
    public final FormatterType component13() {
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
        return this.f;
    }

    @Nullable
    public final String component6() {
        return this.g;
    }

    @Nullable
    public final String component7() {
        return getSuggestion();
    }

    @NotNull
    public final ShopSettingsInputItem.State component8() {
        return getState();
    }

    @Nullable
    public final String component9() {
        return getPlaceholder();
    }

    @NotNull
    public final ShopSettingsAddressItem copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @NotNull ShopSettingsInputItem.State state, @Nullable String str8, boolean z, boolean z2, boolean z3, @NotNull FormatterType formatterType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "parcelledText");
        Intrinsics.checkNotNullParameter(str4, "originalText");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(formatterType, "formatterType");
        return new ShopSettingsAddressItem(str, str2, str3, str4, str5, str6, str7, state, str8, z, z2, z3, formatterType);
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
        if (!(obj instanceof ShopSettingsAddressItem)) {
            return false;
        }
        ShopSettingsAddressItem shopSettingsAddressItem = (ShopSettingsAddressItem) obj;
        return Intrinsics.areEqual(getStringId(), shopSettingsAddressItem.getStringId()) && Intrinsics.areEqual(getTitle(), shopSettingsAddressItem.getTitle()) && Intrinsics.areEqual(this.d, shopSettingsAddressItem.d) && Intrinsics.areEqual(getOriginalText(), shopSettingsAddressItem.getOriginalText()) && Intrinsics.areEqual(this.f, shopSettingsAddressItem.f) && Intrinsics.areEqual(this.g, shopSettingsAddressItem.g) && Intrinsics.areEqual(getSuggestion(), shopSettingsAddressItem.getSuggestion()) && Intrinsics.areEqual(getState(), shopSettingsAddressItem.getState()) && Intrinsics.areEqual(getPlaceholder(), shopSettingsAddressItem.getPlaceholder()) && isConfirmed() == shopSettingsAddressItem.isConfirmed() && isModifiable() == shopSettingsAddressItem.isModifiable() && getShouldScrollTo() == shopSettingsAddressItem.getShouldScrollTo() && Intrinsics.areEqual(getFormatterType(), shopSettingsAddressItem.getFormatterType());
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
        return this.n;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return ShopSettingsInputItem.DefaultImpls.getId(this);
    }

    @Nullable
    public final String getLatitude() {
        return this.f;
    }

    @Nullable
    public final String getLongitude() {
        return this.g;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    @NotNull
    public String getOriginalText() {
        return this.e;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    @Nullable
    public String getPlaceholder() {
        return this.j;
    }

    @Override // com.avito.android.shop_settings.blueprints.ShopSettingsItem
    public boolean getShouldScrollTo() {
        return this.m;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    @NotNull
    public ShopSettingsInputItem.State getState() {
        return this.i;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    @Nullable
    public String getSuggestion() {
        return this.h;
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
        String str2 = this.f;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.g;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String suggestion = getSuggestion();
        int hashCode7 = (hashCode6 + (suggestion != null ? suggestion.hashCode() : 0)) * 31;
        ShopSettingsInputItem.State state = getState();
        int hashCode8 = (hashCode7 + (state != null ? state.hashCode() : 0)) * 31;
        String placeholder = getPlaceholder();
        int hashCode9 = (hashCode8 + (placeholder != null ? placeholder.hashCode() : 0)) * 31;
        boolean isConfirmed = isConfirmed();
        int i3 = 1;
        if (isConfirmed) {
            isConfirmed = true;
        }
        int i4 = isConfirmed ? 1 : 0;
        int i5 = isConfirmed ? 1 : 0;
        int i6 = isConfirmed ? 1 : 0;
        int i7 = (hashCode9 + i4) * 31;
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
        return this.k;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    public boolean isModifiable() {
        return this.l;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    public void setCurrentText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.d = str;
        getDidChange().accept(Boolean.valueOf(!Intrinsics.areEqual(getOriginalText(), this.d)));
    }

    public final void setLatitude(@Nullable String str) {
        this.f = str;
    }

    public final void setLongitude(@Nullable String str) {
        this.g = str;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ShopSettingsAddressItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", parcelledText=");
        L.append(this.d);
        L.append(", originalText=");
        L.append(getOriginalText());
        L.append(", latitude=");
        L.append(this.f);
        L.append(", longitude=");
        L.append(this.g);
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
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i.name());
        parcel.writeString(this.j);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeParcelable(this.n, i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopSettingsAddressItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, ShopSettingsInputItem.State state, String str8, boolean z, boolean z2, boolean z3, FormatterType formatterType, int i2, j jVar) {
        this(str, str2, str3, str4, str5, str6, str7, state, str8, (i2 & 512) != 0 ? false : z, z2, z3, (i2 & 4096) != 0 ? FormatterType.Companion.getSIMPLE() : formatterType);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShopSettingsAddressItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @NotNull ShopSettingsInputItem.State state, @Nullable String str7, boolean z, boolean z2) {
        this(str, str2, str3, str3, str4, str5, str6, state, str7, false, z, z2, null, 4608, null);
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "text");
        Intrinsics.checkNotNullParameter(state, "state");
    }
}
