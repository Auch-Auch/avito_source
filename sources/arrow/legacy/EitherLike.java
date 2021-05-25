package arrow.legacy;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Larrow/legacy/EitherLike;", "", "", "isLeft", "()Z", "isRight", "arrow-core"}, k = 1, mv = {1, 4, 0})
public interface EitherLike {
    @Override // arrow.legacy.LeftLike
    boolean isLeft();

    @Override // arrow.legacy.LeftLike
    boolean isRight();
}
