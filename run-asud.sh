if [ "$1" == "" ]; then
    echo "ERROR! Parameter is empty. Expected 'local/center/center2'"
    exit
fi

$JDK8/bin/java -Dwebdriver.chrome.driver=$SOFT/chromedriver/chromedriver -Denv=$1 -jar target/webdriver.jar

