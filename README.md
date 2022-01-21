# Ledger-Demo
Clone the Repo:
```
  git clone https://github.com/swarajbarik/Ledger-Demo.git
  ```
Set Up the project:
```
  cd Ledger-Demo
  mvn clean install
  ```
  
Run:
  As per the requirement
  ```
    mvn clean test -D"cucumber.filter.tags=@e2e"
    ```
  To Run on headless mode 
  ```
    mvn clean test -D"cucumber.filter.tags=@e2e" -Dselenide.headless=true
 
