package com.example.onumis.olympics2016.news;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nuno on 14-05-2016.
 */
public class NewsContent {

    public static final Map<String, News> ITEM_MAP = new HashMap<String, News>();

    static {
        ITEM_MAP.put("1", new News("1", "Lorem Ipsum", "Lorem Ipsum is simply dummy text Lorem Ipsum is simply dummy text Lorem Ipsum is simply dummy text Lorem Ipsum is simply dummy text Lorem Ipsum is simply dummy text Lorem Ipsum is simply dummy text"));
        ITEM_MAP.put("2", new News("2", "Lorem Ipsum", "Lorem Ipsum is simply dummy text"));
        ITEM_MAP.put("3", new News("3", "Lorem Ipsum", "Lorem Ipsum is simply dummy text"));
    }

    public static class News {
        public final String id;
        public final String title;
        public final String text;

        public News(String id, String title, String text) {
            this.id = id;
            this.title = title;
            this.text = text;
        }

        @Override
        public String toString() {
            return title;
        }
    }


}
