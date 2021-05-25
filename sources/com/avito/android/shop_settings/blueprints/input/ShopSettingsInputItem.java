package com.avito.android.shop_settings.blueprints.input;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.shop_settings.blueprints.ShopSettingsItem;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001:\u0001\u001cR\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u0016\u0010\u0013\u001a\u00020\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\bR\u0016\u0010\u0019\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\bR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem;", "Lcom/avito/android/shop_settings/blueprints/ShopSettingsItem;", "Lcom/avito/android/lib/design/input/FormatterType;", "getFormatterType", "()Lcom/avito/android/lib/design/input/FormatterType;", "formatterType", "", "getCurrentText", "()Ljava/lang/String;", "setCurrentText", "(Ljava/lang/String;)V", "currentText", "Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;", "getState", "()Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;", "state", "getPlaceholder", InternalConstsKt.PLACEHOLDER, "", "isConfirmed", "()Z", "isModifiable", "getOriginalText", "originalText", "getTitle", "title", "getSuggestion", "suggestion", "State", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public interface ShopSettingsInputItem extends ShopSettingsItem {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getId(@NotNull ShopSettingsInputItem shopSettingsInputItem) {
            return ShopSettingsItem.DefaultImpls.getId(shopSettingsInputItem);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/input/ShopSettingsInputItem$State;", "", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "(Ljava/lang/String;I)V", "Error", HttpHeaders.WARNING, "Normal", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
    public enum State implements Parcelable {
        Error,
        Warning,
        Normal;
        
        public static final Parcelable.Creator<State> CREATOR = new Creator();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<State> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return (State) Enum.valueOf(State.class, parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State[] newArray(int i) {
                return new State[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(name());
        }
    }

    @NotNull
    String getCurrentText();

    @NotNull
    FormatterType getFormatterType();

    @NotNull
    String getOriginalText();

    @Nullable
    String getPlaceholder();

    @NotNull
    State getState();

    @Nullable
    String getSuggestion();

    @NotNull
    String getTitle();

    boolean isConfirmed();

    boolean isModifiable();

    void setCurrentText(@NotNull String str);
}
