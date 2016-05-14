package com.example.onumis.olympics2016.athletes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nuno on 14-05-2016.
 */
public class AthletesContent {
    public static final Map<String, Athlete> ITEM_MAP = new HashMap<String, Athlete>();

    static {
        ITEM_MAP.put("1", new Athlete("1", "João", "biografia do atleta...", 22, "0"));
        ITEM_MAP.put("2", new Athlete("2", "José", "biografia do atleta...", 22, "1"));
        ITEM_MAP.put("3", new Athlete("3", "Josefino", "biografia do atleta...", 22, "2"));
        ITEM_MAP.put("4", new Athlete("4", "Joaquim", "biografia do atleta...", 22, "3"));
        ITEM_MAP.put("5", new Athlete("5", "João Pedro", "biografia do atleta...", 22, "4"));
        ITEM_MAP.put("6", new Athlete("6", "João Maria", "biografia do atleta...", 22, "5"));
        ITEM_MAP.put("7", new Athlete("7", "Joãozinho", "biografia do atleta...", 22, "6"));
    }

    public static class Athlete {
        public final String id;
        public final String name;
        public final String bio;
        public final Integer age;
        public final String modality_id;

        public Athlete(String id, String name, String bio, Integer age, String modality_id) {
            this.id = id;
            this.name = name;
            this.bio = bio;
            this.age = age;
            this.modality_id = modality_id;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
