import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class Euler {
    private static Math Library;


    // 1. Multiples of 3 or 5 below 1000 (sum)

    public static int sumMultiples() {
        int sum = 0;

        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }


    // 2. Even Fibonacci numbers (sum)

    public static int sumEvenFibonacci() {
        int sum = 0;
        int x = 1;  // Represents the current Fibonacci number being processed
        int y = 2;  // Represents the next Fibonacci number in the sequence

        while (x <= 4000000) {
            if (x % 2 == 0) {
                sum += x;
            }
            int z = x + y;
            x = y;
            y = z;
        }
        return sum;
    }


    // 3. Largest prime factor

    public static long largestPrime(long number) {
        while (true) {
            long p = smallestFactor(number);

            if (p < number)
                number /= p;
            else
                return number;
        }
    }

    // Returns the smallest factor of n, which is in the range [2, n]. The result is always prime.
    public static long smallestFactor(long n) {
        long end = (long) Library.sqrt(n);
        if (n <= 1)
            throw new IllegalArgumentException();

        for (long i = 2; i <= end; i++) {
            if (n % i == 0)
                return i;
        }
        return n;  // n itself is prime
    }


    // 4. Largest palindrome product (two 3-digit numbers)

    public static long largestPalindrome() {
        long largest = 1;

        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                long product = i * j;
                if (isPalindrome(product) && product > largest)
                    largest = product;
            }
        }
        return largest;
    }

    public static int symmetricalNumber(long number) {
        long newNumber = 0;

        while (number != 0) {
            long actualDigit = number % 10;
            newNumber = newNumber * 10 + actualDigit;

            number = number / 10;
        }
        return (int) newNumber;
    }

    public static boolean isPalindrome(long number) {
        if (symmetricalNumber(number) == number)
            return true;
        else
            return false;
    }


    // 5. Smallest multiple divisible from 1 to 20

    public static long smallestMultiple() {
        int smallest = 0;

        for (int num = 2; num < 1000000000; num += 2) {
            boolean isMultiple = true;

            for (int multiple = 1; multiple <= 20; multiple++) {

                if (num % multiple != 0) {
                    isMultiple = false;
                }
            }

            if (isMultiple == true) {
                smallest = num;
                break;
            }
        }
        return (smallest);
    }


    // 6. Sum square difference

    public static long sumSquareDifference(int n) {
        int sumOfSquares = 0;
        int squareOfSum = 0;

        for (int i = 1; i <= n; i++) {
            sumOfSquares += (i * i);
            squareOfSum += i;
        }
        squareOfSum *= squareOfSum;

        int answer = squareOfSum - sumOfSquares;
        return answer;
    }


    // 7. 10.001st prime number

    public static long nthPrime(int n) {
        int numberOfPrimes = 0;
        long prime = 1;

        while (numberOfPrimes < n) {
            prime++;
            if (isPrime(prime)) {
                numberOfPrimes++;
            }
        }
        return prime;
    }

    /* returns true if parameter n is a prime number, false if composite or neither */
    public static boolean isPrime(long n) {
        if (n < 2) return false;
        else if (n == 2) return true;
        for (int i = 2; i < Math.pow(n, 0.5) + 1; i++)
            if (n % i == 0)
                return false;
        return true;
    }


    // 8. Largest product (in a series)

    public static long largestProduct() {

        String s = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
        long largestProduct = 0;

        for (int i = 0; i < s.length() - 13; i++) {
            long product = 1;

            for (int j = i; j < i + 13; j++) {
                product *= Integer.parseInt(s.substring(j, j + 1));
            }
            if (product > largestProduct)
                largestProduct = product;
        }
        return largestProduct;
    }


    // 9. Special Pythagorean triplet

    public static double productABC() {
        for (int a = 3; a <= 1000; a++) {
            for (int b = a + 1; b < 1000; b++) {

                double cSquared = Math.pow(a, 2) + Math.pow(b, 2);
                double c = Math.pow(cSquared, 0.5);

                if (a + b + c == 1000) {
                    return (a * b * c);
                }
            }
        }
        return -1;
    }


    // 10. Summation of primes

    public static long sumOfPrimes() {
        long sum = 0;
        for (int i = 2; i < 2000000; i++) {
            if (isPrime(i))
                sum += i;
        }
        return sum;
    }


    // 11. Largest product (in a grid)

    public static long largestProductGrid() {

        int matrix[][] = {
                {8, 02, 22, 97, 38, 15, 00, 40, 00, 75, 04, 05, 07, 78, 52, 12, 50, 77, 91, 8},
                {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 04, 56, 62, 00},
                {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 03, 49, 13, 36, 65},
                {52, 70, 95, 23, 04, 60, 11, 42, 69, 24, 68, 56, 01, 32, 56, 71, 37, 02, 36, 91},
                {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},
                {24, 47, 32, 60, 99, 03, 45, 02, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},
                {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},
                {67, 26, 20, 68, 02, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21},
                {24, 55, 58, 05, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72},
                {21, 36, 23, 9, 75, 00, 76, 44, 20, 45, 35, 14, 00, 61, 33, 97, 34, 31, 33, 95},
                {78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 03, 80, 04, 62, 16, 14, 9, 53, 56, 92},
                {16, 39, 05, 42, 96, 35, 31, 47, 55, 58, 88, 24, 00, 17, 54, 24, 36, 29, 85, 57},
                {86, 56, 00, 48, 35, 71, 89, 07, 05, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},
                {19, 80, 81, 68, 05, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 04, 89, 55, 40},
                {04, 52, 8, 83, 97, 35, 99, 16, 07, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},
                {88, 36, 68, 87, 57, 62, 20, 72, 03, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},
                {04, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36},
                {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 04, 36, 16},
                {20, 73, 35, 29, 78, 31, 90, 01, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 05, 54},
                {01, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 01, 89, 19, 67, 48}
        };

        int Product = 0;
        int largest = 0;

        // Check horizontally
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 17; j++) {
                Product = matrix[i][j] * matrix[i][j + 1] * matrix[i][j + 2] * matrix[i][j + 3];
                if (Product > largest) {
                    largest = Product;
                }
            }
        }

        // Check vertically
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 20; j++) {
                Product = matrix[i][j] * matrix[i + 1][j] * matrix[i + 2][j] * matrix[i + 3][j];
                if (Product > largest) {
                    largest = Product;
                }
            }
        }

        // Check diagonally right
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                Product = matrix[i][j] * matrix[i + 1][j + 1] * matrix[i + 2][j + 2] * matrix[i + 3][i + 3];
                if (Product > largest) {
                    largest = Product;
                }
            }
        }

        // Check diagonally left
        for (int i = 0; i < 17; i++) {
            for (int j = 3; j < 20; j++) {
                Product = matrix[i][j] * matrix[i + 1][j - 1] * matrix[i + 2][j - 2] * matrix[i + 3][j - 3];
                if (Product > largest) {
                    largest = Product;
                }
            }
        }
        return largest;
    }


    // 12. Highly Divisible Triangular Number

    public static long calculateTriangle(long n) { // n = 7  & return 28 --- the triangle
        int sum = 0;
        for (int i = 0; i <= n; i++)
            sum += i;
        return sum;
    }

    public static long triangle() {
        long start = System.currentTimeMillis(); // start the stopwatch

        long j = 0; // j represents the jth triangle number
        long n = 0; // n represents the triangle number corresponding to j
        int numberOfDivisors = 0; // number of divisors for triangle number n

        while (numberOfDivisors <= 500) {

            // resets numberOfDivisors because it's now checking a new triangle number
            // and also sets n to be the next triangle number
            numberOfDivisors = 0;
            j++;
            n = calculateTriangle(j);

            // for every number from 1 to the square root of this triangle number,
            // count the number of divisors
            for (int i = 1; i <= Math.sqrt(n); i++)
                if (n % i == 0)
                    numberOfDivisors++;

            // 1 to the square root of the number holds exactly half of the divisors
            // so multiply it by 2 to include the other corresponding half
            numberOfDivisors *= 2;
        }

        return n;
    }


    // 13. Large Sum

    public static String largeSum() {

        // array of BigIntegers to contain all one-hundred 50-digit numbers
        BigInteger[] bigArray = new BigInteger[100];

        // initialize each element in the array with its 50-digit number
        bigArray[0] = new BigInteger("37107287533902102798797998220837590246510135740250");
        bigArray[1] = new BigInteger("46376937677490009712648124896970078050417018260538");
        bigArray[2] = new BigInteger("74324986199524741059474233309513058123726617309629");
        bigArray[3] = new BigInteger("91942213363574161572522430563301811072406154908250");
        bigArray[4] = new BigInteger("23067588207539346171171980310421047513778063246676");
        bigArray[5] = new BigInteger("89261670696623633820136378418383684178734361726757");
        bigArray[6] = new BigInteger("28112879812849979408065481931592621691275889832738");
        bigArray[7] = new BigInteger("44274228917432520321923589422876796487670272189318");
        bigArray[8] = new BigInteger("47451445736001306439091167216856844588711603153276");
        bigArray[9] = new BigInteger("70386486105843025439939619828917593665686757934951");
        bigArray[10] = new BigInteger("62176457141856560629502157223196586755079324193331");
        bigArray[11] = new BigInteger("64906352462741904929101432445813822663347944758178");
        bigArray[12] = new BigInteger("92575867718337217661963751590579239728245598838407");
        bigArray[13] = new BigInteger("58203565325359399008402633568948830189458628227828");
        bigArray[14] = new BigInteger("80181199384826282014278194139940567587151170094390");
        bigArray[15] = new BigInteger("35398664372827112653829987240784473053190104293586");
        bigArray[16] = new BigInteger("86515506006295864861532075273371959191420517255829");
        bigArray[17] = new BigInteger("71693888707715466499115593487603532921714970056938");
        bigArray[18] = new BigInteger("54370070576826684624621495650076471787294438377604");
        bigArray[19] = new BigInteger("53282654108756828443191190634694037855217779295145");
        bigArray[20] = new BigInteger("36123272525000296071075082563815656710885258350721");
        bigArray[21] = new BigInteger("45876576172410976447339110607218265236877223636045");
        bigArray[22] = new BigInteger("17423706905851860660448207621209813287860733969412");
        bigArray[23] = new BigInteger("81142660418086830619328460811191061556940512689692");
        bigArray[24] = new BigInteger("51934325451728388641918047049293215058642563049483");
        bigArray[25] = new BigInteger("62467221648435076201727918039944693004732956340691");
        bigArray[26] = new BigInteger("15732444386908125794514089057706229429197107928209");
        bigArray[27] = new BigInteger("55037687525678773091862540744969844508330393682126");
        bigArray[28] = new BigInteger("18336384825330154686196124348767681297534375946515");
        bigArray[29] = new BigInteger("80386287592878490201521685554828717201219257766954");
        bigArray[30] = new BigInteger("78182833757993103614740356856449095527097864797581");
        bigArray[31] = new BigInteger("16726320100436897842553539920931837441497806860984");
        bigArray[32] = new BigInteger("48403098129077791799088218795327364475675590848030");
        bigArray[33] = new BigInteger("87086987551392711854517078544161852424320693150332");
        bigArray[34] = new BigInteger("59959406895756536782107074926966537676326235447210");
        bigArray[35] = new BigInteger("69793950679652694742597709739166693763042633987085");
        bigArray[36] = new BigInteger("41052684708299085211399427365734116182760315001271");
        bigArray[37] = new BigInteger("65378607361501080857009149939512557028198746004375");
        bigArray[38] = new BigInteger("35829035317434717326932123578154982629742552737307");
        bigArray[39] = new BigInteger("94953759765105305946966067683156574377167401875275");
        bigArray[40] = new BigInteger("88902802571733229619176668713819931811048770190271");
        bigArray[41] = new BigInteger("25267680276078003013678680992525463401061632866526");
        bigArray[42] = new BigInteger("36270218540497705585629946580636237993140746255962");
        bigArray[43] = new BigInteger("24074486908231174977792365466257246923322810917141");
        bigArray[44] = new BigInteger("91430288197103288597806669760892938638285025333403");
        bigArray[45] = new BigInteger("34413065578016127815921815005561868836468420090470");
        bigArray[46] = new BigInteger("23053081172816430487623791969842487255036638784583");
        bigArray[47] = new BigInteger("11487696932154902810424020138335124462181441773470");
        bigArray[48] = new BigInteger("63783299490636259666498587618221225225512486764533");
        bigArray[49] = new BigInteger("67720186971698544312419572409913959008952310058822");
        bigArray[50] = new BigInteger("95548255300263520781532296796249481641953868218774");
        bigArray[51] = new BigInteger("76085327132285723110424803456124867697064507995236");
        bigArray[52] = new BigInteger("37774242535411291684276865538926205024910326572967");
        bigArray[53] = new BigInteger("23701913275725675285653248258265463092207058596522");
        bigArray[54] = new BigInteger("29798860272258331913126375147341994889534765745501");
        bigArray[55] = new BigInteger("18495701454879288984856827726077713721403798879715");
        bigArray[56] = new BigInteger("38298203783031473527721580348144513491373226651381");
        bigArray[57] = new BigInteger("34829543829199918180278916522431027392251122869539");
        bigArray[58] = new BigInteger("40957953066405232632538044100059654939159879593635");
        bigArray[59] = new BigInteger("29746152185502371307642255121183693803580388584903");
        bigArray[60] = new BigInteger("41698116222072977186158236678424689157993532961922");
        bigArray[61] = new BigInteger("62467957194401269043877107275048102390895523597457");
        bigArray[62] = new BigInteger("23189706772547915061505504953922979530901129967519");
        bigArray[63] = new BigInteger("86188088225875314529584099251203829009407770775672");
        bigArray[64] = new BigInteger("11306739708304724483816533873502340845647058077308");
        bigArray[65] = new BigInteger("82959174767140363198008187129011875491310547126581");
        bigArray[66] = new BigInteger("97623331044818386269515456334926366572897563400500");
        bigArray[67] = new BigInteger("42846280183517070527831839425882145521227251250327");
        bigArray[68] = new BigInteger("55121603546981200581762165212827652751691296897789");
        bigArray[69] = new BigInteger("32238195734329339946437501907836945765883352399886");
        bigArray[70] = new BigInteger("75506164965184775180738168837861091527357929701337");
        bigArray[71] = new BigInteger("62177842752192623401942399639168044983993173312731");
        bigArray[72] = new BigInteger("32924185707147349566916674687634660915035914677504");
        bigArray[73] = new BigInteger("99518671430235219628894890102423325116913619626622");
        bigArray[74] = new BigInteger("73267460800591547471830798392868535206946944540724");
        bigArray[75] = new BigInteger("76841822524674417161514036427982273348055556214818");
        bigArray[76] = new BigInteger("97142617910342598647204516893989422179826088076852");
        bigArray[77] = new BigInteger("87783646182799346313767754307809363333018982642090");
        bigArray[78] = new BigInteger("10848802521674670883215120185883543223812876952786");
        bigArray[79] = new BigInteger("71329612474782464538636993009049310363619763878039");
        bigArray[80] = new BigInteger("62184073572399794223406235393808339651327408011116");
        bigArray[81] = new BigInteger("66627891981488087797941876876144230030984490851411");
        bigArray[82] = new BigInteger("60661826293682836764744779239180335110989069790714");
        bigArray[83] = new BigInteger("85786944089552990653640447425576083659976645795096");
        bigArray[84] = new BigInteger("66024396409905389607120198219976047599490197230297");
        bigArray[85] = new BigInteger("64913982680032973156037120041377903785566085089252");
        bigArray[86] = new BigInteger("16730939319872750275468906903707539413042652315011");
        bigArray[87] = new BigInteger("94809377245048795150954100921645863754710598436791");
        bigArray[88] = new BigInteger("78639167021187492431995700641917969777599028300699");
        bigArray[89] = new BigInteger("15368713711936614952811305876380278410754449733078");
        bigArray[90] = new BigInteger("40789923115535562561142322423255033685442488917353");
        bigArray[91] = new BigInteger("44889911501440648020369068063960672322193204149535");
        bigArray[92] = new BigInteger("41503128880339536053299340368006977710650566631954");
        bigArray[93] = new BigInteger("81234880673210146739058568557934581403627822703280");
        bigArray[94] = new BigInteger("82616570773948327592232845941706525094512325230608");
        bigArray[95] = new BigInteger("22918802058777319719839450180888072429661980811197");
        bigArray[96] = new BigInteger("77158542502016545090413245809786882778948721859617");
        bigArray[97] = new BigInteger("72107838435069186155435662884062257473692284509516");
        bigArray[98] = new BigInteger("20849603980134001723930671666823555245252804609722");
        bigArray[99] = new BigInteger("53503534226472524250874054075591789781264330331690");

        BigInteger sum = BigInteger.ZERO;

        // add all of the one-hundred BigIntegers to the sum BigInteger
        for (int i = 0; i < bigArray.length; i++)
            sum = sum.add(bigArray[i]);

        // print out the first 10 digits of the sum
        return (sum.toString().substring(0, 10));
    }


    // 14. Longest Collatz sequence

    public static long longestCollatzSequence() {
        long longest = 0;
        for (long i = 1; i < 1000000; i++) {
            if (countCollatzSequence(i) > longest) {
                longest = countCollatzSequence(i);
            }
        }
        return longest;
    }

    public static long countCollatzSequence(long i) {
        int count = 1;
        while (i != 1) {
            if (i % 2 == 0) {
                i = i / 2;
                count++;
            } else {
                i = 3 * i + 1;
                count++;
            }
        }
        return count;
    }


    // 15. Lattice paths

    public static long latticePaths() {
        int gridSize = 20;
        long paths = 1;

        for (int i = 0; i < gridSize; i++) {
            paths *= (2 * gridSize) - i;
            paths /= i + 1;
        }
        return paths;
    }


    // 16. Power digit sum

    public static long powerDigit(int i) {
        long result = (long) Math.pow(2, i);
        return result;
    }

    public static long sumPowerDigit() {
        long sum = 0;
        long number = powerDigit(1000);

        while (number > 0) {
            long actualDigit = number % 10;
            number = number / 10;
            sum += actualDigit;
        }
        return sum;
    }


    // 18. Maximum path sum I

    public static int maximumPath() {
        int sum = 0;

        int[][] matrix = {
                {75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {95, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {17, 47, 82, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {18, 35, 87, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {20, 4, 82, 47, 65, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {19, 1, 23, 75, 3, 34, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {88, 2, 77, 73, 7, 63, 67, 0, 0, 0, 0, 0, 0, 0, 0},
                {99, 65, 4, 28, 6, 16, 70, 92, 0, 0, 0, 0, 0, 0, 0},
                {41, 41, 26, 56, 83, 40, 80, 70, 33, 0, 0, 0, 0, 0, 0},
                {41, 48, 72, 33, 47, 32, 37, 16, 94, 29, 0, 0, 0, 0, 0},
                {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14, 0, 0, 0, 0},
                {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57, 0, 0, 0},
                {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48, 0, 0},
                {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31, 0},
                {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}
        };

        int biggest = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int actual = matrix[i][j];
                if (actual > biggest) {
                    biggest = actual;
                }
            }
            sum += biggest;
            biggest = 0;
        }
        return sum;
    }


    // 19. Counting Sundays on the 1st day of the Month (20th century)

    public static int countSundays() {
        int count = 0;
        int year = 1901;
        boolean isLeapYear = false;
        int currentDay = 2; // Starts on a Monday

        while (year <= 2000) {
            isLeapYear = false;
            if ((year % 4) == 0) {
                if ((year % 100) == 0 && (year % 400) == 0) {
                    isLeapYear = true;
                } else if ((year % 100) == 0 && (year % 400) != 0) {
                    isLeapYear = false;
                } else {
                    isLeapYear = true;
                }
            }
            for (int month = 1; month <= 12; month++) {
                if (currentDay == 7) {
                    count++;
                }
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    //January, March, May, July, August, October, December
                    currentDay += 3;

                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    //April, June, September, November
                    currentDay += 2;

                } else if (month == 2 && isLeapYear) {
                    //February has 29 days in a Leap Year
                    currentDay += 1;
                }

                if (currentDay > 7) {
                    currentDay = currentDay - 7;
                }
            }
            year++;
        }
        return count;
    }


    // 20. Factorial digit sum

    public static long factorial(int n) {
        long factorial = n;

        while (n > 1) {
            factorial *= (n - 1);
            n = n - 1;
        }
        return factorial;
    }

    public static long factorialDigitSum() {
        long number = factorial(10);
        long sum = 0;

        while (number > 0) {
            long currentDigit = number % 10;
            sum += currentDigit;
            number = number / 10;
        }
        return sum;
    }


    // 21. Amicable numbers

    public static long sumAmicableNumbers() {
        long sum = 0;

        for (long i = 1; i < 10000; i++) {
            if (10000 % i == 0)
                sum += i;
        }
        return sum;
    }


    // 23. Non-abundant sums

    private static final int LIMIT = 28123;

    private static boolean[] isAbundant = new boolean[LIMIT + 1];

    public static long solution() {
        // Compute look-up table
        for (int i = 1; i < isAbundant.length; i++)
            isAbundant[i] = isAbundant(i);

        long sum = 0;
        for (int i = 1; i <= LIMIT; i++) {
            if (!isSumOf2Abundants(i))
                sum += i;
        }
        return sum;
    }


    private static boolean isSumOf2Abundants(int n) {
        for (int i = 0; i <= n; i++) {
            if (isAbundant[i] && isAbundant[n - i])
                return true;
        }
        return false;
    }


    private static boolean isAbundant(int n) {
        if (n < 1)
            throw new IllegalArgumentException();

        int sum = 1;  // Sum of factors less than n
        int end = (int) Library.sqrt(n);
        for (int i = 2; i <= end; i++) {
            if (n % i == 0)
                sum += i + n / i;
        }
        if (end * end == n)
            sum -= end;
        return sum > n;
    }


    // 24. Lexicographic permutations

    public static long getFactorial(int num) {
        long retVal = 1;

        for (int i = 2; i <= num; i++)
            retVal *= i;

        return retVal;
    }

    public static int[] getDigitFactorials() {
        int[] retVal = new int[10];
        for (int i = 0; i < retVal.length; i++)
            retVal[i] = (int) getFactorial(i);

        return retVal;
    }

    public static String getAnswer() throws Exception {

        /*
        First first digit has 9! permutations, second 8!, third 7! ...
        Since we are looking for the 1M th, simply find out which digit
        fits would exceed the threshold of what is left
         */

        int[] factorials = getDigitFactorials();

        long left = 1000000;
        String answer = "";

        while (answer.length() < 10) {
            for (int i = 0; i < 10; i++) {
                if (!answer.contains(Integer.toString(i))) {
                    if (left - factorials[9 - answer.length()] > 0) {
                        left = left - factorials[9 - answer.length()];
                    } else {
                        answer += Integer.toString(i);
                        break;
                    }
                }
            }
        }
        return answer;
    }


    // 25. 1000-digit Fibonacci number (revursive method)

    public static long fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }


    // 26. Reciprocal cycles

    public static int reciprocalCycle() {
        int result = 0;
        int longest = 0;

        for (int d = 2; d < 1000; d++) {
            int countRecurring = recurringNumber(d);
            if (countRecurring > longest) {
                longest = countRecurring;
                result = d;
            }
        }
        return result;
    }

    public static int recurringNumber(int number) {
        int[] arr = new int[number + 1];
        int index = 1;
        int modulus = 1;

        while (modulus != 0 && arr[modulus] == 0) {
            arr[modulus] = index++;
            modulus = modulus * 10 % number;
        }
        if (modulus == 0) {
            return 0;
        }
        return index - arr[modulus];
    }


    // 27. Quadratic primes

    public static long productCoefficients() {

        int limit = 1000;

        int ansA = 0;
        int ansB = 0;
        int max = 0;

        for (int a = 1 - limit; a < limit; a++) {
            for (int b = 1 - limit; b < limit; b++) {
                int n = 0;
                while (isPrime(Math.abs(n * n + a * n + b))) {
                    n++;
                }
                if (n > max) {
                    max = n;
                    ansA = a;
                    ansB = b;
                }
            }
        }
        return (ansA * ansB);
    }


    // 28. Number spiral diagonals

    public static long sumDiagonal() {

        long sum = 1;
        int size = 1001;

        for (int i = 3; i <= size; i += 2) {
            sum += 4 * i * i - 6 * (i - 1);
        }
        return sum;
    }


    // 29. Distinct powers

    public static int distinctPowers() {
        Set<BigInteger> powers = new HashSet<>();

        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                powers.add(BigInteger.valueOf(a).pow(b));
            }
        }
        return powers.size();
    }


    // 30. Digit fifth powers

    public static long sumFifthPowersNumber(int number) {
        long sum = 0;

        while (number > 0) {
            long currentDigit = number % 10;
            sum += Math.pow(currentDigit, 5);
            number = number / 10;
        }
        return sum;
    }

    public static boolean numberEqualsSumFifthPowers(int number) {
        if (sumFifthPowersNumber(number) == number) {
            return true;
        }
        return false;
    }

    public static long sumFifthPowers() {
        long sum = 0;

        for (int i = 2; i < 1000000; i++) {
            if (numberEqualsSumFifthPowers(i))
                sum += i;
        }
        return sum;
    }


    // 31. Coin sums

    public static int differentWays() {
        int sum = 200;
        int[] coinSizes = {1, 2, 5, 10, 20, 50, 100, 200};
        int[] combinations = new int[sum + 1];

        // Base case. Only 1 way to make 0, or everything has at least one solution with pennies.
        combinations[0] = 1;

        for (int i = 0; i < coinSizes.length; i++) {
            for (int j = coinSizes[i]; j <= sum; j++) {
                combinations[j] += combinations[j - coinSizes[i]];
            }
        }
        return combinations[200];
    }


    // 32. Pandigital products

    public static String pandigitalProduct() {
        int sum = 0;
        for (int i = 1; i < 10000; i++) {
            if (hasPandigitalProduct(i))
                sum += i;
        }
        return Integer.toString(sum);
    }


    private static boolean hasPandigitalProduct(int n) {
        // Find and examine all factors of n
        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && isPandigital("" + n + i + n / i))
                return true;
        }
        return false;
    }


    private static boolean isPandigital(String s) {
        if (s.length() != 9)
            return false;
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        return new String(temp).equals("123456789");
    }


    // 33. Digit cancelling fractions

    // find Global Common Denominator
    public static int findGCD(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return findGCD(number2, number1 % number2);
    }

    public static String fraction() {
        int numer = 1;
        int denom = 1;

        for (int d = 10; d < 100; d++) {
            for (int n = 10; n < d; n++) {
                int n0 = n % 10, n1 = n / 10;
                int d0 = d % 10, d1 = d / 10;
                if (n1 == d0 && n0 * d == n * d1 || n0 == d1 && n1 * d == n * d0) {
                    numer *= n;
                    denom *= d;
                }
            }
        }
        return Integer.toString(denom / findGCD(numer, denom));
    }


    // 34. Digit factorials

    // Hard-coded values for factorial(0), factorial(1), ..., factorial(9)
    private static int[] FACTORIALinterval = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    private static int factorialDigitSum(int number) {
        int sum = 0;

        while (number > 0) {
            sum += FACTORIALinterval[number % 10];
            number /= 10;
        }
        return sum;
    }

    public static long sumFactorials() {
        long sum = 0;

        for (int i = 3; i < 10000000; i++) {
            if (factorialDigitSum(i) == i) {
                sum += i;
            }
        }
        return sum;
    }


    // 35. Circular primes

    //Returns next prime number after integer n.
    public static int getNextPrime(int n) {
        boolean prime = false;
        while (!prime) {
            n += 2;
            prime = isPrime(n);
        }
        return n;
    }

    // Arithmetically rotates digits of integer n from back to front.
    public static int rotate(int n, int length) {
        int rightDigit = n % 10;        //gets right digit
        int temp = (n - rightDigit) / 10;    //gets all but right digit
        return (rightDigit * (int) (Math.pow(10, length - 1))) + temp;    //rotates digits
    }

    // Determines if integer n is a circular prime.
    public static boolean isCircular(int n) {
        boolean circular = true;
        int length = (int) Math.log10((long) n) + 1; //determines amount of digits in n

        //rotates digits of n to see if each is prime
        int i = 0;
        while (i < length - 1 && circular) {
            n = rotate(n, length);
            circular = isPrime(n);
            i++;
        }
        return circular;
    }


    public static int countCircularPrimes() {
        int n = 11;
        int count = 4;
        while (n < 1000000) {
            if (isCircular(n)) {
                count++;
            }
            n = getNextPrime(n);
        }
        return count;
    }



}























