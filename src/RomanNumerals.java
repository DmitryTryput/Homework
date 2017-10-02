public class RomanNumerals {

    public static void main(String[] args) {
        String number = "3888";
        System.out.println(translate(number));
    }

    public static String translate(String number) {
        if (number.charAt(0) > '3') {
            return "Не верное число";
        }
        char[][] roman = setRomanArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) < '4') {
                if (number.charAt(i) >= '1') {
                    result.append(roman[roman.length - number.length() + i][0]);
                }
                if (number.charAt(i) >= '2') {
                    result.append(roman[roman.length - number.length() + i][0]);
                }
                if (number.charAt(i) >= '3') {
                    result.append(roman[roman.length - number.length() + i][0]);
                }
            } else if (number.charAt(i) == '4') {
                    result.append(roman[roman.length - number.length() + i][0]);
                    result.append(roman[roman.length - number.length() + i][1]);
            } else if (number.charAt(i) <= '8') {
                if (number.charAt(i) >= '5') {
                    result.append(roman[roman.length - number.length() + i][1]);
                }
                if (number.charAt(i) >= '6') {
                    result.append(roman[roman.length - number.length() + i][0]);
                }
                if (number.charAt(i) >= '7') {
                    result.append(roman[roman.length - number.length() + i][0]);
                }
                if (number.charAt(i) >= '8') {
                    result.append(roman[roman.length - number.length() + i][0]);
                }
            } else if (number.charAt(i) == '9') {
                result.append(roman[roman.length - number.length() + i][1]);
                result.append(roman[roman.length - number.length() + i][2]);
            }
        }
        return result.toString();
    }

    public static char[][] setRomanArray() {
        char[][] roman = new char[4][];
        roman[0] = new char[1];
        roman[1] = new char[3];
        roman[2] = new char[3];
        roman[3] = new char[3];
        roman[0][0] = 'M';
        roman[1][0] = 'C';
        roman[1][1] = 'D';
        roman[1][2] = 'M';
        roman[2][0] = 'X';
        roman[2][1] = 'L';
        roman[2][2] = 'C';
        roman[3][0] = 'I';
        roman[3][1] = 'V';
        roman[3][2] = 'X';
        return roman;
    }

}
