package com.guna.searchviewexample.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample title for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    public static void addItem(DummyItem item) {
        ITEMS.add(item);
    }

    public static void clearItem() {
        ITEMS.clear();
    }

    /**
     * A dummy item representing a piece of title.
     */
    public static class DummyItem {
        public String title;
        public String description;

        public DummyItem(String title, String description) {
            this.title = title;
            this.description = description;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}