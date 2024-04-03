package eu.veldsoft.plums.trash.model;

import java.util.List;

/**
 * Deck with cards for the dump.
 */
class DumpDeck extends Deck {
    DumpDeck() {
        super();

        CARDS = List.<Card>of(
                new PlumCard(1),
                new PlumCard(1),
                new PlumCard(1),
                new PlasticCard(),
                new PlasticCard(),
                new PlasticCard(),
                new PlasticCard(),
                new PlasticCard(),
                new PlasticCard(),
                new PlasticCard(),
                new PlasticCard(),
                new PlasticCard(),
                new PlasticCard(),
                new PlasticCard(),
                new PlasticCard(),
                new GlassCard(),
                new GlassCard(),
                new GlassCard(),
                new GlassCard(),
                new GlassCard(),
                new GlassCard(),
                new GlassCard(),
                new GlassCard(),
                new GlassCard(),
                new GlassCard(),
                new GlassCard(),
                new GlassCard(),
                new OrganicCard(),
                new OrganicCard(),
                new OrganicCard(),
                new OrganicCard(),
                new OrganicCard(),
                new OrganicCard(),
                new OrganicCard(),
                new OrganicCard(),
                new OrganicCard(),
                new OrganicCard(),
                new OrganicCard(),
                new OrganicCard(),
                new MixedCard(PaperContainer.class, OrganicContainer.class),
                new MixedCard(PaperContainer.class, PlasticContainer.class),
                new MixedCard(PlasticContainer.class, OrganicContainer.class),
                new MixedCard(PaperContainer.class, GlassContainer.class),
                new MixedCard(GlassContainer.class, OrganicContainer.class),
                new MixedCard(GlassContainer.class, PlasticContainer.class),
                new MessCard(),
                new MessCard(),
                new MessCard(),
                new MagnetCard(OrganicContainer.class, GlassContainer.class),
                new MagnetCard(PaperContainer.class, PlasticContainer.class),
                new MagnetCard(PaperContainer.class, PlasticContainer.class, OrganicContainer.class, GlassContainer.class),
                new BonusCard(),
                new BonusCard(),
                new BonusCard(),
                new ExchangeCard(),
                new ExchangeCard(),
                new ExchangeCard()

        );
    }
}
