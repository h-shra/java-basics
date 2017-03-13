package topcoder;/*
A simple, easy to remember system for encoding integer amounts can be very useful. For example, dealers at flea markets put the information about an item on a card that they let potential buyers see. They find it advantageous to encode the amount they originally paid for the item on the card.
A good system is to use a substitution code, in which each digit is encoded by a letter. An easy to remember 10-letter word or phrase, the key, is chosen. Every '1' in the value is replaced by the first letter of the key, every '2' is replaced by the second letter of the key, and so on. Every '0' is replaced by the last letter of the key. Letters that do not appear in the key can be inserted anywhere without affecting the value represented by the code.. This helps to make the resulting code much harder to break (without knowing the key).

Create a class Substitute that contains the method getValue that is given the s key and code as input and that returns the decoded value.
*/


public class Substitute {
    public int getValue(String key, String code) {
        if (key == null || code == null) {
            return 0;
        }
        if (key.isEmpty() || code.isEmpty()) {
            return 0;
        }
        if (key.length() > 10) {
            return 0;
        }
        char codeArray[] = code.toCharArray();
        int codeLength = codeArray.length;
        String value = "";
        for (char aCodeArray : codeArray) {
            Integer digit = key.indexOf(aCodeArray);
            if (digit > -1) {
                if (digit == key.length() - 1) {
                    digit = 0;
                } else {
                    digit = digit + 1;
                }
                value = value + digit;
            }
        }
        if (value.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(value);
        }
    }

/*    public void testGetValue() throws Exception {
        Substitute substitute = new Substitute();
        int value = substitute.getValue("GOTINDEALS", "TEST");
        Assert.assertEquals(3703, value);
        value = substitute.getValue("GOTINDEALS", "XTEYSTZ");
        Assert.assertEquals(3703, value);
        value = substitute.getValue("GOTINDEALS", "XYZ");
        Assert.assertEquals(0, value);
    }
*/
}
