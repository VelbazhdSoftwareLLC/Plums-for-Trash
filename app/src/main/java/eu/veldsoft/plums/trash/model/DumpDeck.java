package eu.veldsoft.plums.trash.model;

import java.util.List;

/**
 * Deck with cards for the dump.
 */
class DumpDeck extends Deck {
    /**
     * Constructor without parameters.
     */
    DumpDeck() {
        super();

        CARDS = List.<Card>of(
                new PlumCard("garbage_cards_v6_62", 1),
                new PlumCard("garbage_cards_v6_63", 1),
                new PlumCard("garbage_cards_v6_64", 1),
                new PlasticCard("garbage_cards_v6_38"),
                new PlasticCard("garbage_cards_v6_39"),
                new PlasticCard("garbage_cards_v6_40"),
                new PlasticCard("garbage_cards_v6_41"),
                new PlasticCard("garbage_cards_v6_42"),
                new PlasticCard("garbage_cards_v6_43"),
                new PlasticCard("garbage_cards_v6_44"),
                new PlasticCard("garbage_cards_v6_45"),
                new PlasticCard("garbage_cards_v6_46"),
                new PlasticCard("garbage_cards_v6_47"),
                new PlasticCard("garbage_cards_v6_48"),
                new PlasticCard("garbage_cards_v6_49"),
                new GlassCard("garbage_cards_v6_26"),
                new GlassCard("garbage_cards_v6_27"),
                new GlassCard("garbage_cards_v6_28"),
                new GlassCard("garbage_cards_v6_29"),
                new GlassCard("garbage_cards_v6_30"),
                new GlassCard("garbage_cards_v6_31"),
                new GlassCard("garbage_cards_v6_32"),
                new GlassCard("garbage_cards_v6_33"),
                new GlassCard("garbage_cards_v6_34"),
                new GlassCard("garbage_cards_v6_35"),
                new GlassCard("garbage_cards_v6_36"),
                new GlassCard("garbage_cards_v6_37"),
                new OrganicCard("garbage_cards_v6_02"),
                new OrganicCard("garbage_cards_v6_03"),
                new OrganicCard("garbage_cards_v6_04"),
                new OrganicCard("garbage_cards_v6_05"),
                new OrganicCard("garbage_cards_v6_06"),
                new OrganicCard("garbage_cards_v6_07"),
                new OrganicCard("garbage_cards_v6_08"),
                new OrganicCard("garbage_cards_v6_09"),
                new OrganicCard("garbage_cards_v6_10"),
                new OrganicCard("garbage_cards_v6_11"),
                new OrganicCard("garbage_cards_v6_12"),
                new OrganicCard("garbage_cards_v6_13"),
                new MixedCard("garbage_cards_v6_51", PaperContainer.class, OrganicContainer.class),
                new MixedCard("garbage_cards_v6_52", PaperContainer.class, PlasticContainer.class),
                new MixedCard("garbage_cards_v6_54", PlasticContainer.class, OrganicContainer.class),
                new MixedCard("garbage_cards_v6_55", PaperContainer.class, GlassContainer.class),
                new MixedCard("garbage_cards_v6_53", GlassContainer.class, OrganicContainer.class),
                new MixedCard("garbage_cards_v6_50", GlassContainer.class, PlasticContainer.class),
                new MessCard("garbage_cards_v6_59"),
                new MessCard("garbage_cards_v6_60"),
                new MessCard("garbage_cards_v6_61"),
                new MagnetCard("garbage_cards_v6_68", OrganicContainer.class, GlassContainer.class),
                new MagnetCard("garbage_cards_v6_69", PaperContainer.class, PlasticContainer.class),
                new MagnetCard("garbage_cards_v6_70", PaperContainer.class, PlasticContainer.class, OrganicContainer.class, GlassContainer.class),
                new BonusCard("garbage_cards_v6_56"),
                new BonusCard("garbage_cards_v6_57"),
                new BonusCard("garbage_cards_v6_58"),
                new ExchangeCard("garbage_cards_v6_65"),
                new ExchangeCard("garbage_cards_v6_66"),
                new ExchangeCard("garbage_cards_v6_67")
        );
    }
}
