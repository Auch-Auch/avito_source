package com.avito.android.items;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.items.InputItem;
import com.avito.android.items.ItemWithAdditionalButton;
import com.avito.android.items.ItemWithState;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.DisplayingOptions;
import com.avito.android.remote.model.text.AttributedText;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b:\b\b\u0018\u00002\u00020\u00012\u00020\u0002BÇ\u0001\u0012\u0006\u0010(\u001a\u00020\u0007\u0012\u0006\u0010)\u001a\u00020\u0007\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010-\u001a\u00020\u000e\u0012\u0006\u0010.\u001a\u00020\u000e\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u00102\u001a\u00020\u0003\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u00107\u001a\u00020!\u0012\b\b\u0002\u00108\u001a\u00020$\u0012\b\b\u0002\u00109\u001a\u00020\u0003¢\u0006\u0004\b~\u0010J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\f\u0010\tJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\r\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0012\u0010\tJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0013\u0010\tJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0005J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001d\u0010\tJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÆ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b'\u0010\u0005JØ\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020\u00072\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000e2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u00102\u001a\u00020\u00032\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u00107\u001a\u00020!2\b\b\u0002\u00108\u001a\u00020$2\b\b\u0002\u00109\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b:\u0010;J\u0010\u0010<\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b<\u0010\tJ\u0010\u0010=\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b=\u0010\u0010J\u001a\u0010@\u001a\u00020\u00032\b\u0010?\u001a\u0004\u0018\u00010>HÖ\u0003¢\u0006\u0004\b@\u0010AJ\u0010\u0010B\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\bB\u0010\u0010J \u0010G\u001a\u00020F2\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\bG\u0010HR\u001c\u0010)\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010\tR\u001c\u0010(\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bL\u0010J\u001a\u0004\bM\u0010\tR\u001e\u00101\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010\u0015R\u001e\u00106\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010 R\u001e\u00104\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010\u001cR\"\u00108\u001a\u00020$8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010&\"\u0004\bZ\u0010[R\"\u00107\u001a\u00020!8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010#\"\u0004\b_\u0010`R\u001e\u00105\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\ba\u0010J\u001a\u0004\bb\u0010\tR\u001e\u00103\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010\u0019R$\u0010+\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bf\u0010J\u001a\u0004\bg\u0010\t\"\u0004\bh\u0010iR\u001c\u00109\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010\u0005R\u001e\u00100\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bm\u0010J\u001a\u0004\bn\u0010\tR$\u0010*\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bo\u0010J\u001a\u0004\bp\u0010\t\"\u0004\bq\u0010iR\u001c\u0010.\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010\u0010R$\u0010,\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bu\u0010J\u001a\u0004\bv\u0010\t\"\u0004\bw\u0010iR\u001c\u0010-\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bx\u0010s\u001a\u0004\by\u0010\u0010R\u001c\u00102\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bz\u0010k\u001a\u0004\b{\u0010\u0005R\u001e\u0010/\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b|\u0010J\u001a\u0004\b}\u0010\t¨\u0006\u0001"}, d2 = {"Lcom/avito/android/items/ParcelableInput;", "Lcom/avito/android/items/InputItem;", "Landroid/os/Parcelable;", "", "hasError", "()Z", "hasValue", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()I", "component7", "component8", "component9", "component10", "()Ljava/lang/Integer;", "component11", "Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;", "component12", "()Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "component13", "()Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "component14", "Lcom/avito/android/remote/model/text/AttributedText;", "component15", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/items/ItemWithState$State;", "component16", "()Lcom/avito/android/items/ItemWithState$State;", "Lcom/avito/android/lib/design/input/FormatterType;", "component17", "()Lcom/avito/android/lib/design/input/FormatterType;", "component18", "stringId", "title", "value", "error", "bubbleError", "androidSdkInputType", "lines", "prefix", "postfix", "labelMode", "hasCardTopBackground", "additionalButton", "displayingOptions", InternalConstsKt.PLACEHOLDER, "motivation", "state", "inputType", "hideTitle", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/items/ItemWithState$State;Lcom/avito/android/lib/design/input/FormatterType;Z)Lcom/avito/android/items/ParcelableInput;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", AuthSource.SEND_ABUSE, "getStringId", "j", "Ljava/lang/Integer;", "getLabelMode", "o", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "getDisplayingOptions", VKApiConst.Q, "Lcom/avito/android/lib/design/input/FormatterType;", "getInputType", "setInputType", "(Lcom/avito/android/lib/design/input/FormatterType;)V", "p", "Lcom/avito/android/items/ItemWithState$State;", "getState", "setState", "(Lcom/avito/android/items/ItemWithState$State;)V", "n", "getPlaceholder", "l", "Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;", "getAdditionalButton", "d", "getError", "setError", "(Ljava/lang/String;)V", "r", "Z", "getHideTitle", "i", "getPostfix", "c", "getValue", "setValue", g.a, "I", "getLines", "e", "getBubbleError", "setBubbleError", "f", "getAndroidSdkInputType", "k", "getHasCardTopBackground", "h", "getPrefix", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/items/ItemWithState$State;Lcom/avito/android/lib/design/input/FormatterType;Z)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class ParcelableInput implements InputItem, Parcelable {
    public static final Parcelable.Creator<ParcelableInput> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public String c;
    @Nullable
    public String d;
    @Nullable
    public String e;
    public final int f;
    public final int g;
    @Nullable
    public final String h;
    @Nullable
    public final String i;
    @Nullable
    public final Integer j;
    public final boolean k;
    @Nullable
    public final ItemWithAdditionalButton.AdditionalButton l;
    @Nullable
    public final DisplayingOptions m;
    @Nullable
    public final String n;
    @Nullable
    public final AttributedText o;
    @NotNull
    public ItemWithState.State p;
    @NotNull
    public FormatterType q;
    public final boolean r;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ParcelableInput> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ParcelableInput createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ParcelableInput(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0, (ItemWithAdditionalButton.AdditionalButton) parcel.readParcelable(ParcelableInput.class.getClassLoader()), (DisplayingOptions) parcel.readParcelable(ParcelableInput.class.getClassLoader()), parcel.readString(), (AttributedText) parcel.readParcelable(ParcelableInput.class.getClassLoader()), (ItemWithState.State) parcel.readParcelable(ParcelableInput.class.getClassLoader()), (FormatterType) parcel.readParcelable(ParcelableInput.class.getClassLoader()), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ParcelableInput[] newArray(int i) {
            return new ParcelableInput[i];
        }
    }

    public ParcelableInput(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i2, int i3, @Nullable String str6, @Nullable String str7, @Nullable Integer num, boolean z, @Nullable ItemWithAdditionalButton.AdditionalButton additionalButton, @Nullable DisplayingOptions displayingOptions, @Nullable String str8, @Nullable AttributedText attributedText, @NotNull ItemWithState.State state, @NotNull FormatterType formatterType, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(formatterType, "inputType");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = i2;
        this.g = i3;
        this.h = str6;
        this.i = str7;
        this.j = num;
        this.k = z;
        this.l = additionalButton;
        this.m = displayingOptions;
        this.n = str8;
        this.o = attributedText;
        this.p = state;
        this.q = formatterType;
        this.r = z2;
    }

    public static /* synthetic */ ParcelableInput copy$default(ParcelableInput parcelableInput, String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6, String str7, Integer num, boolean z, ItemWithAdditionalButton.AdditionalButton additionalButton, DisplayingOptions displayingOptions, String str8, AttributedText attributedText, ItemWithState.State state, FormatterType formatterType, boolean z2, int i4, Object obj) {
        return parcelableInput.copy((i4 & 1) != 0 ? parcelableInput.getStringId() : str, (i4 & 2) != 0 ? parcelableInput.getTitle() : str2, (i4 & 4) != 0 ? parcelableInput.getValue() : str3, (i4 & 8) != 0 ? parcelableInput.getError() : str4, (i4 & 16) != 0 ? parcelableInput.getBubbleError() : str5, (i4 & 32) != 0 ? parcelableInput.getAndroidSdkInputType() : i2, (i4 & 64) != 0 ? parcelableInput.getLines() : i3, (i4 & 128) != 0 ? parcelableInput.getPrefix() : str6, (i4 & 256) != 0 ? parcelableInput.getPostfix() : str7, (i4 & 512) != 0 ? parcelableInput.getLabelMode() : num, (i4 & 1024) != 0 ? parcelableInput.getHasCardTopBackground() : z, (i4 & 2048) != 0 ? parcelableInput.getAdditionalButton() : additionalButton, (i4 & 4096) != 0 ? parcelableInput.getDisplayingOptions() : displayingOptions, (i4 & 8192) != 0 ? parcelableInput.getPlaceholder() : str8, (i4 & 16384) != 0 ? parcelableInput.getMotivation() : attributedText, (i4 & 32768) != 0 ? parcelableInput.getState() : state, (i4 & 65536) != 0 ? parcelableInput.getInputType() : formatterType, (i4 & 131072) != 0 ? parcelableInput.getHideTitle() : z2);
    }

    @Override // com.avito.android.items.InputItem
    public void applyError(@Nullable String str) {
        InputItem.DefaultImpls.applyError(this, str);
    }

    @Override // com.avito.android.items.InputItem, com.avito.android.items.ItemWithErrors
    public void clearErrors() {
        InputItem.DefaultImpls.clearErrors(this);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @Nullable
    public final Integer component10() {
        return getLabelMode();
    }

    public final boolean component11() {
        return getHasCardTopBackground();
    }

    @Nullable
    public final ItemWithAdditionalButton.AdditionalButton component12() {
        return getAdditionalButton();
    }

    @Nullable
    public final DisplayingOptions component13() {
        return getDisplayingOptions();
    }

    @Nullable
    public final String component14() {
        return getPlaceholder();
    }

    @Nullable
    public final AttributedText component15() {
        return getMotivation();
    }

    @NotNull
    public final ItemWithState.State component16() {
        return getState();
    }

    @NotNull
    public final FormatterType component17() {
        return getInputType();
    }

    public final boolean component18() {
        return getHideTitle();
    }

    @NotNull
    public final String component2() {
        return getTitle();
    }

    @Nullable
    public final String component3() {
        return getValue();
    }

    @Nullable
    public final String component4() {
        return getError();
    }

    @Nullable
    public final String component5() {
        return getBubbleError();
    }

    public final int component6() {
        return getAndroidSdkInputType();
    }

    public final int component7() {
        return getLines();
    }

    @Nullable
    public final String component8() {
        return getPrefix();
    }

    @Nullable
    public final String component9() {
        return getPostfix();
    }

    @NotNull
    public final ParcelableInput copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i2, int i3, @Nullable String str6, @Nullable String str7, @Nullable Integer num, boolean z, @Nullable ItemWithAdditionalButton.AdditionalButton additionalButton, @Nullable DisplayingOptions displayingOptions, @Nullable String str8, @Nullable AttributedText attributedText, @NotNull ItemWithState.State state, @NotNull FormatterType formatterType, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(formatterType, "inputType");
        return new ParcelableInput(str, str2, str3, str4, str5, i2, i3, str6, str7, num, z, additionalButton, displayingOptions, str8, attributedText, state, formatterType, z2);
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
        if (!(obj instanceof ParcelableInput)) {
            return false;
        }
        ParcelableInput parcelableInput = (ParcelableInput) obj;
        return Intrinsics.areEqual(getStringId(), parcelableInput.getStringId()) && Intrinsics.areEqual(getTitle(), parcelableInput.getTitle()) && Intrinsics.areEqual(getValue(), parcelableInput.getValue()) && Intrinsics.areEqual(getError(), parcelableInput.getError()) && Intrinsics.areEqual(getBubbleError(), parcelableInput.getBubbleError()) && getAndroidSdkInputType() == parcelableInput.getAndroidSdkInputType() && getLines() == parcelableInput.getLines() && Intrinsics.areEqual(getPrefix(), parcelableInput.getPrefix()) && Intrinsics.areEqual(getPostfix(), parcelableInput.getPostfix()) && Intrinsics.areEqual(getLabelMode(), parcelableInput.getLabelMode()) && getHasCardTopBackground() == parcelableInput.getHasCardTopBackground() && Intrinsics.areEqual(getAdditionalButton(), parcelableInput.getAdditionalButton()) && Intrinsics.areEqual(getDisplayingOptions(), parcelableInput.getDisplayingOptions()) && Intrinsics.areEqual(getPlaceholder(), parcelableInput.getPlaceholder()) && Intrinsics.areEqual(getMotivation(), parcelableInput.getMotivation()) && Intrinsics.areEqual(getState(), parcelableInput.getState()) && Intrinsics.areEqual(getInputType(), parcelableInput.getInputType()) && getHideTitle() == parcelableInput.getHideTitle();
    }

    @Override // com.avito.android.items.InputItem, com.avito.android.items.ItemWithAdditionalButton
    @Nullable
    public ItemWithAdditionalButton.AdditionalButton getAdditionalButton() {
        return this.l;
    }

    @Override // com.avito.android.items.InputItem
    public int getAndroidSdkInputType() {
        return this.f;
    }

    @Override // com.avito.android.items.ItemWithErrors
    @Nullable
    public String getBubbleError() {
        return this.e;
    }

    @Override // com.avito.android.items.InputItem
    @Nullable
    public DisplayingOptions getDisplayingOptions() {
        return this.m;
    }

    @Override // com.avito.android.items.ItemWithErrors
    @Nullable
    public String getError() {
        return this.d;
    }

    @Override // com.avito.android.items.InputItem
    public boolean getHasCardTopBackground() {
        return this.k;
    }

    @Override // com.avito.android.category_parameters.TitleHidingElement
    public boolean getHideTitle() {
        return this.r;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return InputItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.items.InputItem
    @NotNull
    public FormatterType getInputType() {
        return this.q;
    }

    @Override // com.avito.android.items.InputItem
    @Nullable
    public Integer getLabelMode() {
        return this.j;
    }

    @Override // com.avito.android.items.InputItem
    public int getLines() {
        return this.g;
    }

    @Override // com.avito.android.items.ItemWithMotivation
    @Nullable
    public AttributedText getMotivation() {
        return this.o;
    }

    @Override // com.avito.android.items.InputItem
    @Nullable
    public String getPlaceholder() {
        return this.n;
    }

    @Override // com.avito.android.items.InputItem
    @Nullable
    public String getPostfix() {
        return this.i;
    }

    @Override // com.avito.android.items.InputItem
    @Nullable
    public String getPrefix() {
        return this.h;
    }

    @Override // com.avito.android.items.ItemWithState
    @NotNull
    public ItemWithState.State getState() {
        return this.p;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Override // com.avito.android.items.InputItem
    @NotNull
    public String getTitle() {
        return this.b;
    }

    @Override // com.avito.android.items.InputItem, com.avito.android.items.BasicInputItem
    @Nullable
    public String getValue() {
        return this.c;
    }

    public final boolean hasError() {
        String error = getError();
        return !(error == null || error.length() == 0);
    }

    public final boolean hasValue() {
        String value = getValue();
        return !(value == null || value.length() == 0);
    }

    @Override // java.lang.Object
    public int hashCode() {
        String stringId = getStringId();
        int i2 = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        String title = getTitle();
        int hashCode2 = (hashCode + (title != null ? title.hashCode() : 0)) * 31;
        String value = getValue();
        int hashCode3 = (hashCode2 + (value != null ? value.hashCode() : 0)) * 31;
        String error = getError();
        int hashCode4 = (hashCode3 + (error != null ? error.hashCode() : 0)) * 31;
        String bubbleError = getBubbleError();
        int lines = (getLines() + ((getAndroidSdkInputType() + ((hashCode4 + (bubbleError != null ? bubbleError.hashCode() : 0)) * 31)) * 31)) * 31;
        String prefix = getPrefix();
        int hashCode5 = (lines + (prefix != null ? prefix.hashCode() : 0)) * 31;
        String postfix = getPostfix();
        int hashCode6 = (hashCode5 + (postfix != null ? postfix.hashCode() : 0)) * 31;
        Integer labelMode = getLabelMode();
        int hashCode7 = (hashCode6 + (labelMode != null ? labelMode.hashCode() : 0)) * 31;
        boolean hasCardTopBackground = getHasCardTopBackground();
        int i3 = 1;
        if (hasCardTopBackground) {
            hasCardTopBackground = true;
        }
        int i4 = hasCardTopBackground ? 1 : 0;
        int i5 = hasCardTopBackground ? 1 : 0;
        int i6 = hasCardTopBackground ? 1 : 0;
        int i7 = (hashCode7 + i4) * 31;
        ItemWithAdditionalButton.AdditionalButton additionalButton = getAdditionalButton();
        int hashCode8 = (i7 + (additionalButton != null ? additionalButton.hashCode() : 0)) * 31;
        DisplayingOptions displayingOptions = getDisplayingOptions();
        int hashCode9 = (hashCode8 + (displayingOptions != null ? displayingOptions.hashCode() : 0)) * 31;
        String placeholder = getPlaceholder();
        int hashCode10 = (hashCode9 + (placeholder != null ? placeholder.hashCode() : 0)) * 31;
        AttributedText motivation = getMotivation();
        int hashCode11 = (hashCode10 + (motivation != null ? motivation.hashCode() : 0)) * 31;
        ItemWithState.State state = getState();
        int hashCode12 = (hashCode11 + (state != null ? state.hashCode() : 0)) * 31;
        FormatterType inputType = getInputType();
        if (inputType != null) {
            i2 = inputType.hashCode();
        }
        int i8 = (hashCode12 + i2) * 31;
        boolean hideTitle = getHideTitle();
        if (!hideTitle) {
            i3 = hideTitle;
        }
        return i8 + i3;
    }

    @Override // com.avito.android.items.ItemWithErrors
    public void setBubbleError(@Nullable String str) {
        this.e = str;
    }

    @Override // com.avito.android.items.ItemWithErrors
    public void setError(@Nullable String str) {
        this.d = str;
    }

    public void setInputType(@NotNull FormatterType formatterType) {
        Intrinsics.checkNotNullParameter(formatterType, "<set-?>");
        this.q = formatterType;
    }

    @Override // com.avito.android.items.ItemWithState
    public void setState(@NotNull ItemWithState.State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.p = state;
    }

    @Override // com.avito.android.items.InputItem, com.avito.android.items.BasicInputItem
    public void setValue(@Nullable String str) {
        this.c = str;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ParcelableInput(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", value=");
        L.append(getValue());
        L.append(", error=");
        L.append(getError());
        L.append(", bubbleError=");
        L.append(getBubbleError());
        L.append(", androidSdkInputType=");
        L.append(getAndroidSdkInputType());
        L.append(", lines=");
        L.append(getLines());
        L.append(", prefix=");
        L.append(getPrefix());
        L.append(", postfix=");
        L.append(getPostfix());
        L.append(", labelMode=");
        L.append(getLabelMode());
        L.append(", hasCardTopBackground=");
        L.append(getHasCardTopBackground());
        L.append(", additionalButton=");
        L.append(getAdditionalButton());
        L.append(", displayingOptions=");
        L.append(getDisplayingOptions());
        L.append(", placeholder=");
        L.append(getPlaceholder());
        L.append(", motivation=");
        L.append(getMotivation());
        L.append(", state=");
        L.append(getState());
        L.append(", inputType=");
        L.append(getInputType());
        L.append(", hideTitle=");
        L.append(getHideTitle());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        Integer num = this.j;
        if (num != null) {
            parcel.writeInt(1);
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeParcelable(this.l, i2);
        parcel.writeParcelable(this.m, i2);
        parcel.writeString(this.n);
        parcel.writeParcelable(this.o, i2);
        parcel.writeParcelable(this.p, i2);
        parcel.writeParcelable(this.q, i2);
        parcel.writeInt(this.r ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ParcelableInput(String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6, String str7, Integer num, boolean z, ItemWithAdditionalButton.AdditionalButton additionalButton, DisplayingOptions displayingOptions, String str8, AttributedText attributedText, ItemWithState.State state, FormatterType formatterType, boolean z2, int i4, j jVar) {
        this(str, str2, (i4 & 4) != 0 ? null : str3, (i4 & 8) != 0 ? null : str4, (i4 & 16) != 0 ? null : str5, i2, i3, (i4 & 128) != 0 ? null : str6, (i4 & 256) != 0 ? null : str7, (i4 & 512) != 0 ? null : num, (i4 & 1024) != 0 ? false : z, (i4 & 2048) != 0 ? null : additionalButton, (i4 & 4096) != 0 ? null : displayingOptions, (i4 & 8192) != 0 ? null : str8, (i4 & 16384) != 0 ? null : attributedText, (32768 & i4) != 0 ? new ItemWithState.State.Normal(null, 1, null) : state, (65536 & i4) != 0 ? FormatterType.Companion.getSIMPLE() : formatterType, (i4 & 131072) != 0 ? false : z2);
    }
}
