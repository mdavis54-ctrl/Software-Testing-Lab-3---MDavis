# Test Condition and Input (TCI)

## Equivalence Partitioning

| TCI   | Input              | Equivalence Partition | Expected Behavior                     |
| ----- | ------------------ | --------------------- | ------------------------------------- |
| EP-01 | nights             | Less than 1           | Invalid stay                          |
| EP-02 | nights             | 1–14                  | Valid stay                            |
| EP-03 | nights             | Greater than 14       | Invalid stay                          |
| EP-04 | guestAge           | Less than 0           | Invalid age                           |
| EP-05 | guestAge           | 0–12                  | 50% age discount                      |
| EP-06 | guestAge           | 13–64                 | Full price                            |
| EP-07 | guestAge           | 65+                   | 20% age discount                      |
| EP-08 | isArkansasResident | FALSE                 | No residency discount                 |
| EP-09 | isArkansasResident | TRUE                  | $10 off total                         |
| EP-10 | hasVeteranDiscount | FALSE                 | No veteran discount                   |
| EP-11 | hasVeteranDiscount | TRUE                  | 10% veteran discount                  |
| EP-12 | Resident + Veteran | TRUE + TRUE           | $10 off first, then 10% off remainder |

## Boundary Value Analysis

| TCI    | Input    | Boundary Values |
| ------ | -------- | --------------- |
| BVA-01 | nights   | 0, 1, 2         |
| BVA-02 | nights   | 13, 14, 15      |
| BVA-03 | guestAge | -1, 0, 1        |
| BVA-04 | guestAge | 11, 12, 13      |
| BVA-05 | guestAge | 63, 64, 65      |

## Decision Table

| TCI   | Resident? | Veteran? | Rule                                                |
| ----- | --------- | -------- | --------------------------------------------------- |
| DT-01 | No        | No       | No additional discount                              |
| DT-02 | Yes       | No       | Subtract $10 from total                             |
| DT-03 | No        | Yes      | Apply 10% veteran discount                          |
| DT-04 | Yes       | Yes      | Subtract $10 first, then apply 10% veteran discount |
