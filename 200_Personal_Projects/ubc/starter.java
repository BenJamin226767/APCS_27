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
        System.out.println("Which card would you like to discard?");
        System.out.println("Enter 1-5, or enter 0 to keep your hand.");

        String discardNum = sc.nextLine();

        if (!discardNum.equals("0")) {
            discardCard(Integer.parseInt(discardNum));

            System.out.println("");
            System.out.println("Your new hand:");
            printHand();
        }

        // Second discard
        System.out.println("");
        System.out.println("You have 1 discard remaining.");
        System.out.println("Which card would you like to discard?");
        System.out.println("Enter 1-5, or enter 0 to keep your hand.");

        discardNum = sc.nextLine();

        if (!discardNum.equals("0")) {
            discardCard(Integer.parseInt(discardNum));

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
                "For that performance, you get "
                + rewards[badReward] + "!"
            );
        }
        else if (finalScore <= 149) {
            System.out.println("Reward: Playing Cards!");
        }
        else if (finalScore <= 199) {
            System.out.println("Reward: Playing Cards!");
        }
        else if (finalScore <= 399) {
            System.out.println("Reward: 4 Playing Cards!");
        }
        else if (finalScore <= 599) {
            System.out.println("Reward: 5 Playing Cards!");
        }
        else if (finalScore <= 999) {
            System.out.println("Reward: 7 Playing Cards + 1 Special Item!");
        }
        else if (finalScore <= 1399) {
            System.out.println("Reward: 8 Playing Cards + 1 Special Item!");
        }
        else {
            System.out.println("Reward: 12 Playing Cards + 3 Special Items!");
        }
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