# Text Frequency

The following are assumptions and definitions that limit the scope of the task:
- Word: To simplify, a word is represented by a sequence of one or more characters
between „a‟ and „z‟ or between „A‟ and „Z‟). For example “agdfBh”.
- Letter Case: When counting frequencies, we are interested in the case insensitive
frequency (i.e. in the text “The sun shines over the lake”, the library should count 2
occurrences for any of the words “the” or “The” or “tHE” etc).
- Input Text: The input text contains words separated by various separator characters.
Note that the characters from „a‟ and „z‟ and „A‟ and „Z‟ can only appear within
words. 
- Available Memory: There is enough memory to store the
  

## Implementation (Java version) 
- Create a class which implements the following interface:
```java
public interface WordFrequency { 
       String getWord(); 
       int getFrequency(); 
}
```

- Create a class which implements the following interface: 
```java
- public interface WordFrequencyAnalyzer { 
   int calculateHighestFrequency(String text); 
   int calculateFrequencyForWord (String text, String word); 
   List<WordFrequency> calculateMostFrequentNWords (String text, int n); 
}
```

Implement the three methods defined in this interface 
- CalculateHighestFrequency should return the highest frequency in the text (several words might have this frequency) 
- CalculateFrequencyForWord should return the frequency of the specified word
- CalculateMostFrequentNWords should return a list of the most frequent „n‟ words in the input text, all the words returned in lower case. If several words have the same frequency, this method should return them in ascendant alphabetical order (for input text “The sun shines over the lake” and n = 3, it should return the list {(“the”, 2), (“lake”, 1), (“over”, 1) }

## Implementation (Jakarta EE version)

CalculateHighestFrequency
```bash
curl -i -X GET http://localhost:8080/hf?text=The brown fox, jump, over the moon that jump, jump and jumps on brown dusky eves.
```

CalculateFrequencyForWord
```bash
curl -i -X GET http://localhost:8080/ffw?word=the&text=The brown fox, jump, over the moon that jump, jump and jumps on brown dusky eves.
```

CalculateMostFrequentNWords
```bash
curl -i -X GET http://localhost:8080/mfnw?n=3&text=The brown fox, jump, over the moon that jump, jump and jumps on brown dusky eves.
```