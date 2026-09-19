# Test Cases

## Equivalence Partitioning Test Cases

| Test Case | TCI   | Nights | Age | Resident | Veteran | Expected Result |
| --------- | ----- | -----: | --: | -------- | ------- | --------------- |
| TC01      | EP-02 |      1 |  30 | FALSE    | FALSE   | $50             |
| TC02      | EP-01 |      0 |  30 | FALSE    | FALSE   | Invalid         |
| TC03      | EP-02 |     14 |  30 | FALSE    | FALSE   | $700            |
| TC04      | EP-03 |     15 |  30 | FALSE    | FALSE   | Invalid         |
| TC05      | EP-05 |      7 |  12 | FALSE    | FALSE   | $175            |
| TC06      | EP-06 |      7 |  13 | FALSE    | FALSE   | $350            |
| TC07      | EP-07 |      7 |  65 | FALSE    | FALSE   | $280            |
| TC08      | EP-04 |      7 |  -1 | FALSE    | FALSE   | Invalid         |
| TC09      | EP-09 |      7 |  30 | TRUE     | FALSE   | $340            |
| TC10      | EP-11 |      7 |  30 | FALSE    | TRUE    | $315            |
| TC11      | EP-12 |      7 |  30 | TRUE     | TRUE    | $306            |
| TC12      | EP-06 |      7 |  30 | FALSE    | FALSE   | $350            |
| TC13      | EP-05 |      7 |   0 | FALSE    | FALSE   | $175            |

## Boundary Value Analysis Test Cases

| TCI    | Boundary Values   | Covered By |
| ------ | ----------------- | ---------- |
| BVA-01 | 0, 1, 2 nights    | TC02, TC01 |
| BVA-02 | 13, 14, 15 nights | TC03, TC04 |
| BVA-03 | -1, 0, 1 age      | TC08, TC13 |
| BVA-04 | 11, 12, 13 age    | TC05, TC06 |
| BVA-05 | 63, 64, 65 age    | TC07       |

## Decision Table Test Cases

| Test Case | TCI   | Resident | Veteran | Nights | Age | Expected Result |
| --------- | ----- | -------- | ------- | -----: | --: | --------------- |
| TC12      | DT-01 | FALSE    | FALSE   |      7 |  30 | $350            |
| TC09      | DT-02 | TRUE     | FALSE   |      7 |  30 | $340            |
| TC10      | DT-03 | FALSE    | TRUE    |      7 |  30 | $315            |
| TC11      | DT-04 | TRUE     | TRUE    |      7 |  30 | $306            |

## Final Test Case List

| Test Case | Purpose                     | Nights | Age | Resident | Veteran | Expected Result |
| --------- | --------------------------- | -----: | --: | -------- | ------- | --------------- |
| TC01      | Minimum valid stay          |      1 |  30 | FALSE    | FALSE   | $50             |
| TC02      | Below minimum stay          |      0 |  30 | FALSE    | FALSE   | Invalid         |
| TC03      | Maximum valid stay          |     14 |  30 | FALSE    | FALSE   | $700            |
| TC04      | Above maximum stay          |     15 |  30 | FALSE    | FALSE   | Invalid         |
| TC05      | Child age boundary          |      7 |  12 | FALSE    | FALSE   | $175            |
| TC06      | Adult age boundary          |      7 |  13 | FALSE    | FALSE   | $350            |
| TC07      | Senior age boundary         |      7 |  65 | FALSE    | FALSE   | $280            |
| TC08      | Negative age                |      7 |  -1 | FALSE    | FALSE   | Invalid         |
| TC09      | Arkansas resident discount  |      7 |  30 | TRUE     | FALSE   | $340            |
| TC10      | Veteran discount            |      7 |  30 | FALSE    | TRUE    | $315            |
| TC11      | Arkansas resident + veteran |      7 |  30 | TRUE     | TRUE    | $306            |
| TC12      | Normal adult stay           |      7 |  30 | FALSE    | FALSE   | $350            |
| TC13      | Age zero is a valid child   |      7 |   0 | FALSE    | FALSE   | $175            |
