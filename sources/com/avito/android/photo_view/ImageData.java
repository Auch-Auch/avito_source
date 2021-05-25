package com.avito.android.photo_view;

import a2.b.a.a.a;
import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u000eR\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/photo_view/ImageData;", "", "", "getId", "()Ljava/lang/String;", "id", "Lcom/avito/android/photo_view/ImageData$State;", "getState", "()Lcom/avito/android/photo_view/ImageData$State;", "state", "Landroid/net/Uri;", "getLocalUri", "()Landroid/net/Uri;", "localUri", "State", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public interface ImageData {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/photo_view/ImageData$State;", "", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED, "Error", "Loading", "NotAdded", "photo-view_release"}, k = 1, mv = {1, 4, 2})
    public interface State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_view/ImageData$State$Completed;", "Lcom/avito/android/photo_view/ImageData$State;", "<init>", "()V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
        public static final class Completed implements State {
            @NotNull
            public static final Completed INSTANCE = new Completed();
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/photo_view/ImageData$State$Error;", "Lcom/avito/android/photo_view/ImageData$State;", "", "component1", "()Z", "isRestorable", "copy", "(Z)Lcom/avito/android/photo_view/ImageData$State$Error;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Z", "<init>", "(Z)V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error implements State {
            public final boolean a;

            public Error(boolean z) {
                this.a = z;
            }

            public static /* synthetic */ Error copy$default(Error error, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = error.a;
                }
                return error.copy(z);
            }

            public final boolean component1() {
                return this.a;
            }

            @NotNull
            public final Error copy(boolean z) {
                return new Error(z);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Error) && this.a == ((Error) obj).a;
                }
                return true;
            }

            public int hashCode() {
                boolean z = this.a;
                if (z) {
                    return 1;
                }
                return z ? 1 : 0;
            }

            public final boolean isRestorable() {
                return this.a;
            }

            @NotNull
            public String toString() {
                return a.B(a.L("Error(isRestorable="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_view/ImageData$State$Loading;", "Lcom/avito/android/photo_view/ImageData$State;", "<init>", "()V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading implements State {
            @NotNull
            public static final Loading INSTANCE = new Loading();
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_view/ImageData$State$NotAdded;", "Lcom/avito/android/photo_view/ImageData$State;", "<init>", "()V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
        public static final class NotAdded implements State {
            @NotNull
            public static final NotAdded INSTANCE = new NotAdded();
        }
    }

    @NotNull
    String getId();

    @Nullable
    Uri getLocalUri();

    @NotNull
    State getState();
}
