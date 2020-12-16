# Created for Applitools hackathon v3
https://applitools.com/hackathon-v20-3-instructions/

# How to run
### Prerequisites
* JDK >= 8 installed
* Local Chrome browser installed
* Set your APPLITOOLS_API_KEY environment variable
    * Mac:
        ```
        export APPLITOOLS_API_KEY='YOUR_API_KEY'
        ```
    * Windows:
        ```
        set APPLITOOLS_API_KEY='YOUR_API_KEY'
        ```

### Run from command line
For example running TestsPart1
```shell script
./gradlew clean test --tests TestsPart1
```