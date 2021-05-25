package com.avito.android.call_feedback.di;

import android.app.Activity;
import com.avito.android.call_feedback.CallFeedbackActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/call_feedback/di/CallFeedbackComponent;", "", "Lcom/avito/android/call_feedback/CallFeedbackActivity;", "activity", "", "inject", "(Lcom/avito/android/call_feedback/CallFeedbackActivity;)V", "Builder", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {CallFeedbackDependencies.class}, modules = {CallFeedbackModule.class})
@PerActivity
public interface CallFeedbackComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/call_feedback/di/CallFeedbackComponent$Builder;", "", "Lcom/avito/android/call_feedback/di/CallFeedbackDependencies;", "dependencies", "(Lcom/avito/android/call_feedback/di/CallFeedbackDependencies;)Lcom/avito/android/call_feedback/di/CallFeedbackComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/call_feedback/di/CallFeedbackComponent$Builder;", "", "callId", "withCallId", "(Ljava/lang/String;)Lcom/avito/android/call_feedback/di/CallFeedbackComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/call_feedback/di/CallFeedbackComponent$Builder;", "Lcom/avito/android/call_feedback/di/CallFeedbackComponent;", "build", "()Lcom/avito/android/call_feedback/di/CallFeedbackComponent;", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        CallFeedbackComponent build();

        @NotNull
        Builder dependencies(@NotNull CallFeedbackDependencies callFeedbackDependencies);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withCallId(@NotNull String str);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Kundle kundle);
    }

    void inject(@NotNull CallFeedbackActivity callFeedbackActivity);
}
