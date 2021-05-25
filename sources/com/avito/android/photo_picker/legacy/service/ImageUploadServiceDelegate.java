package com.avito.android.photo_picker.legacy.service;

import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Observable;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ/\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegate;", "", "", "operationId", "photoId", "", "uploadAfterNonRestorableError", "Lio/reactivex/Observable;", "Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegate$UploadingEvent;", Tracker.Events.CREATIVE_START, "(Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Observable;", "UploadingEvent", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface ImageUploadServiceDelegate {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegate$UploadingEvent;", "", "<init>", "()V", "Error", "Success", "Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegate$UploadingEvent$Success;", "Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegate$UploadingEvent$Error;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class UploadingEvent {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegate$UploadingEvent$Error;", "Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegate$UploadingEvent;", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Collection;", "getCauses", "()Ljava/util/Collection;", "causes", "<init>", "(Ljava/util/Collection;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends UploadingEvent {
            @NotNull
            public final Collection<Throwable> a;

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<? extends java.lang.Throwable> */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull Collection<? extends Throwable> collection) {
                super(null);
                Intrinsics.checkNotNullParameter(collection, "causes");
                this.a = collection;
            }

            @NotNull
            public final Collection<Throwable> getCauses() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegate$UploadingEvent$Success;", "Lcom/avito/android/photo_picker/legacy/service/ImageUploadServiceDelegate$UploadingEvent;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
        public static final class Success extends UploadingEvent {
            public Success() {
                super(null);
            }
        }

        public UploadingEvent() {
        }

        public UploadingEvent(j jVar) {
        }
    }

    @NotNull
    Observable<UploadingEvent> start(@NotNull String str, @Nullable String str2, boolean z);
}
