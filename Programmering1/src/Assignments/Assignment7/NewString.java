package Assignments.Assignment7;

public class NewString {

    private final String text;

    public NewString(String text) {
        this.text = text;
    }

    public String abbreviate() {
        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(word.charAt(0));
            }
        }
        return sb.toString();
    }

    public String removeCharacter(char c) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);

            if (current != c) {
                sb.append(current);
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return text;
    }


    public static void main(String[] args) {
        NewString newString = new NewString("Hello World! I hope you all are smiling today!");

        System.out.println("Abbriviate:");
        System.out.println("Expected: HWIhyaast");
        System.out.println("Actual: " + newString.abbreviate());

        System.out.println("RemoveCharacter:");
        System.out.println("Expected: Hllo World! I hop you all ar smiling today!");
        System.out.println("Actual: " + newString.removeCharacter('e'));
    }


}
