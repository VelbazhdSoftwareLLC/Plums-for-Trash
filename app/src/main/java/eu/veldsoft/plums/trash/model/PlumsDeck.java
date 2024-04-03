package eu.veldsoft.plums.trash.model;

import java.util.List;

/**
 * Deck with cards holding plums.
 */
class PlumsDeck extends Deck {
    PlumsDeck() {
        super();

        CARDS = List.<Card>of(
                new PlumCard(2, PaperContainer.class, PaperContainer.class),
                new PlumCard(2, OrganicContainer.class, OrganicContainer.class),
                new PlumCard(2, GlassContainer.class, GlassContainer.class),
                new PlumCard(2, PaperContainer.class, GlassContainer.class),
                new PlumCard(2, PaperContainer.class, PlasticContainer.class),
                new PlumCard(3, PaperContainer.class, PaperContainer.class, PaperContainer.class),
                new PlumCard(3, OrganicContainer.class, OrganicContainer.class, GlassContainer.class),
                new PlumCard(3, GlassContainer.class, GlassContainer.class, PlasticContainer.class),
                new PlumCard(3, OrganicContainer.class, PaperContainer.class, PlasticContainer.class),
                new PlumCard(4, OrganicContainer.class, PlasticContainer.class, PaperContainer.class, GlassContainer.class),
                new PlumCard(4, PlasticContainer.class, PlasticContainer.class, PaperContainer.class, OrganicContainer.class),
                new PlumCard(4, GlassContainer.class, OrganicContainer.class, OrganicContainer.class, PlasticContainer.class),
                new PlumCard(5, PaperContainer.class, PaperContainer.class, GlassContainer.class, PlasticContainer.class, PlasticContainer.class),
                new PlumCard(5, OrganicContainer.class, OrganicContainer.class, GlassContainer.class, PaperContainer.class, PlasticContainer.class),
                new PlumCard(6, GlassContainer.class, GlassContainer.class, OrganicContainer.class, PaperContainer.class, PlasticContainer.class, PlasticContainer.class)
        );
    }
}
