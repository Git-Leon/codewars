Create a RomanNumerals class that can convert a roman numeral to and from an integer value. It should follow the API demonstrated in the examples below. Multiple roman numeral values will be tested for each helper method.

Modern Roman numerals are written by expressing each digit separately starting with the left most digit and skipping any digit with a value of zero. In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.

### Examples

```
RomanNumerals.toRoman(1000) 
RomanNumerals.fromRoman("M") 
```

### Help

<table>
<thead>
<tr>
<th align="right">Symbol</th>
<th align="left">Value</th>
</tr>
</thead>
<tbody><tr>
<td align="right">I</td>
<td align="left">1</td>
</tr>
<tr>
<td align="right">V</td>
<td align="left">5</td>
</tr>
<tr>
<td align="right">X</td>
<td align="left">10</td>
</tr>
<tr>
<td align="right">L</td>
<td align="left">50</td>
</tr>
<tr>
<td align="right">C</td>
<td align="left">100</td>
</tr>
<tr>
<td align="right">D</td>
<td align="left">500</td>
</tr>
<tr>
<td align="right">M</td>
<td align="left">1000</td>
</tr>
</tbody></table>