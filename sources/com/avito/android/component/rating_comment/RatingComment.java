package com.avito.android.component.rating_comment;

import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.Sort;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0010\u0010\u0006J\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0012\u0010\u0006J\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0014\u0010\u0006J\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/avito/android/component/rating_comment/RatingComment;", "", "", "name", "", "setName", "(Ljava/lang/CharSequence;)V", "", "score", "setRating", "(F)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "message", "setMessage", ErrorBundle.SUMMARY_ENTRY, "setSummary", Sort.DATE, "setPublicationDate", "show", "()V", "hide", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface RatingComment {
    void hide();

    void setAvatar(@Nullable Picture picture);

    void setMessage(@Nullable CharSequence charSequence);

    void setName(@NotNull CharSequence charSequence);

    void setPublicationDate(@Nullable CharSequence charSequence);

    void setRating(float f);

    void setSummary(@Nullable CharSequence charSequence);

    void show();
}
