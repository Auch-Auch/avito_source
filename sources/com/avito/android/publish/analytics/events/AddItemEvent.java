package com.avito.android.publish.analytics.events;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.analytics_firebase.FirebaseEvent;
import com.avito.android.analytics_firebase.FirebaseEventTracker;
import com.avito.android.analytics_firebase.SimpleFirebaseEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.n.q;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/publish/analytics/events/AddItemEvent;", "", "<init>", "()V", "CategoryButtonClick", "FinishPublish", "PublishButtonClick", "ShowContactsScreen", "Lcom/avito/android/publish/analytics/events/AddItemEvent$PublishButtonClick;", "Lcom/avito/android/publish/analytics/events/AddItemEvent$CategoryButtonClick;", "Lcom/avito/android/publish/analytics/events/AddItemEvent$ShowContactsScreen;", "Lcom/avito/android/publish/analytics/events/AddItemEvent$FinishPublish;", "publish_release"}, k = 1, mv = {1, 4, 2})
public abstract class AddItemEvent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/publish/analytics/events/AddItemEvent$CategoryButtonClick;", "Lcom/avito/android/publish/analytics/events/AddItemEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "", "", "", "getFirebaseEventParams", "()Ljava/util/Map;", "firebaseEventParams", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class CategoryButtonClick extends AddItemEvent implements FirebaseEvent {
        public final /* synthetic */ SimpleFirebaseEvent a = new SimpleFirebaseEvent("AddItem", q.mapOf(TuplesKt.to(AnalyticFieldsName.step, ExifInterface.GPS_MEASUREMENT_2D)));

        public CategoryButtonClick() {
            super(null);
        }

        @Override // com.avito.android.analytics_firebase.FirebaseEvent
        public void accept(@NotNull FirebaseEventTracker firebaseEventTracker) {
            Intrinsics.checkNotNullParameter(firebaseEventTracker, "tracker");
            this.a.accept(firebaseEventTracker);
        }

        @Override // com.avito.android.analytics_firebase.FirebaseEvent
        @Nullable
        public Map<String, Object> getFirebaseEventParams() {
            return this.a.getFirebaseEventParams();
        }

        @Override // com.avito.android.analytics_firebase.FirebaseEvent
        @NotNull
        public String getName() {
            return this.a.getName();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/publish/analytics/events/AddItemEvent$FinishPublish;", "Lcom/avito/android/publish/analytics/events/AddItemEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "", "getName", "()Ljava/lang/String;", "name", "", "", "getFirebaseEventParams", "()Ljava/util/Map;", "firebaseEventParams", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class FinishPublish extends AddItemEvent implements FirebaseEvent {
        public final /* synthetic */ SimpleFirebaseEvent a = new SimpleFirebaseEvent("AddItem", q.mapOf(TuplesKt.to(AnalyticFieldsName.step, "4")));

        public FinishPublish() {
            super(null);
        }

        @Override // com.avito.android.analytics_firebase.FirebaseEvent
        public void accept(@NotNull FirebaseEventTracker firebaseEventTracker) {
            Intrinsics.checkNotNullParameter(firebaseEventTracker, "tracker");
            this.a.accept(firebaseEventTracker);
        }

        @Override // com.avito.android.analytics_firebase.FirebaseEvent
        @Nullable
        public Map<String, Object> getFirebaseEventParams() {
            return this.a.getFirebaseEventParams();
        }

        @Override // com.avito.android.analytics_firebase.FirebaseEvent
        @NotNull
        public String getName() {
            return this.a.getName();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/publish/analytics/events/AddItemEvent$PublishButtonClick;", "Lcom/avito/android/publish/analytics/events/AddItemEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "", "getName", "()Ljava/lang/String;", "name", "", "", "getFirebaseEventParams", "()Ljava/util/Map;", "firebaseEventParams", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class PublishButtonClick extends AddItemEvent implements FirebaseEvent {
        public final /* synthetic */ SimpleFirebaseEvent a = new SimpleFirebaseEvent("AddItem", q.mapOf(TuplesKt.to(AnalyticFieldsName.step, "1")));

        public PublishButtonClick() {
            super(null);
        }

        @Override // com.avito.android.analytics_firebase.FirebaseEvent
        public void accept(@NotNull FirebaseEventTracker firebaseEventTracker) {
            Intrinsics.checkNotNullParameter(firebaseEventTracker, "tracker");
            this.a.accept(firebaseEventTracker);
        }

        @Override // com.avito.android.analytics_firebase.FirebaseEvent
        @Nullable
        public Map<String, Object> getFirebaseEventParams() {
            return this.a.getFirebaseEventParams();
        }

        @Override // com.avito.android.analytics_firebase.FirebaseEvent
        @NotNull
        public String getName() {
            return this.a.getName();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\t8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/publish/analytics/events/AddItemEvent$ShowContactsScreen;", "Lcom/avito/android/publish/analytics/events/AddItemEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEvent;", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "", "", "", "getFirebaseEventParams", "()Ljava/util/Map;", "firebaseEventParams", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShowContactsScreen extends AddItemEvent implements FirebaseEvent {
        public final /* synthetic */ SimpleFirebaseEvent a = new SimpleFirebaseEvent("AddItem", q.mapOf(TuplesKt.to(AnalyticFieldsName.step, ExifInterface.GPS_MEASUREMENT_3D)));

        public ShowContactsScreen() {
            super(null);
        }

        @Override // com.avito.android.analytics_firebase.FirebaseEvent
        public void accept(@NotNull FirebaseEventTracker firebaseEventTracker) {
            Intrinsics.checkNotNullParameter(firebaseEventTracker, "tracker");
            this.a.accept(firebaseEventTracker);
        }

        @Override // com.avito.android.analytics_firebase.FirebaseEvent
        @Nullable
        public Map<String, Object> getFirebaseEventParams() {
            return this.a.getFirebaseEventParams();
        }

        @Override // com.avito.android.analytics_firebase.FirebaseEvent
        @NotNull
        public String getName() {
            return this.a.getName();
        }
    }

    public AddItemEvent() {
    }

    public AddItemEvent(j jVar) {
    }
}
