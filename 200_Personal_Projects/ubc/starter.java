import java.util.Scanner;

class starter {

    static Scanner sc = new Scanner(System.in);

    // Card variables
    static int firstCardValue;
    static int secondCardValue;
    static int thirdCardValue;
    static int fourthCardValue;
    static int fifthCardValue;

    static int firstCardSuit;
    static int secondCardSuit;
    static int thirdCardSuit;
    static int fourthCardSuit;
    static int fifthCardSuit;

    // Score variables
    static int chips = 0;
    static int mult = 0;

    // Joker variables
    static int cardsDiscarded = 0;
    static int faceCardsDiscarded = 0;
    static int kingsInHand = 0;
    static int heartsDiscarded = 0;
    static int heartsKeptDiscarded = 0;
    static int queensInHand = 0;
    static int spadesInHand = 0;
    static int clubsKept = 0;
    static int heartsKept = 0;
    static int differentSuitsDiscarded = 0;
    static String joker = "";

    // Reward variables
    static int twigs;
    static int grassTuft;
    static int cutStone;
    static int rope;
    static int gold;
    static int redGem;
    static int blueGem;
    static int purpleGem;
    static int banana;
    static int bananaPop;
    static int playingCard;
    static int record;

    // Jokers
    static String[] jokers = {
        "Wilson",
        "Willow",
        "Wolfgang",
        "Wendy",
        "WX-78",
        "Wickerbottom",
        "Woodie",
        "Wes",
        "Maxwell",
        "Wigfrid",
        "Webber",
        "Warly",
        "Wormwood",
        "Winona",
        "Wortox",
        "Wurt",
        "Walter",
        "Wanda"
    };

    static String[] jokerDescriptions = {
        "Start with +50 chips.",
        "Start with +1 mult.",
        "Gain +10 mult for every face card in your hand.",
        "Gain +20 chips if you discard a card.",
        "Gain +5 mult for every card in your hand.",
        "Gain +10 chips for every different suit.",
        "Gain +30 chips if you have a pair.",
        "Gain +15 mult if your hand is a High Card.",
        "Gain +50 chips and +5 mult.",
        "Gain +10 mult for every heart.",
        "Gain +25 chips if you have two of the same card.",
        "Gain +20 chips if you discard a heart.",
        "Gain +15 chips if you keep a heart.",
        "Gain +20 chips for every king.",
        "Gain +30 chips if you have a straight.",
        "Gain +25 mult if you have a flush.",
        "Gain +15 chips for every queen.",
        "Start with 80 chips. Each discard costs 15 chips."
    };

    static String[] rewards = {
        "Hounds",
        "Bees",
        "Spiders"
    };

    public static void main(String args[]) {

        String playAgain = "y";

        while (playAgain.equalsIgnoreCase("y")) {

            playGame();

            System.out.println("");
            System.out.println("=================================");
            System.out.println("Would you like to play again?");
            System.out.println("Enter y for yes or n for no:");
            playAgain = sc.nextLine();
        }

        System.out.println("");
        System.out.println("Thanks for playing!");
    }

    static void playGame() {

        resetGame();

        System.out.println("=================================");
        System.out.println("       DON'T STARVE JIMBO");
        System.out.println("=================================");
        System.out.println("");

        // Choose 3 random jokers
        int joker1 = (int)(Math.random() * jokers.length);
        int joker2 = (int)(Math.random() * jokers.length);
        int joker3 = (int)(Math.random() * jokers.length);

        while (joker2 == joker1) {
            joker2 = (int)(Math.random() * jokers.length);
        }

        while (joker3 == joker1 || joker3 == joker2) {
            joker3 = (int)(Math.random() * jokers.length);
        }

        System.out.println("Choose one of these jokers:");
        System.out.println("");

        System.out.println("1. " + jokers[joker1]);
        System.out.println("   " + jokerDescriptions[joker1]);
        System.out.println("");

        System.out.println("2. " + jokers[joker2]);
        System.out.println("   " + jokerDescriptions[joker2]);
        System.out.println("");

        System.out.println("3. " + jokers[joker3]);
        System.out.println("   " + jokerDescriptions[joker3]);
        System.out.println("");

        System.out.print("Enter your choice: ");
        int jokerChoice = sc.nextInt();
        sc.nextLine();

        if (jokerChoice == 1) {
            joker = jokers[joker1];
        }
        else if (jokerChoice == 2) {
            joker = jokers[joker2];
        }
        else {
            joker = jokers[joker3];
        }

        System.out.println("");
        System.out.println("You chose: " + joker);
        System.out.println("");

        // Generate first hand
        generateCard1();
        generateCard2();
        generateCard3();
        generateCard4();
        generateCard5();

        System.out.println("Your hand:");
        printHand();

        System.out.println("");
        System.out.println("You have 2 discards.");

        // First discard
        System.out.println("");
        System.out.println("Which cards would you like to discard?");
        System.out.println("Enter card numbers separated by spaces.");
        System.out.println("Example: 1 3 5");
        System.out.println("Enter 0 to keep your hand.");

        String discardInput = sc.nextLine();

        if (!discardInput.equals("0")) {
            discardMultipleCards(discardInput);

            System.out.println("");
            System.out.println("Your new hand:");
            printHand();
        }

        // Second discard
        System.out.println("");
        System.out.println("You have 1 discard remaining.");
        System.out.println("Which cards would you like to discard?");
        System.out.println("Enter card numbers separated by spaces.");
        System.out.println("Example: 1 3 5");
        System.out.println("Enter 0 to keep your hand.");

        discardInput = sc.nextLine();

        if (!discardInput.equals("0")) {
            discardMultipleCards(discardInput);

            System.out.println("");
            System.out.println("Your final hand:");
            printHand();
        }

        // Calculate score
        calculateScore();

        System.out.println("");
        System.out.println("=================================");
        System.out.println("FINAL SCORE");
        System.out.println("=================================");
        System.out.println("Chips: " + chips);
        System.out.println("Mult: " + mult);
        System.out.println("Final Score: " + (chips * mult));

        // Rewards
        int finalScore = chips * mult;
        int badReward = (int)(Math.random() * rewards.length);

        System.out.println("");
        System.out.println("=================================");
        System.out.println("REWARD");
        System.out.println("=================================");

        if (finalScore <= 119) {

            System.out.println(
                "FOR THAT PERFORMANCE, YOU GET "
                + rewards[badReward] + "!"
            );
        }

        else if (finalScore <= 149 && finalScore >= 120) {

            System.out.println("YOU DID OK. HAVE THIS SUPPLIES.");
            System.out.println("+1 Twig");
            System.out.println("+1 Grass Tuft");

            grassTuft++;
            twigs++;
        }

        else if (finalScore <= 199 && finalScore >= 150) {

            System.out.println("PRETTY GOOD, YOU GET SUPPLIES.");
            System.out.println("+1 Cut Stone");
            System.out.println("+1 Rope");

            cutStone++;
            rope++;
        }

        else if (finalScore <= 399 && finalScore >= 200) {

            System.out.println("GREAT! ENJOY BANANAS");
            System.out.println("+2 Bananas");
            System.out.println("ALSO HAVE THESE...");
            System.out.println("+4 Playing Cards");

            banana += 2;
            playingCard += 4;
        }

        else if (finalScore <= 599 && finalScore >= 400) {

            System.out.println("WOW! HERE'S SOME BANANAS");
            System.out.println("+2 Banana Pops");
            System.out.println("ALSO HAVE THESE...");
            System.out.println("+5 Playing Cards");

            bananaPop += 2;
            playingCard += 5;
        }

        else if (finalScore <= 999 && finalScore >= 600) {

            System.out.println("FANTASTIC! SOME GOLD FOR YOU");
            System.out.println("+2 Gold");
            System.out.println("ALSO HAVE THESE...");
            System.out.println("+7 Playing Cards");

            gold += 2;
            playingCard += 7;
            record++;
        }

        else if (finalScore <= 1399 && finalScore >= 1000) {

            System.out.println("AMAZING! ENJOY YOUR GOLD!");
            System.out.println("+8 Gold");
            System.out.println("ALSO HAVE THESE...");
            System.out.println("+7 Playing Cards");

            gold += 8;
            playingCard += 7;
            record++;
        }

        else {

            System.out.println("TRUE ROYALTY! YOU REALLY EARNED THIS TREASURE.");
            System.out.println("+1 Red Gem");
            System.out.println("+1 Blue Gem");
            System.out.println("+1 Purple Gem");
            System.out.println("ALSO HAVE THESE...");
            System.out.println("+7 Playing Cards");

            redGem++;
            blueGem++;
            purpleGem++;
            playingCard += 7;
            record++;
        }

        System.out.println("ALL REWARDS CURRENTLY");
        System.out.println("=================================");
        System.out.println("Twigs: " + twigs);
        System.out.println("Grass Tufts: " + grassTuft);
        System.out.println("Cut Stone: " + cutStone);
        System.out.println("Rope: " + rope);
        System.out.println("Gold: " + gold);
        System.out.println("Red Gems: " + redGem);
        System.out.println("Blue Gems: " + blueGem);
        System.out.println("Purple Gems: " + purpleGem);
        System.out.println("Bananas: " + banana);
        System.out.println("Banana Pops: " + bananaPop);
        System.out.println("Playing Cards: " + playingCard);
        System.out.println("Records/Balatro Remixes: " + record);
        System.out.println("=================================");
    }

    static void resetGame() {

        chips = 0;
        mult = 0;

        cardsDiscarded = 0;
        faceCardsDiscarded = 0;
        kingsInHand = 0;
        heartsDiscarded = 0;
        heartsKeptDiscarded = 0;
        queensInHand = 0;
        spadesInHand = 0;
        clubsKept = 0;
        heartsKept = 0;
        differentSuitsDiscarded = 0;

        joker = "";
    }

    static void generateCard1() {

        firstCardValue = (int)(Math.random() * 13) + 1;
        firstCardSuit = (int)(Math.random() * 4) + 1;

        if (firstCardValue == 1) {
            firstCardValue = 11;
        }
    }

    static void generateCard2() {

        secondCardValue = (int)(Math.random() * 13) + 1;
        secondCardSuit = (int)(Math.random() * 4) + 1;

        if (secondCardValue == 1) {
            secondCardValue = 11;
        }
    }

    static void generateCard3() {

        thirdCardValue = (int)(Math.random() * 13) + 1;
        thirdCardSuit = (int)(Math.random() * 4) + 1;

        if (thirdCardValue == 1) {
            thirdCardValue = 11;
        }
    }

    static void generateCard4() {

        fourthCardValue = (int)(Math.random() * 13) + 1;
        fourthCardSuit = (int)(Math.random() * 4) + 1;

        if (fourthCardValue == 1) {
            fourthCardValue = 11;
        }
    }

    static void generateCard5() {

        fifthCardValue = (int)(Math.random() * 13) + 1;
        fifthCardSuit = (int)(Math.random() * 4) + 1;

        if (fifthCardValue == 1) {
            fifthCardValue = 11;
        }
    }

    static String cardName(int value) {

        if (value == 11) {
            return "A";
        }
        else if (value == 12) {
            return "Q";
        }
        else if (value == 13) {
            return "K";
        }
        else {
            return String.valueOf(value);
        }
    }

    static String suitName(int suit) {

        if (suit == 1) {
            return "Hearts";
        }
        else if (suit == 2) {
            return "Diamonds";
        }
        else if (suit == 3) {
            return "Clubs";
        }
        else {
            return "Spades";
        }
    }

    static void printHand() {

        System.out.println(
            "1: " + cardName(firstCardValue)
            + " of " + suitName(firstCardSuit)
        );

        System.out.println(
            "2: " + cardName(secondCardValue)
            + " of " + suitName(secondCardSuit)
        );

        System.out.println(
            "3: " + cardName(thirdCardValue)
            + " of " + suitName(thirdCardSuit)
        );

        System.out.println(
            "4: " + cardName(fourthCardValue)
            + " of " + suitName(fourthCardSuit)
        );

        System.out.println(
            "5: " + cardName(fifthCardValue)
            + " of " + suitName(fifthCardSuit)
        );
    }

    // NEW: Allows multiple cards to be discarded at once
    static void discardMultipleCards(String input) {

        String[] cards = input.split(" ");

        for (String cardNumber : cards) {

            try {

                int card = Integer.parseInt(cardNumber);

                if (card >= 1 && card <= 5) {
                    discardCard(card);
                }
                else {
                    System.out.println(
                        "Invalid card number: " + cardNumber
                    );
                }

            }
            catch (NumberFormatException e) {

                System.out.println(
                    "Invalid input: " + cardNumber
                );
            }
        }
    }

    static void discardCard(int card) {

        cardsDiscarded++;

        if (card == 1) {

            applyDiscardJoker(firstCardValue, firstCardSuit);
            generateCard1();
        }

        else if (card == 2) {

            applyDiscardJoker(secondCardValue, secondCardSuit);
            generateCard2();
        }

        else if (card == 3) {

            applyDiscardJoker(thirdCardValue, thirdCardSuit);
            generateCard3();
        }

        else if (card == 4) {

            applyDiscardJoker(fourthCardValue, fourthCardSuit);
            generateCard4();
        }

        else if (card == 5) {

            applyDiscardJoker(fifthCardValue, fifthCardSuit);
            generateCard5();
        }
    }

    static void applyDiscardJoker(int value, int suit) {

        if (value == 12 || value == 13 || value == 11) {
            faceCardsDiscarded++;
        }

        if (value == 13) {
            kingsInHand++;
        }

        if (value == 12) {
            queensInHand++;
        }

        if (suit == 1) {
            heartsDiscarded++;
        }

        if (suit == 3) {
            clubsKept++;
        }

        if (suit == 4) {
            spadesInHand++;
        }

        if (joker.equals("Warly") && suit == 1) {
            chips += 20;
        }

        if (joker.equals("Wigfrid") &&
            (value == 11 || value == 12 || value == 13)) {

            mult += 10;
        }

        if (joker.equals("Wanda")) {
            chips -= 15;
        }
    }

    static void calculateScore() {

        chips = 0;
        mult = 0;

        String handRank = getHandRank();

        // Base score for hand
        if (handRank.equals("Royal Flush")) {
            chips += 100;
            mult += 8;
        }

        else if (handRank.equals("Straight Flush")) {
            chips += 100;
            mult += 8;
        }

        else if (handRank.equals("Four of a Kind")) {
            chips += 60;
            mult += 7;
        }

        else if (handRank.equals("Full House")) {
            chips += 40;
            mult += 4;
        }

        else if (handRank.equals("Flush")) {
            chips += 35;
            mult += 4;
        }

        else if (handRank.equals("Straight")) {
            chips += 30;
            mult += 4;
        }

        else if (handRank.equals("Three of a Kind")) {
            chips += 30;
            mult += 3;
        }

        else if (handRank.equals("Two Pair")) {
            chips += 20;
            mult += 2;
        }

        else if (handRank.equals("Pair")) {
            chips += 10;
            mult += 2;
        }

        else {
            chips += 5;
            mult += 1;
        }

        // Add card chips
        chips += firstCardValue;
        chips += secondCardValue;
        chips += thirdCardValue;
        chips += fourthCardValue;
        chips += fifthCardValue;

        // Joker effects
        if (joker.equals("Wilson")) {
            chips += 50;
        }

        if (joker.equals("Willow")) {
            mult += 1;
        }

        if (joker.equals("Wolfgang")) {

            if (firstCardValue == 11 ||
                firstCardValue == 12 ||
                firstCardValue == 13) {
                mult += 10;
            }

            if (secondCardValue == 11 ||
                secondCardValue == 12 ||
                secondCardValue == 13) {
                mult += 10;
            }

            if (thirdCardValue == 11 ||
                thirdCardValue == 12 ||
                thirdCardValue == 13) {
                mult += 10;
            }

            if (fourthCardValue == 11 ||
                fourthCardValue == 12 ||
                fourthCardValue == 13) {
                mult += 10;
            }

            if (fifthCardValue == 11 ||
                fifthCardValue == 12 ||
                fifthCardValue == 13) {
                mult += 10;
            }
        }

        if (joker.equals("Wendy")) {

            if (handRank.equals("High Card")) {
                mult += 15;
            }
        }

        if (joker.equals("WX-78")) {
            mult += 25;
        }

        if (joker.equals("Wickerbottom")) {

            int differentSuits = countDifferentSuits();
            chips += differentSuits * 10;
        }

        if (joker.equals("Woodie")) {

            if (handRank.equals("Pair") ||
                handRank.equals("Two Pair") ||
                handRank.equals("Three of a Kind") ||
                handRank.equals("Full House") ||
                handRank.equals("Four of a Kind")) {

                chips += 30;
            }
        }

        if (joker.equals("Maxwell")) {
            chips += 50;
            mult += 5;
        }

        if (joker.equals("Webber")) {

            if (hasTwoOfSameValue()) {
                chips += 25;
            }
        }

        if (joker.equals("Wormwood")) {

            if (hasHeart()) {
                chips += 15;
            }
        }

        if (joker.equals("Winona")) {
            chips += kingsInHand * 20;
        }

        if (joker.equals("Wortox")) {

            if (handRank.equals("Straight")) {
                chips += 30;
            }
        }

        if (joker.equals("Wurt")) {

            if (isFlush()) {
                mult += 25;
            }
        }

        if (joker.equals("Walter")) {
            chips += queensInHand * 15;
        }

        if (joker.equals("Wanda")) {
            chips += 80;
        }

        System.out.println("");
        System.out.println("Hand: " + handRank);
    }

    static String getHandRank() {

        if (isRoyalFlush()) {
            return "Royal Flush";
        }

        if (isStraightFlush()) {
            return "Straight Flush";
        }

        if (hasFourOfAKind()) {
            return "Four of a Kind";
        }

        if (hasFullHouse()) {
            return "Full House";
        }

        if (isFlush()) {
            return "Flush";
        }

        if (isStraight()) {
            return "Straight";
        }

        if (hasThreeOfAKind()) {
            return "Three of a Kind";
        }

        if (hasTwoPair()) {
            return "Two Pair";
        }

        if (hasPair()) {
            return "Pair";
        }

        return "High Card";
    }

    static boolean hasPair() {

        int[] values = {
            firstCardValue,
            secondCardValue,
            thirdCardValue,
            fourthCardValue,
            fifthCardValue
        };

        for (int i = 0; i < values.length; i++) {

            for (int j = i + 1; j < values.length; j++) {

                if (values[i] == values[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean hasTwoPair() {

        int[] values = {
            firstCardValue,
            secondCardValue,
            thirdCardValue,
            fourthCardValue,
            fifthCardValue
        };

        int pairs = 0;

        for (int i = 0; i < values.length; i++) {

            for (int j = i + 1; j < values.length; j++) {

                if (values[i] == values[j]) {
                    pairs++;
                }
            }
        }

        return pairs >= 2;
    }

    static boolean hasThreeOfAKind() {

        int[] values = {
            firstCardValue,
            secondCardValue,
            thirdCardValue,
            fourthCardValue,
            fifthCardValue
        };

        for (int i = 0; i < values.length; i++) {

            int count = 0;

            for (int j = 0; j < values.length; j++) {

                if (values[i] == values[j]) {
                    count++;
                }
            }

            if (count >= 3) {
                return true;
            }
        }

        return false;
    }

    static boolean hasFourOfAKind() {

        int[] values = {
            firstCardValue,
            secondCardValue,
            thirdCardValue,
            fourthCardValue,
            fifthCardValue
        };

        for (int i = 0; i < values.length; i++) {

            int count = 0;

            for (int j = 0; j < values.length; j++) {

                if (values[i] == values[j]) {
                    count++;
                }
            }

            if (count >= 4) {
                return true;
            }
        }

        return false;
    }

    static boolean hasFullHouse() {

        return hasThreeOfAKind() && hasPair();
    }

    static boolean isFlush() {

        return firstCardSuit == secondCardSuit
            && secondCardSuit == thirdCardSuit
            && thirdCardSuit == fourthCardSuit
            && fourthCardSuit == fifthCardSuit;
    }

    static boolean isStraight() {

        int[] values = {
            firstCardValue,
            secondCardValue,
            thirdCardValue,
            fourthCardValue,
            fifthCardValue
        };

        // Sort the cards
        for (int i = 0; i < values.length - 1; i++) {

            for (int j = i + 1; j < values.length; j++) {

                if (values[i] > values[j]) {

                    int temp = values[i];
                    values[i] = values[j];
                    values[j] = temp;
                }
            }
        }

        // Normal straight
        if (values[1] == values[0] + 1 &&
            values[2] == values[1] + 1 &&
            values[3] == values[2] + 1 &&
            values[4] == values[3] + 1) {

            return true;
        }

        // Ace-low straight: A, 2, 3, 4, 5
        if (values[0] == 2 &&
            values[1] == 3 &&
            values[2] == 4 &&
            values[3] == 5 &&
            values[4] == 11) {

            return true;
        }

        return false;
    }

    static boolean isStraightFlush() {

        return isFlush() && isStraight();
    }

    static boolean isRoyalFlush() {

        if (!isFlush()) {
            return false;
        }

        boolean hasAce = false;
        boolean hasQueen = false;
        boolean hasKing = false;
        boolean hasTen = false;

        int[] values = {
            firstCardValue,
            secondCardValue,
            thirdCardValue,
            fourthCardValue,
            fifthCardValue
        };

        for (int value : values) {

            if (value == 11) {
                hasAce = true;
            }

            if (value == 12) {
                hasQueen = true;
            }

            if (value == 13) {
                hasKing = true;
            }

            if (value == 10) {
                hasTen = true;
            }
        }

        return hasAce && hasQueen && hasKing && hasTen;
    }

    static boolean hasTwoOfSameValue() {

        return hasPair();
    }

    static boolean hasHeart() {

        return firstCardSuit == 1
            || secondCardSuit == 1
            || thirdCardSuit == 1
            || fourthCardSuit == 1
            || fifthCardSuit == 1;
    }

    static int countDifferentSuits() {

        boolean hearts = false;
        boolean diamonds = false;
        boolean clubs = false;
        boolean spades = false;

        int[] suits = {
            firstCardSuit,
            secondCardSuit,
            thirdCardSuit,
            fourthCardSuit,
            fifthCardSuit
        };

        for (int suit : suits) {

            if (suit == 1) {
                hearts = true;
            }
            else if (suit == 2) {
                diamonds = true;
            }
            else if (suit == 3) {
                clubs = true;
            }
            else if (suit == 4) {
                spades = true;
            }
        }

        int count = 0;

        if (hearts) {
            count++;
        }

        if (diamonds) {
            count++;
        }

        if (clubs) {
            count++;
        }

        if (spades) {
            count++;
        }

        return count;
    }
}