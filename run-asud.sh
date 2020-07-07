if [ "$1" == "" ]; then
    echo "ERROR! Parameter is empty. Expected 'local/as-center/center2'"
    exit
fi

$JDK8/bin/java -Dwebdriver.chrome.driver=$SOFT/chromedriver/chromedriver.chrome.v83 -Denv=$1 -jar target/webdriver-asud.jar

