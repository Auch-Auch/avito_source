package com.avito.android.shop_settings.blueprints.select;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem;
import com.jakewharton.rxrelay2.BehaviorRelay;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010!\u001a\u00020\r\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0011\u0012\u0006\u0010$\u001a\u00020\u0011\u0012\u0006\u0010%\u001a\u00020\u0011\u0012\b\b\u0002\u0010&\u001a\u00020\u0016¢\u0006\u0004\bf\u0010gBm\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010h\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010!\u001a\u00020\r\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010$\u001a\u00020\u0011\u0012\u0006\u0010i\u001a\u00020\u0011¢\u0006\u0004\bf\u0010jJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0013J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J¨\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010!\u001a\u00020\r2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010#\u001a\u00020\u00112\b\b\u0002\u0010$\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010&\u001a\u00020\u0016HÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b)\u0010\u0004J\u0010\u0010+\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010/\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010-HÖ\u0003¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020*HÖ\u0001¢\u0006\u0004\b1\u0010,J \u00106\u001a\u0002052\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020*HÖ\u0001¢\u0006\u0004\b6\u00107R\u001c\u0010#\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b#\u0010\u0013R\u001e\u0010\"\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\u0004R$\u0010@\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00028V@VX\u000e¢\u0006\f\u001a\u0004\b=\u0010\u0004\"\u0004\b>\u0010?R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010;R\u001c\u0010\u0019\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bB\u0010;\u001a\u0004\bC\u0010\u0004R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bD\u0010;\u001a\u0004\bE\u0010\u0004\"\u0004\bF\u0010?R\u001c\u0010%\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bG\u00109\u001a\u0004\bH\u0010\u0013R\u001c\u0010\u001a\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bI\u0010;\u001a\u0004\bJ\u0010\u0004R(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010\u000b\"\u0004\bN\u0010OR\u001c\u0010&\u001a\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010\u0018R\u001c\u0010\u001c\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bS\u0010;\u001a\u0004\bT\u0010\u0004R\u001e\u0010 \u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bU\u0010;\u001a\u0004\bV\u0010\u0004R(\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00110W8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\bX\u0010Y\u0012\u0004\b\\\u0010]\u001a\u0004\bZ\u0010[R\u001c\u0010!\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010\u000fR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bb\u0010;\u001a\u0004\bc\u0010\u0004\"\u0004\bd\u0010?R\u001c\u0010$\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\be\u00109\u001a\u0004\b$\u0010\u0013¨\u0006k"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/select/ShopSettingsSelectItem;", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem;", "", "component1", "()Ljava/lang/String;", "component2", "component4", "component5", "component6", "", "component7", "()Ljava/util/List;", "component8", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;", "component9", "()Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;", "component10", "", "component11", "()Z", "component12", "component13", "Lcom/avito/android/lib/design/input/FormatterType;", "component14", "()Lcom/avito/android/lib/design/input/FormatterType;", "stringId", "title", "parcelledText", "originalText", "selectContext", "value", "parentValues", "suggestion", "state", InternalConstsKt.PLACEHOLDER, "isConfirmed", "isModifiable", "shouldScrollTo", "formatterType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;Ljava/lang/String;ZZZLcom/avito/android/lib/design/input/FormatterType;)Lcom/avito/android/shop_settings/blueprints/select/ShopSettingsSelectItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "l", "Z", "k", "Ljava/lang/String;", "getPlaceholder", "getCurrentText", "setCurrentText", "(Ljava/lang/String;)V", "currentText", "d", AuthSource.BOOKING_ORDER, "getStringId", g.a, "getValue", "setValue", "n", "getShouldScrollTo", "c", "getTitle", "h", "Ljava/util/List;", "getParentValues", "setParentValues", "(Ljava/util/List;)V", "o", "Lcom/avito/android/lib/design/input/FormatterType;", "getFormatterType", "e", "getOriginalText", "i", "getSuggestion", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getDidChange", "()Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getDidChange$annotations", "()V", "didChange", "j", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;", "getState", "f", "getSelectContext", "setSelectContext", AuthSource.OPEN_CHANNEL_LIST, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;Ljava/lang/String;ZZZLcom/avito/android/lib/design/input/FormatterType;)V", "text", "displaysError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;Ljava/lang/String;ZZ)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSelectItem implements ShopSettingsInputItem {
    public static final Parcelable.Creator<ShopSettingsSelectItem> CREATOR = new Creator();
    @NotNull
    public final BehaviorRelay<Boolean> a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    public String d;
    @NotNull
    public final String e;
    @NotNull
    public String f;
    @Nullable
    public String g;
    @NotNull
    public List<String> h;
    @Nullable
    public final String i;
    @NotNull
    public final ShopSettingsInputItem.State j;
    @Nullable
    public final String k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    @NotNull
    public final FormatterType o;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ShopSettingsSelectItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsSelectItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ShopSettingsSelectItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), (ShopSettingsInputItem.State) Enum.valueOf(ShopSettingsInputItem.State.class, parcel.readString()), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, (FormatterType) parcel.readParcelable(ShopSettingsSelectItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsSelectItem[] newArray(int i) {
            return new ShopSettingsSelectItem[i];
        }
    }

    public ShopSettingsSelectItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable String str6, @NotNull List<String> list, @Nullable String str7, @NotNull ShopSettingsInputItem.State state, @Nullable String str8, boolean z, boolean z2, boolean z3, @NotNull FormatterType formatterType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "parcelledText");
        Intrinsics.checkNotNullParameter(str4, "originalText");
        Intrinsics.checkNotNullParameter(str5, "selectContext");
        Intrinsics.checkNotNullParameter(list, "parentValues");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(formatterType, "formatterType");
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = list;
        this.i = str7;
        this.j = state;
        this.k = str8;
        this.l = z;
        this.m = z2;
        this.n = z3;
        this.o = formatterType;
        BehaviorRelay<Boolean> createDefault = BehaviorRelay.createDefault(Boolean.valueOf(!Intrinsics.areEqual(getOriginalText(), this.d)));
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefa…nalText != parcelledText)");
        this.a = createDefault;
    }

    public static /* synthetic */ ShopSettingsSelectItem copy$default(ShopSettingsSelectItem shopSettingsSelectItem, String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, ShopSettingsInputItem.State state, String str8, boolean z, boolean z2, boolean z3, FormatterType formatterType, int i2, Object obj) {
        return shopSettingsSelectItem.copy((i2 & 1) != 0 ? shopSettingsSelectItem.getStringId() : str, (i2 & 2) != 0 ? shopSettingsSelectItem.getTitle() : str2, (i2 & 4) != 0 ? shopSettingsSelectItem.d : str3, (i2 & 8) != 0 ? shopSettingsSelectItem.getOriginalText() : str4, (i2 & 16) != 0 ? shopSettingsSelectItem.f : str5, (i2 & 32) != 0 ? shopSettingsSelectItem.g : str6, (i2 & 64) != 0 ? shopSettingsSelectItem.h : list, (i2 & 128) != 0 ? shopSettingsSelectItem.getSuggestion() : str7, (i2 & 256) != 0 ? shopSettingsSelectItem.getState() : state, (i2 & 512) != 0 ? shopSettingsSelectItem.getPlaceholder() : str8, (i2 & 1024) != 0 ? shopSettingsSelectItem.isConfirmed() : z, (i2 & 2048) != 0 ? shopSettingsSelectItem.isModifiable() : z2, (i2 & 4096) != 0 ? shopSettingsSelectItem.getShouldScrollTo() : z3, (i2 & 8192) != 0 ? shopSettingsSelectItem.getFormatterType() : formatterType);
    }

    public static /* synthetic */ void getDidChange$annotations() {
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @Nullable
    public final String component10() {
        return getPlaceholder();
    }

    public final boolean component11() {
        return isConfirmed();
    }

    public final boolean component12() {
        return isModifiable();
    }

    public final boolean component13() {
        return getShouldScrollTo();
    }

    @NotNull
    public final FormatterType component14() {
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

    @NotNull
    public final String component5() {
        return this.f;
    }

    @Nullable
    public final String component6() {
        return this.g;
    }

    @NotNull
    public final List<String> component7() {
        return this.h;
    }

    @Nullable
    public final String component8() {
        return getSuggestion();
    }

    @NotNull
    public final ShopSettingsInputItem.State component9() {
        return getState();
    }

    @NotNull
    public final ShopSettingsSelectItem copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable String str6, @NotNull List<String> list, @Nullable String str7, @NotNull ShopSettingsInputItem.State state, @Nullable String str8, boolean z, boolean z2, boolean z3, @NotNull FormatterType formatterType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "parcelledText");
        Intrinsics.checkNotNullParameter(str4, "originalText");
        Intrinsics.checkNotNullParameter(str5, "selectContext");
        Intrinsics.checkNotNullParameter(list, "parentValues");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(formatterType, "formatterType");
        return new ShopSettingsSelectItem(str, str2, str3, str4, str5, str6, list, str7, state, str8, z, z2, z3, formatterType);
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
        if (!(obj instanceof ShopSettingsSelectItem)) {
            return false;
        }
        ShopSettingsSelectItem shopSettingsSelectItem = (ShopSettingsSelectItem) obj;
        return Intrinsics.areEqual(getStringId(), shopSettingsSelectItem.getStringId()) && Intrinsics.areEqual(getTitle(), shopSettingsSelectItem.getTitle()) && Intrinsics.areEqual(this.d, shopSettingsSelectItem.d) && Intrinsics.areEqual(getOriginalText(), shopSettingsSelectItem.getOriginalText()) && Intrinsics.areEqual(this.f, shopSettingsSelectItem.f) && Intrinsics.areEqual(this.g, shopSettingsSelectItem.g) && Intrinsics.areEqual(this.h, shopSettingsSelectItem.h) && Intrinsics.areEqual(getSuggestion(), shopSettingsSelectItem.getSuggestion()) && Intrinsics.areEqual(getState(), shopSettingsSelectItem.getState()) && Intrinsics.areEqual(getPlaceholder(), shopSettingsSelectItem.getPlaceholder()) && isConfirmed() == shopSettingsSelectItem.isConfirmed() && isModifiable() == shopSettingsSelectItem.isModifiable() && getShouldScrollTo() == shopSettingsSelectItem.getShouldScrollTo() && Intrinsics.areEqual(getFormatterType(), shopSettingsSelectItem.getFormatterType());
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
        return this.o;
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

    @NotNull
    public final List<String> getParentValues() {
        return this.h;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    @Nullable
    public String getPlaceholder() {
        return this.k;
    }

    @NotNull
    public final String getSelectContext() {
        return this.f;
    }

    @Override // com.avito.android.shop_settings.blueprints.ShopSettingsItem
    public boolean getShouldScrollTo() {
        return this.n;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    @NotNull
    public ShopSettingsInputItem.State getState() {
        return this.j;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    @Nullable
    public String getSuggestion() {
        return this.i;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    @NotNull
    public String getTitle() {
        return this.c;
    }

    @Nullable
    public final String getValue() {
        return this.g;
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
        List<String> list = this.h;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 0)) * 31;
        String suggestion = getSuggestion();
        int hashCode8 = (hashCode7 + (suggestion != null ? suggestion.hashCode() : 0)) * 31;
        ShopSettingsInputItem.State state = getState();
        int hashCode9 = (hashCode8 + (state != null ? state.hashCode() : 0)) * 31;
        String placeholder = getPlaceholder();
        int hashCode10 = (hashCode9 + (placeholder != null ? placeholder.hashCode() : 0)) * 31;
        boolean isConfirmed = isConfirmed();
        int i3 = 1;
        if (isConfirmed) {
            isConfirmed = true;
        }
        int i4 = isConfirmed ? 1 : 0;
        int i5 = isConfirmed ? 1 : 0;
        int i6 = isConfirmed ? 1 : 0;
        int i7 = (hashCode10 + i4) * 31;
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
        return this.l;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    public boolean isModifiable() {
        return this.m;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItem
    public void setCurrentText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.d = str;
        getDidChange().accept(Boolean.valueOf(!Intrinsics.areEqual(getOriginalText(), this.d)));
    }

    public final void setParentValues(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.h = list;
    }

    public final void setSelectContext(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f = str;
    }

    public final void setValue(@Nullable String str) {
        this.g = str;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ShopSettingsSelectItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", parcelledText=");
        L.append(this.d);
        L.append(", originalText=");
        L.append(getOriginalText());
        L.append(", selectContext=");
        L.append(this.f);
        L.append(", value=");
        L.append(this.g);
        L.append(", parentValues=");
        L.append(this.h);
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
        parcel.writeStringList(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j.name());
        parcel.writeString(this.k);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeInt(this.n ? 1 : 0);
        parcel.writeParcelable(this.o, i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopSettingsSelectItem(String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, ShopSettingsInputItem.State state, String str8, boolean z, boolean z2, boolean z3, FormatterType formatterType, int i2, j jVar) {
        this(str, str2, str3, str4, str5, str6, list, str7, state, str8, (i2 & 1024) != 0 ? false : z, z2, z3, (i2 & 8192) != 0 ? FormatterType.Companion.getSIMPLE() : formatterType);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShopSettingsSelectItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @NotNull List<String> list, @Nullable String str6, @NotNull ShopSettingsInputItem.State state, @Nullable String str7, boolean z, boolean z2) {
        this(str, str2, str3, str3, str4, str5, list, str6, state, str7, false, z, z2, null, 9216, null);
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "text");
        Intrinsics.checkNotNullParameter(str4, "selectContext");
        Intrinsics.checkNotNullParameter(list, "parentValues");
        Intrinsics.checkNotNullParameter(state, "state");
    }
}
