package com.yarolegovich.discretescrollview;

import android.graphics.Point;
import android.view.View;
public enum DSVOrientation {
    HORIZONTAL {
        @Override // com.yarolegovich.discretescrollview.DSVOrientation
        public c a() {
            return new HorizontalHelper();
        }
    },
    VERTICAL {
        @Override // com.yarolegovich.discretescrollview.DSVOrientation
        public c a() {
            return new VerticalHelper();
        }
    };

    public static class HorizontalHelper implements c {
        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public boolean canScrollHorizontally() {
            return true;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public boolean canScrollVertically() {
            return false;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public float getDistanceFromCenter(Point point, int i, int i2) {
            return (float) (i - point.x);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public int getDistanceToChangeCurrent(int i, int i2) {
            return i;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public int getFlingVelocity(int i, int i2) {
            return i;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public int getPendingDx(int i) {
            return i;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public int getPendingDy(int i) {
            return 0;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public int getViewEnd(int i, int i2) {
            return i;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public boolean hasNewBecomeVisible(DiscreteScrollLayoutManager discreteScrollLayoutManager) {
            View s = discreteScrollLayoutManager.s();
            View t = discreteScrollLayoutManager.t();
            int i = -discreteScrollLayoutManager.x;
            int width = discreteScrollLayoutManager.getWidth() + discreteScrollLayoutManager.x;
            boolean z = discreteScrollLayoutManager.getDecoratedLeft(s) > i && discreteScrollLayoutManager.getPosition(s) > 0;
            boolean z2 = discreteScrollLayoutManager.getDecoratedRight(t) < width && discreteScrollLayoutManager.getPosition(t) < discreteScrollLayoutManager.getItemCount() - 1;
            if (z || z2) {
                return true;
            }
            return false;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public boolean isViewVisible(Point point, int i, int i2, int i3, int i4) {
            int i5 = point.x;
            return i5 - i < i3 + i4 && i5 + i > (-i4);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public void offsetChildren(int i, RecyclerViewProxy recyclerViewProxy) {
            recyclerViewProxy.offsetChildrenHorizontal(i);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public void setCurrentViewCenter(Point point, int i, Point point2) {
            point2.set(point.x - i, point.y);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public void shiftViewCenter(a2.v.a.a aVar, int i, Point point) {
            point.set(aVar.a(i) + point.x, point.y);
        }
    }

    public static class VerticalHelper implements c {
        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public boolean canScrollHorizontally() {
            return false;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public boolean canScrollVertically() {
            return true;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public float getDistanceFromCenter(Point point, int i, int i2) {
            return (float) (i2 - point.y);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public int getDistanceToChangeCurrent(int i, int i2) {
            return i2;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public int getFlingVelocity(int i, int i2) {
            return i2;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public int getPendingDx(int i) {
            return 0;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public int getPendingDy(int i) {
            return i;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public int getViewEnd(int i, int i2) {
            return i2;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public boolean hasNewBecomeVisible(DiscreteScrollLayoutManager discreteScrollLayoutManager) {
            View s = discreteScrollLayoutManager.s();
            View t = discreteScrollLayoutManager.t();
            int i = -discreteScrollLayoutManager.x;
            int height = discreteScrollLayoutManager.getHeight() + discreteScrollLayoutManager.x;
            boolean z = discreteScrollLayoutManager.getDecoratedTop(s) > i && discreteScrollLayoutManager.getPosition(s) > 0;
            boolean z2 = discreteScrollLayoutManager.getDecoratedBottom(t) < height && discreteScrollLayoutManager.getPosition(t) < discreteScrollLayoutManager.getItemCount() - 1;
            if (z || z2) {
                return true;
            }
            return false;
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public boolean isViewVisible(Point point, int i, int i2, int i3, int i4) {
            int i5 = point.y;
            return i5 - i2 < i3 + i4 && i5 + i2 > (-i4);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public void offsetChildren(int i, RecyclerViewProxy recyclerViewProxy) {
            recyclerViewProxy.offsetChildrenVertical(i);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public void setCurrentViewCenter(Point point, int i, Point point2) {
            point2.set(point.x, point.y - i);
        }

        @Override // com.yarolegovich.discretescrollview.DSVOrientation.c
        public void shiftViewCenter(a2.v.a.a aVar, int i, Point point) {
            int i2 = point.y;
            point.set(point.x, aVar.a(i) + i2);
        }
    }

    public interface c {
        boolean canScrollHorizontally();

        boolean canScrollVertically();

        float getDistanceFromCenter(Point point, int i, int i2);

        int getDistanceToChangeCurrent(int i, int i2);

        int getFlingVelocity(int i, int i2);

        int getPendingDx(int i);

        int getPendingDy(int i);

        int getViewEnd(int i, int i2);

        boolean hasNewBecomeVisible(DiscreteScrollLayoutManager discreteScrollLayoutManager);

        boolean isViewVisible(Point point, int i, int i2, int i3, int i4);

        void offsetChildren(int i, RecyclerViewProxy recyclerViewProxy);

        void setCurrentViewCenter(Point point, int i, Point point2);

        void shiftViewCenter(a2.v.a.a aVar, int i, Point point);
    }

    /* access modifiers changed from: public */
    DSVOrientation(a aVar) {
    }

    public abstract c a();
}
