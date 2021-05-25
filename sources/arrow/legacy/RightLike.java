package arrow.legacy;

import kotlin.Deprecated;
import kotlin.Metadata;
@Deprecated(message = "arrow.data.Either is already right biased. This data type will be removed in future releases")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Larrow/legacy/RightLike;", "Larrow/legacy/EitherLike;", "", "isLeft", "()Z", "isRight", "arrow-core"}, k = 1, mv = {1, 4, 0})
public interface RightLike extends EitherLike {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static boolean isLeft(RightLike rightLike) {
            return false;
        }

        public static boolean isRight(RightLike rightLike) {
            return true;
        }
    }

    @Override // arrow.legacy.EitherLike, arrow.legacy.LeftLike
    boolean isLeft();

    @Override // arrow.legacy.EitherLike, arrow.legacy.LeftLike
    boolean isRight();
}
