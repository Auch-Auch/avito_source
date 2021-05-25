package com.avito.android.deep_linking.links;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.FormInput;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010)\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b+\u0010,J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017R\u001e\u0010!\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u0017R$\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\u00020\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u0010\u0015\u001a\u0004\b*\u0010\u0017¨\u0006-"}, d2 = {"Lcom/avito/android/deep_linking/links/RealtyRequestFormBody;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/ConsultationFormData;", "toFormData", "()Lcom/avito/android/remote/model/ConsultationFormData;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/InputType;", "formId", "Lcom/avito/android/remote/model/FormInput;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/deep_linking/links/InputType;)Lcom/avito/android/remote/model/FormInput;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "addition", "Lcom/avito/android/remote/model/text/AttributedText;", "getAddition", "()Lcom/avito/android/remote/model/text/AttributedText;", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "buttonTitle", "getButtonTitle", "successToast", "getSuccessToast", "", "Lcom/avito/android/deep_linking/links/FormInput;", "inputs", "Ljava/util/List;", "getInputs", "()Ljava/util/List;", "type", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class RealtyRequestFormBody implements Parcelable {
    public static final Parcelable.Creator<RealtyRequestFormBody> CREATOR = new Creator();
    @SerializedName("addition")
    @Nullable
    private final AttributedText addition;
    @SerializedName("reportButtonTitle")
    @Nullable
    private final String buttonTitle;
    @SerializedName("form")
    @Nullable
    private final List<FormInput> inputs;
    @SerializedName("attributedSubtitle")
    @Nullable
    private final AttributedText subtitle;
    @SerializedName("successToast")
    @Nullable
    private final String successToast;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("type")
    @NotNull
    private final String type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<RealtyRequestFormBody> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RealtyRequestFormBody createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(FormInput.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new RealtyRequestFormBody(readString, readString2, arrayList, (AttributedText) parcel.readParcelable(RealtyRequestFormBody.class.getClassLoader()), (AttributedText) parcel.readParcelable(RealtyRequestFormBody.class.getClassLoader()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RealtyRequestFormBody[] newArray(int i) {
            return new RealtyRequestFormBody[i];
        }
    }

    public RealtyRequestFormBody(@NotNull String str, @Nullable String str2, @Nullable List<FormInput> list, @Nullable AttributedText attributedText, @Nullable AttributedText attributedText2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "type");
        this.type = str;
        this.title = str2;
        this.inputs = list;
        this.subtitle = attributedText;
        this.addition = attributedText2;
        this.buttonTitle = str3;
        this.successToast = str4;
    }

    public final FormInput a(InputType inputType) {
        boolean z;
        String placeholder;
        List<FormInput> list = this.inputs;
        FormInput formInput = null;
        if (list != null) {
            for (T t : list) {
                if (t.getIdentifier() == inputType) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    if (t != null) {
                        String title2 = t.getTitle();
                        if (title2 == null || (placeholder = t.getPlaceholder()) == null) {
                            return null;
                        }
                        formInput = new FormInput(title2, placeholder, t.getValue(), t.getError(), Boolean.valueOf(t.getRequired()), inputType == InputType.Phone);
                    }
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        return formInput;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AttributedText getAddition() {
        return this.addition;
    }

    @Nullable
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    @Nullable
    public final List<FormInput> getInputs() {
        return this.inputs;
    }

    @Nullable
    public final AttributedText getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getSuccessToast() {
        return this.successToast;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.avito.android.remote.model.ConsultationFormData toFormData() {
        /*
            r13 = this;
            java.lang.String r1 = r13.title
            com.avito.android.remote.model.text.AttributedText r3 = r13.subtitle
            com.avito.android.deep_linking.links.InputType r0 = com.avito.android.deep_linking.links.InputType.Name
            com.avito.android.remote.model.FormInput r4 = r13.a(r0)
            com.avito.android.deep_linking.links.InputType r0 = com.avito.android.deep_linking.links.InputType.Phone
            com.avito.android.remote.model.FormInput r5 = r13.a(r0)
            java.lang.String r0 = r13.type
            int r2 = r0.hashCode()
            r6 = -1252584857(0xffffffffb5571267, float:-8.012052E-7)
            if (r2 == r6) goto L_0x002c
            r6 = 192337287(0xb76d587, float:4.7538517E-32)
            if (r2 == r6) goto L_0x0021
            goto L_0x0037
        L_0x0021:
            java.lang.String r2 = "findOfficeOffer"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0037
            com.avito.android.remote.model.FormCategory r0 = com.avito.android.remote.model.FormCategory.FindOfficeOffer
            goto L_0x0039
        L_0x002c:
            java.lang.String r2 = "verifiedAvito"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0037
            com.avito.android.remote.model.FormCategory r0 = com.avito.android.remote.model.FormCategory.VerifiedByAvito
            goto L_0x0039
        L_0x0037:
            com.avito.android.remote.model.FormCategory r0 = com.avito.android.remote.model.FormCategory.NewBuildings
        L_0x0039:
            r9 = r0
            com.avito.android.remote.model.text.AttributedText r6 = r13.addition
            java.lang.String r0 = r13.successToast
            if (r0 == 0) goto L_0x0047
            com.avito.android.remote.model.SuccessAction$ShowToast r2 = new com.avito.android.remote.model.SuccessAction$ShowToast
            r2.<init>(r0)
            r8 = r2
            goto L_0x0049
        L_0x0047:
            r0 = 0
            r8 = r0
        L_0x0049:
            java.lang.String r7 = r13.buttonTitle
            r10 = 2
            r11 = 0
            com.avito.android.remote.model.ConsultationFormData r12 = new com.avito.android.remote.model.ConsultationFormData
            r2 = 0
            r0 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.deep_linking.links.RealtyRequestFormBody.toFormData():com.avito.android.remote.model.ConsultationFormData");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.type);
        parcel.writeString(this.title);
        List<FormInput> list = this.inputs;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((FormInput) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.subtitle, i);
        parcel.writeParcelable(this.addition, i);
        parcel.writeString(this.buttonTitle);
        parcel.writeString(this.successToast);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RealtyRequestFormBody(String str, String str2, List list, AttributedText attributedText, AttributedText attributedText2, String str3, String str4, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : attributedText, (i & 16) != 0 ? null : attributedText2, (i & 32) != 0 ? null : str3, (i & 64) == 0 ? str4 : null);
    }
}
