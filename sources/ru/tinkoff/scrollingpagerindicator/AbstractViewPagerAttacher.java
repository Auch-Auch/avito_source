package ru.tinkoff.scrollingpagerindicator;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;
public abstract class AbstractViewPagerAttacher<T> implements ScrollingPagerIndicator.PagerAttacher<T> {
    public void updateIndicatorOnPagerScrolled(ScrollingPagerIndicator scrollingPagerIndicator, int i, float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        scrollingPagerIndicator.onPageScrolled(i, f);
    }
}
