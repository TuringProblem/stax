import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

/**
 * ANSI Color codes for terminal display
 */
class AnsiColors {
    // Regular Colors
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // Bold Colors
    public static final String BOLD_BLACK = "\u001B[1;30m";
    public static final String BOLD_RED = "\u001B[1;31m";
    public static final String BOLD_GREEN = "\u001B[1;32m";
    public static final String BOLD_YELLOW = "\u001B[1;33m";
    public static final String BOLD_BLUE = "\u001B[1;34m";
    public static final String BOLD_PURPLE = "\u001B[1;35m";
    public static final String BOLD_CYAN = "\u001B[1;36m";
    public static final String BOLD_WHITE = "\u001B[1;37m";

    // Background Colors
    public static final String BG_BLACK = "\u001B[40m";
    public static final String BG_RED = "\u001B[41m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_PURPLE = "\u001B[45m";
    public static final String BG_CYAN = "\u001B[46m";
    public static final String BG_WHITE = "\u001B[47m";

    // Bright Background Colors
    public static final String BG_BRIGHT_BLACK = "\u001B[100m";
    public static final String BG_BRIGHT_RED = "\u001B[101m";
    public static final String BG_BRIGHT_GREEN = "\u001B[102m";
    public static final String BG_BRIGHT_YELLOW = "\u001B[103m";
    public static final String BG_BRIGHT_BLUE = "\u001B[104m";
    public static final String BG_BRIGHT_PURPLE = "\u001B[105m";
    public static final String BG_BRIGHT_CYAN = "\u001B[106m";
    public static final String BG_BRIGHT_WHITE = "\u001B[107m";

    // Underline
    public static final String UNDERLINE = "\u001B[4m";
}

/**
 * Basic enums for card properties
 */
enum CardRarity {
    COMMON, UNCOMMON, RARE, EPIC, LEGENDARY, MYTHIC
}

enum CardType {
    ATTACK, DEFENSE, UTILITY, SPELL, TRAP, CREATURE
}

enum CardElement {
    FIRE, WATER, EARTH, AIR, VOID, LIGHT, DARK, NATURE, TECH
}

/**
 * Card class representing a game card with enhanced properties
 */

class Card {
    private final String id;
    private final String name;
    private final CardType type;
    private final CardRarity rarity;
    private final CardElement element;
    private final int power;
    private final int defense;
    private final int energyCost;
    private final String description;
    private final String flavorText;
    private final String artist;
    private final String edition;

    public Card(String id, String name, CardType type, CardRarity rarity, CardElement element,
            int power, int defense, int energyCost, String description, String flavorText,
            String artist, String edition) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.element = element;
        this.power = power;
        this.defense = defense;
        this.energyCost = energyCost;
        this.description = description;
        this.flavorText = flavorText;
        this.artist = artist;
        this.edition = edition;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CardType getType() {
        return type;
    }

    public CardRarity getRarity() {
        return rarity;
    }

    public CardElement getElement() {
        return element;
    }

    public int getPower() {
        return power;
    }

    public int getDefense() {
        return defense;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public String getDescription() {
        return description;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public String getArtist() {
        return artist;
    }

    public String getEdition() {
        return edition;
    }

    // Helper methods for rendering
    public String getTypeSymbol() {
        return switch (type) {
            case ATTACK -> "⚔️";
            case DEFENSE -> "🛡️";
            case UTILITY -> "🔮";
            case SPELL -> "✨";
            case TRAP -> "⚡";
            case CREATURE -> "👾";
        };
    }

    public String getElementSymbol() {
        return switch (element) {
            case FIRE -> "🔥";
            case WATER -> "💧";
            case EARTH -> "🌍";
            case AIR -> "💨";
            case VOID -> "🌌";
            case LIGHT -> "⭐";
            case DARK -> "🌑";
            case NATURE -> "🌿";
            case TECH -> "⚙️";
        };
    }

    public CardStyle getCardStyle() {
        return CardStyle.forCardProperties(rarity, type, element);
    }
}

/**
 * Enhanced styling for cards based on rarity, type, and element
 */
class CardStyle {
    private final String primaryColor;
    private final String secondaryColor;
    private final String accentColor;
    private final String textColor;
    private final String bgColor;
    private final String titleBgColor;
    private final String statsBgColor;
    private final String borderStyle;
    private final String cornerStyle;

    public CardStyle(String primaryColor, String secondaryColor, String accentColor,
            String textColor, String bgColor, String titleBgColor, String statsBgColor,
            String borderStyle, String cornerStyle) {
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.accentColor = accentColor;
        this.textColor = textColor;
        this.bgColor = bgColor;
        this.titleBgColor = titleBgColor;
        this.statsBgColor = statsBgColor;
        this.borderStyle = borderStyle;
        this.cornerStyle = cornerStyle;
    }

    // Getters
    public String getPrimaryColor() {
        return primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public String getAccentColor() {
        return accentColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public String getBgColor() {
        return bgColor;
    }

    public String getTitleBgColor() {
        return titleBgColor;
    }

    public String getStatsBgColor() {
        return statsBgColor;
    }

    public String getBorderStyle() {
        return borderStyle;
    }

    public String getCornerStyle() {
        return cornerStyle;
    }

    // Factory method for creating card styles
    public static CardStyle forCardProperties(CardRarity rarity, CardType type, CardElement element) {
        // Base style based on rarity
        String primaryColor, secondaryColor, accentColor, textColor, bgColor, titleBgColor, statsBgColor, borderStyle,
                cornerStyle;

        // Set base colors by rarity
        switch (rarity) {
            case COMMON:
                primaryColor = AnsiColors.WHITE;
                secondaryColor = AnsiColors.BOLD_WHITE;
                accentColor = AnsiColors.CYAN;
                textColor = AnsiColors.WHITE;
                bgColor = AnsiColors.BG_BLACK;
                titleBgColor = AnsiColors.BG_BRIGHT_BLACK;
                statsBgColor = AnsiColors.BG_BLACK;
                borderStyle = "═║╔╗╚╝╠╣╦╩╬";
                cornerStyle = "●";
                break;

            case UNCOMMON:
                primaryColor = AnsiColors.GREEN;
                secondaryColor = AnsiColors.BOLD_GREEN;
                accentColor = AnsiColors.CYAN;
                textColor = AnsiColors.GREEN;
                bgColor = AnsiColors.BG_BLACK;
                titleBgColor = AnsiColors.BG_BRIGHT_BLACK;
                statsBgColor = AnsiColors.BG_BLACK;
                borderStyle = "═║╔╗╚╝╠╣╦╩╬";
                cornerStyle = "◆";
                break;

            case RARE:
                primaryColor = AnsiColors.BLUE;
                secondaryColor = AnsiColors.BOLD_BLUE;
                accentColor = AnsiColors.CYAN;
                textColor = AnsiColors.CYAN;
                bgColor = AnsiColors.BG_BLACK;
                titleBgColor = AnsiColors.BG_BRIGHT_BLACK;
                statsBgColor = AnsiColors.BG_BLACK;
                borderStyle = "━┃┏┓┗┛┣┫┳┻╋";
                cornerStyle = "★";
                break;

            case EPIC:
                primaryColor = AnsiColors.PURPLE;
                secondaryColor = AnsiColors.BOLD_PURPLE;
                accentColor = AnsiColors.BOLD_CYAN;
                textColor = AnsiColors.PURPLE;
                bgColor = AnsiColors.BG_BLACK;
                titleBgColor = AnsiColors.BG_BRIGHT_BLACK;
                statsBgColor = AnsiColors.BG_BLACK;
                borderStyle = "═║╔╗╚╝╠╣╦╩╬";
                cornerStyle = "✦";
                break;

            case LEGENDARY:
                primaryColor = AnsiColors.YELLOW;
                secondaryColor = AnsiColors.BOLD_YELLOW;
                accentColor = AnsiColors.BOLD_RED;
                textColor = AnsiColors.YELLOW;
                bgColor = AnsiColors.BG_BLACK;
                titleBgColor = AnsiColors.BG_BRIGHT_BLACK;
                statsBgColor = AnsiColors.BG_BLACK;
                borderStyle = "█▀▄▌▐▓░▒";
                cornerStyle = "✫";
                break;

            case MYTHIC:
                primaryColor = AnsiColors.RED;
                secondaryColor = AnsiColors.BOLD_RED;
                accentColor = AnsiColors.BOLD_YELLOW;
                textColor = AnsiColors.RED;
                bgColor = AnsiColors.BG_BLACK;
                titleBgColor = AnsiColors.BG_BRIGHT_BLACK;
                statsBgColor = AnsiColors.BG_BLACK;
                borderStyle = "▓█▀▄▌▐░▒";
                cornerStyle = "✴";
                break;

            default:
                primaryColor = AnsiColors.WHITE;
                secondaryColor = AnsiColors.BOLD_WHITE;
                accentColor = AnsiColors.CYAN;
                textColor = AnsiColors.WHITE;
                bgColor = AnsiColors.BG_BLACK;
                titleBgColor = AnsiColors.BG_BRIGHT_BLACK;
                statsBgColor = AnsiColors.BG_BLACK;
                borderStyle = "═║╔╗╚╝╠╣╦╩╬";
                cornerStyle = "•";
        }

        // Adjust background colors based on element
        switch (element) {
            case FIRE:
                statsBgColor = AnsiColors.BG_RED;
                break;
            case WATER:
                statsBgColor = AnsiColors.BG_BLUE;
                break;
            case EARTH:
                statsBgColor = AnsiColors.BG_YELLOW;
                break;
            case AIR:
                statsBgColor = AnsiColors.BG_CYAN;
                break;
            case VOID:
                statsBgColor = AnsiColors.BG_PURPLE;
                break;
            case LIGHT:
                statsBgColor = AnsiColors.BG_WHITE;
                break;
            case DARK:
                statsBgColor = AnsiColors.BG_BLACK;
                titleBgColor = AnsiColors.BG_BRIGHT_PURPLE;
                break;
            case NATURE:
                statsBgColor = AnsiColors.BG_GREEN;
                break;
            case TECH:
                statsBgColor = AnsiColors.BG_BRIGHT_BLACK;
                break;
        }

        // Adjust accent colors based on type
        switch (type) {
            case ATTACK:
                if (rarity != CardRarity.LEGENDARY && rarity != CardRarity.MYTHIC) {
                    accentColor = AnsiColors.BOLD_RED;
                }
                break;
            case DEFENSE:
                if (rarity != CardRarity.LEGENDARY && rarity != CardRarity.MYTHIC) {
                    accentColor = AnsiColors.BOLD_BLUE;
                }
                break;
            case UTILITY:
                if (rarity != CardRarity.LEGENDARY && rarity != CardRarity.MYTHIC) {
                    accentColor = AnsiColors.BOLD_GREEN;
                }
                break;
            case SPELL:
                if (rarity != CardRarity.LEGENDARY && rarity != CardRarity.MYTHIC) {
                    accentColor = AnsiColors.BOLD_PURPLE;
                }
                break;
            case TRAP:
                if (rarity != CardRarity.LEGENDARY && rarity != CardRarity.MYTHIC) {
                    accentColor = AnsiColors.BOLD_YELLOW;
                }
                break;
            case CREATURE:
                if (rarity != CardRarity.LEGENDARY && rarity != CardRarity.MYTHIC) {
                    accentColor = AnsiColors.BOLD_CYAN;
                }
                break;
        }

        return new CardStyle(
                primaryColor, secondaryColor, accentColor, textColor,
                bgColor, titleBgColor, statsBgColor, borderStyle, cornerStyle);
    }
}

/**
 * Enhanced card renderer - handles the visual display of cards in the terminal
 */
class CardRenderer {
    // Card dimensions
    private static final int CARD_WIDTH = 36;
    private static final int CARD_HEIGHT = 18;

    /**
     * Render a card in the terminal
     * 
     * @param card      The card to render
     * @param frontSide True to show front side, false for back side
     */
    public static void renderCard(Card card, boolean frontSide) {
        CardStyle style = card.getCardStyle();

        if (frontSide) {
            renderFrontCard(card, style);
        } else {
            renderBackCard(card, style);
        }
    }

    /**
     * Render the front side of a card with enhanced border and styling
     */
    private static void renderFrontCard(Card card, CardStyle style) {
        String bs = style.getBorderStyle(); // Border style characters

        // Extract border characters (for box drawing)
        char horizontalLine = bs.charAt(0);
        char verticalLine = bs.charAt(1);
        char topLeftCorner = bs.charAt(2);
        char topRightCorner = bs.charAt(3);
        char bottomLeftCorner = bs.charAt(4);
        char bottomRightCorner = bs.charAt(5);

        // Top border with corners
        System.out.print(style.getPrimaryColor());
        System.out.print(style.getCornerStyle());
        for (int i = 0; i < CARD_WIDTH - 2; i++) {
            System.out.print(horizontalLine);
        }
        System.out.println(style.getCornerStyle() + AnsiColors.RESET);

        // Title section with background
        String titleLine = " " + card.getName() + " ";
        int titlePadding = CARD_WIDTH - titleLine.length() - 2;
        int leftPad = titlePadding / 2;
        int rightPad = titlePadding - leftPad;

        System.out.print(style.getPrimaryColor() + verticalLine);
        System.out.print(style.getTitleBgColor());

        for (int i = 0; i < leftPad; i++)
            System.out.print(" ");
        System.out.print(style.getSecondaryColor() + titleLine);
        for (int i = 0; i < rightPad; i++)
            System.out.print(" ");

        System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);

        // Rarity and type line
        String typeRarityLine = " " + card.getTypeSymbol() + " " + card.getType() + " | " +
                card.getElementSymbol() + " " + card.getElement() + " | " +
                card.getRarity() + " ";
        int typeRarityPadding = CARD_WIDTH - typeRarityLine.length() - 2;
        leftPad = typeRarityPadding / 2;
        rightPad = typeRarityPadding - leftPad;

        System.out.print(style.getPrimaryColor() + verticalLine);
        System.out.print(style.getBgColor());

        for (int i = 0; i < leftPad; i++)
            System.out.print(" ");
        System.out.print(style.getAccentColor() + typeRarityLine);
        for (int i = 0; i < rightPad; i++)
            System.out.print(" ");

        System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);

        // Stats bar
        String statsLine = " PWR:" + card.getPower() + " | DEF:" + card.getDefense() + " | COST:" + card.getEnergyCost()
                + " ";
        int statsPadding = CARD_WIDTH - statsLine.length() - 2;
        leftPad = statsPadding / 2;
        rightPad = statsPadding - leftPad;

        System.out.print(style.getPrimaryColor() + verticalLine);
        System.out.print(style.getStatsBgColor());

        for (int i = 0; i < leftPad; i++)
            System.out.print(" ");
        System.out.print(style.getSecondaryColor() + statsLine);
        for (int i = 0; i < rightPad; i++)
            System.out.print(" ");

        System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);

        // Divider line
        System.out.print(style.getPrimaryColor() + verticalLine);
        System.out.print(style.getBgColor());
        for (int i = 0; i < CARD_WIDTH - 2; i++) {
            System.out.print("─");
        }
        System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);

        // Card description
        List<String> descLines = wordWrap(card.getDescription(), CARD_WIDTH - 6);
        for (String line : descLines) {
            System.out.print(style.getPrimaryColor() + verticalLine);
            System.out.print(style.getBgColor() + " ");
            System.out.print(style.getTextColor() + " " + line);

            int padding = CARD_WIDTH - 4 - line.length();
            for (int i = 0; i < padding; i++)
                System.out.print(" ");

            System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);
        }

        // Empty line if needed
        if (descLines.size() < 3) {
            for (int i = 0; i < 3 - descLines.size(); i++) {
                System.out.print(style.getPrimaryColor() + verticalLine);
                System.out.print(style.getBgColor());
                for (int j = 0; j < CARD_WIDTH - 2; j++)
                    System.out.print(" ");
                System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);
            }
        }

        // Divider line
        System.out.print(style.getPrimaryColor() + verticalLine);
        System.out.print(style.getBgColor());
        for (int i = 0; i < CARD_WIDTH - 2; i++) {
            System.out.print("─");
        }
        System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);

        // Flavor text (in italics if supported)
        if (card.getFlavorText() != null && !card.getFlavorText().isEmpty()) {
            List<String> flavorLines = wordWrap(card.getFlavorText(), CARD_WIDTH - 6);
            for (String line : flavorLines) {
                System.out.print(style.getPrimaryColor() + verticalLine);
                System.out.print(style.getBgColor() + " ");
                System.out.print(style.getAccentColor() + " " + line);

                int padding = CARD_WIDTH - 4 - line.length();
                for (int i = 0; i < padding; i++)
                    System.out.print(" ");

                System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);
            }

            // Ensure maximum of 2 flavor text lines
            int flavorLinesCount = Math.min(flavorLines.size(), 2);
            if (flavorLinesCount < 2) {
                for (int i = 0; i < 2 - flavorLinesCount; i++) {
                    System.out.print(style.getPrimaryColor() + verticalLine);
                    System.out.print(style.getBgColor());
                    for (int j = 0; j < CARD_WIDTH - 2; j++)
                        System.out.print(" ");
                    System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);
                }
            }
        } else {
            // No flavor text, fill space
            for (int i = 0; i < 2; i++) {
                System.out.print(style.getPrimaryColor() + verticalLine);
                System.out.print(style.getBgColor());
                for (int j = 0; j < CARD_WIDTH - 2; j++)
                    System.out.print(" ");
                System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);
            }
        }

        // Edition & Card ID
        String editionLine = "Edition: " + card.getEdition() + " | ID: " + card.getId();

        System.out.print(style.getPrimaryColor() + verticalLine);
        System.out.print(style.getBgColor() + " ");
        System.out.print(style.getTextColor() + editionLine);

        int padding = CARD_WIDTH - 3 - editionLine.length();
        for (int i = 0; i < padding; i++)
            System.out.print(" ");

        System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);

        // Artist credit line
        String artistLine = "Art: " + card.getArtist();

        System.out.print(style.getPrimaryColor() + verticalLine);
        System.out.print(style.getBgColor() + " ");
        System.out.print(style.getTextColor() + artistLine);

        padding = CARD_WIDTH - 3 - artistLine.length();
        for (int i = 0; i < padding; i++)
            System.out.print(" ");

        System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);

        // Bottom border with corners
        System.out.print(style.getPrimaryColor());
        System.out.print(style.getCornerStyle());
        for (int i = 0; i < CARD_WIDTH - 2; i++) {
            System.out.print(horizontalLine);
        }
        System.out.println(style.getCornerStyle() + AnsiColors.RESET);
    }

    /**
     * Render the back side of a card with enhanced styling
     */
    private static void renderBackCard(Card card, CardStyle style) {
        String bs = style.getBorderStyle(); // Border style characters

        // Extract border characters
        char horizontalLine = bs.charAt(0);
        char verticalLine = bs.charAt(1);
        char topLeftCorner = bs.charAt(2);
        char topRightCorner = bs.charAt(3);
        char bottomLeftCorner = bs.charAt(4);
        char bottomRightCorner = bs.charAt(5);

        // Create distinct patterns based on rarity and element
        char patternChar1, patternChar2;

        switch (card.getRarity()) {
            case COMMON:
                patternChar1 = '·';
                patternChar2 = '∙';
                break;
            case UNCOMMON:
                patternChar1 = '✦';
                patternChar2 = '✧';
                break;
            case RARE:
                patternChar1 = '★';
                patternChar2 = '☆';
                break;
            case EPIC:
                patternChar1 = '♦';
                patternChar2 = '♢';
                break;
            case LEGENDARY:
                patternChar1 = '❖';
                patternChar2 = '✧';
                break;
            case MYTHIC:
                patternChar1 = '✴';
                patternChar2 = '✺';
                break;
            default:
                patternChar1 = '·';
                patternChar2 = '∙';
        }

        // Element symbol for center
        String centerSymbol = card.getElementSymbol();

        // Top border with corners
        System.out.print(style.getPrimaryColor());
        System.out.print(style.getCornerStyle());
        for (int i = 0; i < CARD_WIDTH - 2; i++) {
            System.out.print(horizontalLine);
        }
        System.out.println(style.getCornerStyle() + AnsiColors.RESET);

        // First empty line
        System.out.print(style.getPrimaryColor() + verticalLine);
        System.out.print(style.getBgColor());
        for (int j = 0; j < CARD_WIDTH - 2; j++)
            System.out.print(" ");
        System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);

        // Title banner
        String title = "STAX";
        int titlePadding = CARD_WIDTH - title.length() - 2;
        int leftPad = titlePadding / 2;
        int rightPad = titlePadding - leftPad;

        System.out.print(style.getPrimaryColor() + verticalLine);
        System.out.print(style.getTitleBgColor());

        for (int i = 0; i < leftPad; i++)
            System.out.print(" ");
        System.out.print(style.getSecondaryColor() + title);
        for (int i = 0; i < rightPad; i++)
            System.out.print(" ");

        System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);

        // Empty line
        System.out.print(style.getPrimaryColor() + verticalLine);
        System.out.print(style.getBgColor());
        for (int j = 0; j < CARD_WIDTH - 2; j++)
            System.out.print(" ");
        System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);

        // Pattern rows (8 rows of alternating patterns)
        for (int row = 0; row < 8; row++) {
            System.out.print(style.getPrimaryColor() + verticalLine);
            System.out.print(style.getBgColor());

            // Different pattern for each row
            for (int col = 0; col < CARD_WIDTH - 2; col++) {
                if (row == 3 && col >= (CARD_WIDTH - 6) / 2 && col < (CARD_WIDTH - 6) / 2 + 4) {
                    // Center element symbol
                    if (col == (CARD_WIDTH - 6) / 2 + 1) {
                        System.out.print(style.getAccentColor() + centerSymbol);
                        col++; // Skip next position as emoji takes 2 chars
                    } else {
                        System.out.print(" ");
                    }
                } else if ((row + col) % 3 == 0) {
                    System.out.print(style.getAccentColor() + ((row % 2 == 0) ? patternChar1 : patternChar2));
                } else if ((row - col) % 4 == 0) {
                    System.out.print(style.getSecondaryColor() + ((row % 2 == 0) ? patternChar2 : patternChar1));
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);
        }

        // Type and rarity info
        String typeRarity = card.getType() + " • " + card.getRarity();
        int typeRarityPad = CARD_WIDTH - typeRarity.length() - 2;
        leftPad = typeRarityPad / 2;
        rightPad = typeRarityPad - leftPad;

        System.out.print(style.getPrimaryColor() + verticalLine);
        System.out.print(style.getBgColor());

        System.out.print(style.getPrimaryColor() + verticalLine);
        System.out.print(style.getBgColor());

        for (int i = 0; i < leftPad; i++)
            System.out.print(" ");
        System.out.print(style.getAccentColor() + typeRarity);
        for (int i = 0; i < rightPad; i++)
            System.out.print(" ");

        System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);

        // Element info
        String elementText = "Element: " + card.getElement() + " " + card.getElementSymbol();
        int elementPad = CARD_WIDTH - elementText.length() - 2;
        leftPad = elementPad / 2;
        rightPad = elementPad - leftPad;

        System.out.print(style.getPrimaryColor() + verticalLine);
        System.out.print(style.getBgColor());

        for (int i = 0; i < leftPad; i++)
            System.out.print(" ");
        System.out.print(style.getAccentColor() + elementText);
        for (int i = 0; i < rightPad; i++)
            System.out.print(" ");

        System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);

        // Empty line
        System.out.print(style.getPrimaryColor() + verticalLine);
        System.out.print(style.getBgColor());
        for (int j = 0; j < CARD_WIDTH - 2; j++)
            System.out.print(" ");
        System.out.println(AnsiColors.RESET + style.getPrimaryColor() + verticalLine + AnsiColors.RESET);

        // Bottom border with corners
        System.out.print(style.getPrimaryColor());
        System.out.print(style.getCornerStyle());
        for (int i = 0; i < CARD_WIDTH - 2; i++) {
            System.out.print(horizontalLine);
        }
        System.out.println(style.getCornerStyle() + AnsiColors.RESET);
    }

    /**
     * Word wrap text to fit within a specific width
     */
    private static List<String> wordWrap(String text, int maxWidth) {
        List<String> lines = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return lines;
        }

        String[] words = text.split("\\s+");
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            if (currentLine.length() + word.length() + 1 <= maxWidth) {
                if (currentLine.length() > 0) {
                    currentLine.append(" ");
                }
                currentLine.append(word);
            } else {
                lines.add(currentLine.toString());
                currentLine = new StringBuilder(word);
            }
        }

        if (currentLine.length() > 0) {
            lines.add(currentLine.toString());
        }

        return lines;
    }
}

/**
 * Enhanced card viewer with escape key support
 */
class CardViewer {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * View a card interactively
     * 
     * @param card The card to view
     * @return true if user wants to go back to card selection, false if user wants
     *         to exit
     */
    public static boolean viewCard(Card card) {
        boolean viewing = true;
        boolean frontSide = true;

        while (viewing) {
            clearScreen();
            System.out.println(
                    "\nCard Viewer - Press 1 for Front, 2 for Back, ESC/e to Return to Selection, 0 to Exit\n");

            CardRenderer.renderCard(card, frontSide);

            System.out.print("\nEnter choice: ");
            String input = scanner.nextLine().trim();

            switch (input.toLowerCase()) {
                case "1":
                    frontSide = true;
                    break;
                case "2":
                    frontSide = false;
                    break;
                case "e":
                case "esc":
                case "\u001b": // Actual escape character (may not work in all terminals)
                    return true; // Return to selection
                case "0":
                case "exit":
                case "quit":
                    viewing = false;
                    return false; // Exit entirely
                default:
                    System.out.println("Invalid option. Try again.");
                    sleep(1000); // Short pause for error message
            }
        }

        return false; // Exit program
    }

    /**
     * Clear the terminal screen
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Sleep for the specified milliseconds
     */
    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/**
 * Test class to demonstrate different card designs
 */
public class CardDesignTest {
    private static final Scanner scanner = new Scanner(System.in);

    // Create a collection of test cards with varied properties
    private static Card[] createTestCards() {
        return new Card[] {
                // Common cards
                new Card(
                        "COM-001",
                        "Iron Dagger",
                        CardType.ATTACK,
                        CardRarity.COMMON,
                        CardElement.EARTH,
                        3, 2, 1,
                        "Deal 3 damage to target enemy. If they have less than 5 health, deal 1 additional damage.",
                        "A simple but reliable weapon.",
                        "Anna Smith",
                        "Base Set"),
                new Card(
                        "COM-002",
                        "Wooden Shield",
                        CardType.DEFENSE,
                        CardRarity.COMMON,
                        CardElement.NATURE,
                        1, 4, 1,
                        "Block the next 4 damage you would take from attacks.",
                        "Splinters are the least of your worries.",
                        "John Davis",
                        "Base Set"),

                // Uncommon cards
                new Card(
                        "UNC-001",
                        "Flame Strike",
                        CardType.ATTACK,
                        CardRarity.UNCOMMON,
                        CardElement.FIRE,
                        6, 1, 2,
                        "Deal 6 damage to target enemy and apply Burn status (2 damage per turn for 3 turns).",
                        "The air sizzles as the flames dance through it.",
                        "Maria Rodriguez",
                        "Base Set"),
                new Card(
                        "UNC-002",
                        "Mana Potion",
                        CardType.UTILITY,
                        CardRarity.UNCOMMON,
                        CardElement.WATER,
                        0, 0, 0,
                        "Restore 3 energy points. Draw 1 card.",
                        "The blue liquid bubbles with arcane energy.",
                        "Li Wei",
                        "Base Set"),

                // Rare cards
                new Card(
                        "RAR-001",
                        "Lightning Bolt",
                        CardType.SPELL,
                        CardRarity.RARE,
                        CardElement.AIR,
                        8, 0, 3,
                        "Deal 8 damage to target enemy. Has a 25% chance to stun them for 1 turn.",
                        "The sky itself bends to your will.",
                        "Thomas Wright",
                        "Base Set"),
                new Card(
                        "RAR-002",
                        "Enchanted Armor",
                        CardType.DEFENSE,
                        CardRarity.RARE,
                        CardElement.LIGHT,
                        0, 10, 3,
                        "Block the next 10 damage you would take. Gain 2 armor for 3 turns.",
                        "Glowing runes pulse with protective magic.",
                        "Sarah Johnson",
                        "Base Set"),

                // Epic cards
                new Card(
                        "EPC-001",
                        "Shadow Assassin",
                        CardType.CREATURE,
                        CardRarity.EPIC,
                        CardElement.DARK,
                        7, 3, 4,
                        "Summon a Shadow Assassin with 7 attack and 3 health. It has a 50% chance to evade attacks.",
                        "You'll never see it coming until it's too late.",
                        "Marcus Blackwood",
                        "Base Set"),
                new Card(
                        "EPC-002",
                        "Mind Control",
                        CardType.TRAP,
                        CardRarity.EPIC,
                        CardElement.VOID,
                        0, 5, 4,
                        "Take control of an enemy creature with 5 or less power for 2 turns.",
                        "Your thoughts are no longer your own.",
                        "Luna Grey",
                        "Base Set"),

                // Legendary cards
                new Card(
                        "LGD-001",
                        "Dragon's Breath",
                        CardType.ATTACK,
                        CardRarity.LEGENDARY,
                        CardElement.FIRE,
                        12, 0, 5,
                        "Deal 12 damage to all enemies. Ignores armor and shields. Applies Burn status (3 damage per turn for 4 turns).",
                        "The ancient dragons' fury, unleashed at your command.",
                        "Drake Fireheart",
                        "Mythic Expansion"),
                new Card(
                        "LGD-002",
                        "Time Warp",
                        CardType.SPELL,
                        CardRarity.LEGENDARY,
                        CardElement.VOID,
                        0, 0, 5,
                        "Take an extra turn after this one. Draw 3 cards and gain 3 energy.",
                        "Reality bends as time itself twists to your will.",
                        "Chronos Voidwalker",
                        "Mythic Expansion"),

                // Mythic cards
                new Card(
                        "MTH-001",
                        "World Eater",
                        CardType.CREATURE,
                        CardRarity.MYTHIC,
                        CardElement.VOID,
                        20, 20, 8,
                        "Summon the World Eater with 20 attack and 20 health. At the beginning of your turn, it consumes 1 of your energy but gains +2/+2.",
                        "It hungers for the very fabric of existence.",
                        "Void Collective",
                        "Cosmic Horrors"),
                new Card(
                        "MTH-002",
                        "Divine Intervention",
                        CardType.UTILITY,
                        CardRarity.MYTHIC,
                        CardElement.LIGHT,
                        0, 0, 7,
                        "Restore all health. Remove all negative status effects. Your next 3 spells cost 0 energy.",
                        "The heavens themselves intervene on your behalf.",
                        "Celestial Council",
                        "Divine Order"),
                new Card(
                        "MTH-003",
                        "Technoforge Gauntlet",
                        CardType.ATTACK,
                        CardRarity.MYTHIC,
                        CardElement.TECH,
                        15, 10, 6,
                        "Deal 15 damage to target enemy. If this destroys them, gain a Nano-Bot companion with 5/5 that grants you +1 energy each turn.",
                        "The height of technological advancement, capable of creation and destruction.",
                        "Dr. Nanobot",
                        "Future Tech")
        };
    }

    public static void main(String[] args) {
        Card[] testCards = createTestCards();
        boolean running = true;

        while (running) {
            showCardSelectionMenu(testCards);

            System.out.print("\nSelect a card (1-" + testCards.length + ") or 0 to exit: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                if (choice == 0) {
                    running = false;
                } else if (choice > 0 && choice <= testCards.length) {
                    // View the selected card and check if user wants to return to selection
                    boolean returnToSelection = CardViewer.viewCard(testCards[choice - 1]);
                    if (!returnToSelection) {
                        running = false;
                    }
                } else {
                    System.out.println("Invalid card number. Please try again.");
                    sleep(1500);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                sleep(1500);
            }
        }

        CardViewer.clearScreen();
        System.out.println("\nThank you for exploring the STAX card designs!");
    }

    /**
     * Display the card selection menu
     */
    private static void showCardSelectionMenu(Card[] cards) {
        CardViewer.clearScreen();
        System.out.println("\n=============== STAX CARD DESIGN TEST ===============");
        System.out.println("\nAvailable cards to view:");
        System.out.println("----------------------------------------");

        for (int i = 0; i < cards.length; i++) {
            Card card = cards[i];
            String cardInfo = String.format("%2d. %-20s | %-9s | %-8s | %-6s | PWR:%-2d DEF:%-2d COST:%-1d",
                    (i + 1),
                    card.getName(),
                    card.getType(),
                    card.getRarity(),
                    card.getElement(),
                    card.getPower(),
                    card.getDefense(),
                    card.getEnergyCost());

            // Apply colors based on rarity
            String colorPrefix;
            switch (card.getRarity()) {
                case COMMON:
                    colorPrefix = AnsiColors.WHITE;
                    break;
                case UNCOMMON:
                    colorPrefix = AnsiColors.GREEN;
                    break;
                case RARE:
                    colorPrefix = AnsiColors.BLUE;
                    break;
                case EPIC:
                    colorPrefix = AnsiColors.PURPLE;
                    break;
                case LEGENDARY:
                    colorPrefix = AnsiColors.BOLD_YELLOW;
                    break;
                case MYTHIC:
                    colorPrefix = AnsiColors.BOLD_RED;
                    break;
                default:
                    colorPrefix = AnsiColors.WHITE;
            }

            System.out.println(colorPrefix + cardInfo + AnsiColors.RESET);
        }

        System.out.println("----------------------------------------");
        System.out.println("0. Exit Program");
    }

    /**
     * Sleep for the specified milliseconds
     */
    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
