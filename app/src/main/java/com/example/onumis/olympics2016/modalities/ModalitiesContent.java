package com.example.onumis.olympics2016.modalities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nuno on 13-05-2016.
 */
public class ModalitiesContent {

    public static final Map<String, Modality> ITEM_MAP = new HashMap<String, Modality>();

    static {
        ITEM_MAP.put("1", new Modality("1", "Atletismo", "descrição"));
        ITEM_MAP.put("2", new Modality("2", "Badminton", "descrição"));
        ITEM_MAP.put("3", new Modality("3", "Basquete", "descrição"));
        ITEM_MAP.put("4", new Modality("4", "Boxe", "descrição"));
        ITEM_MAP.put("5", new Modality("5", "Canoagem Slalon", "descrição"));
        ITEM_MAP.put("6", new Modality("6", "Canoagem Velocidade", "descrição"));
        ITEM_MAP.put("7", new Modality("7", "Ciclismo BMX", "descrição"));
        ITEM_MAP.put("8", new Modality("8", "Ciclismo de Estrada", "descrição"));
        ITEM_MAP.put("9", new Modality("9", "Ciclismo Montain bike", "descrição"));
        ITEM_MAP.put("10", new Modality("10", "Ciclismo Pista", "descrição"));
        ITEM_MAP.put("11", new Modality("11", "Esgrima", "descrição"));
        ITEM_MAP.put("12", new Modality("12", "Futebol", "descrição"));
        ITEM_MAP.put("13", new Modality("13", "Gisnástica artística", "descrição"));
        ITEM_MAP.put("14", new Modality("14", "Ginástica de trampolim", "descrição"));
        ITEM_MAP.put("15", new Modality("15", "Ginástica rítmica", "descrição"));
        ITEM_MAP.put("16", new Modality("16", "Golfe", "descrição"));
        ITEM_MAP.put("17", new Modality("17", "Handebol", "descrição"));
        ITEM_MAP.put("18", new Modality("18", "Hipismo Saltos", "descrição"));
        ITEM_MAP.put("19", new Modality("19", "Hipismo CCE", "descrição"));
        ITEM_MAP.put("20", new Modality("20", "Hipismo Adestramento", "descrição"));
        ITEM_MAP.put("21", new Modality("21", "Hóquei sobre grama", "descrição"));
        ITEM_MAP.put("22", new Modality("22", "Judô", "descrição"));
        ITEM_MAP.put("23", new Modality("23", "Levantamento de peso", "descrição"));
        ITEM_MAP.put("24", new Modality("24", "Luta estilo livre", "descrição"));
        ITEM_MAP.put("25", new Modality("25", "Luta greco-romana", "descrição"));
        ITEM_MAP.put("26", new Modality("26", "Maratonas aquáticas", "descrição"));
        ITEM_MAP.put("27", new Modality("27", "Nado sincronizado", "descrição"));
        ITEM_MAP.put("28", new Modality("28", "Natação", "descrição"));
        ITEM_MAP.put("29", new Modality("29", "Pentatlo Moderno", "descrição"));
        ITEM_MAP.put("30", new Modality("30", "Polo Aquático", "descrição"));
        ITEM_MAP.put("31", new Modality("31", "Remo", "descrição"));
        ITEM_MAP.put("32", new Modality("32", "Rugbi", "descrição"));
        ITEM_MAP.put("33", new Modality("33", "Saltos ornamentais", "descrição"));
        ITEM_MAP.put("34", new Modality("34", "Taekwondo", "descrição"));
        ITEM_MAP.put("35", new Modality("35", "Têni", "descrição"));
        ITEM_MAP.put("36", new Modality("36", "Tênis de mesa", "descrição"));
        ITEM_MAP.put("37", new Modality("37", "Tiro com arco", "descrição"));
        ITEM_MAP.put("38", new Modality("38", "Tiro esportivo", "descrição"));
        ITEM_MAP.put("39", new Modality("39", "Triatlo", "descrição"));
        ITEM_MAP.put("40", new Modality("40", "Vela", "descrição"));
        ITEM_MAP.put("41", new Modality("41", "Vôlei", "descrição"));
        ITEM_MAP.put("42", new Modality("42", "Volei de praia", "descrição"));

    }

    public static class Modality {
        public final String id;
        public final String name;
        public final String details;

        public Modality(String id, String name, String details) {
            this.id = id;
            this.name = name;
            this.details = details;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
