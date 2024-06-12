package eu.veldsoft.plums.trash.model;

import java.util.List;

/**
 * Deck with cards holding plums.
 */
class PlumsDeck extends Deck {
    /**
     * Constructor without parameters.
     */
    PlumsDeck() {
        super();

        CARDS = List.<Card>of(
                new PlumCard("quest_v5_en_14", 2, PaperContainer.class, PaperContainer.class),
                new PlumCard("quest_v5_en_15", 2, OrganicContainer.class, OrganicContainer.class),
                new PlumCard("quest_v5_en_16", 2, GlassContainer.class, GlassContainer.class),
                new PlumCard("quest_v5_en_13", 2, PaperContainer.class, GlassContainer.class),
                new PlumCard("quest_v5_en_12", 2, PaperContainer.class, PlasticContainer.class),
                new PlumCard("quest_v5_en_09", 3, PaperContainer.class, PaperContainer.class, PaperContainer.class),
                new PlumCard("quest_v5_en_11", 3, OrganicContainer.class, OrganicContainer.class, GlassContainer.class),
                new PlumCard("quest_v5_en_10", 3, GlassContainer.class, GlassContainer.class, PlasticContainer.class),
                new PlumCard("quest_v5_en_08", 3, OrganicContainer.class, PaperContainer.class, PlasticContainer.class),
                new PlumCard("quest_v5_en_06", 4, OrganicContainer.class, PlasticContainer.class, PaperContainer.class, GlassContainer.class),
                new PlumCard("quest_v5_en_07", 4, PlasticContainer.class, PlasticContainer.class, PaperContainer.class, OrganicContainer.class),
                new PlumCard("quest_v5_en_05", 4, GlassContainer.class, OrganicContainer.class, OrganicContainer.class, PlasticContainer.class),
                new PlumCard("quest_v5_en_04", 5, PaperContainer.class, PaperContainer.class, GlassContainer.class, PlasticContainer.class, PlasticContainer.class),
                new PlumCard("quest_v5_en_03", 5, OrganicContainer.class, OrganicContainer.class, GlassContainer.class, PaperContainer.class, PlasticContainer.class),
                new PlumCard("quest_v5_en_02", 6, GlassContainer.class, GlassContainer.class, OrganicContainer.class, PaperContainer.class, PlasticContainer.class, PlasticContainer.class)
        );
    }
}
