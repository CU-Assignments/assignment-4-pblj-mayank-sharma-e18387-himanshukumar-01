import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class cardCollection {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> cards = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        // Adding cards to the collection
        System.out.print("Enter the number of cards to add: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Card Symbol (Hearts/Spades/Diamonds/Clubs): ");
            String symbol = sc.nextLine();

            System.out.print("Enter Card Name/Number (2, 3, King, Queen, etc.): ");
            String card = sc.nextLine();

            // Add card to HashMap
            cards.putIfAbsent(symbol, new ArrayList<>());
            cards.get(symbol).add(card);
        }

        // Search for cards by symbol
        System.out.print("\nEnter a symbol to search for cards: ");
        String searchSymbol = sc.nextLine();

        if (cards.containsKey(searchSymbol)) {
            System.out.println("Cards with symbol '" + searchSymbol + "':");
            for (String card : cards.get(searchSymbol)) {
                System.out.println(card);
            }
        } else {
            System.out.println("No cards found with symbol '" + searchSymbol + "'.");
        }

        // Display all cards
        System.out.println("\nAll Cards in the Collection:");
        cards.forEach((symbol, cardList) -> {
            System.out.println(symbol + ": " + cardList);
        });

        sc.close();
    }
}