package com.avito.android.deep_linking.links;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.ConsultationFormData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0013\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/avito/android/deep_linking/links/RealtyRequestFormLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/ConsultationFormData;", "d", "Lcom/avito/android/remote/model/ConsultationFormData;", "getForm", "()Lcom/avito/android/remote/model/ConsultationFormData;", "form", "", "c", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "getPath$annotations", "()V", MessageMetaInfo.COLUMN_PATH, "<init>", "(Lcom/avito/android/remote/model/ConsultationFormData;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class RealtyRequestFormLink extends DeepLink {
    public static final Parcelable.Creator<RealtyRequestFormLink> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String FACTORY_MAPPING_PATH = "1/realtyRequestForm/show";
    @NotNull
    public static final String PATH = "/realtyRequestForm/show";
    @NotNull
    public final String c;
    @Nullable
    public final ConsultationFormData d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/deep_linking/links/RealtyRequestFormLink$Companion;", "", "", "FACTORY_MAPPING_PATH", "Ljava/lang/String;", "PATH", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<RealtyRequestFormLink> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RealtyRequestFormLink createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new RealtyRequestFormLink(parcel.readInt() != 0 ? ConsultationFormData.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RealtyRequestFormLink[] newArray(int i) {
            return new RealtyRequestFormLink[i];
        }
    }

    public RealtyRequestFormLink() {
        this(null, 1, null);
    }

    public RealtyRequestFormLink(@Nullable ConsultationFormData consultationFormData) {
        this.d = consultationFormData;
        this.c = PATH;
    }

    public static /* synthetic */ void getPath$annotations() {
    }

    @Nullable
    public final ConsultationFormData getForm() {
        return this.d;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        ConsultationFormData consultationFormData = this.d;
        if (consultationFormData != null) {
            parcel.writeInt(1);
            consultationFormData.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RealtyRequestFormLink(ConsultationFormData consultationFormData, int i, j jVar) {
        this((i & 1) != 0 ? null : consultationFormData);
    }
}
