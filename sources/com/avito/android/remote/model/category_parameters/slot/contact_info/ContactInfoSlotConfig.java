package com.avito.android.remote.model.category_parameters.slot.contact_info;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.EmailParameter;
import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.slot.SlotConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b+\u0010,J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J<\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b'\u0010\nR\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b(\u0010\u0004R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010)\u001a\u0004\b*\u0010\u0007¨\u0006-"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/contact_info/ContactInfoSlotConfig;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;", "Lcom/avito/android/remote/model/category_parameters/CharParameter;", "component1", "()Lcom/avito/android/remote/model/category_parameters/CharParameter;", "Lcom/avito/android/remote/model/category_parameters/EmailParameter;", "component2", "()Lcom/avito/android/remote/model/category_parameters/EmailParameter;", "Lcom/avito/android/remote/model/category_parameters/PhoneParameter;", "component3", "()Lcom/avito/android/remote/model/category_parameters/PhoneParameter;", "component4", "nameField", "emailField", "phoneField", "managerField", "copy", "(Lcom/avito/android/remote/model/category_parameters/CharParameter;Lcom/avito/android/remote/model/category_parameters/EmailParameter;Lcom/avito/android/remote/model/category_parameters/PhoneParameter;Lcom/avito/android/remote/model/category_parameters/CharParameter;)Lcom/avito/android/remote/model/category_parameters/slot/contact_info/ContactInfoSlotConfig;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/category_parameters/CharParameter;", "getNameField", "Lcom/avito/android/remote/model/category_parameters/PhoneParameter;", "getPhoneField", "getManagerField", "Lcom/avito/android/remote/model/category_parameters/EmailParameter;", "getEmailField", "<init>", "(Lcom/avito/android/remote/model/category_parameters/CharParameter;Lcom/avito/android/remote/model/category_parameters/EmailParameter;Lcom/avito/android/remote/model/category_parameters/PhoneParameter;Lcom/avito/android/remote/model/category_parameters/CharParameter;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ContactInfoSlotConfig implements SlotConfig {
    public static final Parcelable.Creator<ContactInfoSlotConfig> CREATOR = new Creator();
    @SerializedName("emailField")
    @Nullable
    private final EmailParameter emailField;
    @SerializedName("managerField")
    @NotNull
    private final CharParameter managerField;
    @SerializedName("nameField")
    @Nullable
    private final CharParameter nameField;
    @SerializedName("phoneField")
    @NotNull
    private final PhoneParameter phoneField;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ContactInfoSlotConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactInfoSlotConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            EmailParameter emailParameter = null;
            CharParameter createFromParcel = parcel.readInt() != 0 ? CharParameter.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                emailParameter = EmailParameter.CREATOR.createFromParcel(parcel);
            }
            return new ContactInfoSlotConfig(createFromParcel, emailParameter, PhoneParameter.CREATOR.createFromParcel(parcel), CharParameter.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactInfoSlotConfig[] newArray(int i) {
            return new ContactInfoSlotConfig[i];
        }
    }

    public ContactInfoSlotConfig(@Nullable CharParameter charParameter, @Nullable EmailParameter emailParameter, @NotNull PhoneParameter phoneParameter, @NotNull CharParameter charParameter2) {
        Intrinsics.checkNotNullParameter(phoneParameter, "phoneField");
        Intrinsics.checkNotNullParameter(charParameter2, "managerField");
        this.nameField = charParameter;
        this.emailField = emailParameter;
        this.phoneField = phoneParameter;
        this.managerField = charParameter2;
    }

    public static /* synthetic */ ContactInfoSlotConfig copy$default(ContactInfoSlotConfig contactInfoSlotConfig, CharParameter charParameter, EmailParameter emailParameter, PhoneParameter phoneParameter, CharParameter charParameter2, int i, Object obj) {
        if ((i & 1) != 0) {
            charParameter = contactInfoSlotConfig.nameField;
        }
        if ((i & 2) != 0) {
            emailParameter = contactInfoSlotConfig.emailField;
        }
        if ((i & 4) != 0) {
            phoneParameter = contactInfoSlotConfig.phoneField;
        }
        if ((i & 8) != 0) {
            charParameter2 = contactInfoSlotConfig.managerField;
        }
        return contactInfoSlotConfig.copy(charParameter, emailParameter, phoneParameter, charParameter2);
    }

    @Nullable
    public final CharParameter component1() {
        return this.nameField;
    }

    @Nullable
    public final EmailParameter component2() {
        return this.emailField;
    }

    @NotNull
    public final PhoneParameter component3() {
        return this.phoneField;
    }

    @NotNull
    public final CharParameter component4() {
        return this.managerField;
    }

    @NotNull
    public final ContactInfoSlotConfig copy(@Nullable CharParameter charParameter, @Nullable EmailParameter emailParameter, @NotNull PhoneParameter phoneParameter, @NotNull CharParameter charParameter2) {
        Intrinsics.checkNotNullParameter(phoneParameter, "phoneField");
        Intrinsics.checkNotNullParameter(charParameter2, "managerField");
        return new ContactInfoSlotConfig(charParameter, emailParameter, phoneParameter, charParameter2);
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
        if (!(obj instanceof ContactInfoSlotConfig)) {
            return false;
        }
        ContactInfoSlotConfig contactInfoSlotConfig = (ContactInfoSlotConfig) obj;
        return Intrinsics.areEqual(this.nameField, contactInfoSlotConfig.nameField) && Intrinsics.areEqual(this.emailField, contactInfoSlotConfig.emailField) && Intrinsics.areEqual(this.phoneField, contactInfoSlotConfig.phoneField) && Intrinsics.areEqual(this.managerField, contactInfoSlotConfig.managerField);
    }

    @Nullable
    public final EmailParameter getEmailField() {
        return this.emailField;
    }

    @NotNull
    public final CharParameter getManagerField() {
        return this.managerField;
    }

    @Nullable
    public final CharParameter getNameField() {
        return this.nameField;
    }

    @NotNull
    public final PhoneParameter getPhoneField() {
        return this.phoneField;
    }

    @Override // java.lang.Object
    public int hashCode() {
        CharParameter charParameter = this.nameField;
        int i = 0;
        int hashCode = (charParameter != null ? charParameter.hashCode() : 0) * 31;
        EmailParameter emailParameter = this.emailField;
        int hashCode2 = (hashCode + (emailParameter != null ? emailParameter.hashCode() : 0)) * 31;
        PhoneParameter phoneParameter = this.phoneField;
        int hashCode3 = (hashCode2 + (phoneParameter != null ? phoneParameter.hashCode() : 0)) * 31;
        CharParameter charParameter2 = this.managerField;
        if (charParameter2 != null) {
            i = charParameter2.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ContactInfoSlotConfig(nameField=");
        L.append(this.nameField);
        L.append(", emailField=");
        L.append(this.emailField);
        L.append(", phoneField=");
        L.append(this.phoneField);
        L.append(", managerField=");
        L.append(this.managerField);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        CharParameter charParameter = this.nameField;
        if (charParameter != null) {
            parcel.writeInt(1);
            charParameter.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        EmailParameter emailParameter = this.emailField;
        if (emailParameter != null) {
            parcel.writeInt(1);
            emailParameter.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        this.phoneField.writeToParcel(parcel, 0);
        this.managerField.writeToParcel(parcel, 0);
    }
}
