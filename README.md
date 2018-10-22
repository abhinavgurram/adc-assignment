# adc – Take home assignment

## What is this project about?
This project includes 3 Java based command-line programs solved as part of the ADC take home assignment. All questions are part of [Project Euler](https://projecteuler.net), and the 3 I have chosen for this assignment are:


[Bouncy Numbers](https://projecteuler.net/problem=112)
[Path Sum: Two Ways](https://projecteuler.net/problem=81) 
[Roman Numerals](https://projecteuler.net/problem=89)


## Dependencies and instructions for running the code

### Dependencies:
- Java 8
- JUnit 

### Steps to run the code:

Clone the git repository from [here](https://github.com/abhinavgurram/adc-assignment.git)
- Once cloned, you should see a folder named adc-assignment
- Cd to that directory
- Next, compile all the java source files using:
``` javac -cp .:junit-4.10.jar *.java ```
- Next, for each of the files, BouncyNumbers.java, TwoWaysPathSum.java and RomanNumerals.java, you can run them using the following commands:
``` java BouncyNumbers.java```
``` java TwoWaysPathSum.java```
``` java RomanNumerals.java```
- For each of the test files, TestBouncyNumbers.java, TestTwoWaysPathSum.java and TestRomanNumerals.java, you can run them using the following commands:
``` java -cp .:junit-4.10.jar org.junit.runner.JUnitCore TestBouncyNumbers```
``` java -cp .:junit-4.10.jar org.junit.runner.JUnitCore TestTwoWaysPathSum```
``` java -cp .:junit-4.10.jar org.junit.runner.JUnitCore TestRomanNumerals```


## Sample Output

- Bouncy Numbers
```java BouncyNumbers```
```The least number is: 1587000``` 
```Computation time: 0s 38ms ```

- TwoWaysPathSum
``` java TwoWaysPathSum``` 
```The minimum path sum is: 427337``` 
```Computation time: 0s 65ms ```

- RomanNumerals
``` java RomanNumerals``` 
```Total number of characters saved are:743```
```Computation time: 0s 91ms ```

- Test Bouncy Numbers
```java -cp .:junit-4.10.jar org.junit.runner.JUnitCore TestBouncyNumbers```
```JUnit version 4.10 ......... Time: 0.019 OK (9 tests)```

- Test TwoWaysPathSum
``` java -cp .:junit-4.10.jar org.junit.runner.JUnitCore TestTwoWaysPathSum```
```JUnit version 4.10 .... Time: 0.124 OK (4 tests)```

- Test RomanNumerals
``` java -cp .:junit-4.10.jar org.junit.runner.JUnitCore TestRomanNumerals```
```JUnit version 4.10 .......... Time: 0.097 OK (10 tests)```


## Motivation behind choosing the above three problems
After looking through all the problems on Project Euler, it was a tough decision to choose 3 of them. Many of the problems seemed interesting, but also seemed like they required more time to solve than what I had at hand. 


Therefore, I decided to choose 3 problems that were challenging and not overwhelming. I believe these problems provided a mix of the various kinds of problems on Project Euler. 

The bouncy numbers problem tested my mathematical skills in determining the right number for a given proportion. 
The two ways path sum was an excellent path finding question that drew me to the white board in determining the right approach. 
And finally, the roman numerals question was an interesting question that involved a lot of edge cases to account for.  

These choices ensured I touched on both the mathematical and computing portions of Project Euler.

## Description of the process followed
### Bouncy Numbers
- I initially started off by writing logic to figure whether a given number was bouncy or not. 
- Once I had that going, I tried to verify by playing around with a couple of numbers I was sure were bouncy/not-bouncy.
- Next, I arrived at the formula to detemine when I had to stop - when I achieved the required proportion of numbers, in this case 99%.
- Next, based on the examples provided, I tried to use a known proportion value and check I was receiving the right answer to verify my solution. 

### Two Ways Path Sum
- For this problem, I initially started off by reading values from the given file, and setting them up in a 2-D matrix.
- Once I had that setup, I tried to arrive at an approach for finding the minimum sum path - this meant white boarding what the possible scenarios were. 
- The idea is to construct an additional cost matrix where each index would include the minimum cost to reach it. 
- The minimum cost for each element is calculated as the sum of the element and the minimum of its top or left neighbor elements. 
- Continuing this approach, once we arrive at the last element of the matrix, we are certain that is the lowest possible sum path in reaching it from the start of the matrix, and hence return it.   

## Roman Numerals
- The initial step for this problem was to read values from the given file, and setting them up in a 2-D matrix.
- Next, I had a LinkedHashMap that held values of all valid/minimal roman numerals with their corresponding numeric values.
- Once I had that setup, I traverse through the given roman numeral and compute its numeric value using the above created map. 
- Once I had the numeric value for a particual roman numeral, I then got its minimal roman numeral form.
- Finally, I computed the difference between the original length of the roman numeral and its minimal form to figure the length difference for each roman. 
- I summed the length differences for all given roman numerals to arrive at the complete solution.


## References 
- [LeetCode Maze](https://leetcode.com/articles/the-maze/)
- [Shortest Paths](https://www.cs.princeton.edu/~rs/AlgsDS07/15ShortestPaths.pdf)
- [Roman Numerals](https://en.wikipedia.org/wiki/Roman_numerals)
- [Project Nayuki]

## Time spent
- I approximately spent 7 hours on this exercise. Although I was able to code the solutions up quite quickly, I spent some time on setting up JUnit and Git. 


