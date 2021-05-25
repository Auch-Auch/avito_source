package com.avito.android.photo_wizard;

import a2.b.a.a.a;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/photo_wizard/PhotoWizardViewState;", "", "<init>", "()V", "ClosedWithResult", "ForceClosed", "Picture", "TakePicture", "Lcom/avito/android/photo_wizard/PhotoWizardViewState$TakePicture;", "Lcom/avito/android/photo_wizard/PhotoWizardViewState$Picture;", "Lcom/avito/android/photo_wizard/PhotoWizardViewState$ForceClosed;", "Lcom/avito/android/photo_wizard/PhotoWizardViewState$ClosedWithResult;", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public abstract class PhotoWizardViewState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_wizard/PhotoWizardViewState$ClosedWithResult;", "Lcom/avito/android/photo_wizard/PhotoWizardViewState;", "<init>", "()V", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
    public static final class ClosedWithResult extends PhotoWizardViewState {
        @NotNull
        public static final ClosedWithResult INSTANCE = new ClosedWithResult();

        public ClosedWithResult() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_wizard/PhotoWizardViewState$ForceClosed;", "Lcom/avito/android/photo_wizard/PhotoWizardViewState;", "<init>", "()V", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
    public static final class ForceClosed extends PhotoWizardViewState {
        @NotNull
        public static final ForceClosed INSTANCE = new ForceClosed();

        public ForceClosed() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/avito/android/photo_wizard/PhotoWizardViewState$Picture;", "Lcom/avito/android/photo_wizard/PhotoWizardViewState;", "Landroid/net/Uri;", "component1", "()Landroid/net/Uri;", "Lcom/avito/android/photo_wizard/ActionsState;", "component2", "()Lcom/avito/android/photo_wizard/ActionsState;", "Lcom/avito/android/photo_wizard/PictureType;", "component3", "()Lcom/avito/android/photo_wizard/PictureType;", ShareConstants.MEDIA_URI, "actionsState", "pictureType", "copy", "(Landroid/net/Uri;Lcom/avito/android/photo_wizard/ActionsState;Lcom/avito/android/photo_wizard/PictureType;)Lcom/avito/android/photo_wizard/PhotoWizardViewState$Picture;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Lcom/avito/android/photo_wizard/PictureType;", "getPictureType", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_wizard/ActionsState;", "getActionsState", AuthSource.SEND_ABUSE, "Landroid/net/Uri;", "getUri", "<init>", "(Landroid/net/Uri;Lcom/avito/android/photo_wizard/ActionsState;Lcom/avito/android/photo_wizard/PictureType;)V", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
    public static final class Picture extends PhotoWizardViewState {
        @NotNull
        public final Uri a;
        @NotNull
        public final ActionsState b;
        @NotNull
        public final PictureType c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Picture(@NotNull Uri uri, @NotNull ActionsState actionsState, @NotNull PictureType pictureType) {
            super(null);
            Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
            Intrinsics.checkNotNullParameter(actionsState, "actionsState");
            Intrinsics.checkNotNullParameter(pictureType, "pictureType");
            this.a = uri;
            this.b = actionsState;
            this.c = pictureType;
        }

        public static /* synthetic */ Picture copy$default(Picture picture, Uri uri, ActionsState actionsState, PictureType pictureType, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = picture.a;
            }
            if ((i & 2) != 0) {
                actionsState = picture.b;
            }
            if ((i & 4) != 0) {
                pictureType = picture.c;
            }
            return picture.copy(uri, actionsState, pictureType);
        }

        @NotNull
        public final Uri component1() {
            return this.a;
        }

        @NotNull
        public final ActionsState component2() {
            return this.b;
        }

        @NotNull
        public final PictureType component3() {
            return this.c;
        }

        @NotNull
        public final Picture copy(@NotNull Uri uri, @NotNull ActionsState actionsState, @NotNull PictureType pictureType) {
            Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
            Intrinsics.checkNotNullParameter(actionsState, "actionsState");
            Intrinsics.checkNotNullParameter(pictureType, "pictureType");
            return new Picture(uri, actionsState, pictureType);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Picture)) {
                return false;
            }
            Picture picture = (Picture) obj;
            return Intrinsics.areEqual(this.a, picture.a) && Intrinsics.areEqual(this.b, picture.b) && Intrinsics.areEqual(this.c, picture.c);
        }

        @NotNull
        public final ActionsState getActionsState() {
            return this.b;
        }

        @NotNull
        public final PictureType getPictureType() {
            return this.c;
        }

        @NotNull
        public final Uri getUri() {
            return this.a;
        }

        public int hashCode() {
            Uri uri = this.a;
            int i = 0;
            int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
            ActionsState actionsState = this.b;
            int hashCode2 = (hashCode + (actionsState != null ? actionsState.hashCode() : 0)) * 31;
            PictureType pictureType = this.c;
            if (pictureType != null) {
                i = pictureType.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Picture(uri=");
            L.append(this.a);
            L.append(", actionsState=");
            L.append(this.b);
            L.append(", pictureType=");
            L.append(this.c);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b)\u0010*J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJB\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0007R\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u000b¨\u0006+"}, d2 = {"Lcom/avito/android/photo_wizard/PhotoWizardViewState$TakePicture;", "Lcom/avito/android/photo_wizard/PhotoWizardViewState;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "", "Lcom/avito/android/photo_wizard/DocumentType;", "component3", "()Ljava/util/List;", "Lcom/avito/android/photo_wizard/PictureType;", "component4", "()Lcom/avito/android/photo_wizard/PictureType;", "hint", "maskResId", "types", "pictureType", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/avito/android/photo_wizard/PictureType;)Lcom/avito/android/photo_wizard/PhotoWizardViewState$TakePicture;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getHint", "d", "Lcom/avito/android/photo_wizard/PictureType;", "getPictureType", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getMaskResId", "c", "Ljava/util/List;", "getTypes", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/avito/android/photo_wizard/PictureType;)V", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
    public static final class TakePicture extends PhotoWizardViewState {
        @Nullable
        public final String a;
        @Nullable
        public final Integer b;
        @NotNull
        public final List<DocumentType> c;
        @NotNull
        public final PictureType d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TakePicture(@Nullable String str, @DrawableRes @Nullable Integer num, @NotNull List<DocumentType> list, @NotNull PictureType pictureType) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "types");
            Intrinsics.checkNotNullParameter(pictureType, "pictureType");
            this.a = str;
            this.b = num;
            this.c = list;
            this.d = pictureType;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.photo_wizard.PhotoWizardViewState$TakePicture */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TakePicture copy$default(TakePicture takePicture, String str, Integer num, List list, PictureType pictureType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = takePicture.a;
            }
            if ((i & 2) != 0) {
                num = takePicture.b;
            }
            if ((i & 4) != 0) {
                list = takePicture.c;
            }
            if ((i & 8) != 0) {
                pictureType = takePicture.d;
            }
            return takePicture.copy(str, num, list, pictureType);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final Integer component2() {
            return this.b;
        }

        @NotNull
        public final List<DocumentType> component3() {
            return this.c;
        }

        @NotNull
        public final PictureType component4() {
            return this.d;
        }

        @NotNull
        public final TakePicture copy(@Nullable String str, @DrawableRes @Nullable Integer num, @NotNull List<DocumentType> list, @NotNull PictureType pictureType) {
            Intrinsics.checkNotNullParameter(list, "types");
            Intrinsics.checkNotNullParameter(pictureType, "pictureType");
            return new TakePicture(str, num, list, pictureType);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TakePicture)) {
                return false;
            }
            TakePicture takePicture = (TakePicture) obj;
            return Intrinsics.areEqual(this.a, takePicture.a) && Intrinsics.areEqual(this.b, takePicture.b) && Intrinsics.areEqual(this.c, takePicture.c) && Intrinsics.areEqual(this.d, takePicture.d);
        }

        @Nullable
        public final String getHint() {
            return this.a;
        }

        @Nullable
        public final Integer getMaskResId() {
            return this.b;
        }

        @NotNull
        public final PictureType getPictureType() {
            return this.d;
        }

        @NotNull
        public final List<DocumentType> getTypes() {
            return this.c;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.b;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
            List<DocumentType> list = this.c;
            int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            PictureType pictureType = this.d;
            if (pictureType != null) {
                i = pictureType.hashCode();
            }
            return hashCode3 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("TakePicture(hint=");
            L.append(this.a);
            L.append(", maskResId=");
            L.append(this.b);
            L.append(", types=");
            L.append(this.c);
            L.append(", pictureType=");
            L.append(this.d);
            L.append(")");
            return L.toString();
        }
    }

    public PhotoWizardViewState() {
    }

    public PhotoWizardViewState(j jVar) {
    }
}
