package me.cassayre.florian.netherrail;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Represents an intersection, a portal or a point of interest.
 */
public enum Station {
    NOUVEA(-714, -702, "Nouvéa", StationType.INTERSECTION_AND_PORTAL),
    ZIG_ZAG(-529, -702, "Zig Zag", StationType.INTERSECTION_ONLY),
    PEPINIERE_OUEST(-714, -582, "Pépinière Ouest", StationType.INTERSECTION_AND_PORTAL),
    FJORDS(-529, -823, "Fjords", StationType.INTERSECTION_ONLY),
    FLEURS(-714, -823, "Fleurs", StationType.INTERSECTION_ONLY),
    PEPINIERE_EST(-529, -582, "Pépinière Est", StationType.INTERSECTION_AND_PORTAL),
    PERE_DODUE(-714, -865, "Chez PèreDodue"), PKTEDDYB(-714, -895, "Chez PkTeddyB"),
    PINPINB(-714, -943, "Chez Pinpin'b"), CAMOUIL(-714, -1027, "Chez Camouil"),
    VERTICALE(-714, -1069, "Verticale des fous", StationType.INTERSECTION_ONLY),
    UZINE(-756, -1069, "UZine", StationType.INTERSECTION_AND_PORTAL),
    CARBONE(-570, -1069, "Carbone", StationType.INTERSECTION_ONLY),
    SIGICOAL_TITAN(-570, -1002, "Sigicoal Titan", StationType.INTERSECTION_AND_PORTAL),
    RESERVE(-341, -702, "Réserve de chasse", StationType.INTERSECTION_AND_PORTAL),
    PUMPKIN_VINES(-714, -1306, "Pumpkin Vines"), KRAVEN(-714, -1222, "Kraven", StationType.INTERSECTION_AND_PORTAL),
    MIDNIGHT_CITY(-714, -1200, "Midnight City"),
    CHESNATOWN(-714, -1351, "Chesnatown", StationType.INTERSECTION_AND_PORTAL),
    SEPTENTRION_OCCIDENTAL(-714, -1436, "Bout Septentrional du monde", StationType.INTERSECTION_ONLY),
    PIC_MARECAGE(-779, -1436, "Pic du marécage", StationType.INTERSECTION_AND_PORTAL),
    TARDIS(-800, -1435, "T.A.R.D.I.S", StationType.INTERSECTION_AND_PORTAL),
    TOUR_KIFEPEUR(-714, -1507, "La Tour Kifépeur", StationType.INTERSECTION_AND_PORTAL),
    VEKTOR(-714, -1585, "Chez Vektor", StationType.INTERSECTION_AND_PORTAL),
    PIERIRO_BILLGATESARDECHE(-714, -1633, "Chez Pieriro et BillGatesardeche", StationType.INTERSECTION_AND_PORTAL),
    HURLENEIGE(-540, -1436, "Hurleneige", StationType.INTERSECTION_AND_PORTAL),
    FROSTBORN_CANYON(-485, -1436, "Frostborn Canyon", StationType.INTERSECTION_ONLY),
    VOYAGE_ECLAIR(-485, -1675, "Voyage-Éclair (Sanctuary)", StationType.INTERSECTION_AND_PORTAL),
    GARDIENS(-413, -1436, "Chute de gardiens", StationType.INTERSECTION_AND_PORTAL),
    FORET_COUVERTE(-570, -1129, "Forêt couverte et Marais montagneux"),
    BASTION_DU_CACTUS_GIVRE(-714, -451, "Bastion du cactus givré"), MOINTAGNE(-714, -397, "Mointagne"),
    ISLA_NUBLAR(-529, -520, "Isla Nublar"), COLLINE_BOULEAUX(-485, -853, "Colline des bouleaux géants"),
    AEROPORT(-436, -853, "Aéroport"), SOURCE(-419, -853, "Source miraculeuse", StationType.INTERSECTION_AND_PORTAL),
    ELERIA(-341, -823, "Eléria", StationType.INTERSECTION_AND_PORTAL), SORCIERES(-341, -871, "Usine à sorcières"),
    ATLANTIS(-341, -913, "Atlantis", StationType.INTERSECTION_AND_PORTAL), ENGORIA(-341, -961, "Engoria"),
    DOGGO(-341, -1015, "République Souterraine Doggo"), BOREE(-234, -1436, "Borée", StationType.INTERSECTION_ONLY),
    KERSUB(-414, -1700, "Kersub", StationType.INTERSECTION_AND_PORTAL),
    GHAST(-341, -1069, "Ghast taquin", StationType.INTERSECTION_ONLY), MOREA(-473, -1069, "Îles de la Moréa"),
    PIC_ASSAUT(-234, -1069, "Pic Assaut", StationType.INTERSECTION_ONLY), ILE_FLEURS(-234, -1130, "Île aux fleurs"),
    WITHER(-234, -1232, "Lande du Wither", StationType.INTERSECTION_AND_PORTAL),
    CREVASSES(-234, -1315, "Croisée des crevasses"), LAC_AMOUREUX(-234, -1351, "Lac des amoureux"),
    SEPTENTRION(30, -1436, "Septentrion", StationType.INTERSECTION_AND_PORTAL),
    TENTACLES(206, -1436, "Tentaclès", StationType.INTERSECTION_AND_PORTAL),
    NEVRESTIR(30, -1366, "Nevrestir", StationType.PORTAL_ONLY),
    FERME_COMTOISE(30, -1321, "Ferme comtoise", StationType.INTERSECTION_AND_PORTAL),
    MESAPLAYA(30, -1278, "Mesaplaya", StationType.INTERSECTION_AND_PORTAL),
    RIVE_BLANCHE(30, -1207, "Rive Blanche", StationType.INTERSECTION_AND_PORTAL),
    FALAISIE(30, -1069, "Falaisie", StationType.INTERSECTION_ONLY),
    TUX(108, -1069, "Tux concursus", StationType.INTERSECTION_AND_PORTAL), PIC_MORIPLAY(195, -1069, "Pic Moriplay"),
    CHESLAND(275, -1069, "Chesland", StationType.INTERSECTION_AND_PORTAL),
    SAINT_KEHAINSYS(540, -1069, "Saint-Kéhainsys", StationType.INTERSECTION_ONLY),
    CHASSEUR(540, -1160, "Chasseur", StationType.INTERSECTION_ONLY),
    PLATYPUS(570, -1160, "Platypus", StationType.INTERSECTION_AND_PORTAL),
    WITHER_DESAFFECTE(430, -1160, "Wither desaffecté", StationType.INTERSECTION_AND_PORTAL),
    REFUGE_ARCTIQUE(540, -1248, "Refuge Arctique"),
    BASE_MILITAIRE_MEUDON(540, -1275, "Base militaire et château de Meudon"),
    MONTAGNE_SOLITAIRE(540, -1302, "Montagne solitaire"),
    POUTLARD(540, -1391, "Poutlard", StationType.INTERSECTION_AND_PORTAL),
    IVUJIVIK(540, -1363, "Ivujivik", StationType.PORTAL_ONLY),
    NORDET(540, -1436, "Nordet", StationType.INTERSECTION_ONLY),
    D_MONSTRATOR(688, -1677, "D-Monstrator", StationType.INTERSECTION_AND_PORTAL),
    INTERSECT_33(688, -1436, "Intersection", StationType.INTERSECTION_ONLY, true, false),
    CAPITALE_ADMINISTRATIVE_FEDERALE(638, -1436, "Capitale Administrative Fédérale",
            StationType.INTERSECTION_AND_PORTAL),
    GLACIER(-529, -342, "Glacier", StationType.INTERSECTION_AND_PORTAL),
    UNKNOWN_1(-714, -342, "Inconnue", StationType.INTERSECTION_ONLY, true, false),
    NOT_FINISHED_1(-529, -301, "En travaux", StationType.INTERSECTION_ONLY, false, true),
    NOT_FINISHED_2(-714, -301, "En travaux", StationType.INTERSECTION_ONLY, false, true),
    BIRDY(-714, -241, "Palais de Birdy"), CHEZ_SQUALL(-714, -103, "Chez Squall"),
    GRAND_OUEST(-714, 47, "Aiguillage du Grand Ouest", StationType.INTERSECTION_ONLY),
    AMAZONIA(-804, 47, "Amazonia", StationType.INTERSECTION_AND_PORTAL),
    VILLAGE_CORROMPU(-655, 47, "Village corrompu", StationType.INTERSECTION_AND_PORTAL),
    PERE_MORIEL(-621, 47, "Père Moriel", StationType.INTERSECTION_AND_PORTAL),
    SOMONITES(-529, 47, "Désert des Somonites", StationType.INTERSECTION_ONLY),
    FALLEN_KINGDOM(-714, 267, "Fallen Kingdom", StationType.INTERSECTION_AND_PORTAL),
    OCEAN_GAUCHE(-714, 539, "Océan du côté gauche", StationType.INTERSECTION_ONLY), NAILA(-804, 539, "Naila"),
    DEPOT(-529, 539, "Dépôt", StationType.INTERSECTION_ONLY),
    KERLAM(-529, 421, "Kerlam", StationType.INTERSECTION_AND_PORTAL),
    ALEXANDRIE(-529, 292, "Alexandrie", StationType.INTERSECTION_AND_PORTAL), GUET(-529, 598, "Tour de guet"),
    ACADEMIE(-219, -702, "Académie des Mages"), BLAZE_ROAD(-145, -702, "Blaze Road", StationType.INTERSECTION_ONLY),
    MER_ADIEUX(30, -702, "Mer des Adieux", StationType.INTERSECTION_ONLY),
    FERME_VILLAGEOIS(30, -829, "Ferme à Villageois", StationType.INTERSECTION_AND_PORTAL),
    POINT_CENTRAL(30, -863, "Point Central", StationType.INTERSECTION_AND_PORTAL),
    MONUMENT_DE_POINT_CENTRAL(-21, -863, "Monument de Point Central", StationType.INTERSECTION_AND_PORTAL),
    ARCHIPEL_TROPE(142, -863, "Archipel Trope", StationType.INTERSECTION_AND_PORTAL),
    PINK_TOWER(142, -907, "Pink Tower", StationType.INTERSECTION_AND_PORTAL),
    JONCTION(121, -702, "Jonction des continents"), MARAYA(294, -702, "Maraya Toumismo", StationType.INTERSECTION_ONLY),
    SPERANZA_PRISTINE(540, -702, "Speranza Pristine", StationType.INTERSECTION_ONLY),
    COL_AIGUES(540, -780, "Col Aigues", StationType.INTERSECTION_ONLY),
    AIGUES_CHAUDES(668, -780, "Aigues chaudes", StationType.INTERSECTION_AND_PORTAL),
    PICS_PRECIPICES(-234, -1183, "Pics et précipices"),
    VYNCIS(294, -661, "Vyncis", StationType.INTERSECTION_AND_PORTAL), TECI_TARZAN(294, -637, "La téci d'Tarzan"),
    CARTOUME(294, -604, "Cartoume", StationType.INTERSECTION_AND_PORTAL),
    VENICE(294, -529, "Venice", StationType.INTERSECTION_AND_PORTAL),
    PROJETZ(30, -613, "ProjetZ", StationType.INTERSECTION_AND_PORTAL),
    UNKNOWN_2(30, -408, "Inconnue", StationType.INTERSECTION_ONLY, true, false), VILLAGE_MAYA(30, -318, "Village Maya"),
    AIGUILLAGE_BAZAR(30, -301, "Aiguillage du Bazar bizarre", StationType.INTERSECTION_ONLY),
    BAZAR(-113, -301, "Bazar bizarre", StationType.INTERSECTION_AND_PORTAL), WALL_STREET(-144, -301, "Wall Street"),
    CONSTRUCTEURS(212, -408, "Constructeurs de l'extrême", StationType.INTERSECTION_AND_PORTAL),
    UNKNOWN_3(259, -408, "Inconnue", StationType.INTERSECTION_ONLY, true, false),
    UNKNOWN_4(259, -301, "Inconnue", StationType.INTERSECTION_ONLY, true, false),
    UNKNOWN_5(259, -260, "Inconnue", StationType.INTERSECTION_ONLY, true, false),
    ETHERNIA(259, -271, "Ethernia", StationType.INTERSECTION_AND_PORTAL),
    CART_TOON(540, -260, "Cart Toon", StationType.INTERSECTION_ONLY), SPERANZA(518, -702, "Sperenza"),
    ILE_PRISTINE(540, -672, "Île Pristine"), ORDOGRAD(540, -558, "Ordograd", StationType.PORTAL_ONLY),
    CENTRE_SPATIAL(540, -469, "Centre Spatial", StationType.PORTAL_ONLY),
    GOULAG(582, -260, "Goulag et Usine à fer", StationType.INTERSECTION_AND_PORTAL),
    HALDA(684, -260, "Halda", StationType.INTERSECTION_AND_PORTAL),
    TASSE(714, -260, "La tasse", StationType.INTERSECTION_AND_PORTAL),
    EURAZIE(259, 47, "EuraZie", StationType.INTERSECTION_ONLY),
    SECTEUR_GHASTS(295, 47, "Secteur Ghasts", StationType.INTERSECTION_ONLY),
    CLEM(425, 47, "Secteur Clem", StationType.INTERSECTION_ONLY),
    LAPUTA(425, 200, "Laputa", StationType.INTERSECTION_AND_PORTAL),
    MELBURNE(540, 47, "Melburne", StationType.INTERSECTION_ONLY),
    MACCRAGE(30, -202, "Secteur Maccrage", StationType.INTERSECTION_AND_PORTAL),
    BALADE(30, -146, "Balade", StationType.INTERSECTION_AND_PORTAL),
    UNKNOWN_7(30, -120, "Inconnue", StationType.INTERSECTION_ONLY, true, false),
    UNKNOWN_8(148, -120, "Inconnue", StationType.INTERSECTION_ONLY, true, false),
    ARENE_BLAZIQUE(148, -32, "Arène blazique"), FORTERESSE_LOUL(175, -120, "Forteresse de Sire Loul"),
    UNKNOWN_9(30, -94, "Inconnue", StationType.INTERSECTION_ONLY, true, false),
    UNKNOWN_10(148, -94, "Inconnue", StationType.INTERSECTION_ONLY, true, false),
    CITE_SCIENCES(190, -94, "Cité des sciences"), GRAND_TEMPLE(30, -84, "Grand temple de May"),
    COIN_NATURISTES(93, -84, "Le coin des naturistes"), CHEZ_Z(30, -65, "Chez Z"),
    VILLAGE_ELFIQUE(30, -54, "Village elfique"), FORTERESSE_2(30, -41, "Forteresse 2"), FLANGORIA(30, -24, "Flangoria"),
    ATTRACTION(30, -3, "Attractions"), UZINE_COCHON(30, 23, "UZine à cochons"),
    VAALON(30, 47, "Vaalon", StationType.INTERSECTION_AND_PORTAL), MOBY_DICK(89, 47, "New Liberty & Moby Dick"),
    AGRISUB_1(132, 47, "Agrisub I", StationType.INTERSECTION_AND_PORTAL),
    UNKNOWN_11(148, 47, "Inconnue", StationType.INTERSECTION_ONLY, true, false),
    AZIE(221, 47, "Azie", StationType.INTERSECTION_AND_PORTAL), SILVERISLAND(276, 47, "Silverisland"),
    COLLINE_JAMBES(-46, 47, "La colline a des jambes"), GRANDE_LOTTERIE(-73, 47, "La grande lotterie"),
    FORTERESSE_1(-110, 47, "Forteresse 1"), OCTOPUSSY(-129, 47, "Octopussy", StationType.INTERSECTION_AND_PORTAL),
    AIGUILLAGE_CHATEAUNOIR(-251, 47, "Aiguillage Château Noir", StationType.INTERSECTION_ONLY),
    CARROUSEL_HOLERIBUS(-251, 254, "Carrousel Holeribus"),
    UNKNOWN_17(-184, 254, "Inconnue", StationType.INTERSECTION_ONLY, true, false),
    CHATEAU_NOIR(-184, 293, "Château Noir", StationType.INTERSECTION_AND_PORTAL),
    CHATEAU_GLACES(-242, 47, "Château des glaces"), ARRAKIS(-251, 65, "Arrakis"),
    PIXEL_ART(-286, 47, "Pixel Art", StationType.INTERSECTION_ONLY), MUSEE_PIXEL(-286, -93, "Musée du pixel art"),
    BANANEROSE(-361, 47, "Ville de bananerose"),
    CIUDAD(-378, 47, "Ciudad Esmeralda", StationType.INTERSECTION_AND_PORTAL), BLAZES_POINT(-378, -152, "Blazes point"),
    UNKNOWN_12(-341, -1208, "Inconnue", StationType.INTERSECTION_ONLY, true, false),
    USINE_OR(-527, -1208, "Usine à or et à XP"),
    POSEIDOPOLIS_EST(540, 251, "Poseidopolis Est", StationType.INTERSECTION_AND_PORTAL),
    POSEIDOPOLIS(450, 251, "Poseidopolis", StationType.INTERSECTION_AND_PORTAL),
    INTERSECT_34(425, 251, "Intersection", StationType.INTERSECTION_ONLY, true, false),
    ILE_PARADISIAQUE_BOBBIX(540, 366, "Île paradisiaque (Bobbix)", StationType.PORTAL_ONLY),
    SUDET(540, 539, "Sudet", StationType.INTERSECTION_ONLY, false, false),
    CARDINALE_EST(708, 539, "Cardinale Est", StationType.INTERSECTION_AND_PORTAL),
    SURET(540, 600, "Suret", StationType.INTERSECTION_AND_PORTAL),
    USINE_GARDIENS(426, 539, "Usine à gardiens", StationType.INTERSECTION_AND_PORTAL),
    FORTERESSE_MYSTERIEUSE(-132, 539, "Mystérieuse forteresse", StationType.INTERSECTION_AND_PORTAL),
    HASHTAG(-348, 539, "HashTag", StationType.INTERSECTION_AND_PORTAL), ILE_ZACQUES(-480, 539, "Île de Zâcques"),
    UNKNOWN_13(-529, -853, "Inconnue", StationType.INTERSECTION_ONLY, true, false),
    UNKNOWN_14(-234, -1740, "Inconnue", StationType.INTERSECTION_ONLY, true, false),
    UNKNOWN_15(-414, -1740, "Inconnue", StationType.INTERSECTION_ONLY, true, false),
    ILE_VOLCANIQUE(-714, 384, "Île volcanique"), FJORD_SUD(-529, -763, "Fjord Sud"),
    FJORD_CENTRAL(-529, -786, "Fjord Central"), FJORD_NORD(-529, -795, "Fjord Nord"),
    LAGON_DE_FLUM(-575, -823, "Lagon de Flum"), FORTERESSE_DES_FLEURS(-611, -823, "Forteresse des fleurs"),
    FLEURS_CREVASSES(-636, -823, "Des fleurs et des crevasses"), ISLA_SOMA(-529, -680, "Isla Soma"),
    CHEZ_CARANDOOM(-529, -564, "Chez Carandoom"), CHEZ_CANTIN(-529, -403, "Chez Cantin"),
    ISLA_PENA(-431, -702, "Isla Pena"),
    TENTACLES_PORT(158, -1436, "Port-Tentaclès", StationType.INTERSECTION_AND_PORTAL),
    NOT_FINISHED_4(30, -1682, "Station inconnue", StationType.INTERSECTION_AND_PORTAL), // Portail ne menant nulle part
    KAAMELOTT(-234, -1454, "Kaamelott"),
    POMMACROBATICS(-234, -1604, "PommAcrobatics", StationType.INTERSECTION_AND_PORTAL),
    CHEZ_NAGAIWA(-234, -1706, "Chez Nagaiwa"),

    // North Continent (these stations will likely be renamed)

    NORTH_CAPITAL(-276, -2376, "Nouvelle capitale", StationType.INTERSECTION_AND_PORTAL, false, true),
    UNKNOWN_20(-233, -2376, "Intersection", StationType.INTERSECTION_ONLY, true, true),

    // Old foot-based network (so-called « Netherroutes »)

    INTERSECT_18(30, 64, "Intersection", StationType.INTERSECTION_ONLY, true, false), ADELLIA(30, 76, "Adellia"),
    RAZIEL(30, 92, "Raziel"), INTERSECT_19(30, 112, "Intersection", StationType.INTERSECTION_ONLY, true, false),
    FORTERESSE_3(30, 128, "Forteresse 3"), ARBRE_BIBLIOTHEQUE(30, 152, "Arbre bibliothèque"),
    SIGICOAL(30, 189, "Sigicoal III"),

    MORZAN(-40, 64, "Morzan"), SMASTEN(-40, 98, "Smasten"),
    INTERSECT_21(-98, 64, "Intersection", StationType.INTERSECTION_ONLY, true, false),
    JUNGLE_PAUMEE(-98, 117, "Jungle paumée"),

    TAVERNE_BUNKER(22, 112, "Taverne Bunker"),
    INTERSECT_22(22, 140, "Intersection", StationType.INTERSECTION_ONLY, true, false),
    INTERSECT_23(55, 140, "Intersection", StationType.INTERSECTION_ONLY, true, false),
    ELEVAGE_DE_MEUH(155, 140, "Élevage de Meuh"), AMPHIPOLIS(55, 164, "Amphipolis"), REZERVE(55, 184, "RéZerve"),
    INTERSECT_26(55, 206, "Intersection", StationType.INTERSECTION_ONLY, true, false), // ok
    INTERSECT_27(108, 206, "Intersection", StationType.INTERSECTION_ONLY, true, false), // ok
    FOREST_OF_MAGIC_ISLAND(108, 296, "Forest of Magic Island"), ILE_PARADISIAQUE(108, 345, "Île paradisiaque"),
    INTERSECT_30(108, 460, "Intersection", StationType.INTERSECTION_ONLY, true, false),
    MONTAGNES_CREUSES(108, 481, "Montagnes creuses"),
    BAIE_HA_LONG(295, 460, "Baie d'Ha-Long", StationType.INTERSECTION_AND_PORTAL), MASTER_PWEL(343, 460, "Master Pwel"),
    STEP_31(295, 326, "Étape", StationType.INTERSECTION_ONLY, true, true),
    STEP_32(295, 304, "Étape", StationType.INTERSECTION_ONLY, true, true), FORT_BOYAUX(295, 133, "Fort Boyaux"),
    SANATORIUM_VERT(295, 61, "Sanatorium Vert"),

    KASTOU(221, 74, "Kastou"), SWAG_ISLAND(221, 186, "Swag island"),

    TOUR_INFERNALE(259, 164, "Tour Infernale")

    ;

    static {
        register(NOUVEA, FLEURS, ZIG_ZAG, PEPINIERE_OUEST, null); //
        register(ZIG_ZAG, FJORD_SUD, ISLA_PENA, ISLA_SOMA, NOUVEA); //
        register(PEPINIERE_OUEST, NOUVEA, null, BASTION_DU_CACTUS_GIVRE, null); //
        register(FJORDS, UNKNOWN_13, null, FJORD_NORD, LAGON_DE_FLUM); //
        register(LAGON_DE_FLUM, null, FJORDS, null, FORTERESSE_DES_FLEURS); //
        register(FORTERESSE_DES_FLEURS, null, LAGON_DE_FLUM, null, FLEURS_CREVASSES);
        register(FLEURS, PERE_DODUE, FLEURS_CREVASSES, NOUVEA, null); //
        register(PEPINIERE_EST, ISLA_SOMA, null, CHEZ_CARANDOOM, null); //
        register(PERE_DODUE, PKTEDDYB, null, FLEURS, null); //
        register(PKTEDDYB, PINPINB, null, PERE_DODUE, null); //
        register(PINPINB, CAMOUIL, null, PKTEDDYB, null); //
        register(CAMOUIL, VERTICALE, null, PINPINB, null); //
        register(VERTICALE, MIDNIGHT_CITY, CARBONE, CAMOUIL, UZINE); //
        register(UZINE, null, VERTICALE, null, null); //
        register(CARBONE, FORET_COUVERTE, MOREA, SIGICOAL_TITAN, VERTICALE); //
        register(SIGICOAL_TITAN, CARBONE, null, null, null); //
        register(RESERVE, ELERIA, ACADEMIE, null, ISLA_PENA);
        register(MIDNIGHT_CITY, KRAVEN, null, VERTICALE, null); //
        register(KRAVEN, PUMPKIN_VINES, null, MIDNIGHT_CITY, null); //
        register(PUMPKIN_VINES, CHESNATOWN, null, KRAVEN, null); //
        register(CHESNATOWN, SEPTENTRION_OCCIDENTAL, null, PUMPKIN_VINES, null); //
        register(SEPTENTRION_OCCIDENTAL, TOUR_KIFEPEUR, HURLENEIGE, CHESNATOWN, PIC_MARECAGE); //
        register(TOUR_KIFEPEUR, VEKTOR, null, SEPTENTRION_OCCIDENTAL, null);
        register(VEKTOR, PIERIRO_BILLGATESARDECHE, null, TOUR_KIFEPEUR, null);
        register(PIERIRO_BILLGATESARDECHE, null, null, VEKTOR, null);
        register(PIC_MARECAGE, null, SEPTENTRION_OCCIDENTAL, null, TARDIS); //
        register(TARDIS, null, PIC_MARECAGE, null, null); //
        register(HURLENEIGE, null, FROSTBORN_CANYON, null, SEPTENTRION_OCCIDENTAL); //
        register(FROSTBORN_CANYON, VOYAGE_ECLAIR, GARDIENS, null, HURLENEIGE); //
        register(VOYAGE_ECLAIR, null, null, FROSTBORN_CANYON, null); //
        register(GARDIENS, null, BOREE, null, FROSTBORN_CANYON); //
        register(FORET_COUVERTE, null, null, CARBONE, null); //
        register(BASTION_DU_CACTUS_GIVRE, PEPINIERE_OUEST, null, MOINTAGNE, null); //
        register(MOINTAGNE, BASTION_DU_CACTUS_GIVRE, null, UNKNOWN_1, null); //
        register(ISLA_NUBLAR, CHEZ_CARANDOOM, null, CHEZ_CANTIN, null); //
        register(COLLINE_BOULEAUX, null, AEROPORT, null, UNKNOWN_13); //
        register(AEROPORT, null, SOURCE, null, COLLINE_BOULEAUX); //
        register(SOURCE, null, null, null, AEROPORT); //
        register(ELERIA, SORCIERES, null, RESERVE, null); //
        register(SORCIERES, ATLANTIS, null, ELERIA, null); //
        register(ATLANTIS, ENGORIA, null, SORCIERES, null); //
        register(ENGORIA, DOGGO, null, ATLANTIS, null); //
        register(DOGGO, GHAST, null, ENGORIA, null); //
        register(BOREE, KAAMELOTT, SEPTENTRION, LAC_AMOUREUX, GARDIENS); //
        register(KAAMELOTT, POMMACROBATICS, null, BOREE, null); //
        register(POMMACROBATICS, CHEZ_NAGAIWA, null, KAAMELOTT, null); //
        register(CHEZ_NAGAIWA, UNKNOWN_14, null, POMMACROBATICS, null); //
        register(KERSUB, UNKNOWN_15, null, null, null); //
        register(GHAST, UNKNOWN_12, PIC_ASSAUT, DOGGO, MOREA);
        register(MOREA, null, GHAST, null, CARBONE); //
        register(PIC_ASSAUT, ILE_FLEURS, FALAISIE, null, GHAST);
        register(ILE_FLEURS, PICS_PRECIPICES, null, PIC_ASSAUT, null); //
        register(WITHER, CREVASSES, null, PICS_PRECIPICES, null); //
        register(CREVASSES, LAC_AMOUREUX, null, WITHER, null); //
        register(LAC_AMOUREUX, BOREE, null, CREVASSES, null); //
        register(SEPTENTRION, NOT_FINISHED_4, TENTACLES_PORT, NEVRESTIR, BOREE); //
        register(TENTACLES_PORT, null, TENTACLES, null, SEPTENTRION); //
        register(TENTACLES, null, NORDET, null, TENTACLES_PORT); //
        register(NEVRESTIR, SEPTENTRION, null, FERME_COMTOISE, null); //
        register(FERME_COMTOISE, NEVRESTIR, null, MESAPLAYA, null); //
        register(MESAPLAYA, FERME_COMTOISE, null, RIVE_BLANCHE, null); //
        register(RIVE_BLANCHE, MESAPLAYA, null, FALAISIE, null); //
        register(FALAISIE, RIVE_BLANCHE, TUX, POINT_CENTRAL, PIC_ASSAUT);
        register(TUX, null, PIC_MORIPLAY, null, FALAISIE); //
        register(PIC_MORIPLAY, null, CHESLAND, null, TUX); //
        register(CHESLAND, null, SAINT_KEHAINSYS, null, PIC_MORIPLAY); //
        register(SAINT_KEHAINSYS, CHASSEUR, null, COL_AIGUES, CHESLAND);
        register(CHASSEUR, REFUGE_ARCTIQUE, PLATYPUS, SAINT_KEHAINSYS, WITHER_DESAFFECTE); //
        register(WITHER_DESAFFECTE, null, CHASSEUR, null, null); //
        register(PLATYPUS, null, null, null, CHASSEUR); //
        register(REFUGE_ARCTIQUE, BASE_MILITAIRE_MEUDON, null, CHASSEUR, null); //
        register(BASE_MILITAIRE_MEUDON, MONTAGNE_SOLITAIRE, null, REFUGE_ARCTIQUE, null); //
        register(MONTAGNE_SOLITAIRE, IVUJIVIK, null, BASE_MILITAIRE_MEUDON, null); //
        register(IVUJIVIK, POUTLARD, null, MONTAGNE_SOLITAIRE, null); //
        register(POUTLARD, NORDET, null, IVUJIVIK, null); //
        register(NORDET, null, CAPITALE_ADMINISTRATIVE_FEDERALE, POUTLARD, TENTACLES);
        register(CAPITALE_ADMINISTRATIVE_FEDERALE, null, INTERSECT_33, null, NORDET);
        register(INTERSECT_33, D_MONSTRATOR, null, null, CAPITALE_ADMINISTRATIVE_FEDERALE);
        register(D_MONSTRATOR, null, null, INTERSECT_33, null);
        ;
        register(GLACIER, new Station[] { CHEZ_CANTIN, null, NOT_FINISHED_1, UNKNOWN_1 }, new PathType[] {
                PathType.OFFICIAL_RAIL, PathType.OFFICIAL_RAIL, PathType.OFFICIAL_RAIL, PathType.UNOFFICIAL_WALKING });
        register(UNKNOWN_1, new Station[] { MOINTAGNE, GLACIER, NOT_FINISHED_2, null }, new PathType[] {
                PathType.OFFICIAL_RAIL, PathType.UNOFFICIAL_WALKING, PathType.OFFICIAL_RAIL, PathType.OFFICIAL_RAIL });
        register(NOT_FINISHED_1, GLACIER, WALL_STREET, SOMONITES, NOT_FINISHED_2);
        register(NOT_FINISHED_2, UNKNOWN_1, NOT_FINISHED_1, BIRDY, null);
        register(BIRDY, NOT_FINISHED_2, null, CHEZ_SQUALL, null); //
        register(CHEZ_SQUALL, BIRDY, null, GRAND_OUEST, null);
        register(GRAND_OUEST, CHEZ_SQUALL, VILLAGE_CORROMPU, FALLEN_KINGDOM, AMAZONIA);
        register(AMAZONIA, null, GRAND_OUEST, null, null); //
        register(VILLAGE_CORROMPU, null, PERE_MORIEL, null, GRAND_OUEST); //
        register(PERE_MORIEL, null, SOMONITES, null, VILLAGE_CORROMPU); //
        register(SOMONITES, NOT_FINISHED_1, CIUDAD, ALEXANDRIE, PERE_MORIEL);
        register(FALLEN_KINGDOM, GRAND_OUEST, null, ILE_VOLCANIQUE, null); //
        register(OCEAN_GAUCHE, ILE_VOLCANIQUE, DEPOT, null, NAILA); //
        register(NAILA, null, OCEAN_GAUCHE, null, null); //
        register(DEPOT, KERLAM, ILE_ZACQUES, GUET, OCEAN_GAUCHE);
        register(KERLAM, ALEXANDRIE, null, DEPOT, null); //
        register(ALEXANDRIE, SOMONITES, null, KERLAM, null);
        register(ACADEMIE, null, BLAZE_ROAD, null, RESERVE);
        register(BLAZE_ROAD, null, MER_ADIEUX, null, ACADEMIE); //
        register(MER_ADIEUX, FERME_VILLAGEOIS, JONCTION, PROJETZ, BLAZE_ROAD); //
        register(FERME_VILLAGEOIS, POINT_CENTRAL, null, MER_ADIEUX, null); //
        register(POINT_CENTRAL, FALAISIE, ARCHIPEL_TROPE, FERME_VILLAGEOIS, MONUMENT_DE_POINT_CENTRAL); //
        register(MONUMENT_DE_POINT_CENTRAL, null, POINT_CENTRAL, null, null); //
        register(ARCHIPEL_TROPE, PINK_TOWER, null, null, POINT_CENTRAL); //
        register(PINK_TOWER, null, null, ARCHIPEL_TROPE, null); //
        register(GUET, DEPOT, null, null, null); //
        register(JONCTION, null, MARAYA, null, MER_ADIEUX); // ***
        register(MARAYA, null, SPERANZA, VYNCIS, JONCTION);
        register(SPERANZA_PRISTINE, COL_AIGUES, null, ILE_PRISTINE, SPERANZA);
        register(COL_AIGUES, SAINT_KEHAINSYS, AIGUES_CHAUDES, SPERANZA_PRISTINE, null);
        register(AIGUES_CHAUDES, null, null, null, COL_AIGUES);
        register(PICS_PRECIPICES, WITHER, null, ILE_FLEURS, null);
        register(VYNCIS, MARAYA, null, TECI_TARZAN, null);
        register(TECI_TARZAN, VYNCIS, null, CARTOUME, null);
        register(CARTOUME, TECI_TARZAN, null, VENICE, null);
        register(VENICE, CARTOUME, null, null, null);
        register(PROJETZ, MER_ADIEUX, null, UNKNOWN_2, null);
        register(UNKNOWN_2, new Station[] { PROJETZ, CONSTRUCTEURS, VILLAGE_MAYA, null }, new PathType[] {
                PathType.OFFICIAL_RAIL, PathType.OFFICIAL_WALKING, PathType.OFFICIAL_RAIL, PathType.OFFICIAL_RAIL });
        register(VILLAGE_MAYA, UNKNOWN_2, null, AIGUILLAGE_BAZAR, null);
        register(AIGUILLAGE_BAZAR, VILLAGE_MAYA, UNKNOWN_4, MACCRAGE, BAZAR);
        register(BAZAR, null, AIGUILLAGE_BAZAR, null, WALL_STREET);
        register(WALL_STREET, null, BAZAR, null, NOT_FINISHED_1);
        register(CONSTRUCTEURS, new Station[] { null, UNKNOWN_3, null, UNKNOWN_2 }, new PathType[] {
                PathType.OFFICIAL_RAIL, PathType.OFFICIAL_RAIL, PathType.OFFICIAL_RAIL, PathType.OFFICIAL_WALKING });
        register(UNKNOWN_3, null, null, UNKNOWN_4, CONSTRUCTEURS);
        register(UNKNOWN_4, UNKNOWN_3, null, ETHERNIA, AIGUILLAGE_BAZAR);
        register(UNKNOWN_5, new Station[] { ETHERNIA, CART_TOON, EURAZIE, null }, new PathType[] {
                PathType.OFFICIAL_RAIL, PathType.OFFICIAL_RAIL, PathType.OFFICIAL_WALKING, PathType.OFFICIAL_RAIL });
        register(ETHERNIA, UNKNOWN_4, null, UNKNOWN_5, null);
        register(CART_TOON, CENTRE_SPATIAL, GOULAG, MELBURNE, UNKNOWN_5);
        register(CENTRE_SPATIAL, ORDOGRAD, null, CART_TOON, null);
        register(ORDOGRAD, ILE_PRISTINE, null, CENTRE_SPATIAL, null);
        register(SPERANZA, null, SPERANZA_PRISTINE, null, MARAYA);
        register(ILE_PRISTINE, SPERANZA_PRISTINE, null, ORDOGRAD, null);
        register(GOULAG, null, HALDA, null, CART_TOON);
        register(HALDA, null, TASSE, null, GOULAG);
        register(TASSE, null, null, null, HALDA);
        register(EURAZIE, new Station[] { UNKNOWN_5, SILVERISLAND, TOUR_INFERNALE, AZIE }, new PathType[] {
                PathType.OFFICIAL_WALKING, PathType.OFFICIAL_RAIL, PathType.OFFICIAL_WALKING, PathType.OFFICIAL_RAIL }); //
        register(SECTEUR_GHASTS, new Station[] { null, CLEM, SANATORIUM_VERT, SILVERISLAND }, new PathType[] {
                PathType.OFFICIAL_RAIL, PathType.OFFICIAL_RAIL, PathType.OFFICIAL_WALKING, PathType.OFFICIAL_RAIL });
        register(CLEM, new Station[] { null, MELBURNE, LAPUTA, SECTEUR_GHASTS }, new PathType[] {
                PathType.OFFICIAL_RAIL, PathType.OFFICIAL_RAIL, PathType.UNOFFICIAL_RAIL, PathType.OFFICIAL_RAIL });
        register(LAPUTA, new Station[] { CLEM, null, INTERSECT_34, null }, new PathType[] { PathType.UNOFFICIAL_RAIL,
                PathType.OFFICIAL_RAIL, PathType.UNOFFICIAL_RAIL, PathType.OFFICIAL_RAIL });
        register(INTERSECT_34, new Station[] { LAPUTA, POSEIDOPOLIS, null, null }, new PathType[] {
                PathType.UNOFFICIAL_RAIL, PathType.UNOFFICIAL_RAIL, PathType.OFFICIAL_RAIL, PathType.OFFICIAL_RAIL });
        register(POSEIDOPOLIS, new Station[] { null, POSEIDOPOLIS_EST, null, INTERSECT_34 }, new PathType[] {
                PathType.OFFICIAL_RAIL, PathType.OFFICIAL_RAIL, PathType.OFFICIAL_RAIL, PathType.UNOFFICIAL_RAIL });
        register(MELBURNE, CART_TOON, null, POSEIDOPOLIS_EST, CLEM);
        register(MACCRAGE, AIGUILLAGE_BAZAR, null, BALADE, null);
        register(BALADE, MACCRAGE, null, UNKNOWN_7, null);
        register(UNKNOWN_7, BALADE, UNKNOWN_8, UNKNOWN_9, null);
        register(UNKNOWN_8, ARENE_BLAZIQUE, FORTERESSE_LOUL, UNKNOWN_10, UNKNOWN_7);
        register(ARENE_BLAZIQUE, null, null, UNKNOWN_8, null);
        register(FORTERESSE_LOUL, null, null, null, UNKNOWN_8);
        register(UNKNOWN_9, UNKNOWN_7, UNKNOWN_10, GRAND_TEMPLE, null);
        register(UNKNOWN_10, UNKNOWN_8, CITE_SCIENCES, null, UNKNOWN_9);
        register(CITE_SCIENCES, null, null, null, UNKNOWN_10);
        register(GRAND_TEMPLE, UNKNOWN_9, COIN_NATURISTES, CHEZ_Z, null);
        register(COIN_NATURISTES, null, null, null, GRAND_TEMPLE);
        register(CHEZ_Z, GRAND_TEMPLE, null, VILLAGE_ELFIQUE, null);
        register(VILLAGE_ELFIQUE, CHEZ_Z, null, FORTERESSE_2, null);
        register(FORTERESSE_2, VILLAGE_ELFIQUE, null, FLANGORIA, null);
        register(FLANGORIA, FORTERESSE_2, null, ATTRACTION, null);
        register(ATTRACTION, FLANGORIA, null, UZINE_COCHON, null);
        register(UZINE_COCHON, ATTRACTION, null, VAALON, null);
        register(VAALON, new Station[] { UZINE_COCHON, MOBY_DICK, INTERSECT_18, COLLINE_JAMBES }, new PathType[] {
                PathType.OFFICIAL_RAIL, PathType.OFFICIAL_RAIL, PathType.OFFICIAL_WALKING, PathType.OFFICIAL_RAIL });
        register(MOBY_DICK, null, AGRISUB_1, null, VAALON);
        register(AGRISUB_1, null, UNKNOWN_11, null, MOBY_DICK);
        register(UNKNOWN_11, null, AZIE, null, AGRISUB_1);
        register(AZIE, new Station[] { null, EURAZIE, KASTOU, UNKNOWN_11 }, new PathType[] { PathType.OFFICIAL_RAIL,
                PathType.OFFICIAL_RAIL, PathType.OFFICIAL_WALKING, PathType.OFFICIAL_RAIL });
        register(SILVERISLAND, null, SECTEUR_GHASTS, null, EURAZIE);
        register(COLLINE_JAMBES, null, VAALON, null, GRANDE_LOTTERIE);
        register(GRANDE_LOTTERIE, null, COLLINE_JAMBES, null, FORTERESSE_1);
        register(FORTERESSE_1, null, GRANDE_LOTTERIE, null, OCTOPUSSY);
        register(OCTOPUSSY, null, FORTERESSE_1, null, CHATEAU_GLACES);
        register(AIGUILLAGE_CHATEAUNOIR, null, CHATEAU_GLACES, ARRAKIS, PIXEL_ART);
        register(CARROUSEL_HOLERIBUS, ARRAKIS, UNKNOWN_17, null, null);
        register(UNKNOWN_17, null, null, CHATEAU_NOIR, CARROUSEL_HOLERIBUS);
        register(CHATEAU_NOIR, UNKNOWN_17, null, null, null);
        register(CHATEAU_GLACES, null, OCTOPUSSY, null, AIGUILLAGE_CHATEAUNOIR);
        register(ARRAKIS, AIGUILLAGE_CHATEAUNOIR, null, CARROUSEL_HOLERIBUS, null);
        register(PIXEL_ART, MUSEE_PIXEL, AIGUILLAGE_CHATEAUNOIR, null, BANANEROSE);
        register(MUSEE_PIXEL, null, null, PIXEL_ART, null);
        register(BANANEROSE, null, PIXEL_ART, null, CIUDAD);
        register(CIUDAD, BLAZES_POINT, BANANEROSE, null, SOMONITES);
        register(BLAZES_POINT, null, null, CIUDAD, null);
        register(UNKNOWN_12, null, null, GHAST, USINE_OR);
        register(USINE_OR, null, UNKNOWN_12, null, null);
        register(POSEIDOPOLIS_EST, MELBURNE, null, ILE_PARADISIAQUE_BOBBIX, POSEIDOPOLIS);
        register(ILE_PARADISIAQUE_BOBBIX, POSEIDOPOLIS_EST, null, SUDET, null);
        register(SUDET, ILE_PARADISIAQUE_BOBBIX, CARDINALE_EST, SURET, USINE_GARDIENS);
        register(CARDINALE_EST, null, null, null, SUDET);
        register(SURET, SUDET, null, null, null);
        register(USINE_GARDIENS, null, SUDET, null, FORTERESSE_MYSTERIEUSE);
        register(FORTERESSE_MYSTERIEUSE, null, USINE_GARDIENS, null, HASHTAG);
        register(HASHTAG, null, FORTERESSE_MYSTERIEUSE, null, ILE_ZACQUES);
        register(ILE_ZACQUES, null, HASHTAG, null, DEPOT);
        register(UNKNOWN_13, null, COLLINE_BOULEAUX, FJORDS, null);
        register(UNKNOWN_14, UNKNOWN_20, null, CHEZ_NAGAIWA, UNKNOWN_15);
        register(UNKNOWN_15, null, UNKNOWN_14, KERSUB, null);
        register(ILE_VOLCANIQUE, FALLEN_KINGDOM, null, OCEAN_GAUCHE, null);
        register(FJORD_SUD, FJORD_CENTRAL, null, ZIG_ZAG, null);
        register(FJORD_CENTRAL, FJORD_NORD, null, FJORD_SUD, null);
        register(FJORD_NORD, FJORDS, null, FJORD_CENTRAL, null);
        register(FLEURS_CREVASSES, null, FORTERESSE_DES_FLEURS, null, FLEURS);
        register(ISLA_SOMA, ZIG_ZAG, null, PEPINIERE_EST, null);
        register(CHEZ_CARANDOOM, PEPINIERE_EST, null, ISLA_NUBLAR, null);
        register(CHEZ_CANTIN, ISLA_NUBLAR, null, GLACIER, null);
        register(ISLA_PENA, null, RESERVE, null, ZIG_ZAG);
        register(NOT_FINISHED_4, null, null, SEPTENTRION, null);

        // North Continent

        register(NORTH_CAPITAL, null, UNKNOWN_20, null, null);
        register(UNKNOWN_20, null, null, UNKNOWN_14, NORTH_CAPITAL);

        // Old foot-based network (so-called « Netherroutes »)

        registerWalk(INTERSECT_18, VAALON, null, ADELLIA, MORZAN);
        registerWalk(ADELLIA, INTERSECT_18, null, RAZIEL, null);
        registerWalk(RAZIEL, ADELLIA, null, INTERSECT_19, null);
        registerWalk(INTERSECT_19, RAZIEL, null, FORTERESSE_3, TAVERNE_BUNKER);
        registerWalk(FORTERESSE_3, INTERSECT_19, null, ARBRE_BIBLIOTHEQUE, null);
        registerWalk(ARBRE_BIBLIOTHEQUE, FORTERESSE_3, null, SIGICOAL, null);
        registerWalk(SIGICOAL, ARBRE_BIBLIOTHEQUE, null, null, null);

        registerWalk(MORZAN, null, INTERSECT_18, SMASTEN, INTERSECT_21);
        registerWalk(SMASTEN, MORZAN, null, null, null);
        registerWalk(INTERSECT_21, null, MORZAN, JUNGLE_PAUMEE, null);
        registerWalk(JUNGLE_PAUMEE, INTERSECT_21, null, null, null);

        registerWalk(TAVERNE_BUNKER, null, INTERSECT_19, INTERSECT_22, null);
        registerWalk(INTERSECT_22, TAVERNE_BUNKER, INTERSECT_23, null, null);
        registerWalk(INTERSECT_23, null, ELEVAGE_DE_MEUH, AMPHIPOLIS, INTERSECT_22);
        registerWalk(ELEVAGE_DE_MEUH, null, null, null, INTERSECT_23);
        registerWalk(AMPHIPOLIS, INTERSECT_23, null, REZERVE, null);
        registerWalk(REZERVE, AMPHIPOLIS, null, INTERSECT_26, null);
        registerWalk(INTERSECT_26, REZERVE, INTERSECT_27, null, null);
        registerWalk(INTERSECT_27, null, null, FOREST_OF_MAGIC_ISLAND, INTERSECT_26);
        registerWalk(FOREST_OF_MAGIC_ISLAND, INTERSECT_27, null, ILE_PARADISIAQUE, null);
        register(ILE_PARADISIAQUE, new Station[] { FOREST_OF_MAGIC_ISLAND, null, INTERSECT_30, null },
                new PathType[] { PathType.OFFICIAL_WALKING, PathType.OFFICIAL_WALKING, PathType.UNOFFICIAL_WALKING,
                        PathType.OFFICIAL_WALKING });
        register(INTERSECT_30, new Station[] { ILE_PARADISIAQUE, BAIE_HA_LONG, MONTAGNES_CREUSES, null },
                new PathType[] { PathType.UNOFFICIAL_WALKING, PathType.OFFICIAL_WALKING, PathType.OFFICIAL_WALKING,
                        PathType.OFFICIAL_WALKING });
        registerWalk(MONTAGNES_CREUSES, INTERSECT_30, null, null, null);

        registerWalk(BAIE_HA_LONG, STEP_31, MASTER_PWEL, null, INTERSECT_30);
        registerWalk(MASTER_PWEL, null, null, null, BAIE_HA_LONG);
        register(STEP_31, new Station[] { STEP_32, null, BAIE_HA_LONG, null },
                new PathType[] { PathType.UNOFFICIAL_WALKING, PathType.OFFICIAL_WALKING, PathType.OFFICIAL_WALKING,
                        PathType.OFFICIAL_WALKING });
        register(STEP_32, new Station[] { FORT_BOYAUX, null, STEP_31, null },
                new PathType[] { PathType.OFFICIAL_WALKING, PathType.OFFICIAL_WALKING, PathType.UNOFFICIAL_WALKING,
                        PathType.OFFICIAL_WALKING });
        registerWalk(FORT_BOYAUX, SANATORIUM_VERT, null, STEP_32, null);
        registerWalk(SANATORIUM_VERT, SECTEUR_GHASTS, null, FORT_BOYAUX, null);

        registerWalk(KASTOU, AZIE, null, SWAG_ISLAND, null);
        registerWalk(SWAG_ISLAND, KASTOU, null, null, null);

        registerWalk(TOUR_INFERNALE, EURAZIE, null, null, null);

        // check();
    }

    private final static int STATIONS_COUNT = 4;

    private final int X, Y;
    private final String NAME;
    private final boolean HIDDEN;
    private final boolean DANGER;
    private Station[] SUB_STATIONS;
    private double[] DISTANCES = new double[STATIONS_COUNT];
    private PathType[] PATH_TYPES;
    private final StationType TYPE;

    Station(final int x, final int y) {
        this(x, y, null);
    }

    Station(final int x, final int y, final String name) {
        this(x, y, name, StationType.PORTAL_ONLY);
    }

    Station(final int x, final int y, final String name, final StationType type) {
        this(x, y, name, type, false, false);
    }

    Station(final int x, final int y, final String name, final StationType type, final boolean isHidden,
            final boolean danger) {
        X = x;
        Y = y;

        NAME = name;

        TYPE = type;

        HIDDEN = isHidden;
        DANGER = danger;
    }

    public static void register(final Station station, final Station... stations) {
        register(station, stations, new PathType[] { PathType.OFFICIAL_RAIL, PathType.OFFICIAL_RAIL,
                PathType.OFFICIAL_RAIL, PathType.OFFICIAL_RAIL });
    }

    public static void registerWalk(final Station station, final Station... stations) {
        register(station, stations, new PathType[] { PathType.OFFICIAL_WALKING, PathType.OFFICIAL_WALKING,
                PathType.OFFICIAL_WALKING, PathType.OFFICIAL_WALKING });
    }

    public static void register(final Station station, final Station[] stations, final PathType[] paths) {
        if (stations.length != STATIONS_COUNT || paths.length != STATIONS_COUNT)
            throw new IllegalArgumentException(
                    String.format("Arrays sizes must be %s for %s", STATIONS_COUNT, station.name()));

        station.SUB_STATIONS = stations;

        station.PATH_TYPES = paths;

        for (int i = 0; i < STATIONS_COUNT; i++) {
            Station sub = station.SUB_STATIONS[i];
            if (sub == null)
                continue;

            if (sub == station)
                throw new IllegalArgumentException("Array contains itself");

            station.DISTANCES[i] = Math
                    .sqrt((station.X - sub.X) * (station.X - sub.X) + (station.Y - sub.Y) * (station.Y - sub.Y));
        }
    }

    public static void check() {
        for (Station station : values()) {

            for (Direction direction : Direction.values()) {
                if (!station.hasSubStation(direction))
                    continue;

                Station next = station.getSubStation(direction);
                Station assertion = next.getSubStation(direction.opposite());

                if (assertion == null || assertion != station) {
                    throw new IllegalArgumentException("Stations " + station + " and " + next
                            + " does not verify themselves for direction " + direction);
                }
            }
        }
    }

    public Station getSubStation(Direction direction) {
        if (direction == null)
            throw new IllegalArgumentException("Direction cannot be null");

        return SUB_STATIONS[direction.getIndex()];
    }

    public Direction getDirection(Station sub) {
        for (Direction direction : Direction.values())
            if (getSubStation(direction) == sub)
                return direction;

        throw new IllegalArgumentException("Station " + sub + " was not found in station " + name());
    }

    public boolean hasSubStation(Direction direction) {
        return getSubStation(direction) != null;
    }

    public double getDistanceFrom(Direction direction) {
        if (direction == null)
            throw new IllegalArgumentException("Direction cannot be null");

        return DISTANCES[direction.getIndex()];
    }

    public double getDistanceFrom(Station station) {
        return getDistanceFrom(getDirection(station));
    }

    public boolean isVisible() {
        return !HIDDEN;
    }

    public PathType getPathType(Direction direction) {
        return PATH_TYPES[direction.getIndex()];
    }

    public PathType getPathType(Station station) {
        return getPathType(getDirection(station));
    }

    public boolean isDangerous() {
        return DANGER;
    }

    public static List<Station> getStationsAlphabetically() {
        List<Station> stations = Arrays.asList(Station.values());
        Collections.sort(stations, new StationComparator());

        return stations;
    }

    @Override
    public String toString() {
        if (!isVisible())
            return "Station inconnue";

        if (NAME == null) {
            String[] split = name().toLowerCase().split("_");

            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].substring(0, 1).toUpperCase() + split[i].substring(1);
            }

            return Utils.join(Arrays.asList(split), " ");
        }

        return NAME;
    }

    public static int getId(Station station) {
        for (int i = 0; i < values().length; i++) {
            if (station == values()[i])
                return i;
        }

        throw new Error("Not found : " + station);
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public boolean isPortal() {
        return TYPE == StationType.PORTAL_ONLY || TYPE == StationType.INTERSECTION_AND_PORTAL;
    }

    public boolean isIntersection() {
        return TYPE == StationType.INTERSECTION_ONLY || TYPE == StationType.INTERSECTION_AND_PORTAL;
    }

    public JsonObject toJson(boolean withNetwork) {
        JsonObject objectStation = new JsonObject();

        objectStation.add("id", new JsonPrimitive(Station.getId(this)));
        objectStation.add("code_name", new JsonPrimitive(this.name().toLowerCase()));
        objectStation.add("full_name", new JsonPrimitive(this.toString()));

        objectStation.add("x", new JsonPrimitive(this.getX()));
        objectStation.add("y", new JsonPrimitive(this.getY()));

        objectStation.add("is_visible", new JsonPrimitive(this.isVisible()));
        objectStation.add("is_safe", new JsonPrimitive(!this.isDangerous()));

        objectStation.add("is_portal", new JsonPrimitive(this.isPortal()));
        objectStation.add("is_intersection", new JsonPrimitive(this.isIntersection()));

        JsonArray network = new JsonArray();

        if (withNetwork) {
            for (Direction direction : Direction.values()) {
                Station sub = this.getSubStation(direction);

                String key = direction.name().toLowerCase();

                if (sub != null)
                    network.add(buildConnectionObject(this, sub));
            }

            objectStation.add("network", network);
        }

        return objectStation;
    }

    /**
     * Creates a json object representing this station and its path. The last
     * station does not have any path.
     *
     * @param station the station
     * @param next    the next station
     * @return a json object
     */
    public static JsonObject buildStationPathObject(Station station, Station next) {
        JsonObject object = new JsonObject();

        JsonObject objectStation = station.toJson(false);

        object.add("station", objectStation);

        if (next != null) {
            JsonObject connection = Station.buildConnectionObject(station, next);

            object.add("connection", connection);
        }

        return object;
    }

    /**
     * Creates a json object representing a connection between two stations.
     *
     * @param station the main station
     * @param sub     the sub station
     * @return a json object
     */
    public static JsonObject buildConnectionObject(Station station, Station sub) {
        JsonObject object = new JsonObject();

        object.add("from", new JsonPrimitive(Station.getId(station)));
        object.add("to", new JsonPrimitive(Station.getId(sub)));

        object.add("direction", new JsonPrimitive(station.getDirection(sub).name().toLowerCase()));

        object.add("length", new JsonPrimitive((int) station.getDistanceFrom(sub)));

        PathType pathType = station.getPathType(sub);

        object.add("is_official", new JsonPrimitive(pathType.isOfficial()));

        object.add("is_rail", new JsonPrimitive(pathType.isRail()));

        return object;
    }
}

/**
 * The type of station.
 */
enum StationType {
    INTERSECTION_ONLY, INTERSECTION_AND_PORTAL, PORTAL_ONLY
}

class StationComparator implements Comparator<Station> {
    @Override
    public int compare(Station station1, Station station2) {
        return Utils.stripAccents(station1.toString()).compareTo(Utils.stripAccents(station2.toString()));
    }
}
