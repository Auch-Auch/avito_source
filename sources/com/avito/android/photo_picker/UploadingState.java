package com.avito.android.photo_picker;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.ImageUpload;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/photo_picker/UploadingState;", "", "<init>", "()V", "Error", "HasUploadData", "Loaded", "Loading", "Lcom/avito/android/photo_picker/UploadingState$Loaded;", "Lcom/avito/android/photo_picker/UploadingState$Loading;", "Lcom/avito/android/photo_picker/UploadingState$Error;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public abstract class UploadingState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/photo_picker/UploadingState$Error;", "Lcom/avito/android/photo_picker/UploadingState;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/avito/android/remote/error/TypedError;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/error/TypedError;", "getError", "()Lcom/avito/android/remote/error/TypedError;", "error", "<init>", "(Lcom/avito/android/remote/error/TypedError;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends UploadingState {
        @NotNull
        public final TypedError a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull TypedError typedError) {
            super(null);
            Intrinsics.checkNotNullParameter(typedError, "error");
            this.a = typedError;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual(obj != null ? obj.getClass() : null, Error.class)) {
                return false;
            }
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.photo_picker.UploadingState.Error");
            return !(Intrinsics.areEqual(this.a, ((Error) obj).a) ^ true);
        }

        @NotNull
        public final TypedError getError() {
            return this.a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/avito/android/photo_picker/UploadingState$HasUploadData;", "", "", "Lcom/avito/android/remote/model/ImageUpload;", "getData", "()Ljava/util/List;", "data", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public interface HasUploadData {
        @NotNull
        List<ImageUpload> getData();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/avito/android/photo_picker/UploadingState$Loaded;", "Lcom/avito/android/photo_picker/UploadingState;", "Lcom/avito/android/photo_picker/UploadingState$HasUploadData;", "", "Lcom/avito/android/remote/model/ImageUpload;", "component1", "()Ljava/util/List;", "data", "copy", "(Ljava/util/List;)Lcom/avito/android/photo_picker/UploadingState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getData", "<init>", "(Ljava/util/List;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Loaded extends UploadingState implements HasUploadData {
        @NotNull
        public final List<ImageUpload> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.ImageUpload> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Loaded(@NotNull List<? extends ImageUpload> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "data");
            this.a = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.photo_picker.UploadingState$Loaded */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = loaded.getData();
            }
            return loaded.copy(list);
        }

        @NotNull
        public final List<ImageUpload> component1() {
            return getData();
        }

        @NotNull
        public final Loaded copy(@NotNull List<? extends ImageUpload> list) {
            Intrinsics.checkNotNullParameter(list, "data");
            return new Loaded(list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Loaded) && Intrinsics.areEqual(getData(), ((Loaded) obj).getData());
            }
            return true;
        }

        @Override // com.avito.android.photo_picker.UploadingState.HasUploadData
        @NotNull
        public List<ImageUpload> getData() {
            return this.a;
        }

        public int hashCode() {
            List<ImageUpload> data = getData();
            if (data != null) {
                return data.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Loaded(data=");
            L.append(getData());
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\"J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ4\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0013\u0010\tJ\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\tR\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\t¨\u0006#"}, d2 = {"Lcom/avito/android/photo_picker/UploadingState$Loading;", "Lcom/avito/android/photo_picker/UploadingState;", "Lcom/avito/android/photo_picker/UploadingState$HasUploadData;", "", "Lcom/avito/android/remote/model/ImageUpload;", "component1", "()Ljava/util/List;", "", "component2", "()I", "component3", "data", "progressCurrent", "progressMax", "copy", "(Ljava/util/List;II)Lcom/avito/android/photo_picker/UploadingState$Loading;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getData", "c", "I", "getProgressMax", AuthSource.BOOKING_ORDER, "getProgressCurrent", "<init>", "(Ljava/util/List;II)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Loading extends UploadingState implements HasUploadData {
        @NotNull
        public final List<ImageUpload> a;
        public final int b;
        public final int c;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Loading(List list, int i, int i2, int i3, j jVar) {
            this(list, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.photo_picker.UploadingState$Loading */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Loading copy$default(Loading loading, List list, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = loading.getData();
            }
            if ((i3 & 2) != 0) {
                i = loading.b;
            }
            if ((i3 & 4) != 0) {
                i2 = loading.c;
            }
            return loading.copy(list, i, i2);
        }

        @NotNull
        public final List<ImageUpload> component1() {
            return getData();
        }

        public final int component2() {
            return this.b;
        }

        public final int component3() {
            return this.c;
        }

        @NotNull
        public final Loading copy(@NotNull List<? extends ImageUpload> list, int i, int i2) {
            Intrinsics.checkNotNullParameter(list, "data");
            return new Loading(list, i, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Loading)) {
                return false;
            }
            Loading loading = (Loading) obj;
            return Intrinsics.areEqual(getData(), loading.getData()) && this.b == loading.b && this.c == loading.c;
        }

        @Override // com.avito.android.photo_picker.UploadingState.HasUploadData
        @NotNull
        public List<ImageUpload> getData() {
            return this.a;
        }

        public final int getProgressCurrent() {
            return this.b;
        }

        public final int getProgressMax() {
            return this.c;
        }

        public int hashCode() {
            List<ImageUpload> data = getData();
            return ((((data != null ? data.hashCode() : 0) * 31) + this.b) * 31) + this.c;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Loading(data=");
            L.append(getData());
            L.append(", progressCurrent=");
            L.append(this.b);
            L.append(", progressMax=");
            return a.j(L, this.c, ")");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.ImageUpload> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Loading(@NotNull List<? extends ImageUpload> list, int i, int i2) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "data");
            this.a = list;
            this.b = i;
            this.c = i2;
        }
    }

    public UploadingState() {
    }

    public UploadingState(j jVar) {
    }
}
