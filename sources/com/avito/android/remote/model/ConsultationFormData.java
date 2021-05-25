package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000fR\u001b\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$R\u001b\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/avito/android/remote/model/ConsultationFormData;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "policy", "Lcom/avito/android/remote/model/text/AttributedText;", "getPolicy", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "buttonTitle", "Ljava/lang/String;", "getButtonTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/SuccessAction;", "successAction", "Lcom/avito/android/remote/model/SuccessAction;", "getSuccessAction", "()Lcom/avito/android/remote/model/SuccessAction;", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "title", "getTitle", "attributedSubtitle", "getAttributedSubtitle", "Lcom/avito/android/remote/model/FormInput;", "nameInput", "Lcom/avito/android/remote/model/FormInput;", "getNameInput", "()Lcom/avito/android/remote/model/FormInput;", "phoneInput", "getPhoneInput", "Lcom/avito/android/remote/model/FormCategory;", "category", "Lcom/avito/android/remote/model/FormCategory;", "getCategory", "()Lcom/avito/android/remote/model/FormCategory;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/FormInput;Lcom/avito/android/remote/model/FormInput;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Lcom/avito/android/remote/model/SuccessAction;Lcom/avito/android/remote/model/FormCategory;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ConsultationFormData implements Parcelable {
    public static final Parcelable.Creator<ConsultationFormData> CREATOR = new Creator();
    @Nullable
    private final AttributedText attributedSubtitle;
    @Nullable
    private final String buttonTitle;
    @Nullable
    private final FormCategory category;
    @Nullable
    private final FormInput nameInput;
    @Nullable
    private final FormInput phoneInput;
    @Nullable
    private final AttributedText policy;
    @Nullable
    private final String subtitle;
    @Nullable
    private final SuccessAction successAction;
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ConsultationFormData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ConsultationFormData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ConsultationFormData(parcel.readString(), parcel.readString(), (AttributedText) parcel.readParcelable(ConsultationFormData.class.getClassLoader()), parcel.readInt() != 0 ? FormInput.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? FormInput.CREATOR.createFromParcel(parcel) : null, (AttributedText) parcel.readParcelable(ConsultationFormData.class.getClassLoader()), parcel.readString(), (SuccessAction) parcel.readParcelable(ConsultationFormData.class.getClassLoader()), parcel.readInt() != 0 ? (FormCategory) Enum.valueOf(FormCategory.class, parcel.readString()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ConsultationFormData[] newArray(int i) {
            return new ConsultationFormData[i];
        }
    }

    public ConsultationFormData() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public ConsultationFormData(@Nullable String str, @Nullable String str2, @Nullable AttributedText attributedText, @Nullable FormInput formInput, @Nullable FormInput formInput2, @Nullable AttributedText attributedText2, @Nullable String str3, @Nullable SuccessAction successAction2, @Nullable FormCategory formCategory) {
        this.title = str;
        this.subtitle = str2;
        this.attributedSubtitle = attributedText;
        this.nameInput = formInput;
        this.phoneInput = formInput2;
        this.policy = attributedText2;
        this.buttonTitle = str3;
        this.successAction = successAction2;
        this.category = formCategory;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AttributedText getAttributedSubtitle() {
        return this.attributedSubtitle;
    }

    @Nullable
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    @Nullable
    public final FormCategory getCategory() {
        return this.category;
    }

    @Nullable
    public final FormInput getNameInput() {
        return this.nameInput;
    }

    @Nullable
    public final FormInput getPhoneInput() {
        return this.phoneInput;
    }

    @Nullable
    public final AttributedText getPolicy() {
        return this.policy;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final SuccessAction getSuccessAction() {
        return this.successAction;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeParcelable(this.attributedSubtitle, i);
        FormInput formInput = this.nameInput;
        if (formInput != null) {
            parcel.writeInt(1);
            formInput.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        FormInput formInput2 = this.phoneInput;
        if (formInput2 != null) {
            parcel.writeInt(1);
            formInput2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.policy, i);
        parcel.writeString(this.buttonTitle);
        parcel.writeParcelable(this.successAction, i);
        FormCategory formCategory = this.category;
        if (formCategory != null) {
            parcel.writeInt(1);
            parcel.writeString(formCategory.name());
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConsultationFormData(String str, String str2, AttributedText attributedText, FormInput formInput, FormInput formInput2, AttributedText attributedText2, String str3, SuccessAction successAction2, FormCategory formCategory, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : attributedText, (i & 8) != 0 ? null : formInput, (i & 16) != 0 ? null : formInput2, (i & 32) != 0 ? null : attributedText2, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : successAction2, (i & 256) == 0 ? formCategory : null);
    }
}
