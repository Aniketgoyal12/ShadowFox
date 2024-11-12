import java.util.Scanner;

class BasicOperations{
    float add(float a,float b){
        float sum = a +b;
        return sum;
    }
    float multiplty(float a,float b){
        float product = a*b;
        return product;
    }
    float subtract(float a,float b){
        float diff = a - b;
        return diff;
    }
    void division(float a,float b) throws Exception{
        float div = a / b;
        try{
            if (b == 0) {
                System.out.println("ERROR! Can't divide by zero");
            }
            else {
                System.out.println(div);
            }
        } catch (Exception e) {
        }
    }
    int modulus(float a, float b){
        int mod = (int)(a % b);
        return mod;
    }
}

class AdvancedArithmetic{
    int absoluteValue(float num){
        int abs = (int) Math.abs(num);
        return abs;
    }
    int exponent(float base, float power){
        int exp = (int) Math.pow((double) base,(double) power);
        return exp;
    }
    int factorial(float a){
        int fact = 1;
        for(int i = 1;i<=a;i++){
            fact *= i;
        }
        return fact;
    }
    float percentCalculation(float a , float b) throws Exception{
        float percent = ( (a*b) / 100);
        return percent;
    }
    float squareRoot(float a){
        float squareRoot = (float) Math.sqrt((double) a);
        return squareRoot;
    }
}
class TempConverter{
    float farheneitToCelsius (float temp){
        float far = (float) ((temp - 32) / 1.8);
        return far;
    }
    float celciusToFarheneit(float temp){
        float cel = (float) ((temp * 1.8) + 32);
        return cel;
    }
    float celsiusToKelvin(float temp) {
        float kel = temp + 273;
        return kel;
    }
    float kelvinToCelsius(float temp){
        float cel = temp - 273;
        return cel;
    }
    float farheneitToKelvin(float temp){
        float cel = farheneitToCelsius(temp);
        float kel = celsiusToKelvin(cel);
        return kel;
    }
    float kelvinToFarheneit(float temp){
        float cel = kelvinToCelsius(temp);
        float far = celciusToFarheneit(cel);
        return far;
    }
}
class NumberSystem{

    // Conversion of binary numbers
    int binToDec(int bin){
        int sum = 0;
        int update = 1;
        while (bin>0){
            int rem = bin%10;
            sum = sum + rem*update;
            update *= 2;
            bin = bin /10;
        }
        return sum;
    }
    int binToOctal(int bin){
        int sum = 0;
        int update = 1;
        while (bin>0){
            int rem = bin%10;
            sum = sum + rem*update;
            update *= 8;
            bin = bin /10;
        }
        return sum;
    }
    String decToHex(int dec){
        char[] arr = new char[15];
        int i = 0;
        while (dec > 0){
            int rem = dec %16;
            if (rem >= 9){
                arr[i] = (char)(rem + 55);
            }
            else{
                arr[i] = (char)(rem + 48);
            }
            i++;
            dec /= 16;
        }
        String ans  = "";
        for(int j = i-1;j>=0;j--){
            ans += arr[j];
        }
        return ans;
    }
    String  binToHex(int bin){
        int dec = binToDec(bin);
        String hex = decToHex(dec);
        return hex;
    }


    // Conversion of Decimal Number
    int decToBin(int dec){
        int[] arr = new int[32];
        int i = 0;
        while (dec > 0){
            arr[i] = dec%2;
            dec = dec/ 2;
            i++;
        }
        int ans = 0;
        for (int j = i-1;j >=0;j--) {
            ans *=  10;
            ans += arr[j];
        }
        return ans;
    }
    int decToOctal(int dec){
        int arr[] = new int[32];
        int i = 0;
        while (dec >0){
            arr[i] = dec %8;
            i++;
            dec /= 8;
        }
        int ans = 0;
        for (int j = i-1;j >=0;j--) {
            ans *=  10;
            ans += arr[j];
        }
        return ans;
    }


    // Octal Conversion
    int octToDec(int oct){
        int sum = 0;
        int update = 1;
        while (oct>0){
            int rem = oct%10;
            sum = sum + rem*update;
            update *= 8;
            oct = oct /10;
        }
        return sum;
    }
    int octToBin(int oct){
        int dec = octToDec(oct);
        int bin = decToBin(dec);
        return bin;
    }
    String octToHex(int oct){
        int dec = octToDec(oct);
        String hex = decToHex(dec);
        return hex;
    }


    // HexaDecimal Conversion
    int hexToDec(String hex){
        int sum = 0;
        int update = 1;
        for(int i = hex.length()-1;i>=0;i--){
            char ch = hex.charAt(i);
            if((int)ch < 65){
                sum += update * (((int) ch )-48);
            }
            else {
                sum += update * (((int) ch )-55);
            }
            update *= 16;
        }
        return sum;
    }
    int hexToBin(String hex){
        int dec = hexToDec(hex);
        int bin = decToBin(dec);
        return bin;
    }
    int hexToOctal(String hex){
        int dec = hexToDec(hex);
        int oct = decToOctal(dec);
        return oct;
    }
}

public class EnhanceCalculator {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter B for Basic Operations (sum, difference, product, division, modulus)");
        System.out.println("Enter A for Advanced Arithmetics(absolute, exponent, factorial, percentage)");
        System.out.println("Enter F for Additional Functions");
        System.out.println("TO EXIT ENTER EXIT AT OPERATION INPUT");
        String mode = scan.next();
        switch (mode) {

            // BASIC ARITHMETIC OPERATION
            case "B":
                System.out.println("Enter the number");
                float num1 = scan.nextFloat();
                BasicOperations ob = new BasicOperations();
                float ans = num1;
                while (true){
                    System.out.println("Enter the operation");
                    String oper = scan.next();
                    if (oper.equals("EXIT")) {
                        break;
                    }
                    else if(!(oper.equals("+") || oper.equals("-") || oper.equals("/") || oper.equals("*") || oper.equals("%"))){
                        System.out.println("INVALID INPUT");
                        break;
                    }
                     else {
                        System.out.println("Enter the number");
                        float num2 = scan.nextFloat();
                        switch (oper) {
                            case "+":
                                ans = ob.add(ans, num2);
                                System.out.println(ans);
                                break;
                            case "-":
                                ans = ob.subtract(ans, num2);
                                System.out.println(ans);
                                break;
                            case "*":
                                ans = ob.multiplty(ans, num2);
                                System.out.println(ans);
                                break;
                            case "/":
                                ob.division(ans, num2);
                                break;
                            case "%":
                                ans = ob.modulus(ans, num2);
                                System.out.println(ans);
                                break;
                        }
                    }
                }
            break;
// ARITHMETIC OPERATION
            case "A" :
                System.out.println("Operation Details :");
                System.out.println("abs -> absolute\n" +
                        "! -> factorial\n" +
                        "e -> exponent\n" +
                        "% -> percentage\n" +
                        "root -> square root \n");
                System.out.println("Enter the operation");
                String oper = scan.next();
                AdvancedArithmetic obj = new AdvancedArithmetic();
                if (oper.equals("EXIT")) {
                    break;
                }
                else if(!(oper.equals("abs") || oper.equals("!") || oper.equals("e") || oper.equals("%") || oper.equals("root"))){
                    System.out.println("INVALID INPUT");
                    break;
                }
                else{
                    switch (oper){
                        case "abs":
                            System.out.println("Enter the number");
                            float num3 = scan.nextFloat();
                            int abs = obj.absoluteValue(num3);
                            System.out.println(abs);
                            break;
                        case "!":
                            System.out.println("Enter the number to calculate it's factorial");
                            num3 = scan.nextFloat();
                            int fact = obj.factorial(num3);
                            System.out.println(fact);
                            break;
                        case "e":
                            System.out.println("Enter the base");
                            float base = scan.nextFloat();
                            System.out.println("Enter the power");
                            float power = scan.nextFloat();
                            int exp = obj.exponent(base,power);
                            System.out.println(exp);
                            break;
                        case "%":
                            System.out.println("Enter the number");
                            float a = scan.nextFloat();
                            System.out.println("Enter the second number");
                            float b = scan.nextFloat();
                            float percent = obj.percentCalculation(a,b);
                            System.out.println(percent);
                            break;
                        case "root":
                            System.out.println("Enter the number");
                            num3 = scan.nextFloat();
                            float squareRoot = obj.squareRoot(num3);
                            System.out.println(squareRoot);
                            break;
                    }
                }
                break;

// ADDITIONAL FUNCTIONS
            case "F":
                System.out.println("Select Mode");
                System.out.println("temp -> Temperature Conversion\n" +
                        "conv -> NumberSystemConversion\n");
                mode = scan.next();
                if (mode.equals("EXIT")) {
                    break;
                }
                else if(!(mode.equals("temp") || mode.equals("conv"))){
                    System.out.println("INVALID MODE INPUT");
                }
                else{
                    switch (mode){
                        case "temp":
                            System.out.println("Scale Info");
                            System.out.println("cel -> Celcius\n" +
                                    "far -> Farheneit\n" +
                                    "kel -> Kelvin\n");
                            System.out.println("Enter the current scale");
                            String current = scan.next();
                            System.out.println("Enter the temperature in " + current);
                            float temperature = scan.nextFloat();
                            TempConverter temp = new TempConverter();
                            switch (current){
                                case "cel":
                                    float far = temp.celciusToFarheneit(temperature);
                                    float kel = temp.celsiusToKelvin(temperature);
                                    System.out.println("Temperature in Farheneit = " + far);
                                    System.out.println("Temperature in Kelvin = " + kel);
                                    break;
                                case "far":
                                    float cel = temp.farheneitToCelsius(temperature);
                                    kel = temp.farheneitToKelvin(temperature);
                                    System.out.println("Temperature in Celsius = " + cel);
                                    System.out.println("Temperature in Kelvin = " + kel);
                                    break;
                                case "kel":
                                    cel = temp.kelvinToCelsius(temperature);
                                    far = temp.kelvinToFarheneit(temperature);
                                    System.out.println("Temperature in Farheneit = " + far);
                                    System.out.println("Temperature in Celsius = " + cel);
                                    break;
                            }
                            break;

                            // Number System
                        case "conv":
                            System.out.println("Operation Info :");
                            System.out.println(" 1 -> Binary To Decimal\n" +
                                    " 2 -> Binary To Octal\n" +
                                    " 3 -> Binary To HexaDecimal\n" +
                                    " 4  -> Decimal to Binary\n" +
                                    " 5  -> Decimal to Octal\n" +
                                    " 6  -> Decimal to HexaDecimal\n" +
                                    " 7 -> Octal to Binary\n" +
                                    " 8 -> Octal to Decimal\n" +
                                    " 9 -> Octal to HexaDecimal\n" +
                                    " 10 -> HexaDecima to Binary\n" +
                                    " 11 -> HexaDecima to Decimal\n" +
                                    " 12 -> HexaDecima to Octal\n" );
                            NumberSystem converter = new NumberSystem();
                            System.out.println("Enter the operation");
                            int operation = scan.nextInt();
                            int num = 0;
                            String number = "";
                            if(!(operation >= 10)) {
                                System.out.println("Enter the number");
                                num = scan.nextInt();
                            }
                            else {
                                System.out.println("Enter the number");
                                number = scan.next();
                            }
                            switch (operation){
                                case 1 :
                                    int dec = converter.binToDec(num);
                                    System.out.println(dec);
                                    break;
                                case 2 :
                                    int oct = converter.binToOctal(num);
                                    System.out.println(oct);
                                    break;
                                case 3 :
                                    String hex = converter.binToHex(num);
                                    System.out.println(hex);
                                    break;
                                case 4 :
                                    int bin = converter.decToBin(num);
                                    System.out.println(bin);
                                    break;
                                case 5 :
                                    oct = converter.decToOctal(num);
                                    System.out.println(oct);
                                    break;
                                case 6 :
                                    hex = converter.decToHex(num);
                                    System.out.println(hex);
                                    break;
                                case 7 :
                                    bin = converter.octToBin(num);
                                    System.out.println(bin);
                                    break;
                                case 8 :
                                    dec = converter.octToDec(num);
                                    System.out.println(dec);
                                    break;
                                case 9 :
                                    hex = converter.octToHex(num);
                                    System.out.println(hex);
                                    break;
                                case 10 :
                                    bin = converter.hexToBin(number);
                                    System.out.println(bin);
                                    break;
                                case 11 :
                                    dec = converter.hexToDec(number);
                                    System.out.println(dec);
                                    break;
                                case 12:
                                    oct = converter.hexToOctal(number);
                                    System.out.println(oct);
                                    break;

                            }
                        break;
                      }
                }
        }
    }
}
