package com.avito.android.publish.input_vin.di;

import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.progress_overlay.ProgressDialogRouter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.DialogRouter;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/publish/input_vin/di/InputVinDependencies;", "", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "()Lcom/avito/android/server_time/TimeSource;", "Ljava/util/Locale;", "locale", "()Ljava/util/Locale;", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "()Lcom/avito/android/util/DialogRouter;", "Lcom/avito/android/progress_overlay/ProgressDialogRouter;", "progressDialogRouter", "()Lcom/avito/android/progress_overlay/ProgressDialogRouter;", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "()Lcom/avito/android/html_formatter/HtmlCleaner;", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "()Lcom/avito/android/html_formatter/HtmlNodeFactory;", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface InputVinDependencies {
    @NotNull
    DialogRouter dialogRouter();

    @Override // com.avito.android.publish.details.di.PublishDetailsDependencies
    @NotNull
    HtmlCleaner htmlCleaner();

    @NotNull
    HtmlNodeFactory htmlNodeFactory();

    @NotNull
    Locale locale();

    @NotNull
    ProgressDialogRouter progressDialogRouter();

    @NotNull
    TimeSource timeSource();
}
